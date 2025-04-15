
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "displayName",
    "matrix",
    "name",
    "onError",
    "params",
    "pipelineRef",
    "pipelineSpec",
    "resources",
    "retries",
    "runAfter",
    "taskRef",
    "taskSpec",
    "timeout",
    "when",
    "workspaces"
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
public class PipelineTask implements Editable<PipelineTaskBuilder>, KubernetesResource
{

    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("matrix")
    private Matrix matrix;
    @JsonProperty("name")
    private String name;
    @JsonProperty("onError")
    private String onError;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Param> params = new ArrayList<>();
    @JsonProperty("pipelineRef")
    private PipelineRef pipelineRef;
    @JsonProperty("pipelineSpec")
    private PipelineSpec pipelineSpec;
    @JsonProperty("resources")
    private PipelineTaskResources resources;
    @JsonProperty("retries")
    private Integer retries;
    @JsonProperty("runAfter")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> runAfter = new ArrayList<>();
    @JsonProperty("taskRef")
    private TaskRef taskRef;
    @JsonProperty("taskSpec")
    private EmbeddedTask taskSpec;
    @JsonProperty("timeout")
    private Duration timeout;
    @JsonProperty("when")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WhenExpression> when = new ArrayList<>();
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WorkspacePipelineTaskBinding> workspaces = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PipelineTask() {
    }

    public PipelineTask(String description, String displayName, Matrix matrix, String name, String onError, List<Param> params, PipelineRef pipelineRef, PipelineSpec pipelineSpec, PipelineTaskResources resources, Integer retries, List<String> runAfter, TaskRef taskRef, EmbeddedTask taskSpec, Duration timeout, List<WhenExpression> when, List<WorkspacePipelineTaskBinding> workspaces) {
        super();
        this.description = description;
        this.displayName = displayName;
        this.matrix = matrix;
        this.name = name;
        this.onError = onError;
        this.params = params;
        this.pipelineRef = pipelineRef;
        this.pipelineSpec = pipelineSpec;
        this.resources = resources;
        this.retries = retries;
        this.runAfter = runAfter;
        this.taskRef = taskRef;
        this.taskSpec = taskSpec;
        this.timeout = timeout;
        this.when = when;
        this.workspaces = workspaces;
    }

    /**
     * Description is the description of this task within the context of a Pipeline. This description may be used to populate a UI.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description is the description of this task within the context of a Pipeline. This description may be used to populate a UI.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * DisplayName is the display name of this task within the context of a Pipeline. This display name may be used to populate a UI.
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * DisplayName is the display name of this task within the context of a Pipeline. This display name may be used to populate a UI.
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("matrix")
    public Matrix getMatrix() {
        return matrix;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("matrix")
    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    /**
     * Name is the name of this task within the context of a Pipeline. Name is used as a coordinate with the `from` and `runAfter` fields to establish the execution order of tasks relative to one another.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of this task within the context of a Pipeline. Name is used as a coordinate with the `from` and `runAfter` fields to establish the execution order of tasks relative to one another.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * OnError defines the exiting behavior of a PipelineRun on error can be set to [ continue | stopAndFail ]
     */
    @JsonProperty("onError")
    public String getOnError() {
        return onError;
    }

    /**
     * OnError defines the exiting behavior of a PipelineRun on error can be set to [ continue | stopAndFail ]
     */
    @JsonProperty("onError")
    public void setOnError(String onError) {
        this.onError = onError;
    }

    /**
     * Parameters declares parameters passed to this task.
     */
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Param> getParams() {
        return params;
    }

    /**
     * Parameters declares parameters passed to this task.
     */
    @JsonProperty("params")
    public void setParams(List<Param> params) {
        this.params = params;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("pipelineRef")
    public PipelineRef getPipelineRef() {
        return pipelineRef;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("pipelineRef")
    public void setPipelineRef(PipelineRef pipelineRef) {
        this.pipelineRef = pipelineRef;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("pipelineSpec")
    public PipelineSpec getPipelineSpec() {
        return pipelineSpec;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("pipelineSpec")
    public void setPipelineSpec(PipelineSpec pipelineSpec) {
        this.pipelineSpec = pipelineSpec;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("resources")
    public PipelineTaskResources getResources() {
        return resources;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("resources")
    public void setResources(PipelineTaskResources resources) {
        this.resources = resources;
    }

    /**
     * Retries represents how many times this task should be retried in case of task failure: ConditionSucceeded set to False
     */
    @JsonProperty("retries")
    public Integer getRetries() {
        return retries;
    }

    /**
     * Retries represents how many times this task should be retried in case of task failure: ConditionSucceeded set to False
     */
    @JsonProperty("retries")
    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    /**
     * RunAfter is the list of PipelineTask names that should be executed before this Task executes. (Used to force a specific ordering in graph execution.)
     */
    @JsonProperty("runAfter")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRunAfter() {
        return runAfter;
    }

    /**
     * RunAfter is the list of PipelineTask names that should be executed before this Task executes. (Used to force a specific ordering in graph execution.)
     */
    @JsonProperty("runAfter")
    public void setRunAfter(List<String> runAfter) {
        this.runAfter = runAfter;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("taskRef")
    public TaskRef getTaskRef() {
        return taskRef;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("taskRef")
    public void setTaskRef(TaskRef taskRef) {
        this.taskRef = taskRef;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("taskSpec")
    public EmbeddedTask getTaskSpec() {
        return taskSpec;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("taskSpec")
    public void setTaskSpec(EmbeddedTask taskSpec) {
        this.taskSpec = taskSpec;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("timeout")
    public Duration getTimeout() {
        return timeout;
    }

    /**
     * PipelineTask defines a task in a Pipeline, passing inputs from both Params and from the output of previous tasks.
     */
    @JsonProperty("timeout")
    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
    }

    /**
     * WhenExpressions is a list of when expressions that need to be true for the task to run
     */
    @JsonProperty("when")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WhenExpression> getWhen() {
        return when;
    }

    /**
     * WhenExpressions is a list of when expressions that need to be true for the task to run
     */
    @JsonProperty("when")
    public void setWhen(List<WhenExpression> when) {
        this.when = when;
    }

    /**
     * Workspaces maps workspaces from the pipeline spec to the workspaces declared in the Task.
     */
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WorkspacePipelineTaskBinding> getWorkspaces() {
        return workspaces;
    }

    /**
     * Workspaces maps workspaces from the pipeline spec to the workspaces declared in the Task.
     */
    @JsonProperty("workspaces")
    public void setWorkspaces(List<WorkspacePipelineTaskBinding> workspaces) {
        this.workspaces = workspaces;
    }

    @JsonIgnore
    public PipelineTaskBuilder edit() {
        return new PipelineTaskBuilder(this);
    }

    @JsonIgnore
    public PipelineTaskBuilder toBuilder() {
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
