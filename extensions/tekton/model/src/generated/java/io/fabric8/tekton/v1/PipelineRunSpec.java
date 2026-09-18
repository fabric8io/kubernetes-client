
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PipelineRunSpec)) {
            return false;
        }
        PipelineRunSpec other = (PipelineRunSpec) o;
        if (!other.canEqual(this)) {
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
        Object this$pipelineRef = this.getPipelineRef();
        Object other$pipelineRef = other.getPipelineRef();
        if (this$pipelineRef == null ? other$pipelineRef != null : !this$pipelineRef.equals(other$pipelineRef)) {
            return false;
        }
        Object this$pipelineSpec = this.getPipelineSpec();
        Object other$pipelineSpec = other.getPipelineSpec();
        if (this$pipelineSpec == null ? other$pipelineSpec != null : !this$pipelineSpec.equals(other$pipelineSpec)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        Object this$taskRunSpecs = this.getTaskRunSpecs();
        Object other$taskRunSpecs = other.getTaskRunSpecs();
        if (this$taskRunSpecs == null ? other$taskRunSpecs != null : !this$taskRunSpecs.equals(other$taskRunSpecs)) {
            return false;
        }
        Object this$taskRunTemplate = this.getTaskRunTemplate();
        Object other$taskRunTemplate = other.getTaskRunTemplate();
        if (this$taskRunTemplate == null ? other$taskRunTemplate != null : !this$taskRunTemplate.equals(other$taskRunTemplate)) {
            return false;
        }
        Object this$timeouts = this.getTimeouts();
        Object other$timeouts = other.getTimeouts();
        if (this$timeouts == null ? other$timeouts != null : !this$timeouts.equals(other$timeouts)) {
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
        return other instanceof PipelineRunSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $managedBy = this.getManagedBy();
        result = result * prime + ($managedBy == null ? 43 : $managedBy.hashCode());
        Object $params = this.getParams();
        result = result * prime + ($params == null ? 43 : $params.hashCode());
        Object $pipelineRef = this.getPipelineRef();
        result = result * prime + ($pipelineRef == null ? 43 : $pipelineRef.hashCode());
        Object $pipelineSpec = this.getPipelineSpec();
        result = result * prime + ($pipelineSpec == null ? 43 : $pipelineSpec.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $taskRunSpecs = this.getTaskRunSpecs();
        result = result * prime + ($taskRunSpecs == null ? 43 : $taskRunSpecs.hashCode());
        Object $taskRunTemplate = this.getTaskRunTemplate();
        result = result * prime + ($taskRunTemplate == null ? 43 : $taskRunTemplate.hashCode());
        Object $timeouts = this.getTimeouts();
        result = result * prime + ($timeouts == null ? 43 : $timeouts.hashCode());
        Object $workspaces = this.getWorkspaces();
        result = result * prime + ($workspaces == null ? 43 : $workspaces.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PipelineRunSpec(" + "managedBy=" + this.getManagedBy() + ", params=" + this.getParams() + ", pipelineRef=" + this.getPipelineRef() + ", pipelineSpec=" + this.getPipelineSpec() + ", status=" + this.getStatus() + ", taskRunSpecs=" + this.getTaskRunSpecs() + ", taskRunTemplate=" + this.getTaskRunTemplate() + ", timeouts=" + this.getTimeouts() + ", workspaces=" + this.getWorkspaces() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
