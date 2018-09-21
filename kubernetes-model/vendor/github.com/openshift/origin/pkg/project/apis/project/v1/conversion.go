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
	"github.com/openshift/origin/pkg/api/apihelpers"
	"k8s.io/apimachinery/pkg/runtime"
)

func addConversionFuncs(scheme *runtime.Scheme) error {
	return nil
}

func addLegacyFieldSelectorKeyConversions(scheme *runtime.Scheme) error {
	if err := scheme.AddFieldLabelConversionFunc(LegacySchemeGroupVersion.String(), "Project", legacyProjectFieldSelectorKeyConversionFunc); err != nil {
		return err
	}
	return nil
}

func addFieldSelectorKeyConversions(scheme *runtime.Scheme) error {
	if err := scheme.AddFieldLabelConversionFunc(SchemeGroupVersion.String(), "Project", projectFieldSelectorKeyConversionFunc); err != nil {
		return err
	}
	return nil
}

// because field selectors can vary in support by version they are exposed under, we have one function for each
// groupVersion we're registering for
// we don't actually do any evaluation, only passing through, so we don't have our own field selector to test.  The upstream
// cannot remove the field selectors or they break compatibility, so we're fine.

func legacyProjectFieldSelectorKeyConversionFunc(label, value string) (internalLabel, internalValue string, err error) {
	switch label {
	case "status.phase":
		return label, value, nil
	default:
		return apihelpers.LegacyMetaV1FieldSelectorConversionWithName(label, value)
	}
}

func projectFieldSelectorKeyConversionFunc(label, value string) (internalLabel, internalValue string, err error) {
	switch label {
	case "status.phase":
		return label, value, nil
	default:
		return runtime.DefaultMetaV1FieldSelectorConversion(label, value)
	}
}
