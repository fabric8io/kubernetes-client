
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

/**
 * PipelineRunTaskRunStatus contains the name of the PipelineTask for this TaskRun and the TaskRun's Status
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pipelineTaskName",
    "status",
    "whenExpressions"
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
public class PipelineRunTaskRunStatus implements Editable<PipelineRunTaskRunStatusBuilder>, KubernetesResource
{

    @JsonProperty("pipelineTaskName")
    private String pipelineTaskName;
    @JsonProperty("status")
    private TaskRunStatus status;
    @JsonProperty("whenExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WhenExpression> whenExpressions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PipelineRunTaskRunStatus() {
    }

    public PipelineRunTaskRunStatus(String pipelineTaskName, TaskRunStatus status, List<WhenExpression> whenExpressions) {
        super();
        this.pipelineTaskName = pipelineTaskName;
        this.status = status;
        this.whenExpressions = whenExpressions;
    }

    /**
     * PipelineTaskName is the name of the PipelineTask.
     */
    @JsonProperty("pipelineTaskName")
    public String getPipelineTaskName() {
        return pipelineTaskName;
    }

    /**
     * PipelineTaskName is the name of the PipelineTask.
     */
    @JsonProperty("pipelineTaskName")
    public void setPipelineTaskName(String pipelineTaskName) {
        this.pipelineTaskName = pipelineTaskName;
    }

    /**
     * PipelineRunTaskRunStatus contains the name of the PipelineTask for this TaskRun and the TaskRun's Status
     */
    @JsonProperty("status")
    public TaskRunStatus getStatus() {
        return status;
    }

    /**
     * PipelineRunTaskRunStatus contains the name of the PipelineTask for this TaskRun and the TaskRun's Status
     */
    @JsonProperty("status")
    public void setStatus(TaskRunStatus status) {
        this.status = status;
    }

    /**
     * WhenExpressions is the list of checks guarding the execution of the PipelineTask
     */
    @JsonProperty("whenExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WhenExpression> getWhenExpressions() {
        return whenExpressions;
    }

    /**
     * WhenExpressions is the list of checks guarding the execution of the PipelineTask
     */
    @JsonProperty("whenExpressions")
    public void setWhenExpressions(List<WhenExpression> whenExpressions) {
        this.whenExpressions = whenExpressions;
    }

    @JsonIgnore
    public PipelineRunTaskRunStatusBuilder edit() {
        return new PipelineRunTaskRunStatusBuilder(this);
    }

    @JsonIgnore
    public PipelineRunTaskRunStatusBuilder toBuilder() {
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
        if (!(o instanceof PipelineRunTaskRunStatus)) {
            return false;
        }
        PipelineRunTaskRunStatus other = (PipelineRunTaskRunStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$pipelineTaskName = this.getPipelineTaskName();
        Object other$pipelineTaskName = other.getPipelineTaskName();
        if (this$pipelineTaskName == null ? other$pipelineTaskName != null : !this$pipelineTaskName.equals(other$pipelineTaskName)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        Object this$whenExpressions = this.getWhenExpressions();
        Object other$whenExpressions = other.getWhenExpressions();
        if (this$whenExpressions == null ? other$whenExpressions != null : !this$whenExpressions.equals(other$whenExpressions)) {
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
        return other instanceof PipelineRunTaskRunStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $pipelineTaskName = this.getPipelineTaskName();
        result = result * prime + ($pipelineTaskName == null ? 43 : $pipelineTaskName.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $whenExpressions = this.getWhenExpressions();
        result = result * prime + ($whenExpressions == null ? 43 : $whenExpressions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PipelineRunTaskRunStatus(" + "pipelineTaskName=" + this.getPipelineTaskName() + ", status=" + this.getStatus() + ", whenExpressions=" + this.getWhenExpressions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
