
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
    "httpGet",
    "tcpSocket"
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
public class LifecycleHandler implements KubernetesResource
{

    @JsonProperty("exec")
    private ExecAction exec;
    @JsonProperty("httpGet")
    private HTTPGetAction httpGet;
    @JsonProperty("tcpSocket")
    private TCPSocketAction tcpSocket;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LifecycleHandler() {
    }

    public LifecycleHandler(ExecAction exec, HTTPGetAction httpGet, TCPSocketAction tcpSocket) {
        super();
        this.exec = exec;
        this.httpGet = httpGet;
        this.tcpSocket = tcpSocket;
    }

    @JsonProperty("exec")
    public ExecAction getExec() {
        return exec;
    }

    @JsonProperty("exec")
    public void setExec(ExecAction exec) {
        this.exec = exec;
    }

    @JsonProperty("httpGet")
    public HTTPGetAction getHttpGet() {
        return httpGet;
    }

    @JsonProperty("httpGet")
    public void setHttpGet(HTTPGetAction httpGet) {
        this.httpGet = httpGet;
    }

    @JsonProperty("tcpSocket")
    public TCPSocketAction getTcpSocket() {
        return tcpSocket;
    }

    @JsonProperty("tcpSocket")
    public void setTcpSocket(TCPSocketAction tcpSocket) {
        this.tcpSocket = tcpSocket;
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
