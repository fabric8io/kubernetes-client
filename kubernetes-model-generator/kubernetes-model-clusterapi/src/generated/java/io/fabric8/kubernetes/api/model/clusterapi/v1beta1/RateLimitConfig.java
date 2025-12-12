
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * RateLimitConfig indicates the rate limit config options.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cloudProviderRateLimit",
    "cloudProviderRateLimitBucket",
    "cloudProviderRateLimitBucketWrite",
    "cloudProviderRateLimitQPS",
    "cloudProviderRateLimitQPSWrite"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class RateLimitConfig implements Editable<RateLimitConfigBuilder>, KubernetesResource
{

    @JsonProperty("cloudProviderRateLimit")
    private Boolean cloudProviderRateLimit;
    @JsonProperty("cloudProviderRateLimitBucket")
    private Integer cloudProviderRateLimitBucket;
    @JsonProperty("cloudProviderRateLimitBucketWrite")
    private Integer cloudProviderRateLimitBucketWrite;
    @JsonProperty("cloudProviderRateLimitQPS")
    private Quantity cloudProviderRateLimitQPS;
    @JsonProperty("cloudProviderRateLimitQPSWrite")
    private Quantity cloudProviderRateLimitQPSWrite;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RateLimitConfig() {
    }

    public RateLimitConfig(Boolean cloudProviderRateLimit, Integer cloudProviderRateLimitBucket, Integer cloudProviderRateLimitBucketWrite, Quantity cloudProviderRateLimitQPS, Quantity cloudProviderRateLimitQPSWrite) {
        super();
        this.cloudProviderRateLimit = cloudProviderRateLimit;
        this.cloudProviderRateLimitBucket = cloudProviderRateLimitBucket;
        this.cloudProviderRateLimitBucketWrite = cloudProviderRateLimitBucketWrite;
        this.cloudProviderRateLimitQPS = cloudProviderRateLimitQPS;
        this.cloudProviderRateLimitQPSWrite = cloudProviderRateLimitQPSWrite;
    }

    /**
     * RateLimitConfig indicates the rate limit config options.
     */
    @JsonProperty("cloudProviderRateLimit")
    public Boolean getCloudProviderRateLimit() {
        return cloudProviderRateLimit;
    }

    /**
     * RateLimitConfig indicates the rate limit config options.
     */
    @JsonProperty("cloudProviderRateLimit")
    public void setCloudProviderRateLimit(Boolean cloudProviderRateLimit) {
        this.cloudProviderRateLimit = cloudProviderRateLimit;
    }

    /**
     * RateLimitConfig indicates the rate limit config options.
     */
    @JsonProperty("cloudProviderRateLimitBucket")
    public Integer getCloudProviderRateLimitBucket() {
        return cloudProviderRateLimitBucket;
    }

    /**
     * RateLimitConfig indicates the rate limit config options.
     */
    @JsonProperty("cloudProviderRateLimitBucket")
    public void setCloudProviderRateLimitBucket(Integer cloudProviderRateLimitBucket) {
        this.cloudProviderRateLimitBucket = cloudProviderRateLimitBucket;
    }

    /**
     * RateLimitConfig indicates the rate limit config options.
     */
    @JsonProperty("cloudProviderRateLimitBucketWrite")
    public Integer getCloudProviderRateLimitBucketWrite() {
        return cloudProviderRateLimitBucketWrite;
    }

    /**
     * RateLimitConfig indicates the rate limit config options.
     */
    @JsonProperty("cloudProviderRateLimitBucketWrite")
    public void setCloudProviderRateLimitBucketWrite(Integer cloudProviderRateLimitBucketWrite) {
        this.cloudProviderRateLimitBucketWrite = cloudProviderRateLimitBucketWrite;
    }

    /**
     * RateLimitConfig indicates the rate limit config options.
     */
    @JsonProperty("cloudProviderRateLimitQPS")
    public Quantity getCloudProviderRateLimitQPS() {
        return cloudProviderRateLimitQPS;
    }

    /**
     * RateLimitConfig indicates the rate limit config options.
     */
    @JsonProperty("cloudProviderRateLimitQPS")
    public void setCloudProviderRateLimitQPS(Quantity cloudProviderRateLimitQPS) {
        this.cloudProviderRateLimitQPS = cloudProviderRateLimitQPS;
    }

    /**
     * RateLimitConfig indicates the rate limit config options.
     */
    @JsonProperty("cloudProviderRateLimitQPSWrite")
    public Quantity getCloudProviderRateLimitQPSWrite() {
        return cloudProviderRateLimitQPSWrite;
    }

    /**
     * RateLimitConfig indicates the rate limit config options.
     */
    @JsonProperty("cloudProviderRateLimitQPSWrite")
    public void setCloudProviderRateLimitQPSWrite(Quantity cloudProviderRateLimitQPSWrite) {
        this.cloudProviderRateLimitQPSWrite = cloudProviderRateLimitQPSWrite;
    }

    @JsonIgnore
    public RateLimitConfigBuilder edit() {
        return new RateLimitConfigBuilder(this);
    }

    @JsonIgnore
    public RateLimitConfigBuilder toBuilder() {
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
