FROM clojure
MAINTAINER Christian Meter <meter@cs.uni-duesseldorf.de>

# Add sources for nodejs
RUN curl -sL https://deb.nodesource.com/setup_6.x | bash -

RUN apt-get update -qq
RUN apt-get install -yqq rubygems nodejs
RUN yes | gem install sass
RUN npm install bower -g

RUN mkdir ./frontend
WORKDIR /frontend

ADD . /frontend

RUN lein deps