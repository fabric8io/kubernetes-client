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
package namespaceconditions

import (
	"k8s.io/apimachinery/pkg/util/sets"
	"k8s.io/apiserver/pkg/admission"
	corev1client "k8s.io/client-go/kubernetes/typed/core/v1"
	corev1lister "k8s.io/client-go/listers/core/v1"
)

// NamespaceLabelConditions provides a decorator that can delegate and conditionally add label conditions
type NamespaceLabelConditions struct {
	// TODO decorators are refactored in 1.10, so this is unnecessary and we'll get a nice chain
	Delegate admission.Decorator

	NamespaceClient corev1client.NamespacesGetter
	NamespaceLister corev1lister.NamespaceLister

	SkipLevelZeroNames sets.String
	SkipLevelOneNames  sets.String
}

func (d *NamespaceLabelConditions) WithNamespaceLabelConditions(admissionPlugin admission.Interface, name string) admission.Interface {
	delegateDecoratedAdmissionPlugin := d.Delegate(admissionPlugin, name)

	switch {
	case d.SkipLevelOneNames.Has(name):
		return &pluginHandlerWithNamespaceLabelConditions{
			admissionPlugin:   delegateDecoratedAdmissionPlugin,
			namespaceClient:   d.NamespaceClient,
			namespaceLister:   d.NamespaceLister,
			namespaceSelector: skipRunLevelOneSelector,
		}

	case d.SkipLevelZeroNames.Has(name):
		return &pluginHandlerWithNamespaceLabelConditions{
			admissionPlugin:   delegateDecoratedAdmissionPlugin,
			namespaceClient:   d.NamespaceClient,
			namespaceLister:   d.NamespaceLister,
			namespaceSelector: skipRunLevelZeroSelector,
		}

	default:
		return delegateDecoratedAdmissionPlugin
	}

}
