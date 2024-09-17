
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "architecture",
    "automatedCleaningMode",
    "bmc",
    "bootMACAddress",
    "bootMode",
    "consumerRef",
    "customDeploy",
    "description",
    "externallyProvisioned",
    "firmware",
    "hardwareProfile",
    "image",
    "metaData",
    "networkData",
    "online",
    "preprovisioningNetworkDataName",
    "raid",
    "rootDeviceHints",
    "taints",
    "userData"
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
@Generated("jsonschema2pojo")
public class BareMetalHostSpec implements Editable<BareMetalHostSpecBuilder> , KubernetesResource
{

    @JsonProperty("architecture")
    private String architecture;
    @JsonProperty("automatedCleaningMode")
    private String automatedCleaningMode;
    @JsonProperty("bmc")
    private BareMetalHostSpecBmc bmc;
    @JsonProperty("bootMACAddress")
    private String bootMACAddress;
    @JsonProperty("bootMode")
    private String bootMode;
    @JsonProperty("consumerRef")
    private BareMetalHostSpecConsumerRef consumerRef;
    @JsonProperty("customDeploy")
    private BareMetalHostSpecCustomDeploy customDeploy;
    @JsonProperty("description")
    private String description;
    @JsonProperty("externallyProvisioned")
    private Boolean externallyProvisioned;
    @JsonProperty("firmware")
    private BareMetalHostSpecFirmware firmware;
    @JsonProperty("hardwareProfile")
    private String hardwareProfile;
    @JsonProperty("image")
    private BareMetalHostSpecImage image;
    @JsonProperty("metaData")
    private BareMetalHostSpecMetaData metaData;
    @JsonProperty("networkData")
    private BareMetalHostSpecNetworkData networkData;
    @JsonProperty("online")
    private Boolean online;
    @JsonProperty("preprovisioningNetworkDataName")
    private String preprovisioningNetworkDataName;
    @JsonProperty("raid")
    private BareMetalHostSpecRaid raid;
    @JsonProperty("rootDeviceHints")
    private BareMetalHostSpecRootDeviceHints rootDeviceHints;
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BareMetalHostSpecTaints> taints = new ArrayList<>();
    @JsonProperty("userData")
    private BareMetalHostSpecUserData userData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BareMetalHostSpec() {
    }

    public BareMetalHostSpec(String architecture, String automatedCleaningMode, BareMetalHostSpecBmc bmc, String bootMACAddress, String bootMode, BareMetalHostSpecConsumerRef consumerRef, BareMetalHostSpecCustomDeploy customDeploy, String description, Boolean externallyProvisioned, BareMetalHostSpecFirmware firmware, String hardwareProfile, BareMetalHostSpecImage image, BareMetalHostSpecMetaData metaData, BareMetalHostSpecNetworkData networkData, Boolean online, String preprovisioningNetworkDataName, BareMetalHostSpecRaid raid, BareMetalHostSpecRootDeviceHints rootDeviceHints, List<BareMetalHostSpecTaints> taints, BareMetalHostSpecUserData userData) {
        super();
        this.architecture = architecture;
        this.automatedCleaningMode = automatedCleaningMode;
        this.bmc = bmc;
        this.bootMACAddress = bootMACAddress;
        this.bootMode = bootMode;
        this.consumerRef = consumerRef;
        this.customDeploy = customDeploy;
        this.description = description;
        this.externallyProvisioned = externallyProvisioned;
        this.firmware = firmware;
        this.hardwareProfile = hardwareProfile;
        this.image = image;
        this.metaData = metaData;
        this.networkData = networkData;
        this.online = online;
        this.preprovisioningNetworkDataName = preprovisioningNetworkDataName;
        this.raid = raid;
        this.rootDeviceHints = rootDeviceHints;
        this.taints = taints;
        this.userData = userData;
    }

    @JsonProperty("architecture")
    public String getArchitecture() {
        return architecture;
    }

    @JsonProperty("architecture")
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    @JsonProperty("automatedCleaningMode")
    public String getAutomatedCleaningMode() {
        return automatedCleaningMode;
    }

    @JsonProperty("automatedCleaningMode")
    public void setAutomatedCleaningMode(String automatedCleaningMode) {
        this.automatedCleaningMode = automatedCleaningMode;
    }

    @JsonProperty("bmc")
    public BareMetalHostSpecBmc getBmc() {
        return bmc;
    }

    @JsonProperty("bmc")
    public void setBmc(BareMetalHostSpecBmc bmc) {
        this.bmc = bmc;
    }

    @JsonProperty("bootMACAddress")
    public String getBootMACAddress() {
        return bootMACAddress;
    }

    @JsonProperty("bootMACAddress")
    public void setBootMACAddress(String bootMACAddress) {
        this.bootMACAddress = bootMACAddress;
    }

    @JsonProperty("bootMode")
    public String getBootMode() {
        return bootMode;
    }

    @JsonProperty("bootMode")
    public void setBootMode(String bootMode) {
        this.bootMode = bootMode;
    }

    @JsonProperty("consumerRef")
    public BareMetalHostSpecConsumerRef getConsumerRef() {
        return consumerRef;
    }

    @JsonProperty("consumerRef")
    public void setConsumerRef(BareMetalHostSpecConsumerRef consumerRef) {
        this.consumerRef = consumerRef;
    }

    @JsonProperty("customDeploy")
    public BareMetalHostSpecCustomDeploy getCustomDeploy() {
        return customDeploy;
    }

    @JsonProperty("customDeploy")
    public void setCustomDeploy(BareMetalHostSpecCustomDeploy customDeploy) {
        this.customDeploy = customDeploy;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("externallyProvisioned")
    public Boolean getExternallyProvisioned() {
        return externallyProvisioned;
    }

    @JsonProperty("externallyProvisioned")
    public void setExternallyProvisioned(Boolean externallyProvisioned) {
        this.externallyProvisioned = externallyProvisioned;
    }

    @JsonProperty("firmware")
    public BareMetalHostSpecFirmware getFirmware() {
        return firmware;
    }

    @JsonProperty("firmware")
    public void setFirmware(BareMetalHostSpecFirmware firmware) {
        this.firmware = firmware;
    }

    @JsonProperty("hardwareProfile")
    public String getHardwareProfile() {
        return hardwareProfile;
    }

    @JsonProperty("hardwareProfile")
    public void setHardwareProfile(String hardwareProfile) {
        this.hardwareProfile = hardwareProfile;
    }

    @JsonProperty("image")
    public BareMetalHostSpecImage getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(BareMetalHostSpecImage image) {
        this.image = image;
    }

    @JsonProperty("metaData")
    public BareMetalHostSpecMetaData getMetaData() {
        return metaData;
    }

    @JsonProperty("metaData")
    public void setMetaData(BareMetalHostSpecMetaData metaData) {
        this.metaData = metaData;
    }

    @JsonProperty("networkData")
    public BareMetalHostSpecNetworkData getNetworkData() {
        return networkData;
    }

    @JsonProperty("networkData")
    public void setNetworkData(BareMetalHostSpecNetworkData networkData) {
        this.networkData = networkData;
    }

    @JsonProperty("online")
    public Boolean getOnline() {
        return online;
    }

    @JsonProperty("online")
    public void setOnline(Boolean online) {
        this.online = online;
    }

    @JsonProperty("preprovisioningNetworkDataName")
    public String getPreprovisioningNetworkDataName() {
        return preprovisioningNetworkDataName;
    }

    @JsonProperty("preprovisioningNetworkDataName")
    public void setPreprovisioningNetworkDataName(String preprovisioningNetworkDataName) {
        this.preprovisioningNetworkDataName = preprovisioningNetworkDataName;
    }

    @JsonProperty("raid")
    public BareMetalHostSpecRaid getRaid() {
        return raid;
    }

    @JsonProperty("raid")
    public void setRaid(BareMetalHostSpecRaid raid) {
        this.raid = raid;
    }

    @JsonProperty("rootDeviceHints")
    public BareMetalHostSpecRootDeviceHints getRootDeviceHints() {
        return rootDeviceHints;
    }

    @JsonProperty("rootDeviceHints")
    public void setRootDeviceHints(BareMetalHostSpecRootDeviceHints rootDeviceHints) {
        this.rootDeviceHints = rootDeviceHints;
    }

    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<BareMetalHostSpecTaints> getTaints() {
        return taints;
    }

    @JsonProperty("taints")
    public void setTaints(List<BareMetalHostSpecTaints> taints) {
        this.taints = taints;
    }

    @JsonProperty("userData")
    public BareMetalHostSpecUserData getUserData() {
        return userData;
    }

    @JsonProperty("userData")
    public void setUserData(BareMetalHostSpecUserData userData) {
        this.userData = userData;
    }

    @JsonIgnore
    public BareMetalHostSpecBuilder edit() {
        return new BareMetalHostSpecBuilder(this);
    }

    @JsonIgnore
    public BareMetalHostSpecBuilder toBuilder() {
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
