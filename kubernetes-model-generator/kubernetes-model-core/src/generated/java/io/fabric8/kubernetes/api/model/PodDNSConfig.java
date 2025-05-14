
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PodDNSConfig defines the DNS parameters of a pod in addition to those generated from DNSPolicy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nameservers",
    "options",
    "searches"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodDNSConfig implements Editable<PodDNSConfigBuilder>, KubernetesResource
{

    @JsonProperty("nameservers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> nameservers = new ArrayList<>();
    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodDNSConfigOption> options = new ArrayList<>();
    @JsonProperty("searches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> searches = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodDNSConfig() {
    }

    public PodDNSConfig(List<String> nameservers, List<PodDNSConfigOption> options, List<String> searches) {
        super();
        this.nameservers = nameservers;
        this.options = options;
        this.searches = searches;
    }

    /**
     * A list of DNS name server IP addresses. This will be appended to the base nameservers generated from DNSPolicy. Duplicated nameservers will be removed.
     */
    @JsonProperty("nameservers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNameservers() {
        return nameservers;
    }

    /**
     * A list of DNS name server IP addresses. This will be appended to the base nameservers generated from DNSPolicy. Duplicated nameservers will be removed.
     */
    @JsonProperty("nameservers")
    public void setNameservers(List<String> nameservers) {
        this.nameservers = nameservers;
    }

    /**
     * A list of DNS resolver options. This will be merged with the base options generated from DNSPolicy. Duplicated entries will be removed. Resolution options given in Options will override those that appear in the base DNSPolicy.
     */
    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodDNSConfigOption> getOptions() {
        return options;
    }

    /**
     * A list of DNS resolver options. This will be merged with the base options generated from DNSPolicy. Duplicated entries will be removed. Resolution options given in Options will override those that appear in the base DNSPolicy.
     */
    @JsonProperty("options")
    public void setOptions(List<PodDNSConfigOption> options) {
        this.options = options;
    }

    /**
     * A list of DNS search domains for host-name lookup. This will be appended to the base search paths generated from DNSPolicy. Duplicated search paths will be removed.
     */
    @JsonProperty("searches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSearches() {
        return searches;
    }

    /**
     * A list of DNS search domains for host-name lookup. This will be appended to the base search paths generated from DNSPolicy. Duplicated search paths will be removed.
     */
    @JsonProperty("searches")
    public void setSearches(List<String> searches) {
        this.searches = searches;
    }

    @JsonIgnore
    public PodDNSConfigBuilder edit() {
        return new PodDNSConfigBuilder(this);
    }

    @JsonIgnore
    public PodDNSConfigBuilder toBuilder() {
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

}
