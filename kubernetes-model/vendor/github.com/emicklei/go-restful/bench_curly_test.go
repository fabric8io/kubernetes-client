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
	"fmt"
	"net/http"
	"net/http/httptest"
	"testing"
)

func setupCurly(container *Container) []string {
	wsCount := 26
	rtCount := 26
	urisCurly := []string{}

	container.Router(CurlyRouter{})
	for i := 0; i < wsCount; i++ {
		root := fmt.Sprintf("/%s/{%s}/", string(i+97), string(i+97))
		ws := new(WebService).Path(root)
		for j := 0; j < rtCount; j++ {
			sub := fmt.Sprintf("/%s2/{%s2}", string(j+97), string(j+97))
			ws.Route(ws.GET(sub).Consumes("application/xml").Produces("application/xml").To(echoCurly))
		}
		container.Add(ws)
		for _, each := range ws.Routes() {
			urisCurly = append(urisCurly, "http://bench.com"+each.Path)
		}
	}
	return urisCurly
}

func echoCurly(req *Request, resp *Response) {}

func BenchmarkManyCurly(b *testing.B) {
	container := NewContainer()
	urisCurly := setupCurly(container)
	b.ResetTimer()
	for t := 0; t < b.N; t++ {
		for r := 0; r < 1000; r++ {
			for _, each := range urisCurly {
				sendNoReturnTo(each, container, t)
			}
		}
	}
}

func sendNoReturnTo(address string, container *Container, t int) {
	httpRequest, _ := http.NewRequest("GET", address, nil)
	httpRequest.Header.Set("Accept", "application/xml")
	httpWriter := httptest.NewRecorder()
	container.dispatch(httpWriter, httpRequest)
}
