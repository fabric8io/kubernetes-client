
package io.fabric8.kubernetes.api.model.resource.v1beta1;

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
 * ResourcePool describes the pool that ResourceSlices belong to.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "generation",
    "name",
    "resourceSliceCount"
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
public class ResourcePool implements Editable<ResourcePoolBuilder>, KubernetesResource
{

    @JsonProperty("generation")
    private Long generation;
    @JsonProperty("name")
    private String name;
    @JsonProperty("resourceSliceCount")
    private Long resourceSliceCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourcePool() {
    }

    public ResourcePool(Long generation, String name, Long resourceSliceCount) {
        super();
        this.generation = generation;
        this.name = name;
        this.resourceSliceCount = resourceSliceCount;
    }

    /**
     * Generation tracks the change in a pool over time. Whenever a driver changes something about one or more of the resources in a pool, it must change the generation in all ResourceSlices which are part of that pool. Consumers of ResourceSlices should only consider resources from the pool with the highest generation number. The generation may be reset by drivers, which should be fine for consumers, assuming that all ResourceSlices in a pool are updated to match or deleted.<br><p> <br><p> Combined with ResourceSliceCount, this mechanism enables consumers to detect pools which are comprised of multiple ResourceSlices and are in an incomplete state.
     */
    @JsonProperty("generation")
    public Long getGeneration() {
        return generation;
    }

    /**
     * Generation tracks the change in a pool over time. Whenever a driver changes something about one or more of the resources in a pool, it must change the generation in all ResourceSlices which are part of that pool. Consumers of ResourceSlices should only consider resources from the pool with the highest generation number. The generation may be reset by drivers, which should be fine for consumers, assuming that all ResourceSlices in a pool are updated to match or deleted.<br><p> <br><p> Combined with ResourceSliceCount, this mechanism enables consumers to detect pools which are comprised of multiple ResourceSlices and are in an incomplete state.
     */
    @JsonProperty("generation")
    public void setGeneration(Long generation) {
        this.generation = generation;
    }

    /**
     * Name is used to identify the pool. For node-local devices, this is often the node name, but this is not required. A field selector can be used to list only ResourceSlice objects belonging to a certain pool.<br><p> <br><p> It must not be longer than 253 characters and must consist of one or more DNS sub-domains separated by slashes. This field is immutable.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is used to identify the pool. For node-local devices, this is often the node name, but this is not required. A field selector can be used to list only ResourceSlice objects belonging to a certain pool.<br><p> <br><p> It must not be longer than 253 characters and must consist of one or more DNS sub-domains separated by slashes. This field is immutable.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ResourceSliceCount is the total number of ResourceSlices in the pool at this generation number. Must be greater than zero.<br><p> <br><p> Consumers can use this to check whether they have seen all ResourceSlices belonging to the same pool.
     */
    @JsonProperty("resourceSliceCount")
    public Long getResourceSliceCount() {
        return resourceSliceCount;
    }

    /**
     * ResourceSliceCount is the total number of ResourceSlices in the pool at this generation number. Must be greater than zero.<br><p> <br><p> Consumers can use this to check whether they have seen all ResourceSlices belonging to the same pool.
     */
    @JsonProperty("resourceSliceCount")
    public void setResourceSliceCount(Long resourceSliceCount) {
        this.resourceSliceCount = resourceSliceCount;
    }

    @JsonIgnore
    public ResourcePoolBuilder edit() {
        return new ResourcePoolBuilder(this);
    }

    @JsonIgnore
    public ResourcePoolBuilder toBuilder() {
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
        if (!(o instanceof ResourcePool)) {
            return false;
        }
        ResourcePool other = (ResourcePool) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$generation = this.getGeneration();
        Object other$generation = other.getGeneration();
        if (this$generation == null ? other$generation != null : !this$generation.equals(other$generation)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$resourceSliceCount = this.getResourceSliceCount();
        Object other$resourceSliceCount = other.getResourceSliceCount();
        if (this$resourceSliceCount == null ? other$resourceSliceCount != null : !this$resourceSliceCount.equals(other$resourceSliceCount)) {
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
        return other instanceof ResourcePool;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $generation = this.getGeneration();
        result = result * prime + ($generation == null ? 43 : $generation.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $resourceSliceCount = this.getResourceSliceCount();
        result = result * prime + ($resourceSliceCount == null ? 43 : $resourceSliceCount.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourcePool(" + "generation=" + this.getGeneration() + ", name=" + this.getName() + ", resourceSliceCount=" + this.getResourceSliceCount() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
