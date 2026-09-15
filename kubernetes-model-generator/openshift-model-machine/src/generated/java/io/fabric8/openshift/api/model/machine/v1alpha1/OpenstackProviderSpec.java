
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
 * OpenstackProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an OpenStack Instance. It is used by the Openstack machine actuator to create a single machine instance. Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
 */
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
@Version("v1alpha1")
@Group("machine.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class OpenstackProviderSpec implements Editable<OpenstackProviderSpecBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("additionalBlockDevices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AdditionalBlockDevice> additionalBlockDevices = new ArrayList<>();
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

    /**
     * additionalBlockDevices is a list of specifications for additional block devices to attach to the server instance
     */
    @JsonProperty("additionalBlockDevices")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AdditionalBlockDevice> getAdditionalBlockDevices() {
        return additionalBlockDevices;
    }

    /**
     * additionalBlockDevices is a list of specifications for additional block devices to attach to the server instance
     */
    @JsonProperty("additionalBlockDevices")
    public void setAdditionalBlockDevices(List<AdditionalBlockDevice> additionalBlockDevices) {
        this.additionalBlockDevices = additionalBlockDevices;
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
     * The availability zone from which to launch the server.
     */
    @JsonProperty("availabilityZone")
    public String getAvailabilityZone() {
        return availabilityZone;
    }

    /**
     * The availability zone from which to launch the server.
     */
    @JsonProperty("availabilityZone")
    public void setAvailabilityZone(String availabilityZone) {
        this.availabilityZone = availabilityZone;
    }

    /**
     * The name of the cloud to use from the clouds secret
     */
    @JsonProperty("cloudName")
    public String getCloudName() {
        return cloudName;
    }

    /**
     * The name of the cloud to use from the clouds secret
     */
    @JsonProperty("cloudName")
    public void setCloudName(String cloudName) {
        this.cloudName = cloudName;
    }

    /**
     * OpenstackProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an OpenStack Instance. It is used by the Openstack machine actuator to create a single machine instance. Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("cloudsSecret")
    public SecretReference getCloudsSecret() {
        return cloudsSecret;
    }

    /**
     * OpenstackProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an OpenStack Instance. It is used by the Openstack machine actuator to create a single machine instance. Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("cloudsSecret")
    public void setCloudsSecret(SecretReference cloudsSecret) {
        this.cloudsSecret = cloudsSecret;
    }

    /**
     * Config Drive support
     */
    @JsonProperty("configDrive")
    public Boolean getConfigDrive() {
        return configDrive;
    }

    /**
     * Config Drive support
     */
    @JsonProperty("configDrive")
    public void setConfigDrive(Boolean configDrive) {
        this.configDrive = configDrive;
    }

    /**
     * The flavor reference for the flavor for your server instance.
     */
    @JsonProperty("flavor")
    public String getFlavor() {
        return flavor;
    }

    /**
     * The flavor reference for the flavor for your server instance.
     */
    @JsonProperty("flavor")
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * floatingIP specifies a floating IP to be associated with the machine. Note that it is not safe to use this parameter in a MachineSet, as only one Machine may be assigned the same floating IP.<br><p> <br><p> Deprecated: floatingIP will be removed in a future release as it cannot be implemented correctly.
     */
    @JsonProperty("floatingIP")
    public String getFloatingIP() {
        return floatingIP;
    }

    /**
     * floatingIP specifies a floating IP to be associated with the machine. Note that it is not safe to use this parameter in a MachineSet, as only one Machine may be assigned the same floating IP.<br><p> <br><p> Deprecated: floatingIP will be removed in a future release as it cannot be implemented correctly.
     */
    @JsonProperty("floatingIP")
    public void setFloatingIP(String floatingIP) {
        this.floatingIP = floatingIP;
    }

    /**
     * The name of the image to use for your server instance. If the RootVolume is specified, this will be ignored and use rootVolume directly.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * The name of the image to use for your server instance. If the RootVolume is specified, this will be ignored and use rootVolume directly.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * The ssh key to inject in the instance
     */
    @JsonProperty("keyName")
    public String getKeyName() {
        return keyName;
    }

    /**
     * The ssh key to inject in the instance
     */
    @JsonProperty("keyName")
    public void setKeyName(String keyName) {
        this.keyName = keyName;
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
     * OpenstackProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an OpenStack Instance. It is used by the Openstack machine actuator to create a single machine instance. Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * OpenstackProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an OpenStack Instance. It is used by the Openstack machine actuator to create a single machine instance. Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * A networks object. Required parameter when there are multiple networks defined for the tenant. When you do not specify the networks parameter, the server attaches to the only network created for the current tenant.
     */
    @JsonProperty("networks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkParam> getNetworks() {
        return networks;
    }

    /**
     * A networks object. Required parameter when there are multiple networks defined for the tenant. When you do not specify the networks parameter, the server attaches to the only network created for the current tenant.
     */
    @JsonProperty("networks")
    public void setNetworks(List<NetworkParam> networks) {
        this.networks = networks;
    }

    /**
     * Create and assign additional ports to instances
     */
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PortOpts> getPorts() {
        return ports;
    }

    /**
     * Create and assign additional ports to instances
     */
    @JsonProperty("ports")
    public void setPorts(List<PortOpts> ports) {
        this.ports = ports;
    }

    /**
     * The subnet that a set of machines will get ingress/egress traffic from Deprecated: primarySubnet is silently ignored. Use subnets instead.
     */
    @JsonProperty("primarySubnet")
    public String getPrimarySubnet() {
        return primarySubnet;
    }

    /**
     * The subnet that a set of machines will get ingress/egress traffic from Deprecated: primarySubnet is silently ignored. Use subnets instead.
     */
    @JsonProperty("primarySubnet")
    public void setPrimarySubnet(String primarySubnet) {
        this.primarySubnet = primarySubnet;
    }

    /**
     * OpenstackProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an OpenStack Instance. It is used by the Openstack machine actuator to create a single machine instance. Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("rootVolume")
    public RootVolume getRootVolume() {
        return rootVolume;
    }

    /**
     * OpenstackProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an OpenStack Instance. It is used by the Openstack machine actuator to create a single machine instance. Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("rootVolume")
    public void setRootVolume(RootVolume rootVolume) {
        this.rootVolume = rootVolume;
    }

    /**
     * The names of the security groups to assign to the instance
     */
    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SecurityGroupParam> getSecurityGroups() {
        return securityGroups;
    }

    /**
     * The names of the security groups to assign to the instance
     */
    @JsonProperty("securityGroups")
    public void setSecurityGroups(List<SecurityGroupParam> securityGroups) {
        this.securityGroups = securityGroups;
    }

    /**
     * The server group to assign the machine to.
     */
    @JsonProperty("serverGroupID")
    public String getServerGroupID() {
        return serverGroupID;
    }

    /**
     * The server group to assign the machine to.
     */
    @JsonProperty("serverGroupID")
    public void setServerGroupID(String serverGroupID) {
        this.serverGroupID = serverGroupID;
    }

    /**
     * The server group to assign the machine to. A server group with that name will be created if it does not exist. If both ServerGroupID and ServerGroupName are non-empty, they must refer to the same OpenStack resource.
     */
    @JsonProperty("serverGroupName")
    public String getServerGroupName() {
        return serverGroupName;
    }

    /**
     * The server group to assign the machine to. A server group with that name will be created if it does not exist. If both ServerGroupID and ServerGroupName are non-empty, they must refer to the same OpenStack resource.
     */
    @JsonProperty("serverGroupName")
    public void setServerGroupName(String serverGroupName) {
        this.serverGroupName = serverGroupName;
    }

    /**
     * Metadata mapping. Allows you to create a map of key value pairs to add to the server instance.
     */
    @JsonProperty("serverMetadata")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getServerMetadata() {
        return serverMetadata;
    }

    /**
     * Metadata mapping. Allows you to create a map of key value pairs to add to the server instance.
     */
    @JsonProperty("serverMetadata")
    public void setServerMetadata(Map<String, String> serverMetadata) {
        this.serverMetadata = serverMetadata;
    }

    /**
     * The machine ssh username Deprecated: sshUserName is silently ignored.
     */
    @JsonProperty("sshUserName")
    public String getSshUserName() {
        return sshUserName;
    }

    /**
     * The machine ssh username Deprecated: sshUserName is silently ignored.
     */
    @JsonProperty("sshUserName")
    public void setSshUserName(String sshUserName) {
        this.sshUserName = sshUserName;
    }

    /**
     * Machine tags Requires Nova api 2.52 minimum!
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTags() {
        return tags;
    }

    /**
     * Machine tags Requires Nova api 2.52 minimum!
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * Whether the server instance is created on a trunk port or not.
     */
    @JsonProperty("trunk")
    public Boolean getTrunk() {
        return trunk;
    }

    /**
     * Whether the server instance is created on a trunk port or not.
     */
    @JsonProperty("trunk")
    public void setTrunk(Boolean trunk) {
        this.trunk = trunk;
    }

    /**
     * OpenstackProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an OpenStack Instance. It is used by the Openstack machine actuator to create a single machine instance. Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
    @JsonProperty("userDataSecret")
    public SecretReference getUserDataSecret() {
        return userDataSecret;
    }

    /**
     * OpenstackProviderSpec is the type that will be embedded in a Machine.Spec.ProviderSpec field for an OpenStack Instance. It is used by the Openstack machine actuator to create a single machine instance. Compatibility level 4: No compatibility is provided, the API can change at any point for any reason. These capabilities should not be used by applications needing long term support.
     */
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
        if (!(o instanceof OpenstackProviderSpec)) {
            return false;
        }
        OpenstackProviderSpec other = (OpenstackProviderSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$additionalBlockDevices = this.getAdditionalBlockDevices();
        Object other$additionalBlockDevices = other.getAdditionalBlockDevices();
        if (this$additionalBlockDevices == null ? other$additionalBlockDevices != null : !this$additionalBlockDevices.equals(other$additionalBlockDevices)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$availabilityZone = this.getAvailabilityZone();
        Object other$availabilityZone = other.getAvailabilityZone();
        if (this$availabilityZone == null ? other$availabilityZone != null : !this$availabilityZone.equals(other$availabilityZone)) {
            return false;
        }
        Object this$cloudName = this.getCloudName();
        Object other$cloudName = other.getCloudName();
        if (this$cloudName == null ? other$cloudName != null : !this$cloudName.equals(other$cloudName)) {
            return false;
        }
        Object this$cloudsSecret = this.getCloudsSecret();
        Object other$cloudsSecret = other.getCloudsSecret();
        if (this$cloudsSecret == null ? other$cloudsSecret != null : !this$cloudsSecret.equals(other$cloudsSecret)) {
            return false;
        }
        Object this$configDrive = this.getConfigDrive();
        Object other$configDrive = other.getConfigDrive();
        if (this$configDrive == null ? other$configDrive != null : !this$configDrive.equals(other$configDrive)) {
            return false;
        }
        Object this$flavor = this.getFlavor();
        Object other$flavor = other.getFlavor();
        if (this$flavor == null ? other$flavor != null : !this$flavor.equals(other$flavor)) {
            return false;
        }
        Object this$floatingIP = this.getFloatingIP();
        Object other$floatingIP = other.getFloatingIP();
        if (this$floatingIP == null ? other$floatingIP != null : !this$floatingIP.equals(other$floatingIP)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$keyName = this.getKeyName();
        Object other$keyName = other.getKeyName();
        if (this$keyName == null ? other$keyName != null : !this$keyName.equals(other$keyName)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$networks = this.getNetworks();
        Object other$networks = other.getNetworks();
        if (this$networks == null ? other$networks != null : !this$networks.equals(other$networks)) {
            return false;
        }
        Object this$ports = this.getPorts();
        Object other$ports = other.getPorts();
        if (this$ports == null ? other$ports != null : !this$ports.equals(other$ports)) {
            return false;
        }
        Object this$primarySubnet = this.getPrimarySubnet();
        Object other$primarySubnet = other.getPrimarySubnet();
        if (this$primarySubnet == null ? other$primarySubnet != null : !this$primarySubnet.equals(other$primarySubnet)) {
            return false;
        }
        Object this$rootVolume = this.getRootVolume();
        Object other$rootVolume = other.getRootVolume();
        if (this$rootVolume == null ? other$rootVolume != null : !this$rootVolume.equals(other$rootVolume)) {
            return false;
        }
        Object this$securityGroups = this.getSecurityGroups();
        Object other$securityGroups = other.getSecurityGroups();
        if (this$securityGroups == null ? other$securityGroups != null : !this$securityGroups.equals(other$securityGroups)) {
            return false;
        }
        Object this$serverGroupID = this.getServerGroupID();
        Object other$serverGroupID = other.getServerGroupID();
        if (this$serverGroupID == null ? other$serverGroupID != null : !this$serverGroupID.equals(other$serverGroupID)) {
            return false;
        }
        Object this$serverGroupName = this.getServerGroupName();
        Object other$serverGroupName = other.getServerGroupName();
        if (this$serverGroupName == null ? other$serverGroupName != null : !this$serverGroupName.equals(other$serverGroupName)) {
            return false;
        }
        Object this$serverMetadata = this.getServerMetadata();
        Object other$serverMetadata = other.getServerMetadata();
        if (this$serverMetadata == null ? other$serverMetadata != null : !this$serverMetadata.equals(other$serverMetadata)) {
            return false;
        }
        Object this$sshUserName = this.getSshUserName();
        Object other$sshUserName = other.getSshUserName();
        if (this$sshUserName == null ? other$sshUserName != null : !this$sshUserName.equals(other$sshUserName)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
            return false;
        }
        Object this$trunk = this.getTrunk();
        Object other$trunk = other.getTrunk();
        if (this$trunk == null ? other$trunk != null : !this$trunk.equals(other$trunk)) {
            return false;
        }
        Object this$userDataSecret = this.getUserDataSecret();
        Object other$userDataSecret = other.getUserDataSecret();
        if (this$userDataSecret == null ? other$userDataSecret != null : !this$userDataSecret.equals(other$userDataSecret)) {
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
        return other instanceof OpenstackProviderSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $additionalBlockDevices = this.getAdditionalBlockDevices();
        result = result * prime + ($additionalBlockDevices == null ? 43 : $additionalBlockDevices.hashCode());
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $availabilityZone = this.getAvailabilityZone();
        result = result * prime + ($availabilityZone == null ? 43 : $availabilityZone.hashCode());
        Object $cloudName = this.getCloudName();
        result = result * prime + ($cloudName == null ? 43 : $cloudName.hashCode());
        Object $cloudsSecret = this.getCloudsSecret();
        result = result * prime + ($cloudsSecret == null ? 43 : $cloudsSecret.hashCode());
        Object $configDrive = this.getConfigDrive();
        result = result * prime + ($configDrive == null ? 43 : $configDrive.hashCode());
        Object $flavor = this.getFlavor();
        result = result * prime + ($flavor == null ? 43 : $flavor.hashCode());
        Object $floatingIP = this.getFloatingIP();
        result = result * prime + ($floatingIP == null ? 43 : $floatingIP.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $keyName = this.getKeyName();
        result = result * prime + ($keyName == null ? 43 : $keyName.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $networks = this.getNetworks();
        result = result * prime + ($networks == null ? 43 : $networks.hashCode());
        Object $ports = this.getPorts();
        result = result * prime + ($ports == null ? 43 : $ports.hashCode());
        Object $primarySubnet = this.getPrimarySubnet();
        result = result * prime + ($primarySubnet == null ? 43 : $primarySubnet.hashCode());
        Object $rootVolume = this.getRootVolume();
        result = result * prime + ($rootVolume == null ? 43 : $rootVolume.hashCode());
        Object $securityGroups = this.getSecurityGroups();
        result = result * prime + ($securityGroups == null ? 43 : $securityGroups.hashCode());
        Object $serverGroupID = this.getServerGroupID();
        result = result * prime + ($serverGroupID == null ? 43 : $serverGroupID.hashCode());
        Object $serverGroupName = this.getServerGroupName();
        result = result * prime + ($serverGroupName == null ? 43 : $serverGroupName.hashCode());
        Object $serverMetadata = this.getServerMetadata();
        result = result * prime + ($serverMetadata == null ? 43 : $serverMetadata.hashCode());
        Object $sshUserName = this.getSshUserName();
        result = result * prime + ($sshUserName == null ? 43 : $sshUserName.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $trunk = this.getTrunk();
        result = result * prime + ($trunk == null ? 43 : $trunk.hashCode());
        Object $userDataSecret = this.getUserDataSecret();
        result = result * prime + ($userDataSecret == null ? 43 : $userDataSecret.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OpenstackProviderSpec(" + "additionalBlockDevices=" + this.getAdditionalBlockDevices() + ", apiVersion=" + this.getApiVersion() + ", availabilityZone=" + this.getAvailabilityZone() + ", cloudName=" + this.getCloudName() + ", cloudsSecret=" + this.getCloudsSecret() + ", configDrive=" + this.getConfigDrive() + ", flavor=" + this.getFlavor() + ", floatingIP=" + this.getFloatingIP() + ", image=" + this.getImage() + ", keyName=" + this.getKeyName() + ", kind=" + this.getKind() + ", metadata=" + this.getMetadata() + ", networks=" + this.getNetworks() + ", ports=" + this.getPorts() + ", primarySubnet=" + this.getPrimarySubnet() + ", rootVolume=" + this.getRootVolume() + ", securityGroups=" + this.getSecurityGroups() + ", serverGroupID=" + this.getServerGroupID() + ", serverGroupName=" + this.getServerGroupName() + ", serverMetadata=" + this.getServerMetadata() + ", sshUserName=" + this.getSshUserName() + ", tags=" + this.getTags() + ", trunk=" + this.getTrunk() + ", userDataSecret=" + this.getUserDataSecret() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
