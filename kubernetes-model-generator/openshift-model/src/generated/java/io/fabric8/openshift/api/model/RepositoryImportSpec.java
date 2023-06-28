
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
    "from",
    "importPolicy",
    "includeManifest",
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
public class RepositoryImportSpec implements KubernetesResource
{

    @JsonProperty("from")
    private io.fabric8.kubernetes.api.model.ObjectReference from;
    @JsonProperty("importPolicy")
    private TagImportPolicy importPolicy;
    @JsonProperty("includeManifest")
    private Boolean includeManifest;
    @JsonProperty("referencePolicy")
    private TagReferencePolicy referencePolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RepositoryImportSpec() {
    }

    public RepositoryImportSpec(io.fabric8.kubernetes.api.model.ObjectReference from, TagImportPolicy importPolicy, Boolean includeManifest, TagReferencePolicy referencePolicy) {
        super();
        this.from = from;
        this.importPolicy = importPolicy;
        this.includeManifest = includeManifest;
        this.referencePolicy = referencePolicy;
    }

    @JsonProperty("from")
    public io.fabric8.kubernetes.api.model.ObjectReference getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(io.fabric8.kubernetes.api.model.ObjectReference from) {
        this.from = from;
    }

    @JsonProperty("importPolicy")
    public TagImportPolicy getImportPolicy() {
        return importPolicy;
    }

    @JsonProperty("importPolicy")
    public void setImportPolicy(TagImportPolicy importPolicy) {
        this.importPolicy = importPolicy;
    }

    @JsonProperty("includeManifest")
    public Boolean getIncludeManifest() {
        return includeManifest;
    }

    @JsonProperty("includeManifest")
    public void setIncludeManifest(Boolean includeManifest) {
        this.includeManifest = includeManifest;
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
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
