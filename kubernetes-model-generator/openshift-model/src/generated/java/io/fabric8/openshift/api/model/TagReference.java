
package io.fabric8.openshift.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "annotations",
    "from",
    "generation",
    "importPolicy",
    "name",
    "reference",
    "referencePolicy"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class TagReference implements KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<String, String>();
    @JsonProperty("from")
    private io.fabric8.kubernetes.api.model.ObjectReference from;
    @JsonProperty("generation")
    private Long generation;
    @JsonProperty("importPolicy")
    private TagImportPolicy importPolicy;
    @JsonProperty("name")
    private java.lang.String name;
    @JsonProperty("reference")
    private Boolean reference;
    @JsonProperty("referencePolicy")
    private TagReferencePolicy referencePolicy;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TagReference() {
    }

    public TagReference(Map<String, String> annotations, io.fabric8.kubernetes.api.model.ObjectReference from, Long generation, TagImportPolicy importPolicy, java.lang.String name, Boolean reference, TagReferencePolicy referencePolicy) {
        super();
        this.annotations = annotations;
        this.from = from;
        this.generation = generation;
        this.importPolicy = importPolicy;
        this.name = name;
        this.reference = reference;
        this.referencePolicy = referencePolicy;
    }

    @JsonProperty("annotations")
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("from")
    public io.fabric8.kubernetes.api.model.ObjectReference getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(io.fabric8.kubernetes.api.model.ObjectReference from) {
        this.from = from;
    }

    @JsonProperty("generation")
    public Long getGeneration() {
        return generation;
    }

    @JsonProperty("generation")
    public void setGeneration(Long generation) {
        this.generation = generation;
    }

    @JsonProperty("importPolicy")
    public TagImportPolicy getImportPolicy() {
        return importPolicy;
    }

    @JsonProperty("importPolicy")
    public void setImportPolicy(TagImportPolicy importPolicy) {
        this.importPolicy = importPolicy;
    }

    @JsonProperty("name")
    public java.lang.String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @JsonProperty("reference")
    public Boolean getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(Boolean reference) {
        this.reference = reference;
    }

    @JsonProperty("referencePolicy")
    public TagReferencePolicy getReferencePolicy() {
        return referencePolicy;
    }

    @JsonProperty("referencePolicy")
    public void setReferencePolicy(TagReferencePolicy referencePolicy) {
        this.referencePolicy = referencePolicy;
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
