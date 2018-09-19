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
	"os"

	"github.com/openshift/origin/pkg/cmd/openshift"
	cmdsanity "github.com/openshift/origin/tools/clicheck/sanity"
)

var (
	skip = []string{
		"openshift kube",             // TODO enable when we upstream all these conventions
		"openshift start kubernetes", // TODO enable when we upstream all these conventions
		"openshift cli create quota", // TODO has examples starting with '//', enable when we upstream all these conventions
		"openshift cli adm",          // already checked in 'openshift admin'
		"openshift cli ex",           // we will only care about experimental when they get promoted
		"openshift cli types",
	}
)

func main() {
	errors := []error{}

	oc := openshift.NewCommandOpenShift("openshift")
	result := cmdsanity.CheckCmdTree(oc, cmdsanity.AllCmdChecks, skip)
	errors = append(errors, result...)

	if len(errors) > 0 {
		for i, err := range errors {
			fmt.Fprintf(os.Stderr, "%d. %s\n\n", i+1, err)
		}
		os.Exit(1)
	}

	fmt.Fprintln(os.Stdout, "Congrats, CLI looks good!")
}
