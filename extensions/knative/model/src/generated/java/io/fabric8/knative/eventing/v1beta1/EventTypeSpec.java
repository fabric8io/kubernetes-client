
package io.fabric8.knative.eventing.v1beta1;

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
import io.fabric8.knative.duck.v1.KReference;
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
    "broker",
    "description",
    "reference",
    "schema",
    "schemaData",
    "source",
    "type"
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
public class EventTypeSpec implements Editable<EventTypeSpecBuilder>, KubernetesResource
{

    @JsonProperty("broker")
    private String broker;
    @JsonProperty("description")
    private String description;
    @JsonProperty("reference")
    private KReference reference;
    @JsonProperty("schema")
    private String schema;
    @JsonProperty("schemaData")
    private String schemaData;
    @JsonProperty("source")
    private String source;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EventTypeSpec() {
    }

    public EventTypeSpec(String broker, String description, KReference reference, String schema, String schemaData, String source, String type) {
        super();
        this.broker = broker;
        this.description = description;
        this.reference = reference;
        this.schema = schema;
        this.schemaData = schemaData;
        this.source = source;
        this.type = type;
    }

    /**
     * Broker refers to the Broker that can provide the EventType.
     */
    @JsonProperty("broker")
    public String getBroker() {
        return broker;
    }

    /**
     * Broker refers to the Broker that can provide the EventType.
     */
    @JsonProperty("broker")
    public void setBroker(String broker) {
        this.broker = broker;
    }

    /**
     * Description is an optional field used to describe the EventType, in any meaningful way.
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * Description is an optional field used to describe the EventType, in any meaningful way.
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("reference")
    public KReference getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(KReference reference) {
        this.reference = reference;
    }

    @JsonProperty("schema")
    public String getSchema() {
        return schema;
    }

    @JsonProperty("schema")
    public void setSchema(String schema) {
        this.schema = schema;
    }

    /**
     * SchemaData allows the CloudEvents schema to be stored directly in the EventType. Content is dependent on the encoding. Optional attribute. The contents are not validated or manipulated by the system.
     */
    @JsonProperty("schemaData")
    public String getSchemaData() {
        return schemaData;
    }

    /**
     * SchemaData allows the CloudEvents schema to be stored directly in the EventType. Content is dependent on the encoding. Optional attribute. The contents are not validated or manipulated by the system.
     */
    @JsonProperty("schemaData")
    public void setSchemaData(String schemaData) {
        this.schemaData = schemaData;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Type represents the CloudEvents type. It is authoritative.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type represents the CloudEvents type. It is authoritative.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public EventTypeSpecBuilder edit() {
        return new EventTypeSpecBuilder(this);
    }

    @JsonIgnore
    public EventTypeSpecBuilder toBuilder() {
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
