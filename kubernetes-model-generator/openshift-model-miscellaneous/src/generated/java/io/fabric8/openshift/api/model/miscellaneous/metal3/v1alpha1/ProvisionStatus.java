
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ProvisionStatus holds the state information for a single target.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ID",
    "bootMode",
    "customDeploy",
    "firmware",
    "image",
    "raid",
    "rootDeviceHints",
    "state"
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
public class ProvisionStatus implements Editable<ProvisionStatusBuilder>, KubernetesResource
{

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("bootMode")
    private String bootMode;
    @JsonProperty("customDeploy")
    private CustomDeploy customDeploy;
    @JsonProperty("firmware")
    private FirmwareConfig firmware;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("raid")
    private RAIDConfig raid;
    @JsonProperty("rootDeviceHints")
    private RootDeviceHints rootDeviceHints;
    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ProvisionStatus() {
    }

    public ProvisionStatus(String iD, String bootMode, CustomDeploy customDeploy, FirmwareConfig firmware, Image image, RAIDConfig raid, RootDeviceHints rootDeviceHints, String state) {
        super();
        this.iD = iD;
        this.bootMode = bootMode;
        this.customDeploy = customDeploy;
        this.firmware = firmware;
        this.image = image;
        this.raid = raid;
        this.rootDeviceHints = rootDeviceHints;
        this.state = state;
    }

    /**
     * The hosts's ID from the underlying provisioning tool (e.g. the Ironic node UUID).
     */
    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    /**
     * The hosts's ID from the underlying provisioning tool (e.g. the Ironic node UUID).
     */
    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    /**
     * BootMode indicates the boot mode used to provision the host.
     */
    @JsonProperty("bootMode")
    public String getBootMode() {
        return bootMode;
    }

    /**
     * BootMode indicates the boot mode used to provision the host.
     */
    @JsonProperty("bootMode")
    public void setBootMode(String bootMode) {
        this.bootMode = bootMode;
    }

    /**
     * ProvisionStatus holds the state information for a single target.
     */
    @JsonProperty("customDeploy")
    public CustomDeploy getCustomDeploy() {
        return customDeploy;
    }

    /**
     * ProvisionStatus holds the state information for a single target.
     */
    @JsonProperty("customDeploy")
    public void setCustomDeploy(CustomDeploy customDeploy) {
        this.customDeploy = customDeploy;
    }

    /**
     * ProvisionStatus holds the state information for a single target.
     */
    @JsonProperty("firmware")
    public FirmwareConfig getFirmware() {
        return firmware;
    }

    /**
     * ProvisionStatus holds the state information for a single target.
     */
    @JsonProperty("firmware")
    public void setFirmware(FirmwareConfig firmware) {
        this.firmware = firmware;
    }

    /**
     * ProvisionStatus holds the state information for a single target.
     */
    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    /**
     * ProvisionStatus holds the state information for a single target.
     */
    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * ProvisionStatus holds the state information for a single target.
     */
    @JsonProperty("raid")
    public RAIDConfig getRaid() {
        return raid;
    }

    /**
     * ProvisionStatus holds the state information for a single target.
     */
    @JsonProperty("raid")
    public void setRaid(RAIDConfig raid) {
        this.raid = raid;
    }

    /**
     * ProvisionStatus holds the state information for a single target.
     */
    @JsonProperty("rootDeviceHints")
    public RootDeviceHints getRootDeviceHints() {
        return rootDeviceHints;
    }

    /**
     * ProvisionStatus holds the state information for a single target.
     */
    @JsonProperty("rootDeviceHints")
    public void setRootDeviceHints(RootDeviceHints rootDeviceHints) {
        this.rootDeviceHints = rootDeviceHints;
    }

    /**
     * An indicator for what the provisioner is doing with the host.
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * An indicator for what the provisioner is doing with the host.
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public ProvisionStatusBuilder edit() {
        return new ProvisionStatusBuilder(this);
    }

    @JsonIgnore
    public ProvisionStatusBuilder toBuilder() {
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
        if (!(o instanceof ProvisionStatus)) {
            return false;
        }
        ProvisionStatus other = (ProvisionStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$iD = this.getID();
        Object other$iD = other.getID();
        if (this$iD == null ? other$iD != null : !this$iD.equals(other$iD)) {
            return false;
        }
        Object this$bootMode = this.getBootMode();
        Object other$bootMode = other.getBootMode();
        if (this$bootMode == null ? other$bootMode != null : !this$bootMode.equals(other$bootMode)) {
            return false;
        }
        Object this$customDeploy = this.getCustomDeploy();
        Object other$customDeploy = other.getCustomDeploy();
        if (this$customDeploy == null ? other$customDeploy != null : !this$customDeploy.equals(other$customDeploy)) {
            return false;
        }
        Object this$firmware = this.getFirmware();
        Object other$firmware = other.getFirmware();
        if (this$firmware == null ? other$firmware != null : !this$firmware.equals(other$firmware)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
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
        Object this$state = this.getState();
        Object other$state = other.getState();
        if (this$state == null ? other$state != null : !this$state.equals(other$state)) {
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
        return other instanceof ProvisionStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $iD = this.getID();
        result = result * prime + ($iD == null ? 43 : $iD.hashCode());
        Object $bootMode = this.getBootMode();
        result = result * prime + ($bootMode == null ? 43 : $bootMode.hashCode());
        Object $customDeploy = this.getCustomDeploy();
        result = result * prime + ($customDeploy == null ? 43 : $customDeploy.hashCode());
        Object $firmware = this.getFirmware();
        result = result * prime + ($firmware == null ? 43 : $firmware.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $raid = this.getRaid();
        result = result * prime + ($raid == null ? 43 : $raid.hashCode());
        Object $rootDeviceHints = this.getRootDeviceHints();
        result = result * prime + ($rootDeviceHints == null ? 43 : $rootDeviceHints.hashCode());
        Object $state = this.getState();
        result = result * prime + ($state == null ? 43 : $state.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ProvisionStatus(" + "iD=" + this.getID() + ", bootMode=" + this.getBootMode() + ", customDeploy=" + this.getCustomDeploy() + ", firmware=" + this.getFirmware() + ", image=" + this.getImage() + ", raid=" + this.getRaid() + ", rootDeviceHints=" + this.getRootDeviceHints() + ", state=" + this.getState() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
