
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fields",
    "includeSelectors",
    "includeTemplates",
    "pairs"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class Label implements Editable<LabelBuilder> , KubernetesResource
{

    @JsonProperty("fields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FieldSpec> fields = new ArrayList<>();
    @JsonProperty("includeSelectors")
    private Boolean includeSelectors;
    @JsonProperty("includeTemplates")
    private Boolean includeTemplates;
    @JsonProperty("pairs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> pairs = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getPairs() {
        return pairs;
    }

    @JsonProperty("pairs")
    public void setPairs(Map<String, String> pairs) {
        this.pairs = pairs;
    }

    @JsonIgnore
    public LabelBuilder edit() {
        return new LabelBuilder(this);
    }

    @JsonIgnore
    public LabelBuilder toBuilder() {
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
