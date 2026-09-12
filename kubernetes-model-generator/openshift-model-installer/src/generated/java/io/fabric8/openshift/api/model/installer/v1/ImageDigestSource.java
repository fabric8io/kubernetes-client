
package io.fabric8.openshift.api.model.installer.v1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ImageDigestSource defines a list of sources/repositories that can be used to pull content.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mirrors",
    "source",
    "sourcePolicy"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
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
public class ImageDigestSource implements Editable<ImageDigestSourceBuilder>, KubernetesResource
{

    @JsonProperty("mirrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> mirrors = new ArrayList<>();
    @JsonProperty("source")
    private String source;
    @JsonProperty("sourcePolicy")
    private String sourcePolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageDigestSource() {
    }

    public ImageDigestSource(List<String> mirrors, String source, String sourcePolicy) {
        super();
        this.mirrors = mirrors;
        this.source = source;
        this.sourcePolicy = sourcePolicy;
    }

    /**
     * Mirrors is one or more repositories that may also contain the same images.
     */
    @JsonProperty("mirrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMirrors() {
        return mirrors;
    }

    /**
     * Mirrors is one or more repositories that may also contain the same images.
     */
    @JsonProperty("mirrors")
    public void setMirrors(List<String> mirrors) {
        this.mirrors = mirrors;
    }

    /**
     * Source is the repository that users refer to, e.g. in image pull specifications.
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * Source is the repository that users refer to, e.g. in image pull specifications.
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * SourcePolicy defines the fallback policy when there is a failure pulling an image from the mirrors.
     */
    @JsonProperty("sourcePolicy")
    public String getSourcePolicy() {
        return sourcePolicy;
    }

    /**
     * SourcePolicy defines the fallback policy when there is a failure pulling an image from the mirrors.
     */
    @JsonProperty("sourcePolicy")
    public void setSourcePolicy(String sourcePolicy) {
        this.sourcePolicy = sourcePolicy;
    }

    @JsonIgnore
    public ImageDigestSourceBuilder edit() {
        return new ImageDigestSourceBuilder(this);
    }

    @JsonIgnore
    public ImageDigestSourceBuilder toBuilder() {
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
        if (!(o instanceof ImageDigestSource)) {
            return false;
        }
        ImageDigestSource other = (ImageDigestSource) o;
        if (!other.canEqual(this)) {
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
        Object this$sourcePolicy = this.getSourcePolicy();
        Object other$sourcePolicy = other.getSourcePolicy();
        if (this$sourcePolicy == null ? other$sourcePolicy != null : !this$sourcePolicy.equals(other$sourcePolicy)) {
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
        return other instanceof ImageDigestSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $mirrors = this.getMirrors();
        result = result * prime + ($mirrors == null ? 43 : $mirrors.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $sourcePolicy = this.getSourcePolicy();
        result = result * prime + ($sourcePolicy == null ? 43 : $sourcePolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageDigestSource(" + "mirrors=" + this.getMirrors() + ", source=" + this.getSource() + ", sourcePolicy=" + this.getSourcePolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
