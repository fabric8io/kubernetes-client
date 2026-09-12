
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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * GlobalVictorOpsConfig configures global VictorOps parameters.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiKey",
    "apiURL"
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
public class GlobalVictorOpsConfig implements Editable<GlobalVictorOpsConfigBuilder>, KubernetesResource
{

    @JsonProperty("apiKey")
    private SecretKeySelector apiKey;
    @JsonProperty("apiURL")
    private String apiURL;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GlobalVictorOpsConfig() {
    }

    public GlobalVictorOpsConfig(SecretKeySelector apiKey, String apiURL) {
        super();
        this.apiKey = apiKey;
        this.apiURL = apiURL;
    }

    /**
     * GlobalVictorOpsConfig configures global VictorOps parameters.
     */
    @JsonProperty("apiKey")
    public SecretKeySelector getApiKey() {
        return apiKey;
    }

    /**
     * GlobalVictorOpsConfig configures global VictorOps parameters.
     */
    @JsonProperty("apiKey")
    public void setApiKey(SecretKeySelector apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * apiURL defines the default VictorOps API URL.
     */
    @JsonProperty("apiURL")
    public String getApiURL() {
        return apiURL;
    }

    /**
     * apiURL defines the default VictorOps API URL.
     */
    @JsonProperty("apiURL")
    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    @JsonIgnore
    public GlobalVictorOpsConfigBuilder edit() {
        return new GlobalVictorOpsConfigBuilder(this);
    }

    @JsonIgnore
    public GlobalVictorOpsConfigBuilder toBuilder() {
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
        if (!(o instanceof GlobalVictorOpsConfig)) {
            return false;
        }
        GlobalVictorOpsConfig other = (GlobalVictorOpsConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiKey = this.getApiKey();
        Object other$apiKey = other.getApiKey();
        if (this$apiKey == null ? other$apiKey != null : !this$apiKey.equals(other$apiKey)) {
            return false;
        }
        Object this$apiURL = this.getApiURL();
        Object other$apiURL = other.getApiURL();
        if (this$apiURL == null ? other$apiURL != null : !this$apiURL.equals(other$apiURL)) {
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
        return other instanceof GlobalVictorOpsConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiKey = this.getApiKey();
        result = result * prime + ($apiKey == null ? 43 : $apiKey.hashCode());
        Object $apiURL = this.getApiURL();
        result = result * prime + ($apiURL == null ? 43 : $apiURL.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GlobalVictorOpsConfig(" + "apiKey=" + this.getApiKey() + ", apiURL=" + this.getApiURL() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
