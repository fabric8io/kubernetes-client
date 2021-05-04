
package io.fabric8.openshift.api.model.monitoring.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "bearerTokenFile",
    "name",
    "namespace",
    "pathPrefix",
    "port",
    "scheme",
    "tlsConfig"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class AlertmanagerEndpoints implements KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("bearerTokenFile")
    private String bearerTokenFile;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("pathPrefix")
    private String pathPrefix;
    @JsonProperty("port")
    private io.fabric8.kubernetes.api.model.IntOrString port;
    @JsonProperty("scheme")
    private String scheme;
    @JsonProperty("tlsConfig")
    private TLSConfig tlsConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerEndpoints() {
    }

    /**
     * 
     * @param apiVersion
     * @param scheme
     * @param port
     * @param name
     * @param namespace
     * @param bearerTokenFile
     * @param pathPrefix
     * @param tlsConfig
     */
    public AlertmanagerEndpoints(String apiVersion, String bearerTokenFile, String name, String namespace, String pathPrefix, io.fabric8.kubernetes.api.model.IntOrString port, String scheme, TLSConfig tlsConfig) {
        super();
        this.apiVersion = apiVersion;
        this.bearerTokenFile = bearerTokenFile;
        this.name = name;
        this.namespace = namespace;
        this.pathPrefix = pathPrefix;
        this.port = port;
        this.scheme = scheme;
        this.tlsConfig = tlsConfig;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("bearerTokenFile")
    public String getBearerTokenFile() {
        return bearerTokenFile;
    }

    @JsonProperty("bearerTokenFile")
    public void setBearerTokenFile(String bearerTokenFile) {
        this.bearerTokenFile = bearerTokenFile;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("pathPrefix")
    public String getPathPrefix() {
        return pathPrefix;
    }

    @JsonProperty("pathPrefix")
    public void setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    @JsonProperty("port")
    public io.fabric8.kubernetes.api.model.IntOrString getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(io.fabric8.kubernetes.api.model.IntOrString port) {
        this.port = port;
    }

    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @JsonProperty("tlsConfig")
    public TLSConfig getTlsConfig() {
        return tlsConfig;
    }

    @JsonProperty("tlsConfig")
    public void setTlsConfig(TLSConfig tlsConfig) {
        this.tlsConfig = tlsConfig;
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
