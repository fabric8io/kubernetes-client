
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
    "fields",
    "includeSelectors",
    "includeTemplates",
    "pairs"
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
public class Label implements KubernetesResource
{

    @JsonProperty("fields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FieldSpec> fields = new ArrayList<FieldSpec>();
    @JsonProperty("includeSelectors")
    private Boolean includeSelectors;
    @JsonProperty("includeTemplates")
    private Boolean includeTemplates;
    @JsonProperty("pairs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> pairs = new LinkedHashMap<String, String>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Label() {
    }

    public Label(List<FieldSpec> fields, Boolean includeSelectors, Boolean includeTemplates, Map<String, String> pairs) {
        super();
        this.fields = fields;
        this.includeSelectors = includeSelectors;
        this.includeTemplates = includeTemplates;
        this.pairs = pairs;
    }

    @JsonProperty("fields")
    public List<FieldSpec> getFields() {
        return fields;
    }

    @JsonProperty("fields")
    public void setFields(List<FieldSpec> fields) {
        this.fields = fields;
    }

    @JsonProperty("includeSelectors")
    public Boolean getIncludeSelectors() {
        return includeSelectors;
    }

    @JsonProperty("includeSelectors")
    public void setIncludeSelectors(Boolean includeSelectors) {
        this.includeSelectors = includeSelectors;
    }

    @JsonProperty("includeTemplates")
    public Boolean getIncludeTemplates() {
        return includeTemplates;
    }

    @JsonProperty("includeTemplates")
    public void setIncludeTemplates(Boolean includeTemplates) {
        this.includeTemplates = includeTemplates;
    }

    @JsonProperty("pairs")
    public Map<String, String> getPairs() {
        return pairs;
    }

    @JsonProperty("pairs")
    public void setPairs(Map<String, String> pairs) {
        this.pairs = pairs;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
