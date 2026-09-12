
package io.fabric8.kubernetes.api.model.policy.v1beta1;

import java.util.LinkedHashMap;
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
 * PodDisruptionBudgetSpec is a description of a PodDisruptionBudget.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxUnavailable",
    "minAvailable",
    "selector"
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
public class PodDisruptionBudgetSpec implements Editable<PodDisruptionBudgetSpecBuilder>, KubernetesResource
{

    @JsonProperty("maxUnavailable")
    private IntOrString maxUnavailable;
    @JsonProperty("minAvailable")
    private IntOrString minAvailable;
    @JsonProperty("selector")
    private LabelSelector selector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodDisruptionBudgetSpec() {
    }

    public PodDisruptionBudgetSpec(IntOrString maxUnavailable, IntOrString minAvailable, LabelSelector selector) {
        super();
        this.maxUnavailable = maxUnavailable;
        this.minAvailable = minAvailable;
        this.selector = selector;
    }

    /**
     * PodDisruptionBudgetSpec is a description of a PodDisruptionBudget.
     */
    @JsonProperty("maxUnavailable")
    public IntOrString getMaxUnavailable() {
        return maxUnavailable;
    }

    /**
     * PodDisruptionBudgetSpec is a description of a PodDisruptionBudget.
     */
    @JsonProperty("maxUnavailable")
    public void setMaxUnavailable(IntOrString maxUnavailable) {
        this.maxUnavailable = maxUnavailable;
    }

    /**
     * PodDisruptionBudgetSpec is a description of a PodDisruptionBudget.
     */
    @JsonProperty("minAvailable")
    public IntOrString getMinAvailable() {
        return minAvailable;
    }

    /**
     * PodDisruptionBudgetSpec is a description of a PodDisruptionBudget.
     */
    @JsonProperty("minAvailable")
    public void setMinAvailable(IntOrString minAvailable) {
        this.minAvailable = minAvailable;
    }

    /**
     * PodDisruptionBudgetSpec is a description of a PodDisruptionBudget.
     */
    @JsonProperty("selector")
    public LabelSelector getSelector() {
        return selector;
    }

    /**
     * PodDisruptionBudgetSpec is a description of a PodDisruptionBudget.
     */
    @JsonProperty("selector")
    public void setSelector(LabelSelector selector) {
        this.selector = selector;
    }

    @JsonIgnore
    public PodDisruptionBudgetSpecBuilder edit() {
        return new PodDisruptionBudgetSpecBuilder(this);
    }

    @JsonIgnore
    public PodDisruptionBudgetSpecBuilder toBuilder() {
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
        if (!(o instanceof PodDisruptionBudgetSpec)) {
            return false;
        }
        PodDisruptionBudgetSpec other = (PodDisruptionBudgetSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$maxUnavailable = this.getMaxUnavailable();
        Object other$maxUnavailable = other.getMaxUnavailable();
        if (this$maxUnavailable == null ? other$maxUnavailable != null : !this$maxUnavailable.equals(other$maxUnavailable)) {
            return false;
        }
        Object this$minAvailable = this.getMinAvailable();
        Object other$minAvailable = other.getMinAvailable();
        if (this$minAvailable == null ? other$minAvailable != null : !this$minAvailable.equals(other$minAvailable)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
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
        return other instanceof PodDisruptionBudgetSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $maxUnavailable = this.getMaxUnavailable();
        result = result * prime + ($maxUnavailable == null ? 43 : $maxUnavailable.hashCode());
        Object $minAvailable = this.getMinAvailable();
        result = result * prime + ($minAvailable == null ? 43 : $minAvailable.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodDisruptionBudgetSpec(" + "maxUnavailable=" + this.getMaxUnavailable() + ", minAvailable=" + this.getMinAvailable() + ", selector=" + this.getSelector() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
