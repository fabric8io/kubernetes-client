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

import "strings"

// Copyright 2013 Ernest Micklei. All rights reserved.
// Use of this source code is governed by a license
// that can be found in the LICENSE file.

// OPTIONSFilter is a filter function that inspects the Http Request for the OPTIONS method
// and provides the response with a set of allowed methods for the request URL Path.
// As for any filter, you can also install it for a particular WebService within a Container.
// Note: this filter is not needed when using CrossOriginResourceSharing (for CORS).
func (c *Container) OPTIONSFilter(req *Request, resp *Response, chain *FilterChain) {
	if "OPTIONS" != req.Request.Method {
		chain.ProcessFilter(req, resp)
		return
	}
	resp.AddHeader(HEADER_Allow, strings.Join(c.computeAllowedMethods(req), ","))
}

// OPTIONSFilter is a filter function that inspects the Http Request for the OPTIONS method
// and provides the response with a set of allowed methods for the request URL Path.
// Note: this filter is not needed when using CrossOriginResourceSharing (for CORS).
func OPTIONSFilter() FilterFunction {
	return DefaultContainer.OPTIONSFilter
}
