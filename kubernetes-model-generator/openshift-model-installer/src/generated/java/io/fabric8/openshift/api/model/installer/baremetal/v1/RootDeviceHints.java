
package io.fabric8.openshift.api.model.installer.baremetal.v1;

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
 * RootDeviceHints holds the hints for specifying the storage location for the root filesystem for the image.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deviceName",
    "hctl",
    "minSizeGigabytes",
    "model",
    "rotational",
    "serialNumber",
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RootDeviceHints implements Editable<RootDeviceHintsBuilder>, KubernetesResource
{

    @JsonProperty("deviceName")
    private String deviceName;
    @JsonProperty("hctl")
    private String hctl;
    @JsonProperty("minSizeGigabytes")
    private Integer minSizeGigabytes;
    @JsonProperty("model")
    private String model;
    @JsonProperty("rotational")
    private Boolean rotational;
    @JsonProperty("serialNumber")
    private String serialNumber;
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
    public RootDeviceHints() {
    }

    public RootDeviceHints(String deviceName, String hctl, Integer minSizeGigabytes, String model, Boolean rotational, String serialNumber, String vendor, String wwn, String wwnVendorExtension, String wwnWithExtension) {
        super();
        this.deviceName = deviceName;
        this.hctl = hctl;
        this.minSizeGigabytes = minSizeGigabytes;
        this.model = model;
        this.rotational = rotational;
        this.serialNumber = serialNumber;
        this.vendor = vendor;
        this.wwn = wwn;
        this.wwnVendorExtension = wwnVendorExtension;
        this.wwnWithExtension = wwnWithExtension;
    }

    /**
     * A Linux device name like "/dev/vda". The hint must match the actual value exactly.
     */
    @JsonProperty("deviceName")
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * A Linux device name like "/dev/vda". The hint must match the actual value exactly.
     */
    @JsonProperty("deviceName")
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    /**
     * A SCSI bus address like 0:0:0:0. The hint must match the actual value exactly.
     */
    @JsonProperty("hctl")
    public String getHctl() {
        return hctl;
    }

    /**
     * A SCSI bus address like 0:0:0:0. The hint must match the actual value exactly.
     */
    @JsonProperty("hctl")
    public void setHctl(String hctl) {
        this.hctl = hctl;
    }

    /**
     * The minimum size of the device in Gigabytes.
     */
    @JsonProperty("minSizeGigabytes")
    public Integer getMinSizeGigabytes() {
        return minSizeGigabytes;
    }

    /**
     * The minimum size of the device in Gigabytes.
     */
    @JsonProperty("minSizeGigabytes")
    public void setMinSizeGigabytes(Integer minSizeGigabytes) {
        this.minSizeGigabytes = minSizeGigabytes;
    }

    /**
     * A vendor-specific device identifier. The hint can be a substring of the actual value.
     */
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    /**
     * A vendor-specific device identifier. The hint can be a substring of the actual value.
     */
    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * True if the device should use spinning media, false otherwise.
     */
    @JsonProperty("rotational")
    public Boolean getRotational() {
        return rotational;
    }

    /**
     * True if the device should use spinning media, false otherwise.
     */
    @JsonProperty("rotational")
    public void setRotational(Boolean rotational) {
        this.rotational = rotational;
    }

    /**
     * Device serial number. The hint must match the actual value exactly.
     */
    @JsonProperty("serialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Device serial number. The hint must match the actual value exactly.
     */
    @JsonProperty("serialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * The name of the vendor or manufacturer of the device. The hint can be a substring of the actual value.
     */
    @JsonProperty("vendor")
    public String getVendor() {
        return vendor;
    }

    /**
     * The name of the vendor or manufacturer of the device. The hint can be a substring of the actual value.
     */
    @JsonProperty("vendor")
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * Unique storage identifier. The hint must match the actual value exactly.
     */
    @JsonProperty("wwn")
    public String getWwn() {
        return wwn;
    }

    /**
     * Unique storage identifier. The hint must match the actual value exactly.
     */
    @JsonProperty("wwn")
    public void setWwn(String wwn) {
        this.wwn = wwn;
    }

    /**
     * Unique vendor storage identifier. The hint must match the actual value exactly.
     */
    @JsonProperty("wwnVendorExtension")
    public String getWwnVendorExtension() {
        return wwnVendorExtension;
    }

    /**
     * Unique vendor storage identifier. The hint must match the actual value exactly.
     */
    @JsonProperty("wwnVendorExtension")
    public void setWwnVendorExtension(String wwnVendorExtension) {
        this.wwnVendorExtension = wwnVendorExtension;
    }

    /**
     * Unique storage identifier with the vendor extension appended. The hint must match the actual value exactly.
     */
    @JsonProperty("wwnWithExtension")
    public String getWwnWithExtension() {
        return wwnWithExtension;
    }

    /**
     * Unique storage identifier with the vendor extension appended. The hint must match the actual value exactly.
     */
    @JsonProperty("wwnWithExtension")
    public void setWwnWithExtension(String wwnWithExtension) {
        this.wwnWithExtension = wwnWithExtension;
    }

    @JsonIgnore
    public RootDeviceHintsBuilder edit() {
        return new RootDeviceHintsBuilder(this);
    }

    @JsonIgnore
    public RootDeviceHintsBuilder toBuilder() {
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
        if (!(o instanceof RootDeviceHints)) {
            return false;
        }
        RootDeviceHints other = (RootDeviceHints) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$deviceName = this.getDeviceName();
        Object other$deviceName = other.getDeviceName();
        if (this$deviceName == null ? other$deviceName != null : !this$deviceName.equals(other$deviceName)) {
            return false;
        }
        Object this$hctl = this.getHctl();
        Object other$hctl = other.getHctl();
        if (this$hctl == null ? other$hctl != null : !this$hctl.equals(other$hctl)) {
            return false;
        }
        Object this$minSizeGigabytes = this.getMinSizeGigabytes();
        Object other$minSizeGigabytes = other.getMinSizeGigabytes();
        if (this$minSizeGigabytes == null ? other$minSizeGigabytes != null : !this$minSizeGigabytes.equals(other$minSizeGigabytes)) {
            return false;
        }
        Object this$model = this.getModel();
        Object other$model = other.getModel();
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) {
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
        return other instanceof RootDeviceHints;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $deviceName = this.getDeviceName();
        result = result * prime + ($deviceName == null ? 43 : $deviceName.hashCode());
        Object $hctl = this.getHctl();
        result = result * prime + ($hctl == null ? 43 : $hctl.hashCode());
        Object $minSizeGigabytes = this.getMinSizeGigabytes();
        result = result * prime + ($minSizeGigabytes == null ? 43 : $minSizeGigabytes.hashCode());
        Object $model = this.getModel();
        result = result * prime + ($model == null ? 43 : $model.hashCode());
        Object $rotational = this.getRotational();
        result = result * prime + ($rotational == null ? 43 : $rotational.hashCode());
        Object $serialNumber = this.getSerialNumber();
        result = result * prime + ($serialNumber == null ? 43 : $serialNumber.hashCode());
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
        return "RootDeviceHints(" + "deviceName=" + this.getDeviceName() + ", hctl=" + this.getHctl() + ", minSizeGigabytes=" + this.getMinSizeGigabytes() + ", model=" + this.getModel() + ", rotational=" + this.getRotational() + ", serialNumber=" + this.getSerialNumber() + ", vendor=" + this.getVendor() + ", wwn=" + this.getWwn() + ", wwnVendorExtension=" + this.getWwnVendorExtension() + ", wwnWithExtension=" + this.getWwnWithExtension() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
