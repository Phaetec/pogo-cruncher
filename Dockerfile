FROM python:3.5
MAINTAINER Christian Meter <cmeter@googlemail.com>

RUN mkdir /code
WORKDIR /code

ADD requirements.txt /code
RUN pip install -U pip
RUN pip install -r requirements.txt

ADD app.py /code
ADD backend /code/backend

EXPOSE 5000
CMD export FLASK_APP=/code/app.py
CMD flask run --host=0.0.0.0
