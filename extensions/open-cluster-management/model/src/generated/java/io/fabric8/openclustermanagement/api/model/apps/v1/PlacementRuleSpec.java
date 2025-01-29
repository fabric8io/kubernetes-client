
package io.fabric8.openclustermanagement.api.model.apps.v1;

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

/**
 * PlacementRuleSpec defines the desired state of PlacementRule
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clusterConditions",
    "clusterReplicas",
    "clusterSelector",
    "clusters",
    "policies",
    "resourceHint",
    "schedulerName"
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
public class PlacementRuleSpec implements Editable<PlacementRuleSpecBuilder>, KubernetesResource
{

    @JsonProperty("clusterConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterConditionFilter> clusterConditions = new ArrayList<>();
    @JsonProperty("clusterReplicas")
    private Integer clusterReplicas;
    @JsonProperty("clusterSelector")
    private LabelSelector clusterSelector;
    @JsonProperty("clusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GenericClusterReference> clusters = new ArrayList<>();
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ObjectReference> policies = new ArrayList<>();
    @JsonProperty("resourceHint")
    private ResourceHint resourceHint;
    @JsonProperty("schedulerName")
    private String schedulerName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PlacementRuleSpec() {
    }

    public PlacementRuleSpec(List<ClusterConditionFilter> clusterConditions, Integer clusterReplicas, LabelSelector clusterSelector, List<GenericClusterReference> clusters, List<ObjectReference> policies, ResourceHint resourceHint, String schedulerName) {
        super();
        this.clusterConditions = clusterConditions;
        this.clusterReplicas = clusterReplicas;
        this.clusterSelector = clusterSelector;
        this.clusters = clusters;
        this.policies = policies;
        this.resourceHint = resourceHint;
        this.schedulerName = schedulerName;
    }

    /**
     * PlacementRuleSpec defines the desired state of PlacementRule
     */
    @JsonProperty("clusterConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterConditionFilter> getClusterConditions() {
        return clusterConditions;
    }

    /**
     * PlacementRuleSpec defines the desired state of PlacementRule
     */
    @JsonProperty("clusterConditions")
    public void setClusterConditions(List<ClusterConditionFilter> clusterConditions) {
        this.clusterConditions = clusterConditions;
    }

    /**
     * number of replicas Application wants to
     */
    @JsonProperty("clusterReplicas")
    public Integer getClusterReplicas() {
        return clusterReplicas;
    }

    /**
     * number of replicas Application wants to
     */
    @JsonProperty("clusterReplicas")
    public void setClusterReplicas(Integer clusterReplicas) {
        this.clusterReplicas = clusterReplicas;
    }

    /**
     * PlacementRuleSpec defines the desired state of PlacementRule
     */
    @JsonProperty("clusterSelector")
    public LabelSelector getClusterSelector() {
        return clusterSelector;
    }

    /**
     * PlacementRuleSpec defines the desired state of PlacementRule
     */
    @JsonProperty("clusterSelector")
    public void setClusterSelector(LabelSelector clusterSelector) {
        this.clusterSelector = clusterSelector;
    }

    /**
     * PlacementRuleSpec defines the desired state of PlacementRule
     */
    @JsonProperty("clusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GenericClusterReference> getClusters() {
        return clusters;
    }

    /**
     * PlacementRuleSpec defines the desired state of PlacementRule
     */
    @JsonProperty("clusters")
    public void setClusters(List<GenericClusterReference> clusters) {
        this.clusters = clusters;
    }

    /**
     * Set Policy Filters
     */
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getPolicies() {
        return policies;
    }

    /**
     * Set Policy Filters
     */
    @JsonProperty("policies")
    public void setPolicies(List<ObjectReference> policies) {
        this.policies = policies;
    }

    /**
     * PlacementRuleSpec defines the desired state of PlacementRule
     */
    @JsonProperty("resourceHint")
    public ResourceHint getResourceHint() {
        return resourceHint;
    }

    /**
     * PlacementRuleSpec defines the desired state of PlacementRule
     */
    @JsonProperty("resourceHint")
    public void setResourceHint(ResourceHint resourceHint) {
        this.resourceHint = resourceHint;
    }

    /**
     * INSERT ADDITIONAL SPEC FIELDS - desired state of cluster Important: Run "make" to regenerate code after modifying this file schedulerName, default to use mcm controller
     */
    @JsonProperty("schedulerName")
    public String getSchedulerName() {
        return schedulerName;
    }

    /**
     * INSERT ADDITIONAL SPEC FIELDS - desired state of cluster Important: Run "make" to regenerate code after modifying this file schedulerName, default to use mcm controller
     */
    @JsonProperty("schedulerName")
    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    @JsonIgnore
    public PlacementRuleSpecBuilder edit() {
        return new PlacementRuleSpecBuilder(this);
    }

    @JsonIgnore
    public PlacementRuleSpecBuilder toBuilder() {
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
