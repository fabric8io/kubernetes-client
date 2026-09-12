
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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * CustomRunSpec defines the desired state of CustomRun
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customRef",
    "customSpec",
    "params",
    "retries",
    "serviceAccountName",
    "status",
    "statusMessage",
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
public class CustomRunSpec implements Editable<CustomRunSpecBuilder>, KubernetesResource
{

    @JsonProperty("customRef")
    private TaskRef customRef;
    @JsonProperty("customSpec")
    private EmbeddedCustomRunSpec customSpec;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Param> params = new ArrayList<>();
    @JsonProperty("retries")
    private Integer retries;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("status")
    private String status;
    @JsonProperty("statusMessage")
    private String statusMessage;
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
    public CustomRunSpec() {
    }

    public CustomRunSpec(TaskRef customRef, EmbeddedCustomRunSpec customSpec, List<Param> params, Integer retries, String serviceAccountName, String status, String statusMessage, Duration timeout, List<WorkspaceBinding> workspaces) {
        super();
        this.customRef = customRef;
        this.customSpec = customSpec;
        this.params = params;
        this.retries = retries;
        this.serviceAccountName = serviceAccountName;
        this.status = status;
        this.statusMessage = statusMessage;
        this.timeout = timeout;
        this.workspaces = workspaces;
    }

    /**
     * CustomRunSpec defines the desired state of CustomRun
     */
    @JsonProperty("customRef")
    public TaskRef getCustomRef() {
        return customRef;
    }

    /**
     * CustomRunSpec defines the desired state of CustomRun
     */
    @JsonProperty("customRef")
    public void setCustomRef(TaskRef customRef) {
        this.customRef = customRef;
    }

    /**
     * CustomRunSpec defines the desired state of CustomRun
     */
    @JsonProperty("customSpec")
    public EmbeddedCustomRunSpec getCustomSpec() {
        return customSpec;
    }

    /**
     * CustomRunSpec defines the desired state of CustomRun
     */
    @JsonProperty("customSpec")
    public void setCustomSpec(EmbeddedCustomRunSpec customSpec) {
        this.customSpec = customSpec;
    }

    /**
     * CustomRunSpec defines the desired state of CustomRun
     */
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Param> getParams() {
        return params;
    }

    /**
     * CustomRunSpec defines the desired state of CustomRun
     */
    @JsonProperty("params")
    public void setParams(List<Param> params) {
        this.params = params;
    }

    /**
     * Used for propagating retries count to custom tasks
     */
    @JsonProperty("retries")
    public Integer getRetries() {
        return retries;
    }

    /**
     * Used for propagating retries count to custom tasks
     */
    @JsonProperty("retries")
    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    /**
     * CustomRunSpec defines the desired state of CustomRun
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * CustomRunSpec defines the desired state of CustomRun
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * Used for cancelling a customrun (and maybe more later on)
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Used for cancelling a customrun (and maybe more later on)
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
     * CustomRunSpec defines the desired state of CustomRun
     */
    @JsonProperty("timeout")
    public Duration getTimeout() {
        return timeout;
    }

    /**
     * CustomRunSpec defines the desired state of CustomRun
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
    public CustomRunSpecBuilder edit() {
        return new CustomRunSpecBuilder(this);
    }

    @JsonIgnore
    public CustomRunSpecBuilder toBuilder() {
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
        if (!(o instanceof CustomRunSpec)) {
            return false;
        }
        CustomRunSpec other = (CustomRunSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$customRef = this.getCustomRef();
        Object other$customRef = other.getCustomRef();
        if (this$customRef == null ? other$customRef != null : !this$customRef.equals(other$customRef)) {
            return false;
        }
        Object this$customSpec = this.getCustomSpec();
        Object other$customSpec = other.getCustomSpec();
        if (this$customSpec == null ? other$customSpec != null : !this$customSpec.equals(other$customSpec)) {
            return false;
        }
        Object this$params = this.getParams();
        Object other$params = other.getParams();
        if (this$params == null ? other$params != null : !this$params.equals(other$params)) {
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
        return other instanceof CustomRunSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $customRef = this.getCustomRef();
        result = result * prime + ($customRef == null ? 43 : $customRef.hashCode());
        Object $customSpec = this.getCustomSpec();
        result = result * prime + ($customSpec == null ? 43 : $customSpec.hashCode());
        Object $params = this.getParams();
        result = result * prime + ($params == null ? 43 : $params.hashCode());
        Object $retries = this.getRetries();
        result = result * prime + ($retries == null ? 43 : $retries.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $statusMessage = this.getStatusMessage();
        result = result * prime + ($statusMessage == null ? 43 : $statusMessage.hashCode());
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
        return "CustomRunSpec(" + "customRef=" + this.getCustomRef() + ", customSpec=" + this.getCustomSpec() + ", params=" + this.getParams() + ", retries=" + this.getRetries() + ", serviceAccountName=" + this.getServiceAccountName() + ", status=" + this.getStatus() + ", statusMessage=" + this.getStatusMessage() + ", timeout=" + this.getTimeout() + ", workspaces=" + this.getWorkspaces() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
