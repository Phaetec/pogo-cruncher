#!/usr/bin/env bash

# Get bower components
GIT_DIR=/tmp bower install --allow-root

# Build minified js
lein cljsbuild once min

# Create CSS files
cd resources/public/
sass css/style.sass css/style.css --style compressed
rm -rf .sass-cache

# Print IP address
ip=`ip addr show eth0 | grep "inet\b" | awk '{print $2}' | cut -d/ -f1`
port=8888

printf "\n###################################################"
printf "\n# Connect to discuss via http://$ip:$port"
printf "\n###################################################\n"

python2 -m SimpleHTTPServer ${port}