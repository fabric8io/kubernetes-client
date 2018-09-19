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
package admission

import (
	"testing"

	"k8s.io/apimachinery/pkg/util/sets"
	"k8s.io/apiserver/pkg/admission"
	kubeapiserver "k8s.io/kubernetes/cmd/kube-apiserver/app/options"

	imageadmission "github.com/openshift/origin/pkg/image/admission"
)

var admissionPluginsNotUsedByKube = sets.NewString(
	"AlwaysAdmit",            // from kube, no need for this by default
	"AlwaysDeny",             // from kube, no need for this by default
	"AlwaysPullImages",       // from kube, not enabled by default.  This is only applicable to some environments.  This will ensure that containers cannot use pre-pulled copies of images without authorization.
	"NamespaceAutoProvision", // from kube, it creates a namespace if a resource is created in a non-existent namespace.  We don't want this behavior
	"SecurityContextDeny",    // from kube, it denies pods that want to use SCC capabilities.  We have different rules to allow this in openshift.
	"DenyExecOnPrivileged",   // from kube (deprecated, see below), it denies exec to pods that have certain privileges.  This is superseded in origin by SCCExecRestrictions that checks against SCC rules.
	"DenyEscalatingExec",     // from kube, it denies exec to pods that have certain privileges.  This is superseded in origin by SCCExecRestrictions that checks against SCC rules.
	"PodSecurityPolicy",      // from kube, this will eventually replace SecurityContextConstraints but for now origin does not use it.
	"ResourceQuota",          // from kube, we replace this with quotaadmission.PluginName

	"BuildByStrategy",                        // from origin, only needed for managing builds, not kubernetes resources
	imageadmission.PluginName,                // from origin, used for limiting image sizes, not kubernetes resources
	"openshift.io/JenkinsBootstrapper",       // from origin, only needed for managing builds, not kubernetes resources
	"openshift.io/BuildConfigSecretInjector", // from origin, only needed for managing builds, not kubernetes resources
	"OriginNamespaceLifecycle",               // from origin, only needed for rejecting openshift resources, so not needed by kube
	"ProjectRequestLimit",                    // from origin, used for limiting project requests by user (online use case)
	"openshift.io/RestrictSubjectBindings",   // from origin, used for enforcing rolebindingrestrictions, not kubernetes resources
	"RunOnceDuration",                        // from origin, used for overriding the ActiveDeadlineSeconds for run-once pods

	"NamespaceExists",  // superseded by NamespaceLifecycle
	"InitialResources", // do we want this? https://github.com/kubernetes/kubernetes/blob/master/docs/proposals/initial-resources.md

	"PodPreset",                // alpha in kube 1.6, not on by default
	"DefaultTolerationSeconds", // alpha, not on by default

	// TODO do we want these:
	"EventRateLimit",
	"PersistentVolumeClaimResize",
	"Priority",
)

func TestKubeAdmissionControllerUsage(t *testing.T) {
	kubeapiserver.RegisterAllAdmissionPlugins(admission.NewPlugins())
	registeredKubePlugins := sets.NewString(OriginAdmissionPlugins.Registered()...)

	usedAdmissionPlugins := sets.NewString(kubeAdmissionPlugins...)

	if missingPlugins := usedAdmissionPlugins.Difference(registeredKubePlugins); len(missingPlugins) != 0 {
		t.Errorf("%v not found", missingPlugins.List())
	}

	if notUsed := registeredKubePlugins.Difference(usedAdmissionPlugins); len(notUsed) != 0 {
		for pluginName := range notUsed {
			if !admissionPluginsNotUsedByKube.Has(pluginName) {
				t.Errorf("%v not used", pluginName)
			}
		}
	}
}

func TestAdmissionOnOffCoverage(t *testing.T) {
	configuredAdmissionPlugins := sets.NewString(combinedAdmissionControlPlugins...)
	allCoveredAdmissionPlugins := sets.String{}
	allCoveredAdmissionPlugins.Insert(DefaultOnPlugins.List()...)
	allCoveredAdmissionPlugins.Insert(DefaultOffPlugins.List()...)

	if !configuredAdmissionPlugins.Equal(allCoveredAdmissionPlugins) {
		t.Errorf("every admission plugin must be default on or default off. differences: %v and %v",
			configuredAdmissionPlugins.Difference(allCoveredAdmissionPlugins).List(),
			allCoveredAdmissionPlugins.Difference(configuredAdmissionPlugins).List())
	}

	for plugin := range DefaultOnPlugins {
		if DefaultOffPlugins.Has(plugin) {
			t.Errorf("%v is both enabled and disabled", plugin)
		}
	}
}
