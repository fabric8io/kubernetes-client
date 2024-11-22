
package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "connectionLimit",
    "maxItemSize",
    "memoryLimitMb",
    "replicas",
    "resources"
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
public class CacheConfig implements Editable<CacheConfigBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("connectionLimit")
    public Integer getConnectionLimit() {
        return connectionLimit;
    }

    @JsonProperty("connectionLimit")
    public void setConnectionLimit(Integer connectionLimit) {
        this.connectionLimit = connectionLimit;
    }

    @JsonProperty("maxItemSize")
    public String getMaxItemSize() {
        return maxItemSize;
    }

    @JsonProperty("maxItemSize")
    public void setMaxItemSize(String maxItemSize) {
        this.maxItemSize = maxItemSize;
    }

    @JsonProperty("memoryLimitMb")
    public Integer getMemoryLimitMb() {
        return memoryLimitMb;
    }

    @JsonProperty("memoryLimitMb")
    public void setMemoryLimitMb(Integer memoryLimitMb) {
        this.memoryLimitMb = memoryLimitMb;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("resources")
    public ResourceRequirements getResources() {
        return resources;
    }

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
