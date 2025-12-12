
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
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * RateLimitSpec represents the rate limit configuration for a particular kind of resource. Eg. loadBalancerRateLimit is used to configure rate limits for load balancers. This eventually gets converted to CloudProviderRateLimitConfig that cloud-provider-azure expects. See: https://github.com/kubernetes-sigs/cloud-provider-azure/blob/d585c2031925b39c925624302f22f8856e29e352/pkg/provider/azure_ratelimit.go#L25 We cannot use CloudProviderRateLimitConfig directly because floating point values are not supported in controller-tools. See: https://github.com/kubernetes-sigs/controller-tools/issues/245
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "config",
    "name"
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
public class RateLimitSpec implements Editable<RateLimitSpecBuilder>, KubernetesResource
{

    @JsonProperty("config")
    private RateLimitConfig config;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RateLimitSpec() {
    }

    public RateLimitSpec(RateLimitConfig config, String name) {
        super();
        this.config = config;
        this.name = name;
    }

    /**
     * RateLimitSpec represents the rate limit configuration for a particular kind of resource. Eg. loadBalancerRateLimit is used to configure rate limits for load balancers. This eventually gets converted to CloudProviderRateLimitConfig that cloud-provider-azure expects. See: https://github.com/kubernetes-sigs/cloud-provider-azure/blob/d585c2031925b39c925624302f22f8856e29e352/pkg/provider/azure_ratelimit.go#L25 We cannot use CloudProviderRateLimitConfig directly because floating point values are not supported in controller-tools. See: https://github.com/kubernetes-sigs/controller-tools/issues/245
     */
    @JsonProperty("config")
    public RateLimitConfig getConfig() {
        return config;
    }

    /**
     * RateLimitSpec represents the rate limit configuration for a particular kind of resource. Eg. loadBalancerRateLimit is used to configure rate limits for load balancers. This eventually gets converted to CloudProviderRateLimitConfig that cloud-provider-azure expects. See: https://github.com/kubernetes-sigs/cloud-provider-azure/blob/d585c2031925b39c925624302f22f8856e29e352/pkg/provider/azure_ratelimit.go#L25 We cannot use CloudProviderRateLimitConfig directly because floating point values are not supported in controller-tools. See: https://github.com/kubernetes-sigs/controller-tools/issues/245
     */
    @JsonProperty("config")
    public void setConfig(RateLimitConfig config) {
        this.config = config;
    }

    /**
     * Name is the name of the rate limit spec.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the rate limit spec.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public RateLimitSpecBuilder edit() {
        return new RateLimitSpecBuilder(this);
    }

    @JsonIgnore
    public RateLimitSpecBuilder toBuilder() {
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
