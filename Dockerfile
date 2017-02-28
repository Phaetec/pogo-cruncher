FROM clojure
MAINTAINER Christian Meter <cmeter@googlemail.com>

RUN curl -sL https://deb.nodesource.com/setup_6.x | bash - && \
    apt-get update && \
    apt-get install -yqq rubygems nodejs git supervisor python python3 python3-dev python3-pip gcc && \
    (gem install sass; exit 0) && \
    npm install bower -g && \
    mkdir /code

ADD . /code
WORKDIR /code

# Setup backend
RUN pip3 install -U pip
RUN pip3 install -r requirements.txt

# Setup frontend
RUN cd /code/frontend && \
    GIT_DIR=/tmp bower install --allow-root && \
    lein deps && \
    lein cljsbuild once min && \
    cd /code/frontend/resources/public && \
    sass css/style.sass css/style.css --style compressed && \
    rm -rf .sass-cache

COPY supervisord.conf /etc/supervisord.conf

# Start SimpleHTTPServer to serve application
EXPOSE 8888 5000
CMD ["/usr/bin/supervisord"]
