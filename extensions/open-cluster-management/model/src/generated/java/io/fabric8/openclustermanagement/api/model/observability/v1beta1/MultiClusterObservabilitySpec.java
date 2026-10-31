
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * Configuration for the hub-side Observability stack.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
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
     * Pull policy of the MultiClusterObservability images. One of: Always, Never, IfNotPresent. Defaults to IfNotPresent.
     */
    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    /**
     * Pull policy of the MultiClusterObservability images. One of: Always, Never, IfNotPresent. Defaults to IfNotPresent.
     */
    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    /**
     * Name of an existing Secret of type kubernetes.io/dockerconfigjson in the same namespace used for pulling MultiClusterObservability images.
     */
    @JsonProperty("imagePullSecret")
    public String getImagePullSecret() {
        return imagePullSecret;
    }

    /**
     * Name of an existing Secret of type kubernetes.io/dockerconfigjson in the same namespace used for pulling MultiClusterObservability images.
     */
    @JsonProperty("imagePullSecret")
    public void setImagePullSecret(String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    /**
     * Node labels used to schedule all Observability workloads. Pods are only placed on nodes matching all specified labels.
     */
    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    /**
     * Node labels used to schedule all Observability workloads. Pods are only placed on nodes matching all specified labels.
     */
    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * Configuration for the hub-side Observability stack.
     */
    @JsonProperty("observabilityAddonSpec")
    public ObservabilityAddonSpec getObservabilityAddonSpec() {
        return observabilityAddonSpec;
    }

    /**
     * Configuration for the hub-side Observability stack.
     */
    @JsonProperty("observabilityAddonSpec")
    public void setObservabilityAddonSpec(ObservabilityAddonSpec observabilityAddonSpec) {
        this.observabilityAddonSpec = observabilityAddonSpec;
    }

    /**
     * How long to retain 1-hour downsampled (resolution 2) samples in object storage. Format: duration string, e.g. '365d'.
     */
    @JsonProperty("retentionResolution1h")
    public String getRetentionResolution1h() {
        return retentionResolution1h;
    }

    /**
     * How long to retain 1-hour downsampled (resolution 2) samples in object storage. Format: duration string, e.g. '365d'.
     */
    @JsonProperty("retentionResolution1h")
    public void setRetentionResolution1h(String retentionResolution1h) {
        this.retentionResolution1h = retentionResolution1h;
    }

    /**
     * How long to retain 5-minute downsampled (resolution 1) samples in object storage. Format: duration string, e.g. '14d'.
     */
    @JsonProperty("retentionResolution5m")
    public String getRetentionResolution5m() {
        return retentionResolution5m;
    }

    /**
     * How long to retain 5-minute downsampled (resolution 1) samples in object storage. Format: duration string, e.g. '14d'.
     */
    @JsonProperty("retentionResolution5m")
    public void setRetentionResolution5m(String retentionResolution5m) {
        this.retentionResolution5m = retentionResolution5m;
    }

    /**
     * How long to retain raw samples in a bucket. Format: duration string, e.g. '5d'. Raw data has the highest storage cost per day retained.
     */
    @JsonProperty("retentionResolutionRaw")
    public String getRetentionResolutionRaw() {
        return retentionResolutionRaw;
    }

    /**
     * How long to retain raw samples in a bucket. Format: duration string, e.g. '5d'. Raw data has the highest storage cost per day retained.
     */
    @JsonProperty("retentionResolutionRaw")
    public void setRetentionResolutionRaw(String retentionResolutionRaw) {
        this.retentionResolutionRaw = retentionResolutionRaw;
    }

    /**
     * Configuration for the hub-side Observability stack.
     */
    @JsonProperty("storageConfigObject")
    public StorageConfigObject getStorageConfigObject() {
        return storageConfigObject;
    }

    /**
     * Configuration for the hub-side Observability stack.
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

}
