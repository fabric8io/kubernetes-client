
package io.fabric8.knative.messaging.v1;

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
import io.fabric8.kubernetes.api.builder.Editable;
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
import lombok.ToString;
import lombok.experimental.Accessors;

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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class SubscriptionStatusPhysicalSubscription implements Editable<SubscriptionStatusPhysicalSubscriptionBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("deadLetterSinkAudience")
    public String getDeadLetterSinkAudience() {
        return deadLetterSinkAudience;
    }

    @JsonProperty("deadLetterSinkAudience")
    public void setDeadLetterSinkAudience(String deadLetterSinkAudience) {
        this.deadLetterSinkAudience = deadLetterSinkAudience;
    }

    @JsonProperty("deadLetterSinkCACerts")
    public String getDeadLetterSinkCACerts() {
        return deadLetterSinkCACerts;
    }

    @JsonProperty("deadLetterSinkCACerts")
    public void setDeadLetterSinkCACerts(String deadLetterSinkCACerts) {
        this.deadLetterSinkCACerts = deadLetterSinkCACerts;
    }

    @JsonProperty("deadLetterSinkUri")
    public String getDeadLetterSinkUri() {
        return deadLetterSinkUri;
    }

    @JsonProperty("deadLetterSinkUri")
    public void setDeadLetterSinkUri(String deadLetterSinkUri) {
        this.deadLetterSinkUri = deadLetterSinkUri;
    }

    @JsonProperty("replyAudience")
    public String getReplyAudience() {
        return replyAudience;
    }

    @JsonProperty("replyAudience")
    public void setReplyAudience(String replyAudience) {
        this.replyAudience = replyAudience;
    }

    @JsonProperty("replyCACerts")
    public String getReplyCACerts() {
        return replyCACerts;
    }

    @JsonProperty("replyCACerts")
    public void setReplyCACerts(String replyCACerts) {
        this.replyCACerts = replyCACerts;
    }

    @JsonProperty("replyUri")
    public String getReplyUri() {
        return replyUri;
    }

    @JsonProperty("replyUri")
    public void setReplyUri(String replyUri) {
        this.replyUri = replyUri;
    }

    @JsonProperty("subscriberAudience")
    public String getSubscriberAudience() {
        return subscriberAudience;
    }

    @JsonProperty("subscriberAudience")
    public void setSubscriberAudience(String subscriberAudience) {
        this.subscriberAudience = subscriberAudience;
    }

    @JsonProperty("subscriberCACerts")
    public String getSubscriberCACerts() {
        return subscriberCACerts;
    }

    @JsonProperty("subscriberCACerts")
    public void setSubscriberCACerts(String subscriberCACerts) {
        this.subscriberCACerts = subscriberCACerts;
    }

    @JsonProperty("subscriberUri")
    public String getSubscriberUri() {
        return subscriberUri;
    }

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
