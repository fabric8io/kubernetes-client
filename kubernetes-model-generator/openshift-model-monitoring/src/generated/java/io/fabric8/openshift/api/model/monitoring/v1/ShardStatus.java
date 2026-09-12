
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableReplicas",
    "replicas",
    "shardID",
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
public class ShardStatus implements Editable<ShardStatusBuilder>, KubernetesResource
{

    @JsonProperty("availableReplicas")
    private Integer availableReplicas;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("shardID")
    private String shardID;
    @JsonProperty("unavailableReplicas")
    private Integer unavailableReplicas;
    @JsonProperty("updatedReplicas")
    private Integer updatedReplicas;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ShardStatus() {
    }

    public ShardStatus(Integer availableReplicas, Integer replicas, String shardID, Integer unavailableReplicas, Integer updatedReplicas) {
        super();
        this.availableReplicas = availableReplicas;
        this.replicas = replicas;
        this.shardID = shardID;
        this.unavailableReplicas = unavailableReplicas;
        this.updatedReplicas = updatedReplicas;
    }

    /**
     * availableReplicas defines the total number of available pods (ready for at least minReadySeconds) targeted by this shard.
     */
    @JsonProperty("availableReplicas")
    public Integer getAvailableReplicas() {
        return availableReplicas;
    }

    /**
     * availableReplicas defines the total number of available pods (ready for at least minReadySeconds) targeted by this shard.
     */
    @JsonProperty("availableReplicas")
    public void setAvailableReplicas(Integer availableReplicas) {
        this.availableReplicas = availableReplicas;
    }

    /**
     * replicas defines the total number of pods targeted by this shard.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * replicas defines the total number of pods targeted by this shard.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * shardID defines the identifier of the shard.
     */
    @JsonProperty("shardID")
    public String getShardID() {
        return shardID;
    }

    /**
     * shardID defines the identifier of the shard.
     */
    @JsonProperty("shardID")
    public void setShardID(String shardID) {
        this.shardID = shardID;
    }

    /**
     * unavailableReplicas defines the Total number of unavailable pods targeted by this shard.
     */
    @JsonProperty("unavailableReplicas")
    public Integer getUnavailableReplicas() {
        return unavailableReplicas;
    }

    /**
     * unavailableReplicas defines the Total number of unavailable pods targeted by this shard.
     */
    @JsonProperty("unavailableReplicas")
    public void setUnavailableReplicas(Integer unavailableReplicas) {
        this.unavailableReplicas = unavailableReplicas;
    }

    /**
     * updatedReplicas defines the total number of non-terminated pods targeted by this shard that have the desired spec.
     */
    @JsonProperty("updatedReplicas")
    public Integer getUpdatedReplicas() {
        return updatedReplicas;
    }

    /**
     * updatedReplicas defines the total number of non-terminated pods targeted by this shard that have the desired spec.
     */
    @JsonProperty("updatedReplicas")
    public void setUpdatedReplicas(Integer updatedReplicas) {
        this.updatedReplicas = updatedReplicas;
    }

    @JsonIgnore
    public ShardStatusBuilder edit() {
        return new ShardStatusBuilder(this);
    }

    @JsonIgnore
    public ShardStatusBuilder toBuilder() {
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
        if (!(o instanceof ShardStatus)) {
            return false;
        }
        ShardStatus other = (ShardStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$availableReplicas = this.getAvailableReplicas();
        Object other$availableReplicas = other.getAvailableReplicas();
        if (this$availableReplicas == null ? other$availableReplicas != null : !this$availableReplicas.equals(other$availableReplicas)) {
            return false;
        }
        Object this$replicas = this.getReplicas();
        Object other$replicas = other.getReplicas();
        if (this$replicas == null ? other$replicas != null : !this$replicas.equals(other$replicas)) {
            return false;
        }
        Object this$shardID = this.getShardID();
        Object other$shardID = other.getShardID();
        if (this$shardID == null ? other$shardID != null : !this$shardID.equals(other$shardID)) {
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
        return other instanceof ShardStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $availableReplicas = this.getAvailableReplicas();
        result = result * prime + ($availableReplicas == null ? 43 : $availableReplicas.hashCode());
        Object $replicas = this.getReplicas();
        result = result * prime + ($replicas == null ? 43 : $replicas.hashCode());
        Object $shardID = this.getShardID();
        result = result * prime + ($shardID == null ? 43 : $shardID.hashCode());
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
        return "ShardStatus(" + "availableReplicas=" + this.getAvailableReplicas() + ", replicas=" + this.getReplicas() + ", shardID=" + this.getShardID() + ", unavailableReplicas=" + this.getUnavailableReplicas() + ", updatedReplicas=" + this.getUpdatedReplicas() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
