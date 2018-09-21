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
package version

import (
	"fmt"
	"io"

	"github.com/spf13/cobra"
)

// VersionInfo provides semantic version information
// in a human-friendly format
// TODO: may be expanded for various short and formatting options if necessary.
type VersionInfo interface {
	String() string
}

// NewCmdVersion provides a shim around version for
// non-client packages that require version information
func NewCmdVersion(fullName string, versionInfo VersionInfo, out io.Writer) *cobra.Command {
	cmd := &cobra.Command{
		Use:   "version",
		Short: "Display version",
		Long:  "Display version",
		Run: func(cmd *cobra.Command, args []string) {
			fmt.Fprintf(out, "%s %v\n", fullName, versionInfo)
		},
	}

	return cmd
}
