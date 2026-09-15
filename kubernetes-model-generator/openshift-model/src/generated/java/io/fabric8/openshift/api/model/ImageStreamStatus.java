
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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ImageStreamStatus contains information about the state of this image stream.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dockerImageRepository",
    "publicDockerImageRepository",
    "tags"
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
public class ImageStreamStatus implements Editable<ImageStreamStatusBuilder>, KubernetesResource
{

    @JsonProperty("dockerImageRepository")
    private String dockerImageRepository;
    @JsonProperty("publicDockerImageRepository")
    private String publicDockerImageRepository;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedTagEventList> tags = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageStreamStatus() {
    }

    public ImageStreamStatus(String dockerImageRepository, String publicDockerImageRepository, List<NamedTagEventList> tags) {
        super();
        this.dockerImageRepository = dockerImageRepository;
        this.publicDockerImageRepository = publicDockerImageRepository;
        this.tags = tags;
    }

    /**
     * dockerImageRepository represents the effective location this stream may be accessed at. May be empty until the server determines where the repository is located
     */
    @JsonProperty("dockerImageRepository")
    public String getDockerImageRepository() {
        return dockerImageRepository;
    }

    /**
     * dockerImageRepository represents the effective location this stream may be accessed at. May be empty until the server determines where the repository is located
     */
    @JsonProperty("dockerImageRepository")
    public void setDockerImageRepository(String dockerImageRepository) {
        this.dockerImageRepository = dockerImageRepository;
    }

    /**
     * publicDockerImageRepository represents the public location from where the image can be pulled outside the cluster. This field may be empty if the administrator has not exposed the integrated registry externally.
     */
    @JsonProperty("publicDockerImageRepository")
    public String getPublicDockerImageRepository() {
        return publicDockerImageRepository;
    }

    /**
     * publicDockerImageRepository represents the public location from where the image can be pulled outside the cluster. This field may be empty if the administrator has not exposed the integrated registry externally.
     */
    @JsonProperty("publicDockerImageRepository")
    public void setPublicDockerImageRepository(String publicDockerImageRepository) {
        this.publicDockerImageRepository = publicDockerImageRepository;
    }

    /**
     * tags are a historical record of images associated with each tag. The first entry in the TagEvent array is the currently tagged image.
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NamedTagEventList> getTags() {
        return tags;
    }

    /**
     * tags are a historical record of images associated with each tag. The first entry in the TagEvent array is the currently tagged image.
     */
    @JsonProperty("tags")
    public void setTags(List<NamedTagEventList> tags) {
        this.tags = tags;
    }

    @JsonIgnore
    public ImageStreamStatusBuilder edit() {
        return new ImageStreamStatusBuilder(this);
    }

    @JsonIgnore
    public ImageStreamStatusBuilder toBuilder() {
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
        if (!(o instanceof ImageStreamStatus)) {
            return false;
        }
        ImageStreamStatus other = (ImageStreamStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dockerImageRepository = this.getDockerImageRepository();
        Object other$dockerImageRepository = other.getDockerImageRepository();
        if (this$dockerImageRepository == null ? other$dockerImageRepository != null : !this$dockerImageRepository.equals(other$dockerImageRepository)) {
            return false;
        }
        Object this$publicDockerImageRepository = this.getPublicDockerImageRepository();
        Object other$publicDockerImageRepository = other.getPublicDockerImageRepository();
        if (this$publicDockerImageRepository == null ? other$publicDockerImageRepository != null : !this$publicDockerImageRepository.equals(other$publicDockerImageRepository)) {
            return false;
        }
        Object this$tags = this.getTags();
        Object other$tags = other.getTags();
        if (this$tags == null ? other$tags != null : !this$tags.equals(other$tags)) {
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
        return other instanceof ImageStreamStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dockerImageRepository = this.getDockerImageRepository();
        result = result * prime + ($dockerImageRepository == null ? 43 : $dockerImageRepository.hashCode());
        Object $publicDockerImageRepository = this.getPublicDockerImageRepository();
        result = result * prime + ($publicDockerImageRepository == null ? 43 : $publicDockerImageRepository.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageStreamStatus(" + "dockerImageRepository=" + this.getDockerImageRepository() + ", publicDockerImageRepository=" + this.getPublicDockerImageRepository() + ", tags=" + this.getTags() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
