
package io.fabric8.openclustermanagement.api.model.policy.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Placement reports how and what managed cluster placement resources are attached to the policy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "decisions",
    "placement",
    "placementBinding",
    "placementRule",
    "policySet"
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
public class Placement implements Editable<PlacementBuilder>, KubernetesResource
{

    @JsonProperty("decisions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PlacementDecision> decisions = new ArrayList<>();
    @JsonProperty("placement")
    private String placement;
    @JsonProperty("placementBinding")
    private String placementBinding;
    @JsonProperty("placementRule")
    private String placementRule;
    @JsonProperty("policySet")
    private String policySet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Placement() {
    }

    public Placement(List<PlacementDecision> decisions, String placement, String placementBinding, String placementRule, String policySet) {
        super();
        this.decisions = decisions;
        this.placement = placement;
        this.placementBinding = placementBinding;
        this.placementRule = placementRule;
        this.policySet = policySet;
    }

    /**
     * Decisions is the list of managed clusters returned by the placement resource for this binding.
     */
    @JsonProperty("decisions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PlacementDecision> getDecisions() {
        return decisions;
    }

    /**
     * Decisions is the list of managed clusters returned by the placement resource for this binding.
     */
    @JsonProperty("decisions")
    public void setDecisions(List<PlacementDecision> decisions) {
        this.decisions = decisions;
    }

    /**
     * Placement is the name of the Placement resource, from the cluster.open-cluster-management.io API group, that is bound to the policy.
     */
    @JsonProperty("placement")
    public String getPlacement() {
        return placement;
    }

    /**
     * Placement is the name of the Placement resource, from the cluster.open-cluster-management.io API group, that is bound to the policy.
     */
    @JsonProperty("placement")
    public void setPlacement(String placement) {
        this.placement = placement;
    }

    /**
     * PlacementBinding is the name of the PlacementBinding resource, from the policies.open-cluster-management.io API group, that binds the placement resource to the policy.
     */
    @JsonProperty("placementBinding")
    public String getPlacementBinding() {
        return placementBinding;
    }

    /**
     * PlacementBinding is the name of the PlacementBinding resource, from the policies.open-cluster-management.io API group, that binds the placement resource to the policy.
     */
    @JsonProperty("placementBinding")
    public void setPlacementBinding(String placementBinding) {
        this.placementBinding = placementBinding;
    }

    /**
     * PlacementRule (deprecated) is the name of the PlacementRule resource, from the apps.open-cluster-management.io API group, that is bound to the policy.
     */
    @JsonProperty("placementRule")
    public String getPlacementRule() {
        return placementRule;
    }

    /**
     * PlacementRule (deprecated) is the name of the PlacementRule resource, from the apps.open-cluster-management.io API group, that is bound to the policy.
     */
    @JsonProperty("placementRule")
    public void setPlacementRule(String placementRule) {
        this.placementRule = placementRule;
    }

    /**
     * PolicySet is the name of the policy set containing this policy and bound to the placement. If specified, then for this placement the policy is being propagated through this policy set rather than the policy being bound directly to a placement and propagated individually.
     */
    @JsonProperty("policySet")
    public String getPolicySet() {
        return policySet;
    }

    /**
     * PolicySet is the name of the policy set containing this policy and bound to the placement. If specified, then for this placement the policy is being propagated through this policy set rather than the policy being bound directly to a placement and propagated individually.
     */
    @JsonProperty("policySet")
    public void setPolicySet(String policySet) {
        this.policySet = policySet;
    }

    @JsonIgnore
    public PlacementBuilder edit() {
        return new PlacementBuilder(this);
    }

    @JsonIgnore
    public PlacementBuilder toBuilder() {
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
