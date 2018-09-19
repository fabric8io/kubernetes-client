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
package fake

import (
	user "github.com/openshift/origin/pkg/user/apis/user"
	v1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	schema "k8s.io/apimachinery/pkg/runtime/schema"
	testing "k8s.io/client-go/testing"
)

// FakeUserIdentityMappings implements UserIdentityMappingInterface
type FakeUserIdentityMappings struct {
	Fake *FakeUser
}

var useridentitymappingsResource = schema.GroupVersionResource{Group: "user.openshift.io", Version: "", Resource: "useridentitymappings"}

var useridentitymappingsKind = schema.GroupVersionKind{Group: "user.openshift.io", Version: "", Kind: "UserIdentityMapping"}

// Get takes name of the userIdentityMapping, and returns the corresponding userIdentityMapping object, and an error if there is any.
func (c *FakeUserIdentityMappings) Get(name string, options v1.GetOptions) (result *user.UserIdentityMapping, err error) {
	obj, err := c.Fake.
		Invokes(testing.NewRootGetAction(useridentitymappingsResource, name), &user.UserIdentityMapping{})
	if obj == nil {
		return nil, err
	}
	return obj.(*user.UserIdentityMapping), err
}

// Create takes the representation of a userIdentityMapping and creates it.  Returns the server's representation of the userIdentityMapping, and an error, if there is any.
func (c *FakeUserIdentityMappings) Create(userIdentityMapping *user.UserIdentityMapping) (result *user.UserIdentityMapping, err error) {
	obj, err := c.Fake.
		Invokes(testing.NewRootCreateAction(useridentitymappingsResource, userIdentityMapping), &user.UserIdentityMapping{})
	if obj == nil {
		return nil, err
	}
	return obj.(*user.UserIdentityMapping), err
}

// Update takes the representation of a userIdentityMapping and updates it. Returns the server's representation of the userIdentityMapping, and an error, if there is any.
func (c *FakeUserIdentityMappings) Update(userIdentityMapping *user.UserIdentityMapping) (result *user.UserIdentityMapping, err error) {
	obj, err := c.Fake.
		Invokes(testing.NewRootUpdateAction(useridentitymappingsResource, userIdentityMapping), &user.UserIdentityMapping{})
	if obj == nil {
		return nil, err
	}
	return obj.(*user.UserIdentityMapping), err
}

// Delete takes name of the userIdentityMapping and deletes it. Returns an error if one occurs.
func (c *FakeUserIdentityMappings) Delete(name string, options *v1.DeleteOptions) error {
	_, err := c.Fake.
		Invokes(testing.NewRootDeleteAction(useridentitymappingsResource, name), &user.UserIdentityMapping{})
	return err
}
