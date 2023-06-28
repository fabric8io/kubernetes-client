
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ProvisionStatus implements KubernetesResource
{

    @JsonProperty("ID")
    private String id;
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
     * 
     */
    public ProvisionStatus() {
    }

    public ProvisionStatus(String id, String bootMode, CustomDeploy customDeploy, FirmwareConfig firmware, Image image, RAIDConfig raid, RootDeviceHints rootDeviceHints, String state) {
        super();
        this.id = id;
        this.bootMode = bootMode;
        this.customDeploy = customDeploy;
        this.firmware = firmware;
        this.image = image;
        this.raid = raid;
        this.rootDeviceHints = rootDeviceHints;
        this.state = state;
    }

    @JsonProperty("ID")
    public String getId() {
        return id;
    }

    @JsonProperty("ID")
    public void setId(String id) {
        this.id = id;
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
    public CustomDeploy getCustomDeploy() {
        return customDeploy;
    }

    @JsonProperty("customDeploy")
    public void setCustomDeploy(CustomDeploy customDeploy) {
        this.customDeploy = customDeploy;
    }

    @JsonProperty("firmware")
    public FirmwareConfig getFirmware() {
        return firmware;
    }

    @JsonProperty("firmware")
    public void setFirmware(FirmwareConfig firmware) {
        this.firmware = firmware;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
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

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
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
