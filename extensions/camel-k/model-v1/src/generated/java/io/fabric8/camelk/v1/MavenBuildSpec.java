
package io.fabric8.camelk.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.SecretKeySelector;
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
    "caSecret",
    "cliOptions",
    "extension",
    "localRepository",
    "properties",
    "repositories",
    "settings",
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
public class MavenBuildSpec implements KubernetesResource
{

    @JsonProperty("caSecret")
    private SecretKeySelector caSecret;
    @JsonProperty("cliOptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> cliOptions = new ArrayList<java.lang.String>();
    @JsonProperty("extension")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MavenArtifact> extension = new ArrayList<MavenArtifact>();
    @JsonProperty("localRepository")
    private java.lang.String localRepository;
    @JsonProperty("properties")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> properties = new LinkedHashMap<String, String>();
    @JsonProperty("repositories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Repository> repositories = new ArrayList<Repository>();
    @JsonProperty("settings")
    private ValueSource settings;
    @JsonProperty("timeout")
    private Duration timeout;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MavenBuildSpec() {
    }

    /**
     * 
     * @param settings
     * @param extension
     * @param repositories
     * @param cliOptions
     * @param properties
     * @param timeout
     * @param caSecret
     * @param localRepository
     */
    public MavenBuildSpec(SecretKeySelector caSecret, List<java.lang.String> cliOptions, List<MavenArtifact> extension, java.lang.String localRepository, Map<String, String> properties, List<Repository> repositories, ValueSource settings, Duration timeout) {
        super();
        this.caSecret = caSecret;
        this.cliOptions = cliOptions;
        this.extension = extension;
        this.localRepository = localRepository;
        this.properties = properties;
        this.repositories = repositories;
        this.settings = settings;
        this.timeout = timeout;
    }

    @JsonProperty("caSecret")
    public SecretKeySelector getCaSecret() {
        return caSecret;
    }

    @JsonProperty("caSecret")
    public void setCaSecret(SecretKeySelector caSecret) {
        this.caSecret = caSecret;
    }

    @JsonProperty("cliOptions")
    public List<java.lang.String> getCliOptions() {
        return cliOptions;
    }

    @JsonProperty("cliOptions")
    public void setCliOptions(List<java.lang.String> cliOptions) {
        this.cliOptions = cliOptions;
    }

    @JsonProperty("extension")
    public List<MavenArtifact> getExtension() {
        return extension;
    }

    @JsonProperty("extension")
    public void setExtension(List<MavenArtifact> extension) {
        this.extension = extension;
    }

    @JsonProperty("localRepository")
    public java.lang.String getLocalRepository() {
        return localRepository;
    }

    @JsonProperty("localRepository")
    public void setLocalRepository(java.lang.String localRepository) {
        this.localRepository = localRepository;
    }

    @JsonProperty("properties")
    public Map<String, String> getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    @JsonProperty("repositories")
    public List<Repository> getRepositories() {
        return repositories;
    }

    @JsonProperty("repositories")
    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @JsonProperty("settings")
    public ValueSource getSettings() {
        return settings;
    }

    @JsonProperty("settings")
    public void setSettings(ValueSource settings) {
        this.settings = settings;
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
