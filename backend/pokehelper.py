import json
import os

class Pokehelper(object):

    def __init__(self):

        basepath = os.path.dirname(__file__)
        filepath = os.path.abspath(os.path.join(basepath, 'data/pokemon.json' ))
        with open(filepath) as pokejson:
            self.pokelist = json.load(pokejson)


    def get_pokefamily(self, pokemon_number):
        return self.pokelist[pokemon_number]['family']


    def get_evolution_name(self, pokemon_number):
        # NOT a safe method to use, just for testing purposes
        return self.pokelist[pokemon_number+1]['name']