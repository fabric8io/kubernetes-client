
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
 * BuildTriggerPolicy describes a policy for a single trigger that results in a new Build.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bitbucket",
    "generic",
    "github",
    "gitlab",
    "imageChange",
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BuildTriggerPolicy implements Editable<BuildTriggerPolicyBuilder>, KubernetesResource
{

    @JsonProperty("bitbucket")
    private WebHookTrigger bitbucket;
    @JsonProperty("generic")
    private WebHookTrigger generic;
    @JsonProperty("github")
    private WebHookTrigger github;
    @JsonProperty("gitlab")
    private WebHookTrigger gitlab;
    @JsonProperty("imageChange")
    private ImageChangeTrigger imageChange;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildTriggerPolicy() {
    }

    public BuildTriggerPolicy(WebHookTrigger bitbucket, WebHookTrigger generic, WebHookTrigger github, WebHookTrigger gitlab, ImageChangeTrigger imageChange, String type) {
        super();
        this.bitbucket = bitbucket;
        this.generic = generic;
        this.github = github;
        this.gitlab = gitlab;
        this.imageChange = imageChange;
        this.type = type;
    }

    /**
     * BuildTriggerPolicy describes a policy for a single trigger that results in a new Build.
     */
    @JsonProperty("bitbucket")
    public WebHookTrigger getBitbucket() {
        return bitbucket;
    }

    /**
     * BuildTriggerPolicy describes a policy for a single trigger that results in a new Build.
     */
    @JsonProperty("bitbucket")
    public void setBitbucket(WebHookTrigger bitbucket) {
        this.bitbucket = bitbucket;
    }

    /**
     * BuildTriggerPolicy describes a policy for a single trigger that results in a new Build.
     */
    @JsonProperty("generic")
    public WebHookTrigger getGeneric() {
        return generic;
    }

    /**
     * BuildTriggerPolicy describes a policy for a single trigger that results in a new Build.
     */
    @JsonProperty("generic")
    public void setGeneric(WebHookTrigger generic) {
        this.generic = generic;
    }

    /**
     * BuildTriggerPolicy describes a policy for a single trigger that results in a new Build.
     */
    @JsonProperty("github")
    public WebHookTrigger getGithub() {
        return github;
    }

    /**
     * BuildTriggerPolicy describes a policy for a single trigger that results in a new Build.
     */
    @JsonProperty("github")
    public void setGithub(WebHookTrigger github) {
        this.github = github;
    }

    /**
     * BuildTriggerPolicy describes a policy for a single trigger that results in a new Build.
     */
    @JsonProperty("gitlab")
    public WebHookTrigger getGitlab() {
        return gitlab;
    }

    /**
     * BuildTriggerPolicy describes a policy for a single trigger that results in a new Build.
     */
    @JsonProperty("gitlab")
    public void setGitlab(WebHookTrigger gitlab) {
        this.gitlab = gitlab;
    }

    /**
     * BuildTriggerPolicy describes a policy for a single trigger that results in a new Build.
     */
    @JsonProperty("imageChange")
    public ImageChangeTrigger getImageChange() {
        return imageChange;
    }

    /**
     * BuildTriggerPolicy describes a policy for a single trigger that results in a new Build.
     */
    @JsonProperty("imageChange")
    public void setImageChange(ImageChangeTrigger imageChange) {
        this.imageChange = imageChange;
    }

    /**
     * type is the type of build trigger. Valid values:<br><p> <br><p> - GitHub GitHubWebHookBuildTriggerType represents a trigger that launches builds on GitHub webhook invocations<br><p> <br><p> - Generic GenericWebHookBuildTriggerType represents a trigger that launches builds on generic webhook invocations<br><p> <br><p> - GitLab GitLabWebHookBuildTriggerType represents a trigger that launches builds on GitLab webhook invocations<br><p> <br><p> - Bitbucket BitbucketWebHookBuildTriggerType represents a trigger that launches builds on Bitbucket webhook invocations<br><p> <br><p> - ImageChange ImageChangeBuildTriggerType represents a trigger that launches builds on availability of a new version of an image<br><p> <br><p> - ConfigChange ConfigChangeBuildTriggerType will trigger a build on an initial build config creation WARNING: In the future the behavior will change to trigger a build on any config change
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the type of build trigger. Valid values:<br><p> <br><p> - GitHub GitHubWebHookBuildTriggerType represents a trigger that launches builds on GitHub webhook invocations<br><p> <br><p> - Generic GenericWebHookBuildTriggerType represents a trigger that launches builds on generic webhook invocations<br><p> <br><p> - GitLab GitLabWebHookBuildTriggerType represents a trigger that launches builds on GitLab webhook invocations<br><p> <br><p> - Bitbucket BitbucketWebHookBuildTriggerType represents a trigger that launches builds on Bitbucket webhook invocations<br><p> <br><p> - ImageChange ImageChangeBuildTriggerType represents a trigger that launches builds on availability of a new version of an image<br><p> <br><p> - ConfigChange ConfigChangeBuildTriggerType will trigger a build on an initial build config creation WARNING: In the future the behavior will change to trigger a build on any config change
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public BuildTriggerPolicyBuilder edit() {
        return new BuildTriggerPolicyBuilder(this);
    }

    @JsonIgnore
    public BuildTriggerPolicyBuilder toBuilder() {
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
