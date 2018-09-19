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
package auth

import (
	kauthorizer "k8s.io/apiserver/pkg/authorization/authorizer"
	"k8s.io/kubernetes/plugin/pkg/auth/authorizer/rbac"

	authorizationutil "github.com/openshift/origin/pkg/authorization/util"
)

// Review is a list of users and groups that can access a resource
type Review interface {
	Users() []string
	Groups() []string
	EvaluationError() string
}

type defaultReview struct {
	users           []string
	groups          []string
	evaluationError string
}

func (r *defaultReview) Users() []string {
	return r.users
}

// Groups returns the groups that can access a resource
func (r *defaultReview) Groups() []string {
	return r.groups
}

func (r *defaultReview) EvaluationError() string {
	return r.evaluationError
}

// Reviewer performs access reviews for a project by name
type Reviewer interface {
	Review(name string) (Review, error)
}

type authorizerReviewer struct {
	policyChecker rbac.SubjectLocator
}

func NewAuthorizerReviewer(policyChecker rbac.SubjectLocator) Reviewer {
	return &authorizerReviewer{policyChecker: policyChecker}
}

func (r *authorizerReviewer) Review(namespaceName string) (Review, error) {
	attributes := kauthorizer.AttributesRecord{
		Verb:            "get",
		Namespace:       namespaceName,
		Resource:        "namespaces",
		Name:            namespaceName,
		ResourceRequest: true,
	}

	subjects, err := r.policyChecker.AllowedSubjects(attributes)
	review := &defaultReview{}
	review.users, review.groups = authorizationutil.RBACSubjectsToUsersAndGroups(subjects, attributes.GetNamespace())
	if err != nil {
		review.evaluationError = err.Error()
	}
	return review, nil
}
