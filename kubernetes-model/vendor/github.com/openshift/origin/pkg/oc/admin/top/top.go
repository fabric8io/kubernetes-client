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
package top

import (
	"io"

	"github.com/spf13/cobra"

	kcmd "k8s.io/kubernetes/pkg/kubectl/cmd"
	"k8s.io/kubernetes/pkg/kubectl/cmd/templates"
	cmdutil "k8s.io/kubernetes/pkg/kubectl/cmd/util"

	"github.com/openshift/origin/pkg/oc/cli/util/clientcmd"
)

const (
	TopRecommendedName = "top"

	DefaultHeapsterNamespace = "openshift-infra"
	DefaultHeapsterScheme    = "https"
	DefaultHeapsterService   = "heapster"
)

var topLong = templates.LongDesc(`
	Show usage statistics of resources on the server

	This command analyzes resources managed by the platform and presents current
	usage statistics.`)

func NewCommandTop(name, fullName string, f *clientcmd.Factory, out, errOut io.Writer) *cobra.Command {
	// Parent command to which all subcommands are added.
	cmds := &cobra.Command{
		Use:   name,
		Short: "Show usage statistics of resources on the server",
		Long:  topLong,
		Run:   cmdutil.DefaultSubCommandRun(errOut),
	}

	ocHeapsterTopOpts := kcmd.HeapsterTopOptions{
		Namespace: DefaultHeapsterNamespace,
		Scheme:    DefaultHeapsterScheme,
		Service:   DefaultHeapsterService,
	}

	cmdTopNodeOpts := &kcmd.TopNodeOptions{
		HeapsterOptions: ocHeapsterTopOpts,
	}
	cmdTopNode := kcmd.NewCmdTopNode(f, cmdTopNodeOpts, out)

	cmdTopPodOpts := &kcmd.TopPodOptions{
		HeapsterOptions: ocHeapsterTopOpts,
	}
	cmdTopPod := kcmd.NewCmdTopPod(f, cmdTopPodOpts, out)

	cmds.AddCommand(NewCmdTopImages(f, fullName, TopImagesRecommendedName, out))
	cmds.AddCommand(NewCmdTopImageStreams(f, fullName, TopImageStreamsRecommendedName, out))
	cmdTopNode.Long = templates.LongDesc(cmdTopNode.Long)
	cmdTopNode.Example = templates.Examples(cmdTopNode.Example)
	cmdTopPod.Long = templates.LongDesc(cmdTopPod.Long)
	cmdTopPod.Example = templates.Examples(cmdTopPod.Example)
	cmds.AddCommand(cmdTopNode)
	cmds.AddCommand(cmdTopPod)
	return cmds
}
