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
package allowanypassword

import (
	"testing"

	"github.com/openshift/origin/pkg/oauthserver/api"
	"k8s.io/apiserver/pkg/authentication/user"
)

type testUserIdentityMapper struct{}

func (m *testUserIdentityMapper) UserFor(identityInfo api.UserIdentityInfo) (user.Info, error) {
	return &user.DefaultInfo{Name: identityInfo.GetProviderUserName()}, nil
}

func TestAnyAuthPassword(t *testing.T) {
	a := New("foo", &testUserIdentityMapper{})

	testcases := map[string]struct {
		Username         string
		Password         string
		ExpectedUsername string
		ExpectedOK       bool
		ExpectedErr      bool
	}{
		"empty user invalid": {
			Username:   "",
			Password:   "foo",
			ExpectedOK: false,
		},
		"empty password invalid": {
			Username:   "foo",
			Password:   "",
			ExpectedOK: false,
		},
		"valid username and password": {
			Username:         "foo",
			Password:         "bar",
			ExpectedOK:       true,
			ExpectedUsername: "foo",
		},
		"case-sensitive username": {
			Username:         "FOO",
			Password:         "bar",
			ExpectedOK:       true,
			ExpectedUsername: "FOO",
		},
		"whitespace-normalizing username": {
			Username:         "  FOO   BAR  ",
			Password:         "bar",
			ExpectedOK:       true,
			ExpectedUsername: "FOO   BAR",
		},
		"whitespace-only user invalid": {
			Username:   "  ",
			Password:   "bar",
			ExpectedOK: false,
		},
	}

	for k, tc := range testcases {
		user, ok, err := a.AuthenticatePassword(tc.Username, tc.Password)
		if tc.ExpectedErr != (err != nil) {
			t.Errorf("%s: expected error=%v, got %v", k, tc.ExpectedErr, err)
			continue
		}
		if tc.ExpectedOK != ok {
			t.Errorf("%s: expected ok=%v, got %v", k, tc.ExpectedOK, ok)
			continue
		}
		username := ""
		if ok {
			username = user.GetName()
		}
		if tc.ExpectedUsername != username {
			t.Errorf("%s: expected username=%v, got %v", k, tc.ExpectedUsername, username)
			continue
		}
	}
}
