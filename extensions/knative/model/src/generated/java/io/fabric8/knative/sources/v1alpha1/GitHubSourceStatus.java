
package io.fabric8.knative.sources.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.knative.duck.v1.AuthStatus;
import io.fabric8.knative.duck.v1.CloudEventAttributes;
import io.fabric8.knative.pkg.apis.Condition;
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

/**
 * GitHubSourceStatus defines the observed state of GitHubSource
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotations",
    "auth",
    "ceAttributes",
    "conditions",
    "observedGeneration",
    "sinkAudience",
    "sinkCACerts",
    "sinkUri",
    "webhookIDKey"
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
public class GitHubSourceStatus implements Editable<GitHubSourceStatusBuilder>, KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("auth")
    private AuthStatus auth;
    @JsonProperty("ceAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CloudEventAttributes> ceAttributes = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("sinkAudience")
    private String sinkAudience;
    @JsonProperty("sinkCACerts")
    private String sinkCACerts;
    @JsonProperty("sinkUri")
    private String sinkUri;
    @JsonProperty("webhookIDKey")
    private String webhookIDKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GitHubSourceStatus() {
    }

    public GitHubSourceStatus(Map<String, String> annotations, AuthStatus auth, List<CloudEventAttributes> ceAttributes, List<Condition> conditions, Long observedGeneration, String sinkAudience, String sinkCACerts, String sinkUri, String webhookIDKey) {
        super();
        this.annotations = annotations;
        this.auth = auth;
        this.ceAttributes = ceAttributes;
        this.conditions = conditions;
        this.observedGeneration = observedGeneration;
        this.sinkAudience = sinkAudience;
        this.sinkCACerts = sinkCACerts;
        this.sinkUri = sinkUri;
        this.webhookIDKey = webhookIDKey;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations is additional Status fields for the Resource to save some additional State as well as convey more information to the user. This is roughly akin to Annotations on any k8s resource, just the reconciler conveying richer information outwards.
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * GitHubSourceStatus defines the observed state of GitHubSource
     */
    @JsonProperty("auth")
    public AuthStatus getAuth() {
        return auth;
    }

    /**
     * GitHubSourceStatus defines the observed state of GitHubSource
     */
    @JsonProperty("auth")
    public void setAuth(AuthStatus auth) {
        this.auth = auth;
    }

    /**
     * CloudEventAttributes are the specific attributes that the Source uses as part of its CloudEvents.
     */
    @JsonProperty("ceAttributes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CloudEventAttributes> getCeAttributes() {
        return ceAttributes;
    }

    /**
     * CloudEventAttributes are the specific attributes that the Source uses as part of its CloudEvents.
     */
    @JsonProperty("ceAttributes")
    public void setCeAttributes(List<CloudEventAttributes> ceAttributes) {
        this.ceAttributes = ceAttributes;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions the latest available observations of a resource's current state.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * ObservedGeneration is the 'Generation' of the Service that was last processed by the controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * SinkAudience is the OIDC audience of the sink.
     */
    @JsonProperty("sinkAudience")
    public String getSinkAudience() {
        return sinkAudience;
    }

    /**
     * SinkAudience is the OIDC audience of the sink.
     */
    @JsonProperty("sinkAudience")
    public void setSinkAudience(String sinkAudience) {
        this.sinkAudience = sinkAudience;
    }

    /**
     * SinkCACerts are Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468.
     */
    @JsonProperty("sinkCACerts")
    public String getSinkCACerts() {
        return sinkCACerts;
    }

    /**
     * SinkCACerts are Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468.
     */
    @JsonProperty("sinkCACerts")
    public void setSinkCACerts(String sinkCACerts) {
        this.sinkCACerts = sinkCACerts;
    }

    /**
     * GitHubSourceStatus defines the observed state of GitHubSource
     */
    @JsonProperty("sinkUri")
    public String getSinkUri() {
        return sinkUri;
    }

    /**
     * GitHubSourceStatus defines the observed state of GitHubSource
     */
    @JsonProperty("sinkUri")
    public void setSinkUri(String sinkUri) {
        this.sinkUri = sinkUri;
    }

    /**
     * WebhookIDKey is the ID of the webhook registered with GitHub
     */
    @JsonProperty("webhookIDKey")
    public String getWebhookIDKey() {
        return webhookIDKey;
    }

    /**
     * WebhookIDKey is the ID of the webhook registered with GitHub
     */
    @JsonProperty("webhookIDKey")
    public void setWebhookIDKey(String webhookIDKey) {
        this.webhookIDKey = webhookIDKey;
    }

    @JsonIgnore
    public GitHubSourceStatusBuilder edit() {
        return new GitHubSourceStatusBuilder(this);
    }

    @JsonIgnore
    public GitHubSourceStatusBuilder toBuilder() {
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
        if (!(o instanceof GitHubSourceStatus)) {
            return false;
        }
        GitHubSourceStatus other = (GitHubSourceStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$annotations = this.getAnnotations();
        Object other$annotations = other.getAnnotations();
        if (this$annotations == null ? other$annotations != null : !this$annotations.equals(other$annotations)) {
            return false;
        }
        Object this$auth = this.getAuth();
        Object other$auth = other.getAuth();
        if (this$auth == null ? other$auth != null : !this$auth.equals(other$auth)) {
            return false;
        }
        Object this$ceAttributes = this.getCeAttributes();
        Object other$ceAttributes = other.getCeAttributes();
        if (this$ceAttributes == null ? other$ceAttributes != null : !this$ceAttributes.equals(other$ceAttributes)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$sinkAudience = this.getSinkAudience();
        Object other$sinkAudience = other.getSinkAudience();
        if (this$sinkAudience == null ? other$sinkAudience != null : !this$sinkAudience.equals(other$sinkAudience)) {
            return false;
        }
        Object this$sinkCACerts = this.getSinkCACerts();
        Object other$sinkCACerts = other.getSinkCACerts();
        if (this$sinkCACerts == null ? other$sinkCACerts != null : !this$sinkCACerts.equals(other$sinkCACerts)) {
            return false;
        }
        Object this$sinkUri = this.getSinkUri();
        Object other$sinkUri = other.getSinkUri();
        if (this$sinkUri == null ? other$sinkUri != null : !this$sinkUri.equals(other$sinkUri)) {
            return false;
        }
        Object this$webhookIDKey = this.getWebhookIDKey();
        Object other$webhookIDKey = other.getWebhookIDKey();
        if (this$webhookIDKey == null ? other$webhookIDKey != null : !this$webhookIDKey.equals(other$webhookIDKey)) {
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
        return other instanceof GitHubSourceStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $annotations = this.getAnnotations();
        result = result * prime + ($annotations == null ? 43 : $annotations.hashCode());
        Object $auth = this.getAuth();
        result = result * prime + ($auth == null ? 43 : $auth.hashCode());
        Object $ceAttributes = this.getCeAttributes();
        result = result * prime + ($ceAttributes == null ? 43 : $ceAttributes.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $sinkAudience = this.getSinkAudience();
        result = result * prime + ($sinkAudience == null ? 43 : $sinkAudience.hashCode());
        Object $sinkCACerts = this.getSinkCACerts();
        result = result * prime + ($sinkCACerts == null ? 43 : $sinkCACerts.hashCode());
        Object $sinkUri = this.getSinkUri();
        result = result * prime + ($sinkUri == null ? 43 : $sinkUri.hashCode());
        Object $webhookIDKey = this.getWebhookIDKey();
        result = result * prime + ($webhookIDKey == null ? 43 : $webhookIDKey.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GitHubSourceStatus(" + "annotations=" + this.getAnnotations() + ", auth=" + this.getAuth() + ", ceAttributes=" + this.getCeAttributes() + ", conditions=" + this.getConditions() + ", observedGeneration=" + this.getObservedGeneration() + ", sinkAudience=" + this.getSinkAudience() + ", sinkCACerts=" + this.getSinkCACerts() + ", sinkUri=" + this.getSinkUri() + ", webhookIDKey=" + this.getWebhookIDKey() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
