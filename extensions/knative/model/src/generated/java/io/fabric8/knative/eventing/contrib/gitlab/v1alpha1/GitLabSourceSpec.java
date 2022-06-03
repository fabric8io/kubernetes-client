
package io.fabric8.knative.eventing.contrib.gitlab.v1alpha1;

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
    "eventTypes",
    "projectUrl",
    "secretToken",
    "serviceAccountName",
    "sink",
    "sslverify"
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
public class GitLabSourceSpec implements KubernetesResource
{

    @JsonProperty("accessToken")
    private SecretValueFromSource accessToken;
    @JsonProperty("eventTypes")
    private List<String> eventTypes = new ArrayList<String>();
    @JsonProperty("projectUrl")
    private String projectUrl;
    @JsonProperty("secretToken")
    private SecretValueFromSource secretToken;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("sink")
    private Destination sink;
    @JsonProperty("sslverify")
    private Boolean sslverify;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GitLabSourceSpec() {
    }

    /**
     * 
     * @param projectUrl
     * @param sslverify
     * @param serviceAccountName
     * @param sink
     * @param secretToken
     * @param accessToken
     * @param eventTypes
     */
    public GitLabSourceSpec(SecretValueFromSource accessToken, List<String> eventTypes, String projectUrl, SecretValueFromSource secretToken, String serviceAccountName, Destination sink, Boolean sslverify) {
        super();
        this.accessToken = accessToken;
        this.eventTypes = eventTypes;
        this.projectUrl = projectUrl;
        this.secretToken = secretToken;
        this.serviceAccountName = serviceAccountName;
        this.sink = sink;
        this.sslverify = sslverify;
    }

    @JsonProperty("accessToken")
    public SecretValueFromSource getAccessToken() {
        return accessToken;
    }

    @JsonProperty("accessToken")
    public void setAccessToken(SecretValueFromSource accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty("eventTypes")
    public List<String> getEventTypes() {
        return eventTypes;
    }

    @JsonProperty("eventTypes")
    public void setEventTypes(List<String> eventTypes) {
        this.eventTypes = eventTypes;
    }

    @JsonProperty("projectUrl")
    public String getProjectUrl() {
        return projectUrl;
    }

    @JsonProperty("projectUrl")
    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    @JsonProperty("secretToken")
    public SecretValueFromSource getSecretToken() {
        return secretToken;
    }

    @JsonProperty("secretToken")
    public void setSecretToken(SecretValueFromSource secretToken) {
        this.secretToken = secretToken;
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

    @JsonProperty("sslverify")
    public Boolean getSslverify() {
        return sslverify;
    }

    @JsonProperty("sslverify")
    public void setSslverify(Boolean sslverify) {
        this.sslverify = sslverify;
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
