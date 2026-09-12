
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
import io.fabric8.kubernetes.api.model.Duration;
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
import io.fabric8.tekton.pod.Template;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "computeResources",
    "pipelineTaskName",
    "sidecarOverrides",
    "stepOverrides",
    "taskPodTemplate",
    "taskServiceAccountName",
    "timeout"
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
public class PipelineTaskRunSpec implements Editable<PipelineTaskRunSpecBuilder>, KubernetesResource
{

    @JsonProperty("computeResources")
    private ResourceRequirements computeResources;
    @JsonProperty("metadata")
    private PipelineTaskMetadata metadata;
    @JsonProperty("pipelineTaskName")
    private String pipelineTaskName;
    @JsonProperty("sidecarOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunSidecarOverride> sidecarOverrides = new ArrayList<>();
    @JsonProperty("stepOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunStepOverride> stepOverrides = new ArrayList<>();
    @JsonProperty("taskPodTemplate")
    private Template taskPodTemplate;
    @JsonProperty("taskServiceAccountName")
    private String taskServiceAccountName;
    @JsonProperty("timeout")
    private Duration timeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PipelineTaskRunSpec() {
    }

    public PipelineTaskRunSpec(ResourceRequirements computeResources, PipelineTaskMetadata metadata, String pipelineTaskName, List<TaskRunSidecarOverride> sidecarOverrides, List<TaskRunStepOverride> stepOverrides, Template taskPodTemplate, String taskServiceAccountName, Duration timeout) {
        super();
        this.computeResources = computeResources;
        this.metadata = metadata;
        this.pipelineTaskName = pipelineTaskName;
        this.sidecarOverrides = sidecarOverrides;
        this.stepOverrides = stepOverrides;
        this.taskPodTemplate = taskPodTemplate;
        this.taskServiceAccountName = taskServiceAccountName;
        this.timeout = timeout;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("computeResources")
    public ResourceRequirements getComputeResources() {
        return computeResources;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("computeResources")
    public void setComputeResources(ResourceRequirements computeResources) {
        this.computeResources = computeResources;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("metadata")
    public PipelineTaskMetadata getMetadata() {
        return metadata;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("metadata")
    public void setMetadata(PipelineTaskMetadata metadata) {
        this.metadata = metadata;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("pipelineTaskName")
    public String getPipelineTaskName() {
        return pipelineTaskName;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("pipelineTaskName")
    public void setPipelineTaskName(String pipelineTaskName) {
        this.pipelineTaskName = pipelineTaskName;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("sidecarOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskRunSidecarOverride> getSidecarOverrides() {
        return sidecarOverrides;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("sidecarOverrides")
    public void setSidecarOverrides(List<TaskRunSidecarOverride> sidecarOverrides) {
        this.sidecarOverrides = sidecarOverrides;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("stepOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskRunStepOverride> getStepOverrides() {
        return stepOverrides;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("stepOverrides")
    public void setStepOverrides(List<TaskRunStepOverride> stepOverrides) {
        this.stepOverrides = stepOverrides;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("taskPodTemplate")
    public Template getTaskPodTemplate() {
        return taskPodTemplate;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("taskPodTemplate")
    public void setTaskPodTemplate(Template taskPodTemplate) {
        this.taskPodTemplate = taskPodTemplate;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("taskServiceAccountName")
    public String getTaskServiceAccountName() {
        return taskServiceAccountName;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("taskServiceAccountName")
    public void setTaskServiceAccountName(String taskServiceAccountName) {
        this.taskServiceAccountName = taskServiceAccountName;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("timeout")
    public Duration getTimeout() {
        return timeout;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("timeout")
    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
    }

    @JsonIgnore
    public PipelineTaskRunSpecBuilder edit() {
        return new PipelineTaskRunSpecBuilder(this);
    }

    @JsonIgnore
    public PipelineTaskRunSpecBuilder toBuilder() {
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
        if (!(o instanceof PipelineTaskRunSpec)) {
            return false;
        }
        PipelineTaskRunSpec other = (PipelineTaskRunSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$computeResources = this.getComputeResources();
        Object other$computeResources = other.getComputeResources();
        if (this$computeResources == null ? other$computeResources != null : !this$computeResources.equals(other$computeResources)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$pipelineTaskName = this.getPipelineTaskName();
        Object other$pipelineTaskName = other.getPipelineTaskName();
        if (this$pipelineTaskName == null ? other$pipelineTaskName != null : !this$pipelineTaskName.equals(other$pipelineTaskName)) {
            return false;
        }
        Object this$sidecarOverrides = this.getSidecarOverrides();
        Object other$sidecarOverrides = other.getSidecarOverrides();
        if (this$sidecarOverrides == null ? other$sidecarOverrides != null : !this$sidecarOverrides.equals(other$sidecarOverrides)) {
            return false;
        }
        Object this$stepOverrides = this.getStepOverrides();
        Object other$stepOverrides = other.getStepOverrides();
        if (this$stepOverrides == null ? other$stepOverrides != null : !this$stepOverrides.equals(other$stepOverrides)) {
            return false;
        }
        Object this$taskPodTemplate = this.getTaskPodTemplate();
        Object other$taskPodTemplate = other.getTaskPodTemplate();
        if (this$taskPodTemplate == null ? other$taskPodTemplate != null : !this$taskPodTemplate.equals(other$taskPodTemplate)) {
            return false;
        }
        Object this$taskServiceAccountName = this.getTaskServiceAccountName();
        Object other$taskServiceAccountName = other.getTaskServiceAccountName();
        if (this$taskServiceAccountName == null ? other$taskServiceAccountName != null : !this$taskServiceAccountName.equals(other$taskServiceAccountName)) {
            return false;
        }
        Object this$timeout = this.getTimeout();
        Object other$timeout = other.getTimeout();
        if (this$timeout == null ? other$timeout != null : !this$timeout.equals(other$timeout)) {
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
        return other instanceof PipelineTaskRunSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $computeResources = this.getComputeResources();
        result = result * prime + ($computeResources == null ? 43 : $computeResources.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $pipelineTaskName = this.getPipelineTaskName();
        result = result * prime + ($pipelineTaskName == null ? 43 : $pipelineTaskName.hashCode());
        Object $sidecarOverrides = this.getSidecarOverrides();
        result = result * prime + ($sidecarOverrides == null ? 43 : $sidecarOverrides.hashCode());
        Object $stepOverrides = this.getStepOverrides();
        result = result * prime + ($stepOverrides == null ? 43 : $stepOverrides.hashCode());
        Object $taskPodTemplate = this.getTaskPodTemplate();
        result = result * prime + ($taskPodTemplate == null ? 43 : $taskPodTemplate.hashCode());
        Object $taskServiceAccountName = this.getTaskServiceAccountName();
        result = result * prime + ($taskServiceAccountName == null ? 43 : $taskServiceAccountName.hashCode());
        Object $timeout = this.getTimeout();
        result = result * prime + ($timeout == null ? 43 : $timeout.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PipelineTaskRunSpec(" + "computeResources=" + this.getComputeResources() + ", metadata=" + this.getMetadata() + ", pipelineTaskName=" + this.getPipelineTaskName() + ", sidecarOverrides=" + this.getSidecarOverrides() + ", stepOverrides=" + this.getStepOverrides() + ", taskPodTemplate=" + this.getTaskPodTemplate() + ", taskServiceAccountName=" + this.getTaskServiceAccountName() + ", timeout=" + this.getTimeout() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
