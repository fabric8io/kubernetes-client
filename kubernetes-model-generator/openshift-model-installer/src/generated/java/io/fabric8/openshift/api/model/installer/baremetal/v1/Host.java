
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

/**
 * Host stores all the configuration data for a baremetal host.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
public class Host implements Editable<HostBuilder>, KubernetesResource
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

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("bmc")
    public BMC getBmc() {
        return bmc;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("bmc")
    public void setBmc(BMC bmc) {
        this.bmc = bmc;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("bootMACAddress")
    public String getBootMACAddress() {
        return bootMACAddress;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("bootMACAddress")
    public void setBootMACAddress(String bootMACAddress) {
        this.bootMACAddress = bootMACAddress;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("bootMode")
    public String getBootMode() {
        return bootMode;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("bootMode")
    public void setBootMode(String bootMode) {
        this.bootMode = bootMode;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("hardwareProfile")
    public String getHardwareProfile() {
        return hardwareProfile;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("hardwareProfile")
    public void setHardwareProfile(String hardwareProfile) {
        this.hardwareProfile = hardwareProfile;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("networkConfig")
    public JsonNode getNetworkConfig() {
        return networkConfig;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("networkConfig")
    public void setNetworkConfig(JsonNode networkConfig) {
        this.networkConfig = networkConfig;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("rootDeviceHints")
    public RootDeviceHints getRootDeviceHints() {
        return rootDeviceHints;
    }

    /**
     * Host stores all the configuration data for a baremetal host.
     */
    @JsonProperty("rootDeviceHints")
    public void setRootDeviceHints(RootDeviceHints rootDeviceHints) {
        this.rootDeviceHints = rootDeviceHints;
    }

    @JsonIgnore
    public HostBuilder edit() {
        return new HostBuilder(this);
    }

    @JsonIgnore
    public HostBuilder toBuilder() {
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
