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

	v1alpha2gwapi "sigs.k8s.io/gateway-api/apis/v1alpha2"
	v1beta1gwapi "sigs.k8s.io/gateway-api/apis/v1beta1"

	"log"
	"reflect"
	"strings"
	"time"

	"os"

	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/pkg/schemagen"
)

type Schema struct {
	TCPRoute           v1alpha2gwapi.TCPRoute
	TCPRouteList       v1alpha2gwapi.TCPRouteList
	TLSRoute           v1alpha2gwapi.TLSRoute
	TLSRouteList       v1alpha2gwapi.TLSRouteList
	UDPRoute           v1alpha2gwapi.UDPRoute
	UDPRouteList       v1alpha2gwapi.UDPRouteList
	GRPCRoute          v1alpha2gwapi.GRPCRoute
	GRPCRouteList      v1alpha2gwapi.GRPCRouteList
	Gateway            v1beta1gwapi.Gateway
	GatewayList        v1beta1gwapi.GatewayList
	GatewayClass       v1beta1gwapi.GatewayClass
	GatewayClassList   v1beta1gwapi.GatewayClassList
	HTTPRoute          v1beta1gwapi.HTTPRoute
	HTTPRouteList      v1beta1gwapi.HTTPRouteList
	ReferenceGrant     v1beta1gwapi.ReferenceGrant
	ReferenceGrantList v1beta1gwapi.ReferenceGrantList
}

func main() {
	packages := []schemagen.PackageDescriptor{
		{GoPackage: "k8s.io/apimachinery/pkg/api/resource", ApiGroup: "", JavaPackage: "io.fabric8.kubernetes.api.model", Prefix: "kubernetes_resource_", Generate: false},
		{GoPackage: "k8s.io/apimachinery/pkg/version", ApiGroup: "", JavaPackage: "io.fabric8.kubernetes.api.model.version", Prefix: "kubernetes_apimachinery_pkg_version_", Generate: false},
		{GoPackage: "k8s.io/apimachinery/pkg/apis/meta/v1", ApiGroup: "", JavaPackage: "io.fabric8.kubernetes.api.model", Prefix: "kubernetes_apimachinery_", Generate: false},
		{GoPackage: "k8s.io/api/core/v1", ApiGroup: "", JavaPackage: "io.fabric8.kubernetes.api.model", Prefix: "kubernetes_core_", Generate: false},
		{GoPackage: "sigs.k8s.io/gateway-api/apis/v1alpha2", ApiGroup: "gateway.networking.k8s.io", JavaPackage: "io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2", Prefix: "kubernetes_sigs_gatewayapi_v1alpha2_", Generate: true},
		{GoPackage: "sigs.k8s.io/gateway-api/apis/v1beta1", ApiGroup: "gateway.networking.k8s.io", JavaPackage: "io.fabric8.kubernetes.api.model.gatewayapi.v1beta1", Prefix: "kubernetes_sigs_gatewayapi_v1beta1_", Generate: true},
	}

	typeMap := map[reflect.Type]reflect.Type{
		reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
		reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
	}
	schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, map[reflect.Type]string{}, "gatewayapi")
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
