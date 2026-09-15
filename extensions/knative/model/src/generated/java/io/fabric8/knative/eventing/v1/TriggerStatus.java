
package io.fabric8.knative.eventing.v1;

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
 * TriggerStatus represents the current state of a Trigger.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotations",
    "auth",
    "conditions",
    "deadLetterSinkAudience",
    "deadLetterSinkCACerts",
    "deadLetterSinkUri",
    "observedGeneration",
    "subscriberAudience",
    "subscriberCACerts",
    "subscriberUri"
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
public class TriggerStatus implements Editable<TriggerStatusBuilder>, KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("auth")
    private AuthStatus auth;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("deadLetterSinkAudience")
    private String deadLetterSinkAudience;
    @JsonProperty("deadLetterSinkCACerts")
    private String deadLetterSinkCACerts;
    @JsonProperty("deadLetterSinkUri")
    private String deadLetterSinkUri;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("subscriberAudience")
    private String subscriberAudience;
    @JsonProperty("subscriberCACerts")
    private String subscriberCACerts;
    @JsonProperty("subscriberUri")
    private String subscriberUri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TriggerStatus() {
    }

    public TriggerStatus(Map<String, String> annotations, AuthStatus auth, List<Condition> conditions, String deadLetterSinkAudience, String deadLetterSinkCACerts, String deadLetterSinkUri, Long observedGeneration, String subscriberAudience, String subscriberCACerts, String subscriberUri) {
        super();
        this.annotations = annotations;
        this.auth = auth;
        this.conditions = conditions;
        this.deadLetterSinkAudience = deadLetterSinkAudience;
        this.deadLetterSinkCACerts = deadLetterSinkCACerts;
        this.deadLetterSinkUri = deadLetterSinkUri;
        this.observedGeneration = observedGeneration;
        this.subscriberAudience = subscriberAudience;
        this.subscriberCACerts = subscriberCACerts;
        this.subscriberUri = subscriberUri;
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
     * TriggerStatus represents the current state of a Trigger.
     */
    @JsonProperty("auth")
    public AuthStatus getAuth() {
        return auth;
    }

    /**
     * TriggerStatus represents the current state of a Trigger.
     */
    @JsonProperty("auth")
    public void setAuth(AuthStatus auth) {
        this.auth = auth;
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
     * DeadLetterSinkAudience is the OIDC audience of the DeadLetterSink
     */
    @JsonProperty("deadLetterSinkAudience")
    public String getDeadLetterSinkAudience() {
        return deadLetterSinkAudience;
    }

    /**
     * DeadLetterSinkAudience is the OIDC audience of the DeadLetterSink
     */
    @JsonProperty("deadLetterSinkAudience")
    public void setDeadLetterSinkAudience(String deadLetterSinkAudience) {
        this.deadLetterSinkAudience = deadLetterSinkAudience;
    }

    /**
     * DeadLetterSinkCACerts are Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468.
     */
    @JsonProperty("deadLetterSinkCACerts")
    public String getDeadLetterSinkCACerts() {
        return deadLetterSinkCACerts;
    }

    /**
     * DeadLetterSinkCACerts are Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468.
     */
    @JsonProperty("deadLetterSinkCACerts")
    public void setDeadLetterSinkCACerts(String deadLetterSinkCACerts) {
        this.deadLetterSinkCACerts = deadLetterSinkCACerts;
    }

    /**
     * TriggerStatus represents the current state of a Trigger.
     */
    @JsonProperty("deadLetterSinkUri")
    public String getDeadLetterSinkUri() {
        return deadLetterSinkUri;
    }

    /**
     * TriggerStatus represents the current state of a Trigger.
     */
    @JsonProperty("deadLetterSinkUri")
    public void setDeadLetterSinkUri(String deadLetterSinkUri) {
        this.deadLetterSinkUri = deadLetterSinkUri;
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
     * SubscriberAudience is the OIDC audience of the subscriber.
     */
    @JsonProperty("subscriberAudience")
    public String getSubscriberAudience() {
        return subscriberAudience;
    }

    /**
     * SubscriberAudience is the OIDC audience of the subscriber.
     */
    @JsonProperty("subscriberAudience")
    public void setSubscriberAudience(String subscriberAudience) {
        this.subscriberAudience = subscriberAudience;
    }

    /**
     * SubscriberCACerts is the Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468 of the receiver for this Trigger.
     */
    @JsonProperty("subscriberCACerts")
    public String getSubscriberCACerts() {
        return subscriberCACerts;
    }

    /**
     * SubscriberCACerts is the Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468 of the receiver for this Trigger.
     */
    @JsonProperty("subscriberCACerts")
    public void setSubscriberCACerts(String subscriberCACerts) {
        this.subscriberCACerts = subscriberCACerts;
    }

    /**
     * TriggerStatus represents the current state of a Trigger.
     */
    @JsonProperty("subscriberUri")
    public String getSubscriberUri() {
        return subscriberUri;
    }

    /**
     * TriggerStatus represents the current state of a Trigger.
     */
    @JsonProperty("subscriberUri")
    public void setSubscriberUri(String subscriberUri) {
        this.subscriberUri = subscriberUri;
    }

    @JsonIgnore
    public TriggerStatusBuilder edit() {
        return new TriggerStatusBuilder(this);
    }

    @JsonIgnore
    public TriggerStatusBuilder toBuilder() {
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
        if (!(o instanceof TriggerStatus)) {
            return false;
        }
        TriggerStatus other = (TriggerStatus) o;
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
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$deadLetterSinkAudience = this.getDeadLetterSinkAudience();
        Object other$deadLetterSinkAudience = other.getDeadLetterSinkAudience();
        if (this$deadLetterSinkAudience == null ? other$deadLetterSinkAudience != null : !this$deadLetterSinkAudience.equals(other$deadLetterSinkAudience)) {
            return false;
        }
        Object this$deadLetterSinkCACerts = this.getDeadLetterSinkCACerts();
        Object other$deadLetterSinkCACerts = other.getDeadLetterSinkCACerts();
        if (this$deadLetterSinkCACerts == null ? other$deadLetterSinkCACerts != null : !this$deadLetterSinkCACerts.equals(other$deadLetterSinkCACerts)) {
            return false;
        }
        Object this$deadLetterSinkUri = this.getDeadLetterSinkUri();
        Object other$deadLetterSinkUri = other.getDeadLetterSinkUri();
        if (this$deadLetterSinkUri == null ? other$deadLetterSinkUri != null : !this$deadLetterSinkUri.equals(other$deadLetterSinkUri)) {
            return false;
        }
        Object this$observedGeneration = this.getObservedGeneration();
        Object other$observedGeneration = other.getObservedGeneration();
        if (this$observedGeneration == null ? other$observedGeneration != null : !this$observedGeneration.equals(other$observedGeneration)) {
            return false;
        }
        Object this$subscriberAudience = this.getSubscriberAudience();
        Object other$subscriberAudience = other.getSubscriberAudience();
        if (this$subscriberAudience == null ? other$subscriberAudience != null : !this$subscriberAudience.equals(other$subscriberAudience)) {
            return false;
        }
        Object this$subscriberCACerts = this.getSubscriberCACerts();
        Object other$subscriberCACerts = other.getSubscriberCACerts();
        if (this$subscriberCACerts == null ? other$subscriberCACerts != null : !this$subscriberCACerts.equals(other$subscriberCACerts)) {
            return false;
        }
        Object this$subscriberUri = this.getSubscriberUri();
        Object other$subscriberUri = other.getSubscriberUri();
        if (this$subscriberUri == null ? other$subscriberUri != null : !this$subscriberUri.equals(other$subscriberUri)) {
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
        return other instanceof TriggerStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $annotations = this.getAnnotations();
        result = result * prime + ($annotations == null ? 43 : $annotations.hashCode());
        Object $auth = this.getAuth();
        result = result * prime + ($auth == null ? 43 : $auth.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $deadLetterSinkAudience = this.getDeadLetterSinkAudience();
        result = result * prime + ($deadLetterSinkAudience == null ? 43 : $deadLetterSinkAudience.hashCode());
        Object $deadLetterSinkCACerts = this.getDeadLetterSinkCACerts();
        result = result * prime + ($deadLetterSinkCACerts == null ? 43 : $deadLetterSinkCACerts.hashCode());
        Object $deadLetterSinkUri = this.getDeadLetterSinkUri();
        result = result * prime + ($deadLetterSinkUri == null ? 43 : $deadLetterSinkUri.hashCode());
        Object $observedGeneration = this.getObservedGeneration();
        result = result * prime + ($observedGeneration == null ? 43 : $observedGeneration.hashCode());
        Object $subscriberAudience = this.getSubscriberAudience();
        result = result * prime + ($subscriberAudience == null ? 43 : $subscriberAudience.hashCode());
        Object $subscriberCACerts = this.getSubscriberCACerts();
        result = result * prime + ($subscriberCACerts == null ? 43 : $subscriberCACerts.hashCode());
        Object $subscriberUri = this.getSubscriberUri();
        result = result * prime + ($subscriberUri == null ? 43 : $subscriberUri.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TriggerStatus(" + "annotations=" + this.getAnnotations() + ", auth=" + this.getAuth() + ", conditions=" + this.getConditions() + ", deadLetterSinkAudience=" + this.getDeadLetterSinkAudience() + ", deadLetterSinkCACerts=" + this.getDeadLetterSinkCACerts() + ", deadLetterSinkUri=" + this.getDeadLetterSinkUri() + ", observedGeneration=" + this.getObservedGeneration() + ", subscriberAudience=" + this.getSubscriberAudience() + ", subscriberCACerts=" + this.getSubscriberCACerts() + ", subscriberUri=" + this.getSubscriberUri() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
