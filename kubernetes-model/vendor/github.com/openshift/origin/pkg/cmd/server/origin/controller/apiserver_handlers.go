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
package controller

import (
	"k8s.io/apimachinery/pkg/util/sets"
	kauthorizer "k8s.io/apiserver/pkg/authorization/authorizer"
)

type bypassAuthorizer struct {
	paths      sets.String
	authorizer kauthorizer.Authorizer
}

// newBypassAuthorizer creates an Authorizer that always allows the exact paths described, and delegates to the nested
// authorizer for everything else.
func newBypassAuthorizer(auth kauthorizer.Authorizer, paths ...string) kauthorizer.Authorizer {
	return bypassAuthorizer{paths: sets.NewString(paths...), authorizer: auth}
}

func (a bypassAuthorizer) Authorize(attributes kauthorizer.Attributes) (allowed kauthorizer.Decision, reason string, err error) {
	if !attributes.IsResourceRequest() && a.paths.Has(attributes.GetPath()) {
		return kauthorizer.DecisionAllow, "always allowed", nil
	}
	return a.authorizer.Authorize(attributes)
}
