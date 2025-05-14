
package io.fabric8.istio.api.api.networking.v1alpha3;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Traffic policies that apply to specific ports of the service
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectionPool",
    "loadBalancer",
    "outlierDetection",
    "port",
    "tls"
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
public class TrafficPolicyPortTrafficPolicy implements Editable<TrafficPolicyPortTrafficPolicyBuilder>, KubernetesResource
{

    @JsonProperty("connectionPool")
    private ConnectionPoolSettings connectionPool;
    @JsonProperty("loadBalancer")
    private LoadBalancerSettings loadBalancer;
    @JsonProperty("outlierDetection")
    private OutlierDetection outlierDetection;
    @JsonProperty("port")
    private PortSelector port;
    @JsonProperty("tls")
    private ClientTLSSettings tls;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TrafficPolicyPortTrafficPolicy() {
    }

    public TrafficPolicyPortTrafficPolicy(ConnectionPoolSettings connectionPool, LoadBalancerSettings loadBalancer, OutlierDetection outlierDetection, PortSelector port, ClientTLSSettings tls) {
        super();
        this.connectionPool = connectionPool;
        this.loadBalancer = loadBalancer;
        this.outlierDetection = outlierDetection;
        this.port = port;
        this.tls = tls;
    }

    /**
     * Traffic policies that apply to specific ports of the service
     */
    @JsonProperty("connectionPool")
    public ConnectionPoolSettings getConnectionPool() {
        return connectionPool;
    }

    /**
     * Traffic policies that apply to specific ports of the service
     */
    @JsonProperty("connectionPool")
    public void setConnectionPool(ConnectionPoolSettings connectionPool) {
        this.connectionPool = connectionPool;
    }

    /**
     * Traffic policies that apply to specific ports of the service
     */
    @JsonProperty("loadBalancer")
    public LoadBalancerSettings getLoadBalancer() {
        return loadBalancer;
    }

    /**
     * Traffic policies that apply to specific ports of the service
     */
    @JsonProperty("loadBalancer")
    public void setLoadBalancer(LoadBalancerSettings loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    /**
     * Traffic policies that apply to specific ports of the service
     */
    @JsonProperty("outlierDetection")
    public OutlierDetection getOutlierDetection() {
        return outlierDetection;
    }

    /**
     * Traffic policies that apply to specific ports of the service
     */
    @JsonProperty("outlierDetection")
    public void setOutlierDetection(OutlierDetection outlierDetection) {
        this.outlierDetection = outlierDetection;
    }

    /**
     * Traffic policies that apply to specific ports of the service
     */
    @JsonProperty("port")
    public PortSelector getPort() {
        return port;
    }

    /**
     * Traffic policies that apply to specific ports of the service
     */
    @JsonProperty("port")
    public void setPort(PortSelector port) {
        this.port = port;
    }

    /**
     * Traffic policies that apply to specific ports of the service
     */
    @JsonProperty("tls")
    public ClientTLSSettings getTls() {
        return tls;
    }

    /**
     * Traffic policies that apply to specific ports of the service
     */
    @JsonProperty("tls")
    public void setTls(ClientTLSSettings tls) {
        this.tls = tls;
    }

    @JsonIgnore
    public TrafficPolicyPortTrafficPolicyBuilder edit() {
        return new TrafficPolicyPortTrafficPolicyBuilder(this);
    }

    @JsonIgnore
    public TrafficPolicyPortTrafficPolicyBuilder toBuilder() {
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
