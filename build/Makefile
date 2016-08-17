prepare:
	-cp -r ../* .
	cp Dockerfile.build Dockerfile

image:
	docker build -t pogo-build .

binary:
	mkdir artifacts
# docker run pogo-build
	docker run -i -v artifacts:/code/build/nsis pogo-build

clean:
	git clean -f -d
