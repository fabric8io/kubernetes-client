
package io.fabric8.tekton.v1alpha1;

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
import io.fabric8.tekton.v1beta1.Param;
import io.fabric8.tekton.v1beta1.TaskRef;
import io.fabric8.tekton.v1beta1.WorkspaceBinding;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * RunSpec defines the desired state of Run
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "params",
    "podTemplate",
    "ref",
    "retries",
    "serviceAccountName",
    "spec",
    "status",
    "statusMessage",
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
public class RunSpec implements Editable<RunSpecBuilder>, KubernetesResource
{

    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Param> params = new ArrayList<>();
    @JsonProperty("podTemplate")
    private Template podTemplate;
    @JsonProperty("ref")
    private TaskRef ref;
    @JsonProperty("retries")
    private Integer retries;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("spec")
    private EmbeddedRunSpec spec;
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
    public RunSpec() {
    }

    public RunSpec(List<Param> params, Template podTemplate, TaskRef ref, Integer retries, String serviceAccountName, EmbeddedRunSpec spec, String status, String statusMessage, Duration timeout, List<WorkspaceBinding> workspaces) {
        super();
        this.params = params;
        this.podTemplate = podTemplate;
        this.ref = ref;
        this.retries = retries;
        this.serviceAccountName = serviceAccountName;
        this.spec = spec;
        this.status = status;
        this.statusMessage = statusMessage;
        this.timeout = timeout;
        this.workspaces = workspaces;
    }

    /**
     * RunSpec defines the desired state of Run
     */
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Param> getParams() {
        return params;
    }

    /**
     * RunSpec defines the desired state of Run
     */
    @JsonProperty("params")
    public void setParams(List<Param> params) {
        this.params = params;
    }

    /**
     * RunSpec defines the desired state of Run
     */
    @JsonProperty("podTemplate")
    public Template getPodTemplate() {
        return podTemplate;
    }

    /**
     * RunSpec defines the desired state of Run
     */
    @JsonProperty("podTemplate")
    public void setPodTemplate(Template podTemplate) {
        this.podTemplate = podTemplate;
    }

    /**
     * RunSpec defines the desired state of Run
     */
    @JsonProperty("ref")
    public TaskRef getRef() {
        return ref;
    }

    /**
     * RunSpec defines the desired state of Run
     */
    @JsonProperty("ref")
    public void setRef(TaskRef ref) {
        this.ref = ref;
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
     * RunSpec defines the desired state of Run
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * RunSpec defines the desired state of Run
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * RunSpec defines the desired state of Run
     */
    @JsonProperty("spec")
    public EmbeddedRunSpec getSpec() {
        return spec;
    }

    /**
     * RunSpec defines the desired state of Run
     */
    @JsonProperty("spec")
    public void setSpec(EmbeddedRunSpec spec) {
        this.spec = spec;
    }

    /**
     * Used for cancelling a run (and maybe more later on)
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Used for cancelling a run (and maybe more later on)
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
     * RunSpec defines the desired state of Run
     */
    @JsonProperty("timeout")
    public Duration getTimeout() {
        return timeout;
    }

    /**
     * RunSpec defines the desired state of Run
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
    public RunSpecBuilder edit() {
        return new RunSpecBuilder(this);
    }

    @JsonIgnore
    public RunSpecBuilder toBuilder() {
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
