
package io.fabric8.chaosmesh.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
    "selector",
    "target",
    "targetDevice",
    "value"
})
@ToString
@EqualsAndHashCode
@Setter
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
@Generated("jsonschema2pojo")
public class NetworkChaosSpec implements KubernetesResource
{

    @JsonProperty("action")
    private java.lang.String action;
    @JsonProperty("bandwidth")
    private BandwidthSpec bandwidth;
    @JsonProperty("corrupt")
    private CorruptSpec corrupt;
    @JsonProperty("delay")
    private DelaySpec delay;
    @JsonProperty("device")
    private java.lang.String device;
    @JsonProperty("direction")
    private java.lang.String direction;
    @JsonProperty("duplicate")
    private DuplicateSpec duplicate;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("externalTargets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> externalTargets = new ArrayList<java.lang.String>();
    @JsonProperty("loss")
    private LossSpec loss;
    @JsonProperty("mode")
    private java.lang.String mode;
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("target")
    private PodSelector target;
    @JsonProperty("targetDevice")
    private java.lang.String targetDevice;
    @JsonProperty("value")
    private java.lang.String value;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkChaosSpec() {
    }

    public NetworkChaosSpec(java.lang.String action, BandwidthSpec bandwidth, CorruptSpec corrupt, DelaySpec delay, java.lang.String device, java.lang.String direction, DuplicateSpec duplicate, String duration, List<java.lang.String> externalTargets, LossSpec loss, java.lang.String mode, PodSelectorSpec selector, PodSelector target, java.lang.String targetDevice, java.lang.String value) {
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
        this.selector = selector;
        this.target = target;
        this.targetDevice = targetDevice;
        this.value = value;
    }

    @JsonProperty("action")
    public java.lang.String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(java.lang.String action) {
        this.action = action;
    }

    @JsonProperty("bandwidth")
    public BandwidthSpec getBandwidth() {
        return bandwidth;
    }

    @JsonProperty("bandwidth")
    public void setBandwidth(BandwidthSpec bandwidth) {
        this.bandwidth = bandwidth;
    }

    @JsonProperty("corrupt")
    public CorruptSpec getCorrupt() {
        return corrupt;
    }

    @JsonProperty("corrupt")
    public void setCorrupt(CorruptSpec corrupt) {
        this.corrupt = corrupt;
    }

    @JsonProperty("delay")
    public DelaySpec getDelay() {
        return delay;
    }

    @JsonProperty("delay")
    public void setDelay(DelaySpec delay) {
        this.delay = delay;
    }

    @JsonProperty("device")
    public java.lang.String getDevice() {
        return device;
    }

    @JsonProperty("device")
    public void setDevice(java.lang.String device) {
        this.device = device;
    }

    @JsonProperty("direction")
    public java.lang.String getDirection() {
        return direction;
    }

    @JsonProperty("direction")
    public void setDirection(java.lang.String direction) {
        this.direction = direction;
    }

    @JsonProperty("duplicate")
    public DuplicateSpec getDuplicate() {
        return duplicate;
    }

    @JsonProperty("duplicate")
    public void setDuplicate(DuplicateSpec duplicate) {
        this.duplicate = duplicate;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("externalTargets")
    public List<java.lang.String> getExternalTargets() {
        return externalTargets;
    }

    @JsonProperty("externalTargets")
    public void setExternalTargets(List<java.lang.String> externalTargets) {
        this.externalTargets = externalTargets;
    }

    @JsonProperty("loss")
    public LossSpec getLoss() {
        return loss;
    }

    @JsonProperty("loss")
    public void setLoss(LossSpec loss) {
        this.loss = loss;
    }

    @JsonProperty("mode")
    public java.lang.String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(java.lang.String mode) {
        this.mode = mode;
    }

    @JsonProperty("selector")
    public PodSelectorSpec getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(PodSelectorSpec selector) {
        this.selector = selector;
    }

    @JsonProperty("target")
    public PodSelector getTarget() {
        return target;
    }

    @JsonProperty("target")
    public void setTarget(PodSelector target) {
        this.target = target;
    }

    @JsonProperty("targetDevice")
    public java.lang.String getTargetDevice() {
        return targetDevice;
    }

    @JsonProperty("targetDevice")
    public void setTargetDevice(java.lang.String targetDevice) {
        this.targetDevice = targetDevice;
    }

    @JsonProperty("value")
    public java.lang.String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
