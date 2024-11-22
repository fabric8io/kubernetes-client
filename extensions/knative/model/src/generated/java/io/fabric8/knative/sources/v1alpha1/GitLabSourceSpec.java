
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessToken",
    "ceOverrides",
    "eventTypes",
    "projectUrl",
    "secretToken",
    "serviceAccountName",
    "sink",
    "sslverify"
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
public class GitLabSourceSpec implements Editable<GitLabSourceSpecBuilder> , KubernetesResource
{

    @JsonProperty("accessToken")
    private SecretValueFromSource accessToken;
    @JsonProperty("ceOverrides")
    private CloudEventOverrides ceOverrides;
    @JsonProperty("eventTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> eventTypes = new ArrayList<>();
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
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GitLabSourceSpec() {
    }

    public GitLabSourceSpec(SecretValueFromSource accessToken, CloudEventOverrides ceOverrides, List<String> eventTypes, String projectUrl, SecretValueFromSource secretToken, String serviceAccountName, Destination sink, Boolean sslverify) {
        super();
        this.accessToken = accessToken;
        this.ceOverrides = ceOverrides;
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

    @JsonProperty("ceOverrides")
    public CloudEventOverrides getCeOverrides() {
        return ceOverrides;
    }

    @JsonProperty("ceOverrides")
    public void setCeOverrides(CloudEventOverrides ceOverrides) {
        this.ceOverrides = ceOverrides;
    }

    @JsonProperty("eventTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonIgnore
    public GitLabSourceSpecBuilder edit() {
        return new GitLabSourceSpecBuilder(this);
    }

    @JsonIgnore
    public GitLabSourceSpecBuilder toBuilder() {
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
