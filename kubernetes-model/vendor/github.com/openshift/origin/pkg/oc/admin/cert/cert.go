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
package cert

import (
	"io"

	"github.com/spf13/cobra"
	cmdutil "k8s.io/kubernetes/pkg/kubectl/cmd/util"

	"github.com/openshift/origin/pkg/cmd/server/admin"
)

const CertRecommendedName = "ca"

// NewCmdCert implements the OpenShift cli ca command
func NewCmdCert(name, fullName string, out io.Writer, errout io.Writer) *cobra.Command {
	// Parent command to which all subcommands are added.
	cmds := &cobra.Command{
		Use:   name,
		Short: "Manage certificates and keys",
		Long:  `Manage certificates and keys`,
		Run:   cmdutil.DefaultSubCommandRun(errout),
	}

	cmds.AddCommand(admin.NewCommandCreateMasterCerts(admin.CreateMasterCertsCommandName, fullName+" "+admin.CreateMasterCertsCommandName, out))
	cmds.AddCommand(admin.NewCommandCreateKeyPair(admin.CreateKeyPairCommandName, fullName+" "+admin.CreateKeyPairCommandName, out))
	cmds.AddCommand(admin.NewCommandCreateServerCert(admin.CreateServerCertCommandName, fullName+" "+admin.CreateServerCertCommandName, out))
	cmds.AddCommand(admin.NewCommandCreateSignerCert(admin.CreateSignerCertCommandName, fullName+" "+admin.CreateSignerCertCommandName, out))

	cmds.AddCommand(admin.NewCommandEncrypt(admin.EncryptCommandName, fullName+" "+admin.EncryptCommandName, out, errout))
	cmds.AddCommand(admin.NewCommandDecrypt(admin.DecryptCommandName, fullName+" "+admin.DecryptCommandName, fullName+" "+admin.EncryptCommandName, out))

	return cmds
}
