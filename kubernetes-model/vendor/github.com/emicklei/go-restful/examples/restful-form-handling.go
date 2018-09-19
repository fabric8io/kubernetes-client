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
	"github.com/emicklei/go-restful"
	"github.com/gorilla/schema"
	"io"
	"net/http"
)

// This example shows how to handle a POST of a HTML form that uses the standard x-www-form-urlencoded content-type.
// It uses the gorilla web tool kit schema package to decode the form data into a struct.
//
// GET http://localhost:8080/profiles
//

type Profile struct {
	Name string
	Age  int
}

var decoder *schema.Decoder

func main() {
	decoder = schema.NewDecoder()
	ws := new(restful.WebService)
	ws.Route(ws.POST("/profiles").Consumes("application/x-www-form-urlencoded").To(postAdddress))
	ws.Route(ws.GET("/profiles").To(addresssForm))
	restful.Add(ws)
	http.ListenAndServe(":8080", nil)
}

func postAdddress(req *restful.Request, resp *restful.Response) {
	err := req.Request.ParseForm()
	if err != nil {
		resp.WriteErrorString(http.StatusBadRequest, err.Error())
		return
	}
	p := new(Profile)
	err = decoder.Decode(p, req.Request.PostForm)
	if err != nil {
		resp.WriteErrorString(http.StatusBadRequest, err.Error())
		return
	}
	io.WriteString(resp.ResponseWriter, fmt.Sprintf("<html><body>Name=%s, Age=%d</body></html>", p.Name, p.Age))
}

func addresssForm(req *restful.Request, resp *restful.Response) {
	io.WriteString(resp.ResponseWriter,
		`<html>
		<body>
		<h1>Enter Profile</h1>
		<form method="post">
		    <label>Name:</label>
			<input type="text" name="Name"/>
			<label>Age:</label>
		    <input type="text" name="Age"/>
			<input type="Submit" />
		</form>
		</body>
		</html>`)
}
