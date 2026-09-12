
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * Probe describes a health check to be performed against a container to determine whether it is alive or ready to receive traffic.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exec",
    "failureThreshold",
    "grpc",
    "httpGet",
    "initialDelaySeconds",
    "periodSeconds",
    "successThreshold",
    "tcpSocket",
    "terminationGracePeriodSeconds",
    "timeoutSeconds"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Probe implements Editable<ProbeBuilder>, KubernetesResource
{

    @JsonProperty("exec")
    private ExecAction exec;
    @JsonProperty("failureThreshold")
    private Integer failureThreshold;
    @JsonProperty("grpc")
    private GRPCAction grpc;
    @JsonProperty("httpGet")
    private HTTPGetAction httpGet;
    @JsonProperty("initialDelaySeconds")
    private Integer initialDelaySeconds;
    @JsonProperty("periodSeconds")
    private Integer periodSeconds;
    @JsonProperty("successThreshold")
    private Integer successThreshold;
    @JsonProperty("tcpSocket")
    private TCPSocketAction tcpSocket;
    @JsonProperty("terminationGracePeriodSeconds")
    private Long terminationGracePeriodSeconds;
    @JsonProperty("timeoutSeconds")
    private Integer timeoutSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Probe() {
    }

    public Probe(ExecAction exec, Integer failureThreshold, GRPCAction grpc, HTTPGetAction httpGet, Integer initialDelaySeconds, Integer periodSeconds, Integer successThreshold, TCPSocketAction tcpSocket, Long terminationGracePeriodSeconds, Integer timeoutSeconds) {
        super();
        this.exec = exec;
        this.failureThreshold = failureThreshold;
        this.grpc = grpc;
        this.httpGet = httpGet;
        this.initialDelaySeconds = initialDelaySeconds;
        this.periodSeconds = periodSeconds;
        this.successThreshold = successThreshold;
        this.tcpSocket = tcpSocket;
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
        this.timeoutSeconds = timeoutSeconds;
    }

    /**
     * Probe describes a health check to be performed against a container to determine whether it is alive or ready to receive traffic.
     */
    @JsonProperty("exec")
    public ExecAction getExec() {
        return exec;
    }

    /**
     * Probe describes a health check to be performed against a container to determine whether it is alive or ready to receive traffic.
     */
    @JsonProperty("exec")
    public void setExec(ExecAction exec) {
        this.exec = exec;
    }

    /**
     * Minimum consecutive failures for the probe to be considered failed after having succeeded. Defaults to 3. Minimum value is 1.
     */
    @JsonProperty("failureThreshold")
    public Integer getFailureThreshold() {
        return failureThreshold;
    }

    /**
     * Minimum consecutive failures for the probe to be considered failed after having succeeded. Defaults to 3. Minimum value is 1.
     */
    @JsonProperty("failureThreshold")
    public void setFailureThreshold(Integer failureThreshold) {
        this.failureThreshold = failureThreshold;
    }

    /**
     * Probe describes a health check to be performed against a container to determine whether it is alive or ready to receive traffic.
     */
    @JsonProperty("grpc")
    public GRPCAction getGrpc() {
        return grpc;
    }

    /**
     * Probe describes a health check to be performed against a container to determine whether it is alive or ready to receive traffic.
     */
    @JsonProperty("grpc")
    public void setGrpc(GRPCAction grpc) {
        this.grpc = grpc;
    }

    /**
     * Probe describes a health check to be performed against a container to determine whether it is alive or ready to receive traffic.
     */
    @JsonProperty("httpGet")
    public HTTPGetAction getHttpGet() {
        return httpGet;
    }

    /**
     * Probe describes a health check to be performed against a container to determine whether it is alive or ready to receive traffic.
     */
    @JsonProperty("httpGet")
    public void setHttpGet(HTTPGetAction httpGet) {
        this.httpGet = httpGet;
    }

    /**
     * Number of seconds after the container has started before liveness probes are initiated. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#container-probes
     */
    @JsonProperty("initialDelaySeconds")
    public Integer getInitialDelaySeconds() {
        return initialDelaySeconds;
    }

    /**
     * Number of seconds after the container has started before liveness probes are initiated. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#container-probes
     */
    @JsonProperty("initialDelaySeconds")
    public void setInitialDelaySeconds(Integer initialDelaySeconds) {
        this.initialDelaySeconds = initialDelaySeconds;
    }

    /**
     * How often (in seconds) to perform the probe. Default to 10 seconds. Minimum value is 1.
     */
    @JsonProperty("periodSeconds")
    public Integer getPeriodSeconds() {
        return periodSeconds;
    }

    /**
     * How often (in seconds) to perform the probe. Default to 10 seconds. Minimum value is 1.
     */
    @JsonProperty("periodSeconds")
    public void setPeriodSeconds(Integer periodSeconds) {
        this.periodSeconds = periodSeconds;
    }

    /**
     * Minimum consecutive successes for the probe to be considered successful after having failed. Defaults to 1. Must be 1 for liveness and startup. Minimum value is 1.
     */
    @JsonProperty("successThreshold")
    public Integer getSuccessThreshold() {
        return successThreshold;
    }

    /**
     * Minimum consecutive successes for the probe to be considered successful after having failed. Defaults to 1. Must be 1 for liveness and startup. Minimum value is 1.
     */
    @JsonProperty("successThreshold")
    public void setSuccessThreshold(Integer successThreshold) {
        this.successThreshold = successThreshold;
    }

    /**
     * Probe describes a health check to be performed against a container to determine whether it is alive or ready to receive traffic.
     */
    @JsonProperty("tcpSocket")
    public TCPSocketAction getTcpSocket() {
        return tcpSocket;
    }

    /**
     * Probe describes a health check to be performed against a container to determine whether it is alive or ready to receive traffic.
     */
    @JsonProperty("tcpSocket")
    public void setTcpSocket(TCPSocketAction tcpSocket) {
        this.tcpSocket = tcpSocket;
    }

    /**
     * Optional duration in seconds the pod needs to terminate gracefully upon probe failure. The grace period is the duration in seconds after the processes running in the pod are sent a termination signal and the time when the processes are forcibly halted with a kill signal. Set this value longer than the expected cleanup time for your process. If this value is nil, the pod's terminationGracePeriodSeconds will be used. Otherwise, this value overrides the value provided by the pod spec. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down). This is a beta field and requires enabling ProbeTerminationGracePeriod feature gate. Minimum value is 1. spec.terminationGracePeriodSeconds is used if unset.
     */
    @JsonProperty("terminationGracePeriodSeconds")
    public Long getTerminationGracePeriodSeconds() {
        return terminationGracePeriodSeconds;
    }

    /**
     * Optional duration in seconds the pod needs to terminate gracefully upon probe failure. The grace period is the duration in seconds after the processes running in the pod are sent a termination signal and the time when the processes are forcibly halted with a kill signal. Set this value longer than the expected cleanup time for your process. If this value is nil, the pod's terminationGracePeriodSeconds will be used. Otherwise, this value overrides the value provided by the pod spec. Value must be non-negative integer. The value zero indicates stop immediately via the kill signal (no opportunity to shut down). This is a beta field and requires enabling ProbeTerminationGracePeriod feature gate. Minimum value is 1. spec.terminationGracePeriodSeconds is used if unset.
     */
    @JsonProperty("terminationGracePeriodSeconds")
    public void setTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    }

    /**
     * Number of seconds after which the probe times out. Defaults to 1 second. Minimum value is 1. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#container-probes
     */
    @JsonProperty("timeoutSeconds")
    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    /**
     * Number of seconds after which the probe times out. Defaults to 1 second. Minimum value is 1. More info: https://kubernetes.io/docs/concepts/workloads/pods/pod-lifecycle#container-probes
     */
    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Integer timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    @JsonIgnore
    public ProbeBuilder edit() {
        return new ProbeBuilder(this);
    }

    @JsonIgnore
    public ProbeBuilder toBuilder() {
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
        if (!(o instanceof Probe)) {
            return false;
        }
        Probe other = (Probe) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$exec = this.getExec();
        Object other$exec = other.getExec();
        if (this$exec == null ? other$exec != null : !this$exec.equals(other$exec)) {
            return false;
        }
        Object this$failureThreshold = this.getFailureThreshold();
        Object other$failureThreshold = other.getFailureThreshold();
        if (this$failureThreshold == null ? other$failureThreshold != null : !this$failureThreshold.equals(other$failureThreshold)) {
            return false;
        }
        Object this$grpc = this.getGrpc();
        Object other$grpc = other.getGrpc();
        if (this$grpc == null ? other$grpc != null : !this$grpc.equals(other$grpc)) {
            return false;
        }
        Object this$httpGet = this.getHttpGet();
        Object other$httpGet = other.getHttpGet();
        if (this$httpGet == null ? other$httpGet != null : !this$httpGet.equals(other$httpGet)) {
            return false;
        }
        Object this$initialDelaySeconds = this.getInitialDelaySeconds();
        Object other$initialDelaySeconds = other.getInitialDelaySeconds();
        if (this$initialDelaySeconds == null ? other$initialDelaySeconds != null : !this$initialDelaySeconds.equals(other$initialDelaySeconds)) {
            return false;
        }
        Object this$periodSeconds = this.getPeriodSeconds();
        Object other$periodSeconds = other.getPeriodSeconds();
        if (this$periodSeconds == null ? other$periodSeconds != null : !this$periodSeconds.equals(other$periodSeconds)) {
            return false;
        }
        Object this$successThreshold = this.getSuccessThreshold();
        Object other$successThreshold = other.getSuccessThreshold();
        if (this$successThreshold == null ? other$successThreshold != null : !this$successThreshold.equals(other$successThreshold)) {
            return false;
        }
        Object this$tcpSocket = this.getTcpSocket();
        Object other$tcpSocket = other.getTcpSocket();
        if (this$tcpSocket == null ? other$tcpSocket != null : !this$tcpSocket.equals(other$tcpSocket)) {
            return false;
        }
        Object this$terminationGracePeriodSeconds = this.getTerminationGracePeriodSeconds();
        Object other$terminationGracePeriodSeconds = other.getTerminationGracePeriodSeconds();
        if (this$terminationGracePeriodSeconds == null ? other$terminationGracePeriodSeconds != null : !this$terminationGracePeriodSeconds.equals(other$terminationGracePeriodSeconds)) {
            return false;
        }
        Object this$timeoutSeconds = this.getTimeoutSeconds();
        Object other$timeoutSeconds = other.getTimeoutSeconds();
        if (this$timeoutSeconds == null ? other$timeoutSeconds != null : !this$timeoutSeconds.equals(other$timeoutSeconds)) {
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
        return other instanceof Probe;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $exec = this.getExec();
        result = result * prime + ($exec == null ? 43 : $exec.hashCode());
        Object $failureThreshold = this.getFailureThreshold();
        result = result * prime + ($failureThreshold == null ? 43 : $failureThreshold.hashCode());
        Object $grpc = this.getGrpc();
        result = result * prime + ($grpc == null ? 43 : $grpc.hashCode());
        Object $httpGet = this.getHttpGet();
        result = result * prime + ($httpGet == null ? 43 : $httpGet.hashCode());
        Object $initialDelaySeconds = this.getInitialDelaySeconds();
        result = result * prime + ($initialDelaySeconds == null ? 43 : $initialDelaySeconds.hashCode());
        Object $periodSeconds = this.getPeriodSeconds();
        result = result * prime + ($periodSeconds == null ? 43 : $periodSeconds.hashCode());
        Object $successThreshold = this.getSuccessThreshold();
        result = result * prime + ($successThreshold == null ? 43 : $successThreshold.hashCode());
        Object $tcpSocket = this.getTcpSocket();
        result = result * prime + ($tcpSocket == null ? 43 : $tcpSocket.hashCode());
        Object $terminationGracePeriodSeconds = this.getTerminationGracePeriodSeconds();
        result = result * prime + ($terminationGracePeriodSeconds == null ? 43 : $terminationGracePeriodSeconds.hashCode());
        Object $timeoutSeconds = this.getTimeoutSeconds();
        result = result * prime + ($timeoutSeconds == null ? 43 : $timeoutSeconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Probe(" + "exec=" + this.getExec() + ", failureThreshold=" + this.getFailureThreshold() + ", grpc=" + this.getGrpc() + ", httpGet=" + this.getHttpGet() + ", initialDelaySeconds=" + this.getInitialDelaySeconds() + ", periodSeconds=" + this.getPeriodSeconds() + ", successThreshold=" + this.getSuccessThreshold() + ", tcpSocket=" + this.getTcpSocket() + ", terminationGracePeriodSeconds=" + this.getTerminationGracePeriodSeconds() + ", timeoutSeconds=" + this.getTimeoutSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
