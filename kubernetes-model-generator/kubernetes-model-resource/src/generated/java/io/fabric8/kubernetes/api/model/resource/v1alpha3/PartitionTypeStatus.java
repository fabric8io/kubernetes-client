
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PartitionTypeStatus)) {
            return false;
        }
        PartitionTypeStatus other = (PartitionTypeStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allocatable = this.getAllocatable();
        Object other$allocatable = other.getAllocatable();
        if (this$allocatable == null ? other$allocatable != null : !this$allocatable.equals(other$allocatable)) {
            return false;
        }
        Object this$attribute = this.getAttribute();
        Object other$attribute = other.getAttribute();
        if (this$attribute == null ? other$attribute != null : !this$attribute.equals(other$attribute)) {
            return false;
        }
        Object this$total = this.getTotal();
        Object other$total = other.getTotal();
        if (this$total == null ? other$total != null : !this$total.equals(other$total)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof PartitionTypeStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allocatable = this.getAllocatable();
        result = result * prime + ($allocatable == null ? 43 : $allocatable.hashCode());
        Object $attribute = this.getAttribute();
        result = result * prime + ($attribute == null ? 43 : $attribute.hashCode());
        Object $total = this.getTotal();
        result = result * prime + ($total == null ? 43 : $total.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PartitionTypeStatus(" + "allocatable=" + this.getAllocatable() + ", attribute=" + this.getAttribute() + ", total=" + this.getTotal() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
