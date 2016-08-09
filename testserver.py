"""
This server is a test version of the production app.py. It will send dummy replies for every API Call.
The replies and test functions are described inside the docstrings.
"""

from flask import Flask, jsonify
from geopy.geocoders import GoogleV3
from backend.pokemon import Pokemon
from backend.pokehelper import Pokehelper
from flask import make_response, request
from flask_cors import CORS
from geopy.exc import GeocoderServiceError
import json
import time
import random


app = Flask(__name__)
CORS(app)

with open('example_dump.txt') as pokemon_data:
    data = json.load(pokemon_data)

pokehelper = Pokehelper()
status = {'logged_in':      False}
deleted_pokemon = 0
pokemon_deletion_amount = 0
player_level = None


@app.route('/', methods=['GET'])
def index():
    return jsonify({'status': 'ok',
                    'message': 'Welcome to the pogo-cruncher API! Seems like everything is working fine.'})


@app.errorhandler(404)
def not_found(error):
    return make_response(jsonify({'error': 'Not found'}), 404)


@app.route('/api/login', methods=['POST'])
def login():
    """
    It does not matter what data you send as long as there is a `password`, `email`, `service` and `location`.
    If you want to test the location resolve send an additonal `'resolve': 1` value.
    If you want to simulate a failing login, send an additonal `'fail': <some message>`. The API will answer
    with an error and return the message inside the `message` field.

    :return: Always returns an `ok` status if `resolve` is not sent. Otherwise return `ok` when the location could be
        found and an `error` including a message if not.
    """
    login_name = request.json['email']
    service = request.json['service']
    password = request.json['password']
    location = request.json['location']
    global data
    with open('example_dump.txt') as pokemon_data:
        data = json.load(pokemon_data)

    if request.json.get('fail', False):
        return jsonify({'status':   'error',
                        'message':  request.json['fail']})

    if request.json.get('resolve', False):
        try:
            position = get_pos_by_name(location)
        except GeocoderServiceError:
            return jsonify({'status':   'error',
                            'message':  'Location could not be found, please try another one!'})

    global status
    status['logged_in'] = True
    return jsonify({'status': 'ok'})


@app.route('/api/pokemon', methods=['GET'])
def get_pokemon():
    """
    The API endpoint allways returns the same test data. If you want to reset the pokemon list, logout and back in.

    :return: Returns a list of Pokemon inside a dict.
    """

    items = data['responses']['GET_INVENTORY']['inventory_delta']['inventory_items']

    # Build answer Pokemon list
    answer = list()
    candies = dict()
    for item in items:
        if 'pokemon_data' in item['inventory_item_data']:
            # Eggs are treated as pokemon by Niantic.
            if 'is_egg' not in item['inventory_item_data']['pokemon_data']:
                pokemon = Pokemon(item['inventory_item_data']['pokemon_data'])
                answer.append({
                    'id':                    str(pokemon.id),
                    'pokemon_id':            pokemon.pokemon_number,
                    'individual_attack':     pokemon.iv_att,
                    'individual_stamina':    pokemon.iv_sta,
                    'individual_defense':    pokemon.iv_def,
                    'individual_percentage': float(pokemon.iv_percentage()),
                    'health':                pokemon.stamina_max,
                    'cp':                    pokemon.cp,
                    'nickname':              pokemon.nickname,
                    'favorite':              pokemon.is_favorite(),
                    'move_1':                pokemon.move_1,
                    'move_2':                pokemon.move_2,
                    'level':                 pokemon.level(),
                    'powerup_cost_stardust': pokemon.powerup_stardust_cost(),
                    'powerup_cost_candy':    pokemon.powerup_candy_cost(),
                })
        elif 'candy' in item['inventory_item_data']:
            candy_data = item['inventory_item_data']['candy']
            candies[candy_data['family_id']] = candy_data.get("candy", 0)

        elif 'player_stats' in item['inventory_item_data']:
            global player_level
            player_level = item['inventory_item_data']['player_stats']['level']

    for poke in answer:
        family = pokehelper.get_pokefamily(poke['pokemon_id'])
        poke['candy'] = candies.get(family, 0)

    print(answer)
    return jsonify(answer)


@app.route('/api/pokemon/delete', methods=['POST'])
def delete_pokemon():
    """
    Deletes the sent pokemon inside the local storage. If you want to reset the db, send a new login call.
    Simulates the sleeping calls from the main app as well.

    :return: Returns `'status': 'ok'`, as soon as the db is done.
    """
    deletion_candidates = request.json['ids']
    global pokemon_deletion_amount
    global deleted_pokemon
    global data

    print('In Deletion process')
    invlist = list(data['responses']['GET_INVENTORY']['inventory_delta']['inventory_items'])

    if 'safe' not in request.json:
        while(len(deletion_candidates) != 0):
            invlist = list(data['responses']['GET_INVENTORY']['inventory_delta']['inventory_items'])
            for count, item in enumerate(invlist):
                if 'pokemon_data' in item['inventory_item_data']:
                    # Eggs are treated as pokemon by Niantic.
                    if 'is_egg' not in item['inventory_item_data']['pokemon_data']:
                        if str(item['inventory_item_data']['pokemon_data']['id']) in deletion_candidates:
                            data['responses']['GET_INVENTORY']['inventory_delta']['inventory_items'].pop(count)
                            deletion_candidates.remove(str(item['inventory_item_data']['pokemon_data']['id']))
                            break
        print("Done deleting")
    else:
        pokemon_deletion_amount = len(deletion_candidates)
        deleted_pokemon = 0
        while(len(deletion_candidates) != 0):
            invlist = list(data['responses']['GET_INVENTORY']['inventory_delta']['inventory_items'])
            for count, item in enumerate(invlist):
                if 'pokemon_data' in item['inventory_item_data']:
                    # Eggs are treated as pokemon by Niantic.
                    if 'is_egg' not in item['inventory_item_data']['pokemon_data']:
                        if str(item['inventory_item_data']['pokemon_data']['id']) in deletion_candidates:
                            data['responses']['GET_INVENTORY']['inventory_delta']['inventory_items'].pop(count)
                            deletion_candidates.remove(str(item['inventory_item_data']['pokemon_data']['id']))
                            deleted_pokemon += 1
                            print('Deleted Pokemon %d out of %d' % (deleted_pokemon, pokemon_deletion_amount))
                            time.sleep(random.randint(200, 350)/100)
                            break
        print("Done deleting")

    pokemon_deletion_amount = 0
    deleted_pokemon = 0

    return jsonify({'status': 'ok'})


@app.route('/api/status/delete', methods=['GET'])
def deletion_status():
    """
    Request how much pokemon have been deelted in the current sitting.

    :return: Returns the amount of pokemon to be deleted in total and the count of pokemon currently deleted.
    """
    return jsonify({'status':       'ok',
                    'to_delete':    pokemon_deletion_amount,
                    'deleted':      deleted_pokemon})


@app.route('/api/pokemon/favorite', methods=['POST'])
def favorite_pokemon():
    """
    Set or unset a favorite pokemon. Expects the values `id` and `set_favorite` (boolean).

    :return: Returns status ok if there were no errors.
    """

    pokemon_id = int(request.json['id'])
    set_favorite = request.json['set_favorite']
    global data
    invlist = list(data['responses']['GET_INVENTORY']['inventory_delta']['inventory_items'])
    for count, item in enumerate(invlist):
        if 'pokemon_data' in item['inventory_item_data']:
            # Eggs are treated as pokemon by Niantic.
            if 'is_egg' not in item['inventory_item_data']['pokemon_data']:
                if item['inventory_item_data']['pokemon_data']['id'] == pokemon_id:
                    data['responses']['GET_INVENTORY']['inventory_delta']['inventory_items'][count]['inventory_item_data']['pokemon_data']['favorite'] = set_favorite
                    print("Pokemon favorite status has been set to " +
                          str(data['responses']['GET_INVENTORY']['inventory_delta']['inventory_items'][count]['inventory_item_data']['pokemon_data']['favorite']))
                    break

    return jsonify({'status':       'ok',
                    'id':           str(pokemon_id),
                    'set_favorite': set_favorite})


@app.route('/api/status', methods=['GET'])
def api_status():
    return jsonify({'status': 'ok'})


@app.route('/api/status/niantic', methods=['GET'])
def niantic_status():

    if status['logged_in']:
        return jsonify({'status': 'ok'})

    return jsonify({'status': 'error',
                    'message': 'The connection to the Pokemon Go Servers could not be established. Please Logout and back in.'})


@app.route('/api/player', methods=['GET'])
def get_player():
    """
    Request Information about the player.

    :return: Return a json dictionary including `name`, `stardust`, `pokecoins`.
    """

    player_data = data['responses']['GET_PLAYER']['player_data']

    pokecoins = 0
    stardust = 0
    for currency in player_data['currencies']:
        if currency['name'] == 'STARDUST':
            stardust = currency.get('amount', 0)
        elif currency['name'] == 'POKECOIN':
            pokecoins = currency.get('amount', 0)

    answer = {
        'name':         player_data.get('username'),
        'stardust':     stardust,
        'pokecoins':    pokecoins,
    }

    if player_level:
        answer['level'] = player_level

    return jsonify(answer)

@app.route('/api/pokemon/evolve', methods=['POST'])
def evolve_pokemon():
    """
    Evolves Pokemon. The post request has to have an `id` field which contains the id of the pokemon to be evolved.

    :return: Return a status: ok if everything is finished.
    """
    evolution_candidate = int(request.json['id'])
    global data
    answer = {'status': 'ok'}
    
    invlist = list(data['responses']['GET_INVENTORY']['inventory_delta']['inventory_items'])
    for count, item in enumerate(invlist):
        if 'pokemon_data' in item['inventory_item_data']:
            # Eggs are treated as pokemon by Niantic.
            if 'is_egg' not in item['inventory_item_data']['pokemon_data']:
                if item['inventory_item_data']['pokemon_data']['id'] == evolution_candidate:
                    pokemon = data['responses']['GET_INVENTORY']['inventory_delta']['inventory_items'][count]['inventory_item_data']['pokemon_data']
                    pokemon['cp'] *= 2
                    pokemon['name'] = pokehelper.get_evolution_name(pokemon['pokemon_id'])
                    pokemon['pokemon_id'] += 1

                    print("Pokemon has been evolved to " +
                          str(pokemon['name']))
                    break

    return jsonify(answer)

# ----------------- Helper Functions


def get_pos_by_name(location_name):
    geolocator = GoogleV3()
    loc = geolocator.geocode(location_name, timeout=10)

    return loc.latitude, loc.longitude, loc.altitude

if __name__ == '__main__':
    app.run(threaded=True)
