
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
    "childReferences",
    "completionTime",
    "conditions",
    "observedGeneration",
    "pipelineResults",
    "pipelineSpec",
    "runs",
    "skippedTasks",
    "startTime",
    "taskRuns"
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
public class PipelineRunStatus implements KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<String, String>();
    @JsonProperty("childReferences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ChildStatusReference> childReferences = new ArrayList<ChildStatusReference>();
    @JsonProperty("completionTime")
    private java.lang.String completionTime;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("pipelineResults")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineRunResult> pipelineResults = new ArrayList<PipelineRunResult>();
    @JsonProperty("pipelineSpec")
    private PipelineSpec pipelineSpec;
    @JsonProperty("runs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, PipelineRunRunStatus> runs = new LinkedHashMap<String, PipelineRunRunStatus>();
    @JsonProperty("skippedTasks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SkippedTask> skippedTasks = new ArrayList<SkippedTask>();
    @JsonProperty("startTime")
    private java.lang.String startTime;
    @JsonProperty("taskRuns")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, PipelineRunTaskRunStatus> taskRuns = new LinkedHashMap<String, PipelineRunTaskRunStatus>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PipelineRunStatus() {
    }

    /**
     * 
     * @param completionTime
     * @param skippedTasks
     * @param taskRuns
     * @param pipelineSpec
     * @param childReferences
     * @param pipelineResults
     * @param annotations
     * @param startTime
     * @param conditions
     * @param runs
     * @param observedGeneration
     */
    public PipelineRunStatus(Map<String, String> annotations, List<ChildStatusReference> childReferences, java.lang.String completionTime, List<Condition> conditions, Long observedGeneration, List<PipelineRunResult> pipelineResults, PipelineSpec pipelineSpec, Map<String, PipelineRunRunStatus> runs, List<SkippedTask> skippedTasks, java.lang.String startTime, Map<String, PipelineRunTaskRunStatus> taskRuns) {
        super();
        this.annotations = annotations;
        this.childReferences = childReferences;
        this.completionTime = completionTime;
        this.conditions = conditions;
        this.observedGeneration = observedGeneration;
        this.pipelineResults = pipelineResults;
        this.pipelineSpec = pipelineSpec;
        this.runs = runs;
        this.skippedTasks = skippedTasks;
        this.startTime = startTime;
        this.taskRuns = taskRuns;
    }

    @JsonProperty("annotations")
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("childReferences")
    public List<ChildStatusReference> getChildReferences() {
        return childReferences;
    }

    @JsonProperty("childReferences")
    public void setChildReferences(List<ChildStatusReference> childReferences) {
        this.childReferences = childReferences;
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

    @JsonProperty("pipelineResults")
    public List<PipelineRunResult> getPipelineResults() {
        return pipelineResults;
    }

    @JsonProperty("pipelineResults")
    public void setPipelineResults(List<PipelineRunResult> pipelineResults) {
        this.pipelineResults = pipelineResults;
    }

    @JsonProperty("pipelineSpec")
    public PipelineSpec getPipelineSpec() {
        return pipelineSpec;
    }

    @JsonProperty("pipelineSpec")
    public void setPipelineSpec(PipelineSpec pipelineSpec) {
        this.pipelineSpec = pipelineSpec;
    }

    @JsonProperty("runs")
    public Map<String, PipelineRunRunStatus> getRuns() {
        return runs;
    }

    @JsonProperty("runs")
    public void setRuns(Map<String, PipelineRunRunStatus> runs) {
        this.runs = runs;
    }

    @JsonProperty("skippedTasks")
    public List<SkippedTask> getSkippedTasks() {
        return skippedTasks;
    }

    @JsonProperty("skippedTasks")
    public void setSkippedTasks(List<SkippedTask> skippedTasks) {
        this.skippedTasks = skippedTasks;
    }

    @JsonProperty("startTime")
    public java.lang.String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(java.lang.String startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("taskRuns")
    public Map<String, PipelineRunTaskRunStatus> getTaskRuns() {
        return taskRuns;
    }

    @JsonProperty("taskRuns")
    public void setTaskRuns(Map<String, PipelineRunTaskRunStatus> taskRuns) {
        this.taskRuns = taskRuns;
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
