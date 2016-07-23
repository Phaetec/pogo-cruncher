# cruncher

## Docker Setup

Build container:

```bash
$ docker build -t cruncher-frontend .
```

And run the container:

```bash
$ docker run -p 8888:8888 -it cruncher-frontend
```

The application is now accessible under this address: [http://localhost:8888](http://localhost:8888)

## Dev-Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL. 

## License

Copyright © 2016 Christian Meter, Alexander Schneider

Distributed under the MIT License.
