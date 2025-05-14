
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
import io.fabric8.tekton.pod.Template;
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
    "params",
    "pipelineRef",
    "pipelineSpec",
    "podTemplate",
    "resources",
    "serviceAccountName",
    "status",
    "taskRunSpecs",
    "timeout",
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

    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Param> params = new ArrayList<>();
    @JsonProperty("pipelineRef")
    private PipelineRef pipelineRef;
    @JsonProperty("pipelineSpec")
    private PipelineSpec pipelineSpec;
    @JsonProperty("podTemplate")
    private Template podTemplate;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineResourceBinding> resources = new ArrayList<>();
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("status")
    private String status;
    @JsonProperty("taskRunSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineTaskRunSpec> taskRunSpecs = new ArrayList<>();
    @JsonProperty("timeout")
    private Duration timeout;
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

    public PipelineRunSpec(List<Param> params, PipelineRef pipelineRef, PipelineSpec pipelineSpec, Template podTemplate, List<PipelineResourceBinding> resources, String serviceAccountName, String status, List<PipelineTaskRunSpec> taskRunSpecs, Duration timeout, TimeoutFields timeouts, List<WorkspaceBinding> workspaces) {
        super();
        this.params = params;
        this.pipelineRef = pipelineRef;
        this.pipelineSpec = pipelineSpec;
        this.podTemplate = podTemplate;
        this.resources = resources;
        this.serviceAccountName = serviceAccountName;
        this.status = status;
        this.taskRunSpecs = taskRunSpecs;
        this.timeout = timeout;
        this.timeouts = timeouts;
        this.workspaces = workspaces;
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
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("podTemplate")
    public Template getPodTemplate() {
        return podTemplate;
    }

    /**
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("podTemplate")
    public void setPodTemplate(Template podTemplate) {
        this.podTemplate = podTemplate;
    }

    /**
     * Resources is a list of bindings specifying which actual instances of PipelineResources to use for the resources the Pipeline has declared it needs.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PipelineResourceBinding> getResources() {
        return resources;
    }

    /**
     * Resources is a list of bindings specifying which actual instances of PipelineResources to use for the resources the Pipeline has declared it needs.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("resources")
    public void setResources(List<PipelineResourceBinding> resources) {
        this.resources = resources;
    }

    /**
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
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
    @JsonProperty("timeout")
    public Duration getTimeout() {
        return timeout;
    }

    /**
     * PipelineRunSpec defines the desired state of PipelineRun
     */
    @JsonProperty("timeout")
    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
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
