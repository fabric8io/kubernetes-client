
package io.fabric8.openshift.api.model.operator.v1;

import java.util.LinkedHashMap;
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ipForwarding",
    "ipv4",
    "ipv6",
    "routingViaHost"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class NetworkSpecDNOKCGatewayConfig implements Editable<NetworkSpecDNOKCGatewayConfigBuilder> , KubernetesResource
{

    @JsonProperty("ipForwarding")
    private String ipForwarding;
    @JsonProperty("ipv4")
    private NetworkSpecDNOKCGCIpv4 ipv4;
    @JsonProperty("ipv6")
    private NetworkSpecDNOKCGCIpv6 ipv6;
    @JsonProperty("routingViaHost")
    private Boolean routingViaHost;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkSpecDNOKCGatewayConfig() {
    }

    public NetworkSpecDNOKCGatewayConfig(String ipForwarding, NetworkSpecDNOKCGCIpv4 ipv4, NetworkSpecDNOKCGCIpv6 ipv6, Boolean routingViaHost) {
        super();
        this.ipForwarding = ipForwarding;
        this.ipv4 = ipv4;
        this.ipv6 = ipv6;
        this.routingViaHost = routingViaHost;
    }

    @JsonProperty("ipForwarding")
    public String getIpForwarding() {
        return ipForwarding;
    }

    @JsonProperty("ipForwarding")
    public void setIpForwarding(String ipForwarding) {
        this.ipForwarding = ipForwarding;
    }

    @JsonProperty("ipv4")
    public NetworkSpecDNOKCGCIpv4 getIpv4() {
        return ipv4;
    }

    @JsonProperty("ipv4")
    public void setIpv4(NetworkSpecDNOKCGCIpv4 ipv4) {
        this.ipv4 = ipv4;
    }

    @JsonProperty("ipv6")
    public NetworkSpecDNOKCGCIpv6 getIpv6() {
        return ipv6;
    }

    @JsonProperty("ipv6")
    public void setIpv6(NetworkSpecDNOKCGCIpv6 ipv6) {
        this.ipv6 = ipv6;
    }

    @JsonProperty("routingViaHost")
    public Boolean getRoutingViaHost() {
        return routingViaHost;
    }

    @JsonProperty("routingViaHost")
    public void setRoutingViaHost(Boolean routingViaHost) {
        this.routingViaHost = routingViaHost;
    }

    @JsonIgnore
    public NetworkSpecDNOKCGatewayConfigBuilder edit() {
        return new NetworkSpecDNOKCGatewayConfigBuilder(this);
    }

    @JsonIgnore
    public NetworkSpecDNOKCGatewayConfigBuilder toBuilder() {
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
