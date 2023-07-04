
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GRPCRoute;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.GRPCRouteList;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.TCPRoute;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.TCPRouteList;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.TLSRoute;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.TLSRouteList;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.UDPRoute;
import io.fabric8.kubernetes.api.model.gatewayapi.v1alpha2.UDPRouteList;
import io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.Gateway;
import io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayClass;
import io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayClassList;
import io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.GatewayList;
import io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.HTTPRoute;
import io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.HTTPRouteList;
import io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.ReferenceGrant;
import io.fabric8.kubernetes.api.model.gatewayapi.v1beta1.ReferenceGrantList;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "GRPCRoute",
    "GRPCRouteList",
    "Gateway",
    "GatewayClass",
    "GatewayClassList",
    "GatewayList",
    "HTTPRoute",
    "HTTPRouteList",
    "ReferenceGrant",
    "ReferenceGrantList",
    "TCPRoute",
    "TCPRouteList",
    "TLSRoute",
    "TLSRouteList",
    "UDPRoute",
    "UDPRouteList"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
public class KubeSchema {

    @JsonProperty("GRPCRoute")
    private GRPCRoute gRPCRoute;
    @JsonProperty("GRPCRouteList")
    private GRPCRouteList gRPCRouteList;
    @JsonProperty("Gateway")
    private Gateway gateway;
    @JsonProperty("GatewayClass")
    private GatewayClass gatewayClass;
    @JsonProperty("GatewayClassList")
    private GatewayClassList gatewayClassList;
    @JsonProperty("GatewayList")
    private GatewayList gatewayList;
    @JsonProperty("HTTPRoute")
    private HTTPRoute hTTPRoute;
    @JsonProperty("HTTPRouteList")
    private HTTPRouteList hTTPRouteList;
    @JsonProperty("ReferenceGrant")
    private ReferenceGrant referenceGrant;
    @JsonProperty("ReferenceGrantList")
    private ReferenceGrantList referenceGrantList;
    @JsonProperty("TCPRoute")
    private TCPRoute tCPRoute;
    @JsonProperty("TCPRouteList")
    private TCPRouteList tCPRouteList;
    @JsonProperty("TLSRoute")
    private TLSRoute tLSRoute;
    @JsonProperty("TLSRouteList")
    private TLSRouteList tLSRouteList;
    @JsonProperty("UDPRoute")
    private UDPRoute uDPRoute;
    @JsonProperty("UDPRouteList")
    private UDPRouteList uDPRouteList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    /**
     * 
     * @param gatewayClassList
     * @param gRPCRoute
     * @param uDPRoute
     * @param gatewayList
     * @param tLSRouteList
     * @param tCPRoute
     * @param hTTPRouteList
     * @param gRPCRouteList
     * @param tLSRoute
     * @param uDPRouteList
     * @param hTTPRoute
     * @param referenceGrantList
     * @param gatewayClass
     * @param referenceGrant
     * @param gateway
     * @param tCPRouteList
     */
    public KubeSchema(GRPCRoute gRPCRoute, GRPCRouteList gRPCRouteList, Gateway gateway, GatewayClass gatewayClass, GatewayClassList gatewayClassList, GatewayList gatewayList, HTTPRoute hTTPRoute, HTTPRouteList hTTPRouteList, ReferenceGrant referenceGrant, ReferenceGrantList referenceGrantList, TCPRoute tCPRoute, TCPRouteList tCPRouteList, TLSRoute tLSRoute, TLSRouteList tLSRouteList, UDPRoute uDPRoute, UDPRouteList uDPRouteList) {
        super();
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
    public Gateway getGateway() {
        return gateway;
    }

    @JsonProperty("Gateway")
    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }

    @JsonProperty("GatewayClass")
    public GatewayClass getGatewayClass() {
        return gatewayClass;
    }

    @JsonProperty("GatewayClass")
    public void setGatewayClass(GatewayClass gatewayClass) {
        this.gatewayClass = gatewayClass;
    }

    @JsonProperty("GatewayClassList")
    public GatewayClassList getGatewayClassList() {
        return gatewayClassList;
    }

    @JsonProperty("GatewayClassList")
    public void setGatewayClassList(GatewayClassList gatewayClassList) {
        this.gatewayClassList = gatewayClassList;
    }

    @JsonProperty("GatewayList")
    public GatewayList getGatewayList() {
        return gatewayList;
    }

    @JsonProperty("GatewayList")
    public void setGatewayList(GatewayList gatewayList) {
        this.gatewayList = gatewayList;
    }

    @JsonProperty("HTTPRoute")
    public HTTPRoute getHTTPRoute() {
        return hTTPRoute;
    }

    @JsonProperty("HTTPRoute")
    public void setHTTPRoute(HTTPRoute hTTPRoute) {
        this.hTTPRoute = hTTPRoute;
    }

    @JsonProperty("HTTPRouteList")
    public HTTPRouteList getHTTPRouteList() {
        return hTTPRouteList;
    }

    @JsonProperty("HTTPRouteList")
    public void setHTTPRouteList(HTTPRouteList hTTPRouteList) {
        this.hTTPRouteList = hTTPRouteList;
    }

    @JsonProperty("ReferenceGrant")
    public ReferenceGrant getReferenceGrant() {
        return referenceGrant;
    }

    @JsonProperty("ReferenceGrant")
    public void setReferenceGrant(ReferenceGrant referenceGrant) {
        this.referenceGrant = referenceGrant;
    }

    @JsonProperty("ReferenceGrantList")
    public ReferenceGrantList getReferenceGrantList() {
        return referenceGrantList;
    }

    @JsonProperty("ReferenceGrantList")
    public void setReferenceGrantList(ReferenceGrantList referenceGrantList) {
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
