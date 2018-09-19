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
package restful

// Copyright 2013 Ernest Micklei. All rights reserved.
// Use of this source code is governed by a license
// that can be found in the LICENSE file.

import "fmt"

// ServiceError is a transport object to pass information about a non-Http error occurred in a WebService while processing a request.
type ServiceError struct {
	Code    int
	Message string
}

// NewError returns a ServiceError using the code and reason
func NewError(code int, message string) ServiceError {
	return ServiceError{Code: code, Message: message}
}

// Error returns a text representation of the service error
func (s ServiceError) Error() string {
	return fmt.Sprintf("[ServiceError:%v] %v", s.Code, s.Message)
}
