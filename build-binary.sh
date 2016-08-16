#!/bin/sh

pynsist="pynsist_pkgs"

pip3 install pynsist

mkdir $pynsist
cp -r /usr/local/lib/python3.4/dist-packages/pgoapi $pynsist
cp -r /usr/local/lib/python3.4/dist-packages/markupsafe $pynsist
cp -r /usr/local/lib/python3.4/dist-packages/google/protobuf $pynsist

wget https://github.com/Phaetec/pogo-cruncher-build/raw/master/Cryptodome.zip
wget https://github.com/Phaetec/pogo-cruncher-build/raw/master/installer.cfg

unzip Cryptodome.zip
mv Cryptodome $pynsist
rm Cryptodome.zip


# Remove all occurences of google.protobuf and replace it with protobuf
find $pynsist/pgoapi/ -type f -exec sed -i 's/google\.protobuf/protobuf/g' {} +
find $pynsist/protobuf/ -type f -exec sed -i 's/google\.protobuf/protobuf/g' {} +

# Replace protobuf check
find $pynsist/pgoapi/__init__.py -type f -exec sed -i 's/if\ (not\ protobuf_exist)\ or\ (int(protobuf_version\[\:1\])\ <\ 3):/\ /g' {} +
find $pynsist/pgoapi/__init__.py -type f -exec sed -i 's/raise\ PleaseInstallProtobufVersion3()/\ /g' {} +

# Copy frontend
mkdir interface
cp -r frontend/resources/public/* interface

# And build!
pynsist installer.cfg
