
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Status;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * RepositoryImportStatus describes the result of an image repository import
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalTags",
    "images",
    "status"
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
public class RepositoryImportStatus implements Editable<RepositoryImportStatusBuilder>, KubernetesResource
{

    @JsonProperty("additionalTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> additionalTags = new ArrayList<>();
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageImportStatus> images = new ArrayList<>();
    @JsonProperty("status")
    private Status status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RepositoryImportStatus() {
    }

    public RepositoryImportStatus(List<String> additionalTags, List<ImageImportStatus> images, Status status) {
        super();
        this.additionalTags = additionalTags;
        this.images = images;
        this.status = status;
    }

    /**
     * additionalTags are tags that exist in the repository but were not imported because a maximum limit of automatic imports was applied.
     */
    @JsonProperty("additionalTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAdditionalTags() {
        return additionalTags;
    }

    /**
     * additionalTags are tags that exist in the repository but were not imported because a maximum limit of automatic imports was applied.
     */
    @JsonProperty("additionalTags")
    public void setAdditionalTags(List<String> additionalTags) {
        this.additionalTags = additionalTags;
    }

    /**
     * images is a list of images successfully retrieved by the import of the repository.
     */
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageImportStatus> getImages() {
        return images;
    }

    /**
     * images is a list of images successfully retrieved by the import of the repository.
     */
    @JsonProperty("images")
    public void setImages(List<ImageImportStatus> images) {
        this.images = images;
    }

    /**
     * RepositoryImportStatus describes the result of an image repository import
     */
    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    /**
     * RepositoryImportStatus describes the result of an image repository import
     */
    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonIgnore
    public RepositoryImportStatusBuilder edit() {
        return new RepositoryImportStatusBuilder(this);
    }

    @JsonIgnore
    public RepositoryImportStatusBuilder toBuilder() {
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
        if (!(o instanceof RepositoryImportStatus)) {
            return false;
        }
        RepositoryImportStatus other = (RepositoryImportStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$additionalTags = this.getAdditionalTags();
        Object other$additionalTags = other.getAdditionalTags();
        if (this$additionalTags == null ? other$additionalTags != null : !this$additionalTags.equals(other$additionalTags)) {
            return false;
        }
        Object this$images = this.getImages();
        Object other$images = other.getImages();
        if (this$images == null ? other$images != null : !this$images.equals(other$images)) {
            return false;
        }
        Object this$status = this.getStatus();
        Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
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
        return other instanceof RepositoryImportStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $additionalTags = this.getAdditionalTags();
        result = result * prime + ($additionalTags == null ? 43 : $additionalTags.hashCode());
        Object $images = this.getImages();
        result = result * prime + ($images == null ? 43 : $images.hashCode());
        Object $status = this.getStatus();
        result = result * prime + ($status == null ? 43 : $status.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RepositoryImportStatus(" + "additionalTags=" + this.getAdditionalTags() + ", images=" + this.getImages() + ", status=" + this.getStatus() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
