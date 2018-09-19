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
package main

import (
	. "github.com/emicklei/go-restful"
	"io"
	"net/http"
)

// This example shows how to a Route that matches the "tail" of a path.
// Requires the use of a CurlyRouter and the star "*" path parameter pattern.
//
// GET http://localhost:8080/basepath/some/other/location/test.xml

func main() {
	DefaultContainer.Router(CurlyRouter{})
	ws := new(WebService)
	ws.Route(ws.GET("/basepath/{resource:*}").To(staticFromPathParam))
	Add(ws)

	println("[go-restful] serve path tails from http://localhost:8080/basepath")
	http.ListenAndServe(":8080", nil)
}

func staticFromPathParam(req *Request, resp *Response) {
	io.WriteString(resp, "Tail="+req.PathParameter("resource"))
}
