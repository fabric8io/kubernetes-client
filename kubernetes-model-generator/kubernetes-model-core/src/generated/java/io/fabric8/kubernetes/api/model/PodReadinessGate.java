
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

/**
 * PodReadinessGate contains the reference to a pod condition
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditionType"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PodReadinessGate implements Editable<PodReadinessGateBuilder>, KubernetesResource
{

    @JsonProperty("conditionType")
    private String conditionType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodReadinessGate() {
    }

    public PodReadinessGate(String conditionType) {
        super();
        this.conditionType = conditionType;
    }

    /**
     * ConditionType refers to a condition in the pod's condition list with matching type.
     */
    @JsonProperty("conditionType")
    public String getConditionType() {
        return conditionType;
    }

    /**
     * ConditionType refers to a condition in the pod's condition list with matching type.
     */
    @JsonProperty("conditionType")
    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    @JsonIgnore
    public PodReadinessGateBuilder edit() {
        return new PodReadinessGateBuilder(this);
    }

    @JsonIgnore
    public PodReadinessGateBuilder toBuilder() {
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
        if (!(o instanceof PodReadinessGate)) {
            return false;
        }
        PodReadinessGate other = (PodReadinessGate) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditionType = this.getConditionType();
        Object other$conditionType = other.getConditionType();
        if (this$conditionType == null ? other$conditionType != null : !this$conditionType.equals(other$conditionType)) {
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
        return other instanceof PodReadinessGate;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditionType = this.getConditionType();
        result = result * prime + ($conditionType == null ? 43 : $conditionType.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodReadinessGate(" + "conditionType=" + this.getConditionType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
