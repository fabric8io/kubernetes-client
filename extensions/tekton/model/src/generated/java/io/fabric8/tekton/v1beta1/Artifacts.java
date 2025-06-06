
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
 * Artifacts represents the collection of input and output artifacts associated with a task run or a similar process. Artifacts in this context are units of data or resources that the process either consumes as input or produces as output.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "inputs",
    "outputs"
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

}
