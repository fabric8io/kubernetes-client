
package io.fabric8.kubernetes.api.model.autoscaling.v2;

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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * HPAScalingRules configures the scaling behavior for one direction via scaling Policy Rules and a configurable metric tolerance.<br><p> <br><p> Scaling Policy Rules are applied after calculating DesiredReplicas from metrics for the HPA. They can limit the scaling velocity by specifying scaling policies. They can prevent flapping by specifying the stabilization window, so that the number of replicas is not set instantly, instead, the safest value from the stabilization window is chosen.<br><p> <br><p> The tolerance is applied to the metric values and prevents scaling too eagerly for small metric variations. (Note that setting a tolerance requires the beta HPAConfigurableTolerance feature gate to be enabled.)
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "policies",
    "selectPolicy",
    "stabilizationWindowSeconds",
    "tolerance"
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
public class HPAScalingRules implements Editable<HPAScalingRulesBuilder>, KubernetesResource
{

    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HPAScalingPolicy> policies = new ArrayList<>();
    @JsonProperty("selectPolicy")
    private String selectPolicy;
    @JsonProperty("stabilizationWindowSeconds")
    private Integer stabilizationWindowSeconds;
    @JsonProperty("tolerance")
    private Quantity tolerance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HPAScalingRules() {
    }

    public HPAScalingRules(List<HPAScalingPolicy> policies, String selectPolicy, Integer stabilizationWindowSeconds, Quantity tolerance) {
        super();
        this.policies = policies;
        this.selectPolicy = selectPolicy;
        this.stabilizationWindowSeconds = stabilizationWindowSeconds;
        this.tolerance = tolerance;
    }

    /**
     * policies is a list of potential scaling polices which can be used during scaling. If not set, use the default values: - For scale up: allow doubling the number of pods, or an absolute change of 4 pods in a 15s window. - For scale down: allow all pods to be removed in a 15s window.
     */
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<HPAScalingPolicy> getPolicies() {
        return policies;
    }

    /**
     * policies is a list of potential scaling polices which can be used during scaling. If not set, use the default values: - For scale up: allow doubling the number of pods, or an absolute change of 4 pods in a 15s window. - For scale down: allow all pods to be removed in a 15s window.
     */
    @JsonProperty("policies")
    public void setPolicies(List<HPAScalingPolicy> policies) {
        this.policies = policies;
    }

    /**
     * selectPolicy is used to specify which policy should be used. If not set, the default value Max is used.
     */
    @JsonProperty("selectPolicy")
    public String getSelectPolicy() {
        return selectPolicy;
    }

    /**
     * selectPolicy is used to specify which policy should be used. If not set, the default value Max is used.
     */
    @JsonProperty("selectPolicy")
    public void setSelectPolicy(String selectPolicy) {
        this.selectPolicy = selectPolicy;
    }

    /**
     * stabilizationWindowSeconds is the number of seconds for which past recommendations should be considered while scaling up or scaling down. StabilizationWindowSeconds must be greater than or equal to zero and less than or equal to 3600 (one hour). If not set, use the default values: - For scale up: 0 (i.e. no stabilization is done). - For scale down: 300 (i.e. the stabilization window is 300 seconds long).
     */
    @JsonProperty("stabilizationWindowSeconds")
    public Integer getStabilizationWindowSeconds() {
        return stabilizationWindowSeconds;
    }

    /**
     * stabilizationWindowSeconds is the number of seconds for which past recommendations should be considered while scaling up or scaling down. StabilizationWindowSeconds must be greater than or equal to zero and less than or equal to 3600 (one hour). If not set, use the default values: - For scale up: 0 (i.e. no stabilization is done). - For scale down: 300 (i.e. the stabilization window is 300 seconds long).
     */
    @JsonProperty("stabilizationWindowSeconds")
    public void setStabilizationWindowSeconds(Integer stabilizationWindowSeconds) {
        this.stabilizationWindowSeconds = stabilizationWindowSeconds;
    }

    /**
     * HPAScalingRules configures the scaling behavior for one direction via scaling Policy Rules and a configurable metric tolerance.<br><p> <br><p> Scaling Policy Rules are applied after calculating DesiredReplicas from metrics for the HPA. They can limit the scaling velocity by specifying scaling policies. They can prevent flapping by specifying the stabilization window, so that the number of replicas is not set instantly, instead, the safest value from the stabilization window is chosen.<br><p> <br><p> The tolerance is applied to the metric values and prevents scaling too eagerly for small metric variations. (Note that setting a tolerance requires the beta HPAConfigurableTolerance feature gate to be enabled.)
     */
    @JsonProperty("tolerance")
    public Quantity getTolerance() {
        return tolerance;
    }

    /**
     * HPAScalingRules configures the scaling behavior for one direction via scaling Policy Rules and a configurable metric tolerance.<br><p> <br><p> Scaling Policy Rules are applied after calculating DesiredReplicas from metrics for the HPA. They can limit the scaling velocity by specifying scaling policies. They can prevent flapping by specifying the stabilization window, so that the number of replicas is not set instantly, instead, the safest value from the stabilization window is chosen.<br><p> <br><p> The tolerance is applied to the metric values and prevents scaling too eagerly for small metric variations. (Note that setting a tolerance requires the beta HPAConfigurableTolerance feature gate to be enabled.)
     */
    @JsonProperty("tolerance")
    public void setTolerance(Quantity tolerance) {
        this.tolerance = tolerance;
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

}
