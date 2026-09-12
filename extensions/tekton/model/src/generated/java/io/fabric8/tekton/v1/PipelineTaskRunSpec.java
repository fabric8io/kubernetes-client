
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
 * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "computeResources",
    "pipelineTaskName",
    "podTemplate",
    "serviceAccountName",
    "sidecarSpecs",
    "stepSpecs",
    "timeout"
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
public class PipelineTaskRunSpec implements Editable<PipelineTaskRunSpecBuilder>, KubernetesResource
{

    @JsonProperty("computeResources")
    private ResourceRequirements computeResources;
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
    private List<TaskRunSidecarSpec> sidecarSpecs = new ArrayList<>();
    @JsonProperty("stepSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TaskRunStepSpec> stepSpecs = new ArrayList<>();
    @JsonProperty("timeout")
    private Duration timeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PipelineTaskRunSpec() {
    }

    public PipelineTaskRunSpec(ResourceRequirements computeResources, PipelineTaskMetadata metadata, String pipelineTaskName, Template podTemplate, String serviceAccountName, List<TaskRunSidecarSpec> sidecarSpecs, List<TaskRunStepSpec> stepSpecs, Duration timeout) {
        super();
        this.computeResources = computeResources;
        this.metadata = metadata;
        this.pipelineTaskName = pipelineTaskName;
        this.podTemplate = podTemplate;
        this.serviceAccountName = serviceAccountName;
        this.sidecarSpecs = sidecarSpecs;
        this.stepSpecs = stepSpecs;
        this.timeout = timeout;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("computeResources")
    public ResourceRequirements getComputeResources() {
        return computeResources;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("computeResources")
    public void setComputeResources(ResourceRequirements computeResources) {
        this.computeResources = computeResources;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("metadata")
    public PipelineTaskMetadata getMetadata() {
        return metadata;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("metadata")
    public void setMetadata(PipelineTaskMetadata metadata) {
        this.metadata = metadata;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("pipelineTaskName")
    public String getPipelineTaskName() {
        return pipelineTaskName;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("pipelineTaskName")
    public void setPipelineTaskName(String pipelineTaskName) {
        this.pipelineTaskName = pipelineTaskName;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("podTemplate")
    public Template getPodTemplate() {
        return podTemplate;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("podTemplate")
    public void setPodTemplate(Template podTemplate) {
        this.podTemplate = podTemplate;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("sidecarSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskRunSidecarSpec> getSidecarSpecs() {
        return sidecarSpecs;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("sidecarSpecs")
    public void setSidecarSpecs(List<TaskRunSidecarSpec> sidecarSpecs) {
        this.sidecarSpecs = sidecarSpecs;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("stepSpecs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TaskRunStepSpec> getStepSpecs() {
        return stepSpecs;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("stepSpecs")
    public void setStepSpecs(List<TaskRunStepSpec> stepSpecs) {
        this.stepSpecs = stepSpecs;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("timeout")
    public Duration getTimeout() {
        return timeout;
    }

    /**
     * PipelineTaskRunSpec  can be used to configure specific specs for a concrete Task
     */
    @JsonProperty("timeout")
    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
    }

    @JsonIgnore
    public PipelineTaskRunSpecBuilder edit() {
        return new PipelineTaskRunSpecBuilder(this);
    }

    @JsonIgnore
    public PipelineTaskRunSpecBuilder toBuilder() {
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
        if (!(o instanceof PipelineTaskRunSpec)) {
            return false;
        }
        PipelineTaskRunSpec other = (PipelineTaskRunSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$computeResources = this.getComputeResources();
        Object other$computeResources = other.getComputeResources();
        if (this$computeResources == null ? other$computeResources != null : !this$computeResources.equals(other$computeResources)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$pipelineTaskName = this.getPipelineTaskName();
        Object other$pipelineTaskName = other.getPipelineTaskName();
        if (this$pipelineTaskName == null ? other$pipelineTaskName != null : !this$pipelineTaskName.equals(other$pipelineTaskName)) {
            return false;
        }
        Object this$podTemplate = this.getPodTemplate();
        Object other$podTemplate = other.getPodTemplate();
        if (this$podTemplate == null ? other$podTemplate != null : !this$podTemplate.equals(other$podTemplate)) {
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
        Object this$stepSpecs = this.getStepSpecs();
        Object other$stepSpecs = other.getStepSpecs();
        if (this$stepSpecs == null ? other$stepSpecs != null : !this$stepSpecs.equals(other$stepSpecs)) {
            return false;
        }
        Object this$timeout = this.getTimeout();
        Object other$timeout = other.getTimeout();
        if (this$timeout == null ? other$timeout != null : !this$timeout.equals(other$timeout)) {
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
        return other instanceof PipelineTaskRunSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $computeResources = this.getComputeResources();
        result = result * prime + ($computeResources == null ? 43 : $computeResources.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $pipelineTaskName = this.getPipelineTaskName();
        result = result * prime + ($pipelineTaskName == null ? 43 : $pipelineTaskName.hashCode());
        Object $podTemplate = this.getPodTemplate();
        result = result * prime + ($podTemplate == null ? 43 : $podTemplate.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $sidecarSpecs = this.getSidecarSpecs();
        result = result * prime + ($sidecarSpecs == null ? 43 : $sidecarSpecs.hashCode());
        Object $stepSpecs = this.getStepSpecs();
        result = result * prime + ($stepSpecs == null ? 43 : $stepSpecs.hashCode());
        Object $timeout = this.getTimeout();
        result = result * prime + ($timeout == null ? 43 : $timeout.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PipelineTaskRunSpec(" + "computeResources=" + this.getComputeResources() + ", metadata=" + this.getMetadata() + ", pipelineTaskName=" + this.getPipelineTaskName() + ", podTemplate=" + this.getPodTemplate() + ", serviceAccountName=" + this.getServiceAccountName() + ", sidecarSpecs=" + this.getSidecarSpecs() + ", stepSpecs=" + this.getStepSpecs() + ", timeout=" + this.getTimeout() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
