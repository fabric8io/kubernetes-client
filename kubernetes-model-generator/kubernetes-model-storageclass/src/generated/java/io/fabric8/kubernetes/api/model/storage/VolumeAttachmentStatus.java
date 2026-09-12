
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

/**
 * VolumeAttachmentStatus is the status of a VolumeAttachment request.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attachError",
    "attached",
    "attachmentMetadata",
    "detachError"
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
public class VolumeAttachmentStatus implements Editable<VolumeAttachmentStatusBuilder>, KubernetesResource
{

    @JsonProperty("attachError")
    private VolumeError attachError;
    @JsonProperty("attached")
    private Boolean attached;
    @JsonProperty("attachmentMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> attachmentMetadata = new LinkedHashMap<>();
    @JsonProperty("detachError")
    private VolumeError detachError;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeAttachmentStatus() {
    }

    public VolumeAttachmentStatus(VolumeError attachError, Boolean attached, Map<String, String> attachmentMetadata, VolumeError detachError) {
        super();
        this.attachError = attachError;
        this.attached = attached;
        this.attachmentMetadata = attachmentMetadata;
        this.detachError = detachError;
    }

    /**
     * VolumeAttachmentStatus is the status of a VolumeAttachment request.
     */
    @JsonProperty("attachError")
    public VolumeError getAttachError() {
        return attachError;
    }

    /**
     * VolumeAttachmentStatus is the status of a VolumeAttachment request.
     */
    @JsonProperty("attachError")
    public void setAttachError(VolumeError attachError) {
        this.attachError = attachError;
    }

    /**
     * attached indicates the volume is successfully attached. This field must only be set by the entity completing the attach operation, i.e. the external-attacher.
     */
    @JsonProperty("attached")
    public Boolean getAttached() {
        return attached;
    }

    /**
     * attached indicates the volume is successfully attached. This field must only be set by the entity completing the attach operation, i.e. the external-attacher.
     */
    @JsonProperty("attached")
    public void setAttached(Boolean attached) {
        this.attached = attached;
    }

    /**
     * attachmentMetadata is populated with any information returned by the attach operation, upon successful attach, that must be passed into subsequent WaitForAttach or Mount calls. This field must only be set by the entity completing the attach operation, i.e. the external-attacher.
     */
    @JsonProperty("attachmentMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAttachmentMetadata() {
        return attachmentMetadata;
    }

    /**
     * attachmentMetadata is populated with any information returned by the attach operation, upon successful attach, that must be passed into subsequent WaitForAttach or Mount calls. This field must only be set by the entity completing the attach operation, i.e. the external-attacher.
     */
    @JsonProperty("attachmentMetadata")
    public void setAttachmentMetadata(Map<String, String> attachmentMetadata) {
        this.attachmentMetadata = attachmentMetadata;
    }

    /**
     * VolumeAttachmentStatus is the status of a VolumeAttachment request.
     */
    @JsonProperty("detachError")
    public VolumeError getDetachError() {
        return detachError;
    }

    /**
     * VolumeAttachmentStatus is the status of a VolumeAttachment request.
     */
    @JsonProperty("detachError")
    public void setDetachError(VolumeError detachError) {
        this.detachError = detachError;
    }

    @JsonIgnore
    public VolumeAttachmentStatusBuilder edit() {
        return new VolumeAttachmentStatusBuilder(this);
    }

    @JsonIgnore
    public VolumeAttachmentStatusBuilder toBuilder() {
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
        if (!(o instanceof VolumeAttachmentStatus)) {
            return false;
        }
        VolumeAttachmentStatus other = (VolumeAttachmentStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$attachError = this.getAttachError();
        Object other$attachError = other.getAttachError();
        if (this$attachError == null ? other$attachError != null : !this$attachError.equals(other$attachError)) {
            return false;
        }
        Object this$attached = this.getAttached();
        Object other$attached = other.getAttached();
        if (this$attached == null ? other$attached != null : !this$attached.equals(other$attached)) {
            return false;
        }
        Object this$attachmentMetadata = this.getAttachmentMetadata();
        Object other$attachmentMetadata = other.getAttachmentMetadata();
        if (this$attachmentMetadata == null ? other$attachmentMetadata != null : !this$attachmentMetadata.equals(other$attachmentMetadata)) {
            return false;
        }
        Object this$detachError = this.getDetachError();
        Object other$detachError = other.getDetachError();
        if (this$detachError == null ? other$detachError != null : !this$detachError.equals(other$detachError)) {
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
        return other instanceof VolumeAttachmentStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $attachError = this.getAttachError();
        result = result * prime + ($attachError == null ? 43 : $attachError.hashCode());
        Object $attached = this.getAttached();
        result = result * prime + ($attached == null ? 43 : $attached.hashCode());
        Object $attachmentMetadata = this.getAttachmentMetadata();
        result = result * prime + ($attachmentMetadata == null ? 43 : $attachmentMetadata.hashCode());
        Object $detachError = this.getDetachError();
        result = result * prime + ($detachError == null ? 43 : $detachError.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeAttachmentStatus(" + "attachError=" + this.getAttachError() + ", attached=" + this.getAttached() + ", attachmentMetadata=" + this.getAttachmentMetadata() + ", detachError=" + this.getDetachError() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
