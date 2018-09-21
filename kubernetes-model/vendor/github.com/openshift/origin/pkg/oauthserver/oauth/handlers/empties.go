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
package handlers

import (
	"net/http"

	"github.com/golang/glog"

	authapi "github.com/openshift/origin/pkg/oauthserver/api"
	"k8s.io/apiserver/pkg/authentication/user"
)

type EmptyAuth struct{}

func (EmptyAuth) AuthenticationNeeded(client authapi.Client, w http.ResponseWriter, req *http.Request) (bool, error) {
	return false, nil
}

type EmptySuccess struct{}

func (EmptySuccess) AuthenticationSucceeded(user user.Info, state string, w http.ResponseWriter, req *http.Request) (bool, error) {
	glog.V(4).Infof("AuthenticationSucceeded: %v (state=%s)", user, state)
	return false, nil
}

type EmptyError struct{}

func (EmptyError) AuthenticationError(err error, w http.ResponseWriter, req *http.Request) (bool, error) {
	glog.Errorf("AuthenticationError: %v", err)
	return false, err
}

func (EmptyError) GrantError(err error, w http.ResponseWriter, req *http.Request) (bool, error) {
	glog.Errorf("GrantError: %v", err)
	return false, err
}
