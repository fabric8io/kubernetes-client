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
package imagepolicy

// RequestsResolution returns true if you should attempt to resolve image pull specs
func RequestsResolution(imageResolutionType ImageResolutionType) bool {
	switch imageResolutionType {
	case RequiredRewrite, Required, AttemptRewrite, Attempt:
		return true
	}
	return false
}

// FailOnResolutionFailure returns true if you should fail when resolution fails
func FailOnResolutionFailure(imageResolutionType ImageResolutionType) bool {
	switch imageResolutionType {
	case RequiredRewrite, Required:
		return true
	}
	return false
}

// RewriteImagePullSpec returns true if you should rewrite image pull specs when resolution succeeds
func RewriteImagePullSpec(imageResolutionType ImageResolutionType) bool {
	switch imageResolutionType {
	case RequiredRewrite, AttemptRewrite:
		return true
	}
	return false
}
