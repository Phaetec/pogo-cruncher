import json

class Pokehelper(object):

    def __init__(self):

        with open('data/pokemon.json') as pokejson:
            self.pokelist = json.load(pokejson)

# TODO add function which helps translate shit.

    def get_pokefamily(self, pokemon_number):
        pass
