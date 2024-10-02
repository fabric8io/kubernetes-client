
package io.fabric8.openshift.api.model.machine.v1beta1;

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
@Version("v1beta1")
@Group("machine.openshift.io")
@Generated("jsonschema2pojo")
public class AzureMachineProviderSpec implements Editable<AzureMachineProviderSpecBuilder> , HasMetadata, Namespaced
{

    @JsonProperty("acceleratedNetworking")
    private Boolean acceleratedNetworking;
    /**
     * 
     * (Required)
     * 
     */
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
    /**
     * 
     * (Required)
     * 
     */
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
     * 
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

    @JsonProperty("acceleratedNetworking")
    public Boolean getAcceleratedNetworking() {
        return acceleratedNetworking;
    }

    @JsonProperty("acceleratedNetworking")
    public void setAcceleratedNetworking(Boolean acceleratedNetworking) {
        this.acceleratedNetworking = acceleratedNetworking;
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

    @JsonProperty("applicationSecurityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApplicationSecurityGroups() {
        return applicationSecurityGroups;
    }

    @JsonProperty("applicationSecurityGroups")
    public void setApplicationSecurityGroups(List<String> applicationSecurityGroups) {
        this.applicationSecurityGroups = applicationSecurityGroups;
    }

    @JsonProperty("availabilitySet")
    public String getAvailabilitySet() {
        return availabilitySet;
    }

    @JsonProperty("availabilitySet")
    public void setAvailabilitySet(String availabilitySet) {
        this.availabilitySet = availabilitySet;
    }

    @JsonProperty("capacityReservationGroupID")
    public String getCapacityReservationGroupID() {
        return capacityReservationGroupID;
    }

    @JsonProperty("capacityReservationGroupID")
    public void setCapacityReservationGroupID(String capacityReservationGroupID) {
        this.capacityReservationGroupID = capacityReservationGroupID;
    }

    @JsonProperty("credentialsSecret")
    public SecretReference getCredentialsSecret() {
        return credentialsSecret;
    }

    @JsonProperty("credentialsSecret")
    public void setCredentialsSecret(SecretReference credentialsSecret) {
        this.credentialsSecret = credentialsSecret;
    }

    @JsonProperty("dataDisks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DataDisk> getDataDisks() {
        return dataDisks;
    }

    @JsonProperty("dataDisks")
    public void setDataDisks(List<DataDisk> dataDisks) {
        this.dataDisks = dataDisks;
    }

    @JsonProperty("diagnostics")
    public AzureDiagnostics getDiagnostics() {
        return diagnostics;
    }

    @JsonProperty("diagnostics")
    public void setDiagnostics(AzureDiagnostics diagnostics) {
        this.diagnostics = diagnostics;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    @JsonProperty("internalLoadBalancer")
    public String getInternalLoadBalancer() {
        return internalLoadBalancer;
    }

    @JsonProperty("internalLoadBalancer")
    public void setInternalLoadBalancer(String internalLoadBalancer) {
        this.internalLoadBalancer = internalLoadBalancer;
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

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("managedIdentity")
    public String getManagedIdentity() {
        return managedIdentity;
    }

    @JsonProperty("managedIdentity")
    public void setManagedIdentity(String managedIdentity) {
        this.managedIdentity = managedIdentity;
    }

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("natRule")
    public Long getNatRule() {
        return natRule;
    }

    @JsonProperty("natRule")
    public void setNatRule(Long natRule) {
        this.natRule = natRule;
    }

    @JsonProperty("networkResourceGroup")
    public String getNetworkResourceGroup() {
        return networkResourceGroup;
    }

    @JsonProperty("networkResourceGroup")
    public void setNetworkResourceGroup(String networkResourceGroup) {
        this.networkResourceGroup = networkResourceGroup;
    }

    @JsonProperty("osDisk")
    public OSDisk getOsDisk() {
        return osDisk;
    }

    @JsonProperty("osDisk")
    public void setOsDisk(OSDisk osDisk) {
        this.osDisk = osDisk;
    }

    @JsonProperty("publicIP")
    public Boolean getPublicIP() {
        return publicIP;
    }

    @JsonProperty("publicIP")
    public void setPublicIP(Boolean publicIP) {
        this.publicIP = publicIP;
    }

    @JsonProperty("publicLoadBalancer")
    public String getPublicLoadBalancer() {
        return publicLoadBalancer;
    }

    @JsonProperty("publicLoadBalancer")
    public void setPublicLoadBalancer(String publicLoadBalancer) {
        this.publicLoadBalancer = publicLoadBalancer;
    }

    @JsonProperty("resourceGroup")
    public String getResourceGroup() {
        return resourceGroup;
    }

    @JsonProperty("resourceGroup")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    @JsonProperty("securityGroup")
    public String getSecurityGroup() {
        return securityGroup;
    }

    @JsonProperty("securityGroup")
    public void setSecurityGroup(String securityGroup) {
        this.securityGroup = securityGroup;
    }

    @JsonProperty("securityProfile")
    public SecurityProfile getSecurityProfile() {
        return securityProfile;
    }

    @JsonProperty("securityProfile")
    public void setSecurityProfile(SecurityProfile securityProfile) {
        this.securityProfile = securityProfile;
    }

    @JsonProperty("spotVMOptions")
    public SpotVMOptions getSpotVMOptions() {
        return spotVMOptions;
    }

    @JsonProperty("spotVMOptions")
    public void setSpotVMOptions(SpotVMOptions spotVMOptions) {
        this.spotVMOptions = spotVMOptions;
    }

    @JsonProperty("sshPublicKey")
    public String getSshPublicKey() {
        return sshPublicKey;
    }

    @JsonProperty("sshPublicKey")
    public void setSshPublicKey(String sshPublicKey) {
        this.sshPublicKey = sshPublicKey;
    }

    @JsonProperty("subnet")
    public String getSubnet() {
        return subnet;
    }

    @JsonProperty("subnet")
    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    @JsonProperty("ultraSSDCapability")
    public String getUltraSSDCapability() {
        return ultraSSDCapability;
    }

    @JsonProperty("ultraSSDCapability")
    public void setUltraSSDCapability(String ultraSSDCapability) {
        this.ultraSSDCapability = ultraSSDCapability;
    }

    @JsonProperty("userDataSecret")
    public SecretReference getUserDataSecret() {
        return userDataSecret;
    }

    @JsonProperty("userDataSecret")
    public void setUserDataSecret(SecretReference userDataSecret) {
        this.userDataSecret = userDataSecret;
    }

    @JsonProperty("vmSize")
    public String getVmSize() {
        return vmSize;
    }

    @JsonProperty("vmSize")
    public void setVmSize(String vmSize) {
        this.vmSize = vmSize;
    }

    @JsonProperty("vnet")
    public String getVnet() {
        return vnet;
    }

    @JsonProperty("vnet")
    public void setVnet(String vnet) {
        this.vnet = vnet;
    }

    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

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
