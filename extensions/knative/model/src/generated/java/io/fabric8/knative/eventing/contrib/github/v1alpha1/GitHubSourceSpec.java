
package io.fabric8.knative.eventing.contrib.github.v1alpha1;

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
import io.fabric8.knative.internal.pkg.apis.duck.v1.CloudEventOverrides;
import io.fabric8.knative.internal.pkg.apis.duck.v1.Destination;
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
public class GitHubSourceSpec implements KubernetesResource
{

    @JsonProperty("accessToken")
    private SecretValueFromSource accessToken;
    @JsonProperty("ceOverrides")
    private CloudEventOverrides ceOverrides;
    @JsonProperty("eventTypes")
    private List<String> eventTypes = new ArrayList<String>();
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
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GitHubSourceSpec() {
    }

    /**
     * 
     * @param githubAPIURL
     * @param serviceAccountName
     * @param sink
     * @param secretToken
     * @param accessToken
     * @param ceOverrides
     * @param eventTypes
     * @param secure
     * @param ownerAndRepository
     */
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

    @JsonProperty("accessToken")
    public SecretValueFromSource getAccessToken() {
        return accessToken;
    }

    @JsonProperty("accessToken")
    public void setAccessToken(SecretValueFromSource accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty("ceOverrides")
    public CloudEventOverrides getCeOverrides() {
        return ceOverrides;
    }

    @JsonProperty("ceOverrides")
    public void setCeOverrides(CloudEventOverrides ceOverrides) {
        this.ceOverrides = ceOverrides;
    }

    @JsonProperty("eventTypes")
    public List<String> getEventTypes() {
        return eventTypes;
    }

    @JsonProperty("eventTypes")
    public void setEventTypes(List<String> eventTypes) {
        this.eventTypes = eventTypes;
    }

    @JsonProperty("githubAPIURL")
    public String getGithubAPIURL() {
        return githubAPIURL;
    }

    @JsonProperty("githubAPIURL")
    public void setGithubAPIURL(String githubAPIURL) {
        this.githubAPIURL = githubAPIURL;
    }

    @JsonProperty("ownerAndRepository")
    public String getOwnerAndRepository() {
        return ownerAndRepository;
    }

    @JsonProperty("ownerAndRepository")
    public void setOwnerAndRepository(String ownerAndRepository) {
        this.ownerAndRepository = ownerAndRepository;
    }

    @JsonProperty("secretToken")
    public SecretValueFromSource getSecretToken() {
        return secretToken;
    }

    @JsonProperty("secretToken")
    public void setSecretToken(SecretValueFromSource secretToken) {
        this.secretToken = secretToken;
    }

    @JsonProperty("secure")
    public Boolean getSecure() {
        return secure;
    }

    @JsonProperty("secure")
    public void setSecure(Boolean secure) {
        this.secure = secure;
    }

    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("sink")
    public Destination getSink() {
        return sink;
    }

    @JsonProperty("sink")
    public void setSink(Destination sink) {
        this.sink = sink;
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
