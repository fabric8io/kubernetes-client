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
package defaults

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	kapi "k8s.io/kubernetes/pkg/apis/core"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
)

const BuildDefaultsPlugin = "BuildDefaults"

// +k8s:deepcopy-gen:interfaces=k8s.io/apimachinery/pkg/runtime.Object

// BuildDefaultsConfig controls the default information for Builds
type BuildDefaultsConfig struct {
	metav1.TypeMeta

	// gitHTTPProxy is the location of the HTTPProxy for Git source
	GitHTTPProxy string

	// gitHTTPSProxy is the location of the HTTPSProxy for Git source
	GitHTTPSProxy string

	// gitNoProxy is the list of domains for which the proxy should not be used
	GitNoProxy string

	// env is a set of default environment variables that will be applied to the
	// build if the specified variables do not exist on the build
	Env []kapi.EnvVar

	// sourceStrategyDefaults are default values that apply to builds using the
	// source strategy.
	SourceStrategyDefaults *SourceStrategyDefaultsConfig

	// imageLabels is a list of docker labels that are applied to the resulting image.
	// User can override a default label by providing a label with the same name in their
	// Build/BuildConfig.
	ImageLabels []buildapi.ImageLabel

	// nodeSelector is a selector which must be true for the build pod to fit on a node
	NodeSelector map[string]string

	// annotations are annotations that will be added to the build pod
	Annotations map[string]string

	// resources defines resource requirements to execute the build.
	Resources kapi.ResourceRequirements
}

// SourceStrategyDefaultsConfig contains values that apply to builds using the
// source strategy.
type SourceStrategyDefaultsConfig struct {

	// Incremental indicates if s2i build strategies should perform an incremental
	// build or not
	Incremental *bool
}
