
package io.fabric8.tekton.v1;

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
 * TaskRunStatusFields holds the fields of TaskRun's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "artifacts",
    "completionTime",
    "podName",
    "provenance",
    "results",
    "retriesStatus",
    "sidecars",
    "spanContext",
    "startTime",
    "steps",
    "taskSpec"
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

    @JsonProperty("artifacts")
    private Artifacts artifacts;
    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("podName")
    private String podName;
    @JsonProperty("provenance")
    private Provenance provenance;
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunResult> results = new ArrayList<>();
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
    @JsonProperty("taskSpec")
    private TaskSpec taskSpec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TaskRunStatusFields() {
    }

    public TaskRunStatusFields(Artifacts artifacts, String completionTime, String podName, Provenance provenance, List<TaskRunResult> results, List<TaskRunStatus> retriesStatus, List<SidecarState> sidecars, Map<String, String> spanContext, String startTime, List<StepState> steps, TaskSpec taskSpec) {
        super();
        this.artifacts = artifacts;
        this.completionTime = completionTime;
        this.podName = podName;
        this.provenance = provenance;
        this.results = results;
        this.retriesStatus = retriesStatus;
        this.sidecars = sidecars;
        this.spanContext = spanContext;
        this.startTime = startTime;
        this.steps = steps;
        this.taskSpec = taskSpec;
    }

    /**
     * TaskRunStatusFields holds the fields of TaskRun's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("artifacts")
    public Artifacts getArtifacts() {
        return artifacts;
    }

    /**
     * TaskRunStatusFields holds the fields of TaskRun's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("artifacts")
    public void setArtifacts(Artifacts artifacts) {
        this.artifacts = artifacts;
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
     * Results are the list of results written out by the task's containers
     */
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskRunResult> getResults() {
        return results;
    }

    /**
     * Results are the list of results written out by the task's containers
     */
    @JsonProperty("results")
    public void setResults(List<TaskRunResult> results) {
        this.results = results;
    }

    /**
     * RetriesStatus contains the history of TaskRunStatus in case of a retry in order to keep record of failures. All TaskRunStatus stored in RetriesStatus will have no date within the RetriesStatus as is redundant.
     */
    @JsonProperty("retriesStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskRunStatus> getRetriesStatus() {
        return retriesStatus;
    }

    /**
     * RetriesStatus contains the history of TaskRunStatus in case of a retry in order to keep record of failures. All TaskRunStatus stored in RetriesStatus will have no date within the RetriesStatus as is redundant.
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
        if (!(o instanceof TaskRunStatusFields)) {
            return false;
        }
        TaskRunStatusFields other = (TaskRunStatusFields) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$artifacts = this.getArtifacts();
        Object other$artifacts = other.getArtifacts();
        if (this$artifacts == null ? other$artifacts != null : !this$artifacts.equals(other$artifacts)) {
            return false;
        }
        Object this$completionTime = this.getCompletionTime();
        Object other$completionTime = other.getCompletionTime();
        if (this$completionTime == null ? other$completionTime != null : !this$completionTime.equals(other$completionTime)) {
            return false;
        }
        Object this$podName = this.getPodName();
        Object other$podName = other.getPodName();
        if (this$podName == null ? other$podName != null : !this$podName.equals(other$podName)) {
            return false;
        }
        Object this$provenance = this.getProvenance();
        Object other$provenance = other.getProvenance();
        if (this$provenance == null ? other$provenance != null : !this$provenance.equals(other$provenance)) {
            return false;
        }
        Object this$results = this.getResults();
        Object other$results = other.getResults();
        if (this$results == null ? other$results != null : !this$results.equals(other$results)) {
            return false;
        }
        Object this$retriesStatus = this.getRetriesStatus();
        Object other$retriesStatus = other.getRetriesStatus();
        if (this$retriesStatus == null ? other$retriesStatus != null : !this$retriesStatus.equals(other$retriesStatus)) {
            return false;
        }
        Object this$sidecars = this.getSidecars();
        Object other$sidecars = other.getSidecars();
        if (this$sidecars == null ? other$sidecars != null : !this$sidecars.equals(other$sidecars)) {
            return false;
        }
        Object this$spanContext = this.getSpanContext();
        Object other$spanContext = other.getSpanContext();
        if (this$spanContext == null ? other$spanContext != null : !this$spanContext.equals(other$spanContext)) {
            return false;
        }
        Object this$startTime = this.getStartTime();
        Object other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) {
            return false;
        }
        Object this$steps = this.getSteps();
        Object other$steps = other.getSteps();
        if (this$steps == null ? other$steps != null : !this$steps.equals(other$steps)) {
            return false;
        }
        Object this$taskSpec = this.getTaskSpec();
        Object other$taskSpec = other.getTaskSpec();
        if (this$taskSpec == null ? other$taskSpec != null : !this$taskSpec.equals(other$taskSpec)) {
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
        return other instanceof TaskRunStatusFields;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $artifacts = this.getArtifacts();
        result = result * prime + ($artifacts == null ? 43 : $artifacts.hashCode());
        Object $completionTime = this.getCompletionTime();
        result = result * prime + ($completionTime == null ? 43 : $completionTime.hashCode());
        Object $podName = this.getPodName();
        result = result * prime + ($podName == null ? 43 : $podName.hashCode());
        Object $provenance = this.getProvenance();
        result = result * prime + ($provenance == null ? 43 : $provenance.hashCode());
        Object $results = this.getResults();
        result = result * prime + ($results == null ? 43 : $results.hashCode());
        Object $retriesStatus = this.getRetriesStatus();
        result = result * prime + ($retriesStatus == null ? 43 : $retriesStatus.hashCode());
        Object $sidecars = this.getSidecars();
        result = result * prime + ($sidecars == null ? 43 : $sidecars.hashCode());
        Object $spanContext = this.getSpanContext();
        result = result * prime + ($spanContext == null ? 43 : $spanContext.hashCode());
        Object $startTime = this.getStartTime();
        result = result * prime + ($startTime == null ? 43 : $startTime.hashCode());
        Object $steps = this.getSteps();
        result = result * prime + ($steps == null ? 43 : $steps.hashCode());
        Object $taskSpec = this.getTaskSpec();
        result = result * prime + ($taskSpec == null ? 43 : $taskSpec.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TaskRunStatusFields(" + "artifacts=" + this.getArtifacts() + ", completionTime=" + this.getCompletionTime() + ", podName=" + this.getPodName() + ", provenance=" + this.getProvenance() + ", results=" + this.getResults() + ", retriesStatus=" + this.getRetriesStatus() + ", sidecars=" + this.getSidecars() + ", spanContext=" + this.getSpanContext() + ", startTime=" + this.getStartTime() + ", steps=" + this.getSteps() + ", taskSpec=" + this.getTaskSpec() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
