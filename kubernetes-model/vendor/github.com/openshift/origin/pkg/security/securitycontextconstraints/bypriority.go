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
package securitycontextconstraints

import (
	securityapi "github.com/openshift/origin/pkg/security/apis/security"
)

// ByRestrictions is a helper to sort SCCs based on priority.  If priorities are equal
// a string compare of the name is used.
type ByPriority []*securityapi.SecurityContextConstraints

func (s ByPriority) Len() int {
	return len(s)
}
func (s ByPriority) Swap(i, j int) { s[i], s[j] = s[j], s[i] }
func (s ByPriority) Less(i, j int) bool {
	iSCC := s[i]
	jSCC := s[j]

	iSCCPriority := getPriority(iSCC)
	jSCCPriority := getPriority(jSCC)

	// a higher priority is considered "less" so that it moves to the front of the line
	if iSCCPriority > jSCCPriority {
		return true
	}

	if iSCCPriority < jSCCPriority {
		return false
	}

	// priorities are equal, let's try point values
	iRestrictionScore := pointValue(iSCC)
	jRestrictionScore := pointValue(jSCC)

	// a lower restriction score is considered "less" so that it moves to the front of the line
	// (the greater the score, the more lax the SCC is)
	if iRestrictionScore < jRestrictionScore {
		return true
	}

	if iRestrictionScore > jRestrictionScore {
		return false
	}

	// they are still equal, sort by name
	return iSCC.Name < jSCC.Name
}

func getPriority(scc *securityapi.SecurityContextConstraints) int {
	if scc.Priority == nil {
		return 0
	}
	return int(*scc.Priority)
}
