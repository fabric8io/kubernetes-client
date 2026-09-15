
package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
import io.fabric8.kubernetes.api.model.Condition;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "decisionGroups",
    "lastScoreUpdateTime",
    "numberOfSelectedClusters"
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
public class PlacementStatus implements Editable<PlacementStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("decisionGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DecisionGroupStatus> decisionGroups = new ArrayList<>();
    @JsonProperty("lastScoreUpdateTime")
    private String lastScoreUpdateTime;
    @JsonProperty("numberOfSelectedClusters")
    private Integer numberOfSelectedClusters;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PlacementStatus() {
    }

    public PlacementStatus(List<Condition> conditions, List<DecisionGroupStatus> decisionGroups, String lastScoreUpdateTime, Integer numberOfSelectedClusters) {
        super();
        this.conditions = conditions;
        this.decisionGroups = decisionGroups;
        this.lastScoreUpdateTime = lastScoreUpdateTime;
        this.numberOfSelectedClusters = numberOfSelectedClusters;
    }

    /**
     * Conditions contains the different condition status for this Placement.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions contains the different condition status for this Placement.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * List of decision groups determined by the placement and DecisionStrategy.
     */
    @JsonProperty("decisionGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DecisionGroupStatus> getDecisionGroups() {
        return decisionGroups;
    }

    /**
     * List of decision groups determined by the placement and DecisionStrategy.
     */
    @JsonProperty("decisionGroups")
    public void setDecisionGroups(List<DecisionGroupStatus> decisionGroups) {
        this.decisionGroups = decisionGroups;
    }

    @JsonProperty("lastScoreUpdateTime")
    public String getLastScoreUpdateTime() {
        return lastScoreUpdateTime;
    }

    @JsonProperty("lastScoreUpdateTime")
    public void setLastScoreUpdateTime(String lastScoreUpdateTime) {
        this.lastScoreUpdateTime = lastScoreUpdateTime;
    }

    /**
     * numberOfSelectedClusters represents the number of selected ManagedClusters
     */
    @JsonProperty("numberOfSelectedClusters")
    public Integer getNumberOfSelectedClusters() {
        return numberOfSelectedClusters;
    }

    /**
     * numberOfSelectedClusters represents the number of selected ManagedClusters
     */
    @JsonProperty("numberOfSelectedClusters")
    public void setNumberOfSelectedClusters(Integer numberOfSelectedClusters) {
        this.numberOfSelectedClusters = numberOfSelectedClusters;
    }

    @JsonIgnore
    public PlacementStatusBuilder edit() {
        return new PlacementStatusBuilder(this);
    }

    @JsonIgnore
    public PlacementStatusBuilder toBuilder() {
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
        if (!(o instanceof PlacementStatus)) {
            return false;
        }
        PlacementStatus other = (PlacementStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$decisionGroups = this.getDecisionGroups();
        Object other$decisionGroups = other.getDecisionGroups();
        if (this$decisionGroups == null ? other$decisionGroups != null : !this$decisionGroups.equals(other$decisionGroups)) {
            return false;
        }
        Object this$lastScoreUpdateTime = this.getLastScoreUpdateTime();
        Object other$lastScoreUpdateTime = other.getLastScoreUpdateTime();
        if (this$lastScoreUpdateTime == null ? other$lastScoreUpdateTime != null : !this$lastScoreUpdateTime.equals(other$lastScoreUpdateTime)) {
            return false;
        }
        Object this$numberOfSelectedClusters = this.getNumberOfSelectedClusters();
        Object other$numberOfSelectedClusters = other.getNumberOfSelectedClusters();
        if (this$numberOfSelectedClusters == null ? other$numberOfSelectedClusters != null : !this$numberOfSelectedClusters.equals(other$numberOfSelectedClusters)) {
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
        return other instanceof PlacementStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $decisionGroups = this.getDecisionGroups();
        result = result * prime + ($decisionGroups == null ? 43 : $decisionGroups.hashCode());
        Object $lastScoreUpdateTime = this.getLastScoreUpdateTime();
        result = result * prime + ($lastScoreUpdateTime == null ? 43 : $lastScoreUpdateTime.hashCode());
        Object $numberOfSelectedClusters = this.getNumberOfSelectedClusters();
        result = result * prime + ($numberOfSelectedClusters == null ? 43 : $numberOfSelectedClusters.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PlacementStatus(" + "conditions=" + this.getConditions() + ", decisionGroups=" + this.getDecisionGroups() + ", lastScoreUpdateTime=" + this.getLastScoreUpdateTime() + ", numberOfSelectedClusters=" + this.getNumberOfSelectedClusters() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
