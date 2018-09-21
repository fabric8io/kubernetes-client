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
package syncgroups

import (
	"fmt"

	"gopkg.in/ldap.v2"

	"github.com/openshift/origin/pkg/oauthserver/ldaputil"
	"github.com/openshift/origin/pkg/oc/admin/groups/sync/interfaces"
)

// NewUserNameMapper returns a new DefaultLDAPGroupUserNameMapper
func NewUserNameMapper(nameAttributes []string) interfaces.LDAPUserNameMapper {
	return &DefaultLDAPUserNameMapper{
		nameAttributes: nameAttributes,
	}
}

// DefaultLDAPUserNameMapper extracts the OpenShift User name of an LDAP entry representing
// a user in a deterministic manner
type DefaultLDAPUserNameMapper struct {
	nameAttributes []string
}

func (m *DefaultLDAPUserNameMapper) UserNameFor(ldapUser *ldap.Entry) (string, error) {
	openShiftUserName := ldaputil.GetAttributeValue(ldapUser, m.nameAttributes)
	if len(openShiftUserName) == 0 {
		return "", fmt.Errorf("the user entry (%v) does not map to a OpenShift User name with the given mapping",
			ldapUser)
	}
	return openShiftUserName, nil
}
