
package io.fabric8.openshift.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Parameter defines a name/value variable that is to be processed during the Template to Config transformation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "displayName",
    "from",
    "generate",
    "name",
    "required",
    "value"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Parameter implements Editable<ParameterBuilder>, KubernetesResource
{

    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("from")
    private String from;
    @JsonProperty("generate")
    private String generate;
    @JsonProperty("name")
    private String name;
    @JsonProperty("required")
    private Boolean required;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Parameter() {
    }

    public Parameter(String description, String displayName, String from, String generate, String name, Boolean required, String value) {
        super();
        this.description = description;
        this.displayName = displayName;
        this.from = from;
        this.generate = generate;
        this.name = name;
        this.required = required;
        this.value = value;
    }

    /**
     * description of a parameter. Optional.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * description of a parameter. Optional.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Optional: The name that will show in UI instead of parameter 'Name'
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Optional: The name that will show in UI instead of parameter 'Name'
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * from is an input value for the generator. Optional.
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * from is an input value for the generator. Optional.
     */
    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * generate specifies the generator to be used to generate random string from an input value specified by From field. The result string is stored into Value field. If empty, no generator is being used, leaving the result Value untouched. Optional.<br><p> <br><p> The only supported generator is "expression", which accepts a "from" value in the form of a simple regular expression containing the range expression "[a-zA-Z0-9]", and the length expression "a{length}".<br><p> <br><p> Examples:<br><p> <br><p> from             | value ----------------------------- "test[0-9]{1}x"  | "test7x" "[0-1]{8}"       | "01001100" "0x[A-F0-9]{4}"  | "0xB3AF" "[a-zA-Z0-9]{8}" | "hW4yQU5i"
     */
    @JsonProperty("generate")
    public String getGenerate() {
        return generate;
    }

    /**
     * generate specifies the generator to be used to generate random string from an input value specified by From field. The result string is stored into Value field. If empty, no generator is being used, leaving the result Value untouched. Optional.<br><p> <br><p> The only supported generator is "expression", which accepts a "from" value in the form of a simple regular expression containing the range expression "[a-zA-Z0-9]", and the length expression "a{length}".<br><p> <br><p> Examples:<br><p> <br><p> from             | value ----------------------------- "test[0-9]{1}x"  | "test7x" "[0-1]{8}"       | "01001100" "0x[A-F0-9]{4}"  | "0xB3AF" "[a-zA-Z0-9]{8}" | "hW4yQU5i"
     */
    @JsonProperty("generate")
    public void setGenerate(String generate) {
        this.generate = generate;
    }

    /**
     * name must be set and it can be referenced in Template Items using ${PARAMETER_NAME}. Required.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name must be set and it can be referenced in Template Items using ${PARAMETER_NAME}. Required.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Optional: Indicates the parameter must have a value.  Defaults to false.
     */
    @JsonProperty("required")
    public Boolean getRequired() {
        return required;
    }

    /**
     * Optional: Indicates the parameter must have a value.  Defaults to false.
     */
    @JsonProperty("required")
    public void setRequired(Boolean required) {
        this.required = required;
    }

    /**
     * value holds the Parameter data. If specified, the generator will be ignored. The value replaces all occurrences of the Parameter ${Name} expression during the Template to Config transformation. Optional.
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * value holds the Parameter data. If specified, the generator will be ignored. The value replaces all occurrences of the Parameter ${Name} expression during the Template to Config transformation. Optional.
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public ParameterBuilder edit() {
        return new ParameterBuilder(this);
    }

    @JsonIgnore
    public ParameterBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    @JsonIgnore
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Parameter)) {
            return false;
        }
        Parameter other = (Parameter) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$description = this.getDescription();
        Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description)) {
            return false;
        }
        Object this$displayName = this.getDisplayName();
        Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName)) {
            return false;
        }
        Object this$from = this.getFrom();
        Object other$from = other.getFrom();
        if (this$from == null ? other$from != null : !this$from.equals(other$from)) {
            return false;
        }
        Object this$generate = this.getGenerate();
        Object other$generate = other.getGenerate();
        if (this$generate == null ? other$generate != null : !this$generate.equals(other$generate)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$required = this.getRequired();
        Object other$required = other.getRequired();
        if (this$required == null ? other$required != null : !this$required.equals(other$required)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Parameter;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $displayName = this.getDisplayName();
        result = result * prime + ($displayName == null ? 43 : $displayName.hashCode());
        Object $from = this.getFrom();
        result = result * prime + ($from == null ? 43 : $from.hashCode());
        Object $generate = this.getGenerate();
        result = result * prime + ($generate == null ? 43 : $generate.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $required = this.getRequired();
        result = result * prime + ($required == null ? 43 : $required.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Parameter(" + "description=" + this.getDescription() + ", displayName=" + this.getDisplayName() + ", from=" + this.getFrom() + ", generate=" + this.getGenerate() + ", name=" + this.getName() + ", required=" + this.getRequired() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
