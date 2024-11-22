
package io.fabric8.tekton.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "computeResources",
    "debug",
    "params",
    "podTemplate",
    "resources",
    "retries",
    "serviceAccountName",
    "sidecarOverrides",
    "status",
    "statusMessage",
    "stepOverrides",
    "taskRef",
    "taskSpec",
    "timeout",
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
public class TaskRunSpec implements Editable<TaskRunSpecBuilder> , KubernetesResource
{

    @JsonProperty("computeResources")
    private ResourceRequirements computeResources;
    @JsonProperty("debug")
    private TaskRunDebug debug;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Param> params = new ArrayList<>();
    @JsonProperty("podTemplate")
    private Template podTemplate;
    @JsonProperty("resources")
    private TaskRunResources resources;
    @JsonProperty("retries")
    private Integer retries;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sidecarOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunSidecarOverride> sidecarOverrides = new ArrayList<>();
    @JsonProperty("status")
    private String status;
    @JsonProperty("statusMessage")
    private String statusMessage;
    @JsonProperty("stepOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunStepOverride> stepOverrides = new ArrayList<>();
    @JsonProperty("taskRef")
    private TaskRef taskRef;
    @JsonProperty("taskSpec")
    private TaskSpec taskSpec;
    @JsonProperty("timeout")
    private Duration timeout;
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WorkspaceBinding> workspaces = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TaskRunSpec() {
    }

    public TaskRunSpec(ResourceRequirements computeResources, TaskRunDebug debug, List<Param> params, Template podTemplate, TaskRunResources resources, Integer retries, String serviceAccountName, List<TaskRunSidecarOverride> sidecarOverrides, String status, String statusMessage, List<TaskRunStepOverride> stepOverrides, TaskRef taskRef, TaskSpec taskSpec, Duration timeout, List<WorkspaceBinding> workspaces) {
        super();
        this.computeResources = computeResources;
        this.debug = debug;
        this.params = params;
        this.podTemplate = podTemplate;
        this.resources = resources;
        this.retries = retries;
        this.serviceAccountName = serviceAccountName;
        this.sidecarOverrides = sidecarOverrides;
        this.status = status;
        this.statusMessage = statusMessage;
        this.stepOverrides = stepOverrides;
        this.taskRef = taskRef;
        this.taskSpec = taskSpec;
        this.timeout = timeout;
        this.workspaces = workspaces;
    }

    @JsonProperty("computeResources")
    public ResourceRequirements getComputeResources() {
        return computeResources;
    }

    @JsonProperty("computeResources")
    public void setComputeResources(ResourceRequirements computeResources) {
        this.computeResources = computeResources;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonProperty("retries")
    public Integer getRetries() {
        return retries;
    }

    @JsonProperty("retries")
    public void setRetries(Integer retries) {
        this.retries = retries;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonProperty("statusMessage")
    public String getStatusMessage() {
        return statusMessage;
    }

    @JsonProperty("statusMessage")
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @JsonProperty("stepOverrides")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WorkspaceBinding> getWorkspaces() {
        return workspaces;
    }

    @JsonProperty("workspaces")
    public void setWorkspaces(List<WorkspaceBinding> workspaces) {
        this.workspaces = workspaces;
    }

    @JsonIgnore
    public TaskRunSpecBuilder edit() {
        return new TaskRunSpecBuilder(this);
    }

    @JsonIgnore
    public TaskRunSpecBuilder toBuilder() {
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
