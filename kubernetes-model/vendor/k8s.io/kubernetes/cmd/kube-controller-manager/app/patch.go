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
package app

import (
	"path"

	"k8s.io/client-go/informers"
	"k8s.io/client-go/rest"
	"k8s.io/kubernetes/cmd/kube-controller-manager/app/options"
)

var InformerFactoryOverride informers.SharedInformerFactory

func ShimForOpenShift(controllerManager *options.CMServer, clientConfig *rest.Config) (func(), error) {
	if len(controllerManager.OpenShiftConfig) == 0 {
		return func() {}, nil
	}

	// TODO this gets removed when no longer take flags and no longer build a recycler template
	openshiftConfig, err := getOpenShiftConfig(controllerManager.OpenShiftConfig)
	if err != nil {
		return func() {}, err
	}
	// apply the config based controller manager flags.  They will override.
	// TODO this should be replaced by the installer setting up the flags for us
	if err := applyOpenShiftConfigFlags(controllerManager, openshiftConfig); err != nil {
		return func() {}, err
	}
	// set up a non-default template
	// TODO this should be replaced by the installer setting up the recycle template file and flags for us
	cleanupFn, err := applyOpenShiftDefaultRecycler(controllerManager, openshiftConfig)
	if err != nil {
		return func() {}, err
	}

	// TODO this should be replaced by using a flex volume to inject service serving cert CAs into pods instead of adding it to the sa token
	if err := applyOpenShiftServiceServingCertCAFunc(path.Dir(controllerManager.OpenShiftConfig), openshiftConfig); err != nil {
		return func() {}, err
	}

	// skip GC on some openshift resources
	// TODO this should be replaced by discovery information in some way
	if err := applyOpenShiftGCConfig(controllerManager); err != nil {
		return func() {}, err
	}

	// Overwrite the informers, because we have our custom generic informers for quota.
	// TODO update quota to create its own informer like garbage collection
	combinedInformers, err := NewInformers(clientConfig)
	if err != nil {
		return cleanupFn, err
	}
	InformerFactoryOverride = externalKubeInformersWithExtraGenerics{
		SharedInformerFactory:   combinedInformers.GetExternalKubeInformers(),
		genericResourceInformer: combinedInformers.ToGenericInformer(),
	}

	return cleanupFn, nil
}
