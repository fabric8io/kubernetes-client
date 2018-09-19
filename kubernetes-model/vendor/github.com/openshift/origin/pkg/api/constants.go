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
package api

// annotation keys
const (
	// OpenShiftDisplayName is a common, optional annotation that stores the name displayed by a UI when referencing a resource.
	OpenShiftDisplayName = "openshift.io/display-name"

	// OpenShiftProviderDisplayNameAnnotation is the name of a provider of a resource, e.g.
	// "Red Hat, Inc."
	OpenShiftProviderDisplayNameAnnotation = "openshift.io/provider-display-name"

	// OpenShiftDocumentationURLAnnotation is the url where documentation associated with
	// a resource can be found.
	OpenShiftDocumentationURLAnnotation = "openshift.io/documentation-url"

	// OpenShiftSupportURLAnnotation is the url where support for a template can be found.
	OpenShiftSupportURLAnnotation = "openshift.io/support-url"

	// OpenShiftDescription is a common, optional annotation that stores the description for a resource.
	OpenShiftDescription = "openshift.io/description"

	// OpenShiftLongDescriptionAnnotation is a resource's long description
	OpenShiftLongDescriptionAnnotation = "openshift.io/long-description"

	// DeprecatedKubeCreatedByAnnotation was removed by https://github.com/kubernetes/kubernetes/pull/54445 (liggitt approved).
	// TODO need to figure out who and how this affects.
	DeprecatedKubeCreatedByAnnotation = "kubernetes.io/created-by"
)
