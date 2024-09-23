
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
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "additionalBlockDevices",
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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1alpha1")
@Group("machine.openshift.io")
@Generated("jsonschema2pojo")
public class OpenstackProviderSpec implements Editable<OpenstackProviderSpecBuilder> , HasMetadata, Namespaced
{

    @JsonProperty("additionalBlockDevices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AdditionalBlockDevice> additionalBlockDevices = new ArrayList<>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "machine.openshift.io/v1alpha1";
    @JsonProperty("availabilityZone")
    private String availabilityZone;
    @JsonProperty("cloudName")
    private String cloudName;
    @JsonProperty("cloudsSecret")
    private SecretReference cloudsSecret;
    @JsonProperty("configDrive")
    private Boolean configDrive;
    @JsonProperty("flavor")
    private String flavor;
    @JsonProperty("floatingIP")
    private String floatingIP;
    @JsonProperty("image")
    private String image;
    @JsonProperty("keyName")
    private String keyName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "OpenstackProviderSpec";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("networks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkParam> networks = new ArrayList<>();
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PortOpts> ports = new ArrayList<>();
    @JsonProperty("primarySubnet")
    private String primarySubnet;
    @JsonProperty("rootVolume")
    private RootVolume rootVolume;
    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecurityGroupParam> securityGroups = new ArrayList<>();
    @JsonProperty("serverGroupID")
    private String serverGroupID;
    @JsonProperty("serverGroupName")
    private String serverGroupName;
    @JsonProperty("serverMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> serverMetadata = new LinkedHashMap<>();
    @JsonProperty("sshUserName")
    private String sshUserName;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> tags = new ArrayList<>();
    @JsonProperty("trunk")
    private Boolean trunk;
    @JsonProperty("userDataSecret")
    private SecretReference userDataSecret;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenstackProviderSpec() {
    }

    public OpenstackProviderSpec(List<AdditionalBlockDevice> additionalBlockDevices, String apiVersion, String availabilityZone, String cloudName, SecretReference cloudsSecret, Boolean configDrive, String flavor, String floatingIP, String image, String keyName, String kind, ObjectMeta metadata, List<NetworkParam> networks, List<PortOpts> ports, String primarySubnet, RootVolume rootVolume, List<SecurityGroupParam> securityGroups, String serverGroupID, String serverGroupName, Map<String, String> serverMetadata, String sshUserName, List<String> tags, Boolean trunk, SecretReference userDataSecret) {
        super();
        this.additionalBlockDevices = additionalBlockDevices;
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

    @JsonProperty("additionalBlockDevices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AdditionalBlockDevice> getAdditionalBlockDevices() {
        return additionalBlockDevices;
    }

    @JsonProperty("additionalBlockDevices")
    public void setAdditionalBlockDevices(List<AdditionalBlockDevice> additionalBlockDevices) {
        this.additionalBlockDevices = additionalBlockDevices;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("availabilityZone")
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    @JsonProperty("availabilityZone")
    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    @JsonProperty("cloudName")
    public String getCloudName() {
        return cloudName;
    }

    @JsonProperty("cloudName")
    public void setCloudName(String cloudName) {
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
    public String getFlavor() {
        return flavor;
    }

    @JsonProperty("flavor")
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @JsonProperty("floatingIP")
    public String getFloatingIP() {
        return floatingIP;
    }

    @JsonProperty("floatingIP")
    public void setFloatingIP(String floatingIP) {
        this.floatingIP = floatingIP;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("keyName")
    public String getKeyName() {
        return keyName;
    }

    @JsonProperty("keyName")
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("networks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkParam> getNetworks() {
        return networks;
    }

    @JsonProperty("networks")
    public void setNetworks(List<NetworkParam> networks) {
        this.networks = networks;
    }

    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PortOpts> getPorts() {
        return ports;
    }

    @JsonProperty("ports")
    public void setPorts(List<PortOpts> ports) {
        this.ports = ports;
    }

    @JsonProperty("primarySubnet")
    public String getPrimarySubnet() {
        return primarySubnet;
    }

    @JsonProperty("primarySubnet")
    public void setPrimarySubnet(String primarySubnet) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SecurityGroupParam> getSecurityGroups() {
        return securityGroups;
    }

    @JsonProperty("securityGroups")
    public void setSecurityGroups(List<SecurityGroupParam> securityGroups) {
        this.securityGroups = securityGroups;
    }

    @JsonProperty("serverGroupID")
    public String getServerGroupID() {
        return serverGroupID;
    }

    @JsonProperty("serverGroupID")
    public void setServerGroupID(String serverGroupID) {
        this.serverGroupID = serverGroupID;
    }

    @JsonProperty("serverGroupName")
    public String getServerGroupName() {
        return serverGroupName;
    }

    @JsonProperty("serverGroupName")
    public void setServerGroupName(String serverGroupName) {
        this.serverGroupName = serverGroupName;
    }

    @JsonProperty("serverMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getServerMetadata() {
        return serverMetadata;
    }

    @JsonProperty("serverMetadata")
    public void setServerMetadata(Map<String, String> serverMetadata) {
        this.serverMetadata = serverMetadata;
    }

    @JsonProperty("sshUserName")
    public String getSshUserName() {
        return sshUserName;
    }

    @JsonProperty("sshUserName")
    public void setSshUserName(String sshUserName) {
        this.sshUserName = sshUserName;
    }

    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
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
