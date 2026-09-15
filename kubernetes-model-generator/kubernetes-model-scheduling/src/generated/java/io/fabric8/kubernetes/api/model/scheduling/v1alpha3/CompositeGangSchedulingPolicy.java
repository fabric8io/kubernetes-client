
package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

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
 * CompositeGangSchedulingPolicy indicates that the groups belonging to the composite group should be scheduled using all-or-nothing semantics.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "minGroupCount"
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
public class CompositeGangSchedulingPolicy implements Editable<CompositeGangSchedulingPolicyBuilder>, KubernetesResource
{

    @JsonProperty("minGroupCount")
    private Integer minGroupCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CompositeGangSchedulingPolicy() {
    }

    public CompositeGangSchedulingPolicy(Integer minGroupCount) {
        super();
        this.minGroupCount = minGroupCount;
    }

    /**
     * minGroupCount is the minimum number of child groups that must be schedulable or scheduled at the same time for the scheduler to admit the entire group. It must be a positive integer.
     */
    @JsonProperty("minGroupCount")
    public Integer getMinGroupCount() {
        return minGroupCount;
    }

    /**
     * minGroupCount is the minimum number of child groups that must be schedulable or scheduled at the same time for the scheduler to admit the entire group. It must be a positive integer.
     */
    @JsonProperty("minGroupCount")
    public void setMinGroupCount(Integer minGroupCount) {
        this.minGroupCount = minGroupCount;
    }

    @JsonIgnore
    public CompositeGangSchedulingPolicyBuilder edit() {
        return new CompositeGangSchedulingPolicyBuilder(this);
    }

    @JsonIgnore
    public CompositeGangSchedulingPolicyBuilder toBuilder() {
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
        if (!(o instanceof CompositeGangSchedulingPolicy)) {
            return false;
        }
        CompositeGangSchedulingPolicy other = (CompositeGangSchedulingPolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$minGroupCount = this.getMinGroupCount();
        Object other$minGroupCount = other.getMinGroupCount();
        if (this$minGroupCount == null ? other$minGroupCount != null : !this$minGroupCount.equals(other$minGroupCount)) {
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
        return other instanceof CompositeGangSchedulingPolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $minGroupCount = this.getMinGroupCount();
        result = result * prime + ($minGroupCount == null ? 43 : $minGroupCount.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CompositeGangSchedulingPolicy(" + "minGroupCount=" + this.getMinGroupCount() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
