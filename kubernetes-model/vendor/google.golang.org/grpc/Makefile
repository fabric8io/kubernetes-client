#
# Copyright (C) 2015 Red Hat, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

all: test testrace

deps:
	go get -d -v google.golang.org/grpc/...

updatedeps:
	go get -d -v -u -f google.golang.org/grpc/...

testdeps:
	go get -d -v -t google.golang.org/grpc/...

updatetestdeps:
	go get -d -v -t -u -f google.golang.org/grpc/...

build: deps
	go build google.golang.org/grpc/...

proto:
	@ if ! which protoc > /dev/null; then \
		echo "error: protoc not installed" >&2; \
		exit 1; \
	fi
	go get -u -v github.com/golang/protobuf/protoc-gen-go
	# use $$dir as the root for all proto files in the same directory
	for dir in $$(git ls-files '*.proto' | xargs -n1 dirname | uniq); do \
		protoc -I $$dir --go_out=plugins=grpc:$$dir $$dir/*.proto; \
	done

test: testdeps
	go test -v -cpu 1,4 google.golang.org/grpc/...

testrace: testdeps
	go test -v -race -cpu 1,4 google.golang.org/grpc/...

clean:
	go clean -i google.golang.org/grpc/...

coverage: testdeps
	./coverage.sh --coveralls

.PHONY: \
	all \
	deps \
	updatedeps \
	testdeps \
	updatetestdeps \
	build \
	proto \
	test \
	testrace \
	clean \
	coverage
