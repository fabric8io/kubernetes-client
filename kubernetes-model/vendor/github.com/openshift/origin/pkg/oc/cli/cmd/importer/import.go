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
package importer

import (
	"fmt"
	"io"

	"github.com/spf13/cobra"
	"k8s.io/kubernetes/pkg/kubectl/cmd/templates"
	cmdutil "k8s.io/kubernetes/pkg/kubectl/cmd/util"

	"github.com/openshift/origin/pkg/oc/cli/util/clientcmd"
)

var (
	importLong = templates.LongDesc(`
		Import outside applications into OpenShift

		These commands assist in bringing existing applications into OpenShift.`)
)

// NewCmdImport exposes commands for modifying objects.
func NewCmdImport(fullName string, f *clientcmd.Factory, in io.Reader, out, errout io.Writer) *cobra.Command {
	cmd := &cobra.Command{
		Use:   "import COMMAND",
		Short: "Commands that import applications",
		Long:  importLong,
		Run:   cmdutil.DefaultSubCommandRun(errout),
	}

	name := fmt.Sprintf("%s import", fullName)

	cmd.AddCommand(NewCmdAppJSON(name, f, in, out, errout))
	return cmd
}
