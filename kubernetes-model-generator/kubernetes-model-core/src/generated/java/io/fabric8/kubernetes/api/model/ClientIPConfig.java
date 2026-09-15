
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
 * ClientIPConfig represents the configurations of Client IP based session affinity.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "timeoutSeconds"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ClientIPConfig implements Editable<ClientIPConfigBuilder>, KubernetesResource
{

    @JsonProperty("timeoutSeconds")
    private Integer timeoutSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClientIPConfig() {
    }

    public ClientIPConfig(Integer timeoutSeconds) {
        super();
        this.timeoutSeconds = timeoutSeconds;
    }

    /**
     * timeoutSeconds specifies the seconds of ClientIP type session sticky time. The value must be &gt;0 &amp;&amp; &lt;=86400(for 1 day) if ServiceAffinity == "ClientIP". Default value is 10800(for 3 hours).
     */
    @JsonProperty("timeoutSeconds")
    public Integer getTimeoutSeconds() {
        return timeoutSeconds;
    }

    /**
     * timeoutSeconds specifies the seconds of ClientIP type session sticky time. The value must be &gt;0 &amp;&amp; &lt;=86400(for 1 day) if ServiceAffinity == "ClientIP". Default value is 10800(for 3 hours).
     */
    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Integer timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    @JsonIgnore
    public ClientIPConfigBuilder edit() {
        return new ClientIPConfigBuilder(this);
    }

    @JsonIgnore
    public ClientIPConfigBuilder toBuilder() {
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
        if (!(o instanceof ClientIPConfig)) {
            return false;
        }
        ClientIPConfig other = (ClientIPConfig) o;
        if (!other.canEqual(this)) {
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
        return other instanceof ClientIPConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $timeoutSeconds = this.getTimeoutSeconds();
        result = result * prime + ($timeoutSeconds == null ? 43 : $timeoutSeconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClientIPConfig(" + "timeoutSeconds=" + this.getTimeoutSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
