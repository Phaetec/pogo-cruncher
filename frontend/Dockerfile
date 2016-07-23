FROM clojure
MAINTAINER Christian Meter <cmeter@googlemail.com>

# Add sources for nodejs
RUN curl -sL https://deb.nodesource.com/setup_6.x | bash -

RUN apt-get update -qq
RUN apt-get install -yqq rubygems nodejs
RUN yes | gem install sass
RUN npm install bower -g

RUN mkdir ./frontend
WORKDIR /frontend

ADD . /frontend

# Load bower dependencies
RUN GIT_DIR=/tmp bower install --allow-root

# Install clojurescript dependencies and build minified js file
RUN lein deps
RUN lein cljsbuild once min

# Now let's create the remaining web components
WORKDIR /frontend/resources/public

RUN sass css/style.sass css/style.css --style compressed
RUN rm -rf .sass-cache

# Start SimpleHTTPServer to serve application
EXPOSE 8888
CMD python2 -m SimpleHTTPServer 8888