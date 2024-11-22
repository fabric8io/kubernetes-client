
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "addresses",
    "notReadyAddresses",
    "ports"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class EndpointSubset implements Editable<EndpointSubsetBuilder> , KubernetesResource
{

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EndpointAddress> addresses = new ArrayList<>();
    @JsonProperty("notReadyAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EndpointAddress> notReadyAddresses = new ArrayList<>();
    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EndpointPort> ports = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EndpointSubset() {
    }

    public EndpointSubset(List<EndpointAddress> addresses, List<EndpointAddress> notReadyAddresses, List<EndpointPort> ports) {
        super();
        this.addresses = addresses;
        this.notReadyAddresses = notReadyAddresses;
        this.ports = ports;
    }

    @JsonProperty("addresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EndpointAddress> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<EndpointAddress> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("notReadyAddresses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EndpointAddress> getNotReadyAddresses() {
        return notReadyAddresses;
    }

    @JsonProperty("notReadyAddresses")
    public void setNotReadyAddresses(List<EndpointAddress> notReadyAddresses) {
        this.notReadyAddresses = notReadyAddresses;
    }

    @JsonProperty("ports")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EndpointPort> getPorts() {
        return ports;
    }

    @JsonProperty("ports")
    public void setPorts(List<EndpointPort> ports) {
        this.ports = ports;
    }

    @JsonIgnore
    public EndpointSubsetBuilder edit() {
        return new EndpointSubsetBuilder(this);
    }

    @JsonIgnore
    public EndpointSubsetBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
