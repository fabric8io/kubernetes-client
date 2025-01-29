
package io.fabric8.knative.sources.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.knative.duck.v1.CloudEventOverrides;
import io.fabric8.knative.duck.v1.Destination;
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
 * GitHubSourceSpec defines the desired state of GitHubSource
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessToken",
    "ceOverrides",
    "eventTypes",
    "githubAPIURL",
    "ownerAndRepository",
    "secretToken",
    "secure",
    "serviceAccountName",
    "sink"
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
public class GitHubSourceSpec implements Editable<GitHubSourceSpecBuilder>, KubernetesResource
{

    @JsonProperty("accessToken")
    private SecretValueFromSource accessToken;
    @JsonProperty("ceOverrides")
    private CloudEventOverrides ceOverrides;
    @JsonProperty("eventTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> eventTypes = new ArrayList<>();
    @JsonProperty("githubAPIURL")
    private String githubAPIURL;
    @JsonProperty("ownerAndRepository")
    private String ownerAndRepository;
    @JsonProperty("secretToken")
    private SecretValueFromSource secretToken;
    @JsonProperty("secure")
    private Boolean secure;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sink")
    private Destination sink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GitHubSourceSpec() {
    }

    public GitHubSourceSpec(SecretValueFromSource accessToken, CloudEventOverrides ceOverrides, List<String> eventTypes, String githubAPIURL, String ownerAndRepository, SecretValueFromSource secretToken, Boolean secure, String serviceAccountName, Destination sink) {
        super();
        this.accessToken = accessToken;
        this.ceOverrides = ceOverrides;
        this.eventTypes = eventTypes;
        this.githubAPIURL = githubAPIURL;
        this.ownerAndRepository = ownerAndRepository;
        this.secretToken = secretToken;
        this.secure = secure;
        this.serviceAccountName = serviceAccountName;
        this.sink = sink;
    }

    /**
     * GitHubSourceSpec defines the desired state of GitHubSource
     */
    @JsonProperty("accessToken")
    public SecretValueFromSource getAccessToken() {
        return accessToken;
    }

    /**
     * GitHubSourceSpec defines the desired state of GitHubSource
     */
    @JsonProperty("accessToken")
    public void setAccessToken(SecretValueFromSource accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * GitHubSourceSpec defines the desired state of GitHubSource
     */
    @JsonProperty("ceOverrides")
    public CloudEventOverrides getCeOverrides() {
        return ceOverrides;
    }

    /**
     * GitHubSourceSpec defines the desired state of GitHubSource
     */
    @JsonProperty("ceOverrides")
    public void setCeOverrides(CloudEventOverrides ceOverrides) {
        this.ceOverrides = ceOverrides;
    }

    /**
     * EventType is the type of event to receive from GitHub. These correspond to the "Webhook event name" values listed at https://developer.github.com/v3/activity/events/types/ - ie "pull_request"
     */
    @JsonProperty("eventTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEventTypes() {
        return eventTypes;
    }

    /**
     * EventType is the type of event to receive from GitHub. These correspond to the "Webhook event name" values listed at https://developer.github.com/v3/activity/events/types/ - ie "pull_request"
     */
    @JsonProperty("eventTypes")
    public void setEventTypes(List<String> eventTypes) {
        this.eventTypes = eventTypes;
    }

    /**
     * API URL if using github enterprise (default https://api.github.com)
     */
    @JsonProperty("githubAPIURL")
    public String getGithubAPIURL() {
        return githubAPIURL;
    }

    /**
     * API URL if using github enterprise (default https://api.github.com)
     */
    @JsonProperty("githubAPIURL")
    public void setGithubAPIURL(String githubAPIURL) {
        this.githubAPIURL = githubAPIURL;
    }

    /**
     * OwnerAndRepository is the GitHub owner/org and repository to receive events from. The repository may be left off to receive events from an entire organization. Examples:<br><p>  myuser/project<br><p>  myorganization
     */
    @JsonProperty("ownerAndRepository")
    public String getOwnerAndRepository() {
        return ownerAndRepository;
    }

    /**
     * OwnerAndRepository is the GitHub owner/org and repository to receive events from. The repository may be left off to receive events from an entire organization. Examples:<br><p>  myuser/project<br><p>  myorganization
     */
    @JsonProperty("ownerAndRepository")
    public void setOwnerAndRepository(String ownerAndRepository) {
        this.ownerAndRepository = ownerAndRepository;
    }

    /**
     * GitHubSourceSpec defines the desired state of GitHubSource
     */
    @JsonProperty("secretToken")
    public SecretValueFromSource getSecretToken() {
        return secretToken;
    }

    /**
     * GitHubSourceSpec defines the desired state of GitHubSource
     */
    @JsonProperty("secretToken")
    public void setSecretToken(SecretValueFromSource secretToken) {
        this.secretToken = secretToken;
    }

    /**
     * Secure can be set to true to configure the webhook to use https, or false to use http.  Omitting it relies on the scheme of the Knative Service created (e.g. if auto-TLS is enabled it should do the right thing).
     */
    @JsonProperty("secure")
    public Boolean getSecure() {
        return secure;
    }

    /**
     * Secure can be set to true to configure the webhook to use https, or false to use http.  Omitting it relies on the scheme of the Knative Service created (e.g. if auto-TLS is enabled it should do the right thing).
     */
    @JsonProperty("secure")
    public void setSecure(Boolean secure) {
        this.secure = secure;
    }

    /**
     * ServiceAccountName holds the name of the Kubernetes service account as which the underlying K8s resources should be run. If unspecified this will default to the "default" service account for the namespace in which the GitHubSource exists.
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * ServiceAccountName holds the name of the Kubernetes service account as which the underlying K8s resources should be run. If unspecified this will default to the "default" service account for the namespace in which the GitHubSource exists.
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * GitHubSourceSpec defines the desired state of GitHubSource
     */
    @JsonProperty("sink")
    public Destination getSink() {
        return sink;
    }

    /**
     * GitHubSourceSpec defines the desired state of GitHubSource
     */
    @JsonProperty("sink")
    public void setSink(Destination sink) {
        this.sink = sink;
    }

    @JsonIgnore
    public GitHubSourceSpecBuilder edit() {
        return new GitHubSourceSpecBuilder(this);
    }

    @JsonIgnore
    public GitHubSourceSpecBuilder toBuilder() {
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
