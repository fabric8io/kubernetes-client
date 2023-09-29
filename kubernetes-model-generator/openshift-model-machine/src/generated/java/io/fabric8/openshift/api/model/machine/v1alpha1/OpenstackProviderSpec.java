
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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
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
    "availabilityZone",
    "cloudName",
    "cloudsSecret",
    "configDrive",
    "flavor",
    "floatingIP",
    "image",
    "keyName",
    "networks",
    "ports",
    "primarySubnet",
    "rootVolume",
    "securityGroups",
    "serverGroupID",
    "serverGroupName",
    "serverMetadata",
    "sshUserName",
    "tags",
    "trunk",
    "userDataSecret"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1alpha1")
@Group("machine.openshift.io")
@Generated("jsonschema2pojo")
public class OpenstackProviderSpec implements Editable<OpenstackProviderSpecBuilder> , HasMetadata, Namespaced
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private java.lang.String apiVersion = "machine.openshift.io/v1alpha1";
    @JsonProperty("availabilityZone")
    private java.lang.String availabilityZone;
    @JsonProperty("cloudName")
    private java.lang.String cloudName;
    @JsonProperty("cloudsSecret")
    private SecretReference cloudsSecret;
    @JsonProperty("configDrive")
    private Boolean configDrive;
    @JsonProperty("flavor")
    private java.lang.String flavor;
    @JsonProperty("floatingIP")
    private java.lang.String floatingIP;
    @JsonProperty("image")
    private java.lang.String image;
    @JsonProperty("keyName")
    private java.lang.String keyName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private java.lang.String kind = "OpenstackProviderSpec";
    @JsonProperty("metadata")
    private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
    @JsonProperty("networks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkParam> networks = new ArrayList<NetworkParam>();
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PortOpts> ports = new ArrayList<PortOpts>();
    @JsonProperty("primarySubnet")
    private java.lang.String primarySubnet;
    @JsonProperty("rootVolume")
    private RootVolume rootVolume;
    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecurityGroupParam> securityGroups = new ArrayList<SecurityGroupParam>();
    @JsonProperty("serverGroupID")
    private java.lang.String serverGroupID;
    @JsonProperty("serverGroupName")
    private java.lang.String serverGroupName;
    @JsonProperty("serverMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> serverMetadata = new LinkedHashMap<String, String>();
    @JsonProperty("sshUserName")
    private java.lang.String sshUserName;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> tags = new ArrayList<java.lang.String>();
    @JsonProperty("trunk")
    private Boolean trunk;
    @JsonProperty("userDataSecret")
    private SecretReference userDataSecret;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenstackProviderSpec() {
    }

    public OpenstackProviderSpec(java.lang.String apiVersion, java.lang.String availabilityZone, java.lang.String cloudName, SecretReference cloudsSecret, Boolean configDrive, java.lang.String flavor, java.lang.String floatingIP, java.lang.String image, java.lang.String keyName, java.lang.String kind, io.fabric8.kubernetes.api.model.ObjectMeta metadata, List<NetworkParam> networks, List<PortOpts> ports, java.lang.String primarySubnet, RootVolume rootVolume, List<SecurityGroupParam> securityGroups, java.lang.String serverGroupID, java.lang.String serverGroupName, Map<String, String> serverMetadata, java.lang.String sshUserName, List<java.lang.String> tags, Boolean trunk, SecretReference userDataSecret) {
        super();
        this.apiVersion = apiVersion;
        this.availabilityZone = availabilityZone;
        this.cloudName = cloudName;
        this.cloudsSecret = cloudsSecret;
        this.configDrive = configDrive;
        this.flavor = flavor;
        this.floatingIP = floatingIP;
        this.image = image;
        this.keyName = keyName;
        this.kind = kind;
        this.metadata = metadata;
        this.networks = networks;
        this.ports = ports;
        this.primarySubnet = primarySubnet;
        this.rootVolume = rootVolume;
        this.securityGroups = securityGroups;
        this.serverGroupID = serverGroupID;
        this.serverGroupName = serverGroupName;
        this.serverMetadata = serverMetadata;
        this.sshUserName = sshUserName;
        this.tags = tags;
        this.trunk = trunk;
        this.userDataSecret = userDataSecret;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public java.lang.String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(java.lang.String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("availabilityZone")
    public java.lang.String getAvailabilityZone() {
        return availabilityZone;
    }

    @JsonProperty("availabilityZone")
    public void setAvailabilityZone(java.lang.String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    @JsonProperty("cloudName")
    public java.lang.String getCloudName() {
        return cloudName;
    }

    @JsonProperty("cloudName")
    public void setCloudName(java.lang.String cloudName) {
        this.cloudName = cloudName;
    }

    @JsonProperty("cloudsSecret")
    public SecretReference getCloudsSecret() {
        return cloudsSecret;
    }

    @JsonProperty("cloudsSecret")
    public void setCloudsSecret(SecretReference cloudsSecret) {
        this.cloudsSecret = cloudsSecret;
    }

    @JsonProperty("configDrive")
    public Boolean getConfigDrive() {
        return configDrive;
    }

    @JsonProperty("configDrive")
    public void setConfigDrive(Boolean configDrive) {
        this.configDrive = configDrive;
    }

    @JsonProperty("flavor")
    public java.lang.String getFlavor() {
        return flavor;
    }

    @JsonProperty("flavor")
    public void setFlavor(java.lang.String flavor) {
        this.flavor = flavor;
    }

    @JsonProperty("floatingIP")
    public java.lang.String getFloatingIP() {
        return floatingIP;
    }

    @JsonProperty("floatingIP")
    public void setFloatingIP(java.lang.String floatingIP) {
        this.floatingIP = floatingIP;
    }

    @JsonProperty("image")
    public java.lang.String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(java.lang.String image) {
        this.image = image;
    }

    @JsonProperty("keyName")
    public java.lang.String getKeyName() {
        return keyName;
    }

    @JsonProperty("keyName")
    public void setKeyName(java.lang.String keyName) {
        this.keyName = keyName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public java.lang.String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(java.lang.String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public io.fabric8.kubernetes.api.model.ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(io.fabric8.kubernetes.api.model.ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("networks")
    public List<NetworkParam> getNetworks() {
        return networks;
    }

    @JsonProperty("networks")
    public void setNetworks(List<NetworkParam> networks) {
        this.networks = networks;
    }

    @JsonProperty("ports")
    public List<PortOpts> getPorts() {
        return ports;
    }

    @JsonProperty("ports")
    public void setPorts(List<PortOpts> ports) {
        this.ports = ports;
    }

    @JsonProperty("primarySubnet")
    public java.lang.String getPrimarySubnet() {
        return primarySubnet;
    }

    @JsonProperty("primarySubnet")
    public void setPrimarySubnet(java.lang.String primarySubnet) {
        this.primarySubnet = primarySubnet;
    }

    @JsonProperty("rootVolume")
    public RootVolume getRootVolume() {
        return rootVolume;
    }

    @JsonProperty("rootVolume")
    public void setRootVolume(RootVolume rootVolume) {
        this.rootVolume = rootVolume;
    }

    @JsonProperty("securityGroups")
    public List<SecurityGroupParam> getSecurityGroups() {
        return securityGroups;
    }

    @JsonProperty("securityGroups")
    public void setSecurityGroups(List<SecurityGroupParam> securityGroups) {
        this.securityGroups = securityGroups;
    }

    @JsonProperty("serverGroupID")
    public java.lang.String getServerGroupID() {
        return serverGroupID;
    }

    @JsonProperty("serverGroupID")
    public void setServerGroupID(java.lang.String serverGroupID) {
        this.serverGroupID = serverGroupID;
    }

    @JsonProperty("serverGroupName")
    public java.lang.String getServerGroupName() {
        return serverGroupName;
    }

    @JsonProperty("serverGroupName")
    public void setServerGroupName(java.lang.String serverGroupName) {
        this.serverGroupName = serverGroupName;
    }

    @JsonProperty("serverMetadata")
    public Map<String, String> getServerMetadata() {
        return serverMetadata;
    }

    @JsonProperty("serverMetadata")
    public void setServerMetadata(Map<String, String> serverMetadata) {
        this.serverMetadata = serverMetadata;
    }

    @JsonProperty("sshUserName")
    public java.lang.String getSshUserName() {
        return sshUserName;
    }

    @JsonProperty("sshUserName")
    public void setSshUserName(java.lang.String sshUserName) {
        this.sshUserName = sshUserName;
    }

    @JsonProperty("tags")
    public List<java.lang.String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<java.lang.String> tags) {
        this.tags = tags;
    }

    @JsonProperty("trunk")
    public Boolean getTrunk() {
        return trunk;
    }

    @JsonProperty("trunk")
    public void setTrunk(Boolean trunk) {
        this.trunk = trunk;
    }

    @JsonProperty("userDataSecret")
    public SecretReference getUserDataSecret() {
        return userDataSecret;
    }

    @JsonProperty("userDataSecret")
    public void setUserDataSecret(SecretReference userDataSecret) {
        this.userDataSecret = userDataSecret;
    }

    @JsonIgnore
    public OpenstackProviderSpecBuilder edit() {
        return new OpenstackProviderSpecBuilder(this);
    }

    @JsonIgnore
    public OpenstackProviderSpecBuilder toBuilder() {
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
