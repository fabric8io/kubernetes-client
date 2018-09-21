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
package middleware

import (
	"fmt"
	"net/url"

	"github.com/docker/distribution/context"
	storagedriver "github.com/docker/distribution/registry/storage/driver"
	storagemiddleware "github.com/docker/distribution/registry/storage/driver/middleware"
)

type redirectStorageMiddleware struct {
	storagedriver.StorageDriver
	scheme string
	host   string
}

var _ storagedriver.StorageDriver = &redirectStorageMiddleware{}

func newRedirectStorageMiddleware(sd storagedriver.StorageDriver, options map[string]interface{}) (storagedriver.StorageDriver, error) {
	o, ok := options["baseurl"]
	if !ok {
		return nil, fmt.Errorf("no baseurl provided")
	}
	b, ok := o.(string)
	if !ok {
		return nil, fmt.Errorf("baseurl must be a string")
	}
	u, err := url.Parse(b)
	if err != nil {
		return nil, fmt.Errorf("unable to parse redirect baseurl: %s", b)
	}
	if u.Scheme == "" {
		return nil, fmt.Errorf("no scheme specified for redirect baseurl")
	}
	if u.Host == "" {
		return nil, fmt.Errorf("no host specified for redirect baseurl")
	}

	return &redirectStorageMiddleware{StorageDriver: sd, scheme: u.Scheme, host: u.Host}, nil
}

func (r *redirectStorageMiddleware) URLFor(ctx context.Context, path string, options map[string]interface{}) (string, error) {
	u := &url.URL{Scheme: r.scheme, Host: r.host, Path: path}
	return u.String(), nil
}

func init() {
	storagemiddleware.Register("redirect", storagemiddleware.InitFunc(newRedirectStorageMiddleware))
}
