
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
 * BuildTriggerCause holds information about a triggered build. It is used for displaying build trigger data for each build and build configuration in oc describe. It is also used to describe which triggers led to the most recent update in the build configuration.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bitbucketWebHook",
    "genericWebHook",
    "githubWebHook",
    "gitlabWebHook",
    "imageChangeBuild",
    "message"
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
public class BuildTriggerCause implements Editable<BuildTriggerCauseBuilder>, KubernetesResource
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

    /**
     * BuildTriggerCause holds information about a triggered build. It is used for displaying build trigger data for each build and build configuration in oc describe. It is also used to describe which triggers led to the most recent update in the build configuration.
     */
    @JsonProperty("bitbucketWebHook")
    public BitbucketWebHookCause getBitbucketWebHook() {
        return bitbucketWebHook;
    }

    /**
     * BuildTriggerCause holds information about a triggered build. It is used for displaying build trigger data for each build and build configuration in oc describe. It is also used to describe which triggers led to the most recent update in the build configuration.
     */
    @JsonProperty("bitbucketWebHook")
    public void setBitbucketWebHook(BitbucketWebHookCause bitbucketWebHook) {
        this.bitbucketWebHook = bitbucketWebHook;
    }

    /**
     * BuildTriggerCause holds information about a triggered build. It is used for displaying build trigger data for each build and build configuration in oc describe. It is also used to describe which triggers led to the most recent update in the build configuration.
     */
    @JsonProperty("genericWebHook")
    public GenericWebHookCause getGenericWebHook() {
        return genericWebHook;
    }

    /**
     * BuildTriggerCause holds information about a triggered build. It is used for displaying build trigger data for each build and build configuration in oc describe. It is also used to describe which triggers led to the most recent update in the build configuration.
     */
    @JsonProperty("genericWebHook")
    public void setGenericWebHook(GenericWebHookCause genericWebHook) {
        this.genericWebHook = genericWebHook;
    }

    /**
     * BuildTriggerCause holds information about a triggered build. It is used for displaying build trigger data for each build and build configuration in oc describe. It is also used to describe which triggers led to the most recent update in the build configuration.
     */
    @JsonProperty("githubWebHook")
    public GitHubWebHookCause getGithubWebHook() {
        return githubWebHook;
    }

    /**
     * BuildTriggerCause holds information about a triggered build. It is used for displaying build trigger data for each build and build configuration in oc describe. It is also used to describe which triggers led to the most recent update in the build configuration.
     */
    @JsonProperty("githubWebHook")
    public void setGithubWebHook(GitHubWebHookCause githubWebHook) {
        this.githubWebHook = githubWebHook;
    }

    /**
     * BuildTriggerCause holds information about a triggered build. It is used for displaying build trigger data for each build and build configuration in oc describe. It is also used to describe which triggers led to the most recent update in the build configuration.
     */
    @JsonProperty("gitlabWebHook")
    public GitLabWebHookCause getGitlabWebHook() {
        return gitlabWebHook;
    }

    /**
     * BuildTriggerCause holds information about a triggered build. It is used for displaying build trigger data for each build and build configuration in oc describe. It is also used to describe which triggers led to the most recent update in the build configuration.
     */
    @JsonProperty("gitlabWebHook")
    public void setGitlabWebHook(GitLabWebHookCause gitlabWebHook) {
        this.gitlabWebHook = gitlabWebHook;
    }

    /**
     * BuildTriggerCause holds information about a triggered build. It is used for displaying build trigger data for each build and build configuration in oc describe. It is also used to describe which triggers led to the most recent update in the build configuration.
     */
    @JsonProperty("imageChangeBuild")
    public ImageChangeCause getImageChangeBuild() {
        return imageChangeBuild;
    }

    /**
     * BuildTriggerCause holds information about a triggered build. It is used for displaying build trigger data for each build and build configuration in oc describe. It is also used to describe which triggers led to the most recent update in the build configuration.
     */
    @JsonProperty("imageChangeBuild")
    public void setImageChangeBuild(ImageChangeCause imageChangeBuild) {
        this.imageChangeBuild = imageChangeBuild;
    }

    /**
     * message is used to store a human readable message for why the build was triggered. E.g.: "Manually triggered by user", "Configuration change",etc.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message is used to store a human readable message for why the build was triggered. E.g.: "Manually triggered by user", "Configuration change",etc.
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    public BuildTriggerCauseBuilder edit() {
        return new BuildTriggerCauseBuilder(this);
    }

    @JsonIgnore
    public BuildTriggerCauseBuilder toBuilder() {
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
