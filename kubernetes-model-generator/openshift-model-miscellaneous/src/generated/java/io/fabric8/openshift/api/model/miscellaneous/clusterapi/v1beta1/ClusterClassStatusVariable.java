
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

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
 * ClusterClassStatusVariable defines a variable which appears in the status of a ClusterClass.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "definitions",
    "definitionsConflict",
    "name"
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
public class ClusterClassStatusVariable implements Editable<ClusterClassStatusVariableBuilder>, KubernetesResource
{

    @JsonProperty("definitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterClassStatusVariableDefinition> definitions = new ArrayList<>();
    @JsonProperty("definitionsConflict")
    private Boolean definitionsConflict;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClusterClassStatusVariable() {
    }

    public ClusterClassStatusVariable(List<ClusterClassStatusVariableDefinition> definitions, Boolean definitionsConflict, String name) {
        super();
        this.definitions = definitions;
        this.definitionsConflict = definitionsConflict;
        this.name = name;
    }

    /**
     * definitions is a list of definitions for a variable.
     */
    @JsonProperty("definitions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterClassStatusVariableDefinition> getDefinitions() {
        return definitions;
    }

    /**
     * definitions is a list of definitions for a variable.
     */
    @JsonProperty("definitions")
    public void setDefinitions(List<ClusterClassStatusVariableDefinition> definitions) {
        this.definitions = definitions;
    }

    /**
     * definitionsConflict specifies whether or not there are conflicting definitions for a single variable name.
     */
    @JsonProperty("definitionsConflict")
    public Boolean getDefinitionsConflict() {
        return definitionsConflict;
    }

    /**
     * definitionsConflict specifies whether or not there are conflicting definitions for a single variable name.
     */
    @JsonProperty("definitionsConflict")
    public void setDefinitionsConflict(Boolean definitionsConflict) {
        this.definitionsConflict = definitionsConflict;
    }

    /**
     * name is the name of the variable.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the name of the variable.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public ClusterClassStatusVariableBuilder edit() {
        return new ClusterClassStatusVariableBuilder(this);
    }

    @JsonIgnore
    public ClusterClassStatusVariableBuilder toBuilder() {
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
