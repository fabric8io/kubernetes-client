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
package in_pod

import (
	"fmt"
	"time"

	"github.com/miekg/dns"
	"github.com/openshift/origin/pkg/oc/admin/diagnostics/diagnostics/types"
)

// dnsResponse is used as a channel payload
type dnsResponse struct {
	in  *dns.Msg
	err error
}

// dnsQueryWithTimeout makes a DNS query that times out quickly.
// The timeout is in seconds.
// The boolean response indicates whether the request completed before the timeout.
func dnsQueryWithTimeout(msg *dns.Msg, server string, timeout int) (dnsResponse, bool) {
	rchan := make(chan dnsResponse, 1)
	go func() {
		in, err := dns.Exchange(msg, server+":53")
		rchan <- dnsResponse{in, err}
	}()
	select {
	case <-time.After(time.Second * time.Duration(timeout)):
		return dnsResponse{}, false
	case result := <-rchan:
		return result, true
	}
}

// getResolvConf reads a clientConfig from resolv.conf and complains about any errors
func getResolvConf(r types.DiagnosticResult) (*dns.ClientConfig, error) {
	resolvConf, err := dns.ClientConfigFromFile("/etc/resolv.conf")
	if err != nil {
		r.Error("DP3001", err, fmt.Sprintf("could not load/parse resolver file /etc/resolv.conf: %v", err))
		return nil, err
	}
	if len(resolvConf.Servers) == 0 {
		r.Error("DP3002", nil, "could not find any nameservers defined in /etc/resolv.conf")
		return nil, err
	}
	if len(resolvConf.Search) == 0 {
		r.Warn("DP3011", nil, "could not find any search domains defined in /etc/resolv.conf")
		resolvConf.Search = nil
	}
	r.Debug("DP3012", fmt.Sprintf("Pod /etc/resolv.conf contains:\nnameservers: %v\nsearch domains: %v", resolvConf.Servers, resolvConf.Search))
	return resolvConf, nil
}
