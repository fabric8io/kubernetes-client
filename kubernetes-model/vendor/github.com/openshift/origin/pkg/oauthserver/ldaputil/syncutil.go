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
package ldaputil

// These constants contain values for annotations and labels affixed to Groups by the LDAP sync job
const (
	// LDAPHostLabel is the Label value that stores the host of the LDAP server
	// TODO: we don't store port here because labels don't allow for colons. We might want to add this back
	// with a different separator
	LDAPHostLabel string = "openshift.io/ldap.host"

	// LDAPURLAnnotation is the Annotation value that stores the host:port of the LDAP server
	LDAPURLAnnotation string = "openshift.io/ldap.url"
	// LDAPUIDAnnotation is the Annotation value that stores the corresponding LDAP group UID for the Group
	LDAPUIDAnnotation string = "openshift.io/ldap.uid"
	// LDAPSyncTime is the Annotation value that stores the last time this Group was synced with LDAP
	LDAPSyncTimeAnnotation string = "openshift.io/ldap.sync-time"
)
