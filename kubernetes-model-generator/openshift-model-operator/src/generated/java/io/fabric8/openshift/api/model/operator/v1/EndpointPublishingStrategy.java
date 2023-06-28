
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "hostNetwork",
    "loadBalancer",
    "nodePort",
    "private",
    "type"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class EndpointPublishingStrategy implements KubernetesResource
{

    @JsonProperty("hostNetwork")
    private HostNetworkStrategy hostNetwork;
    @JsonProperty("loadBalancer")
    private LoadBalancerStrategy loadBalancer;
    @JsonProperty("nodePort")
    private NodePortStrategy nodePort;
    @JsonProperty("private")
    private PrivateStrategy _private;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EndpointPublishingStrategy() {
    }

    public EndpointPublishingStrategy(HostNetworkStrategy hostNetwork, LoadBalancerStrategy loadBalancer, NodePortStrategy nodePort, PrivateStrategy _private, String type) {
        super();
        this.hostNetwork = hostNetwork;
        this.loadBalancer = loadBalancer;
        this.nodePort = nodePort;
        this._private = _private;
        this.type = type;
    }

    @JsonProperty("hostNetwork")
    public HostNetworkStrategy getHostNetwork() {
        return hostNetwork;
    }

    @JsonProperty("hostNetwork")
    public void setHostNetwork(HostNetworkStrategy hostNetwork) {
        this.hostNetwork = hostNetwork;
    }

    @JsonProperty("loadBalancer")
    public LoadBalancerStrategy getLoadBalancer() {
        return loadBalancer;
    }

    @JsonProperty("loadBalancer")
    public void setLoadBalancer(LoadBalancerStrategy loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    @JsonProperty("nodePort")
    public NodePortStrategy getNodePort() {
        return nodePort;
    }

    @JsonProperty("nodePort")
    public void setNodePort(NodePortStrategy nodePort) {
        this.nodePort = nodePort;
    }

    @JsonProperty("private")
    public PrivateStrategy getPrivate() {
        return _private;
    }

    @JsonProperty("private")
    public void setPrivate(PrivateStrategy _private) {
        this._private = _private;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
