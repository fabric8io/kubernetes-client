
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * HostAlias holds the mapping between IP and hostnames that will be injected as an entry in the pod's hosts file.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostnames",
    "ip"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class HostAlias implements Editable<HostAliasBuilder>, KubernetesResource
{

    @JsonProperty("hostnames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hostnames = new ArrayList<>();
    @JsonProperty("ip")
    private String ip;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HostAlias() {
    }

    public HostAlias(List<String> hostnames, String ip) {
        super();
        this.hostnames = hostnames;
        this.ip = ip;
    }

    /**
     * Hostnames for the above IP address.
     */
    @JsonProperty("hostnames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getHostnames() {
        return hostnames;
    }

    /**
     * Hostnames for the above IP address.
     */
    @JsonProperty("hostnames")
    public void setHostnames(List<String> hostnames) {
        this.hostnames = hostnames;
    }

    /**
     * IP address of the host file entry.
     */
    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    /**
     * IP address of the host file entry.
     */
    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonIgnore
    public HostAliasBuilder edit() {
        return new HostAliasBuilder(this);
    }

    @JsonIgnore
    public HostAliasBuilder toBuilder() {
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
        if (!(o instanceof HostAlias)) {
            return false;
        }
        HostAlias other = (HostAlias) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hostnames = this.getHostnames();
        Object other$hostnames = other.getHostnames();
        if (this$hostnames == null ? other$hostnames != null : !this$hostnames.equals(other$hostnames)) {
            return false;
        }
        Object this$ip = this.getIp();
        Object other$ip = other.getIp();
        if (this$ip == null ? other$ip != null : !this$ip.equals(other$ip)) {
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
        return other instanceof HostAlias;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hostnames = this.getHostnames();
        result = result * prime + ($hostnames == null ? 43 : $hostnames.hashCode());
        Object $ip = this.getIp();
        result = result * prime + ($ip == null ? 43 : $ip.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HostAlias(" + "hostnames=" + this.getHostnames() + ", ip=" + this.getIp() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
