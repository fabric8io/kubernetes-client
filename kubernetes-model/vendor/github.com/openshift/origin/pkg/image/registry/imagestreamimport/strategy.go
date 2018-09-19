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
package imagestreamimport

import (
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/util/validation/field"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	"k8s.io/kubernetes/pkg/api/legacyscheme"

	imageapi "github.com/openshift/origin/pkg/image/apis/image"
	"github.com/openshift/origin/pkg/image/apis/image/validation"
	"github.com/openshift/origin/pkg/image/apis/image/validation/whitelist"
)

// strategy implements behavior for ImageStreamImports.
type strategy struct {
	runtime.ObjectTyper
	registryWhitelister whitelist.RegistryWhitelister
}

func NewStrategy(rw whitelist.RegistryWhitelister) *strategy {
	return &strategy{
		ObjectTyper:         legacyscheme.Scheme,
		registryWhitelister: rw,
	}
}

func (s *strategy) NamespaceScoped() bool {
	return true
}

func (s *strategy) GenerateName(string) string {
	return ""
}

func (s *strategy) Canonicalize(runtime.Object) {
}

func (s *strategy) ValidateAllowedRegistries(isi *imageapi.ImageStreamImport) field.ErrorList {
	errs := field.ErrorList{}
	validate := func(path *field.Path, name string, insecure bool) field.ErrorList {
		ref, _ := imageapi.ParseDockerImageReference(name)
		registryHost, registryPort := ref.RegistryHostPort(insecure)
		return validation.ValidateRegistryAllowedForImport(s.registryWhitelister, path.Child("from", "name"), ref.Name, registryHost, registryPort)
	}
	if spec := isi.Spec.Repository; spec != nil && spec.From.Kind == "DockerImage" {
		errs = append(errs, validate(field.NewPath("spec").Child("repository"), spec.From.Name, spec.ImportPolicy.Insecure)...)
	}
	if len(isi.Spec.Images) > 0 {
		for i, image := range isi.Spec.Images {
			errs = append(errs, validate(field.NewPath("spec").Child("images").Index(i), image.From.Name, image.ImportPolicy.Insecure)...)
		}
	}
	return errs
}

func (s *strategy) PrepareForCreate(ctx apirequest.Context, obj runtime.Object) {
	newIST := obj.(*imageapi.ImageStreamImport)
	newIST.Status = imageapi.ImageStreamImportStatus{}
}

func (s *strategy) PrepareImageForCreate(obj runtime.Object) {
	image := obj.(*imageapi.Image)

	// signatures can be added using "images" or "imagesignatures" resources
	image.Signatures = nil

	// Remove the raw manifest as it's very big and this leads to a large memory consumption in etcd.
	image.DockerImageManifest = ""
	image.DockerImageConfig = ""
}

func (s *strategy) Validate(ctx apirequest.Context, obj runtime.Object) field.ErrorList {
	isi := obj.(*imageapi.ImageStreamImport)
	return validation.ValidateImageStreamImport(isi)
}
