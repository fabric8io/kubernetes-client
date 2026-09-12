
package io.fabric8.openshift.api.model.operator.imageregistry.v1;

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
 * ImageRegistryConfigRequestsLimits holds configuration on the max, enqueued and waiting registry's API requests.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxInQueue",
    "maxRunning",
    "maxWaitInQueue"
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
public class ImageRegistryConfigRequestsLimits implements Editable<ImageRegistryConfigRequestsLimitsBuilder>, KubernetesResource
{

    @JsonProperty("maxInQueue")
    private Integer maxInQueue;
    @JsonProperty("maxRunning")
    private Integer maxRunning;
    @JsonProperty("maxWaitInQueue")
    private String maxWaitInQueue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ImageRegistryConfigRequestsLimits() {
    }

    public ImageRegistryConfigRequestsLimits(Integer maxInQueue, Integer maxRunning, String maxWaitInQueue) {
        super();
        this.maxInQueue = maxInQueue;
        this.maxRunning = maxRunning;
        this.maxWaitInQueue = maxWaitInQueue;
    }

    /**
     * maxInQueue sets the maximum queued api requests to the registry.
     */
    @JsonProperty("maxInQueue")
    public Integer getMaxInQueue() {
        return maxInQueue;
    }

    /**
     * maxInQueue sets the maximum queued api requests to the registry.
     */
    @JsonProperty("maxInQueue")
    public void setMaxInQueue(Integer maxInQueue) {
        this.maxInQueue = maxInQueue;
    }

    /**
     * maxRunning sets the maximum in flight api requests to the registry.
     */
    @JsonProperty("maxRunning")
    public Integer getMaxRunning() {
        return maxRunning;
    }

    /**
     * maxRunning sets the maximum in flight api requests to the registry.
     */
    @JsonProperty("maxRunning")
    public void setMaxRunning(Integer maxRunning) {
        this.maxRunning = maxRunning;
    }

    /**
     * ImageRegistryConfigRequestsLimits holds configuration on the max, enqueued and waiting registry's API requests.
     */
    @JsonProperty("maxWaitInQueue")
    public String getMaxWaitInQueue() {
        return maxWaitInQueue;
    }

    /**
     * ImageRegistryConfigRequestsLimits holds configuration on the max, enqueued and waiting registry's API requests.
     */
    @JsonProperty("maxWaitInQueue")
    public void setMaxWaitInQueue(String maxWaitInQueue) {
        this.maxWaitInQueue = maxWaitInQueue;
    }

    @JsonIgnore
    public ImageRegistryConfigRequestsLimitsBuilder edit() {
        return new ImageRegistryConfigRequestsLimitsBuilder(this);
    }

    @JsonIgnore
    public ImageRegistryConfigRequestsLimitsBuilder toBuilder() {
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
        if (!(o instanceof ImageRegistryConfigRequestsLimits)) {
            return false;
        }
        ImageRegistryConfigRequestsLimits other = (ImageRegistryConfigRequestsLimits) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$maxInQueue = this.getMaxInQueue();
        Object other$maxInQueue = other.getMaxInQueue();
        if (this$maxInQueue == null ? other$maxInQueue != null : !this$maxInQueue.equals(other$maxInQueue)) {
            return false;
        }
        Object this$maxRunning = this.getMaxRunning();
        Object other$maxRunning = other.getMaxRunning();
        if (this$maxRunning == null ? other$maxRunning != null : !this$maxRunning.equals(other$maxRunning)) {
            return false;
        }
        Object this$maxWaitInQueue = this.getMaxWaitInQueue();
        Object other$maxWaitInQueue = other.getMaxWaitInQueue();
        if (this$maxWaitInQueue == null ? other$maxWaitInQueue != null : !this$maxWaitInQueue.equals(other$maxWaitInQueue)) {
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
        return other instanceof ImageRegistryConfigRequestsLimits;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $maxInQueue = this.getMaxInQueue();
        result = result * prime + ($maxInQueue == null ? 43 : $maxInQueue.hashCode());
        Object $maxRunning = this.getMaxRunning();
        result = result * prime + ($maxRunning == null ? 43 : $maxRunning.hashCode());
        Object $maxWaitInQueue = this.getMaxWaitInQueue();
        result = result * prime + ($maxWaitInQueue == null ? 43 : $maxWaitInQueue.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ImageRegistryConfigRequestsLimits(" + "maxInQueue=" + this.getMaxInQueue() + ", maxRunning=" + this.getMaxRunning() + ", maxWaitInQueue=" + this.getMaxWaitInQueue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
