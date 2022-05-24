
package io.fabric8.openshift.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class SourceBuildStrategy implements KubernetesResource
{

    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.EnvVar> env = new ArrayList<io.fabric8.kubernetes.api.model.EnvVar>();
    @JsonProperty("forcePull")
    private Boolean forcePull;
    @JsonProperty("from")
    private io.fabric8.kubernetes.api.model.ObjectReference from;
    @JsonProperty("incremental")
    private Boolean incremental;
    @JsonProperty("pullSecret")
    private io.fabric8.kubernetes.api.model.LocalObjectReference pullSecret;
    @JsonProperty("scripts")
    private String scripts;
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BuildVolume> volumes = new ArrayList<BuildVolume>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SourceBuildStrategy() {
    }

    /**
     * 
     * @param forcePull
     * @param volumes
     * @param from
     * @param incremental
     * @param env
     * @param scripts
     * @param pullSecret
     */
    public SourceBuildStrategy(List<io.fabric8.kubernetes.api.model.EnvVar> env, Boolean forcePull, io.fabric8.kubernetes.api.model.ObjectReference from, Boolean incremental, io.fabric8.kubernetes.api.model.LocalObjectReference pullSecret, String scripts, List<BuildVolume> volumes) {
        super();
        this.env = env;
        this.forcePull = forcePull;
        this.from = from;
        this.incremental = incremental;
        this.pullSecret = pullSecret;
        this.scripts = scripts;
        this.volumes = volumes;
    }

    @JsonProperty("env")
    public List<io.fabric8.kubernetes.api.model.EnvVar> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<io.fabric8.kubernetes.api.model.EnvVar> env) {
        this.env = env;
    }

    @JsonProperty("forcePull")
    public Boolean getForcePull() {
        return forcePull;
    }

    @JsonProperty("forcePull")
    public void setForcePull(Boolean forcePull) {
        this.forcePull = forcePull;
    }

    @JsonProperty("from")
    public io.fabric8.kubernetes.api.model.ObjectReference getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(io.fabric8.kubernetes.api.model.ObjectReference from) {
        this.from = from;
    }

    @JsonProperty("incremental")
    public Boolean getIncremental() {
        return incremental;
    }

    @JsonProperty("incremental")
    public void setIncremental(Boolean incremental) {
        this.incremental = incremental;
    }

    @JsonProperty("pullSecret")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getPullSecret() {
        return pullSecret;
    }

    @JsonProperty("pullSecret")
    public void setPullSecret(io.fabric8.kubernetes.api.model.LocalObjectReference pullSecret) {
        this.pullSecret = pullSecret;
    }

    @JsonProperty("scripts")
    public String getScripts() {
        return scripts;
    }

    @JsonProperty("scripts")
    public void setScripts(String scripts) {
        this.scripts = scripts;
    }

    @JsonProperty("volumes")
    public List<BuildVolume> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<BuildVolume> volumes) {
        this.volumes = volumes;
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
