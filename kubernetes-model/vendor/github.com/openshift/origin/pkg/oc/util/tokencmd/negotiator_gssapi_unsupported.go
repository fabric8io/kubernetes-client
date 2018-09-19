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
// +build !gssapi

package tokencmd

import "errors"

func GSSAPIEnabled() bool {
	return false
}

type gssapiUnsupported struct{}

func NewGSSAPINegotiator(principalName string) Negotiater {
	return &gssapiUnsupported{}
}

func (g *gssapiUnsupported) Load() error {
	return errors.New("GSSAPI support is not enabled")
}
func (g *gssapiUnsupported) InitSecContext(requestURL string, challengeToken []byte) (tokenToSend []byte, err error) {
	return nil, errors.New("GSSAPI support is not enabled")
}
func (g *gssapiUnsupported) IsComplete() bool {
	return false
}
func (g *gssapiUnsupported) Release() error {
	return errors.New("GSSAPI support is not enabled")
}
