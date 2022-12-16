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
	certmanageracme "github.com/cert-manager/cert-manager/pkg/apis/acme/v1"
	certmanager "github.com/cert-manager/cert-manager/pkg/apis/certmanager/v1"
	"github.com/fabric8io/kubernetes-client/generator/pkg/schemagen"
	apiextensions "k8s.io/apiextensions-apiserver/pkg/apis/apiextensions/v1"
	v1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"reflect"
)

func main() {

	// the CRD List types for which the model should be generated
	// no other types need to be defined as they are auto discovered
	crdLists := map[reflect.Type]schemagen.CrdScope{
		reflect.TypeOf(certmanager.CertificateList{}):        schemagen.Namespaced,
		reflect.TypeOf(certmanager.CertificateRequestList{}): schemagen.Namespaced,
		reflect.TypeOf(certmanager.IssuerList{}):             schemagen.Namespaced,
		reflect.TypeOf(certmanager.ClusterIssuerList{}):      schemagen.Cluster,
		reflect.TypeOf(certmanageracme.ChallengeList{}):      schemagen.Namespaced,
		reflect.TypeOf(certmanageracme.OrderList{}):          schemagen.Namespaced,
	}

	// constraints and patterns for fields
	constraints := map[reflect.Type]map[string]*schemagen.Constraint{}

	// types that are manually defined in the model
	providedTypes := []schemagen.ProvidedType{}

	// go packages that are provided and where no generation is required and their corresponding java package
	providedPackages := map[string]string{
		// external
		"k8s.io/api/core/v1":                    "io.fabric8.kubernetes.api.model",
		"k8s.io/apimachinery/pkg/apis/meta/v1":  "io.fabric8.kubernetes.api.model",
		"k8s.io/apimachinery/pkg/api/resource":  "io.fabric8.kubernetes.api.model",
		"k8s.io/apimachinery/pkg/runtime":       "io.fabric8.kubernetes.api.model.runtime",
		"sigs.k8s.io/gateway-api/apis/v1alpha2": "io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2",
	}

	// mapping of go packages of this module to the resulting java package
	// optional ApiGroup and ApiVersion for the go package (which is added to the generated java class)
	packageMapping := map[string]schemagen.PackageInformation{
		"github.com/cert-manager/cert-manager/pkg/apis/certmanager/v1": {JavaPackage: "io.fabric8.certmanager.api.model.v1", ApiGroup: "cert-manager.io", ApiVersion: "v1"},
		"github.com/cert-manager/cert-manager/pkg/apis/acme/v1":        {JavaPackage: "io.fabric8.certmanager.api.model.acme.v1", ApiGroup: "acme.cert-manager.io", ApiVersion: "v1"},
		"github.com/cert-manager/cert-manager/pkg/apis/meta/v1":        {JavaPackage: "io.fabric8.certmanager.api.model.meta.v1", ApiGroup: "cert-manager.io", ApiVersion: "v1"},
		"github.com/cert-manager/cert-manager/internal/apis/acme":      {JavaPackage: "io.fabric8.certmanager.api.model.acme.internal", ApiGroup: "cert-manager.io", ApiVersion: "v1"},
		"github.com/cert-manager/cert-manager/internal/apis/meta":      {JavaPackage: "io.fabric8.certmanager.api.model.meta.internal", ApiGroup: "cert-manager.io", ApiVersion: "v1"},
	}

	// converts all packages starting with <key> to a java package using an automated scheme:
	//  - replace <key> with <value> aka "package prefix"
	//  - replace '/' with '.' for a valid java package name
	// e.g. knative.dev/eventing/pkg/apis/messaging/v1beta1/ChannelTemplateSpec is mapped to "io.fabric8.knative.internal.eventing.pkg.apis.messaging.v1beta1.ChannelTemplateSpec"
	mappingSchema := map[string]string{}

	// overwriting some times
	manualTypeMap := map[reflect.Type]string{
		reflect.TypeOf(v1.Time{}):            "java.lang.String",
		reflect.TypeOf(apiextensions.JSON{}): "com.fasterxml.jackson.databind.JsonNode",
	}

	json := schemagen.GenerateSchema("http://fabric8.io/jetstack/CertManagerSchema#", crdLists, providedPackages, manualTypeMap, packageMapping, mappingSchema, providedTypes, constraints, "io.fabric8")

	fmt.Println(json)
}
