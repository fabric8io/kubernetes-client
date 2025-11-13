
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PipelineRunSpec defines the desired state of PipelineRun
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "managedBy",
    "params",
    "pipelineRef",
    "pipelineSpec",
    "status",
    "taskRunSpecs",
    "taskRunTemplate",
    "timeouts",
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
public class PipelineRunSpec implements Editable<PipelineRunSpecBuilder>, KubernetesResource
{

    @JsonProperty("managedBy")
    private String managedBy;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Param> params = new ArrayList<>();
    @JsonProperty("pipelineRef")
    private PipelineRef pipelineRef;
    @JsonProperty("pipelineSpec")
    private PipelineSpec pipelineSpec;
    @JsonProperty("status")
    private String status;
    @JsonProperty("taskRunSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineTaskRunSpec> taskRunSpecs = new ArrayList<>();
    @JsonProperty("taskRunTemplate")
    private PipelineTaskRunTemplate taskRunTemplate;
    @JsonProperty("timeouts")
    private TimeoutFields timeouts;
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WorkspaceBinding> workspaces = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PipelineRunSpec() {
    }

    public PipelineRunSpec(String managedBy, List<Param> params, PipelineRef pipelineRef, PipelineSpec pipelineSpec, String status, List<PipelineTaskRunSpec> taskRunSpecs, PipelineTaskRunTemplate taskRunTemplate, TimeoutFields timeouts, List<WorkspaceBinding> workspaces) {
        super();
        this.managedBy = managedBy;
        this.params = params;
        this.pipelineRef = pipelineRef;
        this.pipelineSpec = pipelineSpec;
        this.status = status;
        this.taskRunSpecs = taskRunSpecs;
        this.taskRunTemplate = taskRunTemplate;
        this.timeouts = timeouts;
        this.workspaces = workspaces;
    }

    /**
     * ManagedBy indicates which controller is responsible for reconciling this resource. If unset or set to "tekton.dev/pipeline", the default Tekton controller will manage this resource. This field is immutable.
     */
    @JsonProperty("managedBy")
    public String getManagedBy() {
        return managedBy;
    }

    /**
     * ManagedBy indicates which controller is responsible for reconciling this resource. If unset or set to "tekton.dev/pipeline", the default Tekton controller will manage this resource. This field is immutable.
     */
    @JsonProperty("managedBy")
    public void setManagedBy(String managedBy) {
        this.managedBy = managedBy;
    }

    /**
     * Params is a list of parameter names and values.
     */
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Param> getParams() {
        return params;
    }

    /**
     * Params is a list of parameter names and values.
     */
    @JsonProperty("params")
    public void setParams(List<Param> params) {
        this.params = params;
    }

    /**
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("pipelineRef")
    public PipelineRef getPipelineRef() {
        return pipelineRef;
    }

    /**
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("pipelineRef")
    public void setPipelineRef(PipelineRef pipelineRef) {
        this.pipelineRef = pipelineRef;
    }

    /**
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("pipelineSpec")
    public PipelineSpec getPipelineSpec() {
        return pipelineSpec;
    }

    /**
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("pipelineSpec")
    public void setPipelineSpec(PipelineSpec pipelineSpec) {
        this.pipelineSpec = pipelineSpec;
    }

    /**
     * Used for cancelling a pipelinerun (and maybe more later on)
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Used for cancelling a pipelinerun (and maybe more later on)
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * TaskRunSpecs holds a set of runtime specs
     */
    @JsonProperty("taskRunSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PipelineTaskRunSpec> getTaskRunSpecs() {
        return taskRunSpecs;
    }

    /**
     * TaskRunSpecs holds a set of runtime specs
     */
    @JsonProperty("taskRunSpecs")
    public void setTaskRunSpecs(List<PipelineTaskRunSpec> taskRunSpecs) {
        this.taskRunSpecs = taskRunSpecs;
    }

    /**
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("taskRunTemplate")
    public PipelineTaskRunTemplate getTaskRunTemplate() {
        return taskRunTemplate;
    }

    /**
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("taskRunTemplate")
    public void setTaskRunTemplate(PipelineTaskRunTemplate taskRunTemplate) {
        this.taskRunTemplate = taskRunTemplate;
    }

    /**
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("timeouts")
    public TimeoutFields getTimeouts() {
        return timeouts;
    }

    /**
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("timeouts")
    public void setTimeouts(TimeoutFields timeouts) {
        this.timeouts = timeouts;
    }

    /**
     * Workspaces holds a set of workspace bindings that must match names with those declared in the pipeline.
     */
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WorkspaceBinding> getWorkspaces() {
        return workspaces;
    }

    /**
     * Workspaces holds a set of workspace bindings that must match names with those declared in the pipeline.
     */
    @JsonProperty("workspaces")
    public void setWorkspaces(List<WorkspaceBinding> workspaces) {
        this.workspaces = workspaces;
    }

    @JsonIgnore
    public PipelineRunSpecBuilder edit() {
        return new PipelineRunSpecBuilder(this);
    }

    @JsonIgnore
    public PipelineRunSpecBuilder toBuilder() {
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
