
package io.fabric8.openshift.api.model.machine.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ControlPlaneMachineSetSpecTMachines_v1beta1_machine_openshift_io implements Editable<ControlPlaneMachineSetSpecTMachines_v1beta1_machine_openshift_ioBuilder> , KubernetesResource
{

    @JsonProperty("failureDomains")
    private ControlPlaneMachineSetSpecTMFailureDomains failureDomains;
    @JsonProperty("metadata")
    private ControlPlaneMachineSetSpecTMMetadata metadata;
    @JsonProperty("spec")
    private ControlPlaneMachineSetSpecTMSpec spec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ControlPlaneMachineSetSpecTMachines_v1beta1_machine_openshift_io() {
    }

    public ControlPlaneMachineSetSpecTMachines_v1beta1_machine_openshift_io(ControlPlaneMachineSetSpecTMFailureDomains failureDomains, ControlPlaneMachineSetSpecTMMetadata metadata, ControlPlaneMachineSetSpecTMSpec spec) {
        super();
        this.failureDomains = failureDomains;
        this.metadata = metadata;
        this.spec = spec;
    }

    @JsonProperty("failureDomains")
    public ControlPlaneMachineSetSpecTMFailureDomains getFailureDomains() {
        return failureDomains;
    }

    @JsonProperty("failureDomains")
    public void setFailureDomains(ControlPlaneMachineSetSpecTMFailureDomains failureDomains) {
        this.failureDomains = failureDomains;
    }

    @JsonProperty("metadata")
    public ControlPlaneMachineSetSpecTMMetadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(ControlPlaneMachineSetSpecTMMetadata metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("spec")
    public ControlPlaneMachineSetSpecTMSpec getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(ControlPlaneMachineSetSpecTMSpec spec) {
        this.spec = spec;
    }

    @JsonIgnore
    public ControlPlaneMachineSetSpecTMachines_v1beta1_machine_openshift_ioBuilder edit() {
        return new ControlPlaneMachineSetSpecTMachines_v1beta1_machine_openshift_ioBuilder(this);
    }

    @JsonIgnore
    public ControlPlaneMachineSetSpecTMachines_v1beta1_machine_openshift_ioBuilder toBuilder() {
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
