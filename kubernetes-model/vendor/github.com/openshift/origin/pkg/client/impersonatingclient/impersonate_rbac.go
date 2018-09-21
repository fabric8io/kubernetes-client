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
package impersonatingclient

import (
	apierrors "k8s.io/apimachinery/pkg/api/errors"
	"k8s.io/apiserver/pkg/endpoints/request"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	"k8s.io/client-go/rest"
	rbacinternalversion "k8s.io/kubernetes/pkg/client/clientset_generated/internalclientset/typed/rbac/internalversion"
)

func NewImpersonatingRBACFromContext(ctx apirequest.Context, restclient rest.Interface) (rbacinternalversion.RbacInterface, error) {
	user, ok := request.UserFrom(ctx)
	if !ok {
		return nil, apierrors.NewBadRequest("user missing from context")
	}
	return rbacinternalversion.New(NewImpersonatingRESTClient(user, restclient)), nil
}
