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
	"github.com/fabric8io/kubernetes-client/generator/pkg/schemagen"
	"github.com/kubernetes-sigs/service-catalog/pkg/apis/servicecatalog/v1beta1"
	v1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/runtime"
	"reflect"
)

func main() {

	// the CRD List types for which the model should be generated
	// no other types need to be defined as they are auto discovered
	crdLists := map[reflect.Type]schemagen.CrdScope{
		reflect.TypeOf(v1beta1.ClusterServiceBrokerList{}): schemagen.Cluster,
		reflect.TypeOf(v1beta1.ClusterServiceClassList{}):  schemagen.Cluster,
		reflect.TypeOf(v1beta1.ClusterServicePlanList{}):   schemagen.Cluster,

		reflect.TypeOf(v1beta1.ServiceInstanceList{}): schemagen.Namespaced,
		reflect.TypeOf(v1beta1.ServiceBindingList{}):  schemagen.Namespaced,
		reflect.TypeOf(v1beta1.ServiceBrokerList{}):   schemagen.Namespaced,
		reflect.TypeOf(v1beta1.ServiceClassList{}):    schemagen.Namespaced,
		reflect.TypeOf(v1beta1.ServicePlanList{}):     schemagen.Namespaced,
	}

	// constraints and patterns for fields
	constraints := map[reflect.Type]map[string]*schemagen.Constraint{}

	// types that are manually defined in the model
	providedTypes := []schemagen.ProvidedType{}

	// go packages that are provided and where no generation is required and their corresponding java package
	providedPackages := map[string]string{
		// external
		"k8s.io/apimachinery/pkg/apis/meta/v1": "io.fabric8.kubernetes.api.model",
	}

	// mapping of go packages of this module to the resulting java package
	// optional ApiGroup and ApiVersion for the go package (which is added to the generated java class)
	packageMapping := map[string]schemagen.PackageInformation{
		"github.com/kubernetes-sigs/service-catalog/pkg/apis/servicecatalog/v1beta1": {JavaPackage: "io.fabric8.servicecatalog.api.model", ApiGroup: "servicecatalog.k8s.io", ApiVersion: "v1beta1"},
	}

	// converts all packages starting with <key> to a java package using an automated scheme:
	//  - replace <key> with <value> aka "package prefix"
	//  - replace '/' with '.' for a valid java package name
	// e.g. knative.dev/eventing/pkg/apis/messaging/v1beta1/ChannelTemplateSpec is mapped to "io.fabric8.knative.internal.eventing.pkg.apis.messaging.v1beta1.ChannelTemplateSpec"
	mappingSchema := map[string]string{
		"github.com/kubernetes-sigs": "io.fabric8.servicecatalog.internal",
	}

	// overwriting some times
	manualTypeMap := map[reflect.Type]string{
		reflect.TypeOf(v1.Time{}):              "java.lang.String",
		reflect.TypeOf(runtime.RawExtension{}): "java.util.Map<String, Object>",
		reflect.TypeOf([]byte{}):               "java.lang.String",
	}

	json := schemagen.GenerateSchema("http://fabric8.io/knative/ServiceCatalogSchema#", crdLists, providedPackages, manualTypeMap, packageMapping, mappingSchema, providedTypes, constraints, "io.fabric8")

	fmt.Println(json)
}
