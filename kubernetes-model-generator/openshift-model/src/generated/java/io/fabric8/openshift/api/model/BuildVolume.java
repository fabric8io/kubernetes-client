
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
 * BuildVolume describes a volume that is made available to build pods, such that it can be mounted into buildah's runtime environment. Only a subset of Kubernetes Volume sources are supported.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "mounts",
    "name",
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
public class BuildVolume implements Editable<BuildVolumeBuilder>, KubernetesResource
{

    @JsonProperty("mounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BuildVolumeMount> mounts = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("source")
    private BuildVolumeSource source;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildVolume() {
    }

    public BuildVolume(List<BuildVolumeMount> mounts, String name, BuildVolumeSource source) {
        super();
        this.mounts = mounts;
        this.name = name;
        this.source = source;
    }

    /**
     * mounts represents the location of the volume in the image build container
     */
    @JsonProperty("mounts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<BuildVolumeMount> getMounts() {
        return mounts;
    }

    /**
     * mounts represents the location of the volume in the image build container
     */
    @JsonProperty("mounts")
    public void setMounts(List<BuildVolumeMount> mounts) {
        this.mounts = mounts;
    }

    /**
     * name is a unique identifier for this BuildVolume. It must conform to the Kubernetes DNS label standard and be unique within the pod. Names that collide with those added by the build controller will result in a failed build with an error message detailing which name caused the error. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is a unique identifier for this BuildVolume. It must conform to the Kubernetes DNS label standard and be unique within the pod. Names that collide with those added by the build controller will result in a failed build with an error message detailing which name caused the error. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * BuildVolume describes a volume that is made available to build pods, such that it can be mounted into buildah's runtime environment. Only a subset of Kubernetes Volume sources are supported.
     */
    @JsonProperty("source")
    public BuildVolumeSource getSource() {
        return source;
    }

    /**
     * BuildVolume describes a volume that is made available to build pods, such that it can be mounted into buildah's runtime environment. Only a subset of Kubernetes Volume sources are supported.
     */
    @JsonProperty("source")
    public void setSource(BuildVolumeSource source) {
        this.source = source;
    }

    @JsonIgnore
    public BuildVolumeBuilder edit() {
        return new BuildVolumeBuilder(this);
    }

    @JsonIgnore
    public BuildVolumeBuilder toBuilder() {
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
