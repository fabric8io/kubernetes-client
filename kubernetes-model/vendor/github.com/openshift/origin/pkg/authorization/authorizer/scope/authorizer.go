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
package scope

import (
	"fmt"

	kerrors "k8s.io/apimachinery/pkg/util/errors"
	"k8s.io/apiserver/pkg/authorization/authorizer"
	rbaclisters "k8s.io/kubernetes/pkg/client/listers/rbac/internalversion"
	authorizerrbac "k8s.io/kubernetes/plugin/pkg/auth/authorizer/rbac"

	authorizationapi "github.com/openshift/origin/pkg/authorization/apis/authorization"
	defaultauthorizer "github.com/openshift/origin/pkg/authorization/authorizer"
)

type scopeAuthorizer struct {
	clusterRoleGetter rbaclisters.ClusterRoleLister

	forbiddenMessageMaker defaultauthorizer.ForbiddenMessageMaker
}

func NewAuthorizer(clusterRoleGetter rbaclisters.ClusterRoleLister, forbiddenMessageMaker defaultauthorizer.ForbiddenMessageMaker) authorizer.Authorizer {
	return &scopeAuthorizer{clusterRoleGetter: clusterRoleGetter, forbiddenMessageMaker: forbiddenMessageMaker}
}

func (a *scopeAuthorizer) Authorize(attributes authorizer.Attributes) (authorizer.Decision, string, error) {
	user := attributes.GetUser()
	if user == nil {
		return authorizer.DecisionNoOpinion, "", fmt.Errorf("user missing from context")
	}

	scopes := user.GetExtra()[authorizationapi.ScopesKey]
	if len(scopes) == 0 {
		return authorizer.DecisionNoOpinion, "", nil
	}

	nonFatalErrors := []error{}

	// scopeResolutionErrors aren't fatal.  If any of the scopes we find allow this, then the overall scope limits allow it
	rules, err := ScopesToRules(scopes, attributes.GetNamespace(), a.clusterRoleGetter)
	if err != nil {
		nonFatalErrors = append(nonFatalErrors, err)
	}

	// check rules against attributes
	if authorizerrbac.RulesAllow(attributes, rules...) {
		return authorizer.DecisionNoOpinion, "", nil
	}

	denyReason, err := a.forbiddenMessageMaker.MakeMessage(attributes)
	if err != nil {
		denyReason = err.Error()
	}

	// the scope prevent this.  We need to authoritatively deny
	return authorizer.DecisionDeny, fmt.Sprintf("scopes %v prevent this action; %v", scopes, denyReason), kerrors.NewAggregate(nonFatalErrors)
}
