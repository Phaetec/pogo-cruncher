# This class represents a pokemon object for easier handling than the dicts the api provides.
from __future__ import division
from . import pokehelper

ph = pokehelper.Pokehelper()


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
        self.upgraded_number = pokemondict.get('num_upgrades', 0)
        self.cp_multiplier = pokemondict.get('cp_multiplier', 0)
        self.additional_cp_multiplier = pokemondict.get('additional_cp_multiplier', 0)

    def is_favorite(self):
        if self.favorite == 1:
            return True
        return False

    def level(self):
        """
        Takes the combined multiplier and returns the pokemons level.

        :return: The pokemon level as a float.
        """
        # Credits to @Grover13 at github.com
        combined_multiplier = self.additional_cp_multiplier + self.cp_multiplier
        if combined_multiplier < 0.734:
            level = 58.35178527 * combined_multiplier * combined_multiplier - 2.838007664 * combined_multiplier + 0.8539209906
        else:
            level = 171.0112688 * combined_multiplier - 95.20425243

        return round(level * 2) / 2

    def iv_percentage(self):
        score = self.iv_sta + self.iv_att + self.iv_def
        return '%.2f' % ((score / 45) * 100)

    def powerup_stardust_cost(self):
        if self.level() < 3 and self.upgraded_number <= 4:
            return 200

        if self.level() < 4 and self.upgraded_number <= 8:
            return 400

        if self.level() < 7 and self.upgraded_number <= 12:
            return 600

        if self.level() < 8 and self.upgraded_number <= 16:
            return 800

        if self.level() < 11 and self.upgraded_number <= 20:
            return 1000

        if self.level() < 13 and self.upgraded_number <= 24:
            return 1300

        if self.level() < 15 and self.upgraded_number <= 28:
            return 1600

        if self.level() < 17 and self.upgraded_number <= 32:
            return 1900

        if self.level() < 19 and self.upgraded_number <= 36:
            return 2200

        if self.level() < 21 and self.upgraded_number <= 40:
            return 2500

        if self.level() < 23 and self.upgraded_number <= 44:
            return 3000

        if self.level() < 25 and self.upgraded_number <= 48:
            return 3500

        if self.level() < 27 and self.upgraded_number <= 52:
            return 4000

        if self.level() < 29 and self.upgraded_number <= 56:
            return 4500

        if self.level() < 31 and self.upgraded_number <= 60:
            return 5000

        if self.level() < 33 and self.upgraded_number <= 64:
            return 6000

        if self.level() < 35 and self.upgraded_number <= 68:
            return 7000

        if self.level() < 37 and self.upgraded_number <= 72:
            return 8000

        if self.level() < 39 and self.upgraded_number <= 76:
            return 9000

        return 10000

    def powerup_candy_cost(self):
        if self.level() < 13 and self.upgraded_number <= 20:
            return 1
        if self.level() < 21 and self.upgraded_number <= 36:
            return 2
        if self.level() < 31 and self.upgraded_number <= 60:
            return 3
        return 4

    @property
    def attack(self):
        return (ph.get_base_attack(self.pokemon_number) * self.iv_att) * (self.cp_multiplier + self.additional_cp_multiplier)

    @property
    def defense(self):
        return (ph.get_base_defense(self.pokemon_number) * self.iv_def) * (self.cp_multiplier + self.additional_cp_multiplier)

    def __str__(self):
        return str(self.pokemon_number) + ': ' + str(self.cp) + 'CP / ' + str(
            self.stamina_max) + 'HP\n' + self.iv_percentage() + '% perfect IVs (' + str(self.iv_att) + '/' + str(
            self.iv_def) + '/' + str(self.iv_sta)
