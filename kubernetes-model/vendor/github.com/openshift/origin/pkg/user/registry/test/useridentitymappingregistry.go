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
package test

import (
	userapi "github.com/openshift/origin/pkg/user/apis/user"
)

type UserIdentityMappingRegistry struct {
	Err                        error
	Created                    bool
	UserIdentityMapping        *userapi.UserIdentityMapping
	CreatedUserIdentityMapping *userapi.UserIdentityMapping
}

func (r *UserIdentityMappingRegistry) GetUserIdentityMapping(name string) (*userapi.UserIdentityMapping, error) {
	return r.UserIdentityMapping, r.Err
}

func (r *UserIdentityMappingRegistry) CreateOrUpdateUserIdentityMapping(mapping *userapi.UserIdentityMapping) (*userapi.UserIdentityMapping, bool, error) {
	r.CreatedUserIdentityMapping = mapping
	return r.CreatedUserIdentityMapping, r.Created, r.Err
}
