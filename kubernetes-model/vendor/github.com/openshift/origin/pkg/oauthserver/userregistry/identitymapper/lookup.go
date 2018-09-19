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
	"fmt"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	kuser "k8s.io/apiserver/pkg/authentication/user"

	userclient "github.com/openshift/client-go/user/clientset/versioned/typed/user/v1"
	authapi "github.com/openshift/origin/pkg/oauthserver/api"
)

var _ = authapi.UserIdentityMapper(&lookupIdentityMapper{})

// lookupIdentityMapper does not provision a new identity or user, it only allows identities already associated with users
type lookupIdentityMapper struct {
	mappings userclient.UserIdentityMappingInterface
	users    userclient.UserInterface
}

// UserFor returns info about the user for whom identity info has been provided
func (p *lookupIdentityMapper) UserFor(info authapi.UserIdentityInfo) (kuser.Info, error) {
	mapping, err := p.mappings.Get(info.GetIdentityName(), metav1.GetOptions{})
	if err != nil {
		return nil, NewLookupError(info, err)
	}

	u, err := p.users.Get(mapping.User.Name, metav1.GetOptions{})
	if err != nil {
		return nil, NewLookupError(info, err)
	}

	return &kuser.DefaultInfo{
		Name:   u.Name,
		UID:    string(u.UID),
		Groups: u.Groups,
	}, nil
}

type lookupError struct {
	Identity authapi.UserIdentityInfo
	CausedBy error
}

func IsLookupError(err error) bool {
	_, ok := err.(lookupError)
	return ok
}
func NewLookupError(info authapi.UserIdentityInfo, err error) error {
	return lookupError{Identity: info, CausedBy: err}
}

func (c lookupError) Error() string {
	return fmt.Sprintf("lookup of user for %q failed: %v", c.Identity.GetIdentityName(), c.CausedBy)
}
