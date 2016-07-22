from flask import Flask, make_response, jsonify, request
from pgoapi import pgoapi
from geopy.geocoders import GoogleV3


app = Flask(__name__)

pokeapi = pgoapi.PGoApi()

@app.route('/')
def index():
    return "Hello, World!"

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

    pokeapi.set_position(*position)
    if not pokeapi.login(service, login_name, password):
        return jsonify({'status': 'error',
                        'message': 'Failed to login. If the Pokemon GO Servers are online, your credentials may be wrong.'})
    else:
        return jsonify({'status': 'ok'})

# ----------------- Helper Functions

def get_pos_by_name(location_name):
    geolocator = GoogleV3()
    loc = geolocator.geocode(location_name, timeout=10)

    return (loc.latitude, loc.longitude, loc.altitude)

if __name__ == '__main__':
    app.run(debug=True)