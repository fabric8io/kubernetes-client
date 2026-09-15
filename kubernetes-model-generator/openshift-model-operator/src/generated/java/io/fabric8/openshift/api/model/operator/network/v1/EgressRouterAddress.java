
package io.fabric8.openshift.api.model.operator.network.v1;

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
 * EgressRouterAddress contains a pair of IP CIDR and gateway to be configured on the router's interface
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gateway",
    "ip"
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
public class EgressRouterAddress implements Editable<EgressRouterAddressBuilder>, KubernetesResource
{

    @JsonProperty("gateway")
    private String gateway;
    @JsonProperty("ip")
    private String ip;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EgressRouterAddress() {
    }

    public EgressRouterAddress(String gateway, String ip) {
        super();
        this.gateway = gateway;
        this.ip = ip;
    }

    /**
     * IP address of the next-hop gateway, if it cannot be automatically determined. Can be IPv4 or IPv6.
     */
    @JsonProperty("gateway")
    public String getGateway() {
        return gateway;
    }

    /**
     * IP address of the next-hop gateway, if it cannot be automatically determined. Can be IPv4 or IPv6.
     */
    @JsonProperty("gateway")
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    /**
     * ip is the address to configure on the router's interface. Can be IPv4 or IPv6.
     */
    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    /**
     * ip is the address to configure on the router's interface. Can be IPv4 or IPv6.
     */
    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonIgnore
    public EgressRouterAddressBuilder edit() {
        return new EgressRouterAddressBuilder(this);
    }

    @JsonIgnore
    public EgressRouterAddressBuilder toBuilder() {
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
        if (!(o instanceof EgressRouterAddress)) {
            return false;
        }
        EgressRouterAddress other = (EgressRouterAddress) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$gateway = this.getGateway();
        Object other$gateway = other.getGateway();
        if (this$gateway == null ? other$gateway != null : !this$gateway.equals(other$gateway)) {
            return false;
        }
        Object this$ip = this.getIp();
        Object other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) {
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
        return other instanceof EgressRouterAddress;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $gateway = this.getGateway();
        result = result * prime + ($gateway == null ? 43 : $gateway.hashCode());
        Object $ip = this.getIp();
        result = result * prime + ($ip == null ? 43 : $ip.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EgressRouterAddress(" + "gateway=" + this.getGateway() + ", ip=" + this.getIp() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
