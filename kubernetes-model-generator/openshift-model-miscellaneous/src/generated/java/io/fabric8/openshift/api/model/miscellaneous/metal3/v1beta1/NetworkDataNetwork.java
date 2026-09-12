
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * NetworkDataNetwork represents a network object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ipv4",
    "ipv4DHCP",
    "ipv6",
    "ipv6DHCP",
    "ipv6SLAAC"
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
public class NetworkDataNetwork implements Editable<NetworkDataNetworkBuilder>, KubernetesResource
{

    @JsonProperty("ipv4")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataIPv4> ipv4 = new ArrayList<>();
    @JsonProperty("ipv4DHCP")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataIPv4DHCP> ipv4DHCP = new ArrayList<>();
    @JsonProperty("ipv6")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataIPv6> ipv6 = new ArrayList<>();
    @JsonProperty("ipv6DHCP")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataIPv6DHCP> ipv6DHCP = new ArrayList<>();
    @JsonProperty("ipv6SLAAC")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NetworkDataIPv6DHCP> ipv6SLAAC = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkDataNetwork() {
    }

    public NetworkDataNetwork(List<NetworkDataIPv4> ipv4, List<NetworkDataIPv4DHCP> ipv4DHCP, List<NetworkDataIPv6> ipv6, List<NetworkDataIPv6DHCP> ipv6DHCP, List<NetworkDataIPv6DHCP> ipv6SLAAC) {
        super();
        this.ipv4 = ipv4;
        this.ipv4DHCP = ipv4DHCP;
        this.ipv6 = ipv6;
        this.ipv6DHCP = ipv6DHCP;
        this.ipv6SLAAC = ipv6SLAAC;
    }

    /**
     * IPv4 contains a list of IPv4 static allocations
     */
    @JsonProperty("ipv4")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataIPv4> getIpv4() {
        return ipv4;
    }

    /**
     * IPv4 contains a list of IPv4 static allocations
     */
    @JsonProperty("ipv4")
    public void setIpv4(List<NetworkDataIPv4> ipv4) {
        this.ipv4 = ipv4;
    }

    /**
     * IPv4 contains a list of IPv4 DHCP allocations
     */
    @JsonProperty("ipv4DHCP")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataIPv4DHCP> getIpv4DHCP() {
        return ipv4DHCP;
    }

    /**
     * IPv4 contains a list of IPv4 DHCP allocations
     */
    @JsonProperty("ipv4DHCP")
    public void setIpv4DHCP(List<NetworkDataIPv4DHCP> ipv4DHCP) {
        this.ipv4DHCP = ipv4DHCP;
    }

    /**
     * IPv4 contains a list of IPv6 static allocations
     */
    @JsonProperty("ipv6")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataIPv6> getIpv6() {
        return ipv6;
    }

    /**
     * IPv4 contains a list of IPv6 static allocations
     */
    @JsonProperty("ipv6")
    public void setIpv6(List<NetworkDataIPv6> ipv6) {
        this.ipv6 = ipv6;
    }

    /**
     * IPv4 contains a list of IPv6 DHCP allocations
     */
    @JsonProperty("ipv6DHCP")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataIPv6DHCP> getIpv6DHCP() {
        return ipv6DHCP;
    }

    /**
     * IPv4 contains a list of IPv6 DHCP allocations
     */
    @JsonProperty("ipv6DHCP")
    public void setIpv6DHCP(List<NetworkDataIPv6DHCP> ipv6DHCP) {
        this.ipv6DHCP = ipv6DHCP;
    }

    /**
     * IPv4 contains a list of IPv6 SLAAC allocations
     */
    @JsonProperty("ipv6SLAAC")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NetworkDataIPv6DHCP> getIpv6SLAAC() {
        return ipv6SLAAC;
    }

    /**
     * IPv4 contains a list of IPv6 SLAAC allocations
     */
    @JsonProperty("ipv6SLAAC")
    public void setIpv6SLAAC(List<NetworkDataIPv6DHCP> ipv6SLAAC) {
        this.ipv6SLAAC = ipv6SLAAC;
    }

    @JsonIgnore
    public NetworkDataNetworkBuilder edit() {
        return new NetworkDataNetworkBuilder(this);
    }

    @JsonIgnore
    public NetworkDataNetworkBuilder toBuilder() {
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
        if (!(o instanceof NetworkDataNetwork)) {
            return false;
        }
        NetworkDataNetwork other = (NetworkDataNetwork) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ipv4 = this.getIpv4();
        Object other$ipv4 = other.getIpv4();
        if (this$ipv4 == null ? other$ipv4 != null : !this$ipv4.equals(other$ipv4)) {
            return false;
        }
        Object this$ipv4DHCP = this.getIpv4DHCP();
        Object other$ipv4DHCP = other.getIpv4DHCP();
        if (this$ipv4DHCP == null ? other$ipv4DHCP != null : !this$ipv4DHCP.equals(other$ipv4DHCP)) {
            return false;
        }
        Object this$ipv6 = this.getIpv6();
        Object other$ipv6 = other.getIpv6();
        if (this$ipv6 == null ? other$ipv6 != null : !this$ipv6.equals(other$ipv6)) {
            return false;
        }
        Object this$ipv6DHCP = this.getIpv6DHCP();
        Object other$ipv6DHCP = other.getIpv6DHCP();
        if (this$ipv6DHCP == null ? other$ipv6DHCP != null : !this$ipv6DHCP.equals(other$ipv6DHCP)) {
            return false;
        }
        Object this$ipv6SLAAC = this.getIpv6SLAAC();
        Object other$ipv6SLAAC = other.getIpv6SLAAC();
        if (this$ipv6SLAAC == null ? other$ipv6SLAAC != null : !this$ipv6SLAAC.equals(other$ipv6SLAAC)) {
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
        return other instanceof NetworkDataNetwork;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ipv4 = this.getIpv4();
        result = result * prime + ($ipv4 == null ? 43 : $ipv4.hashCode());
        Object $ipv4DHCP = this.getIpv4DHCP();
        result = result * prime + ($ipv4DHCP == null ? 43 : $ipv4DHCP.hashCode());
        Object $ipv6 = this.getIpv6();
        result = result * prime + ($ipv6 == null ? 43 : $ipv6.hashCode());
        Object $ipv6DHCP = this.getIpv6DHCP();
        result = result * prime + ($ipv6DHCP == null ? 43 : $ipv6DHCP.hashCode());
        Object $ipv6SLAAC = this.getIpv6SLAAC();
        result = result * prime + ($ipv6SLAAC == null ? 43 : $ipv6SLAAC.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkDataNetwork(" + "ipv4=" + this.getIpv4() + ", ipv4DHCP=" + this.getIpv4DHCP() + ", ipv6=" + this.getIpv6() + ", ipv6DHCP=" + this.getIpv6DHCP() + ", ipv6SLAAC=" + this.getIpv6SLAAC() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
