
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
 * TCPSocketAction describes an action based on opening a socket
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "host",
    "port"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class TCPSocketAction implements Editable<TCPSocketActionBuilder>, KubernetesResource
{

    @JsonProperty("host")
    private String host;
    @JsonProperty("port")
    private IntOrString port;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TCPSocketAction() {
    }

    public TCPSocketAction(String host, IntOrString port) {
        super();
        this.host = host;
        this.port = port;
    }

    /**
     * Optional: Host name to connect to, defaults to the pod IP.
     */
    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    /**
     * Optional: Host name to connect to, defaults to the pod IP.
     */
    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * TCPSocketAction describes an action based on opening a socket
     */
    @JsonProperty("port")
    public IntOrString getPort() {
        return port;
    }

    /**
     * TCPSocketAction describes an action based on opening a socket
     */
    @JsonProperty("port")
    public void setPort(IntOrString port) {
        this.port = port;
    }

    @JsonIgnore
    public TCPSocketActionBuilder edit() {
        return new TCPSocketActionBuilder(this);
    }

    @JsonIgnore
    public TCPSocketActionBuilder toBuilder() {
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
        if (!(o instanceof TCPSocketAction)) {
            return false;
        }
        TCPSocketAction other = (TCPSocketAction) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$host = this.getHost();
        Object other$host = other.getHost();
        if (this$host == null ? other$host != null : !this$host.equals(other$host)) {
            return false;
        }
        Object this$port = this.getPort();
        Object other$port = other.getPort();
        if (this$port == null ? other$port != null : !this$port.equals(other$port)) {
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
        return other instanceof TCPSocketAction;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $host = this.getHost();
        result = result * prime + ($host == null ? 43 : $host.hashCode());
        Object $port = this.getPort();
        result = result * prime + ($port == null ? 43 : $port.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TCPSocketAction(" + "host=" + this.getHost() + ", port=" + this.getPort() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
