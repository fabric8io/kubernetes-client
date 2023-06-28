
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "machineConfigLabels",
    "match",
    "operand",
    "priority",
    "profile"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class TunedRecommend implements KubernetesResource
{

    @JsonProperty("machineConfigLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> machineConfigLabels = new LinkedHashMap<String, String>();
    @JsonProperty("match")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TunedMatch> match = new ArrayList<TunedMatch>();
    @JsonProperty("operand")
    private OperandConfig operand;
    @JsonProperty("priority")
    private Long priority;
    @JsonProperty("profile")
    private java.lang.String profile;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TunedRecommend() {
    }

    public TunedRecommend(Map<String, String> machineConfigLabels, List<TunedMatch> match, OperandConfig operand, Long priority, java.lang.String profile) {
        super();
        this.machineConfigLabels = machineConfigLabels;
        this.match = match;
        this.operand = operand;
        this.priority = priority;
        this.profile = profile;
    }

    @JsonProperty("machineConfigLabels")
    public Map<String, String> getMachineConfigLabels() {
        return machineConfigLabels;
    }

    @JsonProperty("machineConfigLabels")
    public void setMachineConfigLabels(Map<String, String> machineConfigLabels) {
        this.machineConfigLabels = machineConfigLabels;
    }

    @JsonProperty("match")
    public List<TunedMatch> getMatch() {
        return match;
    }

    @JsonProperty("match")
    public void setMatch(List<TunedMatch> match) {
        this.match = match;
    }

    @JsonProperty("operand")
    public OperandConfig getOperand() {
        return operand;
    }

    @JsonProperty("operand")
    public void setOperand(OperandConfig operand) {
        this.operand = operand;
    }

    @JsonProperty("priority")
    public Long getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Long priority) {
        this.priority = priority;
    }

    @JsonProperty("profile")
    public java.lang.String getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(java.lang.String profile) {
        this.profile = profile;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
