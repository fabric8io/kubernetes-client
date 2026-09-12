
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
 * Artifacts represents the collection of input and output artifacts associated with a task run or a similar process. Artifacts in this context are units of data or resources that the process either consumes as input or produces as output.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "inputs",
    "outputs"
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
public class Artifacts implements Editable<ArtifactsBuilder>, KubernetesResource
{

    @JsonProperty("inputs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Artifact> inputs = new ArrayList<>();
    @JsonProperty("outputs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Artifact> outputs = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Artifacts() {
    }

    public Artifacts(List<Artifact> inputs, List<Artifact> outputs) {
        super();
        this.inputs = inputs;
        this.outputs = outputs;
    }

    /**
     * Artifacts represents the collection of input and output artifacts associated with a task run or a similar process. Artifacts in this context are units of data or resources that the process either consumes as input or produces as output.
     */
    @JsonProperty("inputs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Artifact> getInputs() {
        return inputs;
    }

    /**
     * Artifacts represents the collection of input and output artifacts associated with a task run or a similar process. Artifacts in this context are units of data or resources that the process either consumes as input or produces as output.
     */
    @JsonProperty("inputs")
    public void setInputs(List<Artifact> inputs) {
        this.inputs = inputs;
    }

    /**
     * Artifacts represents the collection of input and output artifacts associated with a task run or a similar process. Artifacts in this context are units of data or resources that the process either consumes as input or produces as output.
     */
    @JsonProperty("outputs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Artifact> getOutputs() {
        return outputs;
    }

    /**
     * Artifacts represents the collection of input and output artifacts associated with a task run or a similar process. Artifacts in this context are units of data or resources that the process either consumes as input or produces as output.
     */
    @JsonProperty("outputs")
    public void setOutputs(List<Artifact> outputs) {
        this.outputs = outputs;
    }

    @JsonIgnore
    public ArtifactsBuilder edit() {
        return new ArtifactsBuilder(this);
    }

    @JsonIgnore
    public ArtifactsBuilder toBuilder() {
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
        if (!(o instanceof Artifacts)) {
            return false;
        }
        Artifacts other = (Artifacts) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$inputs = this.getInputs();
        Object other$inputs = other.getInputs();
        if (this$inputs == null ? other$inputs != null : !this$inputs.equals(other$inputs)) {
            return false;
        }
        Object this$outputs = this.getOutputs();
        Object other$outputs = other.getOutputs();
        if (this$outputs == null ? other$outputs != null : !this$outputs.equals(other$outputs)) {
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
        return other instanceof Artifacts;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $inputs = this.getInputs();
        result = result * prime + ($inputs == null ? 43 : $inputs.hashCode());
        Object $outputs = this.getOutputs();
        result = result * prime + ($outputs == null ? 43 : $outputs.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Artifacts(" + "inputs=" + this.getInputs() + ", outputs=" + this.getOutputs() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
