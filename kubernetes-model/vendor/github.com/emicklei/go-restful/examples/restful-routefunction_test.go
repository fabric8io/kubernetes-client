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
	"testing"

	"github.com/emicklei/go-restful"
)

// This example show how to test one particular RouteFunction (getIt)
// It uses the httptest.ResponseRecorder to capture output

func getIt(req *restful.Request, resp *restful.Response) {
	resp.WriteHeader(204)
}

func TestCallFunction(t *testing.T) {
	httpReq, _ := http.NewRequest("GET", "/", nil)
	req := restful.NewRequest(httpReq)

	recorder := new(httptest.ResponseRecorder)
	resp := restful.NewResponse(recorder)

	getIt(req, resp)
	if recorder.Code != 204 {
		t.Fatalf("Missing or wrong status code:%d", recorder.Code)
	}
}
