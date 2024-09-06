
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import java.util.LinkedHashMap;
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
    "ID",
    "bootMode",
    "customDeploy",
    "firmware",
    "image",
    "raid",
    "rootDeviceHints",
    "state"
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
public class BareMetalHostStatusProvisioning implements Editable<BareMetalHostStatusProvisioningBuilder> , KubernetesResource
{

    @JsonProperty("ID")
    private String iD;
    @JsonProperty("bootMode")
    private String bootMode;
    @JsonProperty("customDeploy")
    private BareMetalHostStatusPCustomDeploy customDeploy;
    @JsonProperty("firmware")
    private BareMetalHostStatusPFirmware firmware;
    @JsonProperty("image")
    private BareMetalHostStatusPImage image;
    @JsonProperty("raid")
    private BareMetalHostStatusPRaid raid;
    @JsonProperty("rootDeviceHints")
    private BareMetalHostStatusPRootDeviceHints rootDeviceHints;
    @JsonProperty("state")
    private String state;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BareMetalHostStatusProvisioning() {
    }

    public BareMetalHostStatusProvisioning(String iD, String bootMode, BareMetalHostStatusPCustomDeploy customDeploy, BareMetalHostStatusPFirmware firmware, BareMetalHostStatusPImage image, BareMetalHostStatusPRaid raid, BareMetalHostStatusPRootDeviceHints rootDeviceHints, String state) {
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

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    @JsonProperty("bootMode")
    public String getBootMode() {
        return bootMode;
    }

    @JsonProperty("bootMode")
    public void setBootMode(String bootMode) {
        this.bootMode = bootMode;
    }

    @JsonProperty("customDeploy")
    public BareMetalHostStatusPCustomDeploy getCustomDeploy() {
        return customDeploy;
    }

    @JsonProperty("customDeploy")
    public void setCustomDeploy(BareMetalHostStatusPCustomDeploy customDeploy) {
        this.customDeploy = customDeploy;
    }

    @JsonProperty("firmware")
    public BareMetalHostStatusPFirmware getFirmware() {
        return firmware;
    }

    @JsonProperty("firmware")
    public void setFirmware(BareMetalHostStatusPFirmware firmware) {
        this.firmware = firmware;
    }

    @JsonProperty("image")
    public BareMetalHostStatusPImage getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(BareMetalHostStatusPImage image) {
        this.image = image;
    }

    @JsonProperty("raid")
    public BareMetalHostStatusPRaid getRaid() {
        return raid;
    }

    @JsonProperty("raid")
    public void setRaid(BareMetalHostStatusPRaid raid) {
        this.raid = raid;
    }

    @JsonProperty("rootDeviceHints")
    public BareMetalHostStatusPRootDeviceHints getRootDeviceHints() {
        return rootDeviceHints;
    }

    @JsonProperty("rootDeviceHints")
    public void setRootDeviceHints(BareMetalHostStatusPRootDeviceHints rootDeviceHints) {
        this.rootDeviceHints = rootDeviceHints;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public BareMetalHostStatusProvisioningBuilder edit() {
        return new BareMetalHostStatusProvisioningBuilder(this);
    }

    @JsonIgnore
    public BareMetalHostStatusProvisioningBuilder toBuilder() {
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
