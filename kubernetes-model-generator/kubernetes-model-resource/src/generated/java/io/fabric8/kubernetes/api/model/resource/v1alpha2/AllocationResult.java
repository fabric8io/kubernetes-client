
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
import io.fabric8.kubernetes.api.model.NodeSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AllocationResult contains attributes of an allocated resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availableOnNodes",
    "resourceHandles",
    "shareable"
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
public class AllocationResult implements Editable<AllocationResultBuilder>, KubernetesResource
{

    @JsonProperty("availableOnNodes")
    private NodeSelector availableOnNodes;
    @JsonProperty("resourceHandles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceHandle> resourceHandles = new ArrayList<>();
    @JsonProperty("shareable")
    private Boolean shareable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AllocationResult() {
    }

    public AllocationResult(NodeSelector availableOnNodes, List<ResourceHandle> resourceHandles, Boolean shareable) {
        super();
        this.availableOnNodes = availableOnNodes;
        this.resourceHandles = resourceHandles;
        this.shareable = shareable;
    }

    /**
     * AllocationResult contains attributes of an allocated resource.
     */
    @JsonProperty("availableOnNodes")
    public NodeSelector getAvailableOnNodes() {
        return availableOnNodes;
    }

    /**
     * AllocationResult contains attributes of an allocated resource.
     */
    @JsonProperty("availableOnNodes")
    public void setAvailableOnNodes(NodeSelector availableOnNodes) {
        this.availableOnNodes = availableOnNodes;
    }

    /**
     * ResourceHandles contain the state associated with an allocation that should be maintained throughout the lifetime of a claim. Each ResourceHandle contains data that should be passed to a specific kubelet plugin once it lands on a node. This data is returned by the driver after a successful allocation and is opaque to Kubernetes. Driver documentation may explain to users how to interpret this data if needed.<br><p> <br><p> Setting this field is optional. It has a maximum size of 32 entries. If null (or empty), it is assumed this allocation will be processed by a single kubelet plugin with no ResourceHandle data attached. The name of the kubelet plugin invoked will match the DriverName set in the ResourceClaimStatus this AllocationResult is embedded in.
     */
    @JsonProperty("resourceHandles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourceHandle> getResourceHandles() {
        return resourceHandles;
    }

    /**
     * ResourceHandles contain the state associated with an allocation that should be maintained throughout the lifetime of a claim. Each ResourceHandle contains data that should be passed to a specific kubelet plugin once it lands on a node. This data is returned by the driver after a successful allocation and is opaque to Kubernetes. Driver documentation may explain to users how to interpret this data if needed.<br><p> <br><p> Setting this field is optional. It has a maximum size of 32 entries. If null (or empty), it is assumed this allocation will be processed by a single kubelet plugin with no ResourceHandle data attached. The name of the kubelet plugin invoked will match the DriverName set in the ResourceClaimStatus this AllocationResult is embedded in.
     */
    @JsonProperty("resourceHandles")
    public void setResourceHandles(List<ResourceHandle> resourceHandles) {
        this.resourceHandles = resourceHandles;
    }

    /**
     * Shareable determines whether the resource supports more than one consumer at a time.
     */
    @JsonProperty("shareable")
    public Boolean getShareable() {
        return shareable;
    }

    /**
     * Shareable determines whether the resource supports more than one consumer at a time.
     */
    @JsonProperty("shareable")
    public void setShareable(Boolean shareable) {
        this.shareable = shareable;
    }

    @JsonIgnore
    public AllocationResultBuilder edit() {
        return new AllocationResultBuilder(this);
    }

    @JsonIgnore
    public AllocationResultBuilder toBuilder() {
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
