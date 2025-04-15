
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
import io.fabric8.kubernetes.api.model.ObjectReference;
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
 * APIServerConfig defines how the Prometheus server connects to the Kubernetes API server.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#kubernetes_sd_config
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "authorization",
    "basicAuth",
    "bearerToken",
    "bearerTokenFile",
    "host",
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class APIServerConfig implements Editable<APIServerConfigBuilder>, KubernetesResource
{

    @JsonProperty("authorization")
    private Authorization authorization;
    @JsonProperty("basicAuth")
    private BasicAuth basicAuth;
    @JsonProperty("bearerToken")
    private String bearerToken;
    @JsonProperty("bearerTokenFile")
    private String bearerTokenFile;
    @JsonProperty("host")
    private String host;
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public APIServerConfig() {
    }

    public APIServerConfig(Authorization authorization, BasicAuth basicAuth, String bearerToken, String bearerTokenFile, String host, TLSConfig tlsConfig) {
        super();
        this.authorization = authorization;
        this.basicAuth = basicAuth;
        this.bearerToken = bearerToken;
        this.bearerTokenFile = bearerTokenFile;
        this.host = host;
        this.tlsConfig = tlsConfig;
    }

    /**
     * APIServerConfig defines how the Prometheus server connects to the Kubernetes API server.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#kubernetes_sd_config
     */
    @JsonProperty("authorization")
    public Authorization getAuthorization() {
        return authorization;
    }

    /**
     * APIServerConfig defines how the Prometheus server connects to the Kubernetes API server.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#kubernetes_sd_config
     */
    @JsonProperty("authorization")
    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    /**
     * APIServerConfig defines how the Prometheus server connects to the Kubernetes API server.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#kubernetes_sd_config
     */
    @JsonProperty("basicAuth")
    public BasicAuth getBasicAuth() {
        return basicAuth;
    }

    /**
     * APIServerConfig defines how the Prometheus server connects to the Kubernetes API server.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#kubernetes_sd_config
     */
    @JsonProperty("basicAuth")
    public void setBasicAuth(BasicAuth basicAuth) {
        this.basicAuth = basicAuth;
    }

    /**
     * &#42;Warning: this field shouldn't be used because the token value appears in clear-text. Prefer using `authorization`.&#42;<br><p> <br><p> Deprecated: this will be removed in a future release.
     */
    @JsonProperty("bearerToken")
    public String getBearerToken() {
        return bearerToken;
    }

    /**
     * &#42;Warning: this field shouldn't be used because the token value appears in clear-text. Prefer using `authorization`.&#42;<br><p> <br><p> Deprecated: this will be removed in a future release.
     */
    @JsonProperty("bearerToken")
    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    /**
     * File to read bearer token for accessing apiserver.<br><p> <br><p> Cannot be set at the same time as `basicAuth`, `authorization`, or `bearerToken`.<br><p> <br><p> Deprecated: this will be removed in a future release. Prefer using `authorization`.
     */
    @JsonProperty("bearerTokenFile")
    public String getBearerTokenFile() {
        return bearerTokenFile;
    }

    /**
     * File to read bearer token for accessing apiserver.<br><p> <br><p> Cannot be set at the same time as `basicAuth`, `authorization`, or `bearerToken`.<br><p> <br><p> Deprecated: this will be removed in a future release. Prefer using `authorization`.
     */
    @JsonProperty("bearerTokenFile")
    public void setBearerTokenFile(String bearerTokenFile) {
        this.bearerTokenFile = bearerTokenFile;
    }

    /**
     * Kubernetes API address consisting of a hostname or IP address followed by an optional port number.
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * Kubernetes API address consisting of a hostname or IP address followed by an optional port number.
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * APIServerConfig defines how the Prometheus server connects to the Kubernetes API server.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#kubernetes_sd_config
     */
    @JsonProperty("tlsConfig")
    public TLSConfig getTlsConfig() {
        return tlsConfig;
    }

    /**
     * APIServerConfig defines how the Prometheus server connects to the Kubernetes API server.<br><p> <br><p> More info: https://prometheus.io/docs/prometheus/latest/configuration/configuration/#kubernetes_sd_config
     */
    @JsonProperty("tlsConfig")
    public void setTlsConfig(TLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
    }

    @JsonIgnore
    public APIServerConfigBuilder edit() {
        return new APIServerConfigBuilder(this);
    }

    @JsonIgnore
    public APIServerConfigBuilder toBuilder() {
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
