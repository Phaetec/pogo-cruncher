from flask import Flask, make_response, jsonify, request
from pgoapi import pgoapi
from pgoapi.exceptions import AuthException
from geopy.geocoders import GoogleV3
from backend.pokemon import Pokemon
from flask import make_response, request
from flask_cors import CORS
from geopy.exc import GeocoderServiceError
import time
import random



app = Flask(__name__)
CORS(app)

pokeapi = pgoapi.PGoApi()
deleted_pokemon = 0
pokemon_deletion_amount = 0


@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'error': 'Not found'}), 404)


@app.route('/api/login', methods=['POST'])
def login():
    login_name = request.json['email']
    service = request.json['service']
    password = request.json['password']
    location = request.json['location']
    try:
        position = get_pos_by_name(location)
    except GeocoderServiceError:
        return jsonify({'status':   'error',
                        'message':  'Location could not be found, please try another one!'})


    pokeapi.set_position(*position)
    try:
        logged_in = pokeapi.login(service, login_name, password, app_simulation=True)
    except AuthException as e:
        return jsonify({'status': 'error',
                        'message': e.__str__()})

    if not logged_in:
        return jsonify({'status': 'error',
                        'message': 'Failed to login. If the Pokemon GO Servers are online, your credentials may be wrong.'})
    else:
        return jsonify({'status': 'ok'})

@app.route('/api/pokemon', methods=['GET'])
def get_pokemon():
    req = pokeapi.create_request()
    req.get_inventory()

    # Make the Niantic API call
    response_dict = req.call()
    if not response_dict:
        return jsonify({'status': 'error',
                        'message': 'Failed to retrieve Pokemon. The servers are probably down right now.'})

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
                        'id':                   str(pokemon.id),
                        'pokemon_id':           pokemon.pokemon_number,
                        'individual_attack':    pokemon.iv_att,
                        'individual_stamina':   pokemon.iv_sta,
                        'individual_defense':   pokemon.iv_def,
                        'individual_percentage':float(pokemon.iv_percentage()),
                        'health':               pokemon.stamina_max,
                        'cp':                   pokemon.cp,
                        'nickname':             pokemon.nickname,
                        'favorite':             pokemon.is_favorite(),
                    })
        return jsonify(answer)

@app.route('/api/pokemon/delete', methods=['POST'])
def delete_pokemon():
    deletion_candidates = request.json['ids']
    global pokemon_deletion_amount
    global deleted_pokemon
    if 'safe' not in request.json:
        for id in deletion_candidates:
            req = pokeapi.create_request()
            req.release_pokemon(pokemon_id=int(id))
        req.call()
    else:
        pokemon_deletion_amount = len(deletion_candidates)
        deleted_pokemon = 0
        for id in deletion_candidates:
            req = pokeapi.create_request()
            req.release_pokemon(pokemon_id=int(id))
            req.call()
            # Sleep some random time between two and three seconds
            time.sleep(random.randint(200, 350)/100)
            deleted_pokemon += 1
            print('Deleted Pokemon %d out of %d'%(deleted_pokemon, pokemon_deletion_amount))

    pokemon_deletion_amount = 0
    deleted_pokemon = 0

    return jsonify({'status': 'ok'})



@app.route('/api/status/delete', methods=['GET'])
def deletion_status():
    return jsonify({'status':       'ok',
                    'to_delete':    pokemon_deletion_amount,
                    'deleted':      deleted_pokemon})


@app.route('/api/pokemon/favorite', methods=['POST'])
def favorite_pokemon():
    pokemon_id = int(request.json['id'])
    set_favorite = request.json['set_favorite']

    req = pokeapi.create_request()
    req.set_favorite_pokemon(id=pokemon_id, set_favorite=set_favorite)
    req.call()

    return jsonify({'status':       'ok',
                    'id':           str(pokemon_id),
                    'set_davorite': set_favorite})

# ----------------- Helper Functions

def get_pos_by_name(location_name):
    geolocator = GoogleV3()
    loc = geolocator.geocode(location_name, timeout=10)

    return (loc.latitude, loc.longitude, loc.altitude)

if __name__ == '__main__':
    app.run(threaded=True)
