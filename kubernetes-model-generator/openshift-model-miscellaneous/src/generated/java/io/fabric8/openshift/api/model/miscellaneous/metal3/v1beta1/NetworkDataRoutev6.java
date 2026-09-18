
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * NetworkDataRoutev6 represents an ipv6 route object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gateway",
    "network",
    "prefix",
    "services"
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
public class NetworkDataRoutev6 implements Editable<NetworkDataRoutev6Builder>, KubernetesResource
{

    @JsonProperty("gateway")
    private NetworkGatewayv6 gateway;
    @JsonProperty("network")
    private String network;
    @JsonProperty("prefix")
    private Integer prefix;
    @JsonProperty("services")
    private NetworkDataServicev6 services;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkDataRoutev6() {
    }

    public NetworkDataRoutev6(NetworkGatewayv6 gateway, String network, Integer prefix, NetworkDataServicev6 services) {
        super();
        this.gateway = gateway;
        this.network = network;
        this.prefix = prefix;
        this.services = services;
    }

    /**
     * NetworkDataRoutev6 represents an ipv6 route object.
     */
    @JsonProperty("gateway")
    public NetworkGatewayv6 getGateway() {
        return gateway;
    }

    /**
     * NetworkDataRoutev6 represents an ipv6 route object.
     */
    @JsonProperty("gateway")
    public void setGateway(NetworkGatewayv6 gateway) {
        this.gateway = gateway;
    }

    /**
     * Network is the IPv6 network address
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * Network is the IPv6 network address
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * Prefix is the mask of the network as integer (max 128)
     */
    @JsonProperty("prefix")
    public Integer getPrefix() {
        return prefix;
    }

    /**
     * Prefix is the mask of the network as integer (max 128)
     */
    @JsonProperty("prefix")
    public void setPrefix(Integer prefix) {
        this.prefix = prefix;
    }

    /**
     * NetworkDataRoutev6 represents an ipv6 route object.
     */
    @JsonProperty("services")
    public NetworkDataServicev6 getServices() {
        return services;
    }

    /**
     * NetworkDataRoutev6 represents an ipv6 route object.
     */
    @JsonProperty("services")
    public void setServices(NetworkDataServicev6 services) {
        this.services = services;
    }

    @JsonIgnore
    public NetworkDataRoutev6Builder edit() {
        return new NetworkDataRoutev6Builder(this);
    }

    @JsonIgnore
    public NetworkDataRoutev6Builder toBuilder() {
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
        if (!(o instanceof NetworkDataRoutev6)) {
            return false;
        }
        NetworkDataRoutev6 other = (NetworkDataRoutev6) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$gateway = this.getGateway();
        Object other$gateway = other.getGateway();
        if (this$gateway == null ? other$gateway != null : !this$gateway.equals(other$gateway)) {
            return false;
        }
        Object this$network = this.getNetwork();
        Object other$network = other.getNetwork();
        if (this$network == null ? other$network != null : !this$network.equals(other$network)) {
            return false;
        }
        Object this$prefix = this.getPrefix();
        Object other$prefix = other.getPrefix();
        if (this$prefix == null ? other$prefix != null : !this$prefix.equals(other$prefix)) {
            return false;
        }
        Object this$services = this.getServices();
        Object other$services = other.getServices();
        if (this$services == null ? other$services != null : !this$services.equals(other$services)) {
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
        return other instanceof NetworkDataRoutev6;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $gateway = this.getGateway();
        result = result * prime + ($gateway == null ? 43 : $gateway.hashCode());
        Object $network = this.getNetwork();
        result = result * prime + ($network == null ? 43 : $network.hashCode());
        Object $prefix = this.getPrefix();
        result = result * prime + ($prefix == null ? 43 : $prefix.hashCode());
        Object $services = this.getServices();
        result = result * prime + ($services == null ? 43 : $services.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NetworkDataRoutev6(" + "gateway=" + this.getGateway() + ", network=" + this.getNetwork() + ", prefix=" + this.getPrefix() + ", services=" + this.getServices() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
