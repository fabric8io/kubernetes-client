
package io.fabric8.openshift.api.model.whereabouts.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nodeName",
    "sliceRange"
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
public class NodeSlicePoolStatusAllocations implements Editable<NodeSlicePoolStatusAllocationsBuilder>, KubernetesResource
{

    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("sliceRange")
    private String sliceRange;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeSlicePoolStatusAllocations() {
    }

    public NodeSlicePoolStatusAllocations(String nodeName, String sliceRange) {
        super();
        this.nodeName = nodeName;
        this.sliceRange = sliceRange;
    }

    /**
     * NodeName is the name of the node assigned to this slice, empty node name is an available slice for assignment
     */
    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    /**
     * NodeName is the name of the node assigned to this slice, empty node name is an available slice for assignment
     */
    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * SliceRange is the subnet of this slice
     */
    @JsonProperty("sliceRange")
    public String getSliceRange() {
        return sliceRange;
    }

    /**
     * SliceRange is the subnet of this slice
     */
    @JsonProperty("sliceRange")
    public void setSliceRange(String sliceRange) {
        this.sliceRange = sliceRange;
    }

    @JsonIgnore
    public NodeSlicePoolStatusAllocationsBuilder edit() {
        return new NodeSlicePoolStatusAllocationsBuilder(this);
    }

    @JsonIgnore
    public NodeSlicePoolStatusAllocationsBuilder toBuilder() {
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
        if (!(o instanceof NodeSlicePoolStatusAllocations)) {
            return false;
        }
        NodeSlicePoolStatusAllocations other = (NodeSlicePoolStatusAllocations) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$nodeName = this.getNodeName();
        Object other$nodeName = other.getNodeName();
        if (this$nodeName == null ? other$nodeName != null : !this$nodeName.equals(other$nodeName)) {
            return false;
        }
        Object this$sliceRange = this.getSliceRange();
        Object other$sliceRange = other.getSliceRange();
        if (this$sliceRange == null ? other$sliceRange != null : !this$sliceRange.equals(other$sliceRange)) {
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
        return other instanceof NodeSlicePoolStatusAllocations;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $nodeName = this.getNodeName();
        result = result * prime + ($nodeName == null ? 43 : $nodeName.hashCode());
        Object $sliceRange = this.getSliceRange();
        result = result * prime + ($sliceRange == null ? 43 : $sliceRange.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeSlicePoolStatusAllocations(" + "nodeName=" + this.getNodeName() + ", sliceRange=" + this.getSliceRange() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
