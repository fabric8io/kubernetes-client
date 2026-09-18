
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

/**
 * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "description",
    "displayName",
    "params",
    "resources",
    "results",
    "sidecars",
    "spec",
    "stepTemplate",
    "steps",
    "volumes",
    "workspaces"
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
public class EmbeddedTask implements Editable<EmbeddedTaskBuilder>, KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("metadata")
    private PipelineTaskMetadata metadata;
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
    @JsonProperty("spec")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object spec;
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
    public EmbeddedTask() {
    }

    public EmbeddedTask(String apiVersion, String description, String displayName, String kind, PipelineTaskMetadata metadata, List<ParamSpec> params, TaskResources resources, List<TaskResult> results, List<Sidecar> sidecars, Object spec, StepTemplate stepTemplate, List<Step> steps, List<Volume> volumes, List<WorkspaceDeclaration> workspaces) {
        super();
        this.apiVersion = apiVersion;
        this.description = description;
        this.displayName = displayName;
        this.kind = kind;
        this.metadata = metadata;
        this.params = params;
        this.resources = resources;
        this.results = results;
        this.sidecars = sidecars;
        this.spec = spec;
        this.stepTemplate = stepTemplate;
        this.steps = steps;
        this.volumes = volumes;
        this.workspaces = workspaces;
    }

    /**
     * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
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
     * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
     */
    @JsonProperty("metadata")
    public PipelineTaskMetadata getMetadata() {
        return metadata;
    }

    /**
     * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
     */
    @JsonProperty("metadata")
    public void setMetadata(PipelineTaskMetadata metadata) {
        this.metadata = metadata;
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
     * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
     */
    @JsonProperty("resources")
    public TaskResources getResources() {
        return resources;
    }

    /**
     * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
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
     * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
     */
    @JsonProperty("spec")
    public Object getSpec() {
        return spec;
    }

    /**
     * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
     */
    @JsonProperty("spec")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setSpec(Object spec) {
        this.spec = spec;
    }

    /**
     * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
     */
    @JsonProperty("stepTemplate")
    public StepTemplate getStepTemplate() {
        return stepTemplate;
    }

    /**
     * EmbeddedTask is used to define a Task inline within a Pipeline's PipelineTasks.
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
    public EmbeddedTaskBuilder edit() {
        return new EmbeddedTaskBuilder(this);
    }

    @JsonIgnore
    public EmbeddedTaskBuilder toBuilder() {
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
        if (!(o instanceof EmbeddedTask)) {
            return false;
        }
        EmbeddedTask other = (EmbeddedTask) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$displayName = this.getDisplayName();
        Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$params = this.getParams();
        Object other$params = other.getParams();
        if (this$params == null ? other$params != null : !this$params.equals(other$params)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$results = this.getResults();
        Object other$results = other.getResults();
        if (this$results == null ? other$results != null : !this$results.equals(other$results)) {
            return false;
        }
        Object this$sidecars = this.getSidecars();
        Object other$sidecars = other.getSidecars();
        if (this$sidecars == null ? other$sidecars != null : !this$sidecars.equals(other$sidecars)) {
            return false;
        }
        Object this$spec = this.getSpec();
        Object other$spec = other.getSpec();
        if (this$spec == null ? other$spec != null : !this$spec.equals(other$spec)) {
            return false;
        }
        Object this$stepTemplate = this.getStepTemplate();
        Object other$stepTemplate = other.getStepTemplate();
        if (this$stepTemplate == null ? other$stepTemplate != null : !this$stepTemplate.equals(other$stepTemplate)) {
            return false;
        }
        Object this$steps = this.getSteps();
        Object other$steps = other.getSteps();
        if (this$steps == null ? other$steps != null : !this$steps.equals(other$steps)) {
            return false;
        }
        Object this$volumes = this.getVolumes();
        Object other$volumes = other.getVolumes();
        if (this$volumes == null ? other$volumes != null : !this$volumes.equals(other$volumes)) {
            return false;
        }
        Object this$workspaces = this.getWorkspaces();
        Object other$workspaces = other.getWorkspaces();
        if (this$workspaces == null ? other$workspaces != null : !this$workspaces.equals(other$workspaces)) {
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
        return other instanceof EmbeddedTask;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $displayName = this.getDisplayName();
        result = result * prime + ($displayName == null ? 43 : $displayName.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $params = this.getParams();
        result = result * prime + ($params == null ? 43 : $params.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $results = this.getResults();
        result = result * prime + ($results == null ? 43 : $results.hashCode());
        Object $sidecars = this.getSidecars();
        result = result * prime + ($sidecars == null ? 43 : $sidecars.hashCode());
        Object $spec = this.getSpec();
        result = result * prime + ($spec == null ? 43 : $spec.hashCode());
        Object $stepTemplate = this.getStepTemplate();
        result = result * prime + ($stepTemplate == null ? 43 : $stepTemplate.hashCode());
        Object $steps = this.getSteps();
        result = result * prime + ($steps == null ? 43 : $steps.hashCode());
        Object $volumes = this.getVolumes();
        result = result * prime + ($volumes == null ? 43 : $volumes.hashCode());
        Object $workspaces = this.getWorkspaces();
        result = result * prime + ($workspaces == null ? 43 : $workspaces.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EmbeddedTask(" + "apiVersion=" + this.getApiVersion() + ", description=" + this.getDescription() + ", displayName=" + this.getDisplayName() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", params=" + this.getParams() + ", resources=" + this.getResources() + ", results=" + this.getResults() + ", sidecars=" + this.getSidecars() + ", spec=" + this.getSpec() + ", stepTemplate=" + this.getStepTemplate() + ", steps=" + this.getSteps() + ", volumes=" + this.getVolumes() + ", workspaces=" + this.getWorkspaces() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
