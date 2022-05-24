
package io.fabric8.camelk.v1alpha1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
    "$schema",
    "description",
    "example",
    "externalDocs",
    "id",
    "properties",
    "required",
    "title",
    "type"
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
public class JSONSchemaProps implements KubernetesResource
{

    @JsonProperty("$schema")
    private java.lang.String $schema;
    @JsonProperty("description")
    private java.lang.String description;
    @JsonProperty("example")
    private JsonNode example;
    @JsonProperty("externalDocs")
    private ExternalDocumentation externalDocs;
    @JsonProperty("id")
    private java.lang.String id;
    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, JSONSchemaProp> properties = new LinkedHashMap<String, JSONSchemaProp>();
    @JsonProperty("required")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> required = new ArrayList<java.lang.String>();
    @JsonProperty("title")
    private java.lang.String title;
    @JsonProperty("type")
    private java.lang.String type;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public JSONSchemaProps() {
    }

    /**
     * 
     * @param $schema
     * @param description
     * @param externalDocs
     * @param id
     * @param title
     * @param type
     * @param properties
     * @param required
     * @param example
     */
    public JSONSchemaProps(java.lang.String $schema, java.lang.String description, JsonNode example, ExternalDocumentation externalDocs, java.lang.String id, Map<String, JSONSchemaProp> properties, List<java.lang.String> required, java.lang.String title, java.lang.String type) {
        super();
        this.$schema = $schema;
        this.description = description;
        this.example = example;
        this.externalDocs = externalDocs;
        this.id = id;
        this.properties = properties;
        this.required = required;
        this.title = title;
        this.type = type;
    }

    @JsonProperty("$schema")
    public java.lang.String get$schema() {
        return $schema;
    }

    @JsonProperty("$schema")
    public void set$schema(java.lang.String $schema) {
        this.$schema = $schema;
    }

    @JsonProperty("description")
    public java.lang.String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    @JsonProperty("example")
    public JsonNode getExample() {
        return example;
    }

    @JsonProperty("example")
    public void setExample(JsonNode example) {
        this.example = example;
    }

    @JsonProperty("externalDocs")
    public ExternalDocumentation getExternalDocs() {
        return externalDocs;
    }

    @JsonProperty("externalDocs")
    public void setExternalDocs(ExternalDocumentation externalDocs) {
        this.externalDocs = externalDocs;
    }

    @JsonProperty("id")
    public java.lang.String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(java.lang.String id) {
        this.id = id;
    }

    @JsonProperty("properties")
    public Map<String, JSONSchemaProp> getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Map<String, JSONSchemaProp> properties) {
        this.properties = properties;
    }

    @JsonProperty("required")
    public List<java.lang.String> getRequired() {
        return required;
    }

    @JsonProperty("required")
    public void setRequired(List<java.lang.String> required) {
        this.required = required;
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

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
