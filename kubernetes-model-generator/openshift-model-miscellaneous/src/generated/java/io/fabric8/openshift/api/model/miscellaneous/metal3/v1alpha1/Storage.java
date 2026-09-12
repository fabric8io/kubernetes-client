
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Storage describes one storage device (disk, SSD, etc.) on the host.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "alternateNames",
    "hctl",
    "model",
    "name",
    "rotational",
    "serialNumber",
    "sizeBytes",
    "type",
    "vendor",
    "wwn",
    "wwnVendorExtension",
    "wwnWithExtension"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Storage implements Editable<StorageBuilder>, KubernetesResource
{

    @JsonProperty("alternateNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> alternateNames = new ArrayList<>();
    @JsonProperty("hctl")
    private String hctl;
    @JsonProperty("model")
    private String model;
    @JsonProperty("name")
    private String name;
    @JsonProperty("rotational")
    private Boolean rotational;
    @JsonProperty("serialNumber")
    private String serialNumber;
    @JsonProperty("sizeBytes")
    private Long sizeBytes;
    @JsonProperty("type")
    private String type;
    @JsonProperty("vendor")
    private String vendor;
    @JsonProperty("wwn")
    private String wwn;
    @JsonProperty("wwnVendorExtension")
    private String wwnVendorExtension;
    @JsonProperty("wwnWithExtension")
    private String wwnWithExtension;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Storage() {
    }

    public Storage(List<String> alternateNames, String hctl, String model, String name, Boolean rotational, String serialNumber, Long sizeBytes, String type, String vendor, String wwn, String wwnVendorExtension, String wwnWithExtension) {
        super();
        this.alternateNames = alternateNames;
        this.hctl = hctl;
        this.model = model;
        this.name = name;
        this.rotational = rotational;
        this.serialNumber = serialNumber;
        this.sizeBytes = sizeBytes;
        this.type = type;
        this.vendor = vendor;
        this.wwn = wwn;
        this.wwnVendorExtension = wwnVendorExtension;
        this.wwnWithExtension = wwnWithExtension;
    }

    /**
     * A list of alternate Linux device names of the disk, e.g. "/dev/sda". Note that this list is not exhaustive, and names may not be stable across reboots.
     */
    @JsonProperty("alternateNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAlternateNames() {
        return alternateNames;
    }

    /**
     * A list of alternate Linux device names of the disk, e.g. "/dev/sda". Note that this list is not exhaustive, and names may not be stable across reboots.
     */
    @JsonProperty("alternateNames")
    public void setAlternateNames(List<String> alternateNames) {
        this.alternateNames = alternateNames;
    }

    /**
     * The SCSI location of the device
     */
    @JsonProperty("hctl")
    public String getHctl() {
        return hctl;
    }

    /**
     * The SCSI location of the device
     */
    @JsonProperty("hctl")
    public void setHctl(String hctl) {
        this.hctl = hctl;
    }

    /**
     * Hardware model
     */
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    /**
     * Hardware model
     */
    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * A Linux device name of the disk, e.g. "/dev/disk/by-path/pci-0000:01:00.0-scsi-0:2:0:0". This will be a name that is stable across reboots if one is available.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * A Linux device name of the disk, e.g. "/dev/disk/by-path/pci-0000:01:00.0-scsi-0:2:0:0". This will be a name that is stable across reboots if one is available.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Whether this disk represents rotational storage. This field is not recommended for usage, please prefer using 'Type' field instead, this field will be deprecated eventually.
     */
    @JsonProperty("rotational")
    public Boolean getRotational() {
        return rotational;
    }

    /**
     * Whether this disk represents rotational storage. This field is not recommended for usage, please prefer using 'Type' field instead, this field will be deprecated eventually.
     */
    @JsonProperty("rotational")
    public void setRotational(Boolean rotational) {
        this.rotational = rotational;
    }

    /**
     * The serial number of the device
     */
    @JsonProperty("serialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * The serial number of the device
     */
    @JsonProperty("serialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * The size of the disk in Bytes
     */
    @JsonProperty("sizeBytes")
    public Long getSizeBytes() {
        return sizeBytes;
    }

    /**
     * The size of the disk in Bytes
     */
    @JsonProperty("sizeBytes")
    public void setSizeBytes(Long sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    /**
     * Device type, one of: HDD, SSD, NVME.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Device type, one of: HDD, SSD, NVME.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The name of the vendor of the device
     */
    @JsonProperty("vendor")
    public String getVendor() {
        return vendor;
    }

    /**
     * The name of the vendor of the device
     */
    @JsonProperty("vendor")
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * The WWN of the device
     */
    @JsonProperty("wwn")
    public String getWwn() {
        return wwn;
    }

    /**
     * The WWN of the device
     */
    @JsonProperty("wwn")
    public void setWwn(String wwn) {
        this.wwn = wwn;
    }

    /**
     * The WWN Vendor extension of the device
     */
    @JsonProperty("wwnVendorExtension")
    public String getWwnVendorExtension() {
        return wwnVendorExtension;
    }

    /**
     * The WWN Vendor extension of the device
     */
    @JsonProperty("wwnVendorExtension")
    public void setWwnVendorExtension(String wwnVendorExtension) {
        this.wwnVendorExtension = wwnVendorExtension;
    }

    /**
     * The WWN with the extension
     */
    @JsonProperty("wwnWithExtension")
    public String getWwnWithExtension() {
        return wwnWithExtension;
    }

    /**
     * The WWN with the extension
     */
    @JsonProperty("wwnWithExtension")
    public void setWwnWithExtension(String wwnWithExtension) {
        this.wwnWithExtension = wwnWithExtension;
    }

    @JsonIgnore
    public StorageBuilder edit() {
        return new StorageBuilder(this);
    }

    @JsonIgnore
    public StorageBuilder toBuilder() {
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
        if (!(o instanceof Storage)) {
            return false;
        }
        Storage other = (Storage) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$alternateNames = this.getAlternateNames();
        Object other$alternateNames = other.getAlternateNames();
        if (this$alternateNames == null ? other$alternateNames != null : !this$alternateNames.equals(other$alternateNames)) {
            return false;
        }
        Object this$hctl = this.getHctl();
        Object other$hctl = other.getHctl();
        if (this$hctl == null ? other$hctl != null : !this$hctl.equals(other$hctl)) {
            return false;
        }
        Object this$model = this.getModel();
        Object other$model = other.getModel();
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$rotational = this.getRotational();
        Object other$rotational = other.getRotational();
        if (this$rotational == null ? other$rotational != null : !this$rotational.equals(other$rotational)) {
            return false;
        }
        Object this$serialNumber = this.getSerialNumber();
        Object other$serialNumber = other.getSerialNumber();
        if (this$serialNumber == null ? other$serialNumber != null : !this$serialNumber.equals(other$serialNumber)) {
            return false;
        }
        Object this$sizeBytes = this.getSizeBytes();
        Object other$sizeBytes = other.getSizeBytes();
        if (this$sizeBytes == null ? other$sizeBytes != null : !this$sizeBytes.equals(other$sizeBytes)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$vendor = this.getVendor();
        Object other$vendor = other.getVendor();
        if (this$vendor == null ? other$vendor != null : !this$vendor.equals(other$vendor)) {
            return false;
        }
        Object this$wwn = this.getWwn();
        Object other$wwn = other.getWwn();
        if (this$wwn == null ? other$wwn != null : !this$wwn.equals(other$wwn)) {
            return false;
        }
        Object this$wwnVendorExtension = this.getWwnVendorExtension();
        Object other$wwnVendorExtension = other.getWwnVendorExtension();
        if (this$wwnVendorExtension == null ? other$wwnVendorExtension != null : !this$wwnVendorExtension.equals(other$wwnVendorExtension)) {
            return false;
        }
        Object this$wwnWithExtension = this.getWwnWithExtension();
        Object other$wwnWithExtension = other.getWwnWithExtension();
        if (this$wwnWithExtension == null ? other$wwnWithExtension != null : !this$wwnWithExtension.equals(other$wwnWithExtension)) {
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
        return other instanceof Storage;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $alternateNames = this.getAlternateNames();
        result = result * prime + ($alternateNames == null ? 43 : $alternateNames.hashCode());
        Object $hctl = this.getHctl();
        result = result * prime + ($hctl == null ? 43 : $hctl.hashCode());
        Object $model = this.getModel();
        result = result * prime + ($model == null ? 43 : $model.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $rotational = this.getRotational();
        result = result * prime + ($rotational == null ? 43 : $rotational.hashCode());
        Object $serialNumber = this.getSerialNumber();
        result = result * prime + ($serialNumber == null ? 43 : $serialNumber.hashCode());
        Object $sizeBytes = this.getSizeBytes();
        result = result * prime + ($sizeBytes == null ? 43 : $sizeBytes.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $vendor = this.getVendor();
        result = result * prime + ($vendor == null ? 43 : $vendor.hashCode());
        Object $wwn = this.getWwn();
        result = result * prime + ($wwn == null ? 43 : $wwn.hashCode());
        Object $wwnVendorExtension = this.getWwnVendorExtension();
        result = result * prime + ($wwnVendorExtension == null ? 43 : $wwnVendorExtension.hashCode());
        Object $wwnWithExtension = this.getWwnWithExtension();
        result = result * prime + ($wwnWithExtension == null ? 43 : $wwnWithExtension.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Storage(" + "alternateNames=" + this.getAlternateNames() + ", hctl=" + this.getHctl() + ", model=" + this.getModel() + ", name=" + this.getName() + ", rotational=" + this.getRotational() + ", serialNumber=" + this.getSerialNumber() + ", sizeBytes=" + this.getSizeBytes() + ", type=" + this.getType() + ", vendor=" + this.getVendor() + ", wwn=" + this.getWwn() + ", wwnVendorExtension=" + this.getWwnVendorExtension() + ", wwnWithExtension=" + this.getWwnWithExtension() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
