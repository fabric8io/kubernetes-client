
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
import io.fabric8.kubernetes.api.model.PersistentVolumeSpec;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * VolumeAttachmentSource represents a volume that should be attached. Right now only PersistentVolumes can be attached via external attacher, in the future we may allow also inline volumes in pods. Exactly one member can be set.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "inlineVolumeSpec",
    "persistentVolumeName"
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
public class VolumeAttachmentSource implements Editable<VolumeAttachmentSourceBuilder>, KubernetesResource
{

    @JsonProperty("inlineVolumeSpec")
    private PersistentVolumeSpec inlineVolumeSpec;
    @JsonProperty("persistentVolumeName")
    private String persistentVolumeName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeAttachmentSource() {
    }

    public VolumeAttachmentSource(PersistentVolumeSpec inlineVolumeSpec, String persistentVolumeName) {
        super();
        this.inlineVolumeSpec = inlineVolumeSpec;
        this.persistentVolumeName = persistentVolumeName;
    }

    /**
     * VolumeAttachmentSource represents a volume that should be attached. Right now only PersistentVolumes can be attached via external attacher, in the future we may allow also inline volumes in pods. Exactly one member can be set.
     */
    @JsonProperty("inlineVolumeSpec")
    public PersistentVolumeSpec getInlineVolumeSpec() {
        return inlineVolumeSpec;
    }

    /**
     * VolumeAttachmentSource represents a volume that should be attached. Right now only PersistentVolumes can be attached via external attacher, in the future we may allow also inline volumes in pods. Exactly one member can be set.
     */
    @JsonProperty("inlineVolumeSpec")
    public void setInlineVolumeSpec(PersistentVolumeSpec inlineVolumeSpec) {
        this.inlineVolumeSpec = inlineVolumeSpec;
    }

    /**
     * persistentVolumeName represents the name of the persistent volume to attach.
     */
    @JsonProperty("persistentVolumeName")
    public String getPersistentVolumeName() {
        return persistentVolumeName;
    }

    /**
     * persistentVolumeName represents the name of the persistent volume to attach.
     */
    @JsonProperty("persistentVolumeName")
    public void setPersistentVolumeName(String persistentVolumeName) {
        this.persistentVolumeName = persistentVolumeName;
    }

    @JsonIgnore
    public VolumeAttachmentSourceBuilder edit() {
        return new VolumeAttachmentSourceBuilder(this);
    }

    @JsonIgnore
    public VolumeAttachmentSourceBuilder toBuilder() {
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
        if (!(o instanceof VolumeAttachmentSource)) {
            return false;
        }
        VolumeAttachmentSource other = (VolumeAttachmentSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$inlineVolumeSpec = this.getInlineVolumeSpec();
        Object other$inlineVolumeSpec = other.getInlineVolumeSpec();
        if (this$inlineVolumeSpec == null ? other$inlineVolumeSpec != null : !this$inlineVolumeSpec.equals(other$inlineVolumeSpec)) {
            return false;
        }
        Object this$persistentVolumeName = this.getPersistentVolumeName();
        Object other$persistentVolumeName = other.getPersistentVolumeName();
        if (this$persistentVolumeName == null ? other$persistentVolumeName != null : !this$persistentVolumeName.equals(other$persistentVolumeName)) {
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
        return other instanceof VolumeAttachmentSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $inlineVolumeSpec = this.getInlineVolumeSpec();
        result = result * prime + ($inlineVolumeSpec == null ? 43 : $inlineVolumeSpec.hashCode());
        Object $persistentVolumeName = this.getPersistentVolumeName();
        result = result * prime + ($persistentVolumeName == null ? 43 : $persistentVolumeName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeAttachmentSource(" + "inlineVolumeSpec=" + this.getInlineVolumeSpec() + ", persistentVolumeName=" + this.getPersistentVolumeName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
