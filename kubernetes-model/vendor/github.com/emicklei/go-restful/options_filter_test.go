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

import (
	"net/http"
	"net/http/httptest"
	"testing"
)

// go test -v -test.run TestOptionsFilter ...restful
func TestOptionsFilter(t *testing.T) {
	tearDown()
	ws := new(WebService)
	ws.Route(ws.GET("/candy/{kind}").To(dummy))
	ws.Route(ws.DELETE("/candy/{kind}").To(dummy))
	ws.Route(ws.POST("/candies").To(dummy))
	Add(ws)
	Filter(OPTIONSFilter())

	httpRequest, _ := http.NewRequest("OPTIONS", "http://here.io/candy/gum", nil)
	httpWriter := httptest.NewRecorder()
	DefaultContainer.dispatch(httpWriter, httpRequest)
	actual := httpWriter.Header().Get(HEADER_Allow)
	if "GET,DELETE" != actual {
		t.Fatal("expected: GET,DELETE but got:" + actual)
	}

	httpRequest, _ = http.NewRequest("OPTIONS", "http://here.io/candies", nil)
	httpWriter = httptest.NewRecorder()
	DefaultContainer.dispatch(httpWriter, httpRequest)
	actual = httpWriter.Header().Get(HEADER_Allow)
	if "POST" != actual {
		t.Fatal("expected: POST but got:" + actual)
	}
}
