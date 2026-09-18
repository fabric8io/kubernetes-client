
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

/**
 * NodeSlicePoolSpec defines the desired state of NodeSlicePool
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "range",
    "sliceSize"
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
public class NodeSlicePoolSpec implements Editable<NodeSlicePoolSpecBuilder>, KubernetesResource
{

    @JsonProperty("range")
    private String range;
    @JsonProperty("sliceSize")
    private String sliceSize;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NodeSlicePoolSpec() {
    }

    public NodeSlicePoolSpec(String range, String sliceSize) {
        super();
        this.range = range;
        this.sliceSize = sliceSize;
    }

    /**
     * Range is a RFC 4632/4291-style string that represents an IP address and prefix length in CIDR notation<br><p> this refers to the entire range where the node is allocated a subset
     */
    @JsonProperty("range")
    public String getRange() {
        return range;
    }

    /**
     * Range is a RFC 4632/4291-style string that represents an IP address and prefix length in CIDR notation<br><p> this refers to the entire range where the node is allocated a subset
     */
    @JsonProperty("range")
    public void setRange(String range) {
        this.range = range;
    }

    /**
     * SliceSize is the size of subnets or slices of the range that each node will be assigned
     */
    @JsonProperty("sliceSize")
    public String getSliceSize() {
        return sliceSize;
    }

    /**
     * SliceSize is the size of subnets or slices of the range that each node will be assigned
     */
    @JsonProperty("sliceSize")
    public void setSliceSize(String sliceSize) {
        this.sliceSize = sliceSize;
    }

    @JsonIgnore
    public NodeSlicePoolSpecBuilder edit() {
        return new NodeSlicePoolSpecBuilder(this);
    }

    @JsonIgnore
    public NodeSlicePoolSpecBuilder toBuilder() {
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
        if (!(o instanceof NodeSlicePoolSpec)) {
            return false;
        }
        NodeSlicePoolSpec other = (NodeSlicePoolSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$range = this.getRange();
        Object other$range = other.getRange();
        if (this$range == null ? other$range != null : !this$range.equals(other$range)) {
            return false;
        }
        Object this$sliceSize = this.getSliceSize();
        Object other$sliceSize = other.getSliceSize();
        if (this$sliceSize == null ? other$sliceSize != null : !this$sliceSize.equals(other$sliceSize)) {
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
        return other instanceof NodeSlicePoolSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $range = this.getRange();
        result = result * prime + ($range == null ? 43 : $range.hashCode());
        Object $sliceSize = this.getSliceSize();
        result = result * prime + ($sliceSize == null ? 43 : $sliceSize.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "NodeSlicePoolSpec(" + "range=" + this.getRange() + ", sliceSize=" + this.getSliceSize() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
