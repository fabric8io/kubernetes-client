
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Toleration;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openclustermanagement.api.model.shared.ObservabilityAddonSpec;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * MultiClusterObservabilitySpec defines the desired state of MultiClusterObservability.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "advanced",
    "capabilities",
    "enableDownsampling",
    "imagePullPolicy",
    "imagePullSecret",
    "instanceSize",
    "nodeSelector",
    "observabilityAddonSpec",
    "storageConfig",
    "tolerations"
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
public class MultiClusterObservabilitySpec implements Editable<MultiClusterObservabilitySpecBuilder>, KubernetesResource
{

    @JsonProperty("advanced")
    private AdvancedConfig advanced;
    @JsonProperty("capabilities")
    private CapabilitiesSpec capabilities;
    @JsonProperty("enableDownsampling")
    private Boolean enableDownsampling;
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("imagePullSecret")
    private String imagePullSecret;
    @JsonProperty("instanceSize")
    private String instanceSize;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("observabilityAddonSpec")
    private ObservabilityAddonSpec observabilityAddonSpec;
    @JsonProperty("storageConfig")
    private StorageConfig storageConfig;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MultiClusterObservabilitySpec() {
    }

    public MultiClusterObservabilitySpec(AdvancedConfig advanced, CapabilitiesSpec capabilities, Boolean enableDownsampling, String imagePullPolicy, String imagePullSecret, String instanceSize, Map<String, String> nodeSelector, ObservabilityAddonSpec observabilityAddonSpec, StorageConfig storageConfig, List<Toleration> tolerations) {
        super();
        this.advanced = advanced;
        this.capabilities = capabilities;
        this.enableDownsampling = enableDownsampling;
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSecret = imagePullSecret;
        this.instanceSize = instanceSize;
        this.nodeSelector = nodeSelector;
        this.observabilityAddonSpec = observabilityAddonSpec;
        this.storageConfig = storageConfig;
        this.tolerations = tolerations;
    }

    /**
     * MultiClusterObservabilitySpec defines the desired state of MultiClusterObservability.
     */
    @JsonProperty("advanced")
    public AdvancedConfig getAdvanced() {
        return advanced;
    }

    /**
     * MultiClusterObservabilitySpec defines the desired state of MultiClusterObservability.
     */
    @JsonProperty("advanced")
    public void setAdvanced(AdvancedConfig advanced) {
        this.advanced = advanced;
    }

    /**
     * MultiClusterObservabilitySpec defines the desired state of MultiClusterObservability.
     */
    @JsonProperty("capabilities")
    public CapabilitiesSpec getCapabilities() {
        return capabilities;
    }

    /**
     * MultiClusterObservabilitySpec defines the desired state of MultiClusterObservability.
     */
    @JsonProperty("capabilities")
    public void setCapabilities(CapabilitiesSpec capabilities) {
        this.capabilities = capabilities;
    }

    /**
     * Enable or disable the downsample.
     */
    @JsonProperty("enableDownsampling")
    public Boolean getEnableDownsampling() {
        return enableDownsampling;
    }

    /**
     * Enable or disable the downsample.
     */
    @JsonProperty("enableDownsampling")
    public void setEnableDownsampling(Boolean enableDownsampling) {
        this.enableDownsampling = enableDownsampling;
    }

    /**
     * Pull policy of the MultiClusterObservability images
     */
    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * Pull policy of the MultiClusterObservability images
     */
    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * Pull secret of the MultiClusterObservability images
     */
    @JsonProperty("imagePullSecret")
    public String getImagePullSecret() {
        return imagePullSecret;
    }

    /**
     * Pull secret of the MultiClusterObservability images
     */
    @JsonProperty("imagePullSecret")
    public void setImagePullSecret(String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    /**
     * Size read and write paths of your Observability instance
     */
    @JsonProperty("instanceSize")
    public String getInstanceSize() {
        return instanceSize;
    }

    /**
     * Size read and write paths of your Observability instance
     */
    @JsonProperty("instanceSize")
    public void setInstanceSize(String instanceSize) {
        this.instanceSize = instanceSize;
    }

    /**
     * Spec of NodeSelector
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * Spec of NodeSelector
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * MultiClusterObservabilitySpec defines the desired state of MultiClusterObservability.
     */
    @JsonProperty("observabilityAddonSpec")
    public ObservabilityAddonSpec getObservabilityAddonSpec() {
        return observabilityAddonSpec;
    }

    /**
     * MultiClusterObservabilitySpec defines the desired state of MultiClusterObservability.
     */
    @JsonProperty("observabilityAddonSpec")
    public void setObservabilityAddonSpec(ObservabilityAddonSpec observabilityAddonSpec) {
        this.observabilityAddonSpec = observabilityAddonSpec;
    }

    /**
     * MultiClusterObservabilitySpec defines the desired state of MultiClusterObservability.
     */
    @JsonProperty("storageConfig")
    public StorageConfig getStorageConfig() {
        return storageConfig;
    }

    /**
     * MultiClusterObservabilitySpec defines the desired state of MultiClusterObservability.
     */
    @JsonProperty("storageConfig")
    public void setStorageConfig(StorageConfig storageConfig) {
        this.storageConfig = storageConfig;
    }

    /**
     * Tolerations causes all components to tolerate any taints.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * Tolerations causes all components to tolerate any taints.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonIgnore
    public MultiClusterObservabilitySpecBuilder edit() {
        return new MultiClusterObservabilitySpecBuilder(this);
    }

    @JsonIgnore
    public MultiClusterObservabilitySpecBuilder toBuilder() {
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
        if (!(o instanceof MultiClusterObservabilitySpec)) {
            return false;
        }
        MultiClusterObservabilitySpec other = (MultiClusterObservabilitySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$advanced = this.getAdvanced();
        Object other$advanced = other.getAdvanced();
        if (this$advanced == null ? other$advanced != null : !this$advanced.equals(other$advanced)) {
            return false;
        }
        Object this$capabilities = this.getCapabilities();
        Object other$capabilities = other.getCapabilities();
        if (this$capabilities == null ? other$capabilities != null : !this$capabilities.equals(other$capabilities)) {
            return false;
        }
        Object this$enableDownsampling = this.getEnableDownsampling();
        Object other$enableDownsampling = other.getEnableDownsampling();
        if (this$enableDownsampling == null ? other$enableDownsampling != null : !this$enableDownsampling.equals(other$enableDownsampling)) {
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
        Object this$instanceSize = this.getInstanceSize();
        Object other$instanceSize = other.getInstanceSize();
        if (this$instanceSize == null ? other$instanceSize != null : !this$instanceSize.equals(other$instanceSize)) {
            return false;
        }
        Object this$nodeSelector = this.getNodeSelector();
        Object other$nodeSelector = other.getNodeSelector();
        if (this$nodeSelector == null ? other$nodeSelector != null : !this$nodeSelector.equals(other$nodeSelector)) {
            return false;
        }
        Object this$observabilityAddonSpec = this.getObservabilityAddonSpec();
        Object other$observabilityAddonSpec = other.getObservabilityAddonSpec();
        if (this$observabilityAddonSpec == null ? other$observabilityAddonSpec != null : !this$observabilityAddonSpec.equals(other$observabilityAddonSpec)) {
            return false;
        }
        Object this$storageConfig = this.getStorageConfig();
        Object other$storageConfig = other.getStorageConfig();
        if (this$storageConfig == null ? other$storageConfig != null : !this$storageConfig.equals(other$storageConfig)) {
            return false;
        }
        Object this$tolerations = this.getTolerations();
        Object other$tolerations = other.getTolerations();
        if (this$tolerations == null ? other$tolerations != null : !this$tolerations.equals(other$tolerations)) {
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
        return other instanceof MultiClusterObservabilitySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $advanced = this.getAdvanced();
        result = result * prime + ($advanced == null ? 43 : $advanced.hashCode());
        Object $capabilities = this.getCapabilities();
        result = result * prime + ($capabilities == null ? 43 : $capabilities.hashCode());
        Object $enableDownsampling = this.getEnableDownsampling();
        result = result * prime + ($enableDownsampling == null ? 43 : $enableDownsampling.hashCode());
        Object $imagePullPolicy = this.getImagePullPolicy();
        result = result * prime + ($imagePullPolicy == null ? 43 : $imagePullPolicy.hashCode());
        Object $imagePullSecret = this.getImagePullSecret();
        result = result * prime + ($imagePullSecret == null ? 43 : $imagePullSecret.hashCode());
        Object $instanceSize = this.getInstanceSize();
        result = result * prime + ($instanceSize == null ? 43 : $instanceSize.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $observabilityAddonSpec = this.getObservabilityAddonSpec();
        result = result * prime + ($observabilityAddonSpec == null ? 43 : $observabilityAddonSpec.hashCode());
        Object $storageConfig = this.getStorageConfig();
        result = result * prime + ($storageConfig == null ? 43 : $storageConfig.hashCode());
        Object $tolerations = this.getTolerations();
        result = result * prime + ($tolerations == null ? 43 : $tolerations.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MultiClusterObservabilitySpec(" + "advanced=" + this.getAdvanced() + ", capabilities=" + this.getCapabilities() + ", enableDownsampling=" + this.getEnableDownsampling() + ", imagePullPolicy=" + this.getImagePullPolicy() + ", imagePullSecret=" + this.getImagePullSecret() + ", instanceSize=" + this.getInstanceSize() + ", nodeSelector=" + this.getNodeSelector() + ", observabilityAddonSpec=" + this.getObservabilityAddonSpec() + ", storageConfig=" + this.getStorageConfig() + ", tolerations=" + this.getTolerations() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
