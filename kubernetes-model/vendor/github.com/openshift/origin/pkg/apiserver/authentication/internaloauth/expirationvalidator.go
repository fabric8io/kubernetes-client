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
	"errors"
	"time"

	userv1 "github.com/openshift/api/user/v1"
	"github.com/openshift/origin/pkg/oauth/apis/oauth"
)

var errExpired = errors.New("token is expired")

func NewExpirationValidator() OAuthTokenValidator {
	return OAuthTokenValidatorFunc(
		func(token *oauth.OAuthAccessToken, _ *userv1.User) error {
			if token.ExpiresIn > 0 {
				if expire(token).Before(time.Now()) {
					return errExpired
				}
			}
			if token.DeletionTimestamp != nil {
				return errExpired
			}
			return nil
		},
	)
}

func expire(token *oauth.OAuthAccessToken) time.Time {
	return token.CreationTimestamp.Add(time.Duration(token.ExpiresIn) * time.Second)
}
