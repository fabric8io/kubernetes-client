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
	"github.com/emicklei/go-restful"
	"io"
	"log"
	"net/http"
)

// This example shows how to use the OPTIONSFilter on a Container
//
// OPTIONS http://localhost:8080/users
//
// OPTIONS http://localhost:8080/users/1

type UserResource struct{}

func (u UserResource) RegisterTo(container *restful.Container) {
	ws := new(restful.WebService)
	ws.
		Path("/users").
		Consumes("*/*").
		Produces("*/*")

	ws.Route(ws.GET("/{user-id}").To(u.nop))
	ws.Route(ws.POST("").To(u.nop))
	ws.Route(ws.PUT("/{user-id}").To(u.nop))
	ws.Route(ws.DELETE("/{user-id}").To(u.nop))

	container.Add(ws)
}

func (u UserResource) nop(request *restful.Request, response *restful.Response) {
	io.WriteString(response.ResponseWriter, "this would be a normal response")
}

func main() {
	wsContainer := restful.NewContainer()
	u := UserResource{}
	u.RegisterTo(wsContainer)

	// Add container filter to respond to OPTIONS
	wsContainer.Filter(wsContainer.OPTIONSFilter)

	// For use on the default container, you can write
	// restful.Filter(restful.OPTIONSFilter())

	log.Printf("start listening on localhost:8080")
	server := &http.Server{Addr: ":8080", Handler: wsContainer}
	log.Fatal(server.ListenAndServe())
}
