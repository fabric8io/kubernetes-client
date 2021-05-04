
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "clientCIDR",
    "serverAddress"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
public class ServerAddressByClientCIDR implements KubernetesResource
{

    @JsonProperty("clientCIDR")
    private String clientCIDR;
    @JsonProperty("serverAddress")
    private String serverAddress;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServerAddressByClientCIDR() {
    }

    /**
     * 
     * @param clientCIDR
     * @param serverAddress
     */
    public ServerAddressByClientCIDR(String clientCIDR, String serverAddress) {
        super();
        this.clientCIDR = clientCIDR;
        this.serverAddress = serverAddress;
    }

    @JsonProperty("clientCIDR")
    public String getClientCIDR() {
        return clientCIDR;
    }

    @JsonProperty("clientCIDR")
    public void setClientCIDR(String clientCIDR) {
        this.clientCIDR = clientCIDR;
    }

    @JsonProperty("serverAddress")
    public String getServerAddress() {
        return serverAddress;
    }

    @JsonProperty("serverAddress")
    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
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
