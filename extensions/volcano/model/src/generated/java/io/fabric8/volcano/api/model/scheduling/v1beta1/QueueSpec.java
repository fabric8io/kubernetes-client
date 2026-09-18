
package io.fabric8.volcano.api.model.scheduling.v1beta1;

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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * QueueSpec represents the template of Queue.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "affinity",
    "capability",
    "deserved",
    "extendClusters",
    "guarantee",
    "parent",
    "priority",
    "reclaimable",
    "type",
    "weight"
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
public class QueueSpec implements Editable<QueueSpecBuilder>, KubernetesResource
{

    @JsonProperty("affinity")
    private Affinity affinity;
    @JsonProperty("capability")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> capability = new LinkedHashMap<>();
    @JsonProperty("deserved")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> deserved = new LinkedHashMap<>();
    @JsonProperty("extendClusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Cluster> extendClusters = new ArrayList<>();
    @JsonProperty("guarantee")
    private Guarantee guarantee;
    @JsonProperty("parent")
    private String parent;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("reclaimable")
    private Boolean reclaimable;
    @JsonProperty("type")
    private String type;
    @JsonProperty("weight")
    private Integer weight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public QueueSpec() {
    }

    public QueueSpec(Affinity affinity, Map<String, Quantity> capability, Map<String, Quantity> deserved, List<Cluster> extendClusters, Guarantee guarantee, String parent, Integer priority, Boolean reclaimable, String type, Integer weight) {
        super();
        this.affinity = affinity;
        this.capability = capability;
        this.deserved = deserved;
        this.extendClusters = extendClusters;
        this.guarantee = guarantee;
        this.parent = parent;
        this.priority = priority;
        this.reclaimable = reclaimable;
        this.type = type;
        this.weight = weight;
    }

    /**
     * QueueSpec represents the template of Queue.
     */
    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    /**
     * QueueSpec represents the template of Queue.
     */
    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    /**
     * QueueSpec represents the template of Queue.
     */
    @JsonProperty("capability")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getCapability() {
        return capability;
    }

    /**
     * QueueSpec represents the template of Queue.
     */
    @JsonProperty("capability")
    public void setCapability(Map<String, Quantity> capability) {
        this.capability = capability;
    }

    /**
     * The amount of resources configured by the user. This part of resource can be shared with other queues and reclaimed back.
     */
    @JsonProperty("deserved")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getDeserved() {
        return deserved;
    }

    /**
     * The amount of resources configured by the user. This part of resource can be shared with other queues and reclaimed back.
     */
    @JsonProperty("deserved")
    public void setDeserved(Map<String, Quantity> deserved) {
        this.deserved = deserved;
    }

    /**
     * extendCluster indicate the jobs in this Queue will be dispatched to these clusters.
     */
    @JsonProperty("extendClusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Cluster> getExtendClusters() {
        return extendClusters;
    }

    /**
     * extendCluster indicate the jobs in this Queue will be dispatched to these clusters.
     */
    @JsonProperty("extendClusters")
    public void setExtendClusters(List<Cluster> extendClusters) {
        this.extendClusters = extendClusters;
    }

    /**
     * QueueSpec represents the template of Queue.
     */
    @JsonProperty("guarantee")
    public Guarantee getGuarantee() {
        return guarantee;
    }

    /**
     * QueueSpec represents the template of Queue.
     */
    @JsonProperty("guarantee")
    public void setGuarantee(Guarantee guarantee) {
        this.guarantee = guarantee;
    }

    /**
     * Parent define the parent of queue
     */
    @JsonProperty("parent")
    public String getParent() {
        return parent;
    }

    /**
     * Parent define the parent of queue
     */
    @JsonProperty("parent")
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * Priority define the priority of queue. Higher values are prioritized for scheduling and considered later during reclamation.
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * Priority define the priority of queue. Higher values are prioritized for scheduling and considered later during reclamation.
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * Reclaimable indicate whether the queue can be reclaimed by other queue
     */
    @JsonProperty("reclaimable")
    public Boolean getReclaimable() {
        return reclaimable;
    }

    /**
     * Reclaimable indicate whether the queue can be reclaimed by other queue
     */
    @JsonProperty("reclaimable")
    public void setReclaimable(Boolean reclaimable) {
        this.reclaimable = reclaimable;
    }

    /**
     * Type define the type of queue
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * Type define the type of queue
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    /**
     * QueueSpec represents the template of Queue.
     */
    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    /**
     * QueueSpec represents the template of Queue.
     */
    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonIgnore
    public QueueSpecBuilder edit() {
        return new QueueSpecBuilder(this);
    }

    @JsonIgnore
    public QueueSpecBuilder toBuilder() {
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
        if (!(o instanceof QueueSpec)) {
            return false;
        }
        QueueSpec other = (QueueSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$affinity = this.getAffinity();
        Object other$affinity = other.getAffinity();
        if (this$affinity == null ? other$affinity != null : !this$affinity.equals(other$affinity)) {
            return false;
        }
        Object this$capability = this.getCapability();
        Object other$capability = other.getCapability();
        if (this$capability == null ? other$capability != null : !this$capability.equals(other$capability)) {
            return false;
        }
        Object this$deserved = this.getDeserved();
        Object other$deserved = other.getDeserved();
        if (this$deserved == null ? other$deserved != null : !this$deserved.equals(other$deserved)) {
            return false;
        }
        Object this$extendClusters = this.getExtendClusters();
        Object other$extendClusters = other.getExtendClusters();
        if (this$extendClusters == null ? other$extendClusters != null : !this$extendClusters.equals(other$extendClusters)) {
            return false;
        }
        Object this$guarantee = this.getGuarantee();
        Object other$guarantee = other.getGuarantee();
        if (this$guarantee == null ? other$guarantee != null : !this$guarantee.equals(other$guarantee)) {
            return false;
        }
        Object this$parent = this.getParent();
        Object other$parent = other.getParent();
        if (this$parent == null ? other$parent != null : !this$parent.equals(other$parent)) {
            return false;
        }
        Object this$priority = this.getPriority();
        Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) {
            return false;
        }
        Object this$reclaimable = this.getReclaimable();
        Object other$reclaimable = other.getReclaimable();
        if (this$reclaimable == null ? other$reclaimable != null : !this$reclaimable.equals(other$reclaimable)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
            return false;
        }
        Object this$weight = this.getWeight();
        Object other$weight = other.getWeight();
        if (this$weight == null ? other$weight != null : !this$weight.equals(other$weight)) {
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
        return other instanceof QueueSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $affinity = this.getAffinity();
        result = result * prime + ($affinity == null ? 43 : $affinity.hashCode());
        Object $capability = this.getCapability();
        result = result * prime + ($capability == null ? 43 : $capability.hashCode());
        Object $deserved = this.getDeserved();
        result = result * prime + ($deserved == null ? 43 : $deserved.hashCode());
        Object $extendClusters = this.getExtendClusters();
        result = result * prime + ($extendClusters == null ? 43 : $extendClusters.hashCode());
        Object $guarantee = this.getGuarantee();
        result = result * prime + ($guarantee == null ? 43 : $guarantee.hashCode());
        Object $parent = this.getParent();
        result = result * prime + ($parent == null ? 43 : $parent.hashCode());
        Object $priority = this.getPriority();
        result = result * prime + ($priority == null ? 43 : $priority.hashCode());
        Object $reclaimable = this.getReclaimable();
        result = result * prime + ($reclaimable == null ? 43 : $reclaimable.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $weight = this.getWeight();
        result = result * prime + ($weight == null ? 43 : $weight.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "QueueSpec(" + "affinity=" + this.getAffinity() + ", capability=" + this.getCapability() + ", deserved=" + this.getDeserved() + ", extendClusters=" + this.getExtendClusters() + ", guarantee=" + this.getGuarantee() + ", parent=" + this.getParent() + ", priority=" + this.getPriority() + ", reclaimable=" + this.getReclaimable() + ", type=" + this.getType() + ", weight=" + this.getWeight() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
