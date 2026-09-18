
package io.fabric8.openshift.api.model.installer.gcp.v1;

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
 * Platform stores all the global configuration that all machinesets use.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "computeSubnet",
    "controlPlaneSubnet",
    "defaultMachinePlatform",
    "dns",
    "endpoint",
    "firewallRulesManagement",
    "network",
    "networkProjectID",
    "projectID",
    "region",
    "userLabels",
    "userProvisionedDNS",
    "userTags"
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
public class Platform implements Editable<PlatformBuilder>, KubernetesResource
{

    @JsonProperty("computeSubnet")
    private String computeSubnet;
    @JsonProperty("controlPlaneSubnet")
    private String controlPlaneSubnet;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("dns")
    private DNS dns;
    @JsonProperty("endpoint")
    private PSCEndpoint endpoint;
    @JsonProperty("firewallRulesManagement")
    private String firewallRulesManagement;
    @JsonProperty("network")
    private String network;
    @JsonProperty("networkProjectID")
    private String networkProjectID;
    @JsonProperty("projectID")
    private String projectID;
    @JsonProperty("region")
    private String region;
    @JsonProperty("userLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UserLabel> userLabels = new ArrayList<>();
    @JsonProperty("userProvisionedDNS")
    private String userProvisionedDNS;
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<UserTag> userTags = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(String computeSubnet, String controlPlaneSubnet, MachinePool defaultMachinePlatform, DNS dns, PSCEndpoint endpoint, String firewallRulesManagement, String network, String networkProjectID, String projectID, String region, List<UserLabel> userLabels, String userProvisionedDNS, List<UserTag> userTags) {
        super();
        this.computeSubnet = computeSubnet;
        this.controlPlaneSubnet = controlPlaneSubnet;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.dns = dns;
        this.endpoint = endpoint;
        this.firewallRulesManagement = firewallRulesManagement;
        this.network = network;
        this.networkProjectID = networkProjectID;
        this.projectID = projectID;
        this.region = region;
        this.userLabels = userLabels;
        this.userProvisionedDNS = userProvisionedDNS;
        this.userTags = userTags;
    }

    /**
     * ComputeSubnet is an existing subnet where the compute nodes will be deployed. The value should be the name of the subnet.
     */
    @JsonProperty("computeSubnet")
    public String getComputeSubnet() {
        return computeSubnet;
    }

    /**
     * ComputeSubnet is an existing subnet where the compute nodes will be deployed. The value should be the name of the subnet.
     */
    @JsonProperty("computeSubnet")
    public void setComputeSubnet(String computeSubnet) {
        this.computeSubnet = computeSubnet;
    }

    /**
     * ControlPlaneSubnet is an existing subnet where the control plane will be deployed. The value should be the name of the subnet.
     */
    @JsonProperty("controlPlaneSubnet")
    public String getControlPlaneSubnet() {
        return controlPlaneSubnet;
    }

    /**
     * ControlPlaneSubnet is an existing subnet where the control plane will be deployed. The value should be the name of the subnet.
     */
    @JsonProperty("controlPlaneSubnet")
    public void setControlPlaneSubnet(String controlPlaneSubnet) {
        this.controlPlaneSubnet = controlPlaneSubnet;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("dns")
    public DNS getDns() {
        return dns;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("dns")
    public void setDns(DNS dns) {
        this.dns = dns;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("endpoint")
    public PSCEndpoint getEndpoint() {
        return endpoint;
    }

    /**
     * Platform stores all the global configuration that all machinesets use.
     */
    @JsonProperty("endpoint")
    public void setEndpoint(PSCEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * FirewallRulesManagement specifies the management policy for the cluster. Managed indicates that the firewall rules will be created and destroyed by the cluster. Unmanaged indicates that the user should create and destroy the firewall rules.
     */
    @JsonProperty("firewallRulesManagement")
    public String getFirewallRulesManagement() {
        return firewallRulesManagement;
    }

    /**
     * FirewallRulesManagement specifies the management policy for the cluster. Managed indicates that the firewall rules will be created and destroyed by the cluster. Unmanaged indicates that the user should create and destroy the firewall rules.
     */
    @JsonProperty("firewallRulesManagement")
    public void setFirewallRulesManagement(String firewallRulesManagement) {
        this.firewallRulesManagement = firewallRulesManagement;
    }

    /**
     * Network specifies an existing VPC where the cluster should be created rather than provisioning a new one.
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * Network specifies an existing VPC where the cluster should be created rather than provisioning a new one.
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * NetworkProjectID specifies which project the network and subnets exist in when they are not in the main ProjectID.
     */
    @JsonProperty("networkProjectID")
    public String getNetworkProjectID() {
        return networkProjectID;
    }

    /**
     * NetworkProjectID specifies which project the network and subnets exist in when they are not in the main ProjectID.
     */
    @JsonProperty("networkProjectID")
    public void setNetworkProjectID(String networkProjectID) {
        this.networkProjectID = networkProjectID;
    }

    /**
     * ProjectID is the the project that will be used for the cluster.
     */
    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    /**
     * ProjectID is the the project that will be used for the cluster.
     */
    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    /**
     * Region specifies the GCP region where the cluster will be created.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Region specifies the GCP region where the cluster will be created.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * userLabels has additional keys and values that the installer will add as labels to all resources that it creates on GCP. Resources created by the cluster itself may not include these labels.
     */
    @JsonProperty("userLabels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UserLabel> getUserLabels() {
        return userLabels;
    }

    /**
     * userLabels has additional keys and values that the installer will add as labels to all resources that it creates on GCP. Resources created by the cluster itself may not include these labels.
     */
    @JsonProperty("userLabels")
    public void setUserLabels(List<UserLabel> userLabels) {
        this.userLabels = userLabels;
    }

    /**
     * UserProvisionedDNS indicates if the customer is providing their own DNS solution in place of the default provisioned by the Installer.
     */
    @JsonProperty("userProvisionedDNS")
    public String getUserProvisionedDNS() {
        return userProvisionedDNS;
    }

    /**
     * UserProvisionedDNS indicates if the customer is providing their own DNS solution in place of the default provisioned by the Installer.
     */
    @JsonProperty("userProvisionedDNS")
    public void setUserProvisionedDNS(String userProvisionedDNS) {
        this.userProvisionedDNS = userProvisionedDNS;
    }

    /**
     * userTags has additional keys and values that the installer will add as tags to all resources that it creates on GCP. Resources created by the cluster itself may not include these tags. Tag key and tag value should be the shortnames of the tag key and tag value resource.
     */
    @JsonProperty("userTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<UserTag> getUserTags() {
        return userTags;
    }

    /**
     * userTags has additional keys and values that the installer will add as tags to all resources that it creates on GCP. Resources created by the cluster itself may not include these tags. Tag key and tag value should be the shortnames of the tag key and tag value resource.
     */
    @JsonProperty("userTags")
    public void setUserTags(List<UserTag> userTags) {
        this.userTags = userTags;
    }

    @JsonIgnore
    public PlatformBuilder edit() {
        return new PlatformBuilder(this);
    }

    @JsonIgnore
    public PlatformBuilder toBuilder() {
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
        if (!(o instanceof Platform)) {
            return false;
        }
        Platform other = (Platform) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$computeSubnet = this.getComputeSubnet();
        Object other$computeSubnet = other.getComputeSubnet();
        if (this$computeSubnet == null ? other$computeSubnet != null : !this$computeSubnet.equals(other$computeSubnet)) {
            return false;
        }
        Object this$controlPlaneSubnet = this.getControlPlaneSubnet();
        Object other$controlPlaneSubnet = other.getControlPlaneSubnet();
        if (this$controlPlaneSubnet == null ? other$controlPlaneSubnet != null : !this$controlPlaneSubnet.equals(other$controlPlaneSubnet)) {
            return false;
        }
        Object this$defaultMachinePlatform = this.getDefaultMachinePlatform();
        Object other$defaultMachinePlatform = other.getDefaultMachinePlatform();
        if (this$defaultMachinePlatform == null ? other$defaultMachinePlatform != null : !this$defaultMachinePlatform.equals(other$defaultMachinePlatform)) {
            return false;
        }
        Object this$dns = this.getDns();
        Object other$dns = other.getDns();
        if (this$dns == null ? other$dns != null : !this$dns.equals(other$dns)) {
            return false;
        }
        Object this$endpoint = this.getEndpoint();
        Object other$endpoint = other.getEndpoint();
        if (this$endpoint == null ? other$endpoint != null : !this$endpoint.equals(other$endpoint)) {
            return false;
        }
        Object this$firewallRulesManagement = this.getFirewallRulesManagement();
        Object other$firewallRulesManagement = other.getFirewallRulesManagement();
        if (this$firewallRulesManagement == null ? other$firewallRulesManagement != null : !this$firewallRulesManagement.equals(other$firewallRulesManagement)) {
            return false;
        }
        Object this$network = this.getNetwork();
        Object other$network = other.getNetwork();
        if (this$network == null ? other$network != null : !this$network.equals(other$network)) {
            return false;
        }
        Object this$networkProjectID = this.getNetworkProjectID();
        Object other$networkProjectID = other.getNetworkProjectID();
        if (this$networkProjectID == null ? other$networkProjectID != null : !this$networkProjectID.equals(other$networkProjectID)) {
            return false;
        }
        Object this$projectID = this.getProjectID();
        Object other$projectID = other.getProjectID();
        if (this$projectID == null ? other$projectID != null : !this$projectID.equals(other$projectID)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$userLabels = this.getUserLabels();
        Object other$userLabels = other.getUserLabels();
        if (this$userLabels == null ? other$userLabels != null : !this$userLabels.equals(other$userLabels)) {
            return false;
        }
        Object this$userProvisionedDNS = this.getUserProvisionedDNS();
        Object other$userProvisionedDNS = other.getUserProvisionedDNS();
        if (this$userProvisionedDNS == null ? other$userProvisionedDNS != null : !this$userProvisionedDNS.equals(other$userProvisionedDNS)) {
            return false;
        }
        Object this$userTags = this.getUserTags();
        Object other$userTags = other.getUserTags();
        if (this$userTags == null ? other$userTags != null : !this$userTags.equals(other$userTags)) {
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
        return other instanceof Platform;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $computeSubnet = this.getComputeSubnet();
        result = result * prime + ($computeSubnet == null ? 43 : $computeSubnet.hashCode());
        Object $controlPlaneSubnet = this.getControlPlaneSubnet();
        result = result * prime + ($controlPlaneSubnet == null ? 43 : $controlPlaneSubnet.hashCode());
        Object $defaultMachinePlatform = this.getDefaultMachinePlatform();
        result = result * prime + ($defaultMachinePlatform == null ? 43 : $defaultMachinePlatform.hashCode());
        Object $dns = this.getDns();
        result = result * prime + ($dns == null ? 43 : $dns.hashCode());
        Object $endpoint = this.getEndpoint();
        result = result * prime + ($endpoint == null ? 43 : $endpoint.hashCode());
        Object $firewallRulesManagement = this.getFirewallRulesManagement();
        result = result * prime + ($firewallRulesManagement == null ? 43 : $firewallRulesManagement.hashCode());
        Object $network = this.getNetwork();
        result = result * prime + ($network == null ? 43 : $network.hashCode());
        Object $networkProjectID = this.getNetworkProjectID();
        result = result * prime + ($networkProjectID == null ? 43 : $networkProjectID.hashCode());
        Object $projectID = this.getProjectID();
        result = result * prime + ($projectID == null ? 43 : $projectID.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $userLabels = this.getUserLabels();
        result = result * prime + ($userLabels == null ? 43 : $userLabels.hashCode());
        Object $userProvisionedDNS = this.getUserProvisionedDNS();
        result = result * prime + ($userProvisionedDNS == null ? 43 : $userProvisionedDNS.hashCode());
        Object $userTags = this.getUserTags();
        result = result * prime + ($userTags == null ? 43 : $userTags.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Platform(" + "computeSubnet=" + this.getComputeSubnet() + ", controlPlaneSubnet=" + this.getControlPlaneSubnet() + ", defaultMachinePlatform=" + this.getDefaultMachinePlatform() + ", dns=" + this.getDns() + ", endpoint=" + this.getEndpoint() + ", firewallRulesManagement=" + this.getFirewallRulesManagement() + ", network=" + this.getNetwork() + ", networkProjectID=" + this.getNetworkProjectID() + ", projectID=" + this.getProjectID() + ", region=" + this.getRegion() + ", userLabels=" + this.getUserLabels() + ", userProvisionedDNS=" + this.getUserProvisionedDNS() + ", userTags=" + this.getUserTags() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
