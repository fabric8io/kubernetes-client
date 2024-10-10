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
	prometheusoperatorv1 "github.com/prometheus-operator/prometheus-operator/pkg/apis/monitoring/v1"
	"github.com/spf13/cobra"
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
		prometheusoperatorv1.SchemeGroupVersion.String(),
		volumesnapshotv1.SchemeGroupVersion.String(),
		volcanov1beta1.SchemeGroupVersion.String(),
	}, "\n"))
}
