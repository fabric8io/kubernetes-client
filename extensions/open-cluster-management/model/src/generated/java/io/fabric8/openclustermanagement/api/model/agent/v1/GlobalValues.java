
package io.fabric8.openclustermanagement.api.model.agent.v1;

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

/**
 * GlobalValues defines the global values
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imageOverrides",
    "imagePullPolicy",
    "imagePullSecret",
    "nodeSelector",
    "proxyConfig"
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
public class GlobalValues implements Editable<GlobalValuesBuilder>, KubernetesResource
{

    @JsonProperty("imageOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> imageOverrides = new LinkedHashMap<>();
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("imagePullSecret")
    private String imagePullSecret;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("proxyConfig")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> proxyConfig = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GlobalValues() {
    }

    public GlobalValues(Map<String, String> imageOverrides, String imagePullPolicy, String imagePullSecret, Map<String, String> nodeSelector, Map<String, String> proxyConfig) {
        super();
        this.imageOverrides = imageOverrides;
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSecret = imagePullSecret;
        this.nodeSelector = nodeSelector;
        this.proxyConfig = proxyConfig;
    }

    /**
     * GlobalValues defines the global values
     */
    @JsonProperty("imageOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getImageOverrides() {
        return imageOverrides;
    }

    /**
     * GlobalValues defines the global values
     */
    @JsonProperty("imageOverrides")
    public void setImageOverrides(Map<String, String> imageOverrides) {
        this.imageOverrides = imageOverrides;
    }

    /**
     * GlobalValues defines the global values
     */
    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * GlobalValues defines the global values
     */
    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * GlobalValues defines the global values
     */
    @JsonProperty("imagePullSecret")
    public String getImagePullSecret() {
        return imagePullSecret;
    }

    /**
     * GlobalValues defines the global values
     */
    @JsonProperty("imagePullSecret")
    public void setImagePullSecret(String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    /**
     * GlobalValues defines the global values
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * GlobalValues defines the global values
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * GlobalValues defines the global values
     */
    @JsonProperty("proxyConfig")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getProxyConfig() {
        return proxyConfig;
    }

    /**
     * GlobalValues defines the global values
     */
    @JsonProperty("proxyConfig")
    public void setProxyConfig(Map<String, String> proxyConfig) {
        this.proxyConfig = proxyConfig;
    }

    @JsonIgnore
    public GlobalValuesBuilder edit() {
        return new GlobalValuesBuilder(this);
    }

    @JsonIgnore
    public GlobalValuesBuilder toBuilder() {
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
        if (!(o instanceof GlobalValues)) {
            return false;
        }
        GlobalValues other = (GlobalValues) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$imageOverrides = this.getImageOverrides();
        Object other$imageOverrides = other.getImageOverrides();
        if (this$imageOverrides == null ? other$imageOverrides != null : !this$imageOverrides.equals(other$imageOverrides)) {
            return false;
        }
        Object this$imagePullPolicy = this.getImagePullPolicy();
        Object other$imagePullPolicy = other.getImagePullPolicy();
        if (this$imagePullPolicy == null ? other$imagePullPolicy != null : !this$imagePullPolicy.equals(other$imagePullPolicy)) {
            return false;
        }
        Object this$imagePullSecret = this.getImagePullSecret();
        Object other$imagePullSecret = other.getImagePullSecret();
        if (this$imagePullSecret == null ? other$imagePullSecret != null : !this$imagePullSecret.equals(other$imagePullSecret)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
            return false;
        }
        Object this$proxyConfig = this.getProxyConfig();
        Object other$proxyConfig = other.getProxyConfig();
        if (this$proxyConfig == null ? other$proxyConfig != null : !this$proxyConfig.equals(other$proxyConfig)) {
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
        return other instanceof GlobalValues;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $imageOverrides = this.getImageOverrides();
        result = result * prime + ($imageOverrides == null ? 43 : $imageOverrides.hashCode());
        Object $imagePullPolicy = this.getImagePullPolicy();
        result = result * prime + ($imagePullPolicy == null ? 43 : $imagePullPolicy.hashCode());
        Object $imagePullSecret = this.getImagePullSecret();
        result = result * prime + ($imagePullSecret == null ? 43 : $imagePullSecret.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $proxyConfig = this.getProxyConfig();
        result = result * prime + ($proxyConfig == null ? 43 : $proxyConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GlobalValues(" + "imageOverrides=" + this.getImageOverrides() + ", imagePullPolicy=" + this.getImagePullPolicy() + ", imagePullSecret=" + this.getImagePullSecret() + ", nodeSelector=" + this.getNodeSelector() + ", proxyConfig=" + this.getProxyConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
