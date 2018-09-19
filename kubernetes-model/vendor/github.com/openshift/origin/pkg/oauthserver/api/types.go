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

import (
	"k8s.io/apiserver/pkg/authentication/user"
)

const (
	// IdentityDisplayNameKey is the key for an optional display name in an identity's Extra map
	IdentityDisplayNameKey = "name"
	// IdentityEmailKey is the key for an optional email address in an identity's Extra map
	IdentityEmailKey = "email"
	// IdentityPreferredUsernameKey is the key for an optional preferred username in an identity's Extra map.
	// This is useful when the immutable providerUserName is different than the login used to authenticate
	// If present, this extra value is used as the preferred username
	IdentityPreferredUsernameKey = "preferred_username"
)

// UserIdentityInfo contains information about an identity.  Identities are distinct from users.  An authentication server of
// some kind (like oauth for example) describes an identity.  Our system controls the users mapped to this identity.
type UserIdentityInfo interface {
	// GetIdentityName returns the name of this identity. It must be equal to GetProviderName() + ":" + GetProviderUserName()
	GetIdentityName() string
	// GetProviderName returns the name of the provider of this identity.
	GetProviderName() string
	// GetProviderUserName uniquely identifies this particular identity for this provider.  It is NOT guaranteed to be unique across providers
	GetProviderUserName() string
	// GetExtra is a map to allow providers to add additional fields that they understand
	GetExtra() map[string]string
}

// UserIdentityMapper maps UserIdentities into user.Info objects to allow different user abstractions within auth code.
type UserIdentityMapper interface {
	// UserFor takes an identity, ignores the passed identity.Provider, forces the provider value to some other value and then creates the mapping.
	// It returns the corresponding user.Info
	UserFor(identityInfo UserIdentityInfo) (user.Info, error)
}

type Client interface {
	GetId() string
	GetSecret() string
	GetRedirectUri() string
	GetUserData() interface{}
}

type Grant struct {
	Client      Client
	Scope       string
	Expiration  int64
	RedirectURI string
}

type DefaultUserIdentityInfo struct {
	ProviderName     string
	ProviderUserName string
	Extra            map[string]string
}

// NewDefaultUserIdentityInfo returns a DefaultUserIdentityInfo with a non-nil Extra component
func NewDefaultUserIdentityInfo(providerName, providerUserName string) *DefaultUserIdentityInfo {
	return &DefaultUserIdentityInfo{
		ProviderName:     providerName,
		ProviderUserName: providerUserName,
		Extra:            map[string]string{},
	}
}

func (i *DefaultUserIdentityInfo) GetIdentityName() string {
	return i.ProviderName + ":" + i.ProviderUserName
}

func (i *DefaultUserIdentityInfo) GetProviderName() string {
	return i.ProviderName
}

func (i *DefaultUserIdentityInfo) GetProviderUserName() string {
	return i.ProviderUserName
}

func (i *DefaultUserIdentityInfo) GetExtra() map[string]string {
	return i.Extra
}
