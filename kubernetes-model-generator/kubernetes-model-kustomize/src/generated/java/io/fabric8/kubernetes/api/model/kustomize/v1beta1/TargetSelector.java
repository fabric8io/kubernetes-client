
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
    "fieldPaths",
    "options",
    "reject",
    "select"
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
public class TargetSelector implements KubernetesResource
{

    @JsonProperty("fieldPaths")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> fieldPaths = new ArrayList<String>();
    @JsonProperty("options")
    private FieldOptions options;
    @JsonProperty("reject")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Selector> reject = new ArrayList<Selector>();
    @JsonProperty("select")
    private Selector select;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TargetSelector() {
    }

    public TargetSelector(List<String> fieldPaths, FieldOptions options, List<Selector> reject, Selector select) {
        super();
        this.fieldPaths = fieldPaths;
        this.options = options;
        this.reject = reject;
        this.select = select;
    }

    @JsonProperty("fieldPaths")
    public List<String> getFieldPaths() {
        return fieldPaths;
    }

    @JsonProperty("fieldPaths")
    public void setFieldPaths(List<String> fieldPaths) {
        this.fieldPaths = fieldPaths;
    }

    @JsonProperty("options")
    public FieldOptions getOptions() {
        return options;
    }

    @JsonProperty("options")
    public void setOptions(FieldOptions options) {
        this.options = options;
    }

    @JsonProperty("reject")
    public List<Selector> getReject() {
        return reject;
    }

    @JsonProperty("reject")
    public void setReject(List<Selector> reject) {
        this.reject = reject;
    }

    @JsonProperty("select")
    public Selector getSelect() {
        return select;
    }

    @JsonProperty("select")
    public void setSelect(Selector select) {
        this.select = select;
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
