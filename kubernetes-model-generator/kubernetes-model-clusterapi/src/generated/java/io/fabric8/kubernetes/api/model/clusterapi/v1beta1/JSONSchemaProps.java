
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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

/**
 * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalProperties",
    "allOf",
    "anyOf",
    "default",
    "description",
    "enum",
    "example",
    "exclusiveMaximum",
    "exclusiveMinimum",
    "format",
    "items",
    "maxItems",
    "maxLength",
    "maxProperties",
    "maximum",
    "minItems",
    "minLength",
    "minProperties",
    "minimum",
    "not",
    "oneOf",
    "pattern",
    "properties",
    "required",
    "type",
    "uniqueItems",
    "x-kubernetes-int-or-string",
    "x-kubernetes-preserve-unknown-fields",
    "x-kubernetes-validations",
    "x-metadata"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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

    @JsonProperty("additionalProperties")
    private io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps additionalProperties;
    @JsonProperty("allOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> allOf = new ArrayList<>();
    @JsonProperty("anyOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> anyOf = new ArrayList<>();
    @JsonProperty("default")
    private JsonNode _default;
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
    @JsonProperty("format")
    private String format;
    @JsonProperty("items")
    private io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps items;
    @JsonProperty("maxItems")
    private Long maxItems;
    @JsonProperty("maxLength")
    private Long maxLength;
    @JsonProperty("maxProperties")
    private Long maxProperties;
    @JsonProperty("maximum")
    private Long maximum;
    @JsonProperty("minItems")
    private Long minItems;
    @JsonProperty("minLength")
    private Long minLength;
    @JsonProperty("minProperties")
    private Long minProperties;
    @JsonProperty("minimum")
    private Long minimum;
    @JsonProperty("not")
    private io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps not;
    @JsonProperty("oneOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> oneOf = new ArrayList<>();
    @JsonProperty("pattern")
    private String pattern;
    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> properties = new LinkedHashMap<>();
    @JsonProperty("required")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> required = new ArrayList<>();
    @JsonProperty("type")
    private String type;
    @JsonProperty("uniqueItems")
    private Boolean uniqueItems;
    @JsonProperty("x-kubernetes-int-or-string")
    private Boolean xKubernetesIntOrString;
    @JsonProperty("x-kubernetes-preserve-unknown-fields")
    private Boolean xKubernetesPreserveUnknownFields;
    @JsonProperty("x-kubernetes-validations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ValidationRule> xKubernetesValidations = new ArrayList<>();
    @JsonProperty("x-metadata")
    private VariableSchemaMetadata xMetadata;

    /**
     * No args constructor for use in serialization
     */
    public JSONSchemaProps() {
    }

    public JSONSchemaProps(io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps additionalProperties, List<io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> allOf, List<io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> anyOf, JsonNode _default, String description, List<JsonNode> _enum, JsonNode example, Boolean exclusiveMaximum, Boolean exclusiveMinimum, String format, io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps items, Long maxItems, Long maxLength, Long maxProperties, Long maximum, Long minItems, Long minLength, Long minProperties, Long minimum, io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps not, List<io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> oneOf, String pattern, Map<String, io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> properties, List<String> required, String type, Boolean uniqueItems, Boolean xKubernetesIntOrString, Boolean xKubernetesPreserveUnknownFields, List<ValidationRule> xKubernetesValidations, VariableSchemaMetadata xMetadata) {
        super();
        this.additionalProperties = additionalProperties;
        this.allOf = allOf;
        this.anyOf = anyOf;
        this._default = _default;
        this.description = description;
        this._enum = _enum;
        this.example = example;
        this.exclusiveMaximum = exclusiveMaximum;
        this.exclusiveMinimum = exclusiveMinimum;
        this.format = format;
        this.items = items;
        this.maxItems = maxItems;
        this.maxLength = maxLength;
        this.maxProperties = maxProperties;
        this.maximum = maximum;
        this.minItems = minItems;
        this.minLength = minLength;
        this.minProperties = minProperties;
        this.minimum = minimum;
        this.not = not;
        this.oneOf = oneOf;
        this.pattern = pattern;
        this.properties = properties;
        this.required = required;
        this.type = type;
        this.uniqueItems = uniqueItems;
        this.xKubernetesIntOrString = xKubernetesIntOrString;
        this.xKubernetesPreserveUnknownFields = xKubernetesPreserveUnknownFields;
        this.xKubernetesValidations = xKubernetesValidations;
        this.xMetadata = xMetadata;
    }

    /**
     * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
     */
    @JsonProperty("additionalProperties")
    public io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps getAdditionalProperties() {
        return additionalProperties;
    }

    /**
     * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
     */
    @JsonProperty("additionalProperties")
    public void setAdditionalProperties(io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    /**
     * allOf specifies that the variable must validate against all of the subschemas in the array. NOTE: This field uses PreserveUnknownFields and Schemaless, because recursive validation is not possible.
     */
    @JsonProperty("allOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> getAllOf() {
        return allOf;
    }

    /**
     * allOf specifies that the variable must validate against all of the subschemas in the array. NOTE: This field uses PreserveUnknownFields and Schemaless, because recursive validation is not possible.
     */
    @JsonProperty("allOf")
    public void setAllOf(List<io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> allOf) {
        this.allOf = allOf;
    }

    /**
     * anyOf specifies that the variable must validate against one or more of the subschemas in the array. NOTE: This field uses PreserveUnknownFields and Schemaless, because recursive validation is not possible.
     */
    @JsonProperty("anyOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> getAnyOf() {
        return anyOf;
    }

    /**
     * anyOf specifies that the variable must validate against one or more of the subschemas in the array. NOTE: This field uses PreserveUnknownFields and Schemaless, because recursive validation is not possible.
     */
    @JsonProperty("anyOf")
    public void setAnyOf(List<io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> anyOf) {
        this.anyOf = anyOf;
    }

    /**
     * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
     */
    @JsonProperty("default")
    public JsonNode getDefault() {
        return _default;
    }

    /**
     * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
     */
    @JsonProperty("default")
    public void setDefault(JsonNode _default) {
        this._default = _default;
    }

    /**
     * description is a human-readable description of this variable.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description is a human-readable description of this variable.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * enum is the list of valid values of the variable. NOTE: Can be set for all types.
     */
    @JsonProperty("enum")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<JsonNode> getEnum() {
        return _enum;
    }

    /**
     * enum is the list of valid values of the variable. NOTE: Can be set for all types.
     */
    @JsonProperty("enum")
    public void setEnum(List<JsonNode> _enum) {
        this._enum = _enum;
    }

    /**
     * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
     */
    @JsonProperty("example")
    public JsonNode getExample() {
        return example;
    }

    /**
     * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
     */
    @JsonProperty("example")
    public void setExample(JsonNode example) {
        this.example = example;
    }

    /**
     * exclusiveMaximum specifies if the Maximum is exclusive. NOTE: Can only be set if type is integer or number.
     */
    @JsonProperty("exclusiveMaximum")
    public Boolean getExclusiveMaximum() {
        return exclusiveMaximum;
    }

    /**
     * exclusiveMaximum specifies if the Maximum is exclusive. NOTE: Can only be set if type is integer or number.
     */
    @JsonProperty("exclusiveMaximum")
    public void setExclusiveMaximum(Boolean exclusiveMaximum) {
        this.exclusiveMaximum = exclusiveMaximum;
    }

    /**
     * exclusiveMinimum specifies if the Minimum is exclusive. NOTE: Can only be set if type is integer or number.
     */
    @JsonProperty("exclusiveMinimum")
    public Boolean getExclusiveMinimum() {
        return exclusiveMinimum;
    }

    /**
     * exclusiveMinimum specifies if the Minimum is exclusive. NOTE: Can only be set if type is integer or number.
     */
    @JsonProperty("exclusiveMinimum")
    public void setExclusiveMinimum(Boolean exclusiveMinimum) {
        this.exclusiveMinimum = exclusiveMinimum;
    }

    /**
     * format is an OpenAPI v3 format string. Unknown formats are ignored. For a list of supported formats please see: (of the k8s.io/apiextensions-apiserver version we're currently using) https://github.com/kubernetes/apiextensions-apiserver/blob/master/pkg/apiserver/validation/formats.go NOTE: Can only be set if type is string.
     */
    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    /**
     * format is an OpenAPI v3 format string. Unknown formats are ignored. For a list of supported formats please see: (of the k8s.io/apiextensions-apiserver version we're currently using) https://github.com/kubernetes/apiextensions-apiserver/blob/master/pkg/apiserver/validation/formats.go NOTE: Can only be set if type is string.
     */
    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
     */
    @JsonProperty("items")
    public io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps getItems() {
        return items;
    }

    /**
     * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
     */
    @JsonProperty("items")
    public void setItems(io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps items) {
        this.items = items;
    }

    /**
     * maxItems is the max length of an array variable. NOTE: Can only be set if type is array.
     */
    @JsonProperty("maxItems")
    public Long getMaxItems() {
        return maxItems;
    }

    /**
     * maxItems is the max length of an array variable. NOTE: Can only be set if type is array.
     */
    @JsonProperty("maxItems")
    public void setMaxItems(Long maxItems) {
        this.maxItems = maxItems;
    }

    /**
     * maxLength is the max length of a string variable. NOTE: Can only be set if type is string.
     */
    @JsonProperty("maxLength")
    public Long getMaxLength() {
        return maxLength;
    }

    /**
     * maxLength is the max length of a string variable. NOTE: Can only be set if type is string.
     */
    @JsonProperty("maxLength")
    public void setMaxLength(Long maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * maxProperties is the maximum amount of entries in a map or properties in an object. NOTE: Can only be set if type is object.
     */
    @JsonProperty("maxProperties")
    public Long getMaxProperties() {
        return maxProperties;
    }

    /**
     * maxProperties is the maximum amount of entries in a map or properties in an object. NOTE: Can only be set if type is object.
     */
    @JsonProperty("maxProperties")
    public void setMaxProperties(Long maxProperties) {
        this.maxProperties = maxProperties;
    }

    /**
     * maximum is the maximum of an integer or number variable. If ExclusiveMaximum is false, the variable is valid if it is lower than, or equal to, the value of Maximum. If ExclusiveMaximum is true, the variable is valid if it is strictly lower than the value of Maximum. NOTE: Can only be set if type is integer or number.
     */
    @JsonProperty("maximum")
    public Long getMaximum() {
        return maximum;
    }

    /**
     * maximum is the maximum of an integer or number variable. If ExclusiveMaximum is false, the variable is valid if it is lower than, or equal to, the value of Maximum. If ExclusiveMaximum is true, the variable is valid if it is strictly lower than the value of Maximum. NOTE: Can only be set if type is integer or number.
     */
    @JsonProperty("maximum")
    public void setMaximum(Long maximum) {
        this.maximum = maximum;
    }

    /**
     * minItems is the min length of an array variable. NOTE: Can only be set if type is array.
     */
    @JsonProperty("minItems")
    public Long getMinItems() {
        return minItems;
    }

    /**
     * minItems is the min length of an array variable. NOTE: Can only be set if type is array.
     */
    @JsonProperty("minItems")
    public void setMinItems(Long minItems) {
        this.minItems = minItems;
    }

    /**
     * minLength is the min length of a string variable. NOTE: Can only be set if type is string.
     */
    @JsonProperty("minLength")
    public Long getMinLength() {
        return minLength;
    }

    /**
     * minLength is the min length of a string variable. NOTE: Can only be set if type is string.
     */
    @JsonProperty("minLength")
    public void setMinLength(Long minLength) {
        this.minLength = minLength;
    }

    /**
     * minProperties is the minimum amount of entries in a map or properties in an object. NOTE: Can only be set if type is object.
     */
    @JsonProperty("minProperties")
    public Long getMinProperties() {
        return minProperties;
    }

    /**
     * minProperties is the minimum amount of entries in a map or properties in an object. NOTE: Can only be set if type is object.
     */
    @JsonProperty("minProperties")
    public void setMinProperties(Long minProperties) {
        this.minProperties = minProperties;
    }

    /**
     * minimum is the minimum of an integer or number variable. If ExclusiveMinimum is false, the variable is valid if it is greater than, or equal to, the value of Minimum. If ExclusiveMinimum is true, the variable is valid if it is strictly greater than the value of Minimum. NOTE: Can only be set if type is integer or number.
     */
    @JsonProperty("minimum")
    public Long getMinimum() {
        return minimum;
    }

    /**
     * minimum is the minimum of an integer or number variable. If ExclusiveMinimum is false, the variable is valid if it is greater than, or equal to, the value of Minimum. If ExclusiveMinimum is true, the variable is valid if it is strictly greater than the value of Minimum. NOTE: Can only be set if type is integer or number.
     */
    @JsonProperty("minimum")
    public void setMinimum(Long minimum) {
        this.minimum = minimum;
    }

    /**
     * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
     */
    @JsonProperty("not")
    public io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps getNot() {
        return not;
    }

    /**
     * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
     */
    @JsonProperty("not")
    public void setNot(io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps not) {
        this.not = not;
    }

    /**
     * oneOf specifies that the variable must validate against exactly one of the subschemas in the array. NOTE: This field uses PreserveUnknownFields and Schemaless, because recursive validation is not possible.
     */
    @JsonProperty("oneOf")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> getOneOf() {
        return oneOf;
    }

    /**
     * oneOf specifies that the variable must validate against exactly one of the subschemas in the array. NOTE: This field uses PreserveUnknownFields and Schemaless, because recursive validation is not possible.
     */
    @JsonProperty("oneOf")
    public void setOneOf(List<io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> oneOf) {
        this.oneOf = oneOf;
    }

    /**
     * pattern is the regex which a string variable must match. NOTE: Can only be set if type is string.
     */
    @JsonProperty("pattern")
    public String getPattern() {
        return pattern;
    }

    /**
     * pattern is the regex which a string variable must match. NOTE: Can only be set if type is string.
     */
    @JsonProperty("pattern")
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * properties specifies fields of an object. NOTE: Can only be set if type is object. NOTE: Properties is mutually exclusive with AdditionalProperties. NOTE: This field uses PreserveUnknownFields and Schemaless, because recursive validation is not possible.
     */
    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> getProperties() {
        return properties;
    }

    /**
     * properties specifies fields of an object. NOTE: Can only be set if type is object. NOTE: Properties is mutually exclusive with AdditionalProperties. NOTE: This field uses PreserveUnknownFields and Schemaless, because recursive validation is not possible.
     */
    @JsonProperty("properties")
    public void setProperties(Map<String, io.fabric8.kubernetes.api.model.clusterapi.v1beta1.JSONSchemaProps> properties) {
        this.properties = properties;
    }

    /**
     * required specifies which fields of an object are required. NOTE: Can only be set if type is object.
     */
    @JsonProperty("required")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRequired() {
        return required;
    }

    /**
     * required specifies which fields of an object are required. NOTE: Can only be set if type is object.
     */
    @JsonProperty("required")
    public void setRequired(List<String> required) {
        this.required = required;
    }

    /**
     * type is the type of the variable. Valid values are: object, array, string, integer, number or boolean.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the type of the variable. Valid values are: object, array, string, integer, number or boolean.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * uniqueItems specifies if items in an array must be unique. NOTE: Can only be set if type is array.
     */
    @JsonProperty("uniqueItems")
    public Boolean getUniqueItems() {
        return uniqueItems;
    }

    /**
     * uniqueItems specifies if items in an array must be unique. NOTE: Can only be set if type is array.
     */
    @JsonProperty("uniqueItems")
    public void setUniqueItems(Boolean uniqueItems) {
        this.uniqueItems = uniqueItems;
    }

    /**
     * x-kubernetes-int-or-string specifies that this value is either an integer or a string. If this is true, an empty type is allowed and type as child of anyOf is permitted if following one of the following patterns:<br><p> <br><p> 1) anyOf:<br><p>    - type: integer<br><p>    - type: string<br><p> 2) allOf:<br><p>    - anyOf:<br><p>      - type: integer<br><p>      - type: string<br><p>    - ... zero or more
     */
    @JsonProperty("x-kubernetes-int-or-string")
    public Boolean getXKubernetesIntOrString() {
        return xKubernetesIntOrString;
    }

    /**
     * x-kubernetes-int-or-string specifies that this value is either an integer or a string. If this is true, an empty type is allowed and type as child of anyOf is permitted if following one of the following patterns:<br><p> <br><p> 1) anyOf:<br><p>    - type: integer<br><p>    - type: string<br><p> 2) allOf:<br><p>    - anyOf:<br><p>      - type: integer<br><p>      - type: string<br><p>    - ... zero or more
     */
    @JsonProperty("x-kubernetes-int-or-string")
    public void setXKubernetesIntOrString(Boolean xKubernetesIntOrString) {
        this.xKubernetesIntOrString = xKubernetesIntOrString;
    }

    /**
     * x-kubernetes-preserve-unknown-fields allows setting fields in a variable object which are not defined in the variable schema. This affects fields recursively, except if nested properties or additionalProperties are specified in the schema.
     */
    @JsonProperty("x-kubernetes-preserve-unknown-fields")
    public Boolean getXKubernetesPreserveUnknownFields() {
        return xKubernetesPreserveUnknownFields;
    }

    /**
     * x-kubernetes-preserve-unknown-fields allows setting fields in a variable object which are not defined in the variable schema. This affects fields recursively, except if nested properties or additionalProperties are specified in the schema.
     */
    @JsonProperty("x-kubernetes-preserve-unknown-fields")
    public void setXKubernetesPreserveUnknownFields(Boolean xKubernetesPreserveUnknownFields) {
        this.xKubernetesPreserveUnknownFields = xKubernetesPreserveUnknownFields;
    }

    /**
     * x-kubernetes-validations describes a list of validation rules written in the CEL expression language.
     */
    @JsonProperty("x-kubernetes-validations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ValidationRule> getXKubernetesValidations() {
        return xKubernetesValidations;
    }

    /**
     * x-kubernetes-validations describes a list of validation rules written in the CEL expression language.
     */
    @JsonProperty("x-kubernetes-validations")
    public void setXKubernetesValidations(List<ValidationRule> xKubernetesValidations) {
        this.xKubernetesValidations = xKubernetesValidations;
    }

    /**
     * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
     */
    @JsonProperty("x-metadata")
    public VariableSchemaMetadata getXMetadata() {
        return xMetadata;
    }

    /**
     * JSONSchemaProps is a JSON-Schema following Specification Draft 4 (http://json-schema.org/). This struct has been initially copied from apiextensionsv1.JSONSchemaProps, but all fields which are not supported in CAPI have been removed.
     */
    @JsonProperty("x-metadata")
    public void setXMetadata(VariableSchemaMetadata xMetadata) {
        this.xMetadata = xMetadata;
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
