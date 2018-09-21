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
package apitesting

import (
	"testing"

	"k8s.io/apimachinery/pkg/fields"
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/runtime/schema"
)

// FieldKeyCheck gathers information to check if the field key conversions are working correctly.  It takes many parameters
// in an attempt to reflect reality
type FieldKeyCheck struct {
	SchemeBuilder            runtime.SchemeBuilder
	Kind                     schema.GroupVersionKind
	AllowedExternalFieldKeys []string
	FieldKeyEvaluatorFn      FieldKeyEvaluator
}

func (f FieldKeyCheck) Check(t *testing.T) {
	scheme := runtime.NewScheme()
	f.SchemeBuilder.AddToScheme(scheme)
	internalObj, err := scheme.New(f.Kind.GroupKind().WithVersion(runtime.APIVersionInternal))
	if err != nil {
		t.Errorf("unable to new up %v", f.Kind)
	}

	for _, externalFieldKey := range f.AllowedExternalFieldKeys {
		internalFieldKey, _, err := scheme.ConvertFieldLabel(f.Kind.GroupVersion().String(), f.Kind.Kind, externalFieldKey, "")
		if err != nil {
			t.Errorf("illegal field conversion %q for %v", externalFieldKey, f.Kind)
			continue
		}
		// we get this by default
		if internalFieldKey == "metadata.name" {
			continue
		}

		fieldSet := fields.Set{}
		if err := f.FieldKeyEvaluatorFn(internalObj, fieldSet); err != nil {
			t.Errorf("unable to valuate field keys for %v: %v", f.Kind, err)
			continue
		}

		found := false
		for actualInternalFieldKey := range fieldSet {
			if internalFieldKey == actualInternalFieldKey {
				found = true
				break
			}
		}
		if !found {
			t.Errorf("%q converted to %q which has no internal field key match for %v", externalFieldKey, internalFieldKey, f.Kind)
			continue
		}

	}

}

// FieldKeyEvaluator overlaps with the storage mutation func.  We use this to confirm that the non-meta fields are actually being handled
type FieldKeyEvaluator func(obj runtime.Object, fieldSet fields.Set) error
