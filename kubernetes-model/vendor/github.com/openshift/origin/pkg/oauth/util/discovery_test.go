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
package util

import (
	"reflect"
	"testing"

	"github.com/RangelReale/osin"
)

func TestGetOauthMetadata(t *testing.T) {
	actual := GetOauthMetadata("https://localhost:8443")
	expected := OauthAuthorizationServerMetadata{
		Issuer:                "https://localhost:8443",
		AuthorizationEndpoint: "https://localhost:8443/oauth/authorize",
		TokenEndpoint:         "https://localhost:8443/oauth/token",
		ScopesSupported: []string{
			"user:check-access",
			"user:full",
			"user:info",
			"user:list-projects",
			"user:list-scoped-projects",
		},
		ResponseTypesSupported: osin.AllowedAuthorizeType{
			"code",
			"token",
		},
		GrantTypesSupported: osin.AllowedAccessType{
			"authorization_code",
			"implicit",
		},
		CodeChallengeMethodsSupported: []string{
			"plain",
			"S256",
		},
	}

	if !reflect.DeepEqual(actual, expected) {
		t.Errorf("Expected %#v, got %#v", expected, actual)
	}
}
