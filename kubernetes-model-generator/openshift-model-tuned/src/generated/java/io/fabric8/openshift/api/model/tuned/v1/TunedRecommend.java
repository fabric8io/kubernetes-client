
package io.fabric8.openshift.api.model.tuned.v1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Selection logic for a single Tuned profile.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "machineConfigLabels",
    "match",
    "operand",
    "priority",
    "profile"
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
public class TunedRecommend implements Editable<TunedRecommendBuilder>, KubernetesResource
{

    @JsonProperty("machineConfigLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> machineConfigLabels = new LinkedHashMap<>();
    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TunedMatch> match = new ArrayList<>();
    @JsonProperty("operand")
    private OperandConfig operand;
    @JsonProperty("priority")
    private Long priority;
    @JsonProperty("profile")
    private String profile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TunedRecommend() {
    }

    public TunedRecommend(Map<String, String> machineConfigLabels, List<TunedMatch> match, OperandConfig operand, Long priority, String profile) {
        super();
        this.machineConfigLabels = machineConfigLabels;
        this.match = match;
        this.operand = operand;
        this.priority = priority;
        this.profile = profile;
    }

    /**
     * MachineConfigLabels specifies the labels for a MachineConfig. The MachineConfig is created automatically to apply additional host settings (e.g. kernel boot parameters) profile 'Profile' needs and can only be applied by creating a MachineConfig. This involves finding all MachineConfigPools with machineConfigSelector matching the MachineConfigLabels and setting the profile 'Profile' on all nodes that match the MachineConfigPools' nodeSelectors.
     */
    @JsonProperty("machineConfigLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getMachineConfigLabels() {
        return machineConfigLabels;
    }

    /**
     * MachineConfigLabels specifies the labels for a MachineConfig. The MachineConfig is created automatically to apply additional host settings (e.g. kernel boot parameters) profile 'Profile' needs and can only be applied by creating a MachineConfig. This involves finding all MachineConfigPools with machineConfigSelector matching the MachineConfigLabels and setting the profile 'Profile' on all nodes that match the MachineConfigPools' nodeSelectors.
     */
    @JsonProperty("machineConfigLabels")
    public void setMachineConfigLabels(Map<String, String> machineConfigLabels) {
        this.machineConfigLabels = machineConfigLabels;
    }

    /**
     * Rules governing application of a Tuned profile connected by logical OR operator.
     */
    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TunedMatch> getMatch() {
        return match;
    }

    /**
     * Rules governing application of a Tuned profile connected by logical OR operator.
     */
    @JsonProperty("match")
    public void setMatch(List<TunedMatch> match) {
        this.match = match;
    }

    /**
     * Selection logic for a single Tuned profile.
     */
    @JsonProperty("operand")
    public OperandConfig getOperand() {
        return operand;
    }

    /**
     * Selection logic for a single Tuned profile.
     */
    @JsonProperty("operand")
    public void setOperand(OperandConfig operand) {
        this.operand = operand;
    }

    /**
     * Tuned profile priority. Highest priority is 0.
     */
    @JsonProperty("priority")
    public Long getPriority() {
        return priority;
    }

    /**
     * Tuned profile priority. Highest priority is 0.
     */
    @JsonProperty("priority")
    public void setPriority(Long priority) {
        this.priority = priority;
    }

    /**
     * Name of the Tuned profile to recommend.
     */
    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    /**
     * Name of the Tuned profile to recommend.
     */
    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    @JsonIgnore
    public TunedRecommendBuilder edit() {
        return new TunedRecommendBuilder(this);
    }

    @JsonIgnore
    public TunedRecommendBuilder toBuilder() {
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
