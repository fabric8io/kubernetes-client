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
package util

const (
	ProductOpenShift = `OpenShift`
)

// GetProductName chooses appropriate product for a binary name.
func GetProductName(binaryName string) string {
	return ProductOpenShift
}

// GetPlatformName returns an appropriate platform name for given binary name.
// Platform name can be used as a headline in command's usage.
func GetPlatformName(binaryName string) string {
	return "OpenShift Application Platform"
}

// GetDistributionName returns an appropriate Kubernetes distribution name.
// Distribution name can be used in relation to some feature set in command's
// usage string (e.g. <distribution name> allows you to build, run, etc.).
func GetDistributionName(binaryName string) string {
	return "OpenShift distribution of Kubernetes"
}
