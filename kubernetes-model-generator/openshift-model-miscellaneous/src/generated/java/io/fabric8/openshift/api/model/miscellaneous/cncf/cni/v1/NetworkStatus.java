
package io.fabric8.openshift.api.model.miscellaneous.cncf.cni.v1;

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
public class NetworkStatus implements Editable<NetworkStatusBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("default")
    public Boolean getDefault() {
        return _default;
    }

    @JsonProperty("default")
    public void setDefault(Boolean _default) {
        this._default = _default;
    }

    @JsonProperty("device-info")
    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    @JsonProperty("device-info")
    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    @JsonProperty("dns")
    public DNS getDns() {
        return dns;
    }

    @JsonProperty("dns")
    public void setDns(DNS dns) {
        this.dns = dns;
    }

    @JsonProperty("gateway")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGateway() {
        return gateway;
    }

    @JsonProperty("gateway")
    public void setGateway(List<String> gateway) {
        this.gateway = gateway;
    }

    @JsonProperty("interface")
    public String getInterface() {
        return _interface;
    }

    @JsonProperty("interface")
    public void setInterface(String _interface) {
        this._interface = _interface;
    }

    @JsonProperty("ips")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIps() {
        return ips;
    }

    @JsonProperty("ips")
    public void setIps(List<String> ips) {
        this.ips = ips;
    }

    @JsonProperty("mac")
    public String getMac() {
        return mac;
    }

    @JsonProperty("mac")
    public void setMac(String mac) {
        this.mac = mac;
    }

    @JsonProperty("mtu")
    public Integer getMtu() {
        return mtu;
    }

    @JsonProperty("mtu")
    public void setMtu(Integer mtu) {
        this.mtu = mtu;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

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
