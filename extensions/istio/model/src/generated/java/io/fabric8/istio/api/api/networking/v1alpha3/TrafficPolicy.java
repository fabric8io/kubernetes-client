
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectionPool",
    "loadBalancer",
    "outlierDetection",
    "portLevelSettings",
    "proxyProtocol",
    "retryBudget",
    "tls",
    "tunnel"
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
public class TrafficPolicy implements Editable<TrafficPolicyBuilder>, KubernetesResource
{

    @JsonProperty("connectionPool")
    private ConnectionPoolSettings connectionPool;
    @JsonProperty("loadBalancer")
    private LoadBalancerSettings loadBalancer;
    @JsonProperty("outlierDetection")
    private OutlierDetection outlierDetection;
    @JsonProperty("portLevelSettings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TrafficPolicyPortTrafficPolicy> portLevelSettings = new ArrayList<>();
    @JsonProperty("proxyProtocol")
    private TrafficPolicyProxyProtocol proxyProtocol;
    @JsonProperty("retryBudget")
    private TrafficPolicyRetryBudget retryBudget;
    @JsonProperty("tls")
    private ClientTLSSettings tls;
    @JsonProperty("tunnel")
    private TrafficPolicyTunnelSettings tunnel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TrafficPolicy() {
    }

    public TrafficPolicy(ConnectionPoolSettings connectionPool, LoadBalancerSettings loadBalancer, OutlierDetection outlierDetection, List<TrafficPolicyPortTrafficPolicy> portLevelSettings, TrafficPolicyProxyProtocol proxyProtocol, TrafficPolicyRetryBudget retryBudget, ClientTLSSettings tls, TrafficPolicyTunnelSettings tunnel) {
        super();
        this.connectionPool = connectionPool;
        this.loadBalancer = loadBalancer;
        this.outlierDetection = outlierDetection;
        this.portLevelSettings = portLevelSettings;
        this.proxyProtocol = proxyProtocol;
        this.retryBudget = retryBudget;
        this.tls = tls;
        this.tunnel = tunnel;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("connectionPool")
    public ConnectionPoolSettings getConnectionPool() {
        return connectionPool;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("connectionPool")
    public void setConnectionPool(ConnectionPoolSettings connectionPool) {
        this.connectionPool = connectionPool;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("loadBalancer")
    public LoadBalancerSettings getLoadBalancer() {
        return loadBalancer;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("loadBalancer")
    public void setLoadBalancer(LoadBalancerSettings loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("outlierDetection")
    public OutlierDetection getOutlierDetection() {
        return outlierDetection;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("outlierDetection")
    public void setOutlierDetection(OutlierDetection outlierDetection) {
        this.outlierDetection = outlierDetection;
    }

    /**
     * Traffic policies specific to individual ports. Note that port level settings will override the destination-level settings. Traffic settings specified at the destination-level will not be inherited when overridden by port-level settings, i.e. default values will be applied to fields omitted in port-level traffic policies.
     */
    @JsonProperty("portLevelSettings")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TrafficPolicyPortTrafficPolicy> getPortLevelSettings() {
        return portLevelSettings;
    }

    /**
     * Traffic policies specific to individual ports. Note that port level settings will override the destination-level settings. Traffic settings specified at the destination-level will not be inherited when overridden by port-level settings, i.e. default values will be applied to fields omitted in port-level traffic policies.
     */
    @JsonProperty("portLevelSettings")
    public void setPortLevelSettings(List<TrafficPolicyPortTrafficPolicy> portLevelSettings) {
        this.portLevelSettings = portLevelSettings;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("proxyProtocol")
    public TrafficPolicyProxyProtocol getProxyProtocol() {
        return proxyProtocol;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("proxyProtocol")
    public void setProxyProtocol(TrafficPolicyProxyProtocol proxyProtocol) {
        this.proxyProtocol = proxyProtocol;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("retryBudget")
    public TrafficPolicyRetryBudget getRetryBudget() {
        return retryBudget;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("retryBudget")
    public void setRetryBudget(TrafficPolicyRetryBudget retryBudget) {
        this.retryBudget = retryBudget;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("tls")
    public ClientTLSSettings getTls() {
        return tls;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("tls")
    public void setTls(ClientTLSSettings tls) {
        this.tls = tls;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("tunnel")
    public TrafficPolicyTunnelSettings getTunnel() {
        return tunnel;
    }

    /**
     * Traffic policies to apply for a specific destination, across all destination ports. See DestinationRule for examples.
     */
    @JsonProperty("tunnel")
    public void setTunnel(TrafficPolicyTunnelSettings tunnel) {
        this.tunnel = tunnel;
    }

    @JsonIgnore
    public TrafficPolicyBuilder edit() {
        return new TrafficPolicyBuilder(this);
    }

    @JsonIgnore
    public TrafficPolicyBuilder toBuilder() {
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
        if (!(o instanceof TrafficPolicy)) {
            return false;
        }
        TrafficPolicy other = (TrafficPolicy) o;
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
        Object this$portLevelSettings = this.getPortLevelSettings();
        Object other$portLevelSettings = other.getPortLevelSettings();
        if (this$portLevelSettings == null ? other$portLevelSettings != null : !this$portLevelSettings.equals(other$portLevelSettings)) {
            return false;
        }
        Object this$proxyProtocol = this.getProxyProtocol();
        Object other$proxyProtocol = other.getProxyProtocol();
        if (this$proxyProtocol == null ? other$proxyProtocol != null : !this$proxyProtocol.equals(other$proxyProtocol)) {
            return false;
        }
        Object this$retryBudget = this.getRetryBudget();
        Object other$retryBudget = other.getRetryBudget();
        if (this$retryBudget == null ? other$retryBudget != null : !this$retryBudget.equals(other$retryBudget)) {
            return false;
        }
        Object this$tls = this.getTls();
        Object other$tls = other.getTls();
        if (this$tls == null ? other$tls != null : !this$tls.equals(other$tls)) {
            return false;
        }
        Object this$tunnel = this.getTunnel();
        Object other$tunnel = other.getTunnel();
        if (this$tunnel == null ? other$tunnel != null : !this$tunnel.equals(other$tunnel)) {
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
        return other instanceof TrafficPolicy;
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
        Object $portLevelSettings = this.getPortLevelSettings();
        result = result * prime + ($portLevelSettings == null ? 43 : $portLevelSettings.hashCode());
        Object $proxyProtocol = this.getProxyProtocol();
        result = result * prime + ($proxyProtocol == null ? 43 : $proxyProtocol.hashCode());
        Object $retryBudget = this.getRetryBudget();
        result = result * prime + ($retryBudget == null ? 43 : $retryBudget.hashCode());
        Object $tls = this.getTls();
        result = result * prime + ($tls == null ? 43 : $tls.hashCode());
        Object $tunnel = this.getTunnel();
        result = result * prime + ($tunnel == null ? 43 : $tunnel.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TrafficPolicy(" + "connectionPool=" + this.getConnectionPool() + ", loadBalancer=" + this.getLoadBalancer() + ", outlierDetection=" + this.getOutlierDetection() + ", portLevelSettings=" + this.getPortLevelSettings() + ", proxyProtocol=" + this.getProxyProtocol() + ", retryBudget=" + this.getRetryBudget() + ", tls=" + this.getTls() + ", tunnel=" + this.getTunnel() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
