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
package v1

import (
	_ "github.com/openshift/api/apps/v1"
	_ "github.com/openshift/api/authorization/v1"
	_ "github.com/openshift/api/build/v1"
	_ "github.com/openshift/api/image/v1"
	_ "github.com/openshift/api/network/v1"
	_ "github.com/openshift/api/oauth/v1"
	_ "github.com/openshift/api/project/v1"
	_ "github.com/openshift/api/route/v1"
	_ "github.com/openshift/api/security/v1"
	_ "github.com/openshift/api/template/v1"
	_ "github.com/openshift/api/user/v1"
	"k8s.io/apimachinery/pkg/runtime/schema"
)

// SchemeGroupVersion is group version used to register these objects
var SchemeGroupVersion = schema.GroupVersion{Group: "", Version: "v1"}
