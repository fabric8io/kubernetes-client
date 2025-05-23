
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
import io.fabric8.tekton.v1alpha1.PipelineResourceSpec;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * TaskResourceBinding points to the PipelineResource that will be used for the Task input or output called Name.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "paths",
    "resourceRef",
    "resourceSpec"
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
public class TaskResourceBinding implements Editable<TaskResourceBindingBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> paths = new ArrayList<>();
    @JsonProperty("resourceRef")
    private PipelineResourceRef resourceRef;
    @JsonProperty("resourceSpec")
    private PipelineResourceSpec resourceSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TaskResourceBinding() {
    }

    public TaskResourceBinding(String name, List<String> paths, PipelineResourceRef resourceRef, PipelineResourceSpec resourceSpec) {
        super();
        this.name = name;
        this.paths = paths;
        this.resourceRef = resourceRef;
        this.resourceSpec = resourceSpec;
    }

    /**
     * Name is the name of the PipelineResource in the Pipeline's declaration
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the PipelineResource in the Pipeline's declaration
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Paths will probably be removed in #1284, and then PipelineResourceBinding can be used instead. The optional Path field corresponds to a path on disk at which the Resource can be found (used when providing the resource via mounted volume, overriding the default logic to fetch the Resource).
     */
    @JsonProperty("paths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPaths() {
        return paths;
    }

    /**
     * Paths will probably be removed in #1284, and then PipelineResourceBinding can be used instead. The optional Path field corresponds to a path on disk at which the Resource can be found (used when providing the resource via mounted volume, overriding the default logic to fetch the Resource).
     */
    @JsonProperty("paths")
    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    /**
     * TaskResourceBinding points to the PipelineResource that will be used for the Task input or output called Name.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("resourceRef")
    public PipelineResourceRef getResourceRef() {
        return resourceRef;
    }

    /**
     * TaskResourceBinding points to the PipelineResource that will be used for the Task input or output called Name.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("resourceRef")
    public void setResourceRef(PipelineResourceRef resourceRef) {
        this.resourceRef = resourceRef;
    }

    /**
     * TaskResourceBinding points to the PipelineResource that will be used for the Task input or output called Name.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("resourceSpec")
    public PipelineResourceSpec getResourceSpec() {
        return resourceSpec;
    }

    /**
     * TaskResourceBinding points to the PipelineResource that will be used for the Task input or output called Name.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("resourceSpec")
    public void setResourceSpec(PipelineResourceSpec resourceSpec) {
        this.resourceSpec = resourceSpec;
    }

    @JsonIgnore
    public TaskResourceBindingBuilder edit() {
        return new TaskResourceBindingBuilder(this);
    }

    @JsonIgnore
    public TaskResourceBindingBuilder toBuilder() {
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
