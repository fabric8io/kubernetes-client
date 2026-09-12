
package io.fabric8.openshift.api.model.machine.v1beta1;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "acceleratedNetworking",
    "applicationSecurityGroups",
    "availabilitySet",
    "capacityReservationGroupID",
    "credentialsSecret",
    "dataDisks",
    "diagnostics",
    "image",
    "internalLoadBalancer",
    "location",
    "managedIdentity",
    "natRule",
    "networkResourceGroup",
    "osDisk",
    "publicIP",
    "publicLoadBalancer",
    "resourceGroup",
    "securityGroup",
    "securityProfile",
    "spotVMOptions",
    "sshPublicKey",
    "subnet",
    "tags",
    "ultraSSDCapability",
    "userDataSecret",
    "vmSize",
    "vnet",
    "zone"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
@Version("v1beta1")
@Group("machine.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AzureMachineProviderSpec implements Editable<AzureMachineProviderSpecBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("acceleratedNetworking")
    private Boolean acceleratedNetworking;
    @JsonProperty("apiVersion")
    private String apiVersion = "machine.openshift.io/v1beta1";
    @JsonProperty("applicationSecurityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> applicationSecurityGroups = new ArrayList<>();
    @JsonProperty("availabilitySet")
    private String availabilitySet;
    @JsonProperty("capacityReservationGroupID")
    private String capacityReservationGroupID;
    @JsonProperty("credentialsSecret")
    private SecretReference credentialsSecret;
    @JsonProperty("dataDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DataDisk> dataDisks = new ArrayList<>();
    @JsonProperty("diagnostics")
    private AzureDiagnostics diagnostics;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("internalLoadBalancer")
    private String internalLoadBalancer;
    @JsonProperty("kind")
    private String kind = "AzureMachineProviderSpec";
    @JsonProperty("location")
    private String location;
    @JsonProperty("managedIdentity")
    private String managedIdentity;
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("natRule")
    private Long natRule;
    @JsonProperty("networkResourceGroup")
    private String networkResourceGroup;
    @JsonProperty("osDisk")
    private OSDisk osDisk;
    @JsonProperty("publicIP")
    private Boolean publicIP;
    @JsonProperty("publicLoadBalancer")
    private String publicLoadBalancer;
    @JsonProperty("resourceGroup")
    private String resourceGroup;
    @JsonProperty("securityGroup")
    private String securityGroup;
    @JsonProperty("securityProfile")
    private SecurityProfile securityProfile;
    @JsonProperty("spotVMOptions")
    private SpotVMOptions spotVMOptions;
    @JsonProperty("sshPublicKey")
    private String sshPublicKey;
    @JsonProperty("subnet")
    private String subnet;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> tags = new LinkedHashMap<>();
    @JsonProperty("ultraSSDCapability")
    private String ultraSSDCapability;
    @JsonProperty("userDataSecret")
    private SecretReference userDataSecret;
    @JsonProperty("vmSize")
    private String vmSize;
    @JsonProperty("vnet")
    private String vnet;
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureMachineProviderSpec() {
    }

    public AzureMachineProviderSpec(Boolean acceleratedNetworking, String apiVersion, List<String> applicationSecurityGroups, String availabilitySet, String capacityReservationGroupID, SecretReference credentialsSecret, List<DataDisk> dataDisks, AzureDiagnostics diagnostics, Image image, String internalLoadBalancer, String kind, String location, String managedIdentity, ObjectMeta metadata, Long natRule, String networkResourceGroup, OSDisk osDisk, Boolean publicIP, String publicLoadBalancer, String resourceGroup, String securityGroup, SecurityProfile securityProfile, SpotVMOptions spotVMOptions, String sshPublicKey, String subnet, Map<String, String> tags, String ultraSSDCapability, SecretReference userDataSecret, String vmSize, String vnet, String zone) {
        super();
        this.acceleratedNetworking = acceleratedNetworking;
        this.apiVersion = apiVersion;
        this.applicationSecurityGroups = applicationSecurityGroups;
        this.availabilitySet = availabilitySet;
        this.capacityReservationGroupID = capacityReservationGroupID;
        this.credentialsSecret = credentialsSecret;
        this.dataDisks = dataDisks;
        this.diagnostics = diagnostics;
        this.image = image;
        this.internalLoadBalancer = internalLoadBalancer;
        this.kind = kind;
        this.location = location;
        this.managedIdentity = managedIdentity;
        this.metadata = metadata;
        this.natRule = natRule;
        this.networkResourceGroup = networkResourceGroup;
        this.osDisk = osDisk;
        this.publicIP = publicIP;
        this.publicLoadBalancer = publicLoadBalancer;
        this.resourceGroup = resourceGroup;
        this.securityGroup = securityGroup;
        this.securityProfile = securityProfile;
        this.spotVMOptions = spotVMOptions;
        this.sshPublicKey = sshPublicKey;
        this.subnet = subnet;
        this.tags = tags;
        this.ultraSSDCapability = ultraSSDCapability;
        this.userDataSecret = userDataSecret;
        this.vmSize = vmSize;
        this.vnet = vnet;
        this.zone = zone;
    }

    /**
     * acceleratedNetworking enables or disables Azure accelerated networking feature. Set to false by default. If true, then this will depend on whether the requested VMSize is supported. If set to true with an unsupported VMSize, Azure will return an error.
     */
    @JsonProperty("acceleratedNetworking")
    public Boolean getAcceleratedNetworking() {
        return acceleratedNetworking;
    }

    /**
     * acceleratedNetworking enables or disables Azure accelerated networking feature. Set to false by default. If true, then this will depend on whether the requested VMSize is supported. If set to true with an unsupported VMSize, Azure will return an error.
     */
    @JsonProperty("acceleratedNetworking")
    public void setAcceleratedNetworking(Boolean acceleratedNetworking) {
        this.acceleratedNetworking = acceleratedNetworking;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Application Security Groups that need to be attached to the machine's interface. No application security groups will be attached if zero-length.
     */
    @JsonProperty("applicationSecurityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApplicationSecurityGroups() {
        return applicationSecurityGroups;
    }

    /**
     * Application Security Groups that need to be attached to the machine's interface. No application security groups will be attached if zero-length.
     */
    @JsonProperty("applicationSecurityGroups")
    public void setApplicationSecurityGroups(List<String> applicationSecurityGroups) {
        this.applicationSecurityGroups = applicationSecurityGroups;
    }

    /**
     * availabilitySet specifies the availability set to use for this instance. Availability set should be precreated, before using this field.
     */
    @JsonProperty("availabilitySet")
    public String getAvailabilitySet() {
        return availabilitySet;
    }

    /**
     * availabilitySet specifies the availability set to use for this instance. Availability set should be precreated, before using this field.
     */
    @JsonProperty("availabilitySet")
    public void setAvailabilitySet(String availabilitySet) {
        this.availabilitySet = availabilitySet;
    }

    /**
     * capacityReservationGroupID specifies the capacity reservation group resource id that should be used for allocating the virtual machine. The field size should be greater than 0 and the field input must start with '/'. The input for capacityReservationGroupID must be similar to '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/capacityReservationGroups/{capacityReservationGroupName}'. The keys which are used should be among 'subscriptions', 'providers' and 'resourcegroups' followed by valid ID or names respectively.
     */
    @JsonProperty("capacityReservationGroupID")
    public String getCapacityReservationGroupID() {
        return capacityReservationGroupID;
    }

    /**
     * capacityReservationGroupID specifies the capacity reservation group resource id that should be used for allocating the virtual machine. The field size should be greater than 0 and the field input must start with '/'. The input for capacityReservationGroupID must be similar to '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Compute/capacityReservationGroups/{capacityReservationGroupName}'. The keys which are used should be among 'subscriptions', 'providers' and 'resourcegroups' followed by valid ID or names respectively.
     */
    @JsonProperty("capacityReservationGroupID")
    public void setCapacityReservationGroupID(String capacityReservationGroupID) {
        this.capacityReservationGroupID = capacityReservationGroupID;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public SecretReference getCredentialsSecret() {
        return credentialsSecret;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("credentialsSecret")
    public void setCredentialsSecret(SecretReference credentialsSecret) {
        this.credentialsSecret = credentialsSecret;
    }

    /**
     * DataDisk specifies the parameters that are used to add one or more data disks to the machine.
     */
    @JsonProperty("dataDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DataDisk> getDataDisks() {
        return dataDisks;
    }

    /**
     * DataDisk specifies the parameters that are used to add one or more data disks to the machine.
     */
    @JsonProperty("dataDisks")
    public void setDataDisks(List<DataDisk> dataDisks) {
        this.dataDisks = dataDisks;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("diagnostics")
    public AzureDiagnostics getDiagnostics() {
        return diagnostics;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("diagnostics")
    public void setDiagnostics(AzureDiagnostics diagnostics) {
        this.diagnostics = diagnostics;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * InternalLoadBalancerName to use for this instance
     */
    @JsonProperty("internalLoadBalancer")
    public String getInternalLoadBalancer() {
        return internalLoadBalancer;
    }

    /**
     * InternalLoadBalancerName to use for this instance
     */
    @JsonProperty("internalLoadBalancer")
    public void setInternalLoadBalancer(String internalLoadBalancer) {
        this.internalLoadBalancer = internalLoadBalancer;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * location is the region to use to create the instance
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * location is the region to use to create the instance
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * managedIdentity to set managed identity name
     */
    @JsonProperty("managedIdentity")
    public String getManagedIdentity() {
        return managedIdentity;
    }

    /**
     * managedIdentity to set managed identity name
     */
    @JsonProperty("managedIdentity")
    public void setManagedIdentity(String managedIdentity) {
        this.managedIdentity = managedIdentity;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * natRule to set inbound NAT rule of the load balancer
     */
    @JsonProperty("natRule")
    public Long getNatRule() {
        return natRule;
    }

    /**
     * natRule to set inbound NAT rule of the load balancer
     */
    @JsonProperty("natRule")
    public void setNatRule(Long natRule) {
        this.natRule = natRule;
    }

    /**
     * networkResourceGroup is the resource group for the virtual machine's network
     */
    @JsonProperty("networkResourceGroup")
    public String getNetworkResourceGroup() {
        return networkResourceGroup;
    }

    /**
     * networkResourceGroup is the resource group for the virtual machine's network
     */
    @JsonProperty("networkResourceGroup")
    public void setNetworkResourceGroup(String networkResourceGroup) {
        this.networkResourceGroup = networkResourceGroup;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("osDisk")
    public OSDisk getOsDisk() {
        return osDisk;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("osDisk")
    public void setOsDisk(OSDisk osDisk) {
        this.osDisk = osDisk;
    }

    /**
     * publicIP if true a public IP will be used
     */
    @JsonProperty("publicIP")
    public Boolean getPublicIP() {
        return publicIP;
    }

    /**
     * publicIP if true a public IP will be used
     */
    @JsonProperty("publicIP")
    public void setPublicIP(Boolean publicIP) {
        this.publicIP = publicIP;
    }

    /**
     * publicLoadBalancer to use for this instance
     */
    @JsonProperty("publicLoadBalancer")
    public String getPublicLoadBalancer() {
        return publicLoadBalancer;
    }

    /**
     * publicLoadBalancer to use for this instance
     */
    @JsonProperty("publicLoadBalancer")
    public void setPublicLoadBalancer(String publicLoadBalancer) {
        this.publicLoadBalancer = publicLoadBalancer;
    }

    /**
     * resourceGroup is the resource group for the virtual machine
     */
    @JsonProperty("resourceGroup")
    public String getResourceGroup() {
        return resourceGroup;
    }

    /**
     * resourceGroup is the resource group for the virtual machine
     */
    @JsonProperty("resourceGroup")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * Network Security Group that needs to be attached to the machine's interface. No security group will be attached if empty.
     */
    @JsonProperty("securityGroup")
    public String getSecurityGroup() {
        return securityGroup;
    }

    /**
     * Network Security Group that needs to be attached to the machine's interface. No security group will be attached if empty.
     */
    @JsonProperty("securityGroup")
    public void setSecurityGroup(String securityGroup) {
        this.securityGroup = securityGroup;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("securityProfile")
    public SecurityProfile getSecurityProfile() {
        return securityProfile;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("securityProfile")
    public void setSecurityProfile(SecurityProfile securityProfile) {
        this.securityProfile = securityProfile;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("spotVMOptions")
    public SpotVMOptions getSpotVMOptions() {
        return spotVMOptions;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("spotVMOptions")
    public void setSpotVMOptions(SpotVMOptions spotVMOptions) {
        this.spotVMOptions = spotVMOptions;
    }

    /**
     * sshPublicKey is the public key to use to SSH to the virtual machine.
     */
    @JsonProperty("sshPublicKey")
    public String getSshPublicKey() {
        return sshPublicKey;
    }

    /**
     * sshPublicKey is the public key to use to SSH to the virtual machine.
     */
    @JsonProperty("sshPublicKey")
    public void setSshPublicKey(String sshPublicKey) {
        this.sshPublicKey = sshPublicKey;
    }

    /**
     * subnet to use for this instance
     */
    @JsonProperty("subnet")
    public String getSubnet() {
        return subnet;
    }

    /**
     * subnet to use for this instance
     */
    @JsonProperty("subnet")
    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    /**
     * tags is a list of tags to apply to the machine.
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getTags() {
        return tags;
    }

    /**
     * tags is a list of tags to apply to the machine.
     */
    @JsonProperty("tags")
    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    /**
     * ultraSSDCapability enables or disables Azure UltraSSD capability for a virtual machine. This can be used to allow/disallow binding of Azure UltraSSD to the Machine both as Data Disks or via Persistent Volumes. This Azure feature is subject to a specific scope and certain limitations. More informations on this can be found in the official Azure documentation for Ultra Disks: (https://docs.microsoft.com/en-us/azure/virtual-machines/disks-enable-ultra-ssd?tabs=azure-portal#ga-scope-and-limitations).<br><p> <br><p> When omitted, if at least one Data Disk of type UltraSSD is specified, the platform will automatically enable the capability. If a Perisistent Volume backed by an UltraSSD is bound to a Pod on the Machine, when this field is ommitted, the platform will &#42;not&#42; automatically enable the capability (unless already enabled by the presence of an UltraSSD as Data Disk). This may manifest in the Pod being stuck in `ContainerCreating` phase. This defaulting behaviour may be subject to change in future.<br><p> <br><p> When set to "Enabled", if the capability is available for the Machine based on the scope and limitations described above, the capability will be set on the Machine. This will thus allow UltraSSD both as Data Disks and Persistent Volumes. If set to "Enabled" when the capability can't be available due to scope and limitations, the Machine will go into "Failed" state.<br><p> <br><p> When set to "Disabled", UltraSSDs will not be allowed either as Data Disks nor as Persistent Volumes. In this case if any UltraSSDs are specified as Data Disks on a Machine, the Machine will go into a "Failed" state. If instead any UltraSSDs are backing the volumes (via Persistent Volumes) of any Pods scheduled on a Node which is backed by the Machine, the Pod may get stuck in `ContainerCreating` phase.
     */
    @JsonProperty("ultraSSDCapability")
    public String getUltraSSDCapability() {
        return ultraSSDCapability;
    }

    /**
     * ultraSSDCapability enables or disables Azure UltraSSD capability for a virtual machine. This can be used to allow/disallow binding of Azure UltraSSD to the Machine both as Data Disks or via Persistent Volumes. This Azure feature is subject to a specific scope and certain limitations. More informations on this can be found in the official Azure documentation for Ultra Disks: (https://docs.microsoft.com/en-us/azure/virtual-machines/disks-enable-ultra-ssd?tabs=azure-portal#ga-scope-and-limitations).<br><p> <br><p> When omitted, if at least one Data Disk of type UltraSSD is specified, the platform will automatically enable the capability. If a Perisistent Volume backed by an UltraSSD is bound to a Pod on the Machine, when this field is ommitted, the platform will &#42;not&#42; automatically enable the capability (unless already enabled by the presence of an UltraSSD as Data Disk). This may manifest in the Pod being stuck in `ContainerCreating` phase. This defaulting behaviour may be subject to change in future.<br><p> <br><p> When set to "Enabled", if the capability is available for the Machine based on the scope and limitations described above, the capability will be set on the Machine. This will thus allow UltraSSD both as Data Disks and Persistent Volumes. If set to "Enabled" when the capability can't be available due to scope and limitations, the Machine will go into "Failed" state.<br><p> <br><p> When set to "Disabled", UltraSSDs will not be allowed either as Data Disks nor as Persistent Volumes. In this case if any UltraSSDs are specified as Data Disks on a Machine, the Machine will go into a "Failed" state. If instead any UltraSSDs are backing the volumes (via Persistent Volumes) of any Pods scheduled on a Node which is backed by the Machine, the Pod may get stuck in `ContainerCreating` phase.
     */
    @JsonProperty("ultraSSDCapability")
    public void setUltraSSDCapability(String ultraSSDCapability) {
        this.ultraSSDCapability = ultraSSDCapability;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public SecretReference getUserDataSecret() {
        return userDataSecret;
    }

    /**
     * AzureMachineProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an Azure virtual machine. It is used by the Azure machine actuator to create a single Machine. Required parameters such as location that are not specified by this configuration, will be defaulted by the actuator. Compatibility level 2: Stable within a major release for a minimum of 9 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("userDataSecret")
    public void setUserDataSecret(SecretReference userDataSecret) {
        this.userDataSecret = userDataSecret;
    }

    /**
     * vmSize is the size of the VM to create.
     */
    @JsonProperty("vmSize")
    public String getVmSize() {
        return vmSize;
    }

    /**
     * vmSize is the size of the VM to create.
     */
    @JsonProperty("vmSize")
    public void setVmSize(String vmSize) {
        this.vmSize = vmSize;
    }

    /**
     * vnet to set virtual network name
     */
    @JsonProperty("vnet")
    public String getVnet() {
        return vnet;
    }

    /**
     * vnet to set virtual network name
     */
    @JsonProperty("vnet")
    public void setVnet(String vnet) {
        this.vnet = vnet;
    }

    /**
     * Availability Zone for the virtual machine. If nil, the virtual machine should be deployed to no zone
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * Availability Zone for the virtual machine. If nil, the virtual machine should be deployed to no zone
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonIgnore
    public AzureMachineProviderSpecBuilder edit() {
        return new AzureMachineProviderSpecBuilder(this);
    }

    @JsonIgnore
    public AzureMachineProviderSpecBuilder toBuilder() {
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
        if (!(o instanceof AzureMachineProviderSpec)) {
            return false;
        }
        AzureMachineProviderSpec other = (AzureMachineProviderSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$acceleratedNetworking = this.getAcceleratedNetworking();
        Object other$acceleratedNetworking = other.getAcceleratedNetworking();
        if (this$acceleratedNetworking == null ? other$acceleratedNetworking != null : !this$acceleratedNetworking.equals(other$acceleratedNetworking)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$applicationSecurityGroups = this.getApplicationSecurityGroups();
        Object other$applicationSecurityGroups = other.getApplicationSecurityGroups();
        if (this$applicationSecurityGroups == null ? other$applicationSecurityGroups != null : !this$applicationSecurityGroups.equals(other$applicationSecurityGroups)) {
            return false;
        }
        Object this$availabilitySet = this.getAvailabilitySet();
        Object other$availabilitySet = other.getAvailabilitySet();
        if (this$availabilitySet == null ? other$availabilitySet != null : !this$availabilitySet.equals(other$availabilitySet)) {
            return false;
        }
        Object this$capacityReservationGroupID = this.getCapacityReservationGroupID();
        Object other$capacityReservationGroupID = other.getCapacityReservationGroupID();
        if (this$capacityReservationGroupID == null ? other$capacityReservationGroupID != null : !this$capacityReservationGroupID.equals(other$capacityReservationGroupID)) {
            return false;
        }
        Object this$credentialsSecret = this.getCredentialsSecret();
        Object other$credentialsSecret = other.getCredentialsSecret();
        if (this$credentialsSecret == null ? other$credentialsSecret != null : !this$credentialsSecret.equals(other$credentialsSecret)) {
            return false;
        }
        Object this$dataDisks = this.getDataDisks();
        Object other$dataDisks = other.getDataDisks();
        if (this$dataDisks == null ? other$dataDisks != null : !this$dataDisks.equals(other$dataDisks)) {
            return false;
        }
        Object this$diagnostics = this.getDiagnostics();
        Object other$diagnostics = other.getDiagnostics();
        if (this$diagnostics == null ? other$diagnostics != null : !this$diagnostics.equals(other$diagnostics)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$internalLoadBalancer = this.getInternalLoadBalancer();
        Object other$internalLoadBalancer = other.getInternalLoadBalancer();
        if (this$internalLoadBalancer == null ? other$internalLoadBalancer != null : !this$internalLoadBalancer.equals(other$internalLoadBalancer)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$location = this.getLocation();
        Object other$location = other.getLocation();
        if (this$location == null ? other$location != null : !this$location.equals(other$location)) {
            return false;
        }
        Object this$managedIdentity = this.getManagedIdentity();
        Object other$managedIdentity = other.getManagedIdentity();
        if (this$managedIdentity == null ? other$managedIdentity != null : !this$managedIdentity.equals(other$managedIdentity)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$natRule = this.getNatRule();
        Object other$natRule = other.getNatRule();
        if (this$natRule == null ? other$natRule != null : !this$natRule.equals(other$natRule)) {
            return false;
        }
        Object this$networkResourceGroup = this.getNetworkResourceGroup();
        Object other$networkResourceGroup = other.getNetworkResourceGroup();
        if (this$networkResourceGroup == null ? other$networkResourceGroup != null : !this$networkResourceGroup.equals(other$networkResourceGroup)) {
            return false;
        }
        Object this$osDisk = this.getOsDisk();
        Object other$osDisk = other.getOsDisk();
        if (this$osDisk == null ? other$osDisk != null : !this$osDisk.equals(other$osDisk)) {
            return false;
        }
        Object this$publicIP = this.getPublicIP();
        Object other$publicIP = other.getPublicIP();
        if (this$publicIP == null ? other$publicIP != null : !this$publicIP.equals(other$publicIP)) {
            return false;
        }
        Object this$publicLoadBalancer = this.getPublicLoadBalancer();
        Object other$publicLoadBalancer = other.getPublicLoadBalancer();
        if (this$publicLoadBalancer == null ? other$publicLoadBalancer != null : !this$publicLoadBalancer.equals(other$publicLoadBalancer)) {
            return false;
        }
        Object this$resourceGroup = this.getResourceGroup();
        Object other$resourceGroup = other.getResourceGroup();
        if (this$resourceGroup == null ? other$resourceGroup != null : !this$resourceGroup.equals(other$resourceGroup)) {
            return false;
        }
        Object this$securityGroup = this.getSecurityGroup();
        Object other$securityGroup = other.getSecurityGroup();
        if (this$securityGroup == null ? other$securityGroup != null : !this$securityGroup.equals(other$securityGroup)) {
            return false;
        }
        Object this$securityProfile = this.getSecurityProfile();
        Object other$securityProfile = other.getSecurityProfile();
        if (this$securityProfile == null ? other$securityProfile != null : !this$securityProfile.equals(other$securityProfile)) {
            return false;
        }
        Object this$spotVMOptions = this.getSpotVMOptions();
        Object other$spotVMOptions = other.getSpotVMOptions();
        if (this$spotVMOptions == null ? other$spotVMOptions != null : !this$spotVMOptions.equals(other$spotVMOptions)) {
            return false;
        }
        Object this$sshPublicKey = this.getSshPublicKey();
        Object other$sshPublicKey = other.getSshPublicKey();
        if (this$sshPublicKey == null ? other$sshPublicKey != null : !this$sshPublicKey.equals(other$sshPublicKey)) {
            return false;
        }
        Object this$subnet = this.getSubnet();
        Object other$subnet = other.getSubnet();
        if (this$subnet == null ? other$subnet != null : !this$subnet.equals(other$subnet)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
            return false;
        }
        Object this$ultraSSDCapability = this.getUltraSSDCapability();
        Object other$ultraSSDCapability = other.getUltraSSDCapability();
        if (this$ultraSSDCapability == null ? other$ultraSSDCapability != null : !this$ultraSSDCapability.equals(other$ultraSSDCapability)) {
            return false;
        }
        Object this$userDataSecret = this.getUserDataSecret();
        Object other$userDataSecret = other.getUserDataSecret();
        if (this$userDataSecret == null ? other$userDataSecret != null : !this$userDataSecret.equals(other$userDataSecret)) {
            return false;
        }
        Object this$vmSize = this.getVmSize();
        Object other$vmSize = other.getVmSize();
        if (this$vmSize == null ? other$vmSize != null : !this$vmSize.equals(other$vmSize)) {
            return false;
        }
        Object this$vnet = this.getVnet();
        Object other$vnet = other.getVnet();
        if (this$vnet == null ? other$vnet != null : !this$vnet.equals(other$vnet)) {
            return false;
        }
        Object this$zone = this.getZone();
        Object other$zone = other.getZone();
        if (this$zone == null ? other$zone != null : !this$zone.equals(other$zone)) {
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
        return other instanceof AzureMachineProviderSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $acceleratedNetworking = this.getAcceleratedNetworking();
        result = result * prime + ($acceleratedNetworking == null ? 43 : $acceleratedNetworking.hashCode());
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $applicationSecurityGroups = this.getApplicationSecurityGroups();
        result = result * prime + ($applicationSecurityGroups == null ? 43 : $applicationSecurityGroups.hashCode());
        Object $availabilitySet = this.getAvailabilitySet();
        result = result * prime + ($availabilitySet == null ? 43 : $availabilitySet.hashCode());
        Object $capacityReservationGroupID = this.getCapacityReservationGroupID();
        result = result * prime + ($capacityReservationGroupID == null ? 43 : $capacityReservationGroupID.hashCode());
        Object $credentialsSecret = this.getCredentialsSecret();
        result = result * prime + ($credentialsSecret == null ? 43 : $credentialsSecret.hashCode());
        Object $dataDisks = this.getDataDisks();
        result = result * prime + ($dataDisks == null ? 43 : $dataDisks.hashCode());
        Object $diagnostics = this.getDiagnostics();
        result = result * prime + ($diagnostics == null ? 43 : $diagnostics.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $internalLoadBalancer = this.getInternalLoadBalancer();
        result = result * prime + ($internalLoadBalancer == null ? 43 : $internalLoadBalancer.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $location = this.getLocation();
        result = result * prime + ($location == null ? 43 : $location.hashCode());
        Object $managedIdentity = this.getManagedIdentity();
        result = result * prime + ($managedIdentity == null ? 43 : $managedIdentity.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $natRule = this.getNatRule();
        result = result * prime + ($natRule == null ? 43 : $natRule.hashCode());
        Object $networkResourceGroup = this.getNetworkResourceGroup();
        result = result * prime + ($networkResourceGroup == null ? 43 : $networkResourceGroup.hashCode());
        Object $osDisk = this.getOsDisk();
        result = result * prime + ($osDisk == null ? 43 : $osDisk.hashCode());
        Object $publicIP = this.getPublicIP();
        result = result * prime + ($publicIP == null ? 43 : $publicIP.hashCode());
        Object $publicLoadBalancer = this.getPublicLoadBalancer();
        result = result * prime + ($publicLoadBalancer == null ? 43 : $publicLoadBalancer.hashCode());
        Object $resourceGroup = this.getResourceGroup();
        result = result * prime + ($resourceGroup == null ? 43 : $resourceGroup.hashCode());
        Object $securityGroup = this.getSecurityGroup();
        result = result * prime + ($securityGroup == null ? 43 : $securityGroup.hashCode());
        Object $securityProfile = this.getSecurityProfile();
        result = result * prime + ($securityProfile == null ? 43 : $securityProfile.hashCode());
        Object $spotVMOptions = this.getSpotVMOptions();
        result = result * prime + ($spotVMOptions == null ? 43 : $spotVMOptions.hashCode());
        Object $sshPublicKey = this.getSshPublicKey();
        result = result * prime + ($sshPublicKey == null ? 43 : $sshPublicKey.hashCode());
        Object $subnet = this.getSubnet();
        result = result * prime + ($subnet == null ? 43 : $subnet.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $ultraSSDCapability = this.getUltraSSDCapability();
        result = result * prime + ($ultraSSDCapability == null ? 43 : $ultraSSDCapability.hashCode());
        Object $userDataSecret = this.getUserDataSecret();
        result = result * prime + ($userDataSecret == null ? 43 : $userDataSecret.hashCode());
        Object $vmSize = this.getVmSize();
        result = result * prime + ($vmSize == null ? 43 : $vmSize.hashCode());
        Object $vnet = this.getVnet();
        result = result * prime + ($vnet == null ? 43 : $vnet.hashCode());
        Object $zone = this.getZone();
        result = result * prime + ($zone == null ? 43 : $zone.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AzureMachineProviderSpec(" + "acceleratedNetworking=" + this.getAcceleratedNetworking() + ", apiVersion=" + this.getApiVersion() + ", applicationSecurityGroups=" + this.getApplicationSecurityGroups() + ", availabilitySet=" + this.getAvailabilitySet() + ", capacityReservationGroupID=" + this.getCapacityReservationGroupID() + ", credentialsSecret=" + this.getCredentialsSecret() + ", dataDisks=" + this.getDataDisks() + ", diagnostics=" + this.getDiagnostics() + ", image=" + this.getImage() + ", internalLoadBalancer=" + this.getInternalLoadBalancer() + ", kind=" + this.getKind() + ", location=" + this.getLocation() + ", managedIdentity=" + this.getManagedIdentity() + ", metadata=" + this.getMetadata() + ", natRule=" + this.getNatRule() + ", networkResourceGroup=" + this.getNetworkResourceGroup() + ", osDisk=" + this.getOsDisk() + ", publicIP=" + this.getPublicIP() + ", publicLoadBalancer=" + this.getPublicLoadBalancer() + ", resourceGroup=" + this.getResourceGroup() + ", securityGroup=" + this.getSecurityGroup() + ", securityProfile=" + this.getSecurityProfile() + ", spotVMOptions=" + this.getSpotVMOptions() + ", sshPublicKey=" + this.getSshPublicKey() + ", subnet=" + this.getSubnet() + ", tags=" + this.getTags() + ", ultraSSDCapability=" + this.getUltraSSDCapability() + ", userDataSecret=" + this.getUserDataSecret() + ", vmSize=" + this.getVmSize() + ", vnet=" + this.getVnet() + ", zone=" + this.getZone() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
