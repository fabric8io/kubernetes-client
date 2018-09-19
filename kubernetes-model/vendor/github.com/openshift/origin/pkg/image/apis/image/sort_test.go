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
package image

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"

	"reflect"
	"testing"
	"time"
)

func TestSortStatusTags(t *testing.T) {
	tests := []struct {
		name     string
		tags     map[string]TagEventList
		expected []string
	}{
		{
			name: "all timestamps here",
			tags: map[string]TagEventList{
				"other": {
					Items: []TagEvent{
						{
							DockerImageReference: "other-ref",
							Created:              metav1.Date(2015, 9, 4, 13, 52, 0, 0, time.UTC),
							Image:                "other-image",
						},
					},
				},
				"latest": {
					Items: []TagEvent{
						{
							DockerImageReference: "latest-ref",
							Created:              metav1.Date(2015, 9, 4, 13, 53, 0, 0, time.UTC),
							Image:                "latest-image",
						},
					},
				},
				"third": {
					Items: []TagEvent{
						{
							DockerImageReference: "third-ref",
							Created:              metav1.Date(2015, 9, 4, 13, 54, 0, 0, time.UTC),
							Image:                "third-image",
						},
					},
				},
			},
			expected: []string{"third", "latest", "other"},
		},
	}

	for _, test := range tests {
		got := SortStatusTags(test.tags)
		if !reflect.DeepEqual(test.expected, got) {
			t.Errorf("%s: tags mismatch: expected %v, got %v", test.name, test.expected, got)
		}
	}
}
