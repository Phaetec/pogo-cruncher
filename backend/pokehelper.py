import json

class Pokehelper(object):

    def __init__(self):

        with open('data/pokemon.json') as pokejson:
            self.pokelist = json.load(pokejson)


    def get_pokefamily(self, pokemon_number):
        return self.pokelist[pokemon_number]['family']
