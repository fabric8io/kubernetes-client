
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

/**
 * DockerBuildStrategy defines input parameters specific to container image build.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
public class DockerBuildStrategy implements Editable<DockerBuildStrategyBuilder>, KubernetesResource
{

    @JsonProperty("buildArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> buildArgs = new ArrayList<>();
    @JsonProperty("dockerfilePath")
    private String dockerfilePath;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<>();
    @JsonProperty("forcePull")
    private Boolean forcePull;
    @JsonProperty("from")
    private ObjectReference from;
    @JsonProperty("imageOptimizationPolicy")
    private String imageOptimizationPolicy;
    @JsonProperty("noCache")
    private Boolean noCache;
    @JsonProperty("pullSecret")
    private LocalObjectReference pullSecret;
    @JsonProperty("volumes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BuildVolume> volumes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DockerBuildStrategy() {
    }

    public DockerBuildStrategy(List<EnvVar> buildArgs, String dockerfilePath, List<EnvVar> env, Boolean forcePull, ObjectReference from, String imageOptimizationPolicy, Boolean noCache, LocalObjectReference pullSecret, List<BuildVolume> volumes) {
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

    /**
     * buildArgs contains build arguments that will be resolved in the Dockerfile.  See https://docs.docker.com/engine/reference/builder/#/arg for more details. NOTE: Only the 'name' and 'value' fields are supported. Any settings on the 'valueFrom' field are ignored.
     */
    @JsonProperty("buildArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getBuildArgs() {
        return buildArgs;
    }

    /**
     * buildArgs contains build arguments that will be resolved in the Dockerfile.  See https://docs.docker.com/engine/reference/builder/#/arg for more details. NOTE: Only the 'name' and 'value' fields are supported. Any settings on the 'valueFrom' field are ignored.
     */
    @JsonProperty("buildArgs")
    public void setBuildArgs(List<EnvVar> buildArgs) {
        this.buildArgs = buildArgs;
    }

    /**
     * dockerfilePath is the path of the Dockerfile that will be used to build the container image, relative to the root of the context (contextDir). Defaults to `Dockerfile` if unset.
     */
    @JsonProperty("dockerfilePath")
    public String getDockerfilePath() {
        return dockerfilePath;
    }

    /**
     * dockerfilePath is the path of the Dockerfile that will be used to build the container image, relative to the root of the context (contextDir). Defaults to `Dockerfile` if unset.
     */
    @JsonProperty("dockerfilePath")
    public void setDockerfilePath(String dockerfilePath) {
        this.dockerfilePath = dockerfilePath;
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
     * DockerBuildStrategy defines input parameters specific to container image build.
     */
    @JsonProperty("from")
    public ObjectReference getFrom() {
        return from;
    }

    /**
     * DockerBuildStrategy defines input parameters specific to container image build.
     */
    @JsonProperty("from")
    public void setFrom(ObjectReference from) {
        this.from = from;
    }

    /**
     * imageOptimizationPolicy describes what optimizations the system can use when building images to reduce the final size or time spent building the image. The default policy is 'None' which means the final build image will be equivalent to an image created by the container image build API. The experimental policy 'SkipLayers' will avoid commiting new layers in between each image step, and will fail if the Dockerfile cannot provide compatibility with the 'None' policy. An additional experimental policy 'SkipLayersAndWarn' is the same as 'SkipLayers' but simply warns if compatibility cannot be preserved.
     */
    @JsonProperty("imageOptimizationPolicy")
    public String getImageOptimizationPolicy() {
        return imageOptimizationPolicy;
    }

    /**
     * imageOptimizationPolicy describes what optimizations the system can use when building images to reduce the final size or time spent building the image. The default policy is 'None' which means the final build image will be equivalent to an image created by the container image build API. The experimental policy 'SkipLayers' will avoid commiting new layers in between each image step, and will fail if the Dockerfile cannot provide compatibility with the 'None' policy. An additional experimental policy 'SkipLayersAndWarn' is the same as 'SkipLayers' but simply warns if compatibility cannot be preserved.
     */
    @JsonProperty("imageOptimizationPolicy")
    public void setImageOptimizationPolicy(String imageOptimizationPolicy) {
        this.imageOptimizationPolicy = imageOptimizationPolicy;
    }

    /**
     * noCache if set to true indicates that the container image build must be executed with the --no-cache=true flag
     */
    @JsonProperty("noCache")
    public Boolean getNoCache() {
        return noCache;
    }

    /**
     * noCache if set to true indicates that the container image build must be executed with the --no-cache=true flag
     */
    @JsonProperty("noCache")
    public void setNoCache(Boolean noCache) {
        this.noCache = noCache;
    }

    /**
     * DockerBuildStrategy defines input parameters specific to container image build.
     */
    @JsonProperty("pullSecret")
    public LocalObjectReference getPullSecret() {
        return pullSecret;
    }

    /**
     * DockerBuildStrategy defines input parameters specific to container image build.
     */
    @JsonProperty("pullSecret")
    public void setPullSecret(LocalObjectReference pullSecret) {
        this.pullSecret = pullSecret;
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
    public DockerBuildStrategyBuilder edit() {
        return new DockerBuildStrategyBuilder(this);
    }

    @JsonIgnore
    public DockerBuildStrategyBuilder toBuilder() {
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
        if (!(o instanceof DockerBuildStrategy)) {
            return false;
        }
        DockerBuildStrategy other = (DockerBuildStrategy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$buildArgs = this.getBuildArgs();
        Object other$buildArgs = other.getBuildArgs();
        if (this$buildArgs == null ? other$buildArgs != null : !this$buildArgs.equals(other$buildArgs)) {
            return false;
        }
        Object this$dockerfilePath = this.getDockerfilePath();
        Object other$dockerfilePath = other.getDockerfilePath();
        if (this$dockerfilePath == null ? other$dockerfilePath != null : !this$dockerfilePath.equals(other$dockerfilePath)) {
            return false;
        }
        Object this$env = this.getEnv();
        Object other$env = other.getEnv();
        if (this$env == null ? other$env != null : !this$env.equals(other$env)) {
            return false;
        }
        Object this$forcePull = this.getForcePull();
        Object other$forcePull = other.getForcePull();
        if (this$forcePull == null ? other$forcePull != null : !this$forcePull.equals(other$forcePull)) {
            return false;
        }
        Object this$from = this.getFrom();
        Object other$from = other.getFrom();
        if (this$from == null ? other$from != null : !this$from.equals(other$from)) {
            return false;
        }
        Object this$imageOptimizationPolicy = this.getImageOptimizationPolicy();
        Object other$imageOptimizationPolicy = other.getImageOptimizationPolicy();
        if (this$imageOptimizationPolicy == null ? other$imageOptimizationPolicy != null : !this$imageOptimizationPolicy.equals(other$imageOptimizationPolicy)) {
            return false;
        }
        Object this$noCache = this.getNoCache();
        Object other$noCache = other.getNoCache();
        if (this$noCache == null ? other$noCache != null : !this$noCache.equals(other$noCache)) {
            return false;
        }
        Object this$pullSecret = this.getPullSecret();
        Object other$pullSecret = other.getPullSecret();
        if (this$pullSecret == null ? other$pullSecret != null : !this$pullSecret.equals(other$pullSecret)) {
            return false;
        }
        Object this$volumes = this.getVolumes();
        Object other$volumes = other.getVolumes();
        if (this$volumes == null ? other$volumes != null : !this$volumes.equals(other$volumes)) {
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
        return other instanceof DockerBuildStrategy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $buildArgs = this.getBuildArgs();
        result = result * prime + ($buildArgs == null ? 43 : $buildArgs.hashCode());
        Object $dockerfilePath = this.getDockerfilePath();
        result = result * prime + ($dockerfilePath == null ? 43 : $dockerfilePath.hashCode());
        Object $env = this.getEnv();
        result = result * prime + ($env == null ? 43 : $env.hashCode());
        Object $forcePull = this.getForcePull();
        result = result * prime + ($forcePull == null ? 43 : $forcePull.hashCode());
        Object $from = this.getFrom();
        result = result * prime + ($from == null ? 43 : $from.hashCode());
        Object $imageOptimizationPolicy = this.getImageOptimizationPolicy();
        result = result * prime + ($imageOptimizationPolicy == null ? 43 : $imageOptimizationPolicy.hashCode());
        Object $noCache = this.getNoCache();
        result = result * prime + ($noCache == null ? 43 : $noCache.hashCode());
        Object $pullSecret = this.getPullSecret();
        result = result * prime + ($pullSecret == null ? 43 : $pullSecret.hashCode());
        Object $volumes = this.getVolumes();
        result = result * prime + ($volumes == null ? 43 : $volumes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DockerBuildStrategy(" + "buildArgs=" + this.getBuildArgs() + ", dockerfilePath=" + this.getDockerfilePath() + ", env=" + this.getEnv() + ", forcePull=" + this.getForcePull() + ", from=" + this.getFrom() + ", imageOptimizationPolicy=" + this.getImageOptimizationPolicy() + ", noCache=" + this.getNoCache() + ", pullSecret=" + this.getPullSecret() + ", volumes=" + this.getVolumes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
