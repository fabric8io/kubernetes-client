
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
 * RawTrafficControl represents the traffic control chaos on specific pod
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bandwidth",
    "corrupt",
    "delay",
    "device",
    "duplicate",
    "ipset",
    "loss",
    "rate",
    "source",
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
public class RawTrafficControl implements Editable<RawTrafficControlBuilder>, KubernetesResource
{

    @JsonProperty("bandwidth")
    private BandwidthSpec bandwidth;
    @JsonProperty("corrupt")
    private CorruptSpec corrupt;
    @JsonProperty("delay")
    private DelaySpec delay;
    @JsonProperty("device")
    private String device;
    @JsonProperty("duplicate")
    private DuplicateSpec duplicate;
    @JsonProperty("ipset")
    private String ipset;
    @JsonProperty("loss")
    private LossSpec loss;
    @JsonProperty("rate")
    private RateSpec rate;
    @JsonProperty("source")
    private String source;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RawTrafficControl() {
    }

    public RawTrafficControl(BandwidthSpec bandwidth, CorruptSpec corrupt, DelaySpec delay, String device, DuplicateSpec duplicate, String ipset, LossSpec loss, RateSpec rate, String source, String type) {
        super();
        this.bandwidth = bandwidth;
        this.corrupt = corrupt;
        this.delay = delay;
        this.device = device;
        this.duplicate = duplicate;
        this.ipset = ipset;
        this.loss = loss;
        this.rate = rate;
        this.source = source;
        this.type = type;
    }

    /**
     * RawTrafficControl represents the traffic control chaos on specific pod
     */
    @JsonProperty("bandwidth")
    public BandwidthSpec getBandwidth() {
        return bandwidth;
    }

    /**
     * RawTrafficControl represents the traffic control chaos on specific pod
     */
    @JsonProperty("bandwidth")
    public void setBandwidth(BandwidthSpec bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * RawTrafficControl represents the traffic control chaos on specific pod
     */
    @JsonProperty("corrupt")
    public CorruptSpec getCorrupt() {
        return corrupt;
    }

    /**
     * RawTrafficControl represents the traffic control chaos on specific pod
     */
    @JsonProperty("corrupt")
    public void setCorrupt(CorruptSpec corrupt) {
        this.corrupt = corrupt;
    }

    /**
     * RawTrafficControl represents the traffic control chaos on specific pod
     */
    @JsonProperty("delay")
    public DelaySpec getDelay() {
        return delay;
    }

    /**
     * RawTrafficControl represents the traffic control chaos on specific pod
     */
    @JsonProperty("delay")
    public void setDelay(DelaySpec delay) {
        this.delay = delay;
    }

    /**
     * Device represents the network device to be affected.
     */
    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    /**
     * Device represents the network device to be affected.
     */
    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * RawTrafficControl represents the traffic control chaos on specific pod
     */
    @JsonProperty("duplicate")
    public DuplicateSpec getDuplicate() {
        return duplicate;
    }

    /**
     * RawTrafficControl represents the traffic control chaos on specific pod
     */
    @JsonProperty("duplicate")
    public void setDuplicate(DuplicateSpec duplicate) {
        this.duplicate = duplicate;
    }

    /**
     * The name of target ipset
     */
    @JsonProperty("ipset")
    public String getIpset() {
        return ipset;
    }

    /**
     * The name of target ipset
     */
    @JsonProperty("ipset")
    public void setIpset(String ipset) {
        this.ipset = ipset;
    }

    /**
     * RawTrafficControl represents the traffic control chaos on specific pod
     */
    @JsonProperty("loss")
    public LossSpec getLoss() {
        return loss;
    }

    /**
     * RawTrafficControl represents the traffic control chaos on specific pod
     */
    @JsonProperty("loss")
    public void setLoss(LossSpec loss) {
        this.loss = loss;
    }

    /**
     * RawTrafficControl represents the traffic control chaos on specific pod
     */
    @JsonProperty("rate")
    public RateSpec getRate() {
        return rate;
    }

    /**
     * RawTrafficControl represents the traffic control chaos on specific pod
     */
    @JsonProperty("rate")
    public void setRate(RateSpec rate) {
        this.rate = rate;
    }

    /**
     * The name and namespace of the source network chaos
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * The name and namespace of the source network chaos
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * The type of traffic control
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * The type of traffic control
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public RawTrafficControlBuilder edit() {
        return new RawTrafficControlBuilder(this);
    }

    @JsonIgnore
    public RawTrafficControlBuilder toBuilder() {
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
        if (!(o instanceof RawTrafficControl)) {
            return false;
        }
        RawTrafficControl other = (RawTrafficControl) o;
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
        Object this$device = this.getDevice();
        Object other$device = other.getDevice();
        if (this$device == null ? other$device != null : !this$device.equals(other$device)) {
            return false;
        }
        Object this$duplicate = this.getDuplicate();
        Object other$duplicate = other.getDuplicate();
        if (this$duplicate == null ? other$duplicate != null : !this$duplicate.equals(other$duplicate)) {
            return false;
        }
        Object this$ipset = this.getIpset();
        Object other$ipset = other.getIpset();
        if (this$ipset == null ? other$ipset != null : !this$ipset.equals(other$ipset)) {
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
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
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
        return other instanceof RawTrafficControl;
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
        Object $device = this.getDevice();
        result = result * prime + ($device == null ? 43 : $device.hashCode());
        Object $duplicate = this.getDuplicate();
        result = result * prime + ($duplicate == null ? 43 : $duplicate.hashCode());
        Object $ipset = this.getIpset();
        result = result * prime + ($ipset == null ? 43 : $ipset.hashCode());
        Object $loss = this.getLoss();
        result = result * prime + ($loss == null ? 43 : $loss.hashCode());
        Object $rate = this.getRate();
        result = result * prime + ($rate == null ? 43 : $rate.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RawTrafficControl(" + "bandwidth=" + this.getBandwidth() + ", corrupt=" + this.getCorrupt() + ", delay=" + this.getDelay() + ", device=" + this.getDevice() + ", duplicate=" + this.getDuplicate() + ", ipset=" + this.getIpset() + ", loss=" + this.getLoss() + ", rate=" + this.getRate() + ", source=" + this.getSource() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
