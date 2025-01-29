
package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
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
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "$ref",
    "$schema",
    "additionalItems",
    "additionalProperties",
    "allOf",
    "anyOf",
    "default",
    "definitions",
    "dependencies",
    "description",
    "enum",
    "example",
    "exclusiveMaximum",
    "exclusiveMinimum",
    "externalDocs",
    "format",
    "id",
    "items",
    "maxItems",
    "maxLength",
    "maxProperties",
    "maximum",
    "minItems",
    "minLength",
    "minProperties",
    "minimum",
    "multipleOf",
    "not",
    "nullable",
    "oneOf",
    "pattern",
    "patternProperties",
    "properties",
    "required",
    "title",
    "type",
    "uniqueItems",
    "x-kubernetes-embedded-resource",
    "x-kubernetes-int-or-string",
    "x-kubernetes-list-map-keys",
    "x-kubernetes-list-type",
    "x-kubernetes-map-type",
    "x-kubernetes-preserve-unknown-fields",
    "x-kubernetes-validations"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class JSONSchemaProps implements Editable<JSONSchemaPropsBuilder>, KubernetesResource
{

    @JsonProperty("$ref")
    private String $ref;
    @JsonProperty("$schema")
    private String $schema;
    @JsonProperty("additionalItems")
    private JSONSchemaPropsOrBool additionalItems;
    @JsonProperty("additionalProperties")
    private JSONSchemaPropsOrBool additionalProperties;
    @JsonProperty("allOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> allOf = new ArrayList<>();
    @JsonProperty("anyOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> anyOf = new ArrayList<>();
    @JsonProperty("default")
    private JsonNode _default;
    @JsonProperty("definitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> definitions = new LinkedHashMap<>();
    @JsonProperty("dependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, JSONSchemaPropsOrStringArray> dependencies = new LinkedHashMap<>();
    @JsonProperty("description")
    private String description;
    @JsonProperty("enum")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JsonNode> _enum = new ArrayList<>();
    @JsonProperty("example")
    private JsonNode example;
    @JsonProperty("exclusiveMaximum")
    private Boolean exclusiveMaximum;
    @JsonProperty("exclusiveMinimum")
    private Boolean exclusiveMinimum;
    @JsonProperty("externalDocs")
    private ExternalDocumentation externalDocs;
    @JsonProperty("format")
    private String format;
    @JsonProperty("id")
    private String id;
    @JsonProperty("items")
    private JSONSchemaPropsOrArray items;
    @JsonProperty("maxItems")
    private Long maxItems;
    @JsonProperty("maxLength")
    private Long maxLength;
    @JsonProperty("maxProperties")
    private Long maxProperties;
    @JsonProperty("maximum")
    private Double maximum;
    @JsonProperty("minItems")
    private Long minItems;
    @JsonProperty("minLength")
    private Long minLength;
    @JsonProperty("minProperties")
    private Long minProperties;
    @JsonProperty("minimum")
    private Double minimum;
    @JsonProperty("multipleOf")
    private Double multipleOf;
    @JsonProperty("not")
    private io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps not;
    @JsonProperty("nullable")
    private Boolean nullable;
    @JsonProperty("oneOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> oneOf = new ArrayList<>();
    @JsonProperty("pattern")
    private String pattern;
    @JsonProperty("patternProperties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> patternProperties = new LinkedHashMap<>();
    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> properties = new LinkedHashMap<>();
    @JsonProperty("required")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> required = new ArrayList<>();
    @JsonProperty("title")
    private String title;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uniqueItems")
    private Boolean uniqueItems;
    @JsonProperty("x-kubernetes-embedded-resource")
    private Boolean xKubernetesEmbeddedResource;
    @JsonProperty("x-kubernetes-int-or-string")
    private Boolean xKubernetesIntOrString;
    @JsonProperty("x-kubernetes-list-map-keys")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> xKubernetesListMapKeys = new ArrayList<>();
    @JsonProperty("x-kubernetes-list-type")
    private String xKubernetesListType;
    @JsonProperty("x-kubernetes-map-type")
    private String xKubernetesMapType;
    @JsonProperty("x-kubernetes-preserve-unknown-fields")
    private Boolean xKubernetesPreserveUnknownFields;
    @JsonProperty("x-kubernetes-validations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ValidationRule> xKubernetesValidations = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     */
    public JSONSchemaProps() {
    }

    public JSONSchemaProps(String $ref, String $schema, JSONSchemaPropsOrBool additionalItems, JSONSchemaPropsOrBool additionalProperties, List<io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> allOf, List<io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> anyOf, JsonNode _default, Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> definitions, Map<String, JSONSchemaPropsOrStringArray> dependencies, String description, List<JsonNode> _enum, JsonNode example, Boolean exclusiveMaximum, Boolean exclusiveMinimum, ExternalDocumentation externalDocs, String format, String id, JSONSchemaPropsOrArray items, Long maxItems, Long maxLength, Long maxProperties, Double maximum, Long minItems, Long minLength, Long minProperties, Double minimum, Double multipleOf, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps not, Boolean nullable, List<io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> oneOf, String pattern, Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> patternProperties, Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> properties, List<String> required, String title, String type, Boolean uniqueItems, Boolean xKubernetesEmbeddedResource, Boolean xKubernetesIntOrString, List<String> xKubernetesListMapKeys, String xKubernetesListType, String xKubernetesMapType, Boolean xKubernetesPreserveUnknownFields, List<ValidationRule> xKubernetesValidations) {
        super();
        this.$ref = $ref;
        this.$schema = $schema;
        this.additionalItems = additionalItems;
        this.additionalProperties = additionalProperties;
        this.allOf = allOf;
        this.anyOf = anyOf;
        this._default = _default;
        this.definitions = definitions;
        this.dependencies = dependencies;
        this.description = description;
        this._enum = _enum;
        this.example = example;
        this.exclusiveMaximum = exclusiveMaximum;
        this.exclusiveMinimum = exclusiveMinimum;
        this.externalDocs = externalDocs;
        this.format = format;
        this.id = id;
        this.items = items;
        this.maxItems = maxItems;
        this.maxLength = maxLength;
        this.maxProperties = maxProperties;
        this.maximum = maximum;
        this.minItems = minItems;
        this.minLength = minLength;
        this.minProperties = minProperties;
        this.minimum = minimum;
        this.multipleOf = multipleOf;
        this.not = not;
        this.nullable = nullable;
        this.oneOf = oneOf;
        this.pattern = pattern;
        this.patternProperties = patternProperties;
        this.properties = properties;
        this.required = required;
        this.title = title;
        this.type = type;
        this.uniqueItems = uniqueItems;
        this.xKubernetesEmbeddedResource = xKubernetesEmbeddedResource;
        this.xKubernetesIntOrString = xKubernetesIntOrString;
        this.xKubernetesListMapKeys = xKubernetesListMapKeys;
        this.xKubernetesListType = xKubernetesListType;
        this.xKubernetesMapType = xKubernetesMapType;
        this.xKubernetesPreserveUnknownFields = xKubernetesPreserveUnknownFields;
        this.xKubernetesValidations = xKubernetesValidations;
    }

    @JsonProperty("$ref")
    public String get$ref() {
        return $ref;
    }

    @JsonProperty("$ref")
    public void set$ref(String $ref) {
        this.$ref = $ref;
    }

    @JsonProperty("$schema")
    public String get$schema() {
        return $schema;
    }

    @JsonProperty("$schema")
    public void set$schema(String $schema) {
        this.$schema = $schema;
    }

    @JsonProperty("additionalItems")
    public JSONSchemaPropsOrBool getAdditionalItems() {
        return additionalItems;
    }

    @JsonProperty("additionalItems")
    public void setAdditionalItems(JSONSchemaPropsOrBool additionalItems) {
        this.additionalItems = additionalItems;
    }

    @JsonProperty("additionalProperties")
    public JSONSchemaPropsOrBool getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonProperty("additionalProperties")
    public void setAdditionalProperties(JSONSchemaPropsOrBool additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("allOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> getAllOf() {
        return allOf;
    }

    @JsonProperty("allOf")
    public void setAllOf(List<io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> allOf) {
        this.allOf = allOf;
    }

    @JsonProperty("anyOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> getAnyOf() {
        return anyOf;
    }

    @JsonProperty("anyOf")
    public void setAnyOf(List<io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> anyOf) {
        this.anyOf = anyOf;
    }

    @JsonProperty("default")
    public JsonNode getDefault() {
        return _default;
    }

    @JsonProperty("default")
    public void setDefault(JsonNode _default) {
        this._default = _default;
    }

    @JsonProperty("definitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> getDefinitions() {
        return definitions;
    }

    @JsonProperty("definitions")
    public void setDefinitions(Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> definitions) {
        this.definitions = definitions;
    }

    @JsonProperty("dependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, JSONSchemaPropsOrStringArray> getDependencies() {
        return dependencies;
    }

    @JsonProperty("dependencies")
    public void setDependencies(Map<String, JSONSchemaPropsOrStringArray> dependencies) {
        this.dependencies = dependencies;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("enum")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonProperty("externalDocs")
    public ExternalDocumentation getExternalDocs() {
        return externalDocs;
    }

    @JsonProperty("externalDocs")
    public void setExternalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("items")
    public JSONSchemaPropsOrArray getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(JSONSchemaPropsOrArray items) {
        this.items = items;
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
    public Double getMaximum() {
        return maximum;
    }

    @JsonProperty("maximum")
    public void setMaximum(Double maximum) {
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
    public Double getMinimum() {
        return minimum;
    }

    @JsonProperty("minimum")
    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    @JsonProperty("multipleOf")
    public Double getMultipleOf() {
        return multipleOf;
    }

    @JsonProperty("multipleOf")
    public void setMultipleOf(Double multipleOf) {
        this.multipleOf = multipleOf;
    }

    @JsonProperty("not")
    public io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps getNot() {
        return not;
    }

    @JsonProperty("not")
    public void setNot(io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps not) {
        this.not = not;
    }

    @JsonProperty("nullable")
    public Boolean getNullable() {
        return nullable;
    }

    @JsonProperty("nullable")
    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    @JsonProperty("oneOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> getOneOf() {
        return oneOf;
    }

    @JsonProperty("oneOf")
    public void setOneOf(List<io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> oneOf) {
        this.oneOf = oneOf;
    }

    @JsonProperty("pattern")
    public String getPattern() {
        return pattern;
    }

    @JsonProperty("pattern")
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @JsonProperty("patternProperties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> getPatternProperties() {
        return patternProperties;
    }

    @JsonProperty("patternProperties")
    public void setPatternProperties(Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> patternProperties) {
        this.patternProperties = patternProperties;
    }

    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1beta1.JSONSchemaProps> properties) {
        this.properties = properties;
    }

    @JsonProperty("required")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRequired() {
        return required;
    }

    @JsonProperty("required")
    public void setRequired(List<String> required) {
        this.required = required;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
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

    @JsonProperty("x-kubernetes-embedded-resource")
    public Boolean getXKubernetesEmbeddedResource() {
        return xKubernetesEmbeddedResource;
    }

    @JsonProperty("x-kubernetes-embedded-resource")
    public void setXKubernetesEmbeddedResource(Boolean xKubernetesEmbeddedResource) {
        this.xKubernetesEmbeddedResource = xKubernetesEmbeddedResource;
    }

    @JsonProperty("x-kubernetes-int-or-string")
    public Boolean getXKubernetesIntOrString() {
        return xKubernetesIntOrString;
    }

    @JsonProperty("x-kubernetes-int-or-string")
    public void setXKubernetesIntOrString(Boolean xKubernetesIntOrString) {
        this.xKubernetesIntOrString = xKubernetesIntOrString;
    }

    @JsonProperty("x-kubernetes-list-map-keys")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getXKubernetesListMapKeys() {
        return xKubernetesListMapKeys;
    }

    @JsonProperty("x-kubernetes-list-map-keys")
    public void setXKubernetesListMapKeys(List<String> xKubernetesListMapKeys) {
        this.xKubernetesListMapKeys = xKubernetesListMapKeys;
    }

    @JsonProperty("x-kubernetes-list-type")
    public String getXKubernetesListType() {
        return xKubernetesListType;
    }

    @JsonProperty("x-kubernetes-list-type")
    public void setXKubernetesListType(String xKubernetesListType) {
        this.xKubernetesListType = xKubernetesListType;
    }

    @JsonProperty("x-kubernetes-map-type")
    public String getXKubernetesMapType() {
        return xKubernetesMapType;
    }

    @JsonProperty("x-kubernetes-map-type")
    public void setXKubernetesMapType(String xKubernetesMapType) {
        this.xKubernetesMapType = xKubernetesMapType;
    }

    @JsonProperty("x-kubernetes-preserve-unknown-fields")
    public Boolean getXKubernetesPreserveUnknownFields() {
        return xKubernetesPreserveUnknownFields;
    }

    @JsonProperty("x-kubernetes-preserve-unknown-fields")
    public void setXKubernetesPreserveUnknownFields(Boolean xKubernetesPreserveUnknownFields) {
        this.xKubernetesPreserveUnknownFields = xKubernetesPreserveUnknownFields;
    }

    @JsonProperty("x-kubernetes-validations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ValidationRule> getXKubernetesValidations() {
        return xKubernetesValidations;
    }

    @JsonProperty("x-kubernetes-validations")
    public void setXKubernetesValidations(List<ValidationRule> xKubernetesValidations) {
        this.xKubernetesValidations = xKubernetesValidations;
    }

    @JsonIgnore
    public JSONSchemaPropsBuilder edit() {
        return new JSONSchemaPropsBuilder(this);
    }

    @JsonIgnore
    public JSONSchemaPropsBuilder toBuilder() {
        return edit();
    }


}
