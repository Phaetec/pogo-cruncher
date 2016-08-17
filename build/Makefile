prepare:
	-cp -r ../* .
	cp Dockerfile.build Dockerfile

image:
	docker build -t pogo-build .

binary:
	mkdir artifacts
	docker run pogo-build

clean:
	git clean -f -d
