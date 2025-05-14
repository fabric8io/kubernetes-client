
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
 * TaskBreakpoints defines the breakpoint config for a particular Task
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "beforeSteps",
    "onFailure"
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
public class TaskBreakpoints implements Editable<TaskBreakpointsBuilder>, KubernetesResource
{

    @JsonProperty("beforeSteps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> beforeSteps = new ArrayList<>();
    @JsonProperty("onFailure")
    private String onFailure;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TaskBreakpoints() {
    }

    public TaskBreakpoints(List<String> beforeSteps, String onFailure) {
        super();
        this.beforeSteps = beforeSteps;
        this.onFailure = onFailure;
    }

    /**
     * TaskBreakpoints defines the breakpoint config for a particular Task
     */
    @JsonProperty("beforeSteps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBeforeSteps() {
        return beforeSteps;
    }

    /**
     * TaskBreakpoints defines the breakpoint config for a particular Task
     */
    @JsonProperty("beforeSteps")
    public void setBeforeSteps(List<String> beforeSteps) {
        this.beforeSteps = beforeSteps;
    }

    /**
     * if enabled, pause TaskRun on failure of a step failed step will not exit
     */
    @JsonProperty("onFailure")
    public String getOnFailure() {
        return onFailure;
    }

    /**
     * if enabled, pause TaskRun on failure of a step failed step will not exit
     */
    @JsonProperty("onFailure")
    public void setOnFailure(String onFailure) {
        this.onFailure = onFailure;
    }

    @JsonIgnore
    public TaskBreakpointsBuilder edit() {
        return new TaskBreakpointsBuilder(this);
    }

    @JsonIgnore
    public TaskBreakpointsBuilder toBuilder() {
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
