
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
 * RepositoryImportSpec describes a request to import images from a container image repository.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "from",
    "importPolicy",
    "includeManifest",
    "referencePolicy"
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
public class RepositoryImportSpec implements Editable<RepositoryImportSpecBuilder>, KubernetesResource
{

    @JsonProperty("from")
    private ObjectReference from;
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
     */
    public RepositoryImportSpec() {
    }

    public RepositoryImportSpec(ObjectReference from, TagImportPolicy importPolicy, Boolean includeManifest, TagReferencePolicy referencePolicy) {
        super();
        this.from = from;
        this.importPolicy = importPolicy;
        this.includeManifest = includeManifest;
        this.referencePolicy = referencePolicy;
    }

    /**
     * RepositoryImportSpec describes a request to import images from a container image repository.
     */
    @JsonProperty("from")
    public ObjectReference getFrom() {
        return from;
    }

    /**
     * RepositoryImportSpec describes a request to import images from a container image repository.
     */
    @JsonProperty("from")
    public void setFrom(ObjectReference from) {
        this.from = from;
    }

    /**
     * RepositoryImportSpec describes a request to import images from a container image repository.
     */
    @JsonProperty("importPolicy")
    public TagImportPolicy getImportPolicy() {
        return importPolicy;
    }

    /**
     * RepositoryImportSpec describes a request to import images from a container image repository.
     */
    @JsonProperty("importPolicy")
    public void setImportPolicy(TagImportPolicy importPolicy) {
        this.importPolicy = importPolicy;
    }

    /**
     * includeManifest determines if the manifest for each image is returned in the response
     */
    @JsonProperty("includeManifest")
    public Boolean getIncludeManifest() {
        return includeManifest;
    }

    /**
     * includeManifest determines if the manifest for each image is returned in the response
     */
    @JsonProperty("includeManifest")
    public void setIncludeManifest(Boolean includeManifest) {
        this.includeManifest = includeManifest;
    }

    /**
     * RepositoryImportSpec describes a request to import images from a container image repository.
     */
    @JsonProperty("referencePolicy")
    public TagReferencePolicy getReferencePolicy() {
        return referencePolicy;
    }

    /**
     * RepositoryImportSpec describes a request to import images from a container image repository.
     */
    @JsonProperty("referencePolicy")
    public void setReferencePolicy(TagReferencePolicy referencePolicy) {
        this.referencePolicy = referencePolicy;
    }

    @JsonIgnore
    public RepositoryImportSpecBuilder edit() {
        return new RepositoryImportSpecBuilder(this);
    }

    @JsonIgnore
    public RepositoryImportSpecBuilder toBuilder() {
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
        if (!(o instanceof RepositoryImportSpec)) {
            return false;
        }
        RepositoryImportSpec other = (RepositoryImportSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$from = this.getFrom();
        Object other$from = other.getFrom();
        if (this$from == null ? other$from != null : !this$from.equals(other$from)) {
            return false;
        }
        Object this$importPolicy = this.getImportPolicy();
        Object other$importPolicy = other.getImportPolicy();
        if (this$importPolicy == null ? other$importPolicy != null : !this$importPolicy.equals(other$importPolicy)) {
            return false;
        }
        Object this$includeManifest = this.getIncludeManifest();
        Object other$includeManifest = other.getIncludeManifest();
        if (this$includeManifest == null ? other$includeManifest != null : !this$includeManifest.equals(other$includeManifest)) {
            return false;
        }
        Object this$referencePolicy = this.getReferencePolicy();
        Object other$referencePolicy = other.getReferencePolicy();
        if (this$referencePolicy == null ? other$referencePolicy != null : !this$referencePolicy.equals(other$referencePolicy)) {
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
        return other instanceof RepositoryImportSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $from = this.getFrom();
        result = result * prime + ($from == null ? 43 : $from.hashCode());
        Object $importPolicy = this.getImportPolicy();
        result = result * prime + ($importPolicy == null ? 43 : $importPolicy.hashCode());
        Object $includeManifest = this.getIncludeManifest();
        result = result * prime + ($includeManifest == null ? 43 : $includeManifest.hashCode());
        Object $referencePolicy = this.getReferencePolicy();
        result = result * prime + ($referencePolicy == null ? 43 : $referencePolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RepositoryImportSpec(" + "from=" + this.getFrom() + ", importPolicy=" + this.getImportPolicy() + ", includeManifest=" + this.getIncludeManifest() + ", referencePolicy=" + this.getReferencePolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
