
package io.fabric8.openclustermanagement.api.model.apps.v1;

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
import io.fabric8.kubernetes.api.model.ConfigMap;
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
import io.fabric8.kubernetes.api.model.Secret;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * SubscriberItem defines subscriber item to share subscribers with different channel types
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Channel",
    "ChannelConfigMap",
    "ChannelSecret",
    "SecondaryChannel",
    "SecondaryChannelConfigMap",
    "SecondaryChannelSecret",
    "Subscription",
    "SubscriptionConfigMap"
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
public class SubscriberItem implements Editable<SubscriberItemBuilder>, KubernetesResource
{

    @JsonProperty("Channel")
    private Channel channel;
    @JsonProperty("ChannelConfigMap")
    private ConfigMap channelConfigMap;
    @JsonProperty("ChannelSecret")
    private Secret channelSecret;
    @JsonProperty("SecondaryChannel")
    private Channel secondaryChannel;
    @JsonProperty("SecondaryChannelConfigMap")
    private ConfigMap secondaryChannelConfigMap;
    @JsonProperty("SecondaryChannelSecret")
    private Secret secondaryChannelSecret;
    @JsonProperty("Subscription")
    private Subscription subscription;
    @JsonProperty("SubscriptionConfigMap")
    private ConfigMap subscriptionConfigMap;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubscriberItem() {
    }

    public SubscriberItem(Channel channel, ConfigMap channelConfigMap, Secret channelSecret, Channel secondaryChannel, ConfigMap secondaryChannelConfigMap, Secret secondaryChannelSecret, Subscription subscription, ConfigMap subscriptionConfigMap) {
        super();
        this.channel = channel;
        this.channelConfigMap = channelConfigMap;
        this.channelSecret = channelSecret;
        this.secondaryChannel = secondaryChannel;
        this.secondaryChannelConfigMap = secondaryChannelConfigMap;
        this.secondaryChannelSecret = secondaryChannelSecret;
        this.subscription = subscription;
        this.subscriptionConfigMap = subscriptionConfigMap;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("Channel")
    public Channel getChannel() {
        return channel;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("Channel")
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("ChannelConfigMap")
    public ConfigMap getChannelConfigMap() {
        return channelConfigMap;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("ChannelConfigMap")
    public void setChannelConfigMap(ConfigMap channelConfigMap) {
        this.channelConfigMap = channelConfigMap;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("ChannelSecret")
    public Secret getChannelSecret() {
        return channelSecret;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("ChannelSecret")
    public void setChannelSecret(Secret channelSecret) {
        this.channelSecret = channelSecret;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("SecondaryChannel")
    public Channel getSecondaryChannel() {
        return secondaryChannel;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("SecondaryChannel")
    public void setSecondaryChannel(Channel secondaryChannel) {
        this.secondaryChannel = secondaryChannel;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("SecondaryChannelConfigMap")
    public ConfigMap getSecondaryChannelConfigMap() {
        return secondaryChannelConfigMap;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("SecondaryChannelConfigMap")
    public void setSecondaryChannelConfigMap(ConfigMap secondaryChannelConfigMap) {
        this.secondaryChannelConfigMap = secondaryChannelConfigMap;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("SecondaryChannelSecret")
    public Secret getSecondaryChannelSecret() {
        return secondaryChannelSecret;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("SecondaryChannelSecret")
    public void setSecondaryChannelSecret(Secret secondaryChannelSecret) {
        this.secondaryChannelSecret = secondaryChannelSecret;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("Subscription")
    public Subscription getSubscription() {
        return subscription;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("Subscription")
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("SubscriptionConfigMap")
    public ConfigMap getSubscriptionConfigMap() {
        return subscriptionConfigMap;
    }

    /**
     * SubscriberItem defines subscriber item to share subscribers with different channel types
     */
    @JsonProperty("SubscriptionConfigMap")
    public void setSubscriptionConfigMap(ConfigMap subscriptionConfigMap) {
        this.subscriptionConfigMap = subscriptionConfigMap;
    }

    @JsonIgnore
    public SubscriberItemBuilder edit() {
        return new SubscriberItemBuilder(this);
    }

    @JsonIgnore
    public SubscriberItemBuilder toBuilder() {
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

}
