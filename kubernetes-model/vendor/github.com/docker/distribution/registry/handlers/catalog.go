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
package handlers

import (
	"encoding/json"
	"fmt"
	"io"
	"net/http"
	"net/url"
	"strconv"

	"github.com/docker/distribution/registry/api/errcode"
	"github.com/docker/distribution/registry/storage/driver"
	"github.com/gorilla/handlers"
)

const maximumReturnedEntries = 100

func catalogDispatcher(ctx *Context, r *http.Request) http.Handler {
	catalogHandler := &catalogHandler{
		Context: ctx,
	}

	return handlers.MethodHandler{
		"GET": http.HandlerFunc(catalogHandler.GetCatalog),
	}
}

type catalogHandler struct {
	*Context
}

type catalogAPIResponse struct {
	Repositories []string `json:"repositories"`
}

func (ch *catalogHandler) GetCatalog(w http.ResponseWriter, r *http.Request) {
	var moreEntries = true

	q := r.URL.Query()
	lastEntry := q.Get("last")
	maxEntries, err := strconv.Atoi(q.Get("n"))
	if err != nil || maxEntries < 0 {
		maxEntries = maximumReturnedEntries
	}

	repos := make([]string, maxEntries)

	filled, err := ch.App.registry.Repositories(ch.Context, repos, lastEntry)
	_, pathNotFound := err.(driver.PathNotFoundError)

	if err == io.EOF || pathNotFound {
		moreEntries = false
	} else if err != nil {
		ch.Errors = append(ch.Errors, errcode.ErrorCodeUnknown.WithDetail(err))
		return
	}

	w.Header().Set("Content-Type", "application/json; charset=utf-8")

	// Add a link header if there are more entries to retrieve
	if moreEntries {
		lastEntry = repos[len(repos)-1]
		urlStr, err := createLinkEntry(r.URL.String(), maxEntries, lastEntry)
		if err != nil {
			ch.Errors = append(ch.Errors, errcode.ErrorCodeUnknown.WithDetail(err))
			return
		}
		w.Header().Set("Link", urlStr)
	}

	enc := json.NewEncoder(w)
	if err := enc.Encode(catalogAPIResponse{
		Repositories: repos[0:filled],
	}); err != nil {
		ch.Errors = append(ch.Errors, errcode.ErrorCodeUnknown.WithDetail(err))
		return
	}
}

// Use the original URL from the request to create a new URL for
// the link header
func createLinkEntry(origURL string, maxEntries int, lastEntry string) (string, error) {
	calledURL, err := url.Parse(origURL)
	if err != nil {
		return "", err
	}

	v := url.Values{}
	v.Add("n", strconv.Itoa(maxEntries))
	v.Add("last", lastEntry)

	calledURL.RawQuery = v.Encode()

	calledURL.Fragment = ""
	urlStr := fmt.Sprintf("<%s>; rel=\"next\"", calledURL.String())

	return urlStr, nil
}
