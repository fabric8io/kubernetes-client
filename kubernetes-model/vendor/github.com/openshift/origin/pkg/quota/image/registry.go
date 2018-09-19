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
// Package image implements evaluators of usage for imagestreams and images. They are supposed
// to be passed to resource quota controller and origin resource quota admission plugin.
package image

import (
	"k8s.io/apimachinery/pkg/runtime/schema"
	kapi "k8s.io/kubernetes/pkg/apis/core"
	"k8s.io/kubernetes/pkg/quota"
	"k8s.io/kubernetes/pkg/quota/generic"

	imageapi "github.com/openshift/origin/pkg/image/apis/image"
	imageinternalversion "github.com/openshift/origin/pkg/image/generated/informers/internalversion/image/internalversion"
	imageclient "github.com/openshift/origin/pkg/image/generated/internalclientset/typed/image/internalversion"
)

var legacyObjectCountAliases = map[schema.GroupVersionResource]kapi.ResourceName{
	imageapi.SchemeGroupVersion.WithResource("imagestreams"): imageapi.ResourceImageStreams,
}

// NewEvaluators returns the list of static evaluators that manage more than counts
func NewReplenishmentEvaluators(f quota.ListerForResourceFunc, isInformer imageinternalversion.ImageStreamInformer, imageClient imageclient.ImageStreamTagsGetter) []quota.Evaluator {
	// these evaluators have special logic
	result := []quota.Evaluator{
		NewImageStreamTagEvaluator(isInformer.Lister(), imageClient),
		NewImageStreamImportEvaluator(isInformer.Lister()),
	}
	// these evaluators require an alias for backwards compatibility
	for gvr, alias := range legacyObjectCountAliases {
		result = append(result,
			generic.NewObjectCountEvaluator(false, gvr.GroupResource(), generic.ListResourceUsingListerFunc(f, gvr), alias))
	}
	return result
}

// NewImageQuotaRegistryForAdmission returns a registry for quota evaluation of OpenShift resources related to images in
// internal registry. It evaluates only image streams and related virtual resources that can cause a creation
// of new image stream objects.
// This is different that is used for reconciliation because admission has to check all forms of a resource (legacy and groupified), but
// reconciliation only has to check one.
func NewReplenishmentEvaluatorsForAdmission(isInformer imageinternalversion.ImageStreamInformer, imageClient imageclient.ImageStreamTagsGetter) []quota.Evaluator {
	result := []quota.Evaluator{
		NewImageStreamTagEvaluator(isInformer.Lister(), imageClient),
		NewImageStreamImportEvaluator(isInformer.Lister()),
		&evaluatorForLegacyResource{
			Evaluator:           NewImageStreamTagEvaluator(isInformer.Lister(), imageClient),
			LegacyGroupResource: imageapi.LegacyResource("imagestreamtags"),
		},
		&evaluatorForLegacyResource{
			Evaluator:           NewImageStreamImportEvaluator(isInformer.Lister()),
			LegacyGroupResource: imageapi.LegacyResource("imagestreamimports"),
		},
	}
	// these evaluators require an alias for backwards compatibility
	for gvr, alias := range legacyObjectCountAliases {
		result = append(result,
			generic.NewObjectCountEvaluator(false, gvr.GroupResource(), generic.ListResourceUsingListerFunc(nil, gvr), alias))
	}
	// add the handling for the old resources
	result = append(result,
		generic.NewObjectCountEvaluator(
			false,
			imageapi.LegacyResource("imagestreams"),
			generic.ListResourceUsingListerFunc(nil, imageapi.SchemeGroupVersion.WithResource("imagestreams")),
			imageapi.ResourceImageStreams))

	return result
}

type evaluatorForLegacyResource struct {
	quota.Evaluator
	LegacyGroupResource schema.GroupResource
}

func (e *evaluatorForLegacyResource) GroupResource() schema.GroupResource {
	return e.LegacyGroupResource
}
