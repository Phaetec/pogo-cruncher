from flask import Flask, make_response, jsonify, request
from pgoapi import pgoapi
from geopy.geocoders import GoogleV3
from backend.pokemon import Pokemon
from flask import make_response, request, current_app
from flask_cors import CORS
import time
import random
import binascii
import os



app = Flask(__name__)
CORS(app)

missing_token_error = {'status': 'error',
                       'message': 'You are not authenticated, please log in'}

session_map = dict()

pokeapi = pgoapi.PGoApi()

@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'error': 'Not found'}), 404)


@app.route('/api/login', methods=['POST'])
def login():
    login_name = request.json['email']
    service = request.json['service']
    password = request.json['password']
    location = request.json['location']
    position = get_pos_by_name(location)

    pokeapi = pgoapi.PGoApi()
    pokeapi.set_position(*position)
    if not pokeapi.login(service, login_name, password):
        return jsonify({'status': 'error',
                        'message': 'Failed to login. If the Pokemon GO Servers are online, your credentials may be wrong.'})
    else:
        token = binascii.hexlify(os.urandom(128))
        session_map[token] = pokeapi
        return jsonify({'status':   'ok',
                        'token':    token})

@app.route('/api/pokemon', methods=['GET'])
def get_pokemon():
    if 'token' not in request.json or request.json['token'] not in session_map:
        return jsonify({'status':   'error',
                        'message':  'Your session is invalid, please log in to your Pokemon GO account to continue'})

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
def delete_pokemon():
    if 'token' not in request.json or request.json['token'] not in session_map:
        return jsonify({'status':   'error',
                        'message':  'Your session is invalid, please log in to your Pokemon GO account to continue'})

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