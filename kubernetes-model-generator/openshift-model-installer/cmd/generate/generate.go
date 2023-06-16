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
  "log"
  "reflect"
  "strings"
  "time"

  "os"
  installer "github.com/openshift/installer/pkg/types"
  alibabacloud "github.com/openshift/installer/pkg/types/alibabacloud"
  aws "github.com/openshift/installer/pkg/types/aws"
  azure "github.com/openshift/installer/pkg/types/azure"
  baremetal "github.com/openshift/installer/pkg/types/baremetal"
  gcp "github.com/openshift/installer/pkg/types/gcp"
  ibmcloud "github.com/openshift/installer/pkg/types/ibmcloud"
  libvirt "github.com/openshift/installer/pkg/types/libvirt"
  openstack "github.com/openshift/installer/pkg/types/openstack"
  ovirt "github.com/openshift/installer/pkg/types/ovirt"
  vsphere "github.com/openshift/installer/pkg/types/vsphere"
  ipnet "github.com/openshift/installer/pkg/ipnet"
  intstr "k8s.io/apimachinery/pkg/util/intstr"
  v1apiextensions "k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1"

  "github.com/fabric8io/kubernetes-client/kubernetes-model-generator/pkg/schemagen"
)

type Schema struct {
  APIGroup                                 metav1.APIGroup
  APIGroupList                             metav1.APIGroupList
  BaseKubernetesList                       metav1.List
  ObjectMeta                               metav1.ObjectMeta
  TypeMeta                                 metav1.TypeMeta
  Status                                   metav1.Status
  Patch                                    metav1.Patch
  Time                                     metav1.Time
  InstallConfig                            installer.InstallConfig
  AlibabaCloudMachinePool                  alibabacloud.MachinePool
  AwsMachinePool                           aws.MachinePool
  AzureMachinePool                         azure.MachinePool
  BaremetalMachinePool                     baremetal.MachinePool
  GcpMachinePool                           gcp.MachinePool
  IBMCloudMachinePool                      ibmcloud.MachinePool
  LibvirtMachinePool                       libvirt.MachinePool
  OpenStackMachinePool                     openstack.MachinePool
  VSphereMachinePool                       vsphere.MachinePool
  OvirtMachinePool                         ovirt.MachinePool
}

func main() {
  packages := []schemagen.PackageDescriptor{
    {"k8s.io/apimachinery/pkg/apis/meta/v1", "", "io.fabric8.kubernetes.api.model", "kubernetes_apimachinery_", false},
    {"github.com/openshift/api/config/v1", "", "io.fabric8.openshift.api.model.config.v1", "os_config_v1_", false},
    {"github.com/openshift/api/machine/v1alpha1", "", "io.fabric8.openshift.api.model.machine.v1alpha1", "os_machine_v1alpha1_", false},
    {"github.com/openshift/api/machine/v1", "", "io.fabric8.openshift.api.model.machine.v1", "os_machine_v1_", false},
    {"github.com/openshift/installer/pkg/types", "install", "io.fabric8.openshift.api.model.installer.v1", "os_installer_v1_", true},
    {"github.com/openshift/installer/pkg/ipnet", "", "io.fabric8.openshift.api.model.installer.ipnet.v1", "os_installer_ipnet_v1_", true},
    {"github.com/openshift/installer/pkg/types/alibabacloud", "", "io.fabric8.openshift.api.model.installer.alibabacloud.v1", "os_installer_alibabacloud_v1_", true},
    {"github.com/openshift/installer/pkg/types/aws", "", "io.fabric8.openshift.api.model.installer.aws.v1", "os_installer_aws_v1_", true},
    {"github.com/openshift/installer/pkg/types/azure", "", "io.fabric8.openshift.api.model.installer.azure.v1", "os_installer_azure_v1_", true},
    {"github.com/openshift/installer/pkg/types/baremetal", "", "io.fabric8.openshift.api.model.installer.baremetal.v1", "os_installer_baremetal_v1_", true},
    {"github.com/openshift/installer/pkg/types/gcp", "", "io.fabric8.openshift.api.model.installer.gcp.v1", "os_installer_gcp_v1_", true},
    {"github.com/openshift/installer/pkg/types/ibmcloud", "", "io.fabric8.openshift.api.model.installer.ibmcloud.v1", "os_installer_ibmcloud_v1_", true},
    {"github.com/openshift/installer/pkg/types/libvirt", "", "io.fabric8.openshift.api.model.installer.libvirt.v1", "os_installer_libvirt_v1_", true},
    {"github.com/openshift/installer/pkg/types/openstack", "", "io.fabric8.openshift.api.model.installer.openstack.v1", "os_installer_openstack_v1_", true},
    {"github.com/openshift/installer/pkg/types/vsphere", "", "io.fabric8.openshift.api.model.installer.vsphere.v1", "os_installer_vsphere_v1_", true},
    {"github.com/openshift/installer/pkg/types/ovirt", "", "io.fabric8.openshift.api.model.installer.ovirt.v1", "os_installer_ovirt_v1_", true},
    {"github.com/openshift/installer/pkg/types/none", "", "io.fabric8.openshift.api.model.installer.none.v1", "os_installer_none_v1_", true},
    {"github.com/openshift/installer/pkg/asset/installconfig", "", "io.fabric8.openshift.api.model.installer.asset.installconfig", "os_installer_asset_installconfig_", true},
    {"github.com/openshift/installer/pkg/types/powervs", "", "io.fabric8.openshift.api.model.installer.powervs.v1", "os_installer_powervs_v1_", true},
    {"github.com/openshift/installer/pkg/types/nutanix", "", "io.fabric8.openshift.api.model.installer.nutanix.v1", "os_installer_nutanix_v1_", true},
  }

  typeMap := map[reflect.Type]reflect.Type{
    reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
    reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
    reflect.TypeOf(ipnet.IPNet{}): reflect.TypeOf(""),
  }
  manualTypeMap := map[reflect.Type]string {
    reflect.TypeOf(runtime.RawExtension{}): "java.util.Map<String, Object>",
    reflect.TypeOf(v1apiextensions.JSON{}): "com.fasterxml.jackson.databind.JsonNode",
    reflect.TypeOf(intstr.IntOrString{}): "io.fabric8.kubernetes.api.model.IntOrString",
  }
  schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, manualTypeMap,"installer")
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
  result = strings.Replace(result, "\"clusterNetworks\":", "\"deprecatedClusterNetworks\":", -1)
  result = strings.Replace(result, "types", "v1", -1)

  var out bytes.Buffer
  err = json.Indent(&out, []byte(result), "", "  ")
  if err != nil {
    log.Fatal(err)
  }

  fmt.Println(out.String())
}
