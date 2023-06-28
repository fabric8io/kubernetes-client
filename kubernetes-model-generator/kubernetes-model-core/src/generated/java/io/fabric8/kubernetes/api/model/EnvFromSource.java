
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
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
    "configMapRef",
    "prefix",
    "secretRef"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class EnvFromSource implements KubernetesResource
{

    @JsonProperty("configMapRef")
    private ConfigMapEnvSource configMapRef;
    @JsonProperty("prefix")
    private String prefix;
    @JsonProperty("secretRef")
    private SecretEnvSource secretRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EnvFromSource() {
    }

    public EnvFromSource(ConfigMapEnvSource configMapRef, String prefix, SecretEnvSource secretRef) {
        super();
        this.configMapRef = configMapRef;
        this.prefix = prefix;
        this.secretRef = secretRef;
    }

    @JsonProperty("configMapRef")
    public ConfigMapEnvSource getConfigMapRef() {
        return configMapRef;
    }

    @JsonProperty("configMapRef")
    public void setConfigMapRef(ConfigMapEnvSource configMapRef) {
        this.configMapRef = configMapRef;
    }

    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    @JsonProperty("prefix")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @JsonProperty("secretRef")
    public SecretEnvSource getSecretRef() {
        return secretRef;
    }

    @JsonProperty("secretRef")
    public void setSecretRef(SecretEnvSource secretRef) {
        this.secretRef = secretRef;
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
