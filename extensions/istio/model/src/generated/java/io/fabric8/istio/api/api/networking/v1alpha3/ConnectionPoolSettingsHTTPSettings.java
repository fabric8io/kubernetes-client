
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
 * Settings applicable to HTTP1.1/HTTP2/GRPC connections.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "h2UpgradePolicy",
    "http1MaxPendingRequests",
    "http2MaxRequests",
    "idleTimeout",
    "maxConcurrentStreams",
    "maxRequestsPerConnection",
    "maxRetries",
    "useClientProtocol"
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
public class ConnectionPoolSettingsHTTPSettings implements Editable<ConnectionPoolSettingsHTTPSettingsBuilder>, KubernetesResource
{

    @JsonProperty("h2UpgradePolicy")
    private ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy h2UpgradePolicy;
    @JsonProperty("http1MaxPendingRequests")
    private Integer http1MaxPendingRequests;
    @JsonProperty("http2MaxRequests")
    private Integer http2MaxRequests;
    @JsonProperty("idleTimeout")
    private String idleTimeout;
    @JsonProperty("maxConcurrentStreams")
    private Integer maxConcurrentStreams;
    @JsonProperty("maxRequestsPerConnection")
    private Integer maxRequestsPerConnection;
    @JsonProperty("maxRetries")
    private Integer maxRetries;
    @JsonProperty("useClientProtocol")
    private Boolean useClientProtocol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConnectionPoolSettingsHTTPSettings() {
    }

    public ConnectionPoolSettingsHTTPSettings(ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy h2UpgradePolicy, Integer http1MaxPendingRequests, Integer http2MaxRequests, String idleTimeout, Integer maxConcurrentStreams, Integer maxRequestsPerConnection, Integer maxRetries, Boolean useClientProtocol) {
        super();
        this.h2UpgradePolicy = h2UpgradePolicy;
        this.http1MaxPendingRequests = http1MaxPendingRequests;
        this.http2MaxRequests = http2MaxRequests;
        this.idleTimeout = idleTimeout;
        this.maxConcurrentStreams = maxConcurrentStreams;
        this.maxRequestsPerConnection = maxRequestsPerConnection;
        this.maxRetries = maxRetries;
        this.useClientProtocol = useClientProtocol;
    }

    /**
     * Settings applicable to HTTP1.1/HTTP2/GRPC connections.
     */
    @JsonProperty("h2UpgradePolicy")
    public ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy getH2UpgradePolicy() {
        return h2UpgradePolicy;
    }

    /**
     * Settings applicable to HTTP1.1/HTTP2/GRPC connections.
     */
    @JsonProperty("h2UpgradePolicy")
    public void setH2UpgradePolicy(ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy h2UpgradePolicy) {
        this.h2UpgradePolicy = h2UpgradePolicy;
    }

    /**
     * Maximum number of requests that will be queued while waiting for a ready connection pool connection. Default 2^32-1. Refer to [Envoy Circuit Breaking](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/circuit_breaking) under which conditions a new connection is created for HTTP/2. Please note that this is applicable to both HTTP/1.1 and HTTP/2.
     */
    @JsonProperty("http1MaxPendingRequests")
    public Integer getHttp1MaxPendingRequests() {
        return http1MaxPendingRequests;
    }

    /**
     * Maximum number of requests that will be queued while waiting for a ready connection pool connection. Default 2^32-1. Refer to [Envoy Circuit Breaking](https://www.envoyproxy.io/docs/envoy/latest/intro/arch_overview/upstream/circuit_breaking) under which conditions a new connection is created for HTTP/2. Please note that this is applicable to both HTTP/1.1 and HTTP/2.
     */
    @JsonProperty("http1MaxPendingRequests")
    public void setHttp1MaxPendingRequests(Integer http1MaxPendingRequests) {
        this.http1MaxPendingRequests = http1MaxPendingRequests;
    }

    /**
     * Maximum number of active requests to a destination. Default 2^32-1. Please note that this is applicable to both HTTP/1.1 and HTTP/2.
     */
    @JsonProperty("http2MaxRequests")
    public Integer getHttp2MaxRequests() {
        return http2MaxRequests;
    }

    /**
     * Maximum number of active requests to a destination. Default 2^32-1. Please note that this is applicable to both HTTP/1.1 and HTTP/2.
     */
    @JsonProperty("http2MaxRequests")
    public void setHttp2MaxRequests(Integer http2MaxRequests) {
        this.http2MaxRequests = http2MaxRequests;
    }

    /**
     * Settings applicable to HTTP1.1/HTTP2/GRPC connections.
     */
    @JsonProperty("idleTimeout")
    public String getIdleTimeout() {
        return idleTimeout;
    }

    /**
     * Settings applicable to HTTP1.1/HTTP2/GRPC connections.
     */
    @JsonProperty("idleTimeout")
    public void setIdleTimeout(String idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    /**
     * The maximum number of concurrent streams allowed for a peer on one HTTP/2 connection. Defaults to 2^31-1.
     */
    @JsonProperty("maxConcurrentStreams")
    public Integer getMaxConcurrentStreams() {
        return maxConcurrentStreams;
    }

    /**
     * The maximum number of concurrent streams allowed for a peer on one HTTP/2 connection. Defaults to 2^31-1.
     */
    @JsonProperty("maxConcurrentStreams")
    public void setMaxConcurrentStreams(Integer maxConcurrentStreams) {
        this.maxConcurrentStreams = maxConcurrentStreams;
    }

    /**
     * Maximum number of requests per connection to a backend. Setting this parameter to 1 disables keep alive. Default 0, meaning "unlimited", up to 2^29.
     */
    @JsonProperty("maxRequestsPerConnection")
    public Integer getMaxRequestsPerConnection() {
        return maxRequestsPerConnection;
    }

    /**
     * Maximum number of requests per connection to a backend. Setting this parameter to 1 disables keep alive. Default 0, meaning "unlimited", up to 2^29.
     */
    @JsonProperty("maxRequestsPerConnection")
    public void setMaxRequestsPerConnection(Integer maxRequestsPerConnection) {
        this.maxRequestsPerConnection = maxRequestsPerConnection;
    }

    /**
     * Maximum number of retries that can be outstanding to all hosts in a cluster at a given time. Defaults to 2^32-1.
     */
    @JsonProperty("maxRetries")
    public Integer getMaxRetries() {
        return maxRetries;
    }

    /**
     * Maximum number of retries that can be outstanding to all hosts in a cluster at a given time. Defaults to 2^32-1.
     */
    @JsonProperty("maxRetries")
    public void setMaxRetries(Integer maxRetries) {
        this.maxRetries = maxRetries;
    }

    /**
     * If set to true, client protocol will be preserved while initiating connection to backend. Note that when this is set to true, `h2UpgradePolicy` will be ineffective i.e. the client connections will not be upgraded to http2.
     */
    @JsonProperty("useClientProtocol")
    public Boolean getUseClientProtocol() {
        return useClientProtocol;
    }

    /**
     * If set to true, client protocol will be preserved while initiating connection to backend. Note that when this is set to true, `h2UpgradePolicy` will be ineffective i.e. the client connections will not be upgraded to http2.
     */
    @JsonProperty("useClientProtocol")
    public void setUseClientProtocol(Boolean useClientProtocol) {
        this.useClientProtocol = useClientProtocol;
    }

    @JsonIgnore
    public ConnectionPoolSettingsHTTPSettingsBuilder edit() {
        return new ConnectionPoolSettingsHTTPSettingsBuilder(this);
    }

    @JsonIgnore
    public ConnectionPoolSettingsHTTPSettingsBuilder toBuilder() {
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
        if (!(o instanceof ConnectionPoolSettingsHTTPSettings)) {
            return false;
        }
        ConnectionPoolSettingsHTTPSettings other = (ConnectionPoolSettingsHTTPSettings) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$h2UpgradePolicy = this.getH2UpgradePolicy();
        Object other$h2UpgradePolicy = other.getH2UpgradePolicy();
        if (this$h2UpgradePolicy == null ? other$h2UpgradePolicy != null : !this$h2UpgradePolicy.equals(other$h2UpgradePolicy)) {
            return false;
        }
        Object this$http1MaxPendingRequests = this.getHttp1MaxPendingRequests();
        Object other$http1MaxPendingRequests = other.getHttp1MaxPendingRequests();
        if (this$http1MaxPendingRequests == null ? other$http1MaxPendingRequests != null : !this$http1MaxPendingRequests.equals(other$http1MaxPendingRequests)) {
            return false;
        }
        Object this$http2MaxRequests = this.getHttp2MaxRequests();
        Object other$http2MaxRequests = other.getHttp2MaxRequests();
        if (this$http2MaxRequests == null ? other$http2MaxRequests != null : !this$http2MaxRequests.equals(other$http2MaxRequests)) {
            return false;
        }
        Object this$idleTimeout = this.getIdleTimeout();
        Object other$idleTimeout = other.getIdleTimeout();
        if (this$idleTimeout == null ? other$idleTimeout != null : !this$idleTimeout.equals(other$idleTimeout)) {
            return false;
        }
        Object this$maxConcurrentStreams = this.getMaxConcurrentStreams();
        Object other$maxConcurrentStreams = other.getMaxConcurrentStreams();
        if (this$maxConcurrentStreams == null ? other$maxConcurrentStreams != null : !this$maxConcurrentStreams.equals(other$maxConcurrentStreams)) {
            return false;
        }
        Object this$maxRequestsPerConnection = this.getMaxRequestsPerConnection();
        Object other$maxRequestsPerConnection = other.getMaxRequestsPerConnection();
        if (this$maxRequestsPerConnection == null ? other$maxRequestsPerConnection != null : !this$maxRequestsPerConnection.equals(other$maxRequestsPerConnection)) {
            return false;
        }
        Object this$maxRetries = this.getMaxRetries();
        Object other$maxRetries = other.getMaxRetries();
        if (this$maxRetries == null ? other$maxRetries != null : !this$maxRetries.equals(other$maxRetries)) {
            return false;
        }
        Object this$useClientProtocol = this.getUseClientProtocol();
        Object other$useClientProtocol = other.getUseClientProtocol();
        if (this$useClientProtocol == null ? other$useClientProtocol != null : !this$useClientProtocol.equals(other$useClientProtocol)) {
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
        return other instanceof ConnectionPoolSettingsHTTPSettings;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $h2UpgradePolicy = this.getH2UpgradePolicy();
        result = result * prime + ($h2UpgradePolicy == null ? 43 : $h2UpgradePolicy.hashCode());
        Object $http1MaxPendingRequests = this.getHttp1MaxPendingRequests();
        result = result * prime + ($http1MaxPendingRequests == null ? 43 : $http1MaxPendingRequests.hashCode());
        Object $http2MaxRequests = this.getHttp2MaxRequests();
        result = result * prime + ($http2MaxRequests == null ? 43 : $http2MaxRequests.hashCode());
        Object $idleTimeout = this.getIdleTimeout();
        result = result * prime + ($idleTimeout == null ? 43 : $idleTimeout.hashCode());
        Object $maxConcurrentStreams = this.getMaxConcurrentStreams();
        result = result * prime + ($maxConcurrentStreams == null ? 43 : $maxConcurrentStreams.hashCode());
        Object $maxRequestsPerConnection = this.getMaxRequestsPerConnection();
        result = result * prime + ($maxRequestsPerConnection == null ? 43 : $maxRequestsPerConnection.hashCode());
        Object $maxRetries = this.getMaxRetries();
        result = result * prime + ($maxRetries == null ? 43 : $maxRetries.hashCode());
        Object $useClientProtocol = this.getUseClientProtocol();
        result = result * prime + ($useClientProtocol == null ? 43 : $useClientProtocol.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConnectionPoolSettingsHTTPSettings(" + "h2UpgradePolicy=" + this.getH2UpgradePolicy() + ", http1MaxPendingRequests=" + this.getHttp1MaxPendingRequests() + ", http2MaxRequests=" + this.getHttp2MaxRequests() + ", idleTimeout=" + this.getIdleTimeout() + ", maxConcurrentStreams=" + this.getMaxConcurrentStreams() + ", maxRequestsPerConnection=" + this.getMaxRequestsPerConnection() + ", maxRetries=" + this.getMaxRetries() + ", useClientProtocol=" + this.getUseClientProtocol() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
