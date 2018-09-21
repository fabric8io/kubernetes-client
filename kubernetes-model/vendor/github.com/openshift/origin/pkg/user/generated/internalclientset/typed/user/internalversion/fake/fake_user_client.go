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
	internalversion "github.com/openshift/origin/pkg/user/generated/internalclientset/typed/user/internalversion"
	rest "k8s.io/client-go/rest"
	testing "k8s.io/client-go/testing"
)

type FakeUser struct {
	*testing.Fake
}

func (c *FakeUser) Groups() internalversion.GroupInterface {
	return &FakeGroups{c}
}

func (c *FakeUser) Identities() internalversion.IdentityInterface {
	return &FakeIdentities{c}
}

func (c *FakeUser) Users() internalversion.UserResourceInterface {
	return &FakeUsers{c}
}

func (c *FakeUser) UserIdentityMappings() internalversion.UserIdentityMappingInterface {
	return &FakeUserIdentityMappings{c}
}

// RESTClient returns a RESTClient that is used to communicate
// with API server by this client implementation.
func (c *FakeUser) RESTClient() rest.Interface {
	var ret *rest.RESTClient
	return ret
}
