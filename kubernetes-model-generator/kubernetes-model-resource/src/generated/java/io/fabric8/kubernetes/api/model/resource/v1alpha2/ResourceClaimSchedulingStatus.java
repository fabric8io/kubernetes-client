
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
 * ResourceClaimSchedulingStatus contains information about one particular ResourceClaim with "WaitForFirstConsumer" allocation mode.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "unsuitableNodes"
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
public class ResourceClaimSchedulingStatus implements Editable<ResourceClaimSchedulingStatusBuilder>, KubernetesResource
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("unsuitableNodes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> unsuitableNodes = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResourceClaimSchedulingStatus() {
    }

    public ResourceClaimSchedulingStatus(String name, List<String> unsuitableNodes) {
        super();
        this.name = name;
        this.unsuitableNodes = unsuitableNodes;
    }

    /**
     * Name matches the pod.spec.resourceClaims[&#42;].Name field.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name matches the pod.spec.resourceClaims[&#42;].Name field.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * UnsuitableNodes lists nodes that the ResourceClaim cannot be allocated for.<br><p> <br><p> The size of this field is limited to 128, the same as for PodSchedulingSpec.PotentialNodes. This may get increased in the future, but not reduced.
     */
    @JsonProperty("unsuitableNodes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getUnsuitableNodes() {
        return unsuitableNodes;
    }

    /**
     * UnsuitableNodes lists nodes that the ResourceClaim cannot be allocated for.<br><p> <br><p> The size of this field is limited to 128, the same as for PodSchedulingSpec.PotentialNodes. This may get increased in the future, but not reduced.
     */
    @JsonProperty("unsuitableNodes")
    public void setUnsuitableNodes(List<String> unsuitableNodes) {
        this.unsuitableNodes = unsuitableNodes;
    }

    @JsonIgnore
    public ResourceClaimSchedulingStatusBuilder edit() {
        return new ResourceClaimSchedulingStatusBuilder(this);
    }

    @JsonIgnore
    public ResourceClaimSchedulingStatusBuilder toBuilder() {
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
        if (!(o instanceof ResourceClaimSchedulingStatus)) {
            return false;
        }
        ResourceClaimSchedulingStatus other = (ResourceClaimSchedulingStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$unsuitableNodes = this.getUnsuitableNodes();
        Object other$unsuitableNodes = other.getUnsuitableNodes();
        if (this$unsuitableNodes == null ? other$unsuitableNodes != null : !this$unsuitableNodes.equals(other$unsuitableNodes)) {
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
        return other instanceof ResourceClaimSchedulingStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $unsuitableNodes = this.getUnsuitableNodes();
        result = result * prime + ($unsuitableNodes == null ? 43 : $unsuitableNodes.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResourceClaimSchedulingStatus(" + "name=" + this.getName() + ", unsuitableNodes=" + this.getUnsuitableNodes() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
