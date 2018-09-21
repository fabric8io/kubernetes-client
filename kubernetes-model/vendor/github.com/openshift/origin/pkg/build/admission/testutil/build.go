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
package test

import (
	buildapi "github.com/openshift/origin/pkg/build/apis/build"
)

type TestBuild buildapi.Build

func Build() *TestBuild {
	b := (*TestBuild)(&buildapi.Build{})
	b.Name = "TestBuild"
	b.WithDockerStrategy()
	b.Spec.Source.Git = &buildapi.GitBuildSource{
		URI: "http://test.build/source",
	}
	b.Spec.TriggeredBy = []buildapi.BuildTriggerCause{}
	return b
}

// clearStrategy nil all strategies in the Spec since it is a
// common pattern to detect strategy by testing for non-nil.
func (b *TestBuild) clearStrategy() {
	b.Spec.Strategy.DockerStrategy = nil
	b.Spec.Strategy.SourceStrategy = nil
	b.Spec.Strategy.CustomStrategy = nil
	b.Spec.Strategy.JenkinsPipelineStrategy = nil
}

func (b *TestBuild) WithDockerStrategy() *TestBuild {
	b.clearStrategy()
	b.Spec.Strategy.DockerStrategy = &buildapi.DockerBuildStrategy{}
	return b
}

func (b *TestBuild) WithSourceStrategy() *TestBuild {
	b.clearStrategy()
	strategy := &buildapi.SourceBuildStrategy{}
	strategy.From.Name = "builder/image"
	strategy.From.Kind = "DockerImage"
	b.Spec.Strategy.SourceStrategy = strategy
	return b
}

func (b *TestBuild) WithCustomStrategy() *TestBuild {
	b.clearStrategy()
	strategy := &buildapi.CustomBuildStrategy{}
	strategy.From.Name = "builder/image"
	strategy.From.Kind = "DockerImage"
	b.Spec.Strategy.CustomStrategy = strategy
	return b
}

func (b *TestBuild) WithImageLabels(labels []buildapi.ImageLabel) *TestBuild {
	b.Spec.Output.ImageLabels = labels
	return b
}

func (b *TestBuild) WithNodeSelector(ns map[string]string) *TestBuild {
	b.Spec.NodeSelector = ns
	return b
}

func (b *TestBuild) AsBuild() *buildapi.Build {
	return (*buildapi.Build)(b)
}
