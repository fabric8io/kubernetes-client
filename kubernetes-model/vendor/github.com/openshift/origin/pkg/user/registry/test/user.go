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
package test

import (
	kerrs "k8s.io/apimachinery/pkg/api/errors"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"

	userapi "github.com/openshift/api/user/v1"
	"github.com/openshift/client-go/user/clientset/versioned/typed/user/v1/fake"
)

type UserRegistry struct {
	// included to fill out the interface for testing
	*fake.FakeUsers

	GetErr   map[string]error
	GetUsers map[string]*userapi.User

	CreateErr  error
	CreateUser *userapi.User

	UpdateErr  map[string]error
	UpdateUser *userapi.User

	ListErr   error
	ListUsers *userapi.UserList

	Actions *[]Action
}

func (r *UserRegistry) Get(name string, options metav1.GetOptions) (*userapi.User, error) {
	*r.Actions = append(*r.Actions, Action{"GetUser", name})
	if user, ok := r.GetUsers[name]; ok {
		return user, nil
	}
	if err, ok := r.GetErr[name]; ok {
		return nil, err
	}
	return nil, kerrs.NewNotFound(userapi.Resource("user"), name)
}

func (r *UserRegistry) Create(u *userapi.User) (*userapi.User, error) {
	*r.Actions = append(*r.Actions, Action{"CreateUser", u})
	if r.CreateUser == nil && r.CreateErr == nil {
		return u, nil
	}
	return r.CreateUser, r.CreateErr
}

func (r *UserRegistry) Update(u *userapi.User) (*userapi.User, error) {
	*r.Actions = append(*r.Actions, Action{"UpdateUser", u})
	err, _ := r.UpdateErr[u.Name]
	if r.UpdateUser == nil && err == nil {
		return u, nil
	}
	return r.UpdateUser, err
}

func (r *UserRegistry) List(options metav1.ListOptions) (*userapi.UserList, error) {
	*r.Actions = append(*r.Actions, Action{"ListUsers", options})
	if r.ListUsers == nil && r.ListErr == nil {
		return &userapi.UserList{}, nil
	}
	return r.ListUsers, r.ListErr
}
