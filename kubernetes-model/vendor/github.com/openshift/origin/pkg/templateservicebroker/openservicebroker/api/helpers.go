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
	"net/http"

	templateapi "github.com/openshift/origin/pkg/template/apis/template"
	"k8s.io/apiserver/pkg/authentication/user"
)

func NewResponse(code int, body interface{}, err error) *Response {
	return &Response{Code: code, Body: body, Err: err}
}

func BadRequest(err error) *Response {
	return NewResponse(http.StatusBadRequest, nil, err)
}

func Forbidden(err error) *Response {
	return NewResponse(http.StatusForbidden, nil, err)
}

func InternalServerError(err error) *Response {
	return NewResponse(http.StatusInternalServerError, nil, err)
}

// ConvertUserToTemplateInstanceRequester copies analogous fields from user.Info to TemplateInstanceRequester
func ConvertUserToTemplateInstanceRequester(u user.Info) templateapi.TemplateInstanceRequester {
	templatereq := templateapi.TemplateInstanceRequester{}

	if u != nil {
		extra := map[string]templateapi.ExtraValue{}
		if u.GetExtra() != nil {
			for k, v := range u.GetExtra() {
				extra[k] = templateapi.ExtraValue(v)
			}
		}

		templatereq.Username = u.GetName()
		templatereq.UID = u.GetUID()
		templatereq.Groups = u.GetGroups()
		templatereq.Extra = extra
	}

	return templatereq
}

// ConvertTemplateInstanceRequesterToUser copies analogous fields from TemplateInstanceRequester to user.Info
func ConvertTemplateInstanceRequesterToUser(templateReq *templateapi.TemplateInstanceRequester) user.Info {
	u := user.DefaultInfo{}
	u.Extra = map[string][]string{}

	if templateReq != nil {
		u.Name = templateReq.Username
		u.UID = templateReq.UID
		u.Groups = templateReq.Groups
		if templateReq.Extra != nil {
			for k, v := range templateReq.Extra {
				u.Extra[k] = []string(v)
			}
		}
	}

	return &u
}
