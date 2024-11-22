
package io.fabric8.kubernetes.api.model.storage.v1beta1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attachError",
    "attached",
    "attachmentMetadata",
    "detachError"
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
public class VolumeAttachmentStatus implements Editable<VolumeAttachmentStatusBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("attachError")
    public VolumeError getAttachError() {
        return attachError;
    }

    @JsonProperty("attachError")
    public void setAttachError(VolumeError attachError) {
        this.attachError = attachError;
    }

    @JsonProperty("attached")
    public Boolean getAttached() {
        return attached;
    }

    @JsonProperty("attached")
    public void setAttached(Boolean attached) {
        this.attached = attached;
    }

    @JsonProperty("attachmentMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAttachmentMetadata() {
        return attachmentMetadata;
    }

    @JsonProperty("attachmentMetadata")
    public void setAttachmentMetadata(Map<String, String> attachmentMetadata) {
        this.attachmentMetadata = attachmentMetadata;
    }

    @JsonProperty("detachError")
    public VolumeError getDetachError() {
        return detachError;
    }

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
