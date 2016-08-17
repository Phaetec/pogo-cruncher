FROM clojure
MAINTAINER Christian Meter <cmeter@googlemail.com>

# Add sources for nodejs
RUN curl -sL https://deb.nodesource.com/setup_6.x | bash -

RUN apt-get update
RUN apt-get install -yqq nodejs ruby git supervisor python python3 python3-dev python3-pip gcc musl-dev nsis && \
    (gem install sass; exit 0) && \
    npm install bower -g && \
    mkdir /code

ADD . /code
WORKDIR /code

RUN git describe --tags

# Setup backend
RUN pip3 install -U pip
RUN pip3 install -r requirements.txt
RUN pip3 install pynsist

# Setup frontend
RUN cd /code/frontend && \
    GIT_DIR=/tmp bower install --allow-root && \
    lein deps && \
    lein cljsbuild once min && \
    cd /code/frontend/resources/public && \
    sass css/style.sass css/style.css --style compressed && \
    rm -rf .sass-cache

CMD ["sh", "./build-binary.sh"]
