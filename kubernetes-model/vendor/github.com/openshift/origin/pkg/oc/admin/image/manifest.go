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
package image

import (
	"context"
	"net/http"
	"net/url"

	godigest "github.com/opencontainers/go-digest"

	"k8s.io/client-go/rest"

	"github.com/openshift/origin/pkg/image/registryclient"
)

// getImageManifestByIDFromRegistry retrieves the image manifest from the registry using the basic
// authentication using the image ID.
func getImageManifestByIDFromRegistry(registry *url.URL, repositoryName, imageID, username, password string, insecure bool) ([]byte, error) {
	ctx := context.Background()

	credentials := registryclient.NewBasicCredentials()
	credentials.Add(registry, username, password)

	insecureRT, err := rest.TransportFor(&rest.Config{TLSClientConfig: rest.TLSClientConfig{Insecure: true}})
	if err != nil {
		return nil, err
	}

	repo, err := registryclient.NewContext(http.DefaultTransport, insecureRT).
		WithCredentials(credentials).
		Repository(ctx, registry, repositoryName, insecure)
	if err != nil {
		return nil, err
	}

	manifests, err := repo.Manifests(ctx, nil)
	if err != nil {
		return nil, err
	}

	manifest, err := manifests.Get(ctx, godigest.Digest(imageID))
	if err != nil {
		return nil, err
	}
	_, manifestPayload, err := manifest.Payload()
	if err != nil {
		return nil, err
	}

	return manifestPayload, nil
}
