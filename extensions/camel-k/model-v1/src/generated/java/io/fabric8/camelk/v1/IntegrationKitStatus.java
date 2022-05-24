
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
    "artifacts",
    "baseImage",
    "conditions",
    "digest",
    "failure",
    "image",
    "phase",
    "platform",
    "runtimeProvider",
    "runtimeVersion",
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class IntegrationKitStatus implements KubernetesResource
{

    @JsonProperty("artifacts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Artifact> artifacts = new ArrayList<Artifact>();
    @JsonProperty("baseImage")
    private String baseImage;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IntegrationKitCondition> conditions = new ArrayList<IntegrationKitCondition>();
    @JsonProperty("digest")
    private String digest;
    @JsonProperty("failure")
    private Failure failure;
    @JsonProperty("image")
    private String image;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("runtimeProvider")
    private String runtimeProvider;
    @JsonProperty("runtimeVersion")
    private String runtimeVersion;
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IntegrationKitStatus() {
    }

    /**
     * 
     * @param phase
     * @param image
     * @param runtimeVersion
     * @param failure
     * @param runtimeProvider
     * @param baseImage
     * @param digest
     * @param conditions
     * @param version
     * @param platform
     * @param artifacts
     */
    public IntegrationKitStatus(List<Artifact> artifacts, String baseImage, List<IntegrationKitCondition> conditions, String digest, Failure failure, String image, String phase, String platform, String runtimeProvider, String runtimeVersion, String version) {
        super();
        this.artifacts = artifacts;
        this.baseImage = baseImage;
        this.conditions = conditions;
        this.digest = digest;
        this.failure = failure;
        this.image = image;
        this.phase = phase;
        this.platform = platform;
        this.runtimeProvider = runtimeProvider;
        this.runtimeVersion = runtimeVersion;
        this.version = version;
    }

    @JsonProperty("artifacts")
    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    @JsonProperty("artifacts")
    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    @JsonProperty("baseImage")
    public String getBaseImage() {
        return baseImage;
    }

    @JsonProperty("baseImage")
    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    @JsonProperty("conditions")
    public List<IntegrationKitCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<IntegrationKitCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("digest")
    public String getDigest() {
        return digest;
    }

    @JsonProperty("digest")
    public void setDigest(String digest) {
        this.digest = digest;
    }

    @JsonProperty("failure")
    public Failure getFailure() {
        return failure;
    }

    @JsonProperty("failure")
    public void setFailure(Failure failure) {
        this.failure = failure;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
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
