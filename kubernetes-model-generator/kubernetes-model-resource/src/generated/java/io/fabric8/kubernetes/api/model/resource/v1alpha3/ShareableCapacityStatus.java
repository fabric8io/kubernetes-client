
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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ShareableCapacityStatus reports aggregate amounts for a single shareable capacity key.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "available",
    "consumed",
    "name",
    "total"
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
public class ShareableCapacityStatus implements Editable<ShareableCapacityStatusBuilder>, KubernetesResource
{

    @JsonProperty("available")
    private Quantity available;
    @JsonProperty("consumed")
    private Quantity consumed;
    @JsonProperty("name")
    private String name;
    @JsonProperty("total")
    private Quantity total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ShareableCapacityStatus() {
    }

    public ShareableCapacityStatus(Quantity available, Quantity consumed, String name, Quantity total) {
        super();
        this.available = available;
        this.consumed = consumed;
        this.name = name;
        this.total = total;
    }

    /**
     * ShareableCapacityStatus reports aggregate amounts for a single shareable capacity key.
     */
    @JsonProperty("available")
    public Quantity getAvailable() {
        return available;
    }

    /**
     * ShareableCapacityStatus reports aggregate amounts for a single shareable capacity key.
     */
    @JsonProperty("available")
    public void setAvailable(Quantity available) {
        this.available = available;
    }

    /**
     * ShareableCapacityStatus reports aggregate amounts for a single shareable capacity key.
     */
    @JsonProperty("consumed")
    public Quantity getConsumed() {
        return consumed;
    }

    /**
     * ShareableCapacityStatus reports aggregate amounts for a single shareable capacity key.
     */
    @JsonProperty("consumed")
    public void setConsumed(Quantity consumed) {
        this.consumed = consumed;
    }

    /**
     * Name is the capacity name.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the capacity name.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ShareableCapacityStatus reports aggregate amounts for a single shareable capacity key.
     */
    @JsonProperty("total")
    public Quantity getTotal() {
        return total;
    }

    /**
     * ShareableCapacityStatus reports aggregate amounts for a single shareable capacity key.
     */
    @JsonProperty("total")
    public void setTotal(Quantity total) {
        this.total = total;
    }

    @JsonIgnore
    public ShareableCapacityStatusBuilder edit() {
        return new ShareableCapacityStatusBuilder(this);
    }

    @JsonIgnore
    public ShareableCapacityStatusBuilder toBuilder() {
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
        if (!(o instanceof ShareableCapacityStatus)) {
            return false;
        }
        ShareableCapacityStatus other = (ShareableCapacityStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$available = this.getAvailable();
        Object other$available = other.getAvailable();
        if (this$available == null ? other$available != null : !this$available.equals(other$available)) {
            return false;
        }
        Object this$consumed = this.getConsumed();
        Object other$consumed = other.getConsumed();
        if (this$consumed == null ? other$consumed != null : !this$consumed.equals(other$consumed)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$total = this.getTotal();
        Object other$total = other.getTotal();
        if (this$total == null ? other$total != null : !this$total.equals(other$total)) {
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
        return other instanceof ShareableCapacityStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $available = this.getAvailable();
        result = result * prime + ($available == null ? 43 : $available.hashCode());
        Object $consumed = this.getConsumed();
        result = result * prime + ($consumed == null ? 43 : $consumed.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $total = this.getTotal();
        result = result * prime + ($total == null ? 43 : $total.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ShareableCapacityStatus(" + "available=" + this.getAvailable() + ", consumed=" + this.getConsumed() + ", name=" + this.getName() + ", total=" + this.getTotal() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
