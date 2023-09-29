
package io.fabric8.openshift.api.model.machine.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class PortOpts implements Editable<PortOptsBuilder> , KubernetesResource
{

    @JsonProperty("adminStateUp")
    private Boolean adminStateUp;
    @JsonProperty("allowedAddressPairs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AddressPair> allowedAddressPairs = new ArrayList<AddressPair>();
    @JsonProperty("description")
    private java.lang.String description;
    @JsonProperty("fixedIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FixedIPs> fixedIPs = new ArrayList<FixedIPs>();
    @JsonProperty("hostID")
    private java.lang.String hostID;
    @JsonProperty("macAddress")
    private java.lang.String macAddress;
    @JsonProperty("nameSuffix")
    private java.lang.String nameSuffix;
    @JsonProperty("networkID")
    private java.lang.String networkID;
    @JsonProperty("portSecurity")
    private Boolean portSecurity;
    @JsonProperty("profile")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> profile = new LinkedHashMap<String, String>();
    @JsonProperty("projectID")
    private java.lang.String projectID;
    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> securityGroups = new ArrayList<java.lang.String>();
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> tags = new ArrayList<java.lang.String>();
    @JsonProperty("tenantID")
    private java.lang.String tenantID;
    @JsonProperty("trunk")
    private Boolean trunk;
    @JsonProperty("vnicType")
    private java.lang.String vnicType;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PortOpts() {
    }

    public PortOpts(Boolean adminStateUp, List<AddressPair> allowedAddressPairs, java.lang.String description, List<FixedIPs> fixedIPs, java.lang.String hostID, java.lang.String macAddress, java.lang.String nameSuffix, java.lang.String networkID, Boolean portSecurity, Map<String, String> profile, java.lang.String projectID, List<java.lang.String> securityGroups, List<java.lang.String> tags, java.lang.String tenantID, Boolean trunk, java.lang.String vnicType) {
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

    @JsonProperty("adminStateUp")
    public Boolean getAdminStateUp() {
        return adminStateUp;
    }

    @JsonProperty("adminStateUp")
    public void setAdminStateUp(Boolean adminStateUp) {
        this.adminStateUp = adminStateUp;
    }

    @JsonProperty("allowedAddressPairs")
    public List<AddressPair> getAllowedAddressPairs() {
        return allowedAddressPairs;
    }

    @JsonProperty("allowedAddressPairs")
    public void setAllowedAddressPairs(List<AddressPair> allowedAddressPairs) {
        this.allowedAddressPairs = allowedAddressPairs;
    }

    @JsonProperty("description")
    public java.lang.String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    @JsonProperty("fixedIPs")
    public List<FixedIPs> getFixedIPs() {
        return fixedIPs;
    }

    @JsonProperty("fixedIPs")
    public void setFixedIPs(List<FixedIPs> fixedIPs) {
        this.fixedIPs = fixedIPs;
    }

    @JsonProperty("hostID")
    public java.lang.String getHostID() {
        return hostID;
    }

    @JsonProperty("hostID")
    public void setHostID(java.lang.String hostID) {
        this.hostID = hostID;
    }

    @JsonProperty("macAddress")
    public java.lang.String getMacAddress() {
        return macAddress;
    }

    @JsonProperty("macAddress")
    public void setMacAddress(java.lang.String macAddress) {
        this.macAddress = macAddress;
    }

    @JsonProperty("nameSuffix")
    public java.lang.String getNameSuffix() {
        return nameSuffix;
    }

    @JsonProperty("nameSuffix")
    public void setNameSuffix(java.lang.String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    @JsonProperty("networkID")
    public java.lang.String getNetworkID() {
        return networkID;
    }

    @JsonProperty("networkID")
    public void setNetworkID(java.lang.String networkID) {
        this.networkID = networkID;
    }

    @JsonProperty("portSecurity")
    public Boolean getPortSecurity() {
        return portSecurity;
    }

    @JsonProperty("portSecurity")
    public void setPortSecurity(Boolean portSecurity) {
        this.portSecurity = portSecurity;
    }

    @JsonProperty("profile")
    public Map<String, String> getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(Map<String, String> profile) {
        this.profile = profile;
    }

    @JsonProperty("projectID")
    public java.lang.String getProjectID() {
        return projectID;
    }

    @JsonProperty("projectID")
    public void setProjectID(java.lang.String projectID) {
        this.projectID = projectID;
    }

    @JsonProperty("securityGroups")
    public List<java.lang.String> getSecurityGroups() {
        return securityGroups;
    }

    @JsonProperty("securityGroups")
    public void setSecurityGroups(List<java.lang.String> securityGroups) {
        this.securityGroups = securityGroups;
    }

    @JsonProperty("tags")
    public List<java.lang.String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<java.lang.String> tags) {
        this.tags = tags;
    }

    @JsonProperty("tenantID")
    public java.lang.String getTenantID() {
        return tenantID;
    }

    @JsonProperty("tenantID")
    public void setTenantID(java.lang.String tenantID) {
        this.tenantID = tenantID;
    }

    @JsonProperty("trunk")
    public Boolean getTrunk() {
        return trunk;
    }

    @JsonProperty("trunk")
    public void setTrunk(Boolean trunk) {
        this.trunk = trunk;
    }

    @JsonProperty("vnicType")
    public java.lang.String getVnicType() {
        return vnicType;
    }

    @JsonProperty("vnicType")
    public void setVnicType(java.lang.String vnicType) {
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
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
