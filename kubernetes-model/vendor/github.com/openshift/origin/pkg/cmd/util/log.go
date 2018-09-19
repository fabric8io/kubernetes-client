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
package util

import (
	"io"

	"github.com/golang/glog"
)

// NewGLogWriterV returns a new Writer that delegates to `glog.Info` at the
// desired level of verbosity
func NewGLogWriterV(level int) io.Writer {
	return &gLogWriter{
		level: glog.Level(level),
	}
}

// gLogWriter is a Writer that writes by delegating to `glog.Info`
type gLogWriter struct {
	// level is the default level to log at
	level glog.Level
}

func (w *gLogWriter) Write(p []byte) (n int, err error) {
	if glog.V(w.level) {
		glog.InfoDepth(2, string(p))
	}

	return len(p), nil
}
