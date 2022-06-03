
package io.fabric8.tekton.pipeline.v1alpha1;

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
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.pod.Template;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.Param;
import io.fabric8.tekton.v1alpha1.internal.pipeline.pkg.apis.pipeline.v1alpha2.WorkspaceBinding;
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
    "params",
    "pipelineRef",
    "pipelineSpec",
    "podTemplate",
    "resources",
    "serviceAccountName",
    "serviceAccountNames",
    "status",
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
public class PipelineRunSpec implements KubernetesResource
{

    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Param> params = new ArrayList<Param>();
    @JsonProperty("pipelineRef")
    private PipelineRef pipelineRef;
    @JsonProperty("pipelineSpec")
    private PipelineSpec pipelineSpec;
    @JsonProperty("podTemplate")
    private Template podTemplate;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineResourceBinding> resources = new ArrayList<PipelineResourceBinding>();
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("serviceAccountNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PipelineRunSpecServiceAccountName> serviceAccountNames = new ArrayList<PipelineRunSpecServiceAccountName>();
    @JsonProperty("status")
    private String status;
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
    public PipelineRunSpec() {
    }

    /**
     * 
     * @param pipelineSpec
     * @param serviceAccountName
     * @param podTemplate
     * @param resources
     * @param workspaces
     * @param params
     * @param pipelineRef
     * @param timeout
     * @param serviceAccountNames
     * @param status
     */
    public PipelineRunSpec(List<Param> params, PipelineRef pipelineRef, PipelineSpec pipelineSpec, Template podTemplate, List<PipelineResourceBinding> resources, String serviceAccountName, List<PipelineRunSpecServiceAccountName> serviceAccountNames, String status, Duration timeout, List<WorkspaceBinding> workspaces) {
        super();
        this.params = params;
        this.pipelineRef = pipelineRef;
        this.pipelineSpec = pipelineSpec;
        this.podTemplate = podTemplate;
        this.resources = resources;
        this.serviceAccountName = serviceAccountName;
        this.serviceAccountNames = serviceAccountNames;
        this.status = status;
        this.timeout = timeout;
        this.workspaces = workspaces;
    }

    @JsonProperty("params")
    public List<Param> getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(List<Param> params) {
        this.params = params;
    }

    @JsonProperty("pipelineRef")
    public PipelineRef getPipelineRef() {
        return pipelineRef;
    }

    @JsonProperty("pipelineRef")
    public void setPipelineRef(PipelineRef pipelineRef) {
        this.pipelineRef = pipelineRef;
    }

    @JsonProperty("pipelineSpec")
    public PipelineSpec getPipelineSpec() {
        return pipelineSpec;
    }

    @JsonProperty("pipelineSpec")
    public void setPipelineSpec(PipelineSpec pipelineSpec) {
        this.pipelineSpec = pipelineSpec;
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
    public List<PipelineResourceBinding> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<PipelineResourceBinding> resources) {
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

    @JsonProperty("serviceAccountNames")
    public List<PipelineRunSpecServiceAccountName> getServiceAccountNames() {
        return serviceAccountNames;
    }

    @JsonProperty("serviceAccountNames")
    public void setServiceAccountNames(List<PipelineRunSpecServiceAccountName> serviceAccountNames) {
        this.serviceAccountNames = serviceAccountNames;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
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
