
package io.fabric8.knative.messaging.v1;

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
import io.fabric8.knative.duck.v1.DeliverySpec;
import io.fabric8.knative.duck.v1.SubscriberSpec;
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

/**
 * KafkaChannelSpec defines the specification for a KafkaChannel.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "delivery",
    "numPartitions",
    "replicationFactor",
    "retentionDuration",
    "subscribers"
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
public class KafkaChannelSpec implements Editable<KafkaChannelSpecBuilder>, KubernetesResource
{

    @JsonProperty("delivery")
    private DeliverySpec delivery;
    @JsonProperty("numPartitions")
    private Integer numPartitions;
    @JsonProperty("replicationFactor")
    private Integer replicationFactor;
    @JsonProperty("retentionDuration")
    private String retentionDuration;
    @JsonProperty("subscribers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SubscriberSpec> subscribers = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KafkaChannelSpec() {
    }

    public KafkaChannelSpec(DeliverySpec delivery, Integer numPartitions, Integer replicationFactor, String retentionDuration, List<SubscriberSpec> subscribers) {
        super();
        this.delivery = delivery;
        this.numPartitions = numPartitions;
        this.replicationFactor = replicationFactor;
        this.retentionDuration = retentionDuration;
        this.subscribers = subscribers;
    }

    /**
     * KafkaChannelSpec defines the specification for a KafkaChannel.
     */
    @JsonProperty("delivery")
    public DeliverySpec getDelivery() {
        return delivery;
    }

    /**
     * KafkaChannelSpec defines the specification for a KafkaChannel.
     */
    @JsonProperty("delivery")
    public void setDelivery(DeliverySpec delivery) {
        this.delivery = delivery;
    }

    /**
     * NumPartitions is the number of partitions of a Kafka topic. By default, it is set to 1.
     */
    @JsonProperty("numPartitions")
    public Integer getNumPartitions() {
        return numPartitions;
    }

    /**
     * NumPartitions is the number of partitions of a Kafka topic. By default, it is set to 1.
     */
    @JsonProperty("numPartitions")
    public void setNumPartitions(Integer numPartitions) {
        this.numPartitions = numPartitions;
    }

    /**
     * ReplicationFactor is the replication factor of a Kafka topic. By default, it is set to 1.
     */
    @JsonProperty("replicationFactor")
    public Integer getReplicationFactor() {
        return replicationFactor;
    }

    /**
     * ReplicationFactor is the replication factor of a Kafka topic. By default, it is set to 1.
     */
    @JsonProperty("replicationFactor")
    public void setReplicationFactor(Integer replicationFactor) {
        this.replicationFactor = replicationFactor;
    }

    /**
     * RetentionDuration is the duration for which events will be retained in the Kafka Topic. By default, it is set to 168 hours, which is the precise form for 7 days. More information on Duration format:<br><p>  - https://www.iso.org/iso-8601-date-and-time-format.html<br><p>  - https://en.wikipedia.org/wiki/ISO_8601
     */
    @JsonProperty("retentionDuration")
    public String getRetentionDuration() {
        return retentionDuration;
    }

    /**
     * RetentionDuration is the duration for which events will be retained in the Kafka Topic. By default, it is set to 168 hours, which is the precise form for 7 days. More information on Duration format:<br><p>  - https://www.iso.org/iso-8601-date-and-time-format.html<br><p>  - https://en.wikipedia.org/wiki/ISO_8601
     */
    @JsonProperty("retentionDuration")
    public void setRetentionDuration(String retentionDuration) {
        this.retentionDuration = retentionDuration;
    }

    /**
     * This is the list of subscriptions for this subscribable.
     */
    @JsonProperty("subscribers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SubscriberSpec> getSubscribers() {
        return subscribers;
    }

    /**
     * This is the list of subscriptions for this subscribable.
     */
    @JsonProperty("subscribers")
    public void setSubscribers(List<SubscriberSpec> subscribers) {
        this.subscribers = subscribers;
    }

    @JsonIgnore
    public KafkaChannelSpecBuilder edit() {
        return new KafkaChannelSpecBuilder(this);
    }

    @JsonIgnore
    public KafkaChannelSpecBuilder toBuilder() {
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
