
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * TaskSpec defines the desired state of Task.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "displayName",
    "params",
    "resources",
    "results",
    "sidecars",
    "stepTemplate",
    "steps",
    "volumes",
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
public class TaskSpec implements Editable<TaskSpecBuilder>, KubernetesResource
{

    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ParamSpec> params = new ArrayList<>();
    @JsonProperty("resources")
    private TaskResources resources;
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskResult> results = new ArrayList<>();
    @JsonProperty("sidecars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Sidecar> sidecars = new ArrayList<>();
    @JsonProperty("stepTemplate")
    private StepTemplate stepTemplate;
    @JsonProperty("steps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Step> steps = new ArrayList<>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Volume> volumes = new ArrayList<>();
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WorkspaceDeclaration> workspaces = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TaskSpec() {
    }

    public TaskSpec(String description, String displayName, List<ParamSpec> params, TaskResources resources, List<TaskResult> results, List<Sidecar> sidecars, StepTemplate stepTemplate, List<Step> steps, List<Volume> volumes, List<WorkspaceDeclaration> workspaces) {
        super();
        this.description = description;
        this.displayName = displayName;
        this.params = params;
        this.resources = resources;
        this.results = results;
        this.sidecars = sidecars;
        this.stepTemplate = stepTemplate;
        this.steps = steps;
        this.volumes = volumes;
        this.workspaces = workspaces;
    }

    /**
     * Description is a user-facing description of the task that may be used to populate a UI.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description is a user-facing description of the task that may be used to populate a UI.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * DisplayName is a user-facing name of the task that may be used to populate a UI.
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * DisplayName is a user-facing name of the task that may be used to populate a UI.
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Params is a list of input parameters required to run the task. Params must be supplied as inputs in TaskRuns unless they declare a default value.
     */
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ParamSpec> getParams() {
        return params;
    }

    /**
     * Params is a list of input parameters required to run the task. Params must be supplied as inputs in TaskRuns unless they declare a default value.
     */
    @JsonProperty("params")
    public void setParams(List<ParamSpec> params) {
        this.params = params;
    }

    /**
     * TaskSpec defines the desired state of Task.
     */
    @JsonProperty("resources")
    public TaskResources getResources() {
        return resources;
    }

    /**
     * TaskSpec defines the desired state of Task.
     */
    @JsonProperty("resources")
    public void setResources(TaskResources resources) {
        this.resources = resources;
    }

    /**
     * Results are values that this Task can output
     */
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskResult> getResults() {
        return results;
    }

    /**
     * Results are values that this Task can output
     */
    @JsonProperty("results")
    public void setResults(List<TaskResult> results) {
        this.results = results;
    }

    /**
     * Sidecars are run alongside the Task's step containers. They begin before the steps start and end after the steps complete.
     */
    @JsonProperty("sidecars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Sidecar> getSidecars() {
        return sidecars;
    }

    /**
     * Sidecars are run alongside the Task's step containers. They begin before the steps start and end after the steps complete.
     */
    @JsonProperty("sidecars")
    public void setSidecars(List<Sidecar> sidecars) {
        this.sidecars = sidecars;
    }

    /**
     * TaskSpec defines the desired state of Task.
     */
    @JsonProperty("stepTemplate")
    public StepTemplate getStepTemplate() {
        return stepTemplate;
    }

    /**
     * TaskSpec defines the desired state of Task.
     */
    @JsonProperty("stepTemplate")
    public void setStepTemplate(StepTemplate stepTemplate) {
        this.stepTemplate = stepTemplate;
    }

    /**
     * Steps are the steps of the build; each step is run sequentially with the source mounted into /workspace.
     */
    @JsonProperty("steps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Step> getSteps() {
        return steps;
    }

    /**
     * Steps are the steps of the build; each step is run sequentially with the source mounted into /workspace.
     */
    @JsonProperty("steps")
    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    /**
     * Volumes is a collection of volumes that are available to mount into the steps of the build. See Pod.spec.volumes (API version: v1)
     */
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Volume> getVolumes() {
        return volumes;
    }

    /**
     * Volumes is a collection of volumes that are available to mount into the steps of the build. See Pod.spec.volumes (API version: v1)
     */
    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    /**
     * Workspaces are the volumes that this Task requires.
     */
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WorkspaceDeclaration> getWorkspaces() {
        return workspaces;
    }

    /**
     * Workspaces are the volumes that this Task requires.
     */
    @JsonProperty("workspaces")
    public void setWorkspaces(List<WorkspaceDeclaration> workspaces) {
        this.workspaces = workspaces;
    }

    @JsonIgnore
    public TaskSpecBuilder edit() {
        return new TaskSpecBuilder(this);
    }

    @JsonIgnore
    public TaskSpecBuilder toBuilder() {
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
