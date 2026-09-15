
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
 * Consistent Hash-based load balancing can be used to provide soft session affinity based on HTTP headers, cookies or other properties. The affinity to a particular destination host may be lost when one or more hosts are added/removed from the destination service.<br><p> <br><p> Note: consistent hashing is less reliable at maintaining affinity than common "sticky sessions" implementations, which often encode a specific destination in a cookie, ensuring affinity is maintained as long as the backend remains. With consistent hash, the guarantees are weaker; any host addition or removal can break affinity for `1/backends` requests.<br><p> <br><p> Warning: consistent hashing depends on each proxy having a consistent view of endpoints. This is not the case when locality load balancing is enabled. Locality load balancing and consistent hash will only work together when all proxies are in the same locality, or a high level load balancer handles locality affinity.
 */
@JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "HashAlgorithm",
    "HashKey",
    "minimumRingSize"
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
public class LoadBalancerSettingsConsistentHashLB implements Editable<LoadBalancerSettingsConsistentHashLBBuilder>, KubernetesResource
{

    @JsonProperty("HashAlgorithm")
    @JsonUnwrapped
    private IsLoadBalancerSettingsConsistentHashLBHashAlgorithm hashAlgorithm;
    @JsonProperty("HashKey")
    @JsonUnwrapped
    private IsLoadBalancerSettingsConsistentHashLBHashKey hashKey;
    @JsonProperty("minimumRingSize")
    private Long minimumRingSize;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public LoadBalancerSettingsConsistentHashLB() {
    }

    public LoadBalancerSettingsConsistentHashLB(IsLoadBalancerSettingsConsistentHashLBHashAlgorithm hashAlgorithm, IsLoadBalancerSettingsConsistentHashLBHashKey hashKey, Long minimumRingSize) {
        super();
        this.hashAlgorithm = hashAlgorithm;
        this.hashKey = hashKey;
        this.minimumRingSize = minimumRingSize;
    }

    /**
     * Consistent Hash-based load balancing can be used to provide soft session affinity based on HTTP headers, cookies or other properties. The affinity to a particular destination host may be lost when one or more hosts are added/removed from the destination service.<br><p> <br><p> Note: consistent hashing is less reliable at maintaining affinity than common "sticky sessions" implementations, which often encode a specific destination in a cookie, ensuring affinity is maintained as long as the backend remains. With consistent hash, the guarantees are weaker; any host addition or removal can break affinity for `1/backends` requests.<br><p> <br><p> Warning: consistent hashing depends on each proxy having a consistent view of endpoints. This is not the case when locality load balancing is enabled. Locality load balancing and consistent hash will only work together when all proxies are in the same locality, or a high level load balancer handles locality affinity.
     */
    @JsonProperty("HashAlgorithm")
    @JsonUnwrapped
    public IsLoadBalancerSettingsConsistentHashLBHashAlgorithm getHashAlgorithm() {
        return hashAlgorithm;
    }

    /**
     * Consistent Hash-based load balancing can be used to provide soft session affinity based on HTTP headers, cookies or other properties. The affinity to a particular destination host may be lost when one or more hosts are added/removed from the destination service.<br><p> <br><p> Note: consistent hashing is less reliable at maintaining affinity than common "sticky sessions" implementations, which often encode a specific destination in a cookie, ensuring affinity is maintained as long as the backend remains. With consistent hash, the guarantees are weaker; any host addition or removal can break affinity for `1/backends` requests.<br><p> <br><p> Warning: consistent hashing depends on each proxy having a consistent view of endpoints. This is not the case when locality load balancing is enabled. Locality load balancing and consistent hash will only work together when all proxies are in the same locality, or a high level load balancer handles locality affinity.
     */
    @JsonProperty("HashAlgorithm")
    public void setHashAlgorithm(IsLoadBalancerSettingsConsistentHashLBHashAlgorithm hashAlgorithm) {
        this.hashAlgorithm = hashAlgorithm;
    }

    /**
     * Consistent Hash-based load balancing can be used to provide soft session affinity based on HTTP headers, cookies or other properties. The affinity to a particular destination host may be lost when one or more hosts are added/removed from the destination service.<br><p> <br><p> Note: consistent hashing is less reliable at maintaining affinity than common "sticky sessions" implementations, which often encode a specific destination in a cookie, ensuring affinity is maintained as long as the backend remains. With consistent hash, the guarantees are weaker; any host addition or removal can break affinity for `1/backends` requests.<br><p> <br><p> Warning: consistent hashing depends on each proxy having a consistent view of endpoints. This is not the case when locality load balancing is enabled. Locality load balancing and consistent hash will only work together when all proxies are in the same locality, or a high level load balancer handles locality affinity.
     */
    @JsonProperty("HashKey")
    @JsonUnwrapped
    public IsLoadBalancerSettingsConsistentHashLBHashKey getHashKey() {
        return hashKey;
    }

    /**
     * Consistent Hash-based load balancing can be used to provide soft session affinity based on HTTP headers, cookies or other properties. The affinity to a particular destination host may be lost when one or more hosts are added/removed from the destination service.<br><p> <br><p> Note: consistent hashing is less reliable at maintaining affinity than common "sticky sessions" implementations, which often encode a specific destination in a cookie, ensuring affinity is maintained as long as the backend remains. With consistent hash, the guarantees are weaker; any host addition or removal can break affinity for `1/backends` requests.<br><p> <br><p> Warning: consistent hashing depends on each proxy having a consistent view of endpoints. This is not the case when locality load balancing is enabled. Locality load balancing and consistent hash will only work together when all proxies are in the same locality, or a high level load balancer handles locality affinity.
     */
    @JsonProperty("HashKey")
    public void setHashKey(IsLoadBalancerSettingsConsistentHashLBHashKey hashKey) {
        this.hashKey = hashKey;
    }

    /**
     * Deprecated. Use RingHash instead.<br><p> <br><p> Deprecated: Marked as deprecated in networking/v1alpha3/destination_rule.proto.
     */
    @JsonProperty("minimumRingSize")
    public Long getMinimumRingSize() {
        return minimumRingSize;
    }

    /**
     * Deprecated. Use RingHash instead.<br><p> <br><p> Deprecated: Marked as deprecated in networking/v1alpha3/destination_rule.proto.
     */
    @JsonProperty("minimumRingSize")
    public void setMinimumRingSize(Long minimumRingSize) {
        this.minimumRingSize = minimumRingSize;
    }

    @JsonIgnore
    public LoadBalancerSettingsConsistentHashLBBuilder edit() {
        return new LoadBalancerSettingsConsistentHashLBBuilder(this);
    }

    @JsonIgnore
    public LoadBalancerSettingsConsistentHashLBBuilder toBuilder() {
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
        if (!(o instanceof LoadBalancerSettingsConsistentHashLB)) {
            return false;
        }
        LoadBalancerSettingsConsistentHashLB other = (LoadBalancerSettingsConsistentHashLB) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$hashAlgorithm = this.getHashAlgorithm();
        Object other$hashAlgorithm = other.getHashAlgorithm();
        if (this$hashAlgorithm == null ? other$hashAlgorithm != null : !this$hashAlgorithm.equals(other$hashAlgorithm)) {
            return false;
        }
        Object this$hashKey = this.getHashKey();
        Object other$hashKey = other.getHashKey();
        if (this$hashKey == null ? other$hashKey != null : !this$hashKey.equals(other$hashKey)) {
            return false;
        }
        Object this$minimumRingSize = this.getMinimumRingSize();
        Object other$minimumRingSize = other.getMinimumRingSize();
        if (this$minimumRingSize == null ? other$minimumRingSize != null : !this$minimumRingSize.equals(other$minimumRingSize)) {
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
        return other instanceof LoadBalancerSettingsConsistentHashLB;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $hashAlgorithm = this.getHashAlgorithm();
        result = result * prime + ($hashAlgorithm == null ? 43 : $hashAlgorithm.hashCode());
        Object $hashKey = this.getHashKey();
        result = result * prime + ($hashKey == null ? 43 : $hashKey.hashCode());
        Object $minimumRingSize = this.getMinimumRingSize();
        result = result * prime + ($minimumRingSize == null ? 43 : $minimumRingSize.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LoadBalancerSettingsConsistentHashLB(" + "hashAlgorithm=" + this.getHashAlgorithm() + ", hashKey=" + this.getHashKey() + ", minimumRingSize=" + this.getMinimumRingSize() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
