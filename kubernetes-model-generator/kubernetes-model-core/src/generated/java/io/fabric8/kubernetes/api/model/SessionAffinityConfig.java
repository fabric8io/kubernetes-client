
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
 * SessionAffinityConfig represents the configurations of session affinity.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientIP"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SessionAffinityConfig implements Editable<SessionAffinityConfigBuilder>, KubernetesResource
{

    @JsonProperty("clientIP")
    private ClientIPConfig clientIP;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SessionAffinityConfig() {
    }

    public SessionAffinityConfig(ClientIPConfig clientIP) {
        super();
        this.clientIP = clientIP;
    }

    /**
     * SessionAffinityConfig represents the configurations of session affinity.
     */
    @JsonProperty("clientIP")
    public ClientIPConfig getClientIP() {
        return clientIP;
    }

    /**
     * SessionAffinityConfig represents the configurations of session affinity.
     */
    @JsonProperty("clientIP")
    public void setClientIP(ClientIPConfig clientIP) {
        this.clientIP = clientIP;
    }

    @JsonIgnore
    public SessionAffinityConfigBuilder edit() {
        return new SessionAffinityConfigBuilder(this);
    }

    @JsonIgnore
    public SessionAffinityConfigBuilder toBuilder() {
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
        if (!(o instanceof SessionAffinityConfig)) {
            return false;
        }
        SessionAffinityConfig other = (SessionAffinityConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clientIP = this.getClientIP();
        Object other$clientIP = other.getClientIP();
        if (this$clientIP == null ? other$clientIP != null : !this$clientIP.equals(other$clientIP)) {
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
        return other instanceof SessionAffinityConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clientIP = this.getClientIP();
        result = result * prime + ($clientIP == null ? 43 : $clientIP.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SessionAffinityConfig(" + "clientIP=" + this.getClientIP() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
