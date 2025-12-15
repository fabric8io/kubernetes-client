
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
 * ClusterVariable can be used to customize the Cluster through patches. Each ClusterVariable is associated with a Variable definition in the ClusterClass `status` variables.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "definitionFrom",
    "name",
    "value"
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
public class ClusterVariable implements Editable<ClusterVariableBuilder>, KubernetesResource
{

    @JsonProperty("definitionFrom")
    private String definitionFrom;
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private JsonNode value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterVariable() {
    }

    public ClusterVariable(String definitionFrom, String name, JsonNode value) {
        super();
        this.definitionFrom = definitionFrom;
        this.name = name;
        this.value = value;
    }

    /**
     * definitionFrom specifies where the definition of this Variable is from.<br><p> <br><p> Deprecated: This field is deprecated, must not be set anymore and is going to be removed in the next apiVersion.
     */
    @JsonProperty("definitionFrom")
    public String getDefinitionFrom() {
        return definitionFrom;
    }

    /**
     * definitionFrom specifies where the definition of this Variable is from.<br><p> <br><p> Deprecated: This field is deprecated, must not be set anymore and is going to be removed in the next apiVersion.
     */
    @JsonProperty("definitionFrom")
    public void setDefinitionFrom(String definitionFrom) {
        this.definitionFrom = definitionFrom;
    }

    /**
     * name of the variable.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name of the variable.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ClusterVariable can be used to customize the Cluster through patches. Each ClusterVariable is associated with a Variable definition in the ClusterClass `status` variables.
     */
    @JsonProperty("value")
    public JsonNode getValue() {
        return value;
    }

    /**
     * ClusterVariable can be used to customize the Cluster through patches. Each ClusterVariable is associated with a Variable definition in the ClusterClass `status` variables.
     */
    @JsonProperty("value")
    public void setValue(JsonNode value) {
        this.value = value;
    }

    @JsonIgnore
    public ClusterVariableBuilder edit() {
        return new ClusterVariableBuilder(this);
    }

    @JsonIgnore
    public ClusterVariableBuilder toBuilder() {
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
