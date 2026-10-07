
package io.fabric8.openclustermanagement.api.model.policy.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * RemainingBinding reports a placement binding that still places the policy on a managed cluster when the policy is excluded on a policy set.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "placementBinding"
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
public class RemainingBinding implements Editable<RemainingBindingBuilder>, KubernetesResource
{

    @JsonProperty("placementBinding")
    private String placementBinding;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RemainingBinding() {
    }

    public RemainingBinding(String placementBinding) {
        super();
        this.placementBinding = placementBinding;
    }

    /**
     * RemainingBinding reports a placement binding that still places the policy on a managed cluster when the policy is excluded on a policy set.
     */
    @JsonProperty("placementBinding")
    public String getPlacementBinding() {
        return placementBinding;
    }

    /**
     * RemainingBinding reports a placement binding that still places the policy on a managed cluster when the policy is excluded on a policy set.
     */
    @JsonProperty("placementBinding")
    public void setPlacementBinding(String placementBinding) {
        this.placementBinding = placementBinding;
    }

    @JsonIgnore
    public RemainingBindingBuilder edit() {
        return new RemainingBindingBuilder(this);
    }

    @JsonIgnore
    public RemainingBindingBuilder toBuilder() {
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
        if (!(o instanceof RemainingBinding)) {
            return false;
        }
        RemainingBinding other = (RemainingBinding) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$placementBinding = this.getPlacementBinding();
        Object other$placementBinding = other.getPlacementBinding();
        if (this$placementBinding == null ? other$placementBinding != null : !this$placementBinding.equals(other$placementBinding)) {
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
        return other instanceof RemainingBinding;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $placementBinding = this.getPlacementBinding();
        result = result * prime + ($placementBinding == null ? 43 : $placementBinding.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RemainingBinding(" + "placementBinding=" + this.getPlacementBinding() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
