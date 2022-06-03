
package io.fabric8.openclustermanagement.api.model.multicloudoperatorssubscription.apps.v1;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
    "ansiblejobs",
    "lastUpdateTime",
    "message",
    "phase",
    "reason",
    "statuses"
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
public class SubscriptionStatus implements KubernetesResource
{

    @JsonProperty("ansiblejobs")
    private AnsibleJobsStatus ansiblejobs;
    @JsonProperty("lastUpdateTime")
    private java.lang.String lastUpdateTime;
    @JsonProperty("message")
    private java.lang.String message;
    @JsonProperty("phase")
    private java.lang.String phase;
    @JsonProperty("reason")
    private java.lang.String reason;
    @JsonProperty("statuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, SubscriptionPerClusterStatus> statuses = new LinkedHashMap<String, SubscriptionPerClusterStatus>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubscriptionStatus() {
    }

    /**
     * 
     * @param ansiblejobs
     * @param phase
     * @param reason
     * @param statuses
     * @param message
     * @param lastUpdateTime
     */
    public SubscriptionStatus(AnsibleJobsStatus ansiblejobs, java.lang.String lastUpdateTime, java.lang.String message, java.lang.String phase, java.lang.String reason, Map<String, SubscriptionPerClusterStatus> statuses) {
        super();
        this.ansiblejobs = ansiblejobs;
        this.lastUpdateTime = lastUpdateTime;
        this.message = message;
        this.phase = phase;
        this.reason = reason;
        this.statuses = statuses;
    }

    @JsonProperty("ansiblejobs")
    public AnsibleJobsStatus getAnsiblejobs() {
        return ansiblejobs;
    }

    @JsonProperty("ansiblejobs")
    public void setAnsiblejobs(AnsibleJobsStatus ansiblejobs) {
        this.ansiblejobs = ansiblejobs;
    }

    @JsonProperty("lastUpdateTime")
    public java.lang.String getLastUpdateTime() {
        return lastUpdateTime;
    }

    @JsonProperty("lastUpdateTime")
    public void setLastUpdateTime(java.lang.String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @JsonProperty("message")
    public java.lang.String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    @JsonProperty("phase")
    public java.lang.String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(java.lang.String phase) {
        this.phase = phase;
    }

    @JsonProperty("reason")
    public java.lang.String getReason() {
        return reason;
    }

    @JsonProperty("reason")
    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }

    @JsonProperty("statuses")
    public Map<String, SubscriptionPerClusterStatus> getStatuses() {
        return statuses;
    }

    @JsonProperty("statuses")
    public void setStatuses(Map<String, SubscriptionPerClusterStatus> statuses) {
        this.statuses = statuses;
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
