
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * AzureASOManagedMachinePoolStatus defines the observed state of AzureASOManagedMachinePool.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ready",
    "replicas",
    "resources"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class AzureASOManagedMachinePoolStatus implements Editable<AzureASOManagedMachinePoolStatusBuilder>, KubernetesResource
{

    @JsonProperty("ready")
    private Boolean ready;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceStatus> resources = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureASOManagedMachinePoolStatus() {
    }

    public AzureASOManagedMachinePoolStatus(Boolean ready, Integer replicas, List<ResourceStatus> resources) {
        super();
        this.ready = ready;
        this.replicas = replicas;
        this.resources = resources;
    }

    /**
     * Ready represents whether or not the infrastructure is ready to be used. It fulfills Cluster API's machine pool infrastructure provider contract.
     */
    @JsonProperty("ready")
    public Boolean getReady() {
        return ready;
    }

    /**
     * Ready represents whether or not the infrastructure is ready to be used. It fulfills Cluster API's machine pool infrastructure provider contract.
     */
    @JsonProperty("ready")
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    /**
     * Replicas is the current number of provisioned replicas. It fulfills Cluster API's machine pool infrastructure provider contract.
     */
    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    /**
     * Replicas is the current number of provisioned replicas. It fulfills Cluster API's machine pool infrastructure provider contract.
     */
    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    /**
     * AzureASOManagedMachinePoolStatus defines the observed state of AzureASOManagedMachinePool.
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ResourceStatus> getResources() {
        return resources;
    }

    /**
     * AzureASOManagedMachinePoolStatus defines the observed state of AzureASOManagedMachinePool.
     */
    @JsonProperty("resources")
    public void setResources(List<ResourceStatus> resources) {
        this.resources = resources;
    }

    @JsonIgnore
    public AzureASOManagedMachinePoolStatusBuilder edit() {
        return new AzureASOManagedMachinePoolStatusBuilder(this);
    }

    @JsonIgnore
    public AzureASOManagedMachinePoolStatusBuilder toBuilder() {
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
