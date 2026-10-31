
package io.fabric8.volcano.api.model.scheduling.v1beta1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * NamespaceQueueSpec represents the desired behavior of NamespaceQueue.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "capability",
    "dequeueStrategy",
    "deserved",
    "guarantee",
    "parent",
    "priority",
    "reclaimable"
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
public class NamespaceQueueSpec implements Editable<NamespaceQueueSpecBuilder>, KubernetesResource
{

    @JsonProperty("capability")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> capability = new LinkedHashMap<>();
    @JsonProperty("dequeueStrategy")
    private String dequeueStrategy;
    @JsonProperty("deserved")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> deserved = new LinkedHashMap<>();
    @JsonProperty("guarantee")
    private Guarantee guarantee;
    @JsonProperty("parent")
    private String parent;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("reclaimable")
    private Boolean reclaimable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NamespaceQueueSpec() {
    }

    public NamespaceQueueSpec(Map<String, Quantity> capability, String dequeueStrategy, Map<String, Quantity> deserved, Guarantee guarantee, String parent, Integer priority, Boolean reclaimable) {
        super();
        this.capability = capability;
        this.dequeueStrategy = dequeueStrategy;
        this.deserved = deserved;
        this.guarantee = guarantee;
        this.parent = parent;
        this.priority = priority;
        this.reclaimable = reclaimable;
    }

    /**
     * Capability limits the resources that this NamespaceQueue may consume.
     */
    @JsonProperty("capability")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getCapability() {
        return capability;
    }

    /**
     * Capability limits the resources that this NamespaceQueue may consume.
     */
    @JsonProperty("capability")
    public void setCapability(Map<String, Quantity> capability) {
        this.capability = capability;
    }

    /**
     * DequeueStrategy controls how descendants are traversed when work is dequeued.
     */
    @JsonProperty("dequeueStrategy")
    public String getDequeueStrategy() {
        return dequeueStrategy;
    }

    /**
     * DequeueStrategy controls how descendants are traversed when work is dequeued.
     */
    @JsonProperty("dequeueStrategy")
    public void setDequeueStrategy(String dequeueStrategy) {
        this.dequeueStrategy = dequeueStrategy;
    }

    /**
     * Deserved declares the fair-share resource entitlement for this NamespaceQueue.
     */
    @JsonProperty("deserved")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getDeserved() {
        return deserved;
    }

    /**
     * Deserved declares the fair-share resource entitlement for this NamespaceQueue.
     */
    @JsonProperty("deserved")
    public void setDeserved(Map<String, Quantity> deserved) {
        this.deserved = deserved;
    }

    /**
     * NamespaceQueueSpec represents the desired behavior of NamespaceQueue.
     */
    @JsonProperty("guarantee")
    public Guarantee getGuarantee() {
        return guarantee;
    }

    /**
     * NamespaceQueueSpec represents the desired behavior of NamespaceQueue.
     */
    @JsonProperty("guarantee")
    public void setGuarantee(Guarantee guarantee) {
        this.guarantee = guarantee;
    }

    /**
     * Parent can be a cluster Queue or another NamespaceQueue in the same namespace. "cluster/&lt;name&gt;" refers to a cluster-scoped Queue. An unprefixed value refers to a NamespaceQueue in the same namespace.
     */
    @JsonProperty("parent")
    public String getParent() {
        return parent;
    }

    /**
     * Parent can be a cluster Queue or another NamespaceQueue in the same namespace. "cluster/&lt;name&gt;" refers to a cluster-scoped Queue. An unprefixed value refers to a NamespaceQueue in the same namespace.
     */
    @JsonProperty("parent")
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * Priority influences queue ordering during scheduling and reclamation.
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * Priority influences queue ordering during scheduling and reclamation.
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * Reclaimable controls whether workloads in this NamespaceQueue may be reclaimed.
     */
    @JsonProperty("reclaimable")
    public Boolean getReclaimable() {
        return reclaimable;
    }

    /**
     * Reclaimable controls whether workloads in this NamespaceQueue may be reclaimed.
     */
    @JsonProperty("reclaimable")
    public void setReclaimable(Boolean reclaimable) {
        this.reclaimable = reclaimable;
    }

    @JsonIgnore
    public NamespaceQueueSpecBuilder edit() {
        return new NamespaceQueueSpecBuilder(this);
    }

    @JsonIgnore
    public NamespaceQueueSpecBuilder toBuilder() {
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

}
