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
package policy

import (
	"testing"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
)

func TestSerialIsRunnableNewBuilds(t *testing.T) {
	allNewBuilds := []buildapi.Build{
		addBuild("build-1", "sample-bc", buildapi.BuildPhaseNew, buildapi.BuildRunPolicySerial),
		addBuild("build-2", "sample-bc", buildapi.BuildPhaseNew, buildapi.BuildRunPolicySerial),
		addBuild("build-3", "sample-bc", buildapi.BuildPhaseNew, buildapi.BuildRunPolicySerial),
	}
	client := newTestClient(allNewBuilds)
	policy := SerialPolicy{BuildLister: client.Lister(), BuildUpdater: client}
	runnableBuilds := []string{
		"build-1",
	}
	shouldRun := func(name string) bool {
		for _, b := range runnableBuilds {
			if b == name {
				return true
			}
		}
		return false
	}
	shouldNotRun := func(name string) bool {
		return !shouldRun(name)
	}
	for _, build := range allNewBuilds {
		runnable, err := policy.IsRunnable(&build)
		if err != nil {
			t.Errorf("expected no error, got %v", err)
		}
		if runnable && shouldNotRun(build.Name) {
			t.Errorf("%s should not be runnable", build.Name)
		}
		if !runnable && shouldRun(build.Name) {
			t.Errorf("%s should be runnable, it is not", build.Name)
		}
	}
}
