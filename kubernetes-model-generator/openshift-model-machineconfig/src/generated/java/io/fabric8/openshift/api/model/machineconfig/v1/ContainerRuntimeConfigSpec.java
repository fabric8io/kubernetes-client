
package io.fabric8.openshift.api.model.machineconfig.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "containerRuntimeConfig",
    "machineConfigPoolSelector"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ContainerRuntimeConfigSpec implements KubernetesResource
{

    @JsonProperty("containerRuntimeConfig")
    private ContainerRuntimeConfiguration containerRuntimeConfig;
    @JsonProperty("machineConfigPoolSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector machineConfigPoolSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ContainerRuntimeConfigSpec() {
    }

    public ContainerRuntimeConfigSpec(ContainerRuntimeConfiguration containerRuntimeConfig, io.fabric8.kubernetes.api.model.LabelSelector machineConfigPoolSelector) {
        super();
        this.containerRuntimeConfig = containerRuntimeConfig;
        this.machineConfigPoolSelector = machineConfigPoolSelector;
    }

    @JsonProperty("containerRuntimeConfig")
    public ContainerRuntimeConfiguration getContainerRuntimeConfig() {
        return containerRuntimeConfig;
    }

    @JsonProperty("containerRuntimeConfig")
    public void setContainerRuntimeConfig(ContainerRuntimeConfiguration containerRuntimeConfig) {
        this.containerRuntimeConfig = containerRuntimeConfig;
    }

    @JsonProperty("machineConfigPoolSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getMachineConfigPoolSelector() {
        return machineConfigPoolSelector;
    }

    @JsonProperty("machineConfigPoolSelector")
    public void setMachineConfigPoolSelector(io.fabric8.kubernetes.api.model.LabelSelector machineConfigPoolSelector) {
        this.machineConfigPoolSelector = machineConfigPoolSelector;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
