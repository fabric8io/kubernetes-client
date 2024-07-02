
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "containerNames",
    "delay",
    "duration",
    "iops",
    "mode",
    "selector",
    "value",
    "volumeName"
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
public class BlockChaosSpec implements Editable<BlockChaosSpecBuilder> , KubernetesResource
{

    @JsonProperty("action")
    private java.lang.String action;
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> containerNames = new ArrayList<java.lang.String>();
    @JsonProperty("delay")
    private BlockDelaySpec delay;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("iops")
    private Integer iops;
    @JsonProperty("mode")
    private java.lang.String mode;
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("value")
    private java.lang.String value;
    @JsonProperty("volumeName")
    private java.lang.String volumeName;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BlockChaosSpec() {
    }

    public BlockChaosSpec(java.lang.String action, List<java.lang.String> containerNames, BlockDelaySpec delay, String duration, Integer iops, java.lang.String mode, PodSelectorSpec selector, java.lang.String value, java.lang.String volumeName) {
        super();
        this.action = action;
        this.containerNames = containerNames;
        this.delay = delay;
        this.duration = duration;
        this.iops = iops;
        this.mode = mode;
        this.selector = selector;
        this.value = value;
        this.volumeName = volumeName;
    }

    @JsonProperty("action")
    public java.lang.String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(java.lang.String action) {
        this.action = action;
    }

    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<java.lang.String> getContainerNames() {
        return containerNames;
    }

    @JsonProperty("containerNames")
    public void setContainerNames(List<java.lang.String> containerNames) {
        this.containerNames = containerNames;
    }

    @JsonProperty("delay")
    public BlockDelaySpec getDelay() {
        return delay;
    }

    @JsonProperty("delay")
    public void setDelay(BlockDelaySpec delay) {
        this.delay = delay;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("iops")
    public Integer getIops() {
        return iops;
    }

    @JsonProperty("iops")
    public void setIops(Integer iops) {
        this.iops = iops;
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

    @JsonProperty("value")
    public java.lang.String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    @JsonProperty("volumeName")
    public java.lang.String getVolumeName() {
        return volumeName;
    }

    @JsonProperty("volumeName")
    public void setVolumeName(java.lang.String volumeName) {
        this.volumeName = volumeName;
    }

    @JsonIgnore
    public BlockChaosSpecBuilder edit() {
        return new BlockChaosSpecBuilder(this);
    }

    @JsonIgnore
    public BlockChaosSpecBuilder toBuilder() {
        return edit();
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
