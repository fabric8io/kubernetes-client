
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
 * ImageStreamSpec represents options for ImageStreams.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dockerImageRepository",
    "lookupPolicy",
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
public class ImageStreamSpec implements Editable<ImageStreamSpecBuilder>, KubernetesResource
{

    @JsonProperty("dockerImageRepository")
    private String dockerImageRepository;
    @JsonProperty("lookupPolicy")
    private ImageLookupPolicy lookupPolicy;
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TagReference> tags = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageStreamSpec() {
    }

    public ImageStreamSpec(String dockerImageRepository, ImageLookupPolicy lookupPolicy, List<TagReference> tags) {
        super();
        this.dockerImageRepository = dockerImageRepository;
        this.lookupPolicy = lookupPolicy;
        this.tags = tags;
    }

    /**
     * dockerImageRepository is optional, if specified this stream is backed by a container repository on this server Deprecated: This field is deprecated as of v3.7 and will be removed in a future release. Specify the source for the tags to be imported in each tag via the spec.tags.from reference instead.
     */
    @JsonProperty("dockerImageRepository")
    public String getDockerImageRepository() {
        return dockerImageRepository;
    }

    /**
     * dockerImageRepository is optional, if specified this stream is backed by a container repository on this server Deprecated: This field is deprecated as of v3.7 and will be removed in a future release. Specify the source for the tags to be imported in each tag via the spec.tags.from reference instead.
     */
    @JsonProperty("dockerImageRepository")
    public void setDockerImageRepository(String dockerImageRepository) {
        this.dockerImageRepository = dockerImageRepository;
    }

    /**
     * ImageStreamSpec represents options for ImageStreams.
     */
    @JsonProperty("lookupPolicy")
    public ImageLookupPolicy getLookupPolicy() {
        return lookupPolicy;
    }

    /**
     * ImageStreamSpec represents options for ImageStreams.
     */
    @JsonProperty("lookupPolicy")
    public void setLookupPolicy(ImageLookupPolicy lookupPolicy) {
        this.lookupPolicy = lookupPolicy;
    }

    /**
     * tags map arbitrary string values to specific image locators
     */
    @JsonProperty("tags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TagReference> getTags() {
        return tags;
    }

    /**
     * tags map arbitrary string values to specific image locators
     */
    @JsonProperty("tags")
    public void setTags(List<TagReference> tags) {
        this.tags = tags;
    }

    @JsonIgnore
    public ImageStreamSpecBuilder edit() {
        return new ImageStreamSpecBuilder(this);
    }

    @JsonIgnore
    public ImageStreamSpecBuilder toBuilder() {
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
        if (!(o instanceof ImageStreamSpec)) {
            return false;
        }
        ImageStreamSpec other = (ImageStreamSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dockerImageRepository = this.getDockerImageRepository();
        Object other$dockerImageRepository = other.getDockerImageRepository();
        if (this$dockerImageRepository == null ? other$dockerImageRepository != null : !this$dockerImageRepository.equals(other$dockerImageRepository)) {
            return false;
        }
        Object this$lookupPolicy = this.getLookupPolicy();
        Object other$lookupPolicy = other.getLookupPolicy();
        if (this$lookupPolicy == null ? other$lookupPolicy != null : !this$lookupPolicy.equals(other$lookupPolicy)) {
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
        return other instanceof ImageStreamSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dockerImageRepository = this.getDockerImageRepository();
        result = result * prime + ($dockerImageRepository == null ? 43 : $dockerImageRepository.hashCode());
        Object $lookupPolicy = this.getLookupPolicy();
        result = result * prime + ($lookupPolicy == null ? 43 : $lookupPolicy.hashCode());
        Object $tags = this.getTags();
        result = result * prime + ($tags == null ? 43 : $tags.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageStreamSpec(" + "dockerImageRepository=" + this.getDockerImageRepository() + ", lookupPolicy=" + this.getLookupPolicy() + ", tags=" + this.getTags() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
