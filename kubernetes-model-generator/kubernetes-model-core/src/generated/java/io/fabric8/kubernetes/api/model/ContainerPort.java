
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
 * ContainerPort represents a network port in a single container.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerPort",
    "hostIP",
    "hostPort",
    "name",
    "protocol"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ContainerPort implements Editable<ContainerPortBuilder>, KubernetesResource
{

    @JsonProperty("containerPort")
    private Integer containerPort;
    @JsonProperty("hostIP")
    private String hostIP;
    @JsonProperty("hostPort")
    private Integer hostPort;
    @JsonProperty("name")
    private String name;
    @JsonProperty("protocol")
    private String protocol;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ContainerPort() {
    }

    public ContainerPort(Integer containerPort, String hostIP, Integer hostPort, String name, String protocol) {
        super();
        this.containerPort = containerPort;
        this.hostIP = hostIP;
        this.hostPort = hostPort;
        this.name = name;
        this.protocol = protocol;
    }

    /**
     * Number of port to expose on the pod's IP address. This must be a valid port number, 0 &lt; x &lt; 65536.
     */
    @JsonProperty("containerPort")
    public Integer getContainerPort() {
        return containerPort;
    }

    /**
     * Number of port to expose on the pod's IP address. This must be a valid port number, 0 &lt; x &lt; 65536.
     */
    @JsonProperty("containerPort")
    public void setContainerPort(Integer containerPort) {
        this.containerPort = containerPort;
    }

    /**
     * What host IP to bind the external port to.
     */
    @JsonProperty("hostIP")
    public String getHostIP() {
        return hostIP;
    }

    /**
     * What host IP to bind the external port to.
     */
    @JsonProperty("hostIP")
    public void setHostIP(String hostIP) {
        this.hostIP = hostIP;
    }

    /**
     * Number of port to expose on the host. If specified, this must be a valid port number, 0 &lt; x &lt; 65536. If HostNetwork is specified, this must match ContainerPort. Most containers do not need this.
     */
    @JsonProperty("hostPort")
    public Integer getHostPort() {
        return hostPort;
    }

    /**
     * Number of port to expose on the host. If specified, this must be a valid port number, 0 &lt; x &lt; 65536. If HostNetwork is specified, this must match ContainerPort. Most containers do not need this.
     */
    @JsonProperty("hostPort")
    public void setHostPort(Integer hostPort) {
        this.hostPort = hostPort;
    }

    /**
     * If specified, this must be an IANA_SVC_NAME and unique within the pod. Each named port in a pod must have a unique name. Name for the port that can be referred to by services.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * If specified, this must be an IANA_SVC_NAME and unique within the pod. Each named port in a pod must have a unique name. Name for the port that can be referred to by services.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Protocol for port. Must be UDP, TCP, or SCTP. Defaults to "TCP".
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * Protocol for port. Must be UDP, TCP, or SCTP. Defaults to "TCP".
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @JsonIgnore
    public ContainerPortBuilder edit() {
        return new ContainerPortBuilder(this);
    }

    @JsonIgnore
    public ContainerPortBuilder toBuilder() {
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
        if (!(o instanceof ContainerPort)) {
            return false;
        }
        ContainerPort other = (ContainerPort) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerPort = this.getContainerPort();
        Object other$containerPort = other.getContainerPort();
        if (this$containerPort == null ? other$containerPort != null : !this$containerPort.equals(other$containerPort)) {
            return false;
        }
        Object this$hostIP = this.getHostIP();
        Object other$hostIP = other.getHostIP();
        if (this$hostIP == null ? other$hostIP != null : !this$hostIP.equals(other$hostIP)) {
            return false;
        }
        Object this$hostPort = this.getHostPort();
        Object other$hostPort = other.getHostPort();
        if (this$hostPort == null ? other$hostPort != null : !this$hostPort.equals(other$hostPort)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$protocol = this.getProtocol();
        Object other$protocol = other.getProtocol();
        if (this$protocol == null ? other$protocol != null : !this$protocol.equals(other$protocol)) {
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
        return other instanceof ContainerPort;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerPort = this.getContainerPort();
        result = result * prime + ($containerPort == null ? 43 : $containerPort.hashCode());
        Object $hostIP = this.getHostIP();
        result = result * prime + ($hostIP == null ? 43 : $hostIP.hashCode());
        Object $hostPort = this.getHostPort();
        result = result * prime + ($hostPort == null ? 43 : $hostPort.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $protocol = this.getProtocol();
        result = result * prime + ($protocol == null ? 43 : $protocol.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ContainerPort(" + "containerPort=" + this.getContainerPort() + ", hostIP=" + this.getHostIP() + ", hostPort=" + this.getHostPort() + ", name=" + this.getName() + ", protocol=" + this.getProtocol() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
