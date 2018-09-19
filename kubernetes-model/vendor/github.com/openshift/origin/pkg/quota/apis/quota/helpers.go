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
package quota

import (
	"k8s.io/apimachinery/pkg/api/meta"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/labels"
	"k8s.io/apimachinery/pkg/runtime"
)

var accessor = meta.NewAccessor()

func GetMatcher(selector ClusterResourceQuotaSelector) (func(obj runtime.Object) (bool, error), error) {
	var labelSelector labels.Selector
	if selector.LabelSelector != nil {
		var err error
		labelSelector, err = metav1.LabelSelectorAsSelector(selector.LabelSelector)
		if err != nil {
			return nil, err
		}
	}

	var annotationSelector map[string]string
	if len(selector.AnnotationSelector) > 0 {
		// ensure our matcher has a stable copy of the map
		annotationSelector = make(map[string]string, len(selector.AnnotationSelector))
		for k, v := range selector.AnnotationSelector {
			annotationSelector[k] = v
		}
	}

	return func(obj runtime.Object) (bool, error) {
		if labelSelector != nil {
			objLabels, err := accessor.Labels(obj)
			if err != nil {
				return false, err
			}
			if !labelSelector.Matches(labels.Set(objLabels)) {
				return false, nil
			}
		}

		if annotationSelector != nil {
			objAnnotations, err := accessor.Annotations(obj)
			if err != nil {
				return false, err
			}
			for k, v := range annotationSelector {
				if objValue, exists := objAnnotations[k]; !exists || objValue != v {
					return false, nil
				}
			}
		}

		return true, nil
	}, nil
}

func GetObjectMatcher(selector ClusterResourceQuotaSelector) (func(obj metav1.Object) (bool, error), error) {
	var labelSelector labels.Selector
	if selector.LabelSelector != nil {
		var err error
		labelSelector, err = metav1.LabelSelectorAsSelector(selector.LabelSelector)
		if err != nil {
			return nil, err
		}
	}

	var annotationSelector map[string]string
	if len(selector.AnnotationSelector) > 0 {
		// ensure our matcher has a stable copy of the map
		annotationSelector = make(map[string]string, len(selector.AnnotationSelector))
		for k, v := range selector.AnnotationSelector {
			annotationSelector[k] = v
		}
	}

	return func(obj metav1.Object) (bool, error) {
		if labelSelector != nil {
			if !labelSelector.Matches(labels.Set(obj.GetLabels())) {
				return false, nil
			}
		}

		if annotationSelector != nil {
			objAnnotations := obj.GetAnnotations()
			for k, v := range annotationSelector {
				if objValue, exists := objAnnotations[k]; !exists || objValue != v {
					return false, nil
				}
			}
		}

		return true, nil
	}, nil
}
