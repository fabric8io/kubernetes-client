#!/usr/bin/env bash
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



set -e

workdir=.cover
profile="$workdir/cover.out"
mode=set
end2endtest="google.golang.org/grpc/test"

generate_cover_data() {
    rm -rf "$workdir"
    mkdir "$workdir"

    for pkg in "$@"; do
        if [ $pkg == "google.golang.org/grpc" -o $pkg == "google.golang.org/grpc/transport" -o $pkg == "google.golang.org/grpc/metadata" -o $pkg == "google.golang.org/grpc/credentials" ]
            then
                f="$workdir/$(echo $pkg | tr / -)"
                go test -covermode="$mode" -coverprofile="$f.cover" "$pkg"
                go test -covermode="$mode" -coverpkg "$pkg" -coverprofile="$f.e2e.cover" "$end2endtest"
        fi
    done

    echo "mode: $mode" >"$profile"
    grep -h -v "^mode:" "$workdir"/*.cover >>"$profile"
}

show_cover_report() {
    go tool cover -${1}="$profile"
}

push_to_coveralls() {
    goveralls -coverprofile="$profile"
}

generate_cover_data $(go list ./...)
show_cover_report func
case "$1" in
"")
    ;;
--html)
    show_cover_report html ;;
--coveralls)
    push_to_coveralls ;;
*)
    echo >&2 "error: invalid option: $1" ;;
esac
rm -rf "$workdir"
