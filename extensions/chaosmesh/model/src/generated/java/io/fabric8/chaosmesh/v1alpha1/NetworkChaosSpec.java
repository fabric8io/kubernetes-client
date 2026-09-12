
package io.fabric8.chaosmesh.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * NetworkChaosSpec defines the desired state of NetworkChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "bandwidth",
    "corrupt",
    "delay",
    "device",
    "direction",
    "duplicate",
    "duration",
    "externalTargets",
    "loss",
    "mode",
    "rate",
    "remoteCluster",
    "selector",
    "target",
    "targetDevice",
    "value"
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
public class NetworkChaosSpec implements Editable<NetworkChaosSpecBuilder>, KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("bandwidth")
    private BandwidthSpec bandwidth;
    @JsonProperty("corrupt")
    private CorruptSpec corrupt;
    @JsonProperty("delay")
    private DelaySpec delay;
    @JsonProperty("device")
    private String device;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("duplicate")
    private DuplicateSpec duplicate;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("externalTargets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> externalTargets = new ArrayList<>();
    @JsonProperty("loss")
    private LossSpec loss;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("rate")
    private RateSpec rate;
    @JsonProperty("remoteCluster")
    private String remoteCluster;
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("target")
    private PodSelector target;
    @JsonProperty("targetDevice")
    private String targetDevice;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkChaosSpec() {
    }

    public NetworkChaosSpec(String action, BandwidthSpec bandwidth, CorruptSpec corrupt, DelaySpec delay, String device, String direction, DuplicateSpec duplicate, String duration, List<String> externalTargets, LossSpec loss, String mode, RateSpec rate, String remoteCluster, PodSelectorSpec selector, PodSelector target, String targetDevice, String value) {
        super();
        this.action = action;
        this.bandwidth = bandwidth;
        this.corrupt = corrupt;
        this.delay = delay;
        this.device = device;
        this.direction = direction;
        this.duplicate = duplicate;
        this.duration = duration;
        this.externalTargets = externalTargets;
        this.loss = loss;
        this.mode = mode;
        this.rate = rate;
        this.remoteCluster = remoteCluster;
        this.selector = selector;
        this.target = target;
        this.targetDevice = targetDevice;
        this.value = value;
    }

    /**
     * Action defines the specific network chaos action. Supported action: partition, netem, delay, loss, duplicate, corrupt Default action: delay
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * Action defines the specific network chaos action. Supported action: partition, netem, delay, loss, duplicate, corrupt Default action: delay
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("bandwidth")
    public BandwidthSpec getBandwidth() {
        return bandwidth;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("bandwidth")
    public void setBandwidth(BandwidthSpec bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("corrupt")
    public CorruptSpec getCorrupt() {
        return corrupt;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("corrupt")
    public void setCorrupt(CorruptSpec corrupt) {
        this.corrupt = corrupt;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("delay")
    public DelaySpec getDelay() {
        return delay;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
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
     * Direction represents the direction, this applies on netem and network partition action
     */
    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    /**
     * Direction represents the direction, this applies on netem and network partition action
     */
    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("duplicate")
    public DuplicateSpec getDuplicate() {
        return duplicate;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("duplicate")
    public void setDuplicate(DuplicateSpec duplicate) {
        this.duplicate = duplicate;
    }

    /**
     * Duration represents the duration of the chaos action
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * Duration represents the duration of the chaos action
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * ExternalTargets represents network targets outside k8s
     */
    @JsonProperty("externalTargets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExternalTargets() {
        return externalTargets;
    }

    /**
     * ExternalTargets represents network targets outside k8s
     */
    @JsonProperty("externalTargets")
    public void setExternalTargets(List<String> externalTargets) {
        this.externalTargets = externalTargets;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("loss")
    public LossSpec getLoss() {
        return loss;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("loss")
    public void setLoss(LossSpec loss) {
        this.loss = loss;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("rate")
    public RateSpec getRate() {
        return rate;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("rate")
    public void setRate(RateSpec rate) {
        this.rate = rate;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public void setRemoteCluster(String remoteCluster) {
        this.remoteCluster = remoteCluster;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("selector")
    public PodSelectorSpec getSelector() {
        return selector;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("selector")
    public void setSelector(PodSelectorSpec selector) {
        this.selector = selector;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("target")
    public PodSelector getTarget() {
        return target;
    }

    /**
     * NetworkChaosSpec defines the desired state of NetworkChaos
     */
    @JsonProperty("target")
    public void setTarget(PodSelector target) {
        this.target = target;
    }

    /**
     * TargetDevice represents the network device to be affected in target scope.
     */
    @JsonProperty("targetDevice")
    public String getTargetDevice() {
        return targetDevice;
    }

    /**
     * TargetDevice represents the network device to be affected in target scope.
     */
    @JsonProperty("targetDevice")
    public void setTargetDevice(String targetDevice) {
        this.targetDevice = targetDevice;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of pods to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of pods to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public NetworkChaosSpecBuilder edit() {
        return new NetworkChaosSpecBuilder(this);
    }

    @JsonIgnore
    public NetworkChaosSpecBuilder toBuilder() {
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
        if (!(o instanceof NetworkChaosSpec)) {
            return false;
        }
        NetworkChaosSpec other = (NetworkChaosSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$action = this.getAction();
        Object other$action = other.getAction();
        if (this$action == null ? other$action != null : !this$action.equals(other$action)) {
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
        Object this$direction = this.getDirection();
        Object other$direction = other.getDirection();
        if (this$direction == null ? other$direction != null : !this$direction.equals(other$direction)) {
            return false;
        }
        Object this$duplicate = this.getDuplicate();
        Object other$duplicate = other.getDuplicate();
        if (this$duplicate == null ? other$duplicate != null : !this$duplicate.equals(other$duplicate)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$externalTargets = this.getExternalTargets();
        Object other$externalTargets = other.getExternalTargets();
        if (this$externalTargets == null ? other$externalTargets != null : !this$externalTargets.equals(other$externalTargets)) {
            return false;
        }
        Object this$loss = this.getLoss();
        Object other$loss = other.getLoss();
        if (this$loss == null ? other$loss != null : !this$loss.equals(other$loss)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$rate = this.getRate();
        Object other$rate = other.getRate();
        if (this$rate == null ? other$rate != null : !this$rate.equals(other$rate)) {
            return false;
        }
        Object this$remoteCluster = this.getRemoteCluster();
        Object other$remoteCluster = other.getRemoteCluster();
        if (this$remoteCluster == null ? other$remoteCluster != null : !this$remoteCluster.equals(other$remoteCluster)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$target = this.getTarget();
        Object other$target = other.getTarget();
        if (this$target == null ? other$target != null : !this$target.equals(other$target)) {
            return false;
        }
        Object this$targetDevice = this.getTargetDevice();
        Object other$targetDevice = other.getTargetDevice();
        if (this$targetDevice == null ? other$targetDevice != null : !this$targetDevice.equals(other$targetDevice)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
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
        return other instanceof NetworkChaosSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $action = this.getAction();
        result = result * prime + ($action == null ? 43 : $action.hashCode());
        Object $bandwidth = this.getBandwidth();
        result = result * prime + ($bandwidth == null ? 43 : $bandwidth.hashCode());
        Object $corrupt = this.getCorrupt();
        result = result * prime + ($corrupt == null ? 43 : $corrupt.hashCode());
        Object $delay = this.getDelay();
        result = result * prime + ($delay == null ? 43 : $delay.hashCode());
        Object $device = this.getDevice();
        result = result * prime + ($device == null ? 43 : $device.hashCode());
        Object $direction = this.getDirection();
        result = result * prime + ($direction == null ? 43 : $direction.hashCode());
        Object $duplicate = this.getDuplicate();
        result = result * prime + ($duplicate == null ? 43 : $duplicate.hashCode());
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $externalTargets = this.getExternalTargets();
        result = result * prime + ($externalTargets == null ? 43 : $externalTargets.hashCode());
        Object $loss = this.getLoss();
        result = result * prime + ($loss == null ? 43 : $loss.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $rate = this.getRate();
        result = result * prime + ($rate == null ? 43 : $rate.hashCode());
        Object $remoteCluster = this.getRemoteCluster();
        result = result * prime + ($remoteCluster == null ? 43 : $remoteCluster.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $target = this.getTarget();
        result = result * prime + ($target == null ? 43 : $target.hashCode());
        Object $targetDevice = this.getTargetDevice();
        result = result * prime + ($targetDevice == null ? 43 : $targetDevice.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkChaosSpec(" + "action=" + this.getAction() + ", bandwidth=" + this.getBandwidth() + ", corrupt=" + this.getCorrupt() + ", delay=" + this.getDelay() + ", device=" + this.getDevice() + ", direction=" + this.getDirection() + ", duplicate=" + this.getDuplicate() + ", duration=" + this.getDuration() + ", externalTargets=" + this.getExternalTargets() + ", loss=" + this.getLoss() + ", mode=" + this.getMode() + ", rate=" + this.getRate() + ", remoteCluster=" + this.getRemoteCluster() + ", selector=" + this.getSelector() + ", target=" + this.getTarget() + ", targetDevice=" + this.getTargetDevice() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
