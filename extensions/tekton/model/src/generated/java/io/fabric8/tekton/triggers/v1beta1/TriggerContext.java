
package io.fabric8.tekton.triggers.v1beta1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "event_id",
    "event_url",
    "trigger_id"
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
public class TriggerContext implements Editable<TriggerContextBuilder>, KubernetesResource
{

    @JsonProperty("event_id")
    private String eventId;
    @JsonProperty("event_url")
    private String eventUrl;
    @JsonProperty("trigger_id")
    private String triggerId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TriggerContext() {
    }

    public TriggerContext(String eventId, String eventUrl, String triggerId) {
        super();
        this.eventId = eventId;
        this.eventUrl = eventUrl;
        this.triggerId = triggerId;
    }

    /**
     * EventID is a unique ID assigned by Triggers to each event
     */
    @JsonProperty("event_id")
    public String getEventId() {
        return eventId;
    }

    /**
     * EventID is a unique ID assigned by Triggers to each event
     */
    @JsonProperty("event_id")
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /**
     * EventURL is the URL of the incoming event
     */
    @JsonProperty("event_url")
    public String getEventUrl() {
        return eventUrl;
    }

    /**
     * EventURL is the URL of the incoming event
     */
    @JsonProperty("event_url")
    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    /**
     * TriggerID is of the form namespace/$ns/triggers/$name
     */
    @JsonProperty("trigger_id")
    public String getTriggerId() {
        return triggerId;
    }

    /**
     * TriggerID is of the form namespace/$ns/triggers/$name
     */
    @JsonProperty("trigger_id")
    public void setTriggerId(String triggerId) {
        this.triggerId = triggerId;
    }

    @JsonIgnore
    public TriggerContextBuilder edit() {
        return new TriggerContextBuilder(this);
    }

    @JsonIgnore
    public TriggerContextBuilder toBuilder() {
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
        if (!(o instanceof TriggerContext)) {
            return false;
        }
        TriggerContext other = (TriggerContext) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$eventId = this.getEventId();
        Object other$eventId = other.getEventId();
        if (this$eventId == null ? other$eventId != null : !this$eventId.equals(other$eventId)) {
            return false;
        }
        Object this$eventUrl = this.getEventUrl();
        Object other$eventUrl = other.getEventUrl();
        if (this$eventUrl == null ? other$eventUrl != null : !this$eventUrl.equals(other$eventUrl)) {
            return false;
        }
        Object this$triggerId = this.getTriggerId();
        Object other$triggerId = other.getTriggerId();
        if (this$triggerId == null ? other$triggerId != null : !this$triggerId.equals(other$triggerId)) {
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
        return other instanceof TriggerContext;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $eventId = this.getEventId();
        result = result * prime + ($eventId == null ? 43 : $eventId.hashCode());
        Object $eventUrl = this.getEventUrl();
        result = result * prime + ($eventUrl == null ? 43 : $eventUrl.hashCode());
        Object $triggerId = this.getTriggerId();
        result = result * prime + ($triggerId == null ? 43 : $triggerId.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TriggerContext(" + "eventId=" + this.getEventId() + ", eventUrl=" + this.getEventUrl() + ", triggerId=" + this.getTriggerId() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
