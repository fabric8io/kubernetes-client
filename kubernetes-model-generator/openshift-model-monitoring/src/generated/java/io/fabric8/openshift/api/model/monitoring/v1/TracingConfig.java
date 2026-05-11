
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class TracingConfig implements Editable<TracingConfigBuilder>, KubernetesResource
{

    @JsonProperty("clientType")
    private String clientType;
    @JsonProperty("compression")
    private String compression;
    @JsonProperty("endpoint")
    private String endpoint;
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> headers = new LinkedHashMap<>();
    @JsonProperty("insecure")
    private Boolean insecure;
    @JsonProperty("samplingFraction")
    private Quantity samplingFraction;
    @JsonProperty("timeout")
    private String timeout;
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TracingConfig() {
    }

    public TracingConfig(String clientType, String compression, String endpoint, Map<String, String> headers, Boolean insecure, Quantity samplingFraction, String timeout, TLSConfig tlsConfig) {
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

    /**
     * clientType defines the client used to export the traces. Supported values are `HTTP` and `GRPC`.
     */
    @JsonProperty("clientType")
    public String getClientType() {
        return clientType;
    }

    /**
     * clientType defines the client used to export the traces. Supported values are `HTTP` and `GRPC`.
     */
    @JsonProperty("clientType")
    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    /**
     * compression key for supported compression types. The only supported value is `Gzip`.
     */
    @JsonProperty("compression")
    public String getCompression() {
        return compression;
    }

    /**
     * compression key for supported compression types. The only supported value is `Gzip`.
     */
    @JsonProperty("compression")
    public void setCompression(String compression) {
        this.compression = compression;
    }

    /**
     * endpoint to send the traces to. Should be provided in format &lt;host&gt;:&lt;port&gt;.
     */
    @JsonProperty("endpoint")
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * endpoint to send the traces to. Should be provided in format &lt;host&gt;:&lt;port&gt;.
     */
    @JsonProperty("endpoint")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * headers defines the key-value pairs to be used as headers associated with gRPC or HTTP requests.
     */
    @JsonProperty("headers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * headers defines the key-value pairs to be used as headers associated with gRPC or HTTP requests.
     */
    @JsonProperty("headers")
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * insecure if disabled, the client will use a secure connection.
     */
    @JsonProperty("insecure")
    public Boolean getInsecure() {
        return insecure;
    }

    /**
     * insecure if disabled, the client will use a secure connection.
     */
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

    /**
     * timeout defines the maximum time the exporter will wait for each batch export.
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * timeout defines the maximum time the exporter will wait for each batch export.
     */
    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
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
    public TracingConfigBuilder edit() {
        return new TracingConfigBuilder(this);
    }

    @JsonIgnore
    public TracingConfigBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
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
