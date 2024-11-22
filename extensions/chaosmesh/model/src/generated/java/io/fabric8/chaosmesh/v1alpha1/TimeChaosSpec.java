
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clockIds",
    "containerNames",
    "duration",
    "mode",
    "remoteCluster",
    "selector",
    "timeOffset",
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
public class TimeChaosSpec implements Editable<TimeChaosSpecBuilder> , KubernetesResource
{

    @JsonProperty("clockIds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> clockIds = new ArrayList<>();
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> containerNames = new ArrayList<>();
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("remoteCluster")
    private String remoteCluster;
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("timeOffset")
    private String timeOffset;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TimeChaosSpec() {
    }

    public TimeChaosSpec(List<String> clockIds, List<String> containerNames, String duration, String mode, String remoteCluster, PodSelectorSpec selector, String timeOffset, String value) {
        super();
        this.clockIds = clockIds;
        this.containerNames = containerNames;
        this.duration = duration;
        this.mode = mode;
        this.remoteCluster = remoteCluster;
        this.selector = selector;
        this.timeOffset = timeOffset;
        this.value = value;
    }

    @JsonProperty("clockIds")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getClockIds() {
        return clockIds;
    }

    @JsonProperty("clockIds")
    public void setClockIds(List<String> clockIds) {
        this.clockIds = clockIds;
    }

    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getContainerNames() {
        return containerNames;
    }

    @JsonProperty("containerNames")
    public void setContainerNames(List<String> containerNames) {
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
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

    @JsonProperty("remoteCluster")
    public void setRemoteCluster(String remoteCluster) {
        this.remoteCluster = remoteCluster;
    }

    @JsonProperty("selector")
    public PodSelectorSpec getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(PodSelectorSpec selector) {
        this.selector = selector;
    }

    @JsonProperty("timeOffset")
    public String getTimeOffset() {
        return timeOffset;
    }

    @JsonProperty("timeOffset")
    public void setTimeOffset(String timeOffset) {
        this.timeOffset = timeOffset;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public TimeChaosSpecBuilder edit() {
        return new TimeChaosSpecBuilder(this);
    }

    @JsonIgnore
    public TimeChaosSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
