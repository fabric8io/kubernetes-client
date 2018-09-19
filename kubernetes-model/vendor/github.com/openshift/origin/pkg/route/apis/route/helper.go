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
package route

import (
	"strings"

	kapi "k8s.io/kubernetes/pkg/apis/core"
)

// IngressConditionStatus returns the first status and condition matching the provided ingress condition type. Conditions
// prefer the first matching entry and clients are allowed to ignore later conditions of the same type.
func IngressConditionStatus(ingress *RouteIngress, t RouteIngressConditionType) (kapi.ConditionStatus, RouteIngressCondition) {
	for _, condition := range ingress.Conditions {
		if t != condition.Type {
			continue
		}
		return condition.Status, condition
	}
	return kapi.ConditionUnknown, RouteIngressCondition{}
}

func RouteLessThan(route1, route2 *Route) bool {
	if route1.CreationTimestamp.Before(&route2.CreationTimestamp) {
		return true
	}

	if route2.CreationTimestamp.Before(&route1.CreationTimestamp) {
		return false
	}

	return route1.UID < route2.UID
}

// GetDomainForHost returns the domain for the specified host.
// Note for top level domains, this will return an empty string.
func GetDomainForHost(host string) string {
	if idx := strings.IndexRune(host, '.'); idx > -1 {
		return host[idx+1:]
	}

	return ""
}
