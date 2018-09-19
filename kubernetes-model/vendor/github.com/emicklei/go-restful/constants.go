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

const (
	MIME_XML   = "application/xml"          // Accept or Content-Type used in Consumes() and/or Produces()
	MIME_JSON  = "application/json"         // Accept or Content-Type used in Consumes() and/or Produces()
	MIME_OCTET = "application/octet-stream" // If Content-Type is not present in request, use the default

	HEADER_Allow                         = "Allow"
	HEADER_Accept                        = "Accept"
	HEADER_Origin                        = "Origin"
	HEADER_ContentType                   = "Content-Type"
	HEADER_LastModified                  = "Last-Modified"
	HEADER_AcceptEncoding                = "Accept-Encoding"
	HEADER_ContentEncoding               = "Content-Encoding"
	HEADER_AccessControlExposeHeaders    = "Access-Control-Expose-Headers"
	HEADER_AccessControlRequestMethod    = "Access-Control-Request-Method"
	HEADER_AccessControlRequestHeaders   = "Access-Control-Request-Headers"
	HEADER_AccessControlAllowMethods     = "Access-Control-Allow-Methods"
	HEADER_AccessControlAllowOrigin      = "Access-Control-Allow-Origin"
	HEADER_AccessControlAllowCredentials = "Access-Control-Allow-Credentials"
	HEADER_AccessControlAllowHeaders     = "Access-Control-Allow-Headers"
	HEADER_AccessControlMaxAge           = "Access-Control-Max-Age"

	ENCODING_GZIP    = "gzip"
	ENCODING_DEFLATE = "deflate"
)
