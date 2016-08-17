TAG := $(shell git describe --tags)

prepare:
	cp build/* .
	cp Dockerfile.build Dockerfile
	find installer.cfg -type f -exec sed -i "s/major.minor.patch/$(TAG)/g" {} +

image:
	docker build -t pogo-build .

binary:
	mkdir artifacts
	docker run -i -v artifacts:/code/build/nsis pogo-build

clean:
	git clean -f -d

echo:
	cd build && ls
