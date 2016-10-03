# pogo-cruncher

[![Discord](https://img.shields.io/badge/discord-Phaetec-blue.svg)](https://discord.gg/W6rsEq2)
[![CircleCI](https://img.shields.io/circleci/project/Phaetec/pogo-cruncher/master.svg?maxAge=60)](https://circleci.com/gh/Phaetec/pogo-cruncher)
[![Github All Releases](https://img.shields.io/github/downloads/phaetec/pogo-cruncher/total.svg?maxAge=60)](https://github.com/Phaetec/pogo-cruncher/releases)
[![Docker Pulls](https://img.shields.io/docker/pulls/phaetec/pogo-cruncher.svg?maxAge=60)](https://hub.docker.com/r/phaetec/pogo-cruncher/) [![](https://images.microbadger.com/badges/image/phaetec/pogo-cruncher.svg)](https://microbadger.com/images/phaetec/pogo-cruncher "Get your own image badge on microbadger.com")
[![GitHub release](https://img.shields.io/github/release/Phaetec/pogo-cruncher.svg?maxAge=60)](https://github.com/Phaetec/pogo-cruncher)

**Please refrain of use of this tool, as there is a chance of getting banned at the moment. If we find a solution, we will make a version update and make a shoutout in our Discord channel.**

This tool lets you send away multiple Pokemon at once in Pokemon GO, you can also see all IV Values.
The tool runs locally on your PC and the Login-Details are not leaving your computer. Feel free to check the source code or contribute.

*This tool is not an official production of Niantic or the Pokemon Company. Use at own risk.*  
*Please submit all pull-requests against the developer branch.*

![Screenshot of PoGo-Cruncher](https://github.com/Phaetec/pogo-cruncher/raw/master/screenshot.png)

It is a work in progress, so please report all bugs to the issue page.


## Main Features
  * **[Installation using pre-build image on DockerHub](https://github.com/Phaetec/pogo-cruncher/wiki/Installation:-Docker-version)**
  * [Windows Installation using an Installer](https://github.com/Phaetec/pogo-cruncher/wiki/Installation-with-.exe-for-Windows)
  * Mass send-away / rename your Pokemon
  * Evolve Pokemon
  * Powerup Pokemon
  * Mark Pokemon as favorite

For more upcoming features, see the
[Changelog](https://github.com/Phaetec/pogo-cruncher/blob/master/CHANGELOG.md),
[Milestones](https://github.com/Phaetec/pogo-cruncher/milestones) and
[Issues](https://github.com/Phaetec/pogo-cruncher/issues).


## Installation
For an Installation guide please refer to our [wiki](https://github.com/Phaetec/pogo-cruncher/wiki).

Shorthand:
```bash
docker pull phaetec/pogo-cruncher
docker run -d -p 8888:8888 -p 5000:5000 phaetec/pogo-cruncher
```

and open your browser at [http://localhost:8888](http://localhost:8888)


## Developers / Maintainers
Active Maintainers:
  * [n2o](https://github.com/n2o)
  * [Wegi](https://github.com/Wegi)


## Feature Requests
For feature requests please open up a new issue on this repository.
 