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
	"log"
	"reflect"
	kustomizeapi "sigs.k8s.io/kustomize/api/types"
	"strings"
	"time"

	"os"

	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/pkg/schemagen"
)

type Schema struct {
	Kustomization kustomizeapi.Kustomization
}

func main() {
	packages := []schemagen.PackageDescriptor{
		{"sigs.k8s.io/kustomize/api/types", "", "io.fabric8.kubernetes.api.model.kustomize.v1beta1", "kubernetes_kustomize_v1beta1", true},
	}

	typeMap := map[reflect.Type]reflect.Type{
		reflect.TypeOf(time.Time{}): reflect.TypeOf(""),
		reflect.TypeOf(struct{}{}):  reflect.TypeOf(""),
	}

	manualTypeMap := map[reflect.Type]string{
		reflect.TypeOf(map[string]interface{}{}).Elem(): "java.lang.Object",
	}

	schema, err := schemagen.GenerateSchema(reflect.TypeOf(Schema{}), packages, typeMap, manualTypeMap, "kustomize")
	if err != nil {
		fmt.Fprintf(os.Stderr, "An error occurred: %v", err)
		return
	}

	// Remove group and version as it's not an API resource
	for _, resource := range schema.Resources {
		if prop, ok := resource.Properties["apiVersion"]; ok {
			prop.Default = ""
		}
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
