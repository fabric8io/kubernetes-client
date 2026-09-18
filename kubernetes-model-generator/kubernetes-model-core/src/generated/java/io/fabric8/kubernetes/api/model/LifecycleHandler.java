
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
 * LifecycleHandler defines a specific action that should be taken in a lifecycle hook. One and only one of the fields, except TCPSocket must be specified.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exec",
    "httpGet",
    "sleep",
    "tcpSocket"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class LifecycleHandler implements Editable<LifecycleHandlerBuilder>, KubernetesResource
{

    @JsonProperty("exec")
    private ExecAction exec;
    @JsonProperty("httpGet")
    private HTTPGetAction httpGet;
    @JsonProperty("sleep")
    private SleepAction sleep;
    @JsonProperty("tcpSocket")
    private TCPSocketAction tcpSocket;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LifecycleHandler() {
    }

    public LifecycleHandler(ExecAction exec, HTTPGetAction httpGet, SleepAction sleep, TCPSocketAction tcpSocket) {
        super();
        this.exec = exec;
        this.httpGet = httpGet;
        this.sleep = sleep;
        this.tcpSocket = tcpSocket;
    }

    /**
     * LifecycleHandler defines a specific action that should be taken in a lifecycle hook. One and only one of the fields, except TCPSocket must be specified.
     */
    @JsonProperty("exec")
    public ExecAction getExec() {
        return exec;
    }

    /**
     * LifecycleHandler defines a specific action that should be taken in a lifecycle hook. One and only one of the fields, except TCPSocket must be specified.
     */
    @JsonProperty("exec")
    public void setExec(ExecAction exec) {
        this.exec = exec;
    }

    /**
     * LifecycleHandler defines a specific action that should be taken in a lifecycle hook. One and only one of the fields, except TCPSocket must be specified.
     */
    @JsonProperty("httpGet")
    public HTTPGetAction getHttpGet() {
        return httpGet;
    }

    /**
     * LifecycleHandler defines a specific action that should be taken in a lifecycle hook. One and only one of the fields, except TCPSocket must be specified.
     */
    @JsonProperty("httpGet")
    public void setHttpGet(HTTPGetAction httpGet) {
        this.httpGet = httpGet;
    }

    /**
     * LifecycleHandler defines a specific action that should be taken in a lifecycle hook. One and only one of the fields, except TCPSocket must be specified.
     */
    @JsonProperty("sleep")
    public SleepAction getSleep() {
        return sleep;
    }

    /**
     * LifecycleHandler defines a specific action that should be taken in a lifecycle hook. One and only one of the fields, except TCPSocket must be specified.
     */
    @JsonProperty("sleep")
    public void setSleep(SleepAction sleep) {
        this.sleep = sleep;
    }

    /**
     * LifecycleHandler defines a specific action that should be taken in a lifecycle hook. One and only one of the fields, except TCPSocket must be specified.
     */
    @JsonProperty("tcpSocket")
    public TCPSocketAction getTcpSocket() {
        return tcpSocket;
    }

    /**
     * LifecycleHandler defines a specific action that should be taken in a lifecycle hook. One and only one of the fields, except TCPSocket must be specified.
     */
    @JsonProperty("tcpSocket")
    public void setTcpSocket(TCPSocketAction tcpSocket) {
        this.tcpSocket = tcpSocket;
    }

    @JsonIgnore
    public LifecycleHandlerBuilder edit() {
        return new LifecycleHandlerBuilder(this);
    }

    @JsonIgnore
    public LifecycleHandlerBuilder toBuilder() {
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
        if (!(o instanceof LifecycleHandler)) {
            return false;
        }
        LifecycleHandler other = (LifecycleHandler) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$exec = this.getExec();
        Object other$exec = other.getExec();
        if (this$exec == null ? other$exec != null : !this$exec.equals(other$exec)) {
            return false;
        }
        Object this$httpGet = this.getHttpGet();
        Object other$httpGet = other.getHttpGet();
        if (this$httpGet == null ? other$httpGet != null : !this$httpGet.equals(other$httpGet)) {
            return false;
        }
        Object this$sleep = this.getSleep();
        Object other$sleep = other.getSleep();
        if (this$sleep == null ? other$sleep != null : !this$sleep.equals(other$sleep)) {
            return false;
        }
        Object this$tcpSocket = this.getTcpSocket();
        Object other$tcpSocket = other.getTcpSocket();
        if (this$tcpSocket == null ? other$tcpSocket != null : !this$tcpSocket.equals(other$tcpSocket)) {
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
        return other instanceof LifecycleHandler;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $exec = this.getExec();
        result = result * prime + ($exec == null ? 43 : $exec.hashCode());
        Object $httpGet = this.getHttpGet();
        result = result * prime + ($httpGet == null ? 43 : $httpGet.hashCode());
        Object $sleep = this.getSleep();
        result = result * prime + ($sleep == null ? 43 : $sleep.hashCode());
        Object $tcpSocket = this.getTcpSocket();
        result = result * prime + ($tcpSocket == null ? 43 : $tcpSocket.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LifecycleHandler(" + "exec=" + this.getExec() + ", httpGet=" + this.getHttpGet() + ", sleep=" + this.getSleep() + ", tcpSocket=" + this.getTcpSocket() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
