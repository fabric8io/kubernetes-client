
package io.fabric8.openclustermanagement.api.model.multicloudoperatorsplacementrule.apps.v1;

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
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class PlacementRuleSpec implements KubernetesResource
{

    @JsonProperty("clusterConditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterConditionFilter> clusterConditions = new ArrayList<ClusterConditionFilter>();
    @JsonProperty("clusterReplicas")
    private Integer clusterReplicas;
    @JsonProperty("clusterSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector clusterSelector;
    @JsonProperty("clusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GenericClusterReference> clusters = new ArrayList<GenericClusterReference>();
    @JsonProperty("policies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.ObjectReference> policies = new ArrayList<io.fabric8.kubernetes.api.model.ObjectReference>();
    @JsonProperty("resourceHint")
    private ResourceHint resourceHint;
    @JsonProperty("schedulerName")
    private String schedulerName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PlacementRuleSpec() {
    }

    /**
     * 
     * @param clusterReplicas
     * @param clusterConditions
     * @param resourceHint
     * @param clusterSelector
     * @param policies
     * @param schedulerName
     * @param clusters
     */
    public PlacementRuleSpec(List<ClusterConditionFilter> clusterConditions, Integer clusterReplicas, io.fabric8.kubernetes.api.model.LabelSelector clusterSelector, List<GenericClusterReference> clusters, List<io.fabric8.kubernetes.api.model.ObjectReference> policies, ResourceHint resourceHint, String schedulerName) {
        super();
        this.clusterConditions = clusterConditions;
        this.clusterReplicas = clusterReplicas;
        this.clusterSelector = clusterSelector;
        this.clusters = clusters;
        this.policies = policies;
        this.resourceHint = resourceHint;
        this.schedulerName = schedulerName;
    }

    @JsonProperty("clusterConditions")
    public List<ClusterConditionFilter> getClusterConditions() {
        return clusterConditions;
    }

    @JsonProperty("clusterConditions")
    public void setClusterConditions(List<ClusterConditionFilter> clusterConditions) {
        this.clusterConditions = clusterConditions;
    }

    @JsonProperty("clusterReplicas")
    public Integer getClusterReplicas() {
        return clusterReplicas;
    }

    @JsonProperty("clusterReplicas")
    public void setClusterReplicas(Integer clusterReplicas) {
        this.clusterReplicas = clusterReplicas;
    }

    @JsonProperty("clusterSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getClusterSelector() {
        return clusterSelector;
    }

    @JsonProperty("clusterSelector")
    public void setClusterSelector(io.fabric8.kubernetes.api.model.LabelSelector clusterSelector) {
        this.clusterSelector = clusterSelector;
    }

    @JsonProperty("clusters")
    public List<GenericClusterReference> getClusters() {
        return clusters;
    }

    @JsonProperty("clusters")
    public void setClusters(List<GenericClusterReference> clusters) {
        this.clusters = clusters;
    }

    @JsonProperty("policies")
    public List<io.fabric8.kubernetes.api.model.ObjectReference> getPolicies() {
        return policies;
    }

    @JsonProperty("policies")
    public void setPolicies(List<io.fabric8.kubernetes.api.model.ObjectReference> policies) {
        this.policies = policies;
    }

    @JsonProperty("resourceHint")
    public ResourceHint getResourceHint() {
        return resourceHint;
    }

    @JsonProperty("resourceHint")
    public void setResourceHint(ResourceHint resourceHint) {
        this.resourceHint = resourceHint;
    }

    @JsonProperty("schedulerName")
    public String getSchedulerName() {
        return schedulerName;
    }

    @JsonProperty("schedulerName")
    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
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
