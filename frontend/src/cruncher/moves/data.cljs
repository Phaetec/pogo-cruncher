(ns cruncher.moves.data)

;; Taken from https://github.com/justinleewells/pogo-optimizer

(def all {13  {:damage-window-end-ms   3400
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2800
               :id                     13
               :power                  25
               :unique-id              "V0013_MOVE_WRAP"
               :duration-ms            4000
               :animation-id           5
               :vfx-name               "\"wrap\""
               :name                   "Wrap"
               :type                   "Normal"
               :critical-chance        0.05}
          14  {:damage-window-end-ms   4800
               :accuracy-change        1
               :stamina-loss-scalar    0.15
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 4000
               :id                     14
               :power                  120
               :unique-id              "V0014_MOVE_HYPER_BEAM"
               :duration-ms            5000
               :animation-id           5
               :vfx-name               "\"hyper_beam\""
               :name                   "Hyper Beam"
               :type                   "Normal"
               :critical-chance        0.05}
          16  {:damage-window-end-ms   3400
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2300
               :id                     16
               :power                  45
               :unique-id              "V0016_MOVE_Dark_PULSE"
               :duration-ms            3500
               :animation-id           5
               :vfx-name               "\"Dark_pulse\""
               :name                   "Dark Pulse"
               :type                   "Dark"
               :critical-chance        0.05}
          18  {:damage-window-end-ms   2350
               :accuracy-change        1
               :stamina-loss-scalar    0.065
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1850
               :id                     18
               :power                  25
               :unique-id              "V0018_MOVE_SLUDGE"
               :duration-ms            2600
               :animation-id           5
               :vfx-name               "\"sludge\""
               :name                   "Sludge"
               :type                   "Poison"
               :critical-chance        0.05}
          20  {:damage-window-end-ms   2100
               :accuracy-change        1
               :stamina-loss-scalar    0.055
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1850
               :id                     20
               :power                  15
               :unique-id              "V0020_MOVE_VIce_GRIP"
               :duration-ms            2100
               :animation-id           5
               :vfx-name               "\"vIce_grip\""
               :name                   "Vice Grip"
               :type                   "Normal"
               :critical-chance        0.05}
          21  {:damage-window-end-ms   3200
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2700
               :id                     21
               :power                  40
               :unique-id              "V0021_MOVE_FLAME_WHEEL"
               :duration-ms            4600
               :animation-id           5
               :vfx-name               "\"flame_wheel\""
               :name                   "Flame Wheel"
               :type                   "Fire"
               :critical-chance        0.05}
          22  {:damage-window-end-ms   2700
               :accuracy-change        1
               :stamina-loss-scalar    0.12
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2400
               :id                     22
               :power                  80
               :unique-id              "V0022_MOVE_MEGAHORN"
               :duration-ms            3200
               :animation-id           5
               :vfx-name               "\"megahorn\""
               :name                   "Megahorn"
               :type                   "Bug"
               :critical-chance        0.05}
          24  {:damage-window-end-ms   2600
               :accuracy-change        1
               :stamina-loss-scalar    0.09
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1700
               :id                     24
               :power                  55
               :unique-id              "V0024_MOVE_FLAMETHROWER"
               :duration-ms            2900
               :animation-id           5
               :vfx-name               "\"flamethrower\""
               :name                   "Flamethrower"
               :type                   "Fire"
               :critical-chance        0.05}
          26  {:damage-window-end-ms   5000
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 4600
               :id                     26
               :power                  70
               :unique-id              "V0026_MOVE_DIG"
               :duration-ms            5800
               :animation-id           5
               :vfx-name               "\"dig\""
               :name                   "Dig"
               :type                   "Ground"
               :critical-chance        0.05}
          28  {:damage-window-end-ms   1800
               :accuracy-change        1
               :stamina-loss-scalar    0.1
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1500
               :id                     28
               :power                  60
               :unique-id              "V0028_MOVE_CROSS_CHOP"
               :duration-ms            2000
               :animation-id           5
               :vfx-name               "\"cross_chop\""
               :name                   "Cross Chop"
               :type                   "Fighting"
               :critical-chance        0.25}
          30  {:damage-window-end-ms   3600
               :accuracy-change        1
               :stamina-loss-scalar    0.065
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2300
               :id                     30
               :power                  40
               :unique-id              "V0030_MOVE_PSYBEAM"
               :duration-ms            3800
               :animation-id           5
               :vfx-name               "\"psybeam\""
               :name                   "Psybeam"
               :type                   "Psychic"
               :critical-chance        0.05}
          31  {:damage-window-end-ms   3950
               :accuracy-change        1
               :stamina-loss-scalar    0.1
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2000
               :id                     31
               :power                  100
               :unique-id              "V0031_MOVE_EARTHQUAKE"
               :duration-ms            4200
               :animation-id           5
               :vfx-name               "\"earthquake\""
               :name                   "Earthquake"
               :type                   "Ground"
               :critical-chance        0.05}
          32  {:damage-window-end-ms   1800
               :accuracy-change        1
               :stamina-loss-scalar    0.1
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1400
               :id                     32
               :power                  80
               :unique-id              "V0032_MOVE_STONE_EDGE"
               :duration-ms            3100
               :animation-id           5
               :vfx-name               "\"stone_edge\""
               :name                   "Stone Edge"
               :type                   "Rock"
               :critical-chance        0.5}
          33  {:damage-window-end-ms   3200
               :accuracy-change        1
               :stamina-loss-scalar    0.075
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2100
               :id                     33
               :power                  45
               :unique-id              "V0033_MOVE_Ice_PUNCH"
               :duration-ms            3500
               :animation-id           5
               :vfx-name               "\"Ice_punch\""
               :name                   "Ice Punch"
               :type                   "Ice"
               :critical-chance        0.05}
          34  {:damage-window-end-ms   2250
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1950
               :id                     34
               :power                  20
               :unique-id              "V0034_MOVE_HEART_STAMP"
               :duration-ms            2550
               :animation-id           5
               :vfx-name               "\"heart_stamp\""
               :name                   "Heart Stamp"
               :type                   "Psychic"
               :critical-chance        0.05}
          35  {:damage-window-end-ms   2300
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1600
               :id                     35
               :power                  35
               :unique-id              "V0035_MOVE_DISCHARGE"
               :duration-ms            2500
               :animation-id           5
               :vfx-name               "\"discharge\""
               :name                   "Discharge"
               :type                   "Electric"
               :critical-chance        0.05}
          36  {:damage-window-end-ms   3500
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2400
               :id                     36
               :power                  60
               :unique-id              "V0036_MOVE_FLASH_CANNON"
               :duration-ms            3900
               :animation-id           5
               :vfx-name               "\"flash_cannon\""
               :name                   "Flash Cannon"
               :type                   "Steel"
               :critical-chance        0.05}
          38  {:damage-window-end-ms   2500
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1600
               :id                     38
               :power                  40
               :unique-id              "V0038_MOVE_DRILL_PECK"
               :duration-ms            2700
               :animation-id           5
               :vfx-name               "\"drill_peck\""
               :name                   "Drill Peck"
               :type                   "Flying"
               :critical-chance        0.05}
          39  {:damage-window-end-ms   3500
               :accuracy-change        1
               :stamina-loss-scalar    0.09
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2150
               :id                     39
               :power                  50
               :unique-id              "V0039_MOVE_Ice_BEAM"
               :duration-ms            3650
               :animation-id           5
               :vfx-name               "\"Ice_beam\""
               :name                   "Ice Beam"
               :type                   "Ice"
               :critical-chance        0.05}
          40  {:damage-window-end-ms   3600
               :accuracy-change        1
               :stamina-loss-scalar    0.11
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 3600
               :id                     40
               :power                  100
               :unique-id              "V0040_MOVE_BLIZZARD"
               :duration-ms            3900
               :animation-id           5
               :vfx-name               "\"blizzard\""
               :name                   "Blizzard"
               :type                   "Ice"
               :critical-chance        0.05}
          42  {:damage-window-end-ms   3400
               :accuracy-change        1
               :stamina-loss-scalar    0.095
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 3000
               :id                     42
               :power                  80
               :unique-id              "V0042_MOVE_HEAT_WAVE"
               :duration-ms            3800
               :animation-id           5
               :vfx-name               "\"heat_wave\""
               :name                   "Heat Wave"
               :type                   "Fire"
               :critical-chance        0.05}
          45  {:damage-window-end-ms   2600
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2000
               :id                     45
               :power                  30
               :unique-id              "V0045_MOVE_AERIAL_ACE"
               :duration-ms            2900
               :animation-id           5
               :vfx-name               "\"aerial_ace\""
               :name                   "Aerial Ace"
               :type                   "Flying"
               :critical-chance        0.05}
          46  {:damage-window-end-ms   2800
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2100
               :id                     46
               :power                  50
               :unique-id              "V0046_MOVE_DRILL_RUN"
               :duration-ms            3400
               :animation-id           5
               :vfx-name               "\"drill_run\""
               :name                   "Drill Run"
               :type                   "Ground"
               :critical-chance        0.25}
          47  {:damage-window-end-ms   3100
               :accuracy-change        1
               :stamina-loss-scalar    0.09
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2100
               :id                     47
               :power                  65
               :unique-id              "V0047_MOVE_PETAL_BLIZZARD"
               :duration-ms            3200
               :animation-id           5
               :vfx-name               "\"petal_blizzard\""
               :name                   "Petal Blizzard"
               :type                   "Grass"
               :critical-chance        0.05}
          48  {:damage-window-end-ms   2600
               :accuracy-change        1
               :stamina-loss-scalar    0.04
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1400
               :id                     48
               :power                  15
               :unique-id              "V0048_MOVE_MEGA_DRAIN"
               :duration-ms            3200
               :animation-id           5
               :vfx-name               "\"mega_drain\""
               :name                   "Mega Drain"
               :type                   "Grass"
               :critical-chance        0.05
               :HealScalar             0.5}
          49  {:damage-window-end-ms   4100
               :accuracy-change        1
               :stamina-loss-scalar    0.09
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2600
               :id                     49
               :power                  75
               :unique-id              "V0049_MOVE_Bug_BUZZ"
               :duration-ms            4250
               :animation-id           5
               :vfx-name               "\"Bug_buzz\""
               :name                   "Bug Buzz"
               :type                   "Bug"
               :critical-chance        0.05}
          50  {:damage-window-end-ms   1850
               :accuracy-change        1
               :stamina-loss-scalar    0.05
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1650
               :id                     50
               :power                  25
               :unique-id              "V0050_MOVE_Poison_FANG"
               :duration-ms            2400
               :animation-id           5
               :vfx-name               "\"Poison_fang\""
               :name                   "Poison Fang"
               :type                   "Poison"
               :critical-chance        0.05}
          51  {:damage-window-end-ms   2600
               :accuracy-change        1
               :stamina-loss-scalar    0.07
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2400
               :id                     51
               :power                  30
               :unique-id              "V0051_MOVE_NIGHT_SLASH"
               :duration-ms            2700
               :animation-id           5
               :vfx-name               "\"night_slash\""
               :name                   "Night Slash"
               :type                   "Dark"
               :critical-chance        0.25}
          53  {:damage-window-end-ms   2800
               :accuracy-change        1
               :stamina-loss-scalar    0.065
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2600
               :id                     53
               :power                  30
               :unique-id              "V0053_MOVE_BUBBLE_BEAM"
               :duration-ms            2900
               :animation-id           5
               :vfx-name               "\"bubble_beam\""
               :name                   "Bubble Beam"
               :type                   "Water"
               :critical-chance        0.05}
          54  {:damage-window-end-ms   2000
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1850
               :id                     54
               :power                  30
               :unique-id              "V0054_MOVE_SUBMISSION"
               :duration-ms            2100
               :animation-id           5
               :vfx-name               "\"submission\""
               :name                   "Submission"
               :type                   "Fighting"
               :critical-chance        0.05}
          56  {:damage-window-end-ms   2150
               :accuracy-change        1
               :stamina-loss-scalar    0.065
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2000
               :id                     56
               :power                  25
               :unique-id              "V0056_MOVE_LOW_SWEEP"
               :duration-ms            2250
               :animation-id           5
               :vfx-name               "\"low_sweep\""
               :name                   "Low Sweep"
               :type                   "Fighting"
               :critical-chance        0.05}
          57  {:damage-window-end-ms   2100
               :accuracy-change        1
               :stamina-loss-scalar    0.04
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1700
               :id                     57
               :power                  25
               :unique-id              "V0057_MOVE_AQUA_JET"
               :duration-ms            2350
               :animation-id           5
               :vfx-name               "\"aqua_jet\""
               :name                   "Aqua Jet"
               :type                   "Water"
               :critical-chance        0.05}
          58  {:damage-window-end-ms   2250
               :accuracy-change        1
               :stamina-loss-scalar    0.09
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2050
               :id                     58
               :power                  45
               :unique-id              "V0058_MOVE_AQUA_TAIL"
               :duration-ms            2350
               :animation-id           5
               :vfx-name               "\"aqua_tail\""
               :name                   "Aqua Tail"
               :type                   "Water"
               :critical-chance        0.05}
          59  {:damage-window-end-ms   1800
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1300
               :id                     59
               :power                  40
               :unique-id              "V0059_MOVE_SEED_BOMB"
               :duration-ms            2400
               :animation-id           5
               :vfx-name               "\"seed_bomb\""
               :name                   "Seed Bomb"
               :type                   "Grass"
               :critical-chance        0.05}
          60  {:damage-window-end-ms   2700
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2200
               :id                     60
               :power                  40
               :unique-id              "V0060_MOVE_PSYSHOCK"
               :duration-ms            2700
               :animation-id           5
               :vfx-name               "\"psyshock\""
               :name                   "Psyshock"
               :type                   "Psychic"
               :critical-chance        0.05}
          62  {:damage-window-end-ms   3250
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2900
               :id                     62
               :power                  35
               :unique-id              "V0062_MOVE_ANCIENT_POWER"
               :duration-ms            3600
               :animation-id           5
               :vfx-name               "\"ancient_power\""
               :name                   "Ancient Power"
               :type                   "Rock"
               :critical-chance        0.05}
          63  {:damage-window-end-ms   3200
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2300
               :id                     63
               :power                  25
               :unique-id              "V0063_MOVE_Rock_TOMB"
               :duration-ms            3400
               :animation-id           5
               :vfx-name               "\"Rock_tomb\""
               :name                   "Rock Tomb"
               :type                   "Rock"
               :critical-chance        0.25}
          64  {:damage-window-end-ms   2900
               :accuracy-change        1
               :stamina-loss-scalar    0.075
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1500
               :id                     64
               :power                  40
               :unique-id              "V0064_MOVE_Rock_SLIDE"
               :duration-ms            3200
               :animation-id           5
               :vfx-name               "\"Rock_slide\""
               :name                   "Rock Slide"
               :type                   "Rock"
               :critical-chance        0.05}
          65  {:damage-window-end-ms   2800
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2000
               :id                     65
               :power                  40
               :unique-id              "V0065_MOVE_POWER_GEM"
               :duration-ms            2900
               :animation-id           5
               :vfx-name               "\"power_gem\""
               :name                   "Power Gem"
               :type                   "Rock"
               :critical-chance        0.05}
          66  {:damage-window-end-ms   2900
               :accuracy-change        1
               :stamina-loss-scalar    0.04
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2300
               :id                     66
               :power                  15
               :unique-id              "V0066_MOVE_SHADOW_SNEAK"
               :duration-ms            3100
               :animation-id           5
               :vfx-name               "\"shadow_sneak\""
               :name                   "Shadow Sneak"
               :type                   "Ghost"
               :critical-chance        0.05}
          67  {:damage-window-end-ms   1700
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1400
               :id                     67
               :power                  20
               :unique-id              "V0067_MOVE_SHADOW_PUNCH"
               :duration-ms            2100
               :animation-id           5
               :vfx-name               "\"shadow_punch\""
               :name                   "Shadow Punch"
               :type                   "Ghost"
               :critical-chance        0.05}
          69  {:damage-window-end-ms   2100
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1850
               :id                     69
               :power                  30
               :unique-id              "V0069_MOVE_OMINOUS_WIND"
               :duration-ms            3100
               :animation-id           5
               :vfx-name               "\"ominous_wind\""
               :name                   "Ominous Wind"
               :type                   "Ghost"
               :critical-chance        0.05}
          70  {:damage-window-end-ms   2600
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2300
               :id                     70
               :power                  40
               :unique-id              "V0070_MOVE_SHADOW_BALL"
               :duration-ms            3080
               :animation-id           5
               :vfx-name               "\"shadow_ball\""
               :name                   "Shadow Ball"
               :type                   "Ghost"
               :critical-chance        0.05}
          72  {:damage-window-end-ms   2300
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1750
               :id                     72
               :power                  30
               :unique-id              "V0072_MOVE_MAGNET_BOMB"
               :duration-ms            2800
               :animation-id           5
               :vfx-name               "\"magnet_bomb\""
               :name                   "Magnet Bomb"
               :type                   "Steel"
               :critical-chance        0.05}
          74  {:damage-window-end-ms   1800
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1550
               :id                     74
               :power                  30
               :unique-id              "V0074_MOVE_IRON_HEAD"
               :duration-ms            2000
               :animation-id           5
               :vfx-name               "\"iron_head\""
               :name                   "Iron Head"
               :type                   "Steel"
               :critical-chance        0.05}
          75  {:damage-window-end-ms   1700
               :accuracy-change        1
               :stamina-loss-scalar    0.05
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1300
               :id                     75
               :power                  15
               :unique-id              "V0075_MOVE_PARABOLIC_CHARGE"
               :duration-ms            2100
               :animation-id           5
               :vfx-name               "\"parabolic_charge\""
               :name                   "Parabolic Charge"
               :type                   "Electric"
               :critical-chance        0.05
               :HealScalar             0.5}
          77  {:damage-window-end-ms   2200
               :accuracy-change        1
               :stamina-loss-scalar    0.075
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1950
               :id                     77
               :power                  40
               :unique-id              "V0077_MOVE_THUNDER_PUNCH"
               :duration-ms            2400
               :animation-id           5
               :vfx-name               "\"thunder_punch\""
               :name                   "Thunder Punch"
               :type                   "Electric"
               :critical-chance        0.05}
          78  {:damage-window-end-ms   4100
               :accuracy-change        1
               :stamina-loss-scalar    0.11
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2550
               :id                     78
               :power                  100
               :unique-id              "V0078_MOVE_THUNDER"
               :duration-ms            4300
               :animation-id           5
               :vfx-name               "\"thunder\""
               :name                   "Thunder"
               :type                   "Electric"
               :critical-chance        0.05}
          79  {:damage-window-end-ms   2700
               :accuracy-change        1
               :stamina-loss-scalar    0.09
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1900
               :id                     79
               :power                  55
               :unique-id              "V0079_MOVE_THUNDERBOLT"
               :duration-ms            2700
               :animation-id           5
               :vfx-name               "\"thunderbolt\""
               :name                   "Thunderbolt"
               :type                   "Electric"
               :critical-chance        0.05}
          80  {:damage-window-end-ms   2600
               :accuracy-change        1
               :stamina-loss-scalar    0.04
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 850
               :id                     80
               :power                  25
               :unique-id              "V0080_MOVE_TWISTER"
               :duration-ms            2700
               :animation-id           5
               :vfx-name               "\"twister\""
               :name                   "Twister"
               :type                   "Dragon"
               :critical-chance        0.05}
          82  {:damage-window-end-ms   3300
               :accuracy-change        1
               :stamina-loss-scalar    0.085
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2100
               :id                     82
               :power                  65
               :unique-id              "V0082_MOVE_Dragon_PULSE"
               :duration-ms            3600
               :animation-id           5
               :vfx-name               "\"Dragon_pulse\""
               :name                   "Dragon Pulse"
               :type                   "Dragon"
               :critical-chance        0.05}
          83  {:damage-window-end-ms   1400
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1200
               :id                     83
               :power                  35
               :unique-id              "V0083_MOVE_Dragon_CLAW"
               :duration-ms            1500
               :animation-id           5
               :vfx-name               "\"Dragon_claw\""
               :name                   "Dragon Claw"
               :type                   "Dragon"
               :critical-chance        0.25}
          84  {:damage-window-end-ms   3600
               :accuracy-change        1
               :stamina-loss-scalar    0.04
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1800
               :id                     84
               :power                  25
               :unique-id              "V0084_MOVE_DISARMING_VOIce"
               :duration-ms            3900
               :animation-id           5
               :vfx-name               "\"disarming_voIce\""
               :name                   "Disarming Voice"
               :type                   "Fairy"
               :critical-chance        0.05}
          85  {:damage-window-end-ms   1100
               :accuracy-change        1
               :stamina-loss-scalar    0.05
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1000
               :id                     85
               :power                  25
               :unique-id              "V0085_MOVE_DRAINING_KISS"
               :duration-ms            2800
               :animation-id           5
               :vfx-name               "\"draining_kiss\""
               :name                   "Draining Kiss"
               :type                   "Fairy"
               :critical-chance        0.05
               :HealScalar             1}
          86  {:damage-window-end-ms   4100
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 3300
               :id                     86
               :power                  55
               :unique-id              "V0086_MOVE_DAZZLING_GLEAM"
               :duration-ms            4200
               :animation-id           5
               :vfx-name               "\"dazzling_gleam\""
               :name                   "Dazzling Gleam"
               :type                   "Fairy"
               :critical-chance        0.05}
          87  {:damage-window-end-ms   4100
               :accuracy-change        1
               :stamina-loss-scalar    0.095
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 3500
               :id                     87
               :power                  80
               :unique-id              "V0087_MOVE_MOONBLAST"
               :duration-ms            4100
               :animation-id           5
               :vfx-name               "\"moonblast\""
               :name                   "Moonblast"
               :type                   "Fairy"
               :critical-chance        0.05}
          88  {:damage-window-end-ms   2700
               :accuracy-change        1
               :stamina-loss-scalar    0.1
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1400
               :id                     88
               :power                  55
               :unique-id              "V0088_MOVE_PLAY_ROUGH"
               :duration-ms            2900
               :animation-id           5
               :vfx-name               "\"play_rough\""
               :name                   "Play Rough"
               :type                   "Fairy"
               :critical-chance        0.05}
          89  {:damage-window-end-ms   1500
               :accuracy-change        1
               :stamina-loss-scalar    0.07
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1200
               :id                     89
               :power                  25
               :unique-id              "V0089_MOVE_CROSS_Poison"
               :duration-ms            1500
               :animation-id           5
               :vfx-name               "\"cross_Poison\""
               :name                   "Cross Poison"
               :type                   "Poison"
               :critical-chance        0.25}
          90  {:damage-window-end-ms   2450
               :accuracy-change        1
               :stamina-loss-scalar    0.09
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1950
               :id                     90
               :power                  55
               :unique-id              "V0090_MOVE_SLUDGE_BOMB"
               :duration-ms            2600
               :animation-id           5
               :vfx-name               "\"sludge_bomb\""
               :name                   "Sludge Bomb"
               :type                   "Poison"
               :critical-chance        0.05}
          91  {:damage-window-end-ms   3300
               :accuracy-change        1
               :stamina-loss-scalar    0.095
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2400
               :id                     91
               :power                  60
               :unique-id              "V0091_MOVE_SLUDGE_WAVE"
               :duration-ms            3400
               :animation-id           5
               :vfx-name               "\"sludge_wave\""
               :name                   "Sludge Wave"
               :type                   "Poison"
               :critical-chance        0.05}
          92  {:damage-window-end-ms   2400
               :accuracy-change        1
               :stamina-loss-scalar    0.12
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2000
               :id                     92
               :power                  65
               :unique-id              "V0092_MOVE_GUNK_SHOT"
               :duration-ms            3000
               :animation-id           5
               :vfx-name               "\"gunk_shot\""
               :name                   "Gunk Shot"
               :type                   "Poison"
               :critical-chance        0.05}
          94  {:damage-window-end-ms   1500
               :accuracy-change        1
               :stamina-loss-scalar    0.065
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1250
               :id                     94
               :power                  20
               :unique-id              "V0094_MOVE_BONE_CLUB"
               :duration-ms            1600
               :animation-id           5
               :vfx-name               "\"bone_club\""
               :name                   "Bone Club"
               :type                   "Ground"
               :critical-chance        0.05}
          95  {:damage-window-end-ms   3000
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1900
               :id                     95
               :power                  35
               :unique-id              "V0095_MOVE_BULLDOZE"
               :duration-ms            3400
               :animation-id           5
               :vfx-name               "\"bulldoze\""
               :name                   "Bulldoze"
               :type                   "Ground"
               :critical-chance        0.05}
          96  {:damage-window-end-ms   2500
               :accuracy-change        1
               :stamina-loss-scalar    0.065
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2050
               :id                     96
               :power                  30
               :unique-id              "V0096_MOVE_MUD_BOMB"
               :duration-ms            2600
               :animation-id           5
               :vfx-name               "\"mud_bomb\""
               :name                   "Mud Bomb"
               :type                   "Ground"
               :critical-chance        0.05}
          99  {:damage-window-end-ms   3000
               :accuracy-change        1
               :stamina-loss-scalar    0.075
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2000
               :id                     99
               :power                  35
               :unique-id              "V0099_MOVE_SIGNAL_BEAM"
               :duration-ms            3100
               :animation-id           5
               :vfx-name               "\"signal_beam\""
               :name                   "Signal Beam"
               :type                   "Bug"
               :critical-chance        0.05}
          100 {:damage-window-end-ms   1600
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1350
               :id                     100
               :power                  35
               :unique-id              "V0100_MOVE_X_SCISSOR"
               :duration-ms            2100
               :animation-id           5
               :vfx-name               "\"x_scissor\""
               :name                   "X-Scissor"
               :type                   "Bug"
               :critical-chance        0.05}
          101 {:damage-window-end-ms   2900
               :accuracy-change        1
               :stamina-loss-scalar    0.05
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2700
               :id                     101
               :power                  20
               :unique-id              "V0101_MOVE_FLAME_CHARGE"
               :duration-ms            3100
               :animation-id           5
               :vfx-name               "\"flame_charge\""
               :name                   "Flame Charge"
               :type                   "Fire"
               :critical-chance        0.05}
          102 {:damage-window-end-ms   1600
               :accuracy-change        1
               :stamina-loss-scalar    0.07
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1200
               :id                     102
               :power                  25
               :unique-id              "V0102_MOVE_FLAME_BURST"
               :duration-ms            2100
               :animation-id           5
               :vfx-name               "\"flame_burst\""
               :name                   "Flame Burst"
               :type                   "Fire"
               :critical-chance        0.05}
          103 {:damage-window-end-ms   4000
               :accuracy-change        1
               :stamina-loss-scalar    0.11
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 3600
               :id                     103
               :power                  100
               :unique-id              "V0103_MOVE_Fire_BLAST"
               :duration-ms            4100
               :animation-id           5
               :vfx-name               "\"Fire_blast\""
               :name                   "Fire Blast"
               :type                   "Fire"
               :critical-chance        0.05}
          104 {:damage-window-end-ms   2000
               :accuracy-change        1
               :stamina-loss-scalar    0.065
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1650
               :id                     104
               :power                  25
               :unique-id              "V0104_MOVE_BRINE"
               :duration-ms            2400
               :animation-id           5
               :vfx-name               "\"brine\""
               :name                   "Brine"
               :type                   "Water"
               :critical-chance        0.05}
          105 {:damage-window-end-ms   2900
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1900
               :id                     105
               :power                  35
               :unique-id              "V0105_MOVE_Water_PULSE"
               :duration-ms            3300
               :animation-id           5
               :vfx-name               "\"Water_pulse\""
               :name                   "Water Pulse"
               :type                   "Water"
               :critical-chance        0.05}
          106 {:damage-window-end-ms   3900
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1800
               :id                     106
               :power                  35
               :unique-id              "V0106_MOVE_SCALD"
               :duration-ms            4000
               :animation-id           5
               :vfx-name               "\"scald\""
               :name                   "Scald"
               :type                   "Water"
               :critical-chance        0.05}
          107 {:damage-window-end-ms   3600
               :accuracy-change        1
               :stamina-loss-scalar    0.11
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1500
               :id                     107
               :power                  60
               :unique-id              "V0107_MOVE_HYDRO_PUMP"
               :duration-ms            3800
               :animation-id           5
               :vfx-name               "\"hydro_pump\""
               :name                   "Hydro Pump"
               :type                   "Water"
               :critical-chance        0.05}
          108 {:damage-window-end-ms   2800
               :accuracy-change        1
               :stamina-loss-scalar    0.09
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1600
               :id                     108
               :power                  55
               :unique-id              "V0108_MOVE_Psychic"
               :duration-ms            2800
               :animation-id           5
               :vfx-name               "\"Psychic\""
               :name                   "Psychic"
               :type                   "Psychic"
               :critical-chance        0.05}
          109 {:damage-window-end-ms   5300
               :accuracy-change        1
               :stamina-loss-scalar    0.1
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 4400
               :id                     109
               :power                  70
               :unique-id              "V0109_MOVE_PSYSTRIKE"
               :duration-ms            5100
               :animation-id           5
               :vfx-name               "\"psystrike\""
               :name                   "Psystrike"
               :type                   "Psychic"
               :critical-chance        0.05}
          111 {:damage-window-end-ms   2700
               :accuracy-change        1
               :stamina-loss-scalar    0.055
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2000
               :id                     111
               :power                  25
               :unique-id              "V0111_MOVE_ICY_WIND"
               :duration-ms            3800
               :animation-id           5
               :vfx-name               "\"icy_wind\""
               :name                   "Icy Wind"
               :type                   "Ice"
               :critical-chance        0.05}
          114 {:damage-window-end-ms   1500
               :accuracy-change        1
               :stamina-loss-scalar    0.075
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 350
               :id                     114
               :power                  35
               :unique-id              "V0114_MOVE_GIGA_DRAIN"
               :duration-ms            3600
               :animation-id           5
               :vfx-name               "\"giga_drain\""
               :name                   "Giga Drain"
               :type                   "Grass"
               :critical-chance        0.05
               :HealScalar             0.5}
          115 {:damage-window-end-ms   2200
               :accuracy-change        1
               :stamina-loss-scalar    0.075
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1690
               :id                     115
               :power                  40
               :unique-id              "V0115_MOVE_Fire_PUNCH"
               :duration-ms            2800
               :animation-id           5
               :vfx-name               "\"Fire_punch\""
               :name                   "Fire Punch"
               :type                   "Fire"
               :critical-chance        0.05}
          116 {:damage-window-end-ms   4800
               :accuracy-change        1
               :stamina-loss-scalar    0.12
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 3100
               :id                     116
               :power                  120
               :unique-id              "V0116_MOVE_SOLAR_BEAM"
               :duration-ms            4900
               :animation-id           5
               :vfx-name               "\"solar_beam\""
               :name                   "Solar Beam"
               :type                   "Grass"
               :critical-chance        0.05}
          117 {:damage-window-end-ms   2200
               :accuracy-change        1
               :stamina-loss-scalar    0.09
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1200
               :id                     117
               :power                  55
               :unique-id              "V0117_MOVE_LEAF_BLADE"
               :duration-ms            2800
               :animation-id           5
               :vfx-name               "\"leaf_blade\""
               :name                   "Leaf Blade"
               :type                   "Grass"
               :critical-chance        0.25}
          118 {:damage-window-end-ms   2800
               :accuracy-change        1
               :stamina-loss-scalar    0.12
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1500
               :id                     118
               :power                  70
               :unique-id              "V0118_MOVE_POWER_WHIP"
               :duration-ms            2800
               :animation-id           5
               :vfx-name               "\"power_whip\""
               :name                   "Power Whip"
               :type                   "Grass"}
          121 {:damage-window-end-ms   3100
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2200
               :id                     121
               :power                  30
               :unique-id              "V0121_MOVE_AIR_CUTTER"
               :duration-ms            3300
               :animation-id           5
               :vfx-name               "\"air_cutter\""
               :name                   "Air Cutter"
               :type                   "Flying"
               :critical-chance        0.25}
          122 {:damage-window-end-ms   2800
               :accuracy-change        1
               :stamina-loss-scalar    0.11
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1030
               :id                     122
               :power                  80
               :unique-id              "V0122_MOVE_HURRICANE"
               :duration-ms            3200
               :animation-id           5
               :vfx-name               "\"hurricane\""
               :name                   "Hurricane"
               :type                   "Flying"
               :critical-chance        0.05}
          123 {:damage-window-end-ms   1500
               :accuracy-change        1
               :stamina-loss-scalar    0.075
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1100
               :id                     123
               :power                  30
               :unique-id              "V0123_MOVE_BRICK_BREAK"
               :duration-ms            1600
               :animation-id           5
               :vfx-name               "\"brick_break\""
               :name                   "Brick Break"
               :type                   "Fighting"
               :critical-chance        0.25}
          125 {:damage-window-end-ms   2800
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2300
               :id                     125
               :power                  25
               :unique-id              "V0125_MOVE_SWIFT"
               :duration-ms            3000
               :animation-id           5
               :vfx-name               "\"swift\""
               :name                   "Swift"
               :type                   "Normal"
               :critical-chance        0.05}
          126 {:damage-window-end-ms   1900
               :accuracy-change        1
               :stamina-loss-scalar    0.065
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1600
               :id                     126
               :power                  20
               :unique-id              "V0126_MOVE_HORN_ATTACK"
               :duration-ms            2200
               :animation-id           5
               :vfx-name               "\"horn_attack\""
               :name                   "Horn Attack"
               :type                   "Normal"
               :critical-chance        0.05}
          127 {:damage-window-end-ms   1900
               :accuracy-change        1
               :stamina-loss-scalar    0.065
               :energy-delta           -25
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1200
               :id                     127
               :power                  30
               :unique-id              "V0127_MOVE_STOMP"
               :duration-ms            2100
               :animation-id           5
               :vfx-name               "\"stomp\""
               :name                   "Stomp"
               :type                   "Normal"
               :critical-chance        0.05}
          129 {:damage-window-end-ms   2000
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1700
               :id                     129
               :power                  35
               :unique-id              "V0129_MOVE_HYPER_FANG"
               :duration-ms            2100
               :animation-id           5
               :vfx-name               "\"hyper_fang\""
               :name                   "Hyper Fang"
               :type                   "Normal"
               :critical-chance        0.05}
          131 {:damage-window-end-ms   1300
               :accuracy-change        1
               :stamina-loss-scalar    0.085
               :energy-delta           -50
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1100
               :id                     131
               :power                  40
               :unique-id              "V0131_MOVE_BODY_SLAM"
               :duration-ms            1560
               :animation-id           5
               :vfx-name               "\"body_slam\""
               :name                   "Body Slam"
               :type                   "Normal"
               {132 :critical-chance}  0.05}
          132 {:damage-window-end-ms   2691
               :accuracy-change        1
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1395
               :id                     132
               :power                  35
               :unique-id              "V0132_MOVE_REST"
               :duration-ms            3100
               :animation-id           5
               :vfx-name               "\"rest\""
               :name                   "Rest"
               :type                   "Normal"
               :HealScalar             1}
          133 {:damage-window-end-ms   1500
               :accuracy-change        1
               :stamina-loss-scalar    0.1
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 800
               :id                     133
               :power                  15
               :unique-id              "V0133_MOVE_STRUGGLE"
               :duration-ms            1695
               :animation-id           5
               :vfx-name               "\"struggle\""
               :name                   "Struggle"
               :type                   "Normal"}
          134 {:damage-window-end-ms   3900
               :accuracy-change        1
               :stamina-loss-scalar    0.08
               :energy-delta           -33
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1800
               :id                     134
               :power                  35
               :unique-id              "V0134_MOVE_SCALD_BLASTOISE"
               :duration-ms            4000
               :animation-id           5
               :vfx-name               "\"scald_blastoise\""
               :name                   "Scald Blastoise"
               :type                   "Water"
               :critical-chance        0.05}
          135 {:damage-window-end-ms   3600
               :accuracy-change        1
               :stamina-loss-scalar    0.11
               :energy-delta           -100
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1500
               :id                     135
               :power                  90
               :unique-id              "V0135_MOVE_HYDRO_PUMP_BLASTOISE"
               :duration-ms            3800
               :animation-id           5
               :vfx-name               "\"hydro_pump_blastoise\""
               :name                   "Hydro Pump"
               :type                   "Water"
               :critical-chance        0.05}
          136 {:damage-window-end-ms   3200
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2200
               :id                     136
               :power                  25
               :unique-id              "V0136_MOVE_WRAP_GREEN"
               :duration-ms            3700
               :animation-id           5
               :vfx-name               "\"wrap_green\""
               :name                   "Wrap Green"
               :type                   "Normal"
               :critical-chance        0.05}
          137 {:damage-window-end-ms   3200
               :accuracy-change        1
               :stamina-loss-scalar    0.06
               :energy-delta           -20
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2200
               :id                     137
               :power                  25
               :unique-id              "V0137_MOVE_WRAP_PINK"
               :duration-ms            3700
               :animation-id           5
               :vfx-name               "\"wrap_pink\""
               :name                   "Wrap Pink"
               :type                   "Normal"
               :critical-chance        0.05}
          200 {:damage-window-end-ms   400
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           12
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 200
               :id                     200
               :power                  3
               :unique-id              "V0200_MOVE_FURY_CUTTER_FAST"
               :duration-ms            400
               :animation-id           4
               :vfx-name               "\"fury_cutter_fast\""
               :name                   "Fury Cutter"
               :type                   "Bug"}
          201 {:damage-window-end-ms   450
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 250
               :id                     201
               :power                  5
               :unique-id              "V0201_MOVE_Bug_BITE_FAST"
               :duration-ms            450
               :animation-id           4
               :vfx-name               "\"Bug_bite_fast\""
               :name                   "Bug Bite"
               :type                   "Bug"}
          202 {:damage-window-end-ms   500
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 300
               :id                     202
               :power                  6
               :unique-id              "V0202_MOVE_BITE_FAST"
               :duration-ms            500
               :animation-id           4
               :vfx-name               "\"bite_fast\""
               :name                   "Bite"
               :type                   "Dark"}
          203 {:damage-window-end-ms   700
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           4
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 500
               :id                     203
               :power                  7
               :unique-id              "V0203_MOVE_SUCKER_PUNCH_FAST"
               :duration-ms            700
               :animation-id           4
               :vfx-name               "\"sucker_punch_fast\""
               :name                   "Sucker Punch"
               :type                   "Dark"}
          204 {:damage-window-end-ms   500
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 300
               :id                     204
               :power                  6
               :unique-id              "V0204_MOVE_Dragon_BREATH_FAST"
               :duration-ms            500
               :animation-id           4
               :vfx-name               "\"Dragon_breath_fast\""
               :name                   "Dragon Breath"
               :type                   "Dragon"}
          205 {:damage-window-end-ms   600
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 400
               :id                     205
               :power                  5
               :unique-id              "V0205_MOVE_THUNDER_SHOCK_FAST"
               :duration-ms            600
               :animation-id           4
               :vfx-name               "\"thunder_shock_fast\""
               :name                   "Thunder Shock"
               :type                   "Electric"}
          206 {:damage-window-end-ms   700
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           4
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 500
               :id                     206
               :power                  7
               :unique-id              "V0206_MOVE_SPARK_FAST"
               :duration-ms            700
               :animation-id           4
               :vfx-name               "\"spark_fast\""
               :name                   "Spark"
               :type                   "Electric"}
          207 {:damage-window-end-ms   600
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 400
               :id                     207
               :power                  5
               :unique-id              "V0207_MOVE_LOW_KICK_FAST"
               :duration-ms            600
               :animation-id           4
               :vfx-name               "\"low_kick_fast\""
               :name                   "Low Kick"
               :type                   "Fighting"}
          208 {:damage-window-end-ms   800
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 600
               :id                     208
               :power                  6
               :unique-id              "V0208_MOVE_KARATE_CHOP_FAST"
               :duration-ms            800
               :animation-id           4
               :vfx-name               "\"karate_chop_fast\""
               :name                   "Karate Chop"
               :type                   "Fighting"}
          209 {:damage-window-end-ms   1050
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 850
               :id                     209
               :power                  10
               :unique-id              "V0209_MOVE_EMBER_FAST"
               :duration-ms            1050
               :animation-id           4
               :vfx-name               "\"ember_fast\""
               :name                   "Ember"
               :type                   "Fire"}
          210 {:damage-window-end-ms   750
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 550
               :id                     210
               :power                  9
               :unique-id              "V0210_MOVE_WING_ATTACK_FAST"
               :duration-ms            750
               :animation-id           4
               :vfx-name               "\"wing_attack_fast\""
               :name                   "Wing Attack"
               :type                   "Flying"}
          211 {:damage-window-end-ms   1150
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           10
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 950
               :id                     211
               :power                  10
               :unique-id              "V0211_MOVE_PECK_FAST"
               :duration-ms            1150
               :animation-id           4
               :vfx-name               "\"peck_fast\""
               :name                   "Peck"
               :type                   "Flying"}
          212 {:damage-window-end-ms   500
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 300
               :id                     212
               :power                  5
               :unique-id              "V0212_MOVE_LICK_FAST"
               :duration-ms            500
               :animation-id           4
               :vfx-name               "\"lick_fast\""
               :name                   "Lick"
               :type                   "Ghost"}
          213 {:damage-window-end-ms   950
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 750
               :id                     213
               :power                  11
               :unique-id              "V0213_MOVE_SHADOW_CLAW_FAST"
               :duration-ms            950
               :animation-id           4
               :vfx-name               "\"shadow_claw_fast\""
               :name                   "Shadow Claw"
               :type                   "Ghost"}
          214 {:damage-window-end-ms   650
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 450
               :id                     214
               :power                  7
               :unique-id              "V0214_MOVE_VINE_WHIP_FAST"
               :duration-ms            650
               :animation-id           4
               :vfx-name               "\"vine_whip_fast\""
               :name                   "Vine Whip"
               :type                   "Grass"}
          215 {:damage-window-end-ms   1450
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1250
               :id                     215
               :power                  15
               :unique-id              "V0215_MOVE_RAZOR_LEAF_FAST"
               :duration-ms            1450
               :animation-id           4
               :vfx-name               "\"razor_leaf_fast\""
               :name                   "Razor Leaf"
               :type                   "Grass"}
          216 {:damage-window-end-ms   550
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 350
               :id                     216
               :power                  6
               :unique-id              "V0216_MOVE_MUD_SHOT_FAST"
               :duration-ms            550
               :animation-id           4
               :vfx-name               "\"mud_shot_fast\""
               :name                   "Mud Shot"
               :type                   "Ground"}
          217 {:damage-window-end-ms   1400
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1200
               :id                     217
               :power                  15
               :unique-id              "V0217_MOVE_Ice_SHARD_FAST"
               :duration-ms            1400
               :animation-id           4
               :vfx-name               "\"Ice_shard_fast\""
               :name                   "Ice Shard"
               :type                   "Ice"}
          218 {:damage-window-end-ms   810
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 610
               :id                     218
               :power                  9
               :unique-id              "V0218_MOVE_FROST_BREATH_FAST"
               :duration-ms            810
               :animation-id           4
               :vfx-name               "\"frost_breath_fast\""
               :name                   "Frost Breath"
               :type                   "Ice"}
          219 {:damage-window-end-ms   1330
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1130
               :id                     219
               :power                  10
               :unique-id              "V0219_MOVE_QUICK_ATTACK_FAST"
               :duration-ms            1330
               :animation-id           4
               :vfx-name               "\"quick_attack_fast\""
               :name                   "Quick Attack"
               :type                   "Normal"}
          220 {:damage-window-end-ms   500
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 300
               :id                     220
               :power                  6
               :unique-id              "V0220_MOVE_SCRATCH_FAST"
               :duration-ms            500
               :animation-id           4
               :vfx-name               "\"scratch_fast\""
               :name                   "Scratch"
               :type                   "Normal"}
          221 {:damage-window-end-ms   1100
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 900
               :id                     221
               :power                  12
               :unique-id              "V0221_MOVE_TACKLE_FAST"
               :duration-ms            1100
               :animation-id           4
               :vfx-name               "\"tackle_fast\""
               :name                   "Tackle"
               :type                   "Normal"}
          222 {:damage-window-end-ms   540
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 340
               :id                     222
               :power                  7
               :unique-id              "V0222_MOVE_POUND_FAST"
               :duration-ms            540
               :animation-id           4
               :vfx-name               "\"pound_fast\""
               :name                   "Pound"
               :type                   "Normal"}
          223 {:damage-window-end-ms   1130
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 930
               :id                     223
               :power                  12
               :unique-id              "V0223_MOVE_CUT_FAST"
               :duration-ms            1130
               :animation-id           4
               :vfx-name               "\"cut_fast\""
               :name                   "Cut"
               :type                   "Normal"}
          224 {:damage-window-end-ms   1050
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 850
               :id                     224
               :power                  12
               :unique-id              "V0224_MOVE_Poison_JAB_FAST"
               :duration-ms            1050
               :animation-id           4
               :vfx-name               "\"Poison_jab_fast\""
               :name                   "Poison Jab"
               :type                   "Poison"}
          225 {:damage-window-end-ms   1050
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 850
               :id                     225
               :power                  10
               :unique-id              "V0225_MOVE_ACID_FAST"
               :duration-ms            1050
               :animation-id           4
               :vfx-name               "\"acid_fast\""
               :name                   "Acid"
               :type                   "Poison"}
          226 {:damage-window-end-ms   570
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 370
               :id                     226
               :power                  7
               :unique-id              "V0226_MOVE_PSYCHO_CUT_FAST"
               :duration-ms            570
               :animation-id           4
               :vfx-name               "\"psycho_cut_fast\""
               :name                   "Psycho Cut"
               :type                   "Psychic"}
          227 {:damage-window-end-ms   1360
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1160
               :id                     227
               :power                  12
               :unique-id              "V0227_MOVE_Rock_THROW_FAST"
               :duration-ms            1360
               :animation-id           4
               :vfx-name               "\"Rock_throw_fast\""
               :name                   "Rock Throw"
               :type                   "Rock"}
          228 {:damage-window-end-ms   630
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 430
               :id                     228
               :power                  8
               :unique-id              "V0228_MOVE_METAL_CLAW_FAST"
               :duration-ms            630
               :animation-id           4
               :vfx-name               "\"metal_claw_fast\""
               :name                   "Metal Claw"
               :type                   "Steel"}
          229 {:damage-window-end-ms   1200
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1000
               :id                     229
               :power                  10
               :unique-id              "V0229_MOVE_BULLET_PUNCH_FAST"
               :duration-ms            1200
               :animation-id           4
               :vfx-name               "\"bullet_punch_fast\""
               :name                   "Bullet Punch"
               :type                   "Steel"}
          230 {:damage-window-end-ms   500
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 300
               :id                     230
               :power                  6
               :unique-id              "V0230_MOVE_Water_GUN_FAST"
               :duration-ms            500
               :animation-id           4
               :vfx-name               "\"Water_gun_fast\""
               :name                   "Water Gun"
               :type                   "Water"}
          231 {:damage-window-end-ms   1230
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1030
               :id                     231
               :unique-id              "V0231_MOVE_SPLASH_FAST"
               :duration-ms            1230
               :animation-id           4
               :vfx-name               "\"splash_fast\""
               :name                   "Splash"
               :type                   "Water"}
          232 {:damage-window-end-ms   500
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 300
               :id                     232
               :power                  6
               :unique-id              "V0232_MOVE_Water_GUN_FAST_BLASTOISE"
               :duration-ms            500
               :animation-id           4
               :vfx-name               "\"Water_gun_fast_blastoise\""
               :name                   "Water Gun"
               :type                   "Water"}
          233 {:damage-window-end-ms   1350
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           9
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1150
               :id                     233
               :power                  15
               :unique-id              "V0233_MOVE_MUD_SLAP_FAST"
               :duration-ms            1350
               :animation-id           4
               :vfx-name               "\"mud_slap_fast\""
               :name                   "Mud Slap"
               :type                   "Ground"}
          234 {:damage-window-end-ms   1050
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           4
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 850
               :id                     234
               :power                  12
               :unique-id              "V0234_MOVE_ZEN_HEADBUTT_FAST"
               :duration-ms            1050
               :animation-id           4
               :vfx-name               "\"zen_headbutt_fast\""
               :name                   "Zen Headbutt"
               :type                   "Psychic"}
          235 {:damage-window-end-ms   1510
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1310
               :id                     235
               :power                  15
               :unique-id              "V0235_MOVE_CONFUSION_FAST"
               :duration-ms            1510
               :animation-id           4
               :vfx-name               "\"confusion_fast\""
               :name                   "Confusion"
               :type                   "Psychic"}
          236 {:damage-window-end-ms   575
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           4
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 375
               :id                     236
               :power                  6
               :unique-id              "V0236_MOVE_Poison_STING_FAST"
               :duration-ms            575
               :animation-id           4
               :vfx-name               "\"Poison_sting_fast\""
               :name                   "Poison Sting"
               :type                   "Poison"}
          237 {:damage-window-end-ms   2300
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           15
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 2100
               :id                     237
               :power                  25
               :unique-id              "V0237_MOVE_BUBBLE_FAST"
               :duration-ms            2300
               :animation-id           4
               :vfx-name               "\"bubble_fast\""
               :name                   "Bubble"
               :type                   "Water"}
          238 {:damage-window-end-ms   1040
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 840
               :id                     238
               :power                  12
               :unique-id              "V0238_MOVE_FEINT_ATTACK_FAST"
               :duration-ms            1040
               :animation-id           4
               :vfx-name               "\"feint_attack_fast\""
               :name                   "Feint Attack"
               :type                   "Dark"}
          239 {:damage-window-end-ms   1330
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           4
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1130
               :id                     239
               :power                  15
               :unique-id              "V0239_MOVE_Steel_WING_FAST"
               :duration-ms            1330
               :animation-id           4
               :vfx-name               "\"Steel_wing_fast\""
               :name                   "Steel Wing"
               :type                   "Steel"}
          240 {:damage-window-end-ms   840
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           4
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 640
               :id                     240
               :power                  10
               :unique-id              "V0240_MOVE_Fire_FANG_FAST"
               :duration-ms            840
               :animation-id           4
               :vfx-name               "\"Fire_fang_fast\""
               :name                   "Fire Fang"
               :type                   "Fire"}
          241 {:damage-window-end-ms   1410
               :accuracy-change        1
               :stamina-loss-scalar    0.01
               :energy-delta           7
               :trainer-level-max      100
               :trainer-level-min      1
               :damage-window-start-ms 1210
               :id                     241
               :power                  15
               :unique-id              "V0241_MOVE_Rock_SMASH_FAST"
               :duration-ms            1410
               :animation-id           4
               :vfx-name               "\"Rock_smash_fast\""
               :name                   "Rock Smash"
               :type                   "Fighting"}})