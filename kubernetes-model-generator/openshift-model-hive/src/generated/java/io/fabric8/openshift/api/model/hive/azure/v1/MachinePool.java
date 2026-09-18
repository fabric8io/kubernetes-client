
package io.fabric8.openshift.api.model.hive.azure.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * MachinePool stores the configuration for a machine pool installed on Azure.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "computeSubnet",
    "networkResourceGroupName",
    "osDisk",
    "osImage",
    "type",
    "virtualNetwork",
    "vmNetworkingType",
    "zones"
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
public class MachinePool implements Editable<MachinePoolBuilder>, KubernetesResource
{

    @JsonProperty("computeSubnet")
    private String computeSubnet;
    @JsonProperty("networkResourceGroupName")
    private String networkResourceGroupName;
    @JsonProperty("osDisk")
    private OSDisk osDisk;
    @JsonProperty("osImage")
    private OSImage osImage;
    @JsonProperty("type")
    private String type;
    @JsonProperty("virtualNetwork")
    private String virtualNetwork;
    @JsonProperty("vmNetworkingType")
    private String vmNetworkingType;
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> zones = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachinePool() {
    }

    public MachinePool(String computeSubnet, String networkResourceGroupName, OSDisk osDisk, OSImage osImage, String type, String virtualNetwork, String vmNetworkingType, List<String> zones) {
        super();
        this.computeSubnet = computeSubnet;
        this.networkResourceGroupName = networkResourceGroupName;
        this.osDisk = osDisk;
        this.osImage = osImage;
        this.type = type;
        this.virtualNetwork = virtualNetwork;
        this.vmNetworkingType = vmNetworkingType;
        this.zones = zones;
    }

    /**
     * ComputeSubnet specifies an existing subnet for use by compute nodes. If omitted, the default (${infraID}-worker-subnet) will be used.
     */
    @JsonProperty("computeSubnet")
    public String getComputeSubnet() {
        return computeSubnet;
    }

    /**
     * ComputeSubnet specifies an existing subnet for use by compute nodes. If omitted, the default (${infraID}-worker-subnet) will be used.
     */
    @JsonProperty("computeSubnet")
    public void setComputeSubnet(String computeSubnet) {
        this.computeSubnet = computeSubnet;
    }

    /**
     * NetworkResourceGroupName specifies the network resource group that contains an existing VNet. Ignored unless VirtualNetwork is also specified.
     */
    @JsonProperty("networkResourceGroupName")
    public String getNetworkResourceGroupName() {
        return networkResourceGroupName;
    }

    /**
     * NetworkResourceGroupName specifies the network resource group that contains an existing VNet. Ignored unless VirtualNetwork is also specified.
     */
    @JsonProperty("networkResourceGroupName")
    public void setNetworkResourceGroupName(String networkResourceGroupName) {
        this.networkResourceGroupName = networkResourceGroupName;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("osDisk")
    public OSDisk getOsDisk() {
        return osDisk;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("osDisk")
    public void setOsDisk(OSDisk osDisk) {
        this.osDisk = osDisk;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("osImage")
    public OSImage getOsImage() {
        return osImage;
    }

    /**
     * MachinePool stores the configuration for a machine pool installed on Azure.
     */
    @JsonProperty("osImage")
    public void setOsImage(OSImage osImage) {
        this.osImage = osImage;
    }

    /**
     * InstanceType defines the azure instance type. eg. Standard_DS_V2
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * InstanceType defines the azure instance type. eg. Standard_DS_V2
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * VirtualNetwork specifies the name of an existing VNet for the Machines to use If omitted, the default (${infraID}-vnet) will be used.
     */
    @JsonProperty("virtualNetwork")
    public String getVirtualNetwork() {
        return virtualNetwork;
    }

    /**
     * VirtualNetwork specifies the name of an existing VNet for the Machines to use If omitted, the default (${infraID}-vnet) will be used.
     */
    @JsonProperty("virtualNetwork")
    public void setVirtualNetwork(String virtualNetwork) {
        this.virtualNetwork = virtualNetwork;
    }

    /**
     * VMNetworkingType specifies whether to enable accelerated networking. Accelerated networking enables single root I/O virtualization (SR-IOV) to a VM, greatly improving its networking performance. eg. values: "Accelerated", "Basic"
     */
    @JsonProperty("vmNetworkingType")
    public String getVmNetworkingType() {
        return vmNetworkingType;
    }

    /**
     * VMNetworkingType specifies whether to enable accelerated networking. Accelerated networking enables single root I/O virtualization (SR-IOV) to a VM, greatly improving its networking performance. eg. values: "Accelerated", "Basic"
     */
    @JsonProperty("vmNetworkingType")
    public void setVmNetworkingType(String vmNetworkingType) {
        this.vmNetworkingType = vmNetworkingType;
    }

    /**
     * Zones is list of availability zones that can be used. eg. ["1", "2", "3"]
     */
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getZones() {
        return zones;
    }

    /**
     * Zones is list of availability zones that can be used. eg. ["1", "2", "3"]
     */
    @JsonProperty("zones")
    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    @JsonIgnore
    public MachinePoolBuilder edit() {
        return new MachinePoolBuilder(this);
    }

    @JsonIgnore
    public MachinePoolBuilder toBuilder() {
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
        if (!(o instanceof MachinePool)) {
            return false;
        }
        MachinePool other = (MachinePool) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$computeSubnet = this.getComputeSubnet();
        Object other$computeSubnet = other.getComputeSubnet();
        if (this$computeSubnet == null ? other$computeSubnet != null : !this$computeSubnet.equals(other$computeSubnet)) {
            return false;
        }
        Object this$networkResourceGroupName = this.getNetworkResourceGroupName();
        Object other$networkResourceGroupName = other.getNetworkResourceGroupName();
        if (this$networkResourceGroupName == null ? other$networkResourceGroupName != null : !this$networkResourceGroupName.equals(other$networkResourceGroupName)) {
            return false;
        }
        Object this$osDisk = this.getOsDisk();
        Object other$osDisk = other.getOsDisk();
        if (this$osDisk == null ? other$osDisk != null : !this$osDisk.equals(other$osDisk)) {
            return false;
        }
        Object this$osImage = this.getOsImage();
        Object other$osImage = other.getOsImage();
        if (this$osImage == null ? other$osImage != null : !this$osImage.equals(other$osImage)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$virtualNetwork = this.getVirtualNetwork();
        Object other$virtualNetwork = other.getVirtualNetwork();
        if (this$virtualNetwork == null ? other$virtualNetwork != null : !this$virtualNetwork.equals(other$virtualNetwork)) {
            return false;
        }
        Object this$vmNetworkingType = this.getVmNetworkingType();
        Object other$vmNetworkingType = other.getVmNetworkingType();
        if (this$vmNetworkingType == null ? other$vmNetworkingType != null : !this$vmNetworkingType.equals(other$vmNetworkingType)) {
            return false;
        }
        Object this$zones = this.getZones();
        Object other$zones = other.getZones();
        if (this$zones == null ? other$zones != null : !this$zones.equals(other$zones)) {
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
        return other instanceof MachinePool;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $computeSubnet = this.getComputeSubnet();
        result = result * prime + ($computeSubnet == null ? 43 : $computeSubnet.hashCode());
        Object $networkResourceGroupName = this.getNetworkResourceGroupName();
        result = result * prime + ($networkResourceGroupName == null ? 43 : $networkResourceGroupName.hashCode());
        Object $osDisk = this.getOsDisk();
        result = result * prime + ($osDisk == null ? 43 : $osDisk.hashCode());
        Object $osImage = this.getOsImage();
        result = result * prime + ($osImage == null ? 43 : $osImage.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $virtualNetwork = this.getVirtualNetwork();
        result = result * prime + ($virtualNetwork == null ? 43 : $virtualNetwork.hashCode());
        Object $vmNetworkingType = this.getVmNetworkingType();
        result = result * prime + ($vmNetworkingType == null ? 43 : $vmNetworkingType.hashCode());
        Object $zones = this.getZones();
        result = result * prime + ($zones == null ? 43 : $zones.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachinePool(" + "computeSubnet=" + this.getComputeSubnet() + ", networkResourceGroupName=" + this.getNetworkResourceGroupName() + ", osDisk=" + this.getOsDisk() + ", osImage=" + this.getOsImage() + ", type=" + this.getType() + ", virtualNetwork=" + this.getVirtualNetwork() + ", vmNetworkingType=" + this.getVmNetworkingType() + ", zones=" + this.getZones() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
