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
	"github.com/golang/glog"
	"k8s.io/apimachinery/pkg/runtime/schema"

	configapi "github.com/openshift/origin/pkg/cmd/server/apis/config"
	"github.com/openshift/origin/pkg/quota/admission/apis/clusterresourceoverride"
	"github.com/openshift/origin/pkg/quota/admission/apis/clusterresourceoverride/v1"
)

// availableVersions lists all known external versions for this group from most preferred to least preferred
var availableVersions = []schema.GroupVersion{v1.SchemeGroupVersion}

func init() {
	if err := enableVersions(availableVersions); err != nil {
		panic(err)
	}
}

// TODO: enableVersions should be centralized rather than spread in each API group.
func enableVersions(externalVersions []schema.GroupVersion) error {
	addVersionsToScheme(externalVersions...)
	return nil
}

func addVersionsToScheme(externalVersions ...schema.GroupVersion) {
	// add the internal version to Scheme
	clusterresourceoverride.AddToScheme(configapi.Scheme)
	// add the enabled external versions to Scheme
	for _, v := range externalVersions {
		switch v {
		case v1.SchemeGroupVersion:
			v1.AddToScheme(configapi.Scheme)
		default:
			glog.Errorf("Version %s is not known, so it will not be added to the Scheme.", v)
			continue
		}
	}
}
