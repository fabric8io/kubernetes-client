
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
import io.fabric8.kubernetes.api.model.Duration;
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
    "clientFinTimeout",
    "clientTimeout",
    "headerBufferBytes",
    "headerBufferMaxRewriteBytes",
    "healthCheckInterval",
    "maxConnections",
    "reloadInterval",
    "serverFinTimeout",
    "serverTimeout",
    "threadCount",
    "tlsInspectDelay",
    "tunnelTimeout"
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
public class IngressControllerTuningOptions implements KubernetesResource
{

    @JsonProperty("clientFinTimeout")
    private Duration clientFinTimeout;
    @JsonProperty("clientTimeout")
    private Duration clientTimeout;
    @JsonProperty("headerBufferBytes")
    private Integer headerBufferBytes;
    @JsonProperty("headerBufferMaxRewriteBytes")
    private Integer headerBufferMaxRewriteBytes;
    @JsonProperty("healthCheckInterval")
    private Duration healthCheckInterval;
    @JsonProperty("maxConnections")
    private Integer maxConnections;
    @JsonProperty("reloadInterval")
    private Duration reloadInterval;
    @JsonProperty("serverFinTimeout")
    private Duration serverFinTimeout;
    @JsonProperty("serverTimeout")
    private Duration serverTimeout;
    @JsonProperty("threadCount")
    private Integer threadCount;
    @JsonProperty("tlsInspectDelay")
    private Duration tlsInspectDelay;
    @JsonProperty("tunnelTimeout")
    private Duration tunnelTimeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressControllerTuningOptions() {
    }

    public IngressControllerTuningOptions(Duration clientFinTimeout, Duration clientTimeout, Integer headerBufferBytes, Integer headerBufferMaxRewriteBytes, Duration healthCheckInterval, Integer maxConnections, Duration reloadInterval, Duration serverFinTimeout, Duration serverTimeout, Integer threadCount, Duration tlsInspectDelay, Duration tunnelTimeout) {
        super();
        this.clientFinTimeout = clientFinTimeout;
        this.clientTimeout = clientTimeout;
        this.headerBufferBytes = headerBufferBytes;
        this.headerBufferMaxRewriteBytes = headerBufferMaxRewriteBytes;
        this.healthCheckInterval = healthCheckInterval;
        this.maxConnections = maxConnections;
        this.reloadInterval = reloadInterval;
        this.serverFinTimeout = serverFinTimeout;
        this.serverTimeout = serverTimeout;
        this.threadCount = threadCount;
        this.tlsInspectDelay = tlsInspectDelay;
        this.tunnelTimeout = tunnelTimeout;
    }

    @JsonProperty("clientFinTimeout")
    public Duration getClientFinTimeout() {
        return clientFinTimeout;
    }

    @JsonProperty("clientFinTimeout")
    public void setClientFinTimeout(Duration clientFinTimeout) {
        this.clientFinTimeout = clientFinTimeout;
    }

    @JsonProperty("clientTimeout")
    public Duration getClientTimeout() {
        return clientTimeout;
    }

    @JsonProperty("clientTimeout")
    public void setClientTimeout(Duration clientTimeout) {
        this.clientTimeout = clientTimeout;
    }

    @JsonProperty("headerBufferBytes")
    public Integer getHeaderBufferBytes() {
        return headerBufferBytes;
    }

    @JsonProperty("headerBufferBytes")
    public void setHeaderBufferBytes(Integer headerBufferBytes) {
        this.headerBufferBytes = headerBufferBytes;
    }

    @JsonProperty("headerBufferMaxRewriteBytes")
    public Integer getHeaderBufferMaxRewriteBytes() {
        return headerBufferMaxRewriteBytes;
    }

    @JsonProperty("headerBufferMaxRewriteBytes")
    public void setHeaderBufferMaxRewriteBytes(Integer headerBufferMaxRewriteBytes) {
        this.headerBufferMaxRewriteBytes = headerBufferMaxRewriteBytes;
    }

    @JsonProperty("healthCheckInterval")
    public Duration getHealthCheckInterval() {
        return healthCheckInterval;
    }

    @JsonProperty("healthCheckInterval")
    public void setHealthCheckInterval(Duration healthCheckInterval) {
        this.healthCheckInterval = healthCheckInterval;
    }

    @JsonProperty("maxConnections")
    public Integer getMaxConnections() {
        return maxConnections;
    }

    @JsonProperty("maxConnections")
    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    @JsonProperty("reloadInterval")
    public Duration getReloadInterval() {
        return reloadInterval;
    }

    @JsonProperty("reloadInterval")
    public void setReloadInterval(Duration reloadInterval) {
        this.reloadInterval = reloadInterval;
    }

    @JsonProperty("serverFinTimeout")
    public Duration getServerFinTimeout() {
        return serverFinTimeout;
    }

    @JsonProperty("serverFinTimeout")
    public void setServerFinTimeout(Duration serverFinTimeout) {
        this.serverFinTimeout = serverFinTimeout;
    }

    @JsonProperty("serverTimeout")
    public Duration getServerTimeout() {
        return serverTimeout;
    }

    @JsonProperty("serverTimeout")
    public void setServerTimeout(Duration serverTimeout) {
        this.serverTimeout = serverTimeout;
    }

    @JsonProperty("threadCount")
    public Integer getThreadCount() {
        return threadCount;
    }

    @JsonProperty("threadCount")
    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }

    @JsonProperty("tlsInspectDelay")
    public Duration getTlsInspectDelay() {
        return tlsInspectDelay;
    }

    @JsonProperty("tlsInspectDelay")
    public void setTlsInspectDelay(Duration tlsInspectDelay) {
        this.tlsInspectDelay = tlsInspectDelay;
    }

    @JsonProperty("tunnelTimeout")
    public Duration getTunnelTimeout() {
        return tunnelTimeout;
    }

    @JsonProperty("tunnelTimeout")
    public void setTunnelTimeout(Duration tunnelTimeout) {
        this.tunnelTimeout = tunnelTimeout;
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
