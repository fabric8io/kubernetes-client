
package io.fabric8.openclustermanagement.api.model.cluster.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * SpreadConstraintsTerm defines a terminology to spread placement decisions.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxSkew",
    "topologyKey",
    "topologyKeyType",
    "whenUnsatisfiable"
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
public class SpreadConstraintsTerm implements Editable<SpreadConstraintsTermBuilder>, KubernetesResource
{

    @JsonProperty("maxSkew")
    private Integer maxSkew;
    @JsonProperty("topologyKey")
    private String topologyKey;
    @JsonProperty("topologyKeyType")
    private String topologyKeyType;
    @JsonProperty("whenUnsatisfiable")
    private String whenUnsatisfiable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SpreadConstraintsTerm() {
    }

    public SpreadConstraintsTerm(Integer maxSkew, String topologyKey, String topologyKeyType, String whenUnsatisfiable) {
        super();
        this.maxSkew = maxSkew;
        this.topologyKey = topologyKey;
        this.topologyKeyType = topologyKeyType;
        this.whenUnsatisfiable = whenUnsatisfiable;
    }

    /**
     * MaxSkew represents the degree to which the workload may be unevenly distributed. Skew is the maximum difference between the number of selected ManagedClusters in a topology and the global minimum. The global minimum is the minimum number of selected ManagedClusters for the topologies within the same TopologyKey. The minimum possible value of MaxSkew is 1, and the default value is 1.
     */
    @JsonProperty("maxSkew")
    public Integer getMaxSkew() {
        return maxSkew;
    }

    /**
     * MaxSkew represents the degree to which the workload may be unevenly distributed. Skew is the maximum difference between the number of selected ManagedClusters in a topology and the global minimum. The global minimum is the minimum number of selected ManagedClusters for the topologies within the same TopologyKey. The minimum possible value of MaxSkew is 1, and the default value is 1.
     */
    @JsonProperty("maxSkew")
    public void setMaxSkew(Integer maxSkew) {
        this.maxSkew = maxSkew;
    }

    /**
     * TopologyKey is either a label key or a cluster claim name of ManagedClusters.
     */
    @JsonProperty("topologyKey")
    public String getTopologyKey() {
        return topologyKey;
    }

    /**
     * TopologyKey is either a label key or a cluster claim name of ManagedClusters.
     */
    @JsonProperty("topologyKey")
    public void setTopologyKey(String topologyKey) {
        this.topologyKey = topologyKey;
    }

    /**
     * TopologyKeyType indicates the type of TopologyKey. It could be Label or Claim.
     */
    @JsonProperty("topologyKeyType")
    public String getTopologyKeyType() {
        return topologyKeyType;
    }

    /**
     * TopologyKeyType indicates the type of TopologyKey. It could be Label or Claim.
     */
    @JsonProperty("topologyKeyType")
    public void setTopologyKeyType(String topologyKeyType) {
        this.topologyKeyType = topologyKeyType;
    }

    /**
     * WhenUnsatisfiable represents the action of the scheduler when MaxSkew cannot be satisfied. It could be DoNotSchedule or ScheduleAnyway. The default value is ScheduleAnyway. DoNotSchedule instructs the scheduler not to schedule more ManagedClusters when MaxSkew is not satisfied. ScheduleAnyway instructs the scheduler to keep scheduling even if MaxSkew is not satisfied.
     */
    @JsonProperty("whenUnsatisfiable")
    public String getWhenUnsatisfiable() {
        return whenUnsatisfiable;
    }

    /**
     * WhenUnsatisfiable represents the action of the scheduler when MaxSkew cannot be satisfied. It could be DoNotSchedule or ScheduleAnyway. The default value is ScheduleAnyway. DoNotSchedule instructs the scheduler not to schedule more ManagedClusters when MaxSkew is not satisfied. ScheduleAnyway instructs the scheduler to keep scheduling even if MaxSkew is not satisfied.
     */
    @JsonProperty("whenUnsatisfiable")
    public void setWhenUnsatisfiable(String whenUnsatisfiable) {
        this.whenUnsatisfiable = whenUnsatisfiable;
    }

    @JsonIgnore
    public SpreadConstraintsTermBuilder edit() {
        return new SpreadConstraintsTermBuilder(this);
    }

    @JsonIgnore
    public SpreadConstraintsTermBuilder toBuilder() {
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
        if (!(o instanceof SpreadConstraintsTerm)) {
            return false;
        }
        SpreadConstraintsTerm other = (SpreadConstraintsTerm) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$maxSkew = this.getMaxSkew();
        Object other$maxSkew = other.getMaxSkew();
        if (this$maxSkew == null ? other$maxSkew != null : !this$maxSkew.equals(other$maxSkew)) {
            return false;
        }
        Object this$topologyKey = this.getTopologyKey();
        Object other$topologyKey = other.getTopologyKey();
        if (this$topologyKey == null ? other$topologyKey != null : !this$topologyKey.equals(other$topologyKey)) {
            return false;
        }
        Object this$topologyKeyType = this.getTopologyKeyType();
        Object other$topologyKeyType = other.getTopologyKeyType();
        if (this$topologyKeyType == null ? other$topologyKeyType != null : !this$topologyKeyType.equals(other$topologyKeyType)) {
            return false;
        }
        Object this$whenUnsatisfiable = this.getWhenUnsatisfiable();
        Object other$whenUnsatisfiable = other.getWhenUnsatisfiable();
        if (this$whenUnsatisfiable == null ? other$whenUnsatisfiable != null : !this$whenUnsatisfiable.equals(other$whenUnsatisfiable)) {
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
        return other instanceof SpreadConstraintsTerm;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $maxSkew = this.getMaxSkew();
        result = result * prime + ($maxSkew == null ? 43 : $maxSkew.hashCode());
        Object $topologyKey = this.getTopologyKey();
        result = result * prime + ($topologyKey == null ? 43 : $topologyKey.hashCode());
        Object $topologyKeyType = this.getTopologyKeyType();
        result = result * prime + ($topologyKeyType == null ? 43 : $topologyKeyType.hashCode());
        Object $whenUnsatisfiable = this.getWhenUnsatisfiable();
        result = result * prime + ($whenUnsatisfiable == null ? 43 : $whenUnsatisfiable.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SpreadConstraintsTerm(" + "maxSkew=" + this.getMaxSkew() + ", topologyKey=" + this.getTopologyKey() + ", topologyKeyType=" + this.getTopologyKeyType() + ", whenUnsatisfiable=" + this.getWhenUnsatisfiable() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
