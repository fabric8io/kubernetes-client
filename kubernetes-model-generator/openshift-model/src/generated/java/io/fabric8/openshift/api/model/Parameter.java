
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
