
package io.fabric8.openshift.api.model.operator.v1;

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
 * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientFinTimeout",
    "clientTimeout",
    "connectTimeout",
    "headerBufferBytes",
    "headerBufferMaxRewriteBytes",
    "healthCheckInterval",
    "httpKeepAliveTimeout",
    "maxConnections",
    "reloadInterval",
    "serverFinTimeout",
    "serverTimeout",
    "threadCount",
    "tlsInspectDelay",
    "tunnelTimeout"
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
public class IngressControllerTuningOptions implements Editable<IngressControllerTuningOptionsBuilder>, KubernetesResource
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
    @JsonProperty("httpKeepAliveTimeout")
    private String httpKeepAliveTimeout;
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
     */
    public IngressControllerTuningOptions() {
    }

    public IngressControllerTuningOptions(String clientFinTimeout, String clientTimeout, String connectTimeout, Integer headerBufferBytes, Integer headerBufferMaxRewriteBytes, String healthCheckInterval, String httpKeepAliveTimeout, Integer maxConnections, String reloadInterval, String serverFinTimeout, String serverTimeout, Integer threadCount, String tlsInspectDelay, String tunnelTimeout) {
        super();
        this.clientFinTimeout = clientFinTimeout;
        this.clientTimeout = clientTimeout;
        this.connectTimeout = connectTimeout;
        this.headerBufferBytes = headerBufferBytes;
        this.headerBufferMaxRewriteBytes = headerBufferMaxRewriteBytes;
        this.healthCheckInterval = healthCheckInterval;
        this.httpKeepAliveTimeout = httpKeepAliveTimeout;
        this.maxConnections = maxConnections;
        this.reloadInterval = reloadInterval;
        this.serverFinTimeout = serverFinTimeout;
        this.serverTimeout = serverTimeout;
        this.threadCount = threadCount;
        this.tlsInspectDelay = tlsInspectDelay;
        this.tunnelTimeout = tunnelTimeout;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("clientFinTimeout")
    public String getClientFinTimeout() {
        return clientFinTimeout;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("clientFinTimeout")
    public void setClientFinTimeout(String clientFinTimeout) {
        this.clientFinTimeout = clientFinTimeout;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("clientTimeout")
    public String getClientTimeout() {
        return clientTimeout;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("clientTimeout")
    public void setClientTimeout(String clientTimeout) {
        this.clientTimeout = clientTimeout;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("connectTimeout")
    public String getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("connectTimeout")
    public void setConnectTimeout(String connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    /**
     * headerBufferBytes describes how much memory should be reserved (in bytes) for IngressController connection sessions. Note that this value must be at least 16384 if HTTP/2 is enabled for the IngressController (https://tools.ietf.org/html/rfc7540). If this field is empty, the IngressController will use a default value of 32768 bytes.<br><p> <br><p> Setting this field is generally not recommended as headerBufferBytes values that are too small may break the IngressController and headerBufferBytes values that are too large could cause the IngressController to use significantly more memory than necessary.
     */
    @JsonProperty("headerBufferBytes")
    public Integer getHeaderBufferBytes() {
        return headerBufferBytes;
    }

    /**
     * headerBufferBytes describes how much memory should be reserved (in bytes) for IngressController connection sessions. Note that this value must be at least 16384 if HTTP/2 is enabled for the IngressController (https://tools.ietf.org/html/rfc7540). If this field is empty, the IngressController will use a default value of 32768 bytes.<br><p> <br><p> Setting this field is generally not recommended as headerBufferBytes values that are too small may break the IngressController and headerBufferBytes values that are too large could cause the IngressController to use significantly more memory than necessary.
     */
    @JsonProperty("headerBufferBytes")
    public void setHeaderBufferBytes(Integer headerBufferBytes) {
        this.headerBufferBytes = headerBufferBytes;
    }

    /**
     * headerBufferMaxRewriteBytes describes how much memory should be reserved (in bytes) from headerBufferBytes for HTTP header rewriting and appending for IngressController connection sessions. Note that incoming HTTP requests will be limited to (headerBufferBytes - headerBufferMaxRewriteBytes) bytes, meaning headerBufferBytes must be greater than headerBufferMaxRewriteBytes. If this field is empty, the IngressController will use a default value of 8192 bytes.<br><p> <br><p> Setting this field is generally not recommended as headerBufferMaxRewriteBytes values that are too small may break the IngressController and headerBufferMaxRewriteBytes values that are too large could cause the IngressController to use significantly more memory than necessary.
     */
    @JsonProperty("headerBufferMaxRewriteBytes")
    public Integer getHeaderBufferMaxRewriteBytes() {
        return headerBufferMaxRewriteBytes;
    }

    /**
     * headerBufferMaxRewriteBytes describes how much memory should be reserved (in bytes) from headerBufferBytes for HTTP header rewriting and appending for IngressController connection sessions. Note that incoming HTTP requests will be limited to (headerBufferBytes - headerBufferMaxRewriteBytes) bytes, meaning headerBufferBytes must be greater than headerBufferMaxRewriteBytes. If this field is empty, the IngressController will use a default value of 8192 bytes.<br><p> <br><p> Setting this field is generally not recommended as headerBufferMaxRewriteBytes values that are too small may break the IngressController and headerBufferMaxRewriteBytes values that are too large could cause the IngressController to use significantly more memory than necessary.
     */
    @JsonProperty("headerBufferMaxRewriteBytes")
    public void setHeaderBufferMaxRewriteBytes(Integer headerBufferMaxRewriteBytes) {
        this.headerBufferMaxRewriteBytes = headerBufferMaxRewriteBytes;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("healthCheckInterval")
    public String getHealthCheckInterval() {
        return healthCheckInterval;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("healthCheckInterval")
    public void setHealthCheckInterval(String healthCheckInterval) {
        this.healthCheckInterval = healthCheckInterval;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("httpKeepAliveTimeout")
    public String getHttpKeepAliveTimeout() {
        return httpKeepAliveTimeout;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("httpKeepAliveTimeout")
    public void setHttpKeepAliveTimeout(String httpKeepAliveTimeout) {
        this.httpKeepAliveTimeout = httpKeepAliveTimeout;
    }

    /**
     * maxConnections defines the maximum number of simultaneous connections that can be established per HAProxy process. Increasing this value allows each ingress controller pod to handle more connections but at the cost of additional system resources being consumed.<br><p> <br><p> Permitted values are: empty, 0, -1, and the range 2000-2000000.<br><p> <br><p> If this field is empty or 0, the IngressController will use the default value of 50000, but the default is subject to change in future releases.<br><p> <br><p> If the value is -1 then HAProxy will dynamically compute a maximum value based on the available ulimits in the running container. Selecting -1 (i.e., auto) will result in a large value being computed (~520000 on OpenShift &gt;=4.10 clusters) and therefore each HAProxy process will incur significant memory usage compared to the current default of 50000.<br><p> <br><p> Setting a value that is greater than the current operating system limit will prevent the HAProxy process from starting.<br><p> <br><p> If you choose a discrete value (e.g., 750000) and the router pod is migrated to a new node, there's no guarantee that that new node has identical ulimits configured. In such a scenario the pod would fail to start. If you have nodes with different ulimits configured (e.g., different tuned profiles) and you choose a discrete value then the guidance is to use -1 and let the value be computed dynamically at runtime.<br><p> <br><p> You can monitor memory usage for router containers with the following metric: 'container_memory_working_set_bytes{container="router",namespace="openshift-ingress"}'.<br><p> <br><p> You can monitor memory usage of individual HAProxy processes in router containers with the following metric: 'container_memory_working_set_bytes{container="router",namespace="openshift-ingress"}/container_processes{container="router",namespace="openshift-ingress"}'.
     */
    @JsonProperty("maxConnections")
    public Integer getMaxConnections() {
        return maxConnections;
    }

    /**
     * maxConnections defines the maximum number of simultaneous connections that can be established per HAProxy process. Increasing this value allows each ingress controller pod to handle more connections but at the cost of additional system resources being consumed.<br><p> <br><p> Permitted values are: empty, 0, -1, and the range 2000-2000000.<br><p> <br><p> If this field is empty or 0, the IngressController will use the default value of 50000, but the default is subject to change in future releases.<br><p> <br><p> If the value is -1 then HAProxy will dynamically compute a maximum value based on the available ulimits in the running container. Selecting -1 (i.e., auto) will result in a large value being computed (~520000 on OpenShift &gt;=4.10 clusters) and therefore each HAProxy process will incur significant memory usage compared to the current default of 50000.<br><p> <br><p> Setting a value that is greater than the current operating system limit will prevent the HAProxy process from starting.<br><p> <br><p> If you choose a discrete value (e.g., 750000) and the router pod is migrated to a new node, there's no guarantee that that new node has identical ulimits configured. In such a scenario the pod would fail to start. If you have nodes with different ulimits configured (e.g., different tuned profiles) and you choose a discrete value then the guidance is to use -1 and let the value be computed dynamically at runtime.<br><p> <br><p> You can monitor memory usage for router containers with the following metric: 'container_memory_working_set_bytes{container="router",namespace="openshift-ingress"}'.<br><p> <br><p> You can monitor memory usage of individual HAProxy processes in router containers with the following metric: 'container_memory_working_set_bytes{container="router",namespace="openshift-ingress"}/container_processes{container="router",namespace="openshift-ingress"}'.
     */
    @JsonProperty("maxConnections")
    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("reloadInterval")
    public String getReloadInterval() {
        return reloadInterval;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("reloadInterval")
    public void setReloadInterval(String reloadInterval) {
        this.reloadInterval = reloadInterval;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("serverFinTimeout")
    public String getServerFinTimeout() {
        return serverFinTimeout;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("serverFinTimeout")
    public void setServerFinTimeout(String serverFinTimeout) {
        this.serverFinTimeout = serverFinTimeout;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("serverTimeout")
    public String getServerTimeout() {
        return serverTimeout;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("serverTimeout")
    public void setServerTimeout(String serverTimeout) {
        this.serverTimeout = serverTimeout;
    }

    /**
     * threadCount defines the number of threads created per HAProxy process. Creating more threads allows each ingress controller pod to handle more connections, at the cost of more system resources being used. HAProxy currently supports up to 64 threads. If this field is empty, the IngressController will use the default value.  The current default is 4 threads, but this may change in future releases.<br><p> <br><p> Setting this field is generally not recommended. Increasing the number of HAProxy threads allows ingress controller pods to utilize more CPU time under load, potentially starving other pods if set too high. Reducing the number of threads may cause the ingress controller to perform poorly.
     */
    @JsonProperty("threadCount")
    public Integer getThreadCount() {
        return threadCount;
    }

    /**
     * threadCount defines the number of threads created per HAProxy process. Creating more threads allows each ingress controller pod to handle more connections, at the cost of more system resources being used. HAProxy currently supports up to 64 threads. If this field is empty, the IngressController will use the default value.  The current default is 4 threads, but this may change in future releases.<br><p> <br><p> Setting this field is generally not recommended. Increasing the number of HAProxy threads allows ingress controller pods to utilize more CPU time under load, potentially starving other pods if set too high. Reducing the number of threads may cause the ingress controller to perform poorly.
     */
    @JsonProperty("threadCount")
    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("tlsInspectDelay")
    public String getTlsInspectDelay() {
        return tlsInspectDelay;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("tlsInspectDelay")
    public void setTlsInspectDelay(String tlsInspectDelay) {
        this.tlsInspectDelay = tlsInspectDelay;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
    @JsonProperty("tunnelTimeout")
    public String getTunnelTimeout() {
        return tunnelTimeout;
    }

    /**
     * IngressControllerTuningOptions specifies options for tuning the performance of ingress controller pods
     */
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
        if (!(o instanceof IngressControllerTuningOptions)) {
            return false;
        }
        IngressControllerTuningOptions other = (IngressControllerTuningOptions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clientFinTimeout = this.getClientFinTimeout();
        Object other$clientFinTimeout = other.getClientFinTimeout();
        if (this$clientFinTimeout == null ? other$clientFinTimeout != null : !this$clientFinTimeout.equals(other$clientFinTimeout)) {
            return false;
        }
        Object this$clientTimeout = this.getClientTimeout();
        Object other$clientTimeout = other.getClientTimeout();
        if (this$clientTimeout == null ? other$clientTimeout != null : !this$clientTimeout.equals(other$clientTimeout)) {
            return false;
        }
        Object this$connectTimeout = this.getConnectTimeout();
        Object other$connectTimeout = other.getConnectTimeout();
        if (this$connectTimeout == null ? other$connectTimeout != null : !this$connectTimeout.equals(other$connectTimeout)) {
            return false;
        }
        Object this$headerBufferBytes = this.getHeaderBufferBytes();
        Object other$headerBufferBytes = other.getHeaderBufferBytes();
        if (this$headerBufferBytes == null ? other$headerBufferBytes != null : !this$headerBufferBytes.equals(other$headerBufferBytes)) {
            return false;
        }
        Object this$headerBufferMaxRewriteBytes = this.getHeaderBufferMaxRewriteBytes();
        Object other$headerBufferMaxRewriteBytes = other.getHeaderBufferMaxRewriteBytes();
        if (this$headerBufferMaxRewriteBytes == null ? other$headerBufferMaxRewriteBytes != null : !this$headerBufferMaxRewriteBytes.equals(other$headerBufferMaxRewriteBytes)) {
            return false;
        }
        Object this$healthCheckInterval = this.getHealthCheckInterval();
        Object other$healthCheckInterval = other.getHealthCheckInterval();
        if (this$healthCheckInterval == null ? other$healthCheckInterval != null : !this$healthCheckInterval.equals(other$healthCheckInterval)) {
            return false;
        }
        Object this$httpKeepAliveTimeout = this.getHttpKeepAliveTimeout();
        Object other$httpKeepAliveTimeout = other.getHttpKeepAliveTimeout();
        if (this$httpKeepAliveTimeout == null ? other$httpKeepAliveTimeout != null : !this$httpKeepAliveTimeout.equals(other$httpKeepAliveTimeout)) {
            return false;
        }
        Object this$maxConnections = this.getMaxConnections();
        Object other$maxConnections = other.getMaxConnections();
        if (this$maxConnections == null ? other$maxConnections != null : !this$maxConnections.equals(other$maxConnections)) {
            return false;
        }
        Object this$reloadInterval = this.getReloadInterval();
        Object other$reloadInterval = other.getReloadInterval();
        if (this$reloadInterval == null ? other$reloadInterval != null : !this$reloadInterval.equals(other$reloadInterval)) {
            return false;
        }
        Object this$serverFinTimeout = this.getServerFinTimeout();
        Object other$serverFinTimeout = other.getServerFinTimeout();
        if (this$serverFinTimeout == null ? other$serverFinTimeout != null : !this$serverFinTimeout.equals(other$serverFinTimeout)) {
            return false;
        }
        Object this$serverTimeout = this.getServerTimeout();
        Object other$serverTimeout = other.getServerTimeout();
        if (this$serverTimeout == null ? other$serverTimeout != null : !this$serverTimeout.equals(other$serverTimeout)) {
            return false;
        }
        Object this$threadCount = this.getThreadCount();
        Object other$threadCount = other.getThreadCount();
        if (this$threadCount == null ? other$threadCount != null : !this$threadCount.equals(other$threadCount)) {
            return false;
        }
        Object this$tlsInspectDelay = this.getTlsInspectDelay();
        Object other$tlsInspectDelay = other.getTlsInspectDelay();
        if (this$tlsInspectDelay == null ? other$tlsInspectDelay != null : !this$tlsInspectDelay.equals(other$tlsInspectDelay)) {
            return false;
        }
        Object this$tunnelTimeout = this.getTunnelTimeout();
        Object other$tunnelTimeout = other.getTunnelTimeout();
        if (this$tunnelTimeout == null ? other$tunnelTimeout != null : !this$tunnelTimeout.equals(other$tunnelTimeout)) {
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
        return other instanceof IngressControllerTuningOptions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clientFinTimeout = this.getClientFinTimeout();
        result = result * prime + ($clientFinTimeout == null ? 43 : $clientFinTimeout.hashCode());
        Object $clientTimeout = this.getClientTimeout();
        result = result * prime + ($clientTimeout == null ? 43 : $clientTimeout.hashCode());
        Object $connectTimeout = this.getConnectTimeout();
        result = result * prime + ($connectTimeout == null ? 43 : $connectTimeout.hashCode());
        Object $headerBufferBytes = this.getHeaderBufferBytes();
        result = result * prime + ($headerBufferBytes == null ? 43 : $headerBufferBytes.hashCode());
        Object $headerBufferMaxRewriteBytes = this.getHeaderBufferMaxRewriteBytes();
        result = result * prime + ($headerBufferMaxRewriteBytes == null ? 43 : $headerBufferMaxRewriteBytes.hashCode());
        Object $healthCheckInterval = this.getHealthCheckInterval();
        result = result * prime + ($healthCheckInterval == null ? 43 : $healthCheckInterval.hashCode());
        Object $httpKeepAliveTimeout = this.getHttpKeepAliveTimeout();
        result = result * prime + ($httpKeepAliveTimeout == null ? 43 : $httpKeepAliveTimeout.hashCode());
        Object $maxConnections = this.getMaxConnections();
        result = result * prime + ($maxConnections == null ? 43 : $maxConnections.hashCode());
        Object $reloadInterval = this.getReloadInterval();
        result = result * prime + ($reloadInterval == null ? 43 : $reloadInterval.hashCode());
        Object $serverFinTimeout = this.getServerFinTimeout();
        result = result * prime + ($serverFinTimeout == null ? 43 : $serverFinTimeout.hashCode());
        Object $serverTimeout = this.getServerTimeout();
        result = result * prime + ($serverTimeout == null ? 43 : $serverTimeout.hashCode());
        Object $threadCount = this.getThreadCount();
        result = result * prime + ($threadCount == null ? 43 : $threadCount.hashCode());
        Object $tlsInspectDelay = this.getTlsInspectDelay();
        result = result * prime + ($tlsInspectDelay == null ? 43 : $tlsInspectDelay.hashCode());
        Object $tunnelTimeout = this.getTunnelTimeout();
        result = result * prime + ($tunnelTimeout == null ? 43 : $tunnelTimeout.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IngressControllerTuningOptions(" + "clientFinTimeout=" + this.getClientFinTimeout() + ", clientTimeout=" + this.getClientTimeout() + ", connectTimeout=" + this.getConnectTimeout() + ", headerBufferBytes=" + this.getHeaderBufferBytes() + ", headerBufferMaxRewriteBytes=" + this.getHeaderBufferMaxRewriteBytes() + ", healthCheckInterval=" + this.getHealthCheckInterval() + ", httpKeepAliveTimeout=" + this.getHttpKeepAliveTimeout() + ", maxConnections=" + this.getMaxConnections() + ", reloadInterval=" + this.getReloadInterval() + ", serverFinTimeout=" + this.getServerFinTimeout() + ", serverTimeout=" + this.getServerTimeout() + ", threadCount=" + this.getThreadCount() + ", tlsInspectDelay=" + this.getTlsInspectDelay() + ", tunnelTimeout=" + this.getTunnelTimeout() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
