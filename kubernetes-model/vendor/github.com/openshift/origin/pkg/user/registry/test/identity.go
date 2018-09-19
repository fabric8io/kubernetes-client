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

type Action struct {
	Name   string
	Object interface{}
}

type IdentityRegistry struct {
	*fake.FakeIdentities

	GetErr        map[string]error
	GetIdentities map[string]*userapi.Identity

	CreateErr      error
	CreateIdentity *userapi.Identity

	UpdateErr      error
	UpdateIdentity *userapi.Identity

	ListErr      error
	ListIdentity *userapi.IdentityList

	Actions *[]Action
}

func (r *IdentityRegistry) Get(name string, options metav1.GetOptions) (*userapi.Identity, error) {
	*r.Actions = append(*r.Actions, Action{"GetIdentity", name})
	if identity, ok := r.GetIdentities[name]; ok {
		return identity, nil
	}
	if err, ok := r.GetErr[name]; ok {
		return nil, err
	}
	return nil, kerrs.NewNotFound(userapi.Resource("identity"), name)
}

func (r *IdentityRegistry) Create(u *userapi.Identity) (*userapi.Identity, error) {
	*r.Actions = append(*r.Actions, Action{"CreateIdentity", u})
	if r.CreateIdentity == nil && r.CreateErr == nil {
		return u, nil
	}
	return r.CreateIdentity, r.CreateErr
}

func (r *IdentityRegistry) Update(u *userapi.Identity) (*userapi.Identity, error) {
	*r.Actions = append(*r.Actions, Action{"UpdateIdentity", u})
	if r.UpdateIdentity == nil && r.UpdateErr == nil {
		return u, nil
	}
	return r.UpdateIdentity, r.UpdateErr
}

func (r *IdentityRegistry) List(options metav1.ListOptions) (*userapi.IdentityList, error) {
	*r.Actions = append(*r.Actions, Action{"ListIdentities", options})
	if r.ListIdentity == nil && r.ListErr == nil {
		return &userapi.IdentityList{}, nil
	}
	return r.ListIdentity, r.ListErr
}
