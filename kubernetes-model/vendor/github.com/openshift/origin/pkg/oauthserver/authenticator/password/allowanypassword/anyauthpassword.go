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
	"strings"

	"github.com/golang/glog"

	"k8s.io/apiserver/pkg/authentication/authenticator"
	"k8s.io/apiserver/pkg/authentication/user"

	authapi "github.com/openshift/origin/pkg/oauthserver/api"
)

// alwaysAcceptPasswordAuthenticator approves any login attempt with non-blank username and password
type alwaysAcceptPasswordAuthenticator struct {
	providerName   string
	identityMapper authapi.UserIdentityMapper
}

// New creates a new password authenticator that approves any login attempt with non-blank username and password
func New(providerName string, identityMapper authapi.UserIdentityMapper) authenticator.Password {
	return &alwaysAcceptPasswordAuthenticator{providerName, identityMapper}
}

// AuthenticatePassword approves any login attempt with non-blank username and password
func (a alwaysAcceptPasswordAuthenticator) AuthenticatePassword(username, password string) (user.Info, bool, error) {
	// Since this IDP doesn't validate usernames or passwords, disallow usernames consisting entirely of spaces
	// Normalize usernames by removing leading/trailing spaces
	username = strings.TrimSpace(username)

	if username == "" || password == "" {
		return nil, false, nil
	}

	identity := authapi.NewDefaultUserIdentityInfo(a.providerName, username)
	user, err := a.identityMapper.UserFor(identity)
	if err != nil {
		glog.V(4).Infof("Error creating or updating mapping for: %#v due to %v", identity, err)
		return nil, false, err
	}
	glog.V(4).Infof("Got userIdentityMapping: %#v", user)

	return user, true, nil
}
