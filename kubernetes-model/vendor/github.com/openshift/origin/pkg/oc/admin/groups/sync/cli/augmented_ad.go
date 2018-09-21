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

var _ SyncBuilder = &AugmentedADBuilder{}
var _ PruneBuilder = &AugmentedADBuilder{}

type AugmentedADBuilder struct {
	ClientConfig ldapclient.Config
	Config       *config.AugmentedActiveDirectoryConfig

	augmentedADLDAPInterface *ad.AugmentedADLDAPInterface
}

func (b *AugmentedADBuilder) GetGroupLister() (interfaces.LDAPGroupLister, error) {
	return b.getAugmentedADLDAPInterface()
}

func (b *AugmentedADBuilder) GetGroupNameMapper() (interfaces.LDAPGroupNameMapper, error) {
	ldapInterface, err := b.getAugmentedADLDAPInterface()
	if err != nil {
		return nil, err
	}
	if b.Config.GroupNameAttributes != nil {
		return syncgroups.NewEntryAttributeGroupNameMapper(b.Config.GroupNameAttributes, ldapInterface), nil
	}

	return nil, nil
}

func (b *AugmentedADBuilder) GetUserNameMapper() (interfaces.LDAPUserNameMapper, error) {
	return syncgroups.NewUserNameMapper(b.Config.UserNameAttributes), nil
}

func (b *AugmentedADBuilder) GetGroupMemberExtractor() (interfaces.LDAPMemberExtractor, error) {
	return b.getAugmentedADLDAPInterface()
}

func (b *AugmentedADBuilder) getAugmentedADLDAPInterface() (*ad.AugmentedADLDAPInterface, error) {
	if b.augmentedADLDAPInterface != nil {
		return b.augmentedADLDAPInterface, nil
	}

	userQuery, err := ldaputil.NewLDAPQuery(b.Config.AllUsersQuery)
	if err != nil {
		return nil, err
	}
	groupQuery, err := ldaputil.NewLDAPQueryOnAttribute(b.Config.AllGroupsQuery, b.Config.GroupUIDAttribute)
	if err != nil {
		return nil, err
	}
	b.augmentedADLDAPInterface = ad.NewAugmentedADLDAPInterface(b.ClientConfig,
		userQuery, b.Config.GroupMembershipAttributes, b.Config.UserNameAttributes,
		groupQuery, b.Config.GroupNameAttributes)
	return b.augmentedADLDAPInterface, nil
}

func (b *AugmentedADBuilder) GetGroupDetector() (interfaces.LDAPGroupDetector, error) {
	return b.getAugmentedADLDAPInterface()
}
