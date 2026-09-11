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
	"errors"
	"fmt"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/openapi"
	"github.com/fabric8io/kubernetes-client/kubernetes-model-generator/openapi/generator/pkg/packages"
	"go/token"
	"k8s.io/kube-openapi/cmd/openapi-gen/args"
	"os"
	"path/filepath"
	"time"
)

// docTemplate is the committed placeholder for each generated package.
// It keeps the package resolvable on a clean checkout, so that `go get`, `go mod tidy` and dependency bots work before
// generation has run. The tool (re)writes it whenever it is missing or differs, so that a new or renamed module can't be
// added without it: CI fails on the resulting untracked or modified file.
const docTemplate = `/**
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

// Package %[1]s holds the OpenAPI definitions emitted by ` + "`go generate`" + ` (see tools/generator/openapi.go).
// This file only makes the package resolvable on a clean checkout, so that ` + "`go get`, `go mod tidy`" + ` and dependency bots
// work before generation has run.
package %[1]s
`

func ensureDocFile(outputName string) error {
	if !token.IsIdentifier(outputName) {
		return fmt.Errorf("output package name %q is not a valid Go identifier", outputName)
	}
	docFile := filepath.Join(outputName, "doc.go")
	expected := []byte(fmt.Sprintf(docTemplate, outputName))
	current, err := os.ReadFile(docFile)
	if err == nil && bytes.Equal(current, expected) {
		return nil
	} else if err != nil && !errors.Is(err, os.ErrNotExist) {
		return err
	}
	if err := os.MkdirAll(outputName, 0o755); err != nil {
		return err
	}
	return os.WriteFile(docFile, expected, 0o644)
}

// checkOrphanPackages fails when a generated_* directory has no module producing it (e.g. a module was removed but
// its committed doc.go wasn't), since neither `go build` nor the CI drift check would notice.
func checkOrphanPackages() error {
	dirs, err := filepath.Glob("generated_*")
	if err != nil {
		return err
	}
	for _, dir := range dirs {
		known := false
		for _, m := range modules {
			if m.outputName == dir {
				known = true
				break
			}
		}
		if !known {
			return fmt.Errorf("directory %q has no module producing it; remove it or add it to the modules list", dir)
		}
	}
	return nil
}

type module struct {
	outputName string
	patterns   []string
}

var modules = []module{
	{patterns: packages.OpenShiftPackagePatterns, outputName: "generated_openshift_openapi"},
	{patterns: packages.AutoscalingPackagePatterns, outputName: "generated_autoscaling_openapi"},
	{patterns: packages.CertManagerPackagePatterns, outputName: "generated_certmanager_openapi"},
	{patterns: packages.ChaosMeshPackagePatterns, outputName: "generated_chaosmesh_openapi"},
	{patterns: packages.GatewayApiPackagePatterns, outputName: "generated_gatewayapi_openapi"},
	{patterns: packages.IstioPackagePatterns, outputName: "generated_istio_openapi"},
	{patterns: packages.KnativePackagePatterns, outputName: "generated_knative_openapi"},
	{patterns: packages.OpenClusterManagementPackagePatterns, outputName: "generated_openclustermanagement_openapi"},
	{patterns: packages.OvnPackagePatterns, outputName: "generated_ovn_openapi"},
	{patterns: packages.TektonPackagePatterns, outputName: "generated_tekton_openapi"},
	{patterns: packages.VolcanoPackagePatterns, outputName: "generated_volcano_openapi"},
	{patterns: packages.VolumeSnapshotPackagePatterns, outputName: "generated_volumesnapshot_openapi"},
}

func main() {
	startTime := time.Now()
	fmt.Println("OpenAPI code generation started...")
	if err := checkOrphanPackages(); err != nil {
		panic(fmt.Errorf("OpenAPI code generation error: %w", err))
	}
	for _, m := range modules {
		taskStartTime := time.Now()
		if err := ensureDocFile(m.outputName); err != nil {
			panic(fmt.Errorf("OpenAPI code generation error (%s): %w", m.outputName, err))
		}
		err := (&openapi.GoGenerator{
			Args: args.Args{
				OutputFile: "zz_generated.openapi.go",
				OutputDir:  "./" + m.outputName,
				OutputPkg:  "./" + m.outputName,
			},
			Patterns: m.patterns,
		}).Generate()
		if err != nil {
			panic(fmt.Errorf("OpenAPI code generation error (%s): %w", m.outputName, err))
		}
		fmt.Printf("OpenAPI code generation for (%s) completed in %v\n", m.outputName, time.Since(taskStartTime))
	}
	fmt.Printf("OpenAPI code generation completed in %v\n", time.Since(startTime))
}
