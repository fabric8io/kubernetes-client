
package io.fabric8.openshift.api.model.machine.v1beta1;

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
 * MachineHealthCheckStatus defines the observed state of MachineHealthCheck
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "currentHealthy",
    "expectedMachines",
    "remediationsAllowed"
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
public class MachineHealthCheckStatus implements Editable<MachineHealthCheckStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("currentHealthy")
    private Integer currentHealthy;
    @JsonProperty("expectedMachines")
    private Integer expectedMachines;
    @JsonProperty("remediationsAllowed")
    private Integer remediationsAllowed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MachineHealthCheckStatus() {
    }

    public MachineHealthCheckStatus(List<Condition> conditions, Integer currentHealthy, Integer expectedMachines, Integer remediationsAllowed) {
        super();
        this.conditions = conditions;
        this.currentHealthy = currentHealthy;
        this.expectedMachines = expectedMachines;
        this.remediationsAllowed = remediationsAllowed;
    }

    /**
     * Conditions defines the current state of the MachineHealthCheck
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * Conditions defines the current state of the MachineHealthCheck
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * total number of machines counted by this machine health check
     */
    @JsonProperty("currentHealthy")
    public Integer getCurrentHealthy() {
        return currentHealthy;
    }

    /**
     * total number of machines counted by this machine health check
     */
    @JsonProperty("currentHealthy")
    public void setCurrentHealthy(Integer currentHealthy) {
        this.currentHealthy = currentHealthy;
    }

    /**
     * total number of machines counted by this machine health check
     */
    @JsonProperty("expectedMachines")
    public Integer getExpectedMachines() {
        return expectedMachines;
    }

    /**
     * total number of machines counted by this machine health check
     */
    @JsonProperty("expectedMachines")
    public void setExpectedMachines(Integer expectedMachines) {
        this.expectedMachines = expectedMachines;
    }

    /**
     * RemediationsAllowed is the number of further remediations allowed by this machine health check before maxUnhealthy short circuiting will be applied
     */
    @JsonProperty("remediationsAllowed")
    public Integer getRemediationsAllowed() {
        return remediationsAllowed;
    }

    /**
     * RemediationsAllowed is the number of further remediations allowed by this machine health check before maxUnhealthy short circuiting will be applied
     */
    @JsonProperty("remediationsAllowed")
    public void setRemediationsAllowed(Integer remediationsAllowed) {
        this.remediationsAllowed = remediationsAllowed;
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
