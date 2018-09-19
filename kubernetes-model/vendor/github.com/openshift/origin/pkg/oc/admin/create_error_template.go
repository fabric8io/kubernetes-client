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

	"github.com/openshift/origin/pkg/oauthserver/server/errorpage"
	"github.com/openshift/origin/pkg/oc/cli/util/clientcmd"
)

const CreateErrorTemplateCommand = "create-error-template"

var errorLongDescription = templates.LongDesc(`
		Create a template for customizing the error page

		This command creates a basic template to use as a starting point for
		customizing the authentication error page. Save the output to a file and edit
		the template to change the look and feel or add content.

		To use the template, set oauthConfig.templates.error in the master
		configuration to point to the template file. For example,

		    oauthConfig:
		      templates:
		        error: templates/error.html
		`)

type CreateErrorTemplateOptions struct{}

func NewCommandCreateErrorTemplate(f *clientcmd.Factory, commandName string, fullName string, out io.Writer) *cobra.Command {
	options := &CreateErrorTemplateOptions{}

	cmd := &cobra.Command{
		Use:   commandName,
		Short: "Create an error page template",
		Long:  errorLongDescription,
		Run: func(cmd *cobra.Command, args []string) {
			if err := options.Validate(args); err != nil {
				cmdutil.CheckErr(cmdutil.UsageErrorf(cmd, err.Error()))
			}

			_, err := io.WriteString(out, errorpage.ErrorPageTemplateExample)
			if err != nil {
				cmdutil.CheckErr(err)
			}
		},
	}

	return cmd
}

func (o CreateErrorTemplateOptions) Validate(args []string) error {
	if len(args) != 0 {
		return errors.New("no arguments are supported")
	}

	return nil
}
