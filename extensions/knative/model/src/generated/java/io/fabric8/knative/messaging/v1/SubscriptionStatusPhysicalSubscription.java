
package io.fabric8.knative.messaging.v1;

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
 * SubscriptionStatusPhysicalSubscription represents the fully resolved values for this Subscription.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deadLetterSinkAudience",
    "deadLetterSinkCACerts",
    "deadLetterSinkUri",
    "replyAudience",
    "replyCACerts",
    "replyUri",
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
public class SubscriptionStatusPhysicalSubscription implements Editable<SubscriptionStatusPhysicalSubscriptionBuilder>, KubernetesResource
{

    @JsonProperty("deadLetterSinkAudience")
    private String deadLetterSinkAudience;
    @JsonProperty("deadLetterSinkCACerts")
    private String deadLetterSinkCACerts;
    @JsonProperty("deadLetterSinkUri")
    private String deadLetterSinkUri;
    @JsonProperty("replyAudience")
    private String replyAudience;
    @JsonProperty("replyCACerts")
    private String replyCACerts;
    @JsonProperty("replyUri")
    private String replyUri;
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
    public SubscriptionStatusPhysicalSubscription() {
    }

    public SubscriptionStatusPhysicalSubscription(String deadLetterSinkAudience, String deadLetterSinkCACerts, String deadLetterSinkUri, String replyAudience, String replyCACerts, String replyUri, String subscriberAudience, String subscriberCACerts, String subscriberUri) {
        super();
        this.deadLetterSinkAudience = deadLetterSinkAudience;
        this.deadLetterSinkCACerts = deadLetterSinkCACerts;
        this.deadLetterSinkUri = deadLetterSinkUri;
        this.replyAudience = replyAudience;
        this.replyCACerts = replyCACerts;
        this.replyUri = replyUri;
        this.subscriberAudience = subscriberAudience;
        this.subscriberCACerts = subscriberCACerts;
        this.subscriberUri = subscriberUri;
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
     * SubscriptionStatusPhysicalSubscription represents the fully resolved values for this Subscription.
     */
    @JsonProperty("deadLetterSinkUri")
    public String getDeadLetterSinkUri() {
        return deadLetterSinkUri;
    }

    /**
     * SubscriptionStatusPhysicalSubscription represents the fully resolved values for this Subscription.
     */
    @JsonProperty("deadLetterSinkUri")
    public void setDeadLetterSinkUri(String deadLetterSinkUri) {
        this.deadLetterSinkUri = deadLetterSinkUri;
    }

    /**
     * ReplyAudience is the OIDC audience for the the resolved URI for spec.reply.
     */
    @JsonProperty("replyAudience")
    public String getReplyAudience() {
        return replyAudience;
    }

    /**
     * ReplyAudience is the OIDC audience for the the resolved URI for spec.reply.
     */
    @JsonProperty("replyAudience")
    public void setReplyAudience(String replyAudience) {
        this.replyAudience = replyAudience;
    }

    /**
     * ReplyCACerts is the Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468 for the resolved URI for the spec.reply.
     */
    @JsonProperty("replyCACerts")
    public String getReplyCACerts() {
        return replyCACerts;
    }

    /**
     * ReplyCACerts is the Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468 for the resolved URI for the spec.reply.
     */
    @JsonProperty("replyCACerts")
    public void setReplyCACerts(String replyCACerts) {
        this.replyCACerts = replyCACerts;
    }

    /**
     * SubscriptionStatusPhysicalSubscription represents the fully resolved values for this Subscription.
     */
    @JsonProperty("replyUri")
    public String getReplyUri() {
        return replyUri;
    }

    /**
     * SubscriptionStatusPhysicalSubscription represents the fully resolved values for this Subscription.
     */
    @JsonProperty("replyUri")
    public void setReplyUri(String replyUri) {
        this.replyUri = replyUri;
    }

    /**
     * SubscriberAudience is the OIDC audience for the the resolved URI for spec.subscriber.
     */
    @JsonProperty("subscriberAudience")
    public String getSubscriberAudience() {
        return subscriberAudience;
    }

    /**
     * SubscriberAudience is the OIDC audience for the the resolved URI for spec.subscriber.
     */
    @JsonProperty("subscriberAudience")
    public void setSubscriberAudience(String subscriberAudience) {
        this.subscriberAudience = subscriberAudience;
    }

    /**
     * SubscriberCACerts is the Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468 for the resolved URI for spec.subscriber.
     */
    @JsonProperty("subscriberCACerts")
    public String getSubscriberCACerts() {
        return subscriberCACerts;
    }

    /**
     * SubscriberCACerts is the Certification Authority (CA) certificates in PEM format according to https://www.rfc-editor.org/rfc/rfc7468 for the resolved URI for spec.subscriber.
     */
    @JsonProperty("subscriberCACerts")
    public void setSubscriberCACerts(String subscriberCACerts) {
        this.subscriberCACerts = subscriberCACerts;
    }

    /**
     * SubscriptionStatusPhysicalSubscription represents the fully resolved values for this Subscription.
     */
    @JsonProperty("subscriberUri")
    public String getSubscriberUri() {
        return subscriberUri;
    }

    /**
     * SubscriptionStatusPhysicalSubscription represents the fully resolved values for this Subscription.
     */
    @JsonProperty("subscriberUri")
    public void setSubscriberUri(String subscriberUri) {
        this.subscriberUri = subscriberUri;
    }

    @JsonIgnore
    public SubscriptionStatusPhysicalSubscriptionBuilder edit() {
        return new SubscriptionStatusPhysicalSubscriptionBuilder(this);
    }

    @JsonIgnore
    public SubscriptionStatusPhysicalSubscriptionBuilder toBuilder() {
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
        if (!(o instanceof SubscriptionStatusPhysicalSubscription)) {
            return false;
        }
        SubscriptionStatusPhysicalSubscription other = (SubscriptionStatusPhysicalSubscription) o;
        if (!other.canEqual(this)) {
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
        Object this$replyAudience = this.getReplyAudience();
        Object other$replyAudience = other.getReplyAudience();
        if (this$replyAudience == null ? other$replyAudience != null : !this$replyAudience.equals(other$replyAudience)) {
            return false;
        }
        Object this$replyCACerts = this.getReplyCACerts();
        Object other$replyCACerts = other.getReplyCACerts();
        if (this$replyCACerts == null ? other$replyCACerts != null : !this$replyCACerts.equals(other$replyCACerts)) {
            return false;
        }
        Object this$replyUri = this.getReplyUri();
        Object other$replyUri = other.getReplyUri();
        if (this$replyUri == null ? other$replyUri != null : !this$replyUri.equals(other$replyUri)) {
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
        return other instanceof SubscriptionStatusPhysicalSubscription;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $deadLetterSinkAudience = this.getDeadLetterSinkAudience();
        result = result * prime + ($deadLetterSinkAudience == null ? 43 : $deadLetterSinkAudience.hashCode());
        Object $deadLetterSinkCACerts = this.getDeadLetterSinkCACerts();
        result = result * prime + ($deadLetterSinkCACerts == null ? 43 : $deadLetterSinkCACerts.hashCode());
        Object $deadLetterSinkUri = this.getDeadLetterSinkUri();
        result = result * prime + ($deadLetterSinkUri == null ? 43 : $deadLetterSinkUri.hashCode());
        Object $replyAudience = this.getReplyAudience();
        result = result * prime + ($replyAudience == null ? 43 : $replyAudience.hashCode());
        Object $replyCACerts = this.getReplyCACerts();
        result = result * prime + ($replyCACerts == null ? 43 : $replyCACerts.hashCode());
        Object $replyUri = this.getReplyUri();
        result = result * prime + ($replyUri == null ? 43 : $replyUri.hashCode());
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
        return "SubscriptionStatusPhysicalSubscription(" + "deadLetterSinkAudience=" + this.getDeadLetterSinkAudience() + ", deadLetterSinkCACerts=" + this.getDeadLetterSinkCACerts() + ", deadLetterSinkUri=" + this.getDeadLetterSinkUri() + ", replyAudience=" + this.getReplyAudience() + ", replyCACerts=" + this.getReplyCACerts() + ", replyUri=" + this.getReplyUri() + ", subscriberAudience=" + this.getSubscriberAudience() + ", subscriberCACerts=" + this.getSubscriberCACerts() + ", subscriberUri=" + this.getSubscriberUri() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
