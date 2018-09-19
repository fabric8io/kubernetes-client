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
	"io"
	"net/http"

	"github.com/emicklei/go-restful"
)

// This example shows how to use a WebService filter that passed the Http headers to disable browser cacheing.
//
// GET http://localhost:8080/hello

func main() {
	ws := new(restful.WebService)
	ws.Filter(restful.NoBrowserCacheFilter)
	ws.Route(ws.GET("/hello").To(hello))
	restful.Add(ws)
	http.ListenAndServe(":8080", nil)
}

func hello(req *restful.Request, resp *restful.Response) {
	io.WriteString(resp, "world")
}
