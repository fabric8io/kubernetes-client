
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

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
     * batchSendDeadline defines the maximum time a sample will wait in buffer.
     */
    @JsonProperty("batchSendDeadline")
    public String getBatchSendDeadline() {
        return batchSendDeadline;
    }

    /**
     * batchSendDeadline defines the maximum time a sample will wait in buffer.
     */
    @JsonProperty("batchSendDeadline")
    public void setBatchSendDeadline(String batchSendDeadline) {
        this.batchSendDeadline = batchSendDeadline;
    }

    /**
     * capacity defines the number of samples to buffer per shard before we start dropping them.
     */
    @JsonProperty("capacity")
    public Integer getCapacity() {
        return capacity;
    }

    /**
     * capacity defines the number of samples to buffer per shard before we start dropping them.
     */
    @JsonProperty("capacity")
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    /**
     * maxBackoff defines the maximum retry delay.
     */
    @JsonProperty("maxBackoff")
    public String getMaxBackoff() {
        return maxBackoff;
    }

    /**
     * maxBackoff defines the maximum retry delay.
     */
    @JsonProperty("maxBackoff")
    public void setMaxBackoff(String maxBackoff) {
        this.maxBackoff = maxBackoff;
    }

    /**
     * maxRetries defines the maximum number of times to retry a batch on recoverable errors.
     */
    @JsonProperty("maxRetries")
    public Integer getMaxRetries() {
        return maxRetries;
    }

    /**
     * maxRetries defines the maximum number of times to retry a batch on recoverable errors.
     */
    @JsonProperty("maxRetries")
    public void setMaxRetries(Integer maxRetries) {
        this.maxRetries = maxRetries;
    }

    /**
     * maxSamplesPerSend defines the maximum number of samples per send.
     */
    @JsonProperty("maxSamplesPerSend")
    public Integer getMaxSamplesPerSend() {
        return maxSamplesPerSend;
    }

    /**
     * maxSamplesPerSend defines the maximum number of samples per send.
     */
    @JsonProperty("maxSamplesPerSend")
    public void setMaxSamplesPerSend(Integer maxSamplesPerSend) {
        this.maxSamplesPerSend = maxSamplesPerSend;
    }

    /**
     * maxShards defines the maximum number of shards, i.e. amount of concurrency.
     */
    @JsonProperty("maxShards")
    public Integer getMaxShards() {
        return maxShards;
    }

    /**
     * maxShards defines the maximum number of shards, i.e. amount of concurrency.
     */
    @JsonProperty("maxShards")
    public void setMaxShards(Integer maxShards) {
        this.maxShards = maxShards;
    }

    /**
     * minBackoff defines the initial retry delay. Gets doubled for every retry.
     */
    @JsonProperty("minBackoff")
    public String getMinBackoff() {
        return minBackoff;
    }

    /**
     * minBackoff defines the initial retry delay. Gets doubled for every retry.
     */
    @JsonProperty("minBackoff")
    public void setMinBackoff(String minBackoff) {
        this.minBackoff = minBackoff;
    }

    /**
     * minShards defines the minimum number of shards, i.e. amount of concurrency.
     */
    @JsonProperty("minShards")
    public Integer getMinShards() {
        return minShards;
    }

    /**
     * minShards defines the minimum number of shards, i.e. amount of concurrency.
     */
    @JsonProperty("minShards")
    public void setMinShards(Integer minShards) {
        this.minShards = minShards;
    }

    /**
     * retryOnRateLimit defines the retry upon receiving a 429 status code from the remote-write storage.<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.
     */
    @JsonProperty("retryOnRateLimit")
    public Boolean getRetryOnRateLimit() {
        return retryOnRateLimit;
    }

    /**
     * retryOnRateLimit defines the retry upon receiving a 429 status code from the remote-write storage.<br><p> <br><p> This is an &#42;experimental feature&#42;, it may change in any upcoming release in a breaking way.
     */
    @JsonProperty("retryOnRateLimit")
    public void setRetryOnRateLimit(Boolean retryOnRateLimit) {
        this.retryOnRateLimit = retryOnRateLimit;
    }

    /**
     * sampleAgeLimit drops samples older than the limit. It requires Prometheus &gt;= v2.50.0 or Thanos &gt;= v0.32.0.
     */
    @JsonProperty("sampleAgeLimit")
    public String getSampleAgeLimit() {
        return sampleAgeLimit;
    }

    /**
     * sampleAgeLimit drops samples older than the limit. It requires Prometheus &gt;= v2.50.0 or Thanos &gt;= v0.32.0.
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
        if (!(o instanceof QueueConfig)) {
            return false;
        }
        QueueConfig other = (QueueConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$batchSendDeadline = this.getBatchSendDeadline();
        Object other$batchSendDeadline = other.getBatchSendDeadline();
        if (this$batchSendDeadline == null ? other$batchSendDeadline != null : !this$batchSendDeadline.equals(other$batchSendDeadline)) {
            return false;
        }
        Object this$capacity = this.getCapacity();
        Object other$capacity = other.getCapacity();
        if (this$capacity == null ? other$capacity != null : !this$capacity.equals(other$capacity)) {
            return false;
        }
        Object this$maxBackoff = this.getMaxBackoff();
        Object other$maxBackoff = other.getMaxBackoff();
        if (this$maxBackoff == null ? other$maxBackoff != null : !this$maxBackoff.equals(other$maxBackoff)) {
            return false;
        }
        Object this$maxRetries = this.getMaxRetries();
        Object other$maxRetries = other.getMaxRetries();
        if (this$maxRetries == null ? other$maxRetries != null : !this$maxRetries.equals(other$maxRetries)) {
            return false;
        }
        Object this$maxSamplesPerSend = this.getMaxSamplesPerSend();
        Object other$maxSamplesPerSend = other.getMaxSamplesPerSend();
        if (this$maxSamplesPerSend == null ? other$maxSamplesPerSend != null : !this$maxSamplesPerSend.equals(other$maxSamplesPerSend)) {
            return false;
        }
        Object this$maxShards = this.getMaxShards();
        Object other$maxShards = other.getMaxShards();
        if (this$maxShards == null ? other$maxShards != null : !this$maxShards.equals(other$maxShards)) {
            return false;
        }
        Object this$minBackoff = this.getMinBackoff();
        Object other$minBackoff = other.getMinBackoff();
        if (this$minBackoff == null ? other$minBackoff != null : !this$minBackoff.equals(other$minBackoff)) {
            return false;
        }
        Object this$minShards = this.getMinShards();
        Object other$minShards = other.getMinShards();
        if (this$minShards == null ? other$minShards != null : !this$minShards.equals(other$minShards)) {
            return false;
        }
        Object this$retryOnRateLimit = this.getRetryOnRateLimit();
        Object other$retryOnRateLimit = other.getRetryOnRateLimit();
        if (this$retryOnRateLimit == null ? other$retryOnRateLimit != null : !this$retryOnRateLimit.equals(other$retryOnRateLimit)) {
            return false;
        }
        Object this$sampleAgeLimit = this.getSampleAgeLimit();
        Object other$sampleAgeLimit = other.getSampleAgeLimit();
        if (this$sampleAgeLimit == null ? other$sampleAgeLimit != null : !this$sampleAgeLimit.equals(other$sampleAgeLimit)) {
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
        return other instanceof QueueConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $batchSendDeadline = this.getBatchSendDeadline();
        result = result * prime + ($batchSendDeadline == null ? 43 : $batchSendDeadline.hashCode());
        Object $capacity = this.getCapacity();
        result = result * prime + ($capacity == null ? 43 : $capacity.hashCode());
        Object $maxBackoff = this.getMaxBackoff();
        result = result * prime + ($maxBackoff == null ? 43 : $maxBackoff.hashCode());
        Object $maxRetries = this.getMaxRetries();
        result = result * prime + ($maxRetries == null ? 43 : $maxRetries.hashCode());
        Object $maxSamplesPerSend = this.getMaxSamplesPerSend();
        result = result * prime + ($maxSamplesPerSend == null ? 43 : $maxSamplesPerSend.hashCode());
        Object $maxShards = this.getMaxShards();
        result = result * prime + ($maxShards == null ? 43 : $maxShards.hashCode());
        Object $minBackoff = this.getMinBackoff();
        result = result * prime + ($minBackoff == null ? 43 : $minBackoff.hashCode());
        Object $minShards = this.getMinShards();
        result = result * prime + ($minShards == null ? 43 : $minShards.hashCode());
        Object $retryOnRateLimit = this.getRetryOnRateLimit();
        result = result * prime + ($retryOnRateLimit == null ? 43 : $retryOnRateLimit.hashCode());
        Object $sampleAgeLimit = this.getSampleAgeLimit();
        result = result * prime + ($sampleAgeLimit == null ? 43 : $sampleAgeLimit.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "QueueConfig(" + "batchSendDeadline=" + this.getBatchSendDeadline() + ", capacity=" + this.getCapacity() + ", maxBackoff=" + this.getMaxBackoff() + ", maxRetries=" + this.getMaxRetries() + ", maxSamplesPerSend=" + this.getMaxSamplesPerSend() + ", maxShards=" + this.getMaxShards() + ", minBackoff=" + this.getMinBackoff() + ", minShards=" + this.getMinShards() + ", retryOnRateLimit=" + this.getRetryOnRateLimit() + ", sampleAgeLimit=" + this.getSampleAgeLimit() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
