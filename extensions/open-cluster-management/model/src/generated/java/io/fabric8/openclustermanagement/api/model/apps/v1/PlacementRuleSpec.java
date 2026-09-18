
package io.fabric8.openclustermanagement.api.model.apps.v1;

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
        if (!(o instanceof PlacementRuleSpec)) {
            return false;
        }
        PlacementRuleSpec other = (PlacementRuleSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clusterConditions = this.getClusterConditions();
        Object other$clusterConditions = other.getClusterConditions();
        if (this$clusterConditions == null ? other$clusterConditions != null : !this$clusterConditions.equals(other$clusterConditions)) {
            return false;
        }
        Object this$clusterReplicas = this.getClusterReplicas();
        Object other$clusterReplicas = other.getClusterReplicas();
        if (this$clusterReplicas == null ? other$clusterReplicas != null : !this$clusterReplicas.equals(other$clusterReplicas)) {
            return false;
        }
        Object this$clusterSelector = this.getClusterSelector();
        Object other$clusterSelector = other.getClusterSelector();
        if (this$clusterSelector == null ? other$clusterSelector != null : !this$clusterSelector.equals(other$clusterSelector)) {
            return false;
        }
        Object this$clusters = this.getClusters();
        Object other$clusters = other.getClusters();
        if (this$clusters == null ? other$clusters != null : !this$clusters.equals(other$clusters)) {
            return false;
        }
        Object this$policies = this.getPolicies();
        Object other$policies = other.getPolicies();
        if (this$policies == null ? other$policies != null : !this$policies.equals(other$policies)) {
            return false;
        }
        Object this$resourceHint = this.getResourceHint();
        Object other$resourceHint = other.getResourceHint();
        if (this$resourceHint == null ? other$resourceHint != null : !this$resourceHint.equals(other$resourceHint)) {
            return false;
        }
        Object this$schedulerName = this.getSchedulerName();
        Object other$schedulerName = other.getSchedulerName();
        if (this$schedulerName == null ? other$schedulerName != null : !this$schedulerName.equals(other$schedulerName)) {
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
        return other instanceof PlacementRuleSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clusterConditions = this.getClusterConditions();
        result = result * prime + ($clusterConditions == null ? 43 : $clusterConditions.hashCode());
        Object $clusterReplicas = this.getClusterReplicas();
        result = result * prime + ($clusterReplicas == null ? 43 : $clusterReplicas.hashCode());
        Object $clusterSelector = this.getClusterSelector();
        result = result * prime + ($clusterSelector == null ? 43 : $clusterSelector.hashCode());
        Object $clusters = this.getClusters();
        result = result * prime + ($clusters == null ? 43 : $clusters.hashCode());
        Object $policies = this.getPolicies();
        result = result * prime + ($policies == null ? 43 : $policies.hashCode());
        Object $resourceHint = this.getResourceHint();
        result = result * prime + ($resourceHint == null ? 43 : $resourceHint.hashCode());
        Object $schedulerName = this.getSchedulerName();
        result = result * prime + ($schedulerName == null ? 43 : $schedulerName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PlacementRuleSpec(" + "clusterConditions=" + this.getClusterConditions() + ", clusterReplicas=" + this.getClusterReplicas() + ", clusterSelector=" + this.getClusterSelector() + ", clusters=" + this.getClusters() + ", policies=" + this.getPolicies() + ", resourceHint=" + this.getResourceHint() + ", schedulerName=" + this.getSchedulerName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
