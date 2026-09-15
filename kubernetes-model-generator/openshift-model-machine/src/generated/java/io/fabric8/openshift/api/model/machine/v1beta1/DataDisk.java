
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
 * DataDisk specifies the parameters that are used to add one or more data disks to the machine. A Data Disk is a managed disk that's attached to a virtual machine to store application data. It differs from an OS Disk as it doesn't come with a pre-installed OS, and it cannot contain the boot volume. It is registered as SCSI drive and labeled with the chosen `lun`. e.g. for `lun: 0` the raw disk device will be available at `/dev/disk/azure/scsi1/lun0`.<br><p> <br><p> As the Data Disk disk device is attached raw to the virtual machine, it will need to be partitioned, formatted with a filesystem and mounted, in order for it to be usable. This can be done by creating a custom userdata Secret with custom Ignition configuration to achieve the desired initialization. At this stage the previously defined `lun` is to be used as the "device" key for referencing the raw disk device to be initialized. Once the custom userdata Secret has been created, it can be referenced in the Machine's `.providerSpec.userDataSecret`. For further guidance and examples, please refer to the official OpenShift docs.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cachingType",
    "deletionPolicy",
    "diskSizeGB",
    "lun",
    "managedDisk",
    "nameSuffix"
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
public class DataDisk implements Editable<DataDiskBuilder>, KubernetesResource
{

    @JsonProperty("cachingType")
    private String cachingType;
    @JsonProperty("deletionPolicy")
    private String deletionPolicy;
    @JsonProperty("diskSizeGB")
    private Integer diskSizeGB;
    @JsonProperty("lun")
    private Integer lun;
    @JsonProperty("managedDisk")
    private DataDiskManagedDiskParameters managedDisk;
    @JsonProperty("nameSuffix")
    private String nameSuffix;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DataDisk() {
    }

    public DataDisk(String cachingType, String deletionPolicy, Integer diskSizeGB, Integer lun, DataDiskManagedDiskParameters managedDisk, String nameSuffix) {
        super();
        this.cachingType = cachingType;
        this.deletionPolicy = deletionPolicy;
        this.diskSizeGB = diskSizeGB;
        this.lun = lun;
        this.managedDisk = managedDisk;
        this.nameSuffix = nameSuffix;
    }

    /**
     * cachingType specifies the caching requirements. Empty value means no opinion and the platform chooses a default, which is subject to change over time. Currently the default is CachingTypeNone.
     */
    @JsonProperty("cachingType")
    public String getCachingType() {
        return cachingType;
    }

    /**
     * cachingType specifies the caching requirements. Empty value means no opinion and the platform chooses a default, which is subject to change over time. Currently the default is CachingTypeNone.
     */
    @JsonProperty("cachingType")
    public void setCachingType(String cachingType) {
        this.cachingType = cachingType;
    }

    /**
     * deletionPolicy specifies the data disk deletion policy upon Machine deletion. Possible values are "Delete","Detach". When "Delete" is used the data disk is deleted when the Machine is deleted. When "Detach" is used the data disk is detached from the Machine and retained when the Machine is deleted.
     */
    @JsonProperty("deletionPolicy")
    public String getDeletionPolicy() {
        return deletionPolicy;
    }

    /**
     * deletionPolicy specifies the data disk deletion policy upon Machine deletion. Possible values are "Delete","Detach". When "Delete" is used the data disk is deleted when the Machine is deleted. When "Detach" is used the data disk is detached from the Machine and retained when the Machine is deleted.
     */
    @JsonProperty("deletionPolicy")
    public void setDeletionPolicy(String deletionPolicy) {
        this.deletionPolicy = deletionPolicy;
    }

    /**
     * diskSizeGB is the size in GB to assign to the data disk.
     */
    @JsonProperty("diskSizeGB")
    public Integer getDiskSizeGB() {
        return diskSizeGB;
    }

    /**
     * diskSizeGB is the size in GB to assign to the data disk.
     */
    @JsonProperty("diskSizeGB")
    public void setDiskSizeGB(Integer diskSizeGB) {
        this.diskSizeGB = diskSizeGB;
    }

    /**
     * lun Specifies the logical unit number of the data disk. This value is used to identify data disks within the VM and therefore must be unique for each data disk attached to a VM. This value is also needed for referencing the data disks devices within userdata to perform disk initialization through Ignition (e.g. partition/format/mount). The value must be between 0 and 63.
     */
    @JsonProperty("lun")
    public Integer getLun() {
        return lun;
    }

    /**
     * lun Specifies the logical unit number of the data disk. This value is used to identify data disks within the VM and therefore must be unique for each data disk attached to a VM. This value is also needed for referencing the data disks devices within userdata to perform disk initialization through Ignition (e.g. partition/format/mount). The value must be between 0 and 63.
     */
    @JsonProperty("lun")
    public void setLun(Integer lun) {
        this.lun = lun;
    }

    /**
     * DataDisk specifies the parameters that are used to add one or more data disks to the machine. A Data Disk is a managed disk that's attached to a virtual machine to store application data. It differs from an OS Disk as it doesn't come with a pre-installed OS, and it cannot contain the boot volume. It is registered as SCSI drive and labeled with the chosen `lun`. e.g. for `lun: 0` the raw disk device will be available at `/dev/disk/azure/scsi1/lun0`.<br><p> <br><p> As the Data Disk disk device is attached raw to the virtual machine, it will need to be partitioned, formatted with a filesystem and mounted, in order for it to be usable. This can be done by creating a custom userdata Secret with custom Ignition configuration to achieve the desired initialization. At this stage the previously defined `lun` is to be used as the "device" key for referencing the raw disk device to be initialized. Once the custom userdata Secret has been created, it can be referenced in the Machine's `.providerSpec.userDataSecret`. For further guidance and examples, please refer to the official OpenShift docs.
     */
    @JsonProperty("managedDisk")
    public DataDiskManagedDiskParameters getManagedDisk() {
        return managedDisk;
    }

    /**
     * DataDisk specifies the parameters that are used to add one or more data disks to the machine. A Data Disk is a managed disk that's attached to a virtual machine to store application data. It differs from an OS Disk as it doesn't come with a pre-installed OS, and it cannot contain the boot volume. It is registered as SCSI drive and labeled with the chosen `lun`. e.g. for `lun: 0` the raw disk device will be available at `/dev/disk/azure/scsi1/lun0`.<br><p> <br><p> As the Data Disk disk device is attached raw to the virtual machine, it will need to be partitioned, formatted with a filesystem and mounted, in order for it to be usable. This can be done by creating a custom userdata Secret with custom Ignition configuration to achieve the desired initialization. At this stage the previously defined `lun` is to be used as the "device" key for referencing the raw disk device to be initialized. Once the custom userdata Secret has been created, it can be referenced in the Machine's `.providerSpec.userDataSecret`. For further guidance and examples, please refer to the official OpenShift docs.
     */
    @JsonProperty("managedDisk")
    public void setManagedDisk(DataDiskManagedDiskParameters managedDisk) {
        this.managedDisk = managedDisk;
    }

    /**
     * nameSuffix is the suffix to be appended to the machine name to generate the disk name. Each disk name will be in format &lt;machineName&gt;_&lt;nameSuffix&gt;. NameSuffix name must start and finish with an alphanumeric character and can only contain letters, numbers, underscores, periods or hyphens. The overall disk name must not exceed 80 chars in length.
     */
    @JsonProperty("nameSuffix")
    public String getNameSuffix() {
        return nameSuffix;
    }

    /**
     * nameSuffix is the suffix to be appended to the machine name to generate the disk name. Each disk name will be in format &lt;machineName&gt;_&lt;nameSuffix&gt;. NameSuffix name must start and finish with an alphanumeric character and can only contain letters, numbers, underscores, periods or hyphens. The overall disk name must not exceed 80 chars in length.
     */
    @JsonProperty("nameSuffix")
    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    @JsonIgnore
    public DataDiskBuilder edit() {
        return new DataDiskBuilder(this);
    }

    @JsonIgnore
    public DataDiskBuilder toBuilder() {
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
        if (!(o instanceof DataDisk)) {
            return false;
        }
        DataDisk other = (DataDisk) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cachingType = this.getCachingType();
        Object other$cachingType = other.getCachingType();
        if (this$cachingType == null ? other$cachingType != null : !this$cachingType.equals(other$cachingType)) {
            return false;
        }
        Object this$deletionPolicy = this.getDeletionPolicy();
        Object other$deletionPolicy = other.getDeletionPolicy();
        if (this$deletionPolicy == null ? other$deletionPolicy != null : !this$deletionPolicy.equals(other$deletionPolicy)) {
            return false;
        }
        Object this$diskSizeGB = this.getDiskSizeGB();
        Object other$diskSizeGB = other.getDiskSizeGB();
        if (this$diskSizeGB == null ? other$diskSizeGB != null : !this$diskSizeGB.equals(other$diskSizeGB)) {
            return false;
        }
        Object this$lun = this.getLun();
        Object other$lun = other.getLun();
        if (this$lun == null ? other$lun != null : !this$lun.equals(other$lun)) {
            return false;
        }
        Object this$managedDisk = this.getManagedDisk();
        Object other$managedDisk = other.getManagedDisk();
        if (this$managedDisk == null ? other$managedDisk != null : !this$managedDisk.equals(other$managedDisk)) {
            return false;
        }
        Object this$nameSuffix = this.getNameSuffix();
        Object other$nameSuffix = other.getNameSuffix();
        if (this$nameSuffix == null ? other$nameSuffix != null : !this$nameSuffix.equals(other$nameSuffix)) {
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
        return other instanceof DataDisk;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cachingType = this.getCachingType();
        result = result * prime + ($cachingType == null ? 43 : $cachingType.hashCode());
        Object $deletionPolicy = this.getDeletionPolicy();
        result = result * prime + ($deletionPolicy == null ? 43 : $deletionPolicy.hashCode());
        Object $diskSizeGB = this.getDiskSizeGB();
        result = result * prime + ($diskSizeGB == null ? 43 : $diskSizeGB.hashCode());
        Object $lun = this.getLun();
        result = result * prime + ($lun == null ? 43 : $lun.hashCode());
        Object $managedDisk = this.getManagedDisk();
        result = result * prime + ($managedDisk == null ? 43 : $managedDisk.hashCode());
        Object $nameSuffix = this.getNameSuffix();
        result = result * prime + ($nameSuffix == null ? 43 : $nameSuffix.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DataDisk(" + "cachingType=" + this.getCachingType() + ", deletionPolicy=" + this.getDeletionPolicy() + ", diskSizeGB=" + this.getDiskSizeGB() + ", lun=" + this.getLun() + ", managedDisk=" + this.getManagedDisk() + ", nameSuffix=" + this.getNameSuffix() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
