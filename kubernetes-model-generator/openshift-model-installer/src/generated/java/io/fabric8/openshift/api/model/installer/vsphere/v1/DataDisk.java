
package io.fabric8.openshift.api.model.installer.vsphere.v1;

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
 * DataDisk defines a data disk to add to the VM that is not part of the VM OVA template.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "provisioningMode",
    "sizeGiB"
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
public class DataDisk implements Editable<DataDiskBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("provisioningMode")
    private String provisioningMode;
    @JsonProperty("sizeGiB")
    private Integer sizeGiB;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DataDisk() {
    }

    public DataDisk(String name, String provisioningMode, Integer sizeGiB) {
        super();
        this.name = name;
        this.provisioningMode = provisioningMode;
        this.sizeGiB = sizeGiB;
    }

    /**
     * name is used to identify the disk definition. name is required needs to be unique so that it can be used to clearly identify purpose of the disk.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is used to identify the disk definition. name is required needs to be unique so that it can be used to clearly identify purpose of the disk.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * provisioningMode is an optional field that specifies the provisioning type to be used by this vSphere data disk. Allowed values are "Thin", "Thick", "EagerlyZeroed", and omitted. When set to Thin, the disk will be made using thin provisioning allocating the bare minimum space. When set to Thick, the full disk size will be allocated when disk is created. When set to EagerlyZeroed, the disk will be created using eager zero provisioning. An eager zeroed thick disk has all space allocated and wiped clean of any previous contents on the physical media at creation time. Such disks may take longer time during creation compared to other disk formats. When omitted, no setting will be applied to the data disk and the provisioning mode for the disk will be determined by the default storage policy configured for the datastore in vSphere.
     */
    @JsonProperty("provisioningMode")
    public String getProvisioningMode() {
        return provisioningMode;
    }

    /**
     * provisioningMode is an optional field that specifies the provisioning type to be used by this vSphere data disk. Allowed values are "Thin", "Thick", "EagerlyZeroed", and omitted. When set to Thin, the disk will be made using thin provisioning allocating the bare minimum space. When set to Thick, the full disk size will be allocated when disk is created. When set to EagerlyZeroed, the disk will be created using eager zero provisioning. An eager zeroed thick disk has all space allocated and wiped clean of any previous contents on the physical media at creation time. Such disks may take longer time during creation compared to other disk formats. When omitted, no setting will be applied to the data disk and the provisioning mode for the disk will be determined by the default storage policy configured for the datastore in vSphere.
     */
    @JsonProperty("provisioningMode")
    public void setProvisioningMode(String provisioningMode) {
        this.provisioningMode = provisioningMode;
    }

    /**
     * sizeGiB is the size of the disk in GiB. The maximum supported size is 16384 GiB.
     */
    @JsonProperty("sizeGiB")
    public Integer getSizeGiB() {
        return sizeGiB;
    }

    /**
     * sizeGiB is the size of the disk in GiB. The maximum supported size is 16384 GiB.
     */
    @JsonProperty("sizeGiB")
    public void setSizeGiB(Integer sizeGiB) {
        this.sizeGiB = sizeGiB;
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
