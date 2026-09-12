
package io.fabric8.chaosmesh.v1alpha1;

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
 * MistakeSpec represents one type of mistake
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "filling",
    "maxLength",
    "maxOccurrences"
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
public class MistakeSpec implements Editable<MistakeSpecBuilder>, KubernetesResource
{

    @JsonProperty("filling")
    private String filling;
    @JsonProperty("maxLength")
    private Long maxLength;
    @JsonProperty("maxOccurrences")
    private Long maxOccurrences;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MistakeSpec() {
    }

    public MistakeSpec(String filling, Long maxLength, Long maxOccurrences) {
        super();
        this.filling = filling;
        this.maxLength = maxLength;
        this.maxOccurrences = maxOccurrences;
    }

    /**
     * Filling determines what is filled in the mistake data.
     */
    @JsonProperty("filling")
    public String getFilling() {
        return filling;
    }

    /**
     * Filling determines what is filled in the mistake data.
     */
    @JsonProperty("filling")
    public void setFilling(String filling) {
        this.filling = filling;
    }

    /**
     * Max length of each wrong data segment in bytes
     */
    @JsonProperty("maxLength")
    public Long getMaxLength() {
        return maxLength;
    }

    /**
     * Max length of each wrong data segment in bytes
     */
    @JsonProperty("maxLength")
    public void setMaxLength(Long maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * There will be [1, MaxOccurrences] segments of wrong data.
     */
    @JsonProperty("maxOccurrences")
    public Long getMaxOccurrences() {
        return maxOccurrences;
    }

    /**
     * There will be [1, MaxOccurrences] segments of wrong data.
     */
    @JsonProperty("maxOccurrences")
    public void setMaxOccurrences(Long maxOccurrences) {
        this.maxOccurrences = maxOccurrences;
    }

    @JsonIgnore
    public MistakeSpecBuilder edit() {
        return new MistakeSpecBuilder(this);
    }

    @JsonIgnore
    public MistakeSpecBuilder toBuilder() {
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
        if (!(o instanceof MistakeSpec)) {
            return false;
        }
        MistakeSpec other = (MistakeSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$filling = this.getFilling();
        Object other$filling = other.getFilling();
        if (this$filling == null ? other$filling != null : !this$filling.equals(other$filling)) {
            return false;
        }
        Object this$maxLength = this.getMaxLength();
        Object other$maxLength = other.getMaxLength();
        if (this$maxLength == null ? other$maxLength != null : !this$maxLength.equals(other$maxLength)) {
            return false;
        }
        Object this$maxOccurrences = this.getMaxOccurrences();
        Object other$maxOccurrences = other.getMaxOccurrences();
        if (this$maxOccurrences == null ? other$maxOccurrences != null : !this$maxOccurrences.equals(other$maxOccurrences)) {
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
        return other instanceof MistakeSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $filling = this.getFilling();
        result = result * prime + ($filling == null ? 43 : $filling.hashCode());
        Object $maxLength = this.getMaxLength();
        result = result * prime + ($maxLength == null ? 43 : $maxLength.hashCode());
        Object $maxOccurrences = this.getMaxOccurrences();
        result = result * prime + ($maxOccurrences == null ? 43 : $maxOccurrences.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MistakeSpec(" + "filling=" + this.getFilling() + ", maxLength=" + this.getMaxLength() + ", maxOccurrences=" + this.getMaxOccurrences() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
