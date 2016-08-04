#!/bin/bash

# Stop old instance
docker stop $(docker ps -a -q --filter ancestor=phaetec/pogo-cruncher --format="{{.ID}}")
# Get newest image if it changed
docker pull phaetec/pogo-cruncher
# Start container
docker run -d -p 8888:8888 -p 5000:5000 phaetec/pogo-cruncher