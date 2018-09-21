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
package imagestreammapping

import (
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/util/validation/field"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	"k8s.io/apiserver/pkg/storage/names"
	"k8s.io/kubernetes/pkg/api/legacyscheme"

	imageapi "github.com/openshift/origin/pkg/image/apis/image"
	"github.com/openshift/origin/pkg/image/apis/image/validation"
)

// Strategy implements behavior for image stream mappings.
type Strategy struct {
	runtime.ObjectTyper
	names.NameGenerator

	registryHostRetriever imageapi.RegistryHostnameRetriever
}

// Strategy is the default logic that applies when creating ImageStreamMapping
// objects via the REST API.
func NewStrategy(registryHost imageapi.RegistryHostnameRetriever) Strategy {
	return Strategy{
		ObjectTyper:           legacyscheme.Scheme,
		NameGenerator:         names.SimpleNameGenerator,
		registryHostRetriever: registryHost,
	}
}

// NamespaceScoped is true for image stream mappings.
func (s Strategy) NamespaceScoped() bool {
	return true
}

// PrepareForCreate clears fields that are not allowed to be set by end users on creation.
func (s Strategy) PrepareForCreate(ctx apirequest.Context, obj runtime.Object) {
	ism := obj.(*imageapi.ImageStreamMapping)
	if len(ism.Image.DockerImageReference) == 0 {
		internalRegistry, ok := s.registryHostRetriever.InternalRegistryHostname()
		if ok {
			ism.Image.DockerImageReference = imageapi.DockerImageReference{
				Registry:  internalRegistry,
				Namespace: ism.Namespace,
				Name:      ism.Name,
				ID:        ism.Image.Name,
			}.Exact()
		}
	}

	// signatures can be added using "images" or "imagesignatures" resources
	ism.Image.Signatures = nil
}

// Canonicalize normalizes the object after validation.
func (s Strategy) Canonicalize(obj runtime.Object) {
}

// Validate validates a new ImageStreamMapping.
func (s Strategy) Validate(ctx apirequest.Context, obj runtime.Object) field.ErrorList {
	mapping := obj.(*imageapi.ImageStreamMapping)
	return validation.ValidateImageStreamMapping(mapping)
}
