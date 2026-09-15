
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * EnvFromSource represents the source of a set of ConfigMaps or Secrets
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "configMapRef",
    "prefix",
    "secretRef"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EnvFromSource implements Editable<EnvFromSourceBuilder>, KubernetesResource
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
     */
    public EnvFromSource() {
    }

    public EnvFromSource(ConfigMapEnvSource configMapRef, String prefix, SecretEnvSource secretRef) {
        super();
        this.configMapRef = configMapRef;
        this.prefix = prefix;
        this.secretRef = secretRef;
    }

    /**
     * EnvFromSource represents the source of a set of ConfigMaps or Secrets
     */
    @JsonProperty("configMapRef")
    public ConfigMapEnvSource getConfigMapRef() {
        return configMapRef;
    }

    /**
     * EnvFromSource represents the source of a set of ConfigMaps or Secrets
     */
    @JsonProperty("configMapRef")
    public void setConfigMapRef(ConfigMapEnvSource configMapRef) {
        this.configMapRef = configMapRef;
    }

    /**
     * Optional text to prepend to the name of each environment variable. May consist of any printable ASCII characters except '='.
     */
    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    /**
     * Optional text to prepend to the name of each environment variable. May consist of any printable ASCII characters except '='.
     */
    @JsonProperty("prefix")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * EnvFromSource represents the source of a set of ConfigMaps or Secrets
     */
    @JsonProperty("secretRef")
    public SecretEnvSource getSecretRef() {
        return secretRef;
    }

    /**
     * EnvFromSource represents the source of a set of ConfigMaps or Secrets
     */
    @JsonProperty("secretRef")
    public void setSecretRef(SecretEnvSource secretRef) {
        this.secretRef = secretRef;
    }

    @JsonIgnore
    public EnvFromSourceBuilder edit() {
        return new EnvFromSourceBuilder(this);
    }

    @JsonIgnore
    public EnvFromSourceBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof EnvFromSource)) {
            return false;
        }
        EnvFromSource other = (EnvFromSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$configMapRef = this.getConfigMapRef();
        Object other$configMapRef = other.getConfigMapRef();
        if (this$configMapRef == null ? other$configMapRef != null : !this$configMapRef.equals(other$configMapRef)) {
            return false;
        }
        Object this$prefix = this.getPrefix();
        Object other$prefix = other.getPrefix();
        if (this$prefix == null ? other$prefix != null : !this$prefix.equals(other$prefix)) {
            return false;
        }
        Object this$secretRef = this.getSecretRef();
        Object other$secretRef = other.getSecretRef();
        if (this$secretRef == null ? other$secretRef != null : !this$secretRef.equals(other$secretRef)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof EnvFromSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $configMapRef = this.getConfigMapRef();
        result = result * prime + ($configMapRef == null ? 43 : $configMapRef.hashCode());
        Object $prefix = this.getPrefix();
        result = result * prime + ($prefix == null ? 43 : $prefix.hashCode());
        Object $secretRef = this.getSecretRef();
        result = result * prime + ($secretRef == null ? 43 : $secretRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EnvFromSource(" + "configMapRef=" + this.getConfigMapRef() + ", prefix=" + this.getPrefix() + ", secretRef=" + this.getSecretRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
