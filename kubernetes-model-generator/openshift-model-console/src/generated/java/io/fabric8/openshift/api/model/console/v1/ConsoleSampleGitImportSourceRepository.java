
package io.fabric8.openshift.api.model.console.v1;

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
 * ConsoleSampleGitImportSourceRepository let the user import code from a public git repository.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "contextDir",
    "revision",
    "url"
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ConsoleSampleGitImportSourceRepository implements Editable<ConsoleSampleGitImportSourceRepositoryBuilder>, KubernetesResource
{

    @JsonProperty("contextDir")
    private String contextDir;
    @JsonProperty("revision")
    private String revision;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleSampleGitImportSourceRepository() {
    }

    public ConsoleSampleGitImportSourceRepository(String contextDir, String revision, String url) {
        super();
        this.contextDir = contextDir;
        this.revision = revision;
        this.url = url;
    }

    /**
     * contextDir is used to specify a directory within the repository to build the component. Must start with `/` and have a maximum length of 256 characters. When omitted, the default value is to build from the root of the repository.
     */
    @JsonProperty("contextDir")
    public String getContextDir() {
        return contextDir;
    }

    /**
     * contextDir is used to specify a directory within the repository to build the component. Must start with `/` and have a maximum length of 256 characters. When omitted, the default value is to build from the root of the repository.
     */
    @JsonProperty("contextDir")
    public void setContextDir(String contextDir) {
        this.contextDir = contextDir;
    }

    /**
     * revision is the git revision at which to clone the git repository Can be used to clone a specific branch, tag or commit SHA. Must be at most 256 characters in length. When omitted the repository's default branch is used.
     */
    @JsonProperty("revision")
    public String getRevision() {
        return revision;
    }

    /**
     * revision is the git revision at which to clone the git repository Can be used to clone a specific branch, tag or commit SHA. Must be at most 256 characters in length. When omitted the repository's default branch is used.
     */
    @JsonProperty("revision")
    public void setRevision(String revision) {
        this.revision = revision;
    }

    /**
     * url of the Git repository that contains a HTTP service. The HTTP service must be exposed on the default port (8080) unless otherwise configured with the port field.<br><p> <br><p> Only public repositories on GitHub, GitLab and Bitbucket are currently supported:<br><p> <br><p>   - https://github.com/&lt;org&gt;/&lt;repository&gt;<br><p>   - https://gitlab.com/&lt;org&gt;/&lt;repository&gt;<br><p>   - https://bitbucket.org/&lt;org&gt;/&lt;repository&gt;<br><p> <br><p> The url must have a maximum length of 256 characters.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * url of the Git repository that contains a HTTP service. The HTTP service must be exposed on the default port (8080) unless otherwise configured with the port field.<br><p> <br><p> Only public repositories on GitHub, GitLab and Bitbucket are currently supported:<br><p> <br><p>   - https://github.com/&lt;org&gt;/&lt;repository&gt;<br><p>   - https://gitlab.com/&lt;org&gt;/&lt;repository&gt;<br><p>   - https://bitbucket.org/&lt;org&gt;/&lt;repository&gt;<br><p> <br><p> The url must have a maximum length of 256 characters.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public ConsoleSampleGitImportSourceRepositoryBuilder edit() {
        return new ConsoleSampleGitImportSourceRepositoryBuilder(this);
    }

    @JsonIgnore
    public ConsoleSampleGitImportSourceRepositoryBuilder toBuilder() {
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
