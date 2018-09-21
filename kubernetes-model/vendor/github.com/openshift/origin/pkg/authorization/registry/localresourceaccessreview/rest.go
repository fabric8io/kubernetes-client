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
package localresourceaccessreview

import (
	"fmt"

	kapierrors "k8s.io/apimachinery/pkg/api/errors"
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/util/validation/field"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	"k8s.io/apiserver/pkg/registry/rest"

	authorizationapi "github.com/openshift/origin/pkg/authorization/apis/authorization"
	authorizationvalidation "github.com/openshift/origin/pkg/authorization/apis/authorization/validation"
	"github.com/openshift/origin/pkg/authorization/registry/resourceaccessreview"
)

// REST implements the RESTStorage interface in terms of an Registry.
type REST struct {
	clusterRARRegistry resourceaccessreview.Registry
}

var _ rest.Creater = &REST{}

func NewREST(clusterRARRegistry resourceaccessreview.Registry) *REST {
	return &REST{clusterRARRegistry}
}

func (r *REST) New() runtime.Object {
	return &authorizationapi.LocalResourceAccessReview{}
}

// Create transforms a LocalRAR into an ClusterRAR that is requesting a namespace.  That collapses the code paths.
// LocalResourceAccessReview exists to allow clean expression of policy.
func (r *REST) Create(ctx apirequest.Context, obj runtime.Object, _ rest.ValidateObjectFunc, _ bool) (runtime.Object, error) {
	localRAR, ok := obj.(*authorizationapi.LocalResourceAccessReview)
	if !ok {
		return nil, kapierrors.NewBadRequest(fmt.Sprintf("not a localResourceAccessReview: %#v", obj))
	}
	if errs := authorizationvalidation.ValidateLocalResourceAccessReview(localRAR); len(errs) > 0 {
		return nil, kapierrors.NewInvalid(authorizationapi.Kind(localRAR.Kind), "", errs)
	}
	if namespace := apirequest.NamespaceValue(ctx); len(namespace) == 0 {
		return nil, kapierrors.NewBadRequest(fmt.Sprintf("namespace is required on this type: %v", namespace))
	} else if (len(localRAR.Action.Namespace) > 0) && (namespace != localRAR.Action.Namespace) {
		return nil, field.Invalid(field.NewPath("namespace"), localRAR.Action.Namespace, fmt.Sprintf("namespace must be: %v", namespace))
	}

	// transform this into a ResourceAccessReview
	clusterRAR := &authorizationapi.ResourceAccessReview{
		Action: localRAR.Action,
	}
	clusterRAR.Action.Namespace = apirequest.NamespaceValue(ctx)

	return r.clusterRARRegistry.CreateResourceAccessReview(apirequest.WithNamespace(ctx, ""), clusterRAR)
}
