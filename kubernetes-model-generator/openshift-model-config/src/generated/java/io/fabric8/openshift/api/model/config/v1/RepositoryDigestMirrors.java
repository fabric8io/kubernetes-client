
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * RepositoryDigestMirrors holds cluster-wide information about how to handle mirrors in the registries config.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowMirrorByTags",
    "mirrors",
    "source"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RepositoryDigestMirrors implements Editable<RepositoryDigestMirrorsBuilder>, KubernetesResource
{

    @JsonProperty("allowMirrorByTags")
    private Boolean allowMirrorByTags;
    @JsonProperty("mirrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> mirrors = new ArrayList<>();
    @JsonProperty("source")
    private String source;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RepositoryDigestMirrors() {
    }

    public RepositoryDigestMirrors(Boolean allowMirrorByTags, List<String> mirrors, String source) {
        super();
        this.allowMirrorByTags = allowMirrorByTags;
        this.mirrors = mirrors;
        this.source = source;
    }

    /**
     * allowMirrorByTags if true, the mirrors can be used to pull the images that are referenced by their tags. Default is false, the mirrors only work when pulling the images that are referenced by their digests. Pulling images by tag can potentially yield different images, depending on which endpoint we pull from. Forcing digest-pulls for mirrors avoids that issue.
     */
    @JsonProperty("allowMirrorByTags")
    public Boolean getAllowMirrorByTags() {
        return allowMirrorByTags;
    }

    /**
     * allowMirrorByTags if true, the mirrors can be used to pull the images that are referenced by their tags. Default is false, the mirrors only work when pulling the images that are referenced by their digests. Pulling images by tag can potentially yield different images, depending on which endpoint we pull from. Forcing digest-pulls for mirrors avoids that issue.
     */
    @JsonProperty("allowMirrorByTags")
    public void setAllowMirrorByTags(Boolean allowMirrorByTags) {
        this.allowMirrorByTags = allowMirrorByTags;
    }

    /**
     * mirrors is zero or more repositories that may also contain the same images. If the "mirrors" is not specified, the image will continue to be pulled from the specified repository in the pull spec. No mirror will be configured. The order of mirrors in this list is treated as the user's desired priority, while source is by default considered lower priority than all mirrors. Other cluster configuration, including (but not limited to) other repositoryDigestMirrors objects, may impact the exact order mirrors are contacted in, or some mirrors may be contacted in parallel, so this should be considered a preference rather than a guarantee of ordering.
     */
    @JsonProperty("mirrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMirrors() {
        return mirrors;
    }

    /**
     * mirrors is zero or more repositories that may also contain the same images. If the "mirrors" is not specified, the image will continue to be pulled from the specified repository in the pull spec. No mirror will be configured. The order of mirrors in this list is treated as the user's desired priority, while source is by default considered lower priority than all mirrors. Other cluster configuration, including (but not limited to) other repositoryDigestMirrors objects, may impact the exact order mirrors are contacted in, or some mirrors may be contacted in parallel, so this should be considered a preference rather than a guarantee of ordering.
     */
    @JsonProperty("mirrors")
    public void setMirrors(List<String> mirrors) {
        this.mirrors = mirrors;
    }

    /**
     * source is the repository that users refer to, e.g. in image pull specifications.
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * source is the repository that users refer to, e.g. in image pull specifications.
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public RepositoryDigestMirrorsBuilder edit() {
        return new RepositoryDigestMirrorsBuilder(this);
    }

    @JsonIgnore
    public RepositoryDigestMirrorsBuilder toBuilder() {
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
        if (!(o instanceof RepositoryDigestMirrors)) {
            return false;
        }
        RepositoryDigestMirrors other = (RepositoryDigestMirrors) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allowMirrorByTags = this.getAllowMirrorByTags();
        Object other$allowMirrorByTags = other.getAllowMirrorByTags();
        if (this$allowMirrorByTags == null ? other$allowMirrorByTags != null : !this$allowMirrorByTags.equals(other$allowMirrorByTags)) {
            return false;
        }
        Object this$mirrors = this.getMirrors();
        Object other$mirrors = other.getMirrors();
        if (this$mirrors == null ? other$mirrors != null : !this$mirrors.equals(other$mirrors)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
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
        return other instanceof RepositoryDigestMirrors;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allowMirrorByTags = this.getAllowMirrorByTags();
        result = result * prime + ($allowMirrorByTags == null ? 43 : $allowMirrorByTags.hashCode());
        Object $mirrors = this.getMirrors();
        result = result * prime + ($mirrors == null ? 43 : $mirrors.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RepositoryDigestMirrors(" + "allowMirrorByTags=" + this.getAllowMirrorByTags() + ", mirrors=" + this.getMirrors() + ", source=" + this.getSource() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
