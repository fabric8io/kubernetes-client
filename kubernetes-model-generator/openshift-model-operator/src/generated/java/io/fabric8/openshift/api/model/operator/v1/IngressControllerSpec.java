
package io.fabric8.openshift.api.model.operator.v1;

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
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.openshift.api.model.TLSSecurityProfile;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "defaultCertificate",
    "domain",
    "endpointPublishingStrategy",
    "httpHeaders",
    "logging",
    "namespaceSelector",
    "nodePlacement",
    "replicas",
    "routeAdmission",
    "routeSelector",
    "tlsSecurityProfile"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class IngressControllerSpec implements KubernetesResource
{

    @JsonProperty("defaultCertificate")
    private io.fabric8.kubernetes.api.model.LocalObjectReference defaultCertificate;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("endpointPublishingStrategy")
    private EndpointPublishingStrategy endpointPublishingStrategy;
    @JsonProperty("httpHeaders")
    private IngressControllerHTTPHeaders httpHeaders;
    @JsonProperty("logging")
    private IngressControllerLogging logging;
    @JsonProperty("namespaceSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector namespaceSelector;
    @JsonProperty("nodePlacement")
    private NodePlacement nodePlacement;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("routeAdmission")
    private RouteAdmissionPolicy routeAdmission;
    @JsonProperty("routeSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector routeSelector;
    @JsonProperty("tlsSecurityProfile")
    private TLSSecurityProfile tlsSecurityProfile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressControllerSpec() {
    }

    /**
     * 
     * @param nodePlacement
     * @param routeAdmission
     * @param routeSelector
     * @param replicas
     * @param domain
     * @param tlsSecurityProfile
     * @param defaultCertificate
     * @param endpointPublishingStrategy
     * @param namespaceSelector
     * @param logging
     * @param httpHeaders
     */
    public IngressControllerSpec(io.fabric8.kubernetes.api.model.LocalObjectReference defaultCertificate, String domain, EndpointPublishingStrategy endpointPublishingStrategy, IngressControllerHTTPHeaders httpHeaders, IngressControllerLogging logging, io.fabric8.kubernetes.api.model.LabelSelector namespaceSelector, NodePlacement nodePlacement, Integer replicas, RouteAdmissionPolicy routeAdmission, io.fabric8.kubernetes.api.model.LabelSelector routeSelector, TLSSecurityProfile tlsSecurityProfile) {
        super();
        this.defaultCertificate = defaultCertificate;
        this.domain = domain;
        this.endpointPublishingStrategy = endpointPublishingStrategy;
        this.httpHeaders = httpHeaders;
        this.logging = logging;
        this.namespaceSelector = namespaceSelector;
        this.nodePlacement = nodePlacement;
        this.replicas = replicas;
        this.routeAdmission = routeAdmission;
        this.routeSelector = routeSelector;
        this.tlsSecurityProfile = tlsSecurityProfile;
    }

    @JsonProperty("defaultCertificate")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getDefaultCertificate() {
        return defaultCertificate;
    }

    @JsonProperty("defaultCertificate")
    public void setDefaultCertificate(io.fabric8.kubernetes.api.model.LocalObjectReference defaultCertificate) {
        this.defaultCertificate = defaultCertificate;
    }

    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    @JsonProperty("domain")
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @JsonProperty("endpointPublishingStrategy")
    public EndpointPublishingStrategy getEndpointPublishingStrategy() {
        return endpointPublishingStrategy;
    }

    @JsonProperty("endpointPublishingStrategy")
    public void setEndpointPublishingStrategy(EndpointPublishingStrategy endpointPublishingStrategy) {
        this.endpointPublishingStrategy = endpointPublishingStrategy;
    }

    @JsonProperty("httpHeaders")
    public IngressControllerHTTPHeaders getHttpHeaders() {
        return httpHeaders;
    }

    @JsonProperty("httpHeaders")
    public void setHttpHeaders(IngressControllerHTTPHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    @JsonProperty("logging")
    public IngressControllerLogging getLogging() {
        return logging;
    }

    @JsonProperty("logging")
    public void setLogging(IngressControllerLogging logging) {
        this.logging = logging;
    }

    @JsonProperty("namespaceSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(io.fabric8.kubernetes.api.model.LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    @JsonProperty("nodePlacement")
    public NodePlacement getNodePlacement() {
        return nodePlacement;
    }

    @JsonProperty("nodePlacement")
    public void setNodePlacement(NodePlacement nodePlacement) {
        this.nodePlacement = nodePlacement;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("routeAdmission")
    public RouteAdmissionPolicy getRouteAdmission() {
        return routeAdmission;
    }

    @JsonProperty("routeAdmission")
    public void setRouteAdmission(RouteAdmissionPolicy routeAdmission) {
        this.routeAdmission = routeAdmission;
    }

    @JsonProperty("routeSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getRouteSelector() {
        return routeSelector;
    }

    @JsonProperty("routeSelector")
    public void setRouteSelector(io.fabric8.kubernetes.api.model.LabelSelector routeSelector) {
        this.routeSelector = routeSelector;
    }

    @JsonProperty("tlsSecurityProfile")
    public TLSSecurityProfile getTlsSecurityProfile() {
        return tlsSecurityProfile;
    }

    @JsonProperty("tlsSecurityProfile")
    public void setTlsSecurityProfile(TLSSecurityProfile tlsSecurityProfile) {
        this.tlsSecurityProfile = tlsSecurityProfile;
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
