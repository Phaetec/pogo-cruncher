# pogo-cruncher
This tool lets you send away multiple Pokemon at once in Pokemon GO.

It is a work in progress, so please report all bugs to the issue page.

## Setup for normal use
Requirements:
  * docker
  * git

This is not optimal yet, but you can pack it into two containers and start analyzing your Pokemon.

```bash
$ git clone https://github.com/Wegi/pogo-cruncher.git
$ cd pogo-cruncher
$ docker build -t cruncher-backend .
$ cd frontend
$ docker build -t cruncher-frontend .
$ docker run -d -p 5000:5000 -it cruncher-backend
$ docker run -d -p 8888:8888 -it cruncher-frontend
```

Now the app is up and running. Access it on [localhost:8888](http://localhost:8888)

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
    * See the IV of your pokemon
    * Mass send away fature
    * Automatic Pidgeycalc for Egg-Evolutions
    * Send all dupes away that are not the highest CP
    * Rename Pokemon after their IVs

## Feature Requests
For feature requests please open up a new issue on this repository.

## Starting the flask Server

Step 1: `python app.py`  
Step 2: There is no step 2
