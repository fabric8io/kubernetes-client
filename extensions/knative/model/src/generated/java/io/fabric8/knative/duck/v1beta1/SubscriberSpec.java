
package io.fabric8.knative.duck.v1beta1;

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
 * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "delivery",
    "generation",
    "replyUri",
    "subscriberUri",
    "uid"
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
public class SubscriberSpec implements Editable<SubscriberSpecBuilder>, KubernetesResource
{

    @JsonProperty("delivery")
    private DeliverySpec delivery;
    @JsonProperty("generation")
    private Long generation;
    @JsonProperty("replyUri")
    private String replyUri;
    @JsonProperty("subscriberUri")
    private String subscriberUri;
    @JsonProperty("uid")
    private String uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubscriberSpec() {
    }

    public SubscriberSpec(DeliverySpec delivery, Long generation, String replyUri, String subscriberUri, String uid) {
        super();
        this.delivery = delivery;
        this.generation = generation;
        this.replyUri = replyUri;
        this.subscriberUri = subscriberUri;
        this.uid = uid;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("delivery")
    public DeliverySpec getDelivery() {
        return delivery;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("delivery")
    public void setDelivery(DeliverySpec delivery) {
        this.delivery = delivery;
    }

    /**
     * Generation of the origin of the subscriber with uid:UID.
     */
    @JsonProperty("generation")
    public Long getGeneration() {
        return generation;
    }

    /**
     * Generation of the origin of the subscriber with uid:UID.
     */
    @JsonProperty("generation")
    public void setGeneration(Long generation) {
        this.generation = generation;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("replyUri")
    public String getReplyUri() {
        return replyUri;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("replyUri")
    public void setReplyUri(String replyUri) {
        this.replyUri = replyUri;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("subscriberUri")
    public String getSubscriberUri() {
        return subscriberUri;
    }

    /**
     * SubscriberSpec defines a single subscriber to a Subscribable.<br><p> <br><p> At least one of SubscriberURI and ReplyURI must be present
     */
    @JsonProperty("subscriberUri")
    public void setSubscriberUri(String subscriberUri) {
        this.subscriberUri = subscriberUri;
    }

    /**
     * UID is used to understand the origin of the subscriber.
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * UID is used to understand the origin of the subscriber.
     */
    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public SubscriberSpecBuilder edit() {
        return new SubscriberSpecBuilder(this);
    }

    @JsonIgnore
    public SubscriberSpecBuilder toBuilder() {
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
        if (!(o instanceof SubscriberSpec)) {
            return false;
        }
        SubscriberSpec other = (SubscriberSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$delivery = this.getDelivery();
        Object other$delivery = other.getDelivery();
        if (this$delivery == null ? other$delivery != null : !this$delivery.equals(other$delivery)) {
            return false;
        }
        Object this$generation = this.getGeneration();
        Object other$generation = other.getGeneration();
        if (this$generation == null ? other$generation != null : !this$generation.equals(other$generation)) {
            return false;
        }
        Object this$replyUri = this.getReplyUri();
        Object other$replyUri = other.getReplyUri();
        if (this$replyUri == null ? other$replyUri != null : !this$replyUri.equals(other$replyUri)) {
            return false;
        }
        Object this$subscriberUri = this.getSubscriberUri();
        Object other$subscriberUri = other.getSubscriberUri();
        if (this$subscriberUri == null ? other$subscriberUri != null : !this$subscriberUri.equals(other$subscriberUri)) {
            return false;
        }
        Object this$uid = this.getUid();
        Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) {
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
        return other instanceof SubscriberSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $delivery = this.getDelivery();
        result = result * prime + ($delivery == null ? 43 : $delivery.hashCode());
        Object $generation = this.getGeneration();
        result = result * prime + ($generation == null ? 43 : $generation.hashCode());
        Object $replyUri = this.getReplyUri();
        result = result * prime + ($replyUri == null ? 43 : $replyUri.hashCode());
        Object $subscriberUri = this.getSubscriberUri();
        result = result * prime + ($subscriberUri == null ? 43 : $subscriberUri.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SubscriberSpec(" + "delivery=" + this.getDelivery() + ", generation=" + this.getGeneration() + ", replyUri=" + this.getReplyUri() + ", subscriberUri=" + this.getSubscriberUri() + ", uid=" + this.getUid() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
