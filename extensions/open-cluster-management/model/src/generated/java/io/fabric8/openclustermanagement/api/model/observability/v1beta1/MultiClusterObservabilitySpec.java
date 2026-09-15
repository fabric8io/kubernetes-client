
package io.fabric8.openclustermanagement.api.model.observability.v1beta1;

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
    "availabilityConfig",
    "enableDownSampling",
    "imagePullPolicy",
    "imagePullSecret",
    "nodeSelector",
    "observabilityAddonSpec",
    "retentionResolution1h",
    "retentionResolution5m",
    "retentionResolutionRaw",
    "storageConfigObject",
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

    @JsonProperty("availabilityConfig")
    private String availabilityConfig;
    @JsonProperty("enableDownSampling")
    private Boolean enableDownSampling;
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;
    @JsonProperty("imagePullSecret")
    private String imagePullSecret;
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeSelector = new LinkedHashMap<>();
    @JsonProperty("observabilityAddonSpec")
    private ObservabilityAddonSpec observabilityAddonSpec;
    @JsonProperty("retentionResolution1h")
    private String retentionResolution1h;
    @JsonProperty("retentionResolution5m")
    private String retentionResolution5m;
    @JsonProperty("retentionResolutionRaw")
    private String retentionResolutionRaw;
    @JsonProperty("storageConfigObject")
    private StorageConfigObject storageConfigObject;
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

    public MultiClusterObservabilitySpec(String availabilityConfig, Boolean enableDownSampling, String imagePullPolicy, String imagePullSecret, Map<String, String> nodeSelector, ObservabilityAddonSpec observabilityAddonSpec, String retentionResolution1h, String retentionResolution5m, String retentionResolutionRaw, StorageConfigObject storageConfigObject, List<Toleration> tolerations) {
        super();
        this.availabilityConfig = availabilityConfig;
        this.enableDownSampling = enableDownSampling;
        this.imagePullPolicy = imagePullPolicy;
        this.imagePullSecret = imagePullSecret;
        this.nodeSelector = nodeSelector;
        this.observabilityAddonSpec = observabilityAddonSpec;
        this.retentionResolution1h = retentionResolution1h;
        this.retentionResolution5m = retentionResolution5m;
        this.retentionResolutionRaw = retentionResolutionRaw;
        this.storageConfigObject = storageConfigObject;
        this.tolerations = tolerations;
    }

    /**
     * ReplicaCount for HA support. Does not affect data stores. Enabled will toggle HA support. This will provide better support in cases of failover but consumes more resources. Options are: Basic and High (default).
     */
    @JsonProperty("availabilityConfig")
    public String getAvailabilityConfig() {
        return availabilityConfig;
    }

    /**
     * ReplicaCount for HA support. Does not affect data stores. Enabled will toggle HA support. This will provide better support in cases of failover but consumes more resources. Options are: Basic and High (default).
     */
    @JsonProperty("availabilityConfig")
    public void setAvailabilityConfig(String availabilityConfig) {
        this.availabilityConfig = availabilityConfig;
    }

    /**
     * Enable or disable the downsample. The default value is false. This is not recommended as querying long time ranges without non-downsampled data is not efficient and useful.
     */
    @JsonProperty("enableDownSampling")
    public Boolean getEnableDownSampling() {
        return enableDownSampling;
    }

    /**
     * Enable or disable the downsample. The default value is false. This is not recommended as querying long time ranges without non-downsampled data is not efficient and useful.
     */
    @JsonProperty("enableDownSampling")
    public void setEnableDownSampling(Boolean enableDownSampling) {
        this.enableDownSampling = enableDownSampling;
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
     * How long to retain samples of resolution 2 (1 hour) in bucket.
     */
    @JsonProperty("retentionResolution1h")
    public String getRetentionResolution1h() {
        return retentionResolution1h;
    }

    /**
     * How long to retain samples of resolution 2 (1 hour) in bucket.
     */
    @JsonProperty("retentionResolution1h")
    public void setRetentionResolution1h(String retentionResolution1h) {
        this.retentionResolution1h = retentionResolution1h;
    }

    /**
     * How long to retain samples of resolution 1 (5 minutes) in bucket.
     */
    @JsonProperty("retentionResolution5m")
    public String getRetentionResolution5m() {
        return retentionResolution5m;
    }

    /**
     * How long to retain samples of resolution 1 (5 minutes) in bucket.
     */
    @JsonProperty("retentionResolution5m")
    public void setRetentionResolution5m(String retentionResolution5m) {
        this.retentionResolution5m = retentionResolution5m;
    }

    /**
     * How long to retain raw samples in a bucket.
     */
    @JsonProperty("retentionResolutionRaw")
    public String getRetentionResolutionRaw() {
        return retentionResolutionRaw;
    }

    /**
     * How long to retain raw samples in a bucket.
     */
    @JsonProperty("retentionResolutionRaw")
    public void setRetentionResolutionRaw(String retentionResolutionRaw) {
        this.retentionResolutionRaw = retentionResolutionRaw;
    }

    /**
     * MultiClusterObservabilitySpec defines the desired state of MultiClusterObservability.
     */
    @JsonProperty("storageConfigObject")
    public StorageConfigObject getStorageConfigObject() {
        return storageConfigObject;
    }

    /**
     * MultiClusterObservabilitySpec defines the desired state of MultiClusterObservability.
     */
    @JsonProperty("storageConfigObject")
    public void setStorageConfigObject(StorageConfigObject storageConfigObject) {
        this.storageConfigObject = storageConfigObject;
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
        Object this$availabilityConfig = this.getAvailabilityConfig();
        Object other$availabilityConfig = other.getAvailabilityConfig();
        if (this$availabilityConfig == null ? other$availabilityConfig != null : !this$availabilityConfig.equals(other$availabilityConfig)) {
            return false;
        }
        Object this$enableDownSampling = this.getEnableDownSampling();
        Object other$enableDownSampling = other.getEnableDownSampling();
        if (this$enableDownSampling == null ? other$enableDownSampling != null : !this$enableDownSampling.equals(other$enableDownSampling)) {
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
        Object this$observabilityAddonSpec = this.getObservabilityAddonSpec();
        Object other$observabilityAddonSpec = other.getObservabilityAddonSpec();
        if (this$observabilityAddonSpec == null ? other$observabilityAddonSpec != null : !this$observabilityAddonSpec.equals(other$observabilityAddonSpec)) {
            return false;
        }
        Object this$retentionResolution1h = this.getRetentionResolution1h();
        Object other$retentionResolution1h = other.getRetentionResolution1h();
        if (this$retentionResolution1h == null ? other$retentionResolution1h != null : !this$retentionResolution1h.equals(other$retentionResolution1h)) {
            return false;
        }
        Object this$retentionResolution5m = this.getRetentionResolution5m();
        Object other$retentionResolution5m = other.getRetentionResolution5m();
        if (this$retentionResolution5m == null ? other$retentionResolution5m != null : !this$retentionResolution5m.equals(other$retentionResolution5m)) {
            return false;
        }
        Object this$retentionResolutionRaw = this.getRetentionResolutionRaw();
        Object other$retentionResolutionRaw = other.getRetentionResolutionRaw();
        if (this$retentionResolutionRaw == null ? other$retentionResolutionRaw != null : !this$retentionResolutionRaw.equals(other$retentionResolutionRaw)) {
            return false;
        }
        Object this$storageConfigObject = this.getStorageConfigObject();
        Object other$storageConfigObject = other.getStorageConfigObject();
        if (this$storageConfigObject == null ? other$storageConfigObject != null : !this$storageConfigObject.equals(other$storageConfigObject)) {
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
        Object $availabilityConfig = this.getAvailabilityConfig();
        result = result * prime + ($availabilityConfig == null ? 43 : $availabilityConfig.hashCode());
        Object $enableDownSampling = this.getEnableDownSampling();
        result = result * prime + ($enableDownSampling == null ? 43 : $enableDownSampling.hashCode());
        Object $imagePullPolicy = this.getImagePullPolicy();
        result = result * prime + ($imagePullPolicy == null ? 43 : $imagePullPolicy.hashCode());
        Object $imagePullSecret = this.getImagePullSecret();
        result = result * prime + ($imagePullSecret == null ? 43 : $imagePullSecret.hashCode());
        Object $nodeSelector = this.getNodeSelector();
        result = result * prime + ($nodeSelector == null ? 43 : $nodeSelector.hashCode());
        Object $observabilityAddonSpec = this.getObservabilityAddonSpec();
        result = result * prime + ($observabilityAddonSpec == null ? 43 : $observabilityAddonSpec.hashCode());
        Object $retentionResolution1h = this.getRetentionResolution1h();
        result = result * prime + ($retentionResolution1h == null ? 43 : $retentionResolution1h.hashCode());
        Object $retentionResolution5m = this.getRetentionResolution5m();
        result = result * prime + ($retentionResolution5m == null ? 43 : $retentionResolution5m.hashCode());
        Object $retentionResolutionRaw = this.getRetentionResolutionRaw();
        result = result * prime + ($retentionResolutionRaw == null ? 43 : $retentionResolutionRaw.hashCode());
        Object $storageConfigObject = this.getStorageConfigObject();
        result = result * prime + ($storageConfigObject == null ? 43 : $storageConfigObject.hashCode());
        Object $tolerations = this.getTolerations();
        result = result * prime + ($tolerations == null ? 43 : $tolerations.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MultiClusterObservabilitySpec(" + "availabilityConfig=" + this.getAvailabilityConfig() + ", enableDownSampling=" + this.getEnableDownSampling() + ", imagePullPolicy=" + this.getImagePullPolicy() + ", imagePullSecret=" + this.getImagePullSecret() + ", nodeSelector=" + this.getNodeSelector() + ", observabilityAddonSpec=" + this.getObservabilityAddonSpec() + ", retentionResolution1h=" + this.getRetentionResolution1h() + ", retentionResolution5m=" + this.getRetentionResolution5m() + ", retentionResolutionRaw=" + this.getRetentionResolutionRaw() + ", storageConfigObject=" + this.getStorageConfigObject() + ", tolerations=" + this.getTolerations() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
