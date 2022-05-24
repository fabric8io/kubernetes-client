
package io.fabric8.knative.messaging.v1;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.knative.internal.eventing.pkg.apis.duck.v1.DeliverySpec;
import io.fabric8.knative.internal.pkg.apis.duck.v1.Destination;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
    "channel",
    "delivery",
    "reply",
    "subscriber"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class SubscriptionSpec implements KubernetesResource
{

    @JsonProperty("channel")
    private io.fabric8.kubernetes.api.model.ObjectReference channel;
    @JsonProperty("delivery")
    private DeliverySpec delivery;
    @JsonProperty("reply")
    private Destination reply;
    @JsonProperty("subscriber")
    private Destination subscriber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubscriptionSpec() {
    }

    /**
     * 
     * @param delivery
     * @param subscriber
     * @param channel
     * @param reply
     */
    public SubscriptionSpec(io.fabric8.kubernetes.api.model.ObjectReference channel, DeliverySpec delivery, Destination reply, Destination subscriber) {
        super();
        this.channel = channel;
        this.delivery = delivery;
        this.reply = reply;
        this.subscriber = subscriber;
    }

    @JsonProperty("channel")
    public io.fabric8.kubernetes.api.model.ObjectReference getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(io.fabric8.kubernetes.api.model.ObjectReference channel) {
        this.channel = channel;
    }

    @JsonProperty("delivery")
    public DeliverySpec getDelivery() {
        return delivery;
    }

    @JsonProperty("delivery")
    public void setDelivery(DeliverySpec delivery) {
        this.delivery = delivery;
    }

    @JsonProperty("reply")
    public Destination getReply() {
        return reply;
    }

    @JsonProperty("reply")
    public void setReply(Destination reply) {
        this.reply = reply;
    }

    @JsonProperty("subscriber")
    public Destination getSubscriber() {
        return subscriber;
    }

    @JsonProperty("subscriber")
    public void setSubscriber(Destination subscriber) {
        this.subscriber = subscriber;
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
