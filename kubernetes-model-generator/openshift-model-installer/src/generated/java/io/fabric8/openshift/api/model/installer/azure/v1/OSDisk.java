
package io.fabric8.openshift.api.model.installer.azure.v1;

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
 * OSDisk defines the disk for machines on Azure.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "diskEncryptionSet",
    "diskSizeGB",
    "diskType",
    "securityProfile"
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
public class OSDisk implements Editable<OSDiskBuilder>, KubernetesResource
{

    @JsonProperty("diskEncryptionSet")
    private DiskEncryptionSet diskEncryptionSet;
    @JsonProperty("diskSizeGB")
    private Integer diskSizeGB;
    @JsonProperty("diskType")
    private String diskType;
    @JsonProperty("securityProfile")
    private VMDiskSecurityProfile securityProfile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OSDisk() {
    }

    public OSDisk(DiskEncryptionSet diskEncryptionSet, Integer diskSizeGB, String diskType, VMDiskSecurityProfile securityProfile) {
        super();
        this.diskEncryptionSet = diskEncryptionSet;
        this.diskSizeGB = diskSizeGB;
        this.diskType = diskType;
        this.securityProfile = securityProfile;
    }

    /**
     * OSDisk defines the disk for machines on Azure.
     */
    @JsonProperty("diskEncryptionSet")
    public DiskEncryptionSet getDiskEncryptionSet() {
        return diskEncryptionSet;
    }

    /**
     * OSDisk defines the disk for machines on Azure.
     */
    @JsonProperty("diskEncryptionSet")
    public void setDiskEncryptionSet(DiskEncryptionSet diskEncryptionSet) {
        this.diskEncryptionSet = diskEncryptionSet;
    }

    /**
     * DiskSizeGB defines the size of disk in GB.
     */
    @JsonProperty("diskSizeGB")
    public Integer getDiskSizeGB() {
        return diskSizeGB;
    }

    /**
     * DiskSizeGB defines the size of disk in GB.
     */
    @JsonProperty("diskSizeGB")
    public void setDiskSizeGB(Integer diskSizeGB) {
        this.diskSizeGB = diskSizeGB;
    }

    /**
     * DiskType defines the type of disk. For control plane nodes, the valid values are Premium_LRS and StandardSSD_LRS. Default is Premium_LRS.
     */
    @JsonProperty("diskType")
    public String getDiskType() {
        return diskType;
    }

    /**
     * DiskType defines the type of disk. For control plane nodes, the valid values are Premium_LRS and StandardSSD_LRS. Default is Premium_LRS.
     */
    @JsonProperty("diskType")
    public void setDiskType(String diskType) {
        this.diskType = diskType;
    }

    /**
     * OSDisk defines the disk for machines on Azure.
     */
    @JsonProperty("securityProfile")
    public VMDiskSecurityProfile getSecurityProfile() {
        return securityProfile;
    }

    /**
     * OSDisk defines the disk for machines on Azure.
     */
    @JsonProperty("securityProfile")
    public void setSecurityProfile(VMDiskSecurityProfile securityProfile) {
        this.securityProfile = securityProfile;
    }

    @JsonIgnore
    public OSDiskBuilder edit() {
        return new OSDiskBuilder(this);
    }

    @JsonIgnore
    public OSDiskBuilder toBuilder() {
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
