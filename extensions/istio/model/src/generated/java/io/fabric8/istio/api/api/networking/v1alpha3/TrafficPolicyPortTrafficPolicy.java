
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TrafficPolicyPortTrafficPolicy)) {
            return false;
        }
        TrafficPolicyPortTrafficPolicy other = (TrafficPolicyPortTrafficPolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$connectionPool = this.getConnectionPool();
        Object other$connectionPool = other.getConnectionPool();
        if (this$connectionPool == null ? other$connectionPool != null : !this$connectionPool.equals(other$connectionPool)) {
            return false;
        }
        Object this$loadBalancer = this.getLoadBalancer();
        Object other$loadBalancer = other.getLoadBalancer();
        if (this$loadBalancer == null ? other$loadBalancer != null : !this$loadBalancer.equals(other$loadBalancer)) {
            return false;
        }
        Object this$outlierDetection = this.getOutlierDetection();
        Object other$outlierDetection = other.getOutlierDetection();
        if (this$outlierDetection == null ? other$outlierDetection != null : !this$outlierDetection.equals(other$outlierDetection)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
            return false;
        }
        Object this$tls = this.getTls();
        Object other$tls = other.getTls();
        if (this$tls == null ? other$tls != null : !this$tls.equals(other$tls)) {
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
        return other instanceof TrafficPolicyPortTrafficPolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $connectionPool = this.getConnectionPool();
        result = result * prime + ($connectionPool == null ? 43 : $connectionPool.hashCode());
        Object $loadBalancer = this.getLoadBalancer();
        result = result * prime + ($loadBalancer == null ? 43 : $loadBalancer.hashCode());
        Object $outlierDetection = this.getOutlierDetection();
        result = result * prime + ($outlierDetection == null ? 43 : $outlierDetection.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $tls = this.getTls();
        result = result * prime + ($tls == null ? 43 : $tls.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TrafficPolicyPortTrafficPolicy(" + "connectionPool=" + this.getConnectionPool() + ", loadBalancer=" + this.getLoadBalancer() + ", outlierDetection=" + this.getOutlierDetection() + ", port=" + this.getPort() + ", tls=" + this.getTls() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
