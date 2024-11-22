
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
public class MultiClusterObservabilitySpec implements Editable<MultiClusterObservabilitySpecBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("advanced")
    public AdvancedConfig getAdvanced() {
        return advanced;
    }

    @JsonProperty("advanced")
    public void setAdvanced(AdvancedConfig advanced) {
        this.advanced = advanced;
    }

    @JsonProperty("capabilities")
    public CapabilitiesSpec getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(CapabilitiesSpec capabilities) {
        this.capabilities = capabilities;
    }

    @JsonProperty("enableDownsampling")
    public Boolean getEnableDownsampling() {
        return enableDownsampling;
    }

    @JsonProperty("enableDownsampling")
    public void setEnableDownsampling(Boolean enableDownsampling) {
        this.enableDownsampling = enableDownsampling;
    }

    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    @JsonProperty("imagePullSecret")
    public String getImagePullSecret() {
        return imagePullSecret;
    }

    @JsonProperty("imagePullSecret")
    public void setImagePullSecret(String imagePullSecret) {
        this.imagePullSecret = imagePullSecret;
    }

    @JsonProperty("instanceSize")
    public String getInstanceSize() {
        return instanceSize;
    }

    @JsonProperty("instanceSize")
    public void setInstanceSize(String instanceSize) {
        this.instanceSize = instanceSize;
    }

    @JsonProperty("nodeSelector")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(Map<String, String> nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    @JsonProperty("observabilityAddonSpec")
    public ObservabilityAddonSpec getObservabilityAddonSpec() {
        return observabilityAddonSpec;
    }

    @JsonProperty("observabilityAddonSpec")
    public void setObservabilityAddonSpec(ObservabilityAddonSpec observabilityAddonSpec) {
        this.observabilityAddonSpec = observabilityAddonSpec;
    }

    @JsonProperty("storageConfig")
    public StorageConfig getStorageConfig() {
        return storageConfig;
    }

    @JsonProperty("storageConfig")
    public void setStorageConfig(StorageConfig storageConfig) {
        this.storageConfig = storageConfig;
    }

    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

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
