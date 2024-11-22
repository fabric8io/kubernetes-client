
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientFinTimeout",
    "clientTimeout",
    "connectTimeout",
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
public class IngressControllerTuningOptions implements Editable<IngressControllerTuningOptionsBuilder> , KubernetesResource
{

    @JsonProperty("clientFinTimeout")
    private String clientFinTimeout;
    @JsonProperty("clientTimeout")
    private String clientTimeout;
    @JsonProperty("connectTimeout")
    private String connectTimeout;
    @JsonProperty("headerBufferBytes")
    private Integer headerBufferBytes;
    @JsonProperty("headerBufferMaxRewriteBytes")
    private Integer headerBufferMaxRewriteBytes;
    @JsonProperty("healthCheckInterval")
    private String healthCheckInterval;
    @JsonProperty("maxConnections")
    private Integer maxConnections;
    @JsonProperty("reloadInterval")
    private String reloadInterval;
    @JsonProperty("serverFinTimeout")
    private String serverFinTimeout;
    @JsonProperty("serverTimeout")
    private String serverTimeout;
    @JsonProperty("threadCount")
    private Integer threadCount;
    @JsonProperty("tlsInspectDelay")
    private String tlsInspectDelay;
    @JsonProperty("tunnelTimeout")
    private String tunnelTimeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressControllerTuningOptions() {
    }

    public IngressControllerTuningOptions(String clientFinTimeout, String clientTimeout, String connectTimeout, Integer headerBufferBytes, Integer headerBufferMaxRewriteBytes, String healthCheckInterval, Integer maxConnections, String reloadInterval, String serverFinTimeout, String serverTimeout, Integer threadCount, String tlsInspectDelay, String tunnelTimeout) {
        super();
        this.clientFinTimeout = clientFinTimeout;
        this.clientTimeout = clientTimeout;
        this.connectTimeout = connectTimeout;
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
    public String getClientFinTimeout() {
        return clientFinTimeout;
    }

    @JsonProperty("clientFinTimeout")
    public void setClientFinTimeout(String clientFinTimeout) {
        this.clientFinTimeout = clientFinTimeout;
    }

    @JsonProperty("clientTimeout")
    public String getClientTimeout() {
        return clientTimeout;
    }

    @JsonProperty("clientTimeout")
    public void setClientTimeout(String clientTimeout) {
        this.clientTimeout = clientTimeout;
    }

    @JsonProperty("connectTimeout")
    public String getConnectTimeout() {
        return connectTimeout;
    }

    @JsonProperty("connectTimeout")
    public void setConnectTimeout(String connectTimeout) {
        this.connectTimeout = connectTimeout;
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
    public String getHealthCheckInterval() {
        return healthCheckInterval;
    }

    @JsonProperty("healthCheckInterval")
    public void setHealthCheckInterval(String healthCheckInterval) {
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
    public String getReloadInterval() {
        return reloadInterval;
    }

    @JsonProperty("reloadInterval")
    public void setReloadInterval(String reloadInterval) {
        this.reloadInterval = reloadInterval;
    }

    @JsonProperty("serverFinTimeout")
    public String getServerFinTimeout() {
        return serverFinTimeout;
    }

    @JsonProperty("serverFinTimeout")
    public void setServerFinTimeout(String serverFinTimeout) {
        this.serverFinTimeout = serverFinTimeout;
    }

    @JsonProperty("serverTimeout")
    public String getServerTimeout() {
        return serverTimeout;
    }

    @JsonProperty("serverTimeout")
    public void setServerTimeout(String serverTimeout) {
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
    public String getTlsInspectDelay() {
        return tlsInspectDelay;
    }

    @JsonProperty("tlsInspectDelay")
    public void setTlsInspectDelay(String tlsInspectDelay) {
        this.tlsInspectDelay = tlsInspectDelay;
    }

    @JsonProperty("tunnelTimeout")
    public String getTunnelTimeout() {
        return tunnelTimeout;
    }

    @JsonProperty("tunnelTimeout")
    public void setTunnelTimeout(String tunnelTimeout) {
        this.tunnelTimeout = tunnelTimeout;
    }

    @JsonIgnore
    public IngressControllerTuningOptionsBuilder edit() {
        return new IngressControllerTuningOptionsBuilder(this);
    }

    @JsonIgnore
    public IngressControllerTuningOptionsBuilder toBuilder() {
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
