
package io.fabric8.openshift.api.model.config.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disabledPlugins",
    "enabledPlugins",
    "pluginConfig"
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
public class AdmissionConfig implements Editable<AdmissionConfigBuilder>, KubernetesResource
{

    @JsonProperty("disabledPlugins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> disabledPlugins = new ArrayList<>();
    @JsonProperty("enabledPlugins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> enabledPlugins = new ArrayList<>();
    @JsonProperty("pluginConfig")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, AdmissionPluginConfig> pluginConfig = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AdmissionConfig() {
    }

    public AdmissionConfig(List<String> disabledPlugins, List<String> enabledPlugins, Map<String, AdmissionPluginConfig> pluginConfig) {
        super();
        this.disabledPlugins = disabledPlugins;
        this.enabledPlugins = enabledPlugins;
        this.pluginConfig = pluginConfig;
    }

    /**
     * disabledPlugins is a list of admission plugins that must be off.  Putting something in this list is almost always a mistake and likely to result in cluster instability.
     */
    @JsonProperty("disabledPlugins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDisabledPlugins() {
        return disabledPlugins;
    }

    /**
     * disabledPlugins is a list of admission plugins that must be off.  Putting something in this list is almost always a mistake and likely to result in cluster instability.
     */
    @JsonProperty("disabledPlugins")
    public void setDisabledPlugins(List<String> disabledPlugins) {
        this.disabledPlugins = disabledPlugins;
    }

    /**
     * enabledPlugins is a list of admission plugins that must be on in addition to the default list. Some admission plugins are disabled by default, but certain configurations require them.  This is fairly uncommon and can result in performance penalties and unexpected behavior.
     */
    @JsonProperty("enabledPlugins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEnabledPlugins() {
        return enabledPlugins;
    }

    /**
     * enabledPlugins is a list of admission plugins that must be on in addition to the default list. Some admission plugins are disabled by default, but certain configurations require them.  This is fairly uncommon and can result in performance penalties and unexpected behavior.
     */
    @JsonProperty("enabledPlugins")
    public void setEnabledPlugins(List<String> enabledPlugins) {
        this.enabledPlugins = enabledPlugins;
    }

    @JsonProperty("pluginConfig")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, AdmissionPluginConfig> getPluginConfig() {
        return pluginConfig;
    }

    @JsonProperty("pluginConfig")
    public void setPluginConfig(Map<String, AdmissionPluginConfig> pluginConfig) {
        this.pluginConfig = pluginConfig;
    }

    @JsonIgnore
    public AdmissionConfigBuilder edit() {
        return new AdmissionConfigBuilder(this);
    }

    @JsonIgnore
    public AdmissionConfigBuilder toBuilder() {
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
        if (!(o instanceof AdmissionConfig)) {
            return false;
        }
        AdmissionConfig other = (AdmissionConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$disabledPlugins = this.getDisabledPlugins();
        Object other$disabledPlugins = other.getDisabledPlugins();
        if (this$disabledPlugins == null ? other$disabledPlugins != null : !this$disabledPlugins.equals(other$disabledPlugins)) {
            return false;
        }
        Object this$enabledPlugins = this.getEnabledPlugins();
        Object other$enabledPlugins = other.getEnabledPlugins();
        if (this$enabledPlugins == null ? other$enabledPlugins != null : !this$enabledPlugins.equals(other$enabledPlugins)) {
            return false;
        }
        Object this$pluginConfig = this.getPluginConfig();
        Object other$pluginConfig = other.getPluginConfig();
        if (this$pluginConfig == null ? other$pluginConfig != null : !this$pluginConfig.equals(other$pluginConfig)) {
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
        return other instanceof AdmissionConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $disabledPlugins = this.getDisabledPlugins();
        result = result * prime + ($disabledPlugins == null ? 43 : $disabledPlugins.hashCode());
        Object $enabledPlugins = this.getEnabledPlugins();
        result = result * prime + ($enabledPlugins == null ? 43 : $enabledPlugins.hashCode());
        Object $pluginConfig = this.getPluginConfig();
        result = result * prime + ($pluginConfig == null ? 43 : $pluginConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AdmissionConfig(" + "disabledPlugins=" + this.getDisabledPlugins() + ", enabledPlugins=" + this.getEnabledPlugins() + ", pluginConfig=" + this.getPluginConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
