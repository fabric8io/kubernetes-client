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
package build

import (
	"fmt"
	"testing"

	"k8s.io/api/core/v1"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
)

type testPodCreationStrategy struct {
	pod *v1.Pod
	err error
}

func (s *testPodCreationStrategy) CreateBuildPod(b *buildapi.Build) (*v1.Pod, error) {
	return s.pod, s.err
}

func TestStrategyCreateBuildPod(t *testing.T) {
	dockerBuildPod := &v1.Pod{}
	sourceBuildPod := &v1.Pod{}
	customBuildPod := &v1.Pod{}

	dockerBuild := &buildapi.Build{}
	dockerBuild.Spec.Strategy.DockerStrategy = &buildapi.DockerBuildStrategy{}

	sourceBuild := &buildapi.Build{}
	sourceBuild.Spec.Strategy.SourceStrategy = &buildapi.SourceBuildStrategy{}

	customBuild := &buildapi.Build{}
	customBuild.Spec.Strategy.CustomStrategy = &buildapi.CustomBuildStrategy{}

	pipelineBuild := &buildapi.Build{}
	pipelineBuild.Spec.Strategy.JenkinsPipelineStrategy = &buildapi.JenkinsPipelineBuildStrategy{}

	strategy := &typeBasedFactoryStrategy{
		dockerBuildStrategy: &testPodCreationStrategy{pod: dockerBuildPod},
		sourceBuildStrategy: &testPodCreationStrategy{pod: sourceBuildPod},
		customBuildStrategy: &testPodCreationStrategy{pod: customBuildPod},
	}
	strategyErr := fmt.Errorf("error")
	errorStrategy := &typeBasedFactoryStrategy{
		dockerBuildStrategy: &testPodCreationStrategy{err: strategyErr},
		sourceBuildStrategy: &testPodCreationStrategy{err: strategyErr},
		customBuildStrategy: &testPodCreationStrategy{err: strategyErr},
	}

	tests := []struct {
		strategy    buildPodCreationStrategy
		build       *buildapi.Build
		expectedPod *v1.Pod
		expectError bool
	}{
		{
			strategy:    strategy,
			build:       dockerBuild,
			expectedPod: dockerBuildPod,
		},
		{
			strategy:    strategy,
			build:       sourceBuild,
			expectedPod: sourceBuildPod,
		},
		{
			strategy:    strategy,
			build:       customBuild,
			expectedPod: customBuildPod,
		},
		{
			strategy:    strategy,
			build:       pipelineBuild,
			expectError: true,
		},
		{
			strategy:    strategy,
			build:       &buildapi.Build{},
			expectError: true,
		},
		{
			strategy:    errorStrategy,
			build:       dockerBuild,
			expectError: true,
		},
		{
			strategy:    errorStrategy,
			build:       sourceBuild,
			expectError: true,
		},
		{
			strategy:    errorStrategy,
			build:       customBuild,
			expectError: true,
		},
	}

	for _, test := range tests {
		pod, err := test.strategy.CreateBuildPod(test.build)
		if test.expectError {
			if err == nil {
				t.Errorf("Expected error but did not get one")
			}
			continue
		}
		if err != nil {
			t.Fatalf("unexpected error %v", err)
		}
		if pod != test.expectedPod {
			t.Errorf("did not get expected pod with build %#v", test.build)
		}
	}
}
