
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}
