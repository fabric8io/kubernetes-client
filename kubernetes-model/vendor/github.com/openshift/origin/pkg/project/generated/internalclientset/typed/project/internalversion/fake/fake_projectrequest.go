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
package fake

import (
	project "github.com/openshift/origin/pkg/project/apis/project"
	schema "k8s.io/apimachinery/pkg/runtime/schema"
	testing "k8s.io/client-go/testing"
)

// FakeProjectRequests implements ProjectRequestInterface
type FakeProjectRequests struct {
	Fake *FakeProject
}

var projectrequestsResource = schema.GroupVersionResource{Group: "project.openshift.io", Version: "", Resource: "projectrequests"}

var projectrequestsKind = schema.GroupVersionKind{Group: "project.openshift.io", Version: "", Kind: "ProjectRequest"}

// Create takes the representation of a projectRequest and creates it.  Returns the server's representation of the projectResource, and an error, if there is any.
func (c *FakeProjectRequests) Create(projectRequest *project.ProjectRequest) (result *project.Project, err error) {
	obj, err := c.Fake.
		Invokes(testing.NewRootCreateAction(projectrequestsResource, projectRequest), &project.Project{})
	if obj == nil {
		return nil, err
	}
	return obj.(*project.Project), err
}
