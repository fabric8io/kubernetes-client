
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PipelineRunStatus defines the observed state of PipelineRun
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotations",
    "childReferences",
    "completionTime",
    "conditions",
    "finallyStartTime",
    "observedGeneration",
    "pipelineResults",
    "pipelineSpec",
    "provenance",
    "runs",
    "skippedTasks",
    "spanContext",
    "startTime",
    "taskRuns"
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
public class PipelineRunStatus implements Editable<PipelineRunStatusBuilder>, KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("childReferences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ChildStatusReference> childReferences = new ArrayList<>();
    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("finallyStartTime")
    private String finallyStartTime;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("pipelineResults")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineRunResult> pipelineResults = new ArrayList<>();
    @JsonProperty("pipelineSpec")
    private PipelineSpec pipelineSpec;
    @JsonProperty("provenance")
    private Provenance provenance;
    @JsonProperty("runs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, PipelineRunRunStatus> runs = new LinkedHashMap<>();
    @JsonProperty("skippedTasks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SkippedTask> skippedTasks = new ArrayList<>();
    @JsonProperty("spanContext")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> spanContext = new LinkedHashMap<>();
    @JsonProperty("startTime")
    private String startTime;
    @JsonProperty("taskRuns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, PipelineRunTaskRunStatus> taskRuns = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PipelineRunStatus() {
    }

    public PipelineRunStatus(Map<String, String> annotations, List<ChildStatusReference> childReferences, String completionTime, List<Condition> conditions, String finallyStartTime, Long observedGeneration, List<PipelineRunResult> pipelineResults, PipelineSpec pipelineSpec, Provenance provenance, Map<String, PipelineRunRunStatus> runs, List<SkippedTask> skippedTasks, Map<String, String> spanContext, String startTime, Map<String, PipelineRunTaskRunStatus> taskRuns) {
        super();
        this.annotations = annotations;
        this.childReferences = childReferences;
        this.completionTime = completionTime;
        this.conditions = conditions;
        this.finallyStartTime = finallyStartTime;
        this.observedGeneration = observedGeneration;
        this.pipelineResults = pipelineResults;
        this.pipelineSpec = pipelineSpec;
        this.provenance = provenance;
        this.runs = runs;
        this.skippedTasks = skippedTasks;
        this.spanContext = spanContext;
        this.startTime = startTime;
        this.taskRuns = taskRuns;
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
     * list of TaskRun and Run names, PipelineTask names, and API versions/kinds for children of this PipelineRun.
     */
    @JsonProperty("childReferences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ChildStatusReference> getChildReferences() {
        return childReferences;
    }

    /**
     * list of TaskRun and Run names, PipelineTask names, and API versions/kinds for children of this PipelineRun.
     */
    @JsonProperty("childReferences")
    public void setChildReferences(List<ChildStatusReference> childReferences) {
        this.childReferences = childReferences;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
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
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("finallyStartTime")
    public String getFinallyStartTime() {
        return finallyStartTime;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("finallyStartTime")
    public void setFinallyStartTime(String finallyStartTime) {
        this.finallyStartTime = finallyStartTime;
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
     * PipelineResults are the list of results written out by the pipeline task's containers
     */
    @JsonProperty("pipelineResults")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PipelineRunResult> getPipelineResults() {
        return pipelineResults;
    }

    /**
     * PipelineResults are the list of results written out by the pipeline task's containers
     */
    @JsonProperty("pipelineResults")
    public void setPipelineResults(List<PipelineRunResult> pipelineResults) {
        this.pipelineResults = pipelineResults;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("pipelineSpec")
    public PipelineSpec getPipelineSpec() {
        return pipelineSpec;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("pipelineSpec")
    public void setPipelineSpec(PipelineSpec pipelineSpec) {
        this.pipelineSpec = pipelineSpec;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("provenance")
    public Provenance getProvenance() {
        return provenance;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("provenance")
    public void setProvenance(Provenance provenance) {
        this.provenance = provenance;
    }

    /**
     * Runs is a map of PipelineRunRunStatus with the run name as the key<br><p> <br><p> Deprecated: use ChildReferences instead. As of v0.45.0, this field is no longer populated and is only included for backwards compatibility with older server versions.
     */
    @JsonProperty("runs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, PipelineRunRunStatus> getRuns() {
        return runs;
    }

    /**
     * Runs is a map of PipelineRunRunStatus with the run name as the key<br><p> <br><p> Deprecated: use ChildReferences instead. As of v0.45.0, this field is no longer populated and is only included for backwards compatibility with older server versions.
     */
    @JsonProperty("runs")
    public void setRuns(Map<String, PipelineRunRunStatus> runs) {
        this.runs = runs;
    }

    /**
     * list of tasks that were skipped due to when expressions evaluating to false
     */
    @JsonProperty("skippedTasks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SkippedTask> getSkippedTasks() {
        return skippedTasks;
    }

    /**
     * list of tasks that were skipped due to when expressions evaluating to false
     */
    @JsonProperty("skippedTasks")
    public void setSkippedTasks(List<SkippedTask> skippedTasks) {
        this.skippedTasks = skippedTasks;
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
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     * PipelineRunStatus defines the observed state of PipelineRun
     */
    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * TaskRuns is a map of PipelineRunTaskRunStatus with the taskRun name as the key.<br><p> <br><p> Deprecated: use ChildReferences instead. As of v0.45.0, this field is no longer populated and is only included for backwards compatibility with older server versions.
     */
    @JsonProperty("taskRuns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, PipelineRunTaskRunStatus> getTaskRuns() {
        return taskRuns;
    }

    /**
     * TaskRuns is a map of PipelineRunTaskRunStatus with the taskRun name as the key.<br><p> <br><p> Deprecated: use ChildReferences instead. As of v0.45.0, this field is no longer populated and is only included for backwards compatibility with older server versions.
     */
    @JsonProperty("taskRuns")
    public void setTaskRuns(Map<String, PipelineRunTaskRunStatus> taskRuns) {
        this.taskRuns = taskRuns;
    }

    @JsonIgnore
    public PipelineRunStatusBuilder edit() {
        return new PipelineRunStatusBuilder(this);
    }

    @JsonIgnore
    public PipelineRunStatusBuilder toBuilder() {
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
