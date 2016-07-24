# pogo-cruncher
This tool lets you send away multiple Pokemon at once in Pokemon GO.

It is a work in progress, so please report all bugs to the issue page.

## Installation Setup for normal use
Requirements:
  * docker

#### Step 1
Install docker. You can find docker and a installation guide [on the Docker homepage.](https://www.docker.com/products/docker)

#### Step 2
Download the newest version of pogo-cruncher.

Either via direct download [here](https://github.com/Wegi/pogo-cruncher/releases) or by using git

```bash
$ git clone https://github.com/Wegi/pogo-cruncher.git
```

#### Step 3
Open a Terminal and enter the pogo-cruncher directory, then do build the app via:
```bash
$ docker-compose build
```

### Run Pogo-Cruncher
Open a Terminal and enter the pogo-cruncher directory, then start the app via:
```bash
$ docker-compose up
```
Now the app is up and running. Access it on [localhost:8888](http://localhost:8888)  
You can stop the app by closing the terminal.

![Screenshot of PoGo-Cruncher](screenshot.png)

## Setup for dev-users
Requirements:
  * python3
  * bower
  * nodejs
  * sass
  * Clojure

#### Backend
This tool ist based on python and the wonderfull Pokemon GO api at https://github.com/tejado

Start it with this command from the repository's root directory:

```bash
$ python app.py
```


#### frontend
Change directory to `frontend/`:
```bash
$ cd frontend
```

Once get all bower dependencies with:
```bash
$ bower install
```

Build sass files
```bash
$ sass resources/public/css/style.sass resources/public/css/style.css
```

Then start the interactive session:
```bash
$ lein figwheel
```

You can access the application now at [localhost:3449](http://localhost:3449)

## Upcoming Features
    * Automatic Pidgeycalc for Egg-Evolutions
    * Send all dupes away that are not the highest CP
    * Rename Pokemon after their IVs

## Feature Requests
For feature requests please open up a new issue on this repository.
