
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Generated("jsonschema2pojo")
public class IngressControllerSpec implements Editable<IngressControllerSpecBuilder> , KubernetesResource
{

    @JsonProperty("clientTLS")
    private IngressControllerSpecClientTLS clientTLS;
    @JsonProperty("defaultCertificate")
    private IngressControllerSpecDefaultCertificate defaultCertificate;
    @JsonProperty("domain")
    private String domain;
    @JsonProperty("endpointPublishingStrategy")
    private IngressControllerSpecEndpointPublishingStrategy endpointPublishingStrategy;
    @JsonProperty("httpCompression")
    private IngressControllerSpecHttpCompression httpCompression;
    @JsonProperty("httpEmptyRequestsPolicy")
    private String httpEmptyRequestsPolicy;
    @JsonProperty("httpErrorCodePages")
    private IngressControllerSpecHttpErrorCodePages httpErrorCodePages;
    @JsonProperty("httpHeaders")
    private IngressControllerSpecHttpHeaders httpHeaders;
    @JsonProperty("logging")
    private IngressControllerSpecLogging logging;
    @JsonProperty("namespaceSelector")
    private IngressControllerSpecNamespaceSelector namespaceSelector;
    @JsonProperty("nodePlacement")
    private IngressControllerSpecNodePlacement nodePlacement;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("routeAdmission")
    private IngressControllerSpecRouteAdmission routeAdmission;
    @JsonProperty("routeSelector")
    private IngressControllerSpecRouteSelector routeSelector;
    @JsonProperty("tlsSecurityProfile")
    private IngressControllerSpecTlsSecurityProfile tlsSecurityProfile;
    @JsonProperty("tuningOptions")
    private IngressControllerSpecTuningOptions tuningOptions;
    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object unsupportedConfigOverrides;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressControllerSpec() {
    }

    public IngressControllerSpec(IngressControllerSpecClientTLS clientTLS, IngressControllerSpecDefaultCertificate defaultCertificate, String domain, IngressControllerSpecEndpointPublishingStrategy endpointPublishingStrategy, IngressControllerSpecHttpCompression httpCompression, String httpEmptyRequestsPolicy, IngressControllerSpecHttpErrorCodePages httpErrorCodePages, IngressControllerSpecHttpHeaders httpHeaders, IngressControllerSpecLogging logging, IngressControllerSpecNamespaceSelector namespaceSelector, IngressControllerSpecNodePlacement nodePlacement, Integer replicas, IngressControllerSpecRouteAdmission routeAdmission, IngressControllerSpecRouteSelector routeSelector, IngressControllerSpecTlsSecurityProfile tlsSecurityProfile, IngressControllerSpecTuningOptions tuningOptions, Object unsupportedConfigOverrides) {
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
    public IngressControllerSpecClientTLS getClientTLS() {
        return clientTLS;
    }

    @JsonProperty("clientTLS")
    public void setClientTLS(IngressControllerSpecClientTLS clientTLS) {
        this.clientTLS = clientTLS;
    }

    @JsonProperty("defaultCertificate")
    public IngressControllerSpecDefaultCertificate getDefaultCertificate() {
        return defaultCertificate;
    }

    @JsonProperty("defaultCertificate")
    public void setDefaultCertificate(IngressControllerSpecDefaultCertificate defaultCertificate) {
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
    public IngressControllerSpecEndpointPublishingStrategy getEndpointPublishingStrategy() {
        return endpointPublishingStrategy;
    }

    @JsonProperty("endpointPublishingStrategy")
    public void setEndpointPublishingStrategy(IngressControllerSpecEndpointPublishingStrategy endpointPublishingStrategy) {
        this.endpointPublishingStrategy = endpointPublishingStrategy;
    }

    @JsonProperty("httpCompression")
    public IngressControllerSpecHttpCompression getHttpCompression() {
        return httpCompression;
    }

    @JsonProperty("httpCompression")
    public void setHttpCompression(IngressControllerSpecHttpCompression httpCompression) {
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
    public IngressControllerSpecHttpErrorCodePages getHttpErrorCodePages() {
        return httpErrorCodePages;
    }

    @JsonProperty("httpErrorCodePages")
    public void setHttpErrorCodePages(IngressControllerSpecHttpErrorCodePages httpErrorCodePages) {
        this.httpErrorCodePages = httpErrorCodePages;
    }

    @JsonProperty("httpHeaders")
    public IngressControllerSpecHttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    @JsonProperty("httpHeaders")
    public void setHttpHeaders(IngressControllerSpecHttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    @JsonProperty("logging")
    public IngressControllerSpecLogging getLogging() {
        return logging;
    }

    @JsonProperty("logging")
    public void setLogging(IngressControllerSpecLogging logging) {
        this.logging = logging;
    }

    @JsonProperty("namespaceSelector")
    public IngressControllerSpecNamespaceSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(IngressControllerSpecNamespaceSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    @JsonProperty("nodePlacement")
    public IngressControllerSpecNodePlacement getNodePlacement() {
        return nodePlacement;
    }

    @JsonProperty("nodePlacement")
    public void setNodePlacement(IngressControllerSpecNodePlacement nodePlacement) {
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
    public IngressControllerSpecRouteAdmission getRouteAdmission() {
        return routeAdmission;
    }

    @JsonProperty("routeAdmission")
    public void setRouteAdmission(IngressControllerSpecRouteAdmission routeAdmission) {
        this.routeAdmission = routeAdmission;
    }

    @JsonProperty("routeSelector")
    public IngressControllerSpecRouteSelector getRouteSelector() {
        return routeSelector;
    }

    @JsonProperty("routeSelector")
    public void setRouteSelector(IngressControllerSpecRouteSelector routeSelector) {
        this.routeSelector = routeSelector;
    }

    @JsonProperty("tlsSecurityProfile")
    public IngressControllerSpecTlsSecurityProfile getTlsSecurityProfile() {
        return tlsSecurityProfile;
    }

    @JsonProperty("tlsSecurityProfile")
    public void setTlsSecurityProfile(IngressControllerSpecTlsSecurityProfile tlsSecurityProfile) {
        this.tlsSecurityProfile = tlsSecurityProfile;
    }

    @JsonProperty("tuningOptions")
    public IngressControllerSpecTuningOptions getTuningOptions() {
        return tuningOptions;
    }

    @JsonProperty("tuningOptions")
    public void setTuningOptions(IngressControllerSpecTuningOptions tuningOptions) {
        this.tuningOptions = tuningOptions;
    }

    @JsonProperty("unsupportedConfigOverrides")
    public Object getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    @JsonIgnore
    public IngressControllerSpecBuilder edit() {
        return new IngressControllerSpecBuilder(this);
    }

    @JsonIgnore
    public IngressControllerSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
