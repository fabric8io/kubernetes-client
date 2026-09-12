
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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

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
     * conditions defines the current state of the MachineHealthCheck
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions defines the current state of the MachineHealthCheck
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MachineHealthCheckStatus)) {
            return false;
        }
        MachineHealthCheckStatus other = (MachineHealthCheckStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$currentHealthy = this.getCurrentHealthy();
        Object other$currentHealthy = other.getCurrentHealthy();
        if (this$currentHealthy == null ? other$currentHealthy != null : !this$currentHealthy.equals(other$currentHealthy)) {
            return false;
        }
        Object this$expectedMachines = this.getExpectedMachines();
        Object other$expectedMachines = other.getExpectedMachines();
        if (this$expectedMachines == null ? other$expectedMachines != null : !this$expectedMachines.equals(other$expectedMachines)) {
            return false;
        }
        Object this$remediationsAllowed = this.getRemediationsAllowed();
        Object other$remediationsAllowed = other.getRemediationsAllowed();
        if (this$remediationsAllowed == null ? other$remediationsAllowed != null : !this$remediationsAllowed.equals(other$remediationsAllowed)) {
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
        return other instanceof MachineHealthCheckStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $currentHealthy = this.getCurrentHealthy();
        result = result * prime + ($currentHealthy == null ? 43 : $currentHealthy.hashCode());
        Object $expectedMachines = this.getExpectedMachines();
        result = result * prime + ($expectedMachines == null ? 43 : $expectedMachines.hashCode());
        Object $remediationsAllowed = this.getRemediationsAllowed();
        result = result * prime + ($remediationsAllowed == null ? 43 : $remediationsAllowed.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MachineHealthCheckStatus(" + "conditions=" + this.getConditions() + ", currentHealthy=" + this.getCurrentHealthy() + ", expectedMachines=" + this.getExpectedMachines() + ", remediationsAllowed=" + this.getRemediationsAllowed() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
