
package io.fabric8.camelk.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.Duration;
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
    "PublishStrategyOptions",
    "baseImage",
    "buildStrategy",
    "kanikoBuildCache",
    "maven",
    "persistentVolumeClaim",
    "publishStrategy",
    "registry",
    "runtimeProvider",
    "runtimeVersion",
    "timeout"
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
@Generated("jsonschema2pojo")
public class IntegrationPlatformBuildSpec implements KubernetesResource
{

    @JsonProperty("PublishStrategyOptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> publishStrategyOptions = new LinkedHashMap<String, String>();
    @JsonProperty("baseImage")
    private java.lang.String baseImage;
    @JsonProperty("buildStrategy")
    private java.lang.String buildStrategy;
    @JsonProperty("kanikoBuildCache")
    private Boolean kanikoBuildCache;
    @JsonProperty("maven")
    private MavenSpec maven;
    @JsonProperty("persistentVolumeClaim")
    private java.lang.String persistentVolumeClaim;
    @JsonProperty("publishStrategy")
    private java.lang.String publishStrategy;
    @JsonProperty("registry")
    private RegistrySpec registry;
    @JsonProperty("runtimeProvider")
    private java.lang.String runtimeProvider;
    @JsonProperty("runtimeVersion")
    private java.lang.String runtimeVersion;
    @JsonProperty("timeout")
    private Duration timeout;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IntegrationPlatformBuildSpec() {
    }

    public IntegrationPlatformBuildSpec(Map<String, String> publishStrategyOptions, java.lang.String baseImage, java.lang.String buildStrategy, Boolean kanikoBuildCache, MavenSpec maven, java.lang.String persistentVolumeClaim, java.lang.String publishStrategy, RegistrySpec registry, java.lang.String runtimeProvider, java.lang.String runtimeVersion, Duration timeout) {
        super();
        this.publishStrategyOptions = publishStrategyOptions;
        this.baseImage = baseImage;
        this.buildStrategy = buildStrategy;
        this.kanikoBuildCache = kanikoBuildCache;
        this.maven = maven;
        this.persistentVolumeClaim = persistentVolumeClaim;
        this.publishStrategy = publishStrategy;
        this.registry = registry;
        this.runtimeProvider = runtimeProvider;
        this.runtimeVersion = runtimeVersion;
        this.timeout = timeout;
    }

    @JsonProperty("PublishStrategyOptions")
    public Map<String, String> getPublishStrategyOptions() {
        return publishStrategyOptions;
    }

    @JsonProperty("PublishStrategyOptions")
    public void setPublishStrategyOptions(Map<String, String> publishStrategyOptions) {
        this.publishStrategyOptions = publishStrategyOptions;
    }

    @JsonProperty("baseImage")
    public java.lang.String getBaseImage() {
        return baseImage;
    }

    @JsonProperty("baseImage")
    public void setBaseImage(java.lang.String baseImage) {
        this.baseImage = baseImage;
    }

    @JsonProperty("buildStrategy")
    public java.lang.String getBuildStrategy() {
        return buildStrategy;
    }

    @JsonProperty("buildStrategy")
    public void setBuildStrategy(java.lang.String buildStrategy) {
        this.buildStrategy = buildStrategy;
    }

    @JsonProperty("kanikoBuildCache")
    public Boolean getKanikoBuildCache() {
        return kanikoBuildCache;
    }

    @JsonProperty("kanikoBuildCache")
    public void setKanikoBuildCache(Boolean kanikoBuildCache) {
        this.kanikoBuildCache = kanikoBuildCache;
    }

    @JsonProperty("maven")
    public MavenSpec getMaven() {
        return maven;
    }

    @JsonProperty("maven")
    public void setMaven(MavenSpec maven) {
        this.maven = maven;
    }

    @JsonProperty("persistentVolumeClaim")
    public java.lang.String getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    @JsonProperty("persistentVolumeClaim")
    public void setPersistentVolumeClaim(java.lang.String persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    @JsonProperty("publishStrategy")
    public java.lang.String getPublishStrategy() {
        return publishStrategy;
    }

    @JsonProperty("publishStrategy")
    public void setPublishStrategy(java.lang.String publishStrategy) {
        this.publishStrategy = publishStrategy;
    }

    @JsonProperty("registry")
    public RegistrySpec getRegistry() {
        return registry;
    }

    @JsonProperty("registry")
    public void setRegistry(RegistrySpec registry) {
        this.registry = registry;
    }

    @JsonProperty("runtimeProvider")
    public java.lang.String getRuntimeProvider() {
        return runtimeProvider;
    }

    @JsonProperty("runtimeProvider")
    public void setRuntimeProvider(java.lang.String runtimeProvider) {
        this.runtimeProvider = runtimeProvider;
    }

    @JsonProperty("runtimeVersion")
    public java.lang.String getRuntimeVersion() {
        return runtimeVersion;
    }

    @JsonProperty("runtimeVersion")
    public void setRuntimeVersion(java.lang.String runtimeVersion) {
        this.runtimeVersion = runtimeVersion;
    }

    @JsonProperty("timeout")
    public Duration getTimeout() {
        return timeout;
    }

    @JsonProperty("timeout")
    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
