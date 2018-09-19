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

// Copyright 2014 Ernest Micklei. All rights reserved.
// Use of this source code is governed by a license
// that can be found in the LICENSE file.
import (
	"github.com/emicklei/go-restful/log"
)

var trace bool = false
var traceLogger log.StdLogger

func init() {
	traceLogger = log.Logger // use the package logger by default
}

// TraceLogger enables detailed logging of Http request matching and filter invocation. Default no logger is set.
// You may call EnableTracing() directly to enable trace logging to the package-wide logger.
func TraceLogger(logger log.StdLogger) {
	traceLogger = logger
	EnableTracing(logger != nil)
}

// expose the setter for the global logger on the top-level package
func SetLogger(customLogger log.StdLogger) {
	log.SetLogger(customLogger)
}

// EnableTracing can be used to Trace logging on and off.
func EnableTracing(enabled bool) {
	trace = enabled
}
