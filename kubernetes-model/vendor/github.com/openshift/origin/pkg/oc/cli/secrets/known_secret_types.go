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
package secrets

import (
	"reflect"

	"k8s.io/apimachinery/pkg/util/sets"
	kapi "k8s.io/kubernetes/pkg/apis/core"
)

type KnownSecretType struct {
	Type             kapi.SecretType
	RequiredContents sets.String
}

func (ks KnownSecretType) Matches(secretContent map[string][]byte) bool {
	if secretContent == nil {
		return false
	}
	secretKeys := sets.StringKeySet(secretContent)
	return reflect.DeepEqual(ks.RequiredContents.List(), secretKeys.List())
}

var (
	KnownSecretTypes = []KnownSecretType{
		{kapi.SecretTypeDockercfg, sets.NewString(kapi.DockerConfigKey)},
		{kapi.SecretTypeDockerConfigJson, sets.NewString(kapi.DockerConfigJsonKey)},
	}
)
