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
	"log"
	"net/http"
	"text/template"

	"github.com/emicklei/go-restful"
)

// This example shows how to serve a HTML page using the standard Go template engine.
//
// GET http://localhost:8080/

func main() {
	ws := new(restful.WebService)
	ws.Route(ws.GET("/").To(home))
	restful.Add(ws)
	print("open browser on http://localhost:8080/\n")
	http.ListenAndServe(":8080", nil)
}

type Message struct {
	Text string
}

func home(req *restful.Request, resp *restful.Response) {
	p := &Message{"restful-html-template demo"}
	// you might want to cache compiled templates
	t, err := template.ParseFiles("home.html")
	if err != nil {
		log.Fatalf("Template gave: %s", err)
	}
	t.Execute(resp.ResponseWriter, p)
}
