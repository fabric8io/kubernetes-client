
package io.fabric8.kubernetes.api.model.batch.v1;

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
import io.fabric8.kubernetes.api.model.scheduling.v1alpha3.WorkloadPodGroupDisruptionMode;
import io.fabric8.kubernetes.api.model.scheduling.v1alpha3.WorkloadPodGroupResourceClaim;
import io.fabric8.kubernetes.api.model.scheduling.v1alpha3.WorkloadPodGroupSchedulingConstraints;
import io.fabric8.kubernetes.api.model.scheduling.v1alpha3.WorkloadPodGroupSchedulingPolicy;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * JobSchedulingConfiguration composes the reusable workload-aware scheduling building blocks.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disruptionMode",
    "resourceClaims",
    "schedulingConstraints",
    "schedulingPolicy"
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
public class JobSchedulingConfiguration implements Editable<JobSchedulingConfigurationBuilder>, KubernetesResource
{

    @JsonProperty("disruptionMode")
    private WorkloadPodGroupDisruptionMode disruptionMode;
    @JsonProperty("resourceClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WorkloadPodGroupResourceClaim> resourceClaims = new ArrayList<>();
    @JsonProperty("schedulingConstraints")
    private WorkloadPodGroupSchedulingConstraints schedulingConstraints;
    @JsonProperty("schedulingPolicy")
    private WorkloadPodGroupSchedulingPolicy schedulingPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JobSchedulingConfiguration() {
    }

    public JobSchedulingConfiguration(WorkloadPodGroupDisruptionMode disruptionMode, List<WorkloadPodGroupResourceClaim> resourceClaims, WorkloadPodGroupSchedulingConstraints schedulingConstraints, WorkloadPodGroupSchedulingPolicy schedulingPolicy) {
        super();
        this.disruptionMode = disruptionMode;
        this.resourceClaims = resourceClaims;
        this.schedulingConstraints = schedulingConstraints;
        this.schedulingPolicy = schedulingPolicy;
    }

    /**
     * JobSchedulingConfiguration composes the reusable workload-aware scheduling building blocks.
     */
    @JsonProperty("disruptionMode")
    public WorkloadPodGroupDisruptionMode getDisruptionMode() {
        return disruptionMode;
    }

    /**
     * JobSchedulingConfiguration composes the reusable workload-aware scheduling building blocks.
     */
    @JsonProperty("disruptionMode")
    public void setDisruptionMode(WorkloadPodGroupDisruptionMode disruptionMode) {
        this.disruptionMode = disruptionMode;
    }

    /**
     * ResourceClaims defines which ResourceClaims may be shared among Pods in the Job. Pods consume the devices allocated to a PodGroup's claim by defining a claim in its own Spec.ResourceClaims that matches the PodGroup's claim exactly. The claim must have the same name and refer to the same ResourceClaim or ResourceClaimTemplate. At most 4 claims may be set, matching the limit on the resulting PodGroup. This list is immutable after creation: entries may neither be added, removed, nor modified.
     */
    @JsonProperty("resourceClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WorkloadPodGroupResourceClaim> getResourceClaims() {
        return resourceClaims;
    }

    /**
     * ResourceClaims defines which ResourceClaims may be shared among Pods in the Job. Pods consume the devices allocated to a PodGroup's claim by defining a claim in its own Spec.ResourceClaims that matches the PodGroup's claim exactly. The claim must have the same name and refer to the same ResourceClaim or ResourceClaimTemplate. At most 4 claims may be set, matching the limit on the resulting PodGroup. This list is immutable after creation: entries may neither be added, removed, nor modified.
     */
    @JsonProperty("resourceClaims")
    public void setResourceClaims(List<WorkloadPodGroupResourceClaim> resourceClaims) {
        this.resourceClaims = resourceClaims;
    }

    /**
     * JobSchedulingConfiguration composes the reusable workload-aware scheduling building blocks.
     */
    @JsonProperty("schedulingConstraints")
    public WorkloadPodGroupSchedulingConstraints getSchedulingConstraints() {
        return schedulingConstraints;
    }

    /**
     * JobSchedulingConfiguration composes the reusable workload-aware scheduling building blocks.
     */
    @JsonProperty("schedulingConstraints")
    public void setSchedulingConstraints(WorkloadPodGroupSchedulingConstraints schedulingConstraints) {
        this.schedulingConstraints = schedulingConstraints;
    }

    /**
     * JobSchedulingConfiguration composes the reusable workload-aware scheduling building blocks.
     */
    @JsonProperty("schedulingPolicy")
    public WorkloadPodGroupSchedulingPolicy getSchedulingPolicy() {
        return schedulingPolicy;
    }

    /**
     * JobSchedulingConfiguration composes the reusable workload-aware scheduling building blocks.
     */
    @JsonProperty("schedulingPolicy")
    public void setSchedulingPolicy(WorkloadPodGroupSchedulingPolicy schedulingPolicy) {
        this.schedulingPolicy = schedulingPolicy;
    }

    @JsonIgnore
    public JobSchedulingConfigurationBuilder edit() {
        return new JobSchedulingConfigurationBuilder(this);
    }

    @JsonIgnore
    public JobSchedulingConfigurationBuilder toBuilder() {
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
