
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * NetworkDataRoutev4 represents an ipv4 route object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "gateway",
    "network",
    "prefix",
    "services"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class NetworkDataRoutev4 implements Editable<NetworkDataRoutev4Builder>, KubernetesResource
{

    @JsonProperty("gateway")
    private NetworkGatewayv4 gateway;
    @JsonProperty("network")
    private String network;
    @JsonProperty("prefix")
    private Integer prefix;
    @JsonProperty("services")
    private NetworkDataServicev4 services;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NetworkDataRoutev4() {
    }

    public NetworkDataRoutev4(NetworkGatewayv4 gateway, String network, Integer prefix, NetworkDataServicev4 services) {
        super();
        this.gateway = gateway;
        this.network = network;
        this.prefix = prefix;
        this.services = services;
    }

    /**
     * NetworkDataRoutev4 represents an ipv4 route object.
     */
    @JsonProperty("gateway")
    public NetworkGatewayv4 getGateway() {
        return gateway;
    }

    /**
     * NetworkDataRoutev4 represents an ipv4 route object.
     */
    @JsonProperty("gateway")
    public void setGateway(NetworkGatewayv4 gateway) {
        this.gateway = gateway;
    }

    /**
     * Network is the IPv4 network address
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * Network is the IPv4 network address
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * Prefix is the mask of the network as integer (max 32)
     */
    @JsonProperty("prefix")
    public Integer getPrefix() {
        return prefix;
    }

    /**
     * Prefix is the mask of the network as integer (max 32)
     */
    @JsonProperty("prefix")
    public void setPrefix(Integer prefix) {
        this.prefix = prefix;
    }

    /**
     * NetworkDataRoutev4 represents an ipv4 route object.
     */
    @JsonProperty("services")
    public NetworkDataServicev4 getServices() {
        return services;
    }

    /**
     * NetworkDataRoutev4 represents an ipv4 route object.
     */
    @JsonProperty("services")
    public void setServices(NetworkDataServicev4 services) {
        this.services = services;
    }

    @JsonIgnore
    public NetworkDataRoutev4Builder edit() {
        return new NetworkDataRoutev4Builder(this);
    }

    @JsonIgnore
    public NetworkDataRoutev4Builder toBuilder() {
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
