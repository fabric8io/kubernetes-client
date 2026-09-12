
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
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * NutanixVMStorageConfig specifies the storage configuration parameters for VM disks.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "diskMode",
    "storageContainer"
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
public class NutanixVMStorageConfig implements Editable<NutanixVMStorageConfigBuilder>, KubernetesResource
{

    @JsonProperty("diskMode")
    private String diskMode;
    @JsonProperty("storageContainer")
    private NutanixStorageResourceIdentifier storageContainer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NutanixVMStorageConfig() {
    }

    public NutanixVMStorageConfig(String diskMode, NutanixStorageResourceIdentifier storageContainer) {
        super();
        this.diskMode = diskMode;
        this.storageContainer = storageContainer;
    }

    /**
     * diskMode specifies the disk mode. The valid values are Standard and Flash, and the default is Standard.
     */
    @JsonProperty("diskMode")
    public String getDiskMode() {
        return diskMode;
    }

    /**
     * diskMode specifies the disk mode. The valid values are Standard and Flash, and the default is Standard.
     */
    @JsonProperty("diskMode")
    public void setDiskMode(String diskMode) {
        this.diskMode = diskMode;
    }

    /**
     * NutanixVMStorageConfig specifies the storage configuration parameters for VM disks.
     */
    @JsonProperty("storageContainer")
    public NutanixStorageResourceIdentifier getStorageContainer() {
        return storageContainer;
    }

    /**
     * NutanixVMStorageConfig specifies the storage configuration parameters for VM disks.
     */
    @JsonProperty("storageContainer")
    public void setStorageContainer(NutanixStorageResourceIdentifier storageContainer) {
        this.storageContainer = storageContainer;
    }

    @JsonIgnore
    public NutanixVMStorageConfigBuilder edit() {
        return new NutanixVMStorageConfigBuilder(this);
    }

    @JsonIgnore
    public NutanixVMStorageConfigBuilder toBuilder() {
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
        if (!(o instanceof NutanixVMStorageConfig)) {
            return false;
        }
        NutanixVMStorageConfig other = (NutanixVMStorageConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$diskMode = this.getDiskMode();
        Object other$diskMode = other.getDiskMode();
        if (this$diskMode == null ? other$diskMode != null : !this$diskMode.equals(other$diskMode)) {
            return false;
        }
        Object this$storageContainer = this.getStorageContainer();
        Object other$storageContainer = other.getStorageContainer();
        if (this$storageContainer == null ? other$storageContainer != null : !this$storageContainer.equals(other$storageContainer)) {
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
        return other instanceof NutanixVMStorageConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $diskMode = this.getDiskMode();
        result = result * prime + ($diskMode == null ? 43 : $diskMode.hashCode());
        Object $storageContainer = this.getStorageContainer();
        result = result * prime + ($storageContainer == null ? 43 : $storageContainer.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NutanixVMStorageConfig(" + "diskMode=" + this.getDiskMode() + ", storageContainer=" + this.getStorageContainer() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
