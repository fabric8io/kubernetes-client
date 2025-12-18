
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
import io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1.APIEndpoint;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aadProfile",
    "additionalTags",
    "addonProfiles",
    "apiServerAccessProfile",
    "asoManagedClusterPatches",
    "autoUpgradeProfile",
    "autoscalerProfile",
    "azureEnvironment",
    "controlPlaneEndpoint",
    "disableLocalAccounts",
    "dnsPrefix",
    "dnsServiceIP",
    "enablePreviewFeatures",
    "extensions",
    "fleetsMember",
    "httpProxyConfig",
    "identity",
    "identityRef",
    "kubeletUserAssignedIdentity",
    "loadBalancerProfile",
    "loadBalancerSKU",
    "location",
    "machineTemplate",
    "networkDataplane",
    "networkPlugin",
    "networkPluginMode",
    "networkPolicy",
    "nodeResourceGroupName",
    "oidcIssuerProfile",
    "outboundType",
    "resourceGroupName",
    "securityProfile",
    "sku",
    "sshPublicKey",
    "subscriptionID",
    "version",
    "virtualNetwork"
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
public class AzureManagedControlPlaneSpec implements Editable<AzureManagedControlPlaneSpecBuilder>, KubernetesResource
{

    @JsonProperty("aadProfile")
    private AADProfile aadProfile;
    @JsonProperty("additionalTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> additionalTags = new LinkedHashMap<>();
    @JsonProperty("addonProfiles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AddonProfile> addonProfiles = new ArrayList<>();
    @JsonProperty("apiServerAccessProfile")
    private APIServerAccessProfile apiServerAccessProfile;
    @JsonProperty("asoManagedClusterPatches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> asoManagedClusterPatches = new ArrayList<>();
    @JsonProperty("autoUpgradeProfile")
    private ManagedClusterAutoUpgradeProfile autoUpgradeProfile;
    @JsonProperty("autoscalerProfile")
    private AutoScalerProfile autoscalerProfile;
    @JsonProperty("azureEnvironment")
    private String azureEnvironment;
    @JsonProperty("controlPlaneEndpoint")
    private APIEndpoint controlPlaneEndpoint;
    @JsonProperty("disableLocalAccounts")
    private Boolean disableLocalAccounts;
    @JsonProperty("dnsPrefix")
    private String dnsPrefix;
    @JsonProperty("dnsServiceIP")
    private String dnsServiceIP;
    @JsonProperty("enablePreviewFeatures")
    private Boolean enablePreviewFeatures;
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AKSExtension> extensions = new ArrayList<>();
    @JsonProperty("fleetsMember")
    private FleetsMemberClassSpec fleetsMember;
    @JsonProperty("httpProxyConfig")
    private HTTPProxyConfig httpProxyConfig;
    @JsonProperty("identity")
    private Identity identity;
    @JsonProperty("identityRef")
    private ObjectReference identityRef;
    @JsonProperty("kubeletUserAssignedIdentity")
    private String kubeletUserAssignedIdentity;
    @JsonProperty("loadBalancerProfile")
    private LoadBalancerProfile loadBalancerProfile;
    @JsonProperty("loadBalancerSKU")
    private String loadBalancerSKU;
    @JsonProperty("location")
    private String location;
    @JsonProperty("machineTemplate")
    private AzureManagedControlPlaneTemplateMachineTemplate machineTemplate;
    @JsonProperty("networkDataplane")
    private String networkDataplane;
    @JsonProperty("networkPlugin")
    private String networkPlugin;
    @JsonProperty("networkPluginMode")
    private String networkPluginMode;
    @JsonProperty("networkPolicy")
    private String networkPolicy;
    @JsonProperty("nodeResourceGroupName")
    private String nodeResourceGroupName;
    @JsonProperty("oidcIssuerProfile")
    private OIDCIssuerProfile oidcIssuerProfile;
    @JsonProperty("outboundType")
    private String outboundType;
    @JsonProperty("resourceGroupName")
    private String resourceGroupName;
    @JsonProperty("securityProfile")
    private ManagedClusterSecurityProfile securityProfile;
    @JsonProperty("sku")
    private AKSSku sku;
    @JsonProperty("sshPublicKey")
    private String sshPublicKey;
    @JsonProperty("subscriptionID")
    private String subscriptionID;
    @JsonProperty("version")
    private String version;
    @JsonProperty("virtualNetwork")
    private ManagedControlPlaneVirtualNetwork virtualNetwork;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureManagedControlPlaneSpec() {
    }

    public AzureManagedControlPlaneSpec(AADProfile aadProfile, Map<String, String> additionalTags, List<AddonProfile> addonProfiles, APIServerAccessProfile apiServerAccessProfile, List<String> asoManagedClusterPatches, ManagedClusterAutoUpgradeProfile autoUpgradeProfile, AutoScalerProfile autoscalerProfile, String azureEnvironment, APIEndpoint controlPlaneEndpoint, Boolean disableLocalAccounts, String dnsPrefix, String dnsServiceIP, Boolean enablePreviewFeatures, List<AKSExtension> extensions, FleetsMemberClassSpec fleetsMember, HTTPProxyConfig httpProxyConfig, Identity identity, ObjectReference identityRef, String kubeletUserAssignedIdentity, LoadBalancerProfile loadBalancerProfile, String loadBalancerSKU, String location, AzureManagedControlPlaneTemplateMachineTemplate machineTemplate, String networkDataplane, String networkPlugin, String networkPluginMode, String networkPolicy, String nodeResourceGroupName, OIDCIssuerProfile oidcIssuerProfile, String outboundType, String resourceGroupName, ManagedClusterSecurityProfile securityProfile, AKSSku sku, String sshPublicKey, String subscriptionID, String version, ManagedControlPlaneVirtualNetwork virtualNetwork) {
        super();
        this.aadProfile = aadProfile;
        this.additionalTags = additionalTags;
        this.addonProfiles = addonProfiles;
        this.apiServerAccessProfile = apiServerAccessProfile;
        this.asoManagedClusterPatches = asoManagedClusterPatches;
        this.autoUpgradeProfile = autoUpgradeProfile;
        this.autoscalerProfile = autoscalerProfile;
        this.azureEnvironment = azureEnvironment;
        this.controlPlaneEndpoint = controlPlaneEndpoint;
        this.disableLocalAccounts = disableLocalAccounts;
        this.dnsPrefix = dnsPrefix;
        this.dnsServiceIP = dnsServiceIP;
        this.enablePreviewFeatures = enablePreviewFeatures;
        this.extensions = extensions;
        this.fleetsMember = fleetsMember;
        this.httpProxyConfig = httpProxyConfig;
        this.identity = identity;
        this.identityRef = identityRef;
        this.kubeletUserAssignedIdentity = kubeletUserAssignedIdentity;
        this.loadBalancerProfile = loadBalancerProfile;
        this.loadBalancerSKU = loadBalancerSKU;
        this.location = location;
        this.machineTemplate = machineTemplate;
        this.networkDataplane = networkDataplane;
        this.networkPlugin = networkPlugin;
        this.networkPluginMode = networkPluginMode;
        this.networkPolicy = networkPolicy;
        this.nodeResourceGroupName = nodeResourceGroupName;
        this.oidcIssuerProfile = oidcIssuerProfile;
        this.outboundType = outboundType;
        this.resourceGroupName = resourceGroupName;
        this.securityProfile = securityProfile;
        this.sku = sku;
        this.sshPublicKey = sshPublicKey;
        this.subscriptionID = subscriptionID;
        this.version = version;
        this.virtualNetwork = virtualNetwork;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("aadProfile")
    public AADProfile getAadProfile() {
        return aadProfile;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("aadProfile")
    public void setAadProfile(AADProfile aadProfile) {
        this.aadProfile = aadProfile;
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
     * AddonProfiles are the profiles of managed cluster add-on.
     */
    @JsonProperty("addonProfiles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AddonProfile> getAddonProfiles() {
        return addonProfiles;
    }

    /**
     * AddonProfiles are the profiles of managed cluster add-on.
     */
    @JsonProperty("addonProfiles")
    public void setAddonProfiles(List<AddonProfile> addonProfiles) {
        this.addonProfiles = addonProfiles;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("apiServerAccessProfile")
    public APIServerAccessProfile getApiServerAccessProfile() {
        return apiServerAccessProfile;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("apiServerAccessProfile")
    public void setApiServerAccessProfile(APIServerAccessProfile apiServerAccessProfile) {
        this.apiServerAccessProfile = apiServerAccessProfile;
    }

    /**
     * ASOManagedClusterPatches defines JSON merge patches to be applied to the generated ASO ManagedCluster resource. WARNING: This is meant to be used sparingly to enable features for development and testing that are not otherwise represented in the CAPZ API. Misconfiguration that conflicts with CAPZ's normal mode of operation is possible.
     */
    @JsonProperty("asoManagedClusterPatches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAsoManagedClusterPatches() {
        return asoManagedClusterPatches;
    }

    /**
     * ASOManagedClusterPatches defines JSON merge patches to be applied to the generated ASO ManagedCluster resource. WARNING: This is meant to be used sparingly to enable features for development and testing that are not otherwise represented in the CAPZ API. Misconfiguration that conflicts with CAPZ's normal mode of operation is possible.
     */
    @JsonProperty("asoManagedClusterPatches")
    public void setAsoManagedClusterPatches(List<String> asoManagedClusterPatches) {
        this.asoManagedClusterPatches = asoManagedClusterPatches;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("autoUpgradeProfile")
    public ManagedClusterAutoUpgradeProfile getAutoUpgradeProfile() {
        return autoUpgradeProfile;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("autoUpgradeProfile")
    public void setAutoUpgradeProfile(ManagedClusterAutoUpgradeProfile autoUpgradeProfile) {
        this.autoUpgradeProfile = autoUpgradeProfile;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("autoscalerProfile")
    public AutoScalerProfile getAutoscalerProfile() {
        return autoscalerProfile;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("autoscalerProfile")
    public void setAutoscalerProfile(AutoScalerProfile autoscalerProfile) {
        this.autoscalerProfile = autoscalerProfile;
    }

    /**
     * AzureEnvironment is the name of the AzureCloud to be used. The default value that would be used by most users is "AzurePublicCloud", other values are: - ChinaCloud: "AzureChinaCloud" - PublicCloud: "AzurePublicCloud" - USGovernmentCloud: "AzureUSGovernmentCloud"<br><p> <br><p> Note that values other than the default must also be accompanied by corresponding changes to the aso-controller-settings Secret to configure ASO to refer to the non-Public cloud. ASO currently does not support referring to multiple different clouds in a single installation. The following fields must be defined in the Secret: - AZURE_AUTHORITY_HOST - AZURE_RESOURCE_MANAGER_ENDPOINT - AZURE_RESOURCE_MANAGER_AUDIENCE<br><p> <br><p> See the [ASO docs] for more details.<br><p> <br><p> [ASO docs]: https://azure.github.io/azure-service-operator/guide/aso-controller-settings-options/
     */
    @JsonProperty("azureEnvironment")
    public String getAzureEnvironment() {
        return azureEnvironment;
    }

    /**
     * AzureEnvironment is the name of the AzureCloud to be used. The default value that would be used by most users is "AzurePublicCloud", other values are: - ChinaCloud: "AzureChinaCloud" - PublicCloud: "AzurePublicCloud" - USGovernmentCloud: "AzureUSGovernmentCloud"<br><p> <br><p> Note that values other than the default must also be accompanied by corresponding changes to the aso-controller-settings Secret to configure ASO to refer to the non-Public cloud. ASO currently does not support referring to multiple different clouds in a single installation. The following fields must be defined in the Secret: - AZURE_AUTHORITY_HOST - AZURE_RESOURCE_MANAGER_ENDPOINT - AZURE_RESOURCE_MANAGER_AUDIENCE<br><p> <br><p> See the [ASO docs] for more details.<br><p> <br><p> [ASO docs]: https://azure.github.io/azure-service-operator/guide/aso-controller-settings-options/
     */
    @JsonProperty("azureEnvironment")
    public void setAzureEnvironment(String azureEnvironment) {
        this.azureEnvironment = azureEnvironment;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("controlPlaneEndpoint")
    public APIEndpoint getControlPlaneEndpoint() {
        return controlPlaneEndpoint;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("controlPlaneEndpoint")
    public void setControlPlaneEndpoint(APIEndpoint controlPlaneEndpoint) {
        this.controlPlaneEndpoint = controlPlaneEndpoint;
    }

    /**
     * DisableLocalAccounts disables getting static credentials for this cluster when set. Expected to only be used for AAD clusters.
     */
    @JsonProperty("disableLocalAccounts")
    public Boolean getDisableLocalAccounts() {
        return disableLocalAccounts;
    }

    /**
     * DisableLocalAccounts disables getting static credentials for this cluster when set. Expected to only be used for AAD clusters.
     */
    @JsonProperty("disableLocalAccounts")
    public void setDisableLocalAccounts(Boolean disableLocalAccounts) {
        this.disableLocalAccounts = disableLocalAccounts;
    }

    /**
     * DNSPrefix allows the user to customize dns prefix. Immutable.
     */
    @JsonProperty("dnsPrefix")
    public String getDnsPrefix() {
        return dnsPrefix;
    }

    /**
     * DNSPrefix allows the user to customize dns prefix. Immutable.
     */
    @JsonProperty("dnsPrefix")
    public void setDnsPrefix(String dnsPrefix) {
        this.dnsPrefix = dnsPrefix;
    }

    /**
     * DNSServiceIP is an IP address assigned to the Kubernetes DNS service. It must be within the Kubernetes service address range specified in serviceCidr. Immutable.
     */
    @JsonProperty("dnsServiceIP")
    public String getDnsServiceIP() {
        return dnsServiceIP;
    }

    /**
     * DNSServiceIP is an IP address assigned to the Kubernetes DNS service. It must be within the Kubernetes service address range specified in serviceCidr. Immutable.
     */
    @JsonProperty("dnsServiceIP")
    public void setDnsServiceIP(String dnsServiceIP) {
        this.dnsServiceIP = dnsServiceIP;
    }

    /**
     * EnablePreviewFeatures enables preview features for the cluster.
     */
    @JsonProperty("enablePreviewFeatures")
    public Boolean getEnablePreviewFeatures() {
        return enablePreviewFeatures;
    }

    /**
     * EnablePreviewFeatures enables preview features for the cluster.
     */
    @JsonProperty("enablePreviewFeatures")
    public void setEnablePreviewFeatures(Boolean enablePreviewFeatures) {
        this.enablePreviewFeatures = enablePreviewFeatures;
    }

    /**
     * Extensions is a list of AKS extensions to be installed on the cluster.
     */
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AKSExtension> getExtensions() {
        return extensions;
    }

    /**
     * Extensions is a list of AKS extensions to be installed on the cluster.
     */
    @JsonProperty("extensions")
    public void setExtensions(List<AKSExtension> extensions) {
        this.extensions = extensions;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("fleetsMember")
    public FleetsMemberClassSpec getFleetsMember() {
        return fleetsMember;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("fleetsMember")
    public void setFleetsMember(FleetsMemberClassSpec fleetsMember) {
        this.fleetsMember = fleetsMember;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("httpProxyConfig")
    public HTTPProxyConfig getHttpProxyConfig() {
        return httpProxyConfig;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("httpProxyConfig")
    public void setHttpProxyConfig(HTTPProxyConfig httpProxyConfig) {
        this.httpProxyConfig = httpProxyConfig;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("identity")
    public Identity getIdentity() {
        return identity;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("identity")
    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("identityRef")
    public ObjectReference getIdentityRef() {
        return identityRef;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("identityRef")
    public void setIdentityRef(ObjectReference identityRef) {
        this.identityRef = identityRef;
    }

    /**
     * KubeletUserAssignedIdentity is the user-assigned identity for kubelet. For authentication with Azure Container Registry.
     */
    @JsonProperty("kubeletUserAssignedIdentity")
    public String getKubeletUserAssignedIdentity() {
        return kubeletUserAssignedIdentity;
    }

    /**
     * KubeletUserAssignedIdentity is the user-assigned identity for kubelet. For authentication with Azure Container Registry.
     */
    @JsonProperty("kubeletUserAssignedIdentity")
    public void setKubeletUserAssignedIdentity(String kubeletUserAssignedIdentity) {
        this.kubeletUserAssignedIdentity = kubeletUserAssignedIdentity;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("loadBalancerProfile")
    public LoadBalancerProfile getLoadBalancerProfile() {
        return loadBalancerProfile;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("loadBalancerProfile")
    public void setLoadBalancerProfile(LoadBalancerProfile loadBalancerProfile) {
        this.loadBalancerProfile = loadBalancerProfile;
    }

    /**
     * LoadBalancerSKU is the SKU of the loadBalancer to be provisioned. Immutable.
     */
    @JsonProperty("loadBalancerSKU")
    public String getLoadBalancerSKU() {
        return loadBalancerSKU;
    }

    /**
     * LoadBalancerSKU is the SKU of the loadBalancer to be provisioned. Immutable.
     */
    @JsonProperty("loadBalancerSKU")
    public void setLoadBalancerSKU(String loadBalancerSKU) {
        this.loadBalancerSKU = loadBalancerSKU;
    }

    /**
     * Location is a string matching one of the canonical Azure region names. Examples: "westus2", "eastus".
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * Location is a string matching one of the canonical Azure region names. Examples: "westus2", "eastus".
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("machineTemplate")
    public AzureManagedControlPlaneTemplateMachineTemplate getMachineTemplate() {
        return machineTemplate;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("machineTemplate")
    public void setMachineTemplate(AzureManagedControlPlaneTemplateMachineTemplate machineTemplate) {
        this.machineTemplate = machineTemplate;
    }

    /**
     * NetworkDataplane is the dataplane used for building the Kubernetes network.
     */
    @JsonProperty("networkDataplane")
    public String getNetworkDataplane() {
        return networkDataplane;
    }

    /**
     * NetworkDataplane is the dataplane used for building the Kubernetes network.
     */
    @JsonProperty("networkDataplane")
    public void setNetworkDataplane(String networkDataplane) {
        this.networkDataplane = networkDataplane;
    }

    /**
     * NetworkPlugin used for building Kubernetes network.
     */
    @JsonProperty("networkPlugin")
    public String getNetworkPlugin() {
        return networkPlugin;
    }

    /**
     * NetworkPlugin used for building Kubernetes network.
     */
    @JsonProperty("networkPlugin")
    public void setNetworkPlugin(String networkPlugin) {
        this.networkPlugin = networkPlugin;
    }

    /**
     * NetworkPluginMode is the mode the network plugin should use. Allowed value is "overlay".
     */
    @JsonProperty("networkPluginMode")
    public String getNetworkPluginMode() {
        return networkPluginMode;
    }

    /**
     * NetworkPluginMode is the mode the network plugin should use. Allowed value is "overlay".
     */
    @JsonProperty("networkPluginMode")
    public void setNetworkPluginMode(String networkPluginMode) {
        this.networkPluginMode = networkPluginMode;
    }

    /**
     * NetworkPolicy used for building Kubernetes network.
     */
    @JsonProperty("networkPolicy")
    public String getNetworkPolicy() {
        return networkPolicy;
    }

    /**
     * NetworkPolicy used for building Kubernetes network.
     */
    @JsonProperty("networkPolicy")
    public void setNetworkPolicy(String networkPolicy) {
        this.networkPolicy = networkPolicy;
    }

    /**
     * NodeResourceGroupName is the name of the resource group containing cluster IaaS resources. Will be populated to default in webhook. Immutable.
     */
    @JsonProperty("nodeResourceGroupName")
    public String getNodeResourceGroupName() {
        return nodeResourceGroupName;
    }

    /**
     * NodeResourceGroupName is the name of the resource group containing cluster IaaS resources. Will be populated to default in webhook. Immutable.
     */
    @JsonProperty("nodeResourceGroupName")
    public void setNodeResourceGroupName(String nodeResourceGroupName) {
        this.nodeResourceGroupName = nodeResourceGroupName;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("oidcIssuerProfile")
    public OIDCIssuerProfile getOidcIssuerProfile() {
        return oidcIssuerProfile;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("oidcIssuerProfile")
    public void setOidcIssuerProfile(OIDCIssuerProfile oidcIssuerProfile) {
        this.oidcIssuerProfile = oidcIssuerProfile;
    }

    /**
     * Outbound configuration used by Nodes.
     */
    @JsonProperty("outboundType")
    public String getOutboundType() {
        return outboundType;
    }

    /**
     * Outbound configuration used by Nodes.
     */
    @JsonProperty("outboundType")
    public void setOutboundType(String outboundType) {
        this.outboundType = outboundType;
    }

    /**
     * ResourceGroupName is the name of the Azure resource group for this AKS Cluster. Immutable.
     */
    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    /**
     * ResourceGroupName is the name of the Azure resource group for this AKS Cluster. Immutable.
     */
    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("securityProfile")
    public ManagedClusterSecurityProfile getSecurityProfile() {
        return securityProfile;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("securityProfile")
    public void setSecurityProfile(ManagedClusterSecurityProfile securityProfile) {
        this.securityProfile = securityProfile;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("sku")
    public AKSSku getSku() {
        return sku;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("sku")
    public void setSku(AKSSku sku) {
        this.sku = sku;
    }

    /**
     * SSHPublicKey is a string literal containing an ssh public key base64 encoded. Use empty string to autogenerate new key. Use null value to not set key. Immutable.
     */
    @JsonProperty("sshPublicKey")
    public String getSshPublicKey() {
        return sshPublicKey;
    }

    /**
     * SSHPublicKey is a string literal containing an ssh public key base64 encoded. Use empty string to autogenerate new key. Use null value to not set key. Immutable.
     */
    @JsonProperty("sshPublicKey")
    public void setSshPublicKey(String sshPublicKey) {
        this.sshPublicKey = sshPublicKey;
    }

    /**
     * SubscriptionID is the GUID of the Azure subscription that owns this cluster.
     */
    @JsonProperty("subscriptionID")
    public String getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * SubscriptionID is the GUID of the Azure subscription that owns this cluster.
     */
    @JsonProperty("subscriptionID")
    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    /**
     * Version defines the desired Kubernetes version.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * Version defines the desired Kubernetes version.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("virtualNetwork")
    public ManagedControlPlaneVirtualNetwork getVirtualNetwork() {
        return virtualNetwork;
    }

    /**
     * AzureManagedControlPlaneSpec defines the desired state of AzureManagedControlPlane.
     */
    @JsonProperty("virtualNetwork")
    public void setVirtualNetwork(ManagedControlPlaneVirtualNetwork virtualNetwork) {
        this.virtualNetwork = virtualNetwork;
    }

    @JsonIgnore
    public AzureManagedControlPlaneSpecBuilder edit() {
        return new AzureManagedControlPlaneSpecBuilder(this);
    }

    @JsonIgnore
    public AzureManagedControlPlaneSpecBuilder toBuilder() {
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
