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

prefix=/usr/local/bin

default: build

build:
	@echo "Nothing to build. Use make install"

install: intemp.sh
	install intemp.sh $(DESTDIR)$(prefix)

uninstall:
	-rm $(DESTDIR)$(prefix)/intemp.sh
