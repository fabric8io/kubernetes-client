
package io.fabric8.istio.api.api.networking.v1alpha3;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aggression",
    "duration",
    "minimumPercent"
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
public class WarmupConfiguration implements Editable<WarmupConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("aggression")
    private Double aggression;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("minimumPercent")
    private Double minimumPercent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WarmupConfiguration() {
    }

    public WarmupConfiguration(Double aggression, String duration, Double minimumPercent) {
        super();
        this.aggression = aggression;
        this.duration = duration;
        this.minimumPercent = minimumPercent;
    }

    @JsonProperty("aggression")
    public Double getAggression() {
        return aggression;
    }

    @JsonProperty("aggression")
    public void setAggression(Double aggression) {
        this.aggression = aggression;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("minimumPercent")
    public Double getMinimumPercent() {
        return minimumPercent;
    }

    @JsonProperty("minimumPercent")
    public void setMinimumPercent(Double minimumPercent) {
        this.minimumPercent = minimumPercent;
    }

    @JsonIgnore
    public WarmupConfigurationBuilder edit() {
        return new WarmupConfigurationBuilder(this);
    }

    @JsonIgnore
    public WarmupConfigurationBuilder toBuilder() {
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
        if (!(o instanceof WarmupConfiguration)) {
            return false;
        }
        WarmupConfiguration other = (WarmupConfiguration) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$aggression = this.getAggression();
        Object other$aggression = other.getAggression();
        if (this$aggression == null ? other$aggression != null : !this$aggression.equals(other$aggression)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$minimumPercent = this.getMinimumPercent();
        Object other$minimumPercent = other.getMinimumPercent();
        if (this$minimumPercent == null ? other$minimumPercent != null : !this$minimumPercent.equals(other$minimumPercent)) {
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
        return other instanceof WarmupConfiguration;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $aggression = this.getAggression();
        result = result * prime + ($aggression == null ? 43 : $aggression.hashCode());
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $minimumPercent = this.getMinimumPercent();
        result = result * prime + ($minimumPercent == null ? 43 : $minimumPercent.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WarmupConfiguration(" + "aggression=" + this.getAggression() + ", duration=" + this.getDuration() + ", minimumPercent=" + this.getMinimumPercent() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
