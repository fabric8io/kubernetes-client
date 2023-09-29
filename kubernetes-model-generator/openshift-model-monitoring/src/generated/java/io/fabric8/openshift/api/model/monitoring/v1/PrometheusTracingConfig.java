
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "clientType",
    "compression",
    "endpoint",
    "headers",
    "insecure",
    "samplingFraction",
    "timeout",
    "tlsConfig"
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
@Generated("jsonschema2pojo")
public class PrometheusTracingConfig implements Editable<PrometheusTracingConfigBuilder> , KubernetesResource
{

    @JsonProperty("clientType")
    private java.lang.String clientType;
    @JsonProperty("compression")
    private java.lang.String compression;
    @JsonProperty("endpoint")
    private java.lang.String endpoint;
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> headers = new LinkedHashMap<String, String>();
    @JsonProperty("insecure")
    private Boolean insecure;
    @JsonProperty("samplingFraction")
    private Quantity samplingFraction;
    @JsonProperty("timeout")
    private java.lang.String timeout;
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrometheusTracingConfig() {
    }

    public PrometheusTracingConfig(java.lang.String clientType, java.lang.String compression, java.lang.String endpoint, Map<String, String> headers, Boolean insecure, Quantity samplingFraction, java.lang.String timeout, TLSConfig tlsConfig) {
        super();
        this.clientType = clientType;
        this.compression = compression;
        this.endpoint = endpoint;
        this.headers = headers;
        this.insecure = insecure;
        this.samplingFraction = samplingFraction;
        this.timeout = timeout;
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("clientType")
    public java.lang.String getClientType() {
        return clientType;
    }

    @JsonProperty("clientType")
    public void setClientType(java.lang.String clientType) {
        this.clientType = clientType;
    }

    @JsonProperty("compression")
    public java.lang.String getCompression() {
        return compression;
    }

    @JsonProperty("compression")
    public void setCompression(java.lang.String compression) {
        this.compression = compression;
    }

    @JsonProperty("endpoint")
    public java.lang.String getEndpoint() {
        return endpoint;
    }

    @JsonProperty("endpoint")
    public void setEndpoint(java.lang.String endpoint) {
        this.endpoint = endpoint;
    }

    @JsonProperty("headers")
    public Map<String, String> getHeaders() {
        return headers;
    }

    @JsonProperty("headers")
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @JsonProperty("insecure")
    public Boolean getInsecure() {
        return insecure;
    }

    @JsonProperty("insecure")
    public void setInsecure(Boolean insecure) {
        this.insecure = insecure;
    }

    @JsonProperty("samplingFraction")
    public Quantity getSamplingFraction() {
        return samplingFraction;
    }

    @JsonProperty("samplingFraction")
    public void setSamplingFraction(Quantity samplingFraction) {
        this.samplingFraction = samplingFraction;
    }

    @JsonProperty("timeout")
    public java.lang.String getTimeout() {
        return timeout;
    }

    @JsonProperty("timeout")
    public void setTimeout(java.lang.String timeout) {
        this.timeout = timeout;
    }

    @JsonProperty("tlsConfig")
    public TLSConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(TLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public PrometheusTracingConfigBuilder edit() {
        return new PrometheusTracingConfigBuilder(this);
    }

    @JsonIgnore
    public PrometheusTracingConfigBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
