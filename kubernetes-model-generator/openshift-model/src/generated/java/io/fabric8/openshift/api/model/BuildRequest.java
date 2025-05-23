
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
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
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

}
