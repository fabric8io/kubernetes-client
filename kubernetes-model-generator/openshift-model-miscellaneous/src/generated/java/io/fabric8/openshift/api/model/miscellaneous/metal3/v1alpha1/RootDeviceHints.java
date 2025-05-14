
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
     * A Linux device name like "/dev/vda", or a by-path link to it like "/dev/disk/by-path/pci-0000:01:00.0-scsi-0:2:0:0". The hint must match the actual value exactly.
     */
    @JsonProperty("deviceName")
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * A Linux device name like "/dev/vda", or a by-path link to it like "/dev/disk/by-path/pci-0000:01:00.0-scsi-0:2:0:0". The hint must match the actual value exactly.
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

}
