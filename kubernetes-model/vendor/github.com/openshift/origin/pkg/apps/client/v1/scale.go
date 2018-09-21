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
package v1

import (
	extensionsv1beta1 "k8s.io/api/extensions/v1beta1"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	kextensionsclient "k8s.io/client-go/kubernetes/typed/extensions/v1beta1"

	appstypedclient "github.com/openshift/client-go/apps/clientset/versioned/typed/apps/v1"
)

type delegatingScaleInterface struct {
	dcs    appstypedclient.DeploymentConfigInterface
	scales kextensionsclient.ScaleInterface
}

type delegatingScaleNamespacer struct {
	dcNS    appstypedclient.DeploymentConfigsGetter
	scaleNS kextensionsclient.ScalesGetter
}

func (c *delegatingScaleNamespacer) Scales(namespace string) kextensionsclient.ScaleInterface {
	return &delegatingScaleInterface{
		dcs:    c.dcNS.DeploymentConfigs(namespace),
		scales: c.scaleNS.Scales(namespace),
	}
}

func NewDelegatingScaleNamespacer(dcNamespacer appstypedclient.DeploymentConfigsGetter, sNamespacer kextensionsclient.ScalesGetter) kextensionsclient.ScalesGetter {
	return &delegatingScaleNamespacer{
		dcNS:    dcNamespacer,
		scaleNS: sNamespacer,
	}
}

// Get takes the reference to scale subresource and returns the subresource or error, if one occurs.
func (c *delegatingScaleInterface) Get(kind string, name string) (result *extensionsv1beta1.Scale, err error) {
	switch {
	case kind == "DeploymentConfig":
		return c.dcs.GetScale(name, metav1.GetOptions{})
		// TODO: This is borked because the interface for Get is broken. Kind is insufficient.
	default:
		return c.scales.Get(kind, name)
	}
}

// Update takes a scale subresource object, updates the stored version to match it, and
// returns the subresource or error, if one occurs.
func (c *delegatingScaleInterface) Update(kind string, scale *extensionsv1beta1.Scale) (result *extensionsv1beta1.Scale, err error) {
	switch {
	case kind == "DeploymentConfig":
		return c.dcs.UpdateScale(scale.Name, scale)
		// TODO: This is borked because the interface for Update is broken. Kind is insufficient.
	default:
		return c.scales.Update(kind, scale)
	}
}
