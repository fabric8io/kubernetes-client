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
package meta

import (
	"strings"

	"k8s.io/apimachinery/pkg/runtime/schema"
)

var oapiResources = map[schema.GroupVersionResource]bool{
	{Resource: "appliedclusterresourcequotas"}: true,
	{Resource: "appliedclusterresourcequota"}:  true,
	{Resource: "buildconfigs"}:                 true,
	{Resource: "buildconfig"}:                  true,
	{Resource: "bc"}:                           true,
	{Resource: "builds"}:                       true,
	{Resource: "build"}:                        true,
	{Resource: "clusternetworks"}:              true,
	{Resource: "clusternetwork"}:               true,
	{Resource: "clusterresourcequotas"}:        true,
	{Resource: "clusterresourcequota"}:         true,
	{Resource: "clusterquota"}:                 true,
	{Resource: "clusterrolebindings"}:          true,
	{Resource: "clusterrolebinding"}:           true,
	{Resource: "clusterroles"}:                 true,
	{Resource: "clusterrole"}:                  true,
	{Resource: "deploymentconfigrollbacks"}:    true,
	{Resource: "deploymentconfigrollback"}:     true,
	{Resource: "deploymentconfigs"}:            true,
	{Resource: "deploymentconfig"}:             true,
	{Resource: "dc"}:                           true,
	{Resource: "egressnetworkpolicies"}:        true,
	{Resource: "egressnetworkpolicy"}:          true,
	{Resource: "groups"}:                       true,
	{Resource: "group"}:                        true,
	{Resource: "hostsubnets"}:                  true,
	{Resource: "hostsubnet"}:                   true,
	{Resource: "identities"}:                   true,
	{Resource: "identity"}:                     true,
	{Resource: "images"}:                       true,
	{Resource: "image"}:                        true,
	{Resource: "imagesignatures"}:              true,
	{Resource: "imagesignature"}:               true,
	{Resource: "imagestreamimages"}:            true,
	{Resource: "imagestreamimage"}:             true,
	{Resource: "isimage"}:                      true,
	{Resource: "imagestreamimports"}:           true,
	{Resource: "imagestreamimport"}:            true,
	{Resource: "imagestreammappings"}:          true,
	{Resource: "imagestreammapping"}:           true,
	{Resource: "imagestreams"}:                 true,
	{Resource: "imagestream"}:                  true,
	{Resource: "is"}:                           true,
	{Resource: "imagestreamtags"}:              true,
	{Resource: "imagestreamtag"}:               true,
	{Resource: "istag"}:                        true,
	{Resource: "netnamespaces"}:                true,
	{Resource: "netnamespace"}:                 true,
	{Resource: "oauthaccesstokens"}:            true,
	{Resource: "oauthaccesstoken"}:             true,
	{Resource: "oauthauthorizetokens"}:         true,
	{Resource: "oauthauthorizetoken"}:          true,
	{Resource: "oauthclientauthorizations"}:    true,
	{Resource: "oauthclientauthorization"}:     true,
	{Resource: "oauthclients"}:                 true,
	{Resource: "oauthclient"}:                  true,
	{Resource: "processedtemplates"}:           true,
	{Resource: "processedtemplate"}:            true,
	{Resource: "projects"}:                     true,
	{Resource: "project"}:                      true,
	{Resource: "rolebindingrestrictions"}:      true,
	{Resource: "rolebindingrestriction"}:       true,
	{Resource: "rolebindings"}:                 true,
	{Resource: "rolebinding"}:                  true,
	{Resource: "roles"}:                        true,
	{Resource: "role"}:                         true,
	{Resource: "routes"}:                       true,
	{Resource: "route"}:                        true,
	{Resource: "securitycontextconstraints"}:   true,
	{Resource: "securitycontextconstraint"}:    true,
	{Resource: "scc"}:                          true,
	{Resource: "templates"}:                    true,
	{Resource: "template"}:                     true,
	{Resource: "useridentitymappings"}:         true,
	{Resource: "useridentitymapping"}:          true,
	{Resource: "users"}:                        true,
	{Resource: "user"}:                         true,
}

func isOAPIResource(resource schema.GroupVersionResource) bool {
	// modify our copy to be sure we match our map
	resource.Resource = strings.ToLower(resource.Resource)
	return oapiResources[resource]
}
