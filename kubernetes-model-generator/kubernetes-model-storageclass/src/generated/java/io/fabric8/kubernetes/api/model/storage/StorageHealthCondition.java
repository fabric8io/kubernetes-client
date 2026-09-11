
package io.fabric8.kubernetes.api.model.storage;

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
 * StorageHealthCondition represents an adverse health condition reported by a CSI driver for its storage backend on a node.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessMode",
    "lastTransitionTime",
    "message",
    "reason",
    "status",
    "volumeMode"
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
public class StorageHealthCondition implements Editable<StorageHealthConditionBuilder>, KubernetesResource
{

    @JsonProperty("accessMode")
    private String accessMode;
    @JsonProperty("lastTransitionTime")
    private String lastTransitionTime;
    @JsonProperty("message")
    private String message;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("status")
    private String status;
    @JsonProperty("volumeMode")
    private String volumeMode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StorageHealthCondition() {
    }

    public StorageHealthCondition(String accessMode, String lastTransitionTime, String message, String reason, String status, String volumeMode) {
        super();
        this.accessMode = accessMode;
        this.lastTransitionTime = lastTransitionTime;
        this.message = message;
        this.reason = reason;
        this.status = status;
        this.volumeMode = volumeMode;
    }

    /**
     * accessMode is the access mode affected. Nil means all access modes are affected.
     */
    @JsonProperty("accessMode")
    public String getAccessMode() {
        return accessMode;
    }

    /**
     * accessMode is the access mode affected. Nil means all access modes are affected.
     */
    @JsonProperty("accessMode")
    public void setAccessMode(String accessMode) {
        this.accessMode = accessMode;
    }

    /**
     * StorageHealthCondition represents an adverse health condition reported by a CSI driver for its storage backend on a node.
     */
    @JsonProperty("lastTransitionTime")
    public String getLastTransitionTime() {
        return lastTransitionTime;
    }

    /**
     * StorageHealthCondition represents an adverse health condition reported by a CSI driver for its storage backend on a node.
     */
    @JsonProperty("lastTransitionTime")
    public void setLastTransitionTime(String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
    }

    /**
     * message is a human-readable description. Maximum permitted length of a message is 1024 characters.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message is a human-readable description. Maximum permitted length of a message is 1024 characters.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * reason is a brief CamelCase machine-parseable reason. Maximum permitted length of a reason is 256 characters.
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     * reason is a brief CamelCase machine-parseable reason. Maximum permitted length of a reason is 256 characters.
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * status is the health status category. One of "StorageUnreachable", "StorageDegraded".
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * status is the health status category. One of "StorageUnreachable", "StorageDegraded".
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * volumeMode is the volume mode affected. Nil means both are affected.
     */
    @JsonProperty("volumeMode")
    public String getVolumeMode() {
        return volumeMode;
    }

    /**
     * volumeMode is the volume mode affected. Nil means both are affected.
     */
    @JsonProperty("volumeMode")
    public void setVolumeMode(String volumeMode) {
        this.volumeMode = volumeMode;
    }

    @JsonIgnore
    public StorageHealthConditionBuilder edit() {
        return new StorageHealthConditionBuilder(this);
    }

    @JsonIgnore
    public StorageHealthConditionBuilder toBuilder() {
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
