/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package schema1

import (
	"crypto/x509"

	"github.com/docker/libtrust"
	"github.com/sirupsen/logrus"
)

// Verify verifies the signature of the signed manifest returning the public
// keys used during signing.
func Verify(sm *SignedManifest) ([]libtrust.PublicKey, error) {
	js, err := libtrust.ParsePrettySignature(sm.all, "signatures")
	if err != nil {
		logrus.WithField("err", err).Debugf("(*SignedManifest).Verify")
		return nil, err
	}

	return js.Verify()
}

// VerifyChains verifies the signature of the signed manifest against the
// certificate pool returning the list of verified chains. Signatures without
// an x509 chain are not checked.
func VerifyChains(sm *SignedManifest, ca *x509.CertPool) ([][]*x509.Certificate, error) {
	js, err := libtrust.ParsePrettySignature(sm.all, "signatures")
	if err != nil {
		return nil, err
	}

	return js.VerifyChains(ca)
}
