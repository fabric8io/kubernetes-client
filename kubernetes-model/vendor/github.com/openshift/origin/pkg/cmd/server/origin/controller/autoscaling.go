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
package controller

import (
	apimeta "k8s.io/apimachinery/pkg/api/meta"
	"k8s.io/client-go/discovery"
	discocache "k8s.io/client-go/discovery/cached"
	"k8s.io/client-go/dynamic"
	kubeclientset "k8s.io/client-go/kubernetes"
	"k8s.io/client-go/scale"
	hpacontroller "k8s.io/kubernetes/pkg/controller/podautoscaler"
	hpametrics "k8s.io/kubernetes/pkg/controller/podautoscaler/metrics"

	"github.com/openshift/origin/pkg/cmd/server/bootstrappolicy"
)

// NB: this is funky -- it's actually a Kubernetes controller, but we run it as an OpenShift controller in order
// to get a handle on OpenShift clients, so that our delegating scales getter can work.

type HorizontalPodAutoscalerControllerConfig struct {
	HeapsterNamespace string
}

func (c *HorizontalPodAutoscalerControllerConfig) RunController(originCtx ControllerContext) (bool, error) {
	hpaClientConfig, err := originCtx.ClientBuilder.Config(bootstrappolicy.InfraHorizontalPodAutoscalerControllerServiceAccountName)
	if err != nil {
		return true, err
	}

	hpaClient, err := kubeclientset.NewForConfig(hpaClientConfig)
	if err != nil {
		return false, err
	}

	metricsClient := hpametrics.NewHeapsterMetricsClient(
		hpaClient,
		c.HeapsterNamespace,
		"https",
		"heapster",
		"",
	)
	replicaCalc := hpacontroller.NewReplicaCalculator(
		metricsClient,
		hpaClient.CoreV1(),
		0.1, // this is the default
	)

	// TODO: we need something like deferred discovery REST mapper that calls invalidate
	// on cache misses.
	cachedDiscovery := discocache.NewMemCacheClient(hpaClient.Discovery())
	restMapper := discovery.NewDeferredDiscoveryRESTMapper(cachedDiscovery, apimeta.InterfacesForUnstructured)
	restMapper.Reset()
	// we don't use cached discovery because DiscoveryScaleKindResolver does its own caching,
	// so we want to re-fetch every time when we actually ask for it
	scaleKindResolver := scale.NewDiscoveryScaleKindResolver(hpaClient.Discovery())
	scaleClient, err := scale.NewForConfig(hpaClientConfig, restMapper, dynamic.LegacyAPIPathResolverFunc, scaleKindResolver)
	if err != nil {
		return false, err
	}

	go hpacontroller.NewHorizontalController(
		hpaClient.CoreV1(),
		scaleClient,
		hpaClient.AutoscalingV1(),
		restMapper,
		replicaCalc,
		originCtx.ExternalKubeInformers.Autoscaling().V1().HorizontalPodAutoscalers(),
		originCtx.OpenshiftControllerOptions.HPAControllerOptions.SyncPeriod.Duration,
		originCtx.OpenshiftControllerOptions.HPAControllerOptions.UpscaleForbiddenWindow.Duration,
		originCtx.OpenshiftControllerOptions.HPAControllerOptions.DownscaleForbiddenWindow.Duration,
	).Run(originCtx.Stop)

	return true, nil
}
