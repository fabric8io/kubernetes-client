
package io.fabric8.kubernetes.api.model.autoscaling.v2;

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
 * HPAScalingPolicy is a single policy which must hold true for a specified past interval.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "periodSeconds",
    "type",
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
public class HPAScalingPolicy implements Editable<HPAScalingPolicyBuilder>, KubernetesResource
{

    @JsonProperty("periodSeconds")
    private Integer periodSeconds;
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private Integer value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HPAScalingPolicy() {
    }

    public HPAScalingPolicy(Integer periodSeconds, String type, Integer value) {
        super();
        this.periodSeconds = periodSeconds;
        this.type = type;
        this.value = value;
    }

    /**
     * periodSeconds specifies the window of time for which the policy should hold true. PeriodSeconds must be greater than zero and less than or equal to 1800 (30 min).
     */
    @JsonProperty("periodSeconds")
    public Integer getPeriodSeconds() {
        return periodSeconds;
    }

    /**
     * periodSeconds specifies the window of time for which the policy should hold true. PeriodSeconds must be greater than zero and less than or equal to 1800 (30 min).
     */
    @JsonProperty("periodSeconds")
    public void setPeriodSeconds(Integer periodSeconds) {
        this.periodSeconds = periodSeconds;
    }

    /**
     * type is used to specify the scaling policy.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is used to specify the scaling policy.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * value contains the amount of change which is permitted by the policy. It must be greater than zero
     */
    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    /**
     * value contains the amount of change which is permitted by the policy. It must be greater than zero
     */
    @JsonProperty("value")
    public void setValue(Integer value) {
        this.value = value;
    }

    @JsonIgnore
    public HPAScalingPolicyBuilder edit() {
        return new HPAScalingPolicyBuilder(this);
    }

    @JsonIgnore
    public HPAScalingPolicyBuilder toBuilder() {
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
        if (!(o instanceof HPAScalingPolicy)) {
            return false;
        }
        HPAScalingPolicy other = (HPAScalingPolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$periodSeconds = this.getPeriodSeconds();
        Object other$periodSeconds = other.getPeriodSeconds();
        if (this$periodSeconds == null ? other$periodSeconds != null : !this$periodSeconds.equals(other$periodSeconds)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof HPAScalingPolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $periodSeconds = this.getPeriodSeconds();
        result = result * prime + ($periodSeconds == null ? 43 : $periodSeconds.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HPAScalingPolicy(" + "periodSeconds=" + this.getPeriodSeconds() + ", type=" + this.getType() + ", value=" + this.getValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
