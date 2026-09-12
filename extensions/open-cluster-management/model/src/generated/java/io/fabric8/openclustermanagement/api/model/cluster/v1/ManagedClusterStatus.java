
package io.fabric8.openclustermanagement.api.model.cluster.v1;

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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * ManagedClusterStatus represents the current status of joined managed cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocatable",
    "capacity",
    "clusterClaims",
    "conditions",
    "managedNamespaces",
    "version"
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
public class ManagedClusterStatus implements Editable<ManagedClusterStatusBuilder>, KubernetesResource
{

    @JsonProperty("allocatable")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> allocatable = new LinkedHashMap<>();
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> capacity = new LinkedHashMap<>();
    @JsonProperty("clusterClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ManagedClusterClaim> clusterClaims = new ArrayList<>();
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("managedNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterSetManagedNamespaceConfig> managedNamespaces = new ArrayList<>();
    @JsonProperty("version")
    private ManagedClusterVersion version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ManagedClusterStatus() {
    }

    public ManagedClusterStatus(Map<String, Quantity> allocatable, Map<String, Quantity> capacity, List<ManagedClusterClaim> clusterClaims, List<Condition> conditions, List<ClusterSetManagedNamespaceConfig> managedNamespaces, ManagedClusterVersion version) {
        super();
        this.allocatable = allocatable;
        this.capacity = capacity;
        this.clusterClaims = clusterClaims;
        this.conditions = conditions;
        this.managedNamespaces = managedNamespaces;
        this.version = version;
    }

    /**
     * allocatable represents the total allocatable resources on the managed cluster.
     */
    @JsonProperty("allocatable")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getAllocatable() {
        return allocatable;
    }

    /**
     * allocatable represents the total allocatable resources on the managed cluster.
     */
    @JsonProperty("allocatable")
    public void setAllocatable(Map<String, Quantity> allocatable) {
        this.allocatable = allocatable;
    }

    /**
     * capacity represents the total resource capacity from all nodeStatuses on the managed cluster.
     */
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getCapacity() {
        return capacity;
    }

    /**
     * capacity represents the total resource capacity from all nodeStatuses on the managed cluster.
     */
    @JsonProperty("capacity")
    public void setCapacity(Map<String, Quantity> capacity) {
        this.capacity = capacity;
    }

    /**
     * clusterClaims represents cluster information that a managed cluster claims, for example a unique cluster identifier (id.k8s.io) and kubernetes version (kubeversion.open-cluster-management.io). They are written from the managed cluster. The set of claims is not uniform across a fleet, some claims can be vendor or version specific and may not be included from all managed clusters.
     */
    @JsonProperty("clusterClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ManagedClusterClaim> getClusterClaims() {
        return clusterClaims;
    }

    /**
     * clusterClaims represents cluster information that a managed cluster claims, for example a unique cluster identifier (id.k8s.io) and kubernetes version (kubeversion.open-cluster-management.io). They are written from the managed cluster. The set of claims is not uniform across a fleet, some claims can be vendor or version specific and may not be included from all managed clusters.
     */
    @JsonProperty("clusterClaims")
    public void setClusterClaims(List<ManagedClusterClaim> clusterClaims) {
        this.clusterClaims = clusterClaims;
    }

    /**
     * conditions contains the different condition statuses for this managed cluster.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions contains the different condition statuses for this managed cluster.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * managedNamespaces are a list of namespaces managed by the clustersets the cluster belongs to.
     */
    @JsonProperty("managedNamespaces")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterSetManagedNamespaceConfig> getManagedNamespaces() {
        return managedNamespaces;
    }

    /**
     * managedNamespaces are a list of namespaces managed by the clustersets the cluster belongs to.
     */
    @JsonProperty("managedNamespaces")
    public void setManagedNamespaces(List<ClusterSetManagedNamespaceConfig> managedNamespaces) {
        this.managedNamespaces = managedNamespaces;
    }

    /**
     * ManagedClusterStatus represents the current status of joined managed cluster.
     */
    @JsonProperty("version")
    public ManagedClusterVersion getVersion() {
        return version;
    }

    /**
     * ManagedClusterStatus represents the current status of joined managed cluster.
     */
    @JsonProperty("version")
    public void setVersion(ManagedClusterVersion version) {
        this.version = version;
    }

    @JsonIgnore
    public ManagedClusterStatusBuilder edit() {
        return new ManagedClusterStatusBuilder(this);
    }

    @JsonIgnore
    public ManagedClusterStatusBuilder toBuilder() {
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
        if (!(o instanceof ManagedClusterStatus)) {
            return false;
        }
        ManagedClusterStatus other = (ManagedClusterStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$allocatable = this.getAllocatable();
        Object other$allocatable = other.getAllocatable();
        if (this$allocatable == null ? other$allocatable != null : !this$allocatable.equals(other$allocatable)) {
            return false;
        }
        Object this$capacity = this.getCapacity();
        Object other$capacity = other.getCapacity();
        if (this$capacity == null ? other$capacity != null : !this$capacity.equals(other$capacity)) {
            return false;
        }
        Object this$clusterClaims = this.getClusterClaims();
        Object other$clusterClaims = other.getClusterClaims();
        if (this$clusterClaims == null ? other$clusterClaims != null : !this$clusterClaims.equals(other$clusterClaims)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$managedNamespaces = this.getManagedNamespaces();
        Object other$managedNamespaces = other.getManagedNamespaces();
        if (this$managedNamespaces == null ? other$managedNamespaces != null : !this$managedNamespaces.equals(other$managedNamespaces)) {
            return false;
        }
        Object this$version = this.getVersion();
        Object other$version = other.getVersion();
        if (this$version == null ? other$version != null : !this$version.equals(other$version)) {
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
        return other instanceof ManagedClusterStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $allocatable = this.getAllocatable();
        result = result * prime + ($allocatable == null ? 43 : $allocatable.hashCode());
        Object $capacity = this.getCapacity();
        result = result * prime + ($capacity == null ? 43 : $capacity.hashCode());
        Object $clusterClaims = this.getClusterClaims();
        result = result * prime + ($clusterClaims == null ? 43 : $clusterClaims.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $managedNamespaces = this.getManagedNamespaces();
        result = result * prime + ($managedNamespaces == null ? 43 : $managedNamespaces.hashCode());
        Object $version = this.getVersion();
        result = result * prime + ($version == null ? 43 : $version.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ManagedClusterStatus(" + "allocatable=" + this.getAllocatable() + ", capacity=" + this.getCapacity() + ", clusterClaims=" + this.getClusterClaims() + ", conditions=" + this.getConditions() + ", managedNamespaces=" + this.getManagedNamespaces() + ", version=" + this.getVersion() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
