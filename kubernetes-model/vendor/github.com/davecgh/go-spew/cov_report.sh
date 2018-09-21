#!/bin/sh
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


# This script uses gocov to generate a test coverage report.
# The gocov tool my be obtained with the following command:
#   go get github.com/axw/gocov/gocov
#
# It will be installed to $GOPATH/bin, so ensure that location is in your $PATH.

# Check for gocov.
if ! type gocov >/dev/null 2>&1; then
	echo >&2 "This script requires the gocov tool."
	echo >&2 "You may obtain it with the following command:"
	echo >&2 "go get github.com/axw/gocov/gocov"
	exit 1
fi

# Only run the cgo tests if gcc is installed.
if type gcc >/dev/null 2>&1; then
	(cd spew && gocov test -tags testcgo | gocov report)
else
	(cd spew && gocov test | gocov report)
fi
