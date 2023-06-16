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
  "bytes"
  "encoding/json"
  "fmt"
  metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
  runtime "k8s.io/apimachinery/pkg/runtime"
  kapi "k8s.io/api/core/v1"
  openshiftconfigapi "github.com/openshift/api/config/v1"
  "log"
  "reflect"
  "strings"
  "time"

  "os"
  hivev1 "github.com/openshift/hive/apis/hive/v1"
  azure "github.com/openshift/hive/apis/hive/v1/azure"
  gcp "github.com/openshift/hive/apis/hive/v1/gcp"
  vsphere "github.com/openshift/hive/apis/hive/v1/vsphere"


  "github.com/fabric8io/kubernetes-client/kubernetes-model-generator/pkg/schemagen"
)

type Schema struct {
  APIGroup                                 metav1.APIGroup
  APIGroupList                             metav1.APIGroupList
  BaseKubernetesList                       metav1.List
  ObjectMeta                               metav1.ObjectMeta
  LocalObjectReference                     kapi.LocalObjectReference
  TypeMeta                                 metav1.TypeMeta
  Status                                   metav1.Status
  Patch                                    metav1.Patch
  Time                                     metav1.Time
  ClusterOperatorStatusCondition           openshiftconfigapi.ClusterOperatorStatusCondition
  Checkpoint                               hivev1.Checkpoint
  CheckpointList                           hivev1.CheckpointList
  ClusterClaim                             hivev1.ClusterClaim
  ClusterClaimList                         hivev1.ClusterClaimList
  ClusterDeployment                        hivev1.ClusterDeployment
  ClusterDeploymentList                    hivev1.ClusterDeploymentList
  ClusterDeprovision                       hivev1.ClusterDeprovision
  ClusterDeprovisionList                   hivev1.ClusterDeprovisionList
  ClusterImageSet                          hivev1.ClusterImageSet
  ClusterImageSetList                      hivev1.ClusterImageSetList
  ClusterPool                              hivev1.ClusterPool
  ClusterPoolList                          hivev1.ClusterPoolList
  ClusterProvision                         hivev1.ClusterProvision
  ClusterProvisionList                     hivev1.ClusterProvisionList
  ClusterRelocate                          hivev1.ClusterRelocate
  ClusterRelocateList                      hivev1.ClusterRelocateList
  ClusterState                             hivev1.ClusterState
  ClusterStateList                         hivev1.ClusterStateList
  DNSZone                                  hivev1.DNSZone
  DNSZoneList                              hivev1.DNSZoneList
  HiveConfig                               hivev1.HiveConfig
  HiveConfigList                           hivev1.HiveConfigList
  MachinePoolNameLease                     hivev1.MachinePoolNameLease
  MachinePoolNameLeaseList                 hivev1.MachinePoolNameLeaseList
  MachinePool                              hivev1.MachinePool
  MachinePoolList                          hivev1.MachinePoolList
  SelectorSyncIdentityProvider             hivev1.SelectorSyncIdentityProvider
  SelectorSyncIdentityProviderList         hivev1.SelectorSyncIdentityProviderList
  SelectorSyncSet                          hivev1.SelectorSyncSet
  SelectorSyncSetList                      hivev1.SelectorSyncSetList
  SyncIdentityProvider                     hivev1.SyncIdentityProvider
  SyncIdentityProviderList                 hivev1.SyncIdentityProviderList
  SyncSet                                  hivev1.SyncSet
  SyncSetList                              hivev1.SyncSetList
  AzureOSDisk                              azure.OSDisk
  GcpOSDisk                                gcp.OSDisk
  VsphereOSDisk                            vsphere.OSDisk
}

func main() {
  packages := []schemagen.PackageDescriptor{
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_", false},
    {"k8s.io/api/core/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_core_", false},
    {"k8s.io/api/rbac/v1", "", "io.fabric8.kubernetes.api.model.rbac", "kubernetes_rbac_", false},
    {"github.com/openshift/api/config/v1", "", "io.fabric8.openshift.api.model.config.v1", "os_config_v1_", false}, 
    {"github.com/openshift/hive/apis/hive/v1", "hive", "io.fabric8.openshift.api.model.hive.v1", "os_hive_v1_", true},
    {"github.com/openshift/hive/apis/hive/v1/alibabacloud", "hive", "io.fabric8.openshift.api.model.hive.alibabacloud.v1", "os_hive_alibabacloud_v1_", true},
    {"github.com/openshift/hive/apis/hive/v1/ibmcloud", "hive", "io.fabric8.openshift.api.model.hive.ibmcloud.v1", "os_hive_ibmcloud_v1_", true},
    {"github.com/openshift/hive/apis/hive/v1/aws", "hive", "io.fabric8.openshift.api.model.hive.aws.v1", "os_hive_aws_v1_", true},
    {"github.com/openshift/hive/apis/hive/v1/azure", "hive", "io.fabric8.openshift.api.model.hive.azure.v1", "os_hive_azure_v1_", true},
    {"github.com/openshift/hive/apis/hive/v1/baremetal", "hive", "io.fabric8.openshift.api.model.hive.baremetal.v1", "os_hive_baremetal_v1_", true},
    {"github.com/openshift/hive/apis/hive/v1/gcp", "hive", "io.fabric8.openshift.api.model.hive.gcp.v1", "os_hive_gcp_v1_", true},
    {"github.com/openshift/hive/apis/hive/v1/openstack", "hive", "io.fabric8.openshift.api.model.hive.openstack.v1", "os_hive_openstack_v1_", true},
    {"github.com/openshift/hive/apis/hive/v1/vsphere", "hive", "io.fabric8.openshift.api.model.hive.vsphere.v1", "os_hive_vsphere_v1_", true},
    {"github.com/openshift/hive/apis/hive/v1/ovirt", "hive", "io.fabric8.openshift.api.model.hive.ovirt.v1", "os_hive_ovirt_v1_", true},
    {"github.com/openshift/hive/apis/hive/v1/agent", "hive", "io.fabric8.openshift.api.model.hive.agent.v1", "os_hive_agent_v1_", true},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
  }
  manualTypeMap := map[reflect.Type]string {
    reflect.TypeOf(runtime.RawExtension{}): "java.util.Map<String, Object>",
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, manualTypeMap,"hive")
  if err != nil {
    fmt.Fprintf(os.Stderr, "An error occurred: %v", err)
    return
  }

  args := os.Args[1:]
  if len(args) < 1 || args[0] != "validation" {
    schema.Resources = nil
  }

  b, err := json.Marshal(&schema)
  if err != nil {
    log.Fatal(err)
  }
  result := string(b)
  result = strings.Replace(result, "\"additionalProperty\":", "\"additionalProperties\":", -1)

  var out bytes.Buffer
  err = json.Indent(&out, []byte(result), "", "  ")
  if err != nil {
    log.Fatal(err)
  }

  fmt.Println(out.String())
}
