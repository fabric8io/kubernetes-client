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
	"testing"

	userapi "github.com/openshift/api/user/v1"
	"github.com/openshift/origin/pkg/user/registry/test"
)

func TestStrategyAdd(t *testing.T) {
	testcases := map[string]strategyTestCase{
		"no user": {
			MakeStrategy:      NewStrategyAdd,
			PreferredUsername: "bob",
			Identity:          makeIdentity("", "idp", "bob", "", ""),

			CreateResponse: makeUser("bobUserUID", "bob", "idp:bob"),

			ExpectedActions: []test.Action{
				{Name: "GetUser", Object: "bob"},
				{Name: "CreateUser", Object: makeUser("", "bob", "idp:bob")},
			},
			ExpectedUserName:   "bob",
			ExpectedInitialize: true,
		},
		"existing user, no identities": {
			MakeStrategy:      NewStrategyAdd,
			PreferredUsername: "bob",
			Identity:          makeIdentity("", "idp", "bob", "", ""),

			ExistingUsers:  []*userapi.User{makeUser("bobUserUID", "bob")},
			UpdateResponse: makeUser("bobUserUID", "bob", "idp:bob"),

			ExpectedActions: []test.Action{
				{Name: "GetUser", Object: "bob"},
				{Name: "UpdateUser", Object: makeUser("bobUserUID", "bob", "idp:bob")},
			},
			ExpectedUserName:   "bob",
			ExpectedInitialize: true,
		},
		"existing user, conflicting identity": {
			MakeStrategy:      NewStrategyAdd,
			PreferredUsername: "bob",
			Identity:          makeIdentity("", "idp", "bob", "", ""),

			ExistingUsers:  []*userapi.User{makeUser("bobUserUID", "bob", "otheridp:user")},
			UpdateResponse: makeUser("bobUserUID", "bob", "otheridp:user", "idp:bob"),

			ExpectedActions: []test.Action{
				{Name: "GetUser", Object: "bob"},
				{Name: "UpdateUser", Object: makeUser("bobUserUID", "bob", "otheridp:user", "idp:bob")},
			},
			ExpectedUserName:   "bob",
			ExpectedInitialize: false,
		},
	}

	for testCaseName, testCase := range testcases {
		testCase.run(testCaseName, t)
	}
}
