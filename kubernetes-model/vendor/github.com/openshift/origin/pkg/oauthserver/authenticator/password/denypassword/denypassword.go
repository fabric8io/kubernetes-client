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
package denypassword

import (
	"k8s.io/apiserver/pkg/authentication/authenticator"
	"k8s.io/apiserver/pkg/authentication/user"
)

// denyPasswordAuthenticator denies all password requests
type denyPasswordAuthenticator struct {
}

// New creates a new password authenticator that denies any login attempt
func New() authenticator.Password {
	return &denyPasswordAuthenticator{}
}

// AuthenticatePassword denies any login attempt
func (a denyPasswordAuthenticator) AuthenticatePassword(username, password string) (user.Info, bool, error) {
	return nil, false, nil
}
