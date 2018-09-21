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

if ! [[ "$0" =~ "./gencerts.sh" ]]; then
	echo "must be run from 'fixtures-expired'"
	exit 255
fi

if which cfssl >/dev/null; then
    echo "cfssl is installed; generating certs"
else
    echo "cfssl is not installed; exiting"
    exit 255
fi

cat > ./etcd-root-ca-csr.json <<EOF
{
  "key": {
    "algo": "rsa",
    "size": 4096
  },
  "names": [
    {
      "O": "etcd",
      "OU": "etcd Security",
      "L": "San Francisco",
      "ST": "California",
      "C": "USA"
    }
  ],
  "CN": "etcd-root-ca",
  "ca": {
    "expiry": "1h"
  }
}
EOF

cfssl gencert --initca=true ./etcd-root-ca-csr.json | cfssljson --bare ./etcd-root-ca

cat > ./etcd-gencert.json <<EOF
{
  "signing": {
    "default": {
        "usages": [
          "signing",
          "key encipherment",
          "server auth",
          "client auth"
        ],
        "expiry": "1h"
    }
  }
}
EOF

cat > ./server-ca-csr.json <<EOF
{
  "key": {
    "algo": "rsa",
    "size": 4096
  },
  "names": [
    {
      "O": "etcd",
      "OU": "etcd Security",
      "L": "San Francisco",
      "ST": "California",
      "C": "USA"
    }
  ],
  "CN": "example.com",
  "hosts": [
    "127.0.0.1",
    "localhost"
  ]
}
EOF

cfssl gencert \
    --ca ./etcd-root-ca.pem \
    --ca-key ./etcd-root-ca-key.pem \
    --config ./etcd-gencert.json \
    ./server-ca-csr.json | cfssljson --bare ./server

rm ./*.json
rm ./*.csr

if which openssl >/dev/null; then
    openssl x509 -in ./etcd-root-ca.pem -text -noout
    openssl x509 -in ./server.pem -text -noout
fi
