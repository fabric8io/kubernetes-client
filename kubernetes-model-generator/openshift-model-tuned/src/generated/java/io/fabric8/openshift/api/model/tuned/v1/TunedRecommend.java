
package io.fabric8.openshift.api.model.tuned.v1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

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
        if (!(o instanceof TunedRecommend)) {
            return false;
        }
        TunedRecommend other = (TunedRecommend) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$machineConfigLabels = this.getMachineConfigLabels();
        Object other$machineConfigLabels = other.getMachineConfigLabels();
        if (this$machineConfigLabels == null ? other$machineConfigLabels != null : !this$machineConfigLabels.equals(other$machineConfigLabels)) {
            return false;
        }
        Object this$match = this.getMatch();
        Object other$match = other.getMatch();
        if (this$match == null ? other$match != null : !this$match.equals(other$match)) {
            return false;
        }
        Object this$operand = this.getOperand();
        Object other$operand = other.getOperand();
        if (this$operand == null ? other$operand != null : !this$operand.equals(other$operand)) {
            return false;
        }
        Object this$priority = this.getPriority();
        Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) {
            return false;
        }
        Object this$profile = this.getProfile();
        Object other$profile = other.getProfile();
        if (this$profile == null ? other$profile != null : !this$profile.equals(other$profile)) {
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
        return other instanceof TunedRecommend;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $machineConfigLabels = this.getMachineConfigLabels();
        result = result * prime + ($machineConfigLabels == null ? 43 : $machineConfigLabels.hashCode());
        Object $match = this.getMatch();
        result = result * prime + ($match == null ? 43 : $match.hashCode());
        Object $operand = this.getOperand();
        result = result * prime + ($operand == null ? 43 : $operand.hashCode());
        Object $priority = this.getPriority();
        result = result * prime + ($priority == null ? 43 : $priority.hashCode());
        Object $profile = this.getProfile();
        result = result * prime + ($profile == null ? 43 : $profile.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TunedRecommend(" + "machineConfigLabels=" + this.getMachineConfigLabels() + ", match=" + this.getMatch() + ", operand=" + this.getOperand() + ", priority=" + this.getPriority() + ", profile=" + this.getProfile() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
