
package io.fabric8.openclustermanagement.api.model.cluster.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocatable",
    "capacity",
    "clusterClaims",
    "conditions",
    "version"
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
public class ManagedClusterStatus implements Editable<ManagedClusterStatusBuilder> , KubernetesResource
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
    @JsonProperty("version")
    private ManagedClusterVersion version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ManagedClusterStatus() {
    }

    public ManagedClusterStatus(Map<String, Quantity> allocatable, Map<String, Quantity> capacity, List<ManagedClusterClaim> clusterClaims, List<Condition> conditions, ManagedClusterVersion version) {
        super();
        this.allocatable = allocatable;
        this.capacity = capacity;
        this.clusterClaims = clusterClaims;
        this.conditions = conditions;
        this.version = version;
    }

    @JsonProperty("allocatable")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getAllocatable() {
        return allocatable;
    }

    @JsonProperty("allocatable")
    public void setAllocatable(Map<String, Quantity> allocatable) {
        this.allocatable = allocatable;
    }

    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getCapacity() {
        return capacity;
    }

    @JsonProperty("capacity")
    public void setCapacity(Map<String, Quantity> capacity) {
        this.capacity = capacity;
    }

    @JsonProperty("clusterClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ManagedClusterClaim> getClusterClaims() {
        return clusterClaims;
    }

    @JsonProperty("clusterClaims")
    public void setClusterClaims(List<ManagedClusterClaim> clusterClaims) {
        this.clusterClaims = clusterClaims;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("version")
    public ManagedClusterVersion getVersion() {
        return version;
    }

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
