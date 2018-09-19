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
package policy

import (
	"fmt"

	buildapi "github.com/openshift/origin/pkg/build/apis/build"
)

// NoBuildNumberLabelError represents an error caused by the build not having
// the required build number annotation.
type NoBuildNumberAnnotationError struct {
	build *buildapi.Build
}

func NewNoBuildNumberAnnotationError(build *buildapi.Build) error {
	return NoBuildNumberAnnotationError{build: build}
}

func (e NoBuildNumberAnnotationError) Error() string {
	return fmt.Sprintf("build %s/%s does not have required %q annotation set", e.build.Namespace, e.build.Name, buildapi.BuildNumberAnnotation)
}
