
package io.fabric8.istio.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.istio.api.analysis.v1alpha1.AnalysisMessageBase;
import io.fabric8.istio.api.analysis.v1alpha1.AnalysisMessageBaseLevel;
import io.fabric8.istio.api.analysis.v1alpha1.AnalysisMessageBaseType;
import io.fabric8.istio.api.internal.protobuf.types.IsValueKind;
import io.fabric8.istio.api.internal.protobuf.types.ListValue;
import io.fabric8.istio.api.internal.protobuf.types.NullValue;
import io.fabric8.istio.api.internal.protobuf.types.Value;
import io.fabric8.istio.api.internal.protobuf.types.ValueBoolValue;
import io.fabric8.istio.api.internal.protobuf.types.ValueListValue;
import io.fabric8.istio.api.internal.protobuf.types.ValueNullValue;
import io.fabric8.istio.api.internal.protobuf.types.ValueNumberValue;
import io.fabric8.istio.api.internal.protobuf.types.ValueStringValue;
import io.fabric8.istio.api.internal.protobuf.types.ValueStructValue;
import io.fabric8.istio.api.meta.v1alpha1.IstioCondition;
import io.fabric8.istio.api.meta.v1alpha1.IstioStatus;
import io.fabric8.istio.api.networking.v1alpha3.CaptureMode;
import io.fabric8.istio.api.networking.v1alpha3.ClientTLSSettings;
import io.fabric8.istio.api.networking.v1alpha3.ClientTLSSettingsTLSmode;
import io.fabric8.istio.api.networking.v1alpha3.ConnectionPoolSettings;
import io.fabric8.istio.api.networking.v1alpha3.ConnectionPoolSettingsHTTPSettings;
import io.fabric8.istio.api.networking.v1alpha3.ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy;
import io.fabric8.istio.api.networking.v1alpha3.ConnectionPoolSettingsTCPSettings;
import io.fabric8.istio.api.networking.v1alpha3.ConnectionPoolSettingsTCPSettingsTcpKeepalive;
import io.fabric8.istio.api.networking.v1alpha3.Delegate;
import io.fabric8.istio.api.networking.v1alpha3.Destination;
import io.fabric8.istio.api.networking.v1alpha3.DestinationRule;
import io.fabric8.istio.api.networking.v1alpha3.DestinationRuleList;
import io.fabric8.istio.api.networking.v1alpha3.DestinationRuleSpec;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilter;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterApplyTo;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterClusterMatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatchCluster;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatchListener;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterEnvoyConfigObjectPatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterList;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterListenerMatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterListenerMatchFilterChainMatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterListenerMatchFilterMatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterListenerMatchSubFilterMatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterPatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterPatchContext;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterPatchFilterClass;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterPatchOperation;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterProxyMatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterRouteConfigurationMatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterRouteConfigurationMatchRouteMatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterRouteConfigurationMatchRouteMatchAction;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterRouteConfigurationMatchVirtualHostMatch;
import io.fabric8.istio.api.networking.v1alpha3.EnvoyFilterSpec;
import io.fabric8.istio.api.networking.v1alpha3.Gateway;
import io.fabric8.istio.api.networking.v1alpha3.GatewayList;
import io.fabric8.istio.api.networking.v1alpha3.GatewaySpec;
import io.fabric8.istio.api.networking.v1alpha3.HTTPFaultInjection;
import io.fabric8.istio.api.networking.v1alpha3.HTTPFaultInjectionAbort;
import io.fabric8.istio.api.networking.v1alpha3.HTTPFaultInjectionAbortGrpcStatus;
import io.fabric8.istio.api.networking.v1alpha3.HTTPFaultInjectionAbortHttp2Error;
import io.fabric8.istio.api.networking.v1alpha3.HTTPFaultInjectionAbortHttpStatus;
import io.fabric8.istio.api.networking.v1alpha3.HTTPFaultInjectionDelay;
import io.fabric8.istio.api.networking.v1alpha3.HTTPFaultInjectionDelayExponentialDelay;
import io.fabric8.istio.api.networking.v1alpha3.HTTPFaultInjectionDelayFixedDelay;
import io.fabric8.istio.api.networking.v1alpha3.HTTPMatchRequest;
import io.fabric8.istio.api.networking.v1alpha3.HTTPRedirect;
import io.fabric8.istio.api.networking.v1alpha3.HTTPRedirectDerivePort;
import io.fabric8.istio.api.networking.v1alpha3.HTTPRedirectPort;
import io.fabric8.istio.api.networking.v1alpha3.HTTPRedirectRedirectPortSelection;
import io.fabric8.istio.api.networking.v1alpha3.HTTPRetry;
import io.fabric8.istio.api.networking.v1alpha3.HTTPRewrite;
import io.fabric8.istio.api.networking.v1alpha3.HTTPRoute;
import io.fabric8.istio.api.networking.v1alpha3.HTTPRouteDestination;
import io.fabric8.istio.api.networking.v1alpha3.Headers;
import io.fabric8.istio.api.networking.v1alpha3.HeadersHeaderOperations;
import io.fabric8.istio.api.networking.v1alpha3.IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes;
import io.fabric8.istio.api.networking.v1alpha3.IsHTTPFaultInjectionAbortErrorType;
import io.fabric8.istio.api.networking.v1alpha3.IsHTTPFaultInjectionDelayHttpDelayType;
import io.fabric8.istio.api.networking.v1alpha3.IsHTTPRedirectRedirectPort;
import io.fabric8.istio.api.networking.v1alpha3.IsLoadBalancerSettingsConsistentHashLBHashKey;
import io.fabric8.istio.api.networking.v1alpha3.IsLoadBalancerSettingsLbPolicy;
import io.fabric8.istio.api.networking.v1alpha3.IsStringMatchMatchType;
import io.fabric8.istio.api.networking.v1alpha3.IstioEgressListener;
import io.fabric8.istio.api.networking.v1alpha3.IstioIngressListener;
import io.fabric8.istio.api.networking.v1alpha3.L4MatchAttributes;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettings;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHash;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLB;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBHttpCookie;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBHttpCookieValue;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBHttpHeaderName;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBHttpQueryParameterName;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsConsistentHashLBUseSourceIp;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsSimple;
import io.fabric8.istio.api.networking.v1alpha3.LoadBalancerSettingsSimpleLB;
import io.fabric8.istio.api.networking.v1alpha3.LocalityLoadBalancerSetting;
import io.fabric8.istio.api.networking.v1alpha3.LocalityLoadBalancerSettingDistribute;
import io.fabric8.istio.api.networking.v1alpha3.LocalityLoadBalancerSettingFailover;
import io.fabric8.istio.api.networking.v1alpha3.OutboundTrafficPolicy;
import io.fabric8.istio.api.networking.v1alpha3.OutboundTrafficPolicyMode;
import io.fabric8.istio.api.networking.v1alpha3.OutlierDetection;
import io.fabric8.istio.api.networking.v1alpha3.Percent;
import io.fabric8.istio.api.networking.v1alpha3.Port;
import io.fabric8.istio.api.networking.v1alpha3.PortSelector;
import io.fabric8.istio.api.networking.v1alpha3.RouteDestination;
import io.fabric8.istio.api.networking.v1alpha3.Server;
import io.fabric8.istio.api.networking.v1alpha3.ServerTLSSettings;
import io.fabric8.istio.api.networking.v1alpha3.ServerTLSSettingsTLSProtocol;
import io.fabric8.istio.api.networking.v1alpha3.ServerTLSSettingsTLSmode;
import io.fabric8.istio.api.networking.v1alpha3.ServiceEntry;
import io.fabric8.istio.api.networking.v1alpha3.ServiceEntryList;
import io.fabric8.istio.api.networking.v1alpha3.ServiceEntryLocation;
import io.fabric8.istio.api.networking.v1alpha3.ServiceEntryResolution;
import io.fabric8.istio.api.networking.v1alpha3.ServiceEntrySpec;
import io.fabric8.istio.api.networking.v1alpha3.Sidecar;
import io.fabric8.istio.api.networking.v1alpha3.SidecarList;
import io.fabric8.istio.api.networking.v1alpha3.SidecarSpec;
import io.fabric8.istio.api.networking.v1alpha3.StringMatch;
import io.fabric8.istio.api.networking.v1alpha3.StringMatchExact;
import io.fabric8.istio.api.networking.v1alpha3.StringMatchPrefix;
import io.fabric8.istio.api.networking.v1alpha3.StringMatchRegex;
import io.fabric8.istio.api.networking.v1alpha3.Subset;
import io.fabric8.istio.api.networking.v1alpha3.TCPRoute;
import io.fabric8.istio.api.networking.v1alpha3.TLSMatchAttributes;
import io.fabric8.istio.api.networking.v1alpha3.TLSRoute;
import io.fabric8.istio.api.networking.v1alpha3.TrafficPolicy;
import io.fabric8.istio.api.networking.v1alpha3.TrafficPolicyPortTrafficPolicy;
import io.fabric8.istio.api.networking.v1alpha3.VirtualService;
import io.fabric8.istio.api.networking.v1alpha3.VirtualServiceList;
import io.fabric8.istio.api.networking.v1alpha3.VirtualServiceSpec;
import io.fabric8.istio.api.networking.v1alpha3.WorkloadEntry;
import io.fabric8.istio.api.networking.v1alpha3.WorkloadEntryList;
import io.fabric8.istio.api.networking.v1alpha3.WorkloadEntrySpec;
import io.fabric8.istio.api.networking.v1alpha3.WorkloadSelector;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "github_com_gogo_protobuf_types_ListValue",
    "github_com_gogo_protobuf_types_NullValue",
    "github_com_gogo_protobuf_types_Value",
    "github_com_gogo_protobuf_types_Value_BoolValue",
    "github_com_gogo_protobuf_types_Value_ListValue",
    "github_com_gogo_protobuf_types_Value_NullValue",
    "github_com_gogo_protobuf_types_Value_NumberValue",
    "github_com_gogo_protobuf_types_Value_StringValue",
    "github_com_gogo_protobuf_types_Value_StructValue",
    "github_com_gogo_protobuf_types_isValue_Kind",
    "istio_io_api_analysis_v1alpha1_AnalysisMessageBase",
    "istio_io_api_analysis_v1alpha1_AnalysisMessageBase_Level",
    "istio_io_api_analysis_v1alpha1_AnalysisMessageBase_Type",
    "istio_io_api_meta_v1alpha1_IstioCondition",
    "istio_io_api_meta_v1alpha1_IstioStatus",
    "istio_io_api_networking_v1alpha3_CaptureMode",
    "istio_io_api_networking_v1alpha3_ClientTLSSettings",
    "istio_io_api_networking_v1alpha3_ClientTLSSettings_TLSmode",
    "istio_io_api_networking_v1alpha3_ConnectionPoolSettings",
    "istio_io_api_networking_v1alpha3_ConnectionPoolSettings_HTTPSettings",
    "istio_io_api_networking_v1alpha3_ConnectionPoolSettings_HTTPSettings_H2UpgradePolicy",
    "istio_io_api_networking_v1alpha3_ConnectionPoolSettings_TCPSettings",
    "istio_io_api_networking_v1alpha3_ConnectionPoolSettings_TCPSettings_TcpKeepalive",
    "istio_io_api_networking_v1alpha3_Delegate",
    "istio_io_api_networking_v1alpha3_Destination",
    "istio_io_api_networking_v1alpha3_DestinationRule",
    "istio_io_api_networking_v1alpha3_EnvoyFilter",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_ApplyTo",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_ClusterMatch",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch_Cluster",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch_Listener",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch_RouteConfiguration",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectPatch",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch_FilterChainMatch",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch_FilterMatch",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch_SubFilterMatch",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_Patch",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_PatchContext",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_Patch_FilterClass",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_Patch_Operation",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_ProxyMatch",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch_RouteMatch",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch_RouteMatch_Action",
    "istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch_VirtualHostMatch",
    "istio_io_api_networking_v1alpha3_Gateway",
    "istio_io_api_networking_v1alpha3_HTTPFaultInjection",
    "istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort",
    "istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort_GrpcStatus",
    "istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort_Http2Error",
    "istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort_HttpStatus",
    "istio_io_api_networking_v1alpha3_HTTPFaultInjection_Delay",
    "istio_io_api_networking_v1alpha3_HTTPFaultInjection_Delay_ExponentialDelay",
    "istio_io_api_networking_v1alpha3_HTTPFaultInjection_Delay_FixedDelay",
    "istio_io_api_networking_v1alpha3_HTTPMatchRequest",
    "istio_io_api_networking_v1alpha3_HTTPRedirect",
    "istio_io_api_networking_v1alpha3_HTTPRedirect_DerivePort",
    "istio_io_api_networking_v1alpha3_HTTPRedirect_Port",
    "istio_io_api_networking_v1alpha3_HTTPRedirect_RedirectPortSelection",
    "istio_io_api_networking_v1alpha3_HTTPRetry",
    "istio_io_api_networking_v1alpha3_HTTPRewrite",
    "istio_io_api_networking_v1alpha3_HTTPRoute",
    "istio_io_api_networking_v1alpha3_HTTPRouteDestination",
    "istio_io_api_networking_v1alpha3_Headers",
    "istio_io_api_networking_v1alpha3_Headers_HeaderOperations",
    "istio_io_api_networking_v1alpha3_IstioEgressListener",
    "istio_io_api_networking_v1alpha3_IstioIngressListener",
    "istio_io_api_networking_v1alpha3_L4MatchAttributes",
    "istio_io_api_networking_v1alpha3_LoadBalancerSettings",
    "istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHash",
    "istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB",
    "istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HTTPCookie",
    "istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HttpCookie",
    "istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HttpHeaderName",
    "istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HttpQueryParameterName",
    "istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_UseSourceIp",
    "istio_io_api_networking_v1alpha3_LoadBalancerSettings_Simple",
    "istio_io_api_networking_v1alpha3_LoadBalancerSettings_SimpleLB",
    "istio_io_api_networking_v1alpha3_LocalityLoadBalancerSetting",
    "istio_io_api_networking_v1alpha3_LocalityLoadBalancerSetting_Distribute",
    "istio_io_api_networking_v1alpha3_LocalityLoadBalancerSetting_Failover",
    "istio_io_api_networking_v1alpha3_OutboundTrafficPolicy",
    "istio_io_api_networking_v1alpha3_OutboundTrafficPolicy_Mode",
    "istio_io_api_networking_v1alpha3_OutlierDetection",
    "istio_io_api_networking_v1alpha3_Percent",
    "istio_io_api_networking_v1alpha3_Port",
    "istio_io_api_networking_v1alpha3_PortSelector",
    "istio_io_api_networking_v1alpha3_RouteDestination",
    "istio_io_api_networking_v1alpha3_Server",
    "istio_io_api_networking_v1alpha3_ServerTLSSettings",
    "istio_io_api_networking_v1alpha3_ServerTLSSettings_TLSProtocol",
    "istio_io_api_networking_v1alpha3_ServerTLSSettings_TLSmode",
    "istio_io_api_networking_v1alpha3_ServiceEntry",
    "istio_io_api_networking_v1alpha3_ServiceEntry_Location",
    "istio_io_api_networking_v1alpha3_ServiceEntry_Resolution",
    "istio_io_api_networking_v1alpha3_Sidecar",
    "istio_io_api_networking_v1alpha3_StringMatch",
    "istio_io_api_networking_v1alpha3_StringMatch_Exact",
    "istio_io_api_networking_v1alpha3_StringMatch_Prefix",
    "istio_io_api_networking_v1alpha3_StringMatch_Regex",
    "istio_io_api_networking_v1alpha3_Subset",
    "istio_io_api_networking_v1alpha3_TCPRoute",
    "istio_io_api_networking_v1alpha3_TLSMatchAttributes",
    "istio_io_api_networking_v1alpha3_TLSRoute",
    "istio_io_api_networking_v1alpha3_TrafficPolicy",
    "istio_io_api_networking_v1alpha3_TrafficPolicy_PortTrafficPolicy",
    "istio_io_api_networking_v1alpha3_VirtualService",
    "istio_io_api_networking_v1alpha3_WorkloadEntry",
    "istio_io_api_networking_v1alpha3_WorkloadSelector",
    "istio_io_api_networking_v1alpha3_isEnvoyFilter_EnvoyConfigObjectMatch_ObjectTypes",
    "istio_io_api_networking_v1alpha3_isHTTPFaultInjection_Abort_ErrorType",
    "istio_io_api_networking_v1alpha3_isHTTPFaultInjection_Delay_HttpDelayType",
    "istio_io_api_networking_v1alpha3_isHTTPRedirect_RedirectPort",
    "istio_io_api_networking_v1alpha3_isLoadBalancerSettings_ConsistentHashLB_HashKey",
    "istio_io_api_networking_v1alpha3_isLoadBalancerSettings_LbPolicy",
    "istio_io_api_networking_v1alpha3_isStringMatch_MatchType",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_DestinationRule",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_DestinationRuleList",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_EnvoyFilter",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_EnvoyFilterList",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_Gateway",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_GatewayList",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_ServiceEntry",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_ServiceEntryList",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_Sidecar",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_SidecarList",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_VirtualService",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_VirtualServiceList",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_WorkloadEntry",
    "istio_io_client-go_pkg_apis_networking_v1alpha3_WorkloadEntryList"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class IstioSchema {

    @JsonProperty("github_com_gogo_protobuf_types_ListValue")
    private ListValue githubComGogoProtobufTypesListValue;
    @JsonProperty("github_com_gogo_protobuf_types_NullValue")
    private NullValue githubComGogoProtobufTypesNullValue;
    @JsonProperty("github_com_gogo_protobuf_types_Value")
    private Value githubComGogoProtobufTypesValue;
    @JsonProperty("github_com_gogo_protobuf_types_Value_BoolValue")
    private ValueBoolValue githubComGogoProtobufTypesValueBoolValue;
    @JsonProperty("github_com_gogo_protobuf_types_Value_ListValue")
    private ValueListValue githubComGogoProtobufTypesValueListValue;
    @JsonProperty("github_com_gogo_protobuf_types_Value_NullValue")
    private ValueNullValue githubComGogoProtobufTypesValueNullValue;
    @JsonProperty("github_com_gogo_protobuf_types_Value_NumberValue")
    private ValueNumberValue githubComGogoProtobufTypesValueNumberValue;
    @JsonProperty("github_com_gogo_protobuf_types_Value_StringValue")
    private ValueStringValue githubComGogoProtobufTypesValueStringValue;
    @JsonProperty("github_com_gogo_protobuf_types_Value_StructValue")
    private ValueStructValue githubComGogoProtobufTypesValueStructValue;
    @JsonProperty("github_com_gogo_protobuf_types_isValue_Kind")
    @JsonUnwrapped
    private IsValueKind githubComGogoProtobufTypesIsValueKind;
    @JsonProperty("istio_io_api_analysis_v1alpha1_AnalysisMessageBase")
    private AnalysisMessageBase istioIoApiAnalysisV1alpha1AnalysisMessageBase;
    @JsonProperty("istio_io_api_analysis_v1alpha1_AnalysisMessageBase_Level")
    private AnalysisMessageBaseLevel istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel;
    @JsonProperty("istio_io_api_analysis_v1alpha1_AnalysisMessageBase_Type")
    private AnalysisMessageBaseType istioIoApiAnalysisV1alpha1AnalysisMessageBaseType;
    @JsonProperty("istio_io_api_meta_v1alpha1_IstioCondition")
    private IstioCondition istioIoApiMetaV1alpha1IstioCondition;
    @JsonProperty("istio_io_api_meta_v1alpha1_IstioStatus")
    private IstioStatus istioIoApiMetaV1alpha1IstioStatus;
    @JsonProperty("istio_io_api_networking_v1alpha3_CaptureMode")
    private CaptureMode istioIoApiNetworkingV1alpha3CaptureMode;
    @JsonProperty("istio_io_api_networking_v1alpha3_ClientTLSSettings")
    private ClientTLSSettings istioIoApiNetworkingV1alpha3ClientTLSSettings;
    @JsonProperty("istio_io_api_networking_v1alpha3_ClientTLSSettings_TLSmode")
    private ClientTLSSettingsTLSmode istioIoApiNetworkingV1alpha3ClientTLSSettingsTLSmode;
    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings")
    private ConnectionPoolSettings istioIoApiNetworkingV1alpha3ConnectionPoolSettings;
    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings_HTTPSettings")
    private ConnectionPoolSettingsHTTPSettings istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettings;
    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings_HTTPSettings_H2UpgradePolicy")
    private ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy;
    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings_TCPSettings")
    private ConnectionPoolSettingsTCPSettings istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettings;
    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings_TCPSettings_TcpKeepalive")
    private ConnectionPoolSettingsTCPSettingsTcpKeepalive istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettingsTcpKeepalive;
    @JsonProperty("istio_io_api_networking_v1alpha3_Delegate")
    private Delegate istioIoApiNetworkingV1alpha3Delegate;
    @JsonProperty("istio_io_api_networking_v1alpha3_Destination")
    private Destination istioIoApiNetworkingV1alpha3Destination;
    @JsonProperty("istio_io_api_networking_v1alpha3_DestinationRule")
    private DestinationRuleSpec istioIoApiNetworkingV1alpha3DestinationRule;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter")
    private EnvoyFilterSpec istioIoApiNetworkingV1alpha3EnvoyFilter;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ApplyTo")
    private EnvoyFilterApplyTo istioIoApiNetworkingV1alpha3EnvoyFilterApplyTo;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ClusterMatch")
    private EnvoyFilterClusterMatch istioIoApiNetworkingV1alpha3EnvoyFilterClusterMatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch")
    private EnvoyFilterEnvoyConfigObjectMatch istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch_Cluster")
    private EnvoyFilterEnvoyConfigObjectMatchCluster istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchCluster;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch_Listener")
    private EnvoyFilterEnvoyConfigObjectMatchListener istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchListener;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch_RouteConfiguration")
    private EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectPatch")
    private EnvoyFilterEnvoyConfigObjectPatch istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectPatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch")
    private EnvoyFilterListenerMatch istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch_FilterChainMatch")
    private EnvoyFilterListenerMatchFilterChainMatch istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterChainMatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch_FilterMatch")
    private EnvoyFilterListenerMatchFilterMatch istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterMatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch_SubFilterMatch")
    private EnvoyFilterListenerMatchSubFilterMatch istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchSubFilterMatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_Patch")
    private EnvoyFilterPatch istioIoApiNetworkingV1alpha3EnvoyFilterPatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_PatchContext")
    private EnvoyFilterPatchContext istioIoApiNetworkingV1alpha3EnvoyFilterPatchContext;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_Patch_FilterClass")
    private EnvoyFilterPatchFilterClass istioIoApiNetworkingV1alpha3EnvoyFilterPatchFilterClass;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_Patch_Operation")
    private EnvoyFilterPatchOperation istioIoApiNetworkingV1alpha3EnvoyFilterPatchOperation;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ProxyMatch")
    private EnvoyFilterProxyMatch istioIoApiNetworkingV1alpha3EnvoyFilterProxyMatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch")
    private EnvoyFilterRouteConfigurationMatch istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch_RouteMatch")
    private EnvoyFilterRouteConfigurationMatchRouteMatch istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch_RouteMatch_Action")
    private EnvoyFilterRouteConfigurationMatchRouteMatchAction istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatchAction;
    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch_VirtualHostMatch")
    private EnvoyFilterRouteConfigurationMatchVirtualHostMatch istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchVirtualHostMatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_Gateway")
    private GatewaySpec istioIoApiNetworkingV1alpha3Gateway;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection")
    private HTTPFaultInjection istioIoApiNetworkingV1alpha3HTTPFaultInjection;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort")
    private HTTPFaultInjectionAbort istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbort;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort_GrpcStatus")
    private HTTPFaultInjectionAbortGrpcStatus istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortGrpcStatus;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort_Http2Error")
    private HTTPFaultInjectionAbortHttp2Error istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttp2Error;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort_HttpStatus")
    private HTTPFaultInjectionAbortHttpStatus istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttpStatus;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Delay")
    private HTTPFaultInjectionDelay istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelay;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Delay_ExponentialDelay")
    private HTTPFaultInjectionDelayExponentialDelay istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayExponentialDelay;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Delay_FixedDelay")
    private HTTPFaultInjectionDelayFixedDelay istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayFixedDelay;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPMatchRequest")
    private HTTPMatchRequest istioIoApiNetworkingV1alpha3HTTPMatchRequest;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRedirect")
    private HTTPRedirect istioIoApiNetworkingV1alpha3HTTPRedirect;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRedirect_DerivePort")
    private HTTPRedirectDerivePort istioIoApiNetworkingV1alpha3HTTPRedirectDerivePort;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRedirect_Port")
    private HTTPRedirectPort istioIoApiNetworkingV1alpha3HTTPRedirectPort;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRedirect_RedirectPortSelection")
    private HTTPRedirectRedirectPortSelection istioIoApiNetworkingV1alpha3HTTPRedirectRedirectPortSelection;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRetry")
    private HTTPRetry istioIoApiNetworkingV1alpha3HTTPRetry;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRewrite")
    private HTTPRewrite istioIoApiNetworkingV1alpha3HTTPRewrite;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRoute")
    private HTTPRoute istioIoApiNetworkingV1alpha3HTTPRoute;
    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRouteDestination")
    private HTTPRouteDestination istioIoApiNetworkingV1alpha3HTTPRouteDestination;
    @JsonProperty("istio_io_api_networking_v1alpha3_Headers")
    private Headers istioIoApiNetworkingV1alpha3Headers;
    @JsonProperty("istio_io_api_networking_v1alpha3_Headers_HeaderOperations")
    private HeadersHeaderOperations istioIoApiNetworkingV1alpha3HeadersHeaderOperations;
    @JsonProperty("istio_io_api_networking_v1alpha3_IstioEgressListener")
    private IstioEgressListener istioIoApiNetworkingV1alpha3IstioEgressListener;
    @JsonProperty("istio_io_api_networking_v1alpha3_IstioIngressListener")
    private IstioIngressListener istioIoApiNetworkingV1alpha3IstioIngressListener;
    @JsonProperty("istio_io_api_networking_v1alpha3_L4MatchAttributes")
    private L4MatchAttributes istioIoApiNetworkingV1alpha3L4MatchAttributes;
    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings")
    private LoadBalancerSettings istioIoApiNetworkingV1alpha3LoadBalancerSettings;
    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHash")
    private LoadBalancerSettingsConsistentHash istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHash;
    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB")
    private LoadBalancerSettingsConsistentHashLB istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLB;
    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HTTPCookie")
    private LoadBalancerSettingsConsistentHashLBHttpCookieValue istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHTTPCookie;
    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HttpCookie")
    private LoadBalancerSettingsConsistentHashLBHttpCookie istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpCookie;
    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HttpHeaderName")
    private LoadBalancerSettingsConsistentHashLBHttpHeaderName istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpHeaderName;
    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HttpQueryParameterName")
    private LoadBalancerSettingsConsistentHashLBHttpQueryParameterName istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpQueryParameterName;
    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_UseSourceIp")
    private LoadBalancerSettingsConsistentHashLBUseSourceIp istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBUseSourceIp;
    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_Simple")
    private LoadBalancerSettingsSimple istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimple;
    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_SimpleLB")
    private LoadBalancerSettingsSimpleLB istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimpleLB;
    @JsonProperty("istio_io_api_networking_v1alpha3_LocalityLoadBalancerSetting")
    private LocalityLoadBalancerSetting istioIoApiNetworkingV1alpha3LocalityLoadBalancerSetting;
    @JsonProperty("istio_io_api_networking_v1alpha3_LocalityLoadBalancerSetting_Distribute")
    private LocalityLoadBalancerSettingDistribute istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingDistribute;
    @JsonProperty("istio_io_api_networking_v1alpha3_LocalityLoadBalancerSetting_Failover")
    private LocalityLoadBalancerSettingFailover istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingFailover;
    @JsonProperty("istio_io_api_networking_v1alpha3_OutboundTrafficPolicy")
    private OutboundTrafficPolicy istioIoApiNetworkingV1alpha3OutboundTrafficPolicy;
    @JsonProperty("istio_io_api_networking_v1alpha3_OutboundTrafficPolicy_Mode")
    private OutboundTrafficPolicyMode istioIoApiNetworkingV1alpha3OutboundTrafficPolicyMode;
    @JsonProperty("istio_io_api_networking_v1alpha3_OutlierDetection")
    private OutlierDetection istioIoApiNetworkingV1alpha3OutlierDetection;
    @JsonProperty("istio_io_api_networking_v1alpha3_Percent")
    private Percent istioIoApiNetworkingV1alpha3Percent;
    @JsonProperty("istio_io_api_networking_v1alpha3_Port")
    private Port istioIoApiNetworkingV1alpha3Port;
    @JsonProperty("istio_io_api_networking_v1alpha3_PortSelector")
    private PortSelector istioIoApiNetworkingV1alpha3PortSelector;
    @JsonProperty("istio_io_api_networking_v1alpha3_RouteDestination")
    private RouteDestination istioIoApiNetworkingV1alpha3RouteDestination;
    @JsonProperty("istio_io_api_networking_v1alpha3_Server")
    private Server istioIoApiNetworkingV1alpha3Server;
    @JsonProperty("istio_io_api_networking_v1alpha3_ServerTLSSettings")
    private ServerTLSSettings istioIoApiNetworkingV1alpha3ServerTLSSettings;
    @JsonProperty("istio_io_api_networking_v1alpha3_ServerTLSSettings_TLSProtocol")
    private ServerTLSSettingsTLSProtocol istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSProtocol;
    @JsonProperty("istio_io_api_networking_v1alpha3_ServerTLSSettings_TLSmode")
    private ServerTLSSettingsTLSmode istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSmode;
    @JsonProperty("istio_io_api_networking_v1alpha3_ServiceEntry")
    private ServiceEntrySpec istioIoApiNetworkingV1alpha3ServiceEntry;
    @JsonProperty("istio_io_api_networking_v1alpha3_ServiceEntry_Location")
    private ServiceEntryLocation istioIoApiNetworkingV1alpha3ServiceEntryLocation;
    @JsonProperty("istio_io_api_networking_v1alpha3_ServiceEntry_Resolution")
    private ServiceEntryResolution istioIoApiNetworkingV1alpha3ServiceEntryResolution;
    @JsonProperty("istio_io_api_networking_v1alpha3_Sidecar")
    private SidecarSpec istioIoApiNetworkingV1alpha3Sidecar;
    @JsonProperty("istio_io_api_networking_v1alpha3_StringMatch")
    private StringMatch istioIoApiNetworkingV1alpha3StringMatch;
    @JsonProperty("istio_io_api_networking_v1alpha3_StringMatch_Exact")
    private StringMatchExact istioIoApiNetworkingV1alpha3StringMatchExact;
    @JsonProperty("istio_io_api_networking_v1alpha3_StringMatch_Prefix")
    private StringMatchPrefix istioIoApiNetworkingV1alpha3StringMatchPrefix;
    @JsonProperty("istio_io_api_networking_v1alpha3_StringMatch_Regex")
    private StringMatchRegex istioIoApiNetworkingV1alpha3StringMatchRegex;
    @JsonProperty("istio_io_api_networking_v1alpha3_Subset")
    private Subset istioIoApiNetworkingV1alpha3Subset;
    @JsonProperty("istio_io_api_networking_v1alpha3_TCPRoute")
    private TCPRoute istioIoApiNetworkingV1alpha3TCPRoute;
    @JsonProperty("istio_io_api_networking_v1alpha3_TLSMatchAttributes")
    private TLSMatchAttributes istioIoApiNetworkingV1alpha3TLSMatchAttributes;
    @JsonProperty("istio_io_api_networking_v1alpha3_TLSRoute")
    private TLSRoute istioIoApiNetworkingV1alpha3TLSRoute;
    @JsonProperty("istio_io_api_networking_v1alpha3_TrafficPolicy")
    private TrafficPolicy istioIoApiNetworkingV1alpha3TrafficPolicy;
    @JsonProperty("istio_io_api_networking_v1alpha3_TrafficPolicy_PortTrafficPolicy")
    private TrafficPolicyPortTrafficPolicy istioIoApiNetworkingV1alpha3TrafficPolicyPortTrafficPolicy;
    @JsonProperty("istio_io_api_networking_v1alpha3_VirtualService")
    private VirtualServiceSpec istioIoApiNetworkingV1alpha3VirtualService;
    @JsonProperty("istio_io_api_networking_v1alpha3_WorkloadEntry")
    private WorkloadEntrySpec istioIoApiNetworkingV1alpha3WorkloadEntry;
    @JsonProperty("istio_io_api_networking_v1alpha3_WorkloadSelector")
    private WorkloadSelector istioIoApiNetworkingV1alpha3WorkloadSelector;
    @JsonProperty("istio_io_api_networking_v1alpha3_isEnvoyFilter_EnvoyConfigObjectMatch_ObjectTypes")
    @JsonUnwrapped
    private IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes istioIoApiNetworkingV1alpha3IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes;
    @JsonProperty("istio_io_api_networking_v1alpha3_isHTTPFaultInjection_Abort_ErrorType")
    @JsonUnwrapped
    private IsHTTPFaultInjectionAbortErrorType istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionAbortErrorType;
    @JsonProperty("istio_io_api_networking_v1alpha3_isHTTPFaultInjection_Delay_HttpDelayType")
    @JsonUnwrapped
    private IsHTTPFaultInjectionDelayHttpDelayType istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionDelayHttpDelayType;
    @JsonProperty("istio_io_api_networking_v1alpha3_isHTTPRedirect_RedirectPort")
    @JsonUnwrapped
    private IsHTTPRedirectRedirectPort istioIoApiNetworkingV1alpha3IsHTTPRedirectRedirectPort;
    @JsonProperty("istio_io_api_networking_v1alpha3_isLoadBalancerSettings_ConsistentHashLB_HashKey")
    @JsonUnwrapped
    private IsLoadBalancerSettingsConsistentHashLBHashKey istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsConsistentHashLBHashKey;
    @JsonProperty("istio_io_api_networking_v1alpha3_isLoadBalancerSettings_LbPolicy")
    @JsonUnwrapped
    private IsLoadBalancerSettingsLbPolicy istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsLbPolicy;
    @JsonProperty("istio_io_api_networking_v1alpha3_isStringMatch_MatchType")
    @JsonUnwrapped
    private IsStringMatchMatchType istioIoApiNetworkingV1alpha3IsStringMatchMatchType;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_DestinationRule")
    private DestinationRule istioIoClientGoPkgApisNetworkingV1alpha3DestinationRule;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_DestinationRuleList")
    private DestinationRuleList istioIoClientGoPkgApisNetworkingV1alpha3DestinationRuleList;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_EnvoyFilter")
    private EnvoyFilter istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilter;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_EnvoyFilterList")
    private EnvoyFilterList istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilterList;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_Gateway")
    private Gateway istioIoClientGoPkgApisNetworkingV1alpha3Gateway;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_GatewayList")
    private GatewayList istioIoClientGoPkgApisNetworkingV1alpha3GatewayList;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_ServiceEntry")
    private ServiceEntry istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntry;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_ServiceEntryList")
    private ServiceEntryList istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntryList;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_Sidecar")
    private Sidecar istioIoClientGoPkgApisNetworkingV1alpha3Sidecar;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_SidecarList")
    private SidecarList istioIoClientGoPkgApisNetworkingV1alpha3SidecarList;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_VirtualService")
    private VirtualService istioIoClientGoPkgApisNetworkingV1alpha3VirtualService;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_VirtualServiceList")
    private VirtualServiceList istioIoClientGoPkgApisNetworkingV1alpha3VirtualServiceList;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_WorkloadEntry")
    private WorkloadEntry istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntry;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_WorkloadEntryList")
    private WorkloadEntryList istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntryList;

    /**
     * No args constructor for use in serialization
     * 
     */
    public IstioSchema() {
    }

    /**
     * 
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatch
     * @param istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntryList
     * @param istioIoApiNetworkingV1alpha3TrafficPolicy
     * @param istioIoClientGoPkgApisNetworkingV1alpha3VirtualServiceList
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterPatchFilterClass
     * @param istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilter
     * @param istioIoApiNetworkingV1alpha3Sidecar
     * @param githubComGogoProtobufTypesIsValueKind
     * @param istioIoApiNetworkingV1alpha3HeadersHeaderOperations
     * @param istioIoApiNetworkingV1alpha3TrafficPolicyPortTrafficPolicy
     * @param istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilterList
     * @param istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSProtocol
     * @param istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel
     * @param istioIoApiNetworkingV1alpha3VirtualService
     * @param istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionDelayHttpDelayType
     * @param istioIoApiNetworkingV1alpha3TCPRoute
     * @param githubComGogoProtobufTypesValueStructValue
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchVirtualHostMatch
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchListener
     * @param istioIoApiNetworkingV1alpha3StringMatchPrefix
     * @param istioIoApiNetworkingV1alpha3Subset
     * @param istioIoApiNetworkingV1alpha3OutboundTrafficPolicy
     * @param istioIoApiNetworkingV1alpha3Percent
     * @param istioIoApiNetworkingV1alpha3HTTPRoute
     * @param istioIoClientGoPkgApisNetworkingV1alpha3VirtualService
     * @param githubComGogoProtobufTypesListValue
     * @param istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpHeaderName
     * @param istioIoApiNetworkingV1alpha3LoadBalancerSettings
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatch
     * @param istioIoApiNetworkingV1alpha3ClientTLSSettings
     * @param istioIoApiNetworkingV1alpha3IstioEgressListener
     * @param istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttp2Error
     * @param istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingFailover
     * @param istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntry
     * @param istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelay
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatch
     * @param istioIoApiNetworkingV1alpha3StringMatchRegex
     * @param istioIoApiNetworkingV1alpha3WorkloadSelector
     * @param istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLB
     * @param istioIoApiNetworkingV1alpha3HTTPRedirectDerivePort
     * @param istioIoApiNetworkingV1alpha3HTTPFaultInjection
     * @param istioIoApiNetworkingV1alpha3ClientTLSSettingsTLSmode
     * @param istioIoApiNetworkingV1alpha3OutboundTrafficPolicyMode
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchCluster
     * @param istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimpleLB
     * @param istioIoApiNetworkingV1alpha3StringMatch
     * @param istioIoApiNetworkingV1alpha3LocalityLoadBalancerSetting
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterProxyMatch
     * @param istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSmode
     * @param istioIoApiNetworkingV1alpha3EnvoyFilter
     * @param istioIoApiNetworkingV1alpha3OutlierDetection
     * @param istioIoApiMetaV1alpha1IstioStatus
     * @param istioIoApiNetworkingV1alpha3StringMatchExact
     * @param istioIoApiNetworkingV1alpha3Delegate
     * @param istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettings
     * @param istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayFixedDelay
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterPatchContext
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterMatch
     * @param istioIoApiNetworkingV1alpha3Server
     * @param istioIoApiNetworkingV1alpha3ServiceEntryLocation
     * @param githubComGogoProtobufTypesValueBoolValue
     * @param istioIoClientGoPkgApisNetworkingV1alpha3Sidecar
     * @param istioIoApiNetworkingV1alpha3IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes
     * @param istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttpStatus
     * @param istioIoApiAnalysisV1alpha1AnalysisMessageBase
     * @param istioIoApiNetworkingV1alpha3PortSelector
     * @param istioIoClientGoPkgApisNetworkingV1alpha3DestinationRuleList
     * @param istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntryList
     * @param istioIoApiMetaV1alpha1IstioCondition
     * @param istioIoApiNetworkingV1alpha3HTTPRedirectPort
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatch
     * @param istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortGrpcStatus
     * @param istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsLbPolicy
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterPatchOperation
     * @param istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpCookie
     * @param githubComGogoProtobufTypesNullValue
     * @param istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHash
     * @param istioIoApiNetworkingV1alpha3HTTPMatchRequest
     * @param istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbort
     * @param istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsConsistentHashLBHashKey
     * @param istioIoApiAnalysisV1alpha1AnalysisMessageBaseType
     * @param istioIoApiNetworkingV1alpha3IsStringMatchMatchType
     * @param istioIoApiNetworkingV1alpha3L4MatchAttributes
     * @param githubComGogoProtobufTypesValue
     * @param istioIoApiNetworkingV1alpha3Port
     * @param istioIoClientGoPkgApisNetworkingV1alpha3DestinationRule
     * @param istioIoClientGoPkgApisNetworkingV1alpha3GatewayList
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterChainMatch
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterApplyTo
     * @param istioIoApiNetworkingV1alpha3TLSMatchAttributes
     * @param istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpQueryParameterName
     * @param istioIoClientGoPkgApisNetworkingV1alpha3SidecarList
     * @param githubComGogoProtobufTypesValueNullValue
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterClusterMatch
     * @param istioIoApiNetworkingV1alpha3Headers
     * @param istioIoApiNetworkingV1alpha3WorkloadEntry
     * @param istioIoApiNetworkingV1alpha3CaptureMode
     * @param istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy
     * @param istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettingsTcpKeepalive
     * @param istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntry
     * @param istioIoApiNetworkingV1alpha3ServiceEntry
     * @param istioIoApiNetworkingV1alpha3RouteDestination
     * @param istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimple
     * @param istioIoClientGoPkgApisNetworkingV1alpha3Gateway
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchSubFilterMatch
     * @param istioIoApiNetworkingV1alpha3HTTPRetry
     * @param githubComGogoProtobufTypesValueListValue
     * @param githubComGogoProtobufTypesValueNumberValue
     * @param istioIoApiNetworkingV1alpha3ServerTLSSettings
     * @param istioIoApiNetworkingV1alpha3ConnectionPoolSettings
     * @param istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayExponentialDelay
     * @param istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHTTPCookie
     * @param istioIoApiNetworkingV1alpha3Destination
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterPatch
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatchAction
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration
     * @param istioIoApiNetworkingV1alpha3HTTPRouteDestination
     * @param istioIoApiNetworkingV1alpha3ServiceEntryResolution
     * @param istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectPatch
     * @param istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingDistribute
     * @param istioIoApiNetworkingV1alpha3DestinationRule
     * @param istioIoApiNetworkingV1alpha3IstioIngressListener
     * @param githubComGogoProtobufTypesValueStringValue
     * @param istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettings
     * @param istioIoApiNetworkingV1alpha3Gateway
     * @param istioIoApiNetworkingV1alpha3HTTPRedirectRedirectPortSelection
     * @param istioIoApiNetworkingV1alpha3TLSRoute
     * @param istioIoApiNetworkingV1alpha3IsHTTPRedirectRedirectPort
     * @param istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionAbortErrorType
     * @param istioIoApiNetworkingV1alpha3HTTPRedirect
     * @param istioIoApiNetworkingV1alpha3HTTPRewrite
     * @param istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBUseSourceIp
     */
    public IstioSchema(ListValue githubComGogoProtobufTypesListValue, NullValue githubComGogoProtobufTypesNullValue, Value githubComGogoProtobufTypesValue, ValueBoolValue githubComGogoProtobufTypesValueBoolValue, ValueListValue githubComGogoProtobufTypesValueListValue, ValueNullValue githubComGogoProtobufTypesValueNullValue, ValueNumberValue githubComGogoProtobufTypesValueNumberValue, ValueStringValue githubComGogoProtobufTypesValueStringValue, ValueStructValue githubComGogoProtobufTypesValueStructValue, IsValueKind githubComGogoProtobufTypesIsValueKind, AnalysisMessageBase istioIoApiAnalysisV1alpha1AnalysisMessageBase, AnalysisMessageBaseLevel istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel, AnalysisMessageBaseType istioIoApiAnalysisV1alpha1AnalysisMessageBaseType, IstioCondition istioIoApiMetaV1alpha1IstioCondition, IstioStatus istioIoApiMetaV1alpha1IstioStatus, CaptureMode istioIoApiNetworkingV1alpha3CaptureMode, ClientTLSSettings istioIoApiNetworkingV1alpha3ClientTLSSettings, ClientTLSSettingsTLSmode istioIoApiNetworkingV1alpha3ClientTLSSettingsTLSmode, ConnectionPoolSettings istioIoApiNetworkingV1alpha3ConnectionPoolSettings, ConnectionPoolSettingsHTTPSettings istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettings, ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy, ConnectionPoolSettingsTCPSettings istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettings, ConnectionPoolSettingsTCPSettingsTcpKeepalive istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettingsTcpKeepalive, Delegate istioIoApiNetworkingV1alpha3Delegate, Destination istioIoApiNetworkingV1alpha3Destination, DestinationRuleSpec istioIoApiNetworkingV1alpha3DestinationRule, EnvoyFilterSpec istioIoApiNetworkingV1alpha3EnvoyFilter, EnvoyFilterApplyTo istioIoApiNetworkingV1alpha3EnvoyFilterApplyTo, EnvoyFilterClusterMatch istioIoApiNetworkingV1alpha3EnvoyFilterClusterMatch, EnvoyFilterEnvoyConfigObjectMatch istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatch, EnvoyFilterEnvoyConfigObjectMatchCluster istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchCluster, EnvoyFilterEnvoyConfigObjectMatchListener istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchListener, EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration, EnvoyFilterEnvoyConfigObjectPatch istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectPatch, EnvoyFilterListenerMatch istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatch, EnvoyFilterListenerMatchFilterChainMatch istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterChainMatch, EnvoyFilterListenerMatchFilterMatch istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterMatch, EnvoyFilterListenerMatchSubFilterMatch istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchSubFilterMatch, EnvoyFilterPatch istioIoApiNetworkingV1alpha3EnvoyFilterPatch, EnvoyFilterPatchContext istioIoApiNetworkingV1alpha3EnvoyFilterPatchContext, EnvoyFilterPatchFilterClass istioIoApiNetworkingV1alpha3EnvoyFilterPatchFilterClass, EnvoyFilterPatchOperation istioIoApiNetworkingV1alpha3EnvoyFilterPatchOperation, EnvoyFilterProxyMatch istioIoApiNetworkingV1alpha3EnvoyFilterProxyMatch, EnvoyFilterRouteConfigurationMatch istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatch, EnvoyFilterRouteConfigurationMatchRouteMatch istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatch, EnvoyFilterRouteConfigurationMatchRouteMatchAction istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatchAction, EnvoyFilterRouteConfigurationMatchVirtualHostMatch istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchVirtualHostMatch, GatewaySpec istioIoApiNetworkingV1alpha3Gateway, HTTPFaultInjection istioIoApiNetworkingV1alpha3HTTPFaultInjection, HTTPFaultInjectionAbort istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbort, HTTPFaultInjectionAbortGrpcStatus istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortGrpcStatus, HTTPFaultInjectionAbortHttp2Error istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttp2Error, HTTPFaultInjectionAbortHttpStatus istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttpStatus, HTTPFaultInjectionDelay istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelay, HTTPFaultInjectionDelayExponentialDelay istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayExponentialDelay, HTTPFaultInjectionDelayFixedDelay istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayFixedDelay, HTTPMatchRequest istioIoApiNetworkingV1alpha3HTTPMatchRequest, HTTPRedirect istioIoApiNetworkingV1alpha3HTTPRedirect, HTTPRedirectDerivePort istioIoApiNetworkingV1alpha3HTTPRedirectDerivePort, HTTPRedirectPort istioIoApiNetworkingV1alpha3HTTPRedirectPort, HTTPRedirectRedirectPortSelection istioIoApiNetworkingV1alpha3HTTPRedirectRedirectPortSelection, HTTPRetry istioIoApiNetworkingV1alpha3HTTPRetry, HTTPRewrite istioIoApiNetworkingV1alpha3HTTPRewrite, HTTPRoute istioIoApiNetworkingV1alpha3HTTPRoute, HTTPRouteDestination istioIoApiNetworkingV1alpha3HTTPRouteDestination, Headers istioIoApiNetworkingV1alpha3Headers, HeadersHeaderOperations istioIoApiNetworkingV1alpha3HeadersHeaderOperations, IstioEgressListener istioIoApiNetworkingV1alpha3IstioEgressListener, IstioIngressListener istioIoApiNetworkingV1alpha3IstioIngressListener, L4MatchAttributes istioIoApiNetworkingV1alpha3L4MatchAttributes, LoadBalancerSettings istioIoApiNetworkingV1alpha3LoadBalancerSettings, LoadBalancerSettingsConsistentHash istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHash, LoadBalancerSettingsConsistentHashLB istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLB, LoadBalancerSettingsConsistentHashLBHttpCookieValue istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHTTPCookie, LoadBalancerSettingsConsistentHashLBHttpCookie istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpCookie, LoadBalancerSettingsConsistentHashLBHttpHeaderName istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpHeaderName, LoadBalancerSettingsConsistentHashLBHttpQueryParameterName istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpQueryParameterName, LoadBalancerSettingsConsistentHashLBUseSourceIp istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBUseSourceIp, LoadBalancerSettingsSimple istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimple, LoadBalancerSettingsSimpleLB istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimpleLB, LocalityLoadBalancerSetting istioIoApiNetworkingV1alpha3LocalityLoadBalancerSetting, LocalityLoadBalancerSettingDistribute istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingDistribute, LocalityLoadBalancerSettingFailover istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingFailover, OutboundTrafficPolicy istioIoApiNetworkingV1alpha3OutboundTrafficPolicy, OutboundTrafficPolicyMode istioIoApiNetworkingV1alpha3OutboundTrafficPolicyMode, OutlierDetection istioIoApiNetworkingV1alpha3OutlierDetection, Percent istioIoApiNetworkingV1alpha3Percent, Port istioIoApiNetworkingV1alpha3Port, PortSelector istioIoApiNetworkingV1alpha3PortSelector, RouteDestination istioIoApiNetworkingV1alpha3RouteDestination, Server istioIoApiNetworkingV1alpha3Server, ServerTLSSettings istioIoApiNetworkingV1alpha3ServerTLSSettings, ServerTLSSettingsTLSProtocol istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSProtocol, ServerTLSSettingsTLSmode istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSmode, ServiceEntrySpec istioIoApiNetworkingV1alpha3ServiceEntry, ServiceEntryLocation istioIoApiNetworkingV1alpha3ServiceEntryLocation, ServiceEntryResolution istioIoApiNetworkingV1alpha3ServiceEntryResolution, SidecarSpec istioIoApiNetworkingV1alpha3Sidecar, StringMatch istioIoApiNetworkingV1alpha3StringMatch, StringMatchExact istioIoApiNetworkingV1alpha3StringMatchExact, StringMatchPrefix istioIoApiNetworkingV1alpha3StringMatchPrefix, StringMatchRegex istioIoApiNetworkingV1alpha3StringMatchRegex, Subset istioIoApiNetworkingV1alpha3Subset, TCPRoute istioIoApiNetworkingV1alpha3TCPRoute, TLSMatchAttributes istioIoApiNetworkingV1alpha3TLSMatchAttributes, TLSRoute istioIoApiNetworkingV1alpha3TLSRoute, TrafficPolicy istioIoApiNetworkingV1alpha3TrafficPolicy, TrafficPolicyPortTrafficPolicy istioIoApiNetworkingV1alpha3TrafficPolicyPortTrafficPolicy, VirtualServiceSpec istioIoApiNetworkingV1alpha3VirtualService, WorkloadEntrySpec istioIoApiNetworkingV1alpha3WorkloadEntry, WorkloadSelector istioIoApiNetworkingV1alpha3WorkloadSelector, IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes istioIoApiNetworkingV1alpha3IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes, IsHTTPFaultInjectionAbortErrorType istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionAbortErrorType, IsHTTPFaultInjectionDelayHttpDelayType istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionDelayHttpDelayType, IsHTTPRedirectRedirectPort istioIoApiNetworkingV1alpha3IsHTTPRedirectRedirectPort, IsLoadBalancerSettingsConsistentHashLBHashKey istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsConsistentHashLBHashKey, IsLoadBalancerSettingsLbPolicy istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsLbPolicy, IsStringMatchMatchType istioIoApiNetworkingV1alpha3IsStringMatchMatchType, DestinationRule istioIoClientGoPkgApisNetworkingV1alpha3DestinationRule, DestinationRuleList istioIoClientGoPkgApisNetworkingV1alpha3DestinationRuleList, EnvoyFilter istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilter, EnvoyFilterList istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilterList, Gateway istioIoClientGoPkgApisNetworkingV1alpha3Gateway, GatewayList istioIoClientGoPkgApisNetworkingV1alpha3GatewayList, ServiceEntry istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntry, ServiceEntryList istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntryList, Sidecar istioIoClientGoPkgApisNetworkingV1alpha3Sidecar, SidecarList istioIoClientGoPkgApisNetworkingV1alpha3SidecarList, VirtualService istioIoClientGoPkgApisNetworkingV1alpha3VirtualService, VirtualServiceList istioIoClientGoPkgApisNetworkingV1alpha3VirtualServiceList, WorkloadEntry istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntry, WorkloadEntryList istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntryList) {
        super();
        this.githubComGogoProtobufTypesListValue = githubComGogoProtobufTypesListValue;
        this.githubComGogoProtobufTypesNullValue = githubComGogoProtobufTypesNullValue;
        this.githubComGogoProtobufTypesValue = githubComGogoProtobufTypesValue;
        this.githubComGogoProtobufTypesValueBoolValue = githubComGogoProtobufTypesValueBoolValue;
        this.githubComGogoProtobufTypesValueListValue = githubComGogoProtobufTypesValueListValue;
        this.githubComGogoProtobufTypesValueNullValue = githubComGogoProtobufTypesValueNullValue;
        this.githubComGogoProtobufTypesValueNumberValue = githubComGogoProtobufTypesValueNumberValue;
        this.githubComGogoProtobufTypesValueStringValue = githubComGogoProtobufTypesValueStringValue;
        this.githubComGogoProtobufTypesValueStructValue = githubComGogoProtobufTypesValueStructValue;
        this.githubComGogoProtobufTypesIsValueKind = githubComGogoProtobufTypesIsValueKind;
        this.istioIoApiAnalysisV1alpha1AnalysisMessageBase = istioIoApiAnalysisV1alpha1AnalysisMessageBase;
        this.istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel = istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel;
        this.istioIoApiAnalysisV1alpha1AnalysisMessageBaseType = istioIoApiAnalysisV1alpha1AnalysisMessageBaseType;
        this.istioIoApiMetaV1alpha1IstioCondition = istioIoApiMetaV1alpha1IstioCondition;
        this.istioIoApiMetaV1alpha1IstioStatus = istioIoApiMetaV1alpha1IstioStatus;
        this.istioIoApiNetworkingV1alpha3CaptureMode = istioIoApiNetworkingV1alpha3CaptureMode;
        this.istioIoApiNetworkingV1alpha3ClientTLSSettings = istioIoApiNetworkingV1alpha3ClientTLSSettings;
        this.istioIoApiNetworkingV1alpha3ClientTLSSettingsTLSmode = istioIoApiNetworkingV1alpha3ClientTLSSettingsTLSmode;
        this.istioIoApiNetworkingV1alpha3ConnectionPoolSettings = istioIoApiNetworkingV1alpha3ConnectionPoolSettings;
        this.istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettings = istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettings;
        this.istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy = istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy;
        this.istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettings = istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettings;
        this.istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettingsTcpKeepalive = istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettingsTcpKeepalive;
        this.istioIoApiNetworkingV1alpha3Delegate = istioIoApiNetworkingV1alpha3Delegate;
        this.istioIoApiNetworkingV1alpha3Destination = istioIoApiNetworkingV1alpha3Destination;
        this.istioIoApiNetworkingV1alpha3DestinationRule = istioIoApiNetworkingV1alpha3DestinationRule;
        this.istioIoApiNetworkingV1alpha3EnvoyFilter = istioIoApiNetworkingV1alpha3EnvoyFilter;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterApplyTo = istioIoApiNetworkingV1alpha3EnvoyFilterApplyTo;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterClusterMatch = istioIoApiNetworkingV1alpha3EnvoyFilterClusterMatch;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatch = istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatch;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchCluster = istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchCluster;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchListener = istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchListener;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration = istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectPatch = istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectPatch;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatch = istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatch;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterChainMatch = istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterChainMatch;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterMatch = istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterMatch;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchSubFilterMatch = istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchSubFilterMatch;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterPatch = istioIoApiNetworkingV1alpha3EnvoyFilterPatch;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterPatchContext = istioIoApiNetworkingV1alpha3EnvoyFilterPatchContext;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterPatchFilterClass = istioIoApiNetworkingV1alpha3EnvoyFilterPatchFilterClass;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterPatchOperation = istioIoApiNetworkingV1alpha3EnvoyFilterPatchOperation;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterProxyMatch = istioIoApiNetworkingV1alpha3EnvoyFilterProxyMatch;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatch = istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatch;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatch = istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatch;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatchAction = istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatchAction;
        this.istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchVirtualHostMatch = istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchVirtualHostMatch;
        this.istioIoApiNetworkingV1alpha3Gateway = istioIoApiNetworkingV1alpha3Gateway;
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjection = istioIoApiNetworkingV1alpha3HTTPFaultInjection;
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbort = istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbort;
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortGrpcStatus = istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortGrpcStatus;
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttp2Error = istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttp2Error;
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttpStatus = istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttpStatus;
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelay = istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelay;
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayExponentialDelay = istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayExponentialDelay;
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayFixedDelay = istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayFixedDelay;
        this.istioIoApiNetworkingV1alpha3HTTPMatchRequest = istioIoApiNetworkingV1alpha3HTTPMatchRequest;
        this.istioIoApiNetworkingV1alpha3HTTPRedirect = istioIoApiNetworkingV1alpha3HTTPRedirect;
        this.istioIoApiNetworkingV1alpha3HTTPRedirectDerivePort = istioIoApiNetworkingV1alpha3HTTPRedirectDerivePort;
        this.istioIoApiNetworkingV1alpha3HTTPRedirectPort = istioIoApiNetworkingV1alpha3HTTPRedirectPort;
        this.istioIoApiNetworkingV1alpha3HTTPRedirectRedirectPortSelection = istioIoApiNetworkingV1alpha3HTTPRedirectRedirectPortSelection;
        this.istioIoApiNetworkingV1alpha3HTTPRetry = istioIoApiNetworkingV1alpha3HTTPRetry;
        this.istioIoApiNetworkingV1alpha3HTTPRewrite = istioIoApiNetworkingV1alpha3HTTPRewrite;
        this.istioIoApiNetworkingV1alpha3HTTPRoute = istioIoApiNetworkingV1alpha3HTTPRoute;
        this.istioIoApiNetworkingV1alpha3HTTPRouteDestination = istioIoApiNetworkingV1alpha3HTTPRouteDestination;
        this.istioIoApiNetworkingV1alpha3Headers = istioIoApiNetworkingV1alpha3Headers;
        this.istioIoApiNetworkingV1alpha3HeadersHeaderOperations = istioIoApiNetworkingV1alpha3HeadersHeaderOperations;
        this.istioIoApiNetworkingV1alpha3IstioEgressListener = istioIoApiNetworkingV1alpha3IstioEgressListener;
        this.istioIoApiNetworkingV1alpha3IstioIngressListener = istioIoApiNetworkingV1alpha3IstioIngressListener;
        this.istioIoApiNetworkingV1alpha3L4MatchAttributes = istioIoApiNetworkingV1alpha3L4MatchAttributes;
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettings = istioIoApiNetworkingV1alpha3LoadBalancerSettings;
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHash = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHash;
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLB = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLB;
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHTTPCookie = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHTTPCookie;
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpCookie = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpCookie;
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpHeaderName = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpHeaderName;
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpQueryParameterName = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpQueryParameterName;
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBUseSourceIp = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBUseSourceIp;
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimple = istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimple;
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimpleLB = istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimpleLB;
        this.istioIoApiNetworkingV1alpha3LocalityLoadBalancerSetting = istioIoApiNetworkingV1alpha3LocalityLoadBalancerSetting;
        this.istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingDistribute = istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingDistribute;
        this.istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingFailover = istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingFailover;
        this.istioIoApiNetworkingV1alpha3OutboundTrafficPolicy = istioIoApiNetworkingV1alpha3OutboundTrafficPolicy;
        this.istioIoApiNetworkingV1alpha3OutboundTrafficPolicyMode = istioIoApiNetworkingV1alpha3OutboundTrafficPolicyMode;
        this.istioIoApiNetworkingV1alpha3OutlierDetection = istioIoApiNetworkingV1alpha3OutlierDetection;
        this.istioIoApiNetworkingV1alpha3Percent = istioIoApiNetworkingV1alpha3Percent;
        this.istioIoApiNetworkingV1alpha3Port = istioIoApiNetworkingV1alpha3Port;
        this.istioIoApiNetworkingV1alpha3PortSelector = istioIoApiNetworkingV1alpha3PortSelector;
        this.istioIoApiNetworkingV1alpha3RouteDestination = istioIoApiNetworkingV1alpha3RouteDestination;
        this.istioIoApiNetworkingV1alpha3Server = istioIoApiNetworkingV1alpha3Server;
        this.istioIoApiNetworkingV1alpha3ServerTLSSettings = istioIoApiNetworkingV1alpha3ServerTLSSettings;
        this.istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSProtocol = istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSProtocol;
        this.istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSmode = istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSmode;
        this.istioIoApiNetworkingV1alpha3ServiceEntry = istioIoApiNetworkingV1alpha3ServiceEntry;
        this.istioIoApiNetworkingV1alpha3ServiceEntryLocation = istioIoApiNetworkingV1alpha3ServiceEntryLocation;
        this.istioIoApiNetworkingV1alpha3ServiceEntryResolution = istioIoApiNetworkingV1alpha3ServiceEntryResolution;
        this.istioIoApiNetworkingV1alpha3Sidecar = istioIoApiNetworkingV1alpha3Sidecar;
        this.istioIoApiNetworkingV1alpha3StringMatch = istioIoApiNetworkingV1alpha3StringMatch;
        this.istioIoApiNetworkingV1alpha3StringMatchExact = istioIoApiNetworkingV1alpha3StringMatchExact;
        this.istioIoApiNetworkingV1alpha3StringMatchPrefix = istioIoApiNetworkingV1alpha3StringMatchPrefix;
        this.istioIoApiNetworkingV1alpha3StringMatchRegex = istioIoApiNetworkingV1alpha3StringMatchRegex;
        this.istioIoApiNetworkingV1alpha3Subset = istioIoApiNetworkingV1alpha3Subset;
        this.istioIoApiNetworkingV1alpha3TCPRoute = istioIoApiNetworkingV1alpha3TCPRoute;
        this.istioIoApiNetworkingV1alpha3TLSMatchAttributes = istioIoApiNetworkingV1alpha3TLSMatchAttributes;
        this.istioIoApiNetworkingV1alpha3TLSRoute = istioIoApiNetworkingV1alpha3TLSRoute;
        this.istioIoApiNetworkingV1alpha3TrafficPolicy = istioIoApiNetworkingV1alpha3TrafficPolicy;
        this.istioIoApiNetworkingV1alpha3TrafficPolicyPortTrafficPolicy = istioIoApiNetworkingV1alpha3TrafficPolicyPortTrafficPolicy;
        this.istioIoApiNetworkingV1alpha3VirtualService = istioIoApiNetworkingV1alpha3VirtualService;
        this.istioIoApiNetworkingV1alpha3WorkloadEntry = istioIoApiNetworkingV1alpha3WorkloadEntry;
        this.istioIoApiNetworkingV1alpha3WorkloadSelector = istioIoApiNetworkingV1alpha3WorkloadSelector;
        this.istioIoApiNetworkingV1alpha3IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes = istioIoApiNetworkingV1alpha3IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes;
        this.istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionAbortErrorType = istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionAbortErrorType;
        this.istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionDelayHttpDelayType = istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionDelayHttpDelayType;
        this.istioIoApiNetworkingV1alpha3IsHTTPRedirectRedirectPort = istioIoApiNetworkingV1alpha3IsHTTPRedirectRedirectPort;
        this.istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsConsistentHashLBHashKey = istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsConsistentHashLBHashKey;
        this.istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsLbPolicy = istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsLbPolicy;
        this.istioIoApiNetworkingV1alpha3IsStringMatchMatchType = istioIoApiNetworkingV1alpha3IsStringMatchMatchType;
        this.istioIoClientGoPkgApisNetworkingV1alpha3DestinationRule = istioIoClientGoPkgApisNetworkingV1alpha3DestinationRule;
        this.istioIoClientGoPkgApisNetworkingV1alpha3DestinationRuleList = istioIoClientGoPkgApisNetworkingV1alpha3DestinationRuleList;
        this.istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilter = istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilter;
        this.istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilterList = istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilterList;
        this.istioIoClientGoPkgApisNetworkingV1alpha3Gateway = istioIoClientGoPkgApisNetworkingV1alpha3Gateway;
        this.istioIoClientGoPkgApisNetworkingV1alpha3GatewayList = istioIoClientGoPkgApisNetworkingV1alpha3GatewayList;
        this.istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntry = istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntry;
        this.istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntryList = istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntryList;
        this.istioIoClientGoPkgApisNetworkingV1alpha3Sidecar = istioIoClientGoPkgApisNetworkingV1alpha3Sidecar;
        this.istioIoClientGoPkgApisNetworkingV1alpha3SidecarList = istioIoClientGoPkgApisNetworkingV1alpha3SidecarList;
        this.istioIoClientGoPkgApisNetworkingV1alpha3VirtualService = istioIoClientGoPkgApisNetworkingV1alpha3VirtualService;
        this.istioIoClientGoPkgApisNetworkingV1alpha3VirtualServiceList = istioIoClientGoPkgApisNetworkingV1alpha3VirtualServiceList;
        this.istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntry = istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntry;
        this.istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntryList = istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntryList;
    }

    @JsonProperty("github_com_gogo_protobuf_types_ListValue")
    public ListValue getGithubComGogoProtobufTypesListValue() {
        return githubComGogoProtobufTypesListValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_ListValue")
    public void setGithubComGogoProtobufTypesListValue(ListValue githubComGogoProtobufTypesListValue) {
        this.githubComGogoProtobufTypesListValue = githubComGogoProtobufTypesListValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_NullValue")
    public NullValue getGithubComGogoProtobufTypesNullValue() {
        return githubComGogoProtobufTypesNullValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_NullValue")
    public void setGithubComGogoProtobufTypesNullValue(NullValue githubComGogoProtobufTypesNullValue) {
        this.githubComGogoProtobufTypesNullValue = githubComGogoProtobufTypesNullValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value")
    public Value getGithubComGogoProtobufTypesValue() {
        return githubComGogoProtobufTypesValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value")
    public void setGithubComGogoProtobufTypesValue(Value githubComGogoProtobufTypesValue) {
        this.githubComGogoProtobufTypesValue = githubComGogoProtobufTypesValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value_BoolValue")
    public ValueBoolValue getGithubComGogoProtobufTypesValueBoolValue() {
        return githubComGogoProtobufTypesValueBoolValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value_BoolValue")
    public void setGithubComGogoProtobufTypesValueBoolValue(ValueBoolValue githubComGogoProtobufTypesValueBoolValue) {
        this.githubComGogoProtobufTypesValueBoolValue = githubComGogoProtobufTypesValueBoolValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value_ListValue")
    public ValueListValue getGithubComGogoProtobufTypesValueListValue() {
        return githubComGogoProtobufTypesValueListValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value_ListValue")
    public void setGithubComGogoProtobufTypesValueListValue(ValueListValue githubComGogoProtobufTypesValueListValue) {
        this.githubComGogoProtobufTypesValueListValue = githubComGogoProtobufTypesValueListValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value_NullValue")
    public ValueNullValue getGithubComGogoProtobufTypesValueNullValue() {
        return githubComGogoProtobufTypesValueNullValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value_NullValue")
    public void setGithubComGogoProtobufTypesValueNullValue(ValueNullValue githubComGogoProtobufTypesValueNullValue) {
        this.githubComGogoProtobufTypesValueNullValue = githubComGogoProtobufTypesValueNullValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value_NumberValue")
    public ValueNumberValue getGithubComGogoProtobufTypesValueNumberValue() {
        return githubComGogoProtobufTypesValueNumberValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value_NumberValue")
    public void setGithubComGogoProtobufTypesValueNumberValue(ValueNumberValue githubComGogoProtobufTypesValueNumberValue) {
        this.githubComGogoProtobufTypesValueNumberValue = githubComGogoProtobufTypesValueNumberValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value_StringValue")
    public ValueStringValue getGithubComGogoProtobufTypesValueStringValue() {
        return githubComGogoProtobufTypesValueStringValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value_StringValue")
    public void setGithubComGogoProtobufTypesValueStringValue(ValueStringValue githubComGogoProtobufTypesValueStringValue) {
        this.githubComGogoProtobufTypesValueStringValue = githubComGogoProtobufTypesValueStringValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value_StructValue")
    public ValueStructValue getGithubComGogoProtobufTypesValueStructValue() {
        return githubComGogoProtobufTypesValueStructValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_Value_StructValue")
    public void setGithubComGogoProtobufTypesValueStructValue(ValueStructValue githubComGogoProtobufTypesValueStructValue) {
        this.githubComGogoProtobufTypesValueStructValue = githubComGogoProtobufTypesValueStructValue;
    }

    @JsonProperty("github_com_gogo_protobuf_types_isValue_Kind")
    public IsValueKind getGithubComGogoProtobufTypesIsValueKind() {
        return githubComGogoProtobufTypesIsValueKind;
    }

    @JsonProperty("github_com_gogo_protobuf_types_isValue_Kind")
    public void setGithubComGogoProtobufTypesIsValueKind(IsValueKind githubComGogoProtobufTypesIsValueKind) {
        this.githubComGogoProtobufTypesIsValueKind = githubComGogoProtobufTypesIsValueKind;
    }

    @JsonProperty("istio_io_api_analysis_v1alpha1_AnalysisMessageBase")
    public AnalysisMessageBase getIstioIoApiAnalysisV1alpha1AnalysisMessageBase() {
        return istioIoApiAnalysisV1alpha1AnalysisMessageBase;
    }

    @JsonProperty("istio_io_api_analysis_v1alpha1_AnalysisMessageBase")
    public void setIstioIoApiAnalysisV1alpha1AnalysisMessageBase(AnalysisMessageBase istioIoApiAnalysisV1alpha1AnalysisMessageBase) {
        this.istioIoApiAnalysisV1alpha1AnalysisMessageBase = istioIoApiAnalysisV1alpha1AnalysisMessageBase;
    }

    @JsonProperty("istio_io_api_analysis_v1alpha1_AnalysisMessageBase_Level")
    public AnalysisMessageBaseLevel getIstioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel() {
        return istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel;
    }

    @JsonProperty("istio_io_api_analysis_v1alpha1_AnalysisMessageBase_Level")
    public void setIstioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel(AnalysisMessageBaseLevel istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel) {
        this.istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel = istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel;
    }

    @JsonProperty("istio_io_api_analysis_v1alpha1_AnalysisMessageBase_Type")
    public AnalysisMessageBaseType getIstioIoApiAnalysisV1alpha1AnalysisMessageBaseType() {
        return istioIoApiAnalysisV1alpha1AnalysisMessageBaseType;
    }

    @JsonProperty("istio_io_api_analysis_v1alpha1_AnalysisMessageBase_Type")
    public void setIstioIoApiAnalysisV1alpha1AnalysisMessageBaseType(AnalysisMessageBaseType istioIoApiAnalysisV1alpha1AnalysisMessageBaseType) {
        this.istioIoApiAnalysisV1alpha1AnalysisMessageBaseType = istioIoApiAnalysisV1alpha1AnalysisMessageBaseType;
    }

    @JsonProperty("istio_io_api_meta_v1alpha1_IstioCondition")
    public IstioCondition getIstioIoApiMetaV1alpha1IstioCondition() {
        return istioIoApiMetaV1alpha1IstioCondition;
    }

    @JsonProperty("istio_io_api_meta_v1alpha1_IstioCondition")
    public void setIstioIoApiMetaV1alpha1IstioCondition(IstioCondition istioIoApiMetaV1alpha1IstioCondition) {
        this.istioIoApiMetaV1alpha1IstioCondition = istioIoApiMetaV1alpha1IstioCondition;
    }

    @JsonProperty("istio_io_api_meta_v1alpha1_IstioStatus")
    public IstioStatus getIstioIoApiMetaV1alpha1IstioStatus() {
        return istioIoApiMetaV1alpha1IstioStatus;
    }

    @JsonProperty("istio_io_api_meta_v1alpha1_IstioStatus")
    public void setIstioIoApiMetaV1alpha1IstioStatus(IstioStatus istioIoApiMetaV1alpha1IstioStatus) {
        this.istioIoApiMetaV1alpha1IstioStatus = istioIoApiMetaV1alpha1IstioStatus;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_CaptureMode")
    public CaptureMode getIstioIoApiNetworkingV1alpha3CaptureMode() {
        return istioIoApiNetworkingV1alpha3CaptureMode;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_CaptureMode")
    public void setIstioIoApiNetworkingV1alpha3CaptureMode(CaptureMode istioIoApiNetworkingV1alpha3CaptureMode) {
        this.istioIoApiNetworkingV1alpha3CaptureMode = istioIoApiNetworkingV1alpha3CaptureMode;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ClientTLSSettings")
    public ClientTLSSettings getIstioIoApiNetworkingV1alpha3ClientTLSSettings() {
        return istioIoApiNetworkingV1alpha3ClientTLSSettings;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ClientTLSSettings")
    public void setIstioIoApiNetworkingV1alpha3ClientTLSSettings(ClientTLSSettings istioIoApiNetworkingV1alpha3ClientTLSSettings) {
        this.istioIoApiNetworkingV1alpha3ClientTLSSettings = istioIoApiNetworkingV1alpha3ClientTLSSettings;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ClientTLSSettings_TLSmode")
    public ClientTLSSettingsTLSmode getIstioIoApiNetworkingV1alpha3ClientTLSSettingsTLSmode() {
        return istioIoApiNetworkingV1alpha3ClientTLSSettingsTLSmode;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ClientTLSSettings_TLSmode")
    public void setIstioIoApiNetworkingV1alpha3ClientTLSSettingsTLSmode(ClientTLSSettingsTLSmode istioIoApiNetworkingV1alpha3ClientTLSSettingsTLSmode) {
        this.istioIoApiNetworkingV1alpha3ClientTLSSettingsTLSmode = istioIoApiNetworkingV1alpha3ClientTLSSettingsTLSmode;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings")
    public ConnectionPoolSettings getIstioIoApiNetworkingV1alpha3ConnectionPoolSettings() {
        return istioIoApiNetworkingV1alpha3ConnectionPoolSettings;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings")
    public void setIstioIoApiNetworkingV1alpha3ConnectionPoolSettings(ConnectionPoolSettings istioIoApiNetworkingV1alpha3ConnectionPoolSettings) {
        this.istioIoApiNetworkingV1alpha3ConnectionPoolSettings = istioIoApiNetworkingV1alpha3ConnectionPoolSettings;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings_HTTPSettings")
    public ConnectionPoolSettingsHTTPSettings getIstioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettings() {
        return istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettings;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings_HTTPSettings")
    public void setIstioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettings(ConnectionPoolSettingsHTTPSettings istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettings) {
        this.istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettings = istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettings;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings_HTTPSettings_H2UpgradePolicy")
    public ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy getIstioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy() {
        return istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings_HTTPSettings_H2UpgradePolicy")
    public void setIstioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy(ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy) {
        this.istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy = istioIoApiNetworkingV1alpha3ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings_TCPSettings")
    public ConnectionPoolSettingsTCPSettings getIstioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettings() {
        return istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettings;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings_TCPSettings")
    public void setIstioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettings(ConnectionPoolSettingsTCPSettings istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettings) {
        this.istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettings = istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettings;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings_TCPSettings_TcpKeepalive")
    public ConnectionPoolSettingsTCPSettingsTcpKeepalive getIstioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettingsTcpKeepalive() {
        return istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettingsTcpKeepalive;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ConnectionPoolSettings_TCPSettings_TcpKeepalive")
    public void setIstioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettingsTcpKeepalive(ConnectionPoolSettingsTCPSettingsTcpKeepalive istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettingsTcpKeepalive) {
        this.istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettingsTcpKeepalive = istioIoApiNetworkingV1alpha3ConnectionPoolSettingsTCPSettingsTcpKeepalive;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Delegate")
    public Delegate getIstioIoApiNetworkingV1alpha3Delegate() {
        return istioIoApiNetworkingV1alpha3Delegate;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Delegate")
    public void setIstioIoApiNetworkingV1alpha3Delegate(Delegate istioIoApiNetworkingV1alpha3Delegate) {
        this.istioIoApiNetworkingV1alpha3Delegate = istioIoApiNetworkingV1alpha3Delegate;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Destination")
    public Destination getIstioIoApiNetworkingV1alpha3Destination() {
        return istioIoApiNetworkingV1alpha3Destination;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Destination")
    public void setIstioIoApiNetworkingV1alpha3Destination(Destination istioIoApiNetworkingV1alpha3Destination) {
        this.istioIoApiNetworkingV1alpha3Destination = istioIoApiNetworkingV1alpha3Destination;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_DestinationRule")
    public DestinationRuleSpec getIstioIoApiNetworkingV1alpha3DestinationRule() {
        return istioIoApiNetworkingV1alpha3DestinationRule;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_DestinationRule")
    public void setIstioIoApiNetworkingV1alpha3DestinationRule(DestinationRuleSpec istioIoApiNetworkingV1alpha3DestinationRule) {
        this.istioIoApiNetworkingV1alpha3DestinationRule = istioIoApiNetworkingV1alpha3DestinationRule;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter")
    public EnvoyFilterSpec getIstioIoApiNetworkingV1alpha3EnvoyFilter() {
        return istioIoApiNetworkingV1alpha3EnvoyFilter;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilter(EnvoyFilterSpec istioIoApiNetworkingV1alpha3EnvoyFilter) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilter = istioIoApiNetworkingV1alpha3EnvoyFilter;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ApplyTo")
    public EnvoyFilterApplyTo getIstioIoApiNetworkingV1alpha3EnvoyFilterApplyTo() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterApplyTo;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ApplyTo")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterApplyTo(EnvoyFilterApplyTo istioIoApiNetworkingV1alpha3EnvoyFilterApplyTo) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterApplyTo = istioIoApiNetworkingV1alpha3EnvoyFilterApplyTo;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ClusterMatch")
    public EnvoyFilterClusterMatch getIstioIoApiNetworkingV1alpha3EnvoyFilterClusterMatch() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterClusterMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ClusterMatch")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterClusterMatch(EnvoyFilterClusterMatch istioIoApiNetworkingV1alpha3EnvoyFilterClusterMatch) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterClusterMatch = istioIoApiNetworkingV1alpha3EnvoyFilterClusterMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch")
    public EnvoyFilterEnvoyConfigObjectMatch getIstioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatch() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatch(EnvoyFilterEnvoyConfigObjectMatch istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatch) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatch = istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch_Cluster")
    public EnvoyFilterEnvoyConfigObjectMatchCluster getIstioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchCluster() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchCluster;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch_Cluster")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchCluster(EnvoyFilterEnvoyConfigObjectMatchCluster istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchCluster) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchCluster = istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchCluster;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch_Listener")
    public EnvoyFilterEnvoyConfigObjectMatchListener getIstioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchListener() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchListener;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch_Listener")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchListener(EnvoyFilterEnvoyConfigObjectMatchListener istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchListener) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchListener = istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchListener;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch_RouteConfiguration")
    public EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration getIstioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectMatch_RouteConfiguration")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration(EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration = istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectMatchRouteConfiguration;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectPatch")
    public EnvoyFilterEnvoyConfigObjectPatch getIstioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectPatch() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectPatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_EnvoyConfigObjectPatch")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectPatch(EnvoyFilterEnvoyConfigObjectPatch istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectPatch) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectPatch = istioIoApiNetworkingV1alpha3EnvoyFilterEnvoyConfigObjectPatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch")
    public EnvoyFilterListenerMatch getIstioIoApiNetworkingV1alpha3EnvoyFilterListenerMatch() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterListenerMatch(EnvoyFilterListenerMatch istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatch) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatch = istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch_FilterChainMatch")
    public EnvoyFilterListenerMatchFilterChainMatch getIstioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterChainMatch() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterChainMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch_FilterChainMatch")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterChainMatch(EnvoyFilterListenerMatchFilterChainMatch istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterChainMatch) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterChainMatch = istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterChainMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch_FilterMatch")
    public EnvoyFilterListenerMatchFilterMatch getIstioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterMatch() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch_FilterMatch")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterMatch(EnvoyFilterListenerMatchFilterMatch istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterMatch) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterMatch = istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchFilterMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch_SubFilterMatch")
    public EnvoyFilterListenerMatchSubFilterMatch getIstioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchSubFilterMatch() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchSubFilterMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ListenerMatch_SubFilterMatch")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchSubFilterMatch(EnvoyFilterListenerMatchSubFilterMatch istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchSubFilterMatch) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchSubFilterMatch = istioIoApiNetworkingV1alpha3EnvoyFilterListenerMatchSubFilterMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_Patch")
    public EnvoyFilterPatch getIstioIoApiNetworkingV1alpha3EnvoyFilterPatch() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterPatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_Patch")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterPatch(EnvoyFilterPatch istioIoApiNetworkingV1alpha3EnvoyFilterPatch) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterPatch = istioIoApiNetworkingV1alpha3EnvoyFilterPatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_PatchContext")
    public EnvoyFilterPatchContext getIstioIoApiNetworkingV1alpha3EnvoyFilterPatchContext() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterPatchContext;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_PatchContext")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterPatchContext(EnvoyFilterPatchContext istioIoApiNetworkingV1alpha3EnvoyFilterPatchContext) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterPatchContext = istioIoApiNetworkingV1alpha3EnvoyFilterPatchContext;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_Patch_FilterClass")
    public EnvoyFilterPatchFilterClass getIstioIoApiNetworkingV1alpha3EnvoyFilterPatchFilterClass() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterPatchFilterClass;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_Patch_FilterClass")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterPatchFilterClass(EnvoyFilterPatchFilterClass istioIoApiNetworkingV1alpha3EnvoyFilterPatchFilterClass) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterPatchFilterClass = istioIoApiNetworkingV1alpha3EnvoyFilterPatchFilterClass;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_Patch_Operation")
    public EnvoyFilterPatchOperation getIstioIoApiNetworkingV1alpha3EnvoyFilterPatchOperation() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterPatchOperation;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_Patch_Operation")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterPatchOperation(EnvoyFilterPatchOperation istioIoApiNetworkingV1alpha3EnvoyFilterPatchOperation) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterPatchOperation = istioIoApiNetworkingV1alpha3EnvoyFilterPatchOperation;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ProxyMatch")
    public EnvoyFilterProxyMatch getIstioIoApiNetworkingV1alpha3EnvoyFilterProxyMatch() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterProxyMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_ProxyMatch")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterProxyMatch(EnvoyFilterProxyMatch istioIoApiNetworkingV1alpha3EnvoyFilterProxyMatch) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterProxyMatch = istioIoApiNetworkingV1alpha3EnvoyFilterProxyMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch")
    public EnvoyFilterRouteConfigurationMatch getIstioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatch() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatch(EnvoyFilterRouteConfigurationMatch istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatch) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatch = istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch_RouteMatch")
    public EnvoyFilterRouteConfigurationMatchRouteMatch getIstioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatch() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch_RouteMatch")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatch(EnvoyFilterRouteConfigurationMatchRouteMatch istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatch) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatch = istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch_RouteMatch_Action")
    public EnvoyFilterRouteConfigurationMatchRouteMatchAction getIstioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatchAction() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatchAction;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch_RouteMatch_Action")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatchAction(EnvoyFilterRouteConfigurationMatchRouteMatchAction istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatchAction) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatchAction = istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchRouteMatchAction;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch_VirtualHostMatch")
    public EnvoyFilterRouteConfigurationMatchVirtualHostMatch getIstioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchVirtualHostMatch() {
        return istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchVirtualHostMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_EnvoyFilter_RouteConfigurationMatch_VirtualHostMatch")
    public void setIstioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchVirtualHostMatch(EnvoyFilterRouteConfigurationMatchVirtualHostMatch istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchVirtualHostMatch) {
        this.istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchVirtualHostMatch = istioIoApiNetworkingV1alpha3EnvoyFilterRouteConfigurationMatchVirtualHostMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Gateway")
    public GatewaySpec getIstioIoApiNetworkingV1alpha3Gateway() {
        return istioIoApiNetworkingV1alpha3Gateway;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Gateway")
    public void setIstioIoApiNetworkingV1alpha3Gateway(GatewaySpec istioIoApiNetworkingV1alpha3Gateway) {
        this.istioIoApiNetworkingV1alpha3Gateway = istioIoApiNetworkingV1alpha3Gateway;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection")
    public HTTPFaultInjection getIstioIoApiNetworkingV1alpha3HTTPFaultInjection() {
        return istioIoApiNetworkingV1alpha3HTTPFaultInjection;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection")
    public void setIstioIoApiNetworkingV1alpha3HTTPFaultInjection(HTTPFaultInjection istioIoApiNetworkingV1alpha3HTTPFaultInjection) {
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjection = istioIoApiNetworkingV1alpha3HTTPFaultInjection;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort")
    public HTTPFaultInjectionAbort getIstioIoApiNetworkingV1alpha3HTTPFaultInjectionAbort() {
        return istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbort;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort")
    public void setIstioIoApiNetworkingV1alpha3HTTPFaultInjectionAbort(HTTPFaultInjectionAbort istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbort) {
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbort = istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbort;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort_GrpcStatus")
    public HTTPFaultInjectionAbortGrpcStatus getIstioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortGrpcStatus() {
        return istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortGrpcStatus;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort_GrpcStatus")
    public void setIstioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortGrpcStatus(HTTPFaultInjectionAbortGrpcStatus istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortGrpcStatus) {
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortGrpcStatus = istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortGrpcStatus;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort_Http2Error")
    public HTTPFaultInjectionAbortHttp2Error getIstioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttp2Error() {
        return istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttp2Error;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort_Http2Error")
    public void setIstioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttp2Error(HTTPFaultInjectionAbortHttp2Error istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttp2Error) {
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttp2Error = istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttp2Error;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort_HttpStatus")
    public HTTPFaultInjectionAbortHttpStatus getIstioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttpStatus() {
        return istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttpStatus;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Abort_HttpStatus")
    public void setIstioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttpStatus(HTTPFaultInjectionAbortHttpStatus istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttpStatus) {
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttpStatus = istioIoApiNetworkingV1alpha3HTTPFaultInjectionAbortHttpStatus;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Delay")
    public HTTPFaultInjectionDelay getIstioIoApiNetworkingV1alpha3HTTPFaultInjectionDelay() {
        return istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelay;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Delay")
    public void setIstioIoApiNetworkingV1alpha3HTTPFaultInjectionDelay(HTTPFaultInjectionDelay istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelay) {
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelay = istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelay;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Delay_ExponentialDelay")
    public HTTPFaultInjectionDelayExponentialDelay getIstioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayExponentialDelay() {
        return istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayExponentialDelay;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Delay_ExponentialDelay")
    public void setIstioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayExponentialDelay(HTTPFaultInjectionDelayExponentialDelay istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayExponentialDelay) {
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayExponentialDelay = istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayExponentialDelay;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Delay_FixedDelay")
    public HTTPFaultInjectionDelayFixedDelay getIstioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayFixedDelay() {
        return istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayFixedDelay;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPFaultInjection_Delay_FixedDelay")
    public void setIstioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayFixedDelay(HTTPFaultInjectionDelayFixedDelay istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayFixedDelay) {
        this.istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayFixedDelay = istioIoApiNetworkingV1alpha3HTTPFaultInjectionDelayFixedDelay;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPMatchRequest")
    public HTTPMatchRequest getIstioIoApiNetworkingV1alpha3HTTPMatchRequest() {
        return istioIoApiNetworkingV1alpha3HTTPMatchRequest;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPMatchRequest")
    public void setIstioIoApiNetworkingV1alpha3HTTPMatchRequest(HTTPMatchRequest istioIoApiNetworkingV1alpha3HTTPMatchRequest) {
        this.istioIoApiNetworkingV1alpha3HTTPMatchRequest = istioIoApiNetworkingV1alpha3HTTPMatchRequest;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRedirect")
    public HTTPRedirect getIstioIoApiNetworkingV1alpha3HTTPRedirect() {
        return istioIoApiNetworkingV1alpha3HTTPRedirect;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRedirect")
    public void setIstioIoApiNetworkingV1alpha3HTTPRedirect(HTTPRedirect istioIoApiNetworkingV1alpha3HTTPRedirect) {
        this.istioIoApiNetworkingV1alpha3HTTPRedirect = istioIoApiNetworkingV1alpha3HTTPRedirect;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRedirect_DerivePort")
    public HTTPRedirectDerivePort getIstioIoApiNetworkingV1alpha3HTTPRedirectDerivePort() {
        return istioIoApiNetworkingV1alpha3HTTPRedirectDerivePort;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRedirect_DerivePort")
    public void setIstioIoApiNetworkingV1alpha3HTTPRedirectDerivePort(HTTPRedirectDerivePort istioIoApiNetworkingV1alpha3HTTPRedirectDerivePort) {
        this.istioIoApiNetworkingV1alpha3HTTPRedirectDerivePort = istioIoApiNetworkingV1alpha3HTTPRedirectDerivePort;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRedirect_Port")
    public HTTPRedirectPort getIstioIoApiNetworkingV1alpha3HTTPRedirectPort() {
        return istioIoApiNetworkingV1alpha3HTTPRedirectPort;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRedirect_Port")
    public void setIstioIoApiNetworkingV1alpha3HTTPRedirectPort(HTTPRedirectPort istioIoApiNetworkingV1alpha3HTTPRedirectPort) {
        this.istioIoApiNetworkingV1alpha3HTTPRedirectPort = istioIoApiNetworkingV1alpha3HTTPRedirectPort;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRedirect_RedirectPortSelection")
    public HTTPRedirectRedirectPortSelection getIstioIoApiNetworkingV1alpha3HTTPRedirectRedirectPortSelection() {
        return istioIoApiNetworkingV1alpha3HTTPRedirectRedirectPortSelection;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRedirect_RedirectPortSelection")
    public void setIstioIoApiNetworkingV1alpha3HTTPRedirectRedirectPortSelection(HTTPRedirectRedirectPortSelection istioIoApiNetworkingV1alpha3HTTPRedirectRedirectPortSelection) {
        this.istioIoApiNetworkingV1alpha3HTTPRedirectRedirectPortSelection = istioIoApiNetworkingV1alpha3HTTPRedirectRedirectPortSelection;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRetry")
    public HTTPRetry getIstioIoApiNetworkingV1alpha3HTTPRetry() {
        return istioIoApiNetworkingV1alpha3HTTPRetry;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRetry")
    public void setIstioIoApiNetworkingV1alpha3HTTPRetry(HTTPRetry istioIoApiNetworkingV1alpha3HTTPRetry) {
        this.istioIoApiNetworkingV1alpha3HTTPRetry = istioIoApiNetworkingV1alpha3HTTPRetry;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRewrite")
    public HTTPRewrite getIstioIoApiNetworkingV1alpha3HTTPRewrite() {
        return istioIoApiNetworkingV1alpha3HTTPRewrite;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRewrite")
    public void setIstioIoApiNetworkingV1alpha3HTTPRewrite(HTTPRewrite istioIoApiNetworkingV1alpha3HTTPRewrite) {
        this.istioIoApiNetworkingV1alpha3HTTPRewrite = istioIoApiNetworkingV1alpha3HTTPRewrite;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRoute")
    public HTTPRoute getIstioIoApiNetworkingV1alpha3HTTPRoute() {
        return istioIoApiNetworkingV1alpha3HTTPRoute;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRoute")
    public void setIstioIoApiNetworkingV1alpha3HTTPRoute(HTTPRoute istioIoApiNetworkingV1alpha3HTTPRoute) {
        this.istioIoApiNetworkingV1alpha3HTTPRoute = istioIoApiNetworkingV1alpha3HTTPRoute;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRouteDestination")
    public HTTPRouteDestination getIstioIoApiNetworkingV1alpha3HTTPRouteDestination() {
        return istioIoApiNetworkingV1alpha3HTTPRouteDestination;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_HTTPRouteDestination")
    public void setIstioIoApiNetworkingV1alpha3HTTPRouteDestination(HTTPRouteDestination istioIoApiNetworkingV1alpha3HTTPRouteDestination) {
        this.istioIoApiNetworkingV1alpha3HTTPRouteDestination = istioIoApiNetworkingV1alpha3HTTPRouteDestination;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Headers")
    public Headers getIstioIoApiNetworkingV1alpha3Headers() {
        return istioIoApiNetworkingV1alpha3Headers;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Headers")
    public void setIstioIoApiNetworkingV1alpha3Headers(Headers istioIoApiNetworkingV1alpha3Headers) {
        this.istioIoApiNetworkingV1alpha3Headers = istioIoApiNetworkingV1alpha3Headers;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Headers_HeaderOperations")
    public HeadersHeaderOperations getIstioIoApiNetworkingV1alpha3HeadersHeaderOperations() {
        return istioIoApiNetworkingV1alpha3HeadersHeaderOperations;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Headers_HeaderOperations")
    public void setIstioIoApiNetworkingV1alpha3HeadersHeaderOperations(HeadersHeaderOperations istioIoApiNetworkingV1alpha3HeadersHeaderOperations) {
        this.istioIoApiNetworkingV1alpha3HeadersHeaderOperations = istioIoApiNetworkingV1alpha3HeadersHeaderOperations;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_IstioEgressListener")
    public IstioEgressListener getIstioIoApiNetworkingV1alpha3IstioEgressListener() {
        return istioIoApiNetworkingV1alpha3IstioEgressListener;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_IstioEgressListener")
    public void setIstioIoApiNetworkingV1alpha3IstioEgressListener(IstioEgressListener istioIoApiNetworkingV1alpha3IstioEgressListener) {
        this.istioIoApiNetworkingV1alpha3IstioEgressListener = istioIoApiNetworkingV1alpha3IstioEgressListener;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_IstioIngressListener")
    public IstioIngressListener getIstioIoApiNetworkingV1alpha3IstioIngressListener() {
        return istioIoApiNetworkingV1alpha3IstioIngressListener;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_IstioIngressListener")
    public void setIstioIoApiNetworkingV1alpha3IstioIngressListener(IstioIngressListener istioIoApiNetworkingV1alpha3IstioIngressListener) {
        this.istioIoApiNetworkingV1alpha3IstioIngressListener = istioIoApiNetworkingV1alpha3IstioIngressListener;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_L4MatchAttributes")
    public L4MatchAttributes getIstioIoApiNetworkingV1alpha3L4MatchAttributes() {
        return istioIoApiNetworkingV1alpha3L4MatchAttributes;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_L4MatchAttributes")
    public void setIstioIoApiNetworkingV1alpha3L4MatchAttributes(L4MatchAttributes istioIoApiNetworkingV1alpha3L4MatchAttributes) {
        this.istioIoApiNetworkingV1alpha3L4MatchAttributes = istioIoApiNetworkingV1alpha3L4MatchAttributes;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings")
    public LoadBalancerSettings getIstioIoApiNetworkingV1alpha3LoadBalancerSettings() {
        return istioIoApiNetworkingV1alpha3LoadBalancerSettings;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings")
    public void setIstioIoApiNetworkingV1alpha3LoadBalancerSettings(LoadBalancerSettings istioIoApiNetworkingV1alpha3LoadBalancerSettings) {
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettings = istioIoApiNetworkingV1alpha3LoadBalancerSettings;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHash")
    public LoadBalancerSettingsConsistentHash getIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHash() {
        return istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHash;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHash")
    public void setIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHash(LoadBalancerSettingsConsistentHash istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHash) {
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHash = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHash;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB")
    public LoadBalancerSettingsConsistentHashLB getIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLB() {
        return istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLB;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB")
    public void setIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLB(LoadBalancerSettingsConsistentHashLB istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLB) {
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLB = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLB;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HTTPCookie")
    public LoadBalancerSettingsConsistentHashLBHttpCookieValue getIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHTTPCookie() {
        return istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHTTPCookie;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HTTPCookie")
    public void setIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHTTPCookie(LoadBalancerSettingsConsistentHashLBHttpCookieValue istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHTTPCookie) {
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHTTPCookie = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHTTPCookie;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HttpCookie")
    public LoadBalancerSettingsConsistentHashLBHttpCookie getIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpCookie() {
        return istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpCookie;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HttpCookie")
    public void setIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpCookie(LoadBalancerSettingsConsistentHashLBHttpCookie istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpCookie) {
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpCookie = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpCookie;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HttpHeaderName")
    public LoadBalancerSettingsConsistentHashLBHttpHeaderName getIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpHeaderName() {
        return istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpHeaderName;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HttpHeaderName")
    public void setIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpHeaderName(LoadBalancerSettingsConsistentHashLBHttpHeaderName istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpHeaderName) {
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpHeaderName = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpHeaderName;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HttpQueryParameterName")
    public LoadBalancerSettingsConsistentHashLBHttpQueryParameterName getIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpQueryParameterName() {
        return istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpQueryParameterName;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_HttpQueryParameterName")
    public void setIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpQueryParameterName(LoadBalancerSettingsConsistentHashLBHttpQueryParameterName istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpQueryParameterName) {
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpQueryParameterName = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBHttpQueryParameterName;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_UseSourceIp")
    public LoadBalancerSettingsConsistentHashLBUseSourceIp getIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBUseSourceIp() {
        return istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBUseSourceIp;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_ConsistentHashLB_UseSourceIp")
    public void setIstioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBUseSourceIp(LoadBalancerSettingsConsistentHashLBUseSourceIp istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBUseSourceIp) {
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBUseSourceIp = istioIoApiNetworkingV1alpha3LoadBalancerSettingsConsistentHashLBUseSourceIp;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_Simple")
    public LoadBalancerSettingsSimple getIstioIoApiNetworkingV1alpha3LoadBalancerSettingsSimple() {
        return istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimple;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_Simple")
    public void setIstioIoApiNetworkingV1alpha3LoadBalancerSettingsSimple(LoadBalancerSettingsSimple istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimple) {
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimple = istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimple;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_SimpleLB")
    public LoadBalancerSettingsSimpleLB getIstioIoApiNetworkingV1alpha3LoadBalancerSettingsSimpleLB() {
        return istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimpleLB;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LoadBalancerSettings_SimpleLB")
    public void setIstioIoApiNetworkingV1alpha3LoadBalancerSettingsSimpleLB(LoadBalancerSettingsSimpleLB istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimpleLB) {
        this.istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimpleLB = istioIoApiNetworkingV1alpha3LoadBalancerSettingsSimpleLB;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LocalityLoadBalancerSetting")
    public LocalityLoadBalancerSetting getIstioIoApiNetworkingV1alpha3LocalityLoadBalancerSetting() {
        return istioIoApiNetworkingV1alpha3LocalityLoadBalancerSetting;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LocalityLoadBalancerSetting")
    public void setIstioIoApiNetworkingV1alpha3LocalityLoadBalancerSetting(LocalityLoadBalancerSetting istioIoApiNetworkingV1alpha3LocalityLoadBalancerSetting) {
        this.istioIoApiNetworkingV1alpha3LocalityLoadBalancerSetting = istioIoApiNetworkingV1alpha3LocalityLoadBalancerSetting;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LocalityLoadBalancerSetting_Distribute")
    public LocalityLoadBalancerSettingDistribute getIstioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingDistribute() {
        return istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingDistribute;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LocalityLoadBalancerSetting_Distribute")
    public void setIstioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingDistribute(LocalityLoadBalancerSettingDistribute istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingDistribute) {
        this.istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingDistribute = istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingDistribute;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LocalityLoadBalancerSetting_Failover")
    public LocalityLoadBalancerSettingFailover getIstioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingFailover() {
        return istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingFailover;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_LocalityLoadBalancerSetting_Failover")
    public void setIstioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingFailover(LocalityLoadBalancerSettingFailover istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingFailover) {
        this.istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingFailover = istioIoApiNetworkingV1alpha3LocalityLoadBalancerSettingFailover;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_OutboundTrafficPolicy")
    public OutboundTrafficPolicy getIstioIoApiNetworkingV1alpha3OutboundTrafficPolicy() {
        return istioIoApiNetworkingV1alpha3OutboundTrafficPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_OutboundTrafficPolicy")
    public void setIstioIoApiNetworkingV1alpha3OutboundTrafficPolicy(OutboundTrafficPolicy istioIoApiNetworkingV1alpha3OutboundTrafficPolicy) {
        this.istioIoApiNetworkingV1alpha3OutboundTrafficPolicy = istioIoApiNetworkingV1alpha3OutboundTrafficPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_OutboundTrafficPolicy_Mode")
    public OutboundTrafficPolicyMode getIstioIoApiNetworkingV1alpha3OutboundTrafficPolicyMode() {
        return istioIoApiNetworkingV1alpha3OutboundTrafficPolicyMode;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_OutboundTrafficPolicy_Mode")
    public void setIstioIoApiNetworkingV1alpha3OutboundTrafficPolicyMode(OutboundTrafficPolicyMode istioIoApiNetworkingV1alpha3OutboundTrafficPolicyMode) {
        this.istioIoApiNetworkingV1alpha3OutboundTrafficPolicyMode = istioIoApiNetworkingV1alpha3OutboundTrafficPolicyMode;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_OutlierDetection")
    public OutlierDetection getIstioIoApiNetworkingV1alpha3OutlierDetection() {
        return istioIoApiNetworkingV1alpha3OutlierDetection;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_OutlierDetection")
    public void setIstioIoApiNetworkingV1alpha3OutlierDetection(OutlierDetection istioIoApiNetworkingV1alpha3OutlierDetection) {
        this.istioIoApiNetworkingV1alpha3OutlierDetection = istioIoApiNetworkingV1alpha3OutlierDetection;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Percent")
    public Percent getIstioIoApiNetworkingV1alpha3Percent() {
        return istioIoApiNetworkingV1alpha3Percent;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Percent")
    public void setIstioIoApiNetworkingV1alpha3Percent(Percent istioIoApiNetworkingV1alpha3Percent) {
        this.istioIoApiNetworkingV1alpha3Percent = istioIoApiNetworkingV1alpha3Percent;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Port")
    public Port getIstioIoApiNetworkingV1alpha3Port() {
        return istioIoApiNetworkingV1alpha3Port;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Port")
    public void setIstioIoApiNetworkingV1alpha3Port(Port istioIoApiNetworkingV1alpha3Port) {
        this.istioIoApiNetworkingV1alpha3Port = istioIoApiNetworkingV1alpha3Port;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_PortSelector")
    public PortSelector getIstioIoApiNetworkingV1alpha3PortSelector() {
        return istioIoApiNetworkingV1alpha3PortSelector;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_PortSelector")
    public void setIstioIoApiNetworkingV1alpha3PortSelector(PortSelector istioIoApiNetworkingV1alpha3PortSelector) {
        this.istioIoApiNetworkingV1alpha3PortSelector = istioIoApiNetworkingV1alpha3PortSelector;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_RouteDestination")
    public RouteDestination getIstioIoApiNetworkingV1alpha3RouteDestination() {
        return istioIoApiNetworkingV1alpha3RouteDestination;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_RouteDestination")
    public void setIstioIoApiNetworkingV1alpha3RouteDestination(RouteDestination istioIoApiNetworkingV1alpha3RouteDestination) {
        this.istioIoApiNetworkingV1alpha3RouteDestination = istioIoApiNetworkingV1alpha3RouteDestination;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Server")
    public Server getIstioIoApiNetworkingV1alpha3Server() {
        return istioIoApiNetworkingV1alpha3Server;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Server")
    public void setIstioIoApiNetworkingV1alpha3Server(Server istioIoApiNetworkingV1alpha3Server) {
        this.istioIoApiNetworkingV1alpha3Server = istioIoApiNetworkingV1alpha3Server;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ServerTLSSettings")
    public ServerTLSSettings getIstioIoApiNetworkingV1alpha3ServerTLSSettings() {
        return istioIoApiNetworkingV1alpha3ServerTLSSettings;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ServerTLSSettings")
    public void setIstioIoApiNetworkingV1alpha3ServerTLSSettings(ServerTLSSettings istioIoApiNetworkingV1alpha3ServerTLSSettings) {
        this.istioIoApiNetworkingV1alpha3ServerTLSSettings = istioIoApiNetworkingV1alpha3ServerTLSSettings;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ServerTLSSettings_TLSProtocol")
    public ServerTLSSettingsTLSProtocol getIstioIoApiNetworkingV1alpha3ServerTLSSettingsTLSProtocol() {
        return istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSProtocol;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ServerTLSSettings_TLSProtocol")
    public void setIstioIoApiNetworkingV1alpha3ServerTLSSettingsTLSProtocol(ServerTLSSettingsTLSProtocol istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSProtocol) {
        this.istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSProtocol = istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSProtocol;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ServerTLSSettings_TLSmode")
    public ServerTLSSettingsTLSmode getIstioIoApiNetworkingV1alpha3ServerTLSSettingsTLSmode() {
        return istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSmode;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ServerTLSSettings_TLSmode")
    public void setIstioIoApiNetworkingV1alpha3ServerTLSSettingsTLSmode(ServerTLSSettingsTLSmode istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSmode) {
        this.istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSmode = istioIoApiNetworkingV1alpha3ServerTLSSettingsTLSmode;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ServiceEntry")
    public ServiceEntrySpec getIstioIoApiNetworkingV1alpha3ServiceEntry() {
        return istioIoApiNetworkingV1alpha3ServiceEntry;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ServiceEntry")
    public void setIstioIoApiNetworkingV1alpha3ServiceEntry(ServiceEntrySpec istioIoApiNetworkingV1alpha3ServiceEntry) {
        this.istioIoApiNetworkingV1alpha3ServiceEntry = istioIoApiNetworkingV1alpha3ServiceEntry;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ServiceEntry_Location")
    public ServiceEntryLocation getIstioIoApiNetworkingV1alpha3ServiceEntryLocation() {
        return istioIoApiNetworkingV1alpha3ServiceEntryLocation;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ServiceEntry_Location")
    public void setIstioIoApiNetworkingV1alpha3ServiceEntryLocation(ServiceEntryLocation istioIoApiNetworkingV1alpha3ServiceEntryLocation) {
        this.istioIoApiNetworkingV1alpha3ServiceEntryLocation = istioIoApiNetworkingV1alpha3ServiceEntryLocation;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ServiceEntry_Resolution")
    public ServiceEntryResolution getIstioIoApiNetworkingV1alpha3ServiceEntryResolution() {
        return istioIoApiNetworkingV1alpha3ServiceEntryResolution;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_ServiceEntry_Resolution")
    public void setIstioIoApiNetworkingV1alpha3ServiceEntryResolution(ServiceEntryResolution istioIoApiNetworkingV1alpha3ServiceEntryResolution) {
        this.istioIoApiNetworkingV1alpha3ServiceEntryResolution = istioIoApiNetworkingV1alpha3ServiceEntryResolution;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Sidecar")
    public SidecarSpec getIstioIoApiNetworkingV1alpha3Sidecar() {
        return istioIoApiNetworkingV1alpha3Sidecar;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Sidecar")
    public void setIstioIoApiNetworkingV1alpha3Sidecar(SidecarSpec istioIoApiNetworkingV1alpha3Sidecar) {
        this.istioIoApiNetworkingV1alpha3Sidecar = istioIoApiNetworkingV1alpha3Sidecar;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_StringMatch")
    public StringMatch getIstioIoApiNetworkingV1alpha3StringMatch() {
        return istioIoApiNetworkingV1alpha3StringMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_StringMatch")
    public void setIstioIoApiNetworkingV1alpha3StringMatch(StringMatch istioIoApiNetworkingV1alpha3StringMatch) {
        this.istioIoApiNetworkingV1alpha3StringMatch = istioIoApiNetworkingV1alpha3StringMatch;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_StringMatch_Exact")
    public StringMatchExact getIstioIoApiNetworkingV1alpha3StringMatchExact() {
        return istioIoApiNetworkingV1alpha3StringMatchExact;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_StringMatch_Exact")
    public void setIstioIoApiNetworkingV1alpha3StringMatchExact(StringMatchExact istioIoApiNetworkingV1alpha3StringMatchExact) {
        this.istioIoApiNetworkingV1alpha3StringMatchExact = istioIoApiNetworkingV1alpha3StringMatchExact;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_StringMatch_Prefix")
    public StringMatchPrefix getIstioIoApiNetworkingV1alpha3StringMatchPrefix() {
        return istioIoApiNetworkingV1alpha3StringMatchPrefix;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_StringMatch_Prefix")
    public void setIstioIoApiNetworkingV1alpha3StringMatchPrefix(StringMatchPrefix istioIoApiNetworkingV1alpha3StringMatchPrefix) {
        this.istioIoApiNetworkingV1alpha3StringMatchPrefix = istioIoApiNetworkingV1alpha3StringMatchPrefix;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_StringMatch_Regex")
    public StringMatchRegex getIstioIoApiNetworkingV1alpha3StringMatchRegex() {
        return istioIoApiNetworkingV1alpha3StringMatchRegex;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_StringMatch_Regex")
    public void setIstioIoApiNetworkingV1alpha3StringMatchRegex(StringMatchRegex istioIoApiNetworkingV1alpha3StringMatchRegex) {
        this.istioIoApiNetworkingV1alpha3StringMatchRegex = istioIoApiNetworkingV1alpha3StringMatchRegex;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Subset")
    public Subset getIstioIoApiNetworkingV1alpha3Subset() {
        return istioIoApiNetworkingV1alpha3Subset;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_Subset")
    public void setIstioIoApiNetworkingV1alpha3Subset(Subset istioIoApiNetworkingV1alpha3Subset) {
        this.istioIoApiNetworkingV1alpha3Subset = istioIoApiNetworkingV1alpha3Subset;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_TCPRoute")
    public TCPRoute getIstioIoApiNetworkingV1alpha3TCPRoute() {
        return istioIoApiNetworkingV1alpha3TCPRoute;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_TCPRoute")
    public void setIstioIoApiNetworkingV1alpha3TCPRoute(TCPRoute istioIoApiNetworkingV1alpha3TCPRoute) {
        this.istioIoApiNetworkingV1alpha3TCPRoute = istioIoApiNetworkingV1alpha3TCPRoute;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_TLSMatchAttributes")
    public TLSMatchAttributes getIstioIoApiNetworkingV1alpha3TLSMatchAttributes() {
        return istioIoApiNetworkingV1alpha3TLSMatchAttributes;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_TLSMatchAttributes")
    public void setIstioIoApiNetworkingV1alpha3TLSMatchAttributes(TLSMatchAttributes istioIoApiNetworkingV1alpha3TLSMatchAttributes) {
        this.istioIoApiNetworkingV1alpha3TLSMatchAttributes = istioIoApiNetworkingV1alpha3TLSMatchAttributes;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_TLSRoute")
    public TLSRoute getIstioIoApiNetworkingV1alpha3TLSRoute() {
        return istioIoApiNetworkingV1alpha3TLSRoute;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_TLSRoute")
    public void setIstioIoApiNetworkingV1alpha3TLSRoute(TLSRoute istioIoApiNetworkingV1alpha3TLSRoute) {
        this.istioIoApiNetworkingV1alpha3TLSRoute = istioIoApiNetworkingV1alpha3TLSRoute;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_TrafficPolicy")
    public TrafficPolicy getIstioIoApiNetworkingV1alpha3TrafficPolicy() {
        return istioIoApiNetworkingV1alpha3TrafficPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_TrafficPolicy")
    public void setIstioIoApiNetworkingV1alpha3TrafficPolicy(TrafficPolicy istioIoApiNetworkingV1alpha3TrafficPolicy) {
        this.istioIoApiNetworkingV1alpha3TrafficPolicy = istioIoApiNetworkingV1alpha3TrafficPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_TrafficPolicy_PortTrafficPolicy")
    public TrafficPolicyPortTrafficPolicy getIstioIoApiNetworkingV1alpha3TrafficPolicyPortTrafficPolicy() {
        return istioIoApiNetworkingV1alpha3TrafficPolicyPortTrafficPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_TrafficPolicy_PortTrafficPolicy")
    public void setIstioIoApiNetworkingV1alpha3TrafficPolicyPortTrafficPolicy(TrafficPolicyPortTrafficPolicy istioIoApiNetworkingV1alpha3TrafficPolicyPortTrafficPolicy) {
        this.istioIoApiNetworkingV1alpha3TrafficPolicyPortTrafficPolicy = istioIoApiNetworkingV1alpha3TrafficPolicyPortTrafficPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_VirtualService")
    public VirtualServiceSpec getIstioIoApiNetworkingV1alpha3VirtualService() {
        return istioIoApiNetworkingV1alpha3VirtualService;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_VirtualService")
    public void setIstioIoApiNetworkingV1alpha3VirtualService(VirtualServiceSpec istioIoApiNetworkingV1alpha3VirtualService) {
        this.istioIoApiNetworkingV1alpha3VirtualService = istioIoApiNetworkingV1alpha3VirtualService;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_WorkloadEntry")
    public WorkloadEntrySpec getIstioIoApiNetworkingV1alpha3WorkloadEntry() {
        return istioIoApiNetworkingV1alpha3WorkloadEntry;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_WorkloadEntry")
    public void setIstioIoApiNetworkingV1alpha3WorkloadEntry(WorkloadEntrySpec istioIoApiNetworkingV1alpha3WorkloadEntry) {
        this.istioIoApiNetworkingV1alpha3WorkloadEntry = istioIoApiNetworkingV1alpha3WorkloadEntry;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_WorkloadSelector")
    public WorkloadSelector getIstioIoApiNetworkingV1alpha3WorkloadSelector() {
        return istioIoApiNetworkingV1alpha3WorkloadSelector;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_WorkloadSelector")
    public void setIstioIoApiNetworkingV1alpha3WorkloadSelector(WorkloadSelector istioIoApiNetworkingV1alpha3WorkloadSelector) {
        this.istioIoApiNetworkingV1alpha3WorkloadSelector = istioIoApiNetworkingV1alpha3WorkloadSelector;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isEnvoyFilter_EnvoyConfigObjectMatch_ObjectTypes")
    public IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes getIstioIoApiNetworkingV1alpha3IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes() {
        return istioIoApiNetworkingV1alpha3IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isEnvoyFilter_EnvoyConfigObjectMatch_ObjectTypes")
    public void setIstioIoApiNetworkingV1alpha3IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes(IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes istioIoApiNetworkingV1alpha3IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes) {
        this.istioIoApiNetworkingV1alpha3IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes = istioIoApiNetworkingV1alpha3IsEnvoyFilterEnvoyConfigObjectMatchObjectTypes;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isHTTPFaultInjection_Abort_ErrorType")
    public IsHTTPFaultInjectionAbortErrorType getIstioIoApiNetworkingV1alpha3IsHTTPFaultInjectionAbortErrorType() {
        return istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionAbortErrorType;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isHTTPFaultInjection_Abort_ErrorType")
    public void setIstioIoApiNetworkingV1alpha3IsHTTPFaultInjectionAbortErrorType(IsHTTPFaultInjectionAbortErrorType istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionAbortErrorType) {
        this.istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionAbortErrorType = istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionAbortErrorType;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isHTTPFaultInjection_Delay_HttpDelayType")
    public IsHTTPFaultInjectionDelayHttpDelayType getIstioIoApiNetworkingV1alpha3IsHTTPFaultInjectionDelayHttpDelayType() {
        return istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionDelayHttpDelayType;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isHTTPFaultInjection_Delay_HttpDelayType")
    public void setIstioIoApiNetworkingV1alpha3IsHTTPFaultInjectionDelayHttpDelayType(IsHTTPFaultInjectionDelayHttpDelayType istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionDelayHttpDelayType) {
        this.istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionDelayHttpDelayType = istioIoApiNetworkingV1alpha3IsHTTPFaultInjectionDelayHttpDelayType;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isHTTPRedirect_RedirectPort")
    public IsHTTPRedirectRedirectPort getIstioIoApiNetworkingV1alpha3IsHTTPRedirectRedirectPort() {
        return istioIoApiNetworkingV1alpha3IsHTTPRedirectRedirectPort;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isHTTPRedirect_RedirectPort")
    public void setIstioIoApiNetworkingV1alpha3IsHTTPRedirectRedirectPort(IsHTTPRedirectRedirectPort istioIoApiNetworkingV1alpha3IsHTTPRedirectRedirectPort) {
        this.istioIoApiNetworkingV1alpha3IsHTTPRedirectRedirectPort = istioIoApiNetworkingV1alpha3IsHTTPRedirectRedirectPort;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isLoadBalancerSettings_ConsistentHashLB_HashKey")
    public IsLoadBalancerSettingsConsistentHashLBHashKey getIstioIoApiNetworkingV1alpha3IsLoadBalancerSettingsConsistentHashLBHashKey() {
        return istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsConsistentHashLBHashKey;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isLoadBalancerSettings_ConsistentHashLB_HashKey")
    public void setIstioIoApiNetworkingV1alpha3IsLoadBalancerSettingsConsistentHashLBHashKey(IsLoadBalancerSettingsConsistentHashLBHashKey istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsConsistentHashLBHashKey) {
        this.istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsConsistentHashLBHashKey = istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsConsistentHashLBHashKey;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isLoadBalancerSettings_LbPolicy")
    public IsLoadBalancerSettingsLbPolicy getIstioIoApiNetworkingV1alpha3IsLoadBalancerSettingsLbPolicy() {
        return istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsLbPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isLoadBalancerSettings_LbPolicy")
    public void setIstioIoApiNetworkingV1alpha3IsLoadBalancerSettingsLbPolicy(IsLoadBalancerSettingsLbPolicy istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsLbPolicy) {
        this.istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsLbPolicy = istioIoApiNetworkingV1alpha3IsLoadBalancerSettingsLbPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isStringMatch_MatchType")
    public IsStringMatchMatchType getIstioIoApiNetworkingV1alpha3IsStringMatchMatchType() {
        return istioIoApiNetworkingV1alpha3IsStringMatchMatchType;
    }

    @JsonProperty("istio_io_api_networking_v1alpha3_isStringMatch_MatchType")
    public void setIstioIoApiNetworkingV1alpha3IsStringMatchMatchType(IsStringMatchMatchType istioIoApiNetworkingV1alpha3IsStringMatchMatchType) {
        this.istioIoApiNetworkingV1alpha3IsStringMatchMatchType = istioIoApiNetworkingV1alpha3IsStringMatchMatchType;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_DestinationRule")
    public DestinationRule getIstioIoClientGoPkgApisNetworkingV1alpha3DestinationRule() {
        return istioIoClientGoPkgApisNetworkingV1alpha3DestinationRule;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_DestinationRule")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3DestinationRule(DestinationRule istioIoClientGoPkgApisNetworkingV1alpha3DestinationRule) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3DestinationRule = istioIoClientGoPkgApisNetworkingV1alpha3DestinationRule;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_DestinationRuleList")
    public DestinationRuleList getIstioIoClientGoPkgApisNetworkingV1alpha3DestinationRuleList() {
        return istioIoClientGoPkgApisNetworkingV1alpha3DestinationRuleList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_DestinationRuleList")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3DestinationRuleList(DestinationRuleList istioIoClientGoPkgApisNetworkingV1alpha3DestinationRuleList) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3DestinationRuleList = istioIoClientGoPkgApisNetworkingV1alpha3DestinationRuleList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_EnvoyFilter")
    public EnvoyFilter getIstioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilter() {
        return istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilter;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_EnvoyFilter")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilter(EnvoyFilter istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilter) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilter = istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilter;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_EnvoyFilterList")
    public EnvoyFilterList getIstioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilterList() {
        return istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilterList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_EnvoyFilterList")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilterList(EnvoyFilterList istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilterList) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilterList = istioIoClientGoPkgApisNetworkingV1alpha3EnvoyFilterList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_Gateway")
    public Gateway getIstioIoClientGoPkgApisNetworkingV1alpha3Gateway() {
        return istioIoClientGoPkgApisNetworkingV1alpha3Gateway;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_Gateway")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3Gateway(Gateway istioIoClientGoPkgApisNetworkingV1alpha3Gateway) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3Gateway = istioIoClientGoPkgApisNetworkingV1alpha3Gateway;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_GatewayList")
    public GatewayList getIstioIoClientGoPkgApisNetworkingV1alpha3GatewayList() {
        return istioIoClientGoPkgApisNetworkingV1alpha3GatewayList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_GatewayList")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3GatewayList(GatewayList istioIoClientGoPkgApisNetworkingV1alpha3GatewayList) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3GatewayList = istioIoClientGoPkgApisNetworkingV1alpha3GatewayList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_ServiceEntry")
    public ServiceEntry getIstioIoClientGoPkgApisNetworkingV1alpha3ServiceEntry() {
        return istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntry;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_ServiceEntry")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3ServiceEntry(ServiceEntry istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntry) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntry = istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntry;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_ServiceEntryList")
    public ServiceEntryList getIstioIoClientGoPkgApisNetworkingV1alpha3ServiceEntryList() {
        return istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntryList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_ServiceEntryList")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3ServiceEntryList(ServiceEntryList istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntryList) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntryList = istioIoClientGoPkgApisNetworkingV1alpha3ServiceEntryList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_Sidecar")
    public Sidecar getIstioIoClientGoPkgApisNetworkingV1alpha3Sidecar() {
        return istioIoClientGoPkgApisNetworkingV1alpha3Sidecar;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_Sidecar")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3Sidecar(Sidecar istioIoClientGoPkgApisNetworkingV1alpha3Sidecar) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3Sidecar = istioIoClientGoPkgApisNetworkingV1alpha3Sidecar;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_SidecarList")
    public SidecarList getIstioIoClientGoPkgApisNetworkingV1alpha3SidecarList() {
        return istioIoClientGoPkgApisNetworkingV1alpha3SidecarList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_SidecarList")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3SidecarList(SidecarList istioIoClientGoPkgApisNetworkingV1alpha3SidecarList) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3SidecarList = istioIoClientGoPkgApisNetworkingV1alpha3SidecarList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_VirtualService")
    public VirtualService getIstioIoClientGoPkgApisNetworkingV1alpha3VirtualService() {
        return istioIoClientGoPkgApisNetworkingV1alpha3VirtualService;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_VirtualService")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3VirtualService(VirtualService istioIoClientGoPkgApisNetworkingV1alpha3VirtualService) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3VirtualService = istioIoClientGoPkgApisNetworkingV1alpha3VirtualService;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_VirtualServiceList")
    public VirtualServiceList getIstioIoClientGoPkgApisNetworkingV1alpha3VirtualServiceList() {
        return istioIoClientGoPkgApisNetworkingV1alpha3VirtualServiceList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_VirtualServiceList")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3VirtualServiceList(VirtualServiceList istioIoClientGoPkgApisNetworkingV1alpha3VirtualServiceList) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3VirtualServiceList = istioIoClientGoPkgApisNetworkingV1alpha3VirtualServiceList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_WorkloadEntry")
    public WorkloadEntry getIstioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntry() {
        return istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntry;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_WorkloadEntry")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntry(WorkloadEntry istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntry) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntry = istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntry;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_WorkloadEntryList")
    public WorkloadEntryList getIstioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntryList() {
        return istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntryList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1alpha3_WorkloadEntryList")
    public void setIstioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntryList(WorkloadEntryList istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntryList) {
        this.istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntryList = istioIoClientGoPkgApisNetworkingV1alpha3WorkloadEntryList;
    }

}
