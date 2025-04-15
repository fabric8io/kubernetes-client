
package io.fabric8.openshift.api.model.operator.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * OperatorStatus contains common fields for an operator to need.  It is intended to be anonymous included inside of the Status struct for you particular operator. DEPRECATED: Use v1.OperatorStatus instead
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "currentVersionAvailability",
    "observedGeneration",
    "state",
    "targetVersionAvailability",
    "taskSummary"
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
public class OperatorStatus implements Editable<OperatorStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OperatorCondition> conditions = new ArrayList<>();
    @JsonProperty("currentVersionAvailability")
    private VersionAvailability currentVersionAvailability;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("state")
    private String state;
    @JsonProperty("targetVersionAvailability")
    private VersionAvailability targetVersionAvailability;
    @JsonProperty("taskSummary")
    private String taskSummary;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OperatorStatus() {
    }

    public OperatorStatus(List<OperatorCondition> conditions, VersionAvailability currentVersionAvailability, Long observedGeneration, String state, VersionAvailability targetVersionAvailability, String taskSummary) {
        super();
        this.conditions = conditions;
        this.currentVersionAvailability = currentVersionAvailability;
        this.observedGeneration = observedGeneration;
        this.state = state;
        this.targetVersionAvailability = targetVersionAvailability;
        this.taskSummary = taskSummary;
    }

    /**
     * conditions is a list of conditions and their status
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OperatorCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions is a list of conditions and their status
     */
    @JsonProperty("conditions")
    public void setConditions(List<OperatorCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * OperatorStatus contains common fields for an operator to need.  It is intended to be anonymous included inside of the Status struct for you particular operator. DEPRECATED: Use v1.OperatorStatus instead
     */
    @JsonProperty("currentVersionAvailability")
    public VersionAvailability getCurrentVersionAvailability() {
        return currentVersionAvailability;
    }

    /**
     * OperatorStatus contains common fields for an operator to need.  It is intended to be anonymous included inside of the Status struct for you particular operator. DEPRECATED: Use v1.OperatorStatus instead
     */
    @JsonProperty("currentVersionAvailability")
    public void setCurrentVersionAvailability(VersionAvailability currentVersionAvailability) {
        this.currentVersionAvailability = currentVersionAvailability;
    }

    /**
     * observedGeneration is the last generation change you've dealt with
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration is the last generation change you've dealt with
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * state indicates what the operator has observed to be its current operational status.
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * state indicates what the operator has observed to be its current operational status.
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * OperatorStatus contains common fields for an operator to need.  It is intended to be anonymous included inside of the Status struct for you particular operator. DEPRECATED: Use v1.OperatorStatus instead
     */
    @JsonProperty("targetVersionAvailability")
    public VersionAvailability getTargetVersionAvailability() {
        return targetVersionAvailability;
    }

    /**
     * OperatorStatus contains common fields for an operator to need.  It is intended to be anonymous included inside of the Status struct for you particular operator. DEPRECATED: Use v1.OperatorStatus instead
     */
    @JsonProperty("targetVersionAvailability")
    public void setTargetVersionAvailability(VersionAvailability targetVersionAvailability) {
        this.targetVersionAvailability = targetVersionAvailability;
    }

    /**
     * taskSummary is a high level summary of what the controller is currently attempting to do.  It is high-level, human-readable and not guaranteed in any way. (I needed this for debugging and realized it made a great summary).
     */
    @JsonProperty("taskSummary")
    public String getTaskSummary() {
        return taskSummary;
    }

    /**
     * taskSummary is a high level summary of what the controller is currently attempting to do.  It is high-level, human-readable and not guaranteed in any way. (I needed this for debugging and realized it made a great summary).
     */
    @JsonProperty("taskSummary")
    public void setTaskSummary(String taskSummary) {
        this.taskSummary = taskSummary;
    }

    @JsonIgnore
    public OperatorStatusBuilder edit() {
        return new OperatorStatusBuilder(this);
    }

    @JsonIgnore
    public OperatorStatusBuilder toBuilder() {
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
