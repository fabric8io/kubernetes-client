
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
 * TagEvent is used by ImageStreamStatus to keep a historical record of images associated with a tag.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "created",
    "dockerImageReference",
    "generation",
    "image"
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
public class TagEvent implements Editable<TagEventBuilder>, KubernetesResource
{

    @JsonProperty("created")
    private String created;
    @JsonProperty("dockerImageReference")
    private String dockerImageReference;
    @JsonProperty("generation")
    private Long generation;
    @JsonProperty("image")
    private String image;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TagEvent() {
    }

    public TagEvent(String created, String dockerImageReference, Long generation, String image) {
        super();
        this.created = created;
        this.dockerImageReference = dockerImageReference;
        this.generation = generation;
        this.image = image;
    }

    /**
     * TagEvent is used by ImageStreamStatus to keep a historical record of images associated with a tag.
     */
    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    /**
     * TagEvent is used by ImageStreamStatus to keep a historical record of images associated with a tag.
     */
    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * dockerImageReference is the string that can be used to pull this image
     */
    @JsonProperty("dockerImageReference")
    public String getDockerImageReference() {
        return dockerImageReference;
    }

    /**
     * dockerImageReference is the string that can be used to pull this image
     */
    @JsonProperty("dockerImageReference")
    public void setDockerImageReference(String dockerImageReference) {
        this.dockerImageReference = dockerImageReference;
    }

    /**
     * generation is the spec tag generation that resulted in this tag being updated
     */
    @JsonProperty("generation")
    public Long getGeneration() {
        return generation;
    }

    /**
     * generation is the spec tag generation that resulted in this tag being updated
     */
    @JsonProperty("generation")
    public void setGeneration(Long generation) {
        this.generation = generation;
    }

    /**
     * image is the image
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image is the image
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonIgnore
    public TagEventBuilder edit() {
        return new TagEventBuilder(this);
    }

    @JsonIgnore
    public TagEventBuilder toBuilder() {
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
        if (!(o instanceof TagEvent)) {
            return false;
        }
        TagEvent other = (TagEvent) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$created = this.getCreated();
        Object other$created = other.getCreated();
        if (this$created == null ? other$created != null : !this$created.equals(other$created)) {
            return false;
        }
        Object this$dockerImageReference = this.getDockerImageReference();
        Object other$dockerImageReference = other.getDockerImageReference();
        if (this$dockerImageReference == null ? other$dockerImageReference != null : !this$dockerImageReference.equals(other$dockerImageReference)) {
            return false;
        }
        Object this$generation = this.getGeneration();
        Object other$generation = other.getGeneration();
        if (this$generation == null ? other$generation != null : !this$generation.equals(other$generation)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
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
        return other instanceof TagEvent;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $created = this.getCreated();
        result = result * prime + ($created == null ? 43 : $created.hashCode());
        Object $dockerImageReference = this.getDockerImageReference();
        result = result * prime + ($dockerImageReference == null ? 43 : $dockerImageReference.hashCode());
        Object $generation = this.getGeneration();
        result = result * prime + ($generation == null ? 43 : $generation.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TagEvent(" + "created=" + this.getCreated() + ", dockerImageReference=" + this.getDockerImageReference() + ", generation=" + this.getGeneration() + ", image=" + this.getImage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
