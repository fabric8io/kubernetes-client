
package io.fabric8.openclustermanagement.api.model.policy.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
@Generated("jsonschema2pojo")
public class Placement implements Editable<PlacementBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("decisions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PlacementDecision> getDecisions() {
        return decisions;
    }

    @JsonProperty("decisions")
    public void setDecisions(List<PlacementDecision> decisions) {
        this.decisions = decisions;
    }

    @JsonProperty("placement")
    public String getPlacement() {
        return placement;
    }

    @JsonProperty("placement")
    public void setPlacement(String placement) {
        this.placement = placement;
    }

    @JsonProperty("placementBinding")
    public String getPlacementBinding() {
        return placementBinding;
    }

    @JsonProperty("placementBinding")
    public void setPlacementBinding(String placementBinding) {
        this.placementBinding = placementBinding;
    }

    @JsonProperty("placementRule")
    public String getPlacementRule() {
        return placementRule;
    }

    @JsonProperty("placementRule")
    public void setPlacementRule(String placementRule) {
        this.placementRule = placementRule;
    }

    @JsonProperty("policySet")
    public String getPolicySet() {
        return policySet;
    }

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