
package io.fabric8.openshift.api.model.machine.v1;

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

/**
 * DataDisk contains the information regarding the datadisk attached to an instance
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Category",
    "DiskEncryption",
    "DiskPreservation",
    "KMSKeyID",
    "Name",
    "PerformanceLevel",
    "Size",
    "SnapshotID"
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
public class DataDiskProperties implements Editable<DataDiskPropertiesBuilder>, KubernetesResource
{

    @JsonProperty("Category")
    private String category;
    @JsonProperty("DiskEncryption")
    private String diskEncryption;
    @JsonProperty("DiskPreservation")
    private String diskPreservation;
    @JsonProperty("KMSKeyID")
    private String kMSKeyID;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("PerformanceLevel")
    private String performanceLevel;
    @JsonProperty("Size")
    private Long size;
    @JsonProperty("SnapshotID")
    private String snapshotID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DataDiskProperties() {
    }

    public DataDiskProperties(String category, String diskEncryption, String diskPreservation, String kMSKeyID, String name, String performanceLevel, Long size, String snapshotID) {
        super();
        this.category = category;
        this.diskEncryption = diskEncryption;
        this.diskPreservation = diskPreservation;
        this.kMSKeyID = kMSKeyID;
        this.name = name;
        this.performanceLevel = performanceLevel;
        this.size = size;
        this.snapshotID = snapshotID;
    }

    /**
     * Category describes the type of data disk N. Valid values: cloud_efficiency: ultra disk cloud_ssd: standard SSD cloud_essd: ESSD cloud: basic disk Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently for non-I/O optimized instances of retired instance types, the default is `cloud`. Currently for other instances, the default is `cloud_efficiency`.
     */
    @JsonProperty("Category")
    public String getCategory() {
        return category;
    }

    /**
     * Category describes the type of data disk N. Valid values: cloud_efficiency: ultra disk cloud_ssd: standard SSD cloud_essd: ESSD cloud: basic disk Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently for non-I/O optimized instances of retired instance types, the default is `cloud`. Currently for other instances, the default is `cloud_efficiency`.
     */
    @JsonProperty("Category")
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * DiskEncryption specifies whether to encrypt data disk N.<br><p> <br><p> Empty value means the platform chooses a default, which is subject to change over time. Currently the default is `disabled`.
     */
    @JsonProperty("DiskEncryption")
    public String getDiskEncryption() {
        return diskEncryption;
    }

    /**
     * DiskEncryption specifies whether to encrypt data disk N.<br><p> <br><p> Empty value means the platform chooses a default, which is subject to change over time. Currently the default is `disabled`.
     */
    @JsonProperty("DiskEncryption")
    public void setDiskEncryption(String diskEncryption) {
        this.diskEncryption = diskEncryption;
    }

    /**
     * DiskPreservation specifies whether to release data disk N along with the instance. Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default is `DeleteWithInstance`
     */
    @JsonProperty("DiskPreservation")
    public String getDiskPreservation() {
        return diskPreservation;
    }

    /**
     * DiskPreservation specifies whether to release data disk N along with the instance. Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default is `DeleteWithInstance`
     */
    @JsonProperty("DiskPreservation")
    public void setDiskPreservation(String diskPreservation) {
        this.diskPreservation = diskPreservation;
    }

    /**
     * KMSKeyID is the ID of the Key Management Service (KMS) key to be used by data disk N. Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default is `""` which is interpreted as do not use KMSKey encryption.
     */
    @JsonProperty("KMSKeyID")
    public String getKMSKeyID() {
        return kMSKeyID;
    }

    /**
     * KMSKeyID is the ID of the Key Management Service (KMS) key to be used by data disk N. Empty value means no opinion and the platform chooses the a default, which is subject to change over time. Currently the default is `""` which is interpreted as do not use KMSKey encryption.
     */
    @JsonProperty("KMSKeyID")
    public void setKMSKeyID(String kMSKeyID) {
        this.kMSKeyID = kMSKeyID;
    }

    /**
     * Name is the name of data disk N. If the name is specified the name must be 2 to 128 characters in length. It must start with a letter and cannot start with http:// or https://. It can contain letters, digits, colons (:), underscores (_), and hyphens (-).<br><p> <br><p> Empty value means the platform chooses a default, which is subject to change over time. Currently the default is `""`.
     */
    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of data disk N. If the name is specified the name must be 2 to 128 characters in length. It must start with a letter and cannot start with http:// or https://. It can contain letters, digits, colons (:), underscores (_), and hyphens (-).<br><p> <br><p> Empty value means the platform chooses a default, which is subject to change over time. Currently the default is `""`.
     */
    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * PerformanceLevel is the performance level of the ESSD used as as data disk N.  The N value must be the same as that in DataDisk.N.Category when DataDisk.N.Category is set to cloud_essd. Empty value means no opinion and the platform chooses a default, which is subject to change over time. Currently the default is `PL1`. Valid values:<br><p> <br><p> PL0: A single ESSD can deliver up to 10,000 random read/write IOPS. PL1: A single ESSD can deliver up to 50,000 random read/write IOPS. PL2: A single ESSD can deliver up to 100,000 random read/write IOPS. PL3: A single ESSD can deliver up to 1,000,000 random read/write IOPS. For more information about ESSD performance levels, see ESSDs.
     */
    @JsonProperty("PerformanceLevel")
    public String getPerformanceLevel() {
        return performanceLevel;
    }

    /**
     * PerformanceLevel is the performance level of the ESSD used as as data disk N.  The N value must be the same as that in DataDisk.N.Category when DataDisk.N.Category is set to cloud_essd. Empty value means no opinion and the platform chooses a default, which is subject to change over time. Currently the default is `PL1`. Valid values:<br><p> <br><p> PL0: A single ESSD can deliver up to 10,000 random read/write IOPS. PL1: A single ESSD can deliver up to 50,000 random read/write IOPS. PL2: A single ESSD can deliver up to 100,000 random read/write IOPS. PL3: A single ESSD can deliver up to 1,000,000 random read/write IOPS. For more information about ESSD performance levels, see ESSDs.
     */
    @JsonProperty("PerformanceLevel")
    public void setPerformanceLevel(String performanceLevel) {
        this.performanceLevel = performanceLevel;
    }

    /**
     * Size of the data disk N. Valid values of N: 1 to 16. Unit: GiB. Valid values:<br><p> <br><p> Valid values when DataDisk.N.Category is set to cloud_efficiency: 20 to 32768 Valid values when DataDisk.N.Category is set to cloud_ssd: 20 to 32768 Valid values when DataDisk.N.Category is set to cloud_essd: 20 to 32768 Valid values when DataDisk.N.Category is set to cloud: 5 to 2000 The value of this parameter must be greater than or equal to the size of the snapshot specified by the SnapshotID parameter.
     */
    @JsonProperty("Size")
    public Long getSize() {
        return size;
    }

    /**
     * Size of the data disk N. Valid values of N: 1 to 16. Unit: GiB. Valid values:<br><p> <br><p> Valid values when DataDisk.N.Category is set to cloud_efficiency: 20 to 32768 Valid values when DataDisk.N.Category is set to cloud_ssd: 20 to 32768 Valid values when DataDisk.N.Category is set to cloud_essd: 20 to 32768 Valid values when DataDisk.N.Category is set to cloud: 5 to 2000 The value of this parameter must be greater than or equal to the size of the snapshot specified by the SnapshotID parameter.
     */
    @JsonProperty("Size")
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * SnapshotID is the ID of the snapshot used to create data disk N. Valid values of N: 1 to 16.<br><p> <br><p> When the DataDisk.N.SnapshotID parameter is specified, the DataDisk.N.Size parameter is ignored. The data disk is created based on the size of the specified snapshot. Use snapshots created after July 15, 2013. Otherwise, an error is returned and your request is rejected.
     */
    @JsonProperty("SnapshotID")
    public String getSnapshotID() {
        return snapshotID;
    }

    /**
     * SnapshotID is the ID of the snapshot used to create data disk N. Valid values of N: 1 to 16.<br><p> <br><p> When the DataDisk.N.SnapshotID parameter is specified, the DataDisk.N.Size parameter is ignored. The data disk is created based on the size of the specified snapshot. Use snapshots created after July 15, 2013. Otherwise, an error is returned and your request is rejected.
     */
    @JsonProperty("SnapshotID")
    public void setSnapshotID(String snapshotID) {
        this.snapshotID = snapshotID;
    }

    @JsonIgnore
    public DataDiskPropertiesBuilder edit() {
        return new DataDiskPropertiesBuilder(this);
    }

    @JsonIgnore
    public DataDiskPropertiesBuilder toBuilder() {
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
