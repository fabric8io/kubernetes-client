
package io.fabric8.kubernetes.api.model.scheduling.v1beta1;

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
 * CompositePodGroupTemplate represents a template for a CompositePodGroup with a scheduling policy.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "compositePodGroupTemplates",
    "disruptionMode",
    "name",
    "podGroupTemplates",
    "preemptionPolicy",
    "priority",
    "priorityClassName",
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
public class CompositePodGroupTemplate implements Editable<CompositePodGroupTemplateBuilder>, KubernetesResource
{

    @JsonProperty("compositePodGroupTemplates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.scheduling.v1beta1.CompositePodGroupTemplate> compositePodGroupTemplates = new ArrayList<>();
    @JsonProperty("disruptionMode")
    private CompositeDisruptionMode disruptionMode;
    @JsonProperty("name")
    private String name;
    @JsonProperty("podGroupTemplates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PodGroupTemplate> podGroupTemplates = new ArrayList<>();
    @JsonProperty("preemptionPolicy")
    private String preemptionPolicy;
    @JsonProperty("priority")
    private Integer priority;
    @JsonProperty("priorityClassName")
    private String priorityClassName;
    @JsonProperty("schedulingConstraints")
    private CompositePodGroupSchedulingConstraints schedulingConstraints;
    @JsonProperty("schedulingPolicy")
    private CompositePodGroupSchedulingPolicy schedulingPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CompositePodGroupTemplate() {
    }

    public CompositePodGroupTemplate(List<io.fabric8.kubernetes.api.model.scheduling.v1beta1.CompositePodGroupTemplate> compositePodGroupTemplates, CompositeDisruptionMode disruptionMode, String name, List<PodGroupTemplate> podGroupTemplates, String preemptionPolicy, Integer priority, String priorityClassName, CompositePodGroupSchedulingConstraints schedulingConstraints, CompositePodGroupSchedulingPolicy schedulingPolicy) {
        super();
        this.compositePodGroupTemplates = compositePodGroupTemplates;
        this.disruptionMode = disruptionMode;
        this.name = name;
        this.podGroupTemplates = podGroupTemplates;
        this.preemptionPolicy = preemptionPolicy;
        this.priority = priority;
        this.priorityClassName = priorityClassName;
        this.schedulingConstraints = schedulingConstraints;
        this.schedulingPolicy = schedulingPolicy;
    }

    /**
     * compositePodGroupTemplates is the list of templates for children CompositePodGroups. The maximum number of templates is 8. At least one entry in CompositePodGroupTemplates or PodGroupTemplates must be set.
     */
    @JsonProperty("compositePodGroupTemplates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<io.fabric8.kubernetes.api.model.scheduling.v1beta1.CompositePodGroupTemplate> getCompositePodGroupTemplates() {
        return compositePodGroupTemplates;
    }

    /**
     * compositePodGroupTemplates is the list of templates for children CompositePodGroups. The maximum number of templates is 8. At least one entry in CompositePodGroupTemplates or PodGroupTemplates must be set.
     */
    @JsonProperty("compositePodGroupTemplates")
    public void setCompositePodGroupTemplates(List<io.fabric8.kubernetes.api.model.scheduling.v1beta1.CompositePodGroupTemplate> compositePodGroupTemplates) {
        this.compositePodGroupTemplates = compositePodGroupTemplates;
    }

    /**
     * CompositePodGroupTemplate represents a template for a CompositePodGroup with a scheduling policy.
     */
    @JsonProperty("disruptionMode")
    public CompositeDisruptionMode getDisruptionMode() {
        return disruptionMode;
    }

    /**
     * CompositePodGroupTemplate represents a template for a CompositePodGroup with a scheduling policy.
     */
    @JsonProperty("disruptionMode")
    public void setDisruptionMode(CompositeDisruptionMode disruptionMode) {
        this.disruptionMode = disruptionMode;
    }

    /**
     * name is a unique identifier for the CompositePodGroupTemplate within the Workload. It must be a DNS label. This field is required.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is a unique identifier for the CompositePodGroupTemplate within the Workload. It must be a DNS label. This field is required.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * podGroupTemplates is the list of templates for children PodGroups. The maximum number of templates is 8. At least one entry in CompositePodGroupTemplates or PodGroupTemplates must be set.
     */
    @JsonProperty("podGroupTemplates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PodGroupTemplate> getPodGroupTemplates() {
        return podGroupTemplates;
    }

    /**
     * podGroupTemplates is the list of templates for children PodGroups. The maximum number of templates is 8. At least one entry in CompositePodGroupTemplates or PodGroupTemplates must be set.
     */
    @JsonProperty("podGroupTemplates")
    public void setPodGroupTemplates(List<PodGroupTemplate> podGroupTemplates) {
        this.podGroupTemplates = podGroupTemplates;
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
     * priority is the value of priority of composite pod groups created from this template. Various system components use this field to find the priority of the composite pod group. When Priority Admission Controller is enabled, it prevents users from setting this field. The admission controller populates this field from PriorityClassName. The higher the value, the higher the priority. This field is immutable.
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * priority is the value of priority of composite pod groups created from this template. Various system components use this field to find the priority of the composite pod group. When Priority Admission Controller is enabled, it prevents users from setting this field. The admission controller populates this field from PriorityClassName. The higher the value, the higher the priority. This field is immutable.
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * priorityClassName indicates the priority that should be considered when scheduling a composite pod group created from this template. If no priority class is specified, admission control can set this to the global default priority class if it exists. Otherwise, composite pod groups created from this template will have the priority set to zero. This field is immutable.
     */
    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    /**
     * priorityClassName indicates the priority that should be considered when scheduling a composite pod group created from this template. If no priority class is specified, admission control can set this to the global default priority class if it exists. Otherwise, composite pod groups created from this template will have the priority set to zero. This field is immutable.
     */
    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    /**
     * CompositePodGroupTemplate represents a template for a CompositePodGroup with a scheduling policy.
     */
    @JsonProperty("schedulingConstraints")
    public CompositePodGroupSchedulingConstraints getSchedulingConstraints() {
        return schedulingConstraints;
    }

    /**
     * CompositePodGroupTemplate represents a template for a CompositePodGroup with a scheduling policy.
     */
    @JsonProperty("schedulingConstraints")
    public void setSchedulingConstraints(CompositePodGroupSchedulingConstraints schedulingConstraints) {
        this.schedulingConstraints = schedulingConstraints;
    }

    /**
     * CompositePodGroupTemplate represents a template for a CompositePodGroup with a scheduling policy.
     */
    @JsonProperty("schedulingPolicy")
    public CompositePodGroupSchedulingPolicy getSchedulingPolicy() {
        return schedulingPolicy;
    }

    /**
     * CompositePodGroupTemplate represents a template for a CompositePodGroup with a scheduling policy.
     */
    @JsonProperty("schedulingPolicy")
    public void setSchedulingPolicy(CompositePodGroupSchedulingPolicy schedulingPolicy) {
        this.schedulingPolicy = schedulingPolicy;
    }

    @JsonIgnore
    public CompositePodGroupTemplateBuilder edit() {
        return new CompositePodGroupTemplateBuilder(this);
    }

    @JsonIgnore
    public CompositePodGroupTemplateBuilder toBuilder() {
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
