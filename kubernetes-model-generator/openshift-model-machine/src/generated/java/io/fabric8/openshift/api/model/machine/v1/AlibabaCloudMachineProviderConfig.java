
package io.fabric8.openshift.api.model.machine.v1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "bandwidth",
    "credentialsSecret",
    "dataDisk",
    "imageId",
    "instanceType",
    "ramRoleName",
    "regionId",
    "resourceGroup",
    "securityGroups",
    "systemDisk",
    "tag",
    "tenancy",
    "userDataSecret",
    "vSwitch",
    "vpcId",
    "zoneId"
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
@Version("v1")
@Group("machine.openshift.io")
@Generated("jsonschema2pojo")
public class AlibabaCloudMachineProviderConfig implements Editable<AlibabaCloudMachineProviderConfigBuilder> , HasMetadata, Namespaced
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "machine.openshift.io/v1";
    @JsonProperty("bandwidth")
    private BandwidthProperties bandwidth;
    @JsonProperty("credentialsSecret")
    private LocalObjectReference credentialsSecret;
    @JsonProperty("dataDisk")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DataDiskProperties> dataDisk = new ArrayList<>();
    @JsonProperty("imageId")
    private String imageId;
    @JsonProperty("instanceType")
    private String instanceType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "AlibabaCloudMachineProviderConfig";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("ramRoleName")
    private String ramRoleName;
    @JsonProperty("regionId")
    private String regionId;
    @JsonProperty("resourceGroup")
    private AlibabaResourceReference resourceGroup;
    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AlibabaResourceReference> securityGroups = new ArrayList<>();
    @JsonProperty("systemDisk")
    private SystemDiskProperties systemDisk;
    @JsonProperty("tag")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Tag> tag = new ArrayList<>();
    @JsonProperty("tenancy")
    private String tenancy;
    @JsonProperty("userDataSecret")
    private LocalObjectReference userDataSecret;
    @JsonProperty("vSwitch")
    private AlibabaResourceReference vSwitch;
    @JsonProperty("vpcId")
    private String vpcId;
    @JsonProperty("zoneId")
    private String zoneId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlibabaCloudMachineProviderConfig() {
    }

    public AlibabaCloudMachineProviderConfig(String apiVersion, BandwidthProperties bandwidth, LocalObjectReference credentialsSecret, List<DataDiskProperties> dataDisk, String imageId, String instanceType, String kind, ObjectMeta metadata, String ramRoleName, String regionId, AlibabaResourceReference resourceGroup, List<AlibabaResourceReference> securityGroups, SystemDiskProperties systemDisk, List<Tag> tag, String tenancy, LocalObjectReference userDataSecret, AlibabaResourceReference vSwitch, String vpcId, String zoneId) {
        super();
        this.apiVersion = apiVersion;
        this.bandwidth = bandwidth;
        this.credentialsSecret = credentialsSecret;
        this.dataDisk = dataDisk;
        this.imageId = imageId;
        this.instanceType = instanceType;
        this.kind = kind;
        this.metadata = metadata;
        this.ramRoleName = ramRoleName;
        this.regionId = regionId;
        this.resourceGroup = resourceGroup;
        this.securityGroups = securityGroups;
        this.systemDisk = systemDisk;
        this.tag = tag;
        this.tenancy = tenancy;
        this.userDataSecret = userDataSecret;
        this.vSwitch = vSwitch;
        this.vpcId = vpcId;
        this.zoneId = zoneId;
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

    @JsonProperty("bandwidth")
    public BandwidthProperties getBandwidth() {
        return bandwidth;
    }

    @JsonProperty("bandwidth")
    public void setBandwidth(BandwidthProperties bandwidth) {
        this.bandwidth = bandwidth;
    }

    @JsonProperty("credentialsSecret")
    public LocalObjectReference getCredentialsSecret() {
        return credentialsSecret;
    }

    @JsonProperty("credentialsSecret")
    public void setCredentialsSecret(LocalObjectReference credentialsSecret) {
        this.credentialsSecret = credentialsSecret;
    }

    @JsonProperty("dataDisk")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DataDiskProperties> getDataDisk() {
        return dataDisk;
    }

    @JsonProperty("dataDisk")
    public void setDataDisk(List<DataDiskProperties> dataDisk) {
        this.dataDisk = dataDisk;
    }

    @JsonProperty("imageId")
    public String getImageId() {
        return imageId;
    }

    @JsonProperty("imageId")
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @JsonProperty("instanceType")
    public String getInstanceType() {
        return instanceType;
    }

    @JsonProperty("instanceType")
    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
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

    @JsonProperty("ramRoleName")
    public String getRamRoleName() {
        return ramRoleName;
    }

    @JsonProperty("ramRoleName")
    public void setRamRoleName(String ramRoleName) {
        this.ramRoleName = ramRoleName;
    }

    @JsonProperty("regionId")
    public String getRegionId() {
        return regionId;
    }

    @JsonProperty("regionId")
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    @JsonProperty("resourceGroup")
    public AlibabaResourceReference getResourceGroup() {
        return resourceGroup;
    }

    @JsonProperty("resourceGroup")
    public void setResourceGroup(AlibabaResourceReference resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    @JsonProperty("securityGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AlibabaResourceReference> getSecurityGroups() {
        return securityGroups;
    }

    @JsonProperty("securityGroups")
    public void setSecurityGroups(List<AlibabaResourceReference> securityGroups) {
        this.securityGroups = securityGroups;
    }

    @JsonProperty("systemDisk")
    public SystemDiskProperties getSystemDisk() {
        return systemDisk;
    }

    @JsonProperty("systemDisk")
    public void setSystemDisk(SystemDiskProperties systemDisk) {
        this.systemDisk = systemDisk;
    }

    @JsonProperty("tag")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Tag> getTag() {
        return tag;
    }

    @JsonProperty("tag")
    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    @JsonProperty("tenancy")
    public String getTenancy() {
        return tenancy;
    }

    @JsonProperty("tenancy")
    public void setTenancy(String tenancy) {
        this.tenancy = tenancy;
    }

    @JsonProperty("userDataSecret")
    public LocalObjectReference getUserDataSecret() {
        return userDataSecret;
    }

    @JsonProperty("userDataSecret")
    public void setUserDataSecret(LocalObjectReference userDataSecret) {
        this.userDataSecret = userDataSecret;
    }

    @JsonProperty("vSwitch")
    public AlibabaResourceReference getVSwitch() {
        return vSwitch;
    }

    @JsonProperty("vSwitch")
    public void setVSwitch(AlibabaResourceReference vSwitch) {
        this.vSwitch = vSwitch;
    }

    @JsonProperty("vpcId")
    public String getVpcId() {
        return vpcId;
    }

    @JsonProperty("vpcId")
    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }

    @JsonProperty("zoneId")
    public String getZoneId() {
        return zoneId;
    }

    @JsonProperty("zoneId")
    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    @JsonIgnore
    public AlibabaCloudMachineProviderConfigBuilder edit() {
        return new AlibabaCloudMachineProviderConfigBuilder(this);
    }

    @JsonIgnore
    public AlibabaCloudMachineProviderConfigBuilder toBuilder() {
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
