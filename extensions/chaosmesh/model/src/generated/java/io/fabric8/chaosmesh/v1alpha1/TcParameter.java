
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
 * TcParameter represents the parameters for a traffic control chaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bandwidth",
    "corrupt",
    "delay",
    "duplicate",
    "loss",
    "rate"
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
public class TcParameter implements Editable<TcParameterBuilder>, KubernetesResource
{

    @JsonProperty("bandwidth")
    private BandwidthSpec bandwidth;
    @JsonProperty("corrupt")
    private CorruptSpec corrupt;
    @JsonProperty("delay")
    private DelaySpec delay;
    @JsonProperty("duplicate")
    private DuplicateSpec duplicate;
    @JsonProperty("loss")
    private LossSpec loss;
    @JsonProperty("rate")
    private RateSpec rate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TcParameter() {
    }

    public TcParameter(BandwidthSpec bandwidth, CorruptSpec corrupt, DelaySpec delay, DuplicateSpec duplicate, LossSpec loss, RateSpec rate) {
        super();
        this.bandwidth = bandwidth;
        this.corrupt = corrupt;
        this.delay = delay;
        this.duplicate = duplicate;
        this.loss = loss;
        this.rate = rate;
    }

    /**
     * TcParameter represents the parameters for a traffic control chaos
     */
    @JsonProperty("bandwidth")
    public BandwidthSpec getBandwidth() {
        return bandwidth;
    }

    /**
     * TcParameter represents the parameters for a traffic control chaos
     */
    @JsonProperty("bandwidth")
    public void setBandwidth(BandwidthSpec bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * TcParameter represents the parameters for a traffic control chaos
     */
    @JsonProperty("corrupt")
    public CorruptSpec getCorrupt() {
        return corrupt;
    }

    /**
     * TcParameter represents the parameters for a traffic control chaos
     */
    @JsonProperty("corrupt")
    public void setCorrupt(CorruptSpec corrupt) {
        this.corrupt = corrupt;
    }

    /**
     * TcParameter represents the parameters for a traffic control chaos
     */
    @JsonProperty("delay")
    public DelaySpec getDelay() {
        return delay;
    }

    /**
     * TcParameter represents the parameters for a traffic control chaos
     */
    @JsonProperty("delay")
    public void setDelay(DelaySpec delay) {
        this.delay = delay;
    }

    /**
     * TcParameter represents the parameters for a traffic control chaos
     */
    @JsonProperty("duplicate")
    public DuplicateSpec getDuplicate() {
        return duplicate;
    }

    /**
     * TcParameter represents the parameters for a traffic control chaos
     */
    @JsonProperty("duplicate")
    public void setDuplicate(DuplicateSpec duplicate) {
        this.duplicate = duplicate;
    }

    /**
     * TcParameter represents the parameters for a traffic control chaos
     */
    @JsonProperty("loss")
    public LossSpec getLoss() {
        return loss;
    }

    /**
     * TcParameter represents the parameters for a traffic control chaos
     */
    @JsonProperty("loss")
    public void setLoss(LossSpec loss) {
        this.loss = loss;
    }

    /**
     * TcParameter represents the parameters for a traffic control chaos
     */
    @JsonProperty("rate")
    public RateSpec getRate() {
        return rate;
    }

    /**
     * TcParameter represents the parameters for a traffic control chaos
     */
    @JsonProperty("rate")
    public void setRate(RateSpec rate) {
        this.rate = rate;
    }

    @JsonIgnore
    public TcParameterBuilder edit() {
        return new TcParameterBuilder(this);
    }

    @JsonIgnore
    public TcParameterBuilder toBuilder() {
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
        if (!(o instanceof TcParameter)) {
            return false;
        }
        TcParameter other = (TcParameter) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bandwidth = this.getBandwidth();
        Object other$bandwidth = other.getBandwidth();
        if (this$bandwidth == null ? other$bandwidth != null : !this$bandwidth.equals(other$bandwidth)) {
            return false;
        }
        Object this$corrupt = this.getCorrupt();
        Object other$corrupt = other.getCorrupt();
        if (this$corrupt == null ? other$corrupt != null : !this$corrupt.equals(other$corrupt)) {
            return false;
        }
        Object this$delay = this.getDelay();
        Object other$delay = other.getDelay();
        if (this$delay == null ? other$delay != null : !this$delay.equals(other$delay)) {
            return false;
        }
        Object this$duplicate = this.getDuplicate();
        Object other$duplicate = other.getDuplicate();
        if (this$duplicate == null ? other$duplicate != null : !this$duplicate.equals(other$duplicate)) {
            return false;
        }
        Object this$loss = this.getLoss();
        Object other$loss = other.getLoss();
        if (this$loss == null ? other$loss != null : !this$loss.equals(other$loss)) {
            return false;
        }
        Object this$rate = this.getRate();
        Object other$rate = other.getRate();
        if (this$rate == null ? other$rate != null : !this$rate.equals(other$rate)) {
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
        return other instanceof TcParameter;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bandwidth = this.getBandwidth();
        result = result * prime + ($bandwidth == null ? 43 : $bandwidth.hashCode());
        Object $corrupt = this.getCorrupt();
        result = result * prime + ($corrupt == null ? 43 : $corrupt.hashCode());
        Object $delay = this.getDelay();
        result = result * prime + ($delay == null ? 43 : $delay.hashCode());
        Object $duplicate = this.getDuplicate();
        result = result * prime + ($duplicate == null ? 43 : $duplicate.hashCode());
        Object $loss = this.getLoss();
        result = result * prime + ($loss == null ? 43 : $loss.hashCode());
        Object $rate = this.getRate();
        result = result * prime + ($rate == null ? 43 : $rate.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TcParameter(" + "bandwidth=" + this.getBandwidth() + ", corrupt=" + this.getCorrupt() + ", delay=" + this.getDelay() + ", duplicate=" + this.getDuplicate() + ", loss=" + this.getLoss() + ", rate=" + this.getRate() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
