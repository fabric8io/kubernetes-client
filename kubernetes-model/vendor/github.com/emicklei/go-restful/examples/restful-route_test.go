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
	"net/http"
	"net/http/httptest"
	"strings"
	"testing"

	"github.com/emicklei/go-restful"
)

var (
	Result string
)

func TestRouteExtractParameter(t *testing.T) {
	// setup service
	ws := new(restful.WebService)
	ws.Consumes(restful.MIME_XML)
	ws.Route(ws.GET("/test/{param}").To(DummyHandler))
	restful.Add(ws)

	// setup request + writer
	bodyReader := strings.NewReader("<Sample><Value>42</Value></Sample>")
	httpRequest, _ := http.NewRequest("GET", "/test/THIS", bodyReader)
	httpRequest.Header.Set("Content-Type", restful.MIME_XML)
	httpWriter := httptest.NewRecorder()

	// run
	restful.DefaultContainer.ServeHTTP(httpWriter, httpRequest)

	if Result != "THIS" {
		t.Fatalf("Result is actually: %s", Result)
	}
}

func DummyHandler(rq *restful.Request, rp *restful.Response) {
	Result = rq.PathParameter("param")
}
