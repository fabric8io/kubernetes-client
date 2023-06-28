
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Taint;
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class BareMetalHostSpec implements KubernetesResource
{

    @JsonProperty("automatedCleaningMode")
    private String automatedCleaningMode;
    @JsonProperty("bmc")
    private BMCDetails bmc;
    @JsonProperty("bootMACAddress")
    private String bootMACAddress;
    @JsonProperty("bootMode")
    private String bootMode;
    @JsonProperty("consumerRef")
    private io.fabric8.kubernetes.api.model.ObjectReference consumerRef;
    @JsonProperty("customDeploy")
    private CustomDeploy customDeploy;
    @JsonProperty("description")
    private String description;
    @JsonProperty("externallyProvisioned")
    private Boolean externallyProvisioned;
    @JsonProperty("firmware")
    private FirmwareConfig firmware;
    @JsonProperty("hardwareProfile")
    private String hardwareProfile;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("metaData")
    private SecretReference metaData;
    @JsonProperty("networkData")
    private SecretReference networkData;
    @JsonProperty("online")
    private Boolean online;
    @JsonProperty("preprovisioningNetworkDataName")
    private String preprovisioningNetworkDataName;
    @JsonProperty("raid")
    private RAIDConfig raid;
    @JsonProperty("rootDeviceHints")
    private RootDeviceHints rootDeviceHints;
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Taint> taints = new ArrayList<Taint>();
    @JsonProperty("userData")
    private SecretReference userData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BareMetalHostSpec() {
    }

    public BareMetalHostSpec(String automatedCleaningMode, BMCDetails bmc, String bootMACAddress, String bootMode, io.fabric8.kubernetes.api.model.ObjectReference consumerRef, CustomDeploy customDeploy, String description, Boolean externallyProvisioned, FirmwareConfig firmware, String hardwareProfile, Image image, SecretReference metaData, SecretReference networkData, Boolean online, String preprovisioningNetworkDataName, RAIDConfig raid, RootDeviceHints rootDeviceHints, List<Taint> taints, SecretReference userData) {
        super();
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

    @JsonProperty("automatedCleaningMode")
    public String getAutomatedCleaningMode() {
        return automatedCleaningMode;
    }

    @JsonProperty("automatedCleaningMode")
    public void setAutomatedCleaningMode(String automatedCleaningMode) {
        this.automatedCleaningMode = automatedCleaningMode;
    }

    @JsonProperty("bmc")
    public BMCDetails getBmc() {
        return bmc;
    }

    @JsonProperty("bmc")
    public void setBmc(BMCDetails bmc) {
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
    public io.fabric8.kubernetes.api.model.ObjectReference getConsumerRef() {
        return consumerRef;
    }

    @JsonProperty("consumerRef")
    public void setConsumerRef(io.fabric8.kubernetes.api.model.ObjectReference consumerRef) {
        this.consumerRef = consumerRef;
    }

    @JsonProperty("customDeploy")
    public CustomDeploy getCustomDeploy() {
        return customDeploy;
    }

    @JsonProperty("customDeploy")
    public void setCustomDeploy(CustomDeploy customDeploy) {
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
    public FirmwareConfig getFirmware() {
        return firmware;
    }

    @JsonProperty("firmware")
    public void setFirmware(FirmwareConfig firmware) {
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
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    @JsonProperty("metaData")
    public SecretReference getMetaData() {
        return metaData;
    }

    @JsonProperty("metaData")
    public void setMetaData(SecretReference metaData) {
        this.metaData = metaData;
    }

    @JsonProperty("networkData")
    public SecretReference getNetworkData() {
        return networkData;
    }

    @JsonProperty("networkData")
    public void setNetworkData(SecretReference networkData) {
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
    public RAIDConfig getRaid() {
        return raid;
    }

    @JsonProperty("raid")
    public void setRaid(RAIDConfig raid) {
        this.raid = raid;
    }

    @JsonProperty("rootDeviceHints")
    public RootDeviceHints getRootDeviceHints() {
        return rootDeviceHints;
    }

    @JsonProperty("rootDeviceHints")
    public void setRootDeviceHints(RootDeviceHints rootDeviceHints) {
        this.rootDeviceHints = rootDeviceHints;
    }

    @JsonProperty("taints")
    public List<Taint> getTaints() {
        return taints;
    }

    @JsonProperty("taints")
    public void setTaints(List<Taint> taints) {
        this.taints = taints;
    }

    @JsonProperty("userData")
    public SecretReference getUserData() {
        return userData;
    }

    @JsonProperty("userData")
    public void setUserData(SecretReference userData) {
        this.userData = userData;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
