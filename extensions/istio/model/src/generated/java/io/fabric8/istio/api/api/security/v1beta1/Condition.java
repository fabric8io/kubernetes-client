
package io.fabric8.istio.api.api.security.v1beta1;

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

/**
 * Condition specifies additional required attributes.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "notValues",
    "values"
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
public class Condition implements Editable<ConditionBuilder>, KubernetesResource
{

    @JsonProperty("key")
    private String key;
    @JsonProperty("notValues")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> notValues = new ArrayList<>();
    @JsonProperty("values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> values = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Condition() {
    }

    public Condition(String key, List<String> notValues, List<String> values) {
        super();
        this.key = key;
        this.notValues = notValues;
        this.values = values;
    }

    /**
     * The name of an Istio attribute. See the [full list of supported attributes](https://istio.io/docs/reference/config/security/conditions/).
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * The name of an Istio attribute. See the [full list of supported attributes](https://istio.io/docs/reference/config/security/conditions/).
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Optional. A list of negative match of values for the attribute. Note: at least one of `values` or `notValues` must be set.
     */
    @JsonProperty("notValues")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNotValues() {
        return notValues;
    }

    /**
     * Optional. A list of negative match of values for the attribute. Note: at least one of `values` or `notValues` must be set.
     */
    @JsonProperty("notValues")
    public void setNotValues(List<String> notValues) {
        this.notValues = notValues;
    }

    /**
     * Optional. A list of allowed values for the attribute. Note: at least one of `values` or `notValues` must be set.
     */
    @JsonProperty("values")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getValues() {
        return values;
    }

    /**
     * Optional. A list of allowed values for the attribute. Note: at least one of `values` or `notValues` must be set.
     */
    @JsonProperty("values")
    public void setValues(List<String> values) {
        this.values = values;
    }

    @JsonIgnore
    public ConditionBuilder edit() {
        return new ConditionBuilder(this);
    }

    @JsonIgnore
    public ConditionBuilder toBuilder() {
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
        if (!(o instanceof Condition)) {
            return false;
        }
        Condition other = (Condition) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$key = this.getKey();
        Object other$key = other.getKey();
        if (this$key == null ? other$key != null : !this$key.equals(other$key)) {
            return false;
        }
        Object this$notValues = this.getNotValues();
        Object other$notValues = other.getNotValues();
        if (this$notValues == null ? other$notValues != null : !this$notValues.equals(other$notValues)) {
            return false;
        }
        Object this$values = this.getValues();
        Object other$values = other.getValues();
        if (this$values == null ? other$values != null : !this$values.equals(other$values)) {
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
        return other instanceof Condition;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $key = this.getKey();
        result = result * prime + ($key == null ? 43 : $key.hashCode());
        Object $notValues = this.getNotValues();
        result = result * prime + ($notValues == null ? 43 : $notValues.hashCode());
        Object $values = this.getValues();
        result = result * prime + ($values == null ? 43 : $values.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Condition(" + "key=" + this.getKey() + ", notValues=" + this.getNotValues() + ", values=" + this.getValues() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
