
package io.fabric8.kubernetes.api.model.resource.v1alpha2;

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
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * PodSchedulingContextSpec describes where resources for the Pod are needed.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "potentialNodes",
    "selectedNode"
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
public class PodSchedulingContextSpec implements Editable<PodSchedulingContextSpecBuilder>, KubernetesResource
{

    @JsonProperty("potentialNodes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> potentialNodes = new ArrayList<>();
    @JsonProperty("selectedNode")
    private String selectedNode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodSchedulingContextSpec() {
    }

    public PodSchedulingContextSpec(List<String> potentialNodes, String selectedNode) {
        super();
        this.potentialNodes = potentialNodes;
        this.selectedNode = selectedNode;
    }

    /**
     * PotentialNodes lists nodes where the Pod might be able to run.<br><p> <br><p> The size of this field is limited to 128. This is large enough for many clusters. Larger clusters may need more attempts to find a node that suits all pending resources. This may get increased in the future, but not reduced.
     */
    @JsonProperty("potentialNodes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPotentialNodes() {
        return potentialNodes;
    }

    /**
     * PotentialNodes lists nodes where the Pod might be able to run.<br><p> <br><p> The size of this field is limited to 128. This is large enough for many clusters. Larger clusters may need more attempts to find a node that suits all pending resources. This may get increased in the future, but not reduced.
     */
    @JsonProperty("potentialNodes")
    public void setPotentialNodes(List<String> potentialNodes) {
        this.potentialNodes = potentialNodes;
    }

    /**
     * SelectedNode is the node for which allocation of ResourceClaims that are referenced by the Pod and that use "WaitForFirstConsumer" allocation is to be attempted.
     */
    @JsonProperty("selectedNode")
    public String getSelectedNode() {
        return selectedNode;
    }

    /**
     * SelectedNode is the node for which allocation of ResourceClaims that are referenced by the Pod and that use "WaitForFirstConsumer" allocation is to be attempted.
     */
    @JsonProperty("selectedNode")
    public void setSelectedNode(String selectedNode) {
        this.selectedNode = selectedNode;
    }

    @JsonIgnore
    public PodSchedulingContextSpecBuilder edit() {
        return new PodSchedulingContextSpecBuilder(this);
    }

    @JsonIgnore
    public PodSchedulingContextSpecBuilder toBuilder() {
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
        if (!(o instanceof PodSchedulingContextSpec)) {
            return false;
        }
        PodSchedulingContextSpec other = (PodSchedulingContextSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$potentialNodes = this.getPotentialNodes();
        Object other$potentialNodes = other.getPotentialNodes();
        if (this$potentialNodes == null ? other$potentialNodes != null : !this$potentialNodes.equals(other$potentialNodes)) {
            return false;
        }
        Object this$selectedNode = this.getSelectedNode();
        Object other$selectedNode = other.getSelectedNode();
        if (this$selectedNode == null ? other$selectedNode != null : !this$selectedNode.equals(other$selectedNode)) {
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
        return other instanceof PodSchedulingContextSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $potentialNodes = this.getPotentialNodes();
        result = result * prime + ($potentialNodes == null ? 43 : $potentialNodes.hashCode());
        Object $selectedNode = this.getSelectedNode();
        result = result * prime + ($selectedNode == null ? 43 : $selectedNode.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodSchedulingContextSpec(" + "potentialNodes=" + this.getPotentialNodes() + ", selectedNode=" + this.getSelectedNode() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
