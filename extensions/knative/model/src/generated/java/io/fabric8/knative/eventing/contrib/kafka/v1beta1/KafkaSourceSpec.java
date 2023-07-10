
package io.fabric8.knative.eventing.contrib.kafka.v1beta1;

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
import io.fabric8.knative.internal.pkg.apis.duck.v1.CloudEventOverrides;
import io.fabric8.knative.internal.pkg.apis.duck.v1.Destination;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "bootstrapServers",
    "ceOverrides",
    "consumerGroup",
    "consumers",
    "initialOffset",
    "net",
    "sink",
    "topics"
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("jsonschema2pojo")
public class KafkaSourceSpec implements KubernetesResource
{

    @JsonProperty("bootstrapServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bootstrapServers = new ArrayList<String>();
    @JsonProperty("ceOverrides")
    private CloudEventOverrides ceOverrides;
    @JsonProperty("consumerGroup")
    private String consumerGroup;
    @JsonProperty("consumers")
    private Integer consumers;
    @JsonProperty("initialOffset")
    private String initialOffset;
    @JsonProperty("net")
    private KafkaNetSpec net;
    @JsonProperty("sink")
    private Destination sink;
    @JsonProperty("topics")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> topics = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KafkaSourceSpec() {
    }

    public KafkaSourceSpec(List<String> bootstrapServers, CloudEventOverrides ceOverrides, String consumerGroup, Integer consumers, String initialOffset, KafkaNetSpec net, Destination sink, List<String> topics) {
        super();
        this.bootstrapServers = bootstrapServers;
        this.ceOverrides = ceOverrides;
        this.consumerGroup = consumerGroup;
        this.consumers = consumers;
        this.initialOffset = initialOffset;
        this.net = net;
        this.sink = sink;
        this.topics = topics;
    }

    @JsonProperty("bootstrapServers")
    public List<String> getBootstrapServers() {
        return bootstrapServers;
    }

    @JsonProperty("bootstrapServers")
    public void setBootstrapServers(List<String> bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    @JsonProperty("ceOverrides")
    public CloudEventOverrides getCeOverrides() {
        return ceOverrides;
    }

    @JsonProperty("ceOverrides")
    public void setCeOverrides(CloudEventOverrides ceOverrides) {
        this.ceOverrides = ceOverrides;
    }

    @JsonProperty("consumerGroup")
    public String getConsumerGroup() {
        return consumerGroup;
    }

    @JsonProperty("consumerGroup")
    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    @JsonProperty("consumers")
    public Integer getConsumers() {
        return consumers;
    }

    @JsonProperty("consumers")
    public void setConsumers(Integer consumers) {
        this.consumers = consumers;
    }

    @JsonProperty("initialOffset")
    public String getInitialOffset() {
        return initialOffset;
    }

    @JsonProperty("initialOffset")
    public void setInitialOffset(String initialOffset) {
        this.initialOffset = initialOffset;
    }

    @JsonProperty("net")
    public KafkaNetSpec getNet() {
        return net;
    }

    @JsonProperty("net")
    public void setNet(KafkaNetSpec net) {
        this.net = net;
    }

    @JsonProperty("sink")
    public Destination getSink() {
        return sink;
    }

    @JsonProperty("sink")
    public void setSink(Destination sink) {
        this.sink = sink;
    }

    @JsonProperty("topics")
    public List<String> getTopics() {
        return topics;
    }

    @JsonProperty("topics")
    public void setTopics(List<String> topics) {
        this.topics = topics;
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
