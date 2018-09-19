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

h2demo.linux: h2demo.go
	GOOS=linux go build --tags=h2demo -o h2demo.linux .

FORCE:

upload: FORCE
	go install golang.org/x/build/cmd/upload
	upload --verbose --osarch=linux-amd64 --tags=h2demo --file=go:golang.org/x/net/http2/h2demo --public http2-demo-server-tls/h2demo
