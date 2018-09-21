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
package recycle

import (
	"fmt"
	"io"
	"os"

	"github.com/spf13/cobra"

	"k8s.io/kubernetes/pkg/kubectl/cmd/templates"
	kcmdutil "k8s.io/kubernetes/pkg/kubectl/cmd/util"
)

var (
	recyclerLong = templates.LongDesc(`
		Recycle a volume

		This command will recycle a single volume provided as an argument.`)
)

// NewCommandRecycle provides a CLI handler for recycling volumes
func NewCommandRecycle(name string, out io.Writer) *cobra.Command {
	cmd := &cobra.Command{
		Use:   fmt.Sprintf("%s DIRNAME", name),
		Short: "Recycle a directory",
		Long:  recyclerLong,
		Run: func(c *cobra.Command, args []string) {
			if len(args) != 1 {
				kcmdutil.CheckErr(kcmdutil.UsageErrorf(c, "a directory to recycle is required as the only argument"))
			}
			if err := Recycle(args[0]); err != nil {
				kcmdutil.CheckErr(fmt.Errorf("recycle failed: %v", err))
			}
			if err := CheckEmpty(args[0]); err != nil {
				// Recycler did not delete everything, some other pod has
				// probably written some data there. Report an error and
				// Kubernetes will try to recycle the volume again in few
				// seconds.
				kcmdutil.CheckErr(fmt.Errorf("recycle failed: %v", err))
			}
			fmt.Fprintln(out, "Scrub ok")
		},
	}
	return cmd
}

// Recycle recursively deletes files and folders within the given path. It does not delete the path itself.
func Recycle(dir string) error {
	return newWalker(func(path string, info os.FileInfo) error {
		// Leave the root dir alone
		if path == dir {
			return nil
		}

		// Delete all subfiles/subdirs
		return os.Remove(path)
	}).Walk(dir)
}

// CheckEmpty returns error if specified directory is not empty.
func CheckEmpty(dir string) error {
	return newWalker(func(path string, info os.FileInfo) error {
		// Leave the root dir alone
		if path == dir {
			return nil
		}
		// Report any other existing file as error
		return fmt.Errorf("Recycled volume is not empty")
	}).Walk(dir)
}
