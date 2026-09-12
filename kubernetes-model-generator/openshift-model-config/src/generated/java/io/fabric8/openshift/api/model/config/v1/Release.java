
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
 * Release represents an OpenShift release image and associated metadata.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "architecture",
    "channels",
    "image",
    "url",
    "version"
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
public class Release implements Editable<ReleaseBuilder>, KubernetesResource
{

    @JsonProperty("architecture")
    private String architecture;
    @JsonProperty("channels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> channels = new ArrayList<>();
    @JsonProperty("image")
    private String image;
    @JsonProperty("url")
    private String url;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Release() {
    }

    public Release(String architecture, List<String> channels, String image, String url, String version) {
        super();
        this.architecture = architecture;
        this.channels = channels;
        this.image = image;
        this.url = url;
        this.version = version;
    }

    /**
     * architecture is an optional field that indicates the value of the cluster architecture. In this context cluster architecture means either a single architecture or a multi architecture. Valid values are 'Multi' and empty.
     */
    @JsonProperty("architecture")
    public String getArchitecture() {
        return architecture;
    }

    /**
     * architecture is an optional field that indicates the value of the cluster architecture. In this context cluster architecture means either a single architecture or a multi architecture. Valid values are 'Multi' and empty.
     */
    @JsonProperty("architecture")
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    /**
     * channels is the set of Cincinnati channels to which the release currently belongs.
     */
    @JsonProperty("channels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getChannels() {
        return channels;
    }

    /**
     * channels is the set of Cincinnati channels to which the release currently belongs.
     */
    @JsonProperty("channels")
    public void setChannels(List<String> channels) {
        this.channels = channels;
    }

    /**
     * image is a container image location that contains the update. When this field is part of spec, image is optional if version is specified and the availableUpdates field contains a matching version.
     */
    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    /**
     * image is a container image location that contains the update. When this field is part of spec, image is optional if version is specified and the availableUpdates field contains a matching version.
     */
    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * url contains information about this release. This URL is set by the 'url' metadata property on a release or the metadata returned by the update API and should be displayed as a link in user interfaces. The URL field may not be set for test or nightly releases.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url contains information about this release. This URL is set by the 'url' metadata property on a release or the metadata returned by the update API and should be displayed as a link in user interfaces. The URL field may not be set for test or nightly releases.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * version is a semantic version identifying the update version. When this field is part of spec, version is optional if image is specified.
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * version is a semantic version identifying the update version. When this field is part of spec, version is optional if image is specified.
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonIgnore
    public ReleaseBuilder edit() {
        return new ReleaseBuilder(this);
    }

    @JsonIgnore
    public ReleaseBuilder toBuilder() {
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
        if (!(o instanceof Release)) {
            return false;
        }
        Release other = (Release) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$architecture = this.getArchitecture();
        Object other$architecture = other.getArchitecture();
        if (this$architecture == null ? other$architecture != null : !this$architecture.equals(other$architecture)) {
            return false;
        }
        Object this$channels = this.getChannels();
        Object other$channels = other.getChannels();
        if (this$channels == null ? other$channels != null : !this$channels.equals(other$channels)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$url = this.getUrl();
        Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof Release;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $architecture = this.getArchitecture();
        result = result * prime + ($architecture == null ? 43 : $architecture.hashCode());
        Object $channels = this.getChannels();
        result = result * prime + ($channels == null ? 43 : $channels.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $url = this.getUrl();
        result = result * prime + ($url == null ? 43 : $url.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Release(" + "architecture=" + this.getArchitecture() + ", channels=" + this.getChannels() + ", image=" + this.getImage() + ", url=" + this.getUrl() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
