FROM clojure:alpine
MAINTAINER Christian Meter <cmeter@googlemail.com>

ENV FLASK_APP /code/app.py

RUN apk add --no-cache nodejs ruby git python python3 python3-dev gcc musl-dev && \
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

WORKDIR /code/frontend/resources/public

# Start SimpleHTTPServer to serve application
EXPOSE 8888
CMD python -m SimpleHTTPServer 8888 && flask run --host=0.0.0.0
