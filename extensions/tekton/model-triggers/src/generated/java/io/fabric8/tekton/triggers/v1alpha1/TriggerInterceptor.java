
package io.fabric8.tekton.triggers.v1alpha1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    "cel",
    "github",
    "gitlab",
    "name",
    "params",
    "ref",
    "webhook"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class TriggerInterceptor implements KubernetesResource
{

    @JsonProperty("bitbucket")
    private BitbucketInterceptor bitbucket;
    @JsonProperty("cel")
    private CELInterceptor cel;
    @JsonProperty("github")
    private GitHubInterceptor github;
    @JsonProperty("gitlab")
    private GitLabInterceptor gitlab;
    @JsonProperty("name")
    private String name;
    @JsonProperty("params")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<InterceptorParams> params = new ArrayList<InterceptorParams>();
    @JsonProperty("ref")
    private InterceptorRef ref;
    @JsonProperty("webhook")
    private WebhookInterceptor webhook;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public TriggerInterceptor() {
    }

    /**
     * 
     * @param github
     * @param ref
     * @param webhook
     * @param name
     * @param gitlab
     * @param cel
     * @param bitbucket
     * @param params
     */
    public TriggerInterceptor(BitbucketInterceptor bitbucket, CELInterceptor cel, GitHubInterceptor github, GitLabInterceptor gitlab, String name, List<InterceptorParams> params, InterceptorRef ref, WebhookInterceptor webhook) {
        super();
        this.bitbucket = bitbucket;
        this.cel = cel;
        this.github = github;
        this.gitlab = gitlab;
        this.name = name;
        this.params = params;
        this.ref = ref;
        this.webhook = webhook;
    }

    @JsonProperty("bitbucket")
    public BitbucketInterceptor getBitbucket() {
        return bitbucket;
    }

    @JsonProperty("bitbucket")
    public void setBitbucket(BitbucketInterceptor bitbucket) {
        this.bitbucket = bitbucket;
    }

    @JsonProperty("cel")
    public CELInterceptor getCel() {
        return cel;
    }

    @JsonProperty("cel")
    public void setCel(CELInterceptor cel) {
        this.cel = cel;
    }

    @JsonProperty("github")
    public GitHubInterceptor getGithub() {
        return github;
    }

    @JsonProperty("github")
    public void setGithub(GitHubInterceptor github) {
        this.github = github;
    }

    @JsonProperty("gitlab")
    public GitLabInterceptor getGitlab() {
        return gitlab;
    }

    @JsonProperty("gitlab")
    public void setGitlab(GitLabInterceptor gitlab) {
        this.gitlab = gitlab;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("params")
    public List<InterceptorParams> getParams() {
        return params;
    }

    @JsonProperty("params")
    public void setParams(List<InterceptorParams> params) {
        this.params = params;
    }

    @JsonProperty("ref")
    public InterceptorRef getRef() {
        return ref;
    }

    @JsonProperty("ref")
    public void setRef(InterceptorRef ref) {
        this.ref = ref;
    }

    @JsonProperty("webhook")
    public WebhookInterceptor getWebhook() {
        return webhook;
    }

    @JsonProperty("webhook")
    public void setWebhook(WebhookInterceptor webhook) {
        this.webhook = webhook;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
