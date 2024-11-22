
package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
    "clusterSets",
    "decisionStrategy",
    "numberOfClusters",
    "predicates",
    "prioritizerPolicy",
    "spreadPolicy",
    "tolerations"
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
public class PlacementSpec implements Editable<PlacementSpecBuilder> , KubernetesResource
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
    @JsonProperty("spreadPolicy")
    private SpreadPolicy spreadPolicy;
    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Toleration> tolerations = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlacementSpec() {
    }

    public PlacementSpec(List<String> clusterSets, DecisionStrategy decisionStrategy, Integer numberOfClusters, List<ClusterPredicate> predicates, PrioritizerPolicy prioritizerPolicy, SpreadPolicy spreadPolicy, List<Toleration> tolerations) {
        super();
        this.clusterSets = clusterSets;
        this.decisionStrategy = decisionStrategy;
        this.numberOfClusters = numberOfClusters;
        this.predicates = predicates;
        this.prioritizerPolicy = prioritizerPolicy;
        this.spreadPolicy = spreadPolicy;
        this.tolerations = tolerations;
    }

    @JsonProperty("clusterSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getClusterSets() {
        return clusterSets;
    }

    @JsonProperty("clusterSets")
    public void setClusterSets(List<String> clusterSets) {
        this.clusterSets = clusterSets;
    }

    @JsonProperty("decisionStrategy")
    public DecisionStrategy getDecisionStrategy() {
        return decisionStrategy;
    }

    @JsonProperty("decisionStrategy")
    public void setDecisionStrategy(DecisionStrategy decisionStrategy) {
        this.decisionStrategy = decisionStrategy;
    }

    @JsonProperty("numberOfClusters")
    public Integer getNumberOfClusters() {
        return numberOfClusters;
    }

    @JsonProperty("numberOfClusters")
    public void setNumberOfClusters(Integer numberOfClusters) {
        this.numberOfClusters = numberOfClusters;
    }

    @JsonProperty("predicates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterPredicate> getPredicates() {
        return predicates;
    }

    @JsonProperty("predicates")
    public void setPredicates(List<ClusterPredicate> predicates) {
        this.predicates = predicates;
    }

    @JsonProperty("prioritizerPolicy")
    public PrioritizerPolicy getPrioritizerPolicy() {
        return prioritizerPolicy;
    }

    @JsonProperty("prioritizerPolicy")
    public void setPrioritizerPolicy(PrioritizerPolicy prioritizerPolicy) {
        this.prioritizerPolicy = prioritizerPolicy;
    }

    @JsonProperty("spreadPolicy")
    public SpreadPolicy getSpreadPolicy() {
        return spreadPolicy;
    }

    @JsonProperty("spreadPolicy")
    public void setSpreadPolicy(SpreadPolicy spreadPolicy) {
        this.spreadPolicy = spreadPolicy;
    }

    @JsonProperty("tolerations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Toleration> getTolerations() {
        return tolerations;
    }

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
