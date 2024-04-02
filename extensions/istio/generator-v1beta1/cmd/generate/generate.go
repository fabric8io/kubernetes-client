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
package main

import (
	"fmt"
	"strings"

	"github.com/fabric8io/kubernetes-client/generator/pkg/schemagen"
	"github.com/gogo/protobuf/types"
	duration "github.com/golang/protobuf/ptypes/duration"
	timestamp "github.com/golang/protobuf/ptypes/timestamp"
	wrappers "github.com/golang/protobuf/ptypes/wrappers"

	// Internal APIs:
	api_networking_v1beta1 "istio.io/api/networking/v1beta1"
	api_security_v1beta1 "istio.io/api/security/v1beta1"

	// External APIs:
	client_networking_v1beta1 "istio.io/client-go/pkg/apis/networking/v1beta1"
	client_security_v1beta1 "istio.io/client-go/pkg/apis/security/v1beta1"

	"reflect"
)

func main() {

	// the CRD List types for which the model should be generated
	// no other types need to be defined as they are auto discovered
	crdLists := map[reflect.Type]schemagen.CrdScope{
		// networking
		reflect.TypeOf(client_networking_v1beta1.DestinationRuleList{}): schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1beta1.GatewayList{}):         schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1beta1.ServiceEntryList{}):    schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1beta1.SidecarList{}):         schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1beta1.VirtualServiceList{}):  schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1beta1.WorkloadEntryList{}):   schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1beta1.WorkloadGroupList{}):   schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1beta1.ProxyConfigList{}):     schemagen.Namespaced,

		// security
		reflect.TypeOf(client_security_v1beta1.PeerAuthenticationList{}):    schemagen.Namespaced,
		reflect.TypeOf(client_security_v1beta1.RequestAuthenticationList{}): schemagen.Namespaced,
		reflect.TypeOf(client_security_v1beta1.AuthorizationPolicyList{}):   schemagen.Namespaced,
	}

	// custom types descriptors
	typesDescriptors := map[reflect.Type]*schemagen.JSONObjectDescriptor{}

	// constraints and patterns for fields
	constraints := map[reflect.Type]map[string]*schemagen.Constraint{}

	// types that are manually defined in the model
	providedTypes := []schemagen.ProvidedType{
		// Due to issue in sundrio (https://github.com/sundrio/sundrio/issues/170). A duplicated methods is generated, both named `hasMatchingAllowOrigin`
		{GoType: reflect.TypeOf(api_networking_v1beta1.CorsPolicy{}), JavaClass: "io.fabric8.istio.api.networking.v1beta1.CorsPolicy"},
	}

	// go packages that are provided and where no generation is required and their corresponding java package
	providedPackages := map[string]string{
		"k8s.io/apimachinery/pkg/apis/meta/v1": "io.fabric8.kubernetes.api.model",
		"k8s.io/api/core/v1":                   "io.fabric8.kubernetes.api.model",
		"istio.io/api/analysis/v1alpha1":       "io.fabric8.istio.api.analysis.v1alpha1",
		"istio.io/api/meta/v1alpha1":           "io.fabric8.istio.api.meta.v1alpha1",
	}

	// mapping of go packages of this module to the resulting java package
	// optional ApiGroup and ApiVersion for the go package (which is added to the generated java class)
	packageMapping := map[string]schemagen.PackageInformation{
		"istio.io/client-go/pkg/apis/networking/v1beta1": {JavaPackage: "io.fabric8.istio.api.networking.v1beta1", ApiGroup: "networking.istio.io", ApiVersion: "v1beta1"},
		"istio.io/client-go/pkg/apis/security/v1beta1":   {JavaPackage: "io.fabric8.istio.api.security.v1beta1", ApiGroup: "security.istio.io", ApiVersion: "v1beta1"},
		"istio.io/client-go/pkg/apis/telemetry/v1alpha1": {JavaPackage: "io.fabric8.istio.api.telemetry.v1alpha1", ApiGroup: "telemetry.istio.io", ApiVersion: "v1alpha1"},
	}

	// converts all packages starting with <key> to a java package using an automated scheme:
	//  - replace <key> with <value> aka "package prefix"
	//  - replace '/' with '.' for a valid java package name
	mappingSchema := map[string]string{
		"istio.io/api/networking/v1beta1": "io.fabric8.istio.api.networking.v1beta1",
		"istio.io/api/type/v1beta1":       "io.fabric8.istio.api.type.v1beta1",
		"istio.io/api/security/v1beta1":   "io.fabric8.istio.api.security.v1beta1",
	}

	// overwriting some times
	manualTypeMap := map[reflect.Type]string{
		reflect.TypeOf(types.BoolValue{}):      "java.lang.Boolean",
		reflect.TypeOf(wrappers.BoolValue{}):   "java.lang.Boolean",
		reflect.TypeOf(wrappers.UInt32Value{}): "java.lang.Integer",
		reflect.TypeOf(wrappers.Int32Value{}):  "java.lang.Integer",
		reflect.TypeOf(types.DoubleValue{}):    "java.lang.Double",
		reflect.TypeOf(duration.Duration{}):    "java.lang.String",
		reflect.TypeOf(timestamp.Timestamp{}):  "java.lang.String",
		reflect.TypeOf(types.Int32Value{}):     "java.lang.Integer",
		reflect.TypeOf(types.UInt32Value{}):    "java.lang.Integer",
	}

	// types for interfaces
	interfacesMapping := map[string][]reflect.Type{
		// networking
		"istio.io/api/networking/v1beta1/isStringMatch_MatchType":                               {reflect.TypeOf(api_networking_v1beta1.StringMatch_Exact{}), reflect.TypeOf(api_networking_v1beta1.StringMatch_Regex{}), reflect.TypeOf(api_networking_v1beta1.StringMatch_Prefix{})},
		"istio.io/api/networking/v1beta1/isHTTPFaultInjection_Abort_ErrorType":                  {reflect.TypeOf(api_networking_v1beta1.HTTPFaultInjection_Abort_HttpStatus{}), reflect.TypeOf(api_networking_v1beta1.HTTPFaultInjection_Abort_GrpcStatus{}), reflect.TypeOf(api_networking_v1beta1.HTTPFaultInjection_Abort_Http2Error{})},
		"istio.io/api/networking/v1beta1/isHTTPFaultInjection_Delay_HttpDelayType":              {reflect.TypeOf(api_networking_v1beta1.HTTPFaultInjection_Delay_ExponentialDelay{}), reflect.TypeOf(api_networking_v1beta1.HTTPFaultInjection_Delay_FixedDelay{})},
		"istio.io/api/networking/v1beta1/isLoadBalancerSettings_LbPolicy":                       {reflect.TypeOf(api_networking_v1beta1.LoadBalancerSettings_ConsistentHash{}), reflect.TypeOf(api_networking_v1beta1.LoadBalancerSettings_Simple{})},
		"istio.io/api/networking/v1beta1/isLoadBalancerSettings_ConsistentHashLB_HashKey":       {reflect.TypeOf(api_networking_v1beta1.LoadBalancerSettings_ConsistentHashLB_HttpHeaderName{}), reflect.TypeOf(api_networking_v1beta1.LoadBalancerSettings_ConsistentHashLB_HttpCookie{}), reflect.TypeOf(api_networking_v1beta1.LoadBalancerSettings_ConsistentHashLB_UseSourceIp{}), reflect.TypeOf(api_networking_v1beta1.LoadBalancerSettings_ConsistentHashLB_HttpQueryParameterName{})},
		"istio.io/api/networking/v1beta1/isHTTPRedirect_RedirectPort":                           {reflect.TypeOf(api_networking_v1beta1.HTTPRedirect_Port{}), reflect.TypeOf(api_networking_v1beta1.HTTPRedirect_DerivePort{})},
		"istio.io/api/networking/v1beta1/isHTTPBody_Specifier":                                  {reflect.TypeOf(api_networking_v1beta1.HTTPBody_String_{}), reflect.TypeOf(api_networking_v1beta1.HTTPBody_Bytes{})},
		"istio.io/api/networking/v1beta1/isLoadBalancerSettings_ConsistentHashLB_HashAlgorithm": {reflect.TypeOf(api_networking_v1beta1.LoadBalancerSettings_ConsistentHashLB_RingHash_{}), reflect.TypeOf(api_networking_v1beta1.LoadBalancerSettings_ConsistentHashLB_Maglev{})},
		"istio.io/api/networking/v1beta1/isReadinessProbe_HealthCheckMethod":                    {reflect.TypeOf(api_networking_v1beta1.ReadinessProbe_HttpGet{}), reflect.TypeOf(api_networking_v1beta1.ReadinessProbe_TcpSocket{}), reflect.TypeOf(api_networking_v1beta1.ReadinessProbe_Exec{})},

		// security
		"istio.io/api/security/v1beta1/isAuthorizationPolicy_ActionDetail": {reflect.TypeOf(api_security_v1beta1.AuthorizationPolicy_Provider{})},
	}

	// custom name rules
	javaNameStrategyMapping := schemagen.JavaNameStrategyMapping{
		ResolveFieldNameFromProtobufFirst: true,
		SkipFieldWithEmptyTag:             true,
		NameMapping: map[reflect.Type]string{
			reflect.TypeOf(api_networking_v1beta1.DestinationRule{}):     "io.fabric8.istio.api.networking.v1beta1.DestinationRuleSpec",
			reflect.TypeOf(api_networking_v1beta1.Gateway{}):             "io.fabric8.istio.api.networking.v1beta1.GatewaySpec",
			reflect.TypeOf(api_networking_v1beta1.ServiceEntry{}):        "io.fabric8.istio.api.networking.v1beta1.ServiceEntrySpec",
			reflect.TypeOf(api_networking_v1beta1.Sidecar{}):             "io.fabric8.istio.api.networking.v1beta1.SidecarSpec",
			reflect.TypeOf(api_networking_v1beta1.VirtualService{}):      "io.fabric8.istio.api.networking.v1beta1.VirtualServiceSpec",
			reflect.TypeOf(api_networking_v1beta1.WorkloadEntry{}):       "io.fabric8.istio.api.networking.v1beta1.WorkloadEntrySpec",
			reflect.TypeOf(api_networking_v1beta1.WorkloadGroup{}):       "io.fabric8.istio.api.networking.v1beta1.WorkloadGroupSpec",
			reflect.TypeOf(api_networking_v1beta1.ProxyConfig{}):         "io.fabric8.istio.api.networking.v1beta1.ProxyConfigSpec",
			reflect.TypeOf(api_security_v1beta1.AuthorizationPolicy{}):   "io.fabric8.istio.api.security.v1beta1.AuthorizationPolicySpec",
			reflect.TypeOf(api_security_v1beta1.PeerAuthentication{}):    "io.fabric8.istio.api.security.v1beta1.PeerAuthenticationSpec",
			reflect.TypeOf(api_security_v1beta1.RequestAuthentication{}): "io.fabric8.istio.api.security.v1beta1.RequestAuthenticationSpec",

			// Avoid same name for:
			reflect.TypeOf(api_networking_v1beta1.LoadBalancerSettings_ConsistentHashLB_HTTPCookie{}): "io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBHttpCookieValue",
			reflect.TypeOf(api_networking_v1beta1.LoadBalancerSettings_ConsistentHashLB_RingHash{}):   "io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBRingHashValue",
			reflect.TypeOf(api_networking_v1beta1.LoadBalancerSettings_ConsistentHashLB_MagLev{}):     "io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBMagLevValue",
		},
		CustomJavaNameRule: func(packageName *string, className *string) {
			// remove underscores
			*className = strings.Replace(*className, "_", "", -1)
		},
	}

	// custom enum mapping
	enumMapping := map[reflect.Type]schemagen.EnumDescriptor{}

	json := schemagen.GenerateSchemaWithAllOptions("http://fabric8.io/istio/IstioSchema#", crdLists, typesDescriptors, providedPackages, manualTypeMap, packageMapping, mappingSchema, providedTypes, constraints, interfacesMapping, javaNameStrategyMapping, enumMapping, "io.fabric8")

	// Workaround to avoid error due to two types with same name RingHash and RingHash_
	json = strings.Replace(json, "RingHash_", "RingHashWrapper", -1)
	fmt.Println(json)
}
