prepare:
	cp -r ../* .

build-image:
	docker build -t pogo-build .

binary:
	mkdir artifacts
	docker run pogo-build
