
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Present decision groups status based on the DecisionStrategy definition.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterCount",
    "decisionGroupIndex",
    "decisionGroupName",
    "decisions"
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
public class DecisionGroupStatus implements Editable<DecisionGroupStatusBuilder>, KubernetesResource
{

    @JsonProperty("clusterCount")
    private Integer clusterCount;
    @JsonProperty("decisionGroupIndex")
    private Integer decisionGroupIndex;
    @JsonProperty("decisionGroupName")
    private String decisionGroupName;
    @JsonProperty("decisions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> decisions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DecisionGroupStatus() {
    }

    public DecisionGroupStatus(Integer clusterCount, Integer decisionGroupIndex, String decisionGroupName, List<String> decisions) {
        super();
        this.clusterCount = clusterCount;
        this.decisionGroupIndex = decisionGroupIndex;
        this.decisionGroupName = decisionGroupName;
        this.decisions = decisions;
    }

    /**
     * Total number of clusters in the decision group. Clusters count is equal or less than the clusterPerDecisionGroups defined in the decision strategy.
     */
    @JsonProperty("clusterCount")
    public Integer getClusterCount() {
        return clusterCount;
    }

    /**
     * Total number of clusters in the decision group. Clusters count is equal or less than the clusterPerDecisionGroups defined in the decision strategy.
     */
    @JsonProperty("clusterCount")
    public void setClusterCount(Integer clusterCount) {
        this.clusterCount = clusterCount;
    }

    /**
     * Present the decision group index. If there is no decision strategy defined all placement decisions will be in group index 0
     */
    @JsonProperty("decisionGroupIndex")
    public Integer getDecisionGroupIndex() {
        return decisionGroupIndex;
    }

    /**
     * Present the decision group index. If there is no decision strategy defined all placement decisions will be in group index 0
     */
    @JsonProperty("decisionGroupIndex")
    public void setDecisionGroupIndex(Integer decisionGroupIndex) {
        this.decisionGroupIndex = decisionGroupIndex;
    }

    /**
     * Decision group name that is defined in the DecisionStrategy's DecisionGroup.
     */
    @JsonProperty("decisionGroupName")
    public String getDecisionGroupName() {
        return decisionGroupName;
    }

    /**
     * Decision group name that is defined in the DecisionStrategy's DecisionGroup.
     */
    @JsonProperty("decisionGroupName")
    public void setDecisionGroupName(String decisionGroupName) {
        this.decisionGroupName = decisionGroupName;
    }

    /**
     * List of placement decisions names associated with the decision group
     */
    @JsonProperty("decisions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getDecisions() {
        return decisions;
    }

    /**
     * List of placement decisions names associated with the decision group
     */
    @JsonProperty("decisions")
    public void setDecisions(List<String> decisions) {
        this.decisions = decisions;
    }

    @JsonIgnore
    public DecisionGroupStatusBuilder edit() {
        return new DecisionGroupStatusBuilder(this);
    }

    @JsonIgnore
    public DecisionGroupStatusBuilder toBuilder() {
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
