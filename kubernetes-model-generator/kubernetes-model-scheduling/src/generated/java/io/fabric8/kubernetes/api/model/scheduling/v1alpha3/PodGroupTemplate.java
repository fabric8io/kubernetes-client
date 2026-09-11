
package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

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
 * PodGroupTemplate represents a template for a set of pods with a scheduling policy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disruptionMode",
    "name",
    "preemptionPolicy",
    "priority",
    "priorityClassName",
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
public class PodGroupTemplate implements Editable<PodGroupTemplateBuilder>, KubernetesResource
{

    @JsonProperty("disruptionMode")
    private DisruptionMode disruptionMode;
    @JsonProperty("name")
    private String name;
    @JsonProperty("preemptionPolicy")
    private String preemptionPolicy;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("resourceClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodGroupResourceClaim> resourceClaims = new ArrayList<>();
    @JsonProperty("schedulingConstraints")
    private PodGroupSchedulingConstraints schedulingConstraints;
    @JsonProperty("schedulingPolicy")
    private PodGroupSchedulingPolicy schedulingPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodGroupTemplate() {
    }

    public PodGroupTemplate(DisruptionMode disruptionMode, String name, String preemptionPolicy, Integer priority, String priorityClassName, List<PodGroupResourceClaim> resourceClaims, PodGroupSchedulingConstraints schedulingConstraints, PodGroupSchedulingPolicy schedulingPolicy) {
        super();
        this.disruptionMode = disruptionMode;
        this.name = name;
        this.preemptionPolicy = preemptionPolicy;
        this.priority = priority;
        this.priorityClassName = priorityClassName;
        this.resourceClaims = resourceClaims;
        this.schedulingConstraints = schedulingConstraints;
        this.schedulingPolicy = schedulingPolicy;
    }

    /**
     * PodGroupTemplate represents a template for a set of pods with a scheduling policy.
     */
    @JsonProperty("disruptionMode")
    public DisruptionMode getDisruptionMode() {
        return disruptionMode;
    }

    /**
     * PodGroupTemplate represents a template for a set of pods with a scheduling policy.
     */
    @JsonProperty("disruptionMode")
    public void setDisruptionMode(DisruptionMode disruptionMode) {
        this.disruptionMode = disruptionMode;
    }

    /**
     * name is a unique identifier for the PodGroupTemplate within the Workload. It must be a DNS label. This field is immutable.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is a unique identifier for the PodGroupTemplate within the Workload. It must be a DNS label. This field is immutable.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * preemptionPolicy is the Policy for preempting pods/podgroups with lower priority. One of Never, PreemptLowerPriority. This field is immutable. This field is available only when the PodGroupPreemptionPolicy feature gate is enabled.
     */
    @JsonProperty("preemptionPolicy")
    public String getPreemptionPolicy() {
        return preemptionPolicy;
    }

    /**
     * preemptionPolicy is the Policy for preempting pods/podgroups with lower priority. One of Never, PreemptLowerPriority. This field is immutable. This field is available only when the PodGroupPreemptionPolicy feature gate is enabled.
     */
    @JsonProperty("preemptionPolicy")
    public void setPreemptionPolicy(String preemptionPolicy) {
        this.preemptionPolicy = preemptionPolicy;
    }

    /**
     * priority is the value of priority of pod groups created from this template. Various system components use this field to find the priority of the pod group. The higher the value, the higher the priority. This field is immutable.
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * priority is the value of priority of pod groups created from this template. Various system components use this field to find the priority of the pod group. The higher the value, the higher the priority. This field is immutable.
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * priorityClassName indicates the priority that should be considered when scheduling a pod group created from this template. This field is immutable.
     */
    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    /**
     * priorityClassName indicates the priority that should be considered when scheduling a pod group created from this template. This field is immutable.
     */
    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    /**
     * resourceClaims defines which ResourceClaims may be shared among Pods in the group. Pods consume the devices allocated to a PodGroup's claim by defining a claim in its own Spec.ResourceClaims that matches the PodGroup's claim exactly. The claim must have the same name and refer to the same ResourceClaim or ResourceClaimTemplate.<br><p> <br><p> This is a beta-level field and requires that the DRAWorkloadResourceClaims feature gate is enabled.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("resourceClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodGroupResourceClaim> getResourceClaims() {
        return resourceClaims;
    }

    /**
     * resourceClaims defines which ResourceClaims may be shared among Pods in the group. Pods consume the devices allocated to a PodGroup's claim by defining a claim in its own Spec.ResourceClaims that matches the PodGroup's claim exactly. The claim must have the same name and refer to the same ResourceClaim or ResourceClaimTemplate.<br><p> <br><p> This is a beta-level field and requires that the DRAWorkloadResourceClaims feature gate is enabled.<br><p> <br><p> This field is immutable.
     */
    @JsonProperty("resourceClaims")
    public void setResourceClaims(List<PodGroupResourceClaim> resourceClaims) {
        this.resourceClaims = resourceClaims;
    }

    /**
     * PodGroupTemplate represents a template for a set of pods with a scheduling policy.
     */
    @JsonProperty("schedulingConstraints")
    public PodGroupSchedulingConstraints getSchedulingConstraints() {
        return schedulingConstraints;
    }

    /**
     * PodGroupTemplate represents a template for a set of pods with a scheduling policy.
     */
    @JsonProperty("schedulingConstraints")
    public void setSchedulingConstraints(PodGroupSchedulingConstraints schedulingConstraints) {
        this.schedulingConstraints = schedulingConstraints;
    }

    /**
     * PodGroupTemplate represents a template for a set of pods with a scheduling policy.
     */
    @JsonProperty("schedulingPolicy")
    public PodGroupSchedulingPolicy getSchedulingPolicy() {
        return schedulingPolicy;
    }

    /**
     * PodGroupTemplate represents a template for a set of pods with a scheduling policy.
     */
    @JsonProperty("schedulingPolicy")
    public void setSchedulingPolicy(PodGroupSchedulingPolicy schedulingPolicy) {
        this.schedulingPolicy = schedulingPolicy;
    }

    @JsonIgnore
    public PodGroupTemplateBuilder edit() {
        return new PodGroupTemplateBuilder(this);
    }

    @JsonIgnore
    public PodGroupTemplateBuilder toBuilder() {
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
