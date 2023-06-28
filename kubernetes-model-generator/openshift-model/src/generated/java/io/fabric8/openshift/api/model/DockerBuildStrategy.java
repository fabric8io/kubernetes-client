
package io.fabric8.openshift.api.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "buildArgs",
    "dockerfilePath",
    "env",
    "forcePull",
    "from",
    "imageOptimizationPolicy",
    "noCache",
    "pullSecret",
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class DockerBuildStrategy implements KubernetesResource
{

    @JsonProperty("buildArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> buildArgs = new ArrayList<EnvVar>();
    @JsonProperty("dockerfilePath")
    private String dockerfilePath;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<EnvVar>();
    @JsonProperty("forcePull")
    private Boolean forcePull;
    @JsonProperty("from")
    private io.fabric8.kubernetes.api.model.ObjectReference from;
    @JsonProperty("imageOptimizationPolicy")
    private String imageOptimizationPolicy;
    @JsonProperty("noCache")
    private Boolean noCache;
    @JsonProperty("pullSecret")
    private io.fabric8.kubernetes.api.model.LocalObjectReference pullSecret;
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BuildVolume> volumes = new ArrayList<BuildVolume>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DockerBuildStrategy() {
    }

    public DockerBuildStrategy(List<EnvVar> buildArgs, String dockerfilePath, List<EnvVar> env, Boolean forcePull, io.fabric8.kubernetes.api.model.ObjectReference from, String imageOptimizationPolicy, Boolean noCache, io.fabric8.kubernetes.api.model.LocalObjectReference pullSecret, List<BuildVolume> volumes) {
        super();
        this.buildArgs = buildArgs;
        this.dockerfilePath = dockerfilePath;
        this.env = env;
        this.forcePull = forcePull;
        this.from = from;
        this.imageOptimizationPolicy = imageOptimizationPolicy;
        this.noCache = noCache;
        this.pullSecret = pullSecret;
        this.volumes = volumes;
    }

    @JsonProperty("buildArgs")
    public List<EnvVar> getBuildArgs() {
        return buildArgs;
    }

    @JsonProperty("buildArgs")
    public void setBuildArgs(List<EnvVar> buildArgs) {
        this.buildArgs = buildArgs;
    }

    @JsonProperty("dockerfilePath")
    public String getDockerfilePath() {
        return dockerfilePath;
    }

    @JsonProperty("dockerfilePath")
    public void setDockerfilePath(String dockerfilePath) {
        this.dockerfilePath = dockerfilePath;
    }

    @JsonProperty("env")
    public List<EnvVar> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<EnvVar> env) {
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

    @JsonProperty("imageOptimizationPolicy")
    public String getImageOptimizationPolicy() {
        return imageOptimizationPolicy;
    }

    @JsonProperty("imageOptimizationPolicy")
    public void setImageOptimizationPolicy(String imageOptimizationPolicy) {
        this.imageOptimizationPolicy = imageOptimizationPolicy;
    }

    @JsonProperty("noCache")
    public Boolean getNoCache() {
        return noCache;
    }

    @JsonProperty("noCache")
    public void setNoCache(Boolean noCache) {
        this.noCache = noCache;
    }

    @JsonProperty("pullSecret")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getPullSecret() {
        return pullSecret;
    }

    @JsonProperty("pullSecret")
    public void setPullSecret(io.fabric8.kubernetes.api.model.LocalObjectReference pullSecret) {
        this.pullSecret = pullSecret;
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
