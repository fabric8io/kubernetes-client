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
package restrictusers

import (
	userapi "github.com/openshift/api/user/v1"
)

type fakeGroupCache struct {
	groups []userapi.Group
}

func (g fakeGroupCache) GroupsFor(user string) ([]*userapi.Group, error) {
	ret := []*userapi.Group{}
	for i := range g.groups {
		group := &g.groups[i]
		for _, currUser := range group.Users {
			if user == currUser {
				ret = append(ret, group)
				break
			}
		}

	}
	return ret, nil
}
