
package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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
 * NetworkStatus is for network status annotation for pod
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "default",
    "device-info",
    "dns",
    "gateway",
    "interface",
    "ips",
    "mac",
    "mtu",
    "name"
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
public class NetworkStatus implements Editable<NetworkStatusBuilder>, KubernetesResource
{

    @JsonProperty("default")
    private Boolean _default;
    @JsonProperty("device-info")
    private DeviceInfo deviceInfo;
    @JsonProperty("dns")
    private DNS dns;
    @JsonProperty("gateway")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> gateway = new ArrayList<>();
    @JsonProperty("interface")
    private String _interface;
    @JsonProperty("ips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ips = new ArrayList<>();
    @JsonProperty("mac")
    private String mac;
    @JsonProperty("mtu")
    private Integer mtu;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkStatus() {
    }

    public NetworkStatus(Boolean _default, DeviceInfo deviceInfo, DNS dns, List<String> gateway, String _interface, List<String> ips, String mac, Integer mtu, String name) {
        super();
        this._default = _default;
        this.deviceInfo = deviceInfo;
        this.dns = dns;
        this.gateway = gateway;
        this._interface = _interface;
        this.ips = ips;
        this.mac = mac;
        this.mtu = mtu;
        this.name = name;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("default")
    public Boolean getDefault() {
        return _default;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("default")
    public void setDefault(Boolean _default) {
        this._default = _default;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("device-info")
    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("device-info")
    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("dns")
    public DNS getDns() {
        return dns;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("dns")
    public void setDns(DNS dns) {
        this.dns = dns;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("gateway")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGateway() {
        return gateway;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("gateway")
    public void setGateway(List<String> gateway) {
        this.gateway = gateway;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("interface")
    public String getInterface() {
        return _interface;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("interface")
    public void setInterface(String _interface) {
        this._interface = _interface;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("ips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIps() {
        return ips;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("ips")
    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("mac")
    public String getMac() {
        return mac;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("mac")
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("mtu")
    public Integer getMtu() {
        return mtu;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("mtu")
    public void setMtu(Integer mtu) {
        this.mtu = mtu;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * NetworkStatus is for network status annotation for pod
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public NetworkStatusBuilder edit() {
        return new NetworkStatusBuilder(this);
    }

    @JsonIgnore
    public NetworkStatusBuilder toBuilder() {
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
        if (!(o instanceof NetworkStatus)) {
            return false;
        }
        NetworkStatus other = (NetworkStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$_default = this.getDefault();
        Object other$_default = other.getDefault();
        if (this$_default == null ? other$_default != null : !this$_default.equals(other$_default)) {
            return false;
        }
        Object this$deviceInfo = this.getDeviceInfo();
        Object other$deviceInfo = other.getDeviceInfo();
        if (this$deviceInfo == null ? other$deviceInfo != null : !this$deviceInfo.equals(other$deviceInfo)) {
            return false;
        }
        Object this$dns = this.getDns();
        Object other$dns = other.getDns();
        if (this$dns == null ? other$dns != null : !this$dns.equals(other$dns)) {
            return false;
        }
        Object this$gateway = this.getGateway();
        Object other$gateway = other.getGateway();
        if (this$gateway == null ? other$gateway != null : !this$gateway.equals(other$gateway)) {
            return false;
        }
        Object this$_interface = this.getInterface();
        Object other$_interface = other.getInterface();
        if (this$_interface == null ? other$_interface != null : !this$_interface.equals(other$_interface)) {
            return false;
        }
        Object this$ips = this.getIps();
        Object other$ips = other.getIps();
        if (this$ips == null ? other$ips != null : !this$ips.equals(other$ips)) {
            return false;
        }
        Object this$mac = this.getMac();
        Object other$mac = other.getMac();
        if (this$mac == null ? other$mac != null : !this$mac.equals(other$mac)) {
            return false;
        }
        Object this$mtu = this.getMtu();
        Object other$mtu = other.getMtu();
        if (this$mtu == null ? other$mtu != null : !this$mtu.equals(other$mtu)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
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
        return other instanceof NetworkStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $_default = this.getDefault();
        result = result * prime + ($_default == null ? 43 : $_default.hashCode());
        Object $deviceInfo = this.getDeviceInfo();
        result = result * prime + ($deviceInfo == null ? 43 : $deviceInfo.hashCode());
        Object $dns = this.getDns();
        result = result * prime + ($dns == null ? 43 : $dns.hashCode());
        Object $gateway = this.getGateway();
        result = result * prime + ($gateway == null ? 43 : $gateway.hashCode());
        Object $_interface = this.getInterface();
        result = result * prime + ($_interface == null ? 43 : $_interface.hashCode());
        Object $ips = this.getIps();
        result = result * prime + ($ips == null ? 43 : $ips.hashCode());
        Object $mac = this.getMac();
        result = result * prime + ($mac == null ? 43 : $mac.hashCode());
        Object $mtu = this.getMtu();
        result = result * prime + ($mtu == null ? 43 : $mtu.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkStatus(" + "_default=" + this.getDefault() + ", deviceInfo=" + this.getDeviceInfo() + ", dns=" + this.getDns() + ", gateway=" + this.getGateway() + ", _interface=" + this.getInterface() + ", ips=" + this.getIps() + ", mac=" + this.getMac() + ", mtu=" + this.getMtu() + ", name=" + this.getName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
