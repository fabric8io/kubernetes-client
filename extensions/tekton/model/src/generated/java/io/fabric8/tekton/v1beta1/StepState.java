
package io.fabric8.tekton.v1beta1;

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
    "waiting"
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
    @JsonProperty("waiting")
    private ContainerStateWaiting waiting;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StepState() {
    }

    public StepState(String container, String imageID, List<Artifact> inputs, String name, List<Artifact> outputs, Provenance provenance, List<TaskRunResult> results, ContainerStateRunning running, ContainerStateTerminated terminated, ContainerStateWaiting waiting) {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof StepState)) {
            return false;
        }
        StepState other = (StepState) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$container = this.getContainer();
        Object other$container = other.getContainer();
        if (this$container == null ? other$container != null : !this$container.equals(other$container)) {
            return false;
        }
        Object this$imageID = this.getImageID();
        Object other$imageID = other.getImageID();
        if (this$imageID == null ? other$imageID != null : !this$imageID.equals(other$imageID)) {
            return false;
        }
        Object this$inputs = this.getInputs();
        Object other$inputs = other.getInputs();
        if (this$inputs == null ? other$inputs != null : !this$inputs.equals(other$inputs)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$outputs = this.getOutputs();
        Object other$outputs = other.getOutputs();
        if (this$outputs == null ? other$outputs != null : !this$outputs.equals(other$outputs)) {
            return false;
        }
        Object this$provenance = this.getProvenance();
        Object other$provenance = other.getProvenance();
        if (this$provenance == null ? other$provenance != null : !this$provenance.equals(other$provenance)) {
            return false;
        }
        Object this$results = this.getResults();
        Object other$results = other.getResults();
        if (this$results == null ? other$results != null : !this$results.equals(other$results)) {
            return false;
        }
        Object this$running = this.getRunning();
        Object other$running = other.getRunning();
        if (this$running == null ? other$running != null : !this$running.equals(other$running)) {
            return false;
        }
        Object this$terminated = this.getTerminated();
        Object other$terminated = other.getTerminated();
        if (this$terminated == null ? other$terminated != null : !this$terminated.equals(other$terminated)) {
            return false;
        }
        Object this$waiting = this.getWaiting();
        Object other$waiting = other.getWaiting();
        if (this$waiting == null ? other$waiting != null : !this$waiting.equals(other$waiting)) {
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
        return other instanceof StepState;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $container = this.getContainer();
        result = result * prime + ($container == null ? 43 : $container.hashCode());
        Object $imageID = this.getImageID();
        result = result * prime + ($imageID == null ? 43 : $imageID.hashCode());
        Object $inputs = this.getInputs();
        result = result * prime + ($inputs == null ? 43 : $inputs.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $outputs = this.getOutputs();
        result = result * prime + ($outputs == null ? 43 : $outputs.hashCode());
        Object $provenance = this.getProvenance();
        result = result * prime + ($provenance == null ? 43 : $provenance.hashCode());
        Object $results = this.getResults();
        result = result * prime + ($results == null ? 43 : $results.hashCode());
        Object $running = this.getRunning();
        result = result * prime + ($running == null ? 43 : $running.hashCode());
        Object $terminated = this.getTerminated();
        result = result * prime + ($terminated == null ? 43 : $terminated.hashCode());
        Object $waiting = this.getWaiting();
        result = result * prime + ($waiting == null ? 43 : $waiting.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StepState(" + "container=" + this.getContainer() + ", imageID=" + this.getImageID() + ", inputs=" + this.getInputs() + ", name=" + this.getName() + ", outputs=" + this.getOutputs() + ", provenance=" + this.getProvenance() + ", results=" + this.getResults() + ", running=" + this.getRunning() + ", terminated=" + this.getTerminated() + ", waiting=" + this.getWaiting() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
