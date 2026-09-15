
package io.fabric8.kubernetes.api.model.apiextensions.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
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
    private List<io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> allOf = new ArrayList<>();
    @JsonProperty("anyOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> anyOf = new ArrayList<>();
    @JsonProperty("default")
    private JsonNode _default;
    @JsonProperty("definitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> definitions = new LinkedHashMap<>();
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
    private io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps not;
    @JsonProperty("nullable")
    private Boolean nullable;
    @JsonProperty("oneOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> oneOf = new ArrayList<>();
    @JsonProperty("pattern")
    private String pattern;
    @JsonProperty("patternProperties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> patternProperties = new LinkedHashMap<>();
    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> properties = new LinkedHashMap<>();
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

    public JSONSchemaProps(String $ref, String $schema, JSONSchemaPropsOrBool additionalItems, JSONSchemaPropsOrBool additionalProperties, List<io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> allOf, List<io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> anyOf, JsonNode _default, Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> definitions, Map<String, JSONSchemaPropsOrStringArray> dependencies, String description, List<JsonNode> _enum, JsonNode example, Boolean exclusiveMaximum, Boolean exclusiveMinimum, ExternalDocumentation externalDocs, String format, String id, JSONSchemaPropsOrArray items, Long maxItems, Long maxLength, Long maxProperties, Double maximum, Long minItems, Long minLength, Long minProperties, Double minimum, Double multipleOf, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps not, Boolean nullable, List<io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> oneOf, String pattern, Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> patternProperties, Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> properties, List<String> required, String title, String type, Boolean uniqueItems, Boolean xKubernetesEmbeddedResource, Boolean xKubernetesIntOrString, List<String> xKubernetesListMapKeys, String xKubernetesListType, String xKubernetesMapType, Boolean xKubernetesPreserveUnknownFields, List<ValidationRule> xKubernetesValidations) {
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
    public List<io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> getAllOf() {
        return allOf;
    }

    @JsonProperty("allOf")
    public void setAllOf(List<io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> allOf) {
        this.allOf = allOf;
    }

    @JsonProperty("anyOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> getAnyOf() {
        return anyOf;
    }

    @JsonProperty("anyOf")
    public void setAnyOf(List<io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> anyOf) {
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
    public Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> getDefinitions() {
        return definitions;
    }

    @JsonProperty("definitions")
    public void setDefinitions(Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> definitions) {
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
    public io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps getNot() {
        return not;
    }

    @JsonProperty("not")
    public void setNot(io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps not) {
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
    public List<io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> getOneOf() {
        return oneOf;
    }

    @JsonProperty("oneOf")
    public void setOneOf(List<io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> oneOf) {
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
    public Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> getPatternProperties() {
        return patternProperties;
    }

    @JsonProperty("patternProperties")
    public void setPatternProperties(Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> patternProperties) {
        this.patternProperties = patternProperties;
    }

    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Map<String, io.fabric8.kubernetes.api.model.apiextensions.v1.JSONSchemaProps> properties) {
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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof JSONSchemaProps)) {
            return false;
        }
        JSONSchemaProps other = (JSONSchemaProps) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$$ref = this.get$ref();
        Object other$$ref = other.get$ref();
        if (this$$ref == null ? other$$ref != null : !this$$ref.equals(other$$ref)) {
            return false;
        }
        Object this$$schema = this.get$schema();
        Object other$$schema = other.get$schema();
        if (this$$schema == null ? other$$schema != null : !this$$schema.equals(other$$schema)) {
            return false;
        }
        Object this$additionalItems = this.getAdditionalItems();
        Object other$additionalItems = other.getAdditionalItems();
        if (this$additionalItems == null ? other$additionalItems != null : !this$additionalItems.equals(other$additionalItems)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        Object this$allOf = this.getAllOf();
        Object other$allOf = other.getAllOf();
        if (this$allOf == null ? other$allOf != null : !this$allOf.equals(other$allOf)) {
            return false;
        }
        Object this$anyOf = this.getAnyOf();
        Object other$anyOf = other.getAnyOf();
        if (this$anyOf == null ? other$anyOf != null : !this$anyOf.equals(other$anyOf)) {
            return false;
        }
        Object this$_default = this.getDefault();
        Object other$_default = other.getDefault();
        if (this$_default == null ? other$_default != null : !this$_default.equals(other$_default)) {
            return false;
        }
        Object this$definitions = this.getDefinitions();
        Object other$definitions = other.getDefinitions();
        if (this$definitions == null ? other$definitions != null : !this$definitions.equals(other$definitions)) {
            return false;
        }
        Object this$dependencies = this.getDependencies();
        Object other$dependencies = other.getDependencies();
        if (this$dependencies == null ? other$dependencies != null : !this$dependencies.equals(other$dependencies)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$_enum = this.getEnum();
        Object other$_enum = other.getEnum();
        if (this$_enum == null ? other$_enum != null : !this$_enum.equals(other$_enum)) {
            return false;
        }
        Object this$example = this.getExample();
        Object other$example = other.getExample();
        if (this$example == null ? other$example != null : !this$example.equals(other$example)) {
            return false;
        }
        Object this$exclusiveMaximum = this.getExclusiveMaximum();
        Object other$exclusiveMaximum = other.getExclusiveMaximum();
        if (this$exclusiveMaximum == null ? other$exclusiveMaximum != null : !this$exclusiveMaximum.equals(other$exclusiveMaximum)) {
            return false;
        }
        Object this$exclusiveMinimum = this.getExclusiveMinimum();
        Object other$exclusiveMinimum = other.getExclusiveMinimum();
        if (this$exclusiveMinimum == null ? other$exclusiveMinimum != null : !this$exclusiveMinimum.equals(other$exclusiveMinimum)) {
            return false;
        }
        Object this$externalDocs = this.getExternalDocs();
        Object other$externalDocs = other.getExternalDocs();
        if (this$externalDocs == null ? other$externalDocs != null : !this$externalDocs.equals(other$externalDocs)) {
            return false;
        }
        Object this$format = this.getFormat();
        Object other$format = other.getFormat();
        if (this$format == null ? other$format != null : !this$format.equals(other$format)) {
            return false;
        }
        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        Object this$items = this.getItems();
        Object other$items = other.getItems();
        if (this$items == null ? other$items != null : !this$items.equals(other$items)) {
            return false;
        }
        Object this$maxItems = this.getMaxItems();
        Object other$maxItems = other.getMaxItems();
        if (this$maxItems == null ? other$maxItems != null : !this$maxItems.equals(other$maxItems)) {
            return false;
        }
        Object this$maxLength = this.getMaxLength();
        Object other$maxLength = other.getMaxLength();
        if (this$maxLength == null ? other$maxLength != null : !this$maxLength.equals(other$maxLength)) {
            return false;
        }
        Object this$maxProperties = this.getMaxProperties();
        Object other$maxProperties = other.getMaxProperties();
        if (this$maxProperties == null ? other$maxProperties != null : !this$maxProperties.equals(other$maxProperties)) {
            return false;
        }
        Object this$maximum = this.getMaximum();
        Object other$maximum = other.getMaximum();
        if (this$maximum == null ? other$maximum != null : !this$maximum.equals(other$maximum)) {
            return false;
        }
        Object this$minItems = this.getMinItems();
        Object other$minItems = other.getMinItems();
        if (this$minItems == null ? other$minItems != null : !this$minItems.equals(other$minItems)) {
            return false;
        }
        Object this$minLength = this.getMinLength();
        Object other$minLength = other.getMinLength();
        if (this$minLength == null ? other$minLength != null : !this$minLength.equals(other$minLength)) {
            return false;
        }
        Object this$minProperties = this.getMinProperties();
        Object other$minProperties = other.getMinProperties();
        if (this$minProperties == null ? other$minProperties != null : !this$minProperties.equals(other$minProperties)) {
            return false;
        }
        Object this$minimum = this.getMinimum();
        Object other$minimum = other.getMinimum();
        if (this$minimum == null ? other$minimum != null : !this$minimum.equals(other$minimum)) {
            return false;
        }
        Object this$multipleOf = this.getMultipleOf();
        Object other$multipleOf = other.getMultipleOf();
        if (this$multipleOf == null ? other$multipleOf != null : !this$multipleOf.equals(other$multipleOf)) {
            return false;
        }
        Object this$not = this.getNot();
        Object other$not = other.getNot();
        if (this$not == null ? other$not != null : !this$not.equals(other$not)) {
            return false;
        }
        Object this$nullable = this.getNullable();
        Object other$nullable = other.getNullable();
        if (this$nullable == null ? other$nullable != null : !this$nullable.equals(other$nullable)) {
            return false;
        }
        Object this$oneOf = this.getOneOf();
        Object other$oneOf = other.getOneOf();
        if (this$oneOf == null ? other$oneOf != null : !this$oneOf.equals(other$oneOf)) {
            return false;
        }
        Object this$pattern = this.getPattern();
        Object other$pattern = other.getPattern();
        if (this$pattern == null ? other$pattern != null : !this$pattern.equals(other$pattern)) {
            return false;
        }
        Object this$patternProperties = this.getPatternProperties();
        Object other$patternProperties = other.getPatternProperties();
        if (this$patternProperties == null ? other$patternProperties != null : !this$patternProperties.equals(other$patternProperties)) {
            return false;
        }
        Object this$properties = this.getProperties();
        Object other$properties = other.getProperties();
        if (this$properties == null ? other$properties != null : !this$properties.equals(other$properties)) {
            return false;
        }
        Object this$required = this.getRequired();
        Object other$required = other.getRequired();
        if (this$required == null ? other$required != null : !this$required.equals(other$required)) {
            return false;
        }
        Object this$title = this.getTitle();
        Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$uniqueItems = this.getUniqueItems();
        Object other$uniqueItems = other.getUniqueItems();
        if (this$uniqueItems == null ? other$uniqueItems != null : !this$uniqueItems.equals(other$uniqueItems)) {
            return false;
        }
        Object this$xKubernetesEmbeddedResource = this.getXKubernetesEmbeddedResource();
        Object other$xKubernetesEmbeddedResource = other.getXKubernetesEmbeddedResource();
        if (this$xKubernetesEmbeddedResource == null ? other$xKubernetesEmbeddedResource != null : !this$xKubernetesEmbeddedResource.equals(other$xKubernetesEmbeddedResource)) {
            return false;
        }
        Object this$xKubernetesIntOrString = this.getXKubernetesIntOrString();
        Object other$xKubernetesIntOrString = other.getXKubernetesIntOrString();
        if (this$xKubernetesIntOrString == null ? other$xKubernetesIntOrString != null : !this$xKubernetesIntOrString.equals(other$xKubernetesIntOrString)) {
            return false;
        }
        Object this$xKubernetesListMapKeys = this.getXKubernetesListMapKeys();
        Object other$xKubernetesListMapKeys = other.getXKubernetesListMapKeys();
        if (this$xKubernetesListMapKeys == null ? other$xKubernetesListMapKeys != null : !this$xKubernetesListMapKeys.equals(other$xKubernetesListMapKeys)) {
            return false;
        }
        Object this$xKubernetesListType = this.getXKubernetesListType();
        Object other$xKubernetesListType = other.getXKubernetesListType();
        if (this$xKubernetesListType == null ? other$xKubernetesListType != null : !this$xKubernetesListType.equals(other$xKubernetesListType)) {
            return false;
        }
        Object this$xKubernetesMapType = this.getXKubernetesMapType();
        Object other$xKubernetesMapType = other.getXKubernetesMapType();
        if (this$xKubernetesMapType == null ? other$xKubernetesMapType != null : !this$xKubernetesMapType.equals(other$xKubernetesMapType)) {
            return false;
        }
        Object this$xKubernetesPreserveUnknownFields = this.getXKubernetesPreserveUnknownFields();
        Object other$xKubernetesPreserveUnknownFields = other.getXKubernetesPreserveUnknownFields();
        if (this$xKubernetesPreserveUnknownFields == null ? other$xKubernetesPreserveUnknownFields != null : !this$xKubernetesPreserveUnknownFields.equals(other$xKubernetesPreserveUnknownFields)) {
            return false;
        }
        Object this$xKubernetesValidations = this.getXKubernetesValidations();
        Object other$xKubernetesValidations = other.getXKubernetesValidations();
        if (this$xKubernetesValidations == null ? other$xKubernetesValidations != null : !this$xKubernetesValidations.equals(other$xKubernetesValidations)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof JSONSchemaProps;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $$ref = this.get$ref();
        result = result * prime + ($$ref == null ? 43 : $$ref.hashCode());
        Object $$schema = this.get$schema();
        result = result * prime + ($$schema == null ? 43 : $$schema.hashCode());
        Object $additionalItems = this.getAdditionalItems();
        result = result * prime + ($additionalItems == null ? 43 : $additionalItems.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        Object $allOf = this.getAllOf();
        result = result * prime + ($allOf == null ? 43 : $allOf.hashCode());
        Object $anyOf = this.getAnyOf();
        result = result * prime + ($anyOf == null ? 43 : $anyOf.hashCode());
        Object $_default = this.getDefault();
        result = result * prime + ($_default == null ? 43 : $_default.hashCode());
        Object $definitions = this.getDefinitions();
        result = result * prime + ($definitions == null ? 43 : $definitions.hashCode());
        Object $dependencies = this.getDependencies();
        result = result * prime + ($dependencies == null ? 43 : $dependencies.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $_enum = this.getEnum();
        result = result * prime + ($_enum == null ? 43 : $_enum.hashCode());
        Object $example = this.getExample();
        result = result * prime + ($example == null ? 43 : $example.hashCode());
        Object $exclusiveMaximum = this.getExclusiveMaximum();
        result = result * prime + ($exclusiveMaximum == null ? 43 : $exclusiveMaximum.hashCode());
        Object $exclusiveMinimum = this.getExclusiveMinimum();
        result = result * prime + ($exclusiveMinimum == null ? 43 : $exclusiveMinimum.hashCode());
        Object $externalDocs = this.getExternalDocs();
        result = result * prime + ($externalDocs == null ? 43 : $externalDocs.hashCode());
        Object $format = this.getFormat();
        result = result * prime + ($format == null ? 43 : $format.hashCode());
        Object $id = this.getId();
        result = result * prime + ($id == null ? 43 : $id.hashCode());
        Object $items = this.getItems();
        result = result * prime + ($items == null ? 43 : $items.hashCode());
        Object $maxItems = this.getMaxItems();
        result = result * prime + ($maxItems == null ? 43 : $maxItems.hashCode());
        Object $maxLength = this.getMaxLength();
        result = result * prime + ($maxLength == null ? 43 : $maxLength.hashCode());
        Object $maxProperties = this.getMaxProperties();
        result = result * prime + ($maxProperties == null ? 43 : $maxProperties.hashCode());
        Object $maximum = this.getMaximum();
        result = result * prime + ($maximum == null ? 43 : $maximum.hashCode());
        Object $minItems = this.getMinItems();
        result = result * prime + ($minItems == null ? 43 : $minItems.hashCode());
        Object $minLength = this.getMinLength();
        result = result * prime + ($minLength == null ? 43 : $minLength.hashCode());
        Object $minProperties = this.getMinProperties();
        result = result * prime + ($minProperties == null ? 43 : $minProperties.hashCode());
        Object $minimum = this.getMinimum();
        result = result * prime + ($minimum == null ? 43 : $minimum.hashCode());
        Object $multipleOf = this.getMultipleOf();
        result = result * prime + ($multipleOf == null ? 43 : $multipleOf.hashCode());
        Object $not = this.getNot();
        result = result * prime + ($not == null ? 43 : $not.hashCode());
        Object $nullable = this.getNullable();
        result = result * prime + ($nullable == null ? 43 : $nullable.hashCode());
        Object $oneOf = this.getOneOf();
        result = result * prime + ($oneOf == null ? 43 : $oneOf.hashCode());
        Object $pattern = this.getPattern();
        result = result * prime + ($pattern == null ? 43 : $pattern.hashCode());
        Object $patternProperties = this.getPatternProperties();
        result = result * prime + ($patternProperties == null ? 43 : $patternProperties.hashCode());
        Object $properties = this.getProperties();
        result = result * prime + ($properties == null ? 43 : $properties.hashCode());
        Object $required = this.getRequired();
        result = result * prime + ($required == null ? 43 : $required.hashCode());
        Object $title = this.getTitle();
        result = result * prime + ($title == null ? 43 : $title.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $uniqueItems = this.getUniqueItems();
        result = result * prime + ($uniqueItems == null ? 43 : $uniqueItems.hashCode());
        Object $xKubernetesEmbeddedResource = this.getXKubernetesEmbeddedResource();
        result = result * prime + ($xKubernetesEmbeddedResource == null ? 43 : $xKubernetesEmbeddedResource.hashCode());
        Object $xKubernetesIntOrString = this.getXKubernetesIntOrString();
        result = result * prime + ($xKubernetesIntOrString == null ? 43 : $xKubernetesIntOrString.hashCode());
        Object $xKubernetesListMapKeys = this.getXKubernetesListMapKeys();
        result = result * prime + ($xKubernetesListMapKeys == null ? 43 : $xKubernetesListMapKeys.hashCode());
        Object $xKubernetesListType = this.getXKubernetesListType();
        result = result * prime + ($xKubernetesListType == null ? 43 : $xKubernetesListType.hashCode());
        Object $xKubernetesMapType = this.getXKubernetesMapType();
        result = result * prime + ($xKubernetesMapType == null ? 43 : $xKubernetesMapType.hashCode());
        Object $xKubernetesPreserveUnknownFields = this.getXKubernetesPreserveUnknownFields();
        result = result * prime + ($xKubernetesPreserveUnknownFields == null ? 43 : $xKubernetesPreserveUnknownFields.hashCode());
        Object $xKubernetesValidations = this.getXKubernetesValidations();
        result = result * prime + ($xKubernetesValidations == null ? 43 : $xKubernetesValidations.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "JSONSchemaProps(" + "$ref=" + this.get$ref() + ", $schema=" + this.get$schema() + ", additionalItems=" + this.getAdditionalItems() + ", additionalProperties=" + this.getAdditionalProperties() + ", allOf=" + this.getAllOf() + ", anyOf=" + this.getAnyOf() + ", _default=" + this.getDefault() + ", definitions=" + this.getDefinitions() + ", dependencies=" + this.getDependencies() + ", description=" + this.getDescription() + ", _enum=" + this.getEnum() + ", example=" + this.getExample() + ", exclusiveMaximum=" + this.getExclusiveMaximum() + ", exclusiveMinimum=" + this.getExclusiveMinimum() + ", externalDocs=" + this.getExternalDocs() + ", format=" + this.getFormat() + ", id=" + this.getId() + ", items=" + this.getItems() + ", maxItems=" + this.getMaxItems() + ", maxLength=" + this.getMaxLength() + ", maxProperties=" + this.getMaxProperties() + ", maximum=" + this.getMaximum() + ", minItems=" + this.getMinItems() + ", minLength=" + this.getMinLength() + ", minProperties=" + this.getMinProperties() + ", minimum=" + this.getMinimum() + ", multipleOf=" + this.getMultipleOf() + ", not=" + this.getNot() + ", nullable=" + this.getNullable() + ", oneOf=" + this.getOneOf() + ", pattern=" + this.getPattern() + ", patternProperties=" + this.getPatternProperties() + ", properties=" + this.getProperties() + ", required=" + this.getRequired() + ", title=" + this.getTitle() + ", type=" + this.getType() + ", uniqueItems=" + this.getUniqueItems() + ", xKubernetesEmbeddedResource=" + this.getXKubernetesEmbeddedResource() + ", xKubernetesIntOrString=" + this.getXKubernetesIntOrString() + ", xKubernetesListMapKeys=" + this.getXKubernetesListMapKeys() + ", xKubernetesListType=" + this.getXKubernetesListType() + ", xKubernetesMapType=" + this.getXKubernetesMapType() + ", xKubernetesPreserveUnknownFields=" + this.getXKubernetesPreserveUnknownFields() + ", xKubernetesValidations=" + this.getXKubernetesValidations() + ")";
    }

}
