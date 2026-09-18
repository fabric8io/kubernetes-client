
package io.fabric8.kubernetes.api.model.scheduling.v1beta1;

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
 * CompositePodGroupSchedulingPolicy defines the scheduling configuration for a CompositePodGroup. Exactly one policy must be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "basic",
    "gang"
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
public class CompositePodGroupSchedulingPolicy implements Editable<CompositePodGroupSchedulingPolicyBuilder>, KubernetesResource
{

    @JsonProperty("basic")
    private CompositeBasicSchedulingPolicy basic;
    @JsonProperty("gang")
    private CompositeGangSchedulingPolicy gang;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CompositePodGroupSchedulingPolicy() {
    }

    public CompositePodGroupSchedulingPolicy(CompositeBasicSchedulingPolicy basic, CompositeGangSchedulingPolicy gang) {
        super();
        this.basic = basic;
        this.gang = gang;
    }

    /**
     * CompositePodGroupSchedulingPolicy defines the scheduling configuration for a CompositePodGroup. Exactly one policy must be set.
     */
    @JsonProperty("basic")
    public CompositeBasicSchedulingPolicy getBasic() {
        return basic;
    }

    /**
     * CompositePodGroupSchedulingPolicy defines the scheduling configuration for a CompositePodGroup. Exactly one policy must be set.
     */
    @JsonProperty("basic")
    public void setBasic(CompositeBasicSchedulingPolicy basic) {
        this.basic = basic;
    }

    /**
     * CompositePodGroupSchedulingPolicy defines the scheduling configuration for a CompositePodGroup. Exactly one policy must be set.
     */
    @JsonProperty("gang")
    public CompositeGangSchedulingPolicy getGang() {
        return gang;
    }

    /**
     * CompositePodGroupSchedulingPolicy defines the scheduling configuration for a CompositePodGroup. Exactly one policy must be set.
     */
    @JsonProperty("gang")
    public void setGang(CompositeGangSchedulingPolicy gang) {
        this.gang = gang;
    }

    @JsonIgnore
    public CompositePodGroupSchedulingPolicyBuilder edit() {
        return new CompositePodGroupSchedulingPolicyBuilder(this);
    }

    @JsonIgnore
    public CompositePodGroupSchedulingPolicyBuilder toBuilder() {
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
        if (!(o instanceof CompositePodGroupSchedulingPolicy)) {
            return false;
        }
        CompositePodGroupSchedulingPolicy other = (CompositePodGroupSchedulingPolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$basic = this.getBasic();
        Object other$basic = other.getBasic();
        if (this$basic == null ? other$basic != null : !this$basic.equals(other$basic)) {
            return false;
        }
        Object this$gang = this.getGang();
        Object other$gang = other.getGang();
        if (this$gang == null ? other$gang != null : !this$gang.equals(other$gang)) {
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
        return other instanceof CompositePodGroupSchedulingPolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $basic = this.getBasic();
        result = result * prime + ($basic == null ? 43 : $basic.hashCode());
        Object $gang = this.getGang();
        result = result * prime + ($gang == null ? 43 : $gang.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CompositePodGroupSchedulingPolicy(" + "basic=" + this.getBasic() + ", gang=" + this.getGang() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
