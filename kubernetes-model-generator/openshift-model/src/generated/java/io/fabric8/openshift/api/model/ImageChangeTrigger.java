
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
 * ImageChangeTrigger allows builds to be triggered when an ImageStream changes
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "from",
    "lastTriggeredImageID",
    "paused"
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
public class ImageChangeTrigger implements Editable<ImageChangeTriggerBuilder>, KubernetesResource
{

    @JsonProperty("from")
    private ObjectReference from;
    @JsonProperty("lastTriggeredImageID")
    private String lastTriggeredImageID;
    @JsonProperty("paused")
    private Boolean paused;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageChangeTrigger() {
    }

    public ImageChangeTrigger(ObjectReference from, String lastTriggeredImageID, Boolean paused) {
        super();
        this.from = from;
        this.lastTriggeredImageID = lastTriggeredImageID;
        this.paused = paused;
    }

    /**
     * ImageChangeTrigger allows builds to be triggered when an ImageStream changes
     */
    @JsonProperty("from")
    public ObjectReference getFrom() {
        return from;
    }

    /**
     * ImageChangeTrigger allows builds to be triggered when an ImageStream changes
     */
    @JsonProperty("from")
    public void setFrom(ObjectReference from) {
        this.from = from;
    }

    /**
     * lastTriggeredImageID is used internally by the ImageChangeController to save last used image ID for build This field is deprecated and will be removed in a future release. Deprecated
     */
    @JsonProperty("lastTriggeredImageID")
    public String getLastTriggeredImageID() {
        return lastTriggeredImageID;
    }

    /**
     * lastTriggeredImageID is used internally by the ImageChangeController to save last used image ID for build This field is deprecated and will be removed in a future release. Deprecated
     */
    @JsonProperty("lastTriggeredImageID")
    public void setLastTriggeredImageID(String lastTriggeredImageID) {
        this.lastTriggeredImageID = lastTriggeredImageID;
    }

    /**
     * paused is true if this trigger is temporarily disabled. Optional.
     */
    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    /**
     * paused is true if this trigger is temporarily disabled. Optional.
     */
    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    @JsonIgnore
    public ImageChangeTriggerBuilder edit() {
        return new ImageChangeTriggerBuilder(this);
    }

    @JsonIgnore
    public ImageChangeTriggerBuilder toBuilder() {
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
