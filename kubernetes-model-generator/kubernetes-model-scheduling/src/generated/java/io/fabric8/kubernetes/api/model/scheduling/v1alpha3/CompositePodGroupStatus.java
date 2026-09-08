
package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

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
import io.fabric8.kubernetes.api.model.Condition;
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
 * CompositePodGroupStatus represents information about the status of a composite pod group.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions"
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
public class CompositePodGroupStatus implements Editable<CompositePodGroupStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CompositePodGroupStatus() {
    }

    public CompositePodGroupStatus(List<Condition> conditions) {
        super();
        this.conditions = conditions;
    }

    /**
     * conditions represent the latest observations of the CompositePodGroup's state.<br><p> <br><p> Known condition types: - "CompositePodGroupInitiallyScheduled": Indicates whether the overall scheduling requirement<br><p>   for the subtree under this CompositePodGroup has been satisfied. Once this condition<br><p>   transitions to True, it serves as a terminal state and will never revert to False,<br><p>   even if pods are subsequently deleted and group constraints are no longer met.<br><p> - "DisruptionTarget": Indicates whether the CompositePodGroup is about to be terminated<br><p>   due to disruption such as preemption.<br><p> <br><p> Known reasons for the CompositePodGroupInitiallyScheduled condition: - "Unschedulable": The CompositePodGroup's subtree could not be placed due to resource constraints,<br><p>   affinity/anti-affinity, or topological constraints.<br><p> - "SchedulerError": The CompositePodGroup cannot be scheduled due to some internal error<br><p>   that occurred during scheduling.<br><p> - "Invalid": Set to True when kube-scheduler detects an invalid group layout during<br><p>   runtime validation. The `message` field details the specific layout violation (such as<br><p>   a detected cycle, exceeding the maximum depth of 4, or referencing multiple distinct Workloads).<br><p> <br><p> Known reasons for the DisruptionTarget condition: - "PreemptionByScheduler": The CompositePodGroup was targeted by the scheduler's preemption loop<br><p>   to free up capacity for higher-priority preemptors.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions represent the latest observations of the CompositePodGroup's state.<br><p> <br><p> Known condition types: - "CompositePodGroupInitiallyScheduled": Indicates whether the overall scheduling requirement<br><p>   for the subtree under this CompositePodGroup has been satisfied. Once this condition<br><p>   transitions to True, it serves as a terminal state and will never revert to False,<br><p>   even if pods are subsequently deleted and group constraints are no longer met.<br><p> - "DisruptionTarget": Indicates whether the CompositePodGroup is about to be terminated<br><p>   due to disruption such as preemption.<br><p> <br><p> Known reasons for the CompositePodGroupInitiallyScheduled condition: - "Unschedulable": The CompositePodGroup's subtree could not be placed due to resource constraints,<br><p>   affinity/anti-affinity, or topological constraints.<br><p> - "SchedulerError": The CompositePodGroup cannot be scheduled due to some internal error<br><p>   that occurred during scheduling.<br><p> - "Invalid": Set to True when kube-scheduler detects an invalid group layout during<br><p>   runtime validation. The `message` field details the specific layout violation (such as<br><p>   a detected cycle, exceeding the maximum depth of 4, or referencing multiple distinct Workloads).<br><p> <br><p> Known reasons for the DisruptionTarget condition: - "PreemptionByScheduler": The CompositePodGroup was targeted by the scheduler's preemption loop<br><p>   to free up capacity for higher-priority preemptors.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonIgnore
    public CompositePodGroupStatusBuilder edit() {
        return new CompositePodGroupStatusBuilder(this);
    }

    @JsonIgnore
    public CompositePodGroupStatusBuilder toBuilder() {
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
