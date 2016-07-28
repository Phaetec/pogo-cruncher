FROM clojure:alpine
MAINTAINER Christian Meter <cmeter@googlemail.com>

RUN apk add --no-cache nodejs ruby git python && \
    (gem install sass; exit 0) && \
    npm install bower -g && \
    mkdir /frontend

ADD . /frontend

# Load bower dependencies
RUN cd /frontend && \
    GIT_DIR=/tmp bower install --allow-root && \
    lein deps && \
    lein cljsbuild once min && \
    cd /frontend/resources/public && \
    sass css/style.sass css/style.css --style compressed && \
    rm -rf .sass-cache

WORKDIR /frontend/resources/public

# Start SimpleHTTPServer to serve application
EXPOSE 8888
CMD python -m SimpleHTTPServer 8888
