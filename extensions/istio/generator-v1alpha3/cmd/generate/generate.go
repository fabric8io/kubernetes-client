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
	"github.com/golang/protobuf/ptypes/duration"
	"github.com/golang/protobuf/ptypes/timestamp"
	"strings"

	"github.com/gogo/protobuf/types"

	"github.com/fabric8io/kubernetes-client/generator/pkg/schemagen"
	structpb "github.com/golang/protobuf/ptypes/struct"
	wrappers "github.com/golang/protobuf/ptypes/wrappers"

	// Internal APIs:
	api_extensions_v1alpha1 "istio.io/api/extensions/v1alpha1"
	api_networking_v1alpha3 "istio.io/api/networking/v1alpha3"
	api_telemetry_v1alpha1 "istio.io/api/telemetry/v1alpha1"

	// External APIs:
	client_extensions_v1alpha1 "istio.io/client-go/pkg/apis/extensions/v1alpha1"
	client_networking_v1alpha3 "istio.io/client-go/pkg/apis/networking/v1alpha3"
	client_telemetry_v1alpha1 "istio.io/client-go/pkg/apis/telemetry/v1alpha1"
	"reflect"
)

func main() {

	// the CRD List types for which the model should be generated
	// no other types need to be defined as they are auto discovered
	crdLists := map[reflect.Type]schemagen.CrdScope{
		// networking
		reflect.TypeOf(client_networking_v1alpha3.DestinationRuleList{}): schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1alpha3.GatewayList{}):         schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1alpha3.ServiceEntryList{}):    schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1alpha3.SidecarList{}):         schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1alpha3.VirtualServiceList{}):  schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1alpha3.WorkloadEntryList{}):   schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1alpha3.EnvoyFilterList{}):     schemagen.Namespaced,
		reflect.TypeOf(client_networking_v1alpha3.WorkloadGroupList{}):   schemagen.Namespaced,
		reflect.TypeOf(client_extensions_v1alpha1.WasmPluginList{}):      schemagen.Namespaced,
		reflect.TypeOf(client_telemetry_v1alpha1.TelemetryList{}):        schemagen.Namespaced,
	}

	// custom types descriptors
	typesDescriptors := map[reflect.Type]*schemagen.JSONObjectDescriptor{}

	// constraints and patterns for fields
	constraints := map[reflect.Type]map[string]*schemagen.Constraint{}

	// types that are manually defined in the model
	providedTypes := []schemagen.ProvidedType{
		// Due to issue in sundrio (https://github.com/sundrio/sundrio/issues/170). A duplicated methods is generated, both named `hasMatchingAllowOrigin`
		{GoType: reflect.TypeOf(api_networking_v1alpha3.CorsPolicy{}), JavaClass: "io.fabric8.istio.api.networking.v1alpha3.CorsPolicy"},
	}

	// go packages that are provided and where no generation is required and their corresponding java package
	providedPackages := map[string]string{
		"k8s.io/apimachinery/pkg/apis/meta/v1": "io.fabric8.kubernetes.api.model",
		"k8s.io/api/core/v1":                   "io.fabric8.kubernetes.api.model",
	}

	// mapping of go packages of this module to the resulting java package
	// optional ApiGroup and ApiVersion for the go package (which is added to the generated java class)
	packageMapping := map[string]schemagen.PackageInformation{
		"istio.io/client-go/pkg/apis/networking/v1alpha3": {JavaPackage: "io.fabric8.istio.api.networking.v1alpha3", ApiGroup: "networking.istio.io", ApiVersion: "v1alpha3"},
		"istio.io/client-go/pkg/apis/extensions/v1alpha1": {JavaPackage: "io.fabric8.istio.api.extensions.v1alpha1", ApiGroup: "extensions.istio.io", ApiVersion: "v1alpha1"},
		"istio.io/client-go/pkg/apis/telemetry/v1alpha1":  {JavaPackage: "io.fabric8.istio.api.telemetry.v1alpha1", ApiGroup: "telemetry.istio.io", ApiVersion: "v1alpha1"},
		"istio.io/api/type/v1beta1":                       {JavaPackage: "io.fabric8.istio.api.networking.v1beta1", ApiGroup: "networking.istio.io", ApiVersion: "v1beta1"},
	}

	// converts all packages starting with <key> to a java package using an automated scheme:
	//  - replace <key> with <value> aka "package prefix"
	//  - replace '/' with '.' for a valid java package name
	mappingSchema := map[string]string{
		"github.com/gogo/protobuf/types":   "io.fabric8.istio.api.internal.protobuf.types",
		"istio.io/api/analysis/v1alpha1":   "io.fabric8.istio.api.analysis.v1alpha1",
		"istio.io/api/meta/v1alpha1":       "io.fabric8.istio.api.meta.v1alpha1",
		"istio.io/api/networking/v1alpha3": "io.fabric8.istio.api.networking.v1alpha3",
		"istio.io/api/extensions/v1alpha1": "io.fabric8.istio.api.networking.v1alpha1",
		"istio.io/api/telemetry/v1alpha1":  "io.fabric8.istio.api.telemetry.v1alpha1",
		"istio.io/api/type/v1beta1":        "io.fabric8.istio.api.type.v1beta1",
	}

	// overwriting some times
	manualTypeMap := map[reflect.Type]string{
		reflect.TypeOf(types.BoolValue{}):      "java.lang.Boolean",
		reflect.TypeOf(wrappers.BoolValue{}):   "java.lang.Boolean",
		reflect.TypeOf(wrappers.UInt32Value{}): "java.lang.Integer",
		reflect.TypeOf(wrappers.Int32Value{}):  "java.lang.Integer",
		reflect.TypeOf(wrappers.DoubleValue{}): "java.lang.Double",
		reflect.TypeOf(types.DoubleValue{}):    "java.lang.Double",
		reflect.TypeOf(duration.Duration{}):    "java.lang.String",
		reflect.TypeOf(timestamp.Timestamp{}):  "java.lang.String",
		reflect.TypeOf(types.Int32Value{}):     "java.lang.Integer",
		reflect.TypeOf(types.UInt32Value{}):    "java.lang.Integer",
		reflect.TypeOf(structpb.Struct{}):      "java.util.Map<String, Object>",
	}

	// types for interfaces
	interfacesMapping := map[string][]reflect.Type{
		// types
		"github.com/gogo/protobuf/types/isValue_Kind": {reflect.TypeOf(types.Value_NullValue{}), reflect.TypeOf(types.Value_NumberValue{}), reflect.TypeOf(types.Value_StringValue{}), reflect.TypeOf(types.Value_BoolValue{}), reflect.TypeOf(types.Value_StructValue{}), reflect.TypeOf(types.Value_ListValue{})},

		// networking
		"istio.io/api/networking/v1alpha3/isStringMatch_MatchType":                               {reflect.TypeOf(api_networking_v1alpha3.StringMatch_Exact{}), reflect.TypeOf(api_networking_v1alpha3.StringMatch_Regex{}), reflect.TypeOf(api_networking_v1alpha3.StringMatch_Prefix{})},
		"istio.io/api/networking/v1alpha3/isHTTPFaultInjection_Abort_ErrorType":                  {reflect.TypeOf(api_networking_v1alpha3.HTTPFaultInjection_Abort_HttpStatus{}), reflect.TypeOf(api_networking_v1alpha3.HTTPFaultInjection_Abort_GrpcStatus{}), reflect.TypeOf(api_networking_v1alpha3.HTTPFaultInjection_Abort_Http2Error{})},
		"istio.io/api/networking/v1alpha3/isHTTPFaultInjection_Delay_HttpDelayType":              {reflect.TypeOf(api_networking_v1alpha3.HTTPFaultInjection_Delay_ExponentialDelay{}), reflect.TypeOf(api_networking_v1alpha3.HTTPFaultInjection_Delay_FixedDelay{})},
		"istio.io/api/networking/v1alpha3/isLoadBalancerSettings_LbPolicy":                       {reflect.TypeOf(api_networking_v1alpha3.LoadBalancerSettings_ConsistentHash{}), reflect.TypeOf(api_networking_v1alpha3.LoadBalancerSettings_Simple{})},
		"istio.io/api/networking/v1alpha3/isLoadBalancerSettings_ConsistentHashLB_HashKey":       {reflect.TypeOf(api_networking_v1alpha3.LoadBalancerSettings_ConsistentHashLB_HttpHeaderName{}), reflect.TypeOf(api_networking_v1alpha3.LoadBalancerSettings_ConsistentHashLB_HttpCookie{}), reflect.TypeOf(api_networking_v1alpha3.LoadBalancerSettings_ConsistentHashLB_UseSourceIp{}), reflect.TypeOf(api_networking_v1alpha3.LoadBalancerSettings_ConsistentHashLB_HttpQueryParameterName{})},
		"istio.io/api/networking/v1alpha3/isLoadBalancerSettings_ConsistentHashLB_HashAlgorithm": {reflect.TypeOf(api_networking_v1alpha3.LoadBalancerSettings_ConsistentHashLB_Maglev{}), reflect.TypeOf(api_networking_v1alpha3.LoadBalancerSettings_ConsistentHashLB_RingHash_{})},
		"istio.io/api/networking/v1alpha3/isHTTPRedirect_RedirectPort":                           {reflect.TypeOf(api_networking_v1alpha3.HTTPRedirect_Port{}), reflect.TypeOf(api_networking_v1alpha3.HTTPRedirect_DerivePort{})},
		"istio.io/api/networking/v1alpha3/isEnvoyFilter_EnvoyConfigObjectMatch_ObjectTypes":      {reflect.TypeOf(api_networking_v1alpha3.EnvoyFilter_EnvoyConfigObjectMatch_Listener{}), reflect.TypeOf(api_networking_v1alpha3.EnvoyFilter_EnvoyConfigObjectMatch_RouteConfiguration{}), reflect.TypeOf(api_networking_v1alpha3.EnvoyFilter_EnvoyConfigObjectMatch_Cluster{})},
		"istio.io/api/networking/v1alpha3/isReadinessProbe_HealthCheckMethod":                    {reflect.TypeOf(api_networking_v1alpha3.ReadinessProbe_Exec{}), reflect.TypeOf(api_networking_v1alpha3.ReadinessProbe_HttpGet{}), reflect.TypeOf(api_networking_v1alpha3.ReadinessProbe_TcpSocket{})},
		"istio.io/api/networking/v1alpha3/isHTTPBody_Specifier":                                  {reflect.TypeOf(api_networking_v1alpha3.HTTPBody_String_{}), reflect.TypeOf(api_networking_v1alpha3.HTTPBody_Bytes{})},
		"istio.io/api/telemetry/v1alpha1/isMetricSelector_MetricMatch":                           {reflect.TypeOf(api_telemetry_v1alpha1.MetricSelector_Metric{}), reflect.TypeOf(api_telemetry_v1alpha1.MetricSelector_CustomMetric{})},
		"istio.io/api/telemetry/v1alpha1/isTracing_CustomTag_Type":                               {reflect.TypeOf(api_telemetry_v1alpha1.Tracing_CustomTag_Literal{}), reflect.TypeOf(api_telemetry_v1alpha1.Tracing_CustomTag_Environment{}), reflect.TypeOf(api_telemetry_v1alpha1.Tracing_CustomTag_Header{})},
	}

	// custom name rules
	javaNameStrategyMapping := schemagen.JavaNameStrategyMapping{
		ResolveFieldNameFromProtobufFirst: true,
		SkipFieldWithEmptyTag:             true,
		NameMapping: map[reflect.Type]string{
			reflect.TypeOf(api_networking_v1alpha3.EnvoyFilter{}):                 "io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterSpec",
			reflect.TypeOf(api_networking_v1alpha3.DestinationRule{}):             "io.fabric8.istio.api.networking.v1alpha3.DestinationRuleSpec",
			reflect.TypeOf(api_networking_v1alpha3.Gateway{}):                     "io.fabric8.istio.api.networking.v1alpha3.GatewaySpec",
			reflect.TypeOf(api_networking_v1alpha3.ServiceEntry{}):                "io.fabric8.istio.api.networking.v1alpha3.ServiceEntrySpec",
			reflect.TypeOf(api_networking_v1alpha3.Sidecar{}):                     "io.fabric8.istio.api.networking.v1alpha3.SidecarSpec",
			reflect.TypeOf(api_networking_v1alpha3.VirtualService{}):              "io.fabric8.istio.api.networking.v1alpha3.VirtualServiceSpec",
			reflect.TypeOf(api_networking_v1alpha3.WorkloadEntry{}):               "io.fabric8.istio.api.networking.v1alpha3.WorkloadEntrySpec",
			reflect.TypeOf(api_networking_v1alpha3.WorkloadGroup{}):               "io.fabric8.istio.api.networking.v1alpha3.WorkloadGroupSpec",
			reflect.TypeOf(api_extensions_v1alpha1.WasmPlugin{}):                  "io.fabric8.istio.api.extensions.v1alpha1.WasmPluginSpec",
			reflect.TypeOf(api_telemetry_v1alpha1.Telemetry{}):                    "io.fabric8.istio.api.extensions.v1alpha1.TelemetrySpec",
			reflect.TypeOf(types.Value{}):                                         "io.fabric8.istio.api.internal.protobuf.types.Value",
			reflect.TypeOf(api_networking_v1alpha3.LoadBalancerSettings_Simple{}): "io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsSimple",

			// Avoid same name for:
			reflect.TypeOf(api_networking_v1alpha3.LoadBalancerSettings_ConsistentHashLB_HTTPCookie{}): "io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBHttpCookieValue",
			reflect.TypeOf(api_networking_v1alpha3.LoadBalancerSettings_ConsistentHashLB_MagLev{}):     "io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBMagLevValue",
			reflect.TypeOf(api_networking_v1alpha3.LoadBalancerSettings_ConsistentHashLB_RingHash{}):   "io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBRingHashValue",
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
