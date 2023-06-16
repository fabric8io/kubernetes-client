
package io.fabric8.openshift.api.model.installer.baremetal.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
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
    "bmc",
    "bootMACAddress",
    "bootMode",
    "hardwareProfile",
    "name",
    "networkConfig",
    "role",
    "rootDeviceHints"
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
public class Host implements KubernetesResource
{

    @JsonProperty("bmc")
    private BMC bmc;
    @JsonProperty("bootMACAddress")
    private String bootMACAddress;
    @JsonProperty("bootMode")
    private String bootMode;
    @JsonProperty("hardwareProfile")
    private String hardwareProfile;
    @JsonProperty("name")
    private String name;
    @JsonProperty("networkConfig")
    private JsonNode networkConfig;
    @JsonProperty("role")
    private String role;
    @JsonProperty("rootDeviceHints")
    private RootDeviceHints rootDeviceHints;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Host() {
    }

    public Host(BMC bmc, String bootMACAddress, String bootMode, String hardwareProfile, String name, JsonNode networkConfig, String role, RootDeviceHints rootDeviceHints) {
        super();
        this.bmc = bmc;
        this.bootMACAddress = bootMACAddress;
        this.bootMode = bootMode;
        this.hardwareProfile = hardwareProfile;
        this.name = name;
        this.networkConfig = networkConfig;
        this.role = role;
        this.rootDeviceHints = rootDeviceHints;
    }

    @JsonProperty("bmc")
    public BMC getBmc() {
        return bmc;
    }

    @JsonProperty("bmc")
    public void setBmc(BMC bmc) {
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

    @JsonProperty("hardwareProfile")
    public String getHardwareProfile() {
        return hardwareProfile;
    }

    @JsonProperty("hardwareProfile")
    public void setHardwareProfile(String hardwareProfile) {
        this.hardwareProfile = hardwareProfile;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("networkConfig")
    public JsonNode getNetworkConfig() {
        return networkConfig;
    }

    @JsonProperty("networkConfig")
    public void setNetworkConfig(JsonNode networkConfig) {
        this.networkConfig = networkConfig;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("rootDeviceHints")
    public RootDeviceHints getRootDeviceHints() {
        return rootDeviceHints;
    }

    @JsonProperty("rootDeviceHints")
    public void setRootDeviceHints(RootDeviceHints rootDeviceHints) {
        this.rootDeviceHints = rootDeviceHints;
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
