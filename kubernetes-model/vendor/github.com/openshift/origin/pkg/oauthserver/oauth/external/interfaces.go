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
// Package external implements an OAuth flow with an external identity provider
package external

import (
	"net/http"

	"github.com/RangelReale/osincli"
	authapi "github.com/openshift/origin/pkg/oauthserver/api"
)

// Provider encapsulates the URLs, configuration, any custom authorize request parameters, and
// the method for transforming an access token into an identity, for an external OAuth provider.
type Provider interface {
	// NewConfig returns a client information that allows a standard oauth client to communicate with external oauth
	NewConfig() (*osincli.ClientConfig, error)
	// GetTransport returns the transport to use for server-to-server calls. If nil is returned, http.DefaultTransport is used.
	GetTransport() (http.RoundTripper, error)
	// AddCustomParameters allows an external oauth provider to provide parameters that are extension to the spec.  Some providers require this.
	AddCustomParameters(*osincli.AuthorizeRequest)
	// GetUserIdentity takes the external oauth token information this and returns the user identity, isAuthenticated, and error
	GetUserIdentity(*osincli.AccessData) (authapi.UserIdentityInfo, bool, error)
}

// State handles generating and verifying the state parameter round-tripped to an external OAuth flow.
// Examples: CSRF protection, post authentication redirection
type State interface {
	Generate(w http.ResponseWriter, req *http.Request) (string, error)
	Check(state string, req *http.Request) (bool, error)
}
