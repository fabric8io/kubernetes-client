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

import "github.com/openshift/api/route/v1"

// If adding or changing route defaults, updates may be required to
// pkg/router/controller/controller.go to ensure the routes generated from
// ingress resources will match routes created via the api.

func SetDefaults_RouteSpec(obj *v1.RouteSpec) {
	if len(obj.WildcardPolicy) == 0 {
		obj.WildcardPolicy = v1.WildcardPolicyNone
	}
}

func SetDefaults_RouteTargetReference(obj *v1.RouteTargetReference) {
	if len(obj.Kind) == 0 {
		obj.Kind = "Service"
	}
	if obj.Weight == nil {
		obj.Weight = new(int32)
		*obj.Weight = 100
	}
}

func SetDefaults_TLSConfig(obj *v1.TLSConfig) {
	if len(obj.Termination) == 0 && len(obj.DestinationCACertificate) == 0 {
		obj.Termination = v1.TLSTerminationEdge
	}
	switch obj.Termination {
	case v1.TLSTerminationType("Reencrypt"):
		obj.Termination = v1.TLSTerminationReencrypt
	case v1.TLSTerminationType("Edge"):
		obj.Termination = v1.TLSTerminationEdge
	case v1.TLSTerminationType("Passthrough"):
		obj.Termination = v1.TLSTerminationPassthrough
	}
}

func SetDefaults_RouteIngress(obj *v1.RouteIngress) {
	if len(obj.WildcardPolicy) == 0 {
		obj.WildcardPolicy = v1.WildcardPolicyNone
	}
}
