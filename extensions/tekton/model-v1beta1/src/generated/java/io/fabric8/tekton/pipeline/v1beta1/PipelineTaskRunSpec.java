
package io.fabric8.tekton.pipeline.v1beta1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import io.fabric8.tekton.v1beta1.internal.pipeline.pkg.apis.pipeline.pod.Template;
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
    "pipelineTaskName",
    "sidecarOverrides",
    "stepOverrides",
    "taskPodTemplate",
    "taskServiceAccountName"
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
public class PipelineTaskRunSpec implements KubernetesResource
{

    @JsonProperty("pipelineTaskName")
    private String pipelineTaskName;
    @JsonProperty("sidecarOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunSidecarOverride> sidecarOverrides = new ArrayList<TaskRunSidecarOverride>();
    @JsonProperty("stepOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunStepOverride> stepOverrides = new ArrayList<TaskRunStepOverride>();
    @JsonProperty("taskPodTemplate")
    private Template taskPodTemplate;
    @JsonProperty("taskServiceAccountName")
    private String taskServiceAccountName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PipelineTaskRunSpec() {
    }

    /**
     * 
     * @param taskPodTemplate
     * @param taskServiceAccountName
     * @param sidecarOverrides
     * @param pipelineTaskName
     * @param stepOverrides
     */
    public PipelineTaskRunSpec(String pipelineTaskName, List<TaskRunSidecarOverride> sidecarOverrides, List<TaskRunStepOverride> stepOverrides, Template taskPodTemplate, String taskServiceAccountName) {
        super();
        this.pipelineTaskName = pipelineTaskName;
        this.sidecarOverrides = sidecarOverrides;
        this.stepOverrides = stepOverrides;
        this.taskPodTemplate = taskPodTemplate;
        this.taskServiceAccountName = taskServiceAccountName;
    }

    @JsonProperty("pipelineTaskName")
    public String getPipelineTaskName() {
        return pipelineTaskName;
    }

    @JsonProperty("pipelineTaskName")
    public void setPipelineTaskName(String pipelineTaskName) {
        this.pipelineTaskName = pipelineTaskName;
    }

    @JsonProperty("sidecarOverrides")
    public List<TaskRunSidecarOverride> getSidecarOverrides() {
        return sidecarOverrides;
    }

    @JsonProperty("sidecarOverrides")
    public void setSidecarOverrides(List<TaskRunSidecarOverride> sidecarOverrides) {
        this.sidecarOverrides = sidecarOverrides;
    }

    @JsonProperty("stepOverrides")
    public List<TaskRunStepOverride> getStepOverrides() {
        return stepOverrides;
    }

    @JsonProperty("stepOverrides")
    public void setStepOverrides(List<TaskRunStepOverride> stepOverrides) {
        this.stepOverrides = stepOverrides;
    }

    @JsonProperty("taskPodTemplate")
    public Template getTaskPodTemplate() {
        return taskPodTemplate;
    }

    @JsonProperty("taskPodTemplate")
    public void setTaskPodTemplate(Template taskPodTemplate) {
        this.taskPodTemplate = taskPodTemplate;
    }

    @JsonProperty("taskServiceAccountName")
    public String getTaskServiceAccountName() {
        return taskServiceAccountName;
    }

    @JsonProperty("taskServiceAccountName")
    public void setTaskServiceAccountName(String taskServiceAccountName) {
        this.taskServiceAccountName = taskServiceAccountName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
