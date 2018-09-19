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
package image

import (
	"fmt"
	"io"

	"github.com/spf13/cobra"
	ktemplates "k8s.io/kubernetes/pkg/kubectl/cmd/templates"
	cmdutil "k8s.io/kubernetes/pkg/kubectl/cmd/util"

	"github.com/openshift/origin/pkg/cmd/templates"
	"github.com/openshift/origin/pkg/oc/cli/cmd/image/mirror"
	"github.com/openshift/origin/pkg/oc/cli/util/clientcmd"
)

var (
	imageLong = ktemplates.LongDesc(`
		Manage images on OpenShift

		These commands help you manage images on OpenShift.`)
)

// NewCmdImage exposes commands for modifying images.
func NewCmdImage(fullName string, f *clientcmd.Factory, in io.Reader, out, errout io.Writer) *cobra.Command {
	image := &cobra.Command{
		Use:   "image COMMAND",
		Short: "Useful commands for managing images",
		Long:  imageLong,
		Run:   cmdutil.DefaultSubCommandRun(errout),
	}

	name := fmt.Sprintf("%s image", fullName)

	groups := ktemplates.CommandGroups{
		{
			Message: "Advanced commands:",
			Commands: []*cobra.Command{
				mirror.NewCmdMirrorImage(name, out, errout),
			},
		},
	}
	groups.Add(image)
	templates.ActsAsRootCommand(image, []string{"options"}, groups...)
	return image
}
