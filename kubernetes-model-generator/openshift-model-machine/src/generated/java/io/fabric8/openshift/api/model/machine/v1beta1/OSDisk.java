
package io.fabric8.openshift.api.model.machine.v1beta1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cachingType",
    "diskSettings",
    "diskSizeGB",
    "managedDisk",
    "osType"
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

    @JsonProperty("cachingType")
    private String cachingType;
    @JsonProperty("diskSettings")
    private DiskSettings diskSettings;
    @JsonProperty("diskSizeGB")
    private Integer diskSizeGB;
    @JsonProperty("managedDisk")
    private OSDiskManagedDiskParameters managedDisk;
    @JsonProperty("osType")
    private String osType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OSDisk() {
    }

    public OSDisk(String cachingType, DiskSettings diskSettings, Integer diskSizeGB, OSDiskManagedDiskParameters managedDisk, String osType) {
        super();
        this.cachingType = cachingType;
        this.diskSettings = diskSettings;
        this.diskSizeGB = diskSizeGB;
        this.managedDisk = managedDisk;
        this.osType = osType;
    }

    /**
     * CachingType specifies the caching requirements. Possible values include: 'None', 'ReadOnly', 'ReadWrite'. Empty value means no opinion and the platform chooses a default, which is subject to change over time. Currently the default is `None`.
     */
    @JsonProperty("cachingType")
    public String getCachingType() {
        return cachingType;
    }

    /**
     * CachingType specifies the caching requirements. Possible values include: 'None', 'ReadOnly', 'ReadWrite'. Empty value means no opinion and the platform chooses a default, which is subject to change over time. Currently the default is `None`.
     */
    @JsonProperty("cachingType")
    public void setCachingType(String cachingType) {
        this.cachingType = cachingType;
    }

    @JsonProperty("diskSettings")
    public DiskSettings getDiskSettings() {
        return diskSettings;
    }

    @JsonProperty("diskSettings")
    public void setDiskSettings(DiskSettings diskSettings) {
        this.diskSettings = diskSettings;
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

    @JsonProperty("managedDisk")
    public OSDiskManagedDiskParameters getManagedDisk() {
        return managedDisk;
    }

    @JsonProperty("managedDisk")
    public void setManagedDisk(OSDiskManagedDiskParameters managedDisk) {
        this.managedDisk = managedDisk;
    }

    /**
     * OSType is the operating system type of the OS disk. Possible values include "Linux" and "Windows".
     */
    @JsonProperty("osType")
    public String getOsType() {
        return osType;
    }

    /**
     * OSType is the operating system type of the OS disk. Possible values include "Linux" and "Windows".
     */
    @JsonProperty("osType")
    public void setOsType(String osType) {
        this.osType = osType;
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
