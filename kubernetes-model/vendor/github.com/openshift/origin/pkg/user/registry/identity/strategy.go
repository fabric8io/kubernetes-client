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
package identity

import (
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/util/validation/field"
	apirequest "k8s.io/apiserver/pkg/endpoints/request"
	"k8s.io/apiserver/pkg/registry/rest"
	"k8s.io/kubernetes/pkg/api/legacyscheme"

	userapi "github.com/openshift/origin/pkg/user/apis/user"
	"github.com/openshift/origin/pkg/user/apis/user/validation"
)

// identityStrategy implements behavior for Identities
type identityStrategy struct {
	runtime.ObjectTyper
}

// Strategy is the default logic that applies when creating and updating Identity
// objects via the REST API.
var Strategy = identityStrategy{legacyscheme.Scheme}

var _ rest.GarbageCollectionDeleteStrategy = identityStrategy{}

func (identityStrategy) DefaultGarbageCollectionPolicy(ctx apirequest.Context) rest.GarbageCollectionPolicy {
	return rest.Unsupported
}

func (identityStrategy) PrepareForUpdate(ctx apirequest.Context, obj, old runtime.Object) {}

// NamespaceScoped is false for users
func (identityStrategy) NamespaceScoped() bool {
	return false
}

func (identityStrategy) GenerateName(base string) string {
	return base
}

func (identityStrategy) PrepareForCreate(ctx apirequest.Context, obj runtime.Object) {
	identity := obj.(*userapi.Identity)
	identity.Name = identityName(identity.ProviderName, identity.ProviderUserName)
}

// this name cannot change since it must match resources persisted into etcd.
func identityName(provider, identity string) string {
	// TODO: normalize?
	return provider + ":" + identity
}

// Validate validates a new user
func (identityStrategy) Validate(ctx apirequest.Context, obj runtime.Object) field.ErrorList {
	identity := obj.(*userapi.Identity)
	return validation.ValidateIdentity(identity)
}

// AllowCreateOnUpdate is false for identity
func (identityStrategy) AllowCreateOnUpdate() bool {
	return false
}

func (identityStrategy) AllowUnconditionalUpdate() bool {
	return false
}

// Canonicalize normalizes the object after validation.
func (identityStrategy) Canonicalize(obj runtime.Object) {
}

// ValidateUpdate is the default update validation for an identity
func (identityStrategy) ValidateUpdate(ctx apirequest.Context, obj, old runtime.Object) field.ErrorList {
	return validation.ValidateIdentityUpdate(obj.(*userapi.Identity), old.(*userapi.Identity))
}
