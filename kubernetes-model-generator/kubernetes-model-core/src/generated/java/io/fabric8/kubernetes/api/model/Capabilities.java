
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
    "add",
    "drop"
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
public class Capabilities implements KubernetesResource
{

    @JsonProperty("add")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> add = new ArrayList<String>();
    @JsonProperty("drop")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> drop = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Capabilities() {
    }

    public Capabilities(List<String> add, List<String> drop) {
        super();
        this.add = add;
        this.drop = drop;
    }

    @JsonProperty("add")
    public List<String> getAdd() {
        return add;
    }

    @JsonProperty("add")
    public void setAdd(List<String> add) {
        this.add = add;
    }

    @JsonProperty("drop")
    public List<String> getDrop() {
        return drop;
    }

    @JsonProperty("drop")
    public void setDrop(List<String> drop) {
        this.drop = drop;
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
