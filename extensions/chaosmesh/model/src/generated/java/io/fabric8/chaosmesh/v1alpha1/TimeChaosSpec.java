
package io.fabric8.chaosmesh.v1alpha1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    "clockIds",
    "containerNames",
    "duration",
    "mode",
    "scheduler",
    "selector",
    "timeOffset",
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
public class TimeChaosSpec implements KubernetesResource
{

    @JsonProperty("clockIds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> clockIds = new ArrayList<java.lang.String>();
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> containerNames = new ArrayList<java.lang.String>();
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("mode")
    private java.lang.String mode;
    @JsonProperty("scheduler")
    private SchedulerSpec scheduler;
    @JsonProperty("selector")
    private SelectorSpec selector;
    @JsonProperty("timeOffset")
    private java.lang.String timeOffset;
    @JsonProperty("value")
    private java.lang.String value;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TimeChaosSpec() {
    }

    /**
     * 
     * @param duration
     * @param mode
     * @param scheduler
     * @param selector
     * @param timeOffset
     * @param value
     * @param clockIds
     * @param containerNames
     */
    public TimeChaosSpec(List<java.lang.String> clockIds, List<java.lang.String> containerNames, String duration, java.lang.String mode, SchedulerSpec scheduler, SelectorSpec selector, java.lang.String timeOffset, java.lang.String value) {
        super();
        this.clockIds = clockIds;
        this.containerNames = containerNames;
        this.duration = duration;
        this.mode = mode;
        this.scheduler = scheduler;
        this.selector = selector;
        this.timeOffset = timeOffset;
        this.value = value;
    }

    @JsonProperty("clockIds")
    public List<java.lang.String> getClockIds() {
        return clockIds;
    }

    @JsonProperty("clockIds")
    public void setClockIds(List<java.lang.String> clockIds) {
        this.clockIds = clockIds;
    }

    @JsonProperty("containerNames")
    public List<java.lang.String> getContainerNames() {
        return containerNames;
    }

    @JsonProperty("containerNames")
    public void setContainerNames(List<java.lang.String> containerNames) {
        this.containerNames = containerNames;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("mode")
    public java.lang.String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(java.lang.String mode) {
        this.mode = mode;
    }

    @JsonProperty("scheduler")
    public SchedulerSpec getScheduler() {
        return scheduler;
    }

    @JsonProperty("scheduler")
    public void setScheduler(SchedulerSpec scheduler) {
        this.scheduler = scheduler;
    }

    @JsonProperty("selector")
    public SelectorSpec getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(SelectorSpec selector) {
        this.selector = selector;
    }

    @JsonProperty("timeOffset")
    public java.lang.String getTimeOffset() {
        return timeOffset;
    }

    @JsonProperty("timeOffset")
    public void setTimeOffset(java.lang.String timeOffset) {
        this.timeOffset = timeOffset;
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
