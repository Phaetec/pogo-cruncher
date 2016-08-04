@echo off

docker pull phaetec/pogo-cruncher
docker run -p 8888:8888 -p 5000:5000 phaetec/pogo-cruncher