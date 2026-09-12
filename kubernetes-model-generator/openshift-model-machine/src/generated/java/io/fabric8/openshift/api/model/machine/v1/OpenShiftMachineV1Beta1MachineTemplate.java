
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
import io.fabric8.openshift.api.model.machine.v1beta1.MachineSpec;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * OpenShiftMachineV1Beta1MachineTemplate is a template for the ControlPlaneMachineSet to create Machines from the v1beta1.machine.openshift.io API group.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "failureDomains",
    "spec"
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
public class OpenShiftMachineV1Beta1MachineTemplate implements Editable<OpenShiftMachineV1Beta1MachineTemplateBuilder>, KubernetesResource
{

    @JsonProperty("failureDomains")
    private FailureDomains failureDomains;
    @JsonProperty("metadata")
    private ControlPlaneMachineSetTemplateObjectMeta metadata;
    @JsonProperty("spec")
    private MachineSpec spec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OpenShiftMachineV1Beta1MachineTemplate() {
    }

    public OpenShiftMachineV1Beta1MachineTemplate(FailureDomains failureDomains, ControlPlaneMachineSetTemplateObjectMeta metadata, MachineSpec spec) {
        super();
        this.failureDomains = failureDomains;
        this.metadata = metadata;
        this.spec = spec;
    }

    /**
     * OpenShiftMachineV1Beta1MachineTemplate is a template for the ControlPlaneMachineSet to create Machines from the v1beta1.machine.openshift.io API group.
     */
    @JsonProperty("failureDomains")
    public FailureDomains getFailureDomains() {
        return failureDomains;
    }

    /**
     * OpenShiftMachineV1Beta1MachineTemplate is a template for the ControlPlaneMachineSet to create Machines from the v1beta1.machine.openshift.io API group.
     */
    @JsonProperty("failureDomains")
    public void setFailureDomains(FailureDomains failureDomains) {
        this.failureDomains = failureDomains;
    }

    /**
     * OpenShiftMachineV1Beta1MachineTemplate is a template for the ControlPlaneMachineSet to create Machines from the v1beta1.machine.openshift.io API group.
     */
    @JsonProperty("metadata")
    public ControlPlaneMachineSetTemplateObjectMeta getMetadata() {
        return metadata;
    }

    /**
     * OpenShiftMachineV1Beta1MachineTemplate is a template for the ControlPlaneMachineSet to create Machines from the v1beta1.machine.openshift.io API group.
     */
    @JsonProperty("metadata")
    public void setMetadata(ControlPlaneMachineSetTemplateObjectMeta metadata) {
        this.metadata = metadata;
    }

    /**
     * OpenShiftMachineV1Beta1MachineTemplate is a template for the ControlPlaneMachineSet to create Machines from the v1beta1.machine.openshift.io API group.
     */
    @JsonProperty("spec")
    public MachineSpec getSpec() {
        return spec;
    }

    /**
     * OpenShiftMachineV1Beta1MachineTemplate is a template for the ControlPlaneMachineSet to create Machines from the v1beta1.machine.openshift.io API group.
     */
    @JsonProperty("spec")
    public void setSpec(MachineSpec spec) {
        this.spec = spec;
    }

    @JsonIgnore
    public OpenShiftMachineV1Beta1MachineTemplateBuilder edit() {
        return new OpenShiftMachineV1Beta1MachineTemplateBuilder(this);
    }

    @JsonIgnore
    public OpenShiftMachineV1Beta1MachineTemplateBuilder toBuilder() {
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
        if (!(o instanceof OpenShiftMachineV1Beta1MachineTemplate)) {
            return false;
        }
        OpenShiftMachineV1Beta1MachineTemplate other = (OpenShiftMachineV1Beta1MachineTemplate) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$failureDomains = this.getFailureDomains();
        Object other$failureDomains = other.getFailureDomains();
        if (this$failureDomains == null ? other$failureDomains != null : !this$failureDomains.equals(other$failureDomains)) {
            return false;
        }
        Object this$metadata = this.getMetadata();
        Object other$metadata = other.getMetadata();
        if (this$metadata == null ? other$metadata != null : !this$metadata.equals(other$metadata)) {
            return false;
        }
        Object this$spec = this.getSpec();
        Object other$spec = other.getSpec();
        if (this$spec == null ? other$spec != null : !this$spec.equals(other$spec)) {
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
        return other instanceof OpenShiftMachineV1Beta1MachineTemplate;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $failureDomains = this.getFailureDomains();
        result = result * prime + ($failureDomains == null ? 43 : $failureDomains.hashCode());
        Object $metadata = this.getMetadata();
        result = result * prime + ($metadata == null ? 43 : $metadata.hashCode());
        Object $spec = this.getSpec();
        result = result * prime + ($spec == null ? 43 : $spec.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OpenShiftMachineV1Beta1MachineTemplate(" + "failureDomains=" + this.getFailureDomains() + ", metadata=" + this.getMetadata() + ", spec=" + this.getSpec() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
