
package io.fabric8.tekton.v1beta1;

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
 * TaskResult used to describe the results of a task
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "name",
    "properties",
    "type",
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class TaskResult implements Editable<TaskResultBuilder>, KubernetesResource
{

    @JsonProperty("description")
    private String description;
    @JsonProperty("name")
    private String name;
    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, PropertySpec> properties = new LinkedHashMap<>();
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private ParamValue value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TaskResult() {
    }

    public TaskResult(String description, String name, Map<String, PropertySpec> properties, String type, ParamValue value) {
        super();
        this.description = description;
        this.name = name;
        this.properties = properties;
        this.type = type;
        this.value = value;
    }

    /**
     * Description is a human-readable description of the result
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description is a human-readable description of the result
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Name the given name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name the given name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Properties is the JSON Schema properties to support key-value pairs results.
     */
    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, PropertySpec> getProperties() {
        return properties;
    }

    /**
     * Properties is the JSON Schema properties to support key-value pairs results.
     */
    @JsonProperty("properties")
    public void setProperties(Map<String, PropertySpec> properties) {
        this.properties = properties;
    }

    /**
     * Type is the user-specified type of the result. The possible type is currently "string" and will support "array" in following work.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type is the user-specified type of the result. The possible type is currently "string" and will support "array" in following work.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * TaskResult used to describe the results of a task
     */
    @JsonProperty("value")
    public ParamValue getValue() {
        return value;
    }

    /**
     * TaskResult used to describe the results of a task
     */
    @JsonProperty("value")
    public void setValue(ParamValue value) {
        this.value = value;
    }

    @JsonIgnore
    public TaskResultBuilder edit() {
        return new TaskResultBuilder(this);
    }

    @JsonIgnore
    public TaskResultBuilder toBuilder() {
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
