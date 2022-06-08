
package io.fabric8.volcano.scheduling.v1beta1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "minMember",
    "minResources",
    "priorityClassName",
    "queue"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class PodGroupSpec implements KubernetesResource
{

    @JsonProperty("minMember")
    private Integer minMember;
    @JsonProperty("minResources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> minResources = new LinkedHashMap<String, Quantity>();
    @JsonProperty("priorityClassName")
    private java.lang.String priorityClassName;
    @JsonProperty("queue")
    private java.lang.String queue;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PodGroupSpec() {
    }

    /**
     * 
     * @param priorityClassName
     * @param minResources
     * @param queue
     * @param minMember
     */
    public PodGroupSpec(Integer minMember, Map<String, Quantity> minResources, java.lang.String priorityClassName, java.lang.String queue) {
        super();
        this.minMember = minMember;
        this.minResources = minResources;
        this.priorityClassName = priorityClassName;
        this.queue = queue;
    }

    @JsonProperty("minMember")
    public Integer getMinMember() {
        return minMember;
    }

    @JsonProperty("minMember")
    public void setMinMember(Integer minMember) {
        this.minMember = minMember;
    }

    @JsonProperty("minResources")
    public Map<String, Quantity> getMinResources() {
        return minResources;
    }

    @JsonProperty("minResources")
    public void setMinResources(Map<String, Quantity> minResources) {
        this.minResources = minResources;
    }

    @JsonProperty("priorityClassName")
    public java.lang.String getPriorityClassName() {
        return priorityClassName;
    }

    @JsonProperty("priorityClassName")
    public void setPriorityClassName(java.lang.String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    @JsonProperty("queue")
    public java.lang.String getQueue() {
        return queue;
    }

    @JsonProperty("queue")
    public void setQueue(java.lang.String queue) {
        this.queue = queue;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
