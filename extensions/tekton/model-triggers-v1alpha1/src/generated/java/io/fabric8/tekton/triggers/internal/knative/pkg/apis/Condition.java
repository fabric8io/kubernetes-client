
package io.fabric8.tekton.triggers.internal.knative.pkg.apis;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
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
    "lastTransitionTime",
    "message",
    "reason",
    "severity",
    "status",
    "type"
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
public class Condition implements KubernetesResource
{

    @JsonProperty("lastTransitionTime")
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
     * how to interpret failures of this condition
     * 
     */
    @JsonProperty("severity")
    @JsonPropertyDescription("how to interpret failures of this condition")
    private String severity;
    /**
     * status of the condition
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("status of the condition")
    private String status;
    /**
     * type of status condition
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("type of status condition")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Condition() {
    }

    /**
     * 
     * @param severity
     * @param reason
     * @param lastTransitionTime
     * @param message
     * @param type
     * @param status
     */
    public Condition(String lastTransitionTime, String message, String reason, String severity, String status, String type) {
        super();
        this.lastTransitionTime = lastTransitionTime;
        this.message = message;
        this.reason = reason;
        this.severity = severity;
        this.status = status;
        this.type = type;
    }

    @JsonProperty("lastTransitionTime")
    public String getLastTransitionTime() {
        return lastTransitionTime;
    }

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
     * how to interpret failures of this condition
     * 
     */
    @JsonProperty("severity")
    public String getSeverity() {
        return severity;
    }

    /**
     * how to interpret failures of this condition
     * 
     */
    @JsonProperty("severity")
    public void setSeverity(String severity) {
        this.severity = severity;
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
     * type of status condition
     * 
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type of status condition
     * 
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
