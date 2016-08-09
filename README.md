# pogo-cruncher

[![Discord](https://img.shields.io/badge/discord-Phaetec-blue.svg)](https://discord.gg/W6rsEq2)
[![CircleCI](https://img.shields.io/circleci/project/Phaetec/pogo-cruncher/master.svg?maxAge=60)](https://circleci.com/gh/Phaetec/pogo-cruncher)
[![Github All Releases](https://img.shields.io/github/downloads/phaetec/pogo-cruncher/total.svg?maxAge=60)](https://github.com/Phaetec/pogo-cruncher/releases)
[![Docker Pulls](https://img.shields.io/docker/pulls/phaetec/pogo-cruncher.svg?maxAge=60)](https://hub.docker.com/r/phaetec/pogo-cruncher/)
[![GitHub release](https://img.shields.io/github/release/Phaetec/pogo-cruncher.svg?maxAge=60)](https://github.com/Phaetec/pogo-cruncher)

This tool lets you send away multiple Pokemon at once in Pokemon GO, you can also see all IV Values.
The tool runs locally on your PC and the Login-Details are not leaving your computer. Feel free to check the source code or contribute.

*This tool is not an official production of Niantic or the Pokemon Company. Use at own risk.*

![Screenshot of PoGo-Cruncher](https://github.com/Phaetec/pogo-cruncher/raw/master/screenshot.png)

It is a work in progress, so please report all bugs to the issue page.


## Main Features
  * **[Installation using pre-build image on DockerHub](https://github.com/Phaetec/pogo-cruncher/wiki/Installation:-Docker-version)**
  * Mass send-away Pokemon
  * Select all Pokemon except your favorites
  * Select all Pokemon below a specified IV % Perfect threshold
  * Select all Pokemon below a CP threshold
  * Evolve Pokemon
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
