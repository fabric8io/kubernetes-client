
package io.fabric8.volcano.api.model.nodeinfo.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * PodAllocation records the numa resource allocation for all containers in a pod
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerAllocations",
    "name",
    "namespace",
    "uid"
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
public class PodAllocation implements Editable<PodAllocationBuilder>, KubernetesResource
{

    @JsonProperty("containerAllocations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ContainerAllocation> containerAllocations = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("uid")
    private String uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodAllocation() {
    }

    public PodAllocation(List<ContainerAllocation> containerAllocations, String name, String namespace, String uid) {
        super();
        this.containerAllocations = containerAllocations;
        this.name = name;
        this.namespace = namespace;
        this.uid = uid;
    }

    /**
     * Specifies the per-container numa resource allocation of the pod
     */
    @JsonProperty("containerAllocations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ContainerAllocation> getContainerAllocations() {
        return containerAllocations;
    }

    /**
     * Specifies the per-container numa resource allocation of the pod
     */
    @JsonProperty("containerAllocations")
    public void setContainerAllocations(List<ContainerAllocation> containerAllocations) {
        this.containerAllocations = containerAllocations;
    }

    /**
     * Specifies the name of the pod
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Specifies the name of the pod
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Specifies the namespace of the pod
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * Specifies the namespace of the pod
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * Specifies the uid of the pod
     */
    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    /**
     * Specifies the uid of the pod
     */
    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public PodAllocationBuilder edit() {
        return new PodAllocationBuilder(this);
    }

    @JsonIgnore
    public PodAllocationBuilder toBuilder() {
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
