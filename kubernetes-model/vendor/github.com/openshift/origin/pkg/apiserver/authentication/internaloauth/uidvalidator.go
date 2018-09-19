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
	"fmt"

	userapi "github.com/openshift/api/user/v1"
	"github.com/openshift/origin/pkg/oauth/apis/oauth"
)

const errInvalidUIDStr = "user.UID (%s) does not match token.userUID (%s)"

func NewUIDValidator() OAuthTokenValidator {
	return OAuthTokenValidatorFunc(
		func(token *oauth.OAuthAccessToken, user *userapi.User) error {
			if string(user.UID) != token.UserUID {
				return fmt.Errorf(errInvalidUIDStr, user.UID, token.UserUID)
			}
			return nil
		},
	)
}
