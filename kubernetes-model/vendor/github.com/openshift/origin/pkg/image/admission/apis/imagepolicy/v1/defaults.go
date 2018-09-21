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

import (
	"k8s.io/apimachinery/pkg/runtime"
	kapi "k8s.io/kubernetes/pkg/apis/core"
)

func SetDefaults_ImagePolicyConfig(obj *ImagePolicyConfig) {
	if obj == nil {
		return
	}

	if len(obj.ResolveImages) == 0 {
		obj.ResolveImages = Attempt
	}

	for i := range obj.ExecutionRules {
		if len(obj.ExecutionRules[i].OnResources) == 0 {
			obj.ExecutionRules[i].OnResources = []GroupResource{{Resource: "pods", Group: kapi.GroupName}}
		}
	}

	if obj.ResolutionRules == nil {
		obj.ResolutionRules = []ImageResolutionPolicyRule{
			{TargetResource: GroupResource{Resource: "pods"}, LocalNames: true},
			{TargetResource: GroupResource{Group: "build.openshift.io", Resource: "builds"}, LocalNames: true},
			{TargetResource: GroupResource{Group: "batch", Resource: "jobs"}, LocalNames: true},
			{TargetResource: GroupResource{Group: "extensions", Resource: "replicasets"}, LocalNames: true},
			{TargetResource: GroupResource{Resource: "replicationcontrollers"}, LocalNames: true},
			{TargetResource: GroupResource{Group: "apps", Resource: "deployments"}, LocalNames: true},
			{TargetResource: GroupResource{Group: "extensions", Resource: "deployments"}, LocalNames: true},
			{TargetResource: GroupResource{Group: "apps", Resource: "statefulsets"}, LocalNames: true},
			{TargetResource: GroupResource{Group: "extensions", Resource: "daemonsets"}, LocalNames: true},
		}
		// default the resolution policy to the global default
		for i := range obj.ResolutionRules {
			if len(obj.ResolutionRules[i].Policy) != 0 {
				continue
			}
			obj.ResolutionRules[i].Policy = DoNotAttempt
			for _, rule := range obj.ExecutionRules {
				if executionRuleCoversResource(rule, obj.ResolutionRules[i].TargetResource) {
					obj.ResolutionRules[i].Policy = obj.ResolveImages
					break
				}
			}
		}
	}
}

func addDefaultingFuncs(scheme *runtime.Scheme) error {
	scheme.AddTypeDefaultingFunc(&ImagePolicyConfig{}, func(obj interface{}) { SetDefaults_ImagePolicyConfig(obj.(*ImagePolicyConfig)) })
	return nil
}

// executionRuleCoversResource returns true if gr is covered by rule.
func executionRuleCoversResource(rule ImageExecutionPolicyRule, gr GroupResource) bool {
	for _, target := range rule.OnResources {
		if target.Group == gr.Group && (target.Resource == gr.Resource || target.Resource == "*") {
			return true
		}
	}
	return false
}
