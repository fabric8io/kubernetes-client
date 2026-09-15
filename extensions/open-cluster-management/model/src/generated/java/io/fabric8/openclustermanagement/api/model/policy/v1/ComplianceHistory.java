
package io.fabric8.openclustermanagement.api.model.policy.v1;

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

/**
 * ComplianceHistory reports a compliance message from a given time and event.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "eventName",
    "lastTimestamp",
    "message"
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
public class ComplianceHistory implements Editable<ComplianceHistoryBuilder>, KubernetesResource
{

    @JsonProperty("eventName")
    private String eventName;
    @JsonProperty("lastTimestamp")
    private String lastTimestamp;
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ComplianceHistory() {
    }

    public ComplianceHistory(String eventName, String lastTimestamp, String message) {
        super();
        this.eventName = eventName;
        this.lastTimestamp = lastTimestamp;
        this.message = message;
    }

    /**
     * EventName is the name of the event attached to the message.
     */
    @JsonProperty("eventName")
    public String getEventName() {
        return eventName;
    }

    /**
     * EventName is the name of the event attached to the message.
     */
    @JsonProperty("eventName")
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * ComplianceHistory reports a compliance message from a given time and event.
     */
    @JsonProperty("lastTimestamp")
    public String getLastTimestamp() {
        return lastTimestamp;
    }

    /**
     * ComplianceHistory reports a compliance message from a given time and event.
     */
    @JsonProperty("lastTimestamp")
    public void setLastTimestamp(String lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    /**
     * Message is the compliance message resulting from evaluating the policy resource.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Message is the compliance message resulting from evaluating the policy resource.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    public ComplianceHistoryBuilder edit() {
        return new ComplianceHistoryBuilder(this);
    }

    @JsonIgnore
    public ComplianceHistoryBuilder toBuilder() {
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
        if (!(o instanceof ComplianceHistory)) {
            return false;
        }
        ComplianceHistory other = (ComplianceHistory) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$eventName = this.getEventName();
        Object other$eventName = other.getEventName();
        if (this$eventName == null ? other$eventName != null : !this$eventName.equals(other$eventName)) {
            return false;
        }
        Object this$lastTimestamp = this.getLastTimestamp();
        Object other$lastTimestamp = other.getLastTimestamp();
        if (this$lastTimestamp == null ? other$lastTimestamp != null : !this$lastTimestamp.equals(other$lastTimestamp)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
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
        return other instanceof ComplianceHistory;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $eventName = this.getEventName();
        result = result * prime + ($eventName == null ? 43 : $eventName.hashCode());
        Object $lastTimestamp = this.getLastTimestamp();
        result = result * prime + ($lastTimestamp == null ? 43 : $lastTimestamp.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ComplianceHistory(" + "eventName=" + this.getEventName() + ", lastTimestamp=" + this.getLastTimestamp() + ", message=" + this.getMessage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
