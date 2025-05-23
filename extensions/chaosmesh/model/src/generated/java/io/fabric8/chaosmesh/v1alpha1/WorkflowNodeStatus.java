
package io.fabric8.chaosmesh.v1alpha1;

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
import io.fabric8.kubernetes.api.model.TypedLocalObjectReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "activeChildren",
    "chaosResource",
    "conditionalBranchesStatus",
    "conditions",
    "finishedChildren"
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
public class WorkflowNodeStatus implements Editable<WorkflowNodeStatusBuilder>, KubernetesResource
{

    @JsonProperty("activeChildren")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalObjectReference> activeChildren = new ArrayList<>();
    @JsonProperty("chaosResource")
    private TypedLocalObjectReference chaosResource;
    @JsonProperty("conditionalBranchesStatus")
    private ConditionalBranchesStatus conditionalBranchesStatus;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WorkflowNodeCondition> conditions = new ArrayList<>();
    @JsonProperty("finishedChildren")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<LocalObjectReference> finishedChildren = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WorkflowNodeStatus() {
    }

    public WorkflowNodeStatus(List<LocalObjectReference> activeChildren, TypedLocalObjectReference chaosResource, ConditionalBranchesStatus conditionalBranchesStatus, List<WorkflowNodeCondition> conditions, List<LocalObjectReference> finishedChildren) {
        super();
        this.activeChildren = activeChildren;
        this.chaosResource = chaosResource;
        this.conditionalBranchesStatus = conditionalBranchesStatus;
        this.conditions = conditions;
        this.finishedChildren = finishedChildren;
    }

    /**
     * ActiveChildren means the created children node
     */
    @JsonProperty("activeChildren")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getActiveChildren() {
        return activeChildren;
    }

    /**
     * ActiveChildren means the created children node
     */
    @JsonProperty("activeChildren")
    public void setActiveChildren(List<LocalObjectReference> activeChildren) {
        this.activeChildren = activeChildren;
    }

    @JsonProperty("chaosResource")
    public TypedLocalObjectReference getChaosResource() {
        return chaosResource;
    }

    @JsonProperty("chaosResource")
    public void setChaosResource(TypedLocalObjectReference chaosResource) {
        this.chaosResource = chaosResource;
    }

    @JsonProperty("conditionalBranchesStatus")
    public ConditionalBranchesStatus getConditionalBranchesStatus() {
        return conditionalBranchesStatus;
    }

    @JsonProperty("conditionalBranchesStatus")
    public void setConditionalBranchesStatus(ConditionalBranchesStatus conditionalBranchesStatus) {
        this.conditionalBranchesStatus = conditionalBranchesStatus;
    }

    /**
     * Represents the latest available observations of a workflow node's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WorkflowNodeCondition> getConditions() {
        return conditions;
    }

    /**
     * Represents the latest available observations of a workflow node's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<WorkflowNodeCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * Children is necessary for representing the order when replicated child template references by parent template.
     */
    @JsonProperty("finishedChildren")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<LocalObjectReference> getFinishedChildren() {
        return finishedChildren;
    }

    /**
     * Children is necessary for representing the order when replicated child template references by parent template.
     */
    @JsonProperty("finishedChildren")
    public void setFinishedChildren(List<LocalObjectReference> finishedChildren) {
        this.finishedChildren = finishedChildren;
    }

    @JsonIgnore
    public WorkflowNodeStatusBuilder edit() {
        return new WorkflowNodeStatusBuilder(this);
    }

    @JsonIgnore
    public WorkflowNodeStatusBuilder toBuilder() {
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
