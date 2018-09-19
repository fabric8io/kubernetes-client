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
	"io"
	"testing"
)

var uris = []string{}

func setup(container *Container) {
	wsCount := 26
	rtCount := 26

	for i := 0; i < wsCount; i++ {
		root := fmt.Sprintf("/%s/{%s}/", string(i+97), string(i+97))
		ws := new(WebService).Path(root)
		for j := 0; j < rtCount; j++ {
			sub := fmt.Sprintf("/%s2/{%s2}", string(j+97), string(j+97))
			ws.Route(ws.GET(sub).To(echo))
		}
		container.Add(ws)
		for _, each := range ws.Routes() {
			uris = append(uris, "http://bench.com"+each.Path)
		}
	}
}

func echo(req *Request, resp *Response) {
	io.WriteString(resp.ResponseWriter, "echo")
}

func BenchmarkMany(b *testing.B) {
	container := NewContainer()
	setup(container)
	b.ResetTimer()
	for t := 0; t < b.N; t++ {
		for _, each := range uris {
			// println(each)
			sendItTo(each, container)
		}
	}
}
