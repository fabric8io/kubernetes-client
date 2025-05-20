
package io.fabric8.openshift.api.model;

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
 * ImageChangeTriggerStatus tracks the latest resolved status of the associated ImageChangeTrigger policy specified in the BuildConfigSpec.Triggers struct.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "from",
    "lastTriggerTime",
    "lastTriggeredImageID"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageChangeTriggerStatus implements Editable<ImageChangeTriggerStatusBuilder>, KubernetesResource
{

    @JsonProperty("from")
    private ImageStreamTagReference from;
    @JsonProperty("lastTriggerTime")
    private String lastTriggerTime;
    @JsonProperty("lastTriggeredImageID")
    private String lastTriggeredImageID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageChangeTriggerStatus() {
    }

    public ImageChangeTriggerStatus(ImageStreamTagReference from, String lastTriggerTime, String lastTriggeredImageID) {
        super();
        this.from = from;
        this.lastTriggerTime = lastTriggerTime;
        this.lastTriggeredImageID = lastTriggeredImageID;
    }

    /**
     * ImageChangeTriggerStatus tracks the latest resolved status of the associated ImageChangeTrigger policy specified in the BuildConfigSpec.Triggers struct.
     */
    @JsonProperty("from")
    public ImageStreamTagReference getFrom() {
        return from;
    }

    /**
     * ImageChangeTriggerStatus tracks the latest resolved status of the associated ImageChangeTrigger policy specified in the BuildConfigSpec.Triggers struct.
     */
    @JsonProperty("from")
    public void setFrom(ImageStreamTagReference from) {
        this.from = from;
    }

    /**
     * ImageChangeTriggerStatus tracks the latest resolved status of the associated ImageChangeTrigger policy specified in the BuildConfigSpec.Triggers struct.
     */
    @JsonProperty("lastTriggerTime")
    public String getLastTriggerTime() {
        return lastTriggerTime;
    }

    /**
     * ImageChangeTriggerStatus tracks the latest resolved status of the associated ImageChangeTrigger policy specified in the BuildConfigSpec.Triggers struct.
     */
    @JsonProperty("lastTriggerTime")
    public void setLastTriggerTime(String lastTriggerTime) {
        this.lastTriggerTime = lastTriggerTime;
    }

    /**
     * lastTriggeredImageID represents the sha/id of the ImageStreamTag when a Build for this BuildConfig was started. The lastTriggeredImageID is updated each time a Build for this BuildConfig is started, even if this ImageStreamTag is not the reason the Build is started.
     */
    @JsonProperty("lastTriggeredImageID")
    public String getLastTriggeredImageID() {
        return lastTriggeredImageID;
    }

    /**
     * lastTriggeredImageID represents the sha/id of the ImageStreamTag when a Build for this BuildConfig was started. The lastTriggeredImageID is updated each time a Build for this BuildConfig is started, even if this ImageStreamTag is not the reason the Build is started.
     */
    @JsonProperty("lastTriggeredImageID")
    public void setLastTriggeredImageID(String lastTriggeredImageID) {
        this.lastTriggeredImageID = lastTriggeredImageID;
    }

    @JsonIgnore
    public ImageChangeTriggerStatusBuilder edit() {
        return new ImageChangeTriggerStatusBuilder(this);
    }

    @JsonIgnore
    public ImageChangeTriggerStatusBuilder toBuilder() {
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
