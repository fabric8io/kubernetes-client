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
	"reflect"
	"testing"

	"k8s.io/apimachinery/pkg/util/diff"
	"k8s.io/kubernetes/pkg/api/legacyscheme"

	"github.com/openshift/api/image/v1"
	newer "github.com/openshift/origin/pkg/image/apis/image"

	_ "github.com/openshift/origin/pkg/image/apis/image/install"
)

func TestImageStreamStatusConversionPreservesTags(t *testing.T) {
	in := &newer.ImageStreamStatus{
		Tags: map[string]newer.TagEventList{
			"v3.5.0": {},
			"3.5.0":  {},
		},
	}
	expOutVersioned := &v1.ImageStreamStatus{
		Tags: []v1.NamedTagEventList{{Tag: "3.5.0"}, {Tag: "v3.5.0"}},
	}

	outVersioned := v1.ImageStreamStatus{Tags: []v1.NamedTagEventList{}}
	err := legacyscheme.Scheme.Convert(in, &outVersioned, nil)
	if err != nil {
		t.Fatalf("got unexpected error: %v", err)
	}
	if a, e := &outVersioned, expOutVersioned; !reflect.DeepEqual(a, e) {
		t.Fatalf("got unexpected output: %s", diff.ObjectDiff(a, e))
	}

	// convert back from v1 to internal scheme
	out := newer.ImageStreamStatus{}
	err = legacyscheme.Scheme.Convert(&outVersioned, &out, nil)
	if err != nil {
		t.Fatalf("got unexpected error: %v", err)
	}
	if a, e := &out, in; !reflect.DeepEqual(a, e) {
		t.Fatalf("got unexpected output: %s", diff.ObjectDiff(a, e))
	}
}
