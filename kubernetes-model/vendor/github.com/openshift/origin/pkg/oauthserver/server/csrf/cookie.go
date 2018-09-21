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
package csrf

import (
	"net/http"

	"github.com/pborman/uuid"
)

type cookieCsrf struct {
	name     string
	path     string
	domain   string
	secure   bool
	httponly bool
}

// NewCookieCSRF stores random CSRF tokens in a cookie created with the given options.
// Empty CSRF tokens or tokens that do not match the value of the cookie on the request
// are rejected.
func NewCookieCSRF(name, path, domain string, secure, httponly bool) CSRF {
	return &cookieCsrf{
		name:     name,
		path:     path,
		domain:   domain,
		secure:   secure,
		httponly: httponly,
	}
}

// Generate implements the CSRF interface
func (c *cookieCsrf) Generate(w http.ResponseWriter, req *http.Request) (string, error) {
	cookie, err := req.Cookie(c.name)
	if err == nil && len(cookie.Value) > 0 {
		return cookie.Value, nil
	}

	cookie = &http.Cookie{
		Name:     c.name,
		Value:    uuid.NewUUID().String(),
		Path:     c.path,
		Domain:   c.domain,
		Secure:   c.secure,
		HttpOnly: c.httponly,
	}
	http.SetCookie(w, cookie)

	return cookie.Value, nil
}

// Check implements the CSRF interface
func (c *cookieCsrf) Check(req *http.Request, value string) (bool, error) {
	if len(value) == 0 {
		return false, nil
	}

	cookie, err := req.Cookie(c.name)
	if err == http.ErrNoCookie {
		return false, nil
	}
	if err != nil {
		return false, err
	}

	if cookie.Value != value {
		return false, nil
	}

	return true, nil
}
