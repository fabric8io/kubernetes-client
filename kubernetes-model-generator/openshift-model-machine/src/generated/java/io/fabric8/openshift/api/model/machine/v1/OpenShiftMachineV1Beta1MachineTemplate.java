
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
