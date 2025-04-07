
package io.fabric8.tekton.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
import io.fabric8.tekton.pipeline.pkg.result.RunResult;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * TaskRunStatusFields holds the fields of TaskRun's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cloudEvents",
    "completionTime",
    "podName",
    "provenance",
    "resourcesResult",
    "retriesStatus",
    "sidecars",
    "spanContext",
    "startTime",
    "steps",
    "taskResults",
    "taskSpec"
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
public class TaskRunStatusFields implements Editable<TaskRunStatusFieldsBuilder>, KubernetesResource
{

    @JsonProperty("cloudEvents")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CloudEventDelivery> cloudEvents = new ArrayList<>();
    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("podName")
    private String podName;
    @JsonProperty("provenance")
    private Provenance provenance;
    @JsonProperty("resourcesResult")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RunResult> resourcesResult = new ArrayList<>();
    @JsonProperty("retriesStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunStatus> retriesStatus = new ArrayList<>();
    @JsonProperty("sidecars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SidecarState> sidecars = new ArrayList<>();
    @JsonProperty("spanContext")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> spanContext = new LinkedHashMap<>();
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("steps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StepState> steps = new ArrayList<>();
    @JsonProperty("taskResults")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunResult> taskResults = new ArrayList<>();
    @JsonProperty("taskSpec")
    private TaskSpec taskSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TaskRunStatusFields() {
    }

    public TaskRunStatusFields(List<CloudEventDelivery> cloudEvents, String completionTime, String podName, Provenance provenance, List<RunResult> resourcesResult, List<TaskRunStatus> retriesStatus, List<SidecarState> sidecars, Map<String, String> spanContext, String startTime, List<StepState> steps, List<TaskRunResult> taskResults, TaskSpec taskSpec) {
        super();
        this.cloudEvents = cloudEvents;
        this.completionTime = completionTime;
        this.podName = podName;
        this.provenance = provenance;
        this.resourcesResult = resourcesResult;
        this.retriesStatus = retriesStatus;
        this.sidecars = sidecars;
        this.spanContext = spanContext;
        this.startTime = startTime;
        this.steps = steps;
        this.taskResults = taskResults;
        this.taskSpec = taskSpec;
    }

    /**
     * CloudEvents describe the state of each cloud event requested via a CloudEventResource.<br><p> <br><p> Deprecated: Removed in v0.44.0.
     */
    @JsonProperty("cloudEvents")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CloudEventDelivery> getCloudEvents() {
        return cloudEvents;
    }

    /**
     * CloudEvents describe the state of each cloud event requested via a CloudEventResource.<br><p> <br><p> Deprecated: Removed in v0.44.0.
     */
    @JsonProperty("cloudEvents")
    public void setCloudEvents(List<CloudEventDelivery> cloudEvents) {
        this.cloudEvents = cloudEvents;
    }

    /**
     * TaskRunStatusFields holds the fields of TaskRun's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    /**
     * TaskRunStatusFields holds the fields of TaskRun's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("completionTime")
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * PodName is the name of the pod responsible for executing this task's steps.
     */
    @JsonProperty("podName")
    public String getPodName() {
        return podName;
    }

    /**
     * PodName is the name of the pod responsible for executing this task's steps.
     */
    @JsonProperty("podName")
    public void setPodName(String podName) {
        this.podName = podName;
    }

    /**
     * TaskRunStatusFields holds the fields of TaskRun's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("provenance")
    public Provenance getProvenance() {
        return provenance;
    }

    /**
     * TaskRunStatusFields holds the fields of TaskRun's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("provenance")
    public void setProvenance(Provenance provenance) {
        this.provenance = provenance;
    }

    /**
     * Results from Resources built during the TaskRun. This is tomb-stoned along with the removal of pipelineResources Deprecated: this field is not populated and is preserved only for backwards compatibility
     */
    @JsonProperty("resourcesResult")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RunResult> getResourcesResult() {
        return resourcesResult;
    }

    /**
     * Results from Resources built during the TaskRun. This is tomb-stoned along with the removal of pipelineResources Deprecated: this field is not populated and is preserved only for backwards compatibility
     */
    @JsonProperty("resourcesResult")
    public void setResourcesResult(List<RunResult> resourcesResult) {
        this.resourcesResult = resourcesResult;
    }

    /**
     * RetriesStatus contains the history of TaskRunStatus in case of a retry in order to keep record of failures. All TaskRunStatus stored in RetriesStatus will have no date within the RetriesStatus as is redundant. See TaskRun.status (API version: tekton.dev/v1beta1)
     */
    @JsonProperty("retriesStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskRunStatus> getRetriesStatus() {
        return retriesStatus;
    }

    /**
     * RetriesStatus contains the history of TaskRunStatus in case of a retry in order to keep record of failures. All TaskRunStatus stored in RetriesStatus will have no date within the RetriesStatus as is redundant. See TaskRun.status (API version: tekton.dev/v1beta1)
     */
    @JsonProperty("retriesStatus")
    public void setRetriesStatus(List<TaskRunStatus> retriesStatus) {
        this.retriesStatus = retriesStatus;
    }

    /**
     * The list has one entry per sidecar in the manifest. Each entry is represents the imageid of the corresponding sidecar.
     */
    @JsonProperty("sidecars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SidecarState> getSidecars() {
        return sidecars;
    }

    /**
     * The list has one entry per sidecar in the manifest. Each entry is represents the imageid of the corresponding sidecar.
     */
    @JsonProperty("sidecars")
    public void setSidecars(List<SidecarState> sidecars) {
        this.sidecars = sidecars;
    }

    /**
     * SpanContext contains tracing span context fields
     */
    @JsonProperty("spanContext")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getSpanContext() {
        return spanContext;
    }

    /**
     * SpanContext contains tracing span context fields
     */
    @JsonProperty("spanContext")
    public void setSpanContext(Map<String, String> spanContext) {
        this.spanContext = spanContext;
    }

    /**
     * TaskRunStatusFields holds the fields of TaskRun's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     * TaskRunStatusFields holds the fields of TaskRun's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Steps describes the state of each build step container.
     */
    @JsonProperty("steps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StepState> getSteps() {
        return steps;
    }

    /**
     * Steps describes the state of each build step container.
     */
    @JsonProperty("steps")
    public void setSteps(List<StepState> steps) {
        this.steps = steps;
    }

    /**
     * TaskRunResults are the list of results written out by the task's containers
     */
    @JsonProperty("taskResults")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskRunResult> getTaskResults() {
        return taskResults;
    }

    /**
     * TaskRunResults are the list of results written out by the task's containers
     */
    @JsonProperty("taskResults")
    public void setTaskResults(List<TaskRunResult> taskResults) {
        this.taskResults = taskResults;
    }

    /**
     * TaskRunStatusFields holds the fields of TaskRun's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("taskSpec")
    public TaskSpec getTaskSpec() {
        return taskSpec;
    }

    /**
     * TaskRunStatusFields holds the fields of TaskRun's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("taskSpec")
    public void setTaskSpec(TaskSpec taskSpec) {
        this.taskSpec = taskSpec;
    }

    @JsonIgnore
    public TaskRunStatusFieldsBuilder edit() {
        return new TaskRunStatusFieldsBuilder(this);
    }

    @JsonIgnore
    public TaskRunStatusFieldsBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
