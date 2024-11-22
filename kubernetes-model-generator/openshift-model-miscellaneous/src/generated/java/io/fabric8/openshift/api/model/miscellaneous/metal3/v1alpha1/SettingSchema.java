
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
public class SettingSchema implements Editable<SettingSchemaBuilder> , KubernetesResource
{

    @JsonProperty("allowable_values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowable_values = new ArrayList<>();
    @JsonProperty("attribute_type")
    private String attribute_type;
    @JsonProperty("lower_bound")
    private Integer lower_bound;
    @JsonProperty("max_length")
    private Integer max_length;
    @JsonProperty("min_length")
    private Integer min_length;
    @JsonProperty("read_only")
    private Boolean read_only;
    @JsonProperty("unique")
    private Boolean unique;
    @JsonProperty("upper_bound")
    private Integer upper_bound;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SettingSchema() {
    }

    public SettingSchema(List<String> allowable_values, String attribute_type, Integer lower_bound, Integer max_length, Integer min_length, Boolean read_only, Boolean unique, Integer upper_bound) {
        super();
        this.allowable_values = allowable_values;
        this.attribute_type = attribute_type;
        this.lower_bound = lower_bound;
        this.max_length = max_length;
        this.min_length = min_length;
        this.read_only = read_only;
        this.unique = unique;
        this.upper_bound = upper_bound;
    }

    @JsonProperty("allowable_values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowable_values() {
        return allowable_values;
    }

    @JsonProperty("allowable_values")
    public void setAllowable_values(List<String> allowable_values) {
        this.allowable_values = allowable_values;
    }

    @JsonProperty("attribute_type")
    public String getAttribute_type() {
        return attribute_type;
    }

    @JsonProperty("attribute_type")
    public void setAttribute_type(String attribute_type) {
        this.attribute_type = attribute_type;
    }

    @JsonProperty("lower_bound")
    public Integer getLower_bound() {
        return lower_bound;
    }

    @JsonProperty("lower_bound")
    public void setLower_bound(Integer lower_bound) {
        this.lower_bound = lower_bound;
    }

    @JsonProperty("max_length")
    public Integer getMax_length() {
        return max_length;
    }

    @JsonProperty("max_length")
    public void setMax_length(Integer max_length) {
        this.max_length = max_length;
    }

    @JsonProperty("min_length")
    public Integer getMin_length() {
        return min_length;
    }

    @JsonProperty("min_length")
    public void setMin_length(Integer min_length) {
        this.min_length = min_length;
    }

    @JsonProperty("read_only")
    public Boolean getRead_only() {
        return read_only;
    }

    @JsonProperty("read_only")
    public void setRead_only(Boolean read_only) {
        this.read_only = read_only;
    }

    @JsonProperty("unique")
    public Boolean getUnique() {
        return unique;
    }

    @JsonProperty("unique")
    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    @JsonProperty("upper_bound")
    public Integer getUpper_bound() {
        return upper_bound;
    }

    @JsonProperty("upper_bound")
    public void setUpper_bound(Integer upper_bound) {
        this.upper_bound = upper_bound;
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
