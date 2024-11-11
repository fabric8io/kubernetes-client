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

// Package packages provides the patterns required for OpenAPI generation
package packages

// OpenShiftPackagePatterns are the patterns required for OpenShift GO and JSON OpenAPI generation
var OpenShiftPackagePatterns = []string{
	// Always import Kubernetes base packages as they are required by the rest of APIs
	"k8s.io/apimachinery/pkg/apis/meta/v...",
	"k8s.io/api/.../v...",
	// OpenShift APIs
	"github.com/openshift/api/.../v...",
	// CRDs don't provide info for reused types
	"github.com/metal3-io/baremetal-operator/apis/metal3.io/v...",
	"github.com/metal3-io/cluster-api-provider-metal3/api/v...",
	"github.com/k8snetworkplumbingwg/network-attachment-definition-client/pkg/apis/.../v...",
	"github.com/openshift/cloud-credential-operator/pkg/apis/.../v...",
	"github.com/openshift/cluster-network-operator/pkg/apis/.../v...",
	"github.com/openshift/cluster-node-tuning-operator/pkg/apis/tuned/v...",
	"github.com/openshift/hive/apis/hive/v...",
	"github.com/openshift/installer/pkg/types", // Add manually each package since some subpackages are problematic with go modules
	"github.com/openshift/installer/pkg/types/aws",
	"github.com/openshift/installer/pkg/types/azure",
	"github.com/openshift/installer/pkg/types/baremetal",
	"github.com/openshift/installer/pkg/types/external",
	"github.com/openshift/installer/pkg/types/gcp",
	"github.com/openshift/installer/pkg/types/ibmcloud",
	"github.com/openshift/installer/pkg/types/none",
	"github.com/openshift/installer/pkg/types/nutanix",
	"github.com/openshift/installer/pkg/types/openstack",
	"github.com/openshift/installer/pkg/types/ovirt",
	"github.com/openshift/installer/pkg/types/powervs",
	"github.com/openshift/installer/pkg/types/vsphere",
	"github.com/operator-framework/api/pkg/operators/v...",
	"github.com/operator-framework/operator-lifecycle-manager/pkg/package-server/apis/operators/v...",
	"github.com/prometheus-operator/prometheus-operator/pkg/apis/monitoring/v...",
	// Support types required by some APIs such as (github.com/openshift/hive)
	"github.com/openshift/custom-resource-status/conditions/v...",
}

var AutoscalingPackagePatterns = []string{
	"k8s.io/autoscaler/vertical-pod-autoscaler/pkg/apis/autoscaling.k8s.io/v...",
}

var CertManagerPackagePatterns = []string{
	"github.com/cert-manager/cert-manager/pkg/apis/acme/v...",
	"github.com/cert-manager/cert-manager/pkg/apis/meta/v...",
	"github.com/cert-manager/cert-manager/pkg/apis/certmanager/v...",
}

var ChaosMeshPackagePatterns = []string{
	"github.com/chaos-mesh/chaos-mesh/api/v1alpha1",
}

var IstioPackagePatterns = []string{
	"istio.io/api/analysis/v...",
	"istio.io/api/extensions/v...",
	"istio.io/api/meta/v...",
	"istio.io/api/networking/v...",
	"istio.io/api/security/v...",
	"istio.io/api/telemetry/v...",
	"istio.io/api/type/v...",
	"istio.io/client-go/pkg/apis/extensions/v...",
	"istio.io/client-go/pkg/apis/networking/v...",
	"istio.io/client-go/pkg/apis/security/v...",
	"istio.io/client-go/pkg/apis/telemetry/v...",
}

var KnativePackagePatterns = []string{
	"knative.dev/pkg/apis",
	"knative.dev/pkg/apis/duck/v...",
	"knative.dev/pkg/tracker",
	"knative.dev/caching/pkg/apis/.../v...",
	"knative.dev/eventing/pkg/apis/.../v...",
	"knative.dev/networking/pkg/apis/.../v...",
	"knative.dev/serving/pkg/apis/.../v...",
	"knative.dev/eventing-awssqs/pkg/apis/.../v...",
	"knative.dev/eventing-couchdb/source/pkg/apis/.../v...",
	"knative.dev/eventing-github/pkg/apis/.../v...",
	"knative.dev/eventing-gitlab/pkg/apis/.../v...", // TODO: See how to remove the duplicate SecretValueFromSource
	"knative.dev/eventing-kafka-broker/control-plane/pkg/apis/bindings/v...",
	"knative.dev/eventing-kafka-broker/control-plane/pkg/apis/eventing/v1alpha1",
	"knative.dev/eventing-kafka-broker/control-plane/pkg/apis/messaging/v...",
	"knative.dev/eventing-kafka-broker/control-plane/pkg/apis/sources/v...",
	"knative.dev/eventing-prometheus/pkg/apis/.../v...",
}

var OvnPackagePatterns = []string{
	"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/adminpolicybasedroute/v1",
	"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressfirewall/v1",
	"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressip/v1",
	"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressqos/v1",
	"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressservice/v1",
	"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/userdefinednetwork/v1",
}

var TektonPackagePatterns = []string{
	"github.com/tektoncd/pipeline/pkg/apis/pipeline/v...",
	"github.com/tektoncd/pipeline/pkg/apis/pipeline/pod",
	"github.com/tektoncd/pipeline/pkg/result",
	"github.com/tektoncd/pipeline/pkg/apis/resolution/v...",
	"github.com/tektoncd/pipeline/pkg/apis/resource/v...",
	"github.com/tektoncd/pipeline/pkg/apis/run/v...",
	"github.com/tektoncd/triggers/pkg/apis/triggers/v...",
	"github.com/tektoncd/pipeline/pkg/apis/config",
}

var VolcanoPackagePatterns = []string{
	"volcano.sh/apis/pkg/apis/batch/v1alpha1",
	"volcano.sh/apis/pkg/apis/bus/v1alpha1",
	"volcano.sh/apis/pkg/apis/flow/v1alpha1",
	"volcano.sh/apis/pkg/apis/nodeinfo/v1alpha1",
	"volcano.sh/apis/pkg/apis/scheduling/v1beta1",
}

var VolumeSnapshotPackagePatterns = []string{
	"github.com/kubernetes-csi/external-snapshotter/client/v8/apis/volumesnapshot/v1",
}
