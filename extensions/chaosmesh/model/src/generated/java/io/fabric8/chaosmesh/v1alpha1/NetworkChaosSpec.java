
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
