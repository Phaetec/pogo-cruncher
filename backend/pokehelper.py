import json
import os

class Pokehelper(object):

    def __init__(self):

        basepath = os.path.dirname(__file__)
        filepath = os.path.abspath(os.path.join(basepath, 'data/pokemon.json' ))
        with open(filepath) as pokejson:
            self.pokelist = json.load(pokejson)

###
### LIST STARTS AT 0, EVERY PokeNumber needs a -1
###

    def get_pokefamily(self, pokemon_number):
        return self.pokelist[pokemon_number-1]['family']


    def get_evolution_name(self, pokemon_number):
        # NOT a safe method to use, just for testing purposes
        return self.pokelist[pokemon_number]['name']

    def get_pokename(self, poke_number):
        return self.pokelist[poke_number-1]['name']