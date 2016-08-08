### This class represents a pokemon object for easier handling than the dicts the api provides.
from __future__ import division

class Pokemon(object):

    def __init__(self, pokemondict):

        self.battles_attacked = pokemondict.get('battles_attacked', 0)
        self.battles_defended = pokemondict.get('battles_defended', 0)
        self.cp = pokemondict.get('cp', 0)
        self.favorite = pokemondict.get('favorite', 0)
        self.captured_cell_id = pokemondict.get('captured_cell_id', 0)
        self.creation_time_ms = pokemondict.get('creation_time_ms', 0)

        if 'favorite' in pokemondict:
            self.favorite = True
        else:
            self.favorite = False

        if 'from_fort' in pokemondict:
            self.lured = True
        else:
            self.lured = False

        self.height_m = pokemondict.get('height_m', 0)
        self.id = pokemondict.get('id', 0)
        self.iv_att = pokemondict.get('individual_attack', 0)
        self.iv_def = pokemondict.get('individual_defense', 0)
        self.iv_sta = pokemondict.get('individual_stamina', 0)
        self.move_1 = pokemondict.get('move_1', 0)
        self.move_2 = pokemondict.get('move_2', 0)
        self.pokeball_type = pokemondict.get('pokeball', 0)
        self.pokemon_number = pokemondict.get('pokemon_id', 0)
        self.stamina_current = pokemondict.get('stamina', 0)
        self.stamina_max = pokemondict.get('stamina_max', 1)
        self.weight_kg = pokemondict.get('weight_kg', 1)
        self.nickname = pokemondict.get('nickname', '')

    def is_favorite(self):
        if self.favorite == 1:
            return True
        return False

    def iv_percentage(self):
        score = self.iv_sta + self.iv_att + self.iv_def
        return '%.2f'%((score/45)*100)

    def __str__(self):
        return str(self.pokemon_number) + ': ' + str(self.cp) + 'CP / ' + str(self.stamina_max) + 'HP\n' + self.iv_percentage() + '% perfect IVs (' + str(self.iv_att) + '/' + str(self.iv_def) + '/' + str(self.iv_sta)