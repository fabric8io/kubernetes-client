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
package cmd

import (
	"flag"
	"fmt"
	"io"

	"github.com/spf13/cobra"
	"github.com/spf13/pflag"
)

func NewCmdDepCheck(name string, out, errout io.Writer) *cobra.Command {
	cmd := &cobra.Command{
		Use:     fmt.Sprintf("%s (ARGUMENT) [OPTIONS]", name),
		Short:   "Gather information about a dependency tree.",
		Long:    "Modify or gather information about a dependency tree.",
		Example: fmt.Sprintf(pinImportsExample, name),
		RunE: func(c *cobra.Command, args []string) error {
			c.SetOutput(errout)
			return c.Help()
		},
	}

	cmd.AddCommand(NewCmdPinImports(name, out, errout))

	// add glog flags to our global flag set
	pflag.CommandLine.AddGoFlagSet(flag.CommandLine)
	pflag.CommandLine.Set("logtostderr", "true")
	return cmd
}
