
package io.fabric8.camelk.v1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "buildah",
    "builder",
    "kaniko",
    "s2i",
    "spectrum"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class Task implements KubernetesResource
{

    @JsonProperty("buildah")
    private BuildahTask buildah;
    @JsonProperty("builder")
    private BuilderTask builder;
    @JsonProperty("kaniko")
    private KanikoTask kaniko;
    @JsonProperty("s2i")
    private S2iTask s2i;
    @JsonProperty("spectrum")
    private SpectrumTask spectrum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Task() {
    }

    /**
     * 
     * @param kaniko
     * @param spectrum
     * @param buildah
     * @param builder
     * @param s2i
     */
    public Task(BuildahTask buildah, BuilderTask builder, KanikoTask kaniko, S2iTask s2i, SpectrumTask spectrum) {
        super();
        this.buildah = buildah;
        this.builder = builder;
        this.kaniko = kaniko;
        this.s2i = s2i;
        this.spectrum = spectrum;
    }

    @JsonProperty("buildah")
    public BuildahTask getBuildah() {
        return buildah;
    }

    @JsonProperty("buildah")
    public void setBuildah(BuildahTask buildah) {
        this.buildah = buildah;
    }

    @JsonProperty("builder")
    public BuilderTask getBuilder() {
        return builder;
    }

    @JsonProperty("builder")
    public void setBuilder(BuilderTask builder) {
        this.builder = builder;
    }

    @JsonProperty("kaniko")
    public KanikoTask getKaniko() {
        return kaniko;
    }

    @JsonProperty("kaniko")
    public void setKaniko(KanikoTask kaniko) {
        this.kaniko = kaniko;
    }

    @JsonProperty("s2i")
    public S2iTask getS2i() {
        return s2i;
    }

    @JsonProperty("s2i")
    public void setS2i(S2iTask s2i) {
        this.s2i = s2i;
    }

    @JsonProperty("spectrum")
    public SpectrumTask getSpectrum() {
        return spectrum;
    }

    @JsonProperty("spectrum")
    public void setSpectrum(SpectrumTask spectrum) {
        this.spectrum = spectrum;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
