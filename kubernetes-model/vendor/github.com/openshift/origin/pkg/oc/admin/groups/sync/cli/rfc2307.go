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
package cli

import (
	"github.com/openshift/origin/pkg/cmd/server/apis/config"
	"github.com/openshift/origin/pkg/oauthserver/ldaputil"
	"github.com/openshift/origin/pkg/oauthserver/ldaputil/ldapclient"
	"github.com/openshift/origin/pkg/oc/admin/groups/sync"
	"github.com/openshift/origin/pkg/oc/admin/groups/sync/interfaces"
	"github.com/openshift/origin/pkg/oc/admin/groups/sync/rfc2307"
	"github.com/openshift/origin/pkg/oc/admin/groups/sync/syncerror"
)

var _ SyncBuilder = &RFC2307Builder{}
var _ PruneBuilder = &RFC2307Builder{}

type RFC2307Builder struct {
	ClientConfig ldapclient.Config
	Config       *config.RFC2307Config

	rfc2307LDAPInterface *rfc2307.LDAPInterface

	ErrorHandler syncerror.Handler
}

func (b *RFC2307Builder) GetGroupLister() (interfaces.LDAPGroupLister, error) {
	return b.getRFC2307LDAPInterface()
}

func (b *RFC2307Builder) GetGroupNameMapper() (interfaces.LDAPGroupNameMapper, error) {
	ldapInterface, err := b.getRFC2307LDAPInterface()
	if err != nil {
		return nil, err
	}
	if b.Config.GroupNameAttributes != nil {
		return syncgroups.NewEntryAttributeGroupNameMapper(b.Config.GroupNameAttributes, ldapInterface), nil
	}

	return nil, nil
}

func (b *RFC2307Builder) GetUserNameMapper() (interfaces.LDAPUserNameMapper, error) {
	return syncgroups.NewUserNameMapper(b.Config.UserNameAttributes), nil
}

func (b *RFC2307Builder) GetGroupMemberExtractor() (interfaces.LDAPMemberExtractor, error) {
	return b.getRFC2307LDAPInterface()
}

func (b *RFC2307Builder) getRFC2307LDAPInterface() (*rfc2307.LDAPInterface, error) {
	if b.rfc2307LDAPInterface != nil {
		return b.rfc2307LDAPInterface, nil
	}

	groupQuery, err := ldaputil.NewLDAPQueryOnAttribute(b.Config.AllGroupsQuery, b.Config.GroupUIDAttribute)
	if err != nil {
		return nil, err
	}
	userQuery, err := ldaputil.NewLDAPQueryOnAttribute(b.Config.AllUsersQuery, b.Config.UserUIDAttribute)
	if err != nil {
		return nil, err
	}
	b.rfc2307LDAPInterface = rfc2307.NewLDAPInterface(b.ClientConfig,
		groupQuery, b.Config.GroupNameAttributes, b.Config.GroupMembershipAttributes,
		userQuery, b.Config.UserNameAttributes, b.ErrorHandler)
	return b.rfc2307LDAPInterface, nil
}

func (b *RFC2307Builder) GetGroupDetector() (interfaces.LDAPGroupDetector, error) {
	return b.getRFC2307LDAPInterface()
}
