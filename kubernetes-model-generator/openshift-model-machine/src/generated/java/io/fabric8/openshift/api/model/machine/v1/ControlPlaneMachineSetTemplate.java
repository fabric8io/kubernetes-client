
package io.fabric8.openshift.api.model.machine.v1;

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
 * ControlPlaneMachineSetTemplate is a template used by the ControlPlaneMachineSet to create the Machines that it will manage in the future.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "machineType",
    "machines_v1beta1_machine_openshift_io"
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
public class ControlPlaneMachineSetTemplate implements Editable<ControlPlaneMachineSetTemplateBuilder>, KubernetesResource
{

    @JsonProperty("machineType")
    private String machineType;
    @JsonProperty("machines_v1beta1_machine_openshift_io")
    private OpenShiftMachineV1Beta1MachineTemplate machinesV1beta1MachineOpenshiftIo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ControlPlaneMachineSetTemplate() {
    }

    public ControlPlaneMachineSetTemplate(String machineType, OpenShiftMachineV1Beta1MachineTemplate machinesV1beta1MachineOpenshiftIo) {
        super();
        this.machineType = machineType;
        this.machinesV1beta1MachineOpenshiftIo = machinesV1beta1MachineOpenshiftIo;
    }

    /**
     * machineType determines the type of Machines that should be managed by the ControlPlaneMachineSet. Currently, the only valid value is machines_v1beta1_machine_openshift_io.
     */
    @JsonProperty("machineType")
    public String getMachineType() {
        return machineType;
    }

    /**
     * machineType determines the type of Machines that should be managed by the ControlPlaneMachineSet. Currently, the only valid value is machines_v1beta1_machine_openshift_io.
     */
    @JsonProperty("machineType")
    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    /**
     * ControlPlaneMachineSetTemplate is a template used by the ControlPlaneMachineSet to create the Machines that it will manage in the future.
     */
    @JsonProperty("machines_v1beta1_machine_openshift_io")
    public OpenShiftMachineV1Beta1MachineTemplate getMachinesV1beta1MachineOpenshiftIo() {
        return machinesV1beta1MachineOpenshiftIo;
    }

    /**
     * ControlPlaneMachineSetTemplate is a template used by the ControlPlaneMachineSet to create the Machines that it will manage in the future.
     */
    @JsonProperty("machines_v1beta1_machine_openshift_io")
    public void setMachinesV1beta1MachineOpenshiftIo(OpenShiftMachineV1Beta1MachineTemplate machinesV1beta1MachineOpenshiftIo) {
        this.machinesV1beta1MachineOpenshiftIo = machinesV1beta1MachineOpenshiftIo;
    }

    @JsonIgnore
    public ControlPlaneMachineSetTemplateBuilder edit() {
        return new ControlPlaneMachineSetTemplateBuilder(this);
    }

    @JsonIgnore
    public ControlPlaneMachineSetTemplateBuilder toBuilder() {
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
        if (!(o instanceof ControlPlaneMachineSetTemplate)) {
            return false;
        }
        ControlPlaneMachineSetTemplate other = (ControlPlaneMachineSetTemplate) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$machineType = this.getMachineType();
        Object other$machineType = other.getMachineType();
        if (this$machineType == null ? other$machineType != null : !this$machineType.equals(other$machineType)) {
            return false;
        }
        Object this$machinesV1beta1MachineOpenshiftIo = this.getMachinesV1beta1MachineOpenshiftIo();
        Object other$machinesV1beta1MachineOpenshiftIo = other.getMachinesV1beta1MachineOpenshiftIo();
        if (this$machinesV1beta1MachineOpenshiftIo == null ? other$machinesV1beta1MachineOpenshiftIo != null : !this$machinesV1beta1MachineOpenshiftIo.equals(other$machinesV1beta1MachineOpenshiftIo)) {
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
        return other instanceof ControlPlaneMachineSetTemplate;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $machineType = this.getMachineType();
        result = result * prime + ($machineType == null ? 43 : $machineType.hashCode());
        Object $machinesV1beta1MachineOpenshiftIo = this.getMachinesV1beta1MachineOpenshiftIo();
        result = result * prime + ($machinesV1beta1MachineOpenshiftIo == null ? 43 : $machinesV1beta1MachineOpenshiftIo.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ControlPlaneMachineSetTemplate(" + "machineType=" + this.getMachineType() + ", machinesV1beta1MachineOpenshiftIo=" + this.getMachinesV1beta1MachineOpenshiftIo() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
