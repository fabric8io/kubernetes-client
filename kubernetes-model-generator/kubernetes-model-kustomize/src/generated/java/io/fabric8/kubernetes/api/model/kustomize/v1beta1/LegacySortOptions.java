
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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
import io.fabric8.kubernetes.api.model.KubernetesResource;
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
    "orderFirst",
    "orderLast"
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
public class LegacySortOptions implements KubernetesResource
{

    @JsonProperty("orderFirst")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> orderFirst = new ArrayList<String>();
    @JsonProperty("orderLast")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> orderLast = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LegacySortOptions() {
    }

    public LegacySortOptions(List<String> orderFirst, List<String> orderLast) {
        super();
        this.orderFirst = orderFirst;
        this.orderLast = orderLast;
    }

    @JsonProperty("orderFirst")
    public List<String> getOrderFirst() {
        return orderFirst;
    }

    @JsonProperty("orderFirst")
    public void setOrderFirst(List<String> orderFirst) {
        this.orderFirst = orderFirst;
    }

    @JsonProperty("orderLast")
    public List<String> getOrderLast() {
        return orderLast;
    }

    @JsonProperty("orderLast")
    public void setOrderLast(List<String> orderLast) {
        this.orderLast = orderLast;
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
