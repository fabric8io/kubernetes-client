
package io.fabric8.kubernetes.api.model.resource.v1;

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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * NetworkDeviceData provides network-related details for the allocated device. This information may be filled by drivers or other components to configure or identify the device within a network context.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hardwareAddress",
    "interfaceName",
    "ips"
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
public class NetworkDeviceData implements Editable<NetworkDeviceDataBuilder>, KubernetesResource
{

    @JsonProperty("hardwareAddress")
    private String hardwareAddress;
    @JsonProperty("interfaceName")
    private String interfaceName;
    @JsonProperty("ips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ips = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkDeviceData() {
    }

    public NetworkDeviceData(String hardwareAddress, String interfaceName, List<String> ips) {
        super();
        this.hardwareAddress = hardwareAddress;
        this.interfaceName = interfaceName;
        this.ips = ips;
    }

    /**
     * HardwareAddress represents the hardware address (e.g. MAC Address) of the device's network interface.<br><p> <br><p> Must not be longer than 128 bytes.
     */
    @JsonProperty("hardwareAddress")
    public String getHardwareAddress() {
        return hardwareAddress;
    }

    /**
     * HardwareAddress represents the hardware address (e.g. MAC Address) of the device's network interface.<br><p> <br><p> Must not be longer than 128 bytes.
     */
    @JsonProperty("hardwareAddress")
    public void setHardwareAddress(String hardwareAddress) {
        this.hardwareAddress = hardwareAddress;
    }

    /**
     * InterfaceName specifies the name of the network interface associated with the allocated device. This might be the name of a physical or virtual network interface being configured in the pod.<br><p> <br><p> Must not be longer than 256 bytes.
     */
    @JsonProperty("interfaceName")
    public String getInterfaceName() {
        return interfaceName;
    }

    /**
     * InterfaceName specifies the name of the network interface associated with the allocated device. This might be the name of a physical or virtual network interface being configured in the pod.<br><p> <br><p> Must not be longer than 256 bytes.
     */
    @JsonProperty("interfaceName")
    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    /**
     * IPs lists the network addresses assigned to the device's network interface. This can include both IPv4 and IPv6 addresses. The IPs are in the CIDR notation, which includes both the address and the associated subnet mask. e.g.: "192.0.2.5/24" for IPv4 and "2001:db8::5/64" for IPv6.
     */
    @JsonProperty("ips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIps() {
        return ips;
    }

    /**
     * IPs lists the network addresses assigned to the device's network interface. This can include both IPv4 and IPv6 addresses. The IPs are in the CIDR notation, which includes both the address and the associated subnet mask. e.g.: "192.0.2.5/24" for IPv4 and "2001:db8::5/64" for IPv6.
     */
    @JsonProperty("ips")
    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    @JsonIgnore
    public NetworkDeviceDataBuilder edit() {
        return new NetworkDeviceDataBuilder(this);
    }

    @JsonIgnore
    public NetworkDeviceDataBuilder toBuilder() {
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
        if (!(o instanceof NetworkDeviceData)) {
            return false;
        }
        NetworkDeviceData other = (NetworkDeviceData) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hardwareAddress = this.getHardwareAddress();
        Object other$hardwareAddress = other.getHardwareAddress();
        if (this$hardwareAddress == null ? other$hardwareAddress != null : !this$hardwareAddress.equals(other$hardwareAddress)) {
            return false;
        }
        Object this$interfaceName = this.getInterfaceName();
        Object other$interfaceName = other.getInterfaceName();
        if (this$interfaceName == null ? other$interfaceName != null : !this$interfaceName.equals(other$interfaceName)) {
            return false;
        }
        Object this$ips = this.getIps();
        Object other$ips = other.getIps();
        if (this$ips == null ? other$ips != null : !this$ips.equals(other$ips)) {
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
        return other instanceof NetworkDeviceData;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hardwareAddress = this.getHardwareAddress();
        result = result * prime + ($hardwareAddress == null ? 43 : $hardwareAddress.hashCode());
        Object $interfaceName = this.getInterfaceName();
        result = result * prime + ($interfaceName == null ? 43 : $interfaceName.hashCode());
        Object $ips = this.getIps();
        result = result * prime + ($ips == null ? 43 : $ips.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkDeviceData(" + "hardwareAddress=" + this.getHardwareAddress() + ", interfaceName=" + this.getInterfaceName() + ", ips=" + this.getIps() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
