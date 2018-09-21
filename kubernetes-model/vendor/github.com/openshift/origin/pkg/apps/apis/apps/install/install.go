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
package install

import (
	"k8s.io/apimachinery/pkg/apimachinery/announced"
	"k8s.io/apimachinery/pkg/apimachinery/registered"
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/kubernetes/pkg/api/legacyscheme"

	legacy "github.com/openshift/origin/pkg/api/legacy"
	appsapi "github.com/openshift/origin/pkg/apps/apis/apps"
	appsapiv1 "github.com/openshift/origin/pkg/apps/apis/apps/v1"
)

func init() {
	legacy.InstallLegacyApps(legacyscheme.Scheme, legacyscheme.Registry)
	Install(legacyscheme.GroupFactoryRegistry, legacyscheme.Registry, legacyscheme.Scheme)
}

// Install registers the API group and adds types to a scheme
func Install(groupFactoryRegistry announced.APIGroupFactoryRegistry, registry *registered.APIRegistrationManager, scheme *runtime.Scheme) {
	if err := announced.NewGroupMetaFactory(
		&announced.GroupMetaFactoryArgs{
			GroupName:                  appsapi.GroupName,
			VersionPreferenceOrder:     []string{appsapiv1.SchemeGroupVersion.Version},
			AddInternalObjectsToScheme: appsapi.AddToScheme,
		},
		announced.VersionToSchemeFunc{
			appsapiv1.SchemeGroupVersion.Version: appsapiv1.AddToScheme,
		},
	).Announce(groupFactoryRegistry).RegisterAndEnable(registry, scheme); err != nil {
		panic(err)
	}
}
