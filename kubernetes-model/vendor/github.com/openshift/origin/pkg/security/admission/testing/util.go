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
package testing

import (
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	kapi "k8s.io/kubernetes/pkg/apis/core"

	allocator "github.com/openshift/origin/pkg/security"
	securityapi "github.com/openshift/origin/pkg/security/apis/security"
)

// CreateSAForTest Build and Initializes a ServiceAccount for tests
func CreateSAForTest() *kapi.ServiceAccount {
	return &kapi.ServiceAccount{
		ObjectMeta: metav1.ObjectMeta{
			Name:      "default",
			Namespace: "default",
		},
	}
}

// CreateNamespaceForTest builds and initializes a Namespaces for tests
func CreateNamespaceForTest() *kapi.Namespace {
	return &kapi.Namespace{
		ObjectMeta: metav1.ObjectMeta{
			Name: "default",
			Annotations: map[string]string{
				allocator.UIDRangeAnnotation:           "1/3",
				allocator.MCSAnnotation:                "s0:c1,c0",
				allocator.SupplementalGroupsAnnotation: "2/3",
			},
		},
	}
}

// UserScc creates a SCC for a given user name
func UserScc(user string) *securityapi.SecurityContextConstraints {
	var uid int64 = 9999
	fsGroup := int64(1)
	return &securityapi.SecurityContextConstraints{
		ObjectMeta: metav1.ObjectMeta{
			SelfLink: "/api/version/securitycontextconstraints/" + user,
			Name:     user,
		},
		Users: []string{user},
		SELinuxContext: securityapi.SELinuxContextStrategyOptions{
			Type: securityapi.SELinuxStrategyRunAsAny,
		},
		RunAsUser: securityapi.RunAsUserStrategyOptions{
			Type: securityapi.RunAsUserStrategyMustRunAs,
			UID:  &uid,
		},
		FSGroup: securityapi.FSGroupStrategyOptions{
			Type: securityapi.FSGroupStrategyMustRunAs,
			Ranges: []securityapi.IDRange{
				{Min: fsGroup, Max: fsGroup},
			},
		},
		SupplementalGroups: securityapi.SupplementalGroupsStrategyOptions{
			Type: securityapi.SupplementalGroupsStrategyRunAsAny,
		},
	}
}
