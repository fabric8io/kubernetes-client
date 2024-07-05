
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastHeartbeatTime",
    "lastTransitionTime",
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class SubscriptionCondition implements Editable<SubscriptionConditionBuilder> , KubernetesResource
{

    /**
     * last time we got an update on a given condition
     * 
     */
    @JsonProperty("lastHeartbeatTime")
    @JsonPropertyDescription("last time we got an update on a given condition")
    private String lastHeartbeatTime;
    /**
     * last time the condition transit from one status to another
     * 
     */
    @JsonProperty("lastTransitionTime")
    @JsonPropertyDescription("last time the condition transit from one status to another")
    private String lastTransitionTime;
    /**
     * human-readable message indicating details about last transition
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("human-readable message indicating details about last transition")
    private String message;
    /**
     * one-word CamelCase reason for the condition's last transition
     * 
     */
    @JsonProperty("reason")
    @JsonPropertyDescription("one-word CamelCase reason for the condition's last transition")
    private String reason;
    /**
     * status of the condition
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("status of the condition")
    private String status;
    /**
     * type of Subscription condition
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("type of Subscription condition")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubscriptionCondition() {
    }

    /**
     * 
     * @param reason
     *     one-word CamelCase reason for the condition's last transition.
     * @param lastHeartbeatTime
     *     last time we got an update on a given condition.
     * @param lastTransitionTime
     *     last time the condition transit from one status to another.
     * @param message
     *     human-readable message indicating details about last transition.
     * @param type
     *     type of Subscription condition.
     * @param status
     *     status of the condition.
     */
    public SubscriptionCondition(String lastHeartbeatTime, String lastTransitionTime, String message, String reason, String status, String type) {
        super();
        this.lastHeartbeatTime = lastHeartbeatTime;
        this.lastTransitionTime = lastTransitionTime;
        this.message = message;
        this.reason = reason;
        this.status = status;
        this.type = type;
    }

    /**
     * last time we got an update on a given condition
     * 
     */
    @JsonProperty("lastHeartbeatTime")
    public String getLastHeartbeatTime() {
        return lastHeartbeatTime;
    }

    /**
     * last time we got an update on a given condition
     * 
     */
    @JsonProperty("lastHeartbeatTime")
    public void setLastHeartbeatTime(String lastHeartbeatTime) {
        this.lastHeartbeatTime = lastHeartbeatTime;
    }

    /**
     * last time the condition transit from one status to another
     * 
     */
    @JsonProperty("lastTransitionTime")
    public String getLastTransitionTime() {
        return lastTransitionTime;
    }

    /**
     * last time the condition transit from one status to another
     * 
     */
    @JsonProperty("lastTransitionTime")
    public void setLastTransitionTime(String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
    }

    /**
     * human-readable message indicating details about last transition
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * human-readable message indicating details about last transition
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * one-word CamelCase reason for the condition's last transition
     * 
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * one-word CamelCase reason for the condition's last transition
     * 
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * status of the condition
     * 
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * status of the condition
     * 
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * type of Subscription condition
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type of Subscription condition
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public SubscriptionConditionBuilder edit() {
        return new SubscriptionConditionBuilder(this);
    }

    @JsonIgnore
    public SubscriptionConditionBuilder toBuilder() {
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
