
package io.fabric8.openshift.api.model.machine.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adminStateUp",
    "allowedAddressPairs",
    "description",
    "fixedIPs",
    "hostID",
    "macAddress",
    "nameSuffix",
    "networkID",
    "portSecurity",
    "profile",
    "projectID",
    "securityGroups",
    "tags",
    "tenantID",
    "trunk",
    "vnicType"
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
public class PortOpts implements Editable<PortOptsBuilder>, KubernetesResource
{

    @JsonProperty("adminStateUp")
    private Boolean adminStateUp;
    @JsonProperty("allowedAddressPairs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AddressPair> allowedAddressPairs = new ArrayList<>();
    @JsonProperty("description")
    private String description;
    @JsonProperty("fixedIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FixedIPs> fixedIPs = new ArrayList<>();
    @JsonProperty("hostID")
    private String hostID;
    @JsonProperty("macAddress")
    private String macAddress;
    @JsonProperty("nameSuffix")
    private String nameSuffix;
    @JsonProperty("networkID")
    private String networkID;
    @JsonProperty("portSecurity")
    private Boolean portSecurity;
    @JsonProperty("profile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> profile = new LinkedHashMap<>();
    @JsonProperty("projectID")
    private String projectID;
    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> securityGroups = new ArrayList<>();
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tags = new ArrayList<>();
    @JsonProperty("tenantID")
    private String tenantID;
    @JsonProperty("trunk")
    private Boolean trunk;
    @JsonProperty("vnicType")
    private String vnicType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PortOpts() {
    }

    public PortOpts(Boolean adminStateUp, List<AddressPair> allowedAddressPairs, String description, List<FixedIPs> fixedIPs, String hostID, String macAddress, String nameSuffix, String networkID, Boolean portSecurity, Map<String, String> profile, String projectID, List<String> securityGroups, List<String> tags, String tenantID, Boolean trunk, String vnicType) {
        super();
        this.adminStateUp = adminStateUp;
        this.allowedAddressPairs = allowedAddressPairs;
        this.description = description;
        this.fixedIPs = fixedIPs;
        this.hostID = hostID;
        this.macAddress = macAddress;
        this.nameSuffix = nameSuffix;
        this.networkID = networkID;
        this.portSecurity = portSecurity;
        this.profile = profile;
        this.projectID = projectID;
        this.securityGroups = securityGroups;
        this.tags = tags;
        this.tenantID = tenantID;
        this.trunk = trunk;
        this.vnicType = vnicType;
    }

    /**
     * adminStateUp sets the administrative state of the created port to up (true), or down (false).
     */
    @JsonProperty("adminStateUp")
    public Boolean getAdminStateUp() {
        return adminStateUp;
    }

    /**
     * adminStateUp sets the administrative state of the created port to up (true), or down (false).
     */
    @JsonProperty("adminStateUp")
    public void setAdminStateUp(Boolean adminStateUp) {
        this.adminStateUp = adminStateUp;
    }

    /**
     * allowedAddressPairs specifies a set of allowed address pairs to add to the port.
     */
    @JsonProperty("allowedAddressPairs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AddressPair> getAllowedAddressPairs() {
        return allowedAddressPairs;
    }

    /**
     * allowedAddressPairs specifies a set of allowed address pairs to add to the port.
     */
    @JsonProperty("allowedAddressPairs")
    public void setAllowedAddressPairs(List<AddressPair> allowedAddressPairs) {
        this.allowedAddressPairs = allowedAddressPairs;
    }

    /**
     * description specifies the description of the created port.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description specifies the description of the created port.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * fixedIPs specifies a set of fixed IPs to assign to the port. They must all be valid for the port's network.
     */
    @JsonProperty("fixedIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FixedIPs> getFixedIPs() {
        return fixedIPs;
    }

    /**
     * fixedIPs specifies a set of fixed IPs to assign to the port. They must all be valid for the port's network.
     */
    @JsonProperty("fixedIPs")
    public void setFixedIPs(List<FixedIPs> fixedIPs) {
        this.fixedIPs = fixedIPs;
    }

    /**
     * The ID of the host where the port is allocated. Do not use this field: it cannot be used correctly. Deprecated: hostID is silently ignored. It will be removed with no replacement.
     */
    @JsonProperty("hostID")
    public String getHostID() {
        return hostID;
    }

    /**
     * The ID of the host where the port is allocated. Do not use this field: it cannot be used correctly. Deprecated: hostID is silently ignored. It will be removed with no replacement.
     */
    @JsonProperty("hostID")
    public void setHostID(String hostID) {
        this.hostID = hostID;
    }

    /**
     * macAddress specifies the MAC address of the created port.
     */
    @JsonProperty("macAddress")
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * macAddress specifies the MAC address of the created port.
     */
    @JsonProperty("macAddress")
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * If nameSuffix is specified the created port will be named &lt;machine name&gt;-&lt;nameSuffix&gt;. If not specified the port will be named &lt;machine-name&gt;-&lt;index of this port&gt;.
     */
    @JsonProperty("nameSuffix")
    public String getNameSuffix() {
        return nameSuffix;
    }

    /**
     * If nameSuffix is specified the created port will be named &lt;machine name&gt;-&lt;nameSuffix&gt;. If not specified the port will be named &lt;machine-name&gt;-&lt;index of this port&gt;.
     */
    @JsonProperty("nameSuffix")
    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    /**
     * networkID is the ID of the network the port will be created in. It is required.
     */
    @JsonProperty("networkID")
    public String getNetworkID() {
        return networkID;
    }

    /**
     * networkID is the ID of the network the port will be created in. It is required.
     */
    @JsonProperty("networkID")
    public void setNetworkID(String networkID) {
        this.networkID = networkID;
    }

    /**
     * enable or disable security on a given port incompatible with securityGroups and allowedAddressPairs
     */
    @JsonProperty("portSecurity")
    public Boolean getPortSecurity() {
        return portSecurity;
    }

    /**
     * enable or disable security on a given port incompatible with securityGroups and allowedAddressPairs
     */
    @JsonProperty("portSecurity")
    public void setPortSecurity(Boolean portSecurity) {
        this.portSecurity = portSecurity;
    }

    /**
     * A dictionary that enables the application running on the specified host to pass and receive virtual network interface (VIF) port-specific information to the plug-in.
     */
    @JsonProperty("profile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getProfile() {
        return profile;
    }

    /**
     * A dictionary that enables the application running on the specified host to pass and receive virtual network interface (VIF) port-specific information to the plug-in.
     */
    @JsonProperty("profile")
    public void setProfile(Map<String, String> profile) {
        this.profile = profile;
    }

    /**
     * projectID specifies the project ID of the created port. Note that this requires OpenShift to have administrative permissions, which is typically not the case. Use of this field is not recommended. Deprecated: projectID is silently ignored.
     */
    @JsonProperty("projectID")
    public String getProjectID() {
        return projectID;
    }

    /**
     * projectID specifies the project ID of the created port. Note that this requires OpenShift to have administrative permissions, which is typically not the case. Use of this field is not recommended. Deprecated: projectID is silently ignored.
     */
    @JsonProperty("projectID")
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    /**
     * securityGroups specifies a set of security group UUIDs to use instead of the machine's default security groups. The default security groups will be used if this is left empty or not specified.
     */
    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSecurityGroups() {
        return securityGroups;
    }

    /**
     * securityGroups specifies a set of security group UUIDs to use instead of the machine's default security groups. The default security groups will be used if this is left empty or not specified.
     */
    @JsonProperty("securityGroups")
    public void setSecurityGroups(List<String> securityGroups) {
        this.securityGroups = securityGroups;
    }

    /**
     * tags species a set of tags to add to the port.
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    /**
     * tags species a set of tags to add to the port.
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * tenantID specifies the tenant ID of the created port. Note that this requires OpenShift to have administrative permissions, which is typically not the case. Use of this field is not recommended. Deprecated: tenantID is silently ignored.
     */
    @JsonProperty("tenantID")
    public String getTenantID() {
        return tenantID;
    }

    /**
     * tenantID specifies the tenant ID of the created port. Note that this requires OpenShift to have administrative permissions, which is typically not the case. Use of this field is not recommended. Deprecated: tenantID is silently ignored.
     */
    @JsonProperty("tenantID")
    public void setTenantID(String tenantID) {
        this.tenantID = tenantID;
    }

    /**
     * Enables and disables trunk at port level. If not provided, openStackMachine.Spec.Trunk is inherited.
     */
    @JsonProperty("trunk")
    public Boolean getTrunk() {
        return trunk;
    }

    /**
     * Enables and disables trunk at port level. If not provided, openStackMachine.Spec.Trunk is inherited.
     */
    @JsonProperty("trunk")
    public void setTrunk(Boolean trunk) {
        this.trunk = trunk;
    }

    /**
     * The virtual network interface card (vNIC) type that is bound to the neutron port.
     */
    @JsonProperty("vnicType")
    public String getVnicType() {
        return vnicType;
    }

    /**
     * The virtual network interface card (vNIC) type that is bound to the neutron port.
     */
    @JsonProperty("vnicType")
    public void setVnicType(String vnicType) {
        this.vnicType = vnicType;
    }

    @JsonIgnore
    public PortOptsBuilder edit() {
        return new PortOptsBuilder(this);
    }

    @JsonIgnore
    public PortOptsBuilder toBuilder() {
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
        if (!(o instanceof PortOpts)) {
            return false;
        }
        PortOpts other = (PortOpts) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$adminStateUp = this.getAdminStateUp();
        Object other$adminStateUp = other.getAdminStateUp();
        if (this$adminStateUp == null ? other$adminStateUp != null : !this$adminStateUp.equals(other$adminStateUp)) {
            return false;
        }
        Object this$allowedAddressPairs = this.getAllowedAddressPairs();
        Object other$allowedAddressPairs = other.getAllowedAddressPairs();
        if (this$allowedAddressPairs == null ? other$allowedAddressPairs != null : !this$allowedAddressPairs.equals(other$allowedAddressPairs)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$fixedIPs = this.getFixedIPs();
        Object other$fixedIPs = other.getFixedIPs();
        if (this$fixedIPs == null ? other$fixedIPs != null : !this$fixedIPs.equals(other$fixedIPs)) {
            return false;
        }
        Object this$hostID = this.getHostID();
        Object other$hostID = other.getHostID();
        if (this$hostID == null ? other$hostID != null : !this$hostID.equals(other$hostID)) {
            return false;
        }
        Object this$macAddress = this.getMacAddress();
        Object other$macAddress = other.getMacAddress();
        if (this$macAddress == null ? other$macAddress != null : !this$macAddress.equals(other$macAddress)) {
            return false;
        }
        Object this$nameSuffix = this.getNameSuffix();
        Object other$nameSuffix = other.getNameSuffix();
        if (this$nameSuffix == null ? other$nameSuffix != null : !this$nameSuffix.equals(other$nameSuffix)) {
            return false;
        }
        Object this$networkID = this.getNetworkID();
        Object other$networkID = other.getNetworkID();
        if (this$networkID == null ? other$networkID != null : !this$networkID.equals(other$networkID)) {
            return false;
        }
        Object this$portSecurity = this.getPortSecurity();
        Object other$portSecurity = other.getPortSecurity();
        if (this$portSecurity == null ? other$portSecurity != null : !this$portSecurity.equals(other$portSecurity)) {
            return false;
        }
        Object this$profile = this.getProfile();
        Object other$profile = other.getProfile();
        if (this$profile == null ? other$profile != null : !this$profile.equals(other$profile)) {
            return false;
        }
        Object this$projectID = this.getProjectID();
        Object other$projectID = other.getProjectID();
        if (this$projectID == null ? other$projectID != null : !this$projectID.equals(other$projectID)) {
            return false;
        }
        Object this$securityGroups = this.getSecurityGroups();
        Object other$securityGroups = other.getSecurityGroups();
        if (this$securityGroups == null ? other$securityGroups != null : !this$securityGroups.equals(other$securityGroups)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
            return false;
        }
        Object this$tenantID = this.getTenantID();
        Object other$tenantID = other.getTenantID();
        if (this$tenantID == null ? other$tenantID != null : !this$tenantID.equals(other$tenantID)) {
            return false;
        }
        Object this$trunk = this.getTrunk();
        Object other$trunk = other.getTrunk();
        if (this$trunk == null ? other$trunk != null : !this$trunk.equals(other$trunk)) {
            return false;
        }
        Object this$vnicType = this.getVnicType();
        Object other$vnicType = other.getVnicType();
        if (this$vnicType == null ? other$vnicType != null : !this$vnicType.equals(other$vnicType)) {
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
        return other instanceof PortOpts;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $adminStateUp = this.getAdminStateUp();
        result = result * prime + ($adminStateUp == null ? 43 : $adminStateUp.hashCode());
        Object $allowedAddressPairs = this.getAllowedAddressPairs();
        result = result * prime + ($allowedAddressPairs == null ? 43 : $allowedAddressPairs.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $fixedIPs = this.getFixedIPs();
        result = result * prime + ($fixedIPs == null ? 43 : $fixedIPs.hashCode());
        Object $hostID = this.getHostID();
        result = result * prime + ($hostID == null ? 43 : $hostID.hashCode());
        Object $macAddress = this.getMacAddress();
        result = result * prime + ($macAddress == null ? 43 : $macAddress.hashCode());
        Object $nameSuffix = this.getNameSuffix();
        result = result * prime + ($nameSuffix == null ? 43 : $nameSuffix.hashCode());
        Object $networkID = this.getNetworkID();
        result = result * prime + ($networkID == null ? 43 : $networkID.hashCode());
        Object $portSecurity = this.getPortSecurity();
        result = result * prime + ($portSecurity == null ? 43 : $portSecurity.hashCode());
        Object $profile = this.getProfile();
        result = result * prime + ($profile == null ? 43 : $profile.hashCode());
        Object $projectID = this.getProjectID();
        result = result * prime + ($projectID == null ? 43 : $projectID.hashCode());
        Object $securityGroups = this.getSecurityGroups();
        result = result * prime + ($securityGroups == null ? 43 : $securityGroups.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $tenantID = this.getTenantID();
        result = result * prime + ($tenantID == null ? 43 : $tenantID.hashCode());
        Object $trunk = this.getTrunk();
        result = result * prime + ($trunk == null ? 43 : $trunk.hashCode());
        Object $vnicType = this.getVnicType();
        result = result * prime + ($vnicType == null ? 43 : $vnicType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PortOpts(" + "adminStateUp=" + this.getAdminStateUp() + ", allowedAddressPairs=" + this.getAllowedAddressPairs() + ", description=" + this.getDescription() + ", fixedIPs=" + this.getFixedIPs() + ", hostID=" + this.getHostID() + ", macAddress=" + this.getMacAddress() + ", nameSuffix=" + this.getNameSuffix() + ", networkID=" + this.getNetworkID() + ", portSecurity=" + this.getPortSecurity() + ", profile=" + this.getProfile() + ", projectID=" + this.getProjectID() + ", securityGroups=" + this.getSecurityGroups() + ", tags=" + this.getTags() + ", tenantID=" + this.getTenantID() + ", trunk=" + this.getTrunk() + ", vnicType=" + this.getVnicType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
