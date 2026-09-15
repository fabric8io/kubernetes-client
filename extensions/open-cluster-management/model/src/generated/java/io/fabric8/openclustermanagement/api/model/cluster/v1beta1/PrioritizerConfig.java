
package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
 * PrioritizerConfig represents the configuration of prioritizer
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "scoreCoordinate",
    "weight"
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
public class PrioritizerConfig implements Editable<PrioritizerConfigBuilder>, KubernetesResource
{

    @JsonProperty("scoreCoordinate")
    private ScoreCoordinate scoreCoordinate;
    @JsonProperty("weight")
    private Integer weight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrioritizerConfig() {
    }

    public PrioritizerConfig(ScoreCoordinate scoreCoordinate, Integer weight) {
        super();
        this.scoreCoordinate = scoreCoordinate;
        this.weight = weight;
    }

    /**
     * PrioritizerConfig represents the configuration of prioritizer
     */
    @JsonProperty("scoreCoordinate")
    public ScoreCoordinate getScoreCoordinate() {
        return scoreCoordinate;
    }

    /**
     * PrioritizerConfig represents the configuration of prioritizer
     */
    @JsonProperty("scoreCoordinate")
    public void setScoreCoordinate(ScoreCoordinate scoreCoordinate) {
        this.scoreCoordinate = scoreCoordinate;
    }

    /**
     * weight defines the weight of the prioritizer score. The value must be ranged in [-10,10]. Each prioritizer will calculate an integer score of a cluster in the range of [-100, 100]. The final score of a cluster will be sum(weight &#42; prioritizer_score). A higher weight indicates that the prioritizer weights more in the cluster selection, while 0 weight indicates that the prioritizer is disabled. A negative weight indicates wants to select the last ones.
     */
    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    /**
     * weight defines the weight of the prioritizer score. The value must be ranged in [-10,10]. Each prioritizer will calculate an integer score of a cluster in the range of [-100, 100]. The final score of a cluster will be sum(weight &#42; prioritizer_score). A higher weight indicates that the prioritizer weights more in the cluster selection, while 0 weight indicates that the prioritizer is disabled. A negative weight indicates wants to select the last ones.
     */
    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonIgnore
    public PrioritizerConfigBuilder edit() {
        return new PrioritizerConfigBuilder(this);
    }

    @JsonIgnore
    public PrioritizerConfigBuilder toBuilder() {
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
        if (!(o instanceof PrioritizerConfig)) {
            return false;
        }
        PrioritizerConfig other = (PrioritizerConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$scoreCoordinate = this.getScoreCoordinate();
        Object other$scoreCoordinate = other.getScoreCoordinate();
        if (this$scoreCoordinate == null ? other$scoreCoordinate != null : !this$scoreCoordinate.equals(other$scoreCoordinate)) {
            return false;
        }
        Object this$weight = this.getWeight();
        Object other$weight = other.getWeight();
        if (this$weight == null ? other$weight != null : !this$weight.equals(other$weight)) {
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
        return other instanceof PrioritizerConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $scoreCoordinate = this.getScoreCoordinate();
        result = result * prime + ($scoreCoordinate == null ? 43 : $scoreCoordinate.hashCode());
        Object $weight = this.getWeight();
        result = result * prime + ($weight == null ? 43 : $weight.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PrioritizerConfig(" + "scoreCoordinate=" + this.getScoreCoordinate() + ", weight=" + this.getWeight() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
