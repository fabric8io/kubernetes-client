
package io.fabric8.volcano.api.model.scheduling.v1beta1;

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
@Generated("jsonschema2pojo")
public class QueueSpec implements Editable<QueueSpecBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("affinity")
    public Affinity getAffinity() {
        return affinity;
    }

    @JsonProperty("affinity")
    public void setAffinity(Affinity affinity) {
        this.affinity = affinity;
    }

    @JsonProperty("capability")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getCapability() {
        return capability;
    }

    @JsonProperty("capability")
    public void setCapability(Map<String, Quantity> capability) {
        this.capability = capability;
    }

    @JsonProperty("deserved")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getDeserved() {
        return deserved;
    }

    @JsonProperty("deserved")
    public void setDeserved(Map<String, Quantity> deserved) {
        this.deserved = deserved;
    }

    @JsonProperty("extendClusters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Cluster> getExtendClusters() {
        return extendClusters;
    }

    @JsonProperty("extendClusters")
    public void setExtendClusters(List<Cluster> extendClusters) {
        this.extendClusters = extendClusters;
    }

    @JsonProperty("guarantee")
    public Guarantee getGuarantee() {
        return guarantee;
    }

    @JsonProperty("guarantee")
    public void setGuarantee(Guarantee guarantee) {
        this.guarantee = guarantee;
    }

    @JsonProperty("parent")
    public String getParent() {
        return parent;
    }

    @JsonProperty("parent")
    public void setParent(String parent) {
        this.parent = parent;
    }

    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @JsonProperty("reclaimable")
    public Boolean getReclaimable() {
        return reclaimable;
    }

    @JsonProperty("reclaimable")
    public void setReclaimable(Boolean reclaimable) {
        this.reclaimable = reclaimable;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

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
