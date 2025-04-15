
package io.fabric8.openshift.api.model.operator.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ForwardPlugin defines a schema for configuring the CoreDNS forward plugin.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "policy",
    "protocolStrategy",
    "transportConfig",
    "upstreams"
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
public class ForwardPlugin implements Editable<ForwardPluginBuilder>, KubernetesResource
{

    @JsonProperty("policy")
    private String policy;
    @JsonProperty("protocolStrategy")
    private String protocolStrategy;
    @JsonProperty("transportConfig")
    private DNSTransportConfig transportConfig;
    @JsonProperty("upstreams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> upstreams = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ForwardPlugin() {
    }

    public ForwardPlugin(String policy, String protocolStrategy, DNSTransportConfig transportConfig, List<String> upstreams) {
        super();
        this.policy = policy;
        this.protocolStrategy = protocolStrategy;
        this.transportConfig = transportConfig;
        this.upstreams = upstreams;
    }

    /**
     * policy is used to determine the order in which upstream servers are selected for querying. Any one of the following values may be specified:<br><p> <br><p> &#42; "Random" picks a random upstream server for each query. &#42; "RoundRobin" picks upstream servers in a round-robin order, moving to the next server for each new query. &#42; "Sequential" tries querying upstream servers in a sequential order until one responds, starting with the first server for each new query.<br><p> <br><p> The default value is "Random"
     */
    @JsonProperty("policy")
    public String getPolicy() {
        return policy;
    }

    /**
     * policy is used to determine the order in which upstream servers are selected for querying. Any one of the following values may be specified:<br><p> <br><p> &#42; "Random" picks a random upstream server for each query. &#42; "RoundRobin" picks upstream servers in a round-robin order, moving to the next server for each new query. &#42; "Sequential" tries querying upstream servers in a sequential order until one responds, starting with the first server for each new query.<br><p> <br><p> The default value is "Random"
     */
    @JsonProperty("policy")
    public void setPolicy(String policy) {
        this.policy = policy;
    }

    /**
     * protocolStrategy specifies the protocol to use for upstream DNS requests. Valid values for protocolStrategy are "TCP" and omitted. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is to use the protocol of the original client request. "TCP" specifies that the platform should use TCP for all upstream DNS requests, even if the client request uses UDP. "TCP" is useful for UDP-specific issues such as those created by non-compliant upstream resolvers, but may consume more bandwidth or increase DNS response time. Note that protocolStrategy only affects the protocol of DNS requests that CoreDNS makes to upstream resolvers. It does not affect the protocol of DNS requests between clients and CoreDNS.
     */
    @JsonProperty("protocolStrategy")
    public String getProtocolStrategy() {
        return protocolStrategy;
    }

    /**
     * protocolStrategy specifies the protocol to use for upstream DNS requests. Valid values for protocolStrategy are "TCP" and omitted. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default is to use the protocol of the original client request. "TCP" specifies that the platform should use TCP for all upstream DNS requests, even if the client request uses UDP. "TCP" is useful for UDP-specific issues such as those created by non-compliant upstream resolvers, but may consume more bandwidth or increase DNS response time. Note that protocolStrategy only affects the protocol of DNS requests that CoreDNS makes to upstream resolvers. It does not affect the protocol of DNS requests between clients and CoreDNS.
     */
    @JsonProperty("protocolStrategy")
    public void setProtocolStrategy(String protocolStrategy) {
        this.protocolStrategy = protocolStrategy;
    }

    /**
     * ForwardPlugin defines a schema for configuring the CoreDNS forward plugin.
     */
    @JsonProperty("transportConfig")
    public DNSTransportConfig getTransportConfig() {
        return transportConfig;
    }

    /**
     * ForwardPlugin defines a schema for configuring the CoreDNS forward plugin.
     */
    @JsonProperty("transportConfig")
    public void setTransportConfig(DNSTransportConfig transportConfig) {
        this.transportConfig = transportConfig;
    }

    /**
     * upstreams is a list of resolvers to forward name queries for subdomains of Zones. Each instance of CoreDNS performs health checking of Upstreams. When a healthy upstream returns an error during the exchange, another resolver is tried from Upstreams. The Upstreams are selected in the order specified in Policy. Each upstream is represented by an IP address or IP:port if the upstream listens on a port other than 53.<br><p> <br><p> A maximum of 15 upstreams is allowed per ForwardPlugin.
     */
    @JsonProperty("upstreams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUpstreams() {
        return upstreams;
    }

    /**
     * upstreams is a list of resolvers to forward name queries for subdomains of Zones. Each instance of CoreDNS performs health checking of Upstreams. When a healthy upstream returns an error during the exchange, another resolver is tried from Upstreams. The Upstreams are selected in the order specified in Policy. Each upstream is represented by an IP address or IP:port if the upstream listens on a port other than 53.<br><p> <br><p> A maximum of 15 upstreams is allowed per ForwardPlugin.
     */
    @JsonProperty("upstreams")
    public void setUpstreams(List<String> upstreams) {
        this.upstreams = upstreams;
    }

    @JsonIgnore
    public ForwardPluginBuilder edit() {
        return new ForwardPluginBuilder(this);
    }

    @JsonIgnore
    public ForwardPluginBuilder toBuilder() {
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
