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
package aggregated_logging

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	kapi "k8s.io/kubernetes/pkg/apis/core"
	kapisext "k8s.io/kubernetes/pkg/apis/extensions"

	appsapi "github.com/openshift/origin/pkg/apps/apis/apps"
	authapi "github.com/openshift/origin/pkg/authorization/apis/authorization"
	routesapi "github.com/openshift/origin/pkg/route/apis/route"
	securityapi "github.com/openshift/origin/pkg/security/apis/security"
)

//diagnosticReporter provides diagnostic messages
type diagnosticReporter interface {
	Info(id string, message string)
	Debug(id string, message string)
	Error(id string, err error, message string)
	Warn(id string, err error, message string)
}

type routesAdapter interface {
	routes(project string, options metav1.ListOptions) (*routesapi.RouteList, error)
}

type sccAdapter interface {
	getScc(name string) (*securityapi.SecurityContextConstraints, error)
}

type clusterRoleBindingsAdapter interface {
	listClusterRoleBindings() (*authapi.ClusterRoleBindingList, error)
}

//deploymentConfigAdapter is an abstraction to retrieve resource for validating dcs
//for aggregated logging diagnostics
type deploymentConfigAdapter interface {
	deploymentconfigs(project string, options metav1.ListOptions) (*appsapi.DeploymentConfigList, error)
	podsAdapter
}

//daemonsetAdapter is an abstraction to retrieve resources for validating daemonsets
//for aggregated logging diagnostics
type daemonsetAdapter interface {
	daemonsets(project string, options metav1.ListOptions) (*kapisext.DaemonSetList, error)
	nodes(options metav1.ListOptions) (*kapi.NodeList, error)
	podsAdapter
}

type podsAdapter interface {
	pods(project string, options metav1.ListOptions) (*kapi.PodList, error)
}

//saAdapter abstractions to retrieve service accounts
type saAdapter interface {
	serviceAccounts(project string, options metav1.ListOptions) (*kapi.ServiceAccountList, error)
}

//servicesAdapter abstracts retrieving services
type servicesAdapter interface {
	services(project string, options metav1.ListOptions) (*kapi.ServiceList, error)
	endpointsForService(project string, serviceName string) (*kapi.Endpoints, error)
}
