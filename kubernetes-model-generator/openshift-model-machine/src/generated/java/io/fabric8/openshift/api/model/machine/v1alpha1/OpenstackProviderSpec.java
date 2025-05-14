
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
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
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
     * The subnet that a set of machines will get ingress/egress traffic from
     */
    @JsonProperty("primarySubnet")
    public String getPrimarySubnet() {
        return primarySubnet;
    }

    /**
     * The subnet that a set of machines will get ingress/egress traffic from
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
     * The machine ssh username
     */
    @JsonProperty("sshUserName")
    public String getSshUserName() {
        return sshUserName;
    }

    /**
     * The machine ssh username
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

}
