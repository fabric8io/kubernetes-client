
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BuildSource)) {
            return false;
        }
        BuildSource other = (BuildSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$binary = this.getBinary();
        Object other$binary = other.getBinary();
        if (this$binary == null ? other$binary != null : !this$binary.equals(other$binary)) {
            return false;
        }
        Object this$configMaps = this.getConfigMaps();
        Object other$configMaps = other.getConfigMaps();
        if (this$configMaps == null ? other$configMaps != null : !this$configMaps.equals(other$configMaps)) {
            return false;
        }
        Object this$contextDir = this.getContextDir();
        Object other$contextDir = other.getContextDir();
        if (this$contextDir == null ? other$contextDir != null : !this$contextDir.equals(other$contextDir)) {
            return false;
        }
        Object this$dockerfile = this.getDockerfile();
        Object other$dockerfile = other.getDockerfile();
        if (this$dockerfile == null ? other$dockerfile != null : !this$dockerfile.equals(other$dockerfile)) {
            return false;
        }
        Object this$git = this.getGit();
        Object other$git = other.getGit();
        if (this$git == null ? other$git != null : !this$git.equals(other$git)) {
            return false;
        }
        Object this$images = this.getImages();
        Object other$images = other.getImages();
        if (this$images == null ? other$images != null : !this$images.equals(other$images)) {
            return false;
        }
        Object this$secrets = this.getSecrets();
        Object other$secrets = other.getSecrets();
        if (this$secrets == null ? other$secrets != null : !this$secrets.equals(other$secrets)) {
            return false;
        }
        Object this$sourceSecret = this.getSourceSecret();
        Object other$sourceSecret = other.getSourceSecret();
        if (this$sourceSecret == null ? other$sourceSecret != null : !this$sourceSecret.equals(other$sourceSecret)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof BuildSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $binary = this.getBinary();
        result = result * prime + ($binary == null ? 43 : $binary.hashCode());
        Object $configMaps = this.getConfigMaps();
        result = result * prime + ($configMaps == null ? 43 : $configMaps.hashCode());
        Object $contextDir = this.getContextDir();
        result = result * prime + ($contextDir == null ? 43 : $contextDir.hashCode());
        Object $dockerfile = this.getDockerfile();
        result = result * prime + ($dockerfile == null ? 43 : $dockerfile.hashCode());
        Object $git = this.getGit();
        result = result * prime + ($git == null ? 43 : $git.hashCode());
        Object $images = this.getImages();
        result = result * prime + ($images == null ? 43 : $images.hashCode());
        Object $secrets = this.getSecrets();
        result = result * prime + ($secrets == null ? 43 : $secrets.hashCode());
        Object $sourceSecret = this.getSourceSecret();
        result = result * prime + ($sourceSecret == null ? 43 : $sourceSecret.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BuildSource(" + "binary=" + this.getBinary() + ", configMaps=" + this.getConfigMaps() + ", contextDir=" + this.getContextDir() + ", dockerfile=" + this.getDockerfile() + ", git=" + this.getGit() + ", images=" + this.getImages() + ", secrets=" + this.getSecrets() + ", sourceSecret=" + this.getSourceSecret() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
