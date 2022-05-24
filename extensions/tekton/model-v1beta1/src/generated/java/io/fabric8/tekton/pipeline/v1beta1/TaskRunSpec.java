
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
import io.fabric8.tekton.v1beta1.internal.pipeline.pkg.apis.pipeline.pod.Template;
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
    "debug",
    "params",
    "podTemplate",
    "resources",
    "serviceAccountName",
    "sidecarOverrides",
    "status",
    "stepOverrides",
    "taskRef",
    "taskSpec",
    "timeout",
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
public class TaskRunSpec implements KubernetesResource
{

    @JsonProperty("debug")
    private TaskRunDebug debug;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Param> params = new ArrayList<Param>();
    @JsonProperty("podTemplate")
    private Template podTemplate;
    @JsonProperty("resources")
    private TaskRunResources resources;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sidecarOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunSidecarOverride> sidecarOverrides = new ArrayList<TaskRunSidecarOverride>();
    @JsonProperty("status")
    private String status;
    @JsonProperty("stepOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunStepOverride> stepOverrides = new ArrayList<TaskRunStepOverride>();
    @JsonProperty("taskRef")
    private TaskRef taskRef;
    @JsonProperty("taskSpec")
    private TaskSpec taskSpec;
    @JsonProperty("timeout")
    private Duration timeout;
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WorkspaceBinding> workspaces = new ArrayList<WorkspaceBinding>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TaskRunSpec() {
    }

    /**
     * 
     * @param taskRef
     * @param debug
     * @param serviceAccountName
     * @param podTemplate
     * @param resources
     * @param workspaces
     * @param params
     * @param sidecarOverrides
     * @param taskSpec
     * @param stepOverrides
     * @param timeout
     * @param status
     */
    public TaskRunSpec(TaskRunDebug debug, List<Param> params, Template podTemplate, TaskRunResources resources, String serviceAccountName, List<TaskRunSidecarOverride> sidecarOverrides, String status, List<TaskRunStepOverride> stepOverrides, TaskRef taskRef, TaskSpec taskSpec, Duration timeout, List<WorkspaceBinding> workspaces) {
        super();
        this.debug = debug;
        this.params = params;
        this.podTemplate = podTemplate;
        this.resources = resources;
        this.serviceAccountName = serviceAccountName;
        this.sidecarOverrides = sidecarOverrides;
        this.status = status;
        this.stepOverrides = stepOverrides;
        this.taskRef = taskRef;
        this.taskSpec = taskSpec;
        this.timeout = timeout;
        this.workspaces = workspaces;
    }

    @JsonProperty("debug")
    public TaskRunDebug getDebug() {
        return debug;
    }

    @JsonProperty("debug")
    public void setDebug(TaskRunDebug debug) {
        this.debug = debug;
    }

    @JsonProperty("params")
    public List<Param> getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(List<Param> params) {
        this.params = params;
    }

    @JsonProperty("podTemplate")
    public Template getPodTemplate() {
        return podTemplate;
    }

    @JsonProperty("podTemplate")
    public void setPodTemplate(Template podTemplate) {
        this.podTemplate = podTemplate;
    }

    @JsonProperty("resources")
    public TaskRunResources getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(TaskRunResources resources) {
        this.resources = resources;
    }

    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("sidecarOverrides")
    public List<TaskRunSidecarOverride> getSidecarOverrides() {
        return sidecarOverrides;
    }

    @JsonProperty("sidecarOverrides")
    public void setSidecarOverrides(List<TaskRunSidecarOverride> sidecarOverrides) {
        this.sidecarOverrides = sidecarOverrides;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("stepOverrides")
    public List<TaskRunStepOverride> getStepOverrides() {
        return stepOverrides;
    }

    @JsonProperty("stepOverrides")
    public void setStepOverrides(List<TaskRunStepOverride> stepOverrides) {
        this.stepOverrides = stepOverrides;
    }

    @JsonProperty("taskRef")
    public TaskRef getTaskRef() {
        return taskRef;
    }

    @JsonProperty("taskRef")
    public void setTaskRef(TaskRef taskRef) {
        this.taskRef = taskRef;
    }

    @JsonProperty("taskSpec")
    public TaskSpec getTaskSpec() {
        return taskSpec;
    }

    @JsonProperty("taskSpec")
    public void setTaskSpec(TaskSpec taskSpec) {
        this.taskSpec = taskSpec;
    }

    @JsonProperty("timeout")
    public Duration getTimeout() {
        return timeout;
    }

    @JsonProperty("timeout")
    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
    }

    @JsonProperty("workspaces")
    public List<WorkspaceBinding> getWorkspaces() {
        return workspaces;
    }

    @JsonProperty("workspaces")
    public void setWorkspaces(List<WorkspaceBinding> workspaces) {
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
