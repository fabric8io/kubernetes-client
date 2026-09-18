
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
    "pci-address",
    "pf-pci-address",
    "rdma-device",
    "representor-device",
    "vhost-net"
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
public class PciDevice implements Editable<PciDeviceBuilder>, KubernetesResource
{

    @JsonProperty("pci-address")
    private String pciAddress;
    @JsonProperty("pf-pci-address")
    private String pfPciAddress;
    @JsonProperty("rdma-device")
    private String rdmaDevice;
    @JsonProperty("representor-device")
    private String representorDevice;
    @JsonProperty("vhost-net")
    private String vhostNet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PciDevice() {
    }

    public PciDevice(String pciAddress, String pfPciAddress, String rdmaDevice, String representorDevice, String vhostNet) {
        super();
        this.pciAddress = pciAddress;
        this.pfPciAddress = pfPciAddress;
        this.rdmaDevice = rdmaDevice;
        this.representorDevice = representorDevice;
        this.vhostNet = vhostNet;
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

    @JsonProperty("rdma-device")
    public String getRdmaDevice() {
        return rdmaDevice;
    }

    @JsonProperty("rdma-device")
    public void setRdmaDevice(String rdmaDevice) {
        this.rdmaDevice = rdmaDevice;
    }

    @JsonProperty("representor-device")
    public String getRepresentorDevice() {
        return representorDevice;
    }

    @JsonProperty("representor-device")
    public void setRepresentorDevice(String representorDevice) {
        this.representorDevice = representorDevice;
    }

    @JsonProperty("vhost-net")
    public String getVhostNet() {
        return vhostNet;
    }

    @JsonProperty("vhost-net")
    public void setVhostNet(String vhostNet) {
        this.vhostNet = vhostNet;
    }

    @JsonIgnore
    public PciDeviceBuilder edit() {
        return new PciDeviceBuilder(this);
    }

    @JsonIgnore
    public PciDeviceBuilder toBuilder() {
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
        if (!(o instanceof PciDevice)) {
            return false;
        }
        PciDevice other = (PciDevice) o;
        if (!other.canEqual(this)) {
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
        Object this$rdmaDevice = this.getRdmaDevice();
        Object other$rdmaDevice = other.getRdmaDevice();
        if (this$rdmaDevice == null ? other$rdmaDevice != null : !this$rdmaDevice.equals(other$rdmaDevice)) {
            return false;
        }
        Object this$representorDevice = this.getRepresentorDevice();
        Object other$representorDevice = other.getRepresentorDevice();
        if (this$representorDevice == null ? other$representorDevice != null : !this$representorDevice.equals(other$representorDevice)) {
            return false;
        }
        Object this$vhostNet = this.getVhostNet();
        Object other$vhostNet = other.getVhostNet();
        if (this$vhostNet == null ? other$vhostNet != null : !this$vhostNet.equals(other$vhostNet)) {
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
        return other instanceof PciDevice;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $pciAddress = this.getPciAddress();
        result = result * prime + ($pciAddress == null ? 43 : $pciAddress.hashCode());
        Object $pfPciAddress = this.getPfPciAddress();
        result = result * prime + ($pfPciAddress == null ? 43 : $pfPciAddress.hashCode());
        Object $rdmaDevice = this.getRdmaDevice();
        result = result * prime + ($rdmaDevice == null ? 43 : $rdmaDevice.hashCode());
        Object $representorDevice = this.getRepresentorDevice();
        result = result * prime + ($representorDevice == null ? 43 : $representorDevice.hashCode());
        Object $vhostNet = this.getVhostNet();
        result = result * prime + ($vhostNet == null ? 43 : $vhostNet.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PciDevice(" + "pciAddress=" + this.getPciAddress() + ", pfPciAddress=" + this.getPfPciAddress() + ", rdmaDevice=" + this.getRdmaDevice() + ", representorDevice=" + this.getRepresentorDevice() + ", vhostNet=" + this.getVhostNet() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
