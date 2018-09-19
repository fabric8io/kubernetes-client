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
package scale

import (
	"k8s.io/apimachinery/pkg/runtime/schema"

	oappsv1 "github.com/openshift/api/apps/v1"
)

var dcGVR = schema.GroupVersionResource{
	Group:    "",
	Version:  "v1",
	Resource: "deploymentconfigs",
}

func correctOapiDeploymentConfig(gvr schema.GroupVersionResource) schema.GroupVersionResource {
	// TODO(directxman12): this is a dirty, dirty hack because oapi just appears in discovery as "/v1", like
	// the kube core API.  We can remove it if/when we get rid of the legacy oapi group entirely.  It makes me
	// cry a bit inside, but such is life.
	if gvr == dcGVR {
		return oappsv1.SchemeGroupVersion.WithResource(gvr.Resource)
	}

	return gvr
}
