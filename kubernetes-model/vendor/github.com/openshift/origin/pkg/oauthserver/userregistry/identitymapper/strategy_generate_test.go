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

func TestStrategyGenerate(t *testing.T) {
	testcases := map[string]strategyTestCase{
		"no user": {
			MakeStrategy:      NewStrategyGenerate,
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
			MakeStrategy:      NewStrategyGenerate,
			PreferredUsername: "bob",
			Identity:          makeIdentity("", "idp", "bob", "", ""),

			ExistingUsers:  []*userapi.User{makeUser("bobUserUID", "bob")},
			CreateResponse: makeUser("bob2UserUID", "bob2", "idp:bob"),

			ExpectedActions: []test.Action{
				{Name: "GetUser", Object: "bob"},
				{Name: "GetUser", Object: "bob2"},
				{Name: "CreateUser", Object: makeUser("", "bob2", "idp:bob")},
			},
			ExpectedUserName:   "bob2",
			ExpectedInitialize: true,
		},
		"existing user, conflicting identity": {
			MakeStrategy:      NewStrategyGenerate,
			PreferredUsername: "bob",
			Identity:          makeIdentity("", "idp", "bob", "", ""),

			ExistingUsers:  []*userapi.User{makeUser("bobUserUID", "bob", "otheridp:user")},
			CreateResponse: makeUser("bob2UserUID", "bob2", "idp:bob"),

			ExpectedActions: []test.Action{
				{Name: "GetUser", Object: "bob"},
				{Name: "GetUser", Object: "bob2"},
				{Name: "CreateUser", Object: makeUser("", "bob2", "idp:bob")},
			},
			ExpectedUserName:   "bob2",
			ExpectedInitialize: true,
		},
		"existing users": {
			MakeStrategy:      NewStrategyGenerate,
			PreferredUsername: "bob",
			Identity:          makeIdentity("", "idp", "bob", "", ""),

			ExistingUsers: []*userapi.User{
				makeUser("bobUserUID", "bob", "otheridp:user"),
				makeUser("bob2UserUID", "bob2", "otheridp:user2"),
			},
			CreateResponse: makeUser("bob3UserUID", "bob3", "idp:bob"),

			ExpectedActions: []test.Action{
				{Name: "GetUser", Object: "bob"},
				{Name: "GetUser", Object: "bob2"},
				{Name: "GetUser", Object: "bob3"},
				{Name: "CreateUser", Object: makeUser("", "bob3", "idp:bob")},
			},
			ExpectedUserName:   "bob3",
			ExpectedInitialize: true,
		},
	}

	for testCaseName, testCase := range testcases {
		testCase.run(testCaseName, t)
	}
}
