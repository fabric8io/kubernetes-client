
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
 * InternalTaskModifier implements TaskModifier for resources that are built-in to Tekton Pipelines.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "stepsToAppend",
    "stepsToPrepend",
    "volumes"
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
public class InternalTaskModifier implements Editable<InternalTaskModifierBuilder>, KubernetesResource
{

    @JsonProperty("stepsToAppend")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Step> stepsToAppend = new ArrayList<>();
    @JsonProperty("stepsToPrepend")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Step> stepsToPrepend = new ArrayList<>();
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Volume> volumes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public InternalTaskModifier() {
    }

    public InternalTaskModifier(List<Step> stepsToAppend, List<Step> stepsToPrepend, List<Volume> volumes) {
        super();
        this.stepsToAppend = stepsToAppend;
        this.stepsToPrepend = stepsToPrepend;
        this.volumes = volumes;
    }

    /**
     * InternalTaskModifier implements TaskModifier for resources that are built-in to Tekton Pipelines.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("stepsToAppend")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Step> getStepsToAppend() {
        return stepsToAppend;
    }

    /**
     * InternalTaskModifier implements TaskModifier for resources that are built-in to Tekton Pipelines.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("stepsToAppend")
    public void setStepsToAppend(List<Step> stepsToAppend) {
        this.stepsToAppend = stepsToAppend;
    }

    /**
     * InternalTaskModifier implements TaskModifier for resources that are built-in to Tekton Pipelines.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("stepsToPrepend")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Step> getStepsToPrepend() {
        return stepsToPrepend;
    }

    /**
     * InternalTaskModifier implements TaskModifier for resources that are built-in to Tekton Pipelines.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("stepsToPrepend")
    public void setStepsToPrepend(List<Step> stepsToPrepend) {
        this.stepsToPrepend = stepsToPrepend;
    }

    /**
     * InternalTaskModifier implements TaskModifier for resources that are built-in to Tekton Pipelines.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Volume> getVolumes() {
        return volumes;
    }

    /**
     * InternalTaskModifier implements TaskModifier for resources that are built-in to Tekton Pipelines.<br><p> <br><p> Deprecated: Unused, preserved only for backwards compatibility
     */
    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    @JsonIgnore
    public InternalTaskModifierBuilder edit() {
        return new InternalTaskModifierBuilder(this);
    }

    @JsonIgnore
    public InternalTaskModifierBuilder toBuilder() {
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
        if (!(o instanceof InternalTaskModifier)) {
            return false;
        }
        InternalTaskModifier other = (InternalTaskModifier) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$stepsToAppend = this.getStepsToAppend();
        Object other$stepsToAppend = other.getStepsToAppend();
        if (this$stepsToAppend == null ? other$stepsToAppend != null : !this$stepsToAppend.equals(other$stepsToAppend)) {
            return false;
        }
        Object this$stepsToPrepend = this.getStepsToPrepend();
        Object other$stepsToPrepend = other.getStepsToPrepend();
        if (this$stepsToPrepend == null ? other$stepsToPrepend != null : !this$stepsToPrepend.equals(other$stepsToPrepend)) {
            return false;
        }
        Object this$volumes = this.getVolumes();
        Object other$volumes = other.getVolumes();
        if (this$volumes == null ? other$volumes != null : !this$volumes.equals(other$volumes)) {
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
        return other instanceof InternalTaskModifier;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $stepsToAppend = this.getStepsToAppend();
        result = result * prime + ($stepsToAppend == null ? 43 : $stepsToAppend.hashCode());
        Object $stepsToPrepend = this.getStepsToPrepend();
        result = result * prime + ($stepsToPrepend == null ? 43 : $stepsToPrepend.hashCode());
        Object $volumes = this.getVolumes();
        result = result * prime + ($volumes == null ? 43 : $volumes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "InternalTaskModifier(" + "stepsToAppend=" + this.getStepsToAppend() + ", stepsToPrepend=" + this.getStepsToPrepend() + ", volumes=" + this.getVolumes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
