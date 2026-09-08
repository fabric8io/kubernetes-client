
package io.fabric8.kubernetes.api.model.resource.v1alpha3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ShareableSummaryStatus reports aggregate capacity for a pool that contains devices with AllowMultipleAllocations.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "capacity",
    "fullyAvailableDevices",
    "partiallyAvailableDevices"
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
public class ShareableSummaryStatus implements Editable<ShareableSummaryStatusBuilder>, KubernetesResource
{

    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ShareableCapacityStatus> capacity = new ArrayList<>();
    @JsonProperty("fullyAvailableDevices")
    private Integer fullyAvailableDevices;
    @JsonProperty("partiallyAvailableDevices")
    private Integer partiallyAvailableDevices;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ShareableSummaryStatus() {
    }

    public ShareableSummaryStatus(List<ShareableCapacityStatus> capacity, Integer fullyAvailableDevices, Integer partiallyAvailableDevices) {
        super();
        this.capacity = capacity;
        this.fullyAvailableDevices = fullyAvailableDevices;
        this.partiallyAvailableDevices = partiallyAvailableDevices;
    }

    /**
     * Capacity reports aggregate total, consumed, and available amounts per shareable capacity key across the pool.
     */
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ShareableCapacityStatus> getCapacity() {
        return capacity;
    }

    /**
     * Capacity reports aggregate total, consumed, and available amounts per shareable capacity key across the pool.
     */
    @JsonProperty("capacity")
    public void setCapacity(List<ShareableCapacityStatus> capacity) {
        this.capacity = capacity;
    }

    /**
     * FullyAvailableDevices is the number of shareable devices with no capacity consumed.
     */
    @JsonProperty("fullyAvailableDevices")
    public Integer getFullyAvailableDevices() {
        return fullyAvailableDevices;
    }

    /**
     * FullyAvailableDevices is the number of shareable devices with no capacity consumed.
     */
    @JsonProperty("fullyAvailableDevices")
    public void setFullyAvailableDevices(Integer fullyAvailableDevices) {
        this.fullyAvailableDevices = fullyAvailableDevices;
    }

    /**
     * PartiallyAvailableDevices is the number of shareable devices with some but not all capacity consumed.
     */
    @JsonProperty("partiallyAvailableDevices")
    public Integer getPartiallyAvailableDevices() {
        return partiallyAvailableDevices;
    }

    /**
     * PartiallyAvailableDevices is the number of shareable devices with some but not all capacity consumed.
     */
    @JsonProperty("partiallyAvailableDevices")
    public void setPartiallyAvailableDevices(Integer partiallyAvailableDevices) {
        this.partiallyAvailableDevices = partiallyAvailableDevices;
    }

    @JsonIgnore
    public ShareableSummaryStatusBuilder edit() {
        return new ShareableSummaryStatusBuilder(this);
    }

    @JsonIgnore
    public ShareableSummaryStatusBuilder toBuilder() {
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
