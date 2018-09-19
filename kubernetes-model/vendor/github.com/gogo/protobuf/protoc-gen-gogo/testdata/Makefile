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

all:
	@echo run make test

test:	regenerate testbuild

#test:	regenerate testbuild extension_test
#	./extension_test
#	@echo PASS

my_test/test.pb.go: my_test/test.proto
	protoc --gogo_out=Mmulti/multi1.proto=github.com/gogo/protobuf/protoc-gen-gogo/testdata/multi:. $<

regenerate: my_test/test.pb.go
	go install github.com/gogo/protobuf/protoc-min-version
	protoc-min-version --version="3.0.0" --gogo_out=. ./my_test/test.proto

nuke:	clean

testbuild:	buildprotos
	go test

buildprotos:
	# Invoke protoc once to generate three independent .pb.go files in the same package.
	protoc --gogo_out=. multi/multi1.proto multi/multi2.proto multi/multi3.proto

#extension_test:	extension_test.$O
#	$(LD) -L. -o $@ $<

#multi.a: multi3.pb.$O multi2.pb.$O multi1.pb.$O
#	rm -f multi.a
#	$(QUOTED_GOBIN)/gopack grc $@ $<

#test.pb.go:	imp.pb.go
#multi1.pb.go:	multi2.pb.go multi3.pb.go
#main.$O: imp.pb.$O test.pb.$O multi.a
#extension_test.$O: extension_base.pb.$O extension_extra.pb.$O extension_user.pb.$O
