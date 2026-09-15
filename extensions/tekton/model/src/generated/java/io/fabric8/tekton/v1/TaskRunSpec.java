
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

/**
 * TaskRunSpec defines the desired state of TaskRun
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "computeResources",
    "debug",
    "managedBy",
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
public class TaskRunSpec implements Editable<TaskRunSpecBuilder>, KubernetesResource
{

    @JsonProperty("computeResources")
    private ResourceRequirements computeResources;
    @JsonProperty("debug")
    private TaskRunDebug debug;
    @JsonProperty("managedBy")
    private String managedBy;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Param> params = new ArrayList<>();
    @JsonProperty("podTemplate")
    private Template podTemplate;
    @JsonProperty("retries")
    private Integer retries;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sidecarSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunSidecarSpec> sidecarSpecs = new ArrayList<>();
    @JsonProperty("status")
    private String status;
    @JsonProperty("statusMessage")
    private String statusMessage;
    @JsonProperty("stepSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunStepSpec> stepSpecs = new ArrayList<>();
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
     */
    public TaskRunSpec() {
    }

    public TaskRunSpec(ResourceRequirements computeResources, TaskRunDebug debug, String managedBy, List<Param> params, Template podTemplate, Integer retries, String serviceAccountName, List<TaskRunSidecarSpec> sidecarSpecs, String status, String statusMessage, List<TaskRunStepSpec> stepSpecs, TaskRef taskRef, TaskSpec taskSpec, Duration timeout, List<WorkspaceBinding> workspaces) {
        super();
        this.computeResources = computeResources;
        this.debug = debug;
        this.managedBy = managedBy;
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

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("computeResources")
    public ResourceRequirements getComputeResources() {
        return computeResources;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("computeResources")
    public void setComputeResources(ResourceRequirements computeResources) {
        this.computeResources = computeResources;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("debug")
    public TaskRunDebug getDebug() {
        return debug;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("debug")
    public void setDebug(TaskRunDebug debug) {
        this.debug = debug;
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
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Param> getParams() {
        return params;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("params")
    public void setParams(List<Param> params) {
        this.params = params;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("podTemplate")
    public Template getPodTemplate() {
        return podTemplate;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("podTemplate")
    public void setPodTemplate(Template podTemplate) {
        this.podTemplate = podTemplate;
    }

    /**
     * Retries represents how many times this TaskRun should be retried in the event of task failure.
     */
    @JsonProperty("retries")
    public Integer getRetries() {
        return retries;
    }

    /**
     * Retries represents how many times this TaskRun should be retried in the event of task failure.
     */
    @JsonProperty("retries")
    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * Specs to apply to Sidecars in this TaskRun. If a field is specified in both a Sidecar and a SidecarSpec, the value from the SidecarSpec will be used. This field is only supported when the alpha feature gate is enabled.
     */
    @JsonProperty("sidecarSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskRunSidecarSpec> getSidecarSpecs() {
        return sidecarSpecs;
    }

    /**
     * Specs to apply to Sidecars in this TaskRun. If a field is specified in both a Sidecar and a SidecarSpec, the value from the SidecarSpec will be used. This field is only supported when the alpha feature gate is enabled.
     */
    @JsonProperty("sidecarSpecs")
    public void setSidecarSpecs(List<TaskRunSidecarSpec> sidecarSpecs) {
        this.sidecarSpecs = sidecarSpecs;
    }

    /**
     * Used for cancelling a TaskRun (and maybe more later on)
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Used for cancelling a TaskRun (and maybe more later on)
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Status message for cancellation.
     */
    @JsonProperty("statusMessage")
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * Status message for cancellation.
     */
    @JsonProperty("statusMessage")
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    /**
     * Specs to apply to Steps in this TaskRun. If a field is specified in both a Step and a StepSpec, the value from the StepSpec will be used. This field is only supported when the alpha feature gate is enabled.
     */
    @JsonProperty("stepSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskRunStepSpec> getStepSpecs() {
        return stepSpecs;
    }

    /**
     * Specs to apply to Steps in this TaskRun. If a field is specified in both a Step and a StepSpec, the value from the StepSpec will be used. This field is only supported when the alpha feature gate is enabled.
     */
    @JsonProperty("stepSpecs")
    public void setStepSpecs(List<TaskRunStepSpec> stepSpecs) {
        this.stepSpecs = stepSpecs;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("taskRef")
    public TaskRef getTaskRef() {
        return taskRef;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("taskRef")
    public void setTaskRef(TaskRef taskRef) {
        this.taskRef = taskRef;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("taskSpec")
    public TaskSpec getTaskSpec() {
        return taskSpec;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("taskSpec")
    public void setTaskSpec(TaskSpec taskSpec) {
        this.taskSpec = taskSpec;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("timeout")
    public Duration getTimeout() {
        return timeout;
    }

    /**
     * TaskRunSpec defines the desired state of TaskRun
     */
    @JsonProperty("timeout")
    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
    }

    /**
     * Workspaces is a list of WorkspaceBindings from volumes to workspaces.
     */
    @JsonProperty("workspaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WorkspaceBinding> getWorkspaces() {
        return workspaces;
    }

    /**
     * Workspaces is a list of WorkspaceBindings from volumes to workspaces.
     */
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
        if (!(o instanceof TaskRunSpec)) {
            return false;
        }
        TaskRunSpec other = (TaskRunSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$computeResources = this.getComputeResources();
        Object other$computeResources = other.getComputeResources();
        if (this$computeResources == null ? other$computeResources != null : !this$computeResources.equals(other$computeResources)) {
            return false;
        }
        Object this$debug = this.getDebug();
        Object other$debug = other.getDebug();
        if (this$debug == null ? other$debug != null : !this$debug.equals(other$debug)) {
            return false;
        }
        Object this$managedBy = this.getManagedBy();
        Object other$managedBy = other.getManagedBy();
        if (this$managedBy == null ? other$managedBy != null : !this$managedBy.equals(other$managedBy)) {
            return false;
        }
        Object this$params = this.getParams();
        Object other$params = other.getParams();
        if (this$params == null ? other$params != null : !this$params.equals(other$params)) {
            return false;
        }
        Object this$podTemplate = this.getPodTemplate();
        Object other$podTemplate = other.getPodTemplate();
        if (this$podTemplate == null ? other$podTemplate != null : !this$podTemplate.equals(other$podTemplate)) {
            return false;
        }
        Object this$retries = this.getRetries();
        Object other$retries = other.getRetries();
        if (this$retries == null ? other$retries != null : !this$retries.equals(other$retries)) {
            return false;
        }
        Object this$serviceAccountName = this.getServiceAccountName();
        Object other$serviceAccountName = other.getServiceAccountName();
        if (this$serviceAccountName == null ? other$serviceAccountName != null : !this$serviceAccountName.equals(other$serviceAccountName)) {
            return false;
        }
        Object this$sidecarSpecs = this.getSidecarSpecs();
        Object other$sidecarSpecs = other.getSidecarSpecs();
        if (this$sidecarSpecs == null ? other$sidecarSpecs != null : !this$sidecarSpecs.equals(other$sidecarSpecs)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        Object this$statusMessage = this.getStatusMessage();
        Object other$statusMessage = other.getStatusMessage();
        if (this$statusMessage == null ? other$statusMessage != null : !this$statusMessage.equals(other$statusMessage)) {
            return false;
        }
        Object this$stepSpecs = this.getStepSpecs();
        Object other$stepSpecs = other.getStepSpecs();
        if (this$stepSpecs == null ? other$stepSpecs != null : !this$stepSpecs.equals(other$stepSpecs)) {
            return false;
        }
        Object this$taskRef = this.getTaskRef();
        Object other$taskRef = other.getTaskRef();
        if (this$taskRef == null ? other$taskRef != null : !this$taskRef.equals(other$taskRef)) {
            return false;
        }
        Object this$taskSpec = this.getTaskSpec();
        Object other$taskSpec = other.getTaskSpec();
        if (this$taskSpec == null ? other$taskSpec != null : !this$taskSpec.equals(other$taskSpec)) {
            return false;
        }
        Object this$timeout = this.getTimeout();
        Object other$timeout = other.getTimeout();
        if (this$timeout == null ? other$timeout != null : !this$timeout.equals(other$timeout)) {
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
        return other instanceof TaskRunSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $computeResources = this.getComputeResources();
        result = result * prime + ($computeResources == null ? 43 : $computeResources.hashCode());
        Object $debug = this.getDebug();
        result = result * prime + ($debug == null ? 43 : $debug.hashCode());
        Object $managedBy = this.getManagedBy();
        result = result * prime + ($managedBy == null ? 43 : $managedBy.hashCode());
        Object $params = this.getParams();
        result = result * prime + ($params == null ? 43 : $params.hashCode());
        Object $podTemplate = this.getPodTemplate();
        result = result * prime + ($podTemplate == null ? 43 : $podTemplate.hashCode());
        Object $retries = this.getRetries();
        result = result * prime + ($retries == null ? 43 : $retries.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $sidecarSpecs = this.getSidecarSpecs();
        result = result * prime + ($sidecarSpecs == null ? 43 : $sidecarSpecs.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $statusMessage = this.getStatusMessage();
        result = result * prime + ($statusMessage == null ? 43 : $statusMessage.hashCode());
        Object $stepSpecs = this.getStepSpecs();
        result = result * prime + ($stepSpecs == null ? 43 : $stepSpecs.hashCode());
        Object $taskRef = this.getTaskRef();
        result = result * prime + ($taskRef == null ? 43 : $taskRef.hashCode());
        Object $taskSpec = this.getTaskSpec();
        result = result * prime + ($taskSpec == null ? 43 : $taskSpec.hashCode());
        Object $timeout = this.getTimeout();
        result = result * prime + ($timeout == null ? 43 : $timeout.hashCode());
        Object $workspaces = this.getWorkspaces();
        result = result * prime + ($workspaces == null ? 43 : $workspaces.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TaskRunSpec(" + "computeResources=" + this.getComputeResources() + ", debug=" + this.getDebug() + ", managedBy=" + this.getManagedBy() + ", params=" + this.getParams() + ", podTemplate=" + this.getPodTemplate() + ", retries=" + this.getRetries() + ", serviceAccountName=" + this.getServiceAccountName() + ", sidecarSpecs=" + this.getSidecarSpecs() + ", status=" + this.getStatus() + ", statusMessage=" + this.getStatusMessage() + ", stepSpecs=" + this.getStepSpecs() + ", taskRef=" + this.getTaskRef() + ", taskSpec=" + this.getTaskSpec() + ", timeout=" + this.getTimeout() + ", workspaces=" + this.getWorkspaces() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
