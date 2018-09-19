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
	"fmt"
	"net/http"
	"path"

	"github.com/emicklei/go-restful"
)

// This example shows how to define methods that serve static files
// It uses the standard http.ServeFile method
//
// GET http://localhost:8080/static/test.xml
// GET http://localhost:8080/static/
//
// GET http://localhost:8080/static?resource=subdir/test.xml

var rootdir = "/tmp"

func main() {
	restful.DefaultContainer.Router(restful.CurlyRouter{})

	ws := new(restful.WebService)
	ws.Route(ws.GET("/static/{subpath:*}").To(staticFromPathParam))
	ws.Route(ws.GET("/static").To(staticFromQueryParam))
	restful.Add(ws)

	println("[go-restful] serving files on http://localhost:8080/static from local /tmp")
	http.ListenAndServe(":8080", nil)
}

func staticFromPathParam(req *restful.Request, resp *restful.Response) {
	actual := path.Join(rootdir, req.PathParameter("subpath"))
	fmt.Printf("serving %s ... (from %s)\n", actual, req.PathParameter("subpath"))
	http.ServeFile(
		resp.ResponseWriter,
		req.Request,
		actual)
}

func staticFromQueryParam(req *restful.Request, resp *restful.Response) {
	http.ServeFile(
		resp.ResponseWriter,
		req.Request,
		path.Join(rootdir, req.QueryParameter("resource")))
}
