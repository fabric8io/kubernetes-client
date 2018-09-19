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
package restful

// Copyright 2013 Ernest Micklei. All rights reserved.
// Use of this source code is governed by a license
// that can be found in the LICENSE file.

import (
	"net/http"
)

// DefaultContainer is a restful.Container that uses http.DefaultServeMux
var DefaultContainer *Container

func init() {
	DefaultContainer = NewContainer()
	DefaultContainer.ServeMux = http.DefaultServeMux
}

// If set the true then panics will not be caught to return HTTP 500.
// In that case, Route functions are responsible for handling any error situation.
// Default value is false = recover from panics. This has performance implications.
// OBSOLETE ; use restful.DefaultContainer.DoNotRecover(true)
var DoNotRecover = false

// Add registers a new WebService add it to the DefaultContainer.
func Add(service *WebService) {
	DefaultContainer.Add(service)
}

// Filter appends a container FilterFunction from the DefaultContainer.
// These are called before dispatching a http.Request to a WebService.
func Filter(filter FilterFunction) {
	DefaultContainer.Filter(filter)
}

// RegisteredWebServices returns the collections of WebServices from the DefaultContainer
func RegisteredWebServices() []*WebService {
	return DefaultContainer.RegisteredWebServices()
}
