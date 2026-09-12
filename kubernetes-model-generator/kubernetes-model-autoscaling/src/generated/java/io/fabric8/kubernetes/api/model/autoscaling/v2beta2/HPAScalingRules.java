
package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

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
 * HPAScalingRules configures the scaling behavior for one direction. These Rules are applied after calculating DesiredReplicas from metrics for the HPA. They can limit the scaling velocity by specifying scaling policies. They can prevent flapping by specifying the stabilization window, so that the number of replicas is not set instantly, instead, the safest value from the stabilization window is chosen.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "policies",
    "selectPolicy",
    "stabilizationWindowSeconds"
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
public class HPAScalingRules implements Editable<HPAScalingRulesBuilder>, KubernetesResource
{

    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HPAScalingPolicy> policies = new ArrayList<>();
    @JsonProperty("selectPolicy")
    private String selectPolicy;
    @JsonProperty("stabilizationWindowSeconds")
    private Integer stabilizationWindowSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HPAScalingRules() {
    }

    public HPAScalingRules(List<HPAScalingPolicy> policies, String selectPolicy, Integer stabilizationWindowSeconds) {
        super();
        this.policies = policies;
        this.selectPolicy = selectPolicy;
        this.stabilizationWindowSeconds = stabilizationWindowSeconds;
    }

    /**
     * policies is a list of potential scaling polices which can be used during scaling. At least one policy must be specified, otherwise the HPAScalingRules will be discarded as invalid
     */
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HPAScalingPolicy> getPolicies() {
        return policies;
    }

    /**
     * policies is a list of potential scaling polices which can be used during scaling. At least one policy must be specified, otherwise the HPAScalingRules will be discarded as invalid
     */
    @JsonProperty("policies")
    public void setPolicies(List<HPAScalingPolicy> policies) {
        this.policies = policies;
    }

    /**
     * selectPolicy is used to specify which policy should be used. If not set, the default value MaxPolicySelect is used.
     */
    @JsonProperty("selectPolicy")
    public String getSelectPolicy() {
        return selectPolicy;
    }

    /**
     * selectPolicy is used to specify which policy should be used. If not set, the default value MaxPolicySelect is used.
     */
    @JsonProperty("selectPolicy")
    public void setSelectPolicy(String selectPolicy) {
        this.selectPolicy = selectPolicy;
    }

    /**
     * StabilizationWindowSeconds is the number of seconds for which past recommendations should be considered while scaling up or scaling down. StabilizationWindowSeconds must be greater than or equal to zero and less than or equal to 3600 (one hour). If not set, use the default values: - For scale up: 0 (i.e. no stabilization is done). - For scale down: 300 (i.e. the stabilization window is 300 seconds long).
     */
    @JsonProperty("stabilizationWindowSeconds")
    public Integer getStabilizationWindowSeconds() {
        return stabilizationWindowSeconds;
    }

    /**
     * StabilizationWindowSeconds is the number of seconds for which past recommendations should be considered while scaling up or scaling down. StabilizationWindowSeconds must be greater than or equal to zero and less than or equal to 3600 (one hour). If not set, use the default values: - For scale up: 0 (i.e. no stabilization is done). - For scale down: 300 (i.e. the stabilization window is 300 seconds long).
     */
    @JsonProperty("stabilizationWindowSeconds")
    public void setStabilizationWindowSeconds(Integer stabilizationWindowSeconds) {
        this.stabilizationWindowSeconds = stabilizationWindowSeconds;
    }

    @JsonIgnore
    public HPAScalingRulesBuilder edit() {
        return new HPAScalingRulesBuilder(this);
    }

    @JsonIgnore
    public HPAScalingRulesBuilder toBuilder() {
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
        if (!(o instanceof HPAScalingRules)) {
            return false;
        }
        HPAScalingRules other = (HPAScalingRules) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$policies = this.getPolicies();
        Object other$policies = other.getPolicies();
        if (this$policies == null ? other$policies != null : !this$policies.equals(other$policies)) {
            return false;
        }
        Object this$selectPolicy = this.getSelectPolicy();
        Object other$selectPolicy = other.getSelectPolicy();
        if (this$selectPolicy == null ? other$selectPolicy != null : !this$selectPolicy.equals(other$selectPolicy)) {
            return false;
        }
        Object this$stabilizationWindowSeconds = this.getStabilizationWindowSeconds();
        Object other$stabilizationWindowSeconds = other.getStabilizationWindowSeconds();
        if (this$stabilizationWindowSeconds == null ? other$stabilizationWindowSeconds != null : !this$stabilizationWindowSeconds.equals(other$stabilizationWindowSeconds)) {
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
        return other instanceof HPAScalingRules;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $policies = this.getPolicies();
        result = result * prime + ($policies == null ? 43 : $policies.hashCode());
        Object $selectPolicy = this.getSelectPolicy();
        result = result * prime + ($selectPolicy == null ? 43 : $selectPolicy.hashCode());
        Object $stabilizationWindowSeconds = this.getStabilizationWindowSeconds();
        result = result * prime + ($stabilizationWindowSeconds == null ? 43 : $stabilizationWindowSeconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HPAScalingRules(" + "policies=" + this.getPolicies() + ", selectPolicy=" + this.getSelectPolicy() + ", stabilizationWindowSeconds=" + this.getStabilizationWindowSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
