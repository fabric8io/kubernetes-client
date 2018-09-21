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

regenerate:
	rm -rf combos
	go install github.com/gogo/protobuf/protoc-gen-combo
	go install github.com/gogo/protobuf/protoc-gen-gogo
	protoc-min-version --version="3.0.0" --gogo_out=. --proto_path=../../../../../:../../protobuf/:. castvalue.proto
	protoc-gen-combo --default=false --version="3.0.0" --gogo_out=. --proto_path=../../../../../:../../protobuf/:. castvalue.proto
	cp mytypes.go ./combos/both/ || true
	cp mytypes.go ./combos/marshaler/ || true
	cp mytypes.go ./combos/unmarshaler/ || true
	cp mytypes.go ./combos/unsafeboth/ || true
	cp mytypes.go ./combos/unsafemarshaler/ || true
	cp mytypes.go ./combos/unsafeunmarshaler/ || true
