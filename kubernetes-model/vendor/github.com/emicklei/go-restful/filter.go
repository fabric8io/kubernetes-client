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

// FilterChain is a request scoped object to process one or more filters before calling the target RouteFunction.
type FilterChain struct {
	Filters []FilterFunction // ordered list of FilterFunction
	Index   int              // index into filters that is currently in progress
	Target  RouteFunction    // function to call after passing all filters
}

// ProcessFilter passes the request,response pair through the next of Filters.
// Each filter can decide to proceed to the next Filter or handle the Response itself.
func (f *FilterChain) ProcessFilter(request *Request, response *Response) {
	if f.Index < len(f.Filters) {
		f.Index++
		f.Filters[f.Index-1](request, response, f)
	} else {
		f.Target(request, response)
	}
}

// FilterFunction definitions must call ProcessFilter on the FilterChain to pass on the control and eventually call the RouteFunction
type FilterFunction func(*Request, *Response, *FilterChain)

// NoBrowserCacheFilter is a filter function to set HTTP headers that disable browser caching
// See examples/restful-no-cache-filter.go for usage
func NoBrowserCacheFilter(req *Request, resp *Response, chain *FilterChain) {
	resp.Header().Set("Cache-Control", "no-cache, no-store, must-revalidate") // HTTP 1.1.
	resp.Header().Set("Pragma", "no-cache")                                   // HTTP 1.0.
	resp.Header().Set("Expires", "0")                                         // Proxies.
	chain.ProcessFilter(req, resp)
}
