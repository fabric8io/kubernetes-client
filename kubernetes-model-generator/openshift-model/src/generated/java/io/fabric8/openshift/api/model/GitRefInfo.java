
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
 * GitRefInfo is a single ref
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "author",
    "commit",
    "committer",
    "httpProxy",
    "httpsProxy",
    "message",
    "noProxy",
    "ref",
    "uri"
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
public class GitRefInfo implements Editable<GitRefInfoBuilder>, KubernetesResource
{

    @JsonProperty("author")
    private SourceControlUser author;
    @JsonProperty("commit")
    private String commit;
    @JsonProperty("committer")
    private SourceControlUser committer;
    @JsonProperty("httpProxy")
    private String httpProxy;
    @JsonProperty("httpsProxy")
    private String httpsProxy;
    @JsonProperty("message")
    private String message;
    @JsonProperty("noProxy")
    private String noProxy;
    @JsonProperty("ref")
    private String ref;
    @JsonProperty("uri")
    private String uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GitRefInfo() {
    }

    public GitRefInfo(SourceControlUser author, String commit, SourceControlUser committer, String httpProxy, String httpsProxy, String message, String noProxy, String ref, String uri) {
        super();
        this.author = author;
        this.commit = commit;
        this.committer = committer;
        this.httpProxy = httpProxy;
        this.httpsProxy = httpsProxy;
        this.message = message;
        this.noProxy = noProxy;
        this.ref = ref;
        this.uri = uri;
    }

    /**
     * GitRefInfo is a single ref
     */
    @JsonProperty("author")
    public SourceControlUser getAuthor() {
        return author;
    }

    /**
     * GitRefInfo is a single ref
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
     * GitRefInfo is a single ref
     */
    @JsonProperty("committer")
    public SourceControlUser getCommitter() {
        return committer;
    }

    /**
     * GitRefInfo is a single ref
     */
    @JsonProperty("committer")
    public void setCommitter(SourceControlUser committer) {
        this.committer = committer;
    }

    /**
     * httpProxy is a proxy used to reach the git repository over http
     */
    @JsonProperty("httpProxy")
    public String getHttpProxy() {
        return httpProxy;
    }

    /**
     * httpProxy is a proxy used to reach the git repository over http
     */
    @JsonProperty("httpProxy")
    public void setHttpProxy(String httpProxy) {
        this.httpProxy = httpProxy;
    }

    /**
     * httpsProxy is a proxy used to reach the git repository over https
     */
    @JsonProperty("httpsProxy")
    public String getHttpsProxy() {
        return httpsProxy;
    }

    /**
     * httpsProxy is a proxy used to reach the git repository over https
     */
    @JsonProperty("httpsProxy")
    public void setHttpsProxy(String httpsProxy) {
        this.httpsProxy = httpsProxy;
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

    /**
     * noProxy is the list of domains for which the proxy should not be used
     */
    @JsonProperty("noProxy")
    public String getNoProxy() {
        return noProxy;
    }

    /**
     * noProxy is the list of domains for which the proxy should not be used
     */
    @JsonProperty("noProxy")
    public void setNoProxy(String noProxy) {
        this.noProxy = noProxy;
    }

    /**
     * ref is the branch/tag/ref to build.
     */
    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    /**
     * ref is the branch/tag/ref to build.
     */
    @JsonProperty("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * uri points to the source that will be built. The structure of the source will depend on the type of build to run
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * uri points to the source that will be built. The structure of the source will depend on the type of build to run
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonIgnore
    public GitRefInfoBuilder edit() {
        return new GitRefInfoBuilder(this);
    }

    @JsonIgnore
    public GitRefInfoBuilder toBuilder() {
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
        if (!(o instanceof GitRefInfo)) {
            return false;
        }
        GitRefInfo other = (GitRefInfo) o;
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
        Object this$httpProxy = this.getHttpProxy();
        Object other$httpProxy = other.getHttpProxy();
        if (this$httpProxy == null ? other$httpProxy != null : !this$httpProxy.equals(other$httpProxy)) {
            return false;
        }
        Object this$httpsProxy = this.getHttpsProxy();
        Object other$httpsProxy = other.getHttpsProxy();
        if (this$httpsProxy == null ? other$httpsProxy != null : !this$httpsProxy.equals(other$httpsProxy)) {
            return false;
        }
        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        Object this$noProxy = this.getNoProxy();
        Object other$noProxy = other.getNoProxy();
        if (this$noProxy == null ? other$noProxy != null : !this$noProxy.equals(other$noProxy)) {
            return false;
        }
        Object this$ref = this.getRef();
        Object other$ref = other.getRef();
        if (this$ref == null ? other$ref != null : !this$ref.equals(other$ref)) {
            return false;
        }
        Object this$uri = this.getUri();
        Object other$uri = other.getUri();
        if (this$uri == null ? other$uri != null : !this$uri.equals(other$uri)) {
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
        return other instanceof GitRefInfo;
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
        Object $httpProxy = this.getHttpProxy();
        result = result * prime + ($httpProxy == null ? 43 : $httpProxy.hashCode());
        Object $httpsProxy = this.getHttpsProxy();
        result = result * prime + ($httpsProxy == null ? 43 : $httpsProxy.hashCode());
        Object $message = this.getMessage();
        result = result * prime + ($message == null ? 43 : $message.hashCode());
        Object $noProxy = this.getNoProxy();
        result = result * prime + ($noProxy == null ? 43 : $noProxy.hashCode());
        Object $ref = this.getRef();
        result = result * prime + ($ref == null ? 43 : $ref.hashCode());
        Object $uri = this.getUri();
        result = result * prime + ($uri == null ? 43 : $uri.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GitRefInfo(" + "author=" + this.getAuthor() + ", commit=" + this.getCommit() + ", committer=" + this.getCommitter() + ", httpProxy=" + this.getHttpProxy() + ", httpsProxy=" + this.getHttpsProxy() + ", message=" + this.getMessage() + ", noProxy=" + this.getNoProxy() + ", ref=" + this.getRef() + ", uri=" + this.getUri() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
