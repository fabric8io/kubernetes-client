
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * EBSBlockDeviceSpec describes a block device for an EBS volume. https://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/EbsBlockDevice
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deleteOnTermination",
    "encrypted",
    "iops",
    "kmsKey",
    "volumeSize",
    "volumeType"
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
public class EBSBlockDeviceSpec implements Editable<EBSBlockDeviceSpecBuilder>, KubernetesResource
{

    @JsonProperty("deleteOnTermination")
    private Boolean deleteOnTermination;
    @JsonProperty("encrypted")
    private Boolean encrypted;
    @JsonProperty("iops")
    private Long iops;
    @JsonProperty("kmsKey")
    private AWSResourceReference kmsKey;
    @JsonProperty("volumeSize")
    private Long volumeSize;
    @JsonProperty("volumeType")
    private String volumeType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EBSBlockDeviceSpec() {
    }

    public EBSBlockDeviceSpec(Boolean deleteOnTermination, Boolean encrypted, Long iops, AWSResourceReference kmsKey, Long volumeSize, String volumeType) {
        super();
        this.deleteOnTermination = deleteOnTermination;
        this.encrypted = encrypted;
        this.iops = iops;
        this.kmsKey = kmsKey;
        this.volumeSize = volumeSize;
        this.volumeType = volumeType;
    }

    /**
     * Indicates whether the EBS volume is deleted on machine termination.<br><p> <br><p> Deprecated: setting this field has no effect.
     */
    @JsonProperty("deleteOnTermination")
    public Boolean getDeleteOnTermination() {
        return deleteOnTermination;
    }

    /**
     * Indicates whether the EBS volume is deleted on machine termination.<br><p> <br><p> Deprecated: setting this field has no effect.
     */
    @JsonProperty("deleteOnTermination")
    public void setDeleteOnTermination(Boolean deleteOnTermination) {
        this.deleteOnTermination = deleteOnTermination;
    }

    /**
     * Indicates whether the EBS volume is encrypted. Encrypted Amazon EBS volumes may only be attached to machines that support Amazon EBS encryption.
     */
    @JsonProperty("encrypted")
    public Boolean getEncrypted() {
        return encrypted;
    }

    /**
     * Indicates whether the EBS volume is encrypted. Encrypted Amazon EBS volumes may only be attached to machines that support Amazon EBS encryption.
     */
    @JsonProperty("encrypted")
    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    /**
     * The number of I/O operations per second (IOPS) that the volume supports. For io1, this represents the number of IOPS that are provisioned for the volume. For gp2, this represents the baseline performance of the volume and the rate at which the volume accumulates I/O credits for bursting. For more information about General Purpose SSD baseline performance, I/O credits, and bursting, see Amazon EBS Volume Types (http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumeTypes.html) in the Amazon Elastic Compute Cloud User Guide.<br><p> <br><p> Minimal and maximal IOPS for io1 and gp2 are constrained. Please, check https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumeTypes.html for precise boundaries for individual volumes.<br><p> <br><p> Condition: This parameter is required for requests to create io1 volumes; it is not used in requests to create gp2, st1, sc1, or standard volumes.
     */
    @JsonProperty("iops")
    public Long getIops() {
        return iops;
    }

    /**
     * The number of I/O operations per second (IOPS) that the volume supports. For io1, this represents the number of IOPS that are provisioned for the volume. For gp2, this represents the baseline performance of the volume and the rate at which the volume accumulates I/O credits for bursting. For more information about General Purpose SSD baseline performance, I/O credits, and bursting, see Amazon EBS Volume Types (http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumeTypes.html) in the Amazon Elastic Compute Cloud User Guide.<br><p> <br><p> Minimal and maximal IOPS for io1 and gp2 are constrained. Please, check https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/EBSVolumeTypes.html for precise boundaries for individual volumes.<br><p> <br><p> Condition: This parameter is required for requests to create io1 volumes; it is not used in requests to create gp2, st1, sc1, or standard volumes.
     */
    @JsonProperty("iops")
    public void setIops(Long iops) {
        this.iops = iops;
    }

    /**
     * EBSBlockDeviceSpec describes a block device for an EBS volume. https://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/EbsBlockDevice
     */
    @JsonProperty("kmsKey")
    public AWSResourceReference getKmsKey() {
        return kmsKey;
    }

    /**
     * EBSBlockDeviceSpec describes a block device for an EBS volume. https://docs.aws.amazon.com/goto/WebAPI/ec2-2016-11-15/EbsBlockDevice
     */
    @JsonProperty("kmsKey")
    public void setKmsKey(AWSResourceReference kmsKey) {
        this.kmsKey = kmsKey;
    }

    /**
     * The size of the volume, in GiB.<br><p> <br><p> Constraints: 1-16384 for General Purpose SSD (gp2), 4-16384 for Provisioned IOPS SSD (io1), 500-16384 for Throughput Optimized HDD (st1), 500-16384 for Cold HDD (sc1), and 1-1024 for Magnetic (standard) volumes. If you specify a snapshot, the volume size must be equal to or larger than the snapshot size.<br><p> <br><p> Default: If you're creating the volume from a snapshot and don't specify a volume size, the default is the snapshot size.
     */
    @JsonProperty("volumeSize")
    public Long getVolumeSize() {
        return volumeSize;
    }

    /**
     * The size of the volume, in GiB.<br><p> <br><p> Constraints: 1-16384 for General Purpose SSD (gp2), 4-16384 for Provisioned IOPS SSD (io1), 500-16384 for Throughput Optimized HDD (st1), 500-16384 for Cold HDD (sc1), and 1-1024 for Magnetic (standard) volumes. If you specify a snapshot, the volume size must be equal to or larger than the snapshot size.<br><p> <br><p> Default: If you're creating the volume from a snapshot and don't specify a volume size, the default is the snapshot size.
     */
    @JsonProperty("volumeSize")
    public void setVolumeSize(Long volumeSize) {
        this.volumeSize = volumeSize;
    }

    /**
     * The volume type: gp2, io1, st1, sc1, or standard. Default: standard
     */
    @JsonProperty("volumeType")
    public String getVolumeType() {
        return volumeType;
    }

    /**
     * The volume type: gp2, io1, st1, sc1, or standard. Default: standard
     */
    @JsonProperty("volumeType")
    public void setVolumeType(String volumeType) {
        this.volumeType = volumeType;
    }

    @JsonIgnore
    public EBSBlockDeviceSpecBuilder edit() {
        return new EBSBlockDeviceSpecBuilder(this);
    }

    @JsonIgnore
    public EBSBlockDeviceSpecBuilder toBuilder() {
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
