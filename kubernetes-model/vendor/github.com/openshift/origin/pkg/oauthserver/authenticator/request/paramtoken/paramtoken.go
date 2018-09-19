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
package paramtoken

import (
	"net/http"
	"strings"

	"k8s.io/apiserver/pkg/authentication/authenticator"
	"k8s.io/apiserver/pkg/authentication/user"
	"k8s.io/apiserver/pkg/util/wsstream"
)

// Authenticator provides a way to authenticate tokens provided as a parameter
// This only exists to allow websocket connections to use an API token, since they cannot set an Authorize header
// For this authenticator to work, tokens will be part of the request URL, and are more likely to be logged or otherwise exposed.
// Every effort should be made to filter tokens from being logged when using this authenticator.
type Authenticator struct {
	// param is the query param to use as a token
	param string
	// auth is the token authenticator to use to validate the token
	auth authenticator.Token
	// removeParam indicates whether the parameter should be stripped from the incoming request
	removeParam bool
}

func New(param string, auth authenticator.Token, removeParam bool) *Authenticator {
	return &Authenticator{param, auth, removeParam}
}

func (a *Authenticator) AuthenticateRequest(req *http.Request) (user.Info, bool, error) {
	// Only accept query param auth for websocket connections
	if !wsstream.IsWebSocketRequest(req) {
		return nil, false, nil
	}

	q := req.URL.Query()
	token := strings.TrimSpace(q.Get(a.param))
	if token == "" {
		return nil, false, nil
	}
	user, ok, err := a.auth.AuthenticateToken(token)
	if ok && a.removeParam {
		q.Del(a.param)
		req.URL.RawQuery = q.Encode()
	}
	return user, ok, err
}
