
package io.fabric8.openclustermanagement.api.model.operator.v1;

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
 * StatusCondition contains condition information.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastTransitionTime",
    "lastUpdateTime",
    "message",
    "reason",
    "status",
    "type"
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
public class HubCondition implements Editable<HubConditionBuilder>, KubernetesResource
{

    @JsonProperty("lastTransitionTime")
    private String lastTransitionTime;
    @JsonProperty("lastUpdateTime")
    private String lastUpdateTime;
    @JsonProperty("message")
    private String message;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("status")
    private String status;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HubCondition() {
    }

    public HubCondition(String lastTransitionTime, String lastUpdateTime, String message, String reason, String status, String type) {
        super();
        this.lastTransitionTime = lastTransitionTime;
        this.lastUpdateTime = lastUpdateTime;
        this.message = message;
        this.reason = reason;
        this.status = status;
        this.type = type;
    }

    /**
     * StatusCondition contains condition information.
     */
    @JsonProperty("lastTransitionTime")
    public String getLastTransitionTime() {
        return lastTransitionTime;
    }

    /**
     * StatusCondition contains condition information.
     */
    @JsonProperty("lastTransitionTime")
    public void setLastTransitionTime(String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
    }

    /**
     * StatusCondition contains condition information.
     */
    @JsonProperty("lastUpdateTime")
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * StatusCondition contains condition information.
     */
    @JsonProperty("lastUpdateTime")
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * Message is a human-readable message indicating details about the last status change.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * Message is a human-readable message indicating details about the last status change.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Reason is a (brief) reason for the condition's last status change.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * Reason is a (brief) reason for the condition's last status change.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * Status is the status of the condition. One of True, False, Unknown.
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * Status is the status of the condition. One of True, False, Unknown.
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Type is the type of the cluster condition.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type is the type of the cluster condition.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public HubConditionBuilder edit() {
        return new HubConditionBuilder(this);
    }

    @JsonIgnore
    public HubConditionBuilder toBuilder() {
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
