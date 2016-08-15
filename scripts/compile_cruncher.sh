#!/bin/bash

PROJECT_HOME="/home/wegi/projects"
PROJECT_NAME="poke-cruncher"

# Compile clojurescript
cd "$PROJECT_HOME/$PROJECT_NAME/frontend"
lein do clean, cljsbuild once min

# Compile sass file
cd "$PROJECT_HOME/$PROJECT_NAME/frontend/resources/public/css"
sass style.sass style.css

# Move all files to root Project folder
cd "$PROJECT_HOME/$PROJECT_NAME"
mv "$PROJECT_HOME/$PROJECT_NAME/frontend/resources/public/bower_components/" "$PROJECT_HOME/$PROJECT_NAME/"
mv "$PROJECT_HOME/$PROJECT_NAME/frontend/resources/public/css/" "$PROJECT_HOME/$PROJECT_NAME/"
mv "$PROJECT_HOME/$PROJECT_NAME/frontend/resources/public/img/" "$PROJECT_HOME/$PROJECT_NAME/"
mv "$PROJECT_HOME/$PROJECT_NAME/frontend/resources/public/js/" "$PROJECT_HOME/$PROJECT_NAME/"
mv "$PROJECT_HOME/$PROJECT_NAME/frontend/resources/public/index.html" "$PROJECT_HOME/$PROJECT_NAME/"

# Make zip file
cd "$PROJECT_HOME"
zip -r poke-cruncher-precompiled.zip "$PROJECT_NAME"

# Cleanup and copy files back
cd "$PROJECT_HOME/$PROJECT_NAME"
mv "bower_components" "./frontend/resources/public/"
mv "css" "./frontend/resources/public/"
mv "img" "./frontend/resources/public/"
mv "js" "./frontend/resources/public/"
mv "index.html" "./frontend/resources/public/"
