
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
    "spec",
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
public class EmbeddedTask implements KubernetesResource
{

    @JsonProperty("apiVersion")
    private java.lang.String apiVersion;
    @JsonProperty("description")
    private java.lang.String description;
    @JsonProperty("kind")
    private java.lang.String kind;
    @JsonProperty("metadata")
    private PipelineTaskMetadata metadata;
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
    @JsonProperty("spec")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> spec = new LinkedHashMap<String, Object>();
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
    private Map<java.lang.String, java.lang.Object> additionalProperties = new HashMap<java.lang.String, java.lang.Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EmbeddedTask() {
    }

    /**
     * 
     * @param sidecars
     * @param metadata
     * @param kind
     * @param volumes
     * @param description
     * @param resources
     * @param stepTemplate
     * @param params
     * @param steps
     * @param spec
     * @param apiVersion
     * @param workspaces
     * @param results
     */
    public EmbeddedTask(java.lang.String apiVersion, java.lang.String description, java.lang.String kind, PipelineTaskMetadata metadata, List<ParamSpec> params, TaskResources resources, List<TaskResult> results, List<Sidecar> sidecars, Map<String, Object> spec, io.fabric8.kubernetes.api.model.Container stepTemplate, List<Step> steps, List<io.fabric8.kubernetes.api.model.Volume> volumes, List<WorkspaceDeclaration> workspaces) {
        super();
        this.apiVersion = apiVersion;
        this.description = description;
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

    @JsonProperty("apiVersion")
    public java.lang.String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(java.lang.String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("description")
    public java.lang.String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    @JsonProperty("kind")
    public java.lang.String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(java.lang.String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public PipelineTaskMetadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(PipelineTaskMetadata metadata) {
        this.metadata = metadata;
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

    @JsonProperty("spec")
    public Map<String, Object> getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(Map<String, Object> spec) {
        this.spec = spec;
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
    public Map<java.lang.String, java.lang.Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, java.lang.Object value) {
        this.additionalProperties.put(name, value);
    }

}
