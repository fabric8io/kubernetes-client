
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
 * ImageDigestMirrorSetSpec is the specification of the ImageDigestMirrorSet CRD.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imageDigestMirrors"
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
public class ImageDigestMirrorSetSpec implements Editable<ImageDigestMirrorSetSpecBuilder>, KubernetesResource
{

    @JsonProperty("imageDigestMirrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageDigestMirrors> imageDigestMirrors = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageDigestMirrorSetSpec() {
    }

    public ImageDigestMirrorSetSpec(List<ImageDigestMirrors> imageDigestMirrors) {
        super();
        this.imageDigestMirrors = imageDigestMirrors;
    }

    /**
     * imageDigestMirrors allows images referenced by image digests in pods to be pulled from alternative mirrored repository locations. The image pull specification provided to the pod will be compared to the source locations described in imageDigestMirrors and the image may be pulled down from any of the mirrors in the list instead of the specified repository allowing administrators to choose a potentially faster mirror. To use mirrors to pull images using tag specification, users should configure a list of mirrors using "ImageTagMirrorSet" CRD.<br><p> <br><p> If the image pull specification matches the repository of "source" in multiple imagedigestmirrorset objects, only the objects which define the most specific namespace match will be used. For example, if there are objects using quay.io/libpod and quay.io/libpod/busybox as the "source", only the objects using quay.io/libpod/busybox are going to apply for pull specification quay.io/libpod/busybox. Each "source" repository is treated independently; configurations for different "source" repositories don’t interact.<br><p> <br><p> If the "mirrors" is not specified, the image will continue to be pulled from the specified repository in the pull spec.<br><p> <br><p> When multiple policies are defined for the same "source" repository, the sets of defined mirrors will be merged together, preserving the relative order of the mirrors, if possible. For example, if policy A has mirrors `a, b, c` and policy B has mirrors `c, d, e`, the mirrors will be used in the order `a, b, c, d, e`.  If the orders of mirror entries conflict (e.g. `a, b` vs. `b, a`) the configuration is not rejected but the resulting order is unspecified. Users who want to use a specific order of mirrors, should configure them into one list of mirrors using the expected order.
     */
    @JsonProperty("imageDigestMirrors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageDigestMirrors> getImageDigestMirrors() {
        return imageDigestMirrors;
    }

    /**
     * imageDigestMirrors allows images referenced by image digests in pods to be pulled from alternative mirrored repository locations. The image pull specification provided to the pod will be compared to the source locations described in imageDigestMirrors and the image may be pulled down from any of the mirrors in the list instead of the specified repository allowing administrators to choose a potentially faster mirror. To use mirrors to pull images using tag specification, users should configure a list of mirrors using "ImageTagMirrorSet" CRD.<br><p> <br><p> If the image pull specification matches the repository of "source" in multiple imagedigestmirrorset objects, only the objects which define the most specific namespace match will be used. For example, if there are objects using quay.io/libpod and quay.io/libpod/busybox as the "source", only the objects using quay.io/libpod/busybox are going to apply for pull specification quay.io/libpod/busybox. Each "source" repository is treated independently; configurations for different "source" repositories don’t interact.<br><p> <br><p> If the "mirrors" is not specified, the image will continue to be pulled from the specified repository in the pull spec.<br><p> <br><p> When multiple policies are defined for the same "source" repository, the sets of defined mirrors will be merged together, preserving the relative order of the mirrors, if possible. For example, if policy A has mirrors `a, b, c` and policy B has mirrors `c, d, e`, the mirrors will be used in the order `a, b, c, d, e`.  If the orders of mirror entries conflict (e.g. `a, b` vs. `b, a`) the configuration is not rejected but the resulting order is unspecified. Users who want to use a specific order of mirrors, should configure them into one list of mirrors using the expected order.
     */
    @JsonProperty("imageDigestMirrors")
    public void setImageDigestMirrors(List<ImageDigestMirrors> imageDigestMirrors) {
        this.imageDigestMirrors = imageDigestMirrors;
    }

    @JsonIgnore
    public ImageDigestMirrorSetSpecBuilder edit() {
        return new ImageDigestMirrorSetSpecBuilder(this);
    }

    @JsonIgnore
    public ImageDigestMirrorSetSpecBuilder toBuilder() {
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
