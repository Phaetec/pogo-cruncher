FROM python:3.5-alpine
MAINTAINER Christian Meter <cmeter@googlemail.com>

RUN apk add --no-cache git gcc musl-dev && \
    mkdir /code

RUN mkdir /code/modules

RUN ls -al
RUN ls -al /code

COPY requirements.txt /code
COPY modules/pgoapi-master.zip /code/modules

RUN pip install -r requirements.txt

COPY app.py /code
COPY backend /code/backend

WORKDIR /code

EXPOSE 5000
ENV FLASK_APP /code/app.py

CMD flask run --host=0.0.0.0
