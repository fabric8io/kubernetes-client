
package io.fabric8.kubernetes.api.model.scheduling.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * WorkloadSpec defines the desired state of a Workload.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "controllerRef",
    "podGroups"
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
public class WorkloadSpec implements Editable<WorkloadSpecBuilder>, KubernetesResource
{

    @JsonProperty("controllerRef")
    private TypedLocalObjectReference controllerRef;
    @JsonProperty("podGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodGroup> podGroups = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WorkloadSpec() {
    }

    public WorkloadSpec(TypedLocalObjectReference controllerRef, List<PodGroup> podGroups) {
        super();
        this.controllerRef = controllerRef;
        this.podGroups = podGroups;
    }

    /**
     * WorkloadSpec defines the desired state of a Workload.
     */
    @JsonProperty("controllerRef")
    public TypedLocalObjectReference getControllerRef() {
        return controllerRef;
    }

    /**
     * WorkloadSpec defines the desired state of a Workload.
     */
    @JsonProperty("controllerRef")
    public void setControllerRef(TypedLocalObjectReference controllerRef) {
        this.controllerRef = controllerRef;
    }

    /**
     * PodGroups is the list of pod groups that make up the Workload. The maximum number of pod groups is 8. This field is immutable.
     */
    @JsonProperty("podGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodGroup> getPodGroups() {
        return podGroups;
    }

    /**
     * PodGroups is the list of pod groups that make up the Workload. The maximum number of pod groups is 8. This field is immutable.
     */
    @JsonProperty("podGroups")
    public void setPodGroups(List<PodGroup> podGroups) {
        this.podGroups = podGroups;
    }

    @JsonIgnore
    public WorkloadSpecBuilder edit() {
        return new WorkloadSpecBuilder(this);
    }

    @JsonIgnore
    public WorkloadSpecBuilder toBuilder() {
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
