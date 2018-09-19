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
package main

import (
	"net/http"

	"github.com/docker/distribution/registry/api/errcode"
)

var (
	errGroup = "tokenserver"

	// ErrorBadTokenOption is returned when a token parameter is invalid
	ErrorBadTokenOption = errcode.Register(errGroup, errcode.ErrorDescriptor{
		Value:   "BAD_TOKEN_OPTION",
		Message: "bad token option",
		Description: `This error may be returned when a request for a
		token contains an option which is not valid`,
		HTTPStatusCode: http.StatusBadRequest,
	})

	// ErrorMissingRequiredField is returned when a required form field is missing
	ErrorMissingRequiredField = errcode.Register(errGroup, errcode.ErrorDescriptor{
		Value:   "MISSING_REQUIRED_FIELD",
		Message: "missing required field",
		Description: `This error may be returned when a request for a
		token does not contain a required form field`,
		HTTPStatusCode: http.StatusBadRequest,
	})

	// ErrorUnsupportedValue is returned when a form field has an unsupported value
	ErrorUnsupportedValue = errcode.Register(errGroup, errcode.ErrorDescriptor{
		Value:   "UNSUPPORTED_VALUE",
		Message: "unsupported value",
		Description: `This error may be returned when a request for a
		token contains a form field with an unsupported value`,
		HTTPStatusCode: http.StatusBadRequest,
	})
)
