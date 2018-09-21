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
package egress_http_proxy_test

import (
	"fmt"
	"os/exec"
	"strings"
	"testing"
)

func TestGenerateSquidConf(t *testing.T) {
	tests := []struct {
		in  string
		out string
	}{
		{
			in: "*",
			out: `
http_access allow all
`,
		},
		{
			in: "example.com",
			out: `
acl dest1 dstdomain example.com
http_access allow dest1

http_access deny all
`,
		},
		{
			in: "!example.com",
			out: `
acl dest1 dstdomain example.com
http_access deny dest1

http_access deny all
`,
		},
		{
			in: "*.example.com",
			out: `
acl dest1 dstdomain .example.com
http_access allow dest1

http_access deny all
`,
		},
		{
			in: "192.168.1.1",
			out: `
acl dest1 dst 192.168.1.1
http_access allow dest1

http_access deny all
`,
		},
		{
			in: "192.168.1.0/24",
			out: `
acl dest1 dst 192.168.1.0/24
http_access allow dest1

http_access deny all
`,
		},
		{
			in: `
!*.example.net
*
`,
			out: `
acl dest1 dstdomain .example.net
http_access deny dest1

http_access allow all
`,
		},
		{
			in: `
# HTTP proxy config

!*.bad.example.com
*.example.com

192.168.0.0/16
fe80::/10

# end
`,
			out: `
acl dest1 dstdomain .bad.example.com
http_access deny dest1

acl dest2 dstdomain .example.com
http_access allow dest2

acl dest3 dst 192.168.0.0/16
http_access allow dest3

acl dest4 dst fe80::/10
http_access allow dest4

http_access deny all
`,
		},
	}

	for n, test := range tests {
		cmd := exec.Command("./egress-http-proxy.sh")
		cmd.Env = []string{
			fmt.Sprintf("EGRESS_HTTP_PROXY_MODE=unit-test"),
			fmt.Sprintf("EGRESS_HTTP_PROXY_DESTINATION=%s", test.in),
		}
		out, err := cmd.CombinedOutput()
		if err != nil {
			t.Fatalf("test %d expected output %q but got error %v / %q", n+1, test.out, err, string(out))
		}
		if string(out) != test.out {
			t.Fatalf("test %d expected output %q but got %q", n+1, test.out, string(out))
		}
	}
}

func TestGenerateSquidConfBad(t *testing.T) {
	tests := []struct {
		in  string
		err string
	}{
		{
			in:  "",
			err: "No EGRESS_HTTP_PROXY_DESTINATION specified",
		},
		{
			in:  "*\nexample.com",
			err: "Wildcard must be last rule, if present",
		},
		{
			in:  "foo bar",
			err: "Bad destination 'foo bar'",
		},
	}

	for n, test := range tests {
		cmd := exec.Command("./egress-http-proxy.sh")
		cmd.Env = []string{
			fmt.Sprintf("EGRESS_HTTP_PROXY_MODE=unit-test"),
			fmt.Sprintf("EGRESS_HTTP_PROXY_DESTINATION=%s", test.in),
		}
		out, err := cmd.CombinedOutput()
		out_lines := strings.Split(string(out), "\n")
		got := out_lines[len(out_lines)-2]
		if err == nil {
			t.Fatalf("test %d expected error %q but got output %q", n+1, test.err, got)
		}
		if got != test.err {
			t.Fatalf("test %d expected output %q but got %q", n+1, test.err, got)
		}
	}
}
