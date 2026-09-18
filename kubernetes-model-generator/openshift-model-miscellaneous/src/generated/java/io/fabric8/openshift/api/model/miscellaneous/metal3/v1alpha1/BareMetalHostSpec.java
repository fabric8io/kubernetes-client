
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
    "disablePowerOff",
    "externallyProvisioned",
    "firmware",
    "hardwareProfile",
    "image",
    "inspectionMode",
    "metaData",
    "networkData",
    "online",
    "preprovisioningNetworkDataName",
    "raid",
    "rootDeviceHints",
    "taints",
    "userData"
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
    @JsonProperty("disablePowerOff")
    private Boolean disablePowerOff;
    @JsonProperty("externallyProvisioned")
    private Boolean externallyProvisioned;
    @JsonProperty("firmware")
    private FirmwareConfig firmware;
    @JsonProperty("hardwareProfile")
    private String hardwareProfile;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("inspectionMode")
    private String inspectionMode;
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

    public BareMetalHostSpec(String architecture, String automatedCleaningMode, BMCDetails bmc, String bootMACAddress, String bootMode, ObjectReference consumerRef, CustomDeploy customDeploy, String description, Boolean disablePowerOff, Boolean externallyProvisioned, FirmwareConfig firmware, String hardwareProfile, Image image, String inspectionMode, SecretReference metaData, SecretReference networkData, Boolean online, String preprovisioningNetworkDataName, RAIDConfig raid, RootDeviceHints rootDeviceHints, List<Taint> taints, SecretReference userData) {
        super();
        this.architecture = architecture;
        this.automatedCleaningMode = automatedCleaningMode;
        this.bmc = bmc;
        this.bootMACAddress = bootMACAddress;
        this.bootMode = bootMode;
        this.consumerRef = consumerRef;
        this.customDeploy = customDeploy;
        this.description = description;
        this.disablePowerOff = disablePowerOff;
        this.externallyProvisioned = externallyProvisioned;
        this.firmware = firmware;
        this.hardwareProfile = hardwareProfile;
        this.image = image;
        this.inspectionMode = inspectionMode;
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
     * When set to true, power off of the node will be disabled, instead, a reboot will be used in place of power on/off
     */
    @JsonProperty("disablePowerOff")
    public Boolean getDisablePowerOff() {
        return disablePowerOff;
    }

    /**
     * When set to true, power off of the node will be disabled, instead, a reboot will be used in place of power on/off
     */
    @JsonProperty("disablePowerOff")
    public void setDisablePowerOff(Boolean disablePowerOff) {
        this.disablePowerOff = disablePowerOff;
    }

    /**
     * ExternallyProvisioned means something else has provisioned the image running on the host, and the operator should only manage the power status. This field is used for integration with already provisioned hosts and when pivoting hosts between clusters.<br><p> <br><p> This field can be set to true either: 1. During initial host creation (e.g., for pre-provisioned hosts) 2. After inspection completes when the host reaches Available state<br><p> <br><p> When used in environments with Cluster API Provider Metal3 (CAPM3), ensure hosts are labeled appropriately so CAPM3's host selector can distinguish them from CAPM3-managed hosts. If unsure, leave this field as false.
     */
    @JsonProperty("externallyProvisioned")
    public Boolean getExternallyProvisioned() {
        return externallyProvisioned;
    }

    /**
     * ExternallyProvisioned means something else has provisioned the image running on the host, and the operator should only manage the power status. This field is used for integration with already provisioned hosts and when pivoting hosts between clusters.<br><p> <br><p> This field can be set to true either: 1. During initial host creation (e.g., for pre-provisioned hosts) 2. After inspection completes when the host reaches Available state<br><p> <br><p> When used in environments with Cluster API Provider Metal3 (CAPM3), ensure hosts are labeled appropriately so CAPM3's host selector can distinguish them from CAPM3-managed hosts. If unsure, leave this field as false.
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
     * Specifies the mode for host inspection. "disabled" - no inspection will be performed "agent" - normal agent-based inspection will run
     */
    @JsonProperty("inspectionMode")
    public String getInspectionMode() {
        return inspectionMode;
    }

    /**
     * Specifies the mode for host inspection. "disabled" - no inspection will be performed "agent" - normal agent-based inspection will run
     */
    @JsonProperty("inspectionMode")
    public void setInspectionMode(String inspectionMode) {
        this.inspectionMode = inspectionMode;
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
        if (!(o instanceof BareMetalHostSpec)) {
            return false;
        }
        BareMetalHostSpec other = (BareMetalHostSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$architecture = this.getArchitecture();
        Object other$architecture = other.getArchitecture();
        if (this$architecture == null ? other$architecture != null : !this$architecture.equals(other$architecture)) {
            return false;
        }
        Object this$automatedCleaningMode = this.getAutomatedCleaningMode();
        Object other$automatedCleaningMode = other.getAutomatedCleaningMode();
        if (this$automatedCleaningMode == null ? other$automatedCleaningMode != null : !this$automatedCleaningMode.equals(other$automatedCleaningMode)) {
            return false;
        }
        Object this$bmc = this.getBmc();
        Object other$bmc = other.getBmc();
        if (this$bmc == null ? other$bmc != null : !this$bmc.equals(other$bmc)) {
            return false;
        }
        Object this$bootMACAddress = this.getBootMACAddress();
        Object other$bootMACAddress = other.getBootMACAddress();
        if (this$bootMACAddress == null ? other$bootMACAddress != null : !this$bootMACAddress.equals(other$bootMACAddress)) {
            return false;
        }
        Object this$bootMode = this.getBootMode();
        Object other$bootMode = other.getBootMode();
        if (this$bootMode == null ? other$bootMode != null : !this$bootMode.equals(other$bootMode)) {
            return false;
        }
        Object this$consumerRef = this.getConsumerRef();
        Object other$consumerRef = other.getConsumerRef();
        if (this$consumerRef == null ? other$consumerRef != null : !this$consumerRef.equals(other$consumerRef)) {
            return false;
        }
        Object this$customDeploy = this.getCustomDeploy();
        Object other$customDeploy = other.getCustomDeploy();
        if (this$customDeploy == null ? other$customDeploy != null : !this$customDeploy.equals(other$customDeploy)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$disablePowerOff = this.getDisablePowerOff();
        Object other$disablePowerOff = other.getDisablePowerOff();
        if (this$disablePowerOff == null ? other$disablePowerOff != null : !this$disablePowerOff.equals(other$disablePowerOff)) {
            return false;
        }
        Object this$externallyProvisioned = this.getExternallyProvisioned();
        Object other$externallyProvisioned = other.getExternallyProvisioned();
        if (this$externallyProvisioned == null ? other$externallyProvisioned != null : !this$externallyProvisioned.equals(other$externallyProvisioned)) {
            return false;
        }
        Object this$firmware = this.getFirmware();
        Object other$firmware = other.getFirmware();
        if (this$firmware == null ? other$firmware != null : !this$firmware.equals(other$firmware)) {
            return false;
        }
        Object this$hardwareProfile = this.getHardwareProfile();
        Object other$hardwareProfile = other.getHardwareProfile();
        if (this$hardwareProfile == null ? other$hardwareProfile != null : !this$hardwareProfile.equals(other$hardwareProfile)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$inspectionMode = this.getInspectionMode();
        Object other$inspectionMode = other.getInspectionMode();
        if (this$inspectionMode == null ? other$inspectionMode != null : !this$inspectionMode.equals(other$inspectionMode)) {
            return false;
        }
        Object this$metaData = this.getMetaData();
        Object other$metaData = other.getMetaData();
        if (this$metaData == null ? other$metaData != null : !this$metaData.equals(other$metaData)) {
            return false;
        }
        Object this$networkData = this.getNetworkData();
        Object other$networkData = other.getNetworkData();
        if (this$networkData == null ? other$networkData != null : !this$networkData.equals(other$networkData)) {
            return false;
        }
        Object this$online = this.getOnline();
        Object other$online = other.getOnline();
        if (this$online == null ? other$online != null : !this$online.equals(other$online)) {
            return false;
        }
        Object this$preprovisioningNetworkDataName = this.getPreprovisioningNetworkDataName();
        Object other$preprovisioningNetworkDataName = other.getPreprovisioningNetworkDataName();
        if (this$preprovisioningNetworkDataName == null ? other$preprovisioningNetworkDataName != null : !this$preprovisioningNetworkDataName.equals(other$preprovisioningNetworkDataName)) {
            return false;
        }
        Object this$raid = this.getRaid();
        Object other$raid = other.getRaid();
        if (this$raid == null ? other$raid != null : !this$raid.equals(other$raid)) {
            return false;
        }
        Object this$rootDeviceHints = this.getRootDeviceHints();
        Object other$rootDeviceHints = other.getRootDeviceHints();
        if (this$rootDeviceHints == null ? other$rootDeviceHints != null : !this$rootDeviceHints.equals(other$rootDeviceHints)) {
            return false;
        }
        Object this$taints = this.getTaints();
        Object other$taints = other.getTaints();
        if (this$taints == null ? other$taints != null : !this$taints.equals(other$taints)) {
            return false;
        }
        Object this$userData = this.getUserData();
        Object other$userData = other.getUserData();
        if (this$userData == null ? other$userData != null : !this$userData.equals(other$userData)) {
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
        return other instanceof BareMetalHostSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $architecture = this.getArchitecture();
        result = result * prime + ($architecture == null ? 43 : $architecture.hashCode());
        Object $automatedCleaningMode = this.getAutomatedCleaningMode();
        result = result * prime + ($automatedCleaningMode == null ? 43 : $automatedCleaningMode.hashCode());
        Object $bmc = this.getBmc();
        result = result * prime + ($bmc == null ? 43 : $bmc.hashCode());
        Object $bootMACAddress = this.getBootMACAddress();
        result = result * prime + ($bootMACAddress == null ? 43 : $bootMACAddress.hashCode());
        Object $bootMode = this.getBootMode();
        result = result * prime + ($bootMode == null ? 43 : $bootMode.hashCode());
        Object $consumerRef = this.getConsumerRef();
        result = result * prime + ($consumerRef == null ? 43 : $consumerRef.hashCode());
        Object $customDeploy = this.getCustomDeploy();
        result = result * prime + ($customDeploy == null ? 43 : $customDeploy.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $disablePowerOff = this.getDisablePowerOff();
        result = result * prime + ($disablePowerOff == null ? 43 : $disablePowerOff.hashCode());
        Object $externallyProvisioned = this.getExternallyProvisioned();
        result = result * prime + ($externallyProvisioned == null ? 43 : $externallyProvisioned.hashCode());
        Object $firmware = this.getFirmware();
        result = result * prime + ($firmware == null ? 43 : $firmware.hashCode());
        Object $hardwareProfile = this.getHardwareProfile();
        result = result * prime + ($hardwareProfile == null ? 43 : $hardwareProfile.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $inspectionMode = this.getInspectionMode();
        result = result * prime + ($inspectionMode == null ? 43 : $inspectionMode.hashCode());
        Object $metaData = this.getMetaData();
        result = result * prime + ($metaData == null ? 43 : $metaData.hashCode());
        Object $networkData = this.getNetworkData();
        result = result * prime + ($networkData == null ? 43 : $networkData.hashCode());
        Object $online = this.getOnline();
        result = result * prime + ($online == null ? 43 : $online.hashCode());
        Object $preprovisioningNetworkDataName = this.getPreprovisioningNetworkDataName();
        result = result * prime + ($preprovisioningNetworkDataName == null ? 43 : $preprovisioningNetworkDataName.hashCode());
        Object $raid = this.getRaid();
        result = result * prime + ($raid == null ? 43 : $raid.hashCode());
        Object $rootDeviceHints = this.getRootDeviceHints();
        result = result * prime + ($rootDeviceHints == null ? 43 : $rootDeviceHints.hashCode());
        Object $taints = this.getTaints();
        result = result * prime + ($taints == null ? 43 : $taints.hashCode());
        Object $userData = this.getUserData();
        result = result * prime + ($userData == null ? 43 : $userData.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BareMetalHostSpec(" + "architecture=" + this.getArchitecture() + ", automatedCleaningMode=" + this.getAutomatedCleaningMode() + ", bmc=" + this.getBmc() + ", bootMACAddress=" + this.getBootMACAddress() + ", bootMode=" + this.getBootMode() + ", consumerRef=" + this.getConsumerRef() + ", customDeploy=" + this.getCustomDeploy() + ", description=" + this.getDescription() + ", disablePowerOff=" + this.getDisablePowerOff() + ", externallyProvisioned=" + this.getExternallyProvisioned() + ", firmware=" + this.getFirmware() + ", hardwareProfile=" + this.getHardwareProfile() + ", image=" + this.getImage() + ", inspectionMode=" + this.getInspectionMode() + ", metaData=" + this.getMetaData() + ", networkData=" + this.getNetworkData() + ", online=" + this.getOnline() + ", preprovisioningNetworkDataName=" + this.getPreprovisioningNetworkDataName() + ", raid=" + this.getRaid() + ", rootDeviceHints=" + this.getRootDeviceHints() + ", taints=" + this.getTaints() + ", userData=" + this.getUserData() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
