
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * BuildSource is the SCM used for the build.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "binary",
    "configMaps",
    "contextDir",
    "dockerfile",
    "git",
    "images",
    "secrets",
    "sourceSecret",
    "type"
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BuildSource implements Editable<BuildSourceBuilder>, KubernetesResource
{

    @JsonProperty("binary")
    private BinaryBuildSource binary;
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConfigMapBuildSource> configMaps = new ArrayList<>();
    @JsonProperty("contextDir")
    private String contextDir;
    @JsonProperty("dockerfile")
    private String dockerfile;
    @JsonProperty("git")
    private GitBuildSource git;
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageSource> images = new ArrayList<>();
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecretBuildSource> secrets = new ArrayList<>();
    @JsonProperty("sourceSecret")
    private LocalObjectReference sourceSecret;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildSource() {
    }

    public BuildSource(BinaryBuildSource binary, List<ConfigMapBuildSource> configMaps, String contextDir, String dockerfile, GitBuildSource git, List<ImageSource> images, List<SecretBuildSource> secrets, LocalObjectReference sourceSecret, String type) {
        super();
        this.binary = binary;
        this.configMaps = configMaps;
        this.contextDir = contextDir;
        this.dockerfile = dockerfile;
        this.git = git;
        this.images = images;
        this.secrets = secrets;
        this.sourceSecret = sourceSecret;
        this.type = type;
    }

    /**
     * BuildSource is the SCM used for the build.
     */
    @JsonProperty("binary")
    public BinaryBuildSource getBinary() {
        return binary;
    }

    /**
     * BuildSource is the SCM used for the build.
     */
    @JsonProperty("binary")
    public void setBinary(BinaryBuildSource binary) {
        this.binary = binary;
    }

    /**
     * configMaps represents a list of configMaps and their destinations that will be used for the build.
     */
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ConfigMapBuildSource> getConfigMaps() {
        return configMaps;
    }

    /**
     * configMaps represents a list of configMaps and their destinations that will be used for the build.
     */
    @JsonProperty("configMaps")
    public void setConfigMaps(List<ConfigMapBuildSource> configMaps) {
        this.configMaps = configMaps;
    }

    /**
     * contextDir specifies the sub-directory where the source code for the application exists. This allows to have buildable sources in directory other than root of repository.
     */
    @JsonProperty("contextDir")
    public String getContextDir() {
        return contextDir;
    }

    /**
     * contextDir specifies the sub-directory where the source code for the application exists. This allows to have buildable sources in directory other than root of repository.
     */
    @JsonProperty("contextDir")
    public void setContextDir(String contextDir) {
        this.contextDir = contextDir;
    }

    /**
     * dockerfile is the raw contents of a Dockerfile which should be built. When this option is specified, the FROM may be modified based on your strategy base image and additional ENV stanzas from your strategy environment will be added after the FROM, but before the rest of your Dockerfile stanzas. The Dockerfile source type may be used with other options like git - in those cases the Git repo will have any innate Dockerfile replaced in the context dir.
     */
    @JsonProperty("dockerfile")
    public String getDockerfile() {
        return dockerfile;
    }

    /**
     * dockerfile is the raw contents of a Dockerfile which should be built. When this option is specified, the FROM may be modified based on your strategy base image and additional ENV stanzas from your strategy environment will be added after the FROM, but before the rest of your Dockerfile stanzas. The Dockerfile source type may be used with other options like git - in those cases the Git repo will have any innate Dockerfile replaced in the context dir.
     */
    @JsonProperty("dockerfile")
    public void setDockerfile(String dockerfile) {
        this.dockerfile = dockerfile;
    }

    /**
     * BuildSource is the SCM used for the build.
     */
    @JsonProperty("git")
    public GitBuildSource getGit() {
        return git;
    }

    /**
     * BuildSource is the SCM used for the build.
     */
    @JsonProperty("git")
    public void setGit(GitBuildSource git) {
        this.git = git;
    }

    /**
     * images describes a set of images to be used to provide source for the build
     */
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ImageSource> getImages() {
        return images;
    }

    /**
     * images describes a set of images to be used to provide source for the build
     */
    @JsonProperty("images")
    public void setImages(List<ImageSource> images) {
        this.images = images;
    }

    /**
     * secrets represents a list of secrets and their destinations that will be used only for the build.
     */
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SecretBuildSource> getSecrets() {
        return secrets;
    }

    /**
     * secrets represents a list of secrets and their destinations that will be used only for the build.
     */
    @JsonProperty("secrets")
    public void setSecrets(List<SecretBuildSource> secrets) {
        this.secrets = secrets;
    }

    /**
     * BuildSource is the SCM used for the build.
     */
    @JsonProperty("sourceSecret")
    public LocalObjectReference getSourceSecret() {
        return sourceSecret;
    }

    /**
     * BuildSource is the SCM used for the build.
     */
    @JsonProperty("sourceSecret")
    public void setSourceSecret(LocalObjectReference sourceSecret) {
        this.sourceSecret = sourceSecret;
    }

    /**
     * type of build input to accept
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type of build input to accept
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public BuildSourceBuilder edit() {
        return new BuildSourceBuilder(this);
    }

    @JsonIgnore
    public BuildSourceBuilder toBuilder() {
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
