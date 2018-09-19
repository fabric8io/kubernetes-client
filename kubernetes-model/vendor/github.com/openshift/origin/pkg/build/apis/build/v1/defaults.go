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

import "github.com/openshift/api/build/v1"

func SetDefaults_BuildConfigSpec(config *v1.BuildConfigSpec) {
	if len(config.RunPolicy) == 0 {
		config.RunPolicy = v1.BuildRunPolicySerial
	}
}

func SetDefaults_BuildSource(source *v1.BuildSource) {
	if (source != nil) && (source.Type == v1.BuildSourceBinary) && (source.Binary == nil) {
		source.Binary = &v1.BinaryBuildSource{}
	}
}

func SetDefaults_BuildStrategy(strategy *v1.BuildStrategy) {
	if (strategy != nil) && (strategy.Type == v1.DockerBuildStrategyType) && (strategy.DockerStrategy == nil) {
		strategy.DockerStrategy = &v1.DockerBuildStrategy{}
	}
}

func SetDefaults_SourceBuildStrategy(obj *v1.SourceBuildStrategy) {
	if len(obj.From.Kind) == 0 {
		obj.From.Kind = "ImageStreamTag"
	}
}

func SetDefaults_DockerBuildStrategy(obj *v1.DockerBuildStrategy) {
	if obj.From != nil && len(obj.From.Kind) == 0 {
		obj.From.Kind = "ImageStreamTag"
	}
}

func SetDefaults_CustomBuildStrategy(obj *v1.CustomBuildStrategy) {
	if len(obj.From.Kind) == 0 {
		obj.From.Kind = "ImageStreamTag"
	}
}

func SetDefaults_BuildTriggerPolicy(obj *v1.BuildTriggerPolicy) {
	if obj.Type == v1.ImageChangeBuildTriggerType && obj.ImageChange == nil {
		obj.ImageChange = &v1.ImageChangeTrigger{}
	}
}
