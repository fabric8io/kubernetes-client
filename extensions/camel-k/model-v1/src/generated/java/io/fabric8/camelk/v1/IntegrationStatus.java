
package io.fabric8.camelk.v1;

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
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
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
    "capabilities",
    "conditions",
    "configuration",
    "dependencies",
    "digest",
    "generatedResources",
    "generatedSources",
    "image",
    "integrationKit",
    "kit",
    "lastInitTimestamp",
    "phase",
    "platform",
    "profile",
    "replicas",
    "runtimeProvider",
    "runtimeVersion",
    "selector",
    "version"
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class IntegrationStatus implements KubernetesResource
{

    @JsonProperty("capabilities")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> capabilities = new ArrayList<String>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IntegrationCondition> conditions = new ArrayList<IntegrationCondition>();
    @JsonProperty("configuration")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConfigurationSpec> configuration = new ArrayList<ConfigurationSpec>();
    @JsonProperty("dependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dependencies = new ArrayList<String>();
    @JsonProperty("digest")
    private String digest;
    @JsonProperty("generatedResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceSpec> generatedResources = new ArrayList<ResourceSpec>();
    @JsonProperty("generatedSources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SourceSpec> generatedSources = new ArrayList<SourceSpec>();
    @JsonProperty("image")
    private String image;
    @JsonProperty("integrationKit")
    private io.fabric8.kubernetes.api.model.ObjectReference integrationKit;
    @JsonProperty("kit")
    private String kit;
    @JsonProperty("lastInitTimestamp")
    private String lastInitTimestamp;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("profile")
    private String profile;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("runtimeProvider")
    private String runtimeProvider;
    @JsonProperty("runtimeVersion")
    private String runtimeVersion;
    @JsonProperty("selector")
    private String selector;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IntegrationStatus() {
    }

    /**
     * 
     * @param phase
     * @param image
     * @param runtimeVersion
     * @param capabilities
     * @param configuration
     * @param integrationKit
     * @param replicas
     * @param profile
     * @param runtimeProvider
     * @param version
     * @param platform
     * @param dependencies
     * @param generatedResources
     * @param lastInitTimestamp
     * @param kit
     * @param digest
     * @param selector
     * @param conditions
     * @param generatedSources
     */
    public IntegrationStatus(List<String> capabilities, List<IntegrationCondition> conditions, List<ConfigurationSpec> configuration, List<String> dependencies, String digest, List<ResourceSpec> generatedResources, List<SourceSpec> generatedSources, String image, io.fabric8.kubernetes.api.model.ObjectReference integrationKit, String kit, String lastInitTimestamp, String phase, String platform, String profile, Integer replicas, String runtimeProvider, String runtimeVersion, String selector, String version) {
        super();
        this.capabilities = capabilities;
        this.conditions = conditions;
        this.configuration = configuration;
        this.dependencies = dependencies;
        this.digest = digest;
        this.generatedResources = generatedResources;
        this.generatedSources = generatedSources;
        this.image = image;
        this.integrationKit = integrationKit;
        this.kit = kit;
        this.lastInitTimestamp = lastInitTimestamp;
        this.phase = phase;
        this.platform = platform;
        this.profile = profile;
        this.replicas = replicas;
        this.runtimeProvider = runtimeProvider;
        this.runtimeVersion = runtimeVersion;
        this.selector = selector;
        this.version = version;
    }

    @JsonProperty("capabilities")
    public List<String> getCapabilities() {
        return capabilities;
    }

    @JsonProperty("capabilities")
    public void setCapabilities(List<String> capabilities) {
        this.capabilities = capabilities;
    }

    @JsonProperty("conditions")
    public List<IntegrationCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<IntegrationCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("configuration")
    public List<ConfigurationSpec> getConfiguration() {
        return configuration;
    }

    @JsonProperty("configuration")
    public void setConfiguration(List<ConfigurationSpec> configuration) {
        this.configuration = configuration;
    }

    @JsonProperty("dependencies")
    public List<String> getDependencies() {
        return dependencies;
    }

    @JsonProperty("dependencies")
    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }

    @JsonProperty("digest")
    public String getDigest() {
        return digest;
    }

    @JsonProperty("digest")
    public void setDigest(String digest) {
        this.digest = digest;
    }

    @JsonProperty("generatedResources")
    public List<ResourceSpec> getGeneratedResources() {
        return generatedResources;
    }

    @JsonProperty("generatedResources")
    public void setGeneratedResources(List<ResourceSpec> generatedResources) {
        this.generatedResources = generatedResources;
    }

    @JsonProperty("generatedSources")
    public List<SourceSpec> getGeneratedSources() {
        return generatedSources;
    }

    @JsonProperty("generatedSources")
    public void setGeneratedSources(List<SourceSpec> generatedSources) {
        this.generatedSources = generatedSources;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("integrationKit")
    public io.fabric8.kubernetes.api.model.ObjectReference getIntegrationKit() {
        return integrationKit;
    }

    @JsonProperty("integrationKit")
    public void setIntegrationKit(io.fabric8.kubernetes.api.model.ObjectReference integrationKit) {
        this.integrationKit = integrationKit;
    }

    @JsonProperty("kit")
    public String getKit() {
        return kit;
    }

    @JsonProperty("kit")
    public void setKit(String kit) {
        this.kit = kit;
    }

    @JsonProperty("lastInitTimestamp")
    public String getLastInitTimestamp() {
        return lastInitTimestamp;
    }

    @JsonProperty("lastInitTimestamp")
    public void setLastInitTimestamp(String lastInitTimestamp) {
        this.lastInitTimestamp = lastInitTimestamp;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @JsonProperty("profile")
    public String getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(String profile) {
        this.profile = profile;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
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

    @JsonProperty("selector")
    public String getSelector() {
        return selector;
    }

    @JsonProperty("selector")
    public void setSelector(String selector) {
        this.selector = selector;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
