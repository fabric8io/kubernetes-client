
package io.fabric8.tekton.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

/**
 * ParamSpec defines arbitrary parameters needed beyond typed inputs (such as resources). Parameter values are provided by users as inputs on a TaskRun or PipelineRun.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "default",
    "description",
    "enum",
    "name",
    "properties",
    "type"
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
public class ParamSpec implements Editable<ParamSpecBuilder>, KubernetesResource
{

    @JsonProperty("default")
    private ParamValue _default;
    @JsonProperty("description")
    private String description;
    @JsonProperty("enum")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> _enum = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, PropertySpec> properties = new LinkedHashMap<>();
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ParamSpec() {
    }

    public ParamSpec(ParamValue _default, String description, List<String> _enum, String name, Map<String, PropertySpec> properties, String type) {
        super();
        this._default = _default;
        this.description = description;
        this._enum = _enum;
        this.name = name;
        this.properties = properties;
        this.type = type;
    }

    /**
     * ParamSpec defines arbitrary parameters needed beyond typed inputs (such as resources). Parameter values are provided by users as inputs on a TaskRun or PipelineRun.
     */
    @JsonProperty("default")
    public ParamValue getDefault() {
        return _default;
    }

    /**
     * ParamSpec defines arbitrary parameters needed beyond typed inputs (such as resources). Parameter values are provided by users as inputs on a TaskRun or PipelineRun.
     */
    @JsonProperty("default")
    public void setDefault(ParamValue _default) {
        this._default = _default;
    }

    /**
     * Description is a user-facing description of the parameter that may be used to populate a UI.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description is a user-facing description of the parameter that may be used to populate a UI.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Enum declares a set of allowed param input values for tasks/pipelines that can be validated. If Enum is not set, no input validation is performed for the param.
     */
    @JsonProperty("enum")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEnum() {
        return _enum;
    }

    /**
     * Enum declares a set of allowed param input values for tasks/pipelines that can be validated. If Enum is not set, no input validation is performed for the param.
     */
    @JsonProperty("enum")
    public void setEnum(List<String> _enum) {
        this._enum = _enum;
    }

    /**
     * Name declares the name by which a parameter is referenced.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name declares the name by which a parameter is referenced.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Properties is the JSON Schema properties to support key-value pairs parameter.
     */
    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, PropertySpec> getProperties() {
        return properties;
    }

    /**
     * Properties is the JSON Schema properties to support key-value pairs parameter.
     */
    @JsonProperty("properties")
    public void setProperties(Map<String, PropertySpec> properties) {
        this.properties = properties;
    }

    /**
     * Type is the user-specified type of the parameter. The possible types are currently "string", "array" and "object", and "string" is the default.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type is the user-specified type of the parameter. The possible types are currently "string", "array" and "object", and "string" is the default.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public ParamSpecBuilder edit() {
        return new ParamSpecBuilder(this);
    }

    @JsonIgnore
    public ParamSpecBuilder toBuilder() {
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
        if (!(o instanceof ParamSpec)) {
            return false;
        }
        ParamSpec other = (ParamSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$_default = this.getDefault();
        Object other$_default = other.getDefault();
        if (this$_default == null ? other$_default != null : !this$_default.equals(other$_default)) {
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
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$properties = this.getProperties();
        Object other$properties = other.getProperties();
        if (this$properties == null ? other$properties != null : !this$properties.equals(other$properties)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof ParamSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $_default = this.getDefault();
        result = result * prime + ($_default == null ? 43 : $_default.hashCode());
        Object $description = this.getDescription();
        result = result * prime + ($description == null ? 43 : $description.hashCode());
        Object $_enum = this.getEnum();
        result = result * prime + ($_enum == null ? 43 : $_enum.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $properties = this.getProperties();
        result = result * prime + ($properties == null ? 43 : $properties.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ParamSpec(" + "_default=" + this.getDefault() + ", description=" + this.getDescription() + ", _enum=" + this.getEnum() + ", name=" + this.getName() + ", properties=" + this.getProperties() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
