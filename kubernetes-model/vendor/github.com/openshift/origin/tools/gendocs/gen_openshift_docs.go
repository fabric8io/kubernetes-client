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
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"

	kcmdutil "k8s.io/kubernetes/pkg/kubectl/cmd/util"

	"github.com/openshift/origin/pkg/cmd/util/gendocs"
	"github.com/openshift/origin/pkg/oc/cli"
)

func OutDir(path string) (string, error) {
	outDir, err := filepath.Abs(path)
	if err != nil {
		return "", err
	}

	stat, err := os.Stat(outDir)
	if err != nil {
		return "", err
	}

	if !stat.IsDir() {
		return "", fmt.Errorf("output directory %s is not a directory\n", outDir)
	}
	outDir = outDir + "/"
	return outDir, nil
}

func main() {
	path := "docs/generated/"
	if len(os.Args) == 2 {
		path = os.Args[1]
	} else if len(os.Args) > 2 {
		fmt.Fprintf(os.Stderr, "usage: %s [output directory]\n", os.Args[0])
		os.Exit(1)
	}

	outDir, err := OutDir(path)
	if err != nil {
		fmt.Fprintf(os.Stderr, "failed to get output directory: %v\n", err)
		os.Exit(1)
	}

	outFile := outDir + "oc_by_example_content.adoc"
	out := os.Stdout
	cmd := cli.NewCommandCLI("oc", "oc", &bytes.Buffer{}, out, ioutil.Discard)
	kcmdutil.AddPrinterFlags(cmd)

	gendocs.GenDocs(cmd, outFile)
}
