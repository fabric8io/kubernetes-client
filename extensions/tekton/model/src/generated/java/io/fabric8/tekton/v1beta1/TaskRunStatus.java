
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
import io.fabric8.knative.pkg.apis.Condition;
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
 * TaskRunStatus defines the observed state of TaskRun
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotations",
    "cloudEvents",
    "completionTime",
    "conditions",
    "observedGeneration",
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
public class TaskRunStatus implements Editable<TaskRunStatusBuilder>, KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("cloudEvents")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CloudEventDelivery> cloudEvents = new ArrayList<>();
    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("podName")
    private String podName;
    @JsonProperty("provenance")
    private Provenance provenance;
    @JsonProperty("resourcesResult")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RunResult> resourcesResult = new ArrayList<>();
    @JsonProperty("retriesStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.tekton.v1beta1.TaskRunStatus> retriesStatus = new ArrayList<>();
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
    public TaskRunStatus() {
    }

    public TaskRunStatus(Map<String, String> annotations, List<CloudEventDelivery> cloudEvents, String completionTime, List<Condition> conditions, Long observedGeneration, String podName, Provenance provenance, List<RunResult> resourcesResult, List<io.fabric8.tekton.v1beta1.TaskRunStatus> retriesStatus, List<SidecarState> sidecars, Map<String, String> spanContext, String startTime, List<StepState> steps, List<TaskRunResult> taskResults, TaskSpec taskSpec) {
        super();
        this.annotations = annotations;
        this.cloudEvents = cloudEvents;
        this.completionTime = completionTime;
        this.conditions = conditions;
        this.observedGeneration = observedGeneration;
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
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
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
     * TaskRunStatus defines the observed state of TaskRun
     */
    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    /**
     * TaskRunStatus defines the observed state of TaskRun
     */
    @JsonProperty("completionTime")
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
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
     * TaskRunStatus defines the observed state of TaskRun
     */
    @JsonProperty("provenance")
    public Provenance getProvenance() {
        return provenance;
    }

    /**
     * TaskRunStatus defines the observed state of TaskRun
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
    public List<io.fabric8.tekton.v1beta1.TaskRunStatus> getRetriesStatus() {
        return retriesStatus;
    }

    /**
     * RetriesStatus contains the history of TaskRunStatus in case of a retry in order to keep record of failures. All TaskRunStatus stored in RetriesStatus will have no date within the RetriesStatus as is redundant. See TaskRun.status (API version: tekton.dev/v1beta1)
     */
    @JsonProperty("retriesStatus")
    public void setRetriesStatus(List<io.fabric8.tekton.v1beta1.TaskRunStatus> retriesStatus) {
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
     * TaskRunStatus defines the observed state of TaskRun
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     * TaskRunStatus defines the observed state of TaskRun
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
     * TaskRunStatus defines the observed state of TaskRun
     */
    @JsonProperty("taskSpec")
    public TaskSpec getTaskSpec() {
        return taskSpec;
    }

    /**
     * TaskRunStatus defines the observed state of TaskRun
     */
    @JsonProperty("taskSpec")
    public void setTaskSpec(TaskSpec taskSpec) {
        this.taskSpec = taskSpec;
    }

    @JsonIgnore
    public TaskRunStatusBuilder edit() {
        return new TaskRunStatusBuilder(this);
    }

    @JsonIgnore
    public TaskRunStatusBuilder toBuilder() {
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
