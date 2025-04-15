
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Taint;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * BareMetalHostSpec defines the desired state of BareMetalHost.
 */
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BareMetalHostSpec implements Editable<BareMetalHostSpecBuilder>, KubernetesResource
{

    @JsonProperty("architecture")
    private String architecture;
    @JsonProperty("automatedCleaningMode")
    private String automatedCleaningMode;
    @JsonProperty("bmc")
    private BMCDetails bmc;
    @JsonProperty("bootMACAddress")
    private String bootMACAddress;
    @JsonProperty("bootMode")
    private String bootMode;
    @JsonProperty("consumerRef")
    private ObjectReference consumerRef;
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
    private List<Taint> taints = new ArrayList<>();
    @JsonProperty("userData")
    private SecretReference userData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BareMetalHostSpec() {
    }

    public BareMetalHostSpec(String architecture, String automatedCleaningMode, BMCDetails bmc, String bootMACAddress, String bootMode, ObjectReference consumerRef, CustomDeploy customDeploy, String description, Boolean externallyProvisioned, FirmwareConfig firmware, String hardwareProfile, Image image, SecretReference metaData, SecretReference networkData, Boolean online, String preprovisioningNetworkDataName, RAIDConfig raid, RootDeviceHints rootDeviceHints, List<Taint> taints, SecretReference userData) {
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

    /**
     * CPU architecture of the host, e.g. "x86_64" or "aarch64". If unset, eventually populated by inspection.
     */
    @JsonProperty("architecture")
    public String getArchitecture() {
        return architecture;
    }

    /**
     * CPU architecture of the host, e.g. "x86_64" or "aarch64". If unset, eventually populated by inspection.
     */
    @JsonProperty("architecture")
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    /**
     * When set to disabled, automated cleaning will be skipped during provisioning and deprovisioning.
     */
    @JsonProperty("automatedCleaningMode")
    public String getAutomatedCleaningMode() {
        return automatedCleaningMode;
    }

    /**
     * When set to disabled, automated cleaning will be skipped during provisioning and deprovisioning.
     */
    @JsonProperty("automatedCleaningMode")
    public void setAutomatedCleaningMode(String automatedCleaningMode) {
        this.automatedCleaningMode = automatedCleaningMode;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("bmc")
    public BMCDetails getBmc() {
        return bmc;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("bmc")
    public void setBmc(BMCDetails bmc) {
        this.bmc = bmc;
    }

    /**
     * The MAC address of the NIC used for provisioning the host. In case of network boot, this is the MAC address of the PXE booting interface. The MAC address of the BMC must never be used here!
     */
    @JsonProperty("bootMACAddress")
    public String getBootMACAddress() {
        return bootMACAddress;
    }

    /**
     * The MAC address of the NIC used for provisioning the host. In case of network boot, this is the MAC address of the PXE booting interface. The MAC address of the BMC must never be used here!
     */
    @JsonProperty("bootMACAddress")
    public void setBootMACAddress(String bootMACAddress) {
        this.bootMACAddress = bootMACAddress;
    }

    /**
     * Select the method of initializing the hardware during boot. Defaults to UEFI. Legacy boot should only be used for hardware that does not support UEFI correctly. Set to UEFISecureBoot to turn secure boot on automatically after provisioning.
     */
    @JsonProperty("bootMode")
    public String getBootMode() {
        return bootMode;
    }

    /**
     * Select the method of initializing the hardware during boot. Defaults to UEFI. Legacy boot should only be used for hardware that does not support UEFI correctly. Set to UEFISecureBoot to turn secure boot on automatically after provisioning.
     */
    @JsonProperty("bootMode")
    public void setBootMode(String bootMode) {
        this.bootMode = bootMode;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("consumerRef")
    public ObjectReference getConsumerRef() {
        return consumerRef;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("consumerRef")
    public void setConsumerRef(ObjectReference consumerRef) {
        this.consumerRef = consumerRef;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("customDeploy")
    public CustomDeploy getCustomDeploy() {
        return customDeploy;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("customDeploy")
    public void setCustomDeploy(CustomDeploy customDeploy) {
        this.customDeploy = customDeploy;
    }

    /**
     * Description is a human-entered text used to help identify the host.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description is a human-entered text used to help identify the host.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * ExternallyProvisioned means something else has provisioned the image running on the host, and the operator should only manage the power status. This field is used for integration with already provisioned hosts and when pivoting hosts between clusters. If unsure, leave this field as false.
     */
    @JsonProperty("externallyProvisioned")
    public Boolean getExternallyProvisioned() {
        return externallyProvisioned;
    }

    /**
     * ExternallyProvisioned means something else has provisioned the image running on the host, and the operator should only manage the power status. This field is used for integration with already provisioned hosts and when pivoting hosts between clusters. If unsure, leave this field as false.
     */
    @JsonProperty("externallyProvisioned")
    public void setExternallyProvisioned(Boolean externallyProvisioned) {
        this.externallyProvisioned = externallyProvisioned;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("firmware")
    public FirmwareConfig getFirmware() {
        return firmware;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("firmware")
    public void setFirmware(FirmwareConfig firmware) {
        this.firmware = firmware;
    }

    /**
     * What is the name of the hardware profile for this host? Hardware profiles are deprecated and should not be used. Use the separate fields Architecture and RootDeviceHints instead. Set to "empty" to prepare for the future version of the API without hardware profiles.
     */
    @JsonProperty("hardwareProfile")
    public String getHardwareProfile() {
        return hardwareProfile;
    }

    /**
     * What is the name of the hardware profile for this host? Hardware profiles are deprecated and should not be used. Use the separate fields Architecture and RootDeviceHints instead. Set to "empty" to prepare for the future version of the API without hardware profiles.
     */
    @JsonProperty("hardwareProfile")
    public void setHardwareProfile(String hardwareProfile) {
        this.hardwareProfile = hardwareProfile;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("metaData")
    public SecretReference getMetaData() {
        return metaData;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("metaData")
    public void setMetaData(SecretReference metaData) {
        this.metaData = metaData;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("networkData")
    public SecretReference getNetworkData() {
        return networkData;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("networkData")
    public void setNetworkData(SecretReference networkData) {
        this.networkData = networkData;
    }

    /**
     * Should the host be powered on? If the host is currently in a stable state (e.g. provisioned), its power state will be forced to match this value.
     */
    @JsonProperty("online")
    public Boolean getOnline() {
        return online;
    }

    /**
     * Should the host be powered on? If the host is currently in a stable state (e.g. provisioned), its power state will be forced to match this value.
     */
    @JsonProperty("online")
    public void setOnline(Boolean online) {
        this.online = online;
    }

    /**
     * PreprovisioningNetworkDataName is the name of the Secret in the local namespace containing network configuration which is passed to the preprovisioning image, and to the Config Drive if not overridden by specifying NetworkData.
     */
    @JsonProperty("preprovisioningNetworkDataName")
    public String getPreprovisioningNetworkDataName() {
        return preprovisioningNetworkDataName;
    }

    /**
     * PreprovisioningNetworkDataName is the name of the Secret in the local namespace containing network configuration which is passed to the preprovisioning image, and to the Config Drive if not overridden by specifying NetworkData.
     */
    @JsonProperty("preprovisioningNetworkDataName")
    public void setPreprovisioningNetworkDataName(String preprovisioningNetworkDataName) {
        this.preprovisioningNetworkDataName = preprovisioningNetworkDataName;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("raid")
    public RAIDConfig getRaid() {
        return raid;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("raid")
    public void setRaid(RAIDConfig raid) {
        this.raid = raid;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("rootDeviceHints")
    public RootDeviceHints getRootDeviceHints() {
        return rootDeviceHints;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("rootDeviceHints")
    public void setRootDeviceHints(RootDeviceHints rootDeviceHints) {
        this.rootDeviceHints = rootDeviceHints;
    }

    /**
     * Taints is the full, authoritative list of taints to apply to the corresponding Machine. This list will overwrite any modifications made to the Machine on an ongoing basis.
     */
    @JsonProperty("taints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Taint> getTaints() {
        return taints;
    }

    /**
     * Taints is the full, authoritative list of taints to apply to the corresponding Machine. This list will overwrite any modifications made to the Machine on an ongoing basis.
     */
    @JsonProperty("taints")
    public void setTaints(List<Taint> taints) {
        this.taints = taints;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("userData")
    public SecretReference getUserData() {
        return userData;
    }

    /**
     * BareMetalHostSpec defines the desired state of BareMetalHost.
     */
    @JsonProperty("userData")
    public void setUserData(SecretReference userData) {
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
