//go:build ignore
// +build ignore

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
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/openshift"
	//openshiftbaremetaloperatorv1alpha1 "github.com/metal3-io/baremetal-operator/apis/metal3.io/v1alpha1"
	openshiftcloudcredentialoperatorv1 "github.com/openshift/cloud-credential-operator/pkg/apis/cloudcredential/v1"
	openshiftclusternetworkoperatorv1 "github.com/openshift/cluster-network-operator/pkg/apis/network/v1"
	operatorframeworkv1 "github.com/operator-framework/api/pkg/operators/v1"
	operatorframeworkv1alpha1 "github.com/operator-framework/api/pkg/operators/v1alpha1"
	olm "github.com/operator-framework/operator-lifecycle-manager/pkg/package-server/apis/operators/v1"
	prometheusoperatorv1 "github.com/prometheus-operator/prometheus-operator/pkg/apis/monitoring/v1"
	"k8s.io/kube-openapi/cmd/openapi-gen/args"
	"time"
)

func main() {
	startTime := time.Now()
	fmt.Printf("OpenAPI code generation started...\n%s\n", []string{
		// Force imports so that modules are present in go.mod
		operatorframeworkv1alpha1.SchemeGroupVersion.String(),
		operatorframeworkv1.GroupVersion.String(),
		//openshiftbaremetaloperatorv1alpha1.GroupVersion.String(),
		openshiftclusternetworkoperatorv1.GroupVersion.String(),
		openshiftcloudcredentialoperatorv1.GroupVersion.String(),
		olm.SchemeGroupVersion.String(),
		prometheusoperatorv1.SchemeGroupVersion.String(),
	})
	err := (&openapi.GoGenerator{
		Args: args.Args{
			OutputFile: "zz_generated.openapi.go",
			OutputDir:  "./generated_openapi",
			OutputPkg:  "./generated_openapi",
		},
		Patterns: openshift.PackagePatterns,
	}).Generate()
	if err != nil {
		panic(fmt.Errorf("OpenAPI code generation error: %w", err))
	}
	fmt.Printf("OpenAPI code generation completed in %v\n", time.Since(startTime))
}
