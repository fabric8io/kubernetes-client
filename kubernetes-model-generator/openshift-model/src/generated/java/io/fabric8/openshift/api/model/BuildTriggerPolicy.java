
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
        if (!(o instanceof BuildTriggerPolicy)) {
            return false;
        }
        BuildTriggerPolicy other = (BuildTriggerPolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bitbucket = this.getBitbucket();
        Object other$bitbucket = other.getBitbucket();
        if (this$bitbucket == null ? other$bitbucket != null : !this$bitbucket.equals(other$bitbucket)) {
            return false;
        }
        Object this$generic = this.getGeneric();
        Object other$generic = other.getGeneric();
        if (this$generic == null ? other$generic != null : !this$generic.equals(other$generic)) {
            return false;
        }
        Object this$github = this.getGithub();
        Object other$github = other.getGithub();
        if (this$github == null ? other$github != null : !this$github.equals(other$github)) {
            return false;
        }
        Object this$gitlab = this.getGitlab();
        Object other$gitlab = other.getGitlab();
        if (this$gitlab == null ? other$gitlab != null : !this$gitlab.equals(other$gitlab)) {
            return false;
        }
        Object this$imageChange = this.getImageChange();
        Object other$imageChange = other.getImageChange();
        if (this$imageChange == null ? other$imageChange != null : !this$imageChange.equals(other$imageChange)) {
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
        return other instanceof BuildTriggerPolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bitbucket = this.getBitbucket();
        result = result * prime + ($bitbucket == null ? 43 : $bitbucket.hashCode());
        Object $generic = this.getGeneric();
        result = result * prime + ($generic == null ? 43 : $generic.hashCode());
        Object $github = this.getGithub();
        result = result * prime + ($github == null ? 43 : $github.hashCode());
        Object $gitlab = this.getGitlab();
        result = result * prime + ($gitlab == null ? 43 : $gitlab.hashCode());
        Object $imageChange = this.getImageChange();
        result = result * prime + ($imageChange == null ? 43 : $imageChange.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BuildTriggerPolicy(" + "bitbucket=" + this.getBitbucket() + ", generic=" + this.getGeneric() + ", github=" + this.getGithub() + ", gitlab=" + this.getGitlab() + ", imageChange=" + this.getImageChange() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
