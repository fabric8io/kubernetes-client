
package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "driver",
    "parent-device",
    "path",
    "pci-address",
    "pf-pci-address",
    "representor-device"
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
public class VdpaDevice implements Editable<VdpaDeviceBuilder>, KubernetesResource
{

    @JsonProperty("driver")
    private String driver;
    @JsonProperty("parent-device")
    private String parentDevice;
    @JsonProperty("path")
    private String path;
    @JsonProperty("pci-address")
    private String pciAddress;
    @JsonProperty("pf-pci-address")
    private String pfPciAddress;
    @JsonProperty("representor-device")
    private String representorDevice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VdpaDevice() {
    }

    public VdpaDevice(String driver, String parentDevice, String path, String pciAddress, String pfPciAddress, String representorDevice) {
        super();
        this.driver = driver;
        this.parentDevice = parentDevice;
        this.path = path;
        this.pciAddress = pciAddress;
        this.pfPciAddress = pfPciAddress;
        this.representorDevice = representorDevice;
    }

    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    @JsonProperty("parent-device")
    public String getParentDevice() {
        return parentDevice;
    }

    @JsonProperty("parent-device")
    public void setParentDevice(String parentDevice) {
        this.parentDevice = parentDevice;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("pci-address")
    public String getPciAddress() {
        return pciAddress;
    }

    @JsonProperty("pci-address")
    public void setPciAddress(String pciAddress) {
        this.pciAddress = pciAddress;
    }

    @JsonProperty("pf-pci-address")
    public String getPfPciAddress() {
        return pfPciAddress;
    }

    @JsonProperty("pf-pci-address")
    public void setPfPciAddress(String pfPciAddress) {
        this.pfPciAddress = pfPciAddress;
    }

    @JsonProperty("representor-device")
    public String getRepresentorDevice() {
        return representorDevice;
    }

    @JsonProperty("representor-device")
    public void setRepresentorDevice(String representorDevice) {
        this.representorDevice = representorDevice;
    }

    @JsonIgnore
    public VdpaDeviceBuilder edit() {
        return new VdpaDeviceBuilder(this);
    }

    @JsonIgnore
    public VdpaDeviceBuilder toBuilder() {
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
        if (!(o instanceof VdpaDevice)) {
            return false;
        }
        VdpaDevice other = (VdpaDevice) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$driver = this.getDriver();
        Object other$driver = other.getDriver();
        if (this$driver == null ? other$driver != null : !this$driver.equals(other$driver)) {
            return false;
        }
        Object this$parentDevice = this.getParentDevice();
        Object other$parentDevice = other.getParentDevice();
        if (this$parentDevice == null ? other$parentDevice != null : !this$parentDevice.equals(other$parentDevice)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$pciAddress = this.getPciAddress();
        Object other$pciAddress = other.getPciAddress();
        if (this$pciAddress == null ? other$pciAddress != null : !this$pciAddress.equals(other$pciAddress)) {
            return false;
        }
        Object this$pfPciAddress = this.getPfPciAddress();
        Object other$pfPciAddress = other.getPfPciAddress();
        if (this$pfPciAddress == null ? other$pfPciAddress != null : !this$pfPciAddress.equals(other$pfPciAddress)) {
            return false;
        }
        Object this$representorDevice = this.getRepresentorDevice();
        Object other$representorDevice = other.getRepresentorDevice();
        if (this$representorDevice == null ? other$representorDevice != null : !this$representorDevice.equals(other$representorDevice)) {
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
        return other instanceof VdpaDevice;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $driver = this.getDriver();
        result = result * prime + ($driver == null ? 43 : $driver.hashCode());
        Object $parentDevice = this.getParentDevice();
        result = result * prime + ($parentDevice == null ? 43 : $parentDevice.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $pciAddress = this.getPciAddress();
        result = result * prime + ($pciAddress == null ? 43 : $pciAddress.hashCode());
        Object $pfPciAddress = this.getPfPciAddress();
        result = result * prime + ($pfPciAddress == null ? 43 : $pfPciAddress.hashCode());
        Object $representorDevice = this.getRepresentorDevice();
        result = result * prime + ($representorDevice == null ? 43 : $representorDevice.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "VdpaDevice(" + "driver=" + this.getDriver() + ", parentDevice=" + this.getParentDevice() + ", path=" + this.getPath() + ", pciAddress=" + this.getPciAddress() + ", pfPciAddress=" + this.getPfPciAddress() + ", representorDevice=" + this.getRepresentorDevice() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
