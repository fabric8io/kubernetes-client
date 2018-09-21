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
package osinserver

import (
	"encoding/base64"
	"strings"

	"crypto/rand"

	"github.com/RangelReale/osin"
)

func randomBytes(len int) []byte {
	b := make([]byte, len)
	if _, err := rand.Read(b); err != nil {
		// rand.Read should never fail
		panic(err)
	}
	return b
}
func randomToken() string {
	for {
		// 32 bytes (256 bits) = 43 base64-encoded characters
		b := randomBytes(32)
		// Use URLEncoding to ensure we don't get / characters
		s := base64.URLEncoding.EncodeToString(b)
		// Don't generate tokens with leading dashes... they're hard to use on the command line
		if strings.HasPrefix(s, "-") {
			continue
		}
		// Strip trailing ='s... they're ugly
		return strings.TrimRight(s, "=")
	}
}

// TokenGen is an authorization and access token generator
type TokenGen struct {
}

// GenerateAuthorizeToken generates a random UUID code
func (TokenGen) GenerateAuthorizeToken(data *osin.AuthorizeData) (ret string, err error) {
	return randomToken(), nil
}

// GenerateAccessToken generates random UUID access and refresh tokens
func (TokenGen) GenerateAccessToken(data *osin.AccessData, generaterefresh bool) (string, string, error) {
	accesstoken := randomToken()

	refreshtoken := ""
	if generaterefresh {
		refreshtoken = randomToken()
	}
	return accesstoken, refreshtoken, nil
}
