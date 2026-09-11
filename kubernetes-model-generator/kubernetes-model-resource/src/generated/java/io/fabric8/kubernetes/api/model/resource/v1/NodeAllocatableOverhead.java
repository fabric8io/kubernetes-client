
package io.fabric8.kubernetes.api.model.resource.v1;

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
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * NodeAllocatableOverhead defines auxiliary resource overheads incurred when allocating a device. Overheads can be specified as a fixed cost per pod referencing the claim, a variable cost per container reference, or both. Kubelet accounts for this overhead by adding it to both the pod-level and container-level cgroups of referencing containers.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "perContainer",
    "perPod"
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
public class NodeAllocatableOverhead implements Editable<NodeAllocatableOverheadBuilder>, KubernetesResource
{

    @JsonProperty("perContainer")
    private Quantity perContainer;
    @JsonProperty("perPod")
    private Quantity perPod;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeAllocatableOverhead() {
    }

    public NodeAllocatableOverhead(Quantity perContainer, Quantity perPod) {
        super();
        this.perContainer = perContainer;
        this.perPod = perPod;
    }

    /**
     * NodeAllocatableOverhead defines auxiliary resource overheads incurred when allocating a device. Overheads can be specified as a fixed cost per pod referencing the claim, a variable cost per container reference, or both. Kubelet accounts for this overhead by adding it to both the pod-level and container-level cgroups of referencing containers.
     */
    @JsonProperty("perContainer")
    public Quantity getPerContainer() {
        return perContainer;
    }

    /**
     * NodeAllocatableOverhead defines auxiliary resource overheads incurred when allocating a device. Overheads can be specified as a fixed cost per pod referencing the claim, a variable cost per container reference, or both. Kubelet accounts for this overhead by adding it to both the pod-level and container-level cgroups of referencing containers.
     */
    @JsonProperty("perContainer")
    public void setPerContainer(Quantity perContainer) {
        this.perContainer = perContainer;
    }

    /**
     * NodeAllocatableOverhead defines auxiliary resource overheads incurred when allocating a device. Overheads can be specified as a fixed cost per pod referencing the claim, a variable cost per container reference, or both. Kubelet accounts for this overhead by adding it to both the pod-level and container-level cgroups of referencing containers.
     */
    @JsonProperty("perPod")
    public Quantity getPerPod() {
        return perPod;
    }

    /**
     * NodeAllocatableOverhead defines auxiliary resource overheads incurred when allocating a device. Overheads can be specified as a fixed cost per pod referencing the claim, a variable cost per container reference, or both. Kubelet accounts for this overhead by adding it to both the pod-level and container-level cgroups of referencing containers.
     */
    @JsonProperty("perPod")
    public void setPerPod(Quantity perPod) {
        this.perPod = perPod;
    }

    @JsonIgnore
    public NodeAllocatableOverheadBuilder edit() {
        return new NodeAllocatableOverheadBuilder(this);
    }

    @JsonIgnore
    public NodeAllocatableOverheadBuilder toBuilder() {
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
