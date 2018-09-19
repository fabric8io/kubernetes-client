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
package network

import (
	"io"

	"github.com/spf13/cobra"
	"k8s.io/kubernetes/pkg/kubectl/cmd/templates"
	cmdutil "k8s.io/kubernetes/pkg/kubectl/cmd/util"

	"github.com/openshift/origin/pkg/oc/cli/util/clientcmd"
)

const PodNetworkCommandName = "pod-network"

var (
	podNetworkLong = templates.LongDesc(`
		Manage pod network in the cluster

		This command provides common pod network operations for administrators.`)
)

func NewCmdPodNetwork(name, fullName string, f *clientcmd.Factory, out, errOut io.Writer) *cobra.Command {
	// Parent command to which all subcommands are added.
	cmds := &cobra.Command{
		Use:   name,
		Short: "Manage pod network",
		Long:  podNetworkLong,
		Run:   cmdutil.DefaultSubCommandRun(errOut),
	}

	cmds.AddCommand(NewCmdJoinProjectsNetwork(JoinProjectsNetworkCommandName, fullName+" "+JoinProjectsNetworkCommandName, f, out))
	cmds.AddCommand(NewCmdMakeGlobalProjectsNetwork(MakeGlobalProjectsNetworkCommandName, fullName+" "+MakeGlobalProjectsNetworkCommandName, f, out))

	cmds.AddCommand(NewCmdIsolateProjectsNetwork(IsolateProjectsNetworkCommandName, fullName+" "+IsolateProjectsNetworkCommandName, f, out))

	return cmds
}
