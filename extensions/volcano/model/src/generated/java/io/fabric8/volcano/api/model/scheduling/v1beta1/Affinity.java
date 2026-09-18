
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
 * Affinity is a group of affinity scheduling rules.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nodeGroupAffinity",
    "nodeGroupAntiAffinity"
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
public class Affinity implements Editable<AffinityBuilder>, KubernetesResource
{

    @JsonProperty("nodeGroupAffinity")
    private NodeGroupAffinity nodeGroupAffinity;
    @JsonProperty("nodeGroupAntiAffinity")
    private NodeGroupAntiAffinity nodeGroupAntiAffinity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Affinity() {
    }

    public Affinity(NodeGroupAffinity nodeGroupAffinity, NodeGroupAntiAffinity nodeGroupAntiAffinity) {
        super();
        this.nodeGroupAffinity = nodeGroupAffinity;
        this.nodeGroupAntiAffinity = nodeGroupAntiAffinity;
    }

    /**
     * Affinity is a group of affinity scheduling rules.
     */
    @JsonProperty("nodeGroupAffinity")
    public NodeGroupAffinity getNodeGroupAffinity() {
        return nodeGroupAffinity;
    }

    /**
     * Affinity is a group of affinity scheduling rules.
     */
    @JsonProperty("nodeGroupAffinity")
    public void setNodeGroupAffinity(NodeGroupAffinity nodeGroupAffinity) {
        this.nodeGroupAffinity = nodeGroupAffinity;
    }

    /**
     * Affinity is a group of affinity scheduling rules.
     */
    @JsonProperty("nodeGroupAntiAffinity")
    public NodeGroupAntiAffinity getNodeGroupAntiAffinity() {
        return nodeGroupAntiAffinity;
    }

    /**
     * Affinity is a group of affinity scheduling rules.
     */
    @JsonProperty("nodeGroupAntiAffinity")
    public void setNodeGroupAntiAffinity(NodeGroupAntiAffinity nodeGroupAntiAffinity) {
        this.nodeGroupAntiAffinity = nodeGroupAntiAffinity;
    }

    @JsonIgnore
    public AffinityBuilder edit() {
        return new AffinityBuilder(this);
    }

    @JsonIgnore
    public AffinityBuilder toBuilder() {
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
        if (!(o instanceof Affinity)) {
            return false;
        }
        Affinity other = (Affinity) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$nodeGroupAffinity = this.getNodeGroupAffinity();
        Object other$nodeGroupAffinity = other.getNodeGroupAffinity();
        if (this$nodeGroupAffinity == null ? other$nodeGroupAffinity != null : !this$nodeGroupAffinity.equals(other$nodeGroupAffinity)) {
            return false;
        }
        Object this$nodeGroupAntiAffinity = this.getNodeGroupAntiAffinity();
        Object other$nodeGroupAntiAffinity = other.getNodeGroupAntiAffinity();
        if (this$nodeGroupAntiAffinity == null ? other$nodeGroupAntiAffinity != null : !this$nodeGroupAntiAffinity.equals(other$nodeGroupAntiAffinity)) {
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
        return other instanceof Affinity;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $nodeGroupAffinity = this.getNodeGroupAffinity();
        result = result * prime + ($nodeGroupAffinity == null ? 43 : $nodeGroupAffinity.hashCode());
        Object $nodeGroupAntiAffinity = this.getNodeGroupAntiAffinity();
        result = result * prime + ($nodeGroupAntiAffinity == null ? 43 : $nodeGroupAntiAffinity.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Affinity(" + "nodeGroupAffinity=" + this.getNodeGroupAffinity() + ", nodeGroupAntiAffinity=" + this.getNodeGroupAntiAffinity() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
