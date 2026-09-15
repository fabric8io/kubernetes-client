
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
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
 * GatewayConfig holds node gateway-related parsed config file parameters and command-line overrides
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ipForwarding",
    "ipv4",
    "ipv6",
    "routingViaHost"
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
public class GatewayConfig implements Editable<GatewayConfigBuilder>, KubernetesResource
{

    @JsonProperty("ipForwarding")
    private String ipForwarding;
    @JsonProperty("ipv4")
    private IPv4GatewayConfig ipv4;
    @JsonProperty("ipv6")
    private IPv6GatewayConfig ipv6;
    @JsonProperty("routingViaHost")
    private Boolean routingViaHost;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GatewayConfig() {
    }

    public GatewayConfig(String ipForwarding, IPv4GatewayConfig ipv4, IPv6GatewayConfig ipv6, Boolean routingViaHost) {
        super();
        this.ipForwarding = ipForwarding;
        this.ipv4 = ipv4;
        this.ipv6 = ipv6;
        this.routingViaHost = routingViaHost;
    }

    /**
     * ipForwarding controls IP forwarding for all traffic on OVN-Kubernetes managed interfaces (such as br-ex). By default this is set to Restricted, and Kubernetes related traffic is still forwarded appropriately, but other IP traffic will not be routed by the OCP node. If there is a desire to allow the host to forward traffic across OVN-Kubernetes managed interfaces, then set this field to "Global". The supported values are "Restricted" and "Global".
     */
    @JsonProperty("ipForwarding")
    public String getIpForwarding() {
        return ipForwarding;
    }

    /**
     * ipForwarding controls IP forwarding for all traffic on OVN-Kubernetes managed interfaces (such as br-ex). By default this is set to Restricted, and Kubernetes related traffic is still forwarded appropriately, but other IP traffic will not be routed by the OCP node. If there is a desire to allow the host to forward traffic across OVN-Kubernetes managed interfaces, then set this field to "Global". The supported values are "Restricted" and "Global".
     */
    @JsonProperty("ipForwarding")
    public void setIpForwarding(String ipForwarding) {
        this.ipForwarding = ipForwarding;
    }

    /**
     * GatewayConfig holds node gateway-related parsed config file parameters and command-line overrides
     */
    @JsonProperty("ipv4")
    public IPv4GatewayConfig getIpv4() {
        return ipv4;
    }

    /**
     * GatewayConfig holds node gateway-related parsed config file parameters and command-line overrides
     */
    @JsonProperty("ipv4")
    public void setIpv4(IPv4GatewayConfig ipv4) {
        this.ipv4 = ipv4;
    }

    /**
     * GatewayConfig holds node gateway-related parsed config file parameters and command-line overrides
     */
    @JsonProperty("ipv6")
    public IPv6GatewayConfig getIpv6() {
        return ipv6;
    }

    /**
     * GatewayConfig holds node gateway-related parsed config file parameters and command-line overrides
     */
    @JsonProperty("ipv6")
    public void setIpv6(IPv6GatewayConfig ipv6) {
        this.ipv6 = ipv6;
    }

    /**
     * routingViaHost allows pod egress traffic to exit via the ovn-k8s-mp0 management port into the host before sending it out. If this is not set, traffic will always egress directly from OVN to outside without touching the host stack. Setting this to true means hardware offload will not be supported. Default is false if GatewayConfig is specified.
     */
    @JsonProperty("routingViaHost")
    public Boolean getRoutingViaHost() {
        return routingViaHost;
    }

    /**
     * routingViaHost allows pod egress traffic to exit via the ovn-k8s-mp0 management port into the host before sending it out. If this is not set, traffic will always egress directly from OVN to outside without touching the host stack. Setting this to true means hardware offload will not be supported. Default is false if GatewayConfig is specified.
     */
    @JsonProperty("routingViaHost")
    public void setRoutingViaHost(Boolean routingViaHost) {
        this.routingViaHost = routingViaHost;
    }

    @JsonIgnore
    public GatewayConfigBuilder edit() {
        return new GatewayConfigBuilder(this);
    }

    @JsonIgnore
    public GatewayConfigBuilder toBuilder() {
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
        if (!(o instanceof GatewayConfig)) {
            return false;
        }
        GatewayConfig other = (GatewayConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ipForwarding = this.getIpForwarding();
        Object other$ipForwarding = other.getIpForwarding();
        if (this$ipForwarding == null ? other$ipForwarding != null : !this$ipForwarding.equals(other$ipForwarding)) {
            return false;
        }
        Object this$ipv4 = this.getIpv4();
        Object other$ipv4 = other.getIpv4();
        if (this$ipv4 == null ? other$ipv4 != null : !this$ipv4.equals(other$ipv4)) {
            return false;
        }
        Object this$ipv6 = this.getIpv6();
        Object other$ipv6 = other.getIpv6();
        if (this$ipv6 == null ? other$ipv6 != null : !this$ipv6.equals(other$ipv6)) {
            return false;
        }
        Object this$routingViaHost = this.getRoutingViaHost();
        Object other$routingViaHost = other.getRoutingViaHost();
        if (this$routingViaHost == null ? other$routingViaHost != null : !this$routingViaHost.equals(other$routingViaHost)) {
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
        return other instanceof GatewayConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ipForwarding = this.getIpForwarding();
        result = result * prime + ($ipForwarding == null ? 43 : $ipForwarding.hashCode());
        Object $ipv4 = this.getIpv4();
        result = result * prime + ($ipv4 == null ? 43 : $ipv4.hashCode());
        Object $ipv6 = this.getIpv6();
        result = result * prime + ($ipv6 == null ? 43 : $ipv6.hashCode());
        Object $routingViaHost = this.getRoutingViaHost();
        result = result * prime + ($routingViaHost == null ? 43 : $routingViaHost.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GatewayConfig(" + "ipForwarding=" + this.getIpForwarding() + ", ipv4=" + this.getIpv4() + ", ipv6=" + this.getIpv6() + ", routingViaHost=" + this.getRoutingViaHost() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
