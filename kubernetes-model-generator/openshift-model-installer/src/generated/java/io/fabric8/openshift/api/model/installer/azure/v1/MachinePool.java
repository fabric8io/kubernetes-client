
package io.fabric8.openshift.api.model.installer.azure.v1;

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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "encryptionAtHost",
    "osDisk",
    "osImage",
    "settings",
    "type",
    "ultraSSDCapability",
    "vmNetworkingType",
    "zones"
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
public class MachinePool implements Editable<MachinePoolBuilder> , KubernetesResource
{

    @JsonProperty("encryptionAtHost")
    private Boolean encryptionAtHost;
    @JsonProperty("osDisk")
    private OSDisk osDisk;
    @JsonProperty("osImage")
    private OSImage osImage;
    @JsonProperty("settings")
    private SecuritySettings settings;
    @JsonProperty("type")
    private String type;
    @JsonProperty("ultraSSDCapability")
    private String ultraSSDCapability;
    @JsonProperty("vmNetworkingType")
    private String vmNetworkingType;
    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> zones = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachinePool() {
    }

    public MachinePool(Boolean encryptionAtHost, OSDisk osDisk, OSImage osImage, SecuritySettings settings, String type, String ultraSSDCapability, String vmNetworkingType, List<String> zones) {
        super();
        this.encryptionAtHost = encryptionAtHost;
        this.osDisk = osDisk;
        this.osImage = osImage;
        this.settings = settings;
        this.type = type;
        this.ultraSSDCapability = ultraSSDCapability;
        this.vmNetworkingType = vmNetworkingType;
        this.zones = zones;
    }

    @JsonProperty("encryptionAtHost")
    public Boolean getEncryptionAtHost() {
        return encryptionAtHost;
    }

    @JsonProperty("encryptionAtHost")
    public void setEncryptionAtHost(Boolean encryptionAtHost) {
        this.encryptionAtHost = encryptionAtHost;
    }

    @JsonProperty("osDisk")
    public OSDisk getOsDisk() {
        return osDisk;
    }

    @JsonProperty("osDisk")
    public void setOsDisk(OSDisk osDisk) {
        this.osDisk = osDisk;
    }

    @JsonProperty("osImage")
    public OSImage getOsImage() {
        return osImage;
    }

    @JsonProperty("osImage")
    public void setOsImage(OSImage osImage) {
        this.osImage = osImage;
    }

    @JsonProperty("settings")
    public SecuritySettings getSettings() {
        return settings;
    }

    @JsonProperty("settings")
    public void setSettings(SecuritySettings settings) {
        this.settings = settings;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("ultraSSDCapability")
    public String getUltraSSDCapability() {
        return ultraSSDCapability;
    }

    @JsonProperty("ultraSSDCapability")
    public void setUltraSSDCapability(String ultraSSDCapability) {
        this.ultraSSDCapability = ultraSSDCapability;
    }

    @JsonProperty("vmNetworkingType")
    public String getVmNetworkingType() {
        return vmNetworkingType;
    }

    @JsonProperty("vmNetworkingType")
    public void setVmNetworkingType(String vmNetworkingType) {
        this.vmNetworkingType = vmNetworkingType;
    }

    @JsonProperty("zones")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getZones() {
        return zones;
    }

    @JsonProperty("zones")
    public void setZones(List<String> zones) {
        this.zones = zones;
    }

    @JsonIgnore
    public MachinePoolBuilder edit() {
        return new MachinePoolBuilder(this);
    }

    @JsonIgnore
    public MachinePoolBuilder toBuilder() {
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
