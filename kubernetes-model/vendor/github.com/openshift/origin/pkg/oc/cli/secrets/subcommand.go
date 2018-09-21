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
package secrets

import (
	"io"

	"github.com/spf13/cobra"
	"k8s.io/kubernetes/pkg/kubectl/cmd/templates"
	cmdutil "k8s.io/kubernetes/pkg/kubectl/cmd/util"

	"github.com/openshift/origin/pkg/oc/cli/util/clientcmd"
)

const SecretsRecommendedName = "secrets"

const (
	// SourceUsername is the key of the optional username for basic authentication subcommand
	SourceUsername = "username"
	// SourcePassword is the key of the optional password or token for basic authentication subcommand
	SourcePassword = "password"
	// SourceCertificate is the key of the optional certificate authority for basic authentication subcommand
	SourceCertificate = "ca.crt"
	// SourcePrivateKey is the key of the required SSH private key for SSH authentication subcommand
	SourcePrivateKey = "ssh-privatekey"
	// SourceGitconfig is the key of the optional gitconfig content for both basic and SSH authentication subcommands
	SourceGitConfig = ".gitconfig"
)

var (
	secretsLong = templates.LongDesc(`
    Manage secrets in your project

    Secrets are used to store confidential information that should not be contained inside of an image.
    They are commonly used to hold things like keys for authentication to other internal systems like
    Docker registries.`)
)

func NewCmdSecrets(name, fullName string, f *clientcmd.Factory, out, errOut io.Writer) *cobra.Command {
	// Parent command to which all subcommands are added.
	cmds := &cobra.Command{
		Use:     name,
		Short:   "Manage secrets",
		Long:    secretsLong,
		Aliases: []string{"secret"},
		Run:     cmdutil.DefaultSubCommandRun(errOut),
	}

	cmds.AddCommand(NewCmdLinkSecret(LinkSecretRecommendedName, fullName+" "+LinkSecretRecommendedName, f, out))
	cmds.AddCommand(NewCmdUnlinkSecret(UnlinkSecretRecommendedName, fullName+" "+UnlinkSecretRecommendedName, f, out))

	return cmds
}
