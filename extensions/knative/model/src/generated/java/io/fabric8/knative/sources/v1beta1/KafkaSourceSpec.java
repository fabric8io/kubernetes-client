
package io.fabric8.knative.sources.v1beta1;

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
import io.fabric8.knative.bindings.v1beta1.KafkaNetSpec;
import io.fabric8.knative.duck.v1.CloudEventOverrides;
import io.fabric8.knative.duck.v1.DeliverySpec;
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

/**
 * KafkaSourceSpec defines the desired state of the KafkaSource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bootstrapServers",
    "ceOverrides",
    "consumerGroup",
    "consumers",
    "delivery",
    "initialOffset",
    "net",
    "ordering",
    "sink",
    "topics"
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
public class KafkaSourceSpec implements Editable<KafkaSourceSpecBuilder>, KubernetesResource
{

    @JsonProperty("bootstrapServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bootstrapServers = new ArrayList<>();
    @JsonProperty("ceOverrides")
    private CloudEventOverrides ceOverrides;
    @JsonProperty("consumerGroup")
    private String consumerGroup;
    @JsonProperty("consumers")
    private Integer consumers;
    @JsonProperty("delivery")
    private DeliverySpec delivery;
    @JsonProperty("initialOffset")
    private String initialOffset;
    @JsonProperty("net")
    private KafkaNetSpec net;
    @JsonProperty("ordering")
    private String ordering;
    @JsonProperty("sink")
    private Destination sink;
    @JsonProperty("topics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> topics = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KafkaSourceSpec() {
    }

    public KafkaSourceSpec(List<String> bootstrapServers, CloudEventOverrides ceOverrides, String consumerGroup, Integer consumers, DeliverySpec delivery, String initialOffset, KafkaNetSpec net, String ordering, Destination sink, List<String> topics) {
        super();
        this.bootstrapServers = bootstrapServers;
        this.ceOverrides = ceOverrides;
        this.consumerGroup = consumerGroup;
        this.consumers = consumers;
        this.delivery = delivery;
        this.initialOffset = initialOffset;
        this.net = net;
        this.ordering = ordering;
        this.sink = sink;
        this.topics = topics;
    }

    /**
     * Bootstrap servers are the Kafka servers the consumer will connect to.
     */
    @JsonProperty("bootstrapServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBootstrapServers() {
        return bootstrapServers;
    }

    /**
     * Bootstrap servers are the Kafka servers the consumer will connect to.
     */
    @JsonProperty("bootstrapServers")
    public void setBootstrapServers(List<String> bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    /**
     * KafkaSourceSpec defines the desired state of the KafkaSource.
     */
    @JsonProperty("ceOverrides")
    public CloudEventOverrides getCeOverrides() {
        return ceOverrides;
    }

    /**
     * KafkaSourceSpec defines the desired state of the KafkaSource.
     */
    @JsonProperty("ceOverrides")
    public void setCeOverrides(CloudEventOverrides ceOverrides) {
        this.ceOverrides = ceOverrides;
    }

    /**
     * ConsumerGroupID is the consumer group ID.
     */
    @JsonProperty("consumerGroup")
    public String getConsumerGroup() {
        return consumerGroup;
    }

    /**
     * ConsumerGroupID is the consumer group ID.
     */
    @JsonProperty("consumerGroup")
    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    /**
     * Number of desired consumers running in the consumer group. Defaults to 1.<br><p> <br><p> This is a pointer to distinguish between explicit zero and not specified.
     */
    @JsonProperty("consumers")
    public Integer getConsumers() {
        return consumers;
    }

    /**
     * Number of desired consumers running in the consumer group. Defaults to 1.<br><p> <br><p> This is a pointer to distinguish between explicit zero and not specified.
     */
    @JsonProperty("consumers")
    public void setConsumers(Integer consumers) {
        this.consumers = consumers;
    }

    /**
     * KafkaSourceSpec defines the desired state of the KafkaSource.
     */
    @JsonProperty("delivery")
    public DeliverySpec getDelivery() {
        return delivery;
    }

    /**
     * KafkaSourceSpec defines the desired state of the KafkaSource.
     */
    @JsonProperty("delivery")
    public void setDelivery(DeliverySpec delivery) {
        this.delivery = delivery;
    }

    /**
     * InitialOffset is the Initial Offset for the consumer group. should be earliest or latest
     */
    @JsonProperty("initialOffset")
    public String getInitialOffset() {
        return initialOffset;
    }

    /**
     * InitialOffset is the Initial Offset for the consumer group. should be earliest or latest
     */
    @JsonProperty("initialOffset")
    public void setInitialOffset(String initialOffset) {
        this.initialOffset = initialOffset;
    }

    /**
     * KafkaSourceSpec defines the desired state of the KafkaSource.
     */
    @JsonProperty("net")
    public KafkaNetSpec getNet() {
        return net;
    }

    /**
     * KafkaSourceSpec defines the desired state of the KafkaSource.
     */
    @JsonProperty("net")
    public void setNet(KafkaNetSpec net) {
        this.net = net;
    }

    /**
     * Ordering is the type of the consumer verticle. Should be ordered or unordered. By default, it is ordered.
     */
    @JsonProperty("ordering")
    public String getOrdering() {
        return ordering;
    }

    /**
     * Ordering is the type of the consumer verticle. Should be ordered or unordered. By default, it is ordered.
     */
    @JsonProperty("ordering")
    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    /**
     * KafkaSourceSpec defines the desired state of the KafkaSource.
     */
    @JsonProperty("sink")
    public Destination getSink() {
        return sink;
    }

    /**
     * KafkaSourceSpec defines the desired state of the KafkaSource.
     */
    @JsonProperty("sink")
    public void setSink(Destination sink) {
        this.sink = sink;
    }

    /**
     * Topic topics to consume messages from
     */
    @JsonProperty("topics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTopics() {
        return topics;
    }

    /**
     * Topic topics to consume messages from
     */
    @JsonProperty("topics")
    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    @JsonIgnore
    public KafkaSourceSpecBuilder edit() {
        return new KafkaSourceSpecBuilder(this);
    }

    @JsonIgnore
    public KafkaSourceSpecBuilder toBuilder() {
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
        if (!(o instanceof KafkaSourceSpec)) {
            return false;
        }
        KafkaSourceSpec other = (KafkaSourceSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$bootstrapServers = this.getBootstrapServers();
        Object other$bootstrapServers = other.getBootstrapServers();
        if (this$bootstrapServers == null ? other$bootstrapServers != null : !this$bootstrapServers.equals(other$bootstrapServers)) {
            return false;
        }
        Object this$ceOverrides = this.getCeOverrides();
        Object other$ceOverrides = other.getCeOverrides();
        if (this$ceOverrides == null ? other$ceOverrides != null : !this$ceOverrides.equals(other$ceOverrides)) {
            return false;
        }
        Object this$consumerGroup = this.getConsumerGroup();
        Object other$consumerGroup = other.getConsumerGroup();
        if (this$consumerGroup == null ? other$consumerGroup != null : !this$consumerGroup.equals(other$consumerGroup)) {
            return false;
        }
        Object this$consumers = this.getConsumers();
        Object other$consumers = other.getConsumers();
        if (this$consumers == null ? other$consumers != null : !this$consumers.equals(other$consumers)) {
            return false;
        }
        Object this$delivery = this.getDelivery();
        Object other$delivery = other.getDelivery();
        if (this$delivery == null ? other$delivery != null : !this$delivery.equals(other$delivery)) {
            return false;
        }
        Object this$initialOffset = this.getInitialOffset();
        Object other$initialOffset = other.getInitialOffset();
        if (this$initialOffset == null ? other$initialOffset != null : !this$initialOffset.equals(other$initialOffset)) {
            return false;
        }
        Object this$net = this.getNet();
        Object other$net = other.getNet();
        if (this$net == null ? other$net != null : !this$net.equals(other$net)) {
            return false;
        }
        Object this$ordering = this.getOrdering();
        Object other$ordering = other.getOrdering();
        if (this$ordering == null ? other$ordering != null : !this$ordering.equals(other$ordering)) {
            return false;
        }
        Object this$sink = this.getSink();
        Object other$sink = other.getSink();
        if (this$sink == null ? other$sink != null : !this$sink.equals(other$sink)) {
            return false;
        }
        Object this$topics = this.getTopics();
        Object other$topics = other.getTopics();
        if (this$topics == null ? other$topics != null : !this$topics.equals(other$topics)) {
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
        return other instanceof KafkaSourceSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $bootstrapServers = this.getBootstrapServers();
        result = result * prime + ($bootstrapServers == null ? 43 : $bootstrapServers.hashCode());
        Object $ceOverrides = this.getCeOverrides();
        result = result * prime + ($ceOverrides == null ? 43 : $ceOverrides.hashCode());
        Object $consumerGroup = this.getConsumerGroup();
        result = result * prime + ($consumerGroup == null ? 43 : $consumerGroup.hashCode());
        Object $consumers = this.getConsumers();
        result = result * prime + ($consumers == null ? 43 : $consumers.hashCode());
        Object $delivery = this.getDelivery();
        result = result * prime + ($delivery == null ? 43 : $delivery.hashCode());
        Object $initialOffset = this.getInitialOffset();
        result = result * prime + ($initialOffset == null ? 43 : $initialOffset.hashCode());
        Object $net = this.getNet();
        result = result * prime + ($net == null ? 43 : $net.hashCode());
        Object $ordering = this.getOrdering();
        result = result * prime + ($ordering == null ? 43 : $ordering.hashCode());
        Object $sink = this.getSink();
        result = result * prime + ($sink == null ? 43 : $sink.hashCode());
        Object $topics = this.getTopics();
        result = result * prime + ($topics == null ? 43 : $topics.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KafkaSourceSpec(" + "bootstrapServers=" + this.getBootstrapServers() + ", ceOverrides=" + this.getCeOverrides() + ", consumerGroup=" + this.getConsumerGroup() + ", consumers=" + this.getConsumers() + ", delivery=" + this.getDelivery() + ", initialOffset=" + this.getInitialOffset() + ", net=" + this.getNet() + ", ordering=" + this.getOrdering() + ", sink=" + this.getSink() + ", topics=" + this.getTopics() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
