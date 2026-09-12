
package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

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
 * Rollout strategy to apply workload to the selected clusters by Placement and DecisionStrategy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "all",
    "progressive",
    "progressivePerGroup",
    "type"
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
public class RolloutStrategy implements Editable<RolloutStrategyBuilder>, KubernetesResource
{

    @JsonProperty("all")
    private RolloutAll all;
    @JsonProperty("progressive")
    private RolloutProgressive progressive;
    @JsonProperty("progressivePerGroup")
    private RolloutProgressivePerGroup progressivePerGroup;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RolloutStrategy() {
    }

    public RolloutStrategy(RolloutAll all, RolloutProgressive progressive, RolloutProgressivePerGroup progressivePerGroup, String type) {
        super();
        this.all = all;
        this.progressive = progressive;
        this.progressivePerGroup = progressivePerGroup;
        this.type = type;
    }

    /**
     * Rollout strategy to apply workload to the selected clusters by Placement and DecisionStrategy.
     */
    @JsonProperty("all")
    public RolloutAll getAll() {
        return all;
    }

    /**
     * Rollout strategy to apply workload to the selected clusters by Placement and DecisionStrategy.
     */
    @JsonProperty("all")
    public void setAll(RolloutAll all) {
        this.all = all;
    }

    /**
     * Rollout strategy to apply workload to the selected clusters by Placement and DecisionStrategy.
     */
    @JsonProperty("progressive")
    public RolloutProgressive getProgressive() {
        return progressive;
    }

    /**
     * Rollout strategy to apply workload to the selected clusters by Placement and DecisionStrategy.
     */
    @JsonProperty("progressive")
    public void setProgressive(RolloutProgressive progressive) {
        this.progressive = progressive;
    }

    /**
     * Rollout strategy to apply workload to the selected clusters by Placement and DecisionStrategy.
     */
    @JsonProperty("progressivePerGroup")
    public RolloutProgressivePerGroup getProgressivePerGroup() {
        return progressivePerGroup;
    }

    /**
     * Rollout strategy to apply workload to the selected clusters by Placement and DecisionStrategy.
     */
    @JsonProperty("progressivePerGroup")
    public void setProgressivePerGroup(RolloutProgressivePerGroup progressivePerGroup) {
        this.progressivePerGroup = progressivePerGroup;
    }

    /**
     * Rollout strategy to apply workload to the selected clusters by Placement and DecisionStrategy.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Rollout strategy to apply workload to the selected clusters by Placement and DecisionStrategy.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public RolloutStrategyBuilder edit() {
        return new RolloutStrategyBuilder(this);
    }

    @JsonIgnore
    public RolloutStrategyBuilder toBuilder() {
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
        if (!(o instanceof RolloutStrategy)) {
            return false;
        }
        RolloutStrategy other = (RolloutStrategy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$all = this.getAll();
        Object other$all = other.getAll();
        if (this$all == null ? other$all != null : !this$all.equals(other$all)) {
            return false;
        }
        Object this$progressive = this.getProgressive();
        Object other$progressive = other.getProgressive();
        if (this$progressive == null ? other$progressive != null : !this$progressive.equals(other$progressive)) {
            return false;
        }
        Object this$progressivePerGroup = this.getProgressivePerGroup();
        Object other$progressivePerGroup = other.getProgressivePerGroup();
        if (this$progressivePerGroup == null ? other$progressivePerGroup != null : !this$progressivePerGroup.equals(other$progressivePerGroup)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof RolloutStrategy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $all = this.getAll();
        result = result * prime + ($all == null ? 43 : $all.hashCode());
        Object $progressive = this.getProgressive();
        result = result * prime + ($progressive == null ? 43 : $progressive.hashCode());
        Object $progressivePerGroup = this.getProgressivePerGroup();
        result = result * prime + ($progressivePerGroup == null ? 43 : $progressivePerGroup.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RolloutStrategy(" + "all=" + this.getAll() + ", progressive=" + this.getProgressive() + ", progressivePerGroup=" + this.getProgressivePerGroup() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
