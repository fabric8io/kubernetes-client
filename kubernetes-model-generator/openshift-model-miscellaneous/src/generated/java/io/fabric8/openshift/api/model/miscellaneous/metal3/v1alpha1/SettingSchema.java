
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

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

/**
 * Additional data describing the firmware setting.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowable_values",
    "attribute_type",
    "lower_bound",
    "max_length",
    "min_length",
    "read_only",
    "unique",
    "upper_bound"
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
public class SettingSchema implements Editable<SettingSchemaBuilder>, KubernetesResource
{

    @JsonProperty("allowable_values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowableValues = new ArrayList<>();
    @JsonProperty("attribute_type")
    private String attributeType;
    @JsonProperty("lower_bound")
    private Integer lowerBound;
    @JsonProperty("max_length")
    private Integer maxLength;
    @JsonProperty("min_length")
    private Integer minLength;
    @JsonProperty("read_only")
    private Boolean readOnly;
    @JsonProperty("unique")
    private Boolean unique;
    @JsonProperty("upper_bound")
    private Integer upperBound;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SettingSchema() {
    }

    public SettingSchema(List<String> allowableValues, String attributeType, Integer lowerBound, Integer maxLength, Integer minLength, Boolean readOnly, Boolean unique, Integer upperBound) {
        super();
        this.allowableValues = allowableValues;
        this.attributeType = attributeType;
        this.lowerBound = lowerBound;
        this.maxLength = maxLength;
        this.minLength = minLength;
        this.readOnly = readOnly;
        this.unique = unique;
        this.upperBound = upperBound;
    }

    /**
     * The allowable value for an Enumeration type setting.
     */
    @JsonProperty("allowable_values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowableValues() {
        return allowableValues;
    }

    /**
     * The allowable value for an Enumeration type setting.
     */
    @JsonProperty("allowable_values")
    public void setAllowableValues(List<String> allowableValues) {
        this.allowableValues = allowableValues;
    }

    /**
     * The type of setting.
     */
    @JsonProperty("attribute_type")
    public String getAttributeType() {
        return attributeType;
    }

    /**
     * The type of setting.
     */
    @JsonProperty("attribute_type")
    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    /**
     * The lowest value for an Integer type setting.
     */
    @JsonProperty("lower_bound")
    public Integer getLowerBound() {
        return lowerBound;
    }

    /**
     * The lowest value for an Integer type setting.
     */
    @JsonProperty("lower_bound")
    public void setLowerBound(Integer lowerBound) {
        this.lowerBound = lowerBound;
    }

    /**
     * Maximum length for a String type setting.
     */
    @JsonProperty("max_length")
    public Integer getMaxLength() {
        return maxLength;
    }

    /**
     * Maximum length for a String type setting.
     */
    @JsonProperty("max_length")
    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * Minimum length for a String type setting.
     */
    @JsonProperty("min_length")
    public Integer getMinLength() {
        return minLength;
    }

    /**
     * Minimum length for a String type setting.
     */
    @JsonProperty("min_length")
    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    /**
     * Whether or not this setting is read only.
     */
    @JsonProperty("read_only")
    public Boolean getReadOnly() {
        return readOnly;
    }

    /**
     * Whether or not this setting is read only.
     */
    @JsonProperty("read_only")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * Whether or not this setting's value is unique to this node, e.g. a serial number.
     */
    @JsonProperty("unique")
    public Boolean getUnique() {
        return unique;
    }

    /**
     * Whether or not this setting's value is unique to this node, e.g. a serial number.
     */
    @JsonProperty("unique")
    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    /**
     * The highest value for an Integer type setting.
     */
    @JsonProperty("upper_bound")
    public Integer getUpperBound() {
        return upperBound;
    }

    /**
     * The highest value for an Integer type setting.
     */
    @JsonProperty("upper_bound")
    public void setUpperBound(Integer upperBound) {
        this.upperBound = upperBound;
    }

    @JsonIgnore
    public SettingSchemaBuilder edit() {
        return new SettingSchemaBuilder(this);
    }

    @JsonIgnore
    public SettingSchemaBuilder toBuilder() {
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
