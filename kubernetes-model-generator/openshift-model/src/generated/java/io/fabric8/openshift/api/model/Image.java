
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "dockerImageConfig",
    "dockerImageLayers",
    "dockerImageManifest",
    "dockerImageManifestMediaType",
    "dockerImageManifests",
    "dockerImageMetadata",
    "dockerImageMetadataVersion",
    "dockerImageReference",
    "dockerImageSignatures",
    "signatures"
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
    @BuildableReference(LocalObjectReference.class),
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
@Group("image.openshift.io")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Image implements Editable<ImageBuilder>, HasMetadata
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "image.openshift.io/v1";
    @JsonProperty("dockerImageConfig")
    private String dockerImageConfig;
    @JsonProperty("dockerImageLayers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageLayer> dockerImageLayers = new ArrayList<>();
    @JsonProperty("dockerImageManifest")
    private String dockerImageManifest;
    @JsonProperty("dockerImageManifestMediaType")
    private String dockerImageManifestMediaType;
    @JsonProperty("dockerImageManifests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageManifest> dockerImageManifests = new ArrayList<>();
    @JsonProperty("dockerImageMetadata")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object dockerImageMetadata;
    @JsonProperty("dockerImageMetadataVersion")
    private String dockerImageMetadataVersion;
    @JsonProperty("dockerImageReference")
    private String dockerImageReference;
    @JsonProperty("dockerImageSignatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dockerImageSignatures = new ArrayList<>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "Image";
    @JsonProperty("metadata")
    private ObjectMeta metadata;
    @JsonProperty("signatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageSignature> signatures = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    public Image(String apiVersion, String dockerImageConfig, List<ImageLayer> dockerImageLayers, String dockerImageManifest, String dockerImageManifestMediaType, List<ImageManifest> dockerImageManifests, Object dockerImageMetadata, String dockerImageMetadataVersion, String dockerImageReference, List<String> dockerImageSignatures, String kind, ObjectMeta metadata, List<ImageSignature> signatures) {
        super();
        this.apiVersion = apiVersion;
        this.dockerImageConfig = dockerImageConfig;
        this.dockerImageLayers = dockerImageLayers;
        this.dockerImageManifest = dockerImageManifest;
        this.dockerImageManifestMediaType = dockerImageManifestMediaType;
        this.dockerImageManifests = dockerImageManifests;
        this.dockerImageMetadata = dockerImageMetadata;
        this.dockerImageMetadataVersion = dockerImageMetadataVersion;
        this.dockerImageReference = dockerImageReference;
        this.dockerImageSignatures = dockerImageSignatures;
        this.kind = kind;
        this.metadata = metadata;
        this.signatures = signatures;
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

    @JsonProperty("dockerImageConfig")
    public String getDockerImageConfig() {
        return dockerImageConfig;
    }

    @JsonProperty("dockerImageConfig")
    public void setDockerImageConfig(String dockerImageConfig) {
        this.dockerImageConfig = dockerImageConfig;
    }

    @JsonProperty("dockerImageLayers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageLayer> getDockerImageLayers() {
        return dockerImageLayers;
    }

    @JsonProperty("dockerImageLayers")
    public void setDockerImageLayers(List<ImageLayer> dockerImageLayers) {
        this.dockerImageLayers = dockerImageLayers;
    }

    @JsonProperty("dockerImageManifest")
    public String getDockerImageManifest() {
        return dockerImageManifest;
    }

    @JsonProperty("dockerImageManifest")
    public void setDockerImageManifest(String dockerImageManifest) {
        this.dockerImageManifest = dockerImageManifest;
    }

    @JsonProperty("dockerImageManifestMediaType")
    public String getDockerImageManifestMediaType() {
        return dockerImageManifestMediaType;
    }

    @JsonProperty("dockerImageManifestMediaType")
    public void setDockerImageManifestMediaType(String dockerImageManifestMediaType) {
        this.dockerImageManifestMediaType = dockerImageManifestMediaType;
    }

    @JsonProperty("dockerImageManifests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageManifest> getDockerImageManifests() {
        return dockerImageManifests;
    }

    @JsonProperty("dockerImageManifests")
    public void setDockerImageManifests(List<ImageManifest> dockerImageManifests) {
        this.dockerImageManifests = dockerImageManifests;
    }

    @JsonProperty("dockerImageMetadata")
    public Object getDockerImageMetadata() {
        return dockerImageMetadata;
    }

    @JsonProperty("dockerImageMetadata")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setDockerImageMetadata(Object dockerImageMetadata) {
        this.dockerImageMetadata = dockerImageMetadata;
    }

    @JsonProperty("dockerImageMetadataVersion")
    public String getDockerImageMetadataVersion() {
        return dockerImageMetadataVersion;
    }

    @JsonProperty("dockerImageMetadataVersion")
    public void setDockerImageMetadataVersion(String dockerImageMetadataVersion) {
        this.dockerImageMetadataVersion = dockerImageMetadataVersion;
    }

    @JsonProperty("dockerImageReference")
    public String getDockerImageReference() {
        return dockerImageReference;
    }

    @JsonProperty("dockerImageReference")
    public void setDockerImageReference(String dockerImageReference) {
        this.dockerImageReference = dockerImageReference;
    }

    @JsonProperty("dockerImageSignatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDockerImageSignatures() {
        return dockerImageSignatures;
    }

    @JsonProperty("dockerImageSignatures")
    public void setDockerImageSignatures(List<String> dockerImageSignatures) {
        this.dockerImageSignatures = dockerImageSignatures;
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

    @JsonProperty("metadata")
    public ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("signatures")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageSignature> getSignatures() {
        return signatures;
    }

    @JsonProperty("signatures")
    public void setSignatures(List<ImageSignature> signatures) {
        this.signatures = signatures;
    }

    @JsonIgnore
    public ImageBuilder edit() {
        return new ImageBuilder(this);
    }

    @JsonIgnore
    public ImageBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
