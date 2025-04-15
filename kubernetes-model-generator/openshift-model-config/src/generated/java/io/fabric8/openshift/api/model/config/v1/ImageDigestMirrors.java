
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
 * ImageDigestMirrors holds cluster-wide information about how to handle mirrors in the registries config.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mirrorSourcePolicy",
    "mirrors",
    "source"
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ImageDigestMirrors implements Editable<ImageDigestMirrorsBuilder>, KubernetesResource
{

    @JsonProperty("mirrorSourcePolicy")
    private String mirrorSourcePolicy;
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
    public ImageDigestMirrors() {
    }

    public ImageDigestMirrors(String mirrorSourcePolicy, List<String> mirrors, String source) {
        super();
        this.mirrorSourcePolicy = mirrorSourcePolicy;
        this.mirrors = mirrors;
        this.source = source;
    }

    /**
     * mirrorSourcePolicy defines the fallback policy if fails to pull image from the mirrors. If unset, the image will continue to be pulled from the the repository in the pull spec. sourcePolicy is valid configuration only when one or more mirrors are in the mirror list.
     */
    @JsonProperty("mirrorSourcePolicy")
    public String getMirrorSourcePolicy() {
        return mirrorSourcePolicy;
    }

    /**
     * mirrorSourcePolicy defines the fallback policy if fails to pull image from the mirrors. If unset, the image will continue to be pulled from the the repository in the pull spec. sourcePolicy is valid configuration only when one or more mirrors are in the mirror list.
     */
    @JsonProperty("mirrorSourcePolicy")
    public void setMirrorSourcePolicy(String mirrorSourcePolicy) {
        this.mirrorSourcePolicy = mirrorSourcePolicy;
    }

    /**
     * mirrors is zero or more locations that may also contain the same images. No mirror will be configured if not specified. Images can be pulled from these mirrors only if they are referenced by their digests. The mirrored location is obtained by replacing the part of the input reference that matches source by the mirrors entry, e.g. for registry.redhat.io/product/repo reference, a (source, mirror) pair &#42;.redhat.io, mirror.local/redhat causes a mirror.local/redhat/product/repo repository to be used. The order of mirrors in this list is treated as the user's desired priority, while source is by default considered lower priority than all mirrors. If no mirror is specified or all image pulls from the mirror list fail, the image will continue to be pulled from the repository in the pull spec unless explicitly prohibited by "mirrorSourcePolicy" Other cluster configuration, including (but not limited to) other imageDigestMirrors objects, may impact the exact order mirrors are contacted in, or some mirrors may be contacted in parallel, so this should be considered a preference rather than a guarantee of ordering. "mirrors" uses one of the following formats: host[:port] host[:port]/namespace[/namespace…] host[:port]/namespace[/namespace…]/repo for more information about the format, see the document about the location field: https://github.com/containers/image/blob/main/docs/containers-registries.conf.5.md#choosing-a-registry-toml-table
     */
    @JsonProperty("mirrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMirrors() {
        return mirrors;
    }

    /**
     * mirrors is zero or more locations that may also contain the same images. No mirror will be configured if not specified. Images can be pulled from these mirrors only if they are referenced by their digests. The mirrored location is obtained by replacing the part of the input reference that matches source by the mirrors entry, e.g. for registry.redhat.io/product/repo reference, a (source, mirror) pair &#42;.redhat.io, mirror.local/redhat causes a mirror.local/redhat/product/repo repository to be used. The order of mirrors in this list is treated as the user's desired priority, while source is by default considered lower priority than all mirrors. If no mirror is specified or all image pulls from the mirror list fail, the image will continue to be pulled from the repository in the pull spec unless explicitly prohibited by "mirrorSourcePolicy" Other cluster configuration, including (but not limited to) other imageDigestMirrors objects, may impact the exact order mirrors are contacted in, or some mirrors may be contacted in parallel, so this should be considered a preference rather than a guarantee of ordering. "mirrors" uses one of the following formats: host[:port] host[:port]/namespace[/namespace…] host[:port]/namespace[/namespace…]/repo for more information about the format, see the document about the location field: https://github.com/containers/image/blob/main/docs/containers-registries.conf.5.md#choosing-a-registry-toml-table
     */
    @JsonProperty("mirrors")
    public void setMirrors(List<String> mirrors) {
        this.mirrors = mirrors;
    }

    /**
     * source matches the repository that users refer to, e.g. in image pull specifications. Setting source to a registry hostname e.g. docker.io. quay.io, or registry.redhat.io, will match the image pull specification of corressponding registry. "source" uses one of the following formats: host[:port] host[:port]/namespace[/namespace…] host[:port]/namespace[/namespace…]/repo [&#42;.]host for more information about the format, see the document about the location field: https://github.com/containers/image/blob/main/docs/containers-registries.conf.5.md#choosing-a-registry-toml-table
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * source matches the repository that users refer to, e.g. in image pull specifications. Setting source to a registry hostname e.g. docker.io. quay.io, or registry.redhat.io, will match the image pull specification of corressponding registry. "source" uses one of the following formats: host[:port] host[:port]/namespace[/namespace…] host[:port]/namespace[/namespace…]/repo [&#42;.]host for more information about the format, see the document about the location field: https://github.com/containers/image/blob/main/docs/containers-registries.conf.5.md#choosing-a-registry-toml-table
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonIgnore
    public ImageDigestMirrorsBuilder edit() {
        return new ImageDigestMirrorsBuilder(this);
    }

    @JsonIgnore
    public ImageDigestMirrorsBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
