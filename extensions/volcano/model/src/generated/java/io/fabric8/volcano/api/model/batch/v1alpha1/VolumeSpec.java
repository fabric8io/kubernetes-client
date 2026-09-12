
package io.fabric8.volcano.api.model.batch.v1alpha1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaimSpec;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * VolumeSpec defines the specification of Volume, e.g. PVC.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mountPath",
    "volumeClaim",
    "volumeClaimName"
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
public class VolumeSpec implements Editable<VolumeSpecBuilder>, KubernetesResource
{

    @JsonProperty("mountPath")
    private String mountPath;
    @JsonProperty("volumeClaim")
    private PersistentVolumeClaimSpec volumeClaim;
    @JsonProperty("volumeClaimName")
    private String volumeClaimName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VolumeSpec() {
    }

    public VolumeSpec(String mountPath, PersistentVolumeClaimSpec volumeClaim, String volumeClaimName) {
        super();
        this.mountPath = mountPath;
        this.volumeClaim = volumeClaim;
        this.volumeClaimName = volumeClaimName;
    }

    /**
     * Path within the container at which the volume should be mounted.  Must not contain ':'.
     */
    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    /**
     * Path within the container at which the volume should be mounted.  Must not contain ':'.
     */
    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    /**
     * VolumeSpec defines the specification of Volume, e.g. PVC.
     */
    @JsonProperty("volumeClaim")
    public PersistentVolumeClaimSpec getVolumeClaim() {
        return volumeClaim;
    }

    /**
     * VolumeSpec defines the specification of Volume, e.g. PVC.
     */
    @JsonProperty("volumeClaim")
    public void setVolumeClaim(PersistentVolumeClaimSpec volumeClaim) {
        this.volumeClaim = volumeClaim;
    }

    /**
     * defined the PVC name
     */
    @JsonProperty("volumeClaimName")
    public String getVolumeClaimName() {
        return volumeClaimName;
    }

    /**
     * defined the PVC name
     */
    @JsonProperty("volumeClaimName")
    public void setVolumeClaimName(String volumeClaimName) {
        this.volumeClaimName = volumeClaimName;
    }

    @JsonIgnore
    public VolumeSpecBuilder edit() {
        return new VolumeSpecBuilder(this);
    }

    @JsonIgnore
    public VolumeSpecBuilder toBuilder() {
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
        if (!(o instanceof VolumeSpec)) {
            return false;
        }
        VolumeSpec other = (VolumeSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$mountPath = this.getMountPath();
        Object other$mountPath = other.getMountPath();
        if (this$mountPath == null ? other$mountPath != null : !this$mountPath.equals(other$mountPath)) {
            return false;
        }
        Object this$volumeClaim = this.getVolumeClaim();
        Object other$volumeClaim = other.getVolumeClaim();
        if (this$volumeClaim == null ? other$volumeClaim != null : !this$volumeClaim.equals(other$volumeClaim)) {
            return false;
        }
        Object this$volumeClaimName = this.getVolumeClaimName();
        Object other$volumeClaimName = other.getVolumeClaimName();
        if (this$volumeClaimName == null ? other$volumeClaimName != null : !this$volumeClaimName.equals(other$volumeClaimName)) {
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
        return other instanceof VolumeSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $mountPath = this.getMountPath();
        result = result * prime + ($mountPath == null ? 43 : $mountPath.hashCode());
        Object $volumeClaim = this.getVolumeClaim();
        result = result * prime + ($volumeClaim == null ? 43 : $volumeClaim.hashCode());
        Object $volumeClaimName = this.getVolumeClaimName();
        result = result * prime + ($volumeClaimName == null ? 43 : $volumeClaimName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VolumeSpec(" + "mountPath=" + this.getMountPath() + ", volumeClaim=" + this.getVolumeClaim() + ", volumeClaimName=" + this.getVolumeClaimName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
