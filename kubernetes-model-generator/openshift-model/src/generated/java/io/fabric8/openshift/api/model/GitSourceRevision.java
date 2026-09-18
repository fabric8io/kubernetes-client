
package io.fabric8.openshift.api.model;

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
 * GitSourceRevision is the commit information from a git source for a build
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "author",
    "commit",
    "committer",
    "message"
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
public class GitSourceRevision implements Editable<GitSourceRevisionBuilder>, KubernetesResource
{

    @JsonProperty("author")
    private SourceControlUser author;
    @JsonProperty("commit")
    private String commit;
    @JsonProperty("committer")
    private SourceControlUser committer;
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GitSourceRevision() {
    }

    public GitSourceRevision(SourceControlUser author, String commit, SourceControlUser committer, String message) {
        super();
        this.author = author;
        this.commit = commit;
        this.committer = committer;
        this.message = message;
    }

    /**
     * GitSourceRevision is the commit information from a git source for a build
     */
    @JsonProperty("author")
    public SourceControlUser getAuthor() {
        return author;
    }

    /**
     * GitSourceRevision is the commit information from a git source for a build
     */
    @JsonProperty("author")
    public void setAuthor(SourceControlUser author) {
        this.author = author;
    }

    /**
     * commit is the commit hash identifying a specific commit
     */
    @JsonProperty("commit")
    public String getCommit() {
        return commit;
    }

    /**
     * commit is the commit hash identifying a specific commit
     */
    @JsonProperty("commit")
    public void setCommit(String commit) {
        this.commit = commit;
    }

    /**
     * GitSourceRevision is the commit information from a git source for a build
     */
    @JsonProperty("committer")
    public SourceControlUser getCommitter() {
        return committer;
    }

    /**
     * GitSourceRevision is the commit information from a git source for a build
     */
    @JsonProperty("committer")
    public void setCommitter(SourceControlUser committer) {
        this.committer = committer;
    }

    /**
     * message is the description of a specific commit
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message is the description of a specific commit
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    public GitSourceRevisionBuilder edit() {
        return new GitSourceRevisionBuilder(this);
    }

    @JsonIgnore
    public GitSourceRevisionBuilder toBuilder() {
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
        if (!(o instanceof GitSourceRevision)) {
            return false;
        }
        GitSourceRevision other = (GitSourceRevision) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$author = this.getAuthor();
        Object other$author = other.getAuthor();
        if (this$author == null ? other$author != null : !this$author.equals(other$author)) {
            return false;
        }
        Object this$commit = this.getCommit();
        Object other$commit = other.getCommit();
        if (this$commit == null ? other$commit != null : !this$commit.equals(other$commit)) {
            return false;
        }
        Object this$committer = this.getCommitter();
        Object other$committer = other.getCommitter();
        if (this$committer == null ? other$committer != null : !this$committer.equals(other$committer)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
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
        return other instanceof GitSourceRevision;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $author = this.getAuthor();
        result = result * prime + ($author == null ? 43 : $author.hashCode());
        Object $commit = this.getCommit();
        result = result * prime + ($commit == null ? 43 : $commit.hashCode());
        Object $committer = this.getCommitter();
        result = result * prime + ($committer == null ? 43 : $committer.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GitSourceRevision(" + "author=" + this.getAuthor() + ", commit=" + this.getCommit() + ", committer=" + this.getCommitter() + ", message=" + this.getMessage() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
