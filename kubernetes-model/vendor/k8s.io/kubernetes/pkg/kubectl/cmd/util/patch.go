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
package util

import (
	"fmt"
	"io"

	"k8s.io/apimachinery/pkg/api/meta"
)

func PrintSuccess(mapper meta.RESTMapper, shortOutput bool, out io.Writer, resource, name string, dryRun bool, operation string) {
	resource, _ = mapper.ResourceSingularizer(resource)
	dryRunMsg := ""
	if dryRun {
		dryRunMsg = " (dry run)"
	}
	if shortOutput {
		// -o name: prints resource/name
		if len(resource) > 0 {
			fmt.Fprintf(out, "%s/%s\n", resource, name)
		} else {
			fmt.Fprintf(out, "%s\n", name)
		}
	} else {
		// understandable output by default
		if len(resource) > 0 {
			fmt.Fprintf(out, "%s \"%s\" %s%s\n", resource, name, operation, dryRunMsg)
		} else {
			fmt.Fprintf(out, "\"%s\" %s%s\n", name, operation, dryRunMsg)
		}
	}
}