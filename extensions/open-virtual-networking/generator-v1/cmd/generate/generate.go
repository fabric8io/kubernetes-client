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
	v1adminpolicybasedroute "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/adminpolicybasedroute/v1"
	v1egressfirewall "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressfirewall/v1"
	v1egressip "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressip/v1"
	v1egressqos "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressqos/v1"
	v1egressservice "github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressservice/v1"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"reflect"

	"github.com/fabric8io/kubernetes-client/generator/pkg/schemagen"
)

func main() {

	// the CRD List types for which the model should be generated
	// no other types need to be defined as they are auto discovered
	crdLists := map[reflect.Type]schemagen.CrdScope{
		reflect.TypeOf(v1adminpolicybasedroute.AdminPolicyBasedExternalRouteList{}): schemagen.Cluster,
		reflect.TypeOf(v1egressfirewall.EgressFirewallList{}):                       schemagen.Namespaced,
		reflect.TypeOf(v1egressip.EgressIPList{}):                                   schemagen.Cluster,
		reflect.TypeOf(v1egressqos.EgressQoSList{}):                                 schemagen.Namespaced,
		reflect.TypeOf(v1egressservice.EgressServiceList{}):                         schemagen.Namespaced,
	}

	// constraints and patterns for fields
	constraints := map[reflect.Type]map[string]*schemagen.Constraint{}

	// types that are manually defined in the model
	providedTypes := []schemagen.ProvidedType{}

	// go packages that are provided and where no generation is required and their corresponding java package
	providedPackages := map[string]string{
		// external
		"k8s.io/api/core/v1":                   "io.fabric8.kubernetes.api.model",
		"k8s.io/apimachinery/pkg/apis/meta/v1": "io.fabric8.kubernetes.api.model",
		"k8s.io/apimachinery/pkg/api/resource": "io.fabric8.kubernetes.api.model",
		"k8s.io/apimachinery/pkg/runtime":      "io.fabric8.kubernetes.api.model.runtime",
	}

	// mapping of go packages of this module to the resulting java package
	// optional ApiGroup and ApiVersion for the go package (which is added to the generated java class)
	packageMapping := map[string]schemagen.PackageInformation{
		"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/adminpolicybasedroute/v1": {JavaPackage: "io.fabric8.kubernetes.api.model.ovn.v1", ApiGroup: "k8s.ovn.org", ApiVersion: "v1"},
		"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressfirewall/v1":        {JavaPackage: "io.fabric8.kubernetes.api.model.ovn.v1", ApiGroup: "k8s.ovn.org", ApiVersion: "v1"},
		"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressip/v1":              {JavaPackage: "io.fabric8.kubernetes.api.model.ovn.v1", ApiGroup: "k8s.ovn.org", ApiVersion: "v1"},
		"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressqos/v1":             {JavaPackage: "io.fabric8.kubernetes.api.model.ovn.v1", ApiGroup: "k8s.ovn.org", ApiVersion: "v1"},
		"github.com/ovn-org/ovn-kubernetes/go-controller/pkg/crd/egressservice/v1":         {JavaPackage: "io.fabric8.kubernetes.api.model.ovn.v1", ApiGroup: "k8s.ovn.org", ApiVersion: "v1"},
	}

	typesDescriptors := map[reflect.Type]*schemagen.JSONObjectDescriptor{}

	mappingSchema := map[string]string{}

	// overwriting some types
	manualTypeMap := map[reflect.Type]string{
		reflect.TypeOf(metav1.Time{}): "java.lang.String",
	}

	// types for interfaces
	interfacesMapping := map[string][]reflect.Type{}

	// custom name rules
	javaNameStrategyMapping := schemagen.JavaNameStrategyMapping{}

	// custom enum mapping
	enumMapping := map[reflect.Type]schemagen.EnumDescriptor{}

	json := schemagen.GenerateSchemaWithAllOptions("http://fabric8.io/OpenVirtualNetworking", crdLists, typesDescriptors, providedPackages, manualTypeMap, packageMapping, mappingSchema, providedTypes, constraints, interfacesMapping, javaNameStrategyMapping, enumMapping, "io.fabric8.kubernetes.api.model.ovn")

	fmt.Println(json)
}
