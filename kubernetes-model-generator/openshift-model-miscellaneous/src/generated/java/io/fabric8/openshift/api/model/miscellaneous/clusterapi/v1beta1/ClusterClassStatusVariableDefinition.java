
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

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
 * ClusterClassStatusVariableDefinition defines a variable which appears in the status of a ClusterClass.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "from",
    "required",
    "schema"
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
public class ClusterClassStatusVariableDefinition implements Editable<ClusterClassStatusVariableDefinitionBuilder>, KubernetesResource
{

    @JsonProperty("from")
    private String from;
    @JsonProperty("metadata")
    private ClusterClassVariableMetadata metadata;
    @JsonProperty("required")
    private Boolean required;
    @JsonProperty("schema")
    private VariableSchema schema;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterClassStatusVariableDefinition() {
    }

    public ClusterClassStatusVariableDefinition(String from, ClusterClassVariableMetadata metadata, Boolean required, VariableSchema schema) {
        super();
        this.from = from;
        this.metadata = metadata;
        this.required = required;
        this.schema = schema;
    }

    /**
     * from specifies the origin of the variable definition. This will be `inline` for variables defined in the ClusterClass or the name of a patch defined in the ClusterClass for variables discovered from a DiscoverVariables runtime extensions.
     */
    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    /**
     * from specifies the origin of the variable definition. This will be `inline` for variables defined in the ClusterClass or the name of a patch defined in the ClusterClass for variables discovered from a DiscoverVariables runtime extensions.
     */
    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * ClusterClassStatusVariableDefinition defines a variable which appears in the status of a ClusterClass.
     */
    @JsonProperty("metadata")
    public ClusterClassVariableMetadata getMetadata() {
        return metadata;
    }

    /**
     * ClusterClassStatusVariableDefinition defines a variable which appears in the status of a ClusterClass.
     */
    @JsonProperty("metadata")
    public void setMetadata(ClusterClassVariableMetadata metadata) {
        this.metadata = metadata;
    }

    /**
     * required specifies if the variable is required. Note: this applies to the variable as a whole and thus the top-level object defined in the schema. If nested fields are required, this will be specified inside the schema.
     */
    @JsonProperty("required")
    public Boolean getRequired() {
        return required;
    }

    /**
     * required specifies if the variable is required. Note: this applies to the variable as a whole and thus the top-level object defined in the schema. If nested fields are required, this will be specified inside the schema.
     */
    @JsonProperty("required")
    public void setRequired(Boolean required) {
        this.required = required;
    }

    /**
     * ClusterClassStatusVariableDefinition defines a variable which appears in the status of a ClusterClass.
     */
    @JsonProperty("schema")
    public VariableSchema getSchema() {
        return schema;
    }

    /**
     * ClusterClassStatusVariableDefinition defines a variable which appears in the status of a ClusterClass.
     */
    @JsonProperty("schema")
    public void setSchema(VariableSchema schema) {
        this.schema = schema;
    }

    @JsonIgnore
    public ClusterClassStatusVariableDefinitionBuilder edit() {
        return new ClusterClassStatusVariableDefinitionBuilder(this);
    }

    @JsonIgnore
    public ClusterClassStatusVariableDefinitionBuilder toBuilder() {
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
