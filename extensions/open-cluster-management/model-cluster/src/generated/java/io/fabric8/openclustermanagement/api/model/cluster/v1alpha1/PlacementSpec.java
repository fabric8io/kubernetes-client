
package io.fabric8.openclustermanagement.api.model.cluster.v1alpha1;

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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "clusterSets",
    "numberOfClusters",
    "predicates",
    "prioritizerPolicy"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class PlacementSpec implements KubernetesResource
{

    @JsonProperty("clusterSets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> clusterSets = new ArrayList<String>();
    @JsonProperty("numberOfClusters")
    private Integer numberOfClusters;
    @JsonProperty("predicates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterPredicate> predicates = new ArrayList<ClusterPredicate>();
    @JsonProperty("prioritizerPolicy")
    private PrioritizerPolicy prioritizerPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlacementSpec() {
    }

    /**
     * 
     * @param numberOfClusters
     * @param predicates
     * @param prioritizerPolicy
     * @param clusterSets
     */
    public PlacementSpec(List<String> clusterSets, Integer numberOfClusters, List<ClusterPredicate> predicates, PrioritizerPolicy prioritizerPolicy) {
        super();
        this.clusterSets = clusterSets;
        this.numberOfClusters = numberOfClusters;
        this.predicates = predicates;
        this.prioritizerPolicy = prioritizerPolicy;
    }

    @JsonProperty("clusterSets")
    public List<String> getClusterSets() {
        return clusterSets;
    }

    @JsonProperty("clusterSets")
    public void setClusterSets(List<String> clusterSets) {
        this.clusterSets = clusterSets;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
