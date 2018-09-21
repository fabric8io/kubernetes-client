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
	"path"
	"strings"

	"github.com/openshift/origin/pkg/oauthserver/osinserver"
	"github.com/openshift/origin/pkg/oauthserver/server/tokenrequest"
)

const OpenShiftOAuthAPIPrefix = "/oauth"

func OpenShiftOAuthAuthorizeURL(masterAddr string) string {
	return openShiftOAuthURL(masterAddr, osinserver.AuthorizePath)
}
func OpenShiftOAuthTokenURL(masterAddr string) string {
	return openShiftOAuthURL(masterAddr, osinserver.TokenPath)
}
func OpenShiftOAuthTokenRequestURL(masterAddr string) string {
	return openShiftOAuthURL(masterAddr, tokenrequest.RequestTokenEndpoint)
}
func OpenShiftOAuthTokenDisplayURL(masterAddr string) string {
	return openShiftOAuthURL(masterAddr, tokenrequest.DisplayTokenEndpoint)
}
func OpenShiftOAuthTokenImplicitURL(masterAddr string) string {
	return openShiftOAuthURL(masterAddr, tokenrequest.ImplicitTokenEndpoint)
}
func openShiftOAuthURL(masterAddr, oauthEndpoint string) string {
	return strings.TrimRight(masterAddr, "/") + path.Join(OpenShiftOAuthAPIPrefix, oauthEndpoint)
}
