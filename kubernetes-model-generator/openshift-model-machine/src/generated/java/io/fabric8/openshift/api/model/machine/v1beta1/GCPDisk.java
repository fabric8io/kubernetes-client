
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * GCPDisk describes disks for GCP.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "autoDelete",
    "boot",
    "encryptionKey",
    "image",
    "labels",
    "sizeGb",
    "type"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class GCPDisk implements Editable<GCPDiskBuilder>, KubernetesResource
{

    @JsonProperty("autoDelete")
    private Boolean autoDelete;
    @JsonProperty("boot")
    private Boolean boot;
    @JsonProperty("encryptionKey")
    private GCPEncryptionKeyReference encryptionKey;
    @JsonProperty("image")
    private String image;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("sizeGb")
    private Long sizeGb;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GCPDisk() {
    }

    public GCPDisk(Boolean autoDelete, Boolean boot, GCPEncryptionKeyReference encryptionKey, String image, Map<String, String> labels, Long sizeGb, String type) {
        super();
        this.autoDelete = autoDelete;
        this.boot = boot;
        this.encryptionKey = encryptionKey;
        this.image = image;
        this.labels = labels;
        this.sizeGb = sizeGb;
        this.type = type;
    }

    /**
     * autoDelete indicates if the disk will be auto-deleted when the instance is deleted (default false).
     */
    @JsonProperty("autoDelete")
    public Boolean getAutoDelete() {
        return autoDelete;
    }

    /**
     * autoDelete indicates if the disk will be auto-deleted when the instance is deleted (default false).
     */
    @JsonProperty("autoDelete")
    public void setAutoDelete(Boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    /**
     * boot indicates if this is a boot disk (default false).
     */
    @JsonProperty("boot")
    public Boolean getBoot() {
        return boot;
    }

    /**
     * boot indicates if this is a boot disk (default false).
     */
    @JsonProperty("boot")
    public void setBoot(Boolean boot) {
        this.boot = boot;
    }

    /**
     * GCPDisk describes disks for GCP.
     */
    @JsonProperty("encryptionKey")
    public GCPEncryptionKeyReference getEncryptionKey() {
        return encryptionKey;
    }

    /**
     * GCPDisk describes disks for GCP.
     */
    @JsonProperty("encryptionKey")
    public void setEncryptionKey(GCPEncryptionKeyReference encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    /**
     * image is the source image to create this disk.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image is the source image to create this disk.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * labels list of labels to apply to the disk.
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * labels list of labels to apply to the disk.
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * sizeGb is the size of the disk (in GB).
     */
    @JsonProperty("sizeGb")
    public Long getSizeGb() {
        return sizeGb;
    }

    /**
     * sizeGb is the size of the disk (in GB).
     */
    @JsonProperty("sizeGb")
    public void setSizeGb(Long sizeGb) {
        this.sizeGb = sizeGb;
    }

    /**
     * type is the type of the disk (eg: pd-standard).
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the type of the disk (eg: pd-standard).
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public GCPDiskBuilder edit() {
        return new GCPDiskBuilder(this);
    }

    @JsonIgnore
    public GCPDiskBuilder toBuilder() {
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
        if (!(o instanceof GCPDisk)) {
            return false;
        }
        GCPDisk other = (GCPDisk) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$autoDelete = this.getAutoDelete();
        Object other$autoDelete = other.getAutoDelete();
        if (this$autoDelete == null ? other$autoDelete != null : !this$autoDelete.equals(other$autoDelete)) {
            return false;
        }
        Object this$boot = this.getBoot();
        Object other$boot = other.getBoot();
        if (this$boot == null ? other$boot != null : !this$boot.equals(other$boot)) {
            return false;
        }
        Object this$encryptionKey = this.getEncryptionKey();
        Object other$encryptionKey = other.getEncryptionKey();
        if (this$encryptionKey == null ? other$encryptionKey != null : !this$encryptionKey.equals(other$encryptionKey)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$labels = this.getLabels();
        Object other$labels = other.getLabels();
        if (this$labels == null ? other$labels != null : !this$labels.equals(other$labels)) {
            return false;
        }
        Object this$sizeGb = this.getSizeGb();
        Object other$sizeGb = other.getSizeGb();
        if (this$sizeGb == null ? other$sizeGb != null : !this$sizeGb.equals(other$sizeGb)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof GCPDisk;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $autoDelete = this.getAutoDelete();
        result = result * prime + ($autoDelete == null ? 43 : $autoDelete.hashCode());
        Object $boot = this.getBoot();
        result = result * prime + ($boot == null ? 43 : $boot.hashCode());
        Object $encryptionKey = this.getEncryptionKey();
        result = result * prime + ($encryptionKey == null ? 43 : $encryptionKey.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $labels = this.getLabels();
        result = result * prime + ($labels == null ? 43 : $labels.hashCode());
        Object $sizeGb = this.getSizeGb();
        result = result * prime + ($sizeGb == null ? 43 : $sizeGb.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GCPDisk(" + "autoDelete=" + this.getAutoDelete() + ", boot=" + this.getBoot() + ", encryptionKey=" + this.getEncryptionKey() + ", image=" + this.getImage() + ", labels=" + this.getLabels() + ", sizeGb=" + this.getSizeGb() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
