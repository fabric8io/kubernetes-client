
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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "binary",
    "dockerStrategyOptions",
    "env",
    "from",
    "lastVersion",
    "revision",
    "sourceStrategyOptions",
    "triggeredBy",
    "triggeredByImage"
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
@Version("v1")
@Group("build.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BuildRequest implements Editable<BuildRequestBuilder>, HasMetadata, Namespaced
{

    @JsonProperty("apiVersion")
    private String apiVersion = "build.openshift.io/v1";
    @JsonProperty("binary")
    private BinaryBuildSource binary;
    @JsonProperty("dockerStrategyOptions")
    private DockerStrategyOptions dockerStrategyOptions;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<>();
    @JsonProperty("from")
    private ObjectReference from;
    @JsonProperty("kind")
    private String kind = "BuildRequest";
    @JsonProperty("lastVersion")
    private Long lastVersion;
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("revision")
    private SourceRevision revision;
    @JsonProperty("sourceStrategyOptions")
    private SourceStrategyOptions sourceStrategyOptions;
    @JsonProperty("triggeredBy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BuildTriggerCause> triggeredBy = new ArrayList<>();
    @JsonProperty("triggeredByImage")
    private ObjectReference triggeredByImage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildRequest() {
    }

    public BuildRequest(String apiVersion, BinaryBuildSource binary, DockerStrategyOptions dockerStrategyOptions, List<EnvVar> env, ObjectReference from, String kind, Long lastVersion, ObjectMeta metadata, SourceRevision revision, SourceStrategyOptions sourceStrategyOptions, List<BuildTriggerCause> triggeredBy, ObjectReference triggeredByImage) {
        super();
        this.apiVersion = apiVersion;
        this.binary = binary;
        this.dockerStrategyOptions = dockerStrategyOptions;
        this.env = env;
        this.from = from;
        this.kind = kind;
        this.lastVersion = lastVersion;
        this.metadata = metadata;
        this.revision = revision;
        this.sourceStrategyOptions = sourceStrategyOptions;
        this.triggeredBy = triggeredBy;
        this.triggeredByImage = triggeredByImage;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("binary")
    public BinaryBuildSource getBinary() {
        return binary;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("binary")
    public void setBinary(BinaryBuildSource binary) {
        this.binary = binary;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("dockerStrategyOptions")
    public DockerStrategyOptions getDockerStrategyOptions() {
        return dockerStrategyOptions;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("dockerStrategyOptions")
    public void setDockerStrategyOptions(DockerStrategyOptions dockerStrategyOptions) {
        this.dockerStrategyOptions = dockerStrategyOptions;
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
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("from")
    public ObjectReference getFrom() {
        return from;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("from")
    public void setFrom(ObjectReference from) {
        this.from = from;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * lastVersion (optional) is the LastVersion of the BuildConfig that was used to generate the build. If the BuildConfig in the generator doesn't match, a build will not be generated.
     */
    @JsonProperty("lastVersion")
    public Long getLastVersion() {
        return lastVersion;
    }

    /**
     * lastVersion (optional) is the LastVersion of the BuildConfig that was used to generate the build. If the BuildConfig in the generator doesn't match, a build will not be generated.
     */
    @JsonProperty("lastVersion")
    public void setLastVersion(Long lastVersion) {
        this.lastVersion = lastVersion;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("revision")
    public SourceRevision getRevision() {
        return revision;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("revision")
    public void setRevision(SourceRevision revision) {
        this.revision = revision;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("sourceStrategyOptions")
    public SourceStrategyOptions getSourceStrategyOptions() {
        return sourceStrategyOptions;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("sourceStrategyOptions")
    public void setSourceStrategyOptions(SourceStrategyOptions sourceStrategyOptions) {
        this.sourceStrategyOptions = sourceStrategyOptions;
    }

    /**
     * triggeredBy describes which triggers started the most recent update to the build configuration and contains information about those triggers.
     */
    @JsonProperty("triggeredBy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<BuildTriggerCause> getTriggeredBy() {
        return triggeredBy;
    }

    /**
     * triggeredBy describes which triggers started the most recent update to the build configuration and contains information about those triggers.
     */
    @JsonProperty("triggeredBy")
    public void setTriggeredBy(List<BuildTriggerCause> triggeredBy) {
        this.triggeredBy = triggeredBy;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("triggeredByImage")
    public ObjectReference getTriggeredByImage() {
        return triggeredByImage;
    }

    /**
     * BuildRequest is the resource used to pass parameters to build generator<br><p> <br><p> Compatibility level 1: Stable within a major release for a minimum of 12 months or 3 minor releases (whichever is longer).
     */
    @JsonProperty("triggeredByImage")
    public void setTriggeredByImage(ObjectReference triggeredByImage) {
        this.triggeredByImage = triggeredByImage;
    }

    @JsonIgnore
    public BuildRequestBuilder edit() {
        return new BuildRequestBuilder(this);
    }

    @JsonIgnore
    public BuildRequestBuilder toBuilder() {
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
        if (!(o instanceof BuildRequest)) {
            return false;
        }
        BuildRequest other = (BuildRequest) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$binary = this.getBinary();
        Object other$binary = other.getBinary();
        if (this$binary == null ? other$binary != null : !this$binary.equals(other$binary)) {
            return false;
        }
        Object this$dockerStrategyOptions = this.getDockerStrategyOptions();
        Object other$dockerStrategyOptions = other.getDockerStrategyOptions();
        if (this$dockerStrategyOptions == null ? other$dockerStrategyOptions != null : !this$dockerStrategyOptions.equals(other$dockerStrategyOptions)) {
            return false;
        }
        Object this$env = this.getEnv();
        Object other$env = other.getEnv();
        if (this$env == null ? other$env != null : !this$env.equals(other$env)) {
            return false;
        }
        Object this$from = this.getFrom();
        Object other$from = other.getFrom();
        if (this$from == null ? other$from != null : !this$from.equals(other$from)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$lastVersion = this.getLastVersion();
        Object other$lastVersion = other.getLastVersion();
        if (this$lastVersion == null ? other$lastVersion != null : !this$lastVersion.equals(other$lastVersion)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$revision = this.getRevision();
        Object other$revision = other.getRevision();
        if (this$revision == null ? other$revision != null : !this$revision.equals(other$revision)) {
            return false;
        }
        Object this$sourceStrategyOptions = this.getSourceStrategyOptions();
        Object other$sourceStrategyOptions = other.getSourceStrategyOptions();
        if (this$sourceStrategyOptions == null ? other$sourceStrategyOptions != null : !this$sourceStrategyOptions.equals(other$sourceStrategyOptions)) {
            return false;
        }
        Object this$triggeredBy = this.getTriggeredBy();
        Object other$triggeredBy = other.getTriggeredBy();
        if (this$triggeredBy == null ? other$triggeredBy != null : !this$triggeredBy.equals(other$triggeredBy)) {
            return false;
        }
        Object this$triggeredByImage = this.getTriggeredByImage();
        Object other$triggeredByImage = other.getTriggeredByImage();
        if (this$triggeredByImage == null ? other$triggeredByImage != null : !this$triggeredByImage.equals(other$triggeredByImage)) {
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
        return other instanceof BuildRequest;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $binary = this.getBinary();
        result = result * prime + ($binary == null ? 43 : $binary.hashCode());
        Object $dockerStrategyOptions = this.getDockerStrategyOptions();
        result = result * prime + ($dockerStrategyOptions == null ? 43 : $dockerStrategyOptions.hashCode());
        Object $env = this.getEnv();
        result = result * prime + ($env == null ? 43 : $env.hashCode());
        Object $from = this.getFrom();
        result = result * prime + ($from == null ? 43 : $from.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $lastVersion = this.getLastVersion();
        result = result * prime + ($lastVersion == null ? 43 : $lastVersion.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $revision = this.getRevision();
        result = result * prime + ($revision == null ? 43 : $revision.hashCode());
        Object $sourceStrategyOptions = this.getSourceStrategyOptions();
        result = result * prime + ($sourceStrategyOptions == null ? 43 : $sourceStrategyOptions.hashCode());
        Object $triggeredBy = this.getTriggeredBy();
        result = result * prime + ($triggeredBy == null ? 43 : $triggeredBy.hashCode());
        Object $triggeredByImage = this.getTriggeredByImage();
        result = result * prime + ($triggeredByImage == null ? 43 : $triggeredByImage.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BuildRequest(" + "apiVersion=" + this.getApiVersion() + ", binary=" + this.getBinary() + ", dockerStrategyOptions=" + this.getDockerStrategyOptions() + ", env=" + this.getEnv() + ", from=" + this.getFrom() + ", kind=" + this.getKind() + ", lastVersion=" + this.getLastVersion() + ", metadata=" + this.getMetadata() + ", revision=" + this.getRevision() + ", sourceStrategyOptions=" + this.getSourceStrategyOptions() + ", triggeredBy=" + this.getTriggeredBy() + ", triggeredByImage=" + this.getTriggeredByImage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
