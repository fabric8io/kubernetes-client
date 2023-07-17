
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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "batchSendDeadline",
    "capacity",
    "maxBackoff",
    "maxRetries",
    "maxSamplesPerSend",
    "maxShards",
    "minBackoff",
    "minShards",
    "retryOnRateLimit"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class QueueConfig implements KubernetesResource
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public QueueConfig() {
    }

    public QueueConfig(String batchSendDeadline, Integer capacity, String maxBackoff, Integer maxRetries, Integer maxSamplesPerSend, Integer maxShards, String minBackoff, Integer minShards, Boolean retryOnRateLimit) {
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
    }

    @JsonProperty("batchSendDeadline")
    public String getBatchSendDeadline() {
        return batchSendDeadline;
    }

    @JsonProperty("batchSendDeadline")
    public void setBatchSendDeadline(String batchSendDeadline) {
        this.batchSendDeadline = batchSendDeadline;
    }

    @JsonProperty("capacity")
    public Integer getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("maxBackoff")
    public String getMaxBackoff() {
        return maxBackoff;
    }

    @JsonProperty("maxBackoff")
    public void setMaxBackoff(String maxBackoff) {
        this.maxBackoff = maxBackoff;
    }

    @JsonProperty("maxRetries")
    public Integer getMaxRetries() {
        return maxRetries;
    }

    @JsonProperty("maxRetries")
    public void setMaxRetries(Integer maxRetries) {
        this.maxRetries = maxRetries;
    }

    @JsonProperty("maxSamplesPerSend")
    public Integer getMaxSamplesPerSend() {
        return maxSamplesPerSend;
    }

    @JsonProperty("maxSamplesPerSend")
    public void setMaxSamplesPerSend(Integer maxSamplesPerSend) {
        this.maxSamplesPerSend = maxSamplesPerSend;
    }

    @JsonProperty("maxShards")
    public Integer getMaxShards() {
        return maxShards;
    }

    @JsonProperty("maxShards")
    public void setMaxShards(Integer maxShards) {
        this.maxShards = maxShards;
    }

    @JsonProperty("minBackoff")
    public String getMinBackoff() {
        return minBackoff;
    }

    @JsonProperty("minBackoff")
    public void setMinBackoff(String minBackoff) {
        this.minBackoff = minBackoff;
    }

    @JsonProperty("minShards")
    public Integer getMinShards() {
        return minShards;
    }

    @JsonProperty("minShards")
    public void setMinShards(Integer minShards) {
        this.minShards = minShards;
    }

    @JsonProperty("retryOnRateLimit")
    public Boolean getRetryOnRateLimit() {
        return retryOnRateLimit;
    }

    @JsonProperty("retryOnRateLimit")
    public void setRetryOnRateLimit(Boolean retryOnRateLimit) {
        this.retryOnRateLimit = retryOnRateLimit;
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
