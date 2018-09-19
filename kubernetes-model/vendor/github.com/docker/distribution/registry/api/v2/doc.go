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
// Package v2 describes routes, urls and the error codes used in the Docker
// Registry JSON HTTP API V2. In addition to declarations, descriptors are
// provided for routes and error codes that can be used for implementation and
// automatically generating documentation.
//
// Definitions here are considered to be locked down for the V2 registry api.
// Any changes must be considered carefully and should not proceed without a
// change proposal in docker core.
package v2
