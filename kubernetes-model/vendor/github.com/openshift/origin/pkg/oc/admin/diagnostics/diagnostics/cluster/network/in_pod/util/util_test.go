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
package util

import (
	"testing"
)

func TestTrimRegistryPath(t *testing.T) {
	testcases := map[string]struct {
		image         string
		expectedImage string
	}{
		"Empty image": {
			image:         "",
			expectedImage: "",
		},
		"Image with no slashes, no tags": {
			image:         "origin",
			expectedImage: "origin",
		},
		"Image with no slashes": {
			image:         "origin:v1.2.3",
			expectedImage: "origin:v1.2.3",
		},
		"Image with one slash, no tags": {
			image:         "openshift/origin",
			expectedImage: "openshift/origin",
		},
		"Image with one slash": {
			image:         "openshift/origin:v1.2.3",
			expectedImage: "openshift/origin:v1.2.3",
		},
		"Image with dns path, no port, no tags": {
			image:         "registry.access.redhat.com/openshift3/ose",
			expectedImage: "openshift3/ose",
		},
		"Image with dns path, no port": {
			image:         "registry.access.redhat.com/openshift3/ose:v1.2.3",
			expectedImage: "openshift3/ose:v1.2.3",
		},
		"Image with dns path": {
			image:         "registry.reg-aws.openshift.com:443/openshift3/ose:v1.2.3",
			expectedImage: "openshift3/ose:v1.2.3",
		},
	}

	for name, tc := range testcases {
		trimmedImage := trimRegistryPath(tc.image)
		if trimmedImage != tc.expectedImage {
			t.Fatalf("[%s] failed: expected %s but got %s", name, tc.expectedImage, trimmedImage)
		}
	}
}
