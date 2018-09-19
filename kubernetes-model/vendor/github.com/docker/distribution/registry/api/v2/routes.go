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
package v2

import "github.com/gorilla/mux"

// The following are definitions of the name under which all V2 routes are
// registered. These symbols can be used to look up a route based on the name.
const (
	RouteNameBase            = "base"
	RouteNameManifest        = "manifest"
	RouteNameTags            = "tags"
	RouteNameBlob            = "blob"
	RouteNameBlobUpload      = "blob-upload"
	RouteNameBlobUploadChunk = "blob-upload-chunk"
	RouteNameCatalog         = "catalog"
)

var allEndpoints = []string{
	RouteNameManifest,
	RouteNameCatalog,
	RouteNameTags,
	RouteNameBlob,
	RouteNameBlobUpload,
	RouteNameBlobUploadChunk,
}

// Router builds a gorilla router with named routes for the various API
// methods. This can be used directly by both server implementations and
// clients.
func Router() *mux.Router {
	return RouterWithPrefix("")
}

// RouterWithPrefix builds a gorilla router with a configured prefix
// on all routes.
func RouterWithPrefix(prefix string) *mux.Router {
	rootRouter := mux.NewRouter()
	router := rootRouter
	if prefix != "" {
		router = router.PathPrefix(prefix).Subrouter()
	}

	router.StrictSlash(true)

	for _, descriptor := range routeDescriptors {
		router.Path(descriptor.Path).Name(descriptor.Name)
	}

	return rootRouter
}
