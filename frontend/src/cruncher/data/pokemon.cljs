(ns cruncher.data.pokemon)

;; Taken from https://github.com/justinleewells/pogo-optimizer

(def all {1 {:pokemon-id                  1
             :name                        "Bulbasaur"
             :classification              "Seed Pokémon"
             :type-1                      ["Grass"]
             :type-2                      ["Poison"]
             :weaknesses                  ["Fire" "Ice" "Flying" "Psychic"]
             :fast-attacks                ["Tackle" "Vine Whip"]
             :weight                      "6.9 kg"
             :height                      "0.7 m"
             :next-evolution-requirements {:amount 25
                                           :name   "Bulbasaur candies"}
             :next-evolutions             [2 3]}

          2 {:pokemon-id                  2
             :name                        "Ivysaur"
             :classification              "Seed Pokémon"
             :type-1                      ["Grass"]
             :type-2                      ["Poison"]
             :weaknesses                  ["Fire" "Ice" "Flying" "Psychic"]
             :fast-attacks                ["Razor Leaf" "Vine Whip"]
             :weight                      "13.0 kg"
             :height                      "1.0 m"
             :previous-evolutions         [1]
             :next-evolution-requirements {:amount 100
                                           :name   "Bulbasaur candies"}
             :next-evolutions             [3]}

          3 {:pokemon-id          3
             :name                "Venusaur"
             :classification      "Seed Pokémon"
             :type-1              ["Grass"]
             :type-2              ["Poison"]
             :weaknesses          ["Fire" "Ice" "Flying" "Psychic"]
             :fast-attacks        ["Razor Leaf" "Vine Whip"]
             :weight              "100.0 kg"
             :height              "2.0 m"
             :previous-evolutions [1 2]}

          4 {:pokemon-id                  4
             :name                        "Charmander"
             :classification              "Lizard Pokémon"
             :type-1                      ["Fire"]
             :weaknesses                  ["Water" "Ground" "Rock"]
             :fast-attacks                ["Ember" "Scratch"]
             :weight                      "8.5 kg"
             :height                      "0.6 m"
             :next-evolution-requirements {:amount 25
                                           :name   "Charmander candies"}
             :next-evolutions             [5 6]}

          5 {:pokemon-id                  5
             :name                        "Charmeleon"
             :classification              "Flame Pokémon"
             :type-1                      ["Fire"]
             :weaknesses                  ["Water" "Ground" "Rock"]
             :fast-attacks                ["Ember" ""]
             :weight                      "19.0 kg"
             :height                      "1.1 m"
             :previous-evolutions         [4]
             :next-evolution-requirements {:amount 100
                                           :name   "Charmander candies"}
             :next-evolutions             [6]}

          6 {:pokemon-id          6
             :name                "Charizard"
             :classification      "Flame Pokémon"
             :type-1              ["Fire"]
             :type-2              ["Flying"]
             :weaknesses          ["Water" "Electric" "Rock"]
             :fast-attacks        ["Ember" "Wing Attack"]
             :weight              "90.5 kg"
             :height              "1.7 m"
             :previous-evolutions [4 5]}

          7 {:pokemon-id                  7
             :name                        "Squirtle"
             :classification              "Tiny Turtle Pokémon"
             :type-1                      ["Water"]
             :weaknesses                  ["Electric" "Grass"]
             :fast-attacks                ["Tackle" "Bubble"]
             :weight                      "9.0 kg"
             :height                      "0.5 m"
             :next-evolution-requirements {:amount 25
                                           :name   "Squirtle candies"}
             :next-evolutions             [8 9]}

          8 {:pokemon-id                  8
             :name                        "Wartortle"
             :classification              "Turtle Pokémon"
             :type-1                      ["Water"]
             :weaknesses                  ["Electric" "Grass"]
             :fast-attacks                ["Bite" "Water Gun"]
             :weight                      "22.5 kg"
             :height                      "1.0 m"
             :previous-evolutions         [7]
             :next-evolution-requirements {:amount 100
                                           :name   "Squirtle candies"}
             :next-evolutions             [9]}

          9 {:pokemon-id          9
             :name                "Blastoise"
             :classification      "Shellfish Pokémon"
             :type-1              ["Water"]
             :weaknesses          ["Electric" "Grass"]
             :fast-attacks        ["Bite" "Water Gun"]
             :weight              "85.5 kg"
             :height              "1.6 m"
             :previous-evolutions [7 8]}

          10 {:pokemon-id                  10
              :name                        "Caterpie"
              :classification              "Worm Pokémon"
              :type-1                      ["Bug"]
              :weaknesses                  ["Fire" "Flying" "Rock"]
              :fast-attacks                ["Bug Bite" "Tackle"]
              :weight                      "2.9 kg"
              :height                      "0.3 m"
              :next-evolution-requirements {:amount 12
                                            :name   "Caterpie candies"}
              :next-evolutions             [11 12]}

          11 {:pokemon-id                  11
              :name                        "Metapod"
              :classification              "Cocoon Pokémon"
              :type-1                      ["Bug"]
              :weaknesses                  ["Fire" "Flying" "Rock"]
              :fast-attacks                ["Bug Bite" "Tackle"]
              :weight                      "9.9 kg"
              :height                      "0.7 m"
              :previous-evolutions         [10]
              :next-evolution-requirements {:amount 50
                                            :name   "Caterpie candies"}
              :next-evolutions             [12]}

          12 {:pokemon-id          12
              :name                "Butterfree"
              :classification      "Butterfly Pokémon"
              :type-1              ["Bug"]
              :type-2              ["Flying"]
              :weaknesses          ["Fire" "Electric" "Ice" "Flying" "Rock"]
              :fast-attacks        ["Bug Bite" "Confusion"]
              :weight              "32.0 kg"
              :height              "1.1 m"
              :previous-evolutions [10 11]}

          13 {:pokemon-id                  13
              :name                        "Weedle"
              :classification              "Hairy Pokémon"
              :type-1                      ["Bug"]
              :type-2                      ["Poison"]
              :weaknesses                  ["Fire" "Flying" "Psychic" "Rock"]
              :fast-attacks                ["Bug Bite" "Poison Sting"]
              :weight                      "3.2 kg"
              :height                      "0.3 m"
              :next-evolution-requirements {:amount 12
                                            :name   "Weedle candies"}
              :next-evolutions             [14 15]}

          14 {:pokemon-id                  14
              :name                        "Kakuna"
              :classification              "Cocoon Pokémon"
              :type-1                      ["Bug"]
              :type-2                      ["Poison"]
              :weaknesses                  ["Fire" "Flying" "Psychic" "Rock"]
              :fast-attacks                ["Bug Bite" "Posion Sting"]
              :weight                      "10.0 kg"
              :height                      "0.6 m"
              :previous-evolutions         [13]
              :next-evolution-requirements {:amount 50
                                            :name   "Weedle candies"}
              :next-evolutions             [15]}

          15 {:pokemon-id          15
              :name                "Beedrill"
              :classification      "Poison Bee Pokémon"
              :type-1              ["Bug"]
              :type-2              ["Poison"]
              :weaknesses          ["Fire" "Flying" "Psychic" "Rock"]
              :fast-attacks        ["Bug Bite" "Poison Jab"]
              :weight              "29.5 kg"
              :height              "1.0 m"
              :previous-evolutions [13 14]}

          16 {:pokemon-id                  16
              :name                        "Pidgey"
              :classification              "Tiny Bird Pokémon"
              :type-1                      ["Normal"]
              :type-2                      ["Flying"]
              :weaknesses                  ["Electric" "Rock"]
              :fast-attacks                ["Quick Attack" "Tackle"]
              :special-attack              ["Aerial Ace" "Air Cutter" "Twister"]
              :weight                      "1.8 kg"
              :height                      "0.3 m"
              :next-evolution-requirements {:amount 12
                                            :name   "Pidgey candies"}
              :next-evolutions             [17 18]}

          17 {:pokemon-id                  17
              :name                        "Pidgeotto"
              :classification              "Bird Pokémon"
              :type-1                      ["Normal"]
              :type-2                      ["Flying"]
              :weaknesses                  ["Electric" "Rock"]
              :fast-attacks                ["Steel Wing" "Wing Attack"]
              :special-attack              ["Aerial Ace" "Air Cutter" "Twister"]
              :weight                      "30.0 kg"
              :height                      "1.1 m"
              :previous-evolutions         [16]
              :next-evolution-requirements {:amount 50
                                            :name   "Pidgey candies"}
              :next-evolutions             [18]}

          18 {:pokemon-id          18
              :name                "Pidgeot"
              :classification      "Bird Pokémon"
              :type-1              ["Normal"]
              :type-2              ["Flying"]
              :weaknesses          ["Electric" "Rock"]
              :fast-attacks        ["Steel Wing" "Wing Attack"]
              :special-attack      ["Hurricane"]
              :weight              "39.5 kg"
              :height              "1.5 m"
              :previous-evolutions [16 17]}

          19 {:pokemon-id                  19
              :name                        "Rattata"
              :classification              "Mouse Pokémon"
              :type-1                      ["Normal"]
              :weaknesses                  ["Fighting"]
              :fast-attacks                ["Quick Attack" "Tackle"]
              :special-attack              ["Body Slam" "Dig" "Hyper Fang"]
              :weight                      "3.5 kg"
              :height                      "0.3 m"
              :next-evolution-requirements {:amount 25
                                            :name   "Rattata candies"}
              :next-evolutions             [20]}

          20 {:pokemon-id          20
              :name                "Raticate"
              :classification      "Mouse Pokémon"
              :type-1              ["Normal"]
              :weaknesses          ["Fighting"]
              :fast-attacks        ["Bite" "Quick Attack"]
              :special-attack      ["Dig" "Hyper Beam" "Hyper Fang"]
              :weight              "18.5 kg"
              :height              "0.7 m"
              :previous-evolutions [19]}

          21 {:pokemon-id                  21
              :name                        "Spearow"
              :classification              "Tiny Bird Pokémon"
              :type-1                      ["Normal"]
              :type-2                      ["Flying"]
              :weaknesses                  ["Electric" "Rock"]
              :fast-attacks                ["Peck" "Quick Attack"]
              :weight                      "2.0 kg"
              :height                      "0.3 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Spearow candies"}
              :next-evolutions             [22]}

          22 {:pokemon-id          22
              :name                "Fearow"
              :classification      "Beak Pokémon"
              :type-1              ["Normal"]
              :type-2              ["Flying"]
              :weaknesses          ["Electric" "Rock"]
              :fast-attacks        ["Peck" "Steel Wing"]
              :weight              "38.0 kg"
              :height              "1.2 m"
              :previous-evolutions [21]}

          23 {:pokemon-id                  23
              :name                        "Ekans"
              :classification              "Snake Pokémon"
              :type-1                      ["Poison"]
              :weaknesses                  ["Ground" "Psychic"]
              :fast-attacks                ["Acid" "Poison Sting"]
              :weight                      "6.9 kg"
              :height                      "2.0 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Ekans candies"}
              :next-evolutions             [24]}

          24 {:pokemon-id          24
              :name                "Arbok"
              :classification      "Cobra Pokémon"
              :type-1              ["Poison"]
              :weaknesses          ["Ground" "Psychic"]
              :fast-attacks        ["Acid" "Bite"]
              :weight              "65.0 kg"
              :height              "3.5 m"
              :previous-evolutions [23]}

          25 {:pokemon-id                  25
              :name                        "Pikachu"
              :classification              "Mouse Pokémon"
              :type-1                      ["Electric"]
              :weaknesses                  ["Ground"]
              :fast-attacks                ["Quick Attack" "Thunder Shock"]
              :weight                      "6.0 kg"
              :height                      "0.4 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Pikachu candies"}
              :next-evolutions             [26]}

          26 {:pokemon-id          26
              :name                "Raichu"
              :classification      "Mouse Pokémon"
              :type-1              ["Electric"]
              :weaknesses          ["Ground"]
              :fast-attacks        ["Thunder Shock" "Spark"]
              :weight              "30.0 kg"
              :height              "0.8 m"
              :previous-evolutions [25]}

          27 {:pokemon-id                  27
              :name                        "Sandshrew"
              :classification              "Mouse Pokémon"
              :type-1                      ["Ground"]
              :weaknesses                  ["Water" "Grass" "Ice"]
              :fast-attacks                ["Mud Shot" "Scratch"]
              :weight                      "12.0 kg"
              :height                      "0.6 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Sandshrew candies"}
              :next-evolutions             [28]}

          28 {:pokemon-id          28
              :name                "Sandslash"
              :classification      "Mouse Pokémon"
              :type-1              ["Ground"]
              :weaknesses          ["Water" "Grass" "Ice"]
              :fast-attacks        ["Metal Claw" "Mud Shot"]
              :weight              "29.5 kg"
              :height              "1.0 m"
              :previous-evolutions [27]}

          29 {:pokemon-id      29
              :name            "Nidoran F"
              :classification  "Poison Pin Pokémon"
              :type-1          ["Poison"]
              :weaknesses      ["Ground" "Psychic"]
              :fast-attacks    ["Bite" "Poison Sting"]
              :weight          "7.0 kg"
              :height          "0.4 m"
              :next-evolutions [30 31]
              :next-evolution-requirements {:amount 25
                                            :name   "Nidoran F candies"}}

          30 {:pokemon-id                  30
              :name                        "Nidorina"
              :classification              "Poison Pin Pokémon"
              :type-1                      ["Poison"]
              :weaknesses                  ["Ground" "Psychic"]
              :fast-attacks                ["Bite" "Poison Sting"]
              :weight                      "20.0 kg"
              :height                      "0.8 m"
              :previous-evolutions         [29]
              :next-evolution-requirements {:amount 100
                                            :name   "Nidoran F candies"}
              :next-evolutions             [31]}

          31 {:pokemon-id          31
              :name                "Nidoqueen"
              :classification      "Drill Pokémon"
              :type-1              ["Poison"]
              :type-2              ["Ground"]
              :weaknesses          ["Water" "Ice" "Ground" "Psychic"]
              :fast-attacks        ["Bite" "Poison Jab"]
              :weight              "60.0 kg"
              :height              "1.3 m"
              :previous-evolutions [29 30]}

          32 {:pokemon-id      32
              :name            "Nidoran M"
              :classification  "Poison Pin Pokémon"
              :type-1          ["Poison"]
              :weaknesses      ["Ground" "Psychic"]
              :fast-attacks    ["Peck" "Poison Sting"]
              :weight          "9.0 kg"
              :height          "0.5 m"
              :next-evolutions [33 34]}

          33 {:pokemon-id                  33
              :name                        "Nidorino"
              :classification              "Poison Pin Pokémon"
              :type-1                      ["Poison"]
              :weaknesses                  ["Ground" "Psychic"]
              :fast-attacks                ["Bite" "Poison Jab"]
              :weight                      "19.5 kg"
              :height                      "0.9 m"
              :previous-evolutions         [32]
              :next-evolution-requirements {:amount 100
                                            :name   "NidoranM candies"}
              :next-evolutions             [34]}

          34 {:pokemon-id          34
              :name                "Nidoking"
              :classification      "Drill Pokémon"
              :type-1              ["Poison"]
              :type-2              ["Ground"]
              :weaknesses          ["Water" "Ice" "Ground" "Psychic"]
              :fast-attacks        ["Fury Cutter" "Poison Jab"]
              :weight              "62.0 kg"
              :height              "1.4 m"
              :previous-evolutions [32 33]}

          35 {:pokemon-id                  35
              :name                        "Clefairy"
              :classification              "Fairy Pokémon"
              :type-1                      ["Normal"]
              :weaknesses                  ["Fighting"]
              :fast-attacks                ["Pound" "Zen Headbutt"]
              :weight                      "7.5 kg"
              :height                      "0.6 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Clefairy candies"}
              :next-evolutions             [36]}

          36 {:pokemon-id          36
              :name                "Clefable"
              :classification      "Fairy Pokémon"
              :type-1              ["Normal"]
              :weaknesses          ["Fighting"]
              :fast-attacks        ["Pound" "Zen Headbutt"]
              :weight              "40.0 kg"
              :height              "1.3 m"
              :previous-evolutions [35]}

          37 {:pokemon-id                  37
              :name                        "Vulpix"
              :classification              "Fox Pokémon"
              :type-1                      ["Fire"]
              :weaknesses                  ["Water" "Ground" "Rock"]
              :fast-attacks                ["Ember" "Quick Attack"]
              :weight                      "9.9 kg"
              :height                      "0.6 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Vulpi"}
              :next-evolutions             [38]}

          38 {:pokemon-id          38
              :name                "Ninetales"
              :classification      "Fox Pokémon"
              :type-1              ["Fire"]
              :weaknesses          ["Water" "Ground" "Rock"]
              :fast-attacks        ["Ember" "Quick Attack"]
              :weight              "19.9 kg"
              :height              "1.1 m"
              :previous-evolutions [37]}

          39 {:pokemon-id                  39
              :name                        "Jigglypuff"
              :classification              "Balloon Pokémon"
              :type-1                      ["Normal"]
              :weaknesses                  ["Fighting"]
              :fast-attacks                ["Feint Attack" "Pound"]
              :weight                      "5.5 kg"
              :height                      "0.5 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Jigglypuff candies"}
              :next-evolutions             [40]}

          40 {:pokemon-id          40
              :name                "Wigglytuff"
              :classification      "Balloon Pokémon"
              :type-1              ["Normal"]
              :weaknesses          ["Fighting"]
              :fast-attacks        ["Feint Attack" "Pound"]
              :weight              "12.0 kg"
              :height              "1.0 m"
              :previous-evolutions [40]}

          41 {:pokemon-id                  41
              :name                        "Zubat"
              :classification              "Bat Pokémon"
              :type-1                      ["Poison"]
              :type-2                      ["Flying"]
              :weaknesses                  ["Electric" "Ice" "Psychic" "Rock"]
              :fast-attacks                ["Bite" "Quick Attack"]
              :weight                      "7.5 kg"
              :height                      "0.8 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Zubat candies"}
              :next-evolutions             [42]}

          42 {:pokemon-id          42
              :name                "Golbat"
              :classification      "Bat Pokémon"
              :type-1              ["Poison"]
              :type-2              ["Flying"]
              :weaknesses          ["Electric" "Ice" "Psychic" "Rock"]
              :fast-attacks        ["Bite" "Wing Attack"]
              :weight              "55.0 kg"
              :height              "1.6 m"
              :previous-evolutions [41]}

          43 {:pokemon-id                  43
              :name                        "Oddish"
              :classification              "Weed Pokémon"
              :type-1                      ["Grass"]
              :type-2                      ["Poison"]
              :weaknesses                  ["Fire" "Ice" "Flying" "Psychic"]
              :fast-attacks                ["Acid" "Razor Leaf"]
              :weight                      "5.4 kg"
              :height                      "0.5 m"
              :next-evolution-requirements {:amount 25
                                            :name   "Oddish candies"}
              :next-evolutions             [44 45]}

          44 {:pokemon-id                  44
              :name                        "Gloom"
              :classification              "Weed Pokémon"
              :type-1                      ["Grass"]
              :type-2                      ["Poison"]
              :weaknesses                  ["Fire" "Ice" "Flying" "Psychic"]
              :fast-attacks                ["Acid" "Razor Leaf"]
              :weight                      "8.6 kg"
              :height                      "0.8 m"
              :previous-evolutions         [43]
              :next-evolution-requirements {:amount 100
                                            :name   "Oddish candies"}
              :next-evolutions             [45]}

          45 {:pokemon-id          45
              :name                "Vileplume"
              :classification      "Flower Pokémon"
              :type-1              ["Grass"]
              :type-2              ["Poison"]
              :weaknesses          ["Fire" "Ice" "Flying" "Psychic"]
              :fast-attacks        ["Acid" ""]
              :weight              "18.6 kg"
              :height              "1.2 m"
              :previous-evolutions [43 44]}

          46 {:pokemon-id                  46
              :name                        "Paras"
              :classification              "Mushroom Pokémon"
              :type-1                      ["Bug"]
              :type-2                      ["Grass"]
              :weaknesses                  ["Fire" "Ice" "Poison" "Flying" "Bug" "Rock"]
              :fast-attacks                ["Bug Bite" "Scratch"]
              :weight                      "5.4 kg"
              :height                      "0.3 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Paras candies"}
              :next-evolutions             [47]}

          47 {:pokemon-id          47
              :name                "Parasect"
              :classification      "Mushroom Pokémon"
              :type-1              ["Bug"]
              :type-2              ["Grass"]
              :weaknesses          ["Fire" "Ice" "Poison" "Flying" "Bug" "Rock"]
              :fast-attacks        ["Bug Bite" "Fury Cutter"]
              :weight              "29.5 kg"
              :height              "1.0 m"
              :previous-evolutions [46]}

          48 {:pokemon-id                  48
              :name                        "Venonat"
              :classification              "Insect Pokémon"
              :type-1                      ["Bug"]
              :type-2                      ["Poison"]
              :weaknesses                  ["Fire" "Flying" "Psychic" "Rock"]
              :fast-attacks                ["Bug Bite" "Confusion"]
              :weight                      "30.0 kg"
              :height                      "1.0 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Venonat candies"}
              :next-evolutions             [49]}

          49 {:pokemon-id          49
              :name                "Venomoth"
              :classification      "Poison Moth Pokémon"
              :type-1              ["Bug"]
              :type-2              ["Poison"]
              :weaknesses          ["Fire" "Flying" "Psychic" "Rock"]
              :fast-attacks        ["Bug Bite" "Confusion"]
              :weight              "12.5 kg"
              :height              "1.5 m"
              :previous-evolutions [48]}

          50 {:pokemon-id                  50
              :name                        "Diglett"
              :classification              "Mole Pokémon"
              :type-1                      ["Ground"]
              :weaknesses                  ["Water" "Grass" "Ice"]
              :fast-attacks                ["Mud Shot" "Scratch"]
              :weight                      "0.8 kg"
              :height                      "0.2 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Diglett candies"}
              :next-evolutions             [51]}

          51 {:pokemon-id          51
              :name                "Dugtrio"
              :classification      "Mole Pokémon"
              :type-1              ["Ground"]
              :weaknesses          ["Water" "Grass" "Ice"]
              :fast-attacks        ["Mud Shot" "Sucker Punch"]
              :weight              "33.3 kg"
              :height              "0.7 m"
              :previous-evolutions [50]}

          52 {:pokemon-id                  52
              :name                        "Meowth"
              :classification              "Scratch Cat Pokémon"
              :type-1                      ["Normal"]
              :weaknesses                  ["Fighting"]
              :fast-attacks                ["Bite" "Scratch"]
              :weight                      "4.2 kg"
              :height                      "0.4 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Meowth candies"}
              :next-evolutions             [53]}

          53 {:pokemon-id          53
              :name                "Persian"
              :classification      "Classy Cat Pokémon"
              :type-1              ["Normal"]
              :weaknesses          ["Fighting"]
              :fast-attacks        ["Feint Attack" "Scratch"]
              :weight              "32.0 kg"
              :height              "1.0 m"
              :previous-evolutions [52]}

          54 {:pokemon-id                  54
              :name                        "Psyduck"
              :classification              "Duck Pokémon"
              :type-1                      ["Water"]
              :weaknesses                  ["Electric" "Grass"]
              :fast-attacks                ["Water Gun" "Zen Headbutt"]
              :weight                      "19.6 kg"
              :height                      "0.8 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Psyduck candies"}
              :next-evolutions             [55]}

          55 {:pokemon-id          55
              :name                "Golduck"
              :classification      "Duck Pokémon"
              :type-1              ["Water"]
              :weaknesses          ["Electric" "Grass"]
              :fast-attacks        ["Confusion" "Zen Headbutt"]
              :weight              "76.6 kg"
              :height              "1.7 m"
              :previous-evolutions [54]}

          56 {:pokemon-id                  56
              :name                        "Mankey"
              :classification              "Pig Monkey Pokémon"
              :type-1                      ["Fighting"]
              :weaknesses                  ["Flying" "Psychic" "Fairy"]
              :fast-attacks                ["Karate Chop" "Scratch"]
              :weight                      "28.0 kg"
              :height                      "0.5 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Mankey candies"}
              :next-evolutions             [57]}

          57 {:pokemon-id          57
              :name                "Primeape"
              :classification      "Pig Monkey Pokémon"
              :type-1              ["Fighting"]
              :weaknesses          ["Flying" "Psychic" "Fairy"]
              :fast-attacks        ["Karate Chop" "Low Kick"]
              :weight              "32.0 kg"
              :height              "1.0 m"
              :previous-evolutions [56]}

          58 {:pokemon-id                  58
              :name                        "Growlithe"
              :classification              "Puppy Pokémon"
              :type-1                      ["Fire"]
              :weaknesses                  ["Water" "Ground" "Rock"]
              :fast-attacks                ["Bite" "Ember"]
              :weight                      "19.0 kg"
              :height                      "0.7 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Growlithe candies"}
              :next-evolutions             [59]}

          59 {:pokemon-id          59
              :name                "Arcanine"
              :classification      "Legendary Pokémon"
              :type-1              ["Fire"]
              :weaknesses          ["Water" "Ground" "Rock"]
              :fast-attacks        ["Bite" "Fire Fang"]
              :weight              "155.0 kg"
              :height              "1.9 m"
              :previous-evolutions [58]}

          60 {:pokemon-id                  60
              :name                        "Poliwag"
              :classification              "Tadpole Pokémon"
              :type-1                      ["Water"]
              :weaknesses                  ["Electric" "Grass"]
              :fast-attacks                ["Bubble" "Mud Shot"]
              :weight                      "12.4 kg"
              :height                      "0.6 m"
              :next-evolution-requirements {:amount 25
                                            :name   "Poliwag candies"}
              :next-evolutions             [61 62]}

          61 {:pokemon-id                  61
              :name                        "Poliwhirl"
              :classification              "Tadpole Pokémon"
              :type-1                      ["Water"]
              :weaknesses                  ["Electric" "Grass"]
              :fast-attacks                ["Bubble" "Mud Shot"]
              :weight                      "20.0 kg"
              :height                      "1.0 m"
              :previous-evolutions         [60]
              :next-evolution-requirements {:amount 100
                                            :name   "Poliwag candies"}
              :next-evolutions             [62]}

          62 {:pokemon-id          62
              :name                "Poliwrath"
              :classification      "Tadpole Pokémon"
              :type-1              ["Water"]
              :type-2              ["Fighting"]
              :weaknesses          ["Electric" "Grass" "Flying" "Psychic" "Fairy"]
              :fast-attacks        ["Bubble" "Mud Shot"]
              :weight              "54.0 kg"
              :height              "1.3 m"
              :previous-evolutions [60 61]}

          63 {:pokemon-id                  63
              :name                        "Abra"
              :classification              "Psi Pokémon"
              :type-1                      ["Psychic"]
              :weaknesses                  ["Bug" "Ghost" "Dark"]
              :fast-attacks                ["Zen Headbutt" ""]
              :weight                      "19.5 kg"
              :height                      "0.9 m"
              :next-evolution-requirements {:amount 25
                                            :name   "Abra candies"}
              :next-evolutions             [64 65]}

          64 {:pokemon-id                  64
              :name                        "Kadabra"
              :classification              "Psi Pokémon"
              :type-1                      ["Psychic"]
              :weaknesses                  ["Bug" "Ghost" "Dark"]
              :fast-attacks                ["Confusion" "Psycho Cut"]
              :weight                      "56.5 kg"
              :height                      "1.3 m"
              :previous-evolutions         [63]
              :next-evolution-requirements {:amount 100
                                            :name   "Abra candies"}
              :next-evolutions             [65]}

          65 {:pokemon-id          65
              :name                "Alakazam"
              :classification      "Psi Pokémon"
              :type-1              ["Psychic"]
              :weaknesses          ["Bug" "Ghost" "Dark"]
              :fast-attacks        ["Confusion" "Psycho Cut"]
              :weight              "48.0 kg"
              :height              "1.5 m"
              :previous-evolutions [63 64]}

          66 {:pokemon-id                  66
              :name                        "Machop"
              :classification              "Superpower Pokémon"
              :type-1                      ["Fighting"]
              :weaknesses                  ["Flying" "Psychic" "Fairy"]
              :fast-attacks                ["Karate Chop" "Low Kick"]
              :weight                      "19.5 kg"
              :height                      "0.8 m"
              :next-evolution-requirements {:amount 25
                                            :name   "Machop candies"}
              :next-evolutions             [67 68]}

          67 {:pokemon-id                  67
              :name                        "Machoke"
              :classification              "Superpower Pokémon"
              :type-1                      ["Fighting"]
              :weaknesses                  ["Flying" "Psychic" "Fairy"]
              :fast-attacks                ["Karate Chop" "Low Kick"]
              :weight                      "70.5 kg"
              :height                      "1.5 m"
              :previous-evolutions         [66]
              :next-evolution-requirements {:amount 100
                                            :name   "Machop candies"}
              :next-evolutions             [68]}

          68 {:pokemon-id          68
              :name                "Machamp"
              :classification      "Superpower Pokémon"
              :type-1              ["Fighting"]
              :weaknesses          ["Flying" "Psychic" "Fairy"]
              :fast-attacks        ["Bullet Punch" "Karate Chop"]
              :weight              "130.0 kg"
              :height              "1.6 m"
              :previous-evolutions [66 67]}

          69 {:pokemon-id                  69
              :name                        "Bellsprout"
              :classification              "Flower Pokémon"
              :type-1                      ["Grass"]
              :type-2                      ["Poison"]
              :weaknesses                  ["Fire" "Ice" "Flying" "Psychic"]
              :fast-attacks                ["Acid" "Vine Whip"]
              :weight                      "4.0 kg"
              :height                      "0.7 m"
              :next-evolution-requirements {:amount 25
                                            :name   "Bellsprout candies"}
              :next-evolutions             [70 71]}

          70 {:pokemon-id                  70
              :name                        "Weepinbell"
              :classification              "Flycatcher Pokémon"
              :type-1                      ["Grass"]
              :type-2                      ["Poison"]
              :weaknesses                  ["Fire" "Ice" "Flying" "Psychic"]
              :fast-attacks                ["Acid" "Razor Leaf"]
              :weight                      "6.4 kg"
              :height                      "1.0 m"
              :previous-evolutions         [69]
              :next-evolution-requirements {:amount 100
                                            :name   "Bellsprout candies"}
              :next-evolutions             [71]}

          71 {:pokemon-id          71
              :name                "Victreebel"
              :classification      "Flycatcher Pokémon"
              :type-1              ["Grass"]
              :type-2              ["Poison"]
              :weaknesses          ["Fire" "Ice" "Flying" "Psychic"]
              :fast-attacks        ["Acid" "Razor Leaf"]
              :weight              "15.5 kg"
              :height              "1.7 m"
              :previous-evolutions [69 70]}

          72 {:pokemon-id                  72
              :name                        "Tentacool"
              :classification              "Jellyfish Pokémon"
              :type-1                      ["Water"]
              :type-2                      ["Poison"]
              :weaknesses                  ["Electric" "Ground" "Psychic"]
              :fast-attacks                ["Bubble" "Poison Sting"]
              :weight                      "45.5 kg"
              :height                      "0.9 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Tentacool candies"}
              :next-evolutions             [73]}

          73 {:pokemon-id          73
              :name                "Tentacruel"
              :classification      "Jellyfish Pokémon"
              :type-1              ["Water"]
              :type-2              ["Poison"]
              :weaknesses          ["Electric" "Ground" "Psychic"]
              :fast-attacks        ["Acid" "Poison Jab"]
              :weight              "55.0 kg"
              :height              "1.6 m"
              :previous-evolutions [72]}

          74 {:pokemon-id                  74
              :name                        "Geodude"
              :classification              "Rock Pokémon"
              :type-1                      ["Rock"]
              :type-2                      ["Ground"]
              :weaknesses                  ["Water" "Grass" "Ice" "Fighting" "Ground" "Steel"]
              :fast-attacks                ["Rock Throw" "Tackle"]
              :weight                      "20.0 kg"
              :height                      "0.4 m"
              :next-evolution-requirements {:amount 25
                                            :name   "Geodude candies"}
              :next-evolutions             [75 76]}

          75 {:pokemon-id                  75
              :name                        "Graveler"
              :classification              "Rock Pokémon"
              :type-1                      ["Rock"]
              :type-2                      ["Ground"]
              :weaknesses                  ["Water" "Grass" "Ice" "Fighting" "Ground" "Steel"]
              :fast-attacks                ["Mud Shot" "Rock Throw"]
              :weight                      "105.0 kg"
              :height                      "1.0 m"
              :previous-evolutions         [74]
              :next-evolution-requirements {:amount 100
                                            :name   "Geodude candies"}
              :next-evolutions             [76]}

          76 {:pokemon-id          76
              :name                "Golem"
              :classification      "Megaton Pokémon"
              :type-1              ["Rock"]
              :type-2              ["Ground"]
              :weaknesses          ["Water" "Grass" "Ice" "Fighting" "Ground" "Steel"]
              :fast-attacks        ["Mud Shot" "Rock Throw"]
              :weight              "300.0 kg"
              :height              "1.4 m"
              :previous-evolutions [74 75]}

          77 {:pokemon-id                  77
              :name                        "Ponyta"
              :classification              "Fire Horse Pokémon"
              :type-1                      ["Fire"]
              :weaknesses                  ["Water" "Ground" "Rock"]
              :fast-attacks                ["Ember" "Tackle"]
              :weight                      "30.0 kg"
              :height                      "1.0 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Ponyta candies"}
              :next-evolutions             [78]}

          78 {:pokemon-id          78
              :name                "Rapidash"
              :classification      "Fire Horse Pokémon"
              :type-1              ["Fire"]
              :weaknesses          ["Water" "Ground" "Rock"]
              :fast-attacks        ["Ember" "Low Kick"]
              :weight              "95.0 kg"
              :height              "1.7 m"
              :previous-evolutions [77]}

          79 {:pokemon-id                  79
              :name                        "Slowpoke"
              :classification              "Dopey Pokémon"
              :type-1                      ["Water"]
              :type-2                      ["Psychic"]
              :weaknesses                  ["Electric" "Grass" "Bug" "Ghost" "Dark"]
              :fast-attacks                ["Confusion" "Water Gun"]
              :weight                      "36.0 kg"
              :height                      "1.2 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Slowpoke candies"}
              :next-evolutions             [80]}

          80 {:pokemon-id          80
              :name                "Slowbro"
              :classification      "Hermit Crab Pokémon"
              :type-1              ["Water"]
              :type-2              ["Psychic"]
              :weaknesses          ["Electric" "Grass" "Bug" "Ghost" "Dark"]
              :fast-attacks        ["Confusion" "Water Gun"]
              :weight              "78.5 kg"
              :height              "1.6 m"
              :previous-evolutions [79]}

          81 {:pokemon-id                  81
              :name                        "Magnemite"
              :classification              "Magnet Pokémon"
              :type-1                      ["Electric"]
              :type-2                      ["Steel"]
              :weaknesses                  ["Fire" "Water" "Ground"]
              :fast-attacks                ["Spark" "Thunder Shock"]
              :weight                      "6.0 kg"
              :height                      "0.3 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Magnemite candies"}
              :next-evolutions             [82]}

          82 {:pokemon-id          82
              :name                "Magneton"
              :classification      "Magnet Pokémon"
              :type-1              ["Electric"]
              :type-2              ["Steel"]
              :weaknesses          ["Fire" "Water" "Ground"]
              :fast-attacks        ["Spark" "Thunder Shock"]
              :weight              "60.0 kg"
              :height              "1.0 m"
              :previous-evolutions [81]}

          83 {:pokemon-id     83
              :name           "Farfetch'd"
              :classification "Wild Duck Pokémon"
              :type-1         ["Normal"]
              :type-2         ["Flying"]
              :weaknesses     ["Electric" "Rock"]
              :fast-attacks   ["Unknown"]
              :special-attack ["Unknown"]
              :weight         "15.0 kg"
              :height         "0.8 m"}

          84 {:pokemon-id                  84
              :name                        "Doduo"
              :classification              "Twin Bird Pokémon"
              :type-1                      ["Normal"]
              :type-2                      ["Flying"]
              :weaknesses                  ["Electric" "Rock"]
              :fast-attacks                ["Peck" "Quick Attack"]
              :weight                      "39.2 kg"
              :height                      "1.4 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Doduo candies "
                                            }
              :next-evolutions             [85]}

          85 {:pokemon-id          85
              :name                "Dodrio"
              :classification      "Triple Bird Pokémon"
              :type-1              ["Normal"]
              :type-2              ["Flying"]
              :weaknesses          ["Electric" "Rock"]
              :fast-attacks        ["Feint Attack" "Steel Wing"]
              :weight              "85.2 kg"
              :height              "1.8 m"
              :previous-evolutions [84]}

          86 {:pokemon-id                  86
              :name                        "Seel"
              :classification              "Sea Lion Pokémon"
              :type-1                      ["Water"]
              :weaknesses                  ["Electric" "Grass"]
              :fast-attacks                ["Ice Shard" "Water Gun"]
              :weight                      "90.0 kg"
              :height                      "1.1 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Seel candies "
                                            }
              :next-evolutions             [87]}

          87 {:pokemon-id          87
              :name                "Dewgong"
              :classification      "Sea Lion Pokémon"
              :type-1              ["Water"]
              :type-2              ["Ice"]
              :weaknesses          ["Electric" "Grass" "Fighting" "Rock"]
              :fast-attacks        ["Frost Breath" "Ice Shard"]
              :weight              "120.0 kg"
              :height              "1.7 m"
              :previous-evolutions [86]}

          88 {:pokemon-id                  88
              :name                        "Grimer"
              :classification              "Sludge Pokémon"
              :type-1                      ["Poison"]
              :weaknesses                  ["Ground" "Psychic"]
              :fast-attacks                ["Acid" "Mud Slap"]
              :weight                      "30.0 kg"
              :height                      "0.9 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Grimer candies "
                                            }
              :next-evolutions             [89]}

          89 {:pokemon-id          89
              :name                "Muk"
              :classification      "Sludge Pokémon"
              :type-1              ["Poison"]
              :weaknesses          ["Ground" "Psychic"]
              :fast-attacks        ["Poison Jab" ""]
              :weight              "30.0 kg"
              :height              "1.2 m"
              :previous-evolutions [88]}

          90 {:pokemon-id                  90
              :name                        "Shellder"
              :classification              "Bivalve Pokémon"
              :type-1                      ["Water"]
              :weaknesses                  ["Electric" "Grass"]
              :fast-attacks                ["Ice Shard" "Tackle"]
              :weight                      "4.0 kg"
              :height                      "0.3 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Shellder candies "
                                            }
              :next-evolutions             [91]}

          91 {:pokemon-id          91
              :name                "Cloyster"
              :classification      "Bivalve Pokémon"
              :type-1              ["Water"]
              :type-2              ["Ice"]
              :weaknesses          ["Electric" "Grass" "Fighting" "Rock"]
              :fast-attacks        ["Frost Breath" "Ice Shard"]
              :weight              "132.5 kg"
              :height              "1.5 m"
              :previous-evolutions [90]}

          92 {:pokemon-id                  92
              :name                        "Gastly"
              :classification              "Gas Pokémon"
              :type-1                      ["Ghost"]
              :type-2                      ["Poison"]
              :weaknesses                  ["Ground" "Psychic" "Ghost" "Dark"]
              :fast-attacks                ["Lick" "Sucker Punch"]
              :weight                      "0.1 kg"
              :height                      "1.3 m"
              :next-evolution-requirements {:amount 25
                                            :name   "Gastly candies "
                                            }
              :next-evolutions             [93 94]}

          93 {:pokemon-id                  93
              :name                        "Haunter"
              :classification              "Gas Pokémon"
              :type-1                      ["Ghost"]
              :type-2                      ["Poison"]
              :weaknesses                  ["Ground" "Psychic" "Ghost" "Dark"]
              :fast-attacks                ["Lick" "Shadow Claw"]
              :weight                      "0.1 kg"
              :height                      "1.6 m"
              :previous-evolutions         [92]
              :next-evolution-requirements {:amount 100
                                            :name   "Gastly candies "
                                            }
              :next-evolutions             [94]}

          94 {:pokemon-id          94
              :name                "Gengar"
              :classification      "Shadow Pokémon"
              :type-1              ["Ghost"]
              :type-2              ["Poison"]
              :weaknesses          ["Ground" "Psychic" "Ghost" "Dark"]
              :fast-attacks        ["Shadow Claw" "Sucker Punch"]
              :weight              "40.5 kg"
              :height              "1.5 m"
              :previous-evolutions [92 93]}

          95 {:pokemon-id     95
              :name           "Onix"
              :classification "Rock Snake Pokémon"
              :type-1         ["Rock"]
              :type-2         ["Ground"]
              :weaknesses     ["Water" "Grass" "Ice" "Fighting" "Ground" "Steel"]
              :fast-attacks   ["Rock Throw" "Tackle"]
              :weight         "210.0 kg"
              :height         "8.8 m"}

          96 {:pokemon-id                  96
              :name                        "Drowzee"
              :classification              "Hypnosis Pokémon"
              :type-1                      ["Psychic"]
              :weaknesses                  ["Bug" "Ghost" "Dark"]
              :fast-attacks                ["Confusion" "Pound"]
              :weight                      "32.4 kg"
              :height                      "1.0 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Drowzee candies "
                                            }
              :next-evolutions             [97]}

          97 {:pokemon-id          97
              :name                "Hypno"
              :classification      "Hypnosis Pokémon"
              :type-1              ["Psychic"]
              :weaknesses          ["Bug" "Ghost" "Dark"]
              :fast-attacks        ["Confusion" "Zen Headbutt"]
              :weight              "75.6 kg"
              :height              "1.6 m"
              :previous-evolutions [96]}

          98 {:pokemon-id                  98
              :name                        "Krabby"
              :classification              "River Crab Pokémon"
              :type-1                      ["Water"]
              :weaknesses                  ["Electric" "Grass"]
              :fast-attacks                ["Bubble" "Mud Shot"]
              :weight                      "6.5 kg"
              :height                      "0.4 m"
              :next-evolution-requirements {:amount 50
                                            :name   "Krabby candies "
                                            }
              :next-evolutions             [99]}

          99 {:pokemon-id          99
              :name                "Kingler"
              :classification      "Pincer Pokémon"
              :type-1              ["Water"]
              :weaknesses          ["Electric" "Grass"]
              :fast-attacks        ["Metal Claw" "Mud Shot"]
              :weight              "60.0 kg"
              :height              "1.3 m"
              :previous-evolutions [98]}

          100 {:pokemon-id                  100
               :name                        "Voltorb"
               :classification              "Ball Pokémon"
               :type-1                      ["Electric"]
               :weaknesses                  ["Ground"]
               :fast-attacks                ["Spark" "Tackle"]
               :weight                      "10.4 kg"
               :height                      "0.5 m"
               :next-evolution-requirements {:amount 50
                                             :name   "Voltorb candies "
                                             }
               :next-evolutions             [101]}

          101 {:pokemon-id          101
               :name                "Electrode"
               :classification      "Ball Pokémon"
               :type-1              ["Electric"]
               :weaknesses          ["Ground"]
               :fast-attacks        ["Spark" ""]
               :weight              "66.6 kg"
               :height              "1.2 m"
               :previous-evolutions [100]}

          102 {:pokemon-id                  102
               :name                        "Exeggcute"
               :classification              "Egg Pokémon"
               :type-1                      ["Grass"]
               :type-2                      ["Psychic"]
               :weaknesses                  ["Fire" "Ice" "Poison" "Flying" "Bug" "Ghost" "Dark"]
               :fast-attacks                ["Confusion" ""]
               :weight                      "2.5 kg"
               :height                      "0.4 m"
               :next-evolution-requirements {:amount 50
                                             :name   "E "
                                             }
               :next-evolutions             [103]}

          103 {:pokemon-id          103
               :name                "Exeggutor"
               :classification      "Coconut Pokémon"
               :type-1              ["Grass"]
               :type-2              ["Psychic"]
               :weaknesses          ["Fire" "Ice" "Poison" "Flying" "Bug" "Ghost" "Dark"]
               :fast-attacks        ["Confusion" "Zen Headbutt"]
               :weight              "120.0 kg"
               :height              "2.0 m"
               :previous-evolutions [102]}

          104 {:pokemon-id                  104
               :name                        "Cubone"
               :classification              "Lonely Pokémon"
               :type-1                      ["Ground"]
               :weaknesses                  ["Water" "Grass" "Ice"]
               :fast-attacks                ["Mud Slap" "Rock Smash"]
               :weight                      "6.5 kg"
               :height                      "0.4 m"
               :next-evolution-requirements {:amount 50
                                             :name   "Cubone candies "
                                             }
               :next-evolutions             [105]}

          105 {:pokemon-id          105
               :name                "Marowak"
               :classification      "Bone Keeper Pokémon"
               :type-1              ["Ground"]
               :weaknesses          ["Water" "Grass" "Ice"]
               :fast-attacks        ["Mud Slap" "Rock Smash"]
               :weight              "45.0 kg"
               :height              "1.0 m"
               :previous-evolutions [104]}

          106 {:pokemon-id      106
               :name            "Hitmonlee"
               :classification  "Kicking Pokémon"
               :type-1          ["Fighting"]
               :weaknesses      ["Flying" "Psychic" "Fairy"]
               :fast-attacks    ["Low Kick" "Rock Smash"]
               :weight          "49.8 kg"
               :height          "1.5 m"
               :next-evolutions [107]}

          107 {:pokemon-id          107
               :name                "Hitmonchan"
               :classification      "Punching Pokémon"
               :type-1              ["Fighting"]
               :weaknesses          ["Flying" "Psychic" "Fairy"]
               :fast-attacks        ["Bullet Punch" "Rock Smash"]
               :weight              "50.2 kg"
               :height              "1.4 m"
               :previous-evolutions [106]}

          108 {:pokemon-id     108
               :name           "Lickitung"
               :classification "Licking Pokémon"
               :type-1         ["Normal"]
               :weaknesses     ["Fighting"]
               :fast-attacks   ["Lick" "Zen Headbutt"]
               :weight         "65.5 kg"
               :height         "1.2 m"}

          109 {:pokemon-id                  109
               :name                        "Koffing"
               :classification              "Poison Gas Pokémon"
               :type-1                      ["Poison"]
               :weaknesses                  ["Ground" "Psychic"]
               :fast-attacks                ["Acid" "Tackle"]
               :weight                      "1.0 kg"
               :height                      "0.6 m"
               :next-evolution-requirements {:amount 50
                                             :name   "Koffing candies"}
               :next-evolutions             [110]}

          110 {:pokemon-id          110
               :name                "Weezing"
               :classification      "Poison Gas Pokémon"
               :type-1              ["Poison"]
               :weaknesses          ["Ground" "Psychic"]
               :fast-attacks        ["Acid" "Tackle"]
               :weight              "9.5 kg"
               :height              "1.2 m"
               :previous-evolutions [109]}

          111 {:pokemon-id                  111
               :name                        "Rhyhorn"
               :classification              "Spikes Pokémon"
               :type-1                      ["Ground"]
               :type-2                      ["Rock"]
               :weaknesses                  ["Water" "Grass" "Ice" "Fighting" "Ground" "Steel"]
               :fast-attacks                ["Mud Slap" "Rock Smash"]
               :weight                      "115.0 kg"
               :height                      "1.0 m"
               :next-evolution-requirements {:amount 50
                                             :name   "Rhyhorn candies "
                                             }
               :next-evolutions             [112]}

          112 {:pokemon-id          112
               :name                "Rhydon"
               :classification      "Drill Pokémon"
               :type-1              ["Ground"]
               :type-2              ["Rock"]
               :weaknesses          ["Water" "Grass" "Ice" "Fighting" "Ground" "Steel"]
               :fast-attacks        ["Mud Slap" "Rock Smash"]
               :weight              "120.0 kg"
               :height              "1.9 m"
               :previous-evolutions [111]}

          113 {:pokemon-id     113
               :name           "Chansey"
               :classification "Egg Pokémon"
               :type-1         ["Normal"]
               :weaknesses     ["Fighting"]
               :fast-attacks   ["Pound" "Zen Headbutt"]
               :weight         "34.6 kg"
               :height         "1.1 m"}

          114 {:pokemon-id     114
               :name           "Tangela"
               :classification "Vine Pokémon"
               :type-1         ["Grass"]
               :weaknesses     ["Fire" "Ice" "Poison" "Flying" "Bug"]
               :fast-attacks   ["Vine Whip" ""]
               :weight         "35.0 kg"
               :height         "1.0 m"}

          115 {:pokemon-id     115
               :name           "Kangaskhan"
               :classification "Parent Pokémon"
               :type-1         ["Normal"]
               :weaknesses     ["Fighting"]
               :fast-attacks   ["Low Kick" ""]
               :weight         "80.0 kg"
               :height         "2.2 m"}

          116 {:pokemon-id                  116
               :name                        "Horsea"
               :classification              "Dragon Pokémon"
               :type-1                      ["Water"]
               :weaknesses                  ["Electric" "Grass"]
               :fast-attacks                ["Bubble" "Water Gun"]
               :weight                      "8.0 kg"
               :height                      "0.4 m"
               :next-evolution-requirements {:amount 50
                                             :name   "Horsea candies"}
               :next-evolutions             [117]}

          117 {:pokemon-id          117
               :name                "Seadra"
               :classification      "Dragon Pokémon"
               :type-1              ["Water"]
               :weaknesses          ["Electric" "Grass"]
               :fast-attacks        ["Dragon Breath" "Water Gun"]
               :weight              "25.0 kg"
               :height              "1.2 m"
               :previous-evolutions [116]}

          118 {:pokemon-id                  118
               :name                        "Goldeen"
               :classification              "Goldfish Pokémon"
               :type-1                      ["Water"]
               :weaknesses                  ["Electric" "Grass"]
               :fast-attacks                ["Peck" "Mud Shot"]
               :weight                      "15.0 kg"
               :height                      "0.6 m"
               :next-evolution-requirements {:amount 50
                                             :name   "Goldeen candies"}
               :next-evolutions             [119]}

          119 {:pokemon-id          119
               :name                "Seaking"
               :classification      "Goldfish Pokémon"
               :type-1              ["Water"]
               :weaknesses          ["Electric" "Grass"]
               :fast-attacks        ["Peck" "Poison Jab"]
               :weight              "39.0 kg"
               :height              "1.3 m"
               :previous-evolutions [118]}

          120 {:pokemon-id                  120
               :name                        "Staryu"
               :classification              "Starshape Pokémon"
               :type-1                      ["Water"]
               :weaknesses                  ["Electric" "Grass"]
               :fast-attacks                ["Quick Attack" "Water Gun"]
               :weight                      "34.5 kg"
               :height                      "0.8 m"
               :next-evolution-requirements {:amount 50
                                             :name   "Staryu candies"}
               :next-evolutions             [120]}

          121 {:pokemon-id          121
               :name                "Starmie"
               :classification      "Mysterious Pokémon"
               :type-1              ["Water"]
               :type-2              ["Psychic"]
               :weaknesses          ["Electric" "Grass" "Bug" "Ghost" "Dark"]
               :fast-attacks        ["Quick Attack" "Water Gun"]
               :weight              "80.0 kg"
               :height              "1.1 m"
               :previous-evolutions [121]}

          122 {:pokemon-id     122
               :name           "Mr. Mime"
               :classification "Barrier Pokémon"
               :type-1         ["Psychic"]
               :weaknesses     ["Bug" "Ghost" "Dark"]
               :fast-attacks   ["Confusion" "Zen Headbutt"]
               :weight         "54.5 kg"
               :height         "1.3 m"}

          123 {:pokemon-id     123
               :name           "Scyther"
               :classification "Mantis Pokémon"
               :type-1         ["Bug"]
               :type-2         ["Flying"]
               :weaknesses     ["Fire" "Electric" "Ice" "Flying" "Rock"]
               :fast-attacks   ["Fury Cutter" "Steel Wing"]
               :weight         "56.0 kg"
               :height         "1.5 m"}

          124 {:pokemon-id     124
               :name           "Jynx"
               :classification "Humanshape Pokémon"
               :type-1         ["Ice"]
               :type-2         ["Psychic"]
               :weaknesses     ["Fire" "Bug" "Rock" "Ghost" "Dark" "Steel"]
               :fast-attacks   ["Frost Breath" "Pound"]
               :weight         "40.6 kg"
               :height         "1.4 m"}

          125 {:pokemon-id     125
               :name           "Electabuzz"
               :classification "Electric Pokémon"
               :type-1         ["Electric"]
               :weaknesses     ["Ground"]
               :fast-attacks   ["Low Kick" "Thunder Shock"]
               :weight         "30.0 kg"
               :height         "1.1 m"}

          126 {:pokemon-id     126
               :name           "Magmar"
               :classification "Spitfire Pokémon"
               :type-1         ["Fire"]
               :weaknesses     ["Water" "Ground" "Rock"]
               :fast-attacks   ["Ember" "Karate Chop"]
               :weight         "44.5 kg"
               :height         "1.3 m"}

          127 {:pokemon-id     127
               :name           "Pinsir"
               :classification "Stagbeetle Pokémon"
               :type-1         ["Bug"]
               :weaknesses     ["Fire" "Flying" "Rock"]
               :fast-attacks   ["Fury Cutter" "Rock Smash"]
               :weight         "55.0 kg"
               :height         "1.5 m"}

          128 {:pokemon-id     128
               :name           "Tauros"
               :classification "Wild Bull Pokémon"
               :type-1         ["Normal"]
               :weaknesses     ["Fighting"]
               :fast-attacks   ["Tackle" "Zen Headbutt"]
               :weight         "88.4 kg"
               :height         "1.4 m"}

          129 {:pokemon-id                  129
               :name                        "Magikarp"
               :classification              "Fish Pokémon"
               :type-1                      ["Water"]
               :weaknesses                  ["Electric" "Grass"]
               :fast-attacks                ["Splash" ""]
               :weight                      "10.0 kg"
               :height                      "0.9 m"
               :next-evolution-requirements {:amount 400
                                             :name   "Magikarp candies"}
               :next-evolutions             [130]}

          130 {:pokemon-id          130
               :name                "Gyarados"
               :classification      "Atrocious Pokémon"
               :type-1              ["Water"]
               :type-2              ["Flying"]
               :weaknesses          ["Electric" "Rock"]
               :fast-attacks        ["Bite" "Dragon Breath"]
               :weight              "235.0 kg"
               :height              "6.5 m"
               :previous-evolutions [129]}

          131 {:pokemon-id     131
               :name           "Lapras"
               :classification "Transport Pokémon"
               :type-1         ["Water"]
               :type-2         ["Ice"]
               :weaknesses     ["Electric" "Grass" "Fighting" "Rock"]
               :fast-attacks   ["Frost Breath" "Ice Shard"]
               :weight         "220.0 kg"
               :height         "2.5 m"}

          132 {:pokemon-id     132
               :name           "Ditto"
               :classification "Transform Pokémon"
               :type-1         ["Normal"]
               :weaknesses     ["Fighting"]
               :fast-attacks   ["Unknown"]
               :special-attack ["Unknown"]
               :weight         "4.0 kg"
               :height         "0.3 m"}

          133 {:pokemon-id                  133
               :name                        "Eevee"
               :classification              "Evolution Pokémon"
               :type-1                      ["Normal"]
               :weaknesses                  ["Fighting"]
               :fast-attacks                ["Quick Attack" "Tackle"]
               :weight                      "6.5 kg"
               :height                      "0.3 m"
               :next-evolution-requirements {:amount 25
                                             :name   "Eevee candies"}
               :next-evolutions             [134 135 136]}

          134 {:pokemon-id          134
               :name                "Vaporeon"
               :classification      "Bubble Jet Pokémon"
               :type-1              ["Water"]
               :weaknesses          ["Electric" "Grass"]
               :fast-attacks        ["Water Gun" ""]
               :weight              "29.0 kg"
               :height              "1.0 m"
               :previous-evolutions [133]}

          135 {:pokemon-id          135
               :name                "Jolteon"
               :classification      "Lightning Pokémon"
               :type-1              ["Electric"]
               :weaknesses          ["Ground"]
               :fast-attacks        ["Thunder Shock" ""]
               :weight              "24.5 kg"
               :height              "0.8 m"
               :previous-evolutions [133]}

          136 {:pokemon-id          136
               :name                "Flareon"
               :classification      "Flame Pokémon"
               :type-1              ["Fire"]
               :weaknesses          ["Water" "Ground" "Rock"]
               :fast-attacks        ["Ember" ""]
               :weight              "25.0 kg"
               :height              "0.9 m"
               :previous-evolutions [133]}

          137 {:pokemon-id     137
               :name           "Porygon"
               :classification "Virtual Pokémon"
               :type-1         ["Normal"]
               :weaknesses     ["Fighting"]
               :fast-attacks   ["Quick Attack" "Tackle"]
               :weight         "36.5 kg"
               :height         "0.8 m"}

          138 {:pokemon-id                  138
               :name                        "Omanyte"
               :classification              "Spiral Pokémon"
               :type-1                      ["Rock"]
               :type-2                      ["Water"]
               :weaknesses                  ["Electric" "Grass" "Fighting" "Ground"]
               :fast-attacks                ["Water Gun" ""]
               :weight                      "7.5 kg"
               :height                      "0.4 m"
               :next-evolution-requirements {:amount 50
                                             :name   "Omanyte candies"}
               :next-evolutions             [139]}

          139 {:pokemon-id          139
               :name                "Omastar"
               :classification      "Spiral Pokémon"
               :type-1              ["Rock"]
               :type-2              ["Water"]
               :weaknesses          ["Electric" "Grass" "Fighting" "Ground"]
               :fast-attacks        ["Rock Throw" "Water Gun"]
               :weight              "35.0 kg"
               :height              "1.0 m"
               :previous-evolutions [138]}

          140 {:pokemon-id                  140
               :name                        "Kabuto"
               :classification              "Shellfish Pokémon"
               :type-1                      ["Rock"]
               :type-2                      ["Water"]
               :weaknesses                  ["Electric" "Grass" "Fighting" "Ground"]
               :fast-attacks                ["Mud Shot" "Scratch"]
               :weight                      "11.5 kg"
               :height                      "0.5 m"
               :next-evolution-requirements {:amount 50
                                             :name   "Kabuto candies"}
               :next-evolutions             [141]}

          141 {:pokemon-id          141
               :name                "Kabutops"
               :classification      "Shellfish Pokémon"
               :type-1              ["Rock"]
               :type-2              ["Water"]
               :weaknesses          ["Electric" "Grass" "Fighting" "Ground"]
               :fast-attacks        ["Fury Cutter" "Mud Shot"]
               :weight              "40.5 kg"
               :height              "1.3 m"
               :previous-evolutions [140]}

          142 {:pokemon-id     142
               :name           "Aerodactyl"
               :classification "Fossil Pokémon"
               :type-1         ["Rock"]
               :type-2         ["Flying"]
               :weaknesses     ["Water" "Electric" "Ice" "Rock" "Steel"]
               :fast-attacks   ["Bite" "Steel Wing"]
               :weight         "59.0 kg"
               :height         "1.8 m"}

          143 {:pokemon-id     143
               :name           "Snorlax"
               :classification "Sleeping Pokémon"
               :type-1         ["Normal"]
               :weaknesses     ["Fighting"]
               :fast-attacks   ["Lick" "Zen Headbutt"]
               :weight         "460.0 kg"
               :height         "2.1 m"}

          144 {:pokemon-id     144
               :name           "Articuno"
               :classification "Freeze Pokémon"
               :type-1         ["Ice"]
               :type-2         ["Flying"]
               :weaknesses     ["Fire" "Electric" "Rock" "Steel"]
               :fast-attacks   ["Unknown"]
               :special-attack ["Unknown"]
               :weight         "55.4 kg"
               :height         "1.7 m"}

          145 {:pokemon-id     145
               :name           "Zapdos"
               :classification "Electric Pokémon"
               :type-1         ["Electric"]
               :type-2         ["Flying"]
               :weaknesses     ["Ice" "Rock"]
               :fast-attacks   ["Unknown"]
               :special-attack ["Unknown"]
               :weight         "52.6 kg"
               :height         "1.6 m"}

          146 {:pokemon-id     146
               :name           "Moltres"
               :classification "Flame Pokémon"
               :type-1         ["Fire"]
               :type-2         ["Flying"]
               :weaknesses     ["Water" "Electric" "Rock"]
               :fast-attacks   ["Unknown"]
               :special-attack ["Unknown"]
               :weight         "60.0 kg"
               :height         "2.0 m"}

          147 {:pokemon-id                  147
               :name                        "Dratini"
               :classification              "Dragon Pokémon"
               :type-1                      ["Dragon"]
               :weaknesses                  ["Ice" "Dragon" "Fairy"]
               :fast-attacks                ["Dragon Breath" ""]
               :weight                      "3.3 kg"
               :height                      "1.8 m"
               :next-evolution-requirements {:amount 25
                                             :name   "Dratini candies"}}

          148 {:pokemon-id                  148
               :name                        "Dragonair"
               :classification              "Dragon Pokémon"
               :type-1                      ["Dragon"]
               :weaknesses                  ["Ice" "Dragon" "Fairy"]
               :fast-attacks                ["Dragon Breath"]
               :weight                      "16.5 kg"
               :height                      "4.0 m"
               :next-evolution-requirements {:amount 100
                                             :name   "Dratini candies"}
               :next-evolutions             [149]}

          149 {:pokemon-id          149
               :name                "Dragonite"
               :classification      "Dragon Pokémon"
               :type-1              ["Dragon"]
               :type-2              ["Flying"]
               :weaknesses          ["Ice" "Rock" "Dragon" "Fairy"]
               :fast-attacks        ["Dragon Breath" "Steel Wing"]
               :weight              "210.0 kg"
               :height              "2.2 m"
               :previous-evolutions [148]}

          150 {:pokemon-id     150
               :name           "Mewtwo"
               :classification "Genetic Pokémon"
               :type-1         ["Psychic"]
               :weaknesses     ["Bug" "Ghost" "Dark"]
               :fast-attacks   ["Unknown"]
               :special-attack ["Unknown"]
               :weight         "122.0 kg"
               :height         "2.0 m"}

          151 {:pokemon-id     151
               :name           "Mew"
               :classification "New Species Pokémon"
               :type-1         ["Psychic"]
               :weaknesses     ["Bug" "Ghost" "Dark"]
               :fast-attacks   ["Unknown"]
               :special-attack ["Unknown"]
               :weight         "4.0 kg"
               :height         "0.4 m"}})
