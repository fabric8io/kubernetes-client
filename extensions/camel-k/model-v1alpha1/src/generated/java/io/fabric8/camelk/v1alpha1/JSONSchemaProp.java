
package io.fabric8.camelk.v1alpha1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
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
    "default",
    "description",
    "enum",
    "example",
    "exclusiveMaximum",
    "exclusiveMinimum",
    "format",
    "id",
    "maxItems",
    "maxLength",
    "maxProperties",
    "maximum",
    "minItems",
    "minLength",
    "minProperties",
    "minimum",
    "multipleOf",
    "nullable",
    "pattern",
    "title",
    "type",
    "uniqueItems",
    "x-descriptors"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class JSONSchemaProp implements KubernetesResource
{

    @JsonProperty("default")
    private JsonNode _default;
    @JsonProperty("description")
    private java.lang.String description;
    @JsonProperty("enum")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JsonNode> _enum = new ArrayList<JsonNode>();
    @JsonProperty("example")
    private JsonNode example;
    @JsonProperty("exclusiveMaximum")
    private Boolean exclusiveMaximum;
    @JsonProperty("exclusiveMinimum")
    private Boolean exclusiveMinimum;
    @JsonProperty("format")
    private java.lang.String format;
    @JsonProperty("id")
    private java.lang.String id;
    @JsonProperty("maxItems")
    private Long maxItems;
    @JsonProperty("maxLength")
    private Long maxLength;
    @JsonProperty("maxProperties")
    private Long maxProperties;
    @JsonProperty("maximum")
    private String maximum;
    @JsonProperty("minItems")
    private Long minItems;
    @JsonProperty("minLength")
    private Long minLength;
    @JsonProperty("minProperties")
    private Long minProperties;
    @JsonProperty("minimum")
    private String minimum;
    @JsonProperty("multipleOf")
    private String multipleOf;
    @JsonProperty("nullable")
    private Boolean nullable;
    @JsonProperty("pattern")
    private java.lang.String pattern;
    @JsonProperty("title")
    private java.lang.String title;
    @JsonProperty("type")
    private java.lang.String type;
    @JsonProperty("uniqueItems")
    private Boolean uniqueItems;
    @JsonProperty("x-descriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> xDescriptors = new ArrayList<java.lang.String>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public JSONSchemaProp() {
    }

    /**
     * 
     * @param multipleOf
     * @param _default
     * @param maxItems
     * @param nullable
     * @param minLength
     * @param format
     * @param pattern
     * @param xDescriptors
     * @param description
     * @param _enum
     * @param title
     * @param type
     * @param example
     * @param minProperties
     * @param exclusiveMaximum
     * @param minItems
     * @param uniqueItems
     * @param maximum
     * @param id
     * @param maxProperties
     * @param exclusiveMinimum
     * @param minimum
     * @param maxLength
     */
    public JSONSchemaProp(JsonNode _default, java.lang.String description, List<JsonNode> _enum, JsonNode example, Boolean exclusiveMaximum, Boolean exclusiveMinimum, java.lang.String format, java.lang.String id, Long maxItems, Long maxLength, Long maxProperties, String maximum, Long minItems, Long minLength, Long minProperties, String minimum, String multipleOf, Boolean nullable, java.lang.String pattern, java.lang.String title, java.lang.String type, Boolean uniqueItems, List<java.lang.String> xDescriptors) {
        super();
        this._default = _default;
        this.description = description;
        this._enum = _enum;
        this.example = example;
        this.exclusiveMaximum = exclusiveMaximum;
        this.exclusiveMinimum = exclusiveMinimum;
        this.format = format;
        this.id = id;
        this.maxItems = maxItems;
        this.maxLength = maxLength;
        this.maxProperties = maxProperties;
        this.maximum = maximum;
        this.minItems = minItems;
        this.minLength = minLength;
        this.minProperties = minProperties;
        this.minimum = minimum;
        this.multipleOf = multipleOf;
        this.nullable = nullable;
        this.pattern = pattern;
        this.title = title;
        this.type = type;
        this.uniqueItems = uniqueItems;
        this.xDescriptors = xDescriptors;
    }

    @JsonProperty("default")
    public JsonNode getDefault() {
        return _default;
    }

    @JsonProperty("default")
    public void setDefault(JsonNode _default) {
        this._default = _default;
    }

    @JsonProperty("description")
    public java.lang.String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    @JsonProperty("enum")
    public List<JsonNode> getEnum() {
        return _enum;
    }

    @JsonProperty("enum")
    public void setEnum(List<JsonNode> _enum) {
        this._enum = _enum;
    }

    @JsonProperty("example")
    public JsonNode getExample() {
        return example;
    }

    @JsonProperty("example")
    public void setExample(JsonNode example) {
        this.example = example;
    }

    @JsonProperty("exclusiveMaximum")
    public Boolean getExclusiveMaximum() {
        return exclusiveMaximum;
    }

    @JsonProperty("exclusiveMaximum")
    public void setExclusiveMaximum(Boolean exclusiveMaximum) {
        this.exclusiveMaximum = exclusiveMaximum;
    }

    @JsonProperty("exclusiveMinimum")
    public Boolean getExclusiveMinimum() {
        return exclusiveMinimum;
    }

    @JsonProperty("exclusiveMinimum")
    public void setExclusiveMinimum(Boolean exclusiveMinimum) {
        this.exclusiveMinimum = exclusiveMinimum;
    }

    @JsonProperty("format")
    public java.lang.String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(java.lang.String format) {
        this.format = format;
    }

    @JsonProperty("id")
    public java.lang.String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(java.lang.String id) {
        this.id = id;
    }

    @JsonProperty("maxItems")
    public Long getMaxItems() {
        return maxItems;
    }

    @JsonProperty("maxItems")
    public void setMaxItems(Long maxItems) {
        this.maxItems = maxItems;
    }

    @JsonProperty("maxLength")
    public Long getMaxLength() {
        return maxLength;
    }

    @JsonProperty("maxLength")
    public void setMaxLength(Long maxLength) {
        this.maxLength = maxLength;
    }

    @JsonProperty("maxProperties")
    public Long getMaxProperties() {
        return maxProperties;
    }

    @JsonProperty("maxProperties")
    public void setMaxProperties(Long maxProperties) {
        this.maxProperties = maxProperties;
    }

    @JsonProperty("maximum")
    public String getMaximum() {
        return maximum;
    }

    @JsonProperty("maximum")
    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }

    @JsonProperty("minItems")
    public Long getMinItems() {
        return minItems;
    }

    @JsonProperty("minItems")
    public void setMinItems(Long minItems) {
        this.minItems = minItems;
    }

    @JsonProperty("minLength")
    public Long getMinLength() {
        return minLength;
    }

    @JsonProperty("minLength")
    public void setMinLength(Long minLength) {
        this.minLength = minLength;
    }

    @JsonProperty("minProperties")
    public Long getMinProperties() {
        return minProperties;
    }

    @JsonProperty("minProperties")
    public void setMinProperties(Long minProperties) {
        this.minProperties = minProperties;
    }

    @JsonProperty("minimum")
    public String getMinimum() {
        return minimum;
    }

    @JsonProperty("minimum")
    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    @JsonProperty("multipleOf")
    public String getMultipleOf() {
        return multipleOf;
    }

    @JsonProperty("multipleOf")
    public void setMultipleOf(String multipleOf) {
        this.multipleOf = multipleOf;
    }

    @JsonProperty("nullable")
    public Boolean getNullable() {
        return nullable;
    }

    @JsonProperty("nullable")
    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    @JsonProperty("pattern")
    public java.lang.String getPattern() {
        return pattern;
    }

    @JsonProperty("pattern")
    public void setPattern(java.lang.String pattern) {
        this.pattern = pattern;
    }

    @JsonProperty("title")
    public java.lang.String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    @JsonProperty("type")
    public java.lang.String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(java.lang.String type) {
        this.type = type;
    }

    @JsonProperty("uniqueItems")
    public Boolean getUniqueItems() {
        return uniqueItems;
    }

    @JsonProperty("uniqueItems")
    public void setUniqueItems(Boolean uniqueItems) {
        this.uniqueItems = uniqueItems;
    }

    @JsonProperty("x-descriptors")
    public List<java.lang.String> getXDescriptors() {
        return xDescriptors;
    }

    @JsonProperty("x-descriptors")
    public void setXDescriptors(List<java.lang.String> xDescriptors) {
        this.xDescriptors = xDescriptors;
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
