
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.infrastructure.v1beta1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AzureMachineSpec defines the desired state of AzureMachine.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "acceleratedNetworking",
    "additionalCapabilities",
    "additionalTags",
    "allocatePublicIP",
    "capacityReservationGroupID",
    "dataDisks",
    "diagnostics",
    "disableExtensionOperations",
    "disableVMBootstrapExtension",
    "dnsServers",
    "enableIPForwarding",
    "failureDomain",
    "identity",
    "image",
    "networkInterfaces",
    "osDisk",
    "providerID",
    "roleAssignmentName",
    "securityProfile",
    "spotVMOptions",
    "sshPublicKey",
    "subnetName",
    "systemAssignedIdentityRole",
    "userAssignedIdentities",
    "vmExtensions",
    "vmSize"
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
public class AzureMachineSpec implements Editable<AzureMachineSpecBuilder>, KubernetesResource
{

    @JsonProperty("acceleratedNetworking")
    private Boolean acceleratedNetworking;
    @JsonProperty("additionalCapabilities")
    private AdditionalCapabilities additionalCapabilities;
    @JsonProperty("additionalTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> additionalTags = new LinkedHashMap<>();
    @JsonProperty("allocatePublicIP")
    private Boolean allocatePublicIP;
    @JsonProperty("capacityReservationGroupID")
    private String capacityReservationGroupID;
    @JsonProperty("dataDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DataDisk> dataDisks = new ArrayList<>();
    @JsonProperty("diagnostics")
    private Diagnostics diagnostics;
    @JsonProperty("disableExtensionOperations")
    private Boolean disableExtensionOperations;
    @JsonProperty("disableVMBootstrapExtension")
    private Boolean disableVMBootstrapExtension;
    @JsonProperty("dnsServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dnsServers = new ArrayList<>();
    @JsonProperty("enableIPForwarding")
    private Boolean enableIPForwarding;
    @JsonProperty("failureDomain")
    private String failureDomain;
    @JsonProperty("identity")
    private String identity;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("networkInterfaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkInterface> networkInterfaces = new ArrayList<>();
    @JsonProperty("osDisk")
    private OSDisk osDisk;
    @JsonProperty("providerID")
    private String providerID;
    @JsonProperty("roleAssignmentName")
    private String roleAssignmentName;
    @JsonProperty("securityProfile")
    private SecurityProfile securityProfile;
    @JsonProperty("spotVMOptions")
    private SpotVMOptions spotVMOptions;
    @JsonProperty("sshPublicKey")
    private String sshPublicKey;
    @JsonProperty("subnetName")
    private String subnetName;
    @JsonProperty("systemAssignedIdentityRole")
    private SystemAssignedIdentityRole systemAssignedIdentityRole;
    @JsonProperty("userAssignedIdentities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UserAssignedIdentity> userAssignedIdentities = new ArrayList<>();
    @JsonProperty("vmExtensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VMExtension> vmExtensions = new ArrayList<>();
    @JsonProperty("vmSize")
    private String vmSize;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureMachineSpec() {
    }

    public AzureMachineSpec(Boolean acceleratedNetworking, AdditionalCapabilities additionalCapabilities, Map<String, String> additionalTags, Boolean allocatePublicIP, String capacityReservationGroupID, List<DataDisk> dataDisks, Diagnostics diagnostics, Boolean disableExtensionOperations, Boolean disableVMBootstrapExtension, List<String> dnsServers, Boolean enableIPForwarding, String failureDomain, String identity, Image image, List<NetworkInterface> networkInterfaces, OSDisk osDisk, String providerID, String roleAssignmentName, SecurityProfile securityProfile, SpotVMOptions spotVMOptions, String sshPublicKey, String subnetName, SystemAssignedIdentityRole systemAssignedIdentityRole, List<UserAssignedIdentity> userAssignedIdentities, List<VMExtension> vmExtensions, String vmSize) {
        super();
        this.acceleratedNetworking = acceleratedNetworking;
        this.additionalCapabilities = additionalCapabilities;
        this.additionalTags = additionalTags;
        this.allocatePublicIP = allocatePublicIP;
        this.capacityReservationGroupID = capacityReservationGroupID;
        this.dataDisks = dataDisks;
        this.diagnostics = diagnostics;
        this.disableExtensionOperations = disableExtensionOperations;
        this.disableVMBootstrapExtension = disableVMBootstrapExtension;
        this.dnsServers = dnsServers;
        this.enableIPForwarding = enableIPForwarding;
        this.failureDomain = failureDomain;
        this.identity = identity;
        this.image = image;
        this.networkInterfaces = networkInterfaces;
        this.osDisk = osDisk;
        this.providerID = providerID;
        this.roleAssignmentName = roleAssignmentName;
        this.securityProfile = securityProfile;
        this.spotVMOptions = spotVMOptions;
        this.sshPublicKey = sshPublicKey;
        this.subnetName = subnetName;
        this.systemAssignedIdentityRole = systemAssignedIdentityRole;
        this.userAssignedIdentities = userAssignedIdentities;
        this.vmExtensions = vmExtensions;
        this.vmSize = vmSize;
    }

    /**
     * Deprecated: AcceleratedNetworking should be set in the networkInterfaces field.
     */
    @JsonProperty("acceleratedNetworking")
    public Boolean getAcceleratedNetworking() {
        return acceleratedNetworking;
    }

    /**
     * Deprecated: AcceleratedNetworking should be set in the networkInterfaces field.
     */
    @JsonProperty("acceleratedNetworking")
    public void setAcceleratedNetworking(Boolean acceleratedNetworking) {
        this.acceleratedNetworking = acceleratedNetworking;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("additionalCapabilities")
    public AdditionalCapabilities getAdditionalCapabilities() {
        return additionalCapabilities;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("additionalCapabilities")
    public void setAdditionalCapabilities(AdditionalCapabilities additionalCapabilities) {
        this.additionalCapabilities = additionalCapabilities;
    }

    /**
     * AdditionalTags is an optional set of tags to add to an instance, in addition to the ones added by default by the Azure provider. If both the AzureCluster and the AzureMachine specify the same tag name with different values, the AzureMachine's value takes precedence.
     */
    @JsonProperty("additionalTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAdditionalTags() {
        return additionalTags;
    }

    /**
     * AdditionalTags is an optional set of tags to add to an instance, in addition to the ones added by default by the Azure provider. If both the AzureCluster and the AzureMachine specify the same tag name with different values, the AzureMachine's value takes precedence.
     */
    @JsonProperty("additionalTags")
    public void setAdditionalTags(Map<String, String> additionalTags) {
        this.additionalTags = additionalTags;
    }

    /**
     * AllocatePublicIP allows the ability to create dynamic public ips for machines where this value is true.
     */
    @JsonProperty("allocatePublicIP")
    public Boolean getAllocatePublicIP() {
        return allocatePublicIP;
    }

    /**
     * AllocatePublicIP allows the ability to create dynamic public ips for machines where this value is true.
     */
    @JsonProperty("allocatePublicIP")
    public void setAllocatePublicIP(Boolean allocatePublicIP) {
        this.allocatePublicIP = allocatePublicIP;
    }

    /**
     * CapacityReservationGroupID specifies the capacity reservation group resource id that should be used for allocating the virtual machine. The field size should be greater than 0 and the field input must start with '/'. The input for capacityReservationGroupID must be similar to '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/capacityReservationGroups/{capacityReservationGroupName}'. The keys which are used should be among 'subscriptions', 'providers' and 'resourcegroups' followed by valid ID or names respectively. It is optional but may not be changed once set.
     */
    @JsonProperty("capacityReservationGroupID")
    public String getCapacityReservationGroupID() {
        return capacityReservationGroupID;
    }

    /**
     * CapacityReservationGroupID specifies the capacity reservation group resource id that should be used for allocating the virtual machine. The field size should be greater than 0 and the field input must start with '/'. The input for capacityReservationGroupID must be similar to '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/capacityReservationGroups/{capacityReservationGroupName}'. The keys which are used should be among 'subscriptions', 'providers' and 'resourcegroups' followed by valid ID or names respectively. It is optional but may not be changed once set.
     */
    @JsonProperty("capacityReservationGroupID")
    public void setCapacityReservationGroupID(String capacityReservationGroupID) {
        this.capacityReservationGroupID = capacityReservationGroupID;
    }

    /**
     * DataDisk specifies the parameters that are used to add one or more data disks to the machine
     */
    @JsonProperty("dataDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DataDisk> getDataDisks() {
        return dataDisks;
    }

    /**
     * DataDisk specifies the parameters that are used to add one or more data disks to the machine
     */
    @JsonProperty("dataDisks")
    public void setDataDisks(List<DataDisk> dataDisks) {
        this.dataDisks = dataDisks;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("diagnostics")
    public Diagnostics getDiagnostics() {
        return diagnostics;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("diagnostics")
    public void setDiagnostics(Diagnostics diagnostics) {
        this.diagnostics = diagnostics;
    }

    /**
     * DisableExtensionOperations specifies whether extension operations should be disabled on the virtual machine. Use this setting only if VMExtensions are not supported by your image, as it disables CAPZ bootstrapping extension used for detecting Kubernetes bootstrap failure. This may only be set to True when no extensions are configured on the virtual machine.
     */
    @JsonProperty("disableExtensionOperations")
    public Boolean getDisableExtensionOperations() {
        return disableExtensionOperations;
    }

    /**
     * DisableExtensionOperations specifies whether extension operations should be disabled on the virtual machine. Use this setting only if VMExtensions are not supported by your image, as it disables CAPZ bootstrapping extension used for detecting Kubernetes bootstrap failure. This may only be set to True when no extensions are configured on the virtual machine.
     */
    @JsonProperty("disableExtensionOperations")
    public void setDisableExtensionOperations(Boolean disableExtensionOperations) {
        this.disableExtensionOperations = disableExtensionOperations;
    }

    /**
     * DisableVMBootstrapExtension specifies whether the VM bootstrap extension should be disabled on the virtual machine. Use this setting if you want to disable only the bootstrapping extension and not all extensions.
     */
    @JsonProperty("disableVMBootstrapExtension")
    public Boolean getDisableVMBootstrapExtension() {
        return disableVMBootstrapExtension;
    }

    /**
     * DisableVMBootstrapExtension specifies whether the VM bootstrap extension should be disabled on the virtual machine. Use this setting if you want to disable only the bootstrapping extension and not all extensions.
     */
    @JsonProperty("disableVMBootstrapExtension")
    public void setDisableVMBootstrapExtension(Boolean disableVMBootstrapExtension) {
        this.disableVMBootstrapExtension = disableVMBootstrapExtension;
    }

    /**
     * DNSServers adds a list of DNS Server IP addresses to the VM NICs.
     */
    @JsonProperty("dnsServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDnsServers() {
        return dnsServers;
    }

    /**
     * DNSServers adds a list of DNS Server IP addresses to the VM NICs.
     */
    @JsonProperty("dnsServers")
    public void setDnsServers(List<String> dnsServers) {
        this.dnsServers = dnsServers;
    }

    /**
     * EnableIPForwarding enables IP Forwarding in Azure which is required for some CNI's to send traffic from a pods on one machine to another. This is required for IpV6 with Calico in combination with User Defined Routes (set by the Azure Cloud Controller manager). Default is false for disabled.
     */
    @JsonProperty("enableIPForwarding")
    public Boolean getEnableIPForwarding() {
        return enableIPForwarding;
    }

    /**
     * EnableIPForwarding enables IP Forwarding in Azure which is required for some CNI's to send traffic from a pods on one machine to another. This is required for IpV6 with Calico in combination with User Defined Routes (set by the Azure Cloud Controller manager). Default is false for disabled.
     */
    @JsonProperty("enableIPForwarding")
    public void setEnableIPForwarding(Boolean enableIPForwarding) {
        this.enableIPForwarding = enableIPForwarding;
    }

    /**
     * FailureDomain is the failure domain unique identifier this Machine should be attached to, as defined in Cluster API. This relates to an Azure Availability Zone
     */
    @JsonProperty("failureDomain")
    public String getFailureDomain() {
        return failureDomain;
    }

    /**
     * FailureDomain is the failure domain unique identifier this Machine should be attached to, as defined in Cluster API. This relates to an Azure Availability Zone
     */
    @JsonProperty("failureDomain")
    public void setFailureDomain(String failureDomain) {
        this.failureDomain = failureDomain;
    }

    /**
     * Identity is the type of identity used for the virtual machine. The type 'SystemAssigned' is an implicitly created identity. The generated identity will be assigned a Subscription contributor role. The type 'UserAssigned' is a standalone Azure resource provided by the user and assigned to the VM
     */
    @JsonProperty("identity")
    public String getIdentity() {
        return identity;
    }

    /**
     * Identity is the type of identity used for the virtual machine. The type 'SystemAssigned' is an implicitly created identity. The generated identity will be assigned a Subscription contributor role. The type 'UserAssigned' is a standalone Azure resource provided by the user and assigned to the VM
     */
    @JsonProperty("identity")
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * NetworkInterfaces specifies a list of network interface configurations. If left unspecified, the VM will get a single network interface with a single IPConfig in the subnet specified in the cluster's node subnet field. The primary interface will be the first networkInterface specified (index 0) in the list.
     */
    @JsonProperty("networkInterfaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkInterface> getNetworkInterfaces() {
        return networkInterfaces;
    }

    /**
     * NetworkInterfaces specifies a list of network interface configurations. If left unspecified, the VM will get a single network interface with a single IPConfig in the subnet specified in the cluster's node subnet field. The primary interface will be the first networkInterface specified (index 0) in the list.
     */
    @JsonProperty("networkInterfaces")
    public void setNetworkInterfaces(List<NetworkInterface> networkInterfaces) {
        this.networkInterfaces = networkInterfaces;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("osDisk")
    public OSDisk getOsDisk() {
        return osDisk;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("osDisk")
    public void setOsDisk(OSDisk osDisk) {
        this.osDisk = osDisk;
    }

    /**
     * ProviderID is the unique identifier as specified by the cloud provider.
     */
    @JsonProperty("providerID")
    public String getProviderID() {
        return providerID;
    }

    /**
     * ProviderID is the unique identifier as specified by the cloud provider.
     */
    @JsonProperty("providerID")
    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    /**
     * Deprecated: RoleAssignmentName should be set in the systemAssignedIdentityRole field.
     */
    @JsonProperty("roleAssignmentName")
    public String getRoleAssignmentName() {
        return roleAssignmentName;
    }

    /**
     * Deprecated: RoleAssignmentName should be set in the systemAssignedIdentityRole field.
     */
    @JsonProperty("roleAssignmentName")
    public void setRoleAssignmentName(String roleAssignmentName) {
        this.roleAssignmentName = roleAssignmentName;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("securityProfile")
    public SecurityProfile getSecurityProfile() {
        return securityProfile;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("securityProfile")
    public void setSecurityProfile(SecurityProfile securityProfile) {
        this.securityProfile = securityProfile;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("spotVMOptions")
    public SpotVMOptions getSpotVMOptions() {
        return spotVMOptions;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("spotVMOptions")
    public void setSpotVMOptions(SpotVMOptions spotVMOptions) {
        this.spotVMOptions = spotVMOptions;
    }

    /**
     * SSHPublicKey is the SSH public key string, base64-encoded to add to a Virtual Machine. Linux only. Refer to documentation on how to set up SSH access on Windows instances.
     */
    @JsonProperty("sshPublicKey")
    public String getSshPublicKey() {
        return sshPublicKey;
    }

    /**
     * SSHPublicKey is the SSH public key string, base64-encoded to add to a Virtual Machine. Linux only. Refer to documentation on how to set up SSH access on Windows instances.
     */
    @JsonProperty("sshPublicKey")
    public void setSshPublicKey(String sshPublicKey) {
        this.sshPublicKey = sshPublicKey;
    }

    /**
     * Deprecated: SubnetName should be set in the networkInterfaces field.
     */
    @JsonProperty("subnetName")
    public String getSubnetName() {
        return subnetName;
    }

    /**
     * Deprecated: SubnetName should be set in the networkInterfaces field.
     */
    @JsonProperty("subnetName")
    public void setSubnetName(String subnetName) {
        this.subnetName = subnetName;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("systemAssignedIdentityRole")
    public SystemAssignedIdentityRole getSystemAssignedIdentityRole() {
        return systemAssignedIdentityRole;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("systemAssignedIdentityRole")
    public void setSystemAssignedIdentityRole(SystemAssignedIdentityRole systemAssignedIdentityRole) {
        this.systemAssignedIdentityRole = systemAssignedIdentityRole;
    }

    /**
     * UserAssignedIdentities is a list of standalone Azure identities provided by the user The lifecycle of a user-assigned identity is managed separately from the lifecycle of the AzureMachine. See https://learn.microsoft.com/azure/active-directory/managed-identities-azure-resources/how-to-manage-ua-identity-cli
     */
    @JsonProperty("userAssignedIdentities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UserAssignedIdentity> getUserAssignedIdentities() {
        return userAssignedIdentities;
    }

    /**
     * UserAssignedIdentities is a list of standalone Azure identities provided by the user The lifecycle of a user-assigned identity is managed separately from the lifecycle of the AzureMachine. See https://learn.microsoft.com/azure/active-directory/managed-identities-azure-resources/how-to-manage-ua-identity-cli
     */
    @JsonProperty("userAssignedIdentities")
    public void setUserAssignedIdentities(List<UserAssignedIdentity> userAssignedIdentities) {
        this.userAssignedIdentities = userAssignedIdentities;
    }

    /**
     * VMExtensions specifies a list of extensions to be added to the virtual machine.
     */
    @JsonProperty("vmExtensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VMExtension> getVmExtensions() {
        return vmExtensions;
    }

    /**
     * VMExtensions specifies a list of extensions to be added to the virtual machine.
     */
    @JsonProperty("vmExtensions")
    public void setVmExtensions(List<VMExtension> vmExtensions) {
        this.vmExtensions = vmExtensions;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("vmSize")
    public String getVmSize() {
        return vmSize;
    }

    /**
     * AzureMachineSpec defines the desired state of AzureMachine.
     */
    @JsonProperty("vmSize")
    public void setVmSize(String vmSize) {
        this.vmSize = vmSize;
    }

    @JsonIgnore
    public AzureMachineSpecBuilder edit() {
        return new AzureMachineSpecBuilder(this);
    }

    @JsonIgnore
    public AzureMachineSpecBuilder toBuilder() {
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
