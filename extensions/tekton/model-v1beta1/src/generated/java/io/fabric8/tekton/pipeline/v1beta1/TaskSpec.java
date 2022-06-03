
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
    "description",
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
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class TaskSpec implements KubernetesResource
{

    @JsonProperty("description")
    private String description;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ParamSpec> params = new ArrayList<ParamSpec>();
    @JsonProperty("resources")
    private TaskResources resources;
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskResult> results = new ArrayList<TaskResult>();
    @JsonProperty("sidecars")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Sidecar> sidecars = new ArrayList<Sidecar>();
    @JsonProperty("stepTemplate")
    private io.fabric8.kubernetes.api.model.Container stepTemplate;
    @JsonProperty("steps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Step> steps = new ArrayList<Step>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.Volume> volumes = new ArrayList<io.fabric8.kubernetes.api.model.Volume>();
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WorkspaceDeclaration> workspaces = new ArrayList<WorkspaceDeclaration>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TaskSpec() {
    }

    /**
     * 
     * @param sidecars
     * @param volumes
     * @param description
     * @param resources
     * @param stepTemplate
     * @param workspaces
     * @param params
     * @param results
     * @param steps
     */
    public TaskSpec(String description, List<ParamSpec> params, TaskResources resources, List<TaskResult> results, List<Sidecar> sidecars, io.fabric8.kubernetes.api.model.Container stepTemplate, List<Step> steps, List<io.fabric8.kubernetes.api.model.Volume> volumes, List<WorkspaceDeclaration> workspaces) {
        super();
        this.description = description;
        this.params = params;
        this.resources = resources;
        this.results = results;
        this.sidecars = sidecars;
        this.stepTemplate = stepTemplate;
        this.steps = steps;
        this.volumes = volumes;
        this.workspaces = workspaces;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("params")
    public List<ParamSpec> getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(List<ParamSpec> params) {
        this.params = params;
    }

    @JsonProperty("resources")
    public TaskResources getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(TaskResources resources) {
        this.resources = resources;
    }

    @JsonProperty("results")
    public List<TaskResult> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<TaskResult> results) {
        this.results = results;
    }

    @JsonProperty("sidecars")
    public List<Sidecar> getSidecars() {
        return sidecars;
    }

    @JsonProperty("sidecars")
    public void setSidecars(List<Sidecar> sidecars) {
        this.sidecars = sidecars;
    }

    @JsonProperty("stepTemplate")
    public io.fabric8.kubernetes.api.model.Container getStepTemplate() {
        return stepTemplate;
    }

    @JsonProperty("stepTemplate")
    public void setStepTemplate(io.fabric8.kubernetes.api.model.Container stepTemplate) {
        this.stepTemplate = stepTemplate;
    }

    @JsonProperty("steps")
    public List<Step> getSteps() {
        return steps;
    }

    @JsonProperty("steps")
    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    @JsonProperty("volumes")
    public List<io.fabric8.kubernetes.api.model.Volume> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<io.fabric8.kubernetes.api.model.Volume> volumes) {
        this.volumes = volumes;
    }

    @JsonProperty("workspaces")
    public List<WorkspaceDeclaration> getWorkspaces() {
        return workspaces;
    }

    @JsonProperty("workspaces")
    public void setWorkspaces(List<WorkspaceDeclaration> workspaces) {
        this.workspaces = workspaces;
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
