
package io.fabric8.tekton.pipeline.v1alpha1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "conditionChecks",
    "pipelineTaskName",
    "status"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class PipelineRunTaskRunStatus implements KubernetesResource
{

    @JsonProperty("conditionChecks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, PipelineRunConditionCheckStatus> conditionChecks = new LinkedHashMap<String, PipelineRunConditionCheckStatus>();
    @JsonProperty("pipelineTaskName")
    private java.lang.String pipelineTaskName;
    @JsonProperty("status")
    private TaskRunStatus status;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PipelineRunTaskRunStatus() {
    }

    /**
     * 
     * @param pipelineTaskName
     * @param conditionChecks
     * @param status
     */
    public PipelineRunTaskRunStatus(Map<String, PipelineRunConditionCheckStatus> conditionChecks, java.lang.String pipelineTaskName, TaskRunStatus status) {
        super();
        this.conditionChecks = conditionChecks;
        this.pipelineTaskName = pipelineTaskName;
        this.status = status;
    }

    @JsonProperty("conditionChecks")
    public Map<String, PipelineRunConditionCheckStatus> getConditionChecks() {
        return conditionChecks;
    }

    @JsonProperty("conditionChecks")
    public void setConditionChecks(Map<String, PipelineRunConditionCheckStatus> conditionChecks) {
        this.conditionChecks = conditionChecks;
    }

    @JsonProperty("pipelineTaskName")
    public java.lang.String getPipelineTaskName() {
        return pipelineTaskName;
    }

    @JsonProperty("pipelineTaskName")
    public void setPipelineTaskName(java.lang.String pipelineTaskName) {
        this.pipelineTaskName = pipelineTaskName;
    }

    @JsonProperty("status")
    public TaskRunStatus getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(TaskRunStatus status) {
        this.status = status;
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
