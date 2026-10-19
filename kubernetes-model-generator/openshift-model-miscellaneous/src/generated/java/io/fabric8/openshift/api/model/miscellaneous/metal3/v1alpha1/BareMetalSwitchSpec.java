
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
import io.fabric8.kubernetes.api.model.SecretReference;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * BareMetalSwitchSpec defines the desired state of BareMetalSwitch.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "credentials",
    "deviceType",
    "disableCertificateVerification",
    "driver",
    "macAddress",
    "port"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BareMetalSwitchSpec implements Editable<BareMetalSwitchSpecBuilder>, KubernetesResource
{

    @JsonProperty("address")
    private String address;
    @JsonProperty("credentials")
    private SecretReference credentials;
    @JsonProperty("deviceType")
    private String deviceType;
    @JsonProperty("disableCertificateVerification")
    private Boolean disableCertificateVerification;
    @JsonProperty("driver")
    private String driver;
    @JsonProperty("macAddress")
    private String macAddress;
    @JsonProperty("port")
    private Integer port;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BareMetalSwitchSpec() {
    }

    public BareMetalSwitchSpec(String address, SecretReference credentials, String deviceType, Boolean disableCertificateVerification, String driver, String macAddress, Integer port) {
        super();
        this.address = address;
        this.credentials = credentials;
        this.deviceType = deviceType;
        this.disableCertificateVerification = disableCertificateVerification;
        this.driver = driver;
        this.macAddress = macAddress;
        this.port = port;
    }

    /**
     * Address is the network address of the switch (IP address or hostname).
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * Address is the network address of the switch (IP address or hostname).
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * BareMetalSwitchSpec defines the desired state of BareMetalSwitch.
     */
    @JsonProperty("credentials")
    public SecretReference getCredentials() {
        return credentials;
    }

    /**
     * BareMetalSwitchSpec defines the desired state of BareMetalSwitch.
     */
    @JsonProperty("credentials")
    public void setCredentials(SecretReference credentials) {
        this.credentials = credentials;
    }

    /**
     * DeviceType specifies the device type for the generic-switch driver. Must be one of the device types supported by networking-generic-switch. Examples: netmiko_cisco_ios, netmiko_dell_force10, netmiko_dell_os10,<br><p>   netmiko_juniper_junos, netmiko_arista_eos<br><p> See https://docs.openstack.org/networking-generic-switch/latest/configuration.html
     */
    @JsonProperty("deviceType")
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * DeviceType specifies the device type for the generic-switch driver. Must be one of the device types supported by networking-generic-switch. Examples: netmiko_cisco_ios, netmiko_dell_force10, netmiko_dell_os10,<br><p>   netmiko_juniper_junos, netmiko_arista_eos<br><p> See https://docs.openstack.org/networking-generic-switch/latest/configuration.html
     */
    @JsonProperty("deviceType")
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * DisableCertificateVerification disables TLS certificate verification when using HTTPS to connect to the switch. This is required for self-signed certificates, but is insecure as it allows man-in-the-middle attacks.
     */
    @JsonProperty("disableCertificateVerification")
    public Boolean getDisableCertificateVerification() {
        return disableCertificateVerification;
    }

    /**
     * DisableCertificateVerification disables TLS certificate verification when using HTTPS to connect to the switch. This is required for self-signed certificates, but is insecure as it allows man-in-the-middle attacks.
     */
    @JsonProperty("disableCertificateVerification")
    public void setDisableCertificateVerification(Boolean disableCertificateVerification) {
        this.disableCertificateVerification = disableCertificateVerification;
    }

    /**
     * Driver specifies the driver to use. Currently only "generic-switch" is supported.
     */
    @JsonProperty("driver")
    public String getDriver() {
        return driver;
    }

    /**
     * Driver specifies the driver to use. Currently only "generic-switch" is supported.
     */
    @JsonProperty("driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * MACAddress is the MAC address of the switch management interface. Used to correlate LLDP information from nodes to identify which switch they're connected to.
     */
    @JsonProperty("macAddress")
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * MACAddress is the MAC address of the switch management interface. Used to correlate LLDP information from nodes to identify which switch they're connected to.
     */
    @JsonProperty("macAddress")
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    /**
     * Port specifies the management port to connect to (e.g., SSH port 22, HTTPS port 443). If not specified, the driver will use its default port based on the device type.
     */
    @JsonProperty("port")
    public Integer getPort() {
        return port;
    }

    /**
     * Port specifies the management port to connect to (e.g., SSH port 22, HTTPS port 443). If not specified, the driver will use its default port based on the device type.
     */
    @JsonProperty("port")
    public void setPort(Integer port) {
        this.port = port;
    }

    @JsonIgnore
    public BareMetalSwitchSpecBuilder edit() {
        return new BareMetalSwitchSpecBuilder(this);
    }

    @JsonIgnore
    public BareMetalSwitchSpecBuilder toBuilder() {
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

}
