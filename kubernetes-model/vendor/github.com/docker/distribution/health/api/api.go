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
package api

import (
	"errors"
	"net/http"

	"github.com/docker/distribution/health"
)

var (
	updater = health.NewStatusUpdater()
)

// DownHandler registers a manual_http_status that always returns an Error
func DownHandler(w http.ResponseWriter, r *http.Request) {
	if r.Method == "POST" {
		updater.Update(errors.New("Manual Check"))
	} else {
		w.WriteHeader(http.StatusNotFound)
	}
}

// UpHandler registers a manual_http_status that always returns nil
func UpHandler(w http.ResponseWriter, r *http.Request) {
	if r.Method == "POST" {
		updater.Update(nil)
	} else {
		w.WriteHeader(http.StatusNotFound)
	}
}

// init sets up the two endpoints to bring the service up and down
func init() {
	health.Register("manual_http_status", updater)
	http.HandleFunc("/debug/health/down", DownHandler)
	http.HandleFunc("/debug/health/up", UpHandler)
}
