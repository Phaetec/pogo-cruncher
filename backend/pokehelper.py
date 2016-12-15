import json
import os

emptymon = {'moves1': [], 'family': 1, 'name': 'not-in-database', 'moves2': [], 'type2': 'nil', 'id': -1, 'candy': -1, 'type1': 'nil', 'stats': {'stamina': -1, 'attack': -1, 'defense': -1}}


class Pokehelper(object):

    def __init__(self):

        basepath = os.path.dirname(__file__)
        filepath = os.path.abspath(os.path.join(basepath, 'data/pokemon.json'))
        with open(filepath) as pokejson:
            self.pokelist = json.load(pokejson)

    ###
    # LIST STARTS AT 0, EVERY PokeNumber needs a -1
    ###

    def get_pokefamily(self, poke_number):
        if (poke_number > 151):
            return emptymon['family']
        return self.pokelist[poke_number-1]['family']

    def get_evolution_name(self, poke_number):
        # NOT a safe method to use, just for testing purposes
        if (poke_number > 151):
            return emptymon['name']
        return self.pokelist[poke_number]['name']

    def get_pokename(self, poke_number):
        if (poke_number > 151):
            return emptymon['name']
        return self.pokelist[poke_number-1]['name']

    def get_base_attack(self, poke_number):
        if (poke_number > 151):
            return emptymon['stats']['attack']
        return self.pokelist[poke_number-1]['stats']['attack']

    def get_base_defense(self, poke_number):
        if (poke_number > 151):
            return emptymon['stats']['defense']
        return self.pokelist[poke_number-1]['stats']['defense']
