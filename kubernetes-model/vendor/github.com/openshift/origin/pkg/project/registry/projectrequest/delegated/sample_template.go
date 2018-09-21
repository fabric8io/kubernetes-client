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
package delegated

import (
	"k8s.io/api/rbac/v1beta1"
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/kubernetes/pkg/apis/rbac"

	projectapiv1 "github.com/openshift/api/project/v1"
	oapi "github.com/openshift/origin/pkg/api"
	"github.com/openshift/origin/pkg/cmd/server/bootstrappolicy"
	projectapi "github.com/openshift/origin/pkg/project/apis/project"
	templateapi "github.com/openshift/origin/pkg/template/apis/template"
)

const (
	DefaultTemplateName = "project-request"

	ProjectNameParam        = "PROJECT_NAME"
	ProjectDisplayNameParam = "PROJECT_DISPLAYNAME"
	ProjectDescriptionParam = "PROJECT_DESCRIPTION"
	ProjectAdminUserParam   = "PROJECT_ADMIN_USER"
	ProjectRequesterParam   = "PROJECT_REQUESTING_USER"
)

var (
	parameters = []string{ProjectNameParam, ProjectDisplayNameParam, ProjectDescriptionParam, ProjectAdminUserParam, ProjectRequesterParam}
)

func DefaultTemplate() *templateapi.Template {
	ret := &templateapi.Template{}
	ret.Name = DefaultTemplateName

	ns := "${" + ProjectNameParam + "}"

	project := &projectapi.Project{}
	project.Name = ns
	project.Annotations = map[string]string{
		oapi.OpenShiftDescription:   "${" + ProjectDescriptionParam + "}",
		oapi.OpenShiftDisplayName:   "${" + ProjectDisplayNameParam + "}",
		projectapi.ProjectRequester: "${" + ProjectRequesterParam + "}",
	}
	if err := templateapi.AddObjectsToTemplate(ret, []runtime.Object{project}, projectapiv1.SchemeGroupVersion); err != nil {
		panic(err)
	}

	serviceAccountRoleBindings := bootstrappolicy.GetBootstrapServiceAccountProjectRoleBindings(ns)
	for i := range serviceAccountRoleBindings {
		if err := templateapi.AddObjectsToTemplate(ret, []runtime.Object{&serviceAccountRoleBindings[i]}, v1beta1.SchemeGroupVersion); err != nil {
			panic(err)
		}
	}

	binding := rbac.NewRoleBindingForClusterRole(bootstrappolicy.AdminRoleName, ns).Users("${" + ProjectAdminUserParam + "}").BindingOrDie()

	if err := templateapi.AddObjectsToTemplate(ret, []runtime.Object{&binding}, v1beta1.SchemeGroupVersion); err != nil {
		// this should never happen because we're tightly controlling what goes in.
		panic(err)
	}

	for _, parameterName := range parameters {
		parameter := templateapi.Parameter{}
		parameter.Name = parameterName
		ret.Parameters = append(ret.Parameters, parameter)
	}

	return ret
}
