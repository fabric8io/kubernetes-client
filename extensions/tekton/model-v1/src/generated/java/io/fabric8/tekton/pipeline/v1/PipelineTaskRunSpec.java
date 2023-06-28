
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
    "pipelineTaskName",
    "podTemplate",
    "serviceAccountName",
    "sidecarSpecs",
    "stepSpecs"
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
public class PipelineTaskRunSpec implements KubernetesResource
{

    @JsonProperty("computeResources")
    private io.fabric8.kubernetes.api.model.ResourceRequirements computeResources;
    @JsonProperty("metadata")
    private PipelineTaskMetadata metadata;
    @JsonProperty("pipelineTaskName")
    private String pipelineTaskName;
    @JsonProperty("podTemplate")
    private Template podTemplate;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sidecarSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunSidecarSpec> sidecarSpecs = new ArrayList<TaskRunSidecarSpec>();
    @JsonProperty("stepSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunStepSpec> stepSpecs = new ArrayList<TaskRunStepSpec>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PipelineTaskRunSpec() {
    }

    public PipelineTaskRunSpec(io.fabric8.kubernetes.api.model.ResourceRequirements computeResources, PipelineTaskMetadata metadata, String pipelineTaskName, Template podTemplate, String serviceAccountName, List<TaskRunSidecarSpec> sidecarSpecs, List<TaskRunStepSpec> stepSpecs) {
        super();
        this.computeResources = computeResources;
        this.metadata = metadata;
        this.pipelineTaskName = pipelineTaskName;
        this.podTemplate = podTemplate;
        this.serviceAccountName = serviceAccountName;
        this.sidecarSpecs = sidecarSpecs;
        this.stepSpecs = stepSpecs;
    }

    @JsonProperty("computeResources")
    public io.fabric8.kubernetes.api.model.ResourceRequirements getComputeResources() {
        return computeResources;
    }

    @JsonProperty("computeResources")
    public void setComputeResources(io.fabric8.kubernetes.api.model.ResourceRequirements computeResources) {
        this.computeResources = computeResources;
    }

    @JsonProperty("metadata")
    public PipelineTaskMetadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(PipelineTaskMetadata metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("pipelineTaskName")
    public String getPipelineTaskName() {
        return pipelineTaskName;
    }

    @JsonProperty("pipelineTaskName")
    public void setPipelineTaskName(String pipelineTaskName) {
        this.pipelineTaskName = pipelineTaskName;
    }

    @JsonProperty("podTemplate")
    public Template getPodTemplate() {
        return podTemplate;
    }

    @JsonProperty("podTemplate")
    public void setPodTemplate(Template podTemplate) {
        this.podTemplate = podTemplate;
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

    @JsonProperty("stepSpecs")
    public List<TaskRunStepSpec> getStepSpecs() {
        return stepSpecs;
    }

    @JsonProperty("stepSpecs")
    public void setStepSpecs(List<TaskRunStepSpec> stepSpecs) {
        this.stepSpecs = stepSpecs;
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
