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
package identitymapper

import (
	"reflect"
	"testing"

	userapi "github.com/openshift/api/user/v1"
)

func TestInitializerUser(t *testing.T) {
	testcases := map[string]struct {
		Identity     *userapi.Identity
		User         *userapi.User
		ExpectedUser *userapi.User
	}{
		"empty": {
			Identity:     &userapi.Identity{},
			User:         &userapi.User{},
			ExpectedUser: &userapi.User{},
		},
		"empty extra": {
			Identity:     &userapi.Identity{Extra: map[string]string{}},
			User:         &userapi.User{},
			ExpectedUser: &userapi.User{},
		},
		"sets full name": {
			Identity: &userapi.Identity{
				Extra: map[string]string{"name": "Bob"},
			},
			User:         &userapi.User{},
			ExpectedUser: &userapi.User{FullName: "Bob"},
		},
		"respects existing full name": {
			Identity: &userapi.Identity{
				Extra: map[string]string{"name": "Bob"},
			},
			User:         &userapi.User{FullName: "Harold"},
			ExpectedUser: &userapi.User{FullName: "Harold"},
		},
	}

	for k, tc := range testcases {
		err := NewDefaultUserInitStrategy().InitializeUser(tc.Identity, tc.User)
		if err != nil {
			t.Errorf("%s: unexpected error: %v", k, err)
			continue
		}
		if !reflect.DeepEqual(tc.User, tc.ExpectedUser) {
			t.Errorf("%s: expected \n\t%#v\ngot\n\t%#v", k, tc.ExpectedUser, tc.User)
		}
	}
}
