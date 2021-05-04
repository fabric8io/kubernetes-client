
package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "policies",
    "selectPolicy",
    "stabilizationWindowSeconds"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class HPAScalingRules implements KubernetesResource
{

    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HPAScalingPolicy> policies = new ArrayList<HPAScalingPolicy>();
    @JsonProperty("selectPolicy")
    private String selectPolicy;
    @JsonProperty("stabilizationWindowSeconds")
    private Integer stabilizationWindowSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HPAScalingRules() {
    }

    /**
     * 
     * @param selectPolicy
     * @param stabilizationWindowSeconds
     * @param policies
     */
    public HPAScalingRules(List<HPAScalingPolicy> policies, String selectPolicy, Integer stabilizationWindowSeconds) {
        super();
        this.policies = policies;
        this.selectPolicy = selectPolicy;
        this.stabilizationWindowSeconds = stabilizationWindowSeconds;
    }

    @JsonProperty("policies")
    public List<HPAScalingPolicy> getPolicies() {
        return policies;
    }

    @JsonProperty("policies")
    public void setPolicies(List<HPAScalingPolicy> policies) {
        this.policies = policies;
    }

    @JsonProperty("selectPolicy")
    public String getSelectPolicy() {
        return selectPolicy;
    }

    @JsonProperty("selectPolicy")
    public void setSelectPolicy(String selectPolicy) {
        this.selectPolicy = selectPolicy;
    }

    @JsonProperty("stabilizationWindowSeconds")
    public Integer getStabilizationWindowSeconds() {
        return stabilizationWindowSeconds;
    }

    @JsonProperty("stabilizationWindowSeconds")
    public void setStabilizationWindowSeconds(Integer stabilizationWindowSeconds) {
        this.stabilizationWindowSeconds = stabilizationWindowSeconds;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
