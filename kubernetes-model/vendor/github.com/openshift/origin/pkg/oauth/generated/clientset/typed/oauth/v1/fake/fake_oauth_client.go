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
	v1 "github.com/openshift/origin/pkg/oauth/generated/clientset/typed/oauth/v1"
	rest "k8s.io/client-go/rest"
	testing "k8s.io/client-go/testing"
)

type FakeOauthV1 struct {
	*testing.Fake
}

func (c *FakeOauthV1) OAuthAccessTokens() v1.OAuthAccessTokenInterface {
	return &FakeOAuthAccessTokens{c}
}

func (c *FakeOauthV1) OAuthAuthorizeTokens() v1.OAuthAuthorizeTokenInterface {
	return &FakeOAuthAuthorizeTokens{c}
}

func (c *FakeOauthV1) OAuthClients() v1.OAuthClientInterface {
	return &FakeOAuthClients{c}
}

func (c *FakeOauthV1) OAuthClientAuthorizations() v1.OAuthClientAuthorizationInterface {
	return &FakeOAuthClientAuthorizations{c}
}

// RESTClient returns a RESTClient that is used to communicate
// with API server by this client implementation.
func (c *FakeOauthV1) RESTClient() rest.Interface {
	var ret *rest.RESTClient
	return ret
}
