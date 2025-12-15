
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AzureManagedMachinePoolClassSpec defines the AzureManagedMachinePool properties that may be shared across several Azure managed machinepools.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalTags",
    "asoManagedClustersAgentPoolPatches",
    "availabilityZones",
    "enableEncryptionAtHost",
    "enableFIPS",
    "enableNodePublicIP",
    "enableUltraSSD",
    "kubeletConfig",
    "kubeletDiskType",
    "linuxOSConfig",
    "maxPods",
    "mode",
    "name",
    "nodeLabels",
    "nodePublicIPPrefixID",
    "osDiskSizeGB",
    "osDiskType",
    "osType",
    "scaleDownMode",
    "scaleSetPriority",
    "scaling",
    "sku",
    "spotMaxPrice",
    "subnetName",
    "taints"
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
public class AzureManagedMachinePoolClassSpec implements Editable<AzureManagedMachinePoolClassSpecBuilder>, KubernetesResource
{

    @JsonProperty("additionalTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> additionalTags = new LinkedHashMap<>();
    @JsonProperty("asoManagedClustersAgentPoolPatches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> asoManagedClustersAgentPoolPatches = new ArrayList<>();
    @JsonProperty("availabilityZones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> availabilityZones = new ArrayList<>();
    @JsonProperty("enableEncryptionAtHost")
    private Boolean enableEncryptionAtHost;
    @JsonProperty("enableFIPS")
    private Boolean enableFIPS;
    @JsonProperty("enableNodePublicIP")
    private Boolean enableNodePublicIP;
    @JsonProperty("enableUltraSSD")
    private Boolean enableUltraSSD;
    @JsonProperty("kubeletConfig")
    private KubeletConfig kubeletConfig;
    @JsonProperty("kubeletDiskType")
    private String kubeletDiskType;
    @JsonProperty("linuxOSConfig")
    private LinuxOSConfig linuxOSConfig;
    @JsonProperty("maxPods")
    private Integer maxPods;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nodeLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> nodeLabels = new LinkedHashMap<>();
    @JsonProperty("nodePublicIPPrefixID")
    private String nodePublicIPPrefixID;
    @JsonProperty("osDiskSizeGB")
    private Integer osDiskSizeGB;
    @JsonProperty("osDiskType")
    private String osDiskType;
    @JsonProperty("osType")
    private String osType;
    @JsonProperty("scaleDownMode")
    private String scaleDownMode;
    @JsonProperty("scaleSetPriority")
    private String scaleSetPriority;
    @JsonProperty("scaling")
    private ManagedMachinePoolScaling scaling;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("spotMaxPrice")
    private Quantity spotMaxPrice;
    @JsonProperty("subnetName")
    private String subnetName;
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Taint> taints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureManagedMachinePoolClassSpec() {
    }

    public AzureManagedMachinePoolClassSpec(Map<String, String> additionalTags, List<String> asoManagedClustersAgentPoolPatches, List<String> availabilityZones, Boolean enableEncryptionAtHost, Boolean enableFIPS, Boolean enableNodePublicIP, Boolean enableUltraSSD, KubeletConfig kubeletConfig, String kubeletDiskType, LinuxOSConfig linuxOSConfig, Integer maxPods, String mode, String name, Map<String, String> nodeLabels, String nodePublicIPPrefixID, Integer osDiskSizeGB, String osDiskType, String osType, String scaleDownMode, String scaleSetPriority, ManagedMachinePoolScaling scaling, String sku, Quantity spotMaxPrice, String subnetName, List<Taint> taints) {
        super();
        this.additionalTags = additionalTags;
        this.asoManagedClustersAgentPoolPatches = asoManagedClustersAgentPoolPatches;
        this.availabilityZones = availabilityZones;
        this.enableEncryptionAtHost = enableEncryptionAtHost;
        this.enableFIPS = enableFIPS;
        this.enableNodePublicIP = enableNodePublicIP;
        this.enableUltraSSD = enableUltraSSD;
        this.kubeletConfig = kubeletConfig;
        this.kubeletDiskType = kubeletDiskType;
        this.linuxOSConfig = linuxOSConfig;
        this.maxPods = maxPods;
        this.mode = mode;
        this.name = name;
        this.nodeLabels = nodeLabels;
        this.nodePublicIPPrefixID = nodePublicIPPrefixID;
        this.osDiskSizeGB = osDiskSizeGB;
        this.osDiskType = osDiskType;
        this.osType = osType;
        this.scaleDownMode = scaleDownMode;
        this.scaleSetPriority = scaleSetPriority;
        this.scaling = scaling;
        this.sku = sku;
        this.spotMaxPrice = spotMaxPrice;
        this.subnetName = subnetName;
        this.taints = taints;
    }

    /**
     * AdditionalTags is an optional set of tags to add to Azure resources managed by the Azure provider, in addition to the ones added by default.
     */
    @JsonProperty("additionalTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAdditionalTags() {
        return additionalTags;
    }

    /**
     * AdditionalTags is an optional set of tags to add to Azure resources managed by the Azure provider, in addition to the ones added by default.
     */
    @JsonProperty("additionalTags")
    public void setAdditionalTags(Map<String, String> additionalTags) {
        this.additionalTags = additionalTags;
    }

    /**
     * ASOManagedClustersAgentPoolPatches defines JSON merge patches to be applied to the generated ASO ManagedClustersAgentPool resource. WARNING: This is meant to be used sparingly to enable features for development and testing that are not otherwise represented in the CAPZ API. Misconfiguration that conflicts with CAPZ's normal mode of operation is possible.
     */
    @JsonProperty("asoManagedClustersAgentPoolPatches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAsoManagedClustersAgentPoolPatches() {
        return asoManagedClustersAgentPoolPatches;
    }

    /**
     * ASOManagedClustersAgentPoolPatches defines JSON merge patches to be applied to the generated ASO ManagedClustersAgentPool resource. WARNING: This is meant to be used sparingly to enable features for development and testing that are not otherwise represented in the CAPZ API. Misconfiguration that conflicts with CAPZ's normal mode of operation is possible.
     */
    @JsonProperty("asoManagedClustersAgentPoolPatches")
    public void setAsoManagedClustersAgentPoolPatches(List<String> asoManagedClustersAgentPoolPatches) {
        this.asoManagedClustersAgentPoolPatches = asoManagedClustersAgentPoolPatches;
    }

    /**
     * AvailabilityZones - Availability zones for nodes. Must use VirtualMachineScaleSets AgentPoolType. Immutable.
     */
    @JsonProperty("availabilityZones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAvailabilityZones() {
        return availabilityZones;
    }

    /**
     * AvailabilityZones - Availability zones for nodes. Must use VirtualMachineScaleSets AgentPoolType. Immutable.
     */
    @JsonProperty("availabilityZones")
    public void setAvailabilityZones(List<String> availabilityZones) {
        this.availabilityZones = availabilityZones;
    }

    /**
     * EnableEncryptionAtHost indicates whether host encryption is enabled on the node pool. Immutable. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/en-us/azure/aks/enable-host-encryption
     */
    @JsonProperty("enableEncryptionAtHost")
    public Boolean getEnableEncryptionAtHost() {
        return enableEncryptionAtHost;
    }

    /**
     * EnableEncryptionAtHost indicates whether host encryption is enabled on the node pool. Immutable. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/en-us/azure/aks/enable-host-encryption
     */
    @JsonProperty("enableEncryptionAtHost")
    public void setEnableEncryptionAtHost(Boolean enableEncryptionAtHost) {
        this.enableEncryptionAtHost = enableEncryptionAtHost;
    }

    /**
     * EnableFIPS indicates whether FIPS is enabled on the node pool. Immutable.
     */
    @JsonProperty("enableFIPS")
    public Boolean getEnableFIPS() {
        return enableFIPS;
    }

    /**
     * EnableFIPS indicates whether FIPS is enabled on the node pool. Immutable.
     */
    @JsonProperty("enableFIPS")
    public void setEnableFIPS(Boolean enableFIPS) {
        this.enableFIPS = enableFIPS;
    }

    /**
     * EnableNodePublicIP controls whether or not nodes in the pool each have a public IP address. Immutable.
     */
    @JsonProperty("enableNodePublicIP")
    public Boolean getEnableNodePublicIP() {
        return enableNodePublicIP;
    }

    /**
     * EnableNodePublicIP controls whether or not nodes in the pool each have a public IP address. Immutable.
     */
    @JsonProperty("enableNodePublicIP")
    public void setEnableNodePublicIP(Boolean enableNodePublicIP) {
        this.enableNodePublicIP = enableNodePublicIP;
    }

    /**
     * EnableUltraSSD enables the storage type UltraSSD_LRS for the agent pool. Immutable.
     */
    @JsonProperty("enableUltraSSD")
    public Boolean getEnableUltraSSD() {
        return enableUltraSSD;
    }

    /**
     * EnableUltraSSD enables the storage type UltraSSD_LRS for the agent pool. Immutable.
     */
    @JsonProperty("enableUltraSSD")
    public void setEnableUltraSSD(Boolean enableUltraSSD) {
        this.enableUltraSSD = enableUltraSSD;
    }

    /**
     * AzureManagedMachinePoolClassSpec defines the AzureManagedMachinePool properties that may be shared across several Azure managed machinepools.
     */
    @JsonProperty("kubeletConfig")
    public KubeletConfig getKubeletConfig() {
        return kubeletConfig;
    }

    /**
     * AzureManagedMachinePoolClassSpec defines the AzureManagedMachinePool properties that may be shared across several Azure managed machinepools.
     */
    @JsonProperty("kubeletConfig")
    public void setKubeletConfig(KubeletConfig kubeletConfig) {
        this.kubeletConfig = kubeletConfig;
    }

    /**
     * KubeletDiskType specifies the kubelet disk type. Default to OS. Possible values include: 'OS', 'Temporary'. Requires Microsoft.ContainerService/KubeletDisk preview feature to be set. Immutable. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/rest/api/aks/agent-pools/create-or-update?tabs=HTTP#kubeletdisktype
     */
    @JsonProperty("kubeletDiskType")
    public String getKubeletDiskType() {
        return kubeletDiskType;
    }

    /**
     * KubeletDiskType specifies the kubelet disk type. Default to OS. Possible values include: 'OS', 'Temporary'. Requires Microsoft.ContainerService/KubeletDisk preview feature to be set. Immutable. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/rest/api/aks/agent-pools/create-or-update?tabs=HTTP#kubeletdisktype
     */
    @JsonProperty("kubeletDiskType")
    public void setKubeletDiskType(String kubeletDiskType) {
        this.kubeletDiskType = kubeletDiskType;
    }

    /**
     * AzureManagedMachinePoolClassSpec defines the AzureManagedMachinePool properties that may be shared across several Azure managed machinepools.
     */
    @JsonProperty("linuxOSConfig")
    public LinuxOSConfig getLinuxOSConfig() {
        return linuxOSConfig;
    }

    /**
     * AzureManagedMachinePoolClassSpec defines the AzureManagedMachinePool properties that may be shared across several Azure managed machinepools.
     */
    @JsonProperty("linuxOSConfig")
    public void setLinuxOSConfig(LinuxOSConfig linuxOSConfig) {
        this.linuxOSConfig = linuxOSConfig;
    }

    /**
     * MaxPods specifies the kubelet `--max-pods` configuration for the node pool. Immutable. See also [AKS doc], [K8s doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/configure-azure-cni#configure-maximum---new-clusters [K8s doc]: https://kubernetes.io/docs/reference/command-line-tools-reference/kubelet/
     */
    @JsonProperty("maxPods")
    public Integer getMaxPods() {
        return maxPods;
    }

    /**
     * MaxPods specifies the kubelet `--max-pods` configuration for the node pool. Immutable. See also [AKS doc], [K8s doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/configure-azure-cni#configure-maximum---new-clusters [K8s doc]: https://kubernetes.io/docs/reference/command-line-tools-reference/kubelet/
     */
    @JsonProperty("maxPods")
    public void setMaxPods(Integer maxPods) {
        this.maxPods = maxPods;
    }

    /**
     * Mode represents the mode of an agent pool. Possible values include: System, User.
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode represents the mode of an agent pool. Possible values include: System, User.
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Name is the name of the agent pool. If not specified, CAPZ uses the name of the CR as the agent pool name. Immutable.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the agent pool. If not specified, CAPZ uses the name of the CR as the agent pool name. Immutable.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Node labels represent the labels for all of the nodes present in node pool. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/use-labels
     */
    @JsonProperty("nodeLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getNodeLabels() {
        return nodeLabels;
    }

    /**
     * Node labels represent the labels for all of the nodes present in node pool. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/use-labels
     */
    @JsonProperty("nodeLabels")
    public void setNodeLabels(Map<String, String> nodeLabels) {
        this.nodeLabels = nodeLabels;
    }

    /**
     * NodePublicIPPrefixID specifies the public IP prefix resource ID which VM nodes should use IPs from. Immutable.
     */
    @JsonProperty("nodePublicIPPrefixID")
    public String getNodePublicIPPrefixID() {
        return nodePublicIPPrefixID;
    }

    /**
     * NodePublicIPPrefixID specifies the public IP prefix resource ID which VM nodes should use IPs from. Immutable.
     */
    @JsonProperty("nodePublicIPPrefixID")
    public void setNodePublicIPPrefixID(String nodePublicIPPrefixID) {
        this.nodePublicIPPrefixID = nodePublicIPPrefixID;
    }

    /**
     * OSDiskSizeGB is the disk size for every machine in this agent pool. If you specify 0, it will apply the default osDisk size according to the vmSize specified. Immutable.
     */
    @JsonProperty("osDiskSizeGB")
    public Integer getOsDiskSizeGB() {
        return osDiskSizeGB;
    }

    /**
     * OSDiskSizeGB is the disk size for every machine in this agent pool. If you specify 0, it will apply the default osDisk size according to the vmSize specified. Immutable.
     */
    @JsonProperty("osDiskSizeGB")
    public void setOsDiskSizeGB(Integer osDiskSizeGB) {
        this.osDiskSizeGB = osDiskSizeGB;
    }

    /**
     * OsDiskType specifies the OS disk type for each node in the pool. Allowed values are 'Ephemeral' and 'Managed' (default). Immutable. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/cluster-configuration#ephemeral-os
     */
    @JsonProperty("osDiskType")
    public String getOsDiskType() {
        return osDiskType;
    }

    /**
     * OsDiskType specifies the OS disk type for each node in the pool. Allowed values are 'Ephemeral' and 'Managed' (default). Immutable. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/cluster-configuration#ephemeral-os
     */
    @JsonProperty("osDiskType")
    public void setOsDiskType(String osDiskType) {
        this.osDiskType = osDiskType;
    }

    /**
     * OSType specifies the virtual machine operating system. Default to Linux. Possible values include: 'Linux', 'Windows'. 'Windows' requires the AzureManagedControlPlane's `spec.networkPlugin` to be `azure`. Immutable. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/rest/api/aks/agent-pools/create-or-update?tabs=HTTP#ostype
     */
    @JsonProperty("osType")
    public String getOsType() {
        return osType;
    }

    /**
     * OSType specifies the virtual machine operating system. Default to Linux. Possible values include: 'Linux', 'Windows'. 'Windows' requires the AzureManagedControlPlane's `spec.networkPlugin` to be `azure`. Immutable. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/rest/api/aks/agent-pools/create-or-update?tabs=HTTP#ostype
     */
    @JsonProperty("osType")
    public void setOsType(String osType) {
        this.osType = osType;
    }

    /**
     * ScaleDownMode affects the cluster autoscaler behavior. Default to Delete. Possible values include: 'Deallocate', 'Delete'
     */
    @JsonProperty("scaleDownMode")
    public String getScaleDownMode() {
        return scaleDownMode;
    }

    /**
     * ScaleDownMode affects the cluster autoscaler behavior. Default to Delete. Possible values include: 'Deallocate', 'Delete'
     */
    @JsonProperty("scaleDownMode")
    public void setScaleDownMode(String scaleDownMode) {
        this.scaleDownMode = scaleDownMode;
    }

    /**
     * ScaleSetPriority specifies the ScaleSetPriority value. Default to Regular. Possible values include: 'Regular', 'Spot' Immutable.
     */
    @JsonProperty("scaleSetPriority")
    public String getScaleSetPriority() {
        return scaleSetPriority;
    }

    /**
     * ScaleSetPriority specifies the ScaleSetPriority value. Default to Regular. Possible values include: 'Regular', 'Spot' Immutable.
     */
    @JsonProperty("scaleSetPriority")
    public void setScaleSetPriority(String scaleSetPriority) {
        this.scaleSetPriority = scaleSetPriority;
    }

    /**
     * AzureManagedMachinePoolClassSpec defines the AzureManagedMachinePool properties that may be shared across several Azure managed machinepools.
     */
    @JsonProperty("scaling")
    public ManagedMachinePoolScaling getScaling() {
        return scaling;
    }

    /**
     * AzureManagedMachinePoolClassSpec defines the AzureManagedMachinePool properties that may be shared across several Azure managed machinepools.
     */
    @JsonProperty("scaling")
    public void setScaling(ManagedMachinePoolScaling scaling) {
        this.scaling = scaling;
    }

    /**
     * SKU is the size of the VMs in the node pool. Immutable.
     */
    @JsonProperty("sku")
    public String getSku() {
        return sku;
    }

    /**
     * SKU is the size of the VMs in the node pool. Immutable.
     */
    @JsonProperty("sku")
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * AzureManagedMachinePoolClassSpec defines the AzureManagedMachinePool properties that may be shared across several Azure managed machinepools.
     */
    @JsonProperty("spotMaxPrice")
    public Quantity getSpotMaxPrice() {
        return spotMaxPrice;
    }

    /**
     * AzureManagedMachinePoolClassSpec defines the AzureManagedMachinePool properties that may be shared across several Azure managed machinepools.
     */
    @JsonProperty("spotMaxPrice")
    public void setSpotMaxPrice(Quantity spotMaxPrice) {
        this.spotMaxPrice = spotMaxPrice;
    }

    /**
     * SubnetName specifies the Subnet where the MachinePool will be placed Immutable.
     */
    @JsonProperty("subnetName")
    public String getSubnetName() {
        return subnetName;
    }

    /**
     * SubnetName specifies the Subnet where the MachinePool will be placed Immutable.
     */
    @JsonProperty("subnetName")
    public void setSubnetName(String subnetName) {
        this.subnetName = subnetName;
    }

    /**
     * Taints specifies the taints for nodes present in this agent pool. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/use-multiple-node-pools#setting-node-pool-taints
     */
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Taint> getTaints() {
        return taints;
    }

    /**
     * Taints specifies the taints for nodes present in this agent pool. See also [AKS doc].<br><p> <br><p> [AKS doc]: https://learn.microsoft.com/azure/aks/use-multiple-node-pools#setting-node-pool-taints
     */
    @JsonProperty("taints")
    public void setTaints(List<Taint> taints) {
        this.taints = taints;
    }

    @JsonIgnore
    public AzureManagedMachinePoolClassSpecBuilder edit() {
        return new AzureManagedMachinePoolClassSpecBuilder(this);
    }

    @JsonIgnore
    public AzureManagedMachinePoolClassSpecBuilder toBuilder() {
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
