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
package placeholderchallenger

import (
	"fmt"
	"net/http"

	oauthhandlers "github.com/openshift/origin/pkg/oauthserver/oauth/handlers"
)

type placeholderChallenger struct {
	tokenRequestURL string
}

// New returns an AuthenticationChallenger that responds with a warning and link to the web UI for requesting a token
func New(url string) oauthhandlers.AuthenticationChallenger {
	return placeholderChallenger{url}
}

// AuthenticationChallenge returns a header that indicates a basic auth challenge for the supplied realm
func (c placeholderChallenger) AuthenticationChallenge(req *http.Request) (http.Header, error) {
	headers := http.Header{}
	headers.Add("Warning",
		fmt.Sprintf(
			`%s %s "You must obtain an API token by visiting %s"`,
			oauthhandlers.WarningHeaderMiscCode,
			oauthhandlers.WarningHeaderOpenShiftSource,
			c.tokenRequestURL,
		),
	)
	headers.Add("Link", fmt.Sprintf(`<%s>; rel="related"`, c.tokenRequestURL))

	return headers, nil
}
