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

import "net/http"

func ExampleOPTIONSFilter() {
	// Install the OPTIONS filter on the default Container
	Filter(OPTIONSFilter())
}
func ExampleContainer_OPTIONSFilter() {
	// Install the OPTIONS filter on a Container
	myContainer := new(Container)
	myContainer.Filter(myContainer.OPTIONSFilter)
}

func ExampleContainer() {
	// The Default container of go-restful uses the http.DefaultServeMux.
	// You can create your own Container using restful.NewContainer() and create a new http.Server for that particular container

	ws := new(WebService)
	wsContainer := NewContainer()
	wsContainer.Add(ws)
	server := &http.Server{Addr: ":8080", Handler: wsContainer}
	server.ListenAndServe()
}

func ExampleCrossOriginResourceSharing() {
	// To install this filter on the Default Container use:
	cors := CrossOriginResourceSharing{ExposeHeaders: []string{"X-My-Header"}, CookiesAllowed: false, Container: DefaultContainer}
	Filter(cors.Filter)
}

func ExampleServiceError() {
	resp := new(Response)
	resp.WriteEntity(NewError(http.StatusBadRequest, "Non-integer {id} path parameter"))
}

func ExampleBoundedCachedCompressors() {
	// Register a compressor provider (gzip/deflate read/write) that uses
	// a bounded cache with a maximum of 20 writers and 20 readers.
	SetCompressorProvider(NewBoundedCachedCompressors(20, 20))
}
