
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Represents a volume that is populated with the contents of a git repository. Git repo volumes do not support ownership management. Git repo volumes support SELinux relabeling.<br><p> <br><p> DEPRECATED: GitRepo is deprecated. To provision a container with a git repo, mount an EmptyDir into an InitContainer that clones the repo using git, then mount the EmptyDir into the Pod's container.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "directory",
    "repository",
    "revision"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GitRepoVolumeSource implements Editable<GitRepoVolumeSourceBuilder>, KubernetesResource
{

    @JsonProperty("directory")
    private String directory;
    @JsonProperty("repository")
    private String repository;
    @JsonProperty("revision")
    private String revision;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GitRepoVolumeSource() {
    }

    public GitRepoVolumeSource(String directory, String repository, String revision) {
        super();
        this.directory = directory;
        this.repository = repository;
        this.revision = revision;
    }

    /**
     * directory is the target directory name. Must not contain or start with '..'.  If '.' is supplied, the volume directory will be the git repository.  Otherwise, if specified, the volume will contain the git repository in the subdirectory with the given name.
     */
    @JsonProperty("directory")
    public String getDirectory() {
        return directory;
    }

    /**
     * directory is the target directory name. Must not contain or start with '..'.  If '.' is supplied, the volume directory will be the git repository.  Otherwise, if specified, the volume will contain the git repository in the subdirectory with the given name.
     */
    @JsonProperty("directory")
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    /**
     * repository is the URL
     */
    @JsonProperty("repository")
    public String getRepository() {
        return repository;
    }

    /**
     * repository is the URL
     */
    @JsonProperty("repository")
    public void setRepository(String repository) {
        this.repository = repository;
    }

    /**
     * revision is the commit hash for the specified revision.
     */
    @JsonProperty("revision")
    public String getRevision() {
        return revision;
    }

    /**
     * revision is the commit hash for the specified revision.
     */
    @JsonProperty("revision")
    public void setRevision(String revision) {
        this.revision = revision;
    }

    @JsonIgnore
    public GitRepoVolumeSourceBuilder edit() {
        return new GitRepoVolumeSourceBuilder(this);
    }

    @JsonIgnore
    public GitRepoVolumeSourceBuilder toBuilder() {
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
