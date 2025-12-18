
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

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
 * MachineHealthCheckStatus defines the observed state of MachineHealthCheck.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "currentHealthy",
    "expectedMachines",
    "observedGeneration",
    "remediationsAllowed",
    "targets",
    "v1beta2"
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
public class MachineHealthCheckStatus implements Editable<MachineHealthCheckStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("currentHealthy")
    private Integer currentHealthy;
    @JsonProperty("expectedMachines")
    private Integer expectedMachines;
    @JsonProperty("observedGeneration")
    private Long observedGeneration;
    @JsonProperty("remediationsAllowed")
    private Integer remediationsAllowed;
    @JsonProperty("targets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> targets = new ArrayList<>();
    @JsonProperty("v1beta2")
    private MachineHealthCheckV1Beta2Status v1beta2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineHealthCheckStatus() {
    }

    public MachineHealthCheckStatus(List<Condition> conditions, Integer currentHealthy, Integer expectedMachines, Long observedGeneration, Integer remediationsAllowed, List<String> targets, MachineHealthCheckV1Beta2Status v1beta2) {
        super();
        this.conditions = conditions;
        this.currentHealthy = currentHealthy;
        this.expectedMachines = expectedMachines;
        this.observedGeneration = observedGeneration;
        this.remediationsAllowed = remediationsAllowed;
        this.targets = targets;
        this.v1beta2 = v1beta2;
    }

    /**
     * conditions defines current service state of the MachineHealthCheck.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions defines current service state of the MachineHealthCheck.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * currentHealthy is the total number of healthy machines counted by this machine health check
     */
    @JsonProperty("currentHealthy")
    public Integer getCurrentHealthy() {
        return currentHealthy;
    }

    /**
     * currentHealthy is the total number of healthy machines counted by this machine health check
     */
    @JsonProperty("currentHealthy")
    public void setCurrentHealthy(Integer currentHealthy) {
        this.currentHealthy = currentHealthy;
    }

    /**
     * expectedMachines is the total number of machines counted by this machine health check
     */
    @JsonProperty("expectedMachines")
    public Integer getExpectedMachines() {
        return expectedMachines;
    }

    /**
     * expectedMachines is the total number of machines counted by this machine health check
     */
    @JsonProperty("expectedMachines")
    public void setExpectedMachines(Integer expectedMachines) {
        this.expectedMachines = expectedMachines;
    }

    /**
     * observedGeneration is the latest generation observed by the controller.
     */
    @JsonProperty("observedGeneration")
    public Long getObservedGeneration() {
        return observedGeneration;
    }

    /**
     * observedGeneration is the latest generation observed by the controller.
     */
    @JsonProperty("observedGeneration")
    public void setObservedGeneration(Long observedGeneration) {
        this.observedGeneration = observedGeneration;
    }

    /**
     * remediationsAllowed is the number of further remediations allowed by this machine health check before maxUnhealthy short circuiting will be applied
     */
    @JsonProperty("remediationsAllowed")
    public Integer getRemediationsAllowed() {
        return remediationsAllowed;
    }

    /**
     * remediationsAllowed is the number of further remediations allowed by this machine health check before maxUnhealthy short circuiting will be applied
     */
    @JsonProperty("remediationsAllowed")
    public void setRemediationsAllowed(Integer remediationsAllowed) {
        this.remediationsAllowed = remediationsAllowed;
    }

    /**
     * targets shows the current list of machines the machine health check is watching
     */
    @JsonProperty("targets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getTargets() {
        return targets;
    }

    /**
     * targets shows the current list of machines the machine health check is watching
     */
    @JsonProperty("targets")
    public void setTargets(List<String> targets) {
        this.targets = targets;
    }

    /**
     * MachineHealthCheckStatus defines the observed state of MachineHealthCheck.
     */
    @JsonProperty("v1beta2")
    public MachineHealthCheckV1Beta2Status getV1beta2() {
        return v1beta2;
    }

    /**
     * MachineHealthCheckStatus defines the observed state of MachineHealthCheck.
     */
    @JsonProperty("v1beta2")
    public void setV1beta2(MachineHealthCheckV1Beta2Status v1beta2) {
        this.v1beta2 = v1beta2;
    }

    @JsonIgnore
    public MachineHealthCheckStatusBuilder edit() {
        return new MachineHealthCheckStatusBuilder(this);
    }

    @JsonIgnore
    public MachineHealthCheckStatusBuilder toBuilder() {
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
