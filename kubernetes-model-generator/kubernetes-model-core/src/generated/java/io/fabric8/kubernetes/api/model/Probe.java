
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
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
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class Probe implements KubernetesResource
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
     * 
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

    @JsonProperty("exec")
    public ExecAction getExec() {
        return exec;
    }

    @JsonProperty("exec")
    public void setExec(ExecAction exec) {
        this.exec = exec;
    }

    @JsonProperty("failureThreshold")
    public Integer getFailureThreshold() {
        return failureThreshold;
    }

    @JsonProperty("failureThreshold")
    public void setFailureThreshold(Integer failureThreshold) {
        this.failureThreshold = failureThreshold;
    }

    @JsonProperty("grpc")
    public GRPCAction getGrpc() {
        return grpc;
    }

    @JsonProperty("grpc")
    public void setGrpc(GRPCAction grpc) {
        this.grpc = grpc;
    }

    @JsonProperty("httpGet")
    public HTTPGetAction getHttpGet() {
        return httpGet;
    }

    @JsonProperty("httpGet")
    public void setHttpGet(HTTPGetAction httpGet) {
        this.httpGet = httpGet;
    }

    @JsonProperty("initialDelaySeconds")
    public Integer getInitialDelaySeconds() {
        return initialDelaySeconds;
    }

    @JsonProperty("initialDelaySeconds")
    public void setInitialDelaySeconds(Integer initialDelaySeconds) {
        this.initialDelaySeconds = initialDelaySeconds;
    }

    @JsonProperty("periodSeconds")
    public Integer getPeriodSeconds() {
        return periodSeconds;
    }

    @JsonProperty("periodSeconds")
    public void setPeriodSeconds(Integer periodSeconds) {
        this.periodSeconds = periodSeconds;
    }

    @JsonProperty("successThreshold")
    public Integer getSuccessThreshold() {
        return successThreshold;
    }

    @JsonProperty("successThreshold")
    public void setSuccessThreshold(Integer successThreshold) {
        this.successThreshold = successThreshold;
    }

    @JsonProperty("tcpSocket")
    public TCPSocketAction getTcpSocket() {
        return tcpSocket;
    }

    @JsonProperty("tcpSocket")
    public void setTcpSocket(TCPSocketAction tcpSocket) {
        this.tcpSocket = tcpSocket;
    }

    @JsonProperty("terminationGracePeriodSeconds")
    public Long getTerminationGracePeriodSeconds() {
        return terminationGracePeriodSeconds;
    }

    @JsonProperty("terminationGracePeriodSeconds")
    public void setTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    }

    @JsonProperty("timeoutSeconds")
    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Integer timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
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
