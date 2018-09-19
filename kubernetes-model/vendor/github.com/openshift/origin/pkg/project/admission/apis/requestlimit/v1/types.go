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
package v1

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
)

// +k8s:deepcopy-gen:interfaces=k8s.io/apimachinery/pkg/runtime.Object

// ProjectRequestLimitConfig is the configuration for the project request limit plug-in
// It contains an ordered list of limits based on user label selectors. Selectors will
// be checked in order and the first one that applies will be used as the limit.
type ProjectRequestLimitConfig struct {
	metav1.TypeMeta `json:",inline"`

	// Limits are the project request limits
	Limits []ProjectLimitBySelector `json:"limits" description:"project request limits"`

	// MaxProjectsForSystemUsers controls how many projects a certificate user may have.  Certificate
	// users do not have any labels associated with them for more fine grained control
	MaxProjectsForSystemUsers *int `json:"maxProjectsForSystemUsers"`

	// MaxProjectsForServiceAccounts controls how many projects a service account may have.  Service
	// accounts can't create projects by default, but if they are allowed to create projects, you cannot
	// trust any labels placed on them since project editors can manipulate those labels
	MaxProjectsForServiceAccounts *int `json:"maxProjectsForServiceAccounts"`
}

// ProjectLimitBySelector specifies the maximum number of projects allowed for a given user label selector
type ProjectLimitBySelector struct {
	// Selector is a user label selector. An empty selector selects everything.
	Selector map[string]string `json:"selector" description:"user label selector"`
	// MaxProjects is the number of projects allowed for this class of users. If MaxProjects is nil,
	// there is no limit to the number of projects users can request. An unlimited number of projects
	// is useful in the case a limit is specified as the default for all users and only users with a
	// specific set of labels should be allowed unlimited project creation.
	MaxProjects *int `json:"maxProjects,omitempty" description:"maximum number of projects, unlimited if nil"`
}
