
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * DataDisk specifies the parameters that are used to add one or more data disks to the machine.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cachingType",
    "diskSizeGB",
    "lun",
    "managedDisk",
    "nameSuffix"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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
    @JsonProperty("diskSizeGB")
    private Integer diskSizeGB;
    @JsonProperty("lun")
    private Integer lun;
    @JsonProperty("managedDisk")
    private ManagedDiskParameters managedDisk;
    @JsonProperty("nameSuffix")
    private String nameSuffix;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DataDisk() {
    }

    public DataDisk(String cachingType, Integer diskSizeGB, Integer lun, ManagedDiskParameters managedDisk, String nameSuffix) {
        super();
        this.cachingType = cachingType;
        this.diskSizeGB = diskSizeGB;
        this.lun = lun;
        this.managedDisk = managedDisk;
        this.nameSuffix = nameSuffix;
    }

    /**
     * CachingType specifies the caching requirements.
     */
    @JsonProperty("cachingType")
    public String getCachingType() {
        return cachingType;
    }

    /**
     * CachingType specifies the caching requirements.
     */
    @JsonProperty("cachingType")
    public void setCachingType(String cachingType) {
        this.cachingType = cachingType;
    }

    /**
     * DiskSizeGB is the size in GB to assign to the data disk.
     */
    @JsonProperty("diskSizeGB")
    public Integer getDiskSizeGB() {
        return diskSizeGB;
    }

    /**
     * DiskSizeGB is the size in GB to assign to the data disk.
     */
    @JsonProperty("diskSizeGB")
    public void setDiskSizeGB(Integer diskSizeGB) {
        this.diskSizeGB = diskSizeGB;
    }

    /**
     * Lun Specifies the logical unit number of the data disk. This value is used to identify data disks within the VM and therefore must be unique for each data disk attached to a VM. The value must be between 0 and 63.
     */
    @JsonProperty("lun")
    public Integer getLun() {
        return lun;
    }

    /**
     * Lun Specifies the logical unit number of the data disk. This value is used to identify data disks within the VM and therefore must be unique for each data disk attached to a VM. The value must be between 0 and 63.
     */
    @JsonProperty("lun")
    public void setLun(Integer lun) {
        this.lun = lun;
    }

    /**
     * DataDisk specifies the parameters that are used to add one or more data disks to the machine.
     */
    @JsonProperty("managedDisk")
    public ManagedDiskParameters getManagedDisk() {
        return managedDisk;
    }

    /**
     * DataDisk specifies the parameters that are used to add one or more data disks to the machine.
     */
    @JsonProperty("managedDisk")
    public void setManagedDisk(ManagedDiskParameters managedDisk) {
        this.managedDisk = managedDisk;
    }

    /**
     * NameSuffix is the suffix to be appended to the machine name to generate the disk name. Each disk name will be in format &lt;machineName&gt;_&lt;nameSuffix&gt;.
     */
    @JsonProperty("nameSuffix")
    public String getNameSuffix() {
        return nameSuffix;
    }

    /**
     * NameSuffix is the suffix to be appended to the machine name to generate the disk name. Each disk name will be in format &lt;machineName&gt;_&lt;nameSuffix&gt;.
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

}
