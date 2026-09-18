
package io.fabric8.openshift.api.model.installer.v1;

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
 * Networking defines the pod network provider in the cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterNetwork",
    "clusterNetworkMTU",
    "clusterNetworks",
    "machineCIDR",
    "machineNetwork",
    "networkType",
    "ovnKubernetesConfig",
    "serviceCIDR",
    "serviceNetwork",
    "type"
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
public class Networking implements Editable<NetworkingBuilder>, KubernetesResource
{

    @JsonProperty("clusterNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterNetworkEntry> clusterNetwork = new ArrayList<>();
    @JsonProperty("clusterNetworkMTU")
    private Long clusterNetworkMTU;
    @JsonProperty("clusterNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterNetworkEntry> clusterNetworkList = new ArrayList<>();
    @JsonProperty("machineCIDR")
    private String machineCIDR;
    @JsonProperty("machineNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MachineNetworkEntry> machineNetwork = new ArrayList<>();
    @JsonProperty("networkType")
    private String networkType;
    @JsonProperty("ovnKubernetesConfig")
    private OVNKubernetesConfig ovnKubernetesConfig;
    @JsonProperty("serviceCIDR")
    private String serviceCIDR;
    @JsonProperty("serviceNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> serviceNetwork = new ArrayList<>();
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Networking() {
    }

    public Networking(List<ClusterNetworkEntry> clusterNetwork, Long clusterNetworkMTU, List<ClusterNetworkEntry> clusterNetworkList, String machineCIDR, List<MachineNetworkEntry> machineNetwork, String networkType, OVNKubernetesConfig ovnKubernetesConfig, String serviceCIDR, List<String> serviceNetwork, String type) {
        super();
        this.clusterNetwork = clusterNetwork;
        this.clusterNetworkMTU = clusterNetworkMTU;
        this.clusterNetworkList = clusterNetworkList;
        this.machineCIDR = machineCIDR;
        this.machineNetwork = machineNetwork;
        this.networkType = networkType;
        this.ovnKubernetesConfig = ovnKubernetesConfig;
        this.serviceCIDR = serviceCIDR;
        this.serviceNetwork = serviceNetwork;
        this.type = type;
    }

    /**
     * ClusterNetwork is the list of IP address pools for pods. Default is 10.128.0.0/14 and a host prefix of /23.
     */
    @JsonProperty("clusterNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterNetworkEntry> getClusterNetwork() {
        return clusterNetwork;
    }

    /**
     * ClusterNetwork is the list of IP address pools for pods. Default is 10.128.0.0/14 and a host prefix of /23.
     */
    @JsonProperty("clusterNetwork")
    public void setClusterNetwork(List<ClusterNetworkEntry> clusterNetwork) {
        this.clusterNetwork = clusterNetwork;
    }

    /**
     * ClusterNetworkMTU is the Maximum Transmit (MTU) Unit size in bytes to allocate to the cluster network. For example, 1200 would set the MTU of the entire overlay network. If the deployment does not require changes in the network plugin, leave it unset and the MTU will be calculated automatically based on the host network MTU.
     */
    @JsonProperty("clusterNetworkMTU")
    public Long getClusterNetworkMTU() {
        return clusterNetworkMTU;
    }

    /**
     * ClusterNetworkMTU is the Maximum Transmit (MTU) Unit size in bytes to allocate to the cluster network. For example, 1200 would set the MTU of the entire overlay network. If the deployment does not require changes in the network plugin, leave it unset and the MTU will be calculated automatically based on the host network MTU.
     */
    @JsonProperty("clusterNetworkMTU")
    public void setClusterNetworkMTU(Long clusterNetworkMTU) {
        this.clusterNetworkMTU = clusterNetworkMTU;
    }

    /**
     * Deprecated name for ClusterNetwork
     */
    @JsonProperty("clusterNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterNetworkEntry> getClusterNetworks() {
        return clusterNetworkList;
    }

    /**
     * Deprecated name for ClusterNetwork
     */
    @JsonProperty("clusterNetworks")
    public void setClusterNetworks(List<ClusterNetworkEntry> clusterNetworkList) {
        this.clusterNetworkList = clusterNetworkList;
    }

    /**
     * Networking defines the pod network provider in the cluster.
     */
    @JsonProperty("machineCIDR")
    public String getMachineCIDR() {
        return machineCIDR;
    }

    /**
     * Networking defines the pod network provider in the cluster.
     */
    @JsonProperty("machineCIDR")
    public void setMachineCIDR(String machineCIDR) {
        this.machineCIDR = machineCIDR;
    }

    /**
     * MachineNetwork is the list of IP address pools for machines. This field replaces MachineCIDR, and if set MachineCIDR must be empty or match the first entry in the list. Default is 10.0.0.0/16 for all platforms other than Power VS. For Power VS, the default is 192.168.0.0/24.
     */
    @JsonProperty("machineNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<MachineNetworkEntry> getMachineNetwork() {
        return machineNetwork;
    }

    /**
     * MachineNetwork is the list of IP address pools for machines. This field replaces MachineCIDR, and if set MachineCIDR must be empty or match the first entry in the list. Default is 10.0.0.0/16 for all platforms other than Power VS. For Power VS, the default is 192.168.0.0/24.
     */
    @JsonProperty("machineNetwork")
    public void setMachineNetwork(List<MachineNetworkEntry> machineNetwork) {
        this.machineNetwork = machineNetwork;
    }

    /**
     * NetworkType is the type of network to install. The default value is OVNKubernetes.
     */
    @JsonProperty("networkType")
    public String getNetworkType() {
        return networkType;
    }

    /**
     * NetworkType is the type of network to install. The default value is OVNKubernetes.
     */
    @JsonProperty("networkType")
    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    /**
     * Networking defines the pod network provider in the cluster.
     */
    @JsonProperty("ovnKubernetesConfig")
    public OVNKubernetesConfig getOvnKubernetesConfig() {
        return ovnKubernetesConfig;
    }

    /**
     * Networking defines the pod network provider in the cluster.
     */
    @JsonProperty("ovnKubernetesConfig")
    public void setOvnKubernetesConfig(OVNKubernetesConfig ovnKubernetesConfig) {
        this.ovnKubernetesConfig = ovnKubernetesConfig;
    }

    /**
     * Networking defines the pod network provider in the cluster.
     */
    @JsonProperty("serviceCIDR")
    public String getServiceCIDR() {
        return serviceCIDR;
    }

    /**
     * Networking defines the pod network provider in the cluster.
     */
    @JsonProperty("serviceCIDR")
    public void setServiceCIDR(String serviceCIDR) {
        this.serviceCIDR = serviceCIDR;
    }

    /**
     * ServiceNetwork is the list of IP address pools for services. Default is 172.30.0.0/16. NOTE: currently only one entry is supported.
     */
    @JsonProperty("serviceNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getServiceNetwork() {
        return serviceNetwork;
    }

    /**
     * ServiceNetwork is the list of IP address pools for services. Default is 172.30.0.0/16. NOTE: currently only one entry is supported.
     */
    @JsonProperty("serviceNetwork")
    public void setServiceNetwork(List<String> serviceNetwork) {
        this.serviceNetwork = serviceNetwork;
    }

    /**
     * Deprecated name for NetworkType
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Deprecated name for NetworkType
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public NetworkingBuilder edit() {
        return new NetworkingBuilder(this);
    }

    @JsonIgnore
    public NetworkingBuilder toBuilder() {
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
        if (!(o instanceof Networking)) {
            return false;
        }
        Networking other = (Networking) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterNetwork = this.getClusterNetwork();
        Object other$clusterNetwork = other.getClusterNetwork();
        if (this$clusterNetwork == null ? other$clusterNetwork != null : !this$clusterNetwork.equals(other$clusterNetwork)) {
            return false;
        }
        Object this$clusterNetworkMTU = this.getClusterNetworkMTU();
        Object other$clusterNetworkMTU = other.getClusterNetworkMTU();
        if (this$clusterNetworkMTU == null ? other$clusterNetworkMTU != null : !this$clusterNetworkMTU.equals(other$clusterNetworkMTU)) {
            return false;
        }
        Object this$clusterNetworkList = this.getClusterNetworks();
        Object other$clusterNetworkList = other.getClusterNetworks();
        if (this$clusterNetworkList == null ? other$clusterNetworkList != null : !this$clusterNetworkList.equals(other$clusterNetworkList)) {
            return false;
        }
        Object this$machineCIDR = this.getMachineCIDR();
        Object other$machineCIDR = other.getMachineCIDR();
        if (this$machineCIDR == null ? other$machineCIDR != null : !this$machineCIDR.equals(other$machineCIDR)) {
            return false;
        }
        Object this$machineNetwork = this.getMachineNetwork();
        Object other$machineNetwork = other.getMachineNetwork();
        if (this$machineNetwork == null ? other$machineNetwork != null : !this$machineNetwork.equals(other$machineNetwork)) {
            return false;
        }
        Object this$networkType = this.getNetworkType();
        Object other$networkType = other.getNetworkType();
        if (this$networkType == null ? other$networkType != null : !this$networkType.equals(other$networkType)) {
            return false;
        }
        Object this$ovnKubernetesConfig = this.getOvnKubernetesConfig();
        Object other$ovnKubernetesConfig = other.getOvnKubernetesConfig();
        if (this$ovnKubernetesConfig == null ? other$ovnKubernetesConfig != null : !this$ovnKubernetesConfig.equals(other$ovnKubernetesConfig)) {
            return false;
        }
        Object this$serviceCIDR = this.getServiceCIDR();
        Object other$serviceCIDR = other.getServiceCIDR();
        if (this$serviceCIDR == null ? other$serviceCIDR != null : !this$serviceCIDR.equals(other$serviceCIDR)) {
            return false;
        }
        Object this$serviceNetwork = this.getServiceNetwork();
        Object other$serviceNetwork = other.getServiceNetwork();
        if (this$serviceNetwork == null ? other$serviceNetwork != null : !this$serviceNetwork.equals(other$serviceNetwork)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof Networking;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterNetwork = this.getClusterNetwork();
        result = result * prime + ($clusterNetwork == null ? 43 : $clusterNetwork.hashCode());
        Object $clusterNetworkMTU = this.getClusterNetworkMTU();
        result = result * prime + ($clusterNetworkMTU == null ? 43 : $clusterNetworkMTU.hashCode());
        Object $clusterNetworkList = this.getClusterNetworks();
        result = result * prime + ($clusterNetworkList == null ? 43 : $clusterNetworkList.hashCode());
        Object $machineCIDR = this.getMachineCIDR();
        result = result * prime + ($machineCIDR == null ? 43 : $machineCIDR.hashCode());
        Object $machineNetwork = this.getMachineNetwork();
        result = result * prime + ($machineNetwork == null ? 43 : $machineNetwork.hashCode());
        Object $networkType = this.getNetworkType();
        result = result * prime + ($networkType == null ? 43 : $networkType.hashCode());
        Object $ovnKubernetesConfig = this.getOvnKubernetesConfig();
        result = result * prime + ($ovnKubernetesConfig == null ? 43 : $ovnKubernetesConfig.hashCode());
        Object $serviceCIDR = this.getServiceCIDR();
        result = result * prime + ($serviceCIDR == null ? 43 : $serviceCIDR.hashCode());
        Object $serviceNetwork = this.getServiceNetwork();
        result = result * prime + ($serviceNetwork == null ? 43 : $serviceNetwork.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Networking(" + "clusterNetwork=" + this.getClusterNetwork() + ", clusterNetworkMTU=" + this.getClusterNetworkMTU() + ", clusterNetworkList=" + this.getClusterNetworks() + ", machineCIDR=" + this.getMachineCIDR() + ", machineNetwork=" + this.getMachineNetwork() + ", networkType=" + this.getNetworkType() + ", ovnKubernetesConfig=" + this.getOvnKubernetesConfig() + ", serviceCIDR=" + this.getServiceCIDR() + ", serviceNetwork=" + this.getServiceNetwork() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
