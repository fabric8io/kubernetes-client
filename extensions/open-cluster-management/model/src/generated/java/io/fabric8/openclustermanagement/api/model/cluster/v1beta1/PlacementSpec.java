
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
 * PlacementSpec defines the attributes of Placement. An empty PlacementSpec selects all ManagedClusters from the ManagedClusterSets bound to the placement namespace. The containing fields are ANDed.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterSets",
    "decisionStrategy",
    "numberOfClusters",
    "predicates",
    "prioritizerPolicy",
    "scoreRateLimit",
    "sortBy",
    "spreadPolicy",
    "tolerations"
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
public class PlacementSpec implements Editable<PlacementSpecBuilder>, KubernetesResource
{

    @JsonProperty("clusterSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> clusterSets = new ArrayList<>();
    @JsonProperty("decisionStrategy")
    private DecisionStrategy decisionStrategy;
    @JsonProperty("numberOfClusters")
    private Integer numberOfClusters;
    @JsonProperty("predicates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterPredicate> predicates = new ArrayList<>();
    @JsonProperty("prioritizerPolicy")
    private PrioritizerPolicy prioritizerPolicy;
    @JsonProperty("scoreRateLimit")
    private String scoreRateLimit;
    @JsonProperty("sortBy")
    private String sortBy;
    @JsonProperty("spreadPolicy")
    private SpreadPolicy spreadPolicy;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PlacementSpec() {
    }

    public PlacementSpec(List<String> clusterSets, DecisionStrategy decisionStrategy, Integer numberOfClusters, List<ClusterPredicate> predicates, PrioritizerPolicy prioritizerPolicy, String scoreRateLimit, String sortBy, SpreadPolicy spreadPolicy, List<Toleration> tolerations) {
        super();
        this.clusterSets = clusterSets;
        this.decisionStrategy = decisionStrategy;
        this.numberOfClusters = numberOfClusters;
        this.predicates = predicates;
        this.prioritizerPolicy = prioritizerPolicy;
        this.scoreRateLimit = scoreRateLimit;
        this.sortBy = sortBy;
        this.spreadPolicy = spreadPolicy;
        this.tolerations = tolerations;
    }

    /**
     * clusterSets represent the ManagedClusterSets from which the ManagedClusters are selected. If the slice is empty, ManagedClusters will be selected from the ManagedClusterSets bound to the placement namespace, otherwise ManagedClusters will be selected from the intersection of this slice and the ManagedClusterSets bound to the placement namespace.
     */
    @JsonProperty("clusterSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getClusterSets() {
        return clusterSets;
    }

    /**
     * clusterSets represent the ManagedClusterSets from which the ManagedClusters are selected. If the slice is empty, ManagedClusters will be selected from the ManagedClusterSets bound to the placement namespace, otherwise ManagedClusters will be selected from the intersection of this slice and the ManagedClusterSets bound to the placement namespace.
     */
    @JsonProperty("clusterSets")
    public void setClusterSets(List<String> clusterSets) {
        this.clusterSets = clusterSets;
    }

    /**
     * PlacementSpec defines the attributes of Placement. An empty PlacementSpec selects all ManagedClusters from the ManagedClusterSets bound to the placement namespace. The containing fields are ANDed.
     */
    @JsonProperty("decisionStrategy")
    public DecisionStrategy getDecisionStrategy() {
        return decisionStrategy;
    }

    /**
     * PlacementSpec defines the attributes of Placement. An empty PlacementSpec selects all ManagedClusters from the ManagedClusterSets bound to the placement namespace. The containing fields are ANDed.
     */
    @JsonProperty("decisionStrategy")
    public void setDecisionStrategy(DecisionStrategy decisionStrategy) {
        this.decisionStrategy = decisionStrategy;
    }

    /**
     * numberOfClusters represents the desired number of ManagedClusters to be selected which meet the placement requirements. 1) If not specified, all ManagedClusters which meet the placement requirements (including ClusterSets,<br><p>    and Predicates) will be selected;<br><p> 2) Otherwise if the nubmer of ManagedClusters meet the placement requirements is larger than<br><p>    NumberOfClusters, a random subset with desired number of ManagedClusters will be selected;<br><p> 3) If the nubmer of ManagedClusters meet the placement requirements is equal to NumberOfClusters,<br><p>    all of them will be selected;<br><p> 4) If the nubmer of ManagedClusters meet the placement requirements is less than NumberOfClusters,<br><p>    all of them will be selected, and the status of condition `PlacementConditionSatisfied` will be<br><p>    set to false;
     */
    @JsonProperty("numberOfClusters")
    public Integer getNumberOfClusters() {
        return numberOfClusters;
    }

    /**
     * numberOfClusters represents the desired number of ManagedClusters to be selected which meet the placement requirements. 1) If not specified, all ManagedClusters which meet the placement requirements (including ClusterSets,<br><p>    and Predicates) will be selected;<br><p> 2) Otherwise if the nubmer of ManagedClusters meet the placement requirements is larger than<br><p>    NumberOfClusters, a random subset with desired number of ManagedClusters will be selected;<br><p> 3) If the nubmer of ManagedClusters meet the placement requirements is equal to NumberOfClusters,<br><p>    all of them will be selected;<br><p> 4) If the nubmer of ManagedClusters meet the placement requirements is less than NumberOfClusters,<br><p>    all of them will be selected, and the status of condition `PlacementConditionSatisfied` will be<br><p>    set to false;
     */
    @JsonProperty("numberOfClusters")
    public void setNumberOfClusters(Integer numberOfClusters) {
        this.numberOfClusters = numberOfClusters;
    }

    /**
     * predicates represent a slice of predicates to select ManagedClusters. The predicates are ORed.
     */
    @JsonProperty("predicates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterPredicate> getPredicates() {
        return predicates;
    }

    /**
     * predicates represent a slice of predicates to select ManagedClusters. The predicates are ORed.
     */
    @JsonProperty("predicates")
    public void setPredicates(List<ClusterPredicate> predicates) {
        this.predicates = predicates;
    }

    /**
     * PlacementSpec defines the attributes of Placement. An empty PlacementSpec selects all ManagedClusters from the ManagedClusterSets bound to the placement namespace. The containing fields are ANDed.
     */
    @JsonProperty("prioritizerPolicy")
    public PrioritizerPolicy getPrioritizerPolicy() {
        return prioritizerPolicy;
    }

    /**
     * PlacementSpec defines the attributes of Placement. An empty PlacementSpec selects all ManagedClusters from the ManagedClusterSets bound to the placement namespace. The containing fields are ANDed.
     */
    @JsonProperty("prioritizerPolicy")
    public void setPrioritizerPolicy(PrioritizerPolicy prioritizerPolicy) {
        this.prioritizerPolicy = prioritizerPolicy;
    }

    /**
     * ScoreRateLimit sets maximum rate of updates to recorded scores in placement decisions. Score changes that do not change the selected set of clusters in the placement will not be reflected in decisions more often than the given duration.
     */
    @JsonProperty("scoreRateLimit")
    public String getScoreRateLimit() {
        return scoreRateLimit;
    }

    /**
     * ScoreRateLimit sets maximum rate of updates to recorded scores in placement decisions. Score changes that do not change the selected set of clusters in the placement will not be reflected in decisions more often than the given duration.
     */
    @JsonProperty("scoreRateLimit")
    public void setScoreRateLimit(String scoreRateLimit) {
        this.scoreRateLimit = scoreRateLimit;
    }

    /**
     * SortBy sets the sort order for decisions. It can be "ClusterName", or "Score". If sortBy is "ClusterName", decisions will be ordered alphanumerically by cluster name If sortBy is "Score", decisions will be ordered numerically in descending order by score, then by cluster name in the event of a tie
     */
    @JsonProperty("sortBy")
    public String getSortBy() {
        return sortBy;
    }

    /**
     * SortBy sets the sort order for decisions. It can be "ClusterName", or "Score". If sortBy is "ClusterName", decisions will be ordered alphanumerically by cluster name If sortBy is "Score", decisions will be ordered numerically in descending order by score, then by cluster name in the event of a tie
     */
    @JsonProperty("sortBy")
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    /**
     * PlacementSpec defines the attributes of Placement. An empty PlacementSpec selects all ManagedClusters from the ManagedClusterSets bound to the placement namespace. The containing fields are ANDed.
     */
    @JsonProperty("spreadPolicy")
    public SpreadPolicy getSpreadPolicy() {
        return spreadPolicy;
    }

    /**
     * PlacementSpec defines the attributes of Placement. An empty PlacementSpec selects all ManagedClusters from the ManagedClusterSets bound to the placement namespace. The containing fields are ANDed.
     */
    @JsonProperty("spreadPolicy")
    public void setSpreadPolicy(SpreadPolicy spreadPolicy) {
        this.spreadPolicy = spreadPolicy;
    }

    /**
     * tolerations are applied to placements, and allow (but do not require) the managed clusters with certain taints to be selected by placements with matching tolerations.
     */
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    /**
     * tolerations are applied to placements, and allow (but do not require) the managed clusters with certain taints to be selected by placements with matching tolerations.
     */
    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    @JsonIgnore
    public PlacementSpecBuilder edit() {
        return new PlacementSpecBuilder(this);
    }

    @JsonIgnore
    public PlacementSpecBuilder toBuilder() {
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
        if (!(o instanceof PlacementSpec)) {
            return false;
        }
        PlacementSpec other = (PlacementSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterSets = this.getClusterSets();
        Object other$clusterSets = other.getClusterSets();
        if (this$clusterSets == null ? other$clusterSets != null : !this$clusterSets.equals(other$clusterSets)) {
            return false;
        }
        Object this$decisionStrategy = this.getDecisionStrategy();
        Object other$decisionStrategy = other.getDecisionStrategy();
        if (this$decisionStrategy == null ? other$decisionStrategy != null : !this$decisionStrategy.equals(other$decisionStrategy)) {
            return false;
        }
        Object this$numberOfClusters = this.getNumberOfClusters();
        Object other$numberOfClusters = other.getNumberOfClusters();
        if (this$numberOfClusters == null ? other$numberOfClusters != null : !this$numberOfClusters.equals(other$numberOfClusters)) {
            return false;
        }
        Object this$predicates = this.getPredicates();
        Object other$predicates = other.getPredicates();
        if (this$predicates == null ? other$predicates != null : !this$predicates.equals(other$predicates)) {
            return false;
        }
        Object this$prioritizerPolicy = this.getPrioritizerPolicy();
        Object other$prioritizerPolicy = other.getPrioritizerPolicy();
        if (this$prioritizerPolicy == null ? other$prioritizerPolicy != null : !this$prioritizerPolicy.equals(other$prioritizerPolicy)) {
            return false;
        }
        Object this$scoreRateLimit = this.getScoreRateLimit();
        Object other$scoreRateLimit = other.getScoreRateLimit();
        if (this$scoreRateLimit == null ? other$scoreRateLimit != null : !this$scoreRateLimit.equals(other$scoreRateLimit)) {
            return false;
        }
        Object this$sortBy = this.getSortBy();
        Object other$sortBy = other.getSortBy();
        if (this$sortBy == null ? other$sortBy != null : !this$sortBy.equals(other$sortBy)) {
            return false;
        }
        Object this$spreadPolicy = this.getSpreadPolicy();
        Object other$spreadPolicy = other.getSpreadPolicy();
        if (this$spreadPolicy == null ? other$spreadPolicy != null : !this$spreadPolicy.equals(other$spreadPolicy)) {
            return false;
        }
        Object this$tolerations = this.getTolerations();
        Object other$tolerations = other.getTolerations();
        if (this$tolerations == null ? other$tolerations != null : !this$tolerations.equals(other$tolerations)) {
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
        return other instanceof PlacementSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterSets = this.getClusterSets();
        result = result * prime + ($clusterSets == null ? 43 : $clusterSets.hashCode());
        Object $decisionStrategy = this.getDecisionStrategy();
        result = result * prime + ($decisionStrategy == null ? 43 : $decisionStrategy.hashCode());
        Object $numberOfClusters = this.getNumberOfClusters();
        result = result * prime + ($numberOfClusters == null ? 43 : $numberOfClusters.hashCode());
        Object $predicates = this.getPredicates();
        result = result * prime + ($predicates == null ? 43 : $predicates.hashCode());
        Object $prioritizerPolicy = this.getPrioritizerPolicy();
        result = result * prime + ($prioritizerPolicy == null ? 43 : $prioritizerPolicy.hashCode());
        Object $scoreRateLimit = this.getScoreRateLimit();
        result = result * prime + ($scoreRateLimit == null ? 43 : $scoreRateLimit.hashCode());
        Object $sortBy = this.getSortBy();
        result = result * prime + ($sortBy == null ? 43 : $sortBy.hashCode());
        Object $spreadPolicy = this.getSpreadPolicy();
        result = result * prime + ($spreadPolicy == null ? 43 : $spreadPolicy.hashCode());
        Object $tolerations = this.getTolerations();
        result = result * prime + ($tolerations == null ? 43 : $tolerations.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PlacementSpec(" + "clusterSets=" + this.getClusterSets() + ", decisionStrategy=" + this.getDecisionStrategy() + ", numberOfClusters=" + this.getNumberOfClusters() + ", predicates=" + this.getPredicates() + ", prioritizerPolicy=" + this.getPrioritizerPolicy() + ", scoreRateLimit=" + this.getScoreRateLimit() + ", sortBy=" + this.getSortBy() + ", spreadPolicy=" + this.getSpreadPolicy() + ", tolerations=" + this.getTolerations() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
