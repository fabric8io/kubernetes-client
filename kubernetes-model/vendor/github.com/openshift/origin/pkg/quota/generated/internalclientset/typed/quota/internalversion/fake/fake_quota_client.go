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
	internalversion "github.com/openshift/origin/pkg/quota/generated/internalclientset/typed/quota/internalversion"
	rest "k8s.io/client-go/rest"
	testing "k8s.io/client-go/testing"
)

type FakeQuota struct {
	*testing.Fake
}

func (c *FakeQuota) AppliedClusterResourceQuotas(namespace string) internalversion.AppliedClusterResourceQuotaInterface {
	return &FakeAppliedClusterResourceQuotas{c, namespace}
}

func (c *FakeQuota) ClusterResourceQuotas() internalversion.ClusterResourceQuotaInterface {
	return &FakeClusterResourceQuotas{c}
}

// RESTClient returns a RESTClient that is used to communicate
// with API server by this client implementation.
func (c *FakeQuota) RESTClient() rest.Interface {
	var ret *rest.RESTClient
	return ret
}
