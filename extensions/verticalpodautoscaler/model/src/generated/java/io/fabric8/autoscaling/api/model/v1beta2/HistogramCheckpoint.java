
package io.fabric8.autoscaling.api.model.v1beta2;

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
 * HistogramCheckpoint contains data needed to reconstruct the histogram.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bucketWeights",
    "referenceTimestamp",
    "totalWeight"
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
public class HistogramCheckpoint implements Editable<HistogramCheckpointBuilder>, KubernetesResource
{

    @JsonProperty("bucketWeights")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Long> bucketWeights = new LinkedHashMap<>();
    @JsonProperty("referenceTimestamp")
    private String referenceTimestamp;
    @JsonProperty("totalWeight")
    private Double totalWeight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HistogramCheckpoint() {
    }

    public HistogramCheckpoint(Map<String, Long> bucketWeights, String referenceTimestamp, Double totalWeight) {
        super();
        this.bucketWeights = bucketWeights;
        this.referenceTimestamp = referenceTimestamp;
        this.totalWeight = totalWeight;
    }

    /**
     * Map from bucket index to bucket weight.
     */
    @JsonProperty("bucketWeights")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Long> getBucketWeights() {
        return bucketWeights;
    }

    /**
     * Map from bucket index to bucket weight.
     */
    @JsonProperty("bucketWeights")
    public void setBucketWeights(Map<String, Long> bucketWeights) {
        this.bucketWeights = bucketWeights;
    }

    /**
     * HistogramCheckpoint contains data needed to reconstruct the histogram.
     */
    @JsonProperty("referenceTimestamp")
    public String getReferenceTimestamp() {
        return referenceTimestamp;
    }

    /**
     * HistogramCheckpoint contains data needed to reconstruct the histogram.
     */
    @JsonProperty("referenceTimestamp")
    public void setReferenceTimestamp(String referenceTimestamp) {
        this.referenceTimestamp = referenceTimestamp;
    }

    /**
     * Sum of samples to be used as denominator for weights from BucketWeights.
     */
    @JsonProperty("totalWeight")
    public Double getTotalWeight() {
        return totalWeight;
    }

    /**
     * Sum of samples to be used as denominator for weights from BucketWeights.
     */
    @JsonProperty("totalWeight")
    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    @JsonIgnore
    public HistogramCheckpointBuilder edit() {
        return new HistogramCheckpointBuilder(this);
    }

    @JsonIgnore
    public HistogramCheckpointBuilder toBuilder() {
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
        if (!(o instanceof HistogramCheckpoint)) {
            return false;
        }
        HistogramCheckpoint other = (HistogramCheckpoint) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bucketWeights = this.getBucketWeights();
        Object other$bucketWeights = other.getBucketWeights();
        if (this$bucketWeights == null ? other$bucketWeights != null : !this$bucketWeights.equals(other$bucketWeights)) {
            return false;
        }
        Object this$referenceTimestamp = this.getReferenceTimestamp();
        Object other$referenceTimestamp = other.getReferenceTimestamp();
        if (this$referenceTimestamp == null ? other$referenceTimestamp != null : !this$referenceTimestamp.equals(other$referenceTimestamp)) {
            return false;
        }
        Object this$totalWeight = this.getTotalWeight();
        Object other$totalWeight = other.getTotalWeight();
        if (this$totalWeight == null ? other$totalWeight != null : !this$totalWeight.equals(other$totalWeight)) {
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
        return other instanceof HistogramCheckpoint;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bucketWeights = this.getBucketWeights();
        result = result * prime + ($bucketWeights == null ? 43 : $bucketWeights.hashCode());
        Object $referenceTimestamp = this.getReferenceTimestamp();
        result = result * prime + ($referenceTimestamp == null ? 43 : $referenceTimestamp.hashCode());
        Object $totalWeight = this.getTotalWeight();
        result = result * prime + ($totalWeight == null ? 43 : $totalWeight.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HistogramCheckpoint(" + "bucketWeights=" + this.getBucketWeights() + ", referenceTimestamp=" + this.getReferenceTimestamp() + ", totalWeight=" + this.getTotalWeight() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
