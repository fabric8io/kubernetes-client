
package io.fabric8.tekton.v1;

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
import io.fabric8.kubernetes.api.model.ContainerStateRunning;
import io.fabric8.kubernetes.api.model.ContainerStateTerminated;
import io.fabric8.kubernetes.api.model.ContainerStateWaiting;
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
 * StepState reports the results of running a step in a Task.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "container",
    "imageID",
    "inputs",
    "name",
    "outputs",
    "provenance",
    "results",
    "running",
    "terminated",
    "terminationReason",
    "waiting"
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
public class StepState implements Editable<StepStateBuilder>, KubernetesResource
{

    @JsonProperty("container")
    private String container;
    @JsonProperty("imageID")
    private String imageID;
    @JsonProperty("inputs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Artifact> inputs = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("outputs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Artifact> outputs = new ArrayList<>();
    @JsonProperty("provenance")
    private Provenance provenance;
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunResult> results = new ArrayList<>();
    @JsonProperty("running")
    private ContainerStateRunning running;
    @JsonProperty("terminated")
    private ContainerStateTerminated terminated;
    @JsonProperty("terminationReason")
    private String terminationReason;
    @JsonProperty("waiting")
    private ContainerStateWaiting waiting;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StepState() {
    }

    public StepState(String container, String imageID, List<Artifact> inputs, String name, List<Artifact> outputs, Provenance provenance, List<TaskRunResult> results, ContainerStateRunning running, ContainerStateTerminated terminated, String terminationReason, ContainerStateWaiting waiting) {
        super();
        this.container = container;
        this.imageID = imageID;
        this.inputs = inputs;
        this.name = name;
        this.outputs = outputs;
        this.provenance = provenance;
        this.results = results;
        this.running = running;
        this.terminated = terminated;
        this.terminationReason = terminationReason;
        this.waiting = waiting;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("container")
    public String getContainer() {
        return container;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("container")
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("imageID")
    public String getImageID() {
        return imageID;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("imageID")
    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("inputs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Artifact> getInputs() {
        return inputs;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("inputs")
    public void setInputs(List<Artifact> inputs) {
        this.inputs = inputs;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("outputs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Artifact> getOutputs() {
        return outputs;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("outputs")
    public void setOutputs(List<Artifact> outputs) {
        this.outputs = outputs;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("provenance")
    public Provenance getProvenance() {
        return provenance;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("provenance")
    public void setProvenance(Provenance provenance) {
        this.provenance = provenance;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskRunResult> getResults() {
        return results;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("results")
    public void setResults(List<TaskRunResult> results) {
        this.results = results;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("running")
    public ContainerStateRunning getRunning() {
        return running;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("running")
    public void setRunning(ContainerStateRunning running) {
        this.running = running;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("terminated")
    public ContainerStateTerminated getTerminated() {
        return terminated;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("terminated")
    public void setTerminated(ContainerStateTerminated terminated) {
        this.terminated = terminated;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("terminationReason")
    public String getTerminationReason() {
        return terminationReason;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("terminationReason")
    public void setTerminationReason(String terminationReason) {
        this.terminationReason = terminationReason;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("waiting")
    public ContainerStateWaiting getWaiting() {
        return waiting;
    }

    /**
     * StepState reports the results of running a step in a Task.
     */
    @JsonProperty("waiting")
    public void setWaiting(ContainerStateWaiting waiting) {
        this.waiting = waiting;
    }

    @JsonIgnore
    public StepStateBuilder edit() {
        return new StepStateBuilder(this);
    }

    @JsonIgnore
    public StepStateBuilder toBuilder() {
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
