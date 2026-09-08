
package io.fabric8.kubernetes.api.model.resource.v1alpha3;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PartitionTypeStatus reports allocatability for a single partition type, identified by the value of a grouping attribute.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocatable",
    "attribute",
    "total",
    "type"
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
public class PartitionTypeStatus implements Editable<PartitionTypeStatusBuilder>, KubernetesResource
{

    @JsonProperty("allocatable")
    private Integer allocatable;
    @JsonProperty("attribute")
    private String attribute;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PartitionTypeStatus() {
    }

    public PartitionTypeStatus(Integer allocatable, String attribute, Integer total, String type) {
        super();
        this.allocatable = allocatable;
        this.attribute = attribute;
        this.total = total;
        this.type = type;
    }

    /**
     * Allocatable is the number of additional devices of this partition type that could still be allocated given current shared-counter consumption.
     */
    @JsonProperty("allocatable")
    public Integer getAllocatable() {
        return allocatable;
    }

    /**
     * Allocatable is the number of additional devices of this partition type that could still be allocated given current shared-counter consumption.
     */
    @JsonProperty("allocatable")
    public void setAllocatable(Integer allocatable) {
        this.allocatable = allocatable;
    }

    /**
     * Attribute is the fully qualified name of the device attribute whose value groups this entry. It is the PartitionTypeAttribute declared by the devices' own slice, or the default named in the request when their slice declares none.
     */
    @JsonProperty("attribute")
    public String getAttribute() {
        return attribute;
    }

    /**
     * Attribute is the fully qualified name of the device attribute whose value groups this entry. It is the PartitionTypeAttribute declared by the devices' own slice, or the default named in the request when their slice declares none.
     */
    @JsonProperty("attribute")
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    /**
     * Total is the number of devices of this partition type in the pool.
     */
    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    /**
     * Total is the number of devices of this partition type in the pool.
     */
    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * Type is the partition type value (e.g. "Full" or "Half").
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type is the partition type value (e.g. "Full" or "Half").
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public PartitionTypeStatusBuilder edit() {
        return new PartitionTypeStatusBuilder(this);
    }

    @JsonIgnore
    public PartitionTypeStatusBuilder toBuilder() {
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
