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
package main

import (
	"fmt"
	certmanagerv1 "github.com/cert-manager/cert-manager/pkg/apis/certmanager/v1"
	chaosmeshv1alpha1 "github.com/chaos-mesh/chaos-mesh/api/v1alpha1"
	networkattachmentdefinition "github.com/k8snetworkplumbingwg/network-attachment-definition-client/pkg/apis/k8s.cni.cncf.io/v1"
	volumesnapshotv1 "github.com/kubernetes-csi/external-snapshotter/client/v8/apis/volumesnapshot/v1"
	openshiftbaremetaloperatorv1alpha1 "github.com/metal3-io/baremetal-operator/apis/metal3.io/v1alpha1"
	openshiftclusterapiprovidermetal3v1beta1 "github.com/metal3-io/cluster-api-provider-metal3/api/v1beta1"
	openshiftconfigv1 "github.com/openshift/api/config/v1"
	openshiftcloudcredentialoperatorv1 "github.com/openshift/cloud-credential-operator/pkg/apis/cloudcredential/v1"
	openshiftclusternetworkoperatorv1 "github.com/openshift/cluster-network-operator/pkg/apis/network/v1"
	openshiftclusternodetuningoperatorv1 "github.com/openshift/cluster-node-tuning-operator/pkg/apis/tuned/v1"
	openshifthivev1 "github.com/openshift/hive/apis/hive/v1"
	openshiftinstallerv1 "github.com/openshift/installer/pkg/types"
	operatorframeworkv1 "github.com/operator-framework/api/pkg/operators/v1"
	operatorframeworkv1alpha1 "github.com/operator-framework/api/pkg/operators/v1alpha1"
	olm "github.com/operator-framework/operator-lifecycle-manager/pkg/package-server/apis/operators/v1"
	ovnadminpolicybasedroutev1 "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/adminpolicybasedroute/v1"
	ovnegressfirewallv1 "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressfirewall/v1"
	ovnegressipv1 "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressip/v1"
	ovnegressqosv1 "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressqos/v1"
	ovnegressservicev1 "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressservice/v1"
	ovnuserdefinednetworkv1 "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/userdefinednetwork/v1"
	prometheusoperatorv1 "github.com/prometheus-operator/prometheus-operator/pkg/apis/monitoring/v1"
	"github.com/spf13/cobra"
	openclustermanagementdiscoveryv1 "github.com/stolostron/discovery/api/v1"
	openclustermanagementagentv1 "github.com/stolostron/klusterlet-addon-controller/pkg/apis/agent/v1"
	openclustermanagementobservabilityv1beta1 "github.com/stolostron/multicluster-observability-operator/operators/multiclusterobservability/api/v1beta1"
	openclustermanagementoperatormulticlusterv1 "github.com/stolostron/multiclusterhub-operator/api/v1"
	openclustermanagementsearchv1alpha1 "github.com/stolostron/search-v2-operator/api/v1alpha1"
	tektonpipelinev1 "github.com/tektoncd/pipeline/pkg/apis/pipeline/v1"
	tektontriggersv1beta1 "github.com/tektoncd/triggers/pkg/apis/triggers/v1beta1"
	istioapiclientextensions "istio.io/client-go/pkg/apis/extensions/v1alpha1"
	verticalpodautoscalerv1 "k8s.io/autoscaler/vertical-pod-autoscaler/pkg/apis/autoscaling.k8s.io/v1"
	knativecaching "knative.dev/caching/pkg/apis/caching/v1alpha1"
	knativeextawssqs "knative.dev/eventing-awssqs/pkg/apis/sources/v1alpha1"
	knativeextcouchdb "knative.dev/eventing-couchdb/source/pkg/apis/sources/v1alpha1"
	knativeextgithub "knative.dev/eventing-github/pkg/apis/bindings/v1alpha1"
	knativeextgitlab "knative.dev/eventing-gitlab/pkg/apis/bindings/v1alpha1"
	knativeextkafka "knative.dev/eventing-kafka-broker/control-plane/pkg/apis/bindings/v1beta1"
	knativeextprometheus "knative.dev/eventing-prometheus/pkg/apis/sources/v1alpha1"
	knativeeventing "knative.dev/eventing/pkg/apis/eventing/v1"
	knativenetworking "knative.dev/networking/pkg/apis/networking/v1alpha1"
	knativeserving "knative.dev/serving/pkg/apis/serving/v1"
	openclustermanagementclusterv1 "open-cluster-management.io/api/cluster/v1"
	openclustermanagementoperatorv1 "open-cluster-management.io/api/operator/v1"
	openclustermanagementpolicyv1 "open-cluster-management.io/governance-policy-propagator/api/v1"
	openclustermanagementappschannelv1 "open-cluster-management.io/multicloud-operators-channel/pkg/apis/apps/v1"
	openclustermanagementappssubscriptionv1 "open-cluster-management.io/multicloud-operators-subscription/pkg/apis/apps/v1"
	gatewayApiV1 "sigs.k8s.io/gateway-api/apis/v1"
	"strings"
	volcanov1beta1 "volcano.sh/apis/pkg/apis/scheduling/v1beta1"
)

var supportedApis = &cobra.Command{
	Use:   "supported-apis",
	Short: "Lists the APIs supported by this generator",
	Run:   supportedApisRun,
}

func init() {
	rootCmd.AddCommand(supportedApis)
}

// Forces imports so that modules are present in go.mod
var supportedApisRun = func(cobraCmd *cobra.Command, args []string) {
	fmt.Printf("This generator generates OpenAPI schemas for the following supported APIs:\n%s\n", strings.Join([]string{
		certmanagerv1.SchemeGroupVersion.String(),
		chaosmeshv1alpha1.GroupVersion.String(),
		networkattachmentdefinition.SchemeGroupVersion.String(),
		olm.SchemeGroupVersion.String(),
		openshiftbaremetaloperatorv1alpha1.GroupVersion.String(),
		openshiftconfigv1.SchemeGroupVersion.String(),
		openshiftcloudcredentialoperatorv1.GroupVersion.String(),
		openshiftclusterapiprovidermetal3v1beta1.GroupVersion.String(),
		openshiftclusternetworkoperatorv1.GroupVersion.String(),
		openshiftclusternodetuningoperatorv1.SchemeGroupVersion.String(),
		openshifthivev1.SchemeGroupVersion.String(),
		"install.openshift.io/" + openshiftinstallerv1.InstallConfigVersion + " (" + strings.Join(openshiftinstallerv1.PlatformNames, ", ") + ")",
		operatorframeworkv1alpha1.SchemeGroupVersion.String(),
		operatorframeworkv1.GroupVersion.String(),
		ovnadminpolicybasedroutev1.SchemeGroupVersion.String(),
		ovnegressfirewallv1.SchemeGroupVersion.String(),
		ovnegressipv1.SchemeGroupVersion.String(),
		ovnegressqosv1.SchemeGroupVersion.String(),
		ovnegressservicev1.SchemeGroupVersion.String(),
		ovnuserdefinednetworkv1.SchemeGroupVersion.String(),
		prometheusoperatorv1.SchemeGroupVersion.String(),
		volumesnapshotv1.SchemeGroupVersion.String(),
		volcanov1beta1.SchemeGroupVersion.String(),
		istioapiclientextensions.SchemeGroupVersion.String(),
		knativecaching.SchemeGroupVersion.String(),
		knativeeventing.SchemeGroupVersion.String(),
		knativenetworking.SchemeGroupVersion.String(),
		knativeserving.SchemeGroupVersion.String(),
		knativeextawssqs.SchemeGroupVersion.String(),
		knativeextcouchdb.SchemeGroupVersion.String(),
		knativeextgithub.SchemeGroupVersion.String(),
		knativeextgitlab.SchemeGroupVersion.String(),
		knativeextkafka.SchemeGroupVersion.String(),
		knativeextprometheus.SchemeGroupVersion.String(),
		tektonpipelinev1.SchemeGroupVersion.String(),
		tektontriggersv1beta1.SchemeGroupVersion.String(),
		verticalpodautoscalerv1.SchemeGroupVersion.String(),
		openclustermanagementagentv1.SchemeGroupVersion.String(),
		openclustermanagementappschannelv1.SchemeGroupVersion.String(),
		openclustermanagementappssubscriptionv1.SchemeGroupVersion.String(),
		openclustermanagementclusterv1.SchemeGroupVersion.String(),
		openclustermanagementdiscoveryv1.GroupVersion.String(),
		openclustermanagementobservabilityv1beta1.GroupVersion.String(),
		openclustermanagementoperatorv1.SchemeGroupVersion.String(),
		openclustermanagementoperatormulticlusterv1.GroupVersion.String(),
		openclustermanagementpolicyv1.SchemeGroupVersion.String(),
		openclustermanagementsearchv1alpha1.GroupVersion.String(),
		gatewayApiV1.GroupVersion.String(),
	}, "\n"))
}
