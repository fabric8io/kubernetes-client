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

// Package openshift provides OpenShift related functionality
package openshift

// PackagePatterns are the patterns required for OpenShift GO and JSON OpenAPI generation
var PackagePatterns = []string{
	// Always import Kubernetes base packages as they are required by the rest of APIs
	"k8s.io/apimachinery/pkg/apis/meta/v...",
	"k8s.io/api/.../v...",
	// OpenShift APIs
	"github.com/openshift/api/.../v...",
	// CRDs don't provide info for reused types
	//"github.com/metal3-io/baremetal-operator/apis/metal3.io/v...",
	"github.com/openshift/cluster-network-operator/pkg/apis/.../v...",
	"github.com/openshift/cloud-credential-operator/pkg/apis/.../v...",
	"github.com/operator-framework/api/pkg/operators/v...",
	"github.com/operator-framework/operator-lifecycle-manager/pkg/package-server/apis/operators/v...",
	"github.com/prometheus-operator/prometheus-operator/pkg/apis/monitoring/v...",
}
