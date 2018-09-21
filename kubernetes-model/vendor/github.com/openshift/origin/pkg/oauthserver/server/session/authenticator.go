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
package session

import (
	"errors"
	"fmt"
	"net/http"
	"time"

	"strconv"

	"k8s.io/apiserver/pkg/authentication/user"
)

const UserNameKey = "user.name"
const UserUIDKey = "user.uid"
const ExpiresKey = "expires"

type Authenticator struct {
	store  Store
	name   string
	maxAge int
}

func NewAuthenticator(store Store, name string, maxAge int) *Authenticator {
	return &Authenticator{
		store:  store,
		name:   name,
		maxAge: maxAge,
	}
}

func (a *Authenticator) AuthenticateRequest(req *http.Request) (user.Info, bool, error) {
	session, err := a.store.Get(req, a.name)
	if err != nil {
		return nil, false, err
	}

	expiresObj, ok := session.Values()[ExpiresKey]
	if !ok {
		return nil, false, nil
	}
	expiresString, ok := expiresObj.(string)
	if !ok {
		return nil, false, errors.New("expires on session is not a string")
	}
	if expiresString == "" {
		return nil, false, nil
	}
	expires, err := strconv.ParseInt(expiresString, 10, 64)
	if err != nil {
		return nil, false, fmt.Errorf("error parsing expires timestamp: %v", err)
	}
	if expires < time.Now().Unix() {
		return nil, false, nil
	}

	nameObj, ok := session.Values()[UserNameKey]
	if !ok {
		return nil, false, nil
	}
	name, ok := nameObj.(string)
	if !ok {
		return nil, false, errors.New("user.name on session is not a string")
	}
	if name == "" {
		return nil, false, nil
	}

	uidObj, ok := session.Values()[UserUIDKey]
	if !ok {
		return nil, false, nil
	}
	uid, ok := uidObj.(string)
	if !ok {
		return nil, false, errors.New("user.uid on session is not a string")
	}
	// Tolerate empty string UIDs in the session

	return &user.DefaultInfo{
		Name: name,
		UID:  uid,
	}, true, nil
}

func (a *Authenticator) AuthenticationSucceeded(user user.Info, state string, w http.ResponseWriter, req *http.Request) (bool, error) {
	session, err := a.store.Get(req, a.name)
	if err != nil {
		return false, err
	}
	values := session.Values()
	values[UserNameKey] = user.GetName()
	values[UserUIDKey] = user.GetUID()
	values[ExpiresKey] = strconv.FormatInt(time.Now().Add(time.Duration(a.maxAge)*time.Second).Unix(), 10)
	// TODO: should we save groups, scope, and extra in the session as well?
	return false, a.store.Save(w, req)
}

func (a *Authenticator) InvalidateAuthentication(w http.ResponseWriter, req *http.Request) error {
	session, err := a.store.Get(req, a.name)
	if err != nil {
		return err
	}
	session.Values()[UserNameKey] = ""
	session.Values()[UserUIDKey] = ""
	session.Values()[ExpiresKey] = ""
	return a.store.Save(w, req)
}
