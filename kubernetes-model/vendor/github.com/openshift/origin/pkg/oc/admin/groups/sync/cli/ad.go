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
	"github.com/openshift/origin/pkg/oc/admin/groups/sync/ad"
	"github.com/openshift/origin/pkg/oc/admin/groups/sync/interfaces"
)

var _ SyncBuilder = &ADBuilder{}
var _ PruneBuilder = &ADBuilder{}

type ADBuilder struct {
	ClientConfig ldapclient.Config
	Config       *config.ActiveDirectoryConfig

	adLDAPInterface *ad.ADLDAPInterface
}

func (b *ADBuilder) GetGroupLister() (interfaces.LDAPGroupLister, error) {
	return b.getADLDAPInterface()
}

func (b *ADBuilder) GetGroupNameMapper() (interfaces.LDAPGroupNameMapper, error) {
	return &syncgroups.DNLDAPGroupNameMapper{}, nil
}

func (b *ADBuilder) GetUserNameMapper() (interfaces.LDAPUserNameMapper, error) {
	return syncgroups.NewUserNameMapper(b.Config.UserNameAttributes), nil
}

func (b *ADBuilder) GetGroupMemberExtractor() (interfaces.LDAPMemberExtractor, error) {
	return b.getADLDAPInterface()
}

func (b *ADBuilder) getADLDAPInterface() (*ad.ADLDAPInterface, error) {
	if b.adLDAPInterface != nil {
		return b.adLDAPInterface, nil
	}

	userQuery, err := ldaputil.NewLDAPQuery(b.Config.AllUsersQuery)
	if err != nil {
		return nil, err
	}
	b.adLDAPInterface = ad.NewADLDAPInterface(b.ClientConfig,
		userQuery, b.Config.GroupMembershipAttributes, b.Config.UserNameAttributes)
	return b.adLDAPInterface, nil
}

func (b *ADBuilder) GetGroupDetector() (interfaces.LDAPGroupDetector, error) {
	return b.getADLDAPInterface()
}
