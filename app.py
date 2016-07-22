from flask import Flask, make_response, jsonify, request
from pgoapi import pgoapi
from geopy.geocoders import GoogleV3
from backend.pokemon import Pokemon
from datetime import timedelta
from flask import make_response, request, current_app
from functools import update_wrapper
import time
import random

# ----------------- Decorators
def crossdomain(origin=None, methods=None, headers=None,
                max_age=21600, attach_to_all=True,
                automatic_options=True):
    if methods is not None:
        methods = ', '.join(sorted(x.upper() for x in methods))
    if headers is not None and not isinstance(headers, str):
        headers = ', '.join(x.upper() for x in headers)
    if not isinstance(origin, str):
        origin = ', '.join(origin)
    if isinstance(max_age, timedelta):
        max_age = max_age.total_seconds()

    def get_methods():
        if methods is not None:
            return methods

        options_resp = current_app.make_default_options_response()
        return options_resp.headers['allow']

    def decorator(f):
        def wrapped_function(*args, **kwargs):
            if automatic_options and request.method == 'OPTIONS':
                resp = current_app.make_default_options_response()
            else:
                resp = make_response(f(*args, **kwargs))
            if not attach_to_all and request.method != 'OPTIONS':
                return resp

            h = resp.headers

            h['Access-Control-Allow-Origin'] = origin
            h['Access-Control-Allow-Methods'] = get_methods()
            h['Access-Control-Max-Age'] = str(max_age)
            if headers is not None:
                h['Access-Control-Allow-Headers'] = headers
            return resp

        f.provide_automatic_options = False
        return update_wrapper(wrapped_function, f)
    return decorator

# ----------------------


app = Flask(__name__)

pokeapi = pgoapi.PGoApi()

@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'error': 'Not found'}), 404)


@app.route('/api/login', methods=['POST'])
@crossdomain(origin='*', headers='Origin, X-Requested-With, Content-Type, Accept', methods='POST')
def login():
    login_name = request.json['email']
    service = request.json['service']
    password = request.json['password']
    location = request.json['location']
    position = get_pos_by_name(location)

    pokeapi.set_position(*position)
    if not pokeapi.login(service, login_name, password):
        return jsonify({'status': 'error',
                        'message': 'Failed to login. If the Pokemon GO Servers are online, your credentials may be wrong.'})
    else:
        return jsonify({'status': 'ok'})

@app.route('/api/pokemon', methods=['GET'])
@crossdomain(origin='*', headers='Origin, X-Requested-With, Content-Type, Accept', methods='GET')
def get_pokemon():
    pokeapi.get_inventory()

    # Make the Niantic API call
    response_dict = pokeapi.call()
    if 'GET_INVENTORY' in response_dict['responses']:
        items = response_dict['responses']['GET_INVENTORY']['inventory_delta']['inventory_items']

        # Build answer Pokemon list
        answer = list()
        for item in items:
            if 'pokemon_data' in item['inventory_item_data']:
                # Eggs are treated as pokemon by Niantic.
                 if 'is_egg' not in item['inventory_item_data']['pokemon_data']:
                    pokemon = Pokemon(item['inventory_item_data']['pokemon_data'])
                    answer.append({
                        'id':                   pokemon.id,
                        'pokemon_id':           pokemon.pokemon_number,
                        'individual_attack':    pokemon.iv_att,
                        'individual_stamina':   pokemon.iv_sta,
                        'individual_defense':   pokemon.iv_def,
                        'individual_percentage':pokemon.iv_percentage(),
                        'health':               pokemon.stamina_max,
                        'cp':                   pokemon.cp
                    })
        return jsonify(answer)

@app.route('/api/pokemon/delete', methods=['POST'])
@crossdomain(origin='*', headers='Origin, X-Requested-With, Content-Type, Accept', methods='POST')
def delete_pokemon():
    deletion_candidates = request.json['ids']

    if 'safe' not in request.json:
        for id in deletion_candidates:
            pokeapi.release_pokemon(pokemon_id=id)
        pokeapi.call()
    else:
        for id in deletion_candidates:
            pokeapi.release_pokemon(pokemon_id=id).call()
            # Sleep some random time between two and three seconds
            time.sleep(random.randint(200, 350)/100)

    return jsonify({'status': 'finished'})



# ----------------- Helper Functions

def get_pos_by_name(location_name):
    geolocator = GoogleV3()
    loc = geolocator.geocode(location_name, timeout=10)

    return (loc.latitude, loc.longitude, loc.altitude)

if __name__ == '__main__':
    app.run(debug=True)