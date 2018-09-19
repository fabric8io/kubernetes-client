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
package metrics

import (
	"bufio"
	"fmt"
	"io"
	"io/ioutil"
	"net"
	"net/http"
	"net/url"
	"time"

	"github.com/golang/glog"

	"k8s.io/apiserver/pkg/server/healthz"
	"k8s.io/kubernetes/pkg/probe"
	probehttp "k8s.io/kubernetes/pkg/probe/http"
)

var errBackend = fmt.Errorf("backend reported failure")

// HTTPBackendAvailable returns a healthz check that verifies a backend responds to a GET to
// the provided URL with 2xx or 3xx response.
func HTTPBackendAvailable(u *url.URL) healthz.HealthzChecker {
	p := probehttp.New()
	return healthz.NamedCheck("backend-http", func(r *http.Request) error {
		result, _, err := p.Probe(u, nil, 2*time.Second)
		if err != nil {
			return err
		}
		if result != probe.Success {
			return errBackend
		}
		return nil
	})
}

// ProxyProtocolHTTPBackendAvailable returns a healthz check that verifies a backend supporting
// the HAProxy PROXY protocol responds to a GET to the provided URL with 2xx or 3xx response.
func ProxyProtocolHTTPBackendAvailable(u *url.URL) healthz.HealthzChecker {
	dialer := &net.Dialer{
		Timeout:   2 * time.Second,
		DualStack: true,
	}
	return healthz.NamedCheck("backend-proxy-http", func(r *http.Request) error {
		conn, err := dialer.Dial("tcp", u.Host)
		if err != nil {
			return err
		}
		conn.SetDeadline(time.Now().Add(2 * time.Second))
		br := bufio.NewReader(conn)
		if _, err := conn.Write([]byte("PROXY UNKNOWN\r\n")); err != nil {
			return err
		}
		req := &http.Request{Method: "GET", URL: u, Proto: "HTTP/1.1", ProtoMajor: 1, ProtoMinor: 1}
		if err := req.Write(conn); err != nil {
			return err
		}
		res, err := http.ReadResponse(br, req)
		if err != nil {
			return err
		}

		// read full body
		defer res.Body.Close()
		if _, err := io.Copy(ioutil.Discard, res.Body); err != nil {
			glog.V(4).Infof("Error discarding probe body contents: %v", err)
		}

		if res.StatusCode < http.StatusOK && res.StatusCode >= http.StatusBadRequest {
			glog.V(4).Infof("Probe failed for %s, Response: %v", u.String(), res)
			return errBackend
		}
		glog.V(4).Infof("Probe succeeded for %s, Response: %v", u.String(), res)
		return nil
	})
}
