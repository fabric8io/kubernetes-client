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
package interfaces

import "gopkg.in/ldap.v2"

// LDAPGroupLister lists the LDAP groups that need to be synced by a job. The LDAPGroupLister needs to
// be paired with an LDAPMemberExtractor that understands the format of the unique identifiers returned
// to represent the LDAP groups to be synced.
type LDAPGroupLister interface {
	ListGroups() (ldapGroupUIDs []string, err error)
}

// LDAPMemberExtractor retrieves member data about an LDAP group from the LDAP server.
type LDAPMemberExtractor interface {
	// ExtractMembers returns the list of LDAP first-class user entries that are members of the LDAP group
	// specified by the ldapGroupUID
	ExtractMembers(ldapGroupUID string) (members []*ldap.Entry, err error)
}

// LDAPGroupNameMapper maps a ldapGroupUID representing an LDAP group to the OpenShift Group name for the resource
type LDAPGroupNameMapper interface {
	GroupNameFor(ldapGroupUID string) (openShiftGroupName string, err error)
}

// LDAPUserNameMapper maps an LDAP entry representing an LDAP user to the OpenShift User name for the resource
type LDAPUserNameMapper interface {
	UserNameFor(ldapUser *ldap.Entry) (openShiftUserName string, err error)
}

// LDAPGroupGetter maps a ldapGroupUID to a first-class LDAP group entry
type LDAPGroupGetter interface {
	GroupEntryFor(ldapGroupUID string) (group *ldap.Entry, err error)
}

type LDAPGroupListerNameMapper interface {
	LDAPGroupLister
	LDAPGroupNameMapper
}

// LDAPGroupDetector determines if a group identified by an LDAP group UID exists on the LDAP server
type LDAPGroupDetector interface {
	Exists(ldapGroupUID string) (exists bool, err error)
}
