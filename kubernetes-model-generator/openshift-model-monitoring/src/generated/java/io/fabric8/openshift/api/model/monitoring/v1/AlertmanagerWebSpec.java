
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
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AlertmanagerWebSpec defines the web command line flags when starting Alertmanager.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "getConcurrency",
    "httpConfig",
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
public class AlertmanagerWebSpec implements Editable<AlertmanagerWebSpecBuilder>, KubernetesResource
{

    @JsonProperty("getConcurrency")
    private Long getConcurrency;
    @JsonProperty("httpConfig")
    private WebHTTPConfig httpConfig;
    @JsonProperty("timeout")
    private Long timeout;
    @JsonProperty("tlsConfig")
    private WebTLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AlertmanagerWebSpec() {
    }

    public AlertmanagerWebSpec(Long getConcurrency, WebHTTPConfig httpConfig, Long timeout, WebTLSConfig tlsConfig) {
        super();
        this.getConcurrency = getConcurrency;
        this.httpConfig = httpConfig;
        this.timeout = timeout;
        this.tlsConfig = tlsConfig;
    }

    /**
     * Maximum number of GET requests processed concurrently. This corresponds to the Alertmanager's `--web.get-concurrency` flag.
     */
    @JsonProperty("getConcurrency")
    public Long getGetConcurrency() {
        return getConcurrency;
    }

    /**
     * Maximum number of GET requests processed concurrently. This corresponds to the Alertmanager's `--web.get-concurrency` flag.
     */
    @JsonProperty("getConcurrency")
    public void setGetConcurrency(Long getConcurrency) {
        this.getConcurrency = getConcurrency;
    }

    /**
     * AlertmanagerWebSpec defines the web command line flags when starting Alertmanager.
     */
    @JsonProperty("httpConfig")
    public WebHTTPConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * AlertmanagerWebSpec defines the web command line flags when starting Alertmanager.
     */
    @JsonProperty("httpConfig")
    public void setHttpConfig(WebHTTPConfig httpConfig) {
        this.httpConfig = httpConfig;
    }

    /**
     * Timeout for HTTP requests. This corresponds to the Alertmanager's `--web.timeout` flag.
     */
    @JsonProperty("timeout")
    public Long getTimeout() {
        return timeout;
    }

    /**
     * Timeout for HTTP requests. This corresponds to the Alertmanager's `--web.timeout` flag.
     */
    @JsonProperty("timeout")
    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    /**
     * AlertmanagerWebSpec defines the web command line flags when starting Alertmanager.
     */
    @JsonProperty("tlsConfig")
    public WebTLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * AlertmanagerWebSpec defines the web command line flags when starting Alertmanager.
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(WebTLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public AlertmanagerWebSpecBuilder edit() {
        return new AlertmanagerWebSpecBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerWebSpecBuilder toBuilder() {
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
