
package io.fabric8.openshift.api.model.machine.v1;

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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * NutanixDataDisk specifies the VM data disk configuration parameters.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dataSource",
    "deviceProperties",
    "diskSize",
    "storageConfig"
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
public class NutanixVMDisk implements Editable<NutanixVMDiskBuilder>, KubernetesResource
{

    @JsonProperty("dataSource")
    private NutanixResourceIdentifier dataSource;
    @JsonProperty("deviceProperties")
    private NutanixVMDiskDeviceProperties deviceProperties;
    @JsonProperty("diskSize")
    private Quantity diskSize;
    @JsonProperty("storageConfig")
    private NutanixVMStorageConfig storageConfig;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NutanixVMDisk() {
    }

    public NutanixVMDisk(NutanixResourceIdentifier dataSource, NutanixVMDiskDeviceProperties deviceProperties, Quantity diskSize, NutanixVMStorageConfig storageConfig) {
        super();
        this.dataSource = dataSource;
        this.deviceProperties = deviceProperties;
        this.diskSize = diskSize;
        this.storageConfig = storageConfig;
    }

    /**
     * NutanixDataDisk specifies the VM data disk configuration parameters.
     */
    @JsonProperty("dataSource")
    public NutanixResourceIdentifier getDataSource() {
        return dataSource;
    }

    /**
     * NutanixDataDisk specifies the VM data disk configuration parameters.
     */
    @JsonProperty("dataSource")
    public void setDataSource(NutanixResourceIdentifier dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * NutanixDataDisk specifies the VM data disk configuration parameters.
     */
    @JsonProperty("deviceProperties")
    public NutanixVMDiskDeviceProperties getDeviceProperties() {
        return deviceProperties;
    }

    /**
     * NutanixDataDisk specifies the VM data disk configuration parameters.
     */
    @JsonProperty("deviceProperties")
    public void setDeviceProperties(NutanixVMDiskDeviceProperties deviceProperties) {
        this.deviceProperties = deviceProperties;
    }

    /**
     * NutanixDataDisk specifies the VM data disk configuration parameters.
     */
    @JsonProperty("diskSize")
    public Quantity getDiskSize() {
        return diskSize;
    }

    /**
     * NutanixDataDisk specifies the VM data disk configuration parameters.
     */
    @JsonProperty("diskSize")
    public void setDiskSize(Quantity diskSize) {
        this.diskSize = diskSize;
    }

    /**
     * NutanixDataDisk specifies the VM data disk configuration parameters.
     */
    @JsonProperty("storageConfig")
    public NutanixVMStorageConfig getStorageConfig() {
        return storageConfig;
    }

    /**
     * NutanixDataDisk specifies the VM data disk configuration parameters.
     */
    @JsonProperty("storageConfig")
    public void setStorageConfig(NutanixVMStorageConfig storageConfig) {
        this.storageConfig = storageConfig;
    }

    @JsonIgnore
    public NutanixVMDiskBuilder edit() {
        return new NutanixVMDiskBuilder(this);
    }

    @JsonIgnore
    public NutanixVMDiskBuilder toBuilder() {
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
        if (!(o instanceof NutanixVMDisk)) {
            return false;
        }
        NutanixVMDisk other = (NutanixVMDisk) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dataSource = this.getDataSource();
        Object other$dataSource = other.getDataSource();
        if (this$dataSource == null ? other$dataSource != null : !this$dataSource.equals(other$dataSource)) {
            return false;
        }
        Object this$deviceProperties = this.getDeviceProperties();
        Object other$deviceProperties = other.getDeviceProperties();
        if (this$deviceProperties == null ? other$deviceProperties != null : !this$deviceProperties.equals(other$deviceProperties)) {
            return false;
        }
        Object this$diskSize = this.getDiskSize();
        Object other$diskSize = other.getDiskSize();
        if (this$diskSize == null ? other$diskSize != null : !this$diskSize.equals(other$diskSize)) {
            return false;
        }
        Object this$storageConfig = this.getStorageConfig();
        Object other$storageConfig = other.getStorageConfig();
        if (this$storageConfig == null ? other$storageConfig != null : !this$storageConfig.equals(other$storageConfig)) {
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
        return other instanceof NutanixVMDisk;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dataSource = this.getDataSource();
        result = result * prime + ($dataSource == null ? 43 : $dataSource.hashCode());
        Object $deviceProperties = this.getDeviceProperties();
        result = result * prime + ($deviceProperties == null ? 43 : $deviceProperties.hashCode());
        Object $diskSize = this.getDiskSize();
        result = result * prime + ($diskSize == null ? 43 : $diskSize.hashCode());
        Object $storageConfig = this.getStorageConfig();
        result = result * prime + ($storageConfig == null ? 43 : $storageConfig.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NutanixVMDisk(" + "dataSource=" + this.getDataSource() + ", deviceProperties=" + this.getDeviceProperties() + ", diskSize=" + this.getDiskSize() + ", storageConfig=" + this.getStorageConfig() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
