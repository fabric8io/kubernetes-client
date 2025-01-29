
package io.fabric8.knative.eventing.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * KafkaSinkSpec defines the desired state of the Kafka Sink.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "auth",
    "bootstrapServers",
    "contentMode",
    "numPartitions",
    "replicationFactor",
    "topic"
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
public class KafkaSinkSpec implements Editable<KafkaSinkSpecBuilder>, KubernetesResource
{

    @JsonProperty("auth")
    private Auth auth;
    @JsonProperty("bootstrapServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bootstrapServers = new ArrayList<>();
    @JsonProperty("contentMode")
    private String contentMode;
    @JsonProperty("numPartitions")
    private Integer numPartitions;
    @JsonProperty("replicationFactor")
    private Integer replicationFactor;
    @JsonProperty("topic")
    private String topic;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public KafkaSinkSpec() {
    }

    public KafkaSinkSpec(Auth auth, List<String> bootstrapServers, String contentMode, Integer numPartitions, Integer replicationFactor, String topic) {
        super();
        this.auth = auth;
        this.bootstrapServers = bootstrapServers;
        this.contentMode = contentMode;
        this.numPartitions = numPartitions;
        this.replicationFactor = replicationFactor;
        this.topic = topic;
    }

    /**
     * KafkaSinkSpec defines the desired state of the Kafka Sink.
     */
    @JsonProperty("auth")
    public Auth getAuth() {
        return auth;
    }

    /**
     * KafkaSinkSpec defines the desired state of the Kafka Sink.
     */
    @JsonProperty("auth")
    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    /**
     * Kafka Broker bootstrap servers.
     */
    @JsonProperty("bootstrapServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBootstrapServers() {
        return bootstrapServers;
    }

    /**
     * Kafka Broker bootstrap servers.
     */
    @JsonProperty("bootstrapServers")
    public void setBootstrapServers(List<String> bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    /**
     * CloudEvent content mode of Kafka messages sent to the topic. Possible values: - structured - binary<br><p> <br><p> - default: binary.<br><p> <br><p> - https://github.com/cloudevents/spec/blob/v1.0/spec.md#message<br><p> 	 - https://github.com/cloudevents/spec/blob/v1.0/kafka-protocol-binding.md#32-binary-content-mode'<br><p> 	 - https://github.com/cloudevents/spec/blob/v1.0/kafka-protocol-binding.md#33-structured-content-mode
     */
    @JsonProperty("contentMode")
    public String getContentMode() {
        return contentMode;
    }

    /**
     * CloudEvent content mode of Kafka messages sent to the topic. Possible values: - structured - binary<br><p> <br><p> - default: binary.<br><p> <br><p> - https://github.com/cloudevents/spec/blob/v1.0/spec.md#message<br><p> 	 - https://github.com/cloudevents/spec/blob/v1.0/kafka-protocol-binding.md#32-binary-content-mode'<br><p> 	 - https://github.com/cloudevents/spec/blob/v1.0/kafka-protocol-binding.md#33-structured-content-mode
     */
    @JsonProperty("contentMode")
    public void setContentMode(String contentMode) {
        this.contentMode = contentMode;
    }

    /**
     * Number of topic partitions.
     */
    @JsonProperty("numPartitions")
    public Integer getNumPartitions() {
        return numPartitions;
    }

    /**
     * Number of topic partitions.
     */
    @JsonProperty("numPartitions")
    public void setNumPartitions(Integer numPartitions) {
        this.numPartitions = numPartitions;
    }

    /**
     * Topic replication factor
     */
    @JsonProperty("replicationFactor")
    public Integer getReplicationFactor() {
        return replicationFactor;
    }

    /**
     * Topic replication factor
     */
    @JsonProperty("replicationFactor")
    public void setReplicationFactor(Integer replicationFactor) {
        this.replicationFactor = replicationFactor;
    }

    /**
     * Topic name to send events.
     */
    @JsonProperty("topic")
    public String getTopic() {
        return topic;
    }

    /**
     * Topic name to send events.
     */
    @JsonProperty("topic")
    public void setTopic(String topic) {
        this.topic = topic;
    }

    @JsonIgnore
    public KafkaSinkSpecBuilder edit() {
        return new KafkaSinkSpecBuilder(this);
    }

    @JsonIgnore
    public KafkaSinkSpecBuilder toBuilder() {
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
