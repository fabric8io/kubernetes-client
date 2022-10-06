
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
import io.fabric8.openshift.api.model.config.v1.ConfigMapNameReference;
import io.fabric8.openshift.api.model.config.v1.TLSSecurityProfile;
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
    "clientTLS",
    "defaultCertificate",
    "domain",
    "endpointPublishingStrategy",
    "httpCompression",
    "httpEmptyRequestsPolicy",
    "httpErrorCodePages",
    "httpHeaders",
    "logging",
    "namespaceSelector",
    "nodePlacement",
    "replicas",
    "routeAdmission",
    "routeSelector",
    "tlsSecurityProfile",
    "tuningOptions",
    "unsupportedConfigOverrides"
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

    @JsonProperty("clientTLS")
    private ClientTLS clientTLS;
    @JsonProperty("defaultCertificate")
    private io.fabric8.kubernetes.api.model.LocalObjectReference defaultCertificate;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("endpointPublishingStrategy")
    private EndpointPublishingStrategy endpointPublishingStrategy;
    @JsonProperty("httpCompression")
    private HTTPCompressionPolicy httpCompression;
    @JsonProperty("httpEmptyRequestsPolicy")
    private String httpEmptyRequestsPolicy;
    @JsonProperty("httpErrorCodePages")
    private ConfigMapNameReference httpErrorCodePages;
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
    @JsonProperty("tuningOptions")
    private IngressControllerTuningOptions tuningOptions;
    @JsonProperty("unsupportedConfigOverrides")
    private KubernetesResource unsupportedConfigOverrides;
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
     * @param httpErrorCodePages
     * @param httpCompression
     * @param routeSelector
     * @param replicas
     * @param endpointPublishingStrategy
     * @param namespaceSelector
     * @param httpHeaders
     * @param nodePlacement
     * @param clientTLS
     * @param routeAdmission
     * @param httpEmptyRequestsPolicy
     * @param domain
     * @param tlsSecurityProfile
     * @param defaultCertificate
     * @param unsupportedConfigOverrides
     * @param logging
     * @param tuningOptions
     */
    public IngressControllerSpec(ClientTLS clientTLS, io.fabric8.kubernetes.api.model.LocalObjectReference defaultCertificate, String domain, EndpointPublishingStrategy endpointPublishingStrategy, HTTPCompressionPolicy httpCompression, String httpEmptyRequestsPolicy, ConfigMapNameReference httpErrorCodePages, IngressControllerHTTPHeaders httpHeaders, IngressControllerLogging logging, io.fabric8.kubernetes.api.model.LabelSelector namespaceSelector, NodePlacement nodePlacement, Integer replicas, RouteAdmissionPolicy routeAdmission, io.fabric8.kubernetes.api.model.LabelSelector routeSelector, TLSSecurityProfile tlsSecurityProfile, IngressControllerTuningOptions tuningOptions, KubernetesResource unsupportedConfigOverrides) {
        super();
        this.clientTLS = clientTLS;
        this.defaultCertificate = defaultCertificate;
        this.domain = domain;
        this.endpointPublishingStrategy = endpointPublishingStrategy;
        this.httpCompression = httpCompression;
        this.httpEmptyRequestsPolicy = httpEmptyRequestsPolicy;
        this.httpErrorCodePages = httpErrorCodePages;
        this.httpHeaders = httpHeaders;
        this.logging = logging;
        this.namespaceSelector = namespaceSelector;
        this.nodePlacement = nodePlacement;
        this.replicas = replicas;
        this.routeAdmission = routeAdmission;
        this.routeSelector = routeSelector;
        this.tlsSecurityProfile = tlsSecurityProfile;
        this.tuningOptions = tuningOptions;
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    @JsonProperty("clientTLS")
    public ClientTLS getClientTLS() {
        return clientTLS;
    }

    @JsonProperty("clientTLS")
    public void setClientTLS(ClientTLS clientTLS) {
        this.clientTLS = clientTLS;
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

    @JsonProperty("httpCompression")
    public HTTPCompressionPolicy getHttpCompression() {
        return httpCompression;
    }

    @JsonProperty("httpCompression")
    public void setHttpCompression(HTTPCompressionPolicy httpCompression) {
        this.httpCompression = httpCompression;
    }

    @JsonProperty("httpEmptyRequestsPolicy")
    public String getHttpEmptyRequestsPolicy() {
        return httpEmptyRequestsPolicy;
    }

    @JsonProperty("httpEmptyRequestsPolicy")
    public void setHttpEmptyRequestsPolicy(String httpEmptyRequestsPolicy) {
        this.httpEmptyRequestsPolicy = httpEmptyRequestsPolicy;
    }

    @JsonProperty("httpErrorCodePages")
    public ConfigMapNameReference getHttpErrorCodePages() {
        return httpErrorCodePages;
    }

    @JsonProperty("httpErrorCodePages")
    public void setHttpErrorCodePages(ConfigMapNameReference httpErrorCodePages) {
        this.httpErrorCodePages = httpErrorCodePages;
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

    @JsonProperty("tuningOptions")
    public IngressControllerTuningOptions getTuningOptions() {
        return tuningOptions;
    }

    @JsonProperty("tuningOptions")
    public void setTuningOptions(IngressControllerTuningOptions tuningOptions) {
        this.tuningOptions = tuningOptions;
    }

    @JsonProperty("unsupportedConfigOverrides")
    public KubernetesResource getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    @JsonProperty("unsupportedConfigOverrides")
    public void setUnsupportedConfigOverrides(KubernetesResource unsupportedConfigOverrides) {
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
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
