
package io.fabric8.openshift.api.model;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "from",
    "lastTriggerTime",
    "lastTriggeredImageID"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ImageChangeTriggerStatus implements KubernetesResource
{

    @JsonProperty("from")
    private ImageStreamTagReference from;
    @JsonProperty("lastTriggerTime")
    private String lastTriggerTime;
    @JsonProperty("lastTriggeredImageID")
    private java.lang.String lastTriggeredImageID;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ImageChangeTriggerStatus() {
    }

    public ImageChangeTriggerStatus(ImageStreamTagReference from, String lastTriggerTime, java.lang.String lastTriggeredImageID) {
        super();
        this.from = from;
        this.lastTriggerTime = lastTriggerTime;
        this.lastTriggeredImageID = lastTriggeredImageID;
    }

    @JsonProperty("from")
    public ImageStreamTagReference getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(ImageStreamTagReference from) {
        this.from = from;
    }

    @JsonProperty("lastTriggerTime")
    public String getLastTriggerTime() {
        return lastTriggerTime;
    }

    @JsonProperty("lastTriggerTime")
    public void setLastTriggerTime(String lastTriggerTime) {
        this.lastTriggerTime = lastTriggerTime;
    }

    @JsonProperty("lastTriggeredImageID")
    public java.lang.String getLastTriggeredImageID() {
        return lastTriggeredImageID;
    }

    @JsonProperty("lastTriggeredImageID")
    public void setLastTriggeredImageID(java.lang.String lastTriggeredImageID) {
        this.lastTriggeredImageID = lastTriggeredImageID;
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
