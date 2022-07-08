
package io.fabric8.istio.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.istio.api.analysis.v1alpha1.AnalysisMessageBase;
import io.fabric8.istio.api.analysis.v1alpha1.AnalysisMessageBaseLevel;
import io.fabric8.istio.api.analysis.v1alpha1.AnalysisMessageBaseType;
import io.fabric8.istio.api.meta.v1alpha1.IstioCondition;
import io.fabric8.istio.api.meta.v1alpha1.IstioStatus;
import io.fabric8.istio.api.networking.v1beta1.CaptureMode;
import io.fabric8.istio.api.networking.v1beta1.ClientTLSSettings;
import io.fabric8.istio.api.networking.v1beta1.ClientTLSSettingsTLSmode;
import io.fabric8.istio.api.networking.v1beta1.ConnectionPoolSettings;
import io.fabric8.istio.api.networking.v1beta1.ConnectionPoolSettingsHTTPSettings;
import io.fabric8.istio.api.networking.v1beta1.ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy;
import io.fabric8.istio.api.networking.v1beta1.ConnectionPoolSettingsTCPSettings;
import io.fabric8.istio.api.networking.v1beta1.ConnectionPoolSettingsTCPSettingsTcpKeepalive;
import io.fabric8.istio.api.networking.v1beta1.Delegate;
import io.fabric8.istio.api.networking.v1beta1.Destination;
import io.fabric8.istio.api.networking.v1beta1.DestinationRule;
import io.fabric8.istio.api.networking.v1beta1.DestinationRuleList;
import io.fabric8.istio.api.networking.v1beta1.DestinationRuleSpec;
import io.fabric8.istio.api.networking.v1beta1.Gateway;
import io.fabric8.istio.api.networking.v1beta1.GatewayList;
import io.fabric8.istio.api.networking.v1beta1.GatewaySpec;
import io.fabric8.istio.api.networking.v1beta1.HTTPFaultInjection;
import io.fabric8.istio.api.networking.v1beta1.HTTPFaultInjectionAbort;
import io.fabric8.istio.api.networking.v1beta1.HTTPFaultInjectionAbortGrpcStatus;
import io.fabric8.istio.api.networking.v1beta1.HTTPFaultInjectionAbortHttp2Error;
import io.fabric8.istio.api.networking.v1beta1.HTTPFaultInjectionAbortHttpStatus;
import io.fabric8.istio.api.networking.v1beta1.HTTPFaultInjectionDelay;
import io.fabric8.istio.api.networking.v1beta1.HTTPFaultInjectionDelayExponentialDelay;
import io.fabric8.istio.api.networking.v1beta1.HTTPFaultInjectionDelayFixedDelay;
import io.fabric8.istio.api.networking.v1beta1.HTTPMatchRequest;
import io.fabric8.istio.api.networking.v1beta1.HTTPRedirect;
import io.fabric8.istio.api.networking.v1beta1.HTTPRedirectDerivePort;
import io.fabric8.istio.api.networking.v1beta1.HTTPRedirectPort;
import io.fabric8.istio.api.networking.v1beta1.HTTPRedirectRedirectPortSelection;
import io.fabric8.istio.api.networking.v1beta1.HTTPRetry;
import io.fabric8.istio.api.networking.v1beta1.HTTPRewrite;
import io.fabric8.istio.api.networking.v1beta1.HTTPRoute;
import io.fabric8.istio.api.networking.v1beta1.HTTPRouteDestination;
import io.fabric8.istio.api.networking.v1beta1.Headers;
import io.fabric8.istio.api.networking.v1beta1.HeadersHeaderOperations;
import io.fabric8.istio.api.networking.v1beta1.IsHTTPFaultInjectionAbortErrorType;
import io.fabric8.istio.api.networking.v1beta1.IsHTTPFaultInjectionDelayHttpDelayType;
import io.fabric8.istio.api.networking.v1beta1.IsHTTPRedirectRedirectPort;
import io.fabric8.istio.api.networking.v1beta1.IsLoadBalancerSettingsConsistentHashLBHashKey;
import io.fabric8.istio.api.networking.v1beta1.IsLoadBalancerSettingsLbPolicy;
import io.fabric8.istio.api.networking.v1beta1.IsStringMatchMatchType;
import io.fabric8.istio.api.networking.v1beta1.IstioEgressListener;
import io.fabric8.istio.api.networking.v1beta1.IstioIngressListener;
import io.fabric8.istio.api.networking.v1beta1.L4MatchAttributes;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettings;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHash;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLB;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBHttpCookie;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBHttpCookieValue;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBHttpHeaderName;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBHttpQueryParameterName;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsConsistentHashLBUseSourceIp;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsSimple;
import io.fabric8.istio.api.networking.v1beta1.LoadBalancerSettingsSimpleLB;
import io.fabric8.istio.api.networking.v1beta1.LocalityLoadBalancerSetting;
import io.fabric8.istio.api.networking.v1beta1.LocalityLoadBalancerSettingDistribute;
import io.fabric8.istio.api.networking.v1beta1.LocalityLoadBalancerSettingFailover;
import io.fabric8.istio.api.networking.v1beta1.OutboundTrafficPolicy;
import io.fabric8.istio.api.networking.v1beta1.OutboundTrafficPolicyMode;
import io.fabric8.istio.api.networking.v1beta1.OutlierDetection;
import io.fabric8.istio.api.networking.v1beta1.Percent;
import io.fabric8.istio.api.networking.v1beta1.Port;
import io.fabric8.istio.api.networking.v1beta1.PortSelector;
import io.fabric8.istio.api.networking.v1beta1.RouteDestination;
import io.fabric8.istio.api.networking.v1beta1.Server;
import io.fabric8.istio.api.networking.v1beta1.ServerTLSSettings;
import io.fabric8.istio.api.networking.v1beta1.ServerTLSSettingsTLSProtocol;
import io.fabric8.istio.api.networking.v1beta1.ServerTLSSettingsTLSmode;
import io.fabric8.istio.api.networking.v1beta1.ServiceEntry;
import io.fabric8.istio.api.networking.v1beta1.ServiceEntryList;
import io.fabric8.istio.api.networking.v1beta1.ServiceEntryLocation;
import io.fabric8.istio.api.networking.v1beta1.ServiceEntryResolution;
import io.fabric8.istio.api.networking.v1beta1.ServiceEntrySpec;
import io.fabric8.istio.api.networking.v1beta1.Sidecar;
import io.fabric8.istio.api.networking.v1beta1.SidecarList;
import io.fabric8.istio.api.networking.v1beta1.SidecarSpec;
import io.fabric8.istio.api.networking.v1beta1.StringMatch;
import io.fabric8.istio.api.networking.v1beta1.StringMatchExact;
import io.fabric8.istio.api.networking.v1beta1.StringMatchPrefix;
import io.fabric8.istio.api.networking.v1beta1.StringMatchRegex;
import io.fabric8.istio.api.networking.v1beta1.Subset;
import io.fabric8.istio.api.networking.v1beta1.TCPRoute;
import io.fabric8.istio.api.networking.v1beta1.TLSMatchAttributes;
import io.fabric8.istio.api.networking.v1beta1.TLSRoute;
import io.fabric8.istio.api.networking.v1beta1.TrafficPolicy;
import io.fabric8.istio.api.networking.v1beta1.TrafficPolicyPortTrafficPolicy;
import io.fabric8.istio.api.networking.v1beta1.VirtualService;
import io.fabric8.istio.api.networking.v1beta1.VirtualServiceList;
import io.fabric8.istio.api.networking.v1beta1.VirtualServiceSpec;
import io.fabric8.istio.api.networking.v1beta1.WorkloadEntry;
import io.fabric8.istio.api.networking.v1beta1.WorkloadEntryList;
import io.fabric8.istio.api.networking.v1beta1.WorkloadEntrySpec;
import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicy;
import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicyAction;
import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicyExtensionProvider;
import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicyList;
import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicyProvider;
import io.fabric8.istio.api.security.v1beta1.AuthorizationPolicySpec;
import io.fabric8.istio.api.security.v1beta1.Condition;
import io.fabric8.istio.api.security.v1beta1.IsAuthorizationPolicyActionDetail;
import io.fabric8.istio.api.security.v1beta1.JWTHeader;
import io.fabric8.istio.api.security.v1beta1.JWTRule;
import io.fabric8.istio.api.security.v1beta1.Operation;
import io.fabric8.istio.api.security.v1beta1.PeerAuthentication;
import io.fabric8.istio.api.security.v1beta1.PeerAuthenticationList;
import io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLS;
import io.fabric8.istio.api.security.v1beta1.PeerAuthenticationMutualTLSMode;
import io.fabric8.istio.api.security.v1beta1.PeerAuthenticationSpec;
import io.fabric8.istio.api.security.v1beta1.RequestAuthentication;
import io.fabric8.istio.api.security.v1beta1.RequestAuthenticationList;
import io.fabric8.istio.api.security.v1beta1.RequestAuthenticationSpec;
import io.fabric8.istio.api.security.v1beta1.Rule;
import io.fabric8.istio.api.security.v1beta1.RuleFrom;
import io.fabric8.istio.api.security.v1beta1.RuleTo;
import io.fabric8.istio.api.security.v1beta1.Source;
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
    "istio_io_api_analysis_v1alpha1_AnalysisMessageBase",
    "istio_io_api_analysis_v1alpha1_AnalysisMessageBase_Level",
    "istio_io_api_analysis_v1alpha1_AnalysisMessageBase_Type",
    "istio_io_api_meta_v1alpha1_IstioCondition",
    "istio_io_api_meta_v1alpha1_IstioStatus",
    "istio_io_api_networking_v1beta1_CaptureMode",
    "istio_io_api_networking_v1beta1_ClientTLSSettings",
    "istio_io_api_networking_v1beta1_ClientTLSSettings_TLSmode",
    "istio_io_api_networking_v1beta1_ConnectionPoolSettings",
    "istio_io_api_networking_v1beta1_ConnectionPoolSettings_HTTPSettings",
    "istio_io_api_networking_v1beta1_ConnectionPoolSettings_HTTPSettings_H2UpgradePolicy",
    "istio_io_api_networking_v1beta1_ConnectionPoolSettings_TCPSettings",
    "istio_io_api_networking_v1beta1_ConnectionPoolSettings_TCPSettings_TcpKeepalive",
    "istio_io_api_networking_v1beta1_Delegate",
    "istio_io_api_networking_v1beta1_Destination",
    "istio_io_api_networking_v1beta1_DestinationRule",
    "istio_io_api_networking_v1beta1_Gateway",
    "istio_io_api_networking_v1beta1_HTTPFaultInjection",
    "istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort",
    "istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort_GrpcStatus",
    "istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort_Http2Error",
    "istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort_HttpStatus",
    "istio_io_api_networking_v1beta1_HTTPFaultInjection_Delay",
    "istio_io_api_networking_v1beta1_HTTPFaultInjection_Delay_ExponentialDelay",
    "istio_io_api_networking_v1beta1_HTTPFaultInjection_Delay_FixedDelay",
    "istio_io_api_networking_v1beta1_HTTPMatchRequest",
    "istio_io_api_networking_v1beta1_HTTPRedirect",
    "istio_io_api_networking_v1beta1_HTTPRedirect_DerivePort",
    "istio_io_api_networking_v1beta1_HTTPRedirect_Port",
    "istio_io_api_networking_v1beta1_HTTPRedirect_RedirectPortSelection",
    "istio_io_api_networking_v1beta1_HTTPRetry",
    "istio_io_api_networking_v1beta1_HTTPRewrite",
    "istio_io_api_networking_v1beta1_HTTPRoute",
    "istio_io_api_networking_v1beta1_HTTPRouteDestination",
    "istio_io_api_networking_v1beta1_Headers",
    "istio_io_api_networking_v1beta1_Headers_HeaderOperations",
    "istio_io_api_networking_v1beta1_IstioEgressListener",
    "istio_io_api_networking_v1beta1_IstioIngressListener",
    "istio_io_api_networking_v1beta1_L4MatchAttributes",
    "istio_io_api_networking_v1beta1_LoadBalancerSettings",
    "istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHash",
    "istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB",
    "istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HTTPCookie",
    "istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HttpCookie",
    "istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HttpHeaderName",
    "istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HttpQueryParameterName",
    "istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_UseSourceIp",
    "istio_io_api_networking_v1beta1_LoadBalancerSettings_Simple",
    "istio_io_api_networking_v1beta1_LoadBalancerSettings_SimpleLB",
    "istio_io_api_networking_v1beta1_LocalityLoadBalancerSetting",
    "istio_io_api_networking_v1beta1_LocalityLoadBalancerSetting_Distribute",
    "istio_io_api_networking_v1beta1_LocalityLoadBalancerSetting_Failover",
    "istio_io_api_networking_v1beta1_OutboundTrafficPolicy",
    "istio_io_api_networking_v1beta1_OutboundTrafficPolicy_Mode",
    "istio_io_api_networking_v1beta1_OutlierDetection",
    "istio_io_api_networking_v1beta1_Percent",
    "istio_io_api_networking_v1beta1_Port",
    "istio_io_api_networking_v1beta1_PortSelector",
    "istio_io_api_networking_v1beta1_RouteDestination",
    "istio_io_api_networking_v1beta1_Server",
    "istio_io_api_networking_v1beta1_ServerTLSSettings",
    "istio_io_api_networking_v1beta1_ServerTLSSettings_TLSProtocol",
    "istio_io_api_networking_v1beta1_ServerTLSSettings_TLSmode",
    "istio_io_api_networking_v1beta1_ServiceEntry",
    "istio_io_api_networking_v1beta1_ServiceEntry_Location",
    "istio_io_api_networking_v1beta1_ServiceEntry_Resolution",
    "istio_io_api_networking_v1beta1_Sidecar",
    "istio_io_api_networking_v1beta1_StringMatch",
    "istio_io_api_networking_v1beta1_StringMatch_Exact",
    "istio_io_api_networking_v1beta1_StringMatch_Prefix",
    "istio_io_api_networking_v1beta1_StringMatch_Regex",
    "istio_io_api_networking_v1beta1_Subset",
    "istio_io_api_networking_v1beta1_TCPRoute",
    "istio_io_api_networking_v1beta1_TLSMatchAttributes",
    "istio_io_api_networking_v1beta1_TLSRoute",
    "istio_io_api_networking_v1beta1_TrafficPolicy",
    "istio_io_api_networking_v1beta1_TrafficPolicy_PortTrafficPolicy",
    "istio_io_api_networking_v1beta1_VirtualService",
    "istio_io_api_networking_v1beta1_WorkloadEntry",
    "istio_io_api_networking_v1beta1_WorkloadSelector",
    "istio_io_api_networking_v1beta1_isHTTPFaultInjection_Abort_ErrorType",
    "istio_io_api_networking_v1beta1_isHTTPFaultInjection_Delay_HttpDelayType",
    "istio_io_api_networking_v1beta1_isHTTPRedirect_RedirectPort",
    "istio_io_api_networking_v1beta1_isLoadBalancerSettings_ConsistentHashLB_HashKey",
    "istio_io_api_networking_v1beta1_isLoadBalancerSettings_LbPolicy",
    "istio_io_api_networking_v1beta1_isStringMatch_MatchType",
    "istio_io_api_security_v1beta1_AuthorizationPolicy",
    "istio_io_api_security_v1beta1_AuthorizationPolicy_Action",
    "istio_io_api_security_v1beta1_AuthorizationPolicy_ExtensionProvider",
    "istio_io_api_security_v1beta1_AuthorizationPolicy_Provider",
    "istio_io_api_security_v1beta1_Condition",
    "istio_io_api_security_v1beta1_JWTHeader",
    "istio_io_api_security_v1beta1_JWTRule",
    "istio_io_api_security_v1beta1_Operation",
    "istio_io_api_security_v1beta1_PeerAuthentication",
    "istio_io_api_security_v1beta1_PeerAuthentication_MutualTLS",
    "istio_io_api_security_v1beta1_PeerAuthentication_MutualTLS_Mode",
    "istio_io_api_security_v1beta1_RequestAuthentication",
    "istio_io_api_security_v1beta1_Rule",
    "istio_io_api_security_v1beta1_Rule_From",
    "istio_io_api_security_v1beta1_Rule_To",
    "istio_io_api_security_v1beta1_Source",
    "istio_io_api_security_v1beta1_isAuthorizationPolicy_ActionDetail",
    "istio_io_api_type_v1beta1_WorkloadSelector",
    "istio_io_client-go_pkg_apis_networking_v1beta1_DestinationRule",
    "istio_io_client-go_pkg_apis_networking_v1beta1_DestinationRuleList",
    "istio_io_client-go_pkg_apis_networking_v1beta1_Gateway",
    "istio_io_client-go_pkg_apis_networking_v1beta1_GatewayList",
    "istio_io_client-go_pkg_apis_networking_v1beta1_ServiceEntry",
    "istio_io_client-go_pkg_apis_networking_v1beta1_ServiceEntryList",
    "istio_io_client-go_pkg_apis_networking_v1beta1_Sidecar",
    "istio_io_client-go_pkg_apis_networking_v1beta1_SidecarList",
    "istio_io_client-go_pkg_apis_networking_v1beta1_VirtualService",
    "istio_io_client-go_pkg_apis_networking_v1beta1_VirtualServiceList",
    "istio_io_client-go_pkg_apis_networking_v1beta1_WorkloadEntry",
    "istio_io_client-go_pkg_apis_networking_v1beta1_WorkloadEntryList",
    "istio_io_client-go_pkg_apis_security_v1beta1_AuthorizationPolicy",
    "istio_io_client-go_pkg_apis_security_v1beta1_AuthorizationPolicyList",
    "istio_io_client-go_pkg_apis_security_v1beta1_PeerAuthentication",
    "istio_io_client-go_pkg_apis_security_v1beta1_PeerAuthenticationList",
    "istio_io_client-go_pkg_apis_security_v1beta1_RequestAuthentication",
    "istio_io_client-go_pkg_apis_security_v1beta1_RequestAuthenticationList"
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
    @JsonProperty("istio_io_api_networking_v1beta1_CaptureMode")
    private CaptureMode istioIoApiNetworkingV1beta1CaptureMode;
    @JsonProperty("istio_io_api_networking_v1beta1_ClientTLSSettings")
    private ClientTLSSettings istioIoApiNetworkingV1beta1ClientTLSSettings;
    @JsonProperty("istio_io_api_networking_v1beta1_ClientTLSSettings_TLSmode")
    private ClientTLSSettingsTLSmode istioIoApiNetworkingV1beta1ClientTLSSettingsTLSmode;
    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings")
    private ConnectionPoolSettings istioIoApiNetworkingV1beta1ConnectionPoolSettings;
    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings_HTTPSettings")
    private ConnectionPoolSettingsHTTPSettings istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettings;
    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings_HTTPSettings_H2UpgradePolicy")
    private ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy;
    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings_TCPSettings")
    private ConnectionPoolSettingsTCPSettings istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettings;
    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings_TCPSettings_TcpKeepalive")
    private ConnectionPoolSettingsTCPSettingsTcpKeepalive istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettingsTcpKeepalive;
    @JsonProperty("istio_io_api_networking_v1beta1_Delegate")
    private Delegate istioIoApiNetworkingV1beta1Delegate;
    @JsonProperty("istio_io_api_networking_v1beta1_Destination")
    private Destination istioIoApiNetworkingV1beta1Destination;
    @JsonProperty("istio_io_api_networking_v1beta1_DestinationRule")
    private DestinationRuleSpec istioIoApiNetworkingV1beta1DestinationRule;
    @JsonProperty("istio_io_api_networking_v1beta1_Gateway")
    private GatewaySpec istioIoApiNetworkingV1beta1Gateway;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection")
    private HTTPFaultInjection istioIoApiNetworkingV1beta1HTTPFaultInjection;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort")
    private HTTPFaultInjectionAbort istioIoApiNetworkingV1beta1HTTPFaultInjectionAbort;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort_GrpcStatus")
    private HTTPFaultInjectionAbortGrpcStatus istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortGrpcStatus;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort_Http2Error")
    private HTTPFaultInjectionAbortHttp2Error istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttp2Error;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort_HttpStatus")
    private HTTPFaultInjectionAbortHttpStatus istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttpStatus;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Delay")
    private HTTPFaultInjectionDelay istioIoApiNetworkingV1beta1HTTPFaultInjectionDelay;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Delay_ExponentialDelay")
    private HTTPFaultInjectionDelayExponentialDelay istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayExponentialDelay;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Delay_FixedDelay")
    private HTTPFaultInjectionDelayFixedDelay istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayFixedDelay;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPMatchRequest")
    private HTTPMatchRequest istioIoApiNetworkingV1beta1HTTPMatchRequest;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRedirect")
    private HTTPRedirect istioIoApiNetworkingV1beta1HTTPRedirect;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRedirect_DerivePort")
    private HTTPRedirectDerivePort istioIoApiNetworkingV1beta1HTTPRedirectDerivePort;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRedirect_Port")
    private HTTPRedirectPort istioIoApiNetworkingV1beta1HTTPRedirectPort;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRedirect_RedirectPortSelection")
    private HTTPRedirectRedirectPortSelection istioIoApiNetworkingV1beta1HTTPRedirectRedirectPortSelection;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRetry")
    private HTTPRetry istioIoApiNetworkingV1beta1HTTPRetry;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRewrite")
    private HTTPRewrite istioIoApiNetworkingV1beta1HTTPRewrite;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRoute")
    private HTTPRoute istioIoApiNetworkingV1beta1HTTPRoute;
    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRouteDestination")
    private HTTPRouteDestination istioIoApiNetworkingV1beta1HTTPRouteDestination;
    @JsonProperty("istio_io_api_networking_v1beta1_Headers")
    private Headers istioIoApiNetworkingV1beta1Headers;
    @JsonProperty("istio_io_api_networking_v1beta1_Headers_HeaderOperations")
    private HeadersHeaderOperations istioIoApiNetworkingV1beta1HeadersHeaderOperations;
    @JsonProperty("istio_io_api_networking_v1beta1_IstioEgressListener")
    private IstioEgressListener istioIoApiNetworkingV1beta1IstioEgressListener;
    @JsonProperty("istio_io_api_networking_v1beta1_IstioIngressListener")
    private IstioIngressListener istioIoApiNetworkingV1beta1IstioIngressListener;
    @JsonProperty("istio_io_api_networking_v1beta1_L4MatchAttributes")
    private L4MatchAttributes istioIoApiNetworkingV1beta1L4MatchAttributes;
    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings")
    private LoadBalancerSettings istioIoApiNetworkingV1beta1LoadBalancerSettings;
    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHash")
    private LoadBalancerSettingsConsistentHash istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHash;
    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB")
    private LoadBalancerSettingsConsistentHashLB istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLB;
    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HTTPCookie")
    private LoadBalancerSettingsConsistentHashLBHttpCookieValue istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHTTPCookie;
    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HttpCookie")
    private LoadBalancerSettingsConsistentHashLBHttpCookie istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpCookie;
    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HttpHeaderName")
    private LoadBalancerSettingsConsistentHashLBHttpHeaderName istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpHeaderName;
    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HttpQueryParameterName")
    private LoadBalancerSettingsConsistentHashLBHttpQueryParameterName istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpQueryParameterName;
    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_UseSourceIp")
    private LoadBalancerSettingsConsistentHashLBUseSourceIp istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBUseSourceIp;
    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_Simple")
    private LoadBalancerSettingsSimple istioIoApiNetworkingV1beta1LoadBalancerSettingsSimple;
    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_SimpleLB")
    private LoadBalancerSettingsSimpleLB istioIoApiNetworkingV1beta1LoadBalancerSettingsSimpleLB;
    @JsonProperty("istio_io_api_networking_v1beta1_LocalityLoadBalancerSetting")
    private LocalityLoadBalancerSetting istioIoApiNetworkingV1beta1LocalityLoadBalancerSetting;
    @JsonProperty("istio_io_api_networking_v1beta1_LocalityLoadBalancerSetting_Distribute")
    private LocalityLoadBalancerSettingDistribute istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingDistribute;
    @JsonProperty("istio_io_api_networking_v1beta1_LocalityLoadBalancerSetting_Failover")
    private LocalityLoadBalancerSettingFailover istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingFailover;
    @JsonProperty("istio_io_api_networking_v1beta1_OutboundTrafficPolicy")
    private OutboundTrafficPolicy istioIoApiNetworkingV1beta1OutboundTrafficPolicy;
    @JsonProperty("istio_io_api_networking_v1beta1_OutboundTrafficPolicy_Mode")
    private OutboundTrafficPolicyMode istioIoApiNetworkingV1beta1OutboundTrafficPolicyMode;
    @JsonProperty("istio_io_api_networking_v1beta1_OutlierDetection")
    private OutlierDetection istioIoApiNetworkingV1beta1OutlierDetection;
    @JsonProperty("istio_io_api_networking_v1beta1_Percent")
    private Percent istioIoApiNetworkingV1beta1Percent;
    @JsonProperty("istio_io_api_networking_v1beta1_Port")
    private Port istioIoApiNetworkingV1beta1Port;
    @JsonProperty("istio_io_api_networking_v1beta1_PortSelector")
    private PortSelector istioIoApiNetworkingV1beta1PortSelector;
    @JsonProperty("istio_io_api_networking_v1beta1_RouteDestination")
    private RouteDestination istioIoApiNetworkingV1beta1RouteDestination;
    @JsonProperty("istio_io_api_networking_v1beta1_Server")
    private Server istioIoApiNetworkingV1beta1Server;
    @JsonProperty("istio_io_api_networking_v1beta1_ServerTLSSettings")
    private ServerTLSSettings istioIoApiNetworkingV1beta1ServerTLSSettings;
    @JsonProperty("istio_io_api_networking_v1beta1_ServerTLSSettings_TLSProtocol")
    private ServerTLSSettingsTLSProtocol istioIoApiNetworkingV1beta1ServerTLSSettingsTLSProtocol;
    @JsonProperty("istio_io_api_networking_v1beta1_ServerTLSSettings_TLSmode")
    private ServerTLSSettingsTLSmode istioIoApiNetworkingV1beta1ServerTLSSettingsTLSmode;
    @JsonProperty("istio_io_api_networking_v1beta1_ServiceEntry")
    private ServiceEntrySpec istioIoApiNetworkingV1beta1ServiceEntry;
    @JsonProperty("istio_io_api_networking_v1beta1_ServiceEntry_Location")
    private ServiceEntryLocation istioIoApiNetworkingV1beta1ServiceEntryLocation;
    @JsonProperty("istio_io_api_networking_v1beta1_ServiceEntry_Resolution")
    private ServiceEntryResolution istioIoApiNetworkingV1beta1ServiceEntryResolution;
    @JsonProperty("istio_io_api_networking_v1beta1_Sidecar")
    private SidecarSpec istioIoApiNetworkingV1beta1Sidecar;
    @JsonProperty("istio_io_api_networking_v1beta1_StringMatch")
    private StringMatch istioIoApiNetworkingV1beta1StringMatch;
    @JsonProperty("istio_io_api_networking_v1beta1_StringMatch_Exact")
    private StringMatchExact istioIoApiNetworkingV1beta1StringMatchExact;
    @JsonProperty("istio_io_api_networking_v1beta1_StringMatch_Prefix")
    private StringMatchPrefix istioIoApiNetworkingV1beta1StringMatchPrefix;
    @JsonProperty("istio_io_api_networking_v1beta1_StringMatch_Regex")
    private StringMatchRegex istioIoApiNetworkingV1beta1StringMatchRegex;
    @JsonProperty("istio_io_api_networking_v1beta1_Subset")
    private Subset istioIoApiNetworkingV1beta1Subset;
    @JsonProperty("istio_io_api_networking_v1beta1_TCPRoute")
    private TCPRoute istioIoApiNetworkingV1beta1TCPRoute;
    @JsonProperty("istio_io_api_networking_v1beta1_TLSMatchAttributes")
    private TLSMatchAttributes istioIoApiNetworkingV1beta1TLSMatchAttributes;
    @JsonProperty("istio_io_api_networking_v1beta1_TLSRoute")
    private TLSRoute istioIoApiNetworkingV1beta1TLSRoute;
    @JsonProperty("istio_io_api_networking_v1beta1_TrafficPolicy")
    private TrafficPolicy istioIoApiNetworkingV1beta1TrafficPolicy;
    @JsonProperty("istio_io_api_networking_v1beta1_TrafficPolicy_PortTrafficPolicy")
    private TrafficPolicyPortTrafficPolicy istioIoApiNetworkingV1beta1TrafficPolicyPortTrafficPolicy;
    @JsonProperty("istio_io_api_networking_v1beta1_VirtualService")
    private VirtualServiceSpec istioIoApiNetworkingV1beta1VirtualService;
    @JsonProperty("istio_io_api_networking_v1beta1_WorkloadEntry")
    private WorkloadEntrySpec istioIoApiNetworkingV1beta1WorkloadEntry;
    @JsonProperty("istio_io_api_networking_v1beta1_WorkloadSelector")
    private io.fabric8.istio.api.networking.v1beta1.WorkloadSelector istioIoApiNetworkingV1beta1WorkloadSelector;
    @JsonProperty("istio_io_api_networking_v1beta1_isHTTPFaultInjection_Abort_ErrorType")
    @JsonUnwrapped
    private IsHTTPFaultInjectionAbortErrorType istioIoApiNetworkingV1beta1IsHTTPFaultInjectionAbortErrorType;
    @JsonProperty("istio_io_api_networking_v1beta1_isHTTPFaultInjection_Delay_HttpDelayType")
    @JsonUnwrapped
    private IsHTTPFaultInjectionDelayHttpDelayType istioIoApiNetworkingV1beta1IsHTTPFaultInjectionDelayHttpDelayType;
    @JsonProperty("istio_io_api_networking_v1beta1_isHTTPRedirect_RedirectPort")
    @JsonUnwrapped
    private IsHTTPRedirectRedirectPort istioIoApiNetworkingV1beta1IsHTTPRedirectRedirectPort;
    @JsonProperty("istio_io_api_networking_v1beta1_isLoadBalancerSettings_ConsistentHashLB_HashKey")
    @JsonUnwrapped
    private IsLoadBalancerSettingsConsistentHashLBHashKey istioIoApiNetworkingV1beta1IsLoadBalancerSettingsConsistentHashLBHashKey;
    @JsonProperty("istio_io_api_networking_v1beta1_isLoadBalancerSettings_LbPolicy")
    @JsonUnwrapped
    private IsLoadBalancerSettingsLbPolicy istioIoApiNetworkingV1beta1IsLoadBalancerSettingsLbPolicy;
    @JsonProperty("istio_io_api_networking_v1beta1_isStringMatch_MatchType")
    @JsonUnwrapped
    private IsStringMatchMatchType istioIoApiNetworkingV1beta1IsStringMatchMatchType;
    @JsonProperty("istio_io_api_security_v1beta1_AuthorizationPolicy")
    private AuthorizationPolicySpec istioIoApiSecurityV1beta1AuthorizationPolicy;
    @JsonProperty("istio_io_api_security_v1beta1_AuthorizationPolicy_Action")
    private AuthorizationPolicyAction istioIoApiSecurityV1beta1AuthorizationPolicyAction;
    @JsonProperty("istio_io_api_security_v1beta1_AuthorizationPolicy_ExtensionProvider")
    private AuthorizationPolicyExtensionProvider istioIoApiSecurityV1beta1AuthorizationPolicyExtensionProvider;
    @JsonProperty("istio_io_api_security_v1beta1_AuthorizationPolicy_Provider")
    private AuthorizationPolicyProvider istioIoApiSecurityV1beta1AuthorizationPolicyProvider;
    @JsonProperty("istio_io_api_security_v1beta1_Condition")
    private Condition istioIoApiSecurityV1beta1Condition;
    @JsonProperty("istio_io_api_security_v1beta1_JWTHeader")
    private JWTHeader istioIoApiSecurityV1beta1JWTHeader;
    @JsonProperty("istio_io_api_security_v1beta1_JWTRule")
    private JWTRule istioIoApiSecurityV1beta1JWTRule;
    @JsonProperty("istio_io_api_security_v1beta1_Operation")
    private Operation istioIoApiSecurityV1beta1Operation;
    @JsonProperty("istio_io_api_security_v1beta1_PeerAuthentication")
    private PeerAuthenticationSpec istioIoApiSecurityV1beta1PeerAuthentication;
    @JsonProperty("istio_io_api_security_v1beta1_PeerAuthentication_MutualTLS")
    private PeerAuthenticationMutualTLS istioIoApiSecurityV1beta1PeerAuthenticationMutualTLS;
    @JsonProperty("istio_io_api_security_v1beta1_PeerAuthentication_MutualTLS_Mode")
    private PeerAuthenticationMutualTLSMode istioIoApiSecurityV1beta1PeerAuthenticationMutualTLSMode;
    @JsonProperty("istio_io_api_security_v1beta1_RequestAuthentication")
    private RequestAuthenticationSpec istioIoApiSecurityV1beta1RequestAuthentication;
    @JsonProperty("istio_io_api_security_v1beta1_Rule")
    private Rule istioIoApiSecurityV1beta1Rule;
    @JsonProperty("istio_io_api_security_v1beta1_Rule_From")
    private RuleFrom istioIoApiSecurityV1beta1RuleFrom;
    @JsonProperty("istio_io_api_security_v1beta1_Rule_To")
    private RuleTo istioIoApiSecurityV1beta1RuleTo;
    @JsonProperty("istio_io_api_security_v1beta1_Source")
    private Source istioIoApiSecurityV1beta1Source;
    @JsonProperty("istio_io_api_security_v1beta1_isAuthorizationPolicy_ActionDetail")
    @JsonUnwrapped
    private IsAuthorizationPolicyActionDetail istioIoApiSecurityV1beta1IsAuthorizationPolicyActionDetail;
    @JsonProperty("istio_io_api_type_v1beta1_WorkloadSelector")
    private io.fabric8.istio.api.type.v1beta1.WorkloadSelector istioIoApiTypeV1beta1WorkloadSelector;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_DestinationRule")
    private DestinationRule istioIoClientGoPkgApisNetworkingV1beta1DestinationRule;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_DestinationRuleList")
    private DestinationRuleList istioIoClientGoPkgApisNetworkingV1beta1DestinationRuleList;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_Gateway")
    private Gateway istioIoClientGoPkgApisNetworkingV1beta1Gateway;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_GatewayList")
    private GatewayList istioIoClientGoPkgApisNetworkingV1beta1GatewayList;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_ServiceEntry")
    private ServiceEntry istioIoClientGoPkgApisNetworkingV1beta1ServiceEntry;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_ServiceEntryList")
    private ServiceEntryList istioIoClientGoPkgApisNetworkingV1beta1ServiceEntryList;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_Sidecar")
    private Sidecar istioIoClientGoPkgApisNetworkingV1beta1Sidecar;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_SidecarList")
    private SidecarList istioIoClientGoPkgApisNetworkingV1beta1SidecarList;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_VirtualService")
    private VirtualService istioIoClientGoPkgApisNetworkingV1beta1VirtualService;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_VirtualServiceList")
    private VirtualServiceList istioIoClientGoPkgApisNetworkingV1beta1VirtualServiceList;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_WorkloadEntry")
    private WorkloadEntry istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntry;
    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_WorkloadEntryList")
    private WorkloadEntryList istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntryList;
    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_AuthorizationPolicy")
    private AuthorizationPolicy istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicy;
    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_AuthorizationPolicyList")
    private AuthorizationPolicyList istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicyList;
    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_PeerAuthentication")
    private PeerAuthentication istioIoClientGoPkgApisSecurityV1beta1PeerAuthentication;
    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_PeerAuthenticationList")
    private PeerAuthenticationList istioIoClientGoPkgApisSecurityV1beta1PeerAuthenticationList;
    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_RequestAuthentication")
    private RequestAuthentication istioIoClientGoPkgApisSecurityV1beta1RequestAuthentication;
    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_RequestAuthenticationList")
    private RequestAuthenticationList istioIoClientGoPkgApisSecurityV1beta1RequestAuthenticationList;

    /**
     * No args constructor for use in serialization
     * 
     */
    public IstioSchema() {
    }

    /**
     * 
     * @param istioIoApiSecurityV1beta1Source
     * @param istioIoApiNetworkingV1beta1IstioEgressListener
     * @param istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpQueryParameterName
     * @param istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy
     * @param istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortGrpcStatus
     * @param istioIoApiSecurityV1beta1AuthorizationPolicyAction
     * @param istioIoApiSecurityV1beta1JWTRule
     * @param istioIoClientGoPkgApisNetworkingV1beta1Sidecar
     * @param istioIoApiNetworkingV1beta1HTTPRoute
     * @param istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingFailover
     * @param istioIoApiNetworkingV1beta1TLSRoute
     * @param istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettingsTcpKeepalive
     * @param istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicyList
     * @param istioIoApiNetworkingV1beta1ServerTLSSettingsTLSmode
     * @param istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingDistribute
     * @param istioIoApiNetworkingV1beta1TCPRoute
     * @param istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel
     * @param istioIoClientGoPkgApisNetworkingV1beta1VirtualServiceList
     * @param istioIoApiNetworkingV1beta1IsLoadBalancerSettingsLbPolicy
     * @param istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettings
     * @param istioIoApiNetworkingV1beta1TrafficPolicy
     * @param istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHTTPCookie
     * @param istioIoApiSecurityV1beta1RuleTo
     * @param istioIoApiSecurityV1beta1JWTHeader
     * @param istioIoApiNetworkingV1beta1RouteDestination
     * @param istioIoApiNetworkingV1beta1ServiceEntryResolution
     * @param istioIoApiNetworkingV1beta1ConnectionPoolSettings
     * @param istioIoApiNetworkingV1beta1Server
     * @param istioIoApiSecurityV1beta1PeerAuthentication
     * @param istioIoApiNetworkingV1beta1HTTPRouteDestination
     * @param istioIoApiNetworkingV1beta1ClientTLSSettingsTLSmode
     * @param istioIoApiNetworkingV1beta1Gateway
     * @param istioIoApiNetworkingV1beta1HTTPFaultInjection
     * @param istioIoApiNetworkingV1beta1ServiceEntry
     * @param istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntryList
     * @param istioIoApiSecurityV1beta1IsAuthorizationPolicyActionDetail
     * @param istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLB
     * @param istioIoApiSecurityV1beta1AuthorizationPolicyProvider
     * @param istioIoApiNetworkingV1beta1LocalityLoadBalancerSetting
     * @param istioIoClientGoPkgApisSecurityV1beta1RequestAuthenticationList
     * @param istioIoApiNetworkingV1beta1Destination
     * @param istioIoApiNetworkingV1beta1ServerTLSSettingsTLSProtocol
     * @param istioIoApiNetworkingV1beta1IsStringMatchMatchType
     * @param istioIoClientGoPkgApisSecurityV1beta1RequestAuthentication
     * @param istioIoApiSecurityV1beta1PeerAuthenticationMutualTLS
     * @param istioIoClientGoPkgApisNetworkingV1beta1Gateway
     * @param istioIoApiNetworkingV1beta1StringMatch
     * @param istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttpStatus
     * @param istioIoApiNetworkingV1beta1VirtualService
     * @param istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntry
     * @param istioIoApiNetworkingV1beta1LoadBalancerSettings
     * @param istioIoApiSecurityV1beta1RuleFrom
     * @param istioIoApiNetworkingV1beta1PortSelector
     * @param istioIoApiNetworkingV1beta1Port
     * @param istioIoApiMetaV1alpha1IstioStatus
     * @param istioIoClientGoPkgApisSecurityV1beta1PeerAuthenticationList
     * @param istioIoApiNetworkingV1beta1LoadBalancerSettingsSimpleLB
     * @param istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHash
     * @param istioIoApiTypeV1beta1WorkloadSelector
     * @param istioIoApiNetworkingV1beta1HTTPFaultInjectionDelay
     * @param istioIoApiNetworkingV1beta1OutboundTrafficPolicy
     * @param istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpCookie
     * @param istioIoApiNetworkingV1beta1IsHTTPFaultInjectionAbortErrorType
     * @param istioIoApiSecurityV1beta1Rule
     * @param istioIoApiAnalysisV1alpha1AnalysisMessageBase
     * @param istioIoApiNetworkingV1beta1LoadBalancerSettingsSimple
     * @param istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayFixedDelay
     * @param istioIoApiNetworkingV1beta1ClientTLSSettings
     * @param istioIoClientGoPkgApisNetworkingV1beta1VirtualService
     * @param istioIoClientGoPkgApisNetworkingV1beta1DestinationRule
     * @param istioIoApiSecurityV1beta1PeerAuthenticationMutualTLSMode
     * @param istioIoClientGoPkgApisNetworkingV1beta1GatewayList
     * @param istioIoClientGoPkgApisNetworkingV1beta1ServiceEntryList
     * @param istioIoApiMetaV1alpha1IstioCondition
     * @param istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpHeaderName
     * @param istioIoApiNetworkingV1beta1HTTPRedirectPort
     * @param istioIoClientGoPkgApisNetworkingV1beta1SidecarList
     * @param istioIoApiNetworkingV1beta1TrafficPolicyPortTrafficPolicy
     * @param istioIoApiNetworkingV1beta1Sidecar
     * @param istioIoApiNetworkingV1beta1IstioIngressListener
     * @param istioIoApiNetworkingV1beta1Delegate
     * @param istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttp2Error
     * @param istioIoApiNetworkingV1beta1HTTPRetry
     * @param istioIoApiSecurityV1beta1Condition
     * @param istioIoApiNetworkingV1beta1WorkloadSelector
     * @param istioIoApiNetworkingV1beta1OutlierDetection
     * @param istioIoApiNetworkingV1beta1StringMatchRegex
     * @param istioIoApiSecurityV1beta1RequestAuthentication
     * @param istioIoApiNetworkingV1beta1ServiceEntryLocation
     * @param istioIoApiNetworkingV1beta1WorkloadEntry
     * @param istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettings
     * @param istioIoApiNetworkingV1beta1HTTPRedirectRedirectPortSelection
     * @param istioIoApiAnalysisV1alpha1AnalysisMessageBaseType
     * @param istioIoApiNetworkingV1beta1HTTPFaultInjectionAbort
     * @param istioIoApiNetworkingV1beta1IsHTTPFaultInjectionDelayHttpDelayType
     * @param istioIoClientGoPkgApisNetworkingV1beta1DestinationRuleList
     * @param istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBUseSourceIp
     * @param istioIoApiNetworkingV1beta1DestinationRule
     * @param istioIoApiNetworkingV1beta1IsLoadBalancerSettingsConsistentHashLBHashKey
     * @param istioIoApiNetworkingV1beta1HTTPRewrite
     * @param istioIoApiNetworkingV1beta1CaptureMode
     * @param istioIoApiNetworkingV1beta1StringMatchPrefix
     * @param istioIoApiNetworkingV1beta1HTTPRedirect
     * @param istioIoApiNetworkingV1beta1StringMatchExact
     * @param istioIoApiSecurityV1beta1AuthorizationPolicyExtensionProvider
     * @param istioIoApiNetworkingV1beta1HTTPRedirectDerivePort
     * @param istioIoApiSecurityV1beta1Operation
     * @param istioIoApiNetworkingV1beta1HTTPMatchRequest
     * @param istioIoApiNetworkingV1beta1L4MatchAttributes
     * @param istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicy
     * @param istioIoApiSecurityV1beta1AuthorizationPolicy
     * @param istioIoClientGoPkgApisSecurityV1beta1PeerAuthentication
     * @param istioIoApiNetworkingV1beta1Headers
     * @param istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayExponentialDelay
     * @param istioIoApiNetworkingV1beta1HeadersHeaderOperations
     * @param istioIoClientGoPkgApisNetworkingV1beta1ServiceEntry
     * @param istioIoApiNetworkingV1beta1OutboundTrafficPolicyMode
     * @param istioIoApiNetworkingV1beta1ServerTLSSettings
     * @param istioIoApiNetworkingV1beta1Subset
     * @param istioIoApiNetworkingV1beta1TLSMatchAttributes
     * @param istioIoApiNetworkingV1beta1Percent
     * @param istioIoApiNetworkingV1beta1IsHTTPRedirectRedirectPort
     */
    public IstioSchema(AnalysisMessageBase istioIoApiAnalysisV1alpha1AnalysisMessageBase, AnalysisMessageBaseLevel istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel, AnalysisMessageBaseType istioIoApiAnalysisV1alpha1AnalysisMessageBaseType, IstioCondition istioIoApiMetaV1alpha1IstioCondition, IstioStatus istioIoApiMetaV1alpha1IstioStatus, CaptureMode istioIoApiNetworkingV1beta1CaptureMode, ClientTLSSettings istioIoApiNetworkingV1beta1ClientTLSSettings, ClientTLSSettingsTLSmode istioIoApiNetworkingV1beta1ClientTLSSettingsTLSmode, ConnectionPoolSettings istioIoApiNetworkingV1beta1ConnectionPoolSettings, ConnectionPoolSettingsHTTPSettings istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettings, ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy, ConnectionPoolSettingsTCPSettings istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettings, ConnectionPoolSettingsTCPSettingsTcpKeepalive istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettingsTcpKeepalive, Delegate istioIoApiNetworkingV1beta1Delegate, Destination istioIoApiNetworkingV1beta1Destination, DestinationRuleSpec istioIoApiNetworkingV1beta1DestinationRule, GatewaySpec istioIoApiNetworkingV1beta1Gateway, HTTPFaultInjection istioIoApiNetworkingV1beta1HTTPFaultInjection, HTTPFaultInjectionAbort istioIoApiNetworkingV1beta1HTTPFaultInjectionAbort, HTTPFaultInjectionAbortGrpcStatus istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortGrpcStatus, HTTPFaultInjectionAbortHttp2Error istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttp2Error, HTTPFaultInjectionAbortHttpStatus istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttpStatus, HTTPFaultInjectionDelay istioIoApiNetworkingV1beta1HTTPFaultInjectionDelay, HTTPFaultInjectionDelayExponentialDelay istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayExponentialDelay, HTTPFaultInjectionDelayFixedDelay istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayFixedDelay, HTTPMatchRequest istioIoApiNetworkingV1beta1HTTPMatchRequest, HTTPRedirect istioIoApiNetworkingV1beta1HTTPRedirect, HTTPRedirectDerivePort istioIoApiNetworkingV1beta1HTTPRedirectDerivePort, HTTPRedirectPort istioIoApiNetworkingV1beta1HTTPRedirectPort, HTTPRedirectRedirectPortSelection istioIoApiNetworkingV1beta1HTTPRedirectRedirectPortSelection, HTTPRetry istioIoApiNetworkingV1beta1HTTPRetry, HTTPRewrite istioIoApiNetworkingV1beta1HTTPRewrite, HTTPRoute istioIoApiNetworkingV1beta1HTTPRoute, HTTPRouteDestination istioIoApiNetworkingV1beta1HTTPRouteDestination, Headers istioIoApiNetworkingV1beta1Headers, HeadersHeaderOperations istioIoApiNetworkingV1beta1HeadersHeaderOperations, IstioEgressListener istioIoApiNetworkingV1beta1IstioEgressListener, IstioIngressListener istioIoApiNetworkingV1beta1IstioIngressListener, L4MatchAttributes istioIoApiNetworkingV1beta1L4MatchAttributes, LoadBalancerSettings istioIoApiNetworkingV1beta1LoadBalancerSettings, LoadBalancerSettingsConsistentHash istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHash, LoadBalancerSettingsConsistentHashLB istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLB, LoadBalancerSettingsConsistentHashLBHttpCookieValue istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHTTPCookie, LoadBalancerSettingsConsistentHashLBHttpCookie istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpCookie, LoadBalancerSettingsConsistentHashLBHttpHeaderName istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpHeaderName, LoadBalancerSettingsConsistentHashLBHttpQueryParameterName istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpQueryParameterName, LoadBalancerSettingsConsistentHashLBUseSourceIp istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBUseSourceIp, LoadBalancerSettingsSimple istioIoApiNetworkingV1beta1LoadBalancerSettingsSimple, LoadBalancerSettingsSimpleLB istioIoApiNetworkingV1beta1LoadBalancerSettingsSimpleLB, LocalityLoadBalancerSetting istioIoApiNetworkingV1beta1LocalityLoadBalancerSetting, LocalityLoadBalancerSettingDistribute istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingDistribute, LocalityLoadBalancerSettingFailover istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingFailover, OutboundTrafficPolicy istioIoApiNetworkingV1beta1OutboundTrafficPolicy, OutboundTrafficPolicyMode istioIoApiNetworkingV1beta1OutboundTrafficPolicyMode, OutlierDetection istioIoApiNetworkingV1beta1OutlierDetection, Percent istioIoApiNetworkingV1beta1Percent, Port istioIoApiNetworkingV1beta1Port, PortSelector istioIoApiNetworkingV1beta1PortSelector, RouteDestination istioIoApiNetworkingV1beta1RouteDestination, Server istioIoApiNetworkingV1beta1Server, ServerTLSSettings istioIoApiNetworkingV1beta1ServerTLSSettings, ServerTLSSettingsTLSProtocol istioIoApiNetworkingV1beta1ServerTLSSettingsTLSProtocol, ServerTLSSettingsTLSmode istioIoApiNetworkingV1beta1ServerTLSSettingsTLSmode, ServiceEntrySpec istioIoApiNetworkingV1beta1ServiceEntry, ServiceEntryLocation istioIoApiNetworkingV1beta1ServiceEntryLocation, ServiceEntryResolution istioIoApiNetworkingV1beta1ServiceEntryResolution, SidecarSpec istioIoApiNetworkingV1beta1Sidecar, StringMatch istioIoApiNetworkingV1beta1StringMatch, StringMatchExact istioIoApiNetworkingV1beta1StringMatchExact, StringMatchPrefix istioIoApiNetworkingV1beta1StringMatchPrefix, StringMatchRegex istioIoApiNetworkingV1beta1StringMatchRegex, Subset istioIoApiNetworkingV1beta1Subset, TCPRoute istioIoApiNetworkingV1beta1TCPRoute, TLSMatchAttributes istioIoApiNetworkingV1beta1TLSMatchAttributes, TLSRoute istioIoApiNetworkingV1beta1TLSRoute, TrafficPolicy istioIoApiNetworkingV1beta1TrafficPolicy, TrafficPolicyPortTrafficPolicy istioIoApiNetworkingV1beta1TrafficPolicyPortTrafficPolicy, VirtualServiceSpec istioIoApiNetworkingV1beta1VirtualService, WorkloadEntrySpec istioIoApiNetworkingV1beta1WorkloadEntry, io.fabric8.istio.api.networking.v1beta1.WorkloadSelector istioIoApiNetworkingV1beta1WorkloadSelector, IsHTTPFaultInjectionAbortErrorType istioIoApiNetworkingV1beta1IsHTTPFaultInjectionAbortErrorType, IsHTTPFaultInjectionDelayHttpDelayType istioIoApiNetworkingV1beta1IsHTTPFaultInjectionDelayHttpDelayType, IsHTTPRedirectRedirectPort istioIoApiNetworkingV1beta1IsHTTPRedirectRedirectPort, IsLoadBalancerSettingsConsistentHashLBHashKey istioIoApiNetworkingV1beta1IsLoadBalancerSettingsConsistentHashLBHashKey, IsLoadBalancerSettingsLbPolicy istioIoApiNetworkingV1beta1IsLoadBalancerSettingsLbPolicy, IsStringMatchMatchType istioIoApiNetworkingV1beta1IsStringMatchMatchType, AuthorizationPolicySpec istioIoApiSecurityV1beta1AuthorizationPolicy, AuthorizationPolicyAction istioIoApiSecurityV1beta1AuthorizationPolicyAction, AuthorizationPolicyExtensionProvider istioIoApiSecurityV1beta1AuthorizationPolicyExtensionProvider, AuthorizationPolicyProvider istioIoApiSecurityV1beta1AuthorizationPolicyProvider, Condition istioIoApiSecurityV1beta1Condition, JWTHeader istioIoApiSecurityV1beta1JWTHeader, JWTRule istioIoApiSecurityV1beta1JWTRule, Operation istioIoApiSecurityV1beta1Operation, PeerAuthenticationSpec istioIoApiSecurityV1beta1PeerAuthentication, PeerAuthenticationMutualTLS istioIoApiSecurityV1beta1PeerAuthenticationMutualTLS, PeerAuthenticationMutualTLSMode istioIoApiSecurityV1beta1PeerAuthenticationMutualTLSMode, RequestAuthenticationSpec istioIoApiSecurityV1beta1RequestAuthentication, Rule istioIoApiSecurityV1beta1Rule, RuleFrom istioIoApiSecurityV1beta1RuleFrom, RuleTo istioIoApiSecurityV1beta1RuleTo, Source istioIoApiSecurityV1beta1Source, IsAuthorizationPolicyActionDetail istioIoApiSecurityV1beta1IsAuthorizationPolicyActionDetail, io.fabric8.istio.api.type.v1beta1.WorkloadSelector istioIoApiTypeV1beta1WorkloadSelector, DestinationRule istioIoClientGoPkgApisNetworkingV1beta1DestinationRule, DestinationRuleList istioIoClientGoPkgApisNetworkingV1beta1DestinationRuleList, Gateway istioIoClientGoPkgApisNetworkingV1beta1Gateway, GatewayList istioIoClientGoPkgApisNetworkingV1beta1GatewayList, ServiceEntry istioIoClientGoPkgApisNetworkingV1beta1ServiceEntry, ServiceEntryList istioIoClientGoPkgApisNetworkingV1beta1ServiceEntryList, Sidecar istioIoClientGoPkgApisNetworkingV1beta1Sidecar, SidecarList istioIoClientGoPkgApisNetworkingV1beta1SidecarList, VirtualService istioIoClientGoPkgApisNetworkingV1beta1VirtualService, VirtualServiceList istioIoClientGoPkgApisNetworkingV1beta1VirtualServiceList, WorkloadEntry istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntry, WorkloadEntryList istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntryList, AuthorizationPolicy istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicy, AuthorizationPolicyList istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicyList, PeerAuthentication istioIoClientGoPkgApisSecurityV1beta1PeerAuthentication, PeerAuthenticationList istioIoClientGoPkgApisSecurityV1beta1PeerAuthenticationList, RequestAuthentication istioIoClientGoPkgApisSecurityV1beta1RequestAuthentication, RequestAuthenticationList istioIoClientGoPkgApisSecurityV1beta1RequestAuthenticationList) {
        super();
        this.istioIoApiAnalysisV1alpha1AnalysisMessageBase = istioIoApiAnalysisV1alpha1AnalysisMessageBase;
        this.istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel = istioIoApiAnalysisV1alpha1AnalysisMessageBaseLevel;
        this.istioIoApiAnalysisV1alpha1AnalysisMessageBaseType = istioIoApiAnalysisV1alpha1AnalysisMessageBaseType;
        this.istioIoApiMetaV1alpha1IstioCondition = istioIoApiMetaV1alpha1IstioCondition;
        this.istioIoApiMetaV1alpha1IstioStatus = istioIoApiMetaV1alpha1IstioStatus;
        this.istioIoApiNetworkingV1beta1CaptureMode = istioIoApiNetworkingV1beta1CaptureMode;
        this.istioIoApiNetworkingV1beta1ClientTLSSettings = istioIoApiNetworkingV1beta1ClientTLSSettings;
        this.istioIoApiNetworkingV1beta1ClientTLSSettingsTLSmode = istioIoApiNetworkingV1beta1ClientTLSSettingsTLSmode;
        this.istioIoApiNetworkingV1beta1ConnectionPoolSettings = istioIoApiNetworkingV1beta1ConnectionPoolSettings;
        this.istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettings = istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettings;
        this.istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy = istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy;
        this.istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettings = istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettings;
        this.istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettingsTcpKeepalive = istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettingsTcpKeepalive;
        this.istioIoApiNetworkingV1beta1Delegate = istioIoApiNetworkingV1beta1Delegate;
        this.istioIoApiNetworkingV1beta1Destination = istioIoApiNetworkingV1beta1Destination;
        this.istioIoApiNetworkingV1beta1DestinationRule = istioIoApiNetworkingV1beta1DestinationRule;
        this.istioIoApiNetworkingV1beta1Gateway = istioIoApiNetworkingV1beta1Gateway;
        this.istioIoApiNetworkingV1beta1HTTPFaultInjection = istioIoApiNetworkingV1beta1HTTPFaultInjection;
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionAbort = istioIoApiNetworkingV1beta1HTTPFaultInjectionAbort;
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortGrpcStatus = istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortGrpcStatus;
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttp2Error = istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttp2Error;
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttpStatus = istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttpStatus;
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionDelay = istioIoApiNetworkingV1beta1HTTPFaultInjectionDelay;
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayExponentialDelay = istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayExponentialDelay;
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayFixedDelay = istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayFixedDelay;
        this.istioIoApiNetworkingV1beta1HTTPMatchRequest = istioIoApiNetworkingV1beta1HTTPMatchRequest;
        this.istioIoApiNetworkingV1beta1HTTPRedirect = istioIoApiNetworkingV1beta1HTTPRedirect;
        this.istioIoApiNetworkingV1beta1HTTPRedirectDerivePort = istioIoApiNetworkingV1beta1HTTPRedirectDerivePort;
        this.istioIoApiNetworkingV1beta1HTTPRedirectPort = istioIoApiNetworkingV1beta1HTTPRedirectPort;
        this.istioIoApiNetworkingV1beta1HTTPRedirectRedirectPortSelection = istioIoApiNetworkingV1beta1HTTPRedirectRedirectPortSelection;
        this.istioIoApiNetworkingV1beta1HTTPRetry = istioIoApiNetworkingV1beta1HTTPRetry;
        this.istioIoApiNetworkingV1beta1HTTPRewrite = istioIoApiNetworkingV1beta1HTTPRewrite;
        this.istioIoApiNetworkingV1beta1HTTPRoute = istioIoApiNetworkingV1beta1HTTPRoute;
        this.istioIoApiNetworkingV1beta1HTTPRouteDestination = istioIoApiNetworkingV1beta1HTTPRouteDestination;
        this.istioIoApiNetworkingV1beta1Headers = istioIoApiNetworkingV1beta1Headers;
        this.istioIoApiNetworkingV1beta1HeadersHeaderOperations = istioIoApiNetworkingV1beta1HeadersHeaderOperations;
        this.istioIoApiNetworkingV1beta1IstioEgressListener = istioIoApiNetworkingV1beta1IstioEgressListener;
        this.istioIoApiNetworkingV1beta1IstioIngressListener = istioIoApiNetworkingV1beta1IstioIngressListener;
        this.istioIoApiNetworkingV1beta1L4MatchAttributes = istioIoApiNetworkingV1beta1L4MatchAttributes;
        this.istioIoApiNetworkingV1beta1LoadBalancerSettings = istioIoApiNetworkingV1beta1LoadBalancerSettings;
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHash = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHash;
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLB = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLB;
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHTTPCookie = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHTTPCookie;
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpCookie = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpCookie;
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpHeaderName = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpHeaderName;
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpQueryParameterName = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpQueryParameterName;
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBUseSourceIp = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBUseSourceIp;
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsSimple = istioIoApiNetworkingV1beta1LoadBalancerSettingsSimple;
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsSimpleLB = istioIoApiNetworkingV1beta1LoadBalancerSettingsSimpleLB;
        this.istioIoApiNetworkingV1beta1LocalityLoadBalancerSetting = istioIoApiNetworkingV1beta1LocalityLoadBalancerSetting;
        this.istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingDistribute = istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingDistribute;
        this.istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingFailover = istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingFailover;
        this.istioIoApiNetworkingV1beta1OutboundTrafficPolicy = istioIoApiNetworkingV1beta1OutboundTrafficPolicy;
        this.istioIoApiNetworkingV1beta1OutboundTrafficPolicyMode = istioIoApiNetworkingV1beta1OutboundTrafficPolicyMode;
        this.istioIoApiNetworkingV1beta1OutlierDetection = istioIoApiNetworkingV1beta1OutlierDetection;
        this.istioIoApiNetworkingV1beta1Percent = istioIoApiNetworkingV1beta1Percent;
        this.istioIoApiNetworkingV1beta1Port = istioIoApiNetworkingV1beta1Port;
        this.istioIoApiNetworkingV1beta1PortSelector = istioIoApiNetworkingV1beta1PortSelector;
        this.istioIoApiNetworkingV1beta1RouteDestination = istioIoApiNetworkingV1beta1RouteDestination;
        this.istioIoApiNetworkingV1beta1Server = istioIoApiNetworkingV1beta1Server;
        this.istioIoApiNetworkingV1beta1ServerTLSSettings = istioIoApiNetworkingV1beta1ServerTLSSettings;
        this.istioIoApiNetworkingV1beta1ServerTLSSettingsTLSProtocol = istioIoApiNetworkingV1beta1ServerTLSSettingsTLSProtocol;
        this.istioIoApiNetworkingV1beta1ServerTLSSettingsTLSmode = istioIoApiNetworkingV1beta1ServerTLSSettingsTLSmode;
        this.istioIoApiNetworkingV1beta1ServiceEntry = istioIoApiNetworkingV1beta1ServiceEntry;
        this.istioIoApiNetworkingV1beta1ServiceEntryLocation = istioIoApiNetworkingV1beta1ServiceEntryLocation;
        this.istioIoApiNetworkingV1beta1ServiceEntryResolution = istioIoApiNetworkingV1beta1ServiceEntryResolution;
        this.istioIoApiNetworkingV1beta1Sidecar = istioIoApiNetworkingV1beta1Sidecar;
        this.istioIoApiNetworkingV1beta1StringMatch = istioIoApiNetworkingV1beta1StringMatch;
        this.istioIoApiNetworkingV1beta1StringMatchExact = istioIoApiNetworkingV1beta1StringMatchExact;
        this.istioIoApiNetworkingV1beta1StringMatchPrefix = istioIoApiNetworkingV1beta1StringMatchPrefix;
        this.istioIoApiNetworkingV1beta1StringMatchRegex = istioIoApiNetworkingV1beta1StringMatchRegex;
        this.istioIoApiNetworkingV1beta1Subset = istioIoApiNetworkingV1beta1Subset;
        this.istioIoApiNetworkingV1beta1TCPRoute = istioIoApiNetworkingV1beta1TCPRoute;
        this.istioIoApiNetworkingV1beta1TLSMatchAttributes = istioIoApiNetworkingV1beta1TLSMatchAttributes;
        this.istioIoApiNetworkingV1beta1TLSRoute = istioIoApiNetworkingV1beta1TLSRoute;
        this.istioIoApiNetworkingV1beta1TrafficPolicy = istioIoApiNetworkingV1beta1TrafficPolicy;
        this.istioIoApiNetworkingV1beta1TrafficPolicyPortTrafficPolicy = istioIoApiNetworkingV1beta1TrafficPolicyPortTrafficPolicy;
        this.istioIoApiNetworkingV1beta1VirtualService = istioIoApiNetworkingV1beta1VirtualService;
        this.istioIoApiNetworkingV1beta1WorkloadEntry = istioIoApiNetworkingV1beta1WorkloadEntry;
        this.istioIoApiNetworkingV1beta1WorkloadSelector = istioIoApiNetworkingV1beta1WorkloadSelector;
        this.istioIoApiNetworkingV1beta1IsHTTPFaultInjectionAbortErrorType = istioIoApiNetworkingV1beta1IsHTTPFaultInjectionAbortErrorType;
        this.istioIoApiNetworkingV1beta1IsHTTPFaultInjectionDelayHttpDelayType = istioIoApiNetworkingV1beta1IsHTTPFaultInjectionDelayHttpDelayType;
        this.istioIoApiNetworkingV1beta1IsHTTPRedirectRedirectPort = istioIoApiNetworkingV1beta1IsHTTPRedirectRedirectPort;
        this.istioIoApiNetworkingV1beta1IsLoadBalancerSettingsConsistentHashLBHashKey = istioIoApiNetworkingV1beta1IsLoadBalancerSettingsConsistentHashLBHashKey;
        this.istioIoApiNetworkingV1beta1IsLoadBalancerSettingsLbPolicy = istioIoApiNetworkingV1beta1IsLoadBalancerSettingsLbPolicy;
        this.istioIoApiNetworkingV1beta1IsStringMatchMatchType = istioIoApiNetworkingV1beta1IsStringMatchMatchType;
        this.istioIoApiSecurityV1beta1AuthorizationPolicy = istioIoApiSecurityV1beta1AuthorizationPolicy;
        this.istioIoApiSecurityV1beta1AuthorizationPolicyAction = istioIoApiSecurityV1beta1AuthorizationPolicyAction;
        this.istioIoApiSecurityV1beta1AuthorizationPolicyExtensionProvider = istioIoApiSecurityV1beta1AuthorizationPolicyExtensionProvider;
        this.istioIoApiSecurityV1beta1AuthorizationPolicyProvider = istioIoApiSecurityV1beta1AuthorizationPolicyProvider;
        this.istioIoApiSecurityV1beta1Condition = istioIoApiSecurityV1beta1Condition;
        this.istioIoApiSecurityV1beta1JWTHeader = istioIoApiSecurityV1beta1JWTHeader;
        this.istioIoApiSecurityV1beta1JWTRule = istioIoApiSecurityV1beta1JWTRule;
        this.istioIoApiSecurityV1beta1Operation = istioIoApiSecurityV1beta1Operation;
        this.istioIoApiSecurityV1beta1PeerAuthentication = istioIoApiSecurityV1beta1PeerAuthentication;
        this.istioIoApiSecurityV1beta1PeerAuthenticationMutualTLS = istioIoApiSecurityV1beta1PeerAuthenticationMutualTLS;
        this.istioIoApiSecurityV1beta1PeerAuthenticationMutualTLSMode = istioIoApiSecurityV1beta1PeerAuthenticationMutualTLSMode;
        this.istioIoApiSecurityV1beta1RequestAuthentication = istioIoApiSecurityV1beta1RequestAuthentication;
        this.istioIoApiSecurityV1beta1Rule = istioIoApiSecurityV1beta1Rule;
        this.istioIoApiSecurityV1beta1RuleFrom = istioIoApiSecurityV1beta1RuleFrom;
        this.istioIoApiSecurityV1beta1RuleTo = istioIoApiSecurityV1beta1RuleTo;
        this.istioIoApiSecurityV1beta1Source = istioIoApiSecurityV1beta1Source;
        this.istioIoApiSecurityV1beta1IsAuthorizationPolicyActionDetail = istioIoApiSecurityV1beta1IsAuthorizationPolicyActionDetail;
        this.istioIoApiTypeV1beta1WorkloadSelector = istioIoApiTypeV1beta1WorkloadSelector;
        this.istioIoClientGoPkgApisNetworkingV1beta1DestinationRule = istioIoClientGoPkgApisNetworkingV1beta1DestinationRule;
        this.istioIoClientGoPkgApisNetworkingV1beta1DestinationRuleList = istioIoClientGoPkgApisNetworkingV1beta1DestinationRuleList;
        this.istioIoClientGoPkgApisNetworkingV1beta1Gateway = istioIoClientGoPkgApisNetworkingV1beta1Gateway;
        this.istioIoClientGoPkgApisNetworkingV1beta1GatewayList = istioIoClientGoPkgApisNetworkingV1beta1GatewayList;
        this.istioIoClientGoPkgApisNetworkingV1beta1ServiceEntry = istioIoClientGoPkgApisNetworkingV1beta1ServiceEntry;
        this.istioIoClientGoPkgApisNetworkingV1beta1ServiceEntryList = istioIoClientGoPkgApisNetworkingV1beta1ServiceEntryList;
        this.istioIoClientGoPkgApisNetworkingV1beta1Sidecar = istioIoClientGoPkgApisNetworkingV1beta1Sidecar;
        this.istioIoClientGoPkgApisNetworkingV1beta1SidecarList = istioIoClientGoPkgApisNetworkingV1beta1SidecarList;
        this.istioIoClientGoPkgApisNetworkingV1beta1VirtualService = istioIoClientGoPkgApisNetworkingV1beta1VirtualService;
        this.istioIoClientGoPkgApisNetworkingV1beta1VirtualServiceList = istioIoClientGoPkgApisNetworkingV1beta1VirtualServiceList;
        this.istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntry = istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntry;
        this.istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntryList = istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntryList;
        this.istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicy = istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicy;
        this.istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicyList = istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicyList;
        this.istioIoClientGoPkgApisSecurityV1beta1PeerAuthentication = istioIoClientGoPkgApisSecurityV1beta1PeerAuthentication;
        this.istioIoClientGoPkgApisSecurityV1beta1PeerAuthenticationList = istioIoClientGoPkgApisSecurityV1beta1PeerAuthenticationList;
        this.istioIoClientGoPkgApisSecurityV1beta1RequestAuthentication = istioIoClientGoPkgApisSecurityV1beta1RequestAuthentication;
        this.istioIoClientGoPkgApisSecurityV1beta1RequestAuthenticationList = istioIoClientGoPkgApisSecurityV1beta1RequestAuthenticationList;
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

    @JsonProperty("istio_io_api_networking_v1beta1_CaptureMode")
    public CaptureMode getIstioIoApiNetworkingV1beta1CaptureMode() {
        return istioIoApiNetworkingV1beta1CaptureMode;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_CaptureMode")
    public void setIstioIoApiNetworkingV1beta1CaptureMode(CaptureMode istioIoApiNetworkingV1beta1CaptureMode) {
        this.istioIoApiNetworkingV1beta1CaptureMode = istioIoApiNetworkingV1beta1CaptureMode;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ClientTLSSettings")
    public ClientTLSSettings getIstioIoApiNetworkingV1beta1ClientTLSSettings() {
        return istioIoApiNetworkingV1beta1ClientTLSSettings;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ClientTLSSettings")
    public void setIstioIoApiNetworkingV1beta1ClientTLSSettings(ClientTLSSettings istioIoApiNetworkingV1beta1ClientTLSSettings) {
        this.istioIoApiNetworkingV1beta1ClientTLSSettings = istioIoApiNetworkingV1beta1ClientTLSSettings;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ClientTLSSettings_TLSmode")
    public ClientTLSSettingsTLSmode getIstioIoApiNetworkingV1beta1ClientTLSSettingsTLSmode() {
        return istioIoApiNetworkingV1beta1ClientTLSSettingsTLSmode;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ClientTLSSettings_TLSmode")
    public void setIstioIoApiNetworkingV1beta1ClientTLSSettingsTLSmode(ClientTLSSettingsTLSmode istioIoApiNetworkingV1beta1ClientTLSSettingsTLSmode) {
        this.istioIoApiNetworkingV1beta1ClientTLSSettingsTLSmode = istioIoApiNetworkingV1beta1ClientTLSSettingsTLSmode;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings")
    public ConnectionPoolSettings getIstioIoApiNetworkingV1beta1ConnectionPoolSettings() {
        return istioIoApiNetworkingV1beta1ConnectionPoolSettings;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings")
    public void setIstioIoApiNetworkingV1beta1ConnectionPoolSettings(ConnectionPoolSettings istioIoApiNetworkingV1beta1ConnectionPoolSettings) {
        this.istioIoApiNetworkingV1beta1ConnectionPoolSettings = istioIoApiNetworkingV1beta1ConnectionPoolSettings;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings_HTTPSettings")
    public ConnectionPoolSettingsHTTPSettings getIstioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettings() {
        return istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettings;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings_HTTPSettings")
    public void setIstioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettings(ConnectionPoolSettingsHTTPSettings istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettings) {
        this.istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettings = istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettings;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings_HTTPSettings_H2UpgradePolicy")
    public ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy getIstioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy() {
        return istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings_HTTPSettings_H2UpgradePolicy")
    public void setIstioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy(ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy) {
        this.istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy = istioIoApiNetworkingV1beta1ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings_TCPSettings")
    public ConnectionPoolSettingsTCPSettings getIstioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettings() {
        return istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettings;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings_TCPSettings")
    public void setIstioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettings(ConnectionPoolSettingsTCPSettings istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettings) {
        this.istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettings = istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettings;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings_TCPSettings_TcpKeepalive")
    public ConnectionPoolSettingsTCPSettingsTcpKeepalive getIstioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettingsTcpKeepalive() {
        return istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettingsTcpKeepalive;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ConnectionPoolSettings_TCPSettings_TcpKeepalive")
    public void setIstioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettingsTcpKeepalive(ConnectionPoolSettingsTCPSettingsTcpKeepalive istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettingsTcpKeepalive) {
        this.istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettingsTcpKeepalive = istioIoApiNetworkingV1beta1ConnectionPoolSettingsTCPSettingsTcpKeepalive;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Delegate")
    public Delegate getIstioIoApiNetworkingV1beta1Delegate() {
        return istioIoApiNetworkingV1beta1Delegate;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Delegate")
    public void setIstioIoApiNetworkingV1beta1Delegate(Delegate istioIoApiNetworkingV1beta1Delegate) {
        this.istioIoApiNetworkingV1beta1Delegate = istioIoApiNetworkingV1beta1Delegate;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Destination")
    public Destination getIstioIoApiNetworkingV1beta1Destination() {
        return istioIoApiNetworkingV1beta1Destination;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Destination")
    public void setIstioIoApiNetworkingV1beta1Destination(Destination istioIoApiNetworkingV1beta1Destination) {
        this.istioIoApiNetworkingV1beta1Destination = istioIoApiNetworkingV1beta1Destination;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_DestinationRule")
    public DestinationRuleSpec getIstioIoApiNetworkingV1beta1DestinationRule() {
        return istioIoApiNetworkingV1beta1DestinationRule;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_DestinationRule")
    public void setIstioIoApiNetworkingV1beta1DestinationRule(DestinationRuleSpec istioIoApiNetworkingV1beta1DestinationRule) {
        this.istioIoApiNetworkingV1beta1DestinationRule = istioIoApiNetworkingV1beta1DestinationRule;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Gateway")
    public GatewaySpec getIstioIoApiNetworkingV1beta1Gateway() {
        return istioIoApiNetworkingV1beta1Gateway;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Gateway")
    public void setIstioIoApiNetworkingV1beta1Gateway(GatewaySpec istioIoApiNetworkingV1beta1Gateway) {
        this.istioIoApiNetworkingV1beta1Gateway = istioIoApiNetworkingV1beta1Gateway;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection")
    public HTTPFaultInjection getIstioIoApiNetworkingV1beta1HTTPFaultInjection() {
        return istioIoApiNetworkingV1beta1HTTPFaultInjection;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection")
    public void setIstioIoApiNetworkingV1beta1HTTPFaultInjection(HTTPFaultInjection istioIoApiNetworkingV1beta1HTTPFaultInjection) {
        this.istioIoApiNetworkingV1beta1HTTPFaultInjection = istioIoApiNetworkingV1beta1HTTPFaultInjection;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort")
    public HTTPFaultInjectionAbort getIstioIoApiNetworkingV1beta1HTTPFaultInjectionAbort() {
        return istioIoApiNetworkingV1beta1HTTPFaultInjectionAbort;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort")
    public void setIstioIoApiNetworkingV1beta1HTTPFaultInjectionAbort(HTTPFaultInjectionAbort istioIoApiNetworkingV1beta1HTTPFaultInjectionAbort) {
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionAbort = istioIoApiNetworkingV1beta1HTTPFaultInjectionAbort;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort_GrpcStatus")
    public HTTPFaultInjectionAbortGrpcStatus getIstioIoApiNetworkingV1beta1HTTPFaultInjectionAbortGrpcStatus() {
        return istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortGrpcStatus;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort_GrpcStatus")
    public void setIstioIoApiNetworkingV1beta1HTTPFaultInjectionAbortGrpcStatus(HTTPFaultInjectionAbortGrpcStatus istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortGrpcStatus) {
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortGrpcStatus = istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortGrpcStatus;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort_Http2Error")
    public HTTPFaultInjectionAbortHttp2Error getIstioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttp2Error() {
        return istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttp2Error;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort_Http2Error")
    public void setIstioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttp2Error(HTTPFaultInjectionAbortHttp2Error istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttp2Error) {
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttp2Error = istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttp2Error;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort_HttpStatus")
    public HTTPFaultInjectionAbortHttpStatus getIstioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttpStatus() {
        return istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttpStatus;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Abort_HttpStatus")
    public void setIstioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttpStatus(HTTPFaultInjectionAbortHttpStatus istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttpStatus) {
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttpStatus = istioIoApiNetworkingV1beta1HTTPFaultInjectionAbortHttpStatus;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Delay")
    public HTTPFaultInjectionDelay getIstioIoApiNetworkingV1beta1HTTPFaultInjectionDelay() {
        return istioIoApiNetworkingV1beta1HTTPFaultInjectionDelay;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Delay")
    public void setIstioIoApiNetworkingV1beta1HTTPFaultInjectionDelay(HTTPFaultInjectionDelay istioIoApiNetworkingV1beta1HTTPFaultInjectionDelay) {
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionDelay = istioIoApiNetworkingV1beta1HTTPFaultInjectionDelay;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Delay_ExponentialDelay")
    public HTTPFaultInjectionDelayExponentialDelay getIstioIoApiNetworkingV1beta1HTTPFaultInjectionDelayExponentialDelay() {
        return istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayExponentialDelay;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Delay_ExponentialDelay")
    public void setIstioIoApiNetworkingV1beta1HTTPFaultInjectionDelayExponentialDelay(HTTPFaultInjectionDelayExponentialDelay istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayExponentialDelay) {
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayExponentialDelay = istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayExponentialDelay;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Delay_FixedDelay")
    public HTTPFaultInjectionDelayFixedDelay getIstioIoApiNetworkingV1beta1HTTPFaultInjectionDelayFixedDelay() {
        return istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayFixedDelay;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPFaultInjection_Delay_FixedDelay")
    public void setIstioIoApiNetworkingV1beta1HTTPFaultInjectionDelayFixedDelay(HTTPFaultInjectionDelayFixedDelay istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayFixedDelay) {
        this.istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayFixedDelay = istioIoApiNetworkingV1beta1HTTPFaultInjectionDelayFixedDelay;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPMatchRequest")
    public HTTPMatchRequest getIstioIoApiNetworkingV1beta1HTTPMatchRequest() {
        return istioIoApiNetworkingV1beta1HTTPMatchRequest;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPMatchRequest")
    public void setIstioIoApiNetworkingV1beta1HTTPMatchRequest(HTTPMatchRequest istioIoApiNetworkingV1beta1HTTPMatchRequest) {
        this.istioIoApiNetworkingV1beta1HTTPMatchRequest = istioIoApiNetworkingV1beta1HTTPMatchRequest;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRedirect")
    public HTTPRedirect getIstioIoApiNetworkingV1beta1HTTPRedirect() {
        return istioIoApiNetworkingV1beta1HTTPRedirect;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRedirect")
    public void setIstioIoApiNetworkingV1beta1HTTPRedirect(HTTPRedirect istioIoApiNetworkingV1beta1HTTPRedirect) {
        this.istioIoApiNetworkingV1beta1HTTPRedirect = istioIoApiNetworkingV1beta1HTTPRedirect;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRedirect_DerivePort")
    public HTTPRedirectDerivePort getIstioIoApiNetworkingV1beta1HTTPRedirectDerivePort() {
        return istioIoApiNetworkingV1beta1HTTPRedirectDerivePort;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRedirect_DerivePort")
    public void setIstioIoApiNetworkingV1beta1HTTPRedirectDerivePort(HTTPRedirectDerivePort istioIoApiNetworkingV1beta1HTTPRedirectDerivePort) {
        this.istioIoApiNetworkingV1beta1HTTPRedirectDerivePort = istioIoApiNetworkingV1beta1HTTPRedirectDerivePort;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRedirect_Port")
    public HTTPRedirectPort getIstioIoApiNetworkingV1beta1HTTPRedirectPort() {
        return istioIoApiNetworkingV1beta1HTTPRedirectPort;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRedirect_Port")
    public void setIstioIoApiNetworkingV1beta1HTTPRedirectPort(HTTPRedirectPort istioIoApiNetworkingV1beta1HTTPRedirectPort) {
        this.istioIoApiNetworkingV1beta1HTTPRedirectPort = istioIoApiNetworkingV1beta1HTTPRedirectPort;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRedirect_RedirectPortSelection")
    public HTTPRedirectRedirectPortSelection getIstioIoApiNetworkingV1beta1HTTPRedirectRedirectPortSelection() {
        return istioIoApiNetworkingV1beta1HTTPRedirectRedirectPortSelection;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRedirect_RedirectPortSelection")
    public void setIstioIoApiNetworkingV1beta1HTTPRedirectRedirectPortSelection(HTTPRedirectRedirectPortSelection istioIoApiNetworkingV1beta1HTTPRedirectRedirectPortSelection) {
        this.istioIoApiNetworkingV1beta1HTTPRedirectRedirectPortSelection = istioIoApiNetworkingV1beta1HTTPRedirectRedirectPortSelection;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRetry")
    public HTTPRetry getIstioIoApiNetworkingV1beta1HTTPRetry() {
        return istioIoApiNetworkingV1beta1HTTPRetry;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRetry")
    public void setIstioIoApiNetworkingV1beta1HTTPRetry(HTTPRetry istioIoApiNetworkingV1beta1HTTPRetry) {
        this.istioIoApiNetworkingV1beta1HTTPRetry = istioIoApiNetworkingV1beta1HTTPRetry;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRewrite")
    public HTTPRewrite getIstioIoApiNetworkingV1beta1HTTPRewrite() {
        return istioIoApiNetworkingV1beta1HTTPRewrite;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRewrite")
    public void setIstioIoApiNetworkingV1beta1HTTPRewrite(HTTPRewrite istioIoApiNetworkingV1beta1HTTPRewrite) {
        this.istioIoApiNetworkingV1beta1HTTPRewrite = istioIoApiNetworkingV1beta1HTTPRewrite;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRoute")
    public HTTPRoute getIstioIoApiNetworkingV1beta1HTTPRoute() {
        return istioIoApiNetworkingV1beta1HTTPRoute;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRoute")
    public void setIstioIoApiNetworkingV1beta1HTTPRoute(HTTPRoute istioIoApiNetworkingV1beta1HTTPRoute) {
        this.istioIoApiNetworkingV1beta1HTTPRoute = istioIoApiNetworkingV1beta1HTTPRoute;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRouteDestination")
    public HTTPRouteDestination getIstioIoApiNetworkingV1beta1HTTPRouteDestination() {
        return istioIoApiNetworkingV1beta1HTTPRouteDestination;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_HTTPRouteDestination")
    public void setIstioIoApiNetworkingV1beta1HTTPRouteDestination(HTTPRouteDestination istioIoApiNetworkingV1beta1HTTPRouteDestination) {
        this.istioIoApiNetworkingV1beta1HTTPRouteDestination = istioIoApiNetworkingV1beta1HTTPRouteDestination;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Headers")
    public Headers getIstioIoApiNetworkingV1beta1Headers() {
        return istioIoApiNetworkingV1beta1Headers;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Headers")
    public void setIstioIoApiNetworkingV1beta1Headers(Headers istioIoApiNetworkingV1beta1Headers) {
        this.istioIoApiNetworkingV1beta1Headers = istioIoApiNetworkingV1beta1Headers;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Headers_HeaderOperations")
    public HeadersHeaderOperations getIstioIoApiNetworkingV1beta1HeadersHeaderOperations() {
        return istioIoApiNetworkingV1beta1HeadersHeaderOperations;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Headers_HeaderOperations")
    public void setIstioIoApiNetworkingV1beta1HeadersHeaderOperations(HeadersHeaderOperations istioIoApiNetworkingV1beta1HeadersHeaderOperations) {
        this.istioIoApiNetworkingV1beta1HeadersHeaderOperations = istioIoApiNetworkingV1beta1HeadersHeaderOperations;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_IstioEgressListener")
    public IstioEgressListener getIstioIoApiNetworkingV1beta1IstioEgressListener() {
        return istioIoApiNetworkingV1beta1IstioEgressListener;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_IstioEgressListener")
    public void setIstioIoApiNetworkingV1beta1IstioEgressListener(IstioEgressListener istioIoApiNetworkingV1beta1IstioEgressListener) {
        this.istioIoApiNetworkingV1beta1IstioEgressListener = istioIoApiNetworkingV1beta1IstioEgressListener;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_IstioIngressListener")
    public IstioIngressListener getIstioIoApiNetworkingV1beta1IstioIngressListener() {
        return istioIoApiNetworkingV1beta1IstioIngressListener;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_IstioIngressListener")
    public void setIstioIoApiNetworkingV1beta1IstioIngressListener(IstioIngressListener istioIoApiNetworkingV1beta1IstioIngressListener) {
        this.istioIoApiNetworkingV1beta1IstioIngressListener = istioIoApiNetworkingV1beta1IstioIngressListener;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_L4MatchAttributes")
    public L4MatchAttributes getIstioIoApiNetworkingV1beta1L4MatchAttributes() {
        return istioIoApiNetworkingV1beta1L4MatchAttributes;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_L4MatchAttributes")
    public void setIstioIoApiNetworkingV1beta1L4MatchAttributes(L4MatchAttributes istioIoApiNetworkingV1beta1L4MatchAttributes) {
        this.istioIoApiNetworkingV1beta1L4MatchAttributes = istioIoApiNetworkingV1beta1L4MatchAttributes;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings")
    public LoadBalancerSettings getIstioIoApiNetworkingV1beta1LoadBalancerSettings() {
        return istioIoApiNetworkingV1beta1LoadBalancerSettings;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings")
    public void setIstioIoApiNetworkingV1beta1LoadBalancerSettings(LoadBalancerSettings istioIoApiNetworkingV1beta1LoadBalancerSettings) {
        this.istioIoApiNetworkingV1beta1LoadBalancerSettings = istioIoApiNetworkingV1beta1LoadBalancerSettings;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHash")
    public LoadBalancerSettingsConsistentHash getIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHash() {
        return istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHash;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHash")
    public void setIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHash(LoadBalancerSettingsConsistentHash istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHash) {
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHash = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHash;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB")
    public LoadBalancerSettingsConsistentHashLB getIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLB() {
        return istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLB;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB")
    public void setIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLB(LoadBalancerSettingsConsistentHashLB istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLB) {
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLB = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLB;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HTTPCookie")
    public LoadBalancerSettingsConsistentHashLBHttpCookieValue getIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHTTPCookie() {
        return istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHTTPCookie;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HTTPCookie")
    public void setIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHTTPCookie(LoadBalancerSettingsConsistentHashLBHttpCookieValue istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHTTPCookie) {
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHTTPCookie = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHTTPCookie;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HttpCookie")
    public LoadBalancerSettingsConsistentHashLBHttpCookie getIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpCookie() {
        return istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpCookie;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HttpCookie")
    public void setIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpCookie(LoadBalancerSettingsConsistentHashLBHttpCookie istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpCookie) {
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpCookie = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpCookie;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HttpHeaderName")
    public LoadBalancerSettingsConsistentHashLBHttpHeaderName getIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpHeaderName() {
        return istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpHeaderName;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HttpHeaderName")
    public void setIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpHeaderName(LoadBalancerSettingsConsistentHashLBHttpHeaderName istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpHeaderName) {
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpHeaderName = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpHeaderName;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HttpQueryParameterName")
    public LoadBalancerSettingsConsistentHashLBHttpQueryParameterName getIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpQueryParameterName() {
        return istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpQueryParameterName;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_HttpQueryParameterName")
    public void setIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpQueryParameterName(LoadBalancerSettingsConsistentHashLBHttpQueryParameterName istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpQueryParameterName) {
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpQueryParameterName = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBHttpQueryParameterName;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_UseSourceIp")
    public LoadBalancerSettingsConsistentHashLBUseSourceIp getIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBUseSourceIp() {
        return istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBUseSourceIp;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_ConsistentHashLB_UseSourceIp")
    public void setIstioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBUseSourceIp(LoadBalancerSettingsConsistentHashLBUseSourceIp istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBUseSourceIp) {
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBUseSourceIp = istioIoApiNetworkingV1beta1LoadBalancerSettingsConsistentHashLBUseSourceIp;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_Simple")
    public LoadBalancerSettingsSimple getIstioIoApiNetworkingV1beta1LoadBalancerSettingsSimple() {
        return istioIoApiNetworkingV1beta1LoadBalancerSettingsSimple;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_Simple")
    public void setIstioIoApiNetworkingV1beta1LoadBalancerSettingsSimple(LoadBalancerSettingsSimple istioIoApiNetworkingV1beta1LoadBalancerSettingsSimple) {
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsSimple = istioIoApiNetworkingV1beta1LoadBalancerSettingsSimple;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_SimpleLB")
    public LoadBalancerSettingsSimpleLB getIstioIoApiNetworkingV1beta1LoadBalancerSettingsSimpleLB() {
        return istioIoApiNetworkingV1beta1LoadBalancerSettingsSimpleLB;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LoadBalancerSettings_SimpleLB")
    public void setIstioIoApiNetworkingV1beta1LoadBalancerSettingsSimpleLB(LoadBalancerSettingsSimpleLB istioIoApiNetworkingV1beta1LoadBalancerSettingsSimpleLB) {
        this.istioIoApiNetworkingV1beta1LoadBalancerSettingsSimpleLB = istioIoApiNetworkingV1beta1LoadBalancerSettingsSimpleLB;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LocalityLoadBalancerSetting")
    public LocalityLoadBalancerSetting getIstioIoApiNetworkingV1beta1LocalityLoadBalancerSetting() {
        return istioIoApiNetworkingV1beta1LocalityLoadBalancerSetting;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LocalityLoadBalancerSetting")
    public void setIstioIoApiNetworkingV1beta1LocalityLoadBalancerSetting(LocalityLoadBalancerSetting istioIoApiNetworkingV1beta1LocalityLoadBalancerSetting) {
        this.istioIoApiNetworkingV1beta1LocalityLoadBalancerSetting = istioIoApiNetworkingV1beta1LocalityLoadBalancerSetting;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LocalityLoadBalancerSetting_Distribute")
    public LocalityLoadBalancerSettingDistribute getIstioIoApiNetworkingV1beta1LocalityLoadBalancerSettingDistribute() {
        return istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingDistribute;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LocalityLoadBalancerSetting_Distribute")
    public void setIstioIoApiNetworkingV1beta1LocalityLoadBalancerSettingDistribute(LocalityLoadBalancerSettingDistribute istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingDistribute) {
        this.istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingDistribute = istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingDistribute;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LocalityLoadBalancerSetting_Failover")
    public LocalityLoadBalancerSettingFailover getIstioIoApiNetworkingV1beta1LocalityLoadBalancerSettingFailover() {
        return istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingFailover;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_LocalityLoadBalancerSetting_Failover")
    public void setIstioIoApiNetworkingV1beta1LocalityLoadBalancerSettingFailover(LocalityLoadBalancerSettingFailover istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingFailover) {
        this.istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingFailover = istioIoApiNetworkingV1beta1LocalityLoadBalancerSettingFailover;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_OutboundTrafficPolicy")
    public OutboundTrafficPolicy getIstioIoApiNetworkingV1beta1OutboundTrafficPolicy() {
        return istioIoApiNetworkingV1beta1OutboundTrafficPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_OutboundTrafficPolicy")
    public void setIstioIoApiNetworkingV1beta1OutboundTrafficPolicy(OutboundTrafficPolicy istioIoApiNetworkingV1beta1OutboundTrafficPolicy) {
        this.istioIoApiNetworkingV1beta1OutboundTrafficPolicy = istioIoApiNetworkingV1beta1OutboundTrafficPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_OutboundTrafficPolicy_Mode")
    public OutboundTrafficPolicyMode getIstioIoApiNetworkingV1beta1OutboundTrafficPolicyMode() {
        return istioIoApiNetworkingV1beta1OutboundTrafficPolicyMode;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_OutboundTrafficPolicy_Mode")
    public void setIstioIoApiNetworkingV1beta1OutboundTrafficPolicyMode(OutboundTrafficPolicyMode istioIoApiNetworkingV1beta1OutboundTrafficPolicyMode) {
        this.istioIoApiNetworkingV1beta1OutboundTrafficPolicyMode = istioIoApiNetworkingV1beta1OutboundTrafficPolicyMode;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_OutlierDetection")
    public OutlierDetection getIstioIoApiNetworkingV1beta1OutlierDetection() {
        return istioIoApiNetworkingV1beta1OutlierDetection;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_OutlierDetection")
    public void setIstioIoApiNetworkingV1beta1OutlierDetection(OutlierDetection istioIoApiNetworkingV1beta1OutlierDetection) {
        this.istioIoApiNetworkingV1beta1OutlierDetection = istioIoApiNetworkingV1beta1OutlierDetection;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Percent")
    public Percent getIstioIoApiNetworkingV1beta1Percent() {
        return istioIoApiNetworkingV1beta1Percent;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Percent")
    public void setIstioIoApiNetworkingV1beta1Percent(Percent istioIoApiNetworkingV1beta1Percent) {
        this.istioIoApiNetworkingV1beta1Percent = istioIoApiNetworkingV1beta1Percent;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Port")
    public Port getIstioIoApiNetworkingV1beta1Port() {
        return istioIoApiNetworkingV1beta1Port;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Port")
    public void setIstioIoApiNetworkingV1beta1Port(Port istioIoApiNetworkingV1beta1Port) {
        this.istioIoApiNetworkingV1beta1Port = istioIoApiNetworkingV1beta1Port;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_PortSelector")
    public PortSelector getIstioIoApiNetworkingV1beta1PortSelector() {
        return istioIoApiNetworkingV1beta1PortSelector;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_PortSelector")
    public void setIstioIoApiNetworkingV1beta1PortSelector(PortSelector istioIoApiNetworkingV1beta1PortSelector) {
        this.istioIoApiNetworkingV1beta1PortSelector = istioIoApiNetworkingV1beta1PortSelector;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_RouteDestination")
    public RouteDestination getIstioIoApiNetworkingV1beta1RouteDestination() {
        return istioIoApiNetworkingV1beta1RouteDestination;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_RouteDestination")
    public void setIstioIoApiNetworkingV1beta1RouteDestination(RouteDestination istioIoApiNetworkingV1beta1RouteDestination) {
        this.istioIoApiNetworkingV1beta1RouteDestination = istioIoApiNetworkingV1beta1RouteDestination;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Server")
    public Server getIstioIoApiNetworkingV1beta1Server() {
        return istioIoApiNetworkingV1beta1Server;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Server")
    public void setIstioIoApiNetworkingV1beta1Server(Server istioIoApiNetworkingV1beta1Server) {
        this.istioIoApiNetworkingV1beta1Server = istioIoApiNetworkingV1beta1Server;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ServerTLSSettings")
    public ServerTLSSettings getIstioIoApiNetworkingV1beta1ServerTLSSettings() {
        return istioIoApiNetworkingV1beta1ServerTLSSettings;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ServerTLSSettings")
    public void setIstioIoApiNetworkingV1beta1ServerTLSSettings(ServerTLSSettings istioIoApiNetworkingV1beta1ServerTLSSettings) {
        this.istioIoApiNetworkingV1beta1ServerTLSSettings = istioIoApiNetworkingV1beta1ServerTLSSettings;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ServerTLSSettings_TLSProtocol")
    public ServerTLSSettingsTLSProtocol getIstioIoApiNetworkingV1beta1ServerTLSSettingsTLSProtocol() {
        return istioIoApiNetworkingV1beta1ServerTLSSettingsTLSProtocol;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ServerTLSSettings_TLSProtocol")
    public void setIstioIoApiNetworkingV1beta1ServerTLSSettingsTLSProtocol(ServerTLSSettingsTLSProtocol istioIoApiNetworkingV1beta1ServerTLSSettingsTLSProtocol) {
        this.istioIoApiNetworkingV1beta1ServerTLSSettingsTLSProtocol = istioIoApiNetworkingV1beta1ServerTLSSettingsTLSProtocol;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ServerTLSSettings_TLSmode")
    public ServerTLSSettingsTLSmode getIstioIoApiNetworkingV1beta1ServerTLSSettingsTLSmode() {
        return istioIoApiNetworkingV1beta1ServerTLSSettingsTLSmode;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ServerTLSSettings_TLSmode")
    public void setIstioIoApiNetworkingV1beta1ServerTLSSettingsTLSmode(ServerTLSSettingsTLSmode istioIoApiNetworkingV1beta1ServerTLSSettingsTLSmode) {
        this.istioIoApiNetworkingV1beta1ServerTLSSettingsTLSmode = istioIoApiNetworkingV1beta1ServerTLSSettingsTLSmode;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ServiceEntry")
    public ServiceEntrySpec getIstioIoApiNetworkingV1beta1ServiceEntry() {
        return istioIoApiNetworkingV1beta1ServiceEntry;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ServiceEntry")
    public void setIstioIoApiNetworkingV1beta1ServiceEntry(ServiceEntrySpec istioIoApiNetworkingV1beta1ServiceEntry) {
        this.istioIoApiNetworkingV1beta1ServiceEntry = istioIoApiNetworkingV1beta1ServiceEntry;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ServiceEntry_Location")
    public ServiceEntryLocation getIstioIoApiNetworkingV1beta1ServiceEntryLocation() {
        return istioIoApiNetworkingV1beta1ServiceEntryLocation;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ServiceEntry_Location")
    public void setIstioIoApiNetworkingV1beta1ServiceEntryLocation(ServiceEntryLocation istioIoApiNetworkingV1beta1ServiceEntryLocation) {
        this.istioIoApiNetworkingV1beta1ServiceEntryLocation = istioIoApiNetworkingV1beta1ServiceEntryLocation;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ServiceEntry_Resolution")
    public ServiceEntryResolution getIstioIoApiNetworkingV1beta1ServiceEntryResolution() {
        return istioIoApiNetworkingV1beta1ServiceEntryResolution;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_ServiceEntry_Resolution")
    public void setIstioIoApiNetworkingV1beta1ServiceEntryResolution(ServiceEntryResolution istioIoApiNetworkingV1beta1ServiceEntryResolution) {
        this.istioIoApiNetworkingV1beta1ServiceEntryResolution = istioIoApiNetworkingV1beta1ServiceEntryResolution;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Sidecar")
    public SidecarSpec getIstioIoApiNetworkingV1beta1Sidecar() {
        return istioIoApiNetworkingV1beta1Sidecar;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Sidecar")
    public void setIstioIoApiNetworkingV1beta1Sidecar(SidecarSpec istioIoApiNetworkingV1beta1Sidecar) {
        this.istioIoApiNetworkingV1beta1Sidecar = istioIoApiNetworkingV1beta1Sidecar;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_StringMatch")
    public StringMatch getIstioIoApiNetworkingV1beta1StringMatch() {
        return istioIoApiNetworkingV1beta1StringMatch;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_StringMatch")
    public void setIstioIoApiNetworkingV1beta1StringMatch(StringMatch istioIoApiNetworkingV1beta1StringMatch) {
        this.istioIoApiNetworkingV1beta1StringMatch = istioIoApiNetworkingV1beta1StringMatch;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_StringMatch_Exact")
    public StringMatchExact getIstioIoApiNetworkingV1beta1StringMatchExact() {
        return istioIoApiNetworkingV1beta1StringMatchExact;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_StringMatch_Exact")
    public void setIstioIoApiNetworkingV1beta1StringMatchExact(StringMatchExact istioIoApiNetworkingV1beta1StringMatchExact) {
        this.istioIoApiNetworkingV1beta1StringMatchExact = istioIoApiNetworkingV1beta1StringMatchExact;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_StringMatch_Prefix")
    public StringMatchPrefix getIstioIoApiNetworkingV1beta1StringMatchPrefix() {
        return istioIoApiNetworkingV1beta1StringMatchPrefix;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_StringMatch_Prefix")
    public void setIstioIoApiNetworkingV1beta1StringMatchPrefix(StringMatchPrefix istioIoApiNetworkingV1beta1StringMatchPrefix) {
        this.istioIoApiNetworkingV1beta1StringMatchPrefix = istioIoApiNetworkingV1beta1StringMatchPrefix;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_StringMatch_Regex")
    public StringMatchRegex getIstioIoApiNetworkingV1beta1StringMatchRegex() {
        return istioIoApiNetworkingV1beta1StringMatchRegex;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_StringMatch_Regex")
    public void setIstioIoApiNetworkingV1beta1StringMatchRegex(StringMatchRegex istioIoApiNetworkingV1beta1StringMatchRegex) {
        this.istioIoApiNetworkingV1beta1StringMatchRegex = istioIoApiNetworkingV1beta1StringMatchRegex;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Subset")
    public Subset getIstioIoApiNetworkingV1beta1Subset() {
        return istioIoApiNetworkingV1beta1Subset;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_Subset")
    public void setIstioIoApiNetworkingV1beta1Subset(Subset istioIoApiNetworkingV1beta1Subset) {
        this.istioIoApiNetworkingV1beta1Subset = istioIoApiNetworkingV1beta1Subset;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_TCPRoute")
    public TCPRoute getIstioIoApiNetworkingV1beta1TCPRoute() {
        return istioIoApiNetworkingV1beta1TCPRoute;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_TCPRoute")
    public void setIstioIoApiNetworkingV1beta1TCPRoute(TCPRoute istioIoApiNetworkingV1beta1TCPRoute) {
        this.istioIoApiNetworkingV1beta1TCPRoute = istioIoApiNetworkingV1beta1TCPRoute;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_TLSMatchAttributes")
    public TLSMatchAttributes getIstioIoApiNetworkingV1beta1TLSMatchAttributes() {
        return istioIoApiNetworkingV1beta1TLSMatchAttributes;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_TLSMatchAttributes")
    public void setIstioIoApiNetworkingV1beta1TLSMatchAttributes(TLSMatchAttributes istioIoApiNetworkingV1beta1TLSMatchAttributes) {
        this.istioIoApiNetworkingV1beta1TLSMatchAttributes = istioIoApiNetworkingV1beta1TLSMatchAttributes;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_TLSRoute")
    public TLSRoute getIstioIoApiNetworkingV1beta1TLSRoute() {
        return istioIoApiNetworkingV1beta1TLSRoute;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_TLSRoute")
    public void setIstioIoApiNetworkingV1beta1TLSRoute(TLSRoute istioIoApiNetworkingV1beta1TLSRoute) {
        this.istioIoApiNetworkingV1beta1TLSRoute = istioIoApiNetworkingV1beta1TLSRoute;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_TrafficPolicy")
    public TrafficPolicy getIstioIoApiNetworkingV1beta1TrafficPolicy() {
        return istioIoApiNetworkingV1beta1TrafficPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_TrafficPolicy")
    public void setIstioIoApiNetworkingV1beta1TrafficPolicy(TrafficPolicy istioIoApiNetworkingV1beta1TrafficPolicy) {
        this.istioIoApiNetworkingV1beta1TrafficPolicy = istioIoApiNetworkingV1beta1TrafficPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_TrafficPolicy_PortTrafficPolicy")
    public TrafficPolicyPortTrafficPolicy getIstioIoApiNetworkingV1beta1TrafficPolicyPortTrafficPolicy() {
        return istioIoApiNetworkingV1beta1TrafficPolicyPortTrafficPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_TrafficPolicy_PortTrafficPolicy")
    public void setIstioIoApiNetworkingV1beta1TrafficPolicyPortTrafficPolicy(TrafficPolicyPortTrafficPolicy istioIoApiNetworkingV1beta1TrafficPolicyPortTrafficPolicy) {
        this.istioIoApiNetworkingV1beta1TrafficPolicyPortTrafficPolicy = istioIoApiNetworkingV1beta1TrafficPolicyPortTrafficPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_VirtualService")
    public VirtualServiceSpec getIstioIoApiNetworkingV1beta1VirtualService() {
        return istioIoApiNetworkingV1beta1VirtualService;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_VirtualService")
    public void setIstioIoApiNetworkingV1beta1VirtualService(VirtualServiceSpec istioIoApiNetworkingV1beta1VirtualService) {
        this.istioIoApiNetworkingV1beta1VirtualService = istioIoApiNetworkingV1beta1VirtualService;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_WorkloadEntry")
    public WorkloadEntrySpec getIstioIoApiNetworkingV1beta1WorkloadEntry() {
        return istioIoApiNetworkingV1beta1WorkloadEntry;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_WorkloadEntry")
    public void setIstioIoApiNetworkingV1beta1WorkloadEntry(WorkloadEntrySpec istioIoApiNetworkingV1beta1WorkloadEntry) {
        this.istioIoApiNetworkingV1beta1WorkloadEntry = istioIoApiNetworkingV1beta1WorkloadEntry;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_WorkloadSelector")
    public io.fabric8.istio.api.networking.v1beta1.WorkloadSelector getIstioIoApiNetworkingV1beta1WorkloadSelector() {
        return istioIoApiNetworkingV1beta1WorkloadSelector;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_WorkloadSelector")
    public void setIstioIoApiNetworkingV1beta1WorkloadSelector(io.fabric8.istio.api.networking.v1beta1.WorkloadSelector istioIoApiNetworkingV1beta1WorkloadSelector) {
        this.istioIoApiNetworkingV1beta1WorkloadSelector = istioIoApiNetworkingV1beta1WorkloadSelector;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_isHTTPFaultInjection_Abort_ErrorType")
    public IsHTTPFaultInjectionAbortErrorType getIstioIoApiNetworkingV1beta1IsHTTPFaultInjectionAbortErrorType() {
        return istioIoApiNetworkingV1beta1IsHTTPFaultInjectionAbortErrorType;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_isHTTPFaultInjection_Abort_ErrorType")
    public void setIstioIoApiNetworkingV1beta1IsHTTPFaultInjectionAbortErrorType(IsHTTPFaultInjectionAbortErrorType istioIoApiNetworkingV1beta1IsHTTPFaultInjectionAbortErrorType) {
        this.istioIoApiNetworkingV1beta1IsHTTPFaultInjectionAbortErrorType = istioIoApiNetworkingV1beta1IsHTTPFaultInjectionAbortErrorType;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_isHTTPFaultInjection_Delay_HttpDelayType")
    public IsHTTPFaultInjectionDelayHttpDelayType getIstioIoApiNetworkingV1beta1IsHTTPFaultInjectionDelayHttpDelayType() {
        return istioIoApiNetworkingV1beta1IsHTTPFaultInjectionDelayHttpDelayType;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_isHTTPFaultInjection_Delay_HttpDelayType")
    public void setIstioIoApiNetworkingV1beta1IsHTTPFaultInjectionDelayHttpDelayType(IsHTTPFaultInjectionDelayHttpDelayType istioIoApiNetworkingV1beta1IsHTTPFaultInjectionDelayHttpDelayType) {
        this.istioIoApiNetworkingV1beta1IsHTTPFaultInjectionDelayHttpDelayType = istioIoApiNetworkingV1beta1IsHTTPFaultInjectionDelayHttpDelayType;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_isHTTPRedirect_RedirectPort")
    public IsHTTPRedirectRedirectPort getIstioIoApiNetworkingV1beta1IsHTTPRedirectRedirectPort() {
        return istioIoApiNetworkingV1beta1IsHTTPRedirectRedirectPort;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_isHTTPRedirect_RedirectPort")
    public void setIstioIoApiNetworkingV1beta1IsHTTPRedirectRedirectPort(IsHTTPRedirectRedirectPort istioIoApiNetworkingV1beta1IsHTTPRedirectRedirectPort) {
        this.istioIoApiNetworkingV1beta1IsHTTPRedirectRedirectPort = istioIoApiNetworkingV1beta1IsHTTPRedirectRedirectPort;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_isLoadBalancerSettings_ConsistentHashLB_HashKey")
    public IsLoadBalancerSettingsConsistentHashLBHashKey getIstioIoApiNetworkingV1beta1IsLoadBalancerSettingsConsistentHashLBHashKey() {
        return istioIoApiNetworkingV1beta1IsLoadBalancerSettingsConsistentHashLBHashKey;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_isLoadBalancerSettings_ConsistentHashLB_HashKey")
    public void setIstioIoApiNetworkingV1beta1IsLoadBalancerSettingsConsistentHashLBHashKey(IsLoadBalancerSettingsConsistentHashLBHashKey istioIoApiNetworkingV1beta1IsLoadBalancerSettingsConsistentHashLBHashKey) {
        this.istioIoApiNetworkingV1beta1IsLoadBalancerSettingsConsistentHashLBHashKey = istioIoApiNetworkingV1beta1IsLoadBalancerSettingsConsistentHashLBHashKey;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_isLoadBalancerSettings_LbPolicy")
    public IsLoadBalancerSettingsLbPolicy getIstioIoApiNetworkingV1beta1IsLoadBalancerSettingsLbPolicy() {
        return istioIoApiNetworkingV1beta1IsLoadBalancerSettingsLbPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_isLoadBalancerSettings_LbPolicy")
    public void setIstioIoApiNetworkingV1beta1IsLoadBalancerSettingsLbPolicy(IsLoadBalancerSettingsLbPolicy istioIoApiNetworkingV1beta1IsLoadBalancerSettingsLbPolicy) {
        this.istioIoApiNetworkingV1beta1IsLoadBalancerSettingsLbPolicy = istioIoApiNetworkingV1beta1IsLoadBalancerSettingsLbPolicy;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_isStringMatch_MatchType")
    public IsStringMatchMatchType getIstioIoApiNetworkingV1beta1IsStringMatchMatchType() {
        return istioIoApiNetworkingV1beta1IsStringMatchMatchType;
    }

    @JsonProperty("istio_io_api_networking_v1beta1_isStringMatch_MatchType")
    public void setIstioIoApiNetworkingV1beta1IsStringMatchMatchType(IsStringMatchMatchType istioIoApiNetworkingV1beta1IsStringMatchMatchType) {
        this.istioIoApiNetworkingV1beta1IsStringMatchMatchType = istioIoApiNetworkingV1beta1IsStringMatchMatchType;
    }

    @JsonProperty("istio_io_api_security_v1beta1_AuthorizationPolicy")
    public AuthorizationPolicySpec getIstioIoApiSecurityV1beta1AuthorizationPolicy() {
        return istioIoApiSecurityV1beta1AuthorizationPolicy;
    }

    @JsonProperty("istio_io_api_security_v1beta1_AuthorizationPolicy")
    public void setIstioIoApiSecurityV1beta1AuthorizationPolicy(AuthorizationPolicySpec istioIoApiSecurityV1beta1AuthorizationPolicy) {
        this.istioIoApiSecurityV1beta1AuthorizationPolicy = istioIoApiSecurityV1beta1AuthorizationPolicy;
    }

    @JsonProperty("istio_io_api_security_v1beta1_AuthorizationPolicy_Action")
    public AuthorizationPolicyAction getIstioIoApiSecurityV1beta1AuthorizationPolicyAction() {
        return istioIoApiSecurityV1beta1AuthorizationPolicyAction;
    }

    @JsonProperty("istio_io_api_security_v1beta1_AuthorizationPolicy_Action")
    public void setIstioIoApiSecurityV1beta1AuthorizationPolicyAction(AuthorizationPolicyAction istioIoApiSecurityV1beta1AuthorizationPolicyAction) {
        this.istioIoApiSecurityV1beta1AuthorizationPolicyAction = istioIoApiSecurityV1beta1AuthorizationPolicyAction;
    }

    @JsonProperty("istio_io_api_security_v1beta1_AuthorizationPolicy_ExtensionProvider")
    public AuthorizationPolicyExtensionProvider getIstioIoApiSecurityV1beta1AuthorizationPolicyExtensionProvider() {
        return istioIoApiSecurityV1beta1AuthorizationPolicyExtensionProvider;
    }

    @JsonProperty("istio_io_api_security_v1beta1_AuthorizationPolicy_ExtensionProvider")
    public void setIstioIoApiSecurityV1beta1AuthorizationPolicyExtensionProvider(AuthorizationPolicyExtensionProvider istioIoApiSecurityV1beta1AuthorizationPolicyExtensionProvider) {
        this.istioIoApiSecurityV1beta1AuthorizationPolicyExtensionProvider = istioIoApiSecurityV1beta1AuthorizationPolicyExtensionProvider;
    }

    @JsonProperty("istio_io_api_security_v1beta1_AuthorizationPolicy_Provider")
    public AuthorizationPolicyProvider getIstioIoApiSecurityV1beta1AuthorizationPolicyProvider() {
        return istioIoApiSecurityV1beta1AuthorizationPolicyProvider;
    }

    @JsonProperty("istio_io_api_security_v1beta1_AuthorizationPolicy_Provider")
    public void setIstioIoApiSecurityV1beta1AuthorizationPolicyProvider(AuthorizationPolicyProvider istioIoApiSecurityV1beta1AuthorizationPolicyProvider) {
        this.istioIoApiSecurityV1beta1AuthorizationPolicyProvider = istioIoApiSecurityV1beta1AuthorizationPolicyProvider;
    }

    @JsonProperty("istio_io_api_security_v1beta1_Condition")
    public Condition getIstioIoApiSecurityV1beta1Condition() {
        return istioIoApiSecurityV1beta1Condition;
    }

    @JsonProperty("istio_io_api_security_v1beta1_Condition")
    public void setIstioIoApiSecurityV1beta1Condition(Condition istioIoApiSecurityV1beta1Condition) {
        this.istioIoApiSecurityV1beta1Condition = istioIoApiSecurityV1beta1Condition;
    }

    @JsonProperty("istio_io_api_security_v1beta1_JWTHeader")
    public JWTHeader getIstioIoApiSecurityV1beta1JWTHeader() {
        return istioIoApiSecurityV1beta1JWTHeader;
    }

    @JsonProperty("istio_io_api_security_v1beta1_JWTHeader")
    public void setIstioIoApiSecurityV1beta1JWTHeader(JWTHeader istioIoApiSecurityV1beta1JWTHeader) {
        this.istioIoApiSecurityV1beta1JWTHeader = istioIoApiSecurityV1beta1JWTHeader;
    }

    @JsonProperty("istio_io_api_security_v1beta1_JWTRule")
    public JWTRule getIstioIoApiSecurityV1beta1JWTRule() {
        return istioIoApiSecurityV1beta1JWTRule;
    }

    @JsonProperty("istio_io_api_security_v1beta1_JWTRule")
    public void setIstioIoApiSecurityV1beta1JWTRule(JWTRule istioIoApiSecurityV1beta1JWTRule) {
        this.istioIoApiSecurityV1beta1JWTRule = istioIoApiSecurityV1beta1JWTRule;
    }

    @JsonProperty("istio_io_api_security_v1beta1_Operation")
    public Operation getIstioIoApiSecurityV1beta1Operation() {
        return istioIoApiSecurityV1beta1Operation;
    }

    @JsonProperty("istio_io_api_security_v1beta1_Operation")
    public void setIstioIoApiSecurityV1beta1Operation(Operation istioIoApiSecurityV1beta1Operation) {
        this.istioIoApiSecurityV1beta1Operation = istioIoApiSecurityV1beta1Operation;
    }

    @JsonProperty("istio_io_api_security_v1beta1_PeerAuthentication")
    public PeerAuthenticationSpec getIstioIoApiSecurityV1beta1PeerAuthentication() {
        return istioIoApiSecurityV1beta1PeerAuthentication;
    }

    @JsonProperty("istio_io_api_security_v1beta1_PeerAuthentication")
    public void setIstioIoApiSecurityV1beta1PeerAuthentication(PeerAuthenticationSpec istioIoApiSecurityV1beta1PeerAuthentication) {
        this.istioIoApiSecurityV1beta1PeerAuthentication = istioIoApiSecurityV1beta1PeerAuthentication;
    }

    @JsonProperty("istio_io_api_security_v1beta1_PeerAuthentication_MutualTLS")
    public PeerAuthenticationMutualTLS getIstioIoApiSecurityV1beta1PeerAuthenticationMutualTLS() {
        return istioIoApiSecurityV1beta1PeerAuthenticationMutualTLS;
    }

    @JsonProperty("istio_io_api_security_v1beta1_PeerAuthentication_MutualTLS")
    public void setIstioIoApiSecurityV1beta1PeerAuthenticationMutualTLS(PeerAuthenticationMutualTLS istioIoApiSecurityV1beta1PeerAuthenticationMutualTLS) {
        this.istioIoApiSecurityV1beta1PeerAuthenticationMutualTLS = istioIoApiSecurityV1beta1PeerAuthenticationMutualTLS;
    }

    @JsonProperty("istio_io_api_security_v1beta1_PeerAuthentication_MutualTLS_Mode")
    public PeerAuthenticationMutualTLSMode getIstioIoApiSecurityV1beta1PeerAuthenticationMutualTLSMode() {
        return istioIoApiSecurityV1beta1PeerAuthenticationMutualTLSMode;
    }

    @JsonProperty("istio_io_api_security_v1beta1_PeerAuthentication_MutualTLS_Mode")
    public void setIstioIoApiSecurityV1beta1PeerAuthenticationMutualTLSMode(PeerAuthenticationMutualTLSMode istioIoApiSecurityV1beta1PeerAuthenticationMutualTLSMode) {
        this.istioIoApiSecurityV1beta1PeerAuthenticationMutualTLSMode = istioIoApiSecurityV1beta1PeerAuthenticationMutualTLSMode;
    }

    @JsonProperty("istio_io_api_security_v1beta1_RequestAuthentication")
    public RequestAuthenticationSpec getIstioIoApiSecurityV1beta1RequestAuthentication() {
        return istioIoApiSecurityV1beta1RequestAuthentication;
    }

    @JsonProperty("istio_io_api_security_v1beta1_RequestAuthentication")
    public void setIstioIoApiSecurityV1beta1RequestAuthentication(RequestAuthenticationSpec istioIoApiSecurityV1beta1RequestAuthentication) {
        this.istioIoApiSecurityV1beta1RequestAuthentication = istioIoApiSecurityV1beta1RequestAuthentication;
    }

    @JsonProperty("istio_io_api_security_v1beta1_Rule")
    public Rule getIstioIoApiSecurityV1beta1Rule() {
        return istioIoApiSecurityV1beta1Rule;
    }

    @JsonProperty("istio_io_api_security_v1beta1_Rule")
    public void setIstioIoApiSecurityV1beta1Rule(Rule istioIoApiSecurityV1beta1Rule) {
        this.istioIoApiSecurityV1beta1Rule = istioIoApiSecurityV1beta1Rule;
    }

    @JsonProperty("istio_io_api_security_v1beta1_Rule_From")
    public RuleFrom getIstioIoApiSecurityV1beta1RuleFrom() {
        return istioIoApiSecurityV1beta1RuleFrom;
    }

    @JsonProperty("istio_io_api_security_v1beta1_Rule_From")
    public void setIstioIoApiSecurityV1beta1RuleFrom(RuleFrom istioIoApiSecurityV1beta1RuleFrom) {
        this.istioIoApiSecurityV1beta1RuleFrom = istioIoApiSecurityV1beta1RuleFrom;
    }

    @JsonProperty("istio_io_api_security_v1beta1_Rule_To")
    public RuleTo getIstioIoApiSecurityV1beta1RuleTo() {
        return istioIoApiSecurityV1beta1RuleTo;
    }

    @JsonProperty("istio_io_api_security_v1beta1_Rule_To")
    public void setIstioIoApiSecurityV1beta1RuleTo(RuleTo istioIoApiSecurityV1beta1RuleTo) {
        this.istioIoApiSecurityV1beta1RuleTo = istioIoApiSecurityV1beta1RuleTo;
    }

    @JsonProperty("istio_io_api_security_v1beta1_Source")
    public Source getIstioIoApiSecurityV1beta1Source() {
        return istioIoApiSecurityV1beta1Source;
    }

    @JsonProperty("istio_io_api_security_v1beta1_Source")
    public void setIstioIoApiSecurityV1beta1Source(Source istioIoApiSecurityV1beta1Source) {
        this.istioIoApiSecurityV1beta1Source = istioIoApiSecurityV1beta1Source;
    }

    @JsonProperty("istio_io_api_security_v1beta1_isAuthorizationPolicy_ActionDetail")
    public IsAuthorizationPolicyActionDetail getIstioIoApiSecurityV1beta1IsAuthorizationPolicyActionDetail() {
        return istioIoApiSecurityV1beta1IsAuthorizationPolicyActionDetail;
    }

    @JsonProperty("istio_io_api_security_v1beta1_isAuthorizationPolicy_ActionDetail")
    public void setIstioIoApiSecurityV1beta1IsAuthorizationPolicyActionDetail(IsAuthorizationPolicyActionDetail istioIoApiSecurityV1beta1IsAuthorizationPolicyActionDetail) {
        this.istioIoApiSecurityV1beta1IsAuthorizationPolicyActionDetail = istioIoApiSecurityV1beta1IsAuthorizationPolicyActionDetail;
    }

    @JsonProperty("istio_io_api_type_v1beta1_WorkloadSelector")
    public io.fabric8.istio.api.type.v1beta1.WorkloadSelector getIstioIoApiTypeV1beta1WorkloadSelector() {
        return istioIoApiTypeV1beta1WorkloadSelector;
    }

    @JsonProperty("istio_io_api_type_v1beta1_WorkloadSelector")
    public void setIstioIoApiTypeV1beta1WorkloadSelector(io.fabric8.istio.api.type.v1beta1.WorkloadSelector istioIoApiTypeV1beta1WorkloadSelector) {
        this.istioIoApiTypeV1beta1WorkloadSelector = istioIoApiTypeV1beta1WorkloadSelector;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_DestinationRule")
    public DestinationRule getIstioIoClientGoPkgApisNetworkingV1beta1DestinationRule() {
        return istioIoClientGoPkgApisNetworkingV1beta1DestinationRule;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_DestinationRule")
    public void setIstioIoClientGoPkgApisNetworkingV1beta1DestinationRule(DestinationRule istioIoClientGoPkgApisNetworkingV1beta1DestinationRule) {
        this.istioIoClientGoPkgApisNetworkingV1beta1DestinationRule = istioIoClientGoPkgApisNetworkingV1beta1DestinationRule;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_DestinationRuleList")
    public DestinationRuleList getIstioIoClientGoPkgApisNetworkingV1beta1DestinationRuleList() {
        return istioIoClientGoPkgApisNetworkingV1beta1DestinationRuleList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_DestinationRuleList")
    public void setIstioIoClientGoPkgApisNetworkingV1beta1DestinationRuleList(DestinationRuleList istioIoClientGoPkgApisNetworkingV1beta1DestinationRuleList) {
        this.istioIoClientGoPkgApisNetworkingV1beta1DestinationRuleList = istioIoClientGoPkgApisNetworkingV1beta1DestinationRuleList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_Gateway")
    public Gateway getIstioIoClientGoPkgApisNetworkingV1beta1Gateway() {
        return istioIoClientGoPkgApisNetworkingV1beta1Gateway;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_Gateway")
    public void setIstioIoClientGoPkgApisNetworkingV1beta1Gateway(Gateway istioIoClientGoPkgApisNetworkingV1beta1Gateway) {
        this.istioIoClientGoPkgApisNetworkingV1beta1Gateway = istioIoClientGoPkgApisNetworkingV1beta1Gateway;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_GatewayList")
    public GatewayList getIstioIoClientGoPkgApisNetworkingV1beta1GatewayList() {
        return istioIoClientGoPkgApisNetworkingV1beta1GatewayList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_GatewayList")
    public void setIstioIoClientGoPkgApisNetworkingV1beta1GatewayList(GatewayList istioIoClientGoPkgApisNetworkingV1beta1GatewayList) {
        this.istioIoClientGoPkgApisNetworkingV1beta1GatewayList = istioIoClientGoPkgApisNetworkingV1beta1GatewayList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_ServiceEntry")
    public ServiceEntry getIstioIoClientGoPkgApisNetworkingV1beta1ServiceEntry() {
        return istioIoClientGoPkgApisNetworkingV1beta1ServiceEntry;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_ServiceEntry")
    public void setIstioIoClientGoPkgApisNetworkingV1beta1ServiceEntry(ServiceEntry istioIoClientGoPkgApisNetworkingV1beta1ServiceEntry) {
        this.istioIoClientGoPkgApisNetworkingV1beta1ServiceEntry = istioIoClientGoPkgApisNetworkingV1beta1ServiceEntry;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_ServiceEntryList")
    public ServiceEntryList getIstioIoClientGoPkgApisNetworkingV1beta1ServiceEntryList() {
        return istioIoClientGoPkgApisNetworkingV1beta1ServiceEntryList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_ServiceEntryList")
    public void setIstioIoClientGoPkgApisNetworkingV1beta1ServiceEntryList(ServiceEntryList istioIoClientGoPkgApisNetworkingV1beta1ServiceEntryList) {
        this.istioIoClientGoPkgApisNetworkingV1beta1ServiceEntryList = istioIoClientGoPkgApisNetworkingV1beta1ServiceEntryList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_Sidecar")
    public Sidecar getIstioIoClientGoPkgApisNetworkingV1beta1Sidecar() {
        return istioIoClientGoPkgApisNetworkingV1beta1Sidecar;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_Sidecar")
    public void setIstioIoClientGoPkgApisNetworkingV1beta1Sidecar(Sidecar istioIoClientGoPkgApisNetworkingV1beta1Sidecar) {
        this.istioIoClientGoPkgApisNetworkingV1beta1Sidecar = istioIoClientGoPkgApisNetworkingV1beta1Sidecar;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_SidecarList")
    public SidecarList getIstioIoClientGoPkgApisNetworkingV1beta1SidecarList() {
        return istioIoClientGoPkgApisNetworkingV1beta1SidecarList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_SidecarList")
    public void setIstioIoClientGoPkgApisNetworkingV1beta1SidecarList(SidecarList istioIoClientGoPkgApisNetworkingV1beta1SidecarList) {
        this.istioIoClientGoPkgApisNetworkingV1beta1SidecarList = istioIoClientGoPkgApisNetworkingV1beta1SidecarList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_VirtualService")
    public VirtualService getIstioIoClientGoPkgApisNetworkingV1beta1VirtualService() {
        return istioIoClientGoPkgApisNetworkingV1beta1VirtualService;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_VirtualService")
    public void setIstioIoClientGoPkgApisNetworkingV1beta1VirtualService(VirtualService istioIoClientGoPkgApisNetworkingV1beta1VirtualService) {
        this.istioIoClientGoPkgApisNetworkingV1beta1VirtualService = istioIoClientGoPkgApisNetworkingV1beta1VirtualService;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_VirtualServiceList")
    public VirtualServiceList getIstioIoClientGoPkgApisNetworkingV1beta1VirtualServiceList() {
        return istioIoClientGoPkgApisNetworkingV1beta1VirtualServiceList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_VirtualServiceList")
    public void setIstioIoClientGoPkgApisNetworkingV1beta1VirtualServiceList(VirtualServiceList istioIoClientGoPkgApisNetworkingV1beta1VirtualServiceList) {
        this.istioIoClientGoPkgApisNetworkingV1beta1VirtualServiceList = istioIoClientGoPkgApisNetworkingV1beta1VirtualServiceList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_WorkloadEntry")
    public WorkloadEntry getIstioIoClientGoPkgApisNetworkingV1beta1WorkloadEntry() {
        return istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntry;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_WorkloadEntry")
    public void setIstioIoClientGoPkgApisNetworkingV1beta1WorkloadEntry(WorkloadEntry istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntry) {
        this.istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntry = istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntry;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_WorkloadEntryList")
    public WorkloadEntryList getIstioIoClientGoPkgApisNetworkingV1beta1WorkloadEntryList() {
        return istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntryList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_networking_v1beta1_WorkloadEntryList")
    public void setIstioIoClientGoPkgApisNetworkingV1beta1WorkloadEntryList(WorkloadEntryList istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntryList) {
        this.istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntryList = istioIoClientGoPkgApisNetworkingV1beta1WorkloadEntryList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_AuthorizationPolicy")
    public AuthorizationPolicy getIstioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicy() {
        return istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicy;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_AuthorizationPolicy")
    public void setIstioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicy(AuthorizationPolicy istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicy) {
        this.istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicy = istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicy;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_AuthorizationPolicyList")
    public AuthorizationPolicyList getIstioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicyList() {
        return istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicyList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_AuthorizationPolicyList")
    public void setIstioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicyList(AuthorizationPolicyList istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicyList) {
        this.istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicyList = istioIoClientGoPkgApisSecurityV1beta1AuthorizationPolicyList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_PeerAuthentication")
    public PeerAuthentication getIstioIoClientGoPkgApisSecurityV1beta1PeerAuthentication() {
        return istioIoClientGoPkgApisSecurityV1beta1PeerAuthentication;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_PeerAuthentication")
    public void setIstioIoClientGoPkgApisSecurityV1beta1PeerAuthentication(PeerAuthentication istioIoClientGoPkgApisSecurityV1beta1PeerAuthentication) {
        this.istioIoClientGoPkgApisSecurityV1beta1PeerAuthentication = istioIoClientGoPkgApisSecurityV1beta1PeerAuthentication;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_PeerAuthenticationList")
    public PeerAuthenticationList getIstioIoClientGoPkgApisSecurityV1beta1PeerAuthenticationList() {
        return istioIoClientGoPkgApisSecurityV1beta1PeerAuthenticationList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_PeerAuthenticationList")
    public void setIstioIoClientGoPkgApisSecurityV1beta1PeerAuthenticationList(PeerAuthenticationList istioIoClientGoPkgApisSecurityV1beta1PeerAuthenticationList) {
        this.istioIoClientGoPkgApisSecurityV1beta1PeerAuthenticationList = istioIoClientGoPkgApisSecurityV1beta1PeerAuthenticationList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_RequestAuthentication")
    public RequestAuthentication getIstioIoClientGoPkgApisSecurityV1beta1RequestAuthentication() {
        return istioIoClientGoPkgApisSecurityV1beta1RequestAuthentication;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_RequestAuthentication")
    public void setIstioIoClientGoPkgApisSecurityV1beta1RequestAuthentication(RequestAuthentication istioIoClientGoPkgApisSecurityV1beta1RequestAuthentication) {
        this.istioIoClientGoPkgApisSecurityV1beta1RequestAuthentication = istioIoClientGoPkgApisSecurityV1beta1RequestAuthentication;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_RequestAuthenticationList")
    public RequestAuthenticationList getIstioIoClientGoPkgApisSecurityV1beta1RequestAuthenticationList() {
        return istioIoClientGoPkgApisSecurityV1beta1RequestAuthenticationList;
    }

    @JsonProperty("istio_io_client-go_pkg_apis_security_v1beta1_RequestAuthenticationList")
    public void setIstioIoClientGoPkgApisSecurityV1beta1RequestAuthenticationList(RequestAuthenticationList istioIoClientGoPkgApisSecurityV1beta1RequestAuthenticationList) {
        this.istioIoClientGoPkgApisSecurityV1beta1RequestAuthenticationList = istioIoClientGoPkgApisSecurityV1beta1RequestAuthenticationList;
    }

}
