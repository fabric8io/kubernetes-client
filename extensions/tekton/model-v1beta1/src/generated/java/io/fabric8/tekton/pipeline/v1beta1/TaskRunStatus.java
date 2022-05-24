
package io.fabric8.tekton.pipeline.v1beta1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.knative.internal.pkg.apis.Condition;
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
    "annotations",
    "cloudEvents",
    "completionTime",
    "conditions",
    "observedGeneration",
    "podName",
    "resourcesResult",
    "retriesStatus",
    "sidecars",
    "startTime",
    "steps",
    "taskResults",
    "taskSpec"
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
public class TaskRunStatus implements KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<String, String>();
    @JsonProperty("cloudEvents")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CloudEventDelivery> cloudEvents = new ArrayList<CloudEventDelivery>();
    @JsonProperty("completionTime")
    private java.lang.String completionTime;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("podName")
    private java.lang.String podName;
    @JsonProperty("resourcesResult")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineResourceResult> resourcesResult = new ArrayList<PipelineResourceResult>();
    @JsonProperty("retriesStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunStatus> retriesStatus = new ArrayList<TaskRunStatus>();
    @JsonProperty("sidecars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SidecarState> sidecars = new ArrayList<SidecarState>();
    @JsonProperty("startTime")
    private java.lang.String startTime;
    @JsonProperty("steps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StepState> steps = new ArrayList<StepState>();
    @JsonProperty("taskResults")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunResult> taskResults = new ArrayList<TaskRunResult>();
    @JsonProperty("taskSpec")
    private TaskSpec taskSpec;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TaskRunStatus() {
    }

    /**
     * 
     * @param sidecars
     * @param taskResults
     * @param annotations
     * @param steps
     * @param taskSpec
     * @param cloudEvents
     * @param completionTime
     * @param retriesStatus
     * @param podName
     * @param startTime
     * @param conditions
     * @param resourcesResult
     * @param observedGeneration
     */
    public TaskRunStatus(Map<String, String> annotations, List<CloudEventDelivery> cloudEvents, java.lang.String completionTime, List<Condition> conditions, Long observedGeneration, java.lang.String podName, List<PipelineResourceResult> resourcesResult, List<TaskRunStatus> retriesStatus, List<SidecarState> sidecars, java.lang.String startTime, List<StepState> steps, List<TaskRunResult> taskResults, TaskSpec taskSpec) {
        super();
        this.annotations = annotations;
        this.cloudEvents = cloudEvents;
        this.completionTime = completionTime;
        this.conditions = conditions;
        this.observedGeneration = observedGeneration;
        this.podName = podName;
        this.resourcesResult = resourcesResult;
        this.retriesStatus = retriesStatus;
        this.sidecars = sidecars;
        this.startTime = startTime;
        this.steps = steps;
        this.taskResults = taskResults;
        this.taskSpec = taskSpec;
    }

    @JsonProperty("annotations")
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("cloudEvents")
    public List<CloudEventDelivery> getCloudEvents() {
        return cloudEvents;
    }

    @JsonProperty("cloudEvents")
    public void setCloudEvents(List<CloudEventDelivery> cloudEvents) {
        this.cloudEvents = cloudEvents;
    }

    @JsonProperty("completionTime")
    public java.lang.String getCompletionTime() {
        return completionTime;
    }

    @JsonProperty("completionTime")
    public void setCompletionTime(java.lang.String completionTime) {
        this.completionTime = completionTime;
    }

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    @JsonProperty("podName")
    public java.lang.String getPodName() {
        return podName;
    }

    @JsonProperty("podName")
    public void setPodName(java.lang.String podName) {
        this.podName = podName;
    }

    @JsonProperty("resourcesResult")
    public List<PipelineResourceResult> getResourcesResult() {
        return resourcesResult;
    }

    @JsonProperty("resourcesResult")
    public void setResourcesResult(List<PipelineResourceResult> resourcesResult) {
        this.resourcesResult = resourcesResult;
    }

    @JsonProperty("retriesStatus")
    public List<TaskRunStatus> getRetriesStatus() {
        return retriesStatus;
    }

    @JsonProperty("retriesStatus")
    public void setRetriesStatus(List<TaskRunStatus> retriesStatus) {
        this.retriesStatus = retriesStatus;
    }

    @JsonProperty("sidecars")
    public List<SidecarState> getSidecars() {
        return sidecars;
    }

    @JsonProperty("sidecars")
    public void setSidecars(List<SidecarState> sidecars) {
        this.sidecars = sidecars;
    }

    @JsonProperty("startTime")
    public java.lang.String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(java.lang.String startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("steps")
    public List<StepState> getSteps() {
        return steps;
    }

    @JsonProperty("steps")
    public void setSteps(List<StepState> steps) {
        this.steps = steps;
    }

    @JsonProperty("taskResults")
    public List<TaskRunResult> getTaskResults() {
        return taskResults;
    }

    @JsonProperty("taskResults")
    public void setTaskResults(List<TaskRunResult> taskResults) {
        this.taskResults = taskResults;
    }

    @JsonProperty("taskSpec")
    public TaskSpec getTaskSpec() {
        return taskSpec;
    }

    @JsonProperty("taskSpec")
    public void setTaskSpec(TaskSpec taskSpec) {
        this.taskSpec = taskSpec;
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
