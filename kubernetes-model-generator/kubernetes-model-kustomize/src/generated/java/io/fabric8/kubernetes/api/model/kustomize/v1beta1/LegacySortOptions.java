
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "orderFirst",
    "orderLast"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class LegacySortOptions implements Editable<LegacySortOptionsBuilder> , KubernetesResource
{

    @JsonProperty("orderFirst")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> orderFirst = new ArrayList<>();
    @JsonProperty("orderLast")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> orderLast = new ArrayList<>();
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOrderFirst() {
        return orderFirst;
    }

    @JsonProperty("orderFirst")
    public void setOrderFirst(List<String> orderFirst) {
        this.orderFirst = orderFirst;
    }

    @JsonProperty("orderLast")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOrderLast() {
        return orderLast;
    }

    @JsonProperty("orderLast")
    public void setOrderLast(List<String> orderLast) {
        this.orderLast = orderLast;
    }

    @JsonIgnore
    public LegacySortOptionsBuilder edit() {
        return new LegacySortOptionsBuilder(this);
    }

    @JsonIgnore
    public LegacySortOptionsBuilder toBuilder() {
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
