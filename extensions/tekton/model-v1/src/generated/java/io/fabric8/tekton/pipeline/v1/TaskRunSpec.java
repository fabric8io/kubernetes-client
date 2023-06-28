
package io.fabric8.tekton.pipeline.v1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.tekton.v1.internal.pipeline.pkg.apis.pipeline.pod.Template;
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
    "computeResources",
    "debug",
    "params",
    "podTemplate",
    "retries",
    "serviceAccountName",
    "sidecarSpecs",
    "status",
    "statusMessage",
    "stepSpecs",
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class TaskRunSpec implements KubernetesResource
{

    @JsonProperty("computeResources")
    private io.fabric8.kubernetes.api.model.ResourceRequirements computeResources;
    @JsonProperty("debug")
    private TaskRunDebug debug;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Param> params = new ArrayList<Param>();
    @JsonProperty("podTemplate")
    private Template podTemplate;
    @JsonProperty("retries")
    private Integer retries;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sidecarSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunSidecarSpec> sidecarSpecs = new ArrayList<TaskRunSidecarSpec>();
    @JsonProperty("status")
    private String status;
    @JsonProperty("statusMessage")
    private String statusMessage;
    @JsonProperty("stepSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunStepSpec> stepSpecs = new ArrayList<TaskRunStepSpec>();
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
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TaskRunSpec() {
    }

    public TaskRunSpec(io.fabric8.kubernetes.api.model.ResourceRequirements computeResources, TaskRunDebug debug, List<Param> params, Template podTemplate, Integer retries, String serviceAccountName, List<TaskRunSidecarSpec> sidecarSpecs, String status, String statusMessage, List<TaskRunStepSpec> stepSpecs, TaskRef taskRef, TaskSpec taskSpec, Duration timeout, List<WorkspaceBinding> workspaces) {
        super();
        this.computeResources = computeResources;
        this.debug = debug;
        this.params = params;
        this.podTemplate = podTemplate;
        this.retries = retries;
        this.serviceAccountName = serviceAccountName;
        this.sidecarSpecs = sidecarSpecs;
        this.status = status;
        this.statusMessage = statusMessage;
        this.stepSpecs = stepSpecs;
        this.taskRef = taskRef;
        this.taskSpec = taskSpec;
        this.timeout = timeout;
        this.workspaces = workspaces;
    }

    @JsonProperty("computeResources")
    public io.fabric8.kubernetes.api.model.ResourceRequirements getComputeResources() {
        return computeResources;
    }

    @JsonProperty("computeResources")
    public void setComputeResources(io.fabric8.kubernetes.api.model.ResourceRequirements computeResources) {
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

    @JsonProperty("sidecarSpecs")
    public List<TaskRunSidecarSpec> getSidecarSpecs() {
        return sidecarSpecs;
    }

    @JsonProperty("sidecarSpecs")
    public void setSidecarSpecs(List<TaskRunSidecarSpec> sidecarSpecs) {
        this.sidecarSpecs = sidecarSpecs;
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

    @JsonProperty("stepSpecs")
    public List<TaskRunStepSpec> getStepSpecs() {
        return stepSpecs;
    }

    @JsonProperty("stepSpecs")
    public void setStepSpecs(List<TaskRunStepSpec> stepSpecs) {
        this.stepSpecs = stepSpecs;
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
