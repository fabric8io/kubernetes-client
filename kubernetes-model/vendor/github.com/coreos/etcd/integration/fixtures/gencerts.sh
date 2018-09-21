#!/bin/bash
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


if ! [[ "$0" =~ "./gencerts.sh" ]]; then
	echo "must be run from 'fixtures'"
	exit 255
fi

if ! which cfssl; then
	echo "cfssl is not installed"
	exit 255
fi

cfssl gencert --initca=true ./ca-csr.json | cfssljson --bare ./ca
mv ca.pem ca.crt
openssl x509 -in ca.crt -noout -text

# generate DNS: localhost, IP: 127.0.0.1, CN: example.com certificates
cfssl gencert \
    --ca ./ca.crt \
    --ca-key ./ca-key.pem \
    --config ./gencert.json \
    ./server-ca-csr.json | cfssljson --bare ./server
mv server.pem server.crt
mv server-key.pem server.key.insecure

# generate revoked certificates and crl
cfssl gencert --ca ./ca.crt \
    --ca-key ./ca-key.pem \
    --config ./gencert.json \
    ./server-ca-csr.json 2>revoked.stderr | cfssljson --bare ./server-revoked
mv server-revoked.pem server-revoked.crt
mv server-revoked-key.pem server-revoked.key.insecure
grep serial revoked.stderr | awk ' { print $9 } ' >revoke.txt
cfssl gencrl revoke.txt ca.crt ca-key.pem | base64 -d >revoke.crl

# generate wildcard certificates DNS: *.etcd.local
cfssl gencert \
    --ca ./ca.crt \
    --ca-key ./ca-key.pem \
    --config ./gencert.json \
    ./server-ca-csr-wildcard.json | cfssljson --bare ./server-wildcard
mv server-wildcard.pem server-wildcard.crt
mv server-wildcard-key.pem server-wildcard.key.insecure


rm -f *.csr *.pem *.stderr *.txt
