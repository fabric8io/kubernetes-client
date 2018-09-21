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
package start

import (
	"github.com/spf13/pflag"

	"github.com/openshift/origin/pkg/cmd/util/variable"
)

// ImageFormatArgs is a struct that the command stores flag values into.
type ImageFormatArgs struct {
	// ImageTemplate is used in expanding parameterized Docker image references
	// from configuration or a file
	ImageTemplate variable.ImageTemplate
}

// BindImageFormatArgs binds values to the given arguments by using flags
func BindImageFormatArgs(args *ImageFormatArgs, flags *pflag.FlagSet, prefix string) {
	flags.StringVar(&args.ImageTemplate.Format, "images", args.ImageTemplate.Format, "When fetching images used by the cluster for important components, use this format on both master and nodes. The latest release will be used by default.")
	flags.BoolVar(&args.ImageTemplate.Latest, "latest-images", args.ImageTemplate.Latest, "If true, attempt to use the latest images for the cluster instead of the latest release.")
}

// NewDefaultImageFormatArgs returns the default image template
func NewDefaultImageFormatArgs() *ImageFormatArgs {
	config := &ImageFormatArgs{
		ImageTemplate: variable.NewDefaultImageTemplate(),
	}

	return config
}
