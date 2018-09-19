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

func TestParallelIsRunnableNewBuilds(t *testing.T) {
	allNewBuilds := []buildapi.Build{
		addBuild("build-1", "sample-bc", buildapi.BuildPhaseNew, buildapi.BuildRunPolicyParallel),
		addBuild("build-2", "sample-bc", buildapi.BuildPhaseNew, buildapi.BuildRunPolicyParallel),
		addBuild("build-3", "sample-bc", buildapi.BuildPhaseNew, buildapi.BuildRunPolicyParallel),
	}
	client := newTestClient(allNewBuilds)
	policy := ParallelPolicy{BuildLister: client.Lister(), BuildUpdater: client}
	for _, build := range allNewBuilds {
		runnable, err := policy.IsRunnable(&build)
		if err != nil {
			t.Errorf("expected no error, got %v", err)
		}
		if !runnable {
			t.Errorf("expected build %s runnable, is not", build.Name)
		}
	}
}

func TestParallelIsRunnableMixedBuilds(t *testing.T) {
	mixedBuilds := []buildapi.Build{
		addBuild("build-4", "sample-bc", buildapi.BuildPhaseRunning, buildapi.BuildRunPolicyParallel),
		addBuild("build-6", "sample-bc", buildapi.BuildPhaseNew, buildapi.BuildRunPolicyParallel),
		addBuild("build-5", "sample-bc", buildapi.BuildPhasePending, buildapi.BuildRunPolicyParallel),
	}
	client := newTestClient(mixedBuilds)
	policy := ParallelPolicy{BuildLister: client.Lister(), BuildUpdater: client}
	for _, build := range mixedBuilds {
		runnable, err := policy.IsRunnable(&build)
		if err != nil {
			t.Errorf("expected no error, got %v", err)
		}
		if !runnable {
			t.Errorf("expected build %s runnable, is not", build.Name)
		}
	}
}

func TestParallelIsRunnableWithSerialRunning(t *testing.T) {
	mixedBuilds := []buildapi.Build{
		addBuild("build-7", "sample-bc", buildapi.BuildPhaseRunning, buildapi.BuildRunPolicySerial),
		addBuild("build-8", "sample-bc", buildapi.BuildPhaseNew, buildapi.BuildRunPolicyParallel),
		addBuild("build-9", "sample-bc", buildapi.BuildPhaseNew, buildapi.BuildRunPolicyParallel),
	}
	client := newTestClient(mixedBuilds)
	policy := ParallelPolicy{BuildLister: client.Lister(), BuildUpdater: client}
	for _, build := range mixedBuilds {
		runnable, err := policy.IsRunnable(&build)
		if err != nil {
			t.Errorf("expected no error, got %v", err)
		}
		if runnable {
			t.Errorf("expected build %s as not runnable", build.Name)
		}
	}
}
