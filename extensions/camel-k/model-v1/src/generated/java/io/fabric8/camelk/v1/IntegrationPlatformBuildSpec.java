
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
public class IntegrationPlatformBuildSpec implements KubernetesResource
{

    @JsonProperty("baseImage")
    private String baseImage;
    @JsonProperty("buildStrategy")
    private String buildStrategy;
    @JsonProperty("kanikoBuildCache")
    private Boolean kanikoBuildCache;
    @JsonProperty("maven")
    private MavenSpec maven;
    @JsonProperty("persistentVolumeClaim")
    private String persistentVolumeClaim;
    @JsonProperty("publishStrategy")
    private String publishStrategy;
    @JsonProperty("registry")
    private RegistrySpec registry;
    @JsonProperty("runtimeProvider")
    private String runtimeProvider;
    @JsonProperty("runtimeVersion")
    private String runtimeVersion;
    @JsonProperty("timeout")
    private Duration timeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IntegrationPlatformBuildSpec() {
    }

    /**
     * 
     * @param registry
     * @param runtimeVersion
     * @param buildStrategy
     * @param maven
     * @param runtimeProvider
     * @param baseImage
     * @param kanikoBuildCache
     * @param publishStrategy
     * @param persistentVolumeClaim
     * @param timeout
     */
    public IntegrationPlatformBuildSpec(String baseImage, String buildStrategy, Boolean kanikoBuildCache, MavenSpec maven, String persistentVolumeClaim, String publishStrategy, RegistrySpec registry, String runtimeProvider, String runtimeVersion, Duration timeout) {
        super();
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

    @JsonProperty("baseImage")
    public String getBaseImage() {
        return baseImage;
    }

    @JsonProperty("baseImage")
    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    @JsonProperty("buildStrategy")
    public String getBuildStrategy() {
        return buildStrategy;
    }

    @JsonProperty("buildStrategy")
    public void setBuildStrategy(String buildStrategy) {
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
    public String getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    @JsonProperty("persistentVolumeClaim")
    public void setPersistentVolumeClaim(String persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    @JsonProperty("publishStrategy")
    public String getPublishStrategy() {
        return publishStrategy;
    }

    @JsonProperty("publishStrategy")
    public void setPublishStrategy(String publishStrategy) {
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
    public String getRuntimeProvider() {
        return runtimeProvider;
    }

    @JsonProperty("runtimeProvider")
    public void setRuntimeProvider(String runtimeProvider) {
        this.runtimeProvider = runtimeProvider;
    }

    @JsonProperty("runtimeVersion")
    public String getRuntimeVersion() {
        return runtimeVersion;
    }

    @JsonProperty("runtimeVersion")
    public void setRuntimeVersion(String runtimeVersion) {
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
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
