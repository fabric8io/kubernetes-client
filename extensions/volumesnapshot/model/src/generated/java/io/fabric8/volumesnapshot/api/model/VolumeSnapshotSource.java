
package io.fabric8.volumesnapshot.api.model;

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
 * VolumeSnapshotSource specifies whether the underlying snapshot should be dynamically taken upon creation or if a pre-existing VolumeSnapshotContent object should be used. Exactly one of its members must be set. Members in VolumeSnapshotSource are immutable.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "persistentVolumeClaimName",
    "volumeSnapshotContentName"
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
public class VolumeSnapshotSource implements Editable<VolumeSnapshotSourceBuilder>, KubernetesResource
{

    @JsonProperty("persistentVolumeClaimName")
    private String persistentVolumeClaimName;
    @JsonProperty("volumeSnapshotContentName")
    private String volumeSnapshotContentName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeSnapshotSource() {
    }

    public VolumeSnapshotSource(String persistentVolumeClaimName, String volumeSnapshotContentName) {
        super();
        this.persistentVolumeClaimName = persistentVolumeClaimName;
        this.volumeSnapshotContentName = volumeSnapshotContentName;
    }

    /**
     * persistentVolumeClaimName specifies the name of the PersistentVolumeClaim object representing the volume from which a snapshot should be created. This PVC is assumed to be in the same namespace as the VolumeSnapshot object. This field should be set if the snapshot does not exists, and needs to be created. This field is immutable.
     */
    @JsonProperty("persistentVolumeClaimName")
    public String getPersistentVolumeClaimName() {
        return persistentVolumeClaimName;
    }

    /**
     * persistentVolumeClaimName specifies the name of the PersistentVolumeClaim object representing the volume from which a snapshot should be created. This PVC is assumed to be in the same namespace as the VolumeSnapshot object. This field should be set if the snapshot does not exists, and needs to be created. This field is immutable.
     */
    @JsonProperty("persistentVolumeClaimName")
    public void setPersistentVolumeClaimName(String persistentVolumeClaimName) {
        this.persistentVolumeClaimName = persistentVolumeClaimName;
    }

    /**
     * volumeSnapshotContentName specifies the name of a pre-existing VolumeSnapshotContent object representing an existing volume snapshot. This field should be set if the snapshot already exists and only needs a representation in Kubernetes. This field is immutable.
     */
    @JsonProperty("volumeSnapshotContentName")
    public String getVolumeSnapshotContentName() {
        return volumeSnapshotContentName;
    }

    /**
     * volumeSnapshotContentName specifies the name of a pre-existing VolumeSnapshotContent object representing an existing volume snapshot. This field should be set if the snapshot already exists and only needs a representation in Kubernetes. This field is immutable.
     */
    @JsonProperty("volumeSnapshotContentName")
    public void setVolumeSnapshotContentName(String volumeSnapshotContentName) {
        this.volumeSnapshotContentName = volumeSnapshotContentName;
    }

    @JsonIgnore
    public VolumeSnapshotSourceBuilder edit() {
        return new VolumeSnapshotSourceBuilder(this);
    }

    @JsonIgnore
    public VolumeSnapshotSourceBuilder toBuilder() {
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
        if (!(o instanceof VolumeSnapshotSource)) {
            return false;
        }
        VolumeSnapshotSource other = (VolumeSnapshotSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$persistentVolumeClaimName = this.getPersistentVolumeClaimName();
        Object other$persistentVolumeClaimName = other.getPersistentVolumeClaimName();
        if (this$persistentVolumeClaimName == null ? other$persistentVolumeClaimName != null : !this$persistentVolumeClaimName.equals(other$persistentVolumeClaimName)) {
            return false;
        }
        Object this$volumeSnapshotContentName = this.getVolumeSnapshotContentName();
        Object other$volumeSnapshotContentName = other.getVolumeSnapshotContentName();
        if (this$volumeSnapshotContentName == null ? other$volumeSnapshotContentName != null : !this$volumeSnapshotContentName.equals(other$volumeSnapshotContentName)) {
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
        return other instanceof VolumeSnapshotSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $persistentVolumeClaimName = this.getPersistentVolumeClaimName();
        result = result * prime + ($persistentVolumeClaimName == null ? 43 : $persistentVolumeClaimName.hashCode());
        Object $volumeSnapshotContentName = this.getVolumeSnapshotContentName();
        result = result * prime + ($volumeSnapshotContentName == null ? 43 : $volumeSnapshotContentName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeSnapshotSource(" + "persistentVolumeClaimName=" + this.getPersistentVolumeClaimName() + ", volumeSnapshotContentName=" + this.getVolumeSnapshotContentName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
