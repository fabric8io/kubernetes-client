
package io.fabric8.openshift.api.model.monitoring.v1;

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
 * QueueConfig allows the tuning of remote write's queue_config parameters. This object is referenced in the RemoteWriteSpec object.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "batchSendDeadline",
    "capacity",
    "maxBackoff",
    "maxRetries",
    "maxSamplesPerSend",
    "maxShards",
    "minBackoff",
    "minShards",
    "retryOnRateLimit",
    "sampleAgeLimit"
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
public class QueueConfig implements Editable<QueueConfigBuilder>, KubernetesResource
{

    @JsonProperty("batchSendDeadline")
    private String batchSendDeadline;
    @JsonProperty("capacity")
    private Integer capacity;
    @JsonProperty("maxBackoff")
    private String maxBackoff;
    @JsonProperty("maxRetries")
    private Integer maxRetries;
    @JsonProperty("maxSamplesPerSend")
    private Integer maxSamplesPerSend;
    @JsonProperty("maxShards")
    private Integer maxShards;
    @JsonProperty("minBackoff")
    private String minBackoff;
    @JsonProperty("minShards")
    private Integer minShards;
    @JsonProperty("retryOnRateLimit")
    private Boolean retryOnRateLimit;
    @JsonProperty("sampleAgeLimit")
    private String sampleAgeLimit;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public QueueConfig() {
    }

    public QueueConfig(String batchSendDeadline, Integer capacity, String maxBackoff, Integer maxRetries, Integer maxSamplesPerSend, Integer maxShards, String minBackoff, Integer minShards, Boolean retryOnRateLimit, String sampleAgeLimit) {
        super();
        this.batchSendDeadline = batchSendDeadline;
        this.capacity = capacity;
        this.maxBackoff = maxBackoff;
        this.maxRetries = maxRetries;
        this.maxSamplesPerSend = maxSamplesPerSend;
        this.maxShards = maxShards;
        this.minBackoff = minBackoff;
        this.minShards = minShards;
        this.retryOnRateLimit = retryOnRateLimit;
        this.sampleAgeLimit = sampleAgeLimit;
    }

    /**
     * BatchSendDeadline is the maximum time a sample will wait in buffer.
     */
    @JsonProperty("batchSendDeadline")
    public String getBatchSendDeadline() {
        return batchSendDeadline;
    }

    /**
     * BatchSendDeadline is the maximum time a sample will wait in buffer.
     */
    @JsonProperty("batchSendDeadline")
    public void setBatchSendDeadline(String batchSendDeadline) {
        this.batchSendDeadline = batchSendDeadline;
    }

    /**
     * Capacity is the number of samples to buffer per shard before we start dropping them.
     */
    @JsonProperty("capacity")
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * Capacity is the number of samples to buffer per shard before we start dropping them.
     */
    @JsonProperty("capacity")
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * MaxBackoff is the maximum retry delay.
     */
    @JsonProperty("maxBackoff")
    public String getMaxBackoff() {
        return maxBackoff;
    }

    /**
     * MaxBackoff is the maximum retry delay.
     */
    @JsonProperty("maxBackoff")
    public void setMaxBackoff(String maxBackoff) {
        this.maxBackoff = maxBackoff;
    }

    /**
     * MaxRetries is the maximum number of times to retry a batch on recoverable errors.
     */
    @JsonProperty("maxRetries")
    public Integer getMaxRetries() {
        return maxRetries;
    }

    /**
     * MaxRetries is the maximum number of times to retry a batch on recoverable errors.
     */
    @JsonProperty("maxRetries")
    public void setMaxRetries(Integer maxRetries) {
        this.maxRetries = maxRetries;
    }

    /**
     * MaxSamplesPerSend is the maximum number of samples per send.
     */
    @JsonProperty("maxSamplesPerSend")
    public Integer getMaxSamplesPerSend() {
        return maxSamplesPerSend;
    }

    /**
     * MaxSamplesPerSend is the maximum number of samples per send.
     */
    @JsonProperty("maxSamplesPerSend")
    public void setMaxSamplesPerSend(Integer maxSamplesPerSend) {
        this.maxSamplesPerSend = maxSamplesPerSend;
    }

    /**
     * MaxShards is the maximum number of shards, i.e. amount of concurrency.
     */
    @JsonProperty("maxShards")
    public Integer getMaxShards() {
        return maxShards;
    }

    /**
     * MaxShards is the maximum number of shards, i.e. amount of concurrency.
     */
    @JsonProperty("maxShards")
    public void setMaxShards(Integer maxShards) {
        this.maxShards = maxShards;
    }

    /**
     * MinBackoff is the initial retry delay. Gets doubled for every retry.
     */
    @JsonProperty("minBackoff")
    public String getMinBackoff() {
        return minBackoff;
    }

    /**
     * MinBackoff is the initial retry delay. Gets doubled for every retry.
     */
    @JsonProperty("minBackoff")
    public void setMinBackoff(String minBackoff) {
        this.minBackoff = minBackoff;
    }

    /**
     * MinShards is the minimum number of shards, i.e. amount of concurrency.
     */
    @JsonProperty("minShards")
    public Integer getMinShards() {
        return minShards;
    }

    /**
     * MinShards is the minimum number of shards, i.e. amount of concurrency.
     */
    @JsonProperty("minShards")
    public void setMinShards(Integer minShards) {
        this.minShards = minShards;
    }

    /**
     * Retry upon receiving a 429 status code from the remote-write storage.<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.
     */
    @JsonProperty("retryOnRateLimit")
    public Boolean getRetryOnRateLimit() {
        return retryOnRateLimit;
    }

    /**
     * Retry upon receiving a 429 status code from the remote-write storage.<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.
     */
    @JsonProperty("retryOnRateLimit")
    public void setRetryOnRateLimit(Boolean retryOnRateLimit) {
        this.retryOnRateLimit = retryOnRateLimit;
    }

    /**
     * SampleAgeLimit drops samples older than the limit. It requires Prometheus &gt;= v2.50.0.
     */
    @JsonProperty("sampleAgeLimit")
    public String getSampleAgeLimit() {
        return sampleAgeLimit;
    }

    /**
     * SampleAgeLimit drops samples older than the limit. It requires Prometheus &gt;= v2.50.0.
     */
    @JsonProperty("sampleAgeLimit")
    public void setSampleAgeLimit(String sampleAgeLimit) {
        this.sampleAgeLimit = sampleAgeLimit;
    }

    @JsonIgnore
    public QueueConfigBuilder edit() {
        return new QueueConfigBuilder(this);
    }

    @JsonIgnore
    public QueueConfigBuilder toBuilder() {
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
