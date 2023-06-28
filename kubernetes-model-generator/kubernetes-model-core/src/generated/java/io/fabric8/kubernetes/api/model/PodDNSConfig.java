
package io.fabric8.kubernetes.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    "nameservers",
    "options",
    "searches"
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
public class PodDNSConfig implements KubernetesResource
{

    @JsonProperty("nameservers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> nameservers = new ArrayList<String>();
    @JsonProperty("options")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodDNSConfigOption> options = new ArrayList<PodDNSConfigOption>();
    @JsonProperty("searches")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> searches = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodDNSConfig() {
    }

    public PodDNSConfig(List<String> nameservers, List<PodDNSConfigOption> options, List<String> searches) {
        super();
        this.nameservers = nameservers;
        this.options = options;
        this.searches = searches;
    }

    @JsonProperty("nameservers")
    public List<String> getNameservers() {
        return nameservers;
    }

    @JsonProperty("nameservers")
    public void setNameservers(List<String> nameservers) {
        this.nameservers = nameservers;
    }

    @JsonProperty("options")
    public List<PodDNSConfigOption> getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(List<PodDNSConfigOption> options) {
        this.options = options;
    }

    @JsonProperty("searches")
    public List<String> getSearches() {
        return searches;
    }

    @JsonProperty("searches")
    public void setSearches(List<String> searches) {
        this.searches = searches;
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
