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
package google

import (
	"errors"
	"fmt"

	"github.com/openshift/origin/pkg/oauthserver/oauth/external"
	"github.com/openshift/origin/pkg/oauthserver/oauth/external/openid"
)

const (
	googleAuthorizeURL = "https://accounts.google.com/o/oauth2/auth"
	googleTokenURL     = "https://www.googleapis.com/oauth2/v3/token"
	googleUserInfoURL  = "https://www.googleapis.com/oauth2/v3/userinfo"

	// https://developers.google.com/identity/protocols/OpenIDConnect#hd-param
	googleHostedDomain = "hd"
)

var googleOAuthScopes = []string{"openid", "email", "profile"}

func NewProvider(providerName, clientID, clientSecret, hostedDomain string) (external.Provider, error) {
	config := openid.Config{
		ClientID:     clientID,
		ClientSecret: clientSecret,

		AuthorizeURL: googleAuthorizeURL,
		TokenURL:     googleTokenURL,
		UserInfoURL:  googleUserInfoURL,

		Scopes: googleOAuthScopes,

		IDClaims:                []string{"sub"},
		PreferredUsernameClaims: []string{"preferred_username", "email"},
		EmailClaims:             []string{"email"},
		NameClaims:              []string{"name", "email"},
	}

	if len(hostedDomain) > 0 {
		// Request a specific hosted domain during authorization
		config.ExtraAuthorizeParameters = map[string]string{
			googleHostedDomain: hostedDomain,
		}

		// Validate the returned id_token is from that hosted domain
		config.IDTokenValidator = func(idToken map[string]interface{}) error {
			hdClaim, ok := idToken[googleHostedDomain].(string)
			if !ok {
				return errors.New("id_token did not contain a hd claim")
			}
			if hdClaim != hostedDomain {
				return fmt.Errorf("id_token hd claim (%s) did not match hostedDomain (%s)", hdClaim, hostedDomain)
			}
			return nil
		}
	}

	return openid.NewProvider(providerName, nil, config)
}
