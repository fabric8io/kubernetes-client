
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
 * ImageImportSpec describes a request to import a specific image.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "from",
    "importPolicy",
    "includeManifest",
    "referencePolicy",
    "to"
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
public class ImageImportSpec implements Editable<ImageImportSpecBuilder>, KubernetesResource
{

    @JsonProperty("from")
    private ObjectReference from;
    @JsonProperty("importPolicy")
    private TagImportPolicy importPolicy;
    @JsonProperty("includeManifest")
    private Boolean includeManifest;
    @JsonProperty("referencePolicy")
    private TagReferencePolicy referencePolicy;
    @JsonProperty("to")
    private LocalObjectReference to;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageImportSpec() {
    }

    public ImageImportSpec(ObjectReference from, TagImportPolicy importPolicy, Boolean includeManifest, TagReferencePolicy referencePolicy, LocalObjectReference to) {
        super();
        this.from = from;
        this.importPolicy = importPolicy;
        this.includeManifest = includeManifest;
        this.referencePolicy = referencePolicy;
        this.to = to;
    }

    /**
     * ImageImportSpec describes a request to import a specific image.
     */
    @JsonProperty("from")
    public ObjectReference getFrom() {
        return from;
    }

    /**
     * ImageImportSpec describes a request to import a specific image.
     */
    @JsonProperty("from")
    public void setFrom(ObjectReference from) {
        this.from = from;
    }

    /**
     * ImageImportSpec describes a request to import a specific image.
     */
    @JsonProperty("importPolicy")
    public TagImportPolicy getImportPolicy() {
        return importPolicy;
    }

    /**
     * ImageImportSpec describes a request to import a specific image.
     */
    @JsonProperty("importPolicy")
    public void setImportPolicy(TagImportPolicy importPolicy) {
        this.importPolicy = importPolicy;
    }

    /**
     * IncludeManifest determines if the manifest for each image is returned in the response
     */
    @JsonProperty("includeManifest")
    public Boolean getIncludeManifest() {
        return includeManifest;
    }

    /**
     * IncludeManifest determines if the manifest for each image is returned in the response
     */
    @JsonProperty("includeManifest")
    public void setIncludeManifest(Boolean includeManifest) {
        this.includeManifest = includeManifest;
    }

    /**
     * ImageImportSpec describes a request to import a specific image.
     */
    @JsonProperty("referencePolicy")
    public TagReferencePolicy getReferencePolicy() {
        return referencePolicy;
    }

    /**
     * ImageImportSpec describes a request to import a specific image.
     */
    @JsonProperty("referencePolicy")
    public void setReferencePolicy(TagReferencePolicy referencePolicy) {
        this.referencePolicy = referencePolicy;
    }

    /**
     * ImageImportSpec describes a request to import a specific image.
     */
    @JsonProperty("to")
    public LocalObjectReference getTo() {
        return to;
    }

    /**
     * ImageImportSpec describes a request to import a specific image.
     */
    @JsonProperty("to")
    public void setTo(LocalObjectReference to) {
        this.to = to;
    }

    @JsonIgnore
    public ImageImportSpecBuilder edit() {
        return new ImageImportSpecBuilder(this);
    }

    @JsonIgnore
    public ImageImportSpecBuilder toBuilder() {
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
