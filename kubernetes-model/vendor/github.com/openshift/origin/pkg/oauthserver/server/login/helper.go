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
package login

import (
	"net/http"
	"net/url"
	"strings"
)

func failed(reason string, w http.ResponseWriter, req *http.Request) {
	uri, err := getBaseURL(req)
	if err != nil {
		http.Redirect(w, req, req.URL.Path, http.StatusFound)
		return
	}
	query := url.Values{}
	query.Set("reason", reason)
	if then := req.FormValue("then"); then != "" {
		query.Set("then", then)
	}
	uri.RawQuery = query.Encode()
	http.Redirect(w, req, uri.String(), http.StatusFound)
}

func getBaseURL(req *http.Request) (*url.URL, error) {
	uri, err := url.Parse(req.RequestURI)
	if err != nil {
		return nil, err
	}
	uri.Scheme, uri.Host, uri.RawQuery, uri.Fragment = req.URL.Scheme, req.URL.Host, "", ""
	return uri, nil
}

func postForm(url string, body url.Values) (resp *http.Response, err error) {
	req, err := http.NewRequest("POST", url, strings.NewReader(body.Encode()))
	if err != nil {
		return nil, err
	}
	req.Header.Set("Content-Type", "application/x-www-form-urlencoded")
	return http.DefaultTransport.RoundTrip(req)
}

func getURL(url string) (resp *http.Response, err error) {
	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		return nil, err
	}
	return http.DefaultTransport.RoundTrip(req)
}
