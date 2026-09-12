
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PrometheusStatus is the most recent observed status of the Prometheus cluster. More info: https://github.com/kubernetes/community/blob/master/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableReplicas",
    "conditions",
    "paused",
    "replicas",
    "selector",
    "shardStatuses",
    "shards",
    "unavailableReplicas",
    "updatedReplicas"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
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
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class PrometheusStatus implements Editable<PrometheusStatusBuilder>, KubernetesResource
{

    @JsonProperty("availableReplicas")
    private Integer availableReplicas;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("paused")
    private Boolean paused;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("selector")
    private String selector;
    @JsonProperty("shardStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ShardStatus> shardStatuses = new ArrayList<>();
    @JsonProperty("shards")
    private Integer shards;
    @JsonProperty("unavailableReplicas")
    private Integer unavailableReplicas;
    @JsonProperty("updatedReplicas")
    private Integer updatedReplicas;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrometheusStatus() {
    }

    public PrometheusStatus(Integer availableReplicas, List<Condition> conditions, Boolean paused, Integer replicas, String selector, List<ShardStatus> shardStatuses, Integer shards, Integer unavailableReplicas, Integer updatedReplicas) {
        super();
        this.availableReplicas = availableReplicas;
        this.conditions = conditions;
        this.paused = paused;
        this.replicas = replicas;
        this.selector = selector;
        this.shardStatuses = shardStatuses;
        this.shards = shards;
        this.unavailableReplicas = unavailableReplicas;
        this.updatedReplicas = updatedReplicas;
    }

    /**
     * availableReplicas defines the total number of available pods (ready for at least minReadySeconds) targeted by this Prometheus deployment.
     */
    @JsonProperty("availableReplicas")
    public Integer getAvailableReplicas() {
        return availableReplicas;
    }

    /**
     * availableReplicas defines the total number of available pods (ready for at least minReadySeconds) targeted by this Prometheus deployment.
     */
    @JsonProperty("availableReplicas")
    public void setAvailableReplicas(Integer availableReplicas) {
        this.availableReplicas = availableReplicas;
    }

    /**
     * conditions defines the current state of the Prometheus deployment.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions defines the current state of the Prometheus deployment.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * paused defines whether any actions on the underlying managed objects are being performed. Only delete actions will be performed.
     */
    @JsonProperty("paused")
    public Boolean getPaused() {
        return paused;
    }

    /**
     * paused defines whether any actions on the underlying managed objects are being performed. Only delete actions will be performed.
     */
    @JsonProperty("paused")
    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    /**
     * replicas defines the total number of non-terminated pods targeted by this Prometheus deployment (their labels match the selector).
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas defines the total number of non-terminated pods targeted by this Prometheus deployment (their labels match the selector).
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * selector used to match the pods targeted by this Prometheus resource.
     */
    @JsonProperty("selector")
    public String getSelector() {
        return selector;
    }

    /**
     * selector used to match the pods targeted by this Prometheus resource.
     */
    @JsonProperty("selector")
    public void setSelector(String selector) {
        this.selector = selector;
    }

    /**
     * shardStatuses defines the list has one entry per shard. Each entry provides a summary of the shard status.
     */
    @JsonProperty("shardStatuses")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ShardStatus> getShardStatuses() {
        return shardStatuses;
    }

    /**
     * shardStatuses defines the list has one entry per shard. Each entry provides a summary of the shard status.
     */
    @JsonProperty("shardStatuses")
    public void setShardStatuses(List<ShardStatus> shardStatuses) {
        this.shardStatuses = shardStatuses;
    }

    /**
     * shards defines the most recently observed number of shards.
     */
    @JsonProperty("shards")
    public Integer getShards() {
        return shards;
    }

    /**
     * shards defines the most recently observed number of shards.
     */
    @JsonProperty("shards")
    public void setShards(Integer shards) {
        this.shards = shards;
    }

    /**
     * unavailableReplicas defines the total number of unavailable pods targeted by this Prometheus deployment.
     */
    @JsonProperty("unavailableReplicas")
    public Integer getUnavailableReplicas() {
        return unavailableReplicas;
    }

    /**
     * unavailableReplicas defines the total number of unavailable pods targeted by this Prometheus deployment.
     */
    @JsonProperty("unavailableReplicas")
    public void setUnavailableReplicas(Integer unavailableReplicas) {
        this.unavailableReplicas = unavailableReplicas;
    }

    /**
     * updatedReplicas defines the total number of non-terminated pods targeted by this Prometheus deployment that have the desired version spec.
     */
    @JsonProperty("updatedReplicas")
    public Integer getUpdatedReplicas() {
        return updatedReplicas;
    }

    /**
     * updatedReplicas defines the total number of non-terminated pods targeted by this Prometheus deployment that have the desired version spec.
     */
    @JsonProperty("updatedReplicas")
    public void setUpdatedReplicas(Integer updatedReplicas) {
        this.updatedReplicas = updatedReplicas;
    }

    @JsonIgnore
    public PrometheusStatusBuilder edit() {
        return new PrometheusStatusBuilder(this);
    }

    @JsonIgnore
    public PrometheusStatusBuilder toBuilder() {
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
        if (!(o instanceof PrometheusStatus)) {
            return false;
        }
        PrometheusStatus other = (PrometheusStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$availableReplicas = this.getAvailableReplicas();
        Object other$availableReplicas = other.getAvailableReplicas();
        if (this$availableReplicas == null ? other$availableReplicas != null : !this$availableReplicas.equals(other$availableReplicas)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$paused = this.getPaused();
        Object other$paused = other.getPaused();
        if (this$paused == null ? other$paused != null : !this$paused.equals(other$paused)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$shardStatuses = this.getShardStatuses();
        Object other$shardStatuses = other.getShardStatuses();
        if (this$shardStatuses == null ? other$shardStatuses != null : !this$shardStatuses.equals(other$shardStatuses)) {
            return false;
        }
        Object this$shards = this.getShards();
        Object other$shards = other.getShards();
        if (this$shards == null ? other$shards != null : !this$shards.equals(other$shards)) {
            return false;
        }
        Object this$unavailableReplicas = this.getUnavailableReplicas();
        Object other$unavailableReplicas = other.getUnavailableReplicas();
        if (this$unavailableReplicas == null ? other$unavailableReplicas != null : !this$unavailableReplicas.equals(other$unavailableReplicas)) {
            return false;
        }
        Object this$updatedReplicas = this.getUpdatedReplicas();
        Object other$updatedReplicas = other.getUpdatedReplicas();
        if (this$updatedReplicas == null ? other$updatedReplicas != null : !this$updatedReplicas.equals(other$updatedReplicas)) {
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
        return other instanceof PrometheusStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $availableReplicas = this.getAvailableReplicas();
        result = result * prime + ($availableReplicas == null ? 43 : $availableReplicas.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $paused = this.getPaused();
        result = result * prime + ($paused == null ? 43 : $paused.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $shardStatuses = this.getShardStatuses();
        result = result * prime + ($shardStatuses == null ? 43 : $shardStatuses.hashCode());
        Object $shards = this.getShards();
        result = result * prime + ($shards == null ? 43 : $shards.hashCode());
        Object $unavailableReplicas = this.getUnavailableReplicas();
        result = result * prime + ($unavailableReplicas == null ? 43 : $unavailableReplicas.hashCode());
        Object $updatedReplicas = this.getUpdatedReplicas();
        result = result * prime + ($updatedReplicas == null ? 43 : $updatedReplicas.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PrometheusStatus(" + "availableReplicas=" + this.getAvailableReplicas() + ", conditions=" + this.getConditions() + ", paused=" + this.getPaused() + ", replicas=" + this.getReplicas() + ", selector=" + this.getSelector() + ", shardStatuses=" + this.getShardStatuses() + ", shards=" + this.getShards() + ", unavailableReplicas=" + this.getUnavailableReplicas() + ", updatedReplicas=" + this.getUpdatedReplicas() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
