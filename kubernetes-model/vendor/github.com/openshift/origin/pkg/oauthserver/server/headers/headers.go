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
package headers

import (
	"net/http"
)

func SetStandardHeaders(w http.ResponseWriter) {
	// We cannot set HSTS by default, it has too many drawbacks in environments
	// that use self-signed certs
	standardHeaders := map[string]string{
		// Turn off caching, it never makes sense for authorization pages
		"Cache-Control": "no-cache, no-store",
		"Pragma":        "no-cache",
		"Expires":       "0",
		// Use a reasonably strict Referer policy by default
		"Referrer-Policy": "strict-origin-when-cross-origin",
		// Do not allow embedding as that can lead to clickjacking attacks
		"X-Frame-Options": "DENY",
		// Add other basic scurity hygiene headers
		"X-Content-Type-Options": "nosniff",
		"X-DNS-Prefetch-Control": "off",
		"X-XSS-Protection":       "1; mode=block",
	}

	for key, val := range standardHeaders {
		w.Header().Set(key, val)
	}
}
