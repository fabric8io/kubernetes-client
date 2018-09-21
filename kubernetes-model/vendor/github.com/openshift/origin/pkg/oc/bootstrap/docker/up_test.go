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
package docker

import (
	"testing"

	"github.com/openshift/origin/pkg/oc/bootstrap"
)

// TestBootstrapFiles ensures that the files that are used for
// Bootstrapping a cluster are available.
func TestBootstrapFiles(t *testing.T) {
	templateMaps := []map[string]string{
		imageStreams,
		templateLocations,
	}
	for _, templateMap := range templateMaps {
		for _, location := range templateMap {
			_, err := bootstrap.Asset(location)
			if err != nil {
				t.Errorf("Error getting asset at: %s", location)
			}
		}
	}
}
