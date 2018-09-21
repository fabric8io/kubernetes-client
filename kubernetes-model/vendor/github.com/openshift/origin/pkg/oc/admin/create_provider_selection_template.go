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
package admin

import (
	"errors"
	"io"

	"github.com/spf13/cobra"

	"k8s.io/kubernetes/pkg/kubectl/cmd/templates"
	cmdutil "k8s.io/kubernetes/pkg/kubectl/cmd/util"

	"github.com/openshift/origin/pkg/oauthserver/server/selectprovider"
	"github.com/openshift/origin/pkg/oc/cli/util/clientcmd"
)

const CreateProviderSelectionTemplateCommand = "create-provider-selection-template"

var providerSelectionLongDescription = templates.LongDesc(`
	Create a template for customizing the provider selection page

	This command creates a basic template to use as a starting point for
	customizing the login provider selection page. Save the output to a file and edit
	the template to change the look and feel or add content. Be careful not to remove
	any parameter values inside curly braces.

	To use the template, set oauthConfig.templates.providerSelection in the master
	configuration to point to the template file. For example,

	    oauthConfig:
	      templates:
	        providerSelection: templates/provider-selection.html
	`)

type CreateProviderSelectionTemplateOptions struct{}

func NewCommandCreateProviderSelectionTemplate(f *clientcmd.Factory, commandName string, fullName string, out io.Writer) *cobra.Command {
	options := &CreateProviderSelectionTemplateOptions{}

	cmd := &cobra.Command{
		Use:   commandName,
		Short: "Create a provider selection template",
		Long:  providerSelectionLongDescription,
		Run: func(cmd *cobra.Command, args []string) {
			if err := options.Validate(args); err != nil {
				cmdutil.CheckErr(cmdutil.UsageErrorf(cmd, err.Error()))
			}

			_, err := io.WriteString(out, selectprovider.SelectProviderTemplateExample)
			if err != nil {
				cmdutil.CheckErr(err)
			}
		},
	}

	return cmd
}

func (o CreateProviderSelectionTemplateOptions) Validate(args []string) error {
	if len(args) != 0 {
		return errors.New("no arguments are supported")
	}

	return nil
}
