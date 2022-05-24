
package io.fabric8.istio.api.networking.v1alpha3;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "h2UpgradePolicy",
    "http1MaxPendingRequests",
    "http2MaxRequests",
    "idleTimeout",
    "maxRequestsPerConnection",
    "maxRetries",
    "useClientProtocol"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class ConnectionPoolSettingsHTTPSettings implements KubernetesResource
{

    @JsonProperty("h2UpgradePolicy")
    private ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy h2UpgradePolicy;
    @JsonProperty("http1MaxPendingRequests")
    private Integer http1MaxPendingRequests;
    @JsonProperty("http2MaxRequests")
    private Integer http2MaxRequests;
    @JsonProperty("idleTimeout")
    private String idleTimeout;
    @JsonProperty("maxRequestsPerConnection")
    private Integer maxRequestsPerConnection;
    @JsonProperty("maxRetries")
    private Integer maxRetries;
    @JsonProperty("useClientProtocol")
    private Boolean useClientProtocol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ConnectionPoolSettingsHTTPSettings() {
    }

    /**
     * 
     * @param http2MaxRequests
     * @param maxRetries
     * @param useClientProtocol
     * @param h2UpgradePolicy
     * @param idleTimeout
     * @param http1MaxPendingRequests
     * @param maxRequestsPerConnection
     */
    public ConnectionPoolSettingsHTTPSettings(ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy h2UpgradePolicy, Integer http1MaxPendingRequests, Integer http2MaxRequests, String idleTimeout, Integer maxRequestsPerConnection, Integer maxRetries, Boolean useClientProtocol) {
        super();
        this.h2UpgradePolicy = h2UpgradePolicy;
        this.http1MaxPendingRequests = http1MaxPendingRequests;
        this.http2MaxRequests = http2MaxRequests;
        this.idleTimeout = idleTimeout;
        this.maxRequestsPerConnection = maxRequestsPerConnection;
        this.maxRetries = maxRetries;
        this.useClientProtocol = useClientProtocol;
    }

    @JsonProperty("h2UpgradePolicy")
    public ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy getH2UpgradePolicy() {
        return h2UpgradePolicy;
    }

    @JsonProperty("h2UpgradePolicy")
    public void setH2UpgradePolicy(ConnectionPoolSettingsHTTPSettingsH2UpgradePolicy h2UpgradePolicy) {
        this.h2UpgradePolicy = h2UpgradePolicy;
    }

    @JsonProperty("http1MaxPendingRequests")
    public Integer getHttp1MaxPendingRequests() {
        return http1MaxPendingRequests;
    }

    @JsonProperty("http1MaxPendingRequests")
    public void setHttp1MaxPendingRequests(Integer http1MaxPendingRequests) {
        this.http1MaxPendingRequests = http1MaxPendingRequests;
    }

    @JsonProperty("http2MaxRequests")
    public Integer getHttp2MaxRequests() {
        return http2MaxRequests;
    }

    @JsonProperty("http2MaxRequests")
    public void setHttp2MaxRequests(Integer http2MaxRequests) {
        this.http2MaxRequests = http2MaxRequests;
    }

    @JsonProperty("idleTimeout")
    public String getIdleTimeout() {
        return idleTimeout;
    }

    @JsonProperty("idleTimeout")
    public void setIdleTimeout(String idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    @JsonProperty("maxRequestsPerConnection")
    public Integer getMaxRequestsPerConnection() {
        return maxRequestsPerConnection;
    }

    @JsonProperty("maxRequestsPerConnection")
    public void setMaxRequestsPerConnection(Integer maxRequestsPerConnection) {
        this.maxRequestsPerConnection = maxRequestsPerConnection;
    }

    @JsonProperty("maxRetries")
    public Integer getMaxRetries() {
        return maxRetries;
    }

    @JsonProperty("maxRetries")
    public void setMaxRetries(Integer maxRetries) {
        this.maxRetries = maxRetries;
    }

    @JsonProperty("useClientProtocol")
    public Boolean getUseClientProtocol() {
        return useClientProtocol;
    }

    @JsonProperty("useClientProtocol")
    public void setUseClientProtocol(Boolean useClientProtocol) {
        this.useClientProtocol = useClientProtocol;
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
