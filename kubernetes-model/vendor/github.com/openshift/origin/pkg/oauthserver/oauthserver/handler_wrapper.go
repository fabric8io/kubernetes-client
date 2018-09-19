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
package oauthserver

import (
	"net/http"
)

type handlerWrapper interface {
	Wrap(http.Handler) http.Handler
}

// handlerWrapperMux wraps all handlers before registering them in the contained mux
type handlerWrapperMux struct {
	mux     mux
	wrapper handlerWrapper
}

var _ = mux(&handlerWrapperMux{})

func (m *handlerWrapperMux) Handle(pattern string, handler http.Handler) {
	m.mux.Handle(pattern, m.wrapper.Wrap(handler))
}
func (m *handlerWrapperMux) HandleFunc(pattern string, handler func(http.ResponseWriter, *http.Request)) {
	m.mux.Handle(pattern, m.wrapper.Wrap(http.HandlerFunc(handler)))
}
