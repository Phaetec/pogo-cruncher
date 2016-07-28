FROM python:3.5-alpine
MAINTAINER Christian Meter <cmeter@googlemail.com>

RUN apk add --no-cache git gcc musl-dev && \
    mkdir /code

WORKDIR /code

COPY requirements.txt /code

RUN pip install -r requirements.txt

COPY app.py /code
COPY backend /code/backend

EXPOSE 5000
ENV FLASK_APP /code/app.py

CMD flask run --host=0.0.0.0
