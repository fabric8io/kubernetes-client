
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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
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
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("build.openshift.io")
@Generated("jsonschema2pojo")
public class BuildRequest implements HasMetadata, Namespaced
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "build.openshift.io/v1";
    @JsonProperty("binary")
    private BinaryBuildSource binary;
    @JsonProperty("dockerStrategyOptions")
    private DockerStrategyOptions dockerStrategyOptions;
    @JsonProperty("env")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> env = new ArrayList<EnvVar>();
    @JsonProperty("from")
    private io.fabric8.kubernetes.api.model.ObjectReference from;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "BuildRequest";
    @JsonProperty("lastVersion")
    private Long lastVersion;
    @JsonProperty("metadata")
    private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
    @JsonProperty("revision")
    private SourceRevision revision;
    @JsonProperty("sourceStrategyOptions")
    private SourceStrategyOptions sourceStrategyOptions;
    @JsonProperty("triggeredBy")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<BuildTriggerCause> triggeredBy = new ArrayList<BuildTriggerCause>();
    @JsonProperty("triggeredByImage")
    private io.fabric8.kubernetes.api.model.ObjectReference triggeredByImage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BuildRequest() {
    }

    public BuildRequest(String apiVersion, BinaryBuildSource binary, DockerStrategyOptions dockerStrategyOptions, List<EnvVar> env, io.fabric8.kubernetes.api.model.ObjectReference from, String kind, Long lastVersion, io.fabric8.kubernetes.api.model.ObjectMeta metadata, SourceRevision revision, SourceStrategyOptions sourceStrategyOptions, List<BuildTriggerCause> triggeredBy, io.fabric8.kubernetes.api.model.ObjectReference triggeredByImage) {
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("binary")
    public BinaryBuildSource getBinary() {
        return binary;
    }

    @JsonProperty("binary")
    public void setBinary(BinaryBuildSource binary) {
        this.binary = binary;
    }

    @JsonProperty("dockerStrategyOptions")
    public DockerStrategyOptions getDockerStrategyOptions() {
        return dockerStrategyOptions;
    }

    @JsonProperty("dockerStrategyOptions")
    public void setDockerStrategyOptions(DockerStrategyOptions dockerStrategyOptions) {
        this.dockerStrategyOptions = dockerStrategyOptions;
    }

    @JsonProperty("env")
    public List<EnvVar> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<EnvVar> env) {
        this.env = env;
    }

    @JsonProperty("from")
    public io.fabric8.kubernetes.api.model.ObjectReference getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(io.fabric8.kubernetes.api.model.ObjectReference from) {
        this.from = from;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("lastVersion")
    public Long getLastVersion() {
        return lastVersion;
    }

    @JsonProperty("lastVersion")
    public void setLastVersion(Long lastVersion) {
        this.lastVersion = lastVersion;
    }

    @JsonProperty("metadata")
    public io.fabric8.kubernetes.api.model.ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(io.fabric8.kubernetes.api.model.ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("revision")
    public SourceRevision getRevision() {
        return revision;
    }

    @JsonProperty("revision")
    public void setRevision(SourceRevision revision) {
        this.revision = revision;
    }

    @JsonProperty("sourceStrategyOptions")
    public SourceStrategyOptions getSourceStrategyOptions() {
        return sourceStrategyOptions;
    }

    @JsonProperty("sourceStrategyOptions")
    public void setSourceStrategyOptions(SourceStrategyOptions sourceStrategyOptions) {
        this.sourceStrategyOptions = sourceStrategyOptions;
    }

    @JsonProperty("triggeredBy")
    public List<BuildTriggerCause> getTriggeredBy() {
        return triggeredBy;
    }

    @JsonProperty("triggeredBy")
    public void setTriggeredBy(List<BuildTriggerCause> triggeredBy) {
        this.triggeredBy = triggeredBy;
    }

    @JsonProperty("triggeredByImage")
    public io.fabric8.kubernetes.api.model.ObjectReference getTriggeredByImage() {
        return triggeredByImage;
    }

    @JsonProperty("triggeredByImage")
    public void setTriggeredByImage(io.fabric8.kubernetes.api.model.ObjectReference triggeredByImage) {
        this.triggeredByImage = triggeredByImage;
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
