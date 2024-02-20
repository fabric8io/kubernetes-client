
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.BackendTLSPolicy;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.BackendTLSPolicyList;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GRPCRoute;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GRPCRouteList;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.TCPRoute;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.TCPRouteList;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.TLSRoute;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.TLSRouteList;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.UDPRoute;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.UDPRouteList;

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private BackendTLSPolicy backendTLSPolicy;
    private BackendTLSPolicyList backendTLSPolicyList;
    private GRPCRoute gRPCRoute;
    private GRPCRouteList gRPCRouteList;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.Gateway gateway;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GatewayClass gatewayClass;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GatewayClassList gatewayClassList;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GatewayList gatewayList;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.HTTPRoute hTTPRoute;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.HTTPRouteList hTTPRouteList;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.ReferenceGrant referenceGrant;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.ReferenceGrantList referenceGrantList;
    private TCPRoute tCPRoute;
    private TCPRouteList tCPRouteList;
    private TLSRoute tLSRoute;
    private TLSRouteList tLSRouteList;
    private UDPRoute uDPRoute;
    private UDPRouteList uDPRouteList;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.Gateway v1Beta1Gateway;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayClass v1Beta1GatewayClass;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayClassList v1Beta1GatewayClassList;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayList v1Beta1GatewayList;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.HTTPRoute v1Beta1HTTPRoute;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.HTTPRouteList v1Beta1HTTPRouteList;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.ReferenceGrant v1Beta1ReferenceGrant;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.ReferenceGrantList v1Beta1ReferenceGrantList;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1.Gateway v1Gateway;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayClass v1GatewayClass;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayClassList v1GatewayClassList;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayList v1GatewayList;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRoute v1HTTPRoute;
    private io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRouteList v1HTTPRouteList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(BackendTLSPolicy backendTLSPolicy, BackendTLSPolicyList backendTLSPolicyList, GRPCRoute gRPCRoute, GRPCRouteList gRPCRouteList, io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.Gateway gateway, io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GatewayClass gatewayClass, io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GatewayClassList gatewayClassList, io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GatewayList gatewayList, io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.HTTPRoute hTTPRoute, io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.HTTPRouteList hTTPRouteList, io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.ReferenceGrant referenceGrant, io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.ReferenceGrantList referenceGrantList, TCPRoute tCPRoute, TCPRouteList tCPRouteList, TLSRoute tLSRoute, TLSRouteList tLSRouteList, UDPRoute uDPRoute, UDPRouteList uDPRouteList, io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.Gateway v1Beta1Gateway, io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayClass v1Beta1GatewayClass, io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayClassList v1Beta1GatewayClassList, io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayList v1Beta1GatewayList, io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.HTTPRoute v1Beta1HTTPRoute, io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.HTTPRouteList v1Beta1HTTPRouteList, io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.ReferenceGrant v1Beta1ReferenceGrant, io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.ReferenceGrantList v1Beta1ReferenceGrantList, io.fabric8.kubernetes.api.model.gatewayapi.v1.Gateway v1Gateway, io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayClass v1GatewayClass, io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayClassList v1GatewayClassList, io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayList v1GatewayList, io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRoute v1HTTPRoute, io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRouteList v1HTTPRouteList) {
        super();
        this.backendTLSPolicy = backendTLSPolicy;
        this.backendTLSPolicyList = backendTLSPolicyList;
        this.gRPCRoute = gRPCRoute;
        this.gRPCRouteList = gRPCRouteList;
        this.gateway = gateway;
        this.gatewayClass = gatewayClass;
        this.gatewayClassList = gatewayClassList;
        this.gatewayList = gatewayList;
        this.hTTPRoute = hTTPRoute;
        this.hTTPRouteList = hTTPRouteList;
        this.referenceGrant = referenceGrant;
        this.referenceGrantList = referenceGrantList;
        this.tCPRoute = tCPRoute;
        this.tCPRouteList = tCPRouteList;
        this.tLSRoute = tLSRoute;
        this.tLSRouteList = tLSRouteList;
        this.uDPRoute = uDPRoute;
        this.uDPRouteList = uDPRouteList;
        this.v1Beta1Gateway = v1Beta1Gateway;
        this.v1Beta1GatewayClass = v1Beta1GatewayClass;
        this.v1Beta1GatewayClassList = v1Beta1GatewayClassList;
        this.v1Beta1GatewayList = v1Beta1GatewayList;
        this.v1Beta1HTTPRoute = v1Beta1HTTPRoute;
        this.v1Beta1HTTPRouteList = v1Beta1HTTPRouteList;
        this.v1Beta1ReferenceGrant = v1Beta1ReferenceGrant;
        this.v1Beta1ReferenceGrantList = v1Beta1ReferenceGrantList;
        this.v1Gateway = v1Gateway;
        this.v1GatewayClass = v1GatewayClass;
        this.v1GatewayClassList = v1GatewayClassList;
        this.v1GatewayList = v1GatewayList;
        this.v1HTTPRoute = v1HTTPRoute;
        this.v1HTTPRouteList = v1HTTPRouteList;
    }

    @JsonProperty("BackendTLSPolicy")
    public BackendTLSPolicy getBackendTLSPolicy() {
        return backendTLSPolicy;
    }

    @JsonProperty("BackendTLSPolicy")
    public void setBackendTLSPolicy(BackendTLSPolicy backendTLSPolicy) {
        this.backendTLSPolicy = backendTLSPolicy;
    }

    @JsonProperty("BackendTLSPolicyList")
    public BackendTLSPolicyList getBackendTLSPolicyList() {
        return backendTLSPolicyList;
    }

    @JsonProperty("BackendTLSPolicyList")
    public void setBackendTLSPolicyList(BackendTLSPolicyList backendTLSPolicyList) {
        this.backendTLSPolicyList = backendTLSPolicyList;
    }

    @JsonProperty("GRPCRoute")
    public GRPCRoute getGRPCRoute() {
        return gRPCRoute;
    }

    @JsonProperty("GRPCRoute")
    public void setGRPCRoute(GRPCRoute gRPCRoute) {
        this.gRPCRoute = gRPCRoute;
    }

    @JsonProperty("GRPCRouteList")
    public GRPCRouteList getGRPCRouteList() {
        return gRPCRouteList;
    }

    @JsonProperty("GRPCRouteList")
    public void setGRPCRouteList(GRPCRouteList gRPCRouteList) {
        this.gRPCRouteList = gRPCRouteList;
    }

    @JsonProperty("Gateway")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.Gateway getGateway() {
        return gateway;
    }

    @JsonProperty("Gateway")
    public void setGateway(io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.Gateway gateway) {
        this.gateway = gateway;
    }

    @JsonProperty("GatewayClass")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GatewayClass getGatewayClass() {
        return gatewayClass;
    }

    @JsonProperty("GatewayClass")
    public void setGatewayClass(io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GatewayClass gatewayClass) {
        this.gatewayClass = gatewayClass;
    }

    @JsonProperty("GatewayClassList")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GatewayClassList getGatewayClassList() {
        return gatewayClassList;
    }

    @JsonProperty("GatewayClassList")
    public void setGatewayClassList(io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GatewayClassList gatewayClassList) {
        this.gatewayClassList = gatewayClassList;
    }

    @JsonProperty("GatewayList")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GatewayList getGatewayList() {
        return gatewayList;
    }

    @JsonProperty("GatewayList")
    public void setGatewayList(io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GatewayList gatewayList) {
        this.gatewayList = gatewayList;
    }

    @JsonProperty("HTTPRoute")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.HTTPRoute getHTTPRoute() {
        return hTTPRoute;
    }

    @JsonProperty("HTTPRoute")
    public void setHTTPRoute(io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.HTTPRoute hTTPRoute) {
        this.hTTPRoute = hTTPRoute;
    }

    @JsonProperty("HTTPRouteList")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.HTTPRouteList getHTTPRouteList() {
        return hTTPRouteList;
    }

    @JsonProperty("HTTPRouteList")
    public void setHTTPRouteList(io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.HTTPRouteList hTTPRouteList) {
        this.hTTPRouteList = hTTPRouteList;
    }

    @JsonProperty("ReferenceGrant")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.ReferenceGrant getReferenceGrant() {
        return referenceGrant;
    }

    @JsonProperty("ReferenceGrant")
    public void setReferenceGrant(io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.ReferenceGrant referenceGrant) {
        this.referenceGrant = referenceGrant;
    }

    @JsonProperty("ReferenceGrantList")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.ReferenceGrantList getReferenceGrantList() {
        return referenceGrantList;
    }

    @JsonProperty("ReferenceGrantList")
    public void setReferenceGrantList(io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.ReferenceGrantList referenceGrantList) {
        this.referenceGrantList = referenceGrantList;
    }

    @JsonProperty("TCPRoute")
    public TCPRoute getTCPRoute() {
        return tCPRoute;
    }

    @JsonProperty("TCPRoute")
    public void setTCPRoute(TCPRoute tCPRoute) {
        this.tCPRoute = tCPRoute;
    }

    @JsonProperty("TCPRouteList")
    public TCPRouteList getTCPRouteList() {
        return tCPRouteList;
    }

    @JsonProperty("TCPRouteList")
    public void setTCPRouteList(TCPRouteList tCPRouteList) {
        this.tCPRouteList = tCPRouteList;
    }

    @JsonProperty("TLSRoute")
    public TLSRoute getTLSRoute() {
        return tLSRoute;
    }

    @JsonProperty("TLSRoute")
    public void setTLSRoute(TLSRoute tLSRoute) {
        this.tLSRoute = tLSRoute;
    }

    @JsonProperty("TLSRouteList")
    public TLSRouteList getTLSRouteList() {
        return tLSRouteList;
    }

    @JsonProperty("TLSRouteList")
    public void setTLSRouteList(TLSRouteList tLSRouteList) {
        this.tLSRouteList = tLSRouteList;
    }

    @JsonProperty("UDPRoute")
    public UDPRoute getUDPRoute() {
        return uDPRoute;
    }

    @JsonProperty("UDPRoute")
    public void setUDPRoute(UDPRoute uDPRoute) {
        this.uDPRoute = uDPRoute;
    }

    @JsonProperty("UDPRouteList")
    public UDPRouteList getUDPRouteList() {
        return uDPRouteList;
    }

    @JsonProperty("UDPRouteList")
    public void setUDPRouteList(UDPRouteList uDPRouteList) {
        this.uDPRouteList = uDPRouteList;
    }

    @JsonProperty("V1Beta1Gateway")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.Gateway getV1Beta1Gateway() {
        return v1Beta1Gateway;
    }

    @JsonProperty("V1Beta1Gateway")
    public void setV1Beta1Gateway(io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.Gateway v1Beta1Gateway) {
        this.v1Beta1Gateway = v1Beta1Gateway;
    }

    @JsonProperty("V1Beta1GatewayClass")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayClass getV1Beta1GatewayClass() {
        return v1Beta1GatewayClass;
    }

    @JsonProperty("V1Beta1GatewayClass")
    public void setV1Beta1GatewayClass(io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayClass v1Beta1GatewayClass) {
        this.v1Beta1GatewayClass = v1Beta1GatewayClass;
    }

    @JsonProperty("V1Beta1GatewayClassList")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayClassList getV1Beta1GatewayClassList() {
        return v1Beta1GatewayClassList;
    }

    @JsonProperty("V1Beta1GatewayClassList")
    public void setV1Beta1GatewayClassList(io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayClassList v1Beta1GatewayClassList) {
        this.v1Beta1GatewayClassList = v1Beta1GatewayClassList;
    }

    @JsonProperty("V1Beta1GatewayList")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayList getV1Beta1GatewayList() {
        return v1Beta1GatewayList;
    }

    @JsonProperty("V1Beta1GatewayList")
    public void setV1Beta1GatewayList(io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayList v1Beta1GatewayList) {
        this.v1Beta1GatewayList = v1Beta1GatewayList;
    }

    @JsonProperty("V1Beta1HTTPRoute")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.HTTPRoute getV1Beta1HTTPRoute() {
        return v1Beta1HTTPRoute;
    }

    @JsonProperty("V1Beta1HTTPRoute")
    public void setV1Beta1HTTPRoute(io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.HTTPRoute v1Beta1HTTPRoute) {
        this.v1Beta1HTTPRoute = v1Beta1HTTPRoute;
    }

    @JsonProperty("V1Beta1HTTPRouteList")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.HTTPRouteList getV1Beta1HTTPRouteList() {
        return v1Beta1HTTPRouteList;
    }

    @JsonProperty("V1Beta1HTTPRouteList")
    public void setV1Beta1HTTPRouteList(io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.HTTPRouteList v1Beta1HTTPRouteList) {
        this.v1Beta1HTTPRouteList = v1Beta1HTTPRouteList;
    }

    @JsonProperty("V1Beta1ReferenceGrant")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.ReferenceGrant getV1Beta1ReferenceGrant() {
        return v1Beta1ReferenceGrant;
    }

    @JsonProperty("V1Beta1ReferenceGrant")
    public void setV1Beta1ReferenceGrant(io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.ReferenceGrant v1Beta1ReferenceGrant) {
        this.v1Beta1ReferenceGrant = v1Beta1ReferenceGrant;
    }

    @JsonProperty("V1Beta1ReferenceGrantList")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.ReferenceGrantList getV1Beta1ReferenceGrantList() {
        return v1Beta1ReferenceGrantList;
    }

    @JsonProperty("V1Beta1ReferenceGrantList")
    public void setV1Beta1ReferenceGrantList(io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.ReferenceGrantList v1Beta1ReferenceGrantList) {
        this.v1Beta1ReferenceGrantList = v1Beta1ReferenceGrantList;
    }

    @JsonProperty("V1Gateway")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1.Gateway getV1Gateway() {
        return v1Gateway;
    }

    @JsonProperty("V1Gateway")
    public void setV1Gateway(io.fabric8.kubernetes.api.model.gatewayapi.v1.Gateway v1Gateway) {
        this.v1Gateway = v1Gateway;
    }

    @JsonProperty("V1GatewayClass")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayClass getV1GatewayClass() {
        return v1GatewayClass;
    }

    @JsonProperty("V1GatewayClass")
    public void setV1GatewayClass(io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayClass v1GatewayClass) {
        this.v1GatewayClass = v1GatewayClass;
    }

    @JsonProperty("V1GatewayClassList")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayClassList getV1GatewayClassList() {
        return v1GatewayClassList;
    }

    @JsonProperty("V1GatewayClassList")
    public void setV1GatewayClassList(io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayClassList v1GatewayClassList) {
        this.v1GatewayClassList = v1GatewayClassList;
    }

    @JsonProperty("V1GatewayList")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayList getV1GatewayList() {
        return v1GatewayList;
    }

    @JsonProperty("V1GatewayList")
    public void setV1GatewayList(io.fabric8.kubernetes.api.model.gatewayapi.v1.GatewayList v1GatewayList) {
        this.v1GatewayList = v1GatewayList;
    }

    @JsonProperty("V1HTTPRoute")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRoute getV1HTTPRoute() {
        return v1HTTPRoute;
    }

    @JsonProperty("V1HTTPRoute")
    public void setV1HTTPRoute(io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRoute v1HTTPRoute) {
        this.v1HTTPRoute = v1HTTPRoute;
    }

    @JsonProperty("V1HTTPRouteList")
    public io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRouteList getV1HTTPRouteList() {
        return v1HTTPRouteList;
    }

    @JsonProperty("V1HTTPRouteList")
    public void setV1HTTPRouteList(io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRouteList v1HTTPRouteList) {
        this.v1HTTPRouteList = v1HTTPRouteList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
