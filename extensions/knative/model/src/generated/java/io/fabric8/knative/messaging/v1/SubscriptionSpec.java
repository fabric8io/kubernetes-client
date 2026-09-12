
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
import io.fabric8.knative.duck.v1.DeliverySpec;
import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.duck.v1.KReference;
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
 * SubscriptionSpec specifies the Channel for incoming events, a Subscriber target for processing those events and where to put the result of the processing. Only From (where the events are coming from) is always required. You can optionally only Process the events (results in no output events) by leaving out the Reply. You can also perform an identity transformation on the incoming events by leaving out the Subscriber and only specifying Reply.<br><p> <br><p> The following are all valid specifications: channel --[subscriber]--&gt; reply Sink, no outgoing events: channel -- subscriber no-op function (identity transformation): channel --&gt; reply
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "channel",
    "delivery",
    "reply",
    "subscriber"
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
public class SubscriptionSpec implements Editable<SubscriptionSpecBuilder>, KubernetesResource
{

    @JsonProperty("channel")
    private KReference channel;
    @JsonProperty("delivery")
    private DeliverySpec delivery;
    @JsonProperty("reply")
    private Destination reply;
    @JsonProperty("subscriber")
    private Destination subscriber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubscriptionSpec() {
    }

    public SubscriptionSpec(KReference channel, DeliverySpec delivery, Destination reply, Destination subscriber) {
        super();
        this.channel = channel;
        this.delivery = delivery;
        this.reply = reply;
        this.subscriber = subscriber;
    }

    /**
     * SubscriptionSpec specifies the Channel for incoming events, a Subscriber target for processing those events and where to put the result of the processing. Only From (where the events are coming from) is always required. You can optionally only Process the events (results in no output events) by leaving out the Reply. You can also perform an identity transformation on the incoming events by leaving out the Subscriber and only specifying Reply.<br><p> <br><p> The following are all valid specifications: channel --[subscriber]--&gt; reply Sink, no outgoing events: channel -- subscriber no-op function (identity transformation): channel --&gt; reply
     */
    @JsonProperty("channel")
    public KReference getChannel() {
        return channel;
    }

    /**
     * SubscriptionSpec specifies the Channel for incoming events, a Subscriber target for processing those events and where to put the result of the processing. Only From (where the events are coming from) is always required. You can optionally only Process the events (results in no output events) by leaving out the Reply. You can also perform an identity transformation on the incoming events by leaving out the Subscriber and only specifying Reply.<br><p> <br><p> The following are all valid specifications: channel --[subscriber]--&gt; reply Sink, no outgoing events: channel -- subscriber no-op function (identity transformation): channel --&gt; reply
     */
    @JsonProperty("channel")
    public void setChannel(KReference channel) {
        this.channel = channel;
    }

    /**
     * SubscriptionSpec specifies the Channel for incoming events, a Subscriber target for processing those events and where to put the result of the processing. Only From (where the events are coming from) is always required. You can optionally only Process the events (results in no output events) by leaving out the Reply. You can also perform an identity transformation on the incoming events by leaving out the Subscriber and only specifying Reply.<br><p> <br><p> The following are all valid specifications: channel --[subscriber]--&gt; reply Sink, no outgoing events: channel -- subscriber no-op function (identity transformation): channel --&gt; reply
     */
    @JsonProperty("delivery")
    public DeliverySpec getDelivery() {
        return delivery;
    }

    /**
     * SubscriptionSpec specifies the Channel for incoming events, a Subscriber target for processing those events and where to put the result of the processing. Only From (where the events are coming from) is always required. You can optionally only Process the events (results in no output events) by leaving out the Reply. You can also perform an identity transformation on the incoming events by leaving out the Subscriber and only specifying Reply.<br><p> <br><p> The following are all valid specifications: channel --[subscriber]--&gt; reply Sink, no outgoing events: channel -- subscriber no-op function (identity transformation): channel --&gt; reply
     */
    @JsonProperty("delivery")
    public void setDelivery(DeliverySpec delivery) {
        this.delivery = delivery;
    }

    /**
     * SubscriptionSpec specifies the Channel for incoming events, a Subscriber target for processing those events and where to put the result of the processing. Only From (where the events are coming from) is always required. You can optionally only Process the events (results in no output events) by leaving out the Reply. You can also perform an identity transformation on the incoming events by leaving out the Subscriber and only specifying Reply.<br><p> <br><p> The following are all valid specifications: channel --[subscriber]--&gt; reply Sink, no outgoing events: channel -- subscriber no-op function (identity transformation): channel --&gt; reply
     */
    @JsonProperty("reply")
    public Destination getReply() {
        return reply;
    }

    /**
     * SubscriptionSpec specifies the Channel for incoming events, a Subscriber target for processing those events and where to put the result of the processing. Only From (where the events are coming from) is always required. You can optionally only Process the events (results in no output events) by leaving out the Reply. You can also perform an identity transformation on the incoming events by leaving out the Subscriber and only specifying Reply.<br><p> <br><p> The following are all valid specifications: channel --[subscriber]--&gt; reply Sink, no outgoing events: channel -- subscriber no-op function (identity transformation): channel --&gt; reply
     */
    @JsonProperty("reply")
    public void setReply(Destination reply) {
        this.reply = reply;
    }

    /**
     * SubscriptionSpec specifies the Channel for incoming events, a Subscriber target for processing those events and where to put the result of the processing. Only From (where the events are coming from) is always required. You can optionally only Process the events (results in no output events) by leaving out the Reply. You can also perform an identity transformation on the incoming events by leaving out the Subscriber and only specifying Reply.<br><p> <br><p> The following are all valid specifications: channel --[subscriber]--&gt; reply Sink, no outgoing events: channel -- subscriber no-op function (identity transformation): channel --&gt; reply
     */
    @JsonProperty("subscriber")
    public Destination getSubscriber() {
        return subscriber;
    }

    /**
     * SubscriptionSpec specifies the Channel for incoming events, a Subscriber target for processing those events and where to put the result of the processing. Only From (where the events are coming from) is always required. You can optionally only Process the events (results in no output events) by leaving out the Reply. You can also perform an identity transformation on the incoming events by leaving out the Subscriber and only specifying Reply.<br><p> <br><p> The following are all valid specifications: channel --[subscriber]--&gt; reply Sink, no outgoing events: channel -- subscriber no-op function (identity transformation): channel --&gt; reply
     */
    @JsonProperty("subscriber")
    public void setSubscriber(Destination subscriber) {
        this.subscriber = subscriber;
    }

    @JsonIgnore
    public SubscriptionSpecBuilder edit() {
        return new SubscriptionSpecBuilder(this);
    }

    @JsonIgnore
    public SubscriptionSpecBuilder toBuilder() {
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
        if (!(o instanceof SubscriptionSpec)) {
            return false;
        }
        SubscriptionSpec other = (SubscriptionSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$channel = this.getChannel();
        Object other$channel = other.getChannel();
        if (this$channel == null ? other$channel != null : !this$channel.equals(other$channel)) {
            return false;
        }
        Object this$delivery = this.getDelivery();
        Object other$delivery = other.getDelivery();
        if (this$delivery == null ? other$delivery != null : !this$delivery.equals(other$delivery)) {
            return false;
        }
        Object this$reply = this.getReply();
        Object other$reply = other.getReply();
        if (this$reply == null ? other$reply != null : !this$reply.equals(other$reply)) {
            return false;
        }
        Object this$subscriber = this.getSubscriber();
        Object other$subscriber = other.getSubscriber();
        if (this$subscriber == null ? other$subscriber != null : !this$subscriber.equals(other$subscriber)) {
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
        return other instanceof SubscriptionSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $channel = this.getChannel();
        result = result * prime + ($channel == null ? 43 : $channel.hashCode());
        Object $delivery = this.getDelivery();
        result = result * prime + ($delivery == null ? 43 : $delivery.hashCode());
        Object $reply = this.getReply();
        result = result * prime + ($reply == null ? 43 : $reply.hashCode());
        Object $subscriber = this.getSubscriber();
        result = result * prime + ($subscriber == null ? 43 : $subscriber.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SubscriptionSpec(" + "channel=" + this.getChannel() + ", delivery=" + this.getDelivery() + ", reply=" + this.getReply() + ", subscriber=" + this.getSubscriber() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
