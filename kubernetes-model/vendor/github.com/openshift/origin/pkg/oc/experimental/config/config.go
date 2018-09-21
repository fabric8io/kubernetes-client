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
package config

import (
	"io"

	"github.com/spf13/cobra"
	"k8s.io/kubernetes/pkg/kubectl/cmd/templates"
	cmdutil "k8s.io/kubernetes/pkg/kubectl/cmd/util"

	"github.com/openshift/origin/pkg/oc/cli/util/clientcmd"
)

const ConfigRecommendedName = "config"

var configLong = templates.LongDesc(`Manage cluster configuration files like master-config.yaml.`)

func NewCmdConfig(name, fullName string, f *clientcmd.Factory, out, errout io.Writer) *cobra.Command {
	cmd := &cobra.Command{
		Use:   name,
		Short: "Manage config",
		Long:  configLong,
		Run:   cmdutil.DefaultSubCommandRun(errout),
	}

	cmd.AddCommand(NewCmdPatch(PatchRecommendedName, fullName+" "+PatchRecommendedName, f, out))

	return cmd
}
