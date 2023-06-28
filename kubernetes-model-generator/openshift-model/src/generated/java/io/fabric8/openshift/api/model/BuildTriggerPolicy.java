
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
    "bitbucket",
    "generic",
    "github",
    "gitlab",
    "imageChange",
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class BuildTriggerPolicy implements KubernetesResource
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
     * 
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

    @JsonProperty("bitbucket")
    public WebHookTrigger getBitbucket() {
        return bitbucket;
    }

    @JsonProperty("bitbucket")
    public void setBitbucket(WebHookTrigger bitbucket) {
        this.bitbucket = bitbucket;
    }

    @JsonProperty("generic")
    public WebHookTrigger getGeneric() {
        return generic;
    }

    @JsonProperty("generic")
    public void setGeneric(WebHookTrigger generic) {
        this.generic = generic;
    }

    @JsonProperty("github")
    public WebHookTrigger getGithub() {
        return github;
    }

    @JsonProperty("github")
    public void setGithub(WebHookTrigger github) {
        this.github = github;
    }

    @JsonProperty("gitlab")
    public WebHookTrigger getGitlab() {
        return gitlab;
    }

    @JsonProperty("gitlab")
    public void setGitlab(WebHookTrigger gitlab) {
        this.gitlab = gitlab;
    }

    @JsonProperty("imageChange")
    public ImageChangeTrigger getImageChange() {
        return imageChange;
    }

    @JsonProperty("imageChange")
    public void setImageChange(ImageChangeTrigger imageChange) {
        this.imageChange = imageChange;
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
