
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
 * ServerAddressByClientCIDR helps the client to determine the server address that they should use, depending on the clientCIDR that they match.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientCIDR",
    "serverAddress"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ServerAddressByClientCIDR implements Editable<ServerAddressByClientCIDRBuilder>, KubernetesResource
{

    @JsonProperty("clientCIDR")
    private String clientCIDR;
    @JsonProperty("serverAddress")
    private String serverAddress;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ServerAddressByClientCIDR() {
    }

    public ServerAddressByClientCIDR(String clientCIDR, String serverAddress) {
        super();
        this.clientCIDR = clientCIDR;
        this.serverAddress = serverAddress;
    }

    /**
     * The CIDR with which clients can match their IP to figure out the server address that they should use.
     */
    @JsonProperty("clientCIDR")
    public String getClientCIDR() {
        return clientCIDR;
    }

    /**
     * The CIDR with which clients can match their IP to figure out the server address that they should use.
     */
    @JsonProperty("clientCIDR")
    public void setClientCIDR(String clientCIDR) {
        this.clientCIDR = clientCIDR;
    }

    /**
     * Address of this server, suitable for a client that matches the above CIDR. This can be a hostname, hostname:port, IP or IP:port.
     */
    @JsonProperty("serverAddress")
    public String getServerAddress() {
        return serverAddress;
    }

    /**
     * Address of this server, suitable for a client that matches the above CIDR. This can be a hostname, hostname:port, IP or IP:port.
     */
    @JsonProperty("serverAddress")
    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    @JsonIgnore
    public ServerAddressByClientCIDRBuilder edit() {
        return new ServerAddressByClientCIDRBuilder(this);
    }

    @JsonIgnore
    public ServerAddressByClientCIDRBuilder toBuilder() {
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
        if (!(o instanceof ServerAddressByClientCIDR)) {
            return false;
        }
        ServerAddressByClientCIDR other = (ServerAddressByClientCIDR) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clientCIDR = this.getClientCIDR();
        Object other$clientCIDR = other.getClientCIDR();
        if (this$clientCIDR == null ? other$clientCIDR != null : !this$clientCIDR.equals(other$clientCIDR)) {
            return false;
        }
        Object this$serverAddress = this.getServerAddress();
        Object other$serverAddress = other.getServerAddress();
        if (this$serverAddress == null ? other$serverAddress != null : !this$serverAddress.equals(other$serverAddress)) {
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
        return other instanceof ServerAddressByClientCIDR;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clientCIDR = this.getClientCIDR();
        result = result * prime + ($clientCIDR == null ? 43 : $clientCIDR.hashCode());
        Object $serverAddress = this.getServerAddress();
        result = result * prime + ($serverAddress == null ? 43 : $serverAddress.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ServerAddressByClientCIDR(" + "clientCIDR=" + this.getClientCIDR() + ", serverAddress=" + this.getServerAddress() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
