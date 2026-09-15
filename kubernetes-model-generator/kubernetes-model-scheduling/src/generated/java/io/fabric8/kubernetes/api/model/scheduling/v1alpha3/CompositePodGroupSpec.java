
package io.fabric8.kubernetes.api.model.scheduling.v1alpha3;

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
 * CompositePodGroupSpec defines the desired state of CompositePodGroup.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "disruptionMode",
    "parentCompositePodGroupName",
    "preemptionPolicy",
    "priority",
    "priorityClassName",
    "schedulingConstraints",
    "schedulingPolicy",
    "workloadRef"
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
public class CompositePodGroupSpec implements Editable<CompositePodGroupSpecBuilder>, KubernetesResource
{

    @JsonProperty("disruptionMode")
    private CompositeDisruptionMode disruptionMode;
    @JsonProperty("parentCompositePodGroupName")
    private String parentCompositePodGroupName;
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
    @JsonProperty("workloadRef")
    private WorkloadReference workloadRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CompositePodGroupSpec() {
    }

    public CompositePodGroupSpec(CompositeDisruptionMode disruptionMode, String parentCompositePodGroupName, String preemptionPolicy, Integer priority, String priorityClassName, CompositePodGroupSchedulingConstraints schedulingConstraints, CompositePodGroupSchedulingPolicy schedulingPolicy, WorkloadReference workloadRef) {
        super();
        this.disruptionMode = disruptionMode;
        this.parentCompositePodGroupName = parentCompositePodGroupName;
        this.preemptionPolicy = preemptionPolicy;
        this.priority = priority;
        this.priorityClassName = priorityClassName;
        this.schedulingConstraints = schedulingConstraints;
        this.schedulingPolicy = schedulingPolicy;
        this.workloadRef = workloadRef;
    }

    /**
     * CompositePodGroupSpec defines the desired state of CompositePodGroup.
     */
    @JsonProperty("disruptionMode")
    public CompositeDisruptionMode getDisruptionMode() {
        return disruptionMode;
    }

    /**
     * CompositePodGroupSpec defines the desired state of CompositePodGroup.
     */
    @JsonProperty("disruptionMode")
    public void setDisruptionMode(CompositeDisruptionMode disruptionMode) {
        this.disruptionMode = disruptionMode;
    }

    /**
     * parentCompositePodGroupName contains the name of the parent composite pod group within the same namespace as this composite pod group. It must be a DNS name. If it's nil, then this composite pod group is a root of a workload's hierarchy. This field is immutable.
     */
    @JsonProperty("parentCompositePodGroupName")
    public String getParentCompositePodGroupName() {
        return parentCompositePodGroupName;
    }

    /**
     * parentCompositePodGroupName contains the name of the parent composite pod group within the same namespace as this composite pod group. It must be a DNS name. If it's nil, then this composite pod group is a root of a workload's hierarchy. This field is immutable.
     */
    @JsonProperty("parentCompositePodGroupName")
    public void setParentCompositePodGroupName(String parentCompositePodGroupName) {
        this.parentCompositePodGroupName = parentCompositePodGroupName;
    }

    /**
     * preemptionPolicy is the Policy for preempting pods/podgroups with lower priority. One of Never, PreemptLowerPriority. Defaults to PreemptLowerPriority if unset. When Priority Admission Controller is enabled, it populates this field from PriorityClassName, and defaults to PreemptLowerPriority if value is unset in PriorityClass. This field is immutable. This field is available only when the PodGroupPreemptionPolicy feature gate is enabled.
     */
    @JsonProperty("preemptionPolicy")
    public String getPreemptionPolicy() {
        return preemptionPolicy;
    }

    /**
     * preemptionPolicy is the Policy for preempting pods/podgroups with lower priority. One of Never, PreemptLowerPriority. Defaults to PreemptLowerPriority if unset. When Priority Admission Controller is enabled, it populates this field from PriorityClassName, and defaults to PreemptLowerPriority if value is unset in PriorityClass. This field is immutable. This field is available only when the PodGroupPreemptionPolicy feature gate is enabled.
     */
    @JsonProperty("preemptionPolicy")
    public void setPreemptionPolicy(String preemptionPolicy) {
        this.preemptionPolicy = preemptionPolicy;
    }

    /**
     * priority is the value of priority of this composite pod group. Various system components use this field to find the priority of the composite pod group. When Priority Admission Controller is enabled, it prevents users from setting this field. The admission controller populates this field from PriorityClassName. The higher the value, the higher the priority. This field is immutable.
     */
    @JsonProperty("priority")
    public Integer getPriority() {
        return priority;
    }

    /**
     * priority is the value of priority of this composite pod group. Various system components use this field to find the priority of the composite pod group. When Priority Admission Controller is enabled, it prevents users from setting this field. The admission controller populates this field from PriorityClassName. The higher the value, the higher the priority. This field is immutable.
     */
    @JsonProperty("priority")
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * priorityClassName defines the priority that should be considered when scheduling this CompositePodGroup. Controllers are expected to fill this field by copying it from a CompositePodGroupTemplate. If left unspecified, it is validated and resolved similarly to the PriorityClassName field in Pods (i.e. if no priority class is specified, admission control can set this to the global default priority class if it exists. Otherwise, the composite pod group's priority will be zero). This field is immutable.
     */
    @JsonProperty("priorityClassName")
    public String getPriorityClassName() {
        return priorityClassName;
    }

    /**
     * priorityClassName defines the priority that should be considered when scheduling this CompositePodGroup. Controllers are expected to fill this field by copying it from a CompositePodGroupTemplate. If left unspecified, it is validated and resolved similarly to the PriorityClassName field in Pods (i.e. if no priority class is specified, admission control can set this to the global default priority class if it exists. Otherwise, the composite pod group's priority will be zero). This field is immutable.
     */
    @JsonProperty("priorityClassName")
    public void setPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
    }

    /**
     * CompositePodGroupSpec defines the desired state of CompositePodGroup.
     */
    @JsonProperty("schedulingConstraints")
    public CompositePodGroupSchedulingConstraints getSchedulingConstraints() {
        return schedulingConstraints;
    }

    /**
     * CompositePodGroupSpec defines the desired state of CompositePodGroup.
     */
    @JsonProperty("schedulingConstraints")
    public void setSchedulingConstraints(CompositePodGroupSchedulingConstraints schedulingConstraints) {
        this.schedulingConstraints = schedulingConstraints;
    }

    /**
     * CompositePodGroupSpec defines the desired state of CompositePodGroup.
     */
    @JsonProperty("schedulingPolicy")
    public CompositePodGroupSchedulingPolicy getSchedulingPolicy() {
        return schedulingPolicy;
    }

    /**
     * CompositePodGroupSpec defines the desired state of CompositePodGroup.
     */
    @JsonProperty("schedulingPolicy")
    public void setSchedulingPolicy(CompositePodGroupSchedulingPolicy schedulingPolicy) {
        this.schedulingPolicy = schedulingPolicy;
    }

    /**
     * CompositePodGroupSpec defines the desired state of CompositePodGroup.
     */
    @JsonProperty("workloadRef")
    public WorkloadReference getWorkloadRef() {
        return workloadRef;
    }

    /**
     * CompositePodGroupSpec defines the desired state of CompositePodGroup.
     */
    @JsonProperty("workloadRef")
    public void setWorkloadRef(WorkloadReference workloadRef) {
        this.workloadRef = workloadRef;
    }

    @JsonIgnore
    public CompositePodGroupSpecBuilder edit() {
        return new CompositePodGroupSpecBuilder(this);
    }

    @JsonIgnore
    public CompositePodGroupSpecBuilder toBuilder() {
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
        if (!(o instanceof CompositePodGroupSpec)) {
            return false;
        }
        CompositePodGroupSpec other = (CompositePodGroupSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$disruptionMode = this.getDisruptionMode();
        Object other$disruptionMode = other.getDisruptionMode();
        if (this$disruptionMode == null ? other$disruptionMode != null : !this$disruptionMode.equals(other$disruptionMode)) {
            return false;
        }
        Object this$parentCompositePodGroupName = this.getParentCompositePodGroupName();
        Object other$parentCompositePodGroupName = other.getParentCompositePodGroupName();
        if (this$parentCompositePodGroupName == null ? other$parentCompositePodGroupName != null : !this$parentCompositePodGroupName.equals(other$parentCompositePodGroupName)) {
            return false;
        }
        Object this$preemptionPolicy = this.getPreemptionPolicy();
        Object other$preemptionPolicy = other.getPreemptionPolicy();
        if (this$preemptionPolicy == null ? other$preemptionPolicy != null : !this$preemptionPolicy.equals(other$preemptionPolicy)) {
            return false;
        }
        Object this$priority = this.getPriority();
        Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) {
            return false;
        }
        Object this$priorityClassName = this.getPriorityClassName();
        Object other$priorityClassName = other.getPriorityClassName();
        if (this$priorityClassName == null ? other$priorityClassName != null : !this$priorityClassName.equals(other$priorityClassName)) {
            return false;
        }
        Object this$schedulingConstraints = this.getSchedulingConstraints();
        Object other$schedulingConstraints = other.getSchedulingConstraints();
        if (this$schedulingConstraints == null ? other$schedulingConstraints != null : !this$schedulingConstraints.equals(other$schedulingConstraints)) {
            return false;
        }
        Object this$schedulingPolicy = this.getSchedulingPolicy();
        Object other$schedulingPolicy = other.getSchedulingPolicy();
        if (this$schedulingPolicy == null ? other$schedulingPolicy != null : !this$schedulingPolicy.equals(other$schedulingPolicy)) {
            return false;
        }
        Object this$workloadRef = this.getWorkloadRef();
        Object other$workloadRef = other.getWorkloadRef();
        if (this$workloadRef == null ? other$workloadRef != null : !this$workloadRef.equals(other$workloadRef)) {
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
        return other instanceof CompositePodGroupSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $disruptionMode = this.getDisruptionMode();
        result = result * prime + ($disruptionMode == null ? 43 : $disruptionMode.hashCode());
        Object $parentCompositePodGroupName = this.getParentCompositePodGroupName();
        result = result * prime + ($parentCompositePodGroupName == null ? 43 : $parentCompositePodGroupName.hashCode());
        Object $preemptionPolicy = this.getPreemptionPolicy();
        result = result * prime + ($preemptionPolicy == null ? 43 : $preemptionPolicy.hashCode());
        Object $priority = this.getPriority();
        result = result * prime + ($priority == null ? 43 : $priority.hashCode());
        Object $priorityClassName = this.getPriorityClassName();
        result = result * prime + ($priorityClassName == null ? 43 : $priorityClassName.hashCode());
        Object $schedulingConstraints = this.getSchedulingConstraints();
        result = result * prime + ($schedulingConstraints == null ? 43 : $schedulingConstraints.hashCode());
        Object $schedulingPolicy = this.getSchedulingPolicy();
        result = result * prime + ($schedulingPolicy == null ? 43 : $schedulingPolicy.hashCode());
        Object $workloadRef = this.getWorkloadRef();
        result = result * prime + ($workloadRef == null ? 43 : $workloadRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CompositePodGroupSpec(" + "disruptionMode=" + this.getDisruptionMode() + ", parentCompositePodGroupName=" + this.getParentCompositePodGroupName() + ", preemptionPolicy=" + this.getPreemptionPolicy() + ", priority=" + this.getPriority() + ", priorityClassName=" + this.getPriorityClassName() + ", schedulingConstraints=" + this.getSchedulingConstraints() + ", schedulingPolicy=" + this.getSchedulingPolicy() + ", workloadRef=" + this.getWorkloadRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
