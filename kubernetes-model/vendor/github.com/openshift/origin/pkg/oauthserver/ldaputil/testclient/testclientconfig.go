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
package testclient

import (
	"github.com/openshift/origin/pkg/oauthserver/ldaputil/ldapclient"
	"gopkg.in/ldap.v2"
)

// fakeConfig regurgitates internal state in order to conform to Config
type fakeConfig struct {
	client ldap.Client
}

// NewConfig creates a new Config impl that regurgitates the given data
func NewConfig(client ldap.Client) ldapclient.Config {
	return &fakeConfig{
		client: client,
	}
}

func (c *fakeConfig) Connect() (ldap.Client, error) {
	return c.client, nil
}

func (c *fakeConfig) GetBindCredentials() (string, string) {
	return "", ""
}

func (c *fakeConfig) Host() string {
	return ""
}
