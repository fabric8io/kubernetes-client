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
package gitserver

import (
	"bytes"
	"strings"
	"testing"

	"k8s.io/apimachinery/pkg/runtime"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
	buildfake "github.com/openshift/origin/pkg/build/generated/internalclientset/fake"
)

func bc(name string, annotation string) *buildapi.BuildConfig {
	obj := &buildapi.BuildConfig{}
	obj.Name = name
	obj.Namespace = "test"
	obj.Annotations = map[string]string{}
	if len(annotation) > 0 {
		obj.Annotations[gitRepositoryAnnotationKey] = annotation
	}
	return obj
}

func TestGetRepositoryBuildConfigs(t *testing.T) {
	tests := []struct {
		name             string
		bcs              []runtime.Object
		searchFor        string
		shouldContain    []string
		shouldNotContain []string
	}{
		{
			name:             "find a named build config",
			bcs:              []runtime.Object{bc("bc1", ""), bc("bc2", ""), bc("bc3", "")},
			searchFor:        "bc2",
			shouldContain:    []string{"bc2"},
			shouldNotContain: []string{"bc1", "bc3"},
		},
		{
			name:             "find no match",
			bcs:              []runtime.Object{bc("bc1", ""), bc("bc2", "")},
			searchFor:        "bc3",
			shouldContain:    []string{},
			shouldNotContain: []string{"bc1", "bc2"},
		},
		{
			name:             "multiple matches",
			bcs:              []runtime.Object{bc("bc1", ""), bc("bc2", ""), bc("bc3", "bc2")},
			searchFor:        "bc2",
			shouldContain:    []string{"bc2", "bc3"},
			shouldNotContain: []string{"bc1"},
		},
		{
			name:             "match on annotation",
			bcs:              []runtime.Object{bc("bc1", "a1"), bc("bc2", ""), bc("bc3", "")},
			searchFor:        "a1",
			shouldContain:    []string{"bc1"},
			shouldNotContain: []string{"bc2", "bc3"},
		},
	}

	for _, test := range tests {
		client := buildfake.NewSimpleClientset(test.bcs...)
		output := &bytes.Buffer{}
		GetRepositoryBuildConfigs(client, test.searchFor, output)
		for _, c := range test.shouldContain {
			if !strings.Contains(output.String(), c) {
				t.Errorf("%s: output should contain %q. Output: %q", test.name, c, output.String())
			}
		}
		for _, c := range test.shouldNotContain {
			if strings.Contains(output.String(), c) {
				t.Errorf("%s: output should not contain %q. Output: %q", test.name, c, output.String())
			}
		}
	}
}
