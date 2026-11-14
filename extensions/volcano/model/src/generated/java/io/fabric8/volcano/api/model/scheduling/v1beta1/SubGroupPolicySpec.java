
package io.fabric8.volcano.api.model.scheduling.v1beta1;

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
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "labelSelector",
    "matchLabelKeys",
    "minSubGroups",
    "name",
    "networkTopology",
    "subGroupSize"
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
public class SubGroupPolicySpec implements Editable<SubGroupPolicySpecBuilder>, KubernetesResource
{

    @JsonProperty("labelSelector")
    private LabelSelector labelSelector;
    @JsonProperty("matchLabelKeys")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> matchLabelKeys = new ArrayList<>();
    @JsonProperty("minSubGroups")
    private Integer minSubGroups;
    @JsonProperty("name")
    private String name;
    @JsonProperty("networkTopology")
    private NetworkTopologySpec networkTopology;
    @JsonProperty("subGroupSize")
    private Integer subGroupSize;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SubGroupPolicySpec() {
    }

    public SubGroupPolicySpec(LabelSelector labelSelector, List<String> matchLabelKeys, Integer minSubGroups, String name, NetworkTopologySpec networkTopology, Integer subGroupSize) {
        super();
        this.labelSelector = labelSelector;
        this.matchLabelKeys = matchLabelKeys;
        this.minSubGroups = minSubGroups;
        this.name = name;
        this.networkTopology = networkTopology;
        this.subGroupSize = subGroupSize;
    }

    @JsonProperty("labelSelector")
    public LabelSelector getLabelSelector() {
        return labelSelector;
    }

    @JsonProperty("labelSelector")
    public void setLabelSelector(LabelSelector labelSelector) {
        this.labelSelector = labelSelector;
    }

    /**
     * MatchLabelKeys: A label-based grouping configuration field for Pods, defining filtering rules for grouping label keys Core function: Refine grouping of Pods that meet LabelSelector criteria by label attributes, with the following rules and constraints: 1. Scope: Only applies to Pods matching the predefined LabelSelector 2. Grouping rule: Specify one or more label keys; Pods containing the target label keys with exactly the same corresponding label values are grouped together 3. Policy constraint: Pods in the same group follow a unified NetworkTopology policy to achieve group-level network behavior governance
     */
    @JsonProperty("matchLabelKeys")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMatchLabelKeys() {
        return matchLabelKeys;
    }

    /**
     * MatchLabelKeys: A label-based grouping configuration field for Pods, defining filtering rules for grouping label keys Core function: Refine grouping of Pods that meet LabelSelector criteria by label attributes, with the following rules and constraints: 1. Scope: Only applies to Pods matching the predefined LabelSelector 2. Grouping rule: Specify one or more label keys; Pods containing the target label keys with exactly the same corresponding label values are grouped together 3. Policy constraint: Pods in the same group follow a unified NetworkTopology policy to achieve group-level network behavior governance
     */
    @JsonProperty("matchLabelKeys")
    public void setMatchLabelKeys(List<String> matchLabelKeys) {
        this.matchLabelKeys = matchLabelKeys;
    }

    /**
     * MinSubGroups: Minimum number of subgroups required to trigger scheduling. Scheduling is initiated only if cluster resources meet the requirements of at least this number of subgroups. Subgroup-level Gang Scheduling
     */
    @JsonProperty("minSubGroups")
    public Integer getMinSubGroups() {
        return minSubGroups;
    }

    /**
     * MinSubGroups: Minimum number of subgroups required to trigger scheduling. Scheduling is initiated only if cluster resources meet the requirements of at least this number of subgroups. Subgroup-level Gang Scheduling
     */
    @JsonProperty("minSubGroups")
    public void setMinSubGroups(Integer minSubGroups) {
        this.minSubGroups = minSubGroups;
    }

    /**
     * Name specifies the name of SubGroupPolicy
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name specifies the name of SubGroupPolicy
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("networkTopology")
    public NetworkTopologySpec getNetworkTopology() {
        return networkTopology;
    }

    @JsonProperty("networkTopology")
    public void setNetworkTopology(NetworkTopologySpec networkTopology) {
        this.networkTopology = networkTopology;
    }

    /**
     * SubGroupSize defines the number of pods in each sub-affinity group. Only when a subGroup of pods, with a size of "subGroupSize", can satisfy the network topology constraint then will the subGroup be scheduled.
     */
    @JsonProperty("subGroupSize")
    public Integer getSubGroupSize() {
        return subGroupSize;
    }

    /**
     * SubGroupSize defines the number of pods in each sub-affinity group. Only when a subGroup of pods, with a size of "subGroupSize", can satisfy the network topology constraint then will the subGroup be scheduled.
     */
    @JsonProperty("subGroupSize")
    public void setSubGroupSize(Integer subGroupSize) {
        this.subGroupSize = subGroupSize;
    }

    @JsonIgnore
    public SubGroupPolicySpecBuilder edit() {
        return new SubGroupPolicySpecBuilder(this);
    }

    @JsonIgnore
    public SubGroupPolicySpecBuilder toBuilder() {
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
        if (!(o instanceof SubGroupPolicySpec)) {
            return false;
        }
        SubGroupPolicySpec other = (SubGroupPolicySpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$labelSelector = this.getLabelSelector();
        Object other$labelSelector = other.getLabelSelector();
        if (this$labelSelector == null ? other$labelSelector != null : !this$labelSelector.equals(other$labelSelector)) {
            return false;
        }
        Object this$matchLabelKeys = this.getMatchLabelKeys();
        Object other$matchLabelKeys = other.getMatchLabelKeys();
        if (this$matchLabelKeys == null ? other$matchLabelKeys != null : !this$matchLabelKeys.equals(other$matchLabelKeys)) {
            return false;
        }
        Object this$minSubGroups = this.getMinSubGroups();
        Object other$minSubGroups = other.getMinSubGroups();
        if (this$minSubGroups == null ? other$minSubGroups != null : !this$minSubGroups.equals(other$minSubGroups)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$networkTopology = this.getNetworkTopology();
        Object other$networkTopology = other.getNetworkTopology();
        if (this$networkTopology == null ? other$networkTopology != null : !this$networkTopology.equals(other$networkTopology)) {
            return false;
        }
        Object this$subGroupSize = this.getSubGroupSize();
        Object other$subGroupSize = other.getSubGroupSize();
        if (this$subGroupSize == null ? other$subGroupSize != null : !this$subGroupSize.equals(other$subGroupSize)) {
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
        return other instanceof SubGroupPolicySpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $labelSelector = this.getLabelSelector();
        result = result * prime + ($labelSelector == null ? 43 : $labelSelector.hashCode());
        Object $matchLabelKeys = this.getMatchLabelKeys();
        result = result * prime + ($matchLabelKeys == null ? 43 : $matchLabelKeys.hashCode());
        Object $minSubGroups = this.getMinSubGroups();
        result = result * prime + ($minSubGroups == null ? 43 : $minSubGroups.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $networkTopology = this.getNetworkTopology();
        result = result * prime + ($networkTopology == null ? 43 : $networkTopology.hashCode());
        Object $subGroupSize = this.getSubGroupSize();
        result = result * prime + ($subGroupSize == null ? 43 : $subGroupSize.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SubGroupPolicySpec(" + "labelSelector=" + this.getLabelSelector() + ", matchLabelKeys=" + this.getMatchLabelKeys() + ", minSubGroups=" + this.getMinSubGroups() + ", name=" + this.getName() + ", networkTopology=" + this.getNetworkTopology() + ", subGroupSize=" + this.getSubGroupSize() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
