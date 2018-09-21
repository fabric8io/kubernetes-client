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
	v1beta1 "k8s.io/api/extensions/v1beta1"
	testing "k8s.io/client-go/testing"
)

// UpdateScale takes the representation of a scale and updates it. Returns the server's representation of the scale, and an error, if t
func (c *FakeDeploymentConfigs) UpdateScale(deploymentConfigName string, scale *v1beta1.Scale) (result *v1beta1.Scale, err error) {
	obj, err := c.Fake.
		Invokes(testing.NewUpdateSubresourceAction(deploymentconfigsResource, "scale", c.ns, scale), &v1beta1.Scale{})

	if obj == nil {
		return nil, err
	}
	return obj.(*v1beta1.Scale), err
}
