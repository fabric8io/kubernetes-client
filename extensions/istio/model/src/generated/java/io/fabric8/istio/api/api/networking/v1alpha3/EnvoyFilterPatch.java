
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
 * Patch specifies how the selected object should be modified.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "filterClass",
    "operation",
    "value"
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
public class EnvoyFilterPatch implements Editable<EnvoyFilterPatchBuilder>, KubernetesResource
{

    @JsonProperty("filterClass")
    private EnvoyFilterPatchFilterClass filterClass;
    @JsonProperty("operation")
    private EnvoyFilterPatchOperation operation;
    @JsonProperty("value")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EnvoyFilterPatch() {
    }

    public EnvoyFilterPatch(EnvoyFilterPatchFilterClass filterClass, EnvoyFilterPatchOperation operation, Object value) {
        super();
        this.filterClass = filterClass;
        this.operation = operation;
        this.value = value;
    }

    /**
     * Patch specifies how the selected object should be modified.
     */
    @JsonProperty("filterClass")
    public EnvoyFilterPatchFilterClass getFilterClass() {
        return filterClass;
    }

    /**
     * Patch specifies how the selected object should be modified.
     */
    @JsonProperty("filterClass")
    public void setFilterClass(EnvoyFilterPatchFilterClass filterClass) {
        this.filterClass = filterClass;
    }

    /**
     * Patch specifies how the selected object should be modified.
     */
    @JsonProperty("operation")
    public EnvoyFilterPatchOperation getOperation() {
        return operation;
    }

    /**
     * Patch specifies how the selected object should be modified.
     */
    @JsonProperty("operation")
    public void setOperation(EnvoyFilterPatchOperation operation) {
        this.operation = operation;
    }

    /**
     * Patch specifies how the selected object should be modified.
     */
    @JsonProperty("value")
    public Object getValue() {
        return value;
    }

    /**
     * Patch specifies how the selected object should be modified.
     */
    @JsonProperty("value")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setValue(Object value) {
        this.value = value;
    }

    @JsonIgnore
    public EnvoyFilterPatchBuilder edit() {
        return new EnvoyFilterPatchBuilder(this);
    }

    @JsonIgnore
    public EnvoyFilterPatchBuilder toBuilder() {
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
        if (!(o instanceof EnvoyFilterPatch)) {
            return false;
        }
        EnvoyFilterPatch other = (EnvoyFilterPatch) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$filterClass = this.getFilterClass();
        Object other$filterClass = other.getFilterClass();
        if (this$filterClass == null ? other$filterClass != null : !this$filterClass.equals(other$filterClass)) {
            return false;
        }
        Object this$operation = this.getOperation();
        Object other$operation = other.getOperation();
        if (this$operation == null ? other$operation != null : !this$operation.equals(other$operation)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
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
        return other instanceof EnvoyFilterPatch;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $filterClass = this.getFilterClass();
        result = result * prime + ($filterClass == null ? 43 : $filterClass.hashCode());
        Object $operation = this.getOperation();
        result = result * prime + ($operation == null ? 43 : $operation.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EnvoyFilterPatch(" + "filterClass=" + this.getFilterClass() + ", operation=" + this.getOperation() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
