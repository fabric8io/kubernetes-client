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
package syncerror

import (
	"fmt"
)

func NewMemberLookupError(ldapGroupUID, ldapUserUID string, causedBy error) error {
	return &memberLookupError{ldapGroupUID: ldapGroupUID, ldapUserUID: ldapUserUID, causedBy: causedBy}
}

type memberLookupError struct {
	ldapGroupUID string
	ldapUserUID  string
	causedBy     error
}

func (e *memberLookupError) Error() string {
	return fmt.Sprintf("membership lookup for user %q in group %q failed because of %q", e.ldapUserUID, e.ldapGroupUID, e.causedBy.Error())
}

func IsMemberLookupError(e error) bool {
	if e == nil {
		return false
	}

	_, ok := e.(*memberLookupError)
	return ok
}
