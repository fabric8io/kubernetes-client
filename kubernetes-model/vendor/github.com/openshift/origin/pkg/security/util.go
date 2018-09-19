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
package security

const (
	UIDRangeAnnotation = "openshift.io/sa.scc.uid-range"
	// SupplementalGroupsAnnotation contains a comma delimited list of allocated supplemental groups
	// for the namespace.  Groups are in the form of a Block which supports {start}/{length} or {start}-{end}
	SupplementalGroupsAnnotation = "openshift.io/sa.scc.supplemental-groups"
	MCSAnnotation                = "openshift.io/sa.scc.mcs"
	ValidatedSCCAnnotation       = "openshift.io/scc"
)
