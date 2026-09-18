
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * CacheConfig is the spec of memcached.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectionLimit",
    "maxItemSize",
    "memoryLimitMb",
    "replicas",
    "resources"
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
public class CacheConfig implements Editable<CacheConfigBuilder>, KubernetesResource
{

    @JsonProperty("connectionLimit")
    private Integer connectionLimit;
    @JsonProperty("maxItemSize")
    private String maxItemSize;
    @JsonProperty("memoryLimitMb")
    private Integer memoryLimitMb;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private ResourceRequirements resources;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CacheConfig() {
    }

    public CacheConfig(Integer connectionLimit, String maxItemSize, Integer memoryLimitMb, Integer replicas, ResourceRequirements resources) {
        super();
        this.connectionLimit = connectionLimit;
        this.maxItemSize = maxItemSize;
        this.memoryLimitMb = memoryLimitMb;
        this.replicas = replicas;
        this.resources = resources;
    }

    /**
     * Max simultaneous connections of Memcached.
     */
    @JsonProperty("connectionLimit")
    public Integer getConnectionLimit() {
        return connectionLimit;
    }

    /**
     * Max simultaneous connections of Memcached.
     */
    @JsonProperty("connectionLimit")
    public void setConnectionLimit(Integer connectionLimit) {
        this.connectionLimit = connectionLimit;
    }

    /**
     * Max item size of Memcached (default: 1m, min: 1k, max: 1024m).
     */
    @JsonProperty("maxItemSize")
    public String getMaxItemSize() {
        return maxItemSize;
    }

    /**
     * Max item size of Memcached (default: 1m, min: 1k, max: 1024m).
     */
    @JsonProperty("maxItemSize")
    public void setMaxItemSize(String maxItemSize) {
        this.maxItemSize = maxItemSize;
    }

    /**
     * Memory limit of Memcached in megabytes.
     */
    @JsonProperty("memoryLimitMb")
    public Integer getMemoryLimitMb() {
        return memoryLimitMb;
    }

    /**
     * Memory limit of Memcached in megabytes.
     */
    @JsonProperty("memoryLimitMb")
    public void setMemoryLimitMb(Integer memoryLimitMb) {
        this.memoryLimitMb = memoryLimitMb;
    }

    /**
     * Replicas for this component.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Replicas for this component.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * CacheConfig is the spec of memcached.
     */
    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

    /**
     * CacheConfig is the spec of memcached.
     */
    @JsonProperty("resources")
    public void setResources(ResourceRequirements resources) {
        this.resources = resources;
    }

    @JsonIgnore
    public CacheConfigBuilder edit() {
        return new CacheConfigBuilder(this);
    }

    @JsonIgnore
    public CacheConfigBuilder toBuilder() {
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
        if (!(o instanceof CacheConfig)) {
            return false;
        }
        CacheConfig other = (CacheConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$connectionLimit = this.getConnectionLimit();
        Object other$connectionLimit = other.getConnectionLimit();
        if (this$connectionLimit == null ? other$connectionLimit != null : !this$connectionLimit.equals(other$connectionLimit)) {
            return false;
        }
        Object this$maxItemSize = this.getMaxItemSize();
        Object other$maxItemSize = other.getMaxItemSize();
        if (this$maxItemSize == null ? other$maxItemSize != null : !this$maxItemSize.equals(other$maxItemSize)) {
            return false;
        }
        Object this$memoryLimitMb = this.getMemoryLimitMb();
        Object other$memoryLimitMb = other.getMemoryLimitMb();
        if (this$memoryLimitMb == null ? other$memoryLimitMb != null : !this$memoryLimitMb.equals(other$memoryLimitMb)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
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
        return other instanceof CacheConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $connectionLimit = this.getConnectionLimit();
        result = result * prime + ($connectionLimit == null ? 43 : $connectionLimit.hashCode());
        Object $maxItemSize = this.getMaxItemSize();
        result = result * prime + ($maxItemSize == null ? 43 : $maxItemSize.hashCode());
        Object $memoryLimitMb = this.getMemoryLimitMb();
        result = result * prime + ($memoryLimitMb == null ? 43 : $memoryLimitMb.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CacheConfig(" + "connectionLimit=" + this.getConnectionLimit() + ", maxItemSize=" + this.getMaxItemSize() + ", memoryLimitMb=" + this.getMemoryLimitMb() + ", replicas=" + this.getReplicas() + ", resources=" + this.getResources() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
