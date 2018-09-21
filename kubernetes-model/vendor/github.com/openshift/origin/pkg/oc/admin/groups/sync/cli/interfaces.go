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
	"github.com/openshift/origin/pkg/oc/admin/groups/sync/interfaces"
	usertypedclient "github.com/openshift/origin/pkg/user/generated/internalclientset/typed/user/internalversion"
)

// SyncBuilder describes an object that can build all the schema-specific parts of an LDAPGroupSyncer
type SyncBuilder interface {
	GetGroupLister() (interfaces.LDAPGroupLister, error)
	GetGroupNameMapper() (interfaces.LDAPGroupNameMapper, error)
	GetUserNameMapper() (interfaces.LDAPUserNameMapper, error)
	GetGroupMemberExtractor() (interfaces.LDAPMemberExtractor, error)
}

// PruneBuilder describes an object that can build all the schema-specific parts of an LDAPGroupPruner
type PruneBuilder interface {
	GetGroupLister() (interfaces.LDAPGroupLister, error)
	GetGroupNameMapper() (interfaces.LDAPGroupNameMapper, error)
	GetGroupDetector() (interfaces.LDAPGroupDetector, error)
}

// GroupNameRestrictions desribes an object that holds blacklists and whitelists
type GroupNameRestrictions interface {
	GetWhitelist() []string
	GetBlacklist() []string
}

// OpenShiftGroupNameRestrictions describes an object that holds blacklists and whitelists as well as
// a client that can retrieve OpenShift groups to satisfy those lists
type OpenShiftGroupNameRestrictions interface {
	GroupNameRestrictions
	GetClient() usertypedclient.GroupInterface
}

// MappedNameRestrictions describes an object that holds user name mappings for a group sync job
type MappedNameRestrictions interface {
	GetGroupNameMappings() map[string]string
}
