
package io.fabric8.openshift.api.model.machineconfiguration.v1alpha1;

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
    "buildInputs",
    "buildOutputs",
    "machineConfigPool"
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
public class MachineOSConfigSpec implements Editable<MachineOSConfigSpecBuilder> , KubernetesResource
{

    @JsonProperty("buildInputs")
    private BuildInputs buildInputs;
    @JsonProperty("buildOutputs")
    private BuildOutputs buildOutputs;
    @JsonProperty("machineConfigPool")
    private MachineConfigPoolReference machineConfigPool;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public MachineOSConfigSpec() {
    }

    public MachineOSConfigSpec(BuildInputs buildInputs, BuildOutputs buildOutputs, MachineConfigPoolReference machineConfigPool) {
        super();
        this.buildInputs = buildInputs;
        this.buildOutputs = buildOutputs;
        this.machineConfigPool = machineConfigPool;
    }

    @JsonProperty("buildInputs")
    public BuildInputs getBuildInputs() {
        return buildInputs;
    }

    @JsonProperty("buildInputs")
    public void setBuildInputs(BuildInputs buildInputs) {
        this.buildInputs = buildInputs;
    }

    @JsonProperty("buildOutputs")
    public BuildOutputs getBuildOutputs() {
        return buildOutputs;
    }

    @JsonProperty("buildOutputs")
    public void setBuildOutputs(BuildOutputs buildOutputs) {
        this.buildOutputs = buildOutputs;
    }

    @JsonProperty("machineConfigPool")
    public MachineConfigPoolReference getMachineConfigPool() {
        return machineConfigPool;
    }

    @JsonProperty("machineConfigPool")
    public void setMachineConfigPool(MachineConfigPoolReference machineConfigPool) {
        this.machineConfigPool = machineConfigPool;
    }

    @JsonIgnore
    public MachineOSConfigSpecBuilder edit() {
        return new MachineOSConfigSpecBuilder(this);
    }

    @JsonIgnore
    public MachineOSConfigSpecBuilder toBuilder() {
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