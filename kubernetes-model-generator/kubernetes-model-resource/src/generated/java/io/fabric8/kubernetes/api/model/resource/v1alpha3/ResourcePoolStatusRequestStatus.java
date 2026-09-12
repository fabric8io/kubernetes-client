
package io.fabric8.kubernetes.api.model.resource.v1alpha3;

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

/**
 * ResourcePoolStatusRequestStatus contains the calculated pool status information.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "poolCount",
    "pools"
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
public class ResourcePoolStatusRequestStatus implements Editable<ResourcePoolStatusRequestStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("poolCount")
    private Integer poolCount;
    @JsonProperty("pools")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PoolStatus> pools = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourcePoolStatusRequestStatus() {
    }

    public ResourcePoolStatusRequestStatus(List<Condition> conditions, Integer poolCount, List<PoolStatus> pools) {
        super();
        this.conditions = conditions;
        this.poolCount = poolCount;
        this.pools = pools;
    }

    /**
     * Conditions provide information about the state of the request. A condition with type=Complete or type=Failed will always be set when the status is populated.<br><p> <br><p> Known condition types: - "Complete": True when the request has been processed successfully - "Failed": True when the request could not be processed
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions provide information about the state of the request. A condition with type=Complete or type=Failed will always be set when the status is populated.<br><p> <br><p> Known condition types: - "Complete": True when the request has been processed successfully - "Failed": True when the request could not be processed
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * PoolCount is the total number of pools that matched the filter criteria, regardless of truncation. This helps users understand how many pools exist even when the response is truncated. A value of 0 means no pools matched the filter criteria.
     */
    @JsonProperty("poolCount")
    public Integer getPoolCount() {
        return poolCount;
    }

    /**
     * PoolCount is the total number of pools that matched the filter criteria, regardless of truncation. This helps users understand how many pools exist even when the response is truncated. A value of 0 means no pools matched the filter criteria.
     */
    @JsonProperty("poolCount")
    public void setPoolCount(Integer poolCount) {
        this.poolCount = poolCount;
    }

    /**
     * Pools contains the first `spec.limit` matching pools, sorted by driver then pool name. If `len(pools) &lt; poolCount`, the list was truncated. When omitted, no pools matched the request filters.
     */
    @JsonProperty("pools")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PoolStatus> getPools() {
        return pools;
    }

    /**
     * Pools contains the first `spec.limit` matching pools, sorted by driver then pool name. If `len(pools) &lt; poolCount`, the list was truncated. When omitted, no pools matched the request filters.
     */
    @JsonProperty("pools")
    public void setPools(List<PoolStatus> pools) {
        this.pools = pools;
    }

    @JsonIgnore
    public ResourcePoolStatusRequestStatusBuilder edit() {
        return new ResourcePoolStatusRequestStatusBuilder(this);
    }

    @JsonIgnore
    public ResourcePoolStatusRequestStatusBuilder toBuilder() {
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
        if (!(o instanceof ResourcePoolStatusRequestStatus)) {
            return false;
        }
        ResourcePoolStatusRequestStatus other = (ResourcePoolStatusRequestStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$poolCount = this.getPoolCount();
        Object other$poolCount = other.getPoolCount();
        if (this$poolCount == null ? other$poolCount != null : !this$poolCount.equals(other$poolCount)) {
            return false;
        }
        Object this$pools = this.getPools();
        Object other$pools = other.getPools();
        if (this$pools == null ? other$pools != null : !this$pools.equals(other$pools)) {
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
        return other instanceof ResourcePoolStatusRequestStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $poolCount = this.getPoolCount();
        result = result * prime + ($poolCount == null ? 43 : $poolCount.hashCode());
        Object $pools = this.getPools();
        result = result * prime + ($pools == null ? 43 : $pools.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourcePoolStatusRequestStatus(" + "conditions=" + this.getConditions() + ", poolCount=" + this.getPoolCount() + ", pools=" + this.getPools() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
