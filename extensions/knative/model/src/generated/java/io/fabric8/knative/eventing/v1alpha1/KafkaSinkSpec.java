
package io.fabric8.knative.eventing.v1alpha1;

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
        if (!(o instanceof KafkaSinkSpec)) {
            return false;
        }
        KafkaSinkSpec other = (KafkaSinkSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$auth = this.getAuth();
        Object other$auth = other.getAuth();
        if (this$auth == null ? other$auth != null : !this$auth.equals(other$auth)) {
            return false;
        }
        Object this$bootstrapServers = this.getBootstrapServers();
        Object other$bootstrapServers = other.getBootstrapServers();
        if (this$bootstrapServers == null ? other$bootstrapServers != null : !this$bootstrapServers.equals(other$bootstrapServers)) {
            return false;
        }
        Object this$contentMode = this.getContentMode();
        Object other$contentMode = other.getContentMode();
        if (this$contentMode == null ? other$contentMode != null : !this$contentMode.equals(other$contentMode)) {
            return false;
        }
        Object this$numPartitions = this.getNumPartitions();
        Object other$numPartitions = other.getNumPartitions();
        if (this$numPartitions == null ? other$numPartitions != null : !this$numPartitions.equals(other$numPartitions)) {
            return false;
        }
        Object this$replicationFactor = this.getReplicationFactor();
        Object other$replicationFactor = other.getReplicationFactor();
        if (this$replicationFactor == null ? other$replicationFactor != null : !this$replicationFactor.equals(other$replicationFactor)) {
            return false;
        }
        Object this$topic = this.getTopic();
        Object other$topic = other.getTopic();
        if (this$topic == null ? other$topic != null : !this$topic.equals(other$topic)) {
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
        return other instanceof KafkaSinkSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $auth = this.getAuth();
        result = result * prime + ($auth == null ? 43 : $auth.hashCode());
        Object $bootstrapServers = this.getBootstrapServers();
        result = result * prime + ($bootstrapServers == null ? 43 : $bootstrapServers.hashCode());
        Object $contentMode = this.getContentMode();
        result = result * prime + ($contentMode == null ? 43 : $contentMode.hashCode());
        Object $numPartitions = this.getNumPartitions();
        result = result * prime + ($numPartitions == null ? 43 : $numPartitions.hashCode());
        Object $replicationFactor = this.getReplicationFactor();
        result = result * prime + ($replicationFactor == null ? 43 : $replicationFactor.hashCode());
        Object $topic = this.getTopic();
        result = result * prime + ($topic == null ? 43 : $topic.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "KafkaSinkSpec(" + "auth=" + this.getAuth() + ", bootstrapServers=" + this.getBootstrapServers() + ", contentMode=" + this.getContentMode() + ", numPartitions=" + this.getNumPartitions() + ", replicationFactor=" + this.getReplicationFactor() + ", topic=" + this.getTopic() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
