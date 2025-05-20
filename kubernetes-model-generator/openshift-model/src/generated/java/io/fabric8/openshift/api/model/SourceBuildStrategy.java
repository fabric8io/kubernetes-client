
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
 * SourceBuildStrategy defines input parameters specific to an Source build.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "env",
    "forcePull",
    "from",
    "incremental",
    "pullSecret",
    "scripts",
    "volumes"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class SourceBuildStrategy implements Editable<SourceBuildStrategyBuilder>, KubernetesResource
{

    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<>();
    @JsonProperty("forcePull")
    private Boolean forcePull;
    @JsonProperty("from")
    private ObjectReference from;
    @JsonProperty("incremental")
    private Boolean incremental;
    @JsonProperty("pullSecret")
    private LocalObjectReference pullSecret;
    @JsonProperty("scripts")
    private String scripts;
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BuildVolume> volumes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SourceBuildStrategy() {
    }

    public SourceBuildStrategy(List<EnvVar> env, Boolean forcePull, ObjectReference from, Boolean incremental, LocalObjectReference pullSecret, String scripts, List<BuildVolume> volumes) {
        super();
        this.env = env;
        this.forcePull = forcePull;
        this.from = from;
        this.incremental = incremental;
        this.pullSecret = pullSecret;
        this.scripts = scripts;
        this.volumes = volumes;
    }

    /**
     * env contains additional environment variables you want to pass into a builder container.
     */
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getEnv() {
        return env;
    }

    /**
     * env contains additional environment variables you want to pass into a builder container.
     */
    @JsonProperty("env")
    public void setEnv(List<EnvVar> env) {
        this.env = env;
    }

    /**
     * forcePull describes if the builder should pull the images from registry prior to building.
     */
    @JsonProperty("forcePull")
    public Boolean getForcePull() {
        return forcePull;
    }

    /**
     * forcePull describes if the builder should pull the images from registry prior to building.
     */
    @JsonProperty("forcePull")
    public void setForcePull(Boolean forcePull) {
        this.forcePull = forcePull;
    }

    /**
     * SourceBuildStrategy defines input parameters specific to an Source build.
     */
    @JsonProperty("from")
    public ObjectReference getFrom() {
        return from;
    }

    /**
     * SourceBuildStrategy defines input parameters specific to an Source build.
     */
    @JsonProperty("from")
    public void setFrom(ObjectReference from) {
        this.from = from;
    }

    /**
     * incremental flag forces the Source build to do incremental builds if true.
     */
    @JsonProperty("incremental")
    public Boolean getIncremental() {
        return incremental;
    }

    /**
     * incremental flag forces the Source build to do incremental builds if true.
     */
    @JsonProperty("incremental")
    public void setIncremental(Boolean incremental) {
        this.incremental = incremental;
    }

    /**
     * SourceBuildStrategy defines input parameters specific to an Source build.
     */
    @JsonProperty("pullSecret")
    public LocalObjectReference getPullSecret() {
        return pullSecret;
    }

    /**
     * SourceBuildStrategy defines input parameters specific to an Source build.
     */
    @JsonProperty("pullSecret")
    public void setPullSecret(LocalObjectReference pullSecret) {
        this.pullSecret = pullSecret;
    }

    /**
     * scripts is the location of Source scripts
     */
    @JsonProperty("scripts")
    public String getScripts() {
        return scripts;
    }

    /**
     * scripts is the location of Source scripts
     */
    @JsonProperty("scripts")
    public void setScripts(String scripts) {
        this.scripts = scripts;
    }

    /**
     * volumes is a list of input volumes that can be mounted into the builds runtime environment. Only a subset of Kubernetes Volume sources are supported by builds. More info: https://kubernetes.io/docs/concepts/storage/volumes
     */
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<BuildVolume> getVolumes() {
        return volumes;
    }

    /**
     * volumes is a list of input volumes that can be mounted into the builds runtime environment. Only a subset of Kubernetes Volume sources are supported by builds. More info: https://kubernetes.io/docs/concepts/storage/volumes
     */
    @JsonProperty("volumes")
    public void setVolumes(List<BuildVolume> volumes) {
        this.volumes = volumes;
    }

    @JsonIgnore
    public SourceBuildStrategyBuilder edit() {
        return new SourceBuildStrategyBuilder(this);
    }

    @JsonIgnore
    public SourceBuildStrategyBuilder toBuilder() {
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
