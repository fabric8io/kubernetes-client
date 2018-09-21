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
package internaloauth

import (
	userapi "github.com/openshift/api/user/v1"
	"github.com/openshift/origin/pkg/oauth/apis/oauth"
)

type OAuthTokenValidator interface {
	Validate(token *oauth.OAuthAccessToken, user *userapi.User) error
}

var _ OAuthTokenValidator = OAuthTokenValidatorFunc(nil)

type OAuthTokenValidatorFunc func(token *oauth.OAuthAccessToken, user *userapi.User) error

func (f OAuthTokenValidatorFunc) Validate(token *oauth.OAuthAccessToken, user *userapi.User) error {
	return f(token, user)
}

var _ OAuthTokenValidator = OAuthTokenValidators(nil)

type OAuthTokenValidators []OAuthTokenValidator

func (v OAuthTokenValidators) Validate(token *oauth.OAuthAccessToken, user *userapi.User) error {
	for _, validator := range v {
		if err := validator.Validate(token, user); err != nil {
			return err
		}
	}
	return nil
}

type UserToGroupMapper interface {
	GroupsFor(username string) ([]*userapi.Group, error)
}

type NoopGroupMapper struct{}

func (n NoopGroupMapper) GroupsFor(username string) ([]*userapi.Group, error) {
	return []*userapi.Group{}, nil
}
