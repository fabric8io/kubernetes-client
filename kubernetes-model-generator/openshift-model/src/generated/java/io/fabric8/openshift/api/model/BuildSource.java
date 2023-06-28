
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
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class BuildSource implements KubernetesResource
{

    @JsonProperty("binary")
    private BinaryBuildSource binary;
    @JsonProperty("configMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConfigMapBuildSource> configMaps = new ArrayList<ConfigMapBuildSource>();
    @JsonProperty("contextDir")
    private String contextDir;
    @JsonProperty("dockerfile")
    private String dockerfile;
    @JsonProperty("git")
    private GitBuildSource git;
    @JsonProperty("images")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ImageSource> images = new ArrayList<ImageSource>();
    @JsonProperty("secrets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SecretBuildSource> secrets = new ArrayList<SecretBuildSource>();
    @JsonProperty("sourceSecret")
    private io.fabric8.kubernetes.api.model.LocalObjectReference sourceSecret;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BuildSource() {
    }

    public BuildSource(BinaryBuildSource binary, List<ConfigMapBuildSource> configMaps, String contextDir, String dockerfile, GitBuildSource git, List<ImageSource> images, List<SecretBuildSource> secrets, io.fabric8.kubernetes.api.model.LocalObjectReference sourceSecret, String type) {
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

    @JsonProperty("binary")
    public BinaryBuildSource getBinary() {
        return binary;
    }

    @JsonProperty("binary")
    public void setBinary(BinaryBuildSource binary) {
        this.binary = binary;
    }

    @JsonProperty("configMaps")
    public List<ConfigMapBuildSource> getConfigMaps() {
        return configMaps;
    }

    @JsonProperty("configMaps")
    public void setConfigMaps(List<ConfigMapBuildSource> configMaps) {
        this.configMaps = configMaps;
    }

    @JsonProperty("contextDir")
    public String getContextDir() {
        return contextDir;
    }

    @JsonProperty("contextDir")
    public void setContextDir(String contextDir) {
        this.contextDir = contextDir;
    }

    @JsonProperty("dockerfile")
    public String getDockerfile() {
        return dockerfile;
    }

    @JsonProperty("dockerfile")
    public void setDockerfile(String dockerfile) {
        this.dockerfile = dockerfile;
    }

    @JsonProperty("git")
    public GitBuildSource getGit() {
        return git;
    }

    @JsonProperty("git")
    public void setGit(GitBuildSource git) {
        this.git = git;
    }

    @JsonProperty("images")
    public List<ImageSource> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<ImageSource> images) {
        this.images = images;
    }

    @JsonProperty("secrets")
    public List<SecretBuildSource> getSecrets() {
        return secrets;
    }

    @JsonProperty("secrets")
    public void setSecrets(List<SecretBuildSource> secrets) {
        this.secrets = secrets;
    }

    @JsonProperty("sourceSecret")
    public io.fabric8.kubernetes.api.model.LocalObjectReference getSourceSecret() {
        return sourceSecret;
    }

    @JsonProperty("sourceSecret")
    public void setSourceSecret(io.fabric8.kubernetes.api.model.LocalObjectReference sourceSecret) {
        this.sourceSecret = sourceSecret;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
