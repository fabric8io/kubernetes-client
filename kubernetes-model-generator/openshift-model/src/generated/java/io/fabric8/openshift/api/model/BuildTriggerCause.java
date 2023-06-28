
package io.fabric8.openshift.api.model;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
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
    "bitbucketWebHook",
    "genericWebHook",
    "githubWebHook",
    "gitlabWebHook",
    "imageChangeBuild",
    "message"
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class BuildTriggerCause implements KubernetesResource
{

    @JsonProperty("bitbucketWebHook")
    private BitbucketWebHookCause bitbucketWebHook;
    @JsonProperty("genericWebHook")
    private GenericWebHookCause genericWebHook;
    @JsonProperty("githubWebHook")
    private GitHubWebHookCause githubWebHook;
    @JsonProperty("gitlabWebHook")
    private GitLabWebHookCause gitlabWebHook;
    @JsonProperty("imageChangeBuild")
    private ImageChangeCause imageChangeBuild;
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BuildTriggerCause() {
    }

    public BuildTriggerCause(BitbucketWebHookCause bitbucketWebHook, GenericWebHookCause genericWebHook, GitHubWebHookCause githubWebHook, GitLabWebHookCause gitlabWebHook, ImageChangeCause imageChangeBuild, String message) {
        super();
        this.bitbucketWebHook = bitbucketWebHook;
        this.genericWebHook = genericWebHook;
        this.githubWebHook = githubWebHook;
        this.gitlabWebHook = gitlabWebHook;
        this.imageChangeBuild = imageChangeBuild;
        this.message = message;
    }

    @JsonProperty("bitbucketWebHook")
    public BitbucketWebHookCause getBitbucketWebHook() {
        return bitbucketWebHook;
    }

    @JsonProperty("bitbucketWebHook")
    public void setBitbucketWebHook(BitbucketWebHookCause bitbucketWebHook) {
        this.bitbucketWebHook = bitbucketWebHook;
    }

    @JsonProperty("genericWebHook")
    public GenericWebHookCause getGenericWebHook() {
        return genericWebHook;
    }

    @JsonProperty("genericWebHook")
    public void setGenericWebHook(GenericWebHookCause genericWebHook) {
        this.genericWebHook = genericWebHook;
    }

    @JsonProperty("githubWebHook")
    public GitHubWebHookCause getGithubWebHook() {
        return githubWebHook;
    }

    @JsonProperty("githubWebHook")
    public void setGithubWebHook(GitHubWebHookCause githubWebHook) {
        this.githubWebHook = githubWebHook;
    }

    @JsonProperty("gitlabWebHook")
    public GitLabWebHookCause getGitlabWebHook() {
        return gitlabWebHook;
    }

    @JsonProperty("gitlabWebHook")
    public void setGitlabWebHook(GitLabWebHookCause gitlabWebHook) {
        this.gitlabWebHook = gitlabWebHook;
    }

    @JsonProperty("imageChangeBuild")
    public ImageChangeCause getImageChangeBuild() {
        return imageChangeBuild;
    }

    @JsonProperty("imageChangeBuild")
    public void setImageChangeBuild(ImageChangeCause imageChangeBuild) {
        this.imageChangeBuild = imageChangeBuild;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
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
