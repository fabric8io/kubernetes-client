
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
    "description",
    "finally",
    "params",
    "resources",
    "results",
    "tasks",
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
public class PipelineSpec implements KubernetesResource
{

    @JsonProperty("description")
    private String description;
    @JsonProperty("finally")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineTask> _finally = new ArrayList<PipelineTask>();
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ParamSpec> params = new ArrayList<ParamSpec>();
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineDeclaredResource> resources = new ArrayList<PipelineDeclaredResource>();
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineResult> results = new ArrayList<PipelineResult>();
    @JsonProperty("tasks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineTask> tasks = new ArrayList<PipelineTask>();
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineWorkspaceDeclaration> workspaces = new ArrayList<PipelineWorkspaceDeclaration>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PipelineSpec() {
    }

    /**
     * 
     * @param _finally
     * @param description
     * @param resources
     * @param workspaces
     * @param params
     * @param results
     * @param tasks
     */
    public PipelineSpec(String description, List<PipelineTask> _finally, List<ParamSpec> params, List<PipelineDeclaredResource> resources, List<PipelineResult> results, List<PipelineTask> tasks, List<PipelineWorkspaceDeclaration> workspaces) {
        super();
        this.description = description;
        this._finally = _finally;
        this.params = params;
        this.resources = resources;
        this.results = results;
        this.tasks = tasks;
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

    @JsonProperty("finally")
    public List<PipelineTask> getFinally() {
        return _finally;
    }

    @JsonProperty("finally")
    public void setFinally(List<PipelineTask> _finally) {
        this._finally = _finally;
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
    public List<PipelineDeclaredResource> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<PipelineDeclaredResource> resources) {
        this.resources = resources;
    }

    @JsonProperty("results")
    public List<PipelineResult> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<PipelineResult> results) {
        this.results = results;
    }

    @JsonProperty("tasks")
    public List<PipelineTask> getTasks() {
        return tasks;
    }

    @JsonProperty("tasks")
    public void setTasks(List<PipelineTask> tasks) {
        this.tasks = tasks;
    }

    @JsonProperty("workspaces")
    public List<PipelineWorkspaceDeclaration> getWorkspaces() {
        return workspaces;
    }

    @JsonProperty("workspaces")
    public void setWorkspaces(List<PipelineWorkspaceDeclaration> workspaces) {
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
